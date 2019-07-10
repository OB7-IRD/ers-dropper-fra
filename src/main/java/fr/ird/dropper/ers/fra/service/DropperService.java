package fr.ird.dropper.ers.fra.service;

import fr.ird.common.log.LogService;
import fr.ird.driver.eva.dao.TripDAO;
import fr.ird.dropper.ers.fra.business.Dat;
import fr.ird.dropper.ers.fra.business.Ops;
import fr.ird.dropper.ers.fra.business.Ret;
import fr.ird.dropper.ers.fra.config.ERSDropperProperties;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                        .logApplicationDebug("integreFichiers - getName  " + fichier.getName());
                setReceivedOps(null);
                if (fichier.isDirectory() == false) {
                    LogService.getService(DropperService.class)
                            .logApplicationDebug("integreFichiers - notDirectory");

                    // MSGR02
                    // On vérifie que le fichier est conforme aux XSD
                    LogService.getService(DropperService.class)
                            .logApplicationDebug("integreFichiers - OpsFrenchFileValidator");
                    OpsFrenchFileValidator validator = new OpsFrenchFileValidator(fichier);
                    LogService.getService(DropperService.class)
                            .logApplicationDebug("integreFichiers - validator.validate");
                    OpsFileValidatorReport report = validator
                            .validate(ERSDropperProperties.FORMAT_XML);

                    // Non conformité
                    if (!report.isEmpty()) {

                        LogService.getService(DropperService.class)
                                .logApplicationError("Le fichier est non conforme avec le schéma XSD.");
                        exitCode = 4;
//                        moveFileToTreatedDirectory(fichier);
                        continue;
                    } // Conformité
                    else {
                        LogService.getService(DropperService.class)
                                .logApplicationDebug("integreFichiers - #### conformité avec XSD ");
                        List<Ret> rets = new ArrayList<Ret>();
                        LogService.getService(DropperService.class)
                                .logApplicationDebug("integreFichiers - parsing du fichier - " + fichier.getPath());
                        final Ops ops = XmlReader.parse(fichier.getPath());
                        opsForException = ops;
                        LogService.getService(DropperService.class)
                                .logApplicationDebug("integreFichiers - ops " + ops);

                        ops.setOpsVersionErsLb("V3");

                        LogService.getService(DropperService.class)
                                .logApplicationDebug("###################################################");

                        LogService.getService(DropperService.class)
                                .logApplicationDebug("DATS size " + ops.getDats().size());
                        for (Dat d : ops.getDats()) {
                            LogService.getService(DropperService.class)
                                    .logApplicationDebug("DAT " + d.getDatTmLb());
                            LogService.getService(DropperService.class)
                                    .logApplicationDebug("ERS " + d.getErs().getErsFrRnLb());
                            LogService.getService(DropperService.class)
                                    .logApplicationDebug("OPS " + d.getOps().getOpsFrLb());
                        }

                        LogService.getService(DropperService.class)
                                .logApplicationDebug("###################################################");

                        if (ops == null) {
                            // La transformation du flux XML en Ops a échoué
                            LogService.getService(DropperService.class)
                                    .logApplicationError(
                                            "L'objet OPS n'a pas été créé. Vérifiez le mapping.");
                            exitCode = 4;
                            // On laisse le fichier pour qu'il soit traité
                            // de nouveau

                            continue;
                        }
                        LogService.getService(DropperService.class)
                                .logApplicationDebug("integreFichiers - setReceivedOps " + ops);
                        setReceivedOps(ops);

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
//                        if (ops.getDat() != null) {
//                            LogService.getService(DropperService.class)
//                                    .logApplicationDebug(
//                                            "RN = "
//                                            + ops.getDat().getErs()
//                                                    .getErsRnLb());
//                        }
                        // cca 21/12/2010 : correction controle de RET non
                        // pris en compte
                        // Si les contrôles de validité du message reçu
                        // montrent que le message n'est pas valide, on ne
                        // l'insère pas en base, on déplace le fichier dans
                        // le répertoire des messages traités, et on passe
                        // au message suivant
                        if (containsErrorsOrTransfertAcquittement(rets)) {
                            // MSGR04 et RET04 :génération accusé de traitement sauf
                            // si on a reçu 1 RET ou 1 RSP
                            //Desactivé dans le module IRD
//                            if (ops.getRet() == null
//                                    && ops.getRsp() == null) {
//                                generationService.acknoledge(ops, rets, properties, fichier);
//                            }

                            // Messages d'erreur donc ops non enregistré en
                            // base => ops =null
                            moveFileToTreatedDirectory(null, fichier);

                            continue;
                        }
                    }

                }
            } catch (Exception e) {

//                moveFileToErrors(e, opsForException, fichier, journalService);
                LogService.getService(DropperService.class)
                        .logApplicationError(
                                "Une exception a été levée pendant le traitement du fichier ="
                                + fichier.getName() + "\n" + e);
                exitCode = 4;
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
//        if (ops.getDel() != null) {
//            ErsDAO ersDao = new ErsDAO();
//            Ers ersDeleted = ersDao.findByFrenchRecordNumber(ops.getDel().getDelRnLb());
//            ops.getDel().setErs(ersDeleted);
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
//        if (ops.getDat() != null) {
//            // Transfert d'un XML contenant 1 DAT
//            DatTransfertRulesService datTransfertRulesService = new DatTransfertRulesService();
//            listSentOps.addAll(datTransfertRulesService.transfer(ops, fichier));
//        } else if (ops.getDel() != null) {
//            // Transfert d'un XML contenant 1 DEL
//            DelTransfertRulesService delTransfertRulesService = new DelTransfertRulesService();
//            listSentOps.addAll(delTransfertRulesService.transfer(ops, fichier));
//        } else if (ops.getCor() != null) {
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
    public static boolean containsErrorsOrTransfertAcquittement(List<Ret> rets) {
        if (rets == null || rets.isEmpty()) {
            return false;
        }

        for (Ret ret : rets) {
            if (ret.isTransfertAcquittement()
                    || !"000".equals(ret.getRetRsLb())) {
                return true;
            }
        }

        return false;
    }

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
     * @param currentFileId the currentFileId to set
     */
    public static void setCurrentFileId(Long currentFileId) {
        DropperService.currentFileId = currentFileId;
    }

    /**
     * @param currentFileId the currentXMLFileId to set
     */
    public static void setCurrentXMLFileId(Long currentFileId) {
        DropperService.currentXMLFileId = currentFileId;
    }

    /**
     * @return the currentFileId
     */
    public static Long getCurrentFileId() {
        return currentFileId;
    }

    /**
     * @return the currentXMLFileId
     */
    public static Long getCurrentXMLFileId() {
        return currentXMLFileId;
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
//                    List<Ret> rets = validateMGEN05(journalService, opsForException, fichier, getDate(messages[1]));
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
}
