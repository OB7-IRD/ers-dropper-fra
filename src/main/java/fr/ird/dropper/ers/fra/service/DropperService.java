package fr.ird.dropper.ers.fra.service;

import fr.ird.common.DateTimeUtils;
import fr.ird.common.OTUtils;
import fr.ird.common.log.LogService;
import fr.ird.driver.eva.business.ActivityDepartureToPort;
import fr.ird.driver.eva.business.ActivityReturnToPort;
import fr.ird.driver.eva.business.Capture;
import fr.ird.driver.eva.business.Discard;
import fr.ird.driver.eva.business.EndOFishing;
import fr.ird.driver.eva.business.FADActivity;
import fr.ird.driver.eva.business.Fad;
import fr.ird.driver.eva.business.FishingActivity;
import fr.ird.driver.eva.business.FishingContext;
import fr.ird.driver.eva.business.FishingEvent;
import fr.ird.driver.eva.business.Gear;
import fr.ird.driver.eva.business.GearActivity;
import fr.ird.driver.eva.business.Landing;
import fr.ird.driver.eva.business.Position;
import fr.ird.driver.eva.business.Specie;
import fr.ird.driver.eva.business.Trip;
import fr.ird.driver.eva.dao.ActivityDepartureToPortDAO;
import fr.ird.driver.eva.dao.ActivityReturnToPortDAO;
import fr.ird.driver.eva.dao.FADActivityDAO;
import fr.ird.driver.eva.dao.FishingActivityDAO;
import fr.ird.driver.eva.dao.HarbourDAO;
import fr.ird.driver.eva.dao.TripDAO;
import fr.ird.driver.eva.dao.VesselDAO;
import fr.ird.dropper.ers.fra.business.Dep;
import fr.ird.dropper.ers.fra.business.Dis;
import fr.ird.dropper.ers.fra.business.Eof;
import fr.ird.dropper.ers.fra.business.Ers;
import fr.ird.dropper.ers.fra.business.*;
import fr.ird.dropper.ers.fra.business.EvenementDePeche;
import fr.ird.dropper.ers.fra.business.Far;
import fr.ird.dropper.ers.fra.business.Gea;
import fr.ird.dropper.ers.fra.business.Log;
import fr.ird.dropper.ers.fra.business.Ops;
import fr.ird.dropper.ers.fra.business.Pos;
import fr.ird.dropper.ers.fra.business.Ret;
import fr.ird.dropper.ers.fra.business.Rtp;
import fr.ird.dropper.ers.fra.business.Spe;
import fr.ird.dropper.ers.fra.common.ErsUtils;
import fr.ird.dropper.ers.fra.config.ERSDropperProperties;
import fr.ird.dropper.ers.fra.exception.DropperException;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.joda.time.DateTime;

/**
 * Service permettant d'injecter des fichiers en base de données.
 *
 *
 */
public class DropperService extends ErsMainService {

    private static final DropperService SERVICE = new DropperService();

    private static int exitCode = 0;
    private TripDAO tripDAO;
    private boolean DEBUG = true;

    private static Long currentFileId = null;

    private static Long currentXMLFileId = null;

    private static Ops receivedOps = null;

    public static DropperService getService() {
        return DropperService.SERVICE;
    }

    /**
     * Constructeur privé car InjecteurService est un singleton.
     */
    private DropperService() {
    }

    public static void main(String[] args) {
        // cca 6/9/2010 : ajout des codes retours pour prise en compte dans le
        // shell unix
        DropperService dropperService = DropperService.getService();
        try {
            dropperService.init();
            dropperService.traiteFichiers();

        } catch (IOException e) {
            LogService.getService(DropperService.class).logFilePropertiesNotFound();
            System.exit(2);
        } catch (Exception e) {
            LogService.getService(DropperService.class).logApplicationError(e.getMessage());
            System.exit(1);
        }
        System.exit(exitCode);
    }

    private void traiteFichiers() throws Exception {
        integreFichiersDeRepertoire(ERSDropperProperties.MESSAGE_DIRECTORY);
    }

    /**
     * Intégre les fichiers du repertoire en controlant l'extension
     *
     * @param repDepot
     * @param messageFormat
     */
    private void integreFichiersDeRepertoire(String repDepot) {
        LogService.getService(DropperService.class)
                .logApplicationDebug("integreFichiersDeRepertoire " + repDepot);
        File repertoireDepot = new File(repDepot);
        // Récupération des fichiers à traiter
        // cca 25/4/13 : recupere uniquement les fichiers d'extension xml
        FileFilter xmlFilesFilter = (File f) -> {
            if (f.isDirectory()) {
                return true;
            } else if (f.getName().toLowerCase().endsWith(".xml")) {
                return true;
            } else {
                return false;
            }
        };
        File[] fichiers = repertoireDepot.listFiles(xmlFilesFilter);
        LogService.getService(DropperService.class)
                .logApplicationDebug("Nombre de fichiers " + fichiers.length);

        // Controle que la recherche des fichiers a pu etre realisee
        if (fichiers == null) {
            LogService.getService(DropperService.class)
                    .logApplicationError(repDepot + " Erreur de recherche des fichiers à intégrer. Vérifiez les fichiers de configuration.");
            exitCode = 4;
        } else if (fichiers.length > 0) {
            integreFichiers(fichiers);
        }

    }

    /**
     * Intégre les fichiers en base de données
     *
     * @param fichiers
     * @param messageFormat
     */
    private void integreFichiers(File[] fichiers) {
        LogService.getService(DropperService.class)
                .logApplicationDebug("integreFichiers ");
        // Tri des fichiers du plus ancien au plus récent puis sur le nom de
        // fichier par ordre alphabétique
        Arrays.sort(fichiers, (File o1, File o2) -> {
            if (o1.lastModified() - o2.lastModified() == 0) {
                if (o1.getName().compareTo(o2.getName()) > 0) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (o1.lastModified() - o2.lastModified() > 0) {
                return 1;
            } else {
                return -1;
            }
        });

        Trip trip;

        LogService.getService(DropperService.class)
                .logApplicationDebug("integreFichiers - sortFilesOldestToNewest ");
        sortFilesOldestToNewest(fichiers);
        LogService.getService(DropperService.class)
                .logApplicationDebug("integreFichiers - parcours des fichiers ");
        // Parcours du répertoire de dépôt
        for (final File fichier : fichiers) {
            Ops opsForException = null;
            try {
                LogService.getService(DropperService.class)
                        .logApplicationDebug("##################################################################");
                LogService.getService(DropperService.class)
                        .logApplicationDebug("integreFichiers - getName  " + fichier.getName());
                setReceivedOps(null);
                if (fichier.isDirectory() == false) {
                    LogService.getService(DropperService.class)
                            .logApplicationDebug("integreFichiers - notDirectory");

                    // MSGR02
                    // On vérifie que le fichier est conforme aux XSD
//                    LogService.getService(DropperService.class)
//                            .logApplicationDebug("integreFichiers - OpsFrenchFileValidator");
//                    OpsFrenchFileValidator validator = new OpsFrenchFileValidator(fichier);
//                    LogService.getService(DropperService.class)
//                            .logApplicationDebug("integreFichiers - validator.validate");
//                    OpsFileValidatorReport report = validator.validate(ERSDropperProperties.FORMAT_XML);
                    // Non conformité
//                    if (!report.isEmpty()) {
//
//                        LogService.getService(DropperService.class)
//                                .logApplicationError("Le fichier est non conforme avec le schéma XSD.");
//                        exitCode = 4;
//                        moveFileToErrorDirectory(receivedOps, fichier);
//                        continue;
//                    } // Conformité
//                    else {
                    LogService.getService(DropperService.class)
                            .logApplicationDebug("integreFichiers - #### conformité avec XSD ");
                    List<Ret> rets = new ArrayList<Ret>();
                    LogService.getService(DropperService.class)
                            .logApplicationDebug("integreFichiers - parsing du fichier - " + fichier.getPath());
//                        final Ops ops = XmlReader.parse(fichier.getPath());

                    final Ops ops = unmarshal(fichier);

                    opsForException = ops;
                    LogService.getService(DropperService.class)
                            .logApplicationDebug("integreFichiers - ops " + ops);

//                        ops.setOpsVersionErsLb("V3");
                    if (ops == null) {
                        // La transformation du flux XML en Ops a échoué
                        LogService.getService(DropperService.class)
                                .logApplicationError(
                                        "L'objet OPS n'a pas été créé. Vérifiez le mapping.");
                        exitCode = 4;
                        // On laisse le fichier pour qu'il soit traité
                        // de nouveau
                        moveFileToErrorDirectory(ops, fichier);
                        continue;
                    }
                    LogService.getService(DropperService.class)
                            .logApplicationDebug("integreFichiers - setReceivedOps " + ops);
                    setReceivedOps(ops);

                    trip = factory(ops);

                    if (trip != null) {
                        Trip t = tripDAO.save(trip);
                        if (t == null) {
                            exitCode = 4;
                            // On laisse le fichier pour qu'il soit traité
                            // de nouveau
                            LogService.getService(DropperService.class)
                                    .logApplicationError(
                                            "L'objet Trip n'a pas pu être sauvegardé en base.");
                            moveFileToErrorDirectory(ops, fichier);
                        } else {
                            moveFileToTreatedDirectory(ops, fichier);
                        }
                    }

//                        if (ops.getEmav() != null) {
//                            LogService.getService(DropperService.class)
//                                    .logApplicationDebug("integreFichiers - ops.getEmav() != null");
//                            EmavDAO emavdao = new EmavDAO();
//                            ops.getEmav().setOperateur(emavdao.findOperateurByIr(ops.getEmav().getEmavIrLb()));
//                        } else {
//                            OperateurDAO dao = new OperateurDAO();
//                            ops.setOperateur(dao.findByOperatorCode(ops.getOpsFrLb()));
//                        }
//                        LogService.getService(DropperService.class)
//                                .logApplicationDebug("integreFichiers - validate - rets");
//                        rets = OpsValidationService.getService().validate(ops, fichier);
//
//                        if (ops.getDAT() != null) {
//                            LogService.getService(DropperService.class)
//                                    .logApplicationDebug(
//                                            "RN = "
//                                            + ops.getDAT().getERS()
//                                                    .getRN());
//                        }
                    // cca 21/12/2010 : correction controle de RET non
                    // pris en compte
                    // Si les contrôles de validité du message reçu
                    // montrent que le message n'est pas valide, on ne
                    // l'insère pas en base, on déplace le fichier dans
                    // le répertoire des messages traités, et on passe
                    // au message suivant
//                        if (containsErrorsOrTransfertAcquittement(rets)) {
//                            // MSGR04 et RET04 :génération accusé de traitement sauf
//                            // si on a reçu 1 RET ou 1 RSP
//                            //Desactivé dans le module IRD
////                            if (ops.getRet() == null
////                                    && ops.getRsp() == null) {
////                                generationService.acknoledge(ops, rets, properties, fichier);
////                            }
//
//                            // Messages d'erreur donc ops non enregistré en
//                            // base => ops =null
//                            moveFileToTreatedDirectory(null, fichier);
//
//                            continue;
//                        }
//                    }
                }
            } catch (Exception e) {

//                moveFileToErrors(e, opsForException, fichier, journalService);
                moveFileToErrorDirectory(receivedOps, fichier);
                LogService.getService(DropperService.class)
                        .logApplicationError(
                                "Une exception a été levée pendant le traitement du fichier ="
                                + fichier.getName() + "\n" + e);
                exitCode = 4;
                break;
            }
        }
    }

    /**
     * Call thetr stored procudure and the message transfert module
     *
     * @param opsAccuseTraitementTrans
     * @param ops
     * @param fichier
     * @param listSentOps
     * @return
     * @throws SQLException * private boolean callTransfertModule(Ops
     * opsAccuseTraitementTrans, Ops ops, File fichier, List<Ops> listSentOps)
     * throws SQLException{ boolean procedureOK = callStoredProcedure(ops);
     * if(opsAccuseTraitementTrans!=null){ procedureOK =
     * callStoredProcedure(opsAccuseTraitementTrans); } for(Ops opsSent :
     * listSentOps){ if(opsSent!=null){ procedureOK =
     * callStoredProcedure(opsSent); } } if(procedureOK){ Transaction
     * transaction = null; Session sessionProc = null; try{ Configuration cfg =
     * new Configuration(); cfg.configure();
     *
     * SessionFactory factory = cfg.buildSessionFactory(); sessionProc =
     * factory.openSession(); transaction = sessionProc.beginTransaction();
     * //Connection connection = sessionProc.connection();
     * callMessageTransferModule(fichier, ops); transaction.commit(); }finally{
     * sessionProc.flush(); sessionProc.close(); } } return procedureOK; }
     */
    /**
     * Module de transfert des messages ERS intégrés avec succès en base par le
     * module de traitement. Les messages à transférer sont identifiés par des
     * attributs spécifiques qui sont mis à jour lors de leur transfert, ou
     * lorsqu’il faut re-transférer les messages.
     *
     * @param fichier
     * @param ops
     *
     * private void callMessageTransferModule(File fichier, Ops ops){ try{
     * MessageTransferModule messageTransferModule = MessageTransferModule
     * .getService(); if(ops.getIdXmlf()!=null){
     * messageTransferModule.transfer(ops, (XmlFile)session.load(XmlFile.class,
     * ops.getIdXmlf())); } }catch(Exception ex){
     *
     * LogService.getService(this.getClass()).logApplicationError( "Une
     * exception a été levée pendant le traitement du fichier =" +
     * fichier.getName(), ex); }
     *
     * }
     */
    /**
     * Tri des fichiers du plus ancien au plus récent puis sur le nom de fichier
     * par ordre alphabétique
     *
     * @param fichiers
     */
    private void sortFilesOldestToNewest(File[] fichiers) {
        Arrays.sort(fichiers, (File o1, File o2) -> {
            if (o1.lastModified() - o2.lastModified() == 0) {
                if (o1.getName().compareTo(o2.getName()) > 0) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (o1.lastModified() - o2.lastModified() > 0) {
                return 1;
            } else {
                return -1;
            }
        });
    }

    /**
     * MAJ d'ERS à supprimer pour le DEL du Ops
     *
     * @param ops
     */
//    private void setErsForDel(Ops ops) {
//        if (ops.getDEL() != null) {
//            ErsDAO ersDao = new ErsDAO();
//            Ers ersDeleted = ersDao.findByFrenchRecordNumber(ops.getDEL().getRN());
//            ops.getDEL().setErs(ersDeleted);
//
//        }
//    }
    /**
     * Efectue le transfert du message si nécessaire.
     *
     * @param fichier fichier reçu
     * @param ops Ops contenu dans le fichier
     * @throws Exception en cas d'erreur
     */
//    private List<Ops> transfereMessage(File fichier, Ops ops) throws Exception {
//        List<Ops> listSentOps = new ArrayList<Ops>();
//        if (ops.getDAT() != null) {
//            // Transfert d'un XML contenant 1 DAT
//            DatTransfertRulesService datTransfertRulesService = new DatTransfertRulesService();
//            listSentOps.addAll(datTransfertRulesService.transfer(ops, fichier));
//        } else if (ops.getDEL() != null) {
//            // Transfert d'un XML contenant 1 DEL
//            DelTransfertRulesService delTransfertRulesService = new DelTransfertRulesService();
//            listSentOps.addAll(delTransfertRulesService.transfer(ops, fichier));
//        } else if (ops.getCOR() != null) {
//            // Transfert d'un XML contenant 1 COR
//            CorTransfertRulesService corTransfertRulesService = new CorTransfertRulesService();
//            listSentOps.addAll(corTransfertRulesService.transfer(ops, fichier));
//        } else if (ops.getRsp() != null) {
//            // Transfert d'un XML contenant 1 RSP
//            RspTransfertRulesService rspTransfertRulesService = new RspTransfertRulesService();
//            listSentOps.addAll(rspTransfertRulesService.transfer(ops, fichier));
//        } else if (ops.getRet() != null) {
//            // Transfert d'un XML contenant 1 RET
//            RetTransfertRulesService retTransfertRulesService = new RetTransfertRulesService();
//            listSentOps.addAll(retTransfertRulesService.transfer(ops, fichier));
//        }
//        return listSentOps;
//    }
    /**
     * Indique si une liste de Rets renvoyés par la procédure de validation
     * contient au moins un RET qui indique que la requête est au format V1;
     *
     * @param rets
     * @return
     */
    public static boolean containsQueryVersionUn(List<Ret> rets) {

        return false;
    }

    /**
     * Indique si une liste de Rets renvoyés par la procédure de validation
     * contient au moins une erreur ou un transfert d'acquittement;
     *
     * @param rets
     * @return
     */
//    public static boolean containsErrorsOrTransfertAcquittement(List<Ret> rets) {
//        if (rets == null || rets.isEmpty()) {
//            return false;
//        }
//
//        for (Ret ret : rets) {
//            if (ret.isTransfertAcquittement()
//                    || !"000".equals(ret.getRetRsLb())) {
//                return true;
//            }
//        }
//
//        return false;
//    }
    /**
     * Déplace le fichier dans le répertoire des fichiers traités.
     *
     * @param fichier le fichier
     * @param journalService le service permettant de tracer l'injection de
     * fichiers
     */
    private void moveFileToTreatedDirectory(File fichier) {
        // MSGR07 : on déplace le fichier et on insère une ligne dans le
        // journal
        File fichierTraite = new File(
                ERSDropperProperties.PROCESSED_DIRECTORY
                + "/" + fichier.getName());

        try {
            fichierTraite.delete();
            fichier.renameTo(fichierTraite);
            LogService.getService(this.getClass()).logApplicationInfo(
                    "Le fichier " + fichier.getAbsolutePath()
                    + " a pu être déplacé.\n");
        } catch (SecurityException e) {
            LogService.getService(this.getClass()).logApplicationError(
                    "Le fichier " + fichier.getAbsolutePath()
                    + " n'a pas pu être déplacé.\n" + e);
            exitCode = 4;
        } catch (NullPointerException e) {
            LogService.getService(this.getClass()).logApplicationError(
                    "Le fichier " + fichier.getAbsolutePath()
                    + " n'a pas pu être déplacé.\n" + e);
            exitCode = 4;
        }
    }

    /**
     * Déplace le fichier dans le répertoire des fichiers traités.
     *
     * @param ops l'opération
     * @param fichier le fichier
     * @param journalService le service permettant de tracer l'injection de
     * fichiers
     */
    private void moveFileToTreatedDirectory(Ops ops, File fichier) {
        // MSGR07 : on déplace le fichier et on insère une ligne dans le
        // journal
        File fichierTraite = new File(ERSDropperProperties.PROCESSED_DIRECTORY
                + "/" + fichier.getName());

        // cca 23/11/2010 : ajout de la référence à l'operation en base du
        // message traité pour les lignes de messages MSG04
        try {
            fichierTraite.delete();
            fichier.renameTo(fichierTraite);
        } catch (SecurityException e) {
            LogService.getService(this.getClass()).logApplicationError(
                    "Le fichier " + fichier.getAbsolutePath()
                    + " n'a pas pu être déplacé.\n" + e);
            exitCode = 4;
        } catch (NullPointerException e) {
            LogService.getService(this.getClass()).logApplicationError(
                    "Le fichier " + fichier.getAbsolutePath()
                    + " n'a pas pu être déplacé.\n" + e);
            exitCode = 4;
        } catch (Exception e) {
            LogService.getService(this.getClass()).logApplicationError(
                    "Le fichier message applicatif n'a pas pu être inséré en base de données.\n" + e);
            exitCode = 4;
        }
    }

    /**
     * @param receivedOps the receivedOps to set
     */
    public static void setReceivedOps(Ops receivedOps) {
        DropperService.receivedOps = receivedOps;
    }

    /**
     * @return the receivedOps
     */
    public static Ops getReceivedOps() {
        return receivedOps;
    }

    /**
     * Deplacer le fichier dans le repioire erreurs si besoin
     *
     * @param exception
     * @param opsForException
     * @param fichier
     * @param journalService
     */
//    private void moveFileToErrors(Exception exception, Ops opsForException,
//            final File fichier, JournalService journalService) {
//        if (exception instanceof ERSDriverException) {
//            ERSDriverException gex = (ERSDriverException) exception;
//            //date befoe 1753 exception
//            if ("JZ0SU".equalsIgnoreCase(gex.getSQLException().getSQLState())) {
//                ///todo move file
//                // Génération accusé de réception
//                try {
//                    String message = gex.getSQLException().getMessage();
//                    String[] messages = message.split(":");
//                    List<Ret> rets = validateMGEN05(journalService, opsForException, fichier, getDATe(messages[1]));
//                    //List<Ret> rets = validateMGEN05(journalService, opsForException, fichier, new Date());
//                    if (opsForException.getRet() == null
//                            && opsForException.getRsp() == null) {
//                        generationService.acknoledge(opsForException, rets,
//                                session, properties, fichier);
//                    }
//
//                    // Messages d'erreur donc ops non enregistré en
//                    // base => ops =null
//                    moveFileToTreatedDirectory(null, fichier, journalService);
//                } catch (Exception ex) {
//                    //what to do in this case
//                   LogService.getService(this.getClass()).logApplicationError(
//                            "Le fichier " + fichier.getAbsolutePath()
//                            + " n'a pas pu être déplacé.", ex);
//                    exitCode = 4;
//                }
//            }
//        }
//        //duplicate key exception
//        if (exception instanceof ConstraintViolationException) {
//            moveFileToErrorDirectory(opsForException, fichier, journalService);
//        }
//        //Matcher exception
//        if (exception instanceof IllegalStateException) {
//            IllegalStateException iex = (IllegalStateException) exception;
//            if ("No match found".equalsIgnoreCase(exception.getMessage())) {
//                moveFileToErrorDirectory(opsForException, fichier, journalService);
//            }
//        }
//    }
    /**
     * Coppier le fichier dans les repitoires erreurs
     *
     * @param ops
     * @param fichier
     * @param journalService
     */
    private void moveFileToErrorDirectory(Ops ops, File fichier) {
        // MSGR07 : on déplace le fichier et on insère une ligne dans le
        // journal
        File fichierTraite = new File(ERSDropperProperties.ERROR_DIRECTORY
                + "/" + fichier.getName());

        // cca 23/11/2010 : ajout de la référence à l'operation en base du
        // message traité pour les lignes de messages MSG04
        try {
            fichierTraite.delete();
            if (!fichier.renameTo(fichierTraite)) {
                LogService.getService(this.getClass()).logApplicationError(
                        "Le fichier " + fichier.getAbsolutePath()
                        + " n'a pas pu être déplacé dans " + fichierTraite.getAbsolutePath());
                exitCode = 4;

            }
            /*if (ops != null) {
             journalService.insertMSG04(fichier);
             } else {
             journalService.insertMSG04(fichier);
             }*/
        } catch (SecurityException e) {
            LogService.getService(this.getClass()).logApplicationError(
                    "Le fichier " + fichier.getAbsolutePath()
                    + " n'a pas pu être déplacé." + e);
            exitCode = 4;
        } catch (NullPointerException e) {
            LogService.getService(this.getClass()).logApplicationError(
                    "Le fichier " + fichier.getAbsolutePath()
                    + " n'a pas pu être déplacé." + e);
            exitCode = 4;
        } catch (Exception e) {
            LogService.getService(this.getClass()).logApplicationError(
                    "Le fichier message applicatif n'a pas pu être inséré en base de données."
                    + e);
            exitCode = 4;
        }

    }

    /**
     *
     * @param ops
     * @return
     */
    private Trip factory(Ops ops) throws DropperException {
        Trip trip = null;
        tripDAO = new TripDAO();
        if (ops.getCOR() != null) {

            Ers ers = ops.getCOR().getERS();
            LogService.getService(this.getClass()).logApplicationDebug("Message de modification " + ops.getCOR().getRN());
            if (ers != null) {
                trip = factory(ers, ops.getCOR().getRN());
            } else {
                throw new DropperException("METTRE UN MESSAGE");
            }
        }
        if (ops.getDEL() != null) {
            String rnMessageERS = ops.getDEL().getRN();
            trip = delete(rnMessageERS);
        }

        if (ops.getDAT() != null
                && ops.getDAT().getERS() != null) {
            Ers ers = ops.getDAT().getERS();
            trip = factory(ers, null);
        }

        return trip;
    }

    private Trip factory(Ers ers, String rnMessageERSToCorrect) throws DropperException {
        Trip trip = null;
        String shortTripNumber = ErsUtils.getElogTn(ers);
        String longTripNumber = null;
        String vesselNumber = ErsUtils.getCfrRfaDuNavire(ers.getLOG());

        if (shortTripNumber != null) {
            longTripNumber = OTUtils.createLongTripNumber(vesselNumber, shortTripNumber);
        }

        Date dateMessageERS = DateTimeUtils.createDateTime(ers.getDaDt(), ers.getTiLb()).toDate();

        if (longTripNumber != null && vesselNumber != null) {
            LogService.getService(this.getClass()).logApplicationDebug("## " + vesselNumber + " - " + longTripNumber);
            LogService.getService(this.getClass()).logApplicationDebug("## " + ers.getLOG().getRTP());
            LogService.getService(this.getClass()).logApplicationDebug("## " + ers.getLOG().getRTP().size());
            Rtp rtp = null;
            if (ers.getLOG().getRTP() != null && !ers.getLOG().getRTP().isEmpty()) {
                rtp = ers.getLOG().getRTP().get(ers.getLOG().getRTP().size() - 1);
            }
            Dep dep = null;
            if (ers.getLOG().getDEP() != null && !ers.getLOG().getDEP().isEmpty()) {
                dep = ers.getLOG().getDEP().get(0);
            }
            trip = factory(vesselNumber, longTripNumber, ers.getLOG(), dep, rtp);

            if (ers.getLOG().getEOF() != null) {
                LogService.getService(this.getClass()).logApplicationDebug("## " + trip);
                Eof eof = ers.getLOG().getEOF();
                if (trip != null && trip.getDateOfDep() == null) {
//                    exitCode = 3;
                    throw new DropperException("La fin de pêche n'est pas assiocée à une marée existante en base(Marée num: " + longTripNumber + ", Message num : " + ers.getRN() + ")");
                }
                EndOFishing endOFishing = new EndOFishing();
                endOFishing.setDateMessageERS(dateMessageERS);
                endOFishing.setDateEof(DateTimeUtils.createDateTime(eof.getDaDt(), eof.getTiLb()).toDate());
                endOFishing.setRnMessageERS(ers.getRN());
                endOFishing.setRnMessageERSToCorrect(rnMessageERSToCorrect);
                trip.setEof(endOFishing);
                return trip;
            }
            LogService.getService(this.getClass()).logApplicationDebug("Création du trip faite.");
            List<EvenementDePeche> edp = new ArrayList<>();
            LogService.getService(this.getClass()).logApplicationDebug("DEP " + ers.getLOG().getDEP());
            edp.addAll(ers.getLOG().getDEP());
            LogService.getService(this.getClass()).logApplicationDebug("FAR " + ers.getLOG().getFAR());
            edp.addAll(ers.getLOG().getFAR());
            LogService.getService(this.getClass()).logApplicationDebug("RTP " + ers.getLOG().getRTP());
            edp.addAll(ers.getLOG().getRTP());

            Collections.sort(edp, (EvenementDePeche o1, EvenementDePeche o2) -> {
                if (o1.getDatiDt() == null || o2.getDatiDt() == null) {
                    return 0;
                }
                return o1.getDatiDt().compareTo(o2.getDatiDt());
            });

            LogService.getService(this.getClass()).logApplicationDebug("start of factoryFishingEvents ...");
            factoryFishingEvents(trip, edp, ers.getRN(), dateMessageERS, rnMessageERSToCorrect);
            LogService.getService(this.getClass()).logApplicationDebug("... end of factoryFishingEvents");

            trip.setLandings(factoryLandings(trip, ers.getLOG().getLAN()));
            trip.setDiscards(factoryDiscards(trip, ers.getLOG().getDIS()));
            LogService.getService(this.getClass()).logApplicationDebug("SAVE -> TRIP ");// + trip.toString());

        } else {
            throw new DropperException("Erreur dans les valeurs du numéro de marée (" + longTripNumber + ") ou de l'identifant du navire (" + vesselNumber + ").");
        }
        return trip;
    }

    private Trip delete(String rnMessageERS) {
        LogService.getService(this.getClass()).logApplicationDebug("Suppression du message " + rnMessageERS);
        Trip trip = tripDAO.findTripByRnMessageERS(rnMessageERS);
        if (trip != null) {
            for (Iterator<ActivityReturnToPort> iterator = trip.getActivityReturnToPorts().iterator(); iterator.hasNext();) {
                ActivityReturnToPort a = iterator.next();
                if (a.getRnMessageERS() == null ? rnMessageERS == null : a.getRnMessageERS().equals(rnMessageERS)) {
                    LogService.getService(this.getClass()).logApplicationDebug("Suppression de " + a);
                    iterator.remove();
                    new ActivityReturnToPortDAO().delete(a);
                }
            }
            for (Iterator<ActivityDepartureToPort> iterator = trip.getActivityDepartureToPorts().iterator(); iterator.hasNext();) {
                ActivityDepartureToPort a = iterator.next();
                if (a.getRnMessageERS() == null ? rnMessageERS == null : a.getRnMessageERS().equals(rnMessageERS)) {
                    LogService.getService(this.getClass()).logApplicationDebug("Suppression de " + a);
                    iterator.remove();
                    new ActivityDepartureToPortDAO().delete(a);
                }
            }
            for (Iterator<FADActivity> iterator = trip.getFadActivitys().iterator(); iterator.hasNext();) {
                FADActivity a = iterator.next();
                if (a.getRnMessageERS() == null ? rnMessageERS == null : a.getRnMessageERS().equals(rnMessageERS)) {
                    LogService.getService(this.getClass()).logApplicationDebug("Suppression de " + a);
                    iterator.remove();
                    new FADActivityDAO().delete(a);
                }
            }
            for (Iterator<FishingActivity> iterator = trip.getFishingActivitys().iterator(); iterator.hasNext();) {
                FishingActivity a = iterator.next();
                if (a.getRnMessageERS() == null ? rnMessageERS == null : a.getRnMessageERS().equals(rnMessageERS)) {
                    LogService.getService(this.getClass()).logApplicationDebug("Suppression de " + a);
                    iterator.remove();
                    new FishingActivityDAO().delete(a);
                }
            }
        }
        return trip;
    }

    /**
     * Construit une marée avec les éléments de bases: date de départ et de
     * retour...
     *
     * @param logbook un log ERS
     * @param departure un dep ERS
     * @param returnToPort un rtp ERS
     * @return the trip
     */
    private Trip factory(String vesselNumber, String longTripNumber, Log logbook, Dep departure, Rtp returnToPort) {
        LogService.getService(this.getClass()).logApplicationDebug("factory " + vesselNumber + " - " + longTripNumber);
        LogService.getService(this.getClass()).logApplicationDebug("Log " + logbook);
        LogService.getService(this.getClass()).logApplicationDebug("Dep " + departure);
        LogService.getService(this.getClass()).logApplicationDebug("rtp " + returnToPort);

        LogService.getService(this.getClass()).logApplicationDebug("1");
        Trip trip = tripDAO.findTripByLongTripNumber(longTripNumber);
        LogService.getService(this.getClass()).logApplicationDebug("Trip " + trip);
        Date dateOfRtp = null;
        Date dateOfDep = null;
        LogService.getService(this.getClass()).logApplicationDebug("2");
        if (trip == null) {
            LogService.getService(this.getClass()).logApplicationDebug("Trip " + trip);
            LogService.getService(this.getClass()).logApplicationDebug("Dep " + departure);
            if (departure != null) {
                dateOfDep = DateTimeUtils.createDateTime(departure.getDaDt(), departure.getTi()).toDate();
                LogService.getService(this.getClass()).logApplicationDebug("## " + dateOfDep);
            }
            trip = new Trip(dateOfDep);
            trip.setTripNumber(longTripNumber);
            trip.setVessel(new VesselDAO().findVessel(vesselNumber));
            LogService.getService(this.getClass()).logApplicationDebug("## " + trip);
            if (departure != null) {
                trip.setHabourOfDep(new HarbourDAO().findHarbour(departure.getPO()));
                LogService.getService(this.getClass()).logApplicationDebug("## " + trip);
            }
        } else {
            if (trip.getMasterName() == null) {
                trip.setMasterName(logbook.getMA());
            }
            if (trip.getMasterAdress() == null) {
                trip.setMasterAdress(logbook.getMD());
            }
        }
        LogService.getService(this.getClass()).logApplicationDebug("3");
        if (returnToPort != null) {
            dateOfRtp = DateTimeUtils.createDateTime(returnToPort.getDaDt(), returnToPort.getTiLb()).toDate();
            trip.setHabourOfRtp(new HarbourDAO().findHarbour(returnToPort.getPO()));
            trip.setDateOfRtp(dateOfRtp);
        }
        LogService.getService(this.getClass()).logApplicationDebug("4");
        if (departure != null && departure.getEdep() != null && returnToPort != null && returnToPort.getERTP() != null) {
            LogService.getService(DropperService.class).logApplicationDebug("###############");
            LogService.getService(DropperService.class).logApplicationDebug("T: " + trip);
            LogService.getService(DropperService.class).logApplicationDebug("RTP: " + returnToPort);
            LogService.getService(DropperService.class).logApplicationDebug("ERTP: " + returnToPort.getERTP());
            LogService.getService(DropperService.class).logApplicationDebug("ErtpNdNb: " + returnToPort.getERTP().getND());
            LogService.getService(DropperService.class).logApplicationDebug("D: " + departure);
            LogService.getService(DropperService.class).logApplicationDebug("EDEP: " + departure.getEdep());
            LogService.getService(DropperService.class).logApplicationDebug("EdepNdNb: " + departure.getEdep().getND());
            LogService.getService(DropperService.class).logApplicationDebug("###############");
            Double ertpNdNb = 0d;
            Double edepNdNb = 0d;
            if (departure.getEdep().getND() != null) {
                edepNdNb = departure.getEdep().getND();
            }
            if (returnToPort.getERTP().getND() != null) {
                ertpNdNb = returnToPort.getERTP().getND();
            }
            trip.setNauticalDistance((int) Math.round(ertpNdNb - edepNdNb));

        }
        LogService.getService(this.getClass()).logApplicationDebug("5");
        LogService.getService(DropperService.class).logApplicationDebug("--> " + trip);
        return trip;
    }

    /**
     * Create a Trip from the vessel cfr and the trip number. The trip number
     * format must be form to CFR code and 8 digit, ie FRA000911313-20130004.
     *
     * @param vesselCFR the CFR code
     * @param tripNumber the long format of trip number
     * @param complete true if the trip is created with all data
     * @return a trip
     * @throws DropperException
     */
//    private Trip factory(String vesselCFR, String tripNumber, boolean complete) throws DropperException {
//        LogService.getService(DropperService.class).logApplicationDebug("CFR: " + vesselCFR + ", TN: " + tripNumber);
//        Log log = (new LogDAO()).findFirstLogOfTrip(vesselCFR, tripNumber);
//        LogService.getService(DropperService.class).logApplicationDebug("LOG: " + log);
//        List<Dep> deps = (new DepDAO()).findDepsOfTrip(vesselCFR, tripNumber);
//        if (DEBUG) {
//            LogService.getService(DropperService.class).logApplicationDebug("DEPs " + deps.size() + " - " + deps);
//        }
//        List<Far> fars = (new FarDAO()).findUniqueFarsOfTripIncludindCor(vesselCFR, tripNumber);
//        if (DEBUG) {
//            LogService.getService(DropperService.class).logApplicationDebug("FARs " + fars.size() + " - " + fars);
//        }
//        List<Rtp> rtps = (new RtpDAO()).findRtpsOfTrip(vesselCFR, tripNumber);
//        if (DEBUG) {
//            LogService.getService(DropperService.class).logApplicationDebug("RTPs " + rtps.size() + " - " + rtps);
//        }
//        List<Eof> eofs = (new EofDAO()).findEofOfTrip(vesselCFR, tripNumber);
//        Eof endOfFishing = null;
//        if (DEBUG) {
//            LogService.getService(DropperService.class).logApplicationDebug("EOFs " + eofs.size() + " - " + eofs);
//        }
//        if (eofs.size() > 1) {
//            throw new DropperException("Il y a plusieurs messages de fin de pêche.");
//
//        } else if (!eofs.isEmpty()) {
//            endOfFishing = eofs.get(0);
//        }
//        List<Lan> landings = (new LanDAO()).findLansByTripNumber(vesselCFR, tripNumber);
//        if (DEBUG) {
//            LogService.getService(DropperService.class).logApplicationDebug("LANs " + landings.size() + " - " + landings);
//        }
//
//        List<Dis> discards = (new DisDAO()).findDiscardsOfTrip(vesselCFR, tripNumber);
//        if (DEBUG) {
//            LogService.getService(DropperService.class).logApplicationDebug("DISs " + discards.size() + " - " + discards);
//        }
//
//        return factory(log, deps, fars, rtps, endOfFishing, landings, discards, complete);
//    }
    /**
     * Construit une marée avec les éléments de bases: date de départ et de
     * retour...
     *
     * @param logbook un log ERS
     * @param departure un dep ERS
     * @param returnToPort un rtp ERS
     * @param isComplete true if the trip is created with all data
     * @return the trip
     */
//    private Trip factory(Log logbook, Dep departure, Rtp returnToPort, boolean isComplete) {
//
//        DateTime dateOfDep = DateTimeUtils.createDateTime(departure.getDEPDaDt(), departure.getDEPTiLb());
//        DateTime dateOfRtp = null;
//        if (returnToPort != null) {
//            dateOfRtp = DateTimeUtils.createDateTime(returnToPort.getRTPDaDt(), returnToPort.getTi());
//        }
//        LogService.getService(DropperService.class).logApplicationDebug("dateOfRtp + isComplete : " + dateOfRtp + " - " + isComplete);
//        Trip trip = new Trip(dateOfDep, dateOfRtp);
//
//        trip.setMasterName(logbook.getLOGMaLb());
//        trip.setMasterAdress(logbook.getLOGMdLb());
//        trip.setTripNumber(logbook.getElog().getElogTnLb());
//
//        trip.setVessel(factoryVessel(logbook));
//
//        trip.setPortOfDep(departure.getDEPPoLb());
//        if (returnToPort != null) {
//            trip.setPortOfRtp(returnToPort.getPO());
//        }
//
//        if (isComplete && departure.getEdep() != null && returnToPort != null && returnToPort.getERTP() != null) {
//            LogService.getService(DropperService.class).logApplicationDebug("###############");
//            LogService.getService(DropperService.class).logApplicationDebug("T: " + trip);
//            LogService.getService(DropperService.class).logApplicationDebug("RTP: " + returnToPort);
//            LogService.getService(DropperService.class).logApplicationDebug("ERTP: " + returnToPort.getERTP());
//            LogService.getService(DropperService.class).logApplicationDebug("ErtpNdNb: " + returnToPort.getERTP().getND());
//            LogService.getService(DropperService.class).logApplicationDebug("D: " + departure);
//            LogService.getService(DropperService.class).logApplicationDebug("EDEP: " + departure.getEdep());
//            LogService.getService(DropperService.class).logApplicationDebug("EdepNdNb: " + departure.getEdep().getND());
//            LogService.getService(DropperService.class).logApplicationDebug("###############");
//            Double ertpNdNb = 0d;
//            Double edepNdNb = 0d;
//            if (departure.getEdep().getND() != null) {
//                edepNdNb = departure.getEdep().getND();
//            }
//            if (returnToPort.getERTP().getND() != null) {
//                ertpNdNb = returnToPort.getERTP().getND();
//            }
//            trip.setNauticalDistance((int) Math.round(ertpNdNb - edepNdNb));
//
//        }
//        LogService.getService(DropperService.class).logApplicationDebug("--> " + trip);
//        return trip;
//    }
    /**
     * Créér les activités associées à une marée.
     *
     * @param trip la marée
     * @param evenementDePecheList liste evenement de pêche ERS
     * @param endOfFishing un message de fin de pêche
     * @return la liste des activités de pêche
     * @throws fr.ird.eva.core.exception.EVADriverException
     */
    private void factoryFishingEvents(Trip trip, List<EvenementDePeche> evenementDePecheList, String rnMessageERS, Date dateMessage, String rnMessageERSToCorrect) throws DropperException {
        LogService.getService(this.getClass()).logApplicationDebug("factoryFishingEvents");
//        List<FishingEvent> fishingEvents = new ArrayList<>();

//        int activityNumber = 1;
//        DateTime current = null;
//        HashSet<FishingEvent> fishingEventOfDay = new HashSet<>();
        for (EvenementDePeche evenementDePeche : evenementDePecheList) {
            LogService.getService(this.getClass()).logApplicationDebug("Evt Peche " + evenementDePeche + " " + evenementDePeche.getDatiDt() + " " + evenementDePeche.getTiLb());
            DateTime dateEventOfFishing = DateTimeUtils.createDateTime(evenementDePeche.getDatiDt(), evenementDePeche.getTiLb());
//
//            if (current != null && !DateTimeUtils.dateEqual(dateEventOfFishing, current)) {
//                fishingEvents.addAll(fishingEventOfDay);
//
//                //Initialisation pour une nouvelle itération
//                activityNumber = 1;
//                fishingEventOfDay = new HashSet<>();
//            }

            if (evenementDePeche instanceof Dep) {
                Dep dep = (Dep) evenementDePeche;
                FishingEvent fishingEvent = factoryActivityDepartureToPort(trip, dep, rnMessageERS, dateMessage, rnMessageERSToCorrect);

//                fishingEventOfDay.add(fishingEvent);
                if (dep.getTiLb() == null) {
                    LogService.getService(DropperService.class).logApplicationInfo("Pour l'activité suivante, le champs heure n'est pas renseigné " + fishingEvent.toString());
                }
//                current = DateTimeUtils.convertDate(dep.getDEPDaDt());
            } else if (evenementDePeche instanceof Rtp) {
                Rtp rtp = (Rtp) evenementDePeche;

                FishingEvent fishingEvent = factoryActivityReturnToPort(trip, rtp, rnMessageERS, dateMessage, rnMessageERSToCorrect);
//                activityNumber += 1;
//                fishingEventOfDay.add(fishingEvent);
                if (rtp.getTiLb() == null) {
                    LogService.getService(DropperService.class).logApplicationInfo("Pour l'activité suivante, le champs heure n'est pas renseigné " + fishingEvent.toString());
                }
//                current = DateTimeUtils.convertDate(rtp.getRTPDaDt());
            } else if (evenementDePeche instanceof Far) {
                Far far = (Far) evenementDePeche;
                HashSet<FishingEvent> fishingEventSet = new HashSet<>();
                if (far.getGEA() == null
                        && far.getEFAR() != null
                        && far.getEFAR().getEPFA() != null
                        && far.getEFAR().getEPFA().getEFAD() != null
                        && !far.getEFAR().getEPFA().getEFAD().isEmpty()) {
                    /**
                     * Traite les DCPs de l'activité
                     */
//                    if (DEBUG) {
                    LogService.getService(DropperService.class).logApplicationDebug("Traite les DCPs de l'activité " + far);
//                    }
                    fishingEventSet.addAll(factoryFADActivity(trip, far, rnMessageERS, dateMessage, rnMessageERSToCorrect));
//                    activityNumber += fishingEventSet.size();
                } else {//if (far.getGEA() != null || (far.getRAS() != null && far.getGEA() == null && far.getGls() == null)) {
                    /**
                     * Traite une calée, si il y a présence de DCP, elle sera
                     * traitée de manière interne.
                     */
                    if (DEBUG) {
                        LogService.getService(DropperService.class).logApplicationDebug("Traite les activités de calées avec DCP ou sans");
                    }
                    fishingEventSet.addAll(factoryFishingActivity(trip, far, rnMessageERS, dateMessage, rnMessageERSToCorrect));
//                    activityNumber += fishingEventSet.size();
                }
//                else {
//                    LogService.getService(DropperService.class).logApplicationError("L'activité n'a pas été traitée!!! FAR=" + far);
//                    throw new DropperException("L'activité n'a pas été traitée!!! FAR =" + far);
//                }
//                fishingEventOfDay.addAll(fishingEventSet);

                if (far.getTiLb() == null) {
                    LogService.getService(DropperService.class).logApplicationInfo("Pour l'activité suivante, le champs heure n'est pas renseigné " + fishingEventSet.toString());
                }
//                current = DateTimeUtils.convertDate(far.getFarDaDt());
            }
        }

//        if (fishingEventOfDay.size() > 0) {
//            fishingEvents.addAll(fishingEventOfDay);
//        }
//        if (DEBUG) {
//            LogService.getService(DropperService.class).logApplicationDebug("Le nombre d'activités trouvées, au sens AVDTH, est de " + fishingEvents.size());
//        }
//        return fishingEvents;
    }

    /**
     * Convertit une activité départ de port associées à une marée dans le
     * modèle EvA.
     *
     * @param trip la marée
     * @param dep le depart ERS
     * @param indexOfFishingEvent le numéro de l'activité
     * @return l'activité de depart au port
     * @throws fr.ird.eva.core.exception.EVADriverException
     */
    private ActivityDepartureToPort factoryActivityDepartureToPort(Trip trip, Dep dep, String rnMessageERS, Date dateMessage, String rnMessageERSToCorrect) throws DropperException {
        LogService.getService(DropperService.class).logApplicationDebug("factoryActivityDepartureToPort");
        ActivityDepartureToPort activityDepartureToPort = new ActivityDepartureToPort();
//        activityDepartureToPort.setIndexOfFishingEvent(indexOfFishingEvent);
        activityDepartureToPort.setDateOfFishingEvent(DateTimeUtils.createDateTime(dep.getDaDt(), dep.getTiLb()).toDate());

        LogService.getService(DropperService.class).logApplicationDebug("La date de l'activité est le " + activityDepartureToPort.getDateOfFishingEvent().toString());// +  " -- " + far.getFarDaDt() + " -- " + far.getFarDatiDt() + "--" + far.getFarTiLb());

        activityDepartureToPort.setPortOfDeparture(new HarbourDAO().findHarbour(dep.getPO()));
        LogService.getService(DropperService.class).logApplicationDebug("AA " + dep.getAA());
        activityDepartureToPort.setAnticipatedActivity(dep.getAA());

        LogService.getService(DropperService.class).logApplicationDebug("Gear...");
        for (Gea gea : dep.getGEA()) {
            LogService.getService(DropperService.class).logApplicationDebug("... " + gea);
            Gear gear = new Gear();
            gear.setType(gea.getGE());
            gear.setMeshSize(gea.getME());
            gear.setAverageHeightOfNets(gea.getGD());
            gear.setAverageLengthOfNets(gea.getGL());
            gear.setDimensions(gea.getGC());
            gear.setFishingDepths(gea.getFD());
            gear.setNumberOfFishingOperation(gea.getFO());
            gear.setQuantityOfGear(gea.getQG());
            gear.setTotalLengthOfGear(gea.getTL());

            if (!trip.hasGear(gear)) {
                trip.addGearOnBoard(gear);
            }

//            activityDepartureToPort.addGearOnBoard(gear);
        }

        LogService.getService(DropperService.class).logApplicationDebug("PartialLanding...");
        trip.setPartialLanding(!dep.getSPE().isEmpty());
        LogService.getService(DropperService.class).logApplicationDebug("Spe...");
        for (Spe spe : dep.getSPE()) {
            Specie specie = new Specie();
            LogService.getService(DropperService.class).logApplicationDebug("... " + spe);
            specie.setNameOfSpecies(spe.getSN());
            LogService.getService(DropperService.class).logApplicationDebug("... " + spe.getESPE());
            if (spe.getESPE() != null && spe.getESPE().getZO() != null) {
                specie.setSizeCategory(Integer.valueOf(spe.getESPE().getZO().value().substring(3, 5)));
            }
            specie.setNumberOfFishedToBeLanded(spe.getFL());
            specie.setNumberOfFished(spe.getNF());
            if (spe.getESPE() != null && spe.getESPE().getZO() != null) {
                specie.setSizeComposition(spe.getESPE().getZO().value());
            }
            specie.setGearType(spe.getGE());
            specie.setWeightOfFish(spe.getWT());
            specie.setNumberHeldInNets(spe.getNB());
            specie.setQuantityHeldInNets(spe.getNQ());
            specie.setMeansOfWeightMeasuring(spe.getMM());

            activityDepartureToPort.addSpecieOnBoard(specie);
        }
        LogService.getService(DropperService.class).logApplicationDebug("setRnMessageERS...");
        activityDepartureToPort.setRnMessageERS(rnMessageERS);
        LogService.getService(DropperService.class).logApplicationDebug("setDateMessageERS...");
        activityDepartureToPort.setDateMessageERS(dateMessage);
        if (rnMessageERSToCorrect != null) {
            activityDepartureToPort.setRnMessageERSToCorrect(rnMessageERSToCorrect);
            activityDepartureToPort.setCorMessageERS(true);
        }
        trip.addActivityDepartureToPort(activityDepartureToPort);
        return activityDepartureToPort;
    }
//

    /**
     * Convertit une activité retour au port associées à une marée dans le
     * modèle EvA.
     *
     * @param trip la marée
     * @param rtp le retour au port ERS
     * @param activityNumber le numéro de l'activité
     * @return l'activité de retour au port
     * @throws fr.ird.eva.core.exception.EVADriverException
     */
    private ActivityReturnToPort factoryActivityReturnToPort(Trip trip, Rtp rtp, String rnMessageERS, Date dateMessageERS, String rnMessageERSToCorrect) throws DropperException {
        LogService.getService(this.getClass()).logApplicationDebug("factoryActivityReturnToPort");
        ActivityReturnToPort activityReturnToPort = new ActivityReturnToPort();
        activityReturnToPort.setDateOfFishingEvent(DateTimeUtils.createDateTime(rtp.getDaDt(), rtp.getTI()).toDate());
        activityReturnToPort.setReasonOfReturn(rtp.getRE());

        LogService.getService(DropperService.class).logApplicationDebug(this.getClass().getName() + " " + rtp.getPO());

        activityReturnToPort.setPortOfReturn(new HarbourDAO().findHarbour(rtp.getPO()));
        LogService.getService(this.getClass()).logApplicationDebug("" + activityReturnToPort);
        for (Gea gea : rtp.getGEA()) {
            Gear gear = new Gear();
            gear.setType(gea.getGE());
            gear.setMeshSize(gea.getME());
            gear.setAverageHeightOfNets(gea.getGD());
            gear.setAverageLengthOfNets(gea.getGL());
            gear.setDimensions(gea.getGC());
            gear.setFishingDepths(gea.getFD());
            gear.setNumberOfFishingOperation(gea.getFO());
            gear.setQuantityOfGear(gea.getQG());
            gear.setTotalLengthOfGear(gea.getTL());
            if (!trip.hasGear(gear)) {
                trip.addGearOnBoard(gear);
            }
//            activityReturnToPort.addGearOnBoard(gear);
        }
        LogService.getService(this.getClass()).logApplicationDebug("------");

        activityReturnToPort.setRnMessageERS(rnMessageERS);
        activityReturnToPort.setDateMessageERS(dateMessageERS);
        if (rnMessageERSToCorrect != null) {
            activityReturnToPort.setRnMessageERSToCorrect(rnMessageERSToCorrect);
            activityReturnToPort.setCorMessageERS(true);
        }
        trip.addActivityReturnToPort(activityReturnToPort);
        return activityReturnToPort;
    }

    /**
     * Convertit une activité de pêche associées à une marée dans le modèle EvA.
     *
     * @param trip la marée
     * @param far le far ERS
     * @param activityNumber le numéro de l'activité
     * @return l'activité de pêche
     * @throws DropperException
     */
    private HashSet<FishingEvent> factoryFishingActivity(Trip trip, Far far, String rnMessageERS, Date dateMessage, String rnMessageERSToCorrect) throws DropperException {
        LogService.getService(this.getClass()).logApplicationDebug("factoryFishingActivity\n" + trip);
        HashSet<FishingEvent> fishingEvents = new HashSet<>();
        FishingActivity activity = new FishingActivity();
        activity.setDateOfFishingEvent(DateTimeUtils.createDateTime(far.getDaDt(), far.getTiLb()).toDate());
//        activity.setIndexOfFishingEvent(activityNumber);
        LogService.getService(DropperService.class).logApplicationDebug("Ceci est le FAR numéro " + far.toString());
        LogService.getService(DropperService.class).logApplicationDebug("La date de l'activité est le " + activity.getDateOfFishingEvent().toString());// +  " -- " + far.getFarDaDt() + " -- " + far.getFarDatiDt() + "--" + far.getFarTiLb());

        if (far.getPOS() != null) {
            activity.setPosition(new Position(far.getPOS().getLT(), far.getPOS().getLG()));
        }
        if (far.getEFAR() != null) {
            activity.setDaysFished(far.getEFAR().getDF());
        }

        if (far.getRAS() != null) {
            activity.setEconomicZone(far.getRAS().getEZ());
        }

        activity.setRnMessageERS(rnMessageERS);
        activity.setDateMessageERS(dateMessage);
        if (rnMessageERSToCorrect != null) {
            activity.setRnMessageERSToCorrect(rnMessageERSToCorrect);
            activity.setCorMessageERS(true);
        }

        Gea gea = far.getGEA();
        LogService.getService(this.getClass()).logApplicationDebug("GEA " + gea);
        if (gea != null) {
            Gear gear = new Gear();
            gear.setType(gea.getGE());
            gear.setMeshSize(gea.getME());
            gear.setAverageHeightOfNets(gea.getGD());
            gear.setAverageLengthOfNets(gea.getGL());
            gear.setDimensions(gea.getGC());
            gear.setFishingDepths(gea.getFD());
            gear.setNumberOfFishingOperation(gea.getFO());
            gear.setQuantityOfGear(gea.getQG());
            gear.setTotalLengthOfGear(gea.getTL());
            Gear gearInTrip = trip.isGearExist(gear);
            if (gearInTrip == null) {
                LogService.getService(this.getClass()).logApplicationDebug("No gear in trip");
                trip.addGearOnBoard(gear);
            } else {
                gear = gearInTrip;
            }
            activity.setGearUsed(gear);
            activity.setFishingTime(gea.getDU());

            if (gea.getGES() != null) {
                GearActivity ger = factoryGearShotActivity(gea.getGES());
//                ger.setRnMessageERS(rnMessageERS);
                activity.addGearActivity(ger);
                activity.setPosition(ger.getPosition());

            }
            if (gea.getGER() != null) {
                GearActivity ges = factoryGearRetrieveActivity(gea.getGER());
//                ges.setRnMessageERS(rnMessageERS);
                activity.addGearActivity(ges);
                activity.setPosition(ges.getPosition());
                if (ges.isSuccessfulCatch() != null) {
                    if (ges.isSuccessfulCatch()) {
                        activity.setOperation("COUP POSITIF");
                    } else {
                        activity.setOperation("COUP NEGATIF");
                    }
                } else {
                    activity.setOperation("COUP INCONNU");
                }

            } else {
                activity.setOperation("RECHERCHE");
            }
        }
        if (far.getEFAR() != null) {
            LogService.getService(DropperService.class).logApplicationDebug("far.getEFAR != null #1");
            //Primary fishing association
            if (far.getEFAR().getEPFA() != null) {
                activity.addFishingContext(
                        factoryPrimaryFishingContext(far.getEFAR().getEPFA()));
            }

            // le commentaire de Efad donne l'operation si coup inconnu
        }
        if (activity.getOperation() != null && activity.getOperation().equals("COUP INCONNU")) {
            LogService.getService(DropperService.class).logApplicationDebug("COUP INCONNU");
            if (far != null && far.getEFAR() != null && far.getEFAR().getEPFA() != null && far.getEFAR().getEPFA().getEFAD() != null) {
                if (!far.getEFAR().getEPFA().getEFAD().isEmpty()) {
                    activity.setOperation(far.getEFAR().getEPFA().getEFAD().get(0).getIF());
                }
                if (activity.getOperation().equals("")) {
                    activity.setOperation("COUP INCONNU");
                }
            }
        }
        if (far.getEFAR() != null) {
            LogService.getService(DropperService.class).logApplicationDebug("far.getEFAR() != null #2");
            // Additional subdeclaration under PS tropical tuna fishing
            Etts etts = far.getEFAR().getETTS();
            if (etts == null) {
                LogService.getService(DropperService.class).logApplicationInfo("Les informations additionnelles telles que la direction et la vitesse "
                        + "du vent ne sont pas renseignées.");
            } else {
                LogService.getService(DropperService.class).logApplicationDebug("ETTS non null");

                /**
                 * Élément lié au coup de pêche.
                 */
                activity.setHoldNumber(etts.getHN().toString());
                activity.setSeaState(etts.getSS().toString());
                activity.setSeaSurfaceTemperature(etts.getST());
                activity.setDegreeOfCurrent(etts.getCD().value());
                activity.setSpeedOfCurrent(etts.getSC());
                activity.setDegreeOfWind(etts.getCD().value());
                activity.setSpeedOfWind(etts.getWS());
                activity.setComment(etts.getCM());
                LogService.getService(DropperService.class).logApplicationDebug("--- 3");
                if (activity.getOperation() == null || activity.getOperation().equals("COUP INCONNU")) {
                    LogService.getService(DropperService.class).logApplicationDebug("--- 4");
                    if ("RECHERCHE".equals(activity.getComment())) {
                        activity.setOperation("RECHERCHE");
                    } else if (far.getEFAR() != null
                            && far.getEFAR().getEPFA() != null
                            && far.getEFAR().getEPFA().getEFAD() != null
                            && far.getEFAR().getEPFA().getEFAD().size() > 0) {
                        LogService.getService(DropperService.class).logApplicationDebug("--- 5");
                        activity.setOperation(far.getEFAR().getEPFA().getEFAD().get(0).getIF());
                    } else {
                        LogService.getService(DropperService.class).logApplicationDebug("--- 6");
                        activity.setOperation("RECHERCHE");
                    }
                }
                LogService.getService(DropperService.class).logApplicationDebug("--- 7");
                activity.setSchoolSizeInfomartion(etts.getSO());
                activity.setMiscProblems(etts.getMP().toString());
                if (etts.getFA() != null) {
                    LogService.getService(DropperService.class).logApplicationDebug("--- 8");
                    for (String fa : etts.getFA().value().split(" ")) {
                        FishingContext fc = factoryFishingContext(fa);
                        activity.addFishingContext(fc);
                    }
                }
            }
        }
        LogService.getService(DropperService.class).logApplicationDebug("--- 9");
        for (Spe spe : far.getSPE()) {
            Capture capture = factorySpeciesFished(activity, spe);
            LogService.getService(DropperService.class).logApplicationDebug("capture " + capture);
            LogService.getService(DropperService.class).logApplicationDebug("activity " + activity);
            activity.addElementaryCapture(capture);
            if (activity.getOperation() == null || "".equals(activity.getOperation()) || "RECHERCHE".equals(activity.getOperation())) {
                activity.setOperation("COUP POSITIF");
            }
        }
        LogService.getService(DropperService.class).logApplicationDebug("--- 10");
        trip.addFishingActivity(activity);
        fishingEvents.add(activity);

//        for (FADActivity fADActivity : factoryFADActivity(trip, activity, rnMessageERS, dateMessage, rnMessageERSToCorrect)) {
//            trip.addFADActivity(fADActivity);
//        }
        fishingEvents.addAll(factoryFADActivity(trip, activity, rnMessageERS, dateMessage, rnMessageERSToCorrect));

        return fishingEvents;
    }

    /**
     * Convertit les activités de DCP dans le modèle EvA. Fonction a revoir
     * selon les pratiques des pecheurs.
     *
     * @param fishingActivity une activitié de pêche
     * @param activityNumber le numéro de l'activité
     * @return la liste des activités de pêche
     * @throws DropperException
     */
    private HashSet<FADActivity> factoryFADActivity(Trip trip, FishingActivity fishingActivity, String rnMessageERS, Date dateMessage, String rnMessageERSToCorrect) throws DropperException {
        LogService.getService(DropperService.class).logApplicationDebug("factoryFADActivity");
        HashSet<FADActivity> fishingEvents = new HashSet<FADActivity>();
        if (fishingActivity == null) {
            return fishingEvents;
        }
        FADActivity activity;
        for (FishingContext fishingContext : fishingActivity.getFishingContexts()) {
            if (fishingContext != null) {

                for (Fad fad : fishingContext.getFads()) {

                    activity = new FADActivity();
//                    activity.setIndexOfFishingEvent(activityNumber);

                    //La liste de FAD associée au FC doit être toujours vide.
                    activity.addFishingContext(new FishingContext(true, fishingContext.getFishingContextType()));
                    activity.setDateOfFishingEvent(fishingActivity.getDateOfFishingEvent());

                    activity.setPosition(fishingActivity.getPosition());
                    activity.setEconomicZone(fishingActivity.getEconomicZone());
                    activity.setHoldNumber(fishingActivity.getHoldNumber());
                    activity.setSeaState(fishingActivity.getSeaState());
                    activity.setSeaSurfaceTemperature(fishingActivity.getSeaSurfaceTemperature());
                    activity.setDegreeOfCurrent(fishingActivity.getDegreeOfCurrent());
                    activity.setSpeedOfCurrent(fishingActivity.getSpeedOfCurrent());
                    activity.setDegreeOfWind(fishingActivity.getDegreeOfWind());
                    activity.setSpeedOfWind(fishingActivity.getSpeedOfWind());
                    activity.setSchoolSizeInfomartion(fishingActivity.getSchoolSizeInfomartion());
                    activity.setMiscProblems(fishingActivity.getMiscProblems());
                    activity.setComment(fishingActivity.getComment());

                    activity.setDateMessageERS(dateMessage);
                    activity.setRnMessageERS(rnMessageERS);
                    if (rnMessageERSToCorrect != null) {
                        activity.setCorMessageERS(true);
                        activity.setRnMessageERSToCorrect(rnMessageERSToCorrect);
                    }

                    //Gestion des FADs et des bouées associées
                    activity.setOperation(fad.getFadComment());
                    activity.setFad(fad);

                    if (!activity.getOperation().equals("")) {
                        trip.addFADActivity(activity);
                        fishingEvents.add(activity);
                    }
                }
            }
        }
        return fishingEvents;
    }

    /**
     * Convertit les activités de DCP dans le modèle EvA. Note: Fonction a
     * revoir selon les pratiques des pêcheurs.
     *
     * @param trip la marée
     * @param far le far ERS
     * @param activityNumber le numéro de l'activité
     * @return la liste des activités de pêche
     * @throws DropperException
     */
    private HashSet<FishingEvent> factoryFADActivity(Trip trip, Far far, String rnMessageERS, Date dateMessage, String rnMessageERSToCorrect) throws DropperException {
        LogService.getService(this.getClass()).logApplicationDebug("factoryFADActivity");
        HashSet<FishingEvent> fishingEvents = new HashSet<>();
        if (far == null) {
            return fishingEvents;
        }

        FADActivity activity;
        Far.EFAR.EPFA epfa = far.getEFAR().getEPFA();
        if (epfa == null) {
            return fishingEvents;
        }
        LogService.getService(DropperService.class).logApplicationDebug("EPFA " + epfa);
        FishingContext context = new FishingContext();
        context.setPrimary(true);
        context.setFishingContextType(epfa.getPF().value());
        LogService.getService(DropperService.class).logApplicationDebug("FC " + context);

        for (Far.EFAR.EPFA.EFAD efad : epfa.getEFAD()) {
            LogService.getService(DropperService.class).logApplicationDebug("EFAD " + efad);
            LogService.getService(DropperService.class).logApplicationDebug("rnMessageERS " + rnMessageERS);
            LogService.getService(DropperService.class).logApplicationDebug("dateMessage " + dateMessage);
            LogService.getService(DropperService.class).logApplicationDebug("rnMessageERSToCorrect " + rnMessageERSToCorrect);

            activity = new FADActivity();
            activity.setRnMessageERS(rnMessageERS);
            activity.setDateMessageERS(dateMessage);
            if (rnMessageERSToCorrect != null) {
                activity.setCorMessageERS(true);
                activity.setRnMessageERSToCorrect(rnMessageERSToCorrect);
            }

//            activity.setIndexOfFishingEvent(activityNumber);
            //La liste de FAD associé au FC doit être toujours vide.
            activity.addFishingContext(context);

            activity.setDateOfFishingEvent(DateTimeUtils.createDateTime(far.getDaDt(), far.getTiLb()).toDate());
            LogService.getService(DropperService.class).logApplicationDebug("Ceci est le FAR numéro " + far.toString());

            LogService.getService(DropperService.class).logApplicationDebug("La date de l'activité est le " + activity.getDateOfFishingEvent().toString());// +  " -- " + far.getFarDaDt() + " -- " + far.getFarDatiDt() + "--" + far.getFarTiLb());

            if (far.getPOS() != null) {
                activity.setPosition(new Position(far.getPOS().getLT(), far.getPOS().getLG()));
            }

            activity.setDaysFished(far.getEFAR().getDF());

            if (far.getRAS() != null) {
                activity.setEconomicZone(far.getRAS().getEZ());
            }

            // Additional subdeclaration under tropical tuna fishing
            Etts etts = far.getEFAR().getETTS();
            if (etts == null) {
                LogService.getService(DropperService.class).logApplicationInfo("Les informations additionnelles telles que la direction et la vitesse "
                        + "du vent ne sont pas renseignées.");
            } else {
                /**
                 * Élément lié au coup de pêche.
                 */
                activity.setHoldNumber(etts.getHN().toString());
                activity.setSeaState(etts.getSS().toString());
                activity.setSeaSurfaceTemperature(etts.getST());
                activity.setDegreeOfCurrent(etts.getCD().value());
                activity.setSpeedOfCurrent(etts.getSC());
                activity.setDegreeOfWind(etts.getWD().value());
                activity.setSpeedOfWind(etts.getWS());
                activity.setComment(etts.getCM());

                activity.setSchoolSizeInfomartion(etts.getSO());
                activity.setMiscProblems(etts.getMP().toString());

                //Gestion des FADs et des bouées associées
                activity.setOperation(efad.getIF());

                Fad fad = new Fad();
                fad.setHasBuoy(efad.getTP().equals("presence"));
                fad.setFadType(efad.getTF());
                fad.setFadComment(efad.getIF());
//                fad.setRnMessageERS(rnMessageERS);
                if (fad.isHasBuoy()) {
                    for (Etdd etdd : efad.getETDD()) {
                        fad.addBuoy(etdd.getGT(), etdd.getGI(), etdd.getGO());
                    }
                }
                activity.setFad(fad);

                if (etts.getFA() != null) {
                    for (String fa : etts.getFA().value().split(" ")) {
                        FishingContext fc = factoryFishingContext(fa);
//                        fc.setRnMessageERS(rnMessageERS);
                        activity.addFishingContext(fc);
                    }
                }
            }

            trip.addFADActivity(activity);
            fishingEvents.add(activity);
        }
        return fishingEvents;
    }

    /**
     * Convertit les captures associés à l'ERS dans le modèle EvA.
     *
     * @param fishingActivity l'activité de pêche associée à la capture ERS
     * @param specie l'espèce capturée ERS
     * @return la capture
     * @throws DropperException
     */
    private Capture factorySpeciesFished(FishingActivity fishingActivity, Spe spe) throws DropperException {
        LogService.getService(this.getClass()).logApplicationDebug("factorySpeciesFished");
        LogService.getService(this.getClass()).logApplicationDebug("fishingActivity " + fishingActivity);
        LogService.getService(this.getClass()).logApplicationDebug("Spe " + spe);
        Capture capture = new Capture();
        capture.setDate(fishingActivity.getDateOfFishingEvent());
        capture.setPosition(fishingActivity.getPosition());

        Specie specie = factorySpecie(spe);
        specie.setCapture(capture);
        capture.setSpecie(specie);
        return capture;
    }

    /**
     * Convertit les contextes de pêches associés à l'ERS dans le modèle EvA.
     *
     * @param epfa un contecte de pêche ERS
     * @return un contecte de pêche
     */
    private FishingContext factoryPrimaryFishingContext(Far.EFAR.EPFA epfa) {
        LogService.getService(this.getClass()).logApplicationDebug("factoryPrimaryFishingContext");
        LogService.getService(this.getClass()).logApplicationDebug("Epfa " + epfa);

        FishingContext context = new FishingContext();
        context.setPrimary(true);
        context.setFishingContextType(epfa.getPF().value());
        LogService.getService(this.getClass()).logApplicationDebug("context " + context);
        for (Far.EFAR.EPFA.EFAD efad : epfa.getEFAD()) {
            LogService.getService(this.getClass()).logApplicationDebug("Efad " + efad);
            Fad fad = new Fad();
            fad.setHasBuoy(efad.getTP().equals("presence"));
            fad.setFadType(efad.getTF());
            fad.setFadComment(efad.getIF());
            if (fad.isHasBuoy()) {
                for (Etdd etdd : efad.getETDD()) {
                    fad.addBuoy(etdd.getGT(), etdd.getGI(), etdd.getGO());
                }
            }
            context.addFad(fad);
        }
        return context;
    }

    /**
     * Convertit les contextes de pêches associés à l'ERS dans le modèle EvA.
     *
     * @param fa un contecte de pêche ERS
     * @return un contecte de pêche
     */
    private static FishingContext factoryFishingContext(String fa) {

        FishingContext context = new FishingContext();
        context.setPrimary(false);
        context.setFishingContextType(fa);
        return context;
    }

    /**
     * Convertit les engins de type "retrait" associés à l'ERS dans le modèle
     * EvA.
     *
     * @param ges une activité de mise à l'eau de l'engin ERS
     * @return une activité liée à l'engin
     */
    private static GearActivity factoryGearShotActivity(Ges ges) {
        if (ges == null) {
            return null;
        }
        GearActivity gearActivity = new GearActivity();
        gearActivity.setIsShot(true);
        gearActivity.setDate(DateTimeUtils.createDateTime(ges.getDaDt(), ges.getTiLb()).toDate());
        gearActivity.setPosition(new Position(ges.getPOS().getLT(), ges.getPOS().getLG()));
        gearActivity.setIdentifier(ges.getGS());

        return gearActivity;
    }

    /**
     * Convertit les engins de type "mise à l'eau" associés à l'ERS dans le
     * modèle EvA.
     *
     * @param ger une activité de retrait de l'engin ERS
     * @return une activité liée à l'engin
     */
    private static GearActivity factoryGearRetrieveActivity(Ger ger) {
        if (ger == null) {
            return null;
        }
        GearActivity gearActivity = new GearActivity();
        gearActivity.setIsShot(false);
        gearActivity.setDate(DateTimeUtils.createDateTime(ger.getDaDt(), ger.getTiLb()).toDate());
        gearActivity.setPosition(new Position(ger.getPOS().getLT(), ger.getPOS().getLG()));
        gearActivity.setIdentifier(ger.getGS());
        if (ger.getEGER() != null && ger.getEGER().getRF() != null) {
            gearActivity.setIsSuccessfulCatch(ger.getEGER().getRF().equals(GearActivity.SUCCESSFUL_FISHING_OPERATION));
        }
        return gearActivity;
    }

    /**
     * Convertit les débarquements associés à l'ERS dans le modèle EvA.
     *
     * @param trip la marée ERS
     * @param lans les débarquements ERS
     * @return les débarquements
     */
    private static ArrayList<Landing> factoryLandings(Trip trip, List<Lan> lans) {
        LogService.getService(DropperService.class).logApplicationDebug("factoryLandings" + lans);
        if (lans == null || lans.isEmpty()) {
            return null;
        }

        ArrayList<Landing> landings = new ArrayList<Landing>();
        for (Lan lan : lans) {
            Landing landing = new Landing();
            landing.setDate(DateTimeUtils.createDateTime(lan.getDaDt(), lan.getTiLb()).toDate());
            landing.setPortOfLanding(new HarbourDAO().findHarbour(lan.getPO()));
            landing.setSenderType(lan.getTS());

            ArrayList<Specie> species = new ArrayList<>();
            for (Spe spe : lan.getSPE()) {
                Specie specie = factorySpecie(spe);
                specie.setLanding(landing);
                species.add(specie);

            }
            landing.setSpecies(species);
            LogService.getService(DropperService.class).logApplicationInfo(landing.toString());
            landing.setTrip(trip);
            landings.add(landing);

        }
        return landings;
    }

    /**
     * Convertit les espèces associées à l'ERS dans le modèle EvA.
     *
     * @param specie la liste des espèces ERS
     * @return la liste des espèces
     */
    private static Specie factorySpecie(Spe specie) {
        LogService.getService(DropperService.class).logApplicationDebug("factorySpecie");
        LogService.getService(DropperService.class).logApplicationDebug("Spe " + specie);
        Specie s = new Specie();
        s.setGearType(specie.getGE());
        s.setMeansOfWeightMeasuring(specie.getMM());
        s.setNameOfSpecies(specie.getSN());
        s.setNumberHeldInNets(specie.getNB());
        s.setNumberOfFished(specie.getNF());
        s.setNumberOfFishedToBeLanded(specie.getFL());
        s.setQuantityHeldInNets(specie.getNQ());
        LogService.getService(DropperService.class).logApplicationDebug("Specie " + s);

        if (specie.getESPE() != null) {
            LogService.getService(DropperService.class).logApplicationDebug("ESPE " + specie.getESPE());
            LogService.getService(DropperService.class).logApplicationDebug("ZO " + specie.getESPE().getZO());
            if (specie.getESPE().getZO() != null) {
                s.setSizeCategory(Integer.valueOf(specie.getESPE().getZO().value().substring(3, 5)));
                s.setSizeComposition(specie.getESPE().getZO().value());
            }
        }
        s.setWeightOfFish(specie.getWT());
        return s;
    }

    /**
     * Convertit les rejets associés à l'ERS dans le modèle EvA.
     *
     * @param diss la liste des rejets ERS
     * @return la liste des rejets
     */
    private List<Discard> factoryDiscards(Trip trip, List<Dis> diss) {
        LogService.getService(DropperService.class).logApplicationDebug("factoryDiscards" + diss);
        if (diss == null || diss.isEmpty()) {
            return null;
        }

        ArrayList<Discard> discards = new ArrayList<Discard>();
        for (Dis dis : diss) {
            Discard discard = new Discard();
            discard.setDate(DateTimeUtils.createDateTime(dis.getDaDt(), dis.getTiLb()).toDate());
            Pos pos = dis.getPOS();
            if (pos != null) {
                discard.setPosition(new Position(dis.getPOS().getLT(), dis.getPOS().getLG()));
            }
            ArrayList<Specie> species = new ArrayList<Specie>();
            for (Spe spe : dis.getSPE()) {
                species.add(factorySpecie(spe));
            }
            discard.setSpecies(species);
            discard.setTrip(trip);
            discards.add(discard);
        }
        return discards;
    }

//    /**
//     * Creates only the trip object associated with the trip number. All related
//     * objects, like activity or landing, are not created.
//     *
//     * @param longTripNumber the trip number with the long format
//     * @return the trip or null
//     */
//    public Trip getTrip(String longTripNumber) {
//
//        if (OTUtils.validFormatLongTripNumber(longTripNumber)) {
//            String cfr = OTUtils.splitLongTripNumber(longTripNumber)[0];
//            try {
//                return factory(cfr, longTripNumber, false);
//            } catch (DropperException ex) {
//                LogService.getService(DropperService.class).logApplicationError(ex.getMessage());
//            }
//        }
//        return null;
//
//    }
//    /**
//     * Creates the trip object associated with the trip number. All related
//     * objects, like activity or landing, are created.
//     *
//     * @param longTripNumber the trip number with the long format
//     * @return the trip or null
//     */
//    public Trip getFullTrip(String longTripNumber) {
//
//        if (OTUtils.validFormatLongTripNumber(longTripNumber)) {
//            String cfr = OTUtils.splitLongTripNumber(longTripNumber)[0];
//            try {
//                return factory(cfr, longTripNumber, true);
//            } catch (DropperException ex) {
//                LogService.getService(DropperService.class).logApplicationError(ex.getMessage());
//            }
//        }
//        return null;
//
//    }
}
