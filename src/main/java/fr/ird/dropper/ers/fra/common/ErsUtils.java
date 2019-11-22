package fr.ird.dropper.ers.fra.common;

import fr.ird.dropper.ers.fra.business.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * Classe utilitaire ERS centralisant les méthodes nécessaires partout dans
 * l'application.
 *
 * @author christelle.jeanberne
 */
public class ErsUtils {

    private static List<String> listeCodesOperateurs = null;
//    private static Map<String, Operateur> operateursMap = new HashMap<String, Operateur>();

    /**
     * Constructeur.
     */
    public ErsUtils() {

    }

    /**
     * Retourne le journal de bord électronique (ERS) lié à l'opération (OPS).
     *
     * @param ops l'opération
     * @return le journal de bord électronique
     */
    public static Ers getERS(Ops ops) {
        Ers ers = null;
        if (ops != null) {
            if (ops.getDAT() != null) {
                ers = ops.getDAT().getERS();
            } else if (ops.getCOR() != null) {
                ers = ops.getCOR().getERS();
            }
        }

        return ers;
    }

    /**
     * Retourne l'opération (OPS) liée au journal de bord électronique (ERS).
     *
     * @param ers le journal de bord électronique
     * @return l'opération (OPS)
     */
//    public static Ops getOps(Ers ers) {
//        Ops ops = null;
//        List<Ops> opsPossibles = new ArrayList<Ops>();
//
//        if (ers.getDAT() != null && !ers.getDats().isEmpty()) {
//            for (Dat dat : ers.getDats()) {
//                opsPossibles.add(dat.getOps());
//            }
//        } else if (ers.getCors() != null && !ers.getCors().isEmpty()) {
//            for (Cor cor : ers.getCors()) {
//                opsPossibles.add(cor.getOps());
//            }
//        } else if (ers.getDels() != null && !ers.getDels().isEmpty()) {
//            for (Del del : ers.getDels()) {
//                opsPossibles.add(del.getOps());
//            }
//        }
//
//        Date datePremierOps = null;
//        // On prend le premier des ops pour être sûr de prendre l'OPS du message
//        // reçu
//        // et pas l'un des OPS transférés contenant le même ers
//        for (Ops opsTeste : opsPossibles) {
//            if (datePremierOps == null || opsTeste.getOpsOdotDt().before(datePremierOps)) {
//                datePremierOps = opsTeste.getOpsOdotDt();
//                ops = opsTeste;
//            }
//        }
//
//        return ops;
//    }
    /**
     * Retourne l'Ops d'un évènement présent en base.
     *
     * @param evt évènement de pêche
     * @return l'Ops d'un évènement présent en base.
     */
//    public static Ops getOps(EvenementDePeche evt) {
//        if (evt.getLog() != null && evt.getLog().getERS() != null) {
//            return getOps(evt.getLog().getERS());
//        } else {
//            return null;
//        }
//    }
    /**
     * Permet de récupérer la liste des journaux de bord (ERS) à partir de
     * l'opération si elle est de type DAT/COR/RSP.
     *
     * @param ops l'opération
     * @return
     */
//    public static List<Ers> getErsList(Ops ops) {
//        List<Ers> ersList = new ArrayList<Ers>();
//        if (ops.getCOR() != null) {
//            ersList.add(ops.getCOR().getERS());
//        } else if (ops.getDat() != null) {
//            ersList.add(ops.getDat().getERS());
//        } else if (ops.getRsp() != null && ops.getRsp().getListErs() != null && !ops.getRsp().getListErs().isEmpty()) {
//            ersList.addAll(ops.getRsp().getListErs());
//        }
//        return ersList;
//    }
    /**
     * Retourne l'ELOG lié au journal de bord électronique (ERS) passé en
     * paramètre.
     *
     * @param ers : le journal de bord électronique
     * @return null s'il n'y a pas de LOG, pas d'ELOG, sinon renvoie l'ELOG
     * trouvé
     */
    public static Elog getElog(Ers ers) {
        Elog elog = null;
        if (ers.getLOG() != null && ers.getLOG().getELOG() != null) {
            elog = ers.getLOG().getELOG();
        }
        return elog;
    }

    /**
     * Retourne l'ELOG lié au journal de bord électronique passé en paramètre.
     *
     * @param ops : le journal de bord électronique
     * @return null s'il n'y a pas de LOG, pas d'ELOG, sinon renvoie l'ELOG
     * trouvé
     */
    public static Elog getElog(Ops ops) {
        Ers ers = getERS(ops);
        if (ers == null) {
            return null;
        }

        return getElog(ers);
    }

    /**
     * Retourne l'attribut TN de l'ELOG lié au journal de bord électronique
     * passé en paramètre.
     *
     * @param ers : le journal de bord électronique
     * @return null s'il n'y a pas de LOG, pas d'ELOG ou pas d'attribut TN dans
     * ELOG, renvoie l'attribut TN de l'ELOG
     */
    public static String getElogTn(Ers ers) {
        String elogTn = null;
        if (getElog(ers) != null && getElog(ers).getTN() != null) {
            elogTn = getElog(ers).getTN();
        }
        return elogTn;
    }

    /**
     * Retourne l'ELOG lié au journal de bord électronique (ERS) passé en
     * paramètre.
     *
     * @param ers : le journal de bord électronique
     * @return null s'il n'y a pas de LOG, pas d'ELOG, sinon renvoie l'ELOG
     * trouvé
     */
//    public static Elog getElog(EvenementDePeche evenementDePeche) {
//        Elog elog = null;
//        if (evenementDePeche != null && evenementDePeche.getLog() != null && evenementDePeche.getLog().getElog() != null) {
//            elog = evenementDePeche.getLog().getElog();
//        }
//        return elog;
//    }
    /**
     * Retourne l'attribut TN de l'ELOG lié à l'événement de pêche passé en
     * paramètre.
     *
     * @param evenementDePeche : l'événement de pêche
     * @return
     */
//    public static String getElogTn(EvenementDePeche evenementDePeche) {
//        String elogTn = null;
//        if (getElog(evenementDePeche) != null && getElog(evenementDePeche).getElogTnLb() != null) {
//            elogTn = getElog(evenementDePeche).getElogTnLb();
//        }
//        return elogTn;
//    }
    /**
     * Permet de savoir si un message de type LOG contient un ELOG avec TN
     * renseigné.
     *
     * @param ers le journal de bord
     * @return
     */
//    public static boolean isMessageSansElogTn(Ers ers) {
//        // ELOG_TN_LB est-il renseigné ?
//        return (getElogTn(ers) == null);
//    }
    /**
     * Retourne l'identifiant du navire NAVIRE_CFR_RFA à partir de l'identifiant
     * renseigné dans le LOG (IR, XR ou RC).
     *
     * @param log le registre des événements de pêche
     * @return le CFR_RFA du navire
     */
    public static String getCfrRfaDuNavire(Log log) {
        String noCfr = log.getIR();
        // Inutile car l'attribut IR de la balise LOG est obligatoire. J'ai
        // laissé l'algorithme au cas où l'attribut LOG_IR_LB deviendrait
        // facultatif dans une version ultérieure à la XSD V3.
        /*
		 * if (!StringUtils.isEmpty(log.getLogIrLb())){ noCfr = log.getLogIrLb(); } else { Navire navire = null; NavireDAO navireDAO = new NavireDAO(SessionProviderService .getService().getSession());
		 * if (!StringUtils.isEmpty(log.getLogXrLb())) { navire = navireDAO.findNavireByXrBetweenDates(log .getLogXrLb(), dateDep, dateDep); noCfr = navire.getNavireCfrRfa(); } else if
		 * (!StringUtils.isEmpty(log.getLogRcLb())) { navire = navireDAO.findNavireByXrBetweenDates(log .getLogRcLb(), dateDep, dateDep); noCfr = navire.getNavireCfrRfa(); } } if (noCfr==null) { //
		 * Insertion dans la table T_JOURNAL String message = journalService.insertMDEP01(ops); Ret ret = new Ret(); ret.setRetRsLb("002"); ret.setRetReLb(message); rets.add(ret); }
         */
        return noCfr;
    }
//
//    /**
//     * Permet de savoir si l'émetteur du message est français.
//     *
//     * @param ops l'opération (OPS)
//     * @return
//     */
//    public static boolean isOperateurFrancais(Ops ops) {
////		if (listeCodesOperateurs == null) {
////			OperateurDAO operateurDAO = new OperateurDAO(SessionProviderService.getService().getSession());
////
////			listeCodesOperateurs = operateurDAO.findOperateurCode();
////		}
////
////		// Un message provient d'un opérateur français s'il s'agit d'un
////		// opérateur trouvé en base
////		return (listeCodesOperateurs.contains(ops.getOpsFrLb()));
//        return false;
//    }
//

    /**
     * Permet de savoir si l'émetteur du message est français.
     *
     * @param ops l'opération (OPS)
     * @return
     */
//    public static boolean isEmetteurFrancais(Ops ops) {
//        // Un message provient d'un émetteur français si son attribut FR est
//        // égal au code iso 3 de la France ou s'il s'agit d'un opérateur
//        // français
////        return (isOperateurFrancais(ops) || Constants.FRENCH_3CHARACTERS.equals(ops.getOpsFrLb()));
//        return Constant.FRENCH_3CHARACTERS.equals(ops.getOpsFrLb());
//    }
//
//    /**
//     * Permet de savoir si l'émetteur du message est français.
//     *
//     * @param codePaysIso3 l'Etat du navire (LOG_FS_LB, SAL_FS_LB, TRA_FC_LB,
//     * ...)
//     * @return
//     */
//    public static boolean isNavireFrancais(String codePaysIso3) {
////        if (listeCodesOperateurs == null) {
////            OperateurDAO operateurDAO = new OperateurDAO(SessionProviderService.getService().getSession());
////
////            listeCodesOperateurs = operateurDAO.findOperateurCode();
////        }
////
////        // Un message provient d'un navire français si l'attribut indiquant le
////        // pays est égal au code iso 3 de la France ou s'il s'agit d'un
////        // opérateur français
////        return (listeCodesOperateurs.contains(codePaysIso3) || Constants.FRENCH_3CHARACTERS.equals(codePaysIso3));
//return fa
//    }
//
//    /**
//     * Permet de savoir si le destinataire du message est français.
//     *
//     * @param ops l'opération (OPS)
//     * @return
//     */
//    public static boolean isDestinataireFrancais(Ops ops) {
//        if (listeCodesOperateurs == null) {
//            OperateurDAO operateurDAO = new OperateurDAO(SessionProviderService.getService().getSession());
//
//            listeCodesOperateurs = operateurDAO.findOperateurCode();
//        }
//
//        // Un message provient d'un destinataire français si son attribut AD est
//        // égal au code iso 3 de la France ou s'il s'agit d'un opérateur
//        // français
//        return (listeCodesOperateurs.contains(ops.getOpsAdLb()) || Constants.FRENCH_3CHARACTERS.equals(ops.getOpsAdLb()));
//    }
//
//    /**
//     * Permet de savoir si l'émetteur du message est un opérateur navire
//     * français.
//     *
//     * @param ops l'opération (OPS)
//     * @return
//     */
//    public static boolean isOperateurNavireFrancais(Ops ops) {
//        Operateur operateur;
//
//        if (!operateursMap.containsKey(ops.getOpsFrLb())) {
//            OperateurDAO operateurDAO = new OperateurDAO(SessionProviderService.getService().getSession());
//
//            operateur = operateurDAO.findByOperatorCode(ops.getOpsFrLb());
//
//            operateursMap.put(ops.getOpsFrLb(), operateur);
//        } else {
//            operateur = operateursMap.get(ops.getOpsFrLb());
//        }
//
//        return (operateur != null) && (!operateur.isOprCauBl());
//    }
    /**
     * Permet de récupérer l'opération (OPS) du retour au port (RTP).
     *
     * @param rtp le retour au port
     * @return l'opération (OPS)
     */
//    public static Ops getOpsDuRtpEnBase(Rtp rtp) {
//        return getOps(rtp);
//    }
    /**
     * Règle GENR07.
     *
     * Permet de savoir si la capture est nulle (pas d'espèce ou des espèces
     * avec un poids à 0 ou aucun engin de pêche lancé en mer).
     *
     * @param far la capture
     * @return
     */
//    public static boolean isCaptureNulle(Far far) {
//        boolean isCaptureNulle = true;
//        // Si un engin de pêche a été lancé en mer => capture non nulle
//        if (far.getGea() != null && far.getGea().getGes() != null) {
//            isCaptureNulle = false;
//        } else if (far.getListSpe() != null && !far.getListSpe().isEmpty()) {
//            for (Spe spe : far.getListSpe()) {
//                // Si le poids (WT) d'une espèce (SPE) de poisson est
//                // différente de 0 => capture non nulle
//                if (spe.getSpeWtNb() != null && spe.getSpeWtNb().compareTo(0D) != 0) {
//                    isCaptureNulle = false;
//                    break;
//                }
//            }
//        } else {
//            // S'il s'agit d'une capture conjointe de thon rouge et que
//            // l'espèce (SPE) a un de ses attributs WT (poids) ou
//            // NF (nombre) différent de 0 => capture non nulle
//            Spe spe = getCaptureConjointeThonRouge(far);
//            if (spe != null && ((spe.getSpeWtNb() != null && spe.getSpeWtNb().compareTo(0D) != 0) || (spe.getSpeNfNb() != null && spe.getSpeNfNb() != 0))) {
//                isCaptureNulle = false;
//            }
//        }
//        return isCaptureNulle;
//    }
    /**
     * Retourne la capture conjointe de thon rouge s'il s'agit de ce type de
     * capture.
     *
     * @param far la capture
     * @return null si aucune capture de thon rouge
     */
//    public static Spe getCaptureConjointeThonRouge(Far far) {
//        Spe captureConjointeThonRouge = null;
//        // Vérifie qu'il s'agit d'une pêche conjointe de thon rouge
//        if (far.getJci() != null && far.getJci().getListSpe() != null && !far.getJci().getListSpe().isEmpty()) {
//            for (Spe spe : far.getJci().getListSpe()) {
//                // Vérifie que l'espèce est le thon rouge
//                if (spe.getSpeSnLb() != null && "BFT".equals(spe.getSpeSnLb())) {
//                    captureConjointeThonRouge = spe;
//                }
//            }
//        }
//        return captureConjointeThonRouge;
//    }
    /**
     * Permet de savoir s'il s'agit d'une capture conjointe de thon rouge.
     *
     * @param far la capture
     * @return
     */
//    public static boolean isCaptureConjointeThonRouge(Far far) {
//        return getCaptureConjointeThonRouge(far) != null;
//    }
    /**
     * Permet de savoir s'il s'agit d'une capture conjointe de thon rouge non
     * nulle.
     *
     * @param far la capture
     * @return
     */
//    public static boolean isCaptureConjointeThonRougeNonNulle(Far far) {
//        boolean isCaptureConjointeThonRougeNonNulle = false;
//        Spe spe = getCaptureConjointeThonRouge(far);
//
//        if (spe != null && (spe.getSpeWtNb().compareTo(0D) != 0 || spe.getSpeNfNb() != 0)) {
//            isCaptureConjointeThonRougeNonNulle = true;
//        }
//
//        return isCaptureConjointeThonRougeNonNulle;
//    }
    /**
     * Permet de savoir si on doit transférer le message au pays.
     *
     * @param paysZoneEffort le pays de zone d'effort
     * @return
     */
//    public static boolean isPaysZoneEffortEligibleAuTransfert(Pays paysZoneEffort) {
//        List<String> paysEligibles = Constant.PAYS_TRANSFERT_COE_COX;
//
//        // On doit envoyer le message au pays s'il est membre de la communauté
//        // européenne ou dans la liste des autres pays autorisés
//        return !Constant.FRENCH_3CHARACTERS.equals(paysZoneEffort.getPaysIso3Rfa()) && (paysZoneEffort.isPaysCeOn() || paysEligibles.contains(paysZoneEffort.getPaysIso3Rfa()));
//    }
    /**
     * Méthode permettant de mettre à zéro l'heure d'une date.
     *
     * @param myCalendar
     * @return le calendrier sans l'heure, minute, secondes
     */
    public static Calendar clearTime(Calendar myCalendar) {
        myCalendar.set(Calendar.HOUR_OF_DAY, 0);
        myCalendar.set(Calendar.MINUTE, 0);
        myCalendar.set(Calendar.SECOND, 0);
        myCalendar.set(Calendar.MILLISECOND, 0);
        return myCalendar;
    }

    /**
     * Copie le fichier sur webdav et retourne l'identifiant du fichier.
     *
     * @param fichier
     * @return id du fichier copié / null en cas d'échec
     */
//    public static Long copyFile(File fichier) throws Exception {
//        OpsFileValidatorReport opsFileValidatorReport = new OpsFileValidatorReport();
//        WebdavService webdavService = new WebdavService(SessionProviderService.getService().getSession());
//        return webdavService.copyFile(fichier, opsFileValidatorReport);
//    }
    /**
     * Retourne la date d'un évènement de pêche.
     *
     * @param evenement évènement de pêche
     * @return la date d'un évènement de pêche
     */
    public static Date getDateEvenement(EvenementDePeche evenement) {
        if (!StringUtils.isEmpty(evenement.getTiLb())) {
            return evenement.getDatiDt();
        } else {
            return evenement.getDaDt();
        }
    }

    /**
     * Récupère tous les évènements de pêche correspondant à une marée
     * identifiée par sont ersGroupeLb. Les évènements ne sont pas triés.
     *
     * @param ersGroupeLb identifiant de la marée.
     * @return tous les évènements de pêche correspondant à une marée identifiée
     * par sont ersGroupeLb. Les évènements ne sont pas triés.
     */
//    public static List<EvenementDePeche> findAllEventsByErsGroupeLb(String ersGroupeLb) {
//        ErsDAO ersDAO = new ErsDAO(SessionProviderService.getService().getSession());
//        List<Ers> ersDeLaMaree = ersDAO.findDatAndCorByErsGroupeLb(ersGroupeLb);
//
//        return getAllEventsOfErsList(ersDeLaMaree);
//    }
    /**
     * Récupère tous les évènements de pêche correspondant à une marée
     * identifiée par sont ersGroupeLb, et en excluant les évènements de l'ERS à
     * corriger et en incluant les évènements de l'ERS correcteur. Les
     * évènements ne sont pas triés.
     *
     * @param ersGroupeLb identifiant de la marée.
     * @param ersAcorriger ers dont les évènements ne doivent pas être pris en
     * compte
     *
     * @return tous les évènements de pêche correspondant à une marée identifiée
     * par sont ersGroupeLb, et en excluant les évènements de l'ERS à corriger
     * et en incluant les évènements de l'ERS correcteur. Les évènements ne sont
     * pas triés.
     */
//    public static List<EvenementDePeche> findAllEventsByErsGroupeLbAfterCorrection(String ersGroupeLb, Ers ersAcorriger, Ers ersCorrecteur) {
//        ErsDAO ersDAO = new ErsDAO(SessionProviderService.getService().getSession());
//
//        List<Ers> ersDeLaMaree = ersDAO.findDatAndCorByErsGroupeLb(ersGroupeLb);
//
//        ersDeLaMaree.remove(ersAcorriger);
//        ersDeLaMaree.add(ersCorrecteur);
//
//        return getAllEventsOfErsList(ersDeLaMaree);
//    }
    /**
     * Récupère tous les évènements de pêche correspondant à une marée
     * identifiée par sont ersGroupeLb, et en excluant les évènements d'un ERS
     * donné. Les évènements ne sont pas triés.
     *
     * @param ersGroupeLb identifiant de la marée.
     * @param excludedErs ers dont les évènements ne doivent pas être pris en
     * compte
     *
     * @return tous les évènements de pêche correspondant à une marée identifiée
     * par sont ersGroupeLb, et en excluant les évènements d'un ERS donné. Les
     * évènements ne sont pas triés.
     */
//    public static List<EvenementDePeche> findAllEventsByErsGroupeLbExcludeErs(String ersGroupeLb, Ers excludedErs) {
//        ErsDAO ersDAO = new ErsDAO(SessionProviderService.getService().getSession());
//
//        List<Ers> ersDeLaMaree = ersDAO.findDatAndCorByErsGroupeLb(ersGroupeLb);
//
//        ersDeLaMaree.remove(excludedErs);
//
//        return getAllEventsOfErsList(ersDeLaMaree);
//    }
    /**
     * Trouve l'événement de pêche le plus récent
     *
     * @param ersGroupeLb
     * @param excludedErs
     * @return
     */
//    public static EvenementDePeche findLastEventExcludingErs(String ersGroupeLb, Ers excludedErs) {
//        List<EvenementDePeche> evts = findAllEventsByErsGroupeLbExcludeErs(ersGroupeLb, excludedErs);
//        EvenementDePeche dernierEvtMaree = null;
//        if (evts != null && !evts.isEmpty()) {
//            Collections.sort(evts, DateComparator.ORDER_DATI_DESC);
//            dernierEvtMaree = evts.iterator().next();
//        }
//        return dernierEvtMaree;
//    }
    /**
     * Récupère tous les évènements de pêche correspondant appartenant à une
     * liste d'ERS. Les évènements ne sont pas triés.
     *
     * @param ersGroupeLb identifiant de la marée.
     * @return tous les évènements de pêche correspondant appartenant à une
     * liste d'ERS. Les évènements ne sont pas triés.
     */
//    public static List<EvenementDePeche> getAllEventsOfErsList(List<Ers> ersList) {
//        List<EvenementDePeche> result = new ArrayList<EvenementDePeche>();
//
//        // On parcourt la liste des messages de la marée
//        // pour trouver tous les événenements de pêche.
//        for (Ers messageDeLaMaree : ersList) {
//            result.addAll(getAllEventsOfErs(messageDeLaMaree));
//        }
//
//        return result;
//    }
    /**
     * Récupère tous les évènements de pêche correspondant appartenant à un ERS.
     * Les évènements ne sont pas triés.
     *
     * @param ers le journal de bord
     * @return
     */
//    public static List<EvenementDePeche> getAllEventsOfErs(Ers ers) {
//        List<EvenementDePeche> result = new ArrayList<EvenementDePeche>();
//
//        if (ers != null && ers.getLog() != null && ers.getLog().getEvts() != null) {
//            result.addAll(ers.getLog().getEvts());
//        }
//
//        return result;
//    }
    /**
     * Permet de savoir si l'ERS contient un événement de pêche PNO ou PNT.
     *
     * @param ers le journal de bord
     * @return
     */
//    public static boolean isErsContainingPnoOrPnt(Ers ers) {
//        boolean isErsContainingPnoOrPnt = false;
//
//        if (ers != null && ers.getLog() != null && (ers.getLog().getPno() != null || ers.getLog().getPnt() != null)) {
//            isErsContainingPnoOrPnt = true;
//        }
//
//        return isErsContainingPnoOrPnt;
//    }
    /**
     * Retourne :<br/>
     * - une chaîne vide si pas de balise ERS<br/>
     * - SAL s'il y a une balise SAL dans la balise ERS<br/>
     * - TRN s'il y a une balise TRN dans la balise ERS<br/>
     * - le 1er événement trouvé (ex : DEP, FAR...) s'il y a une balise LOG dans
     * la balise ERS.<br/>
     *
     * @param ops l'opération reçue
     * @return
     */
//    public static String getTypeEvenement(Ops ops) {
//        String typeEvenement = "";
//        List<Ers> ersList = new ArrayList<Ers>();
//        if (ops.getDat() != null && ops.getDat().getERS() != null) {
//            ersList.add(ops.getDat().getERS());
//        } else if (ops.getCOR() != null && ops.getCOR().getERS() != null) {
//            ersList.add(ops.getCOR().getERS());
//        } else if (ops.getRet() != null && ops.getRet().getERS() != null) {
//            ersList.add(ops.getRet().getERS());
//        } else if (ops.getRsp() != null && ops.getRsp().getListErs() != null) {
//            ersList.addAll(ops.getRsp().getListErs());
//        }
//
//        if (ersList != null && !ersList.isEmpty()) {
//            typeEvenement = getTypeEvenement(ersList.get(0));
//        }
//
//        return typeEvenement;
//    }
    /**
     * Retourne :<br/>
     * - une chaîne vide si pas de balise ERS<br/>
     * - SAL s'il y a une balise SAL dans la balise ERS<br/>
     * - TRN s'il y a une balise TRN dans la balise ERS<br/>
     * - le 1er événement trouvé (ex : DEP, FAR...) s'il y a une balise LOG dans
     * la balise ERS.<br/>
     *
     * @param ers le journal de bord électronique
     * @return
     */
//    public static String getTypeEvenement(Ers ers) {
//        String typeEvenement = "";
//        if (ers.getSal() != null) {
//            typeEvenement = "SAL";
//        } else if (ers.getTrn() != null) {
//            typeEvenement = "TRN";
//        } else {
//            List<? extends EvenementDePeche> evts = ers.getLog().getEvts();
//            if (evts == null || evts.isEmpty()) {
//                typeEvenement = "LOG";
//            } else {
//                typeEvenement = evts.get(0).getType();
//            }
//        }
//
//        return typeEvenement;
//    }
    /**
     * Permet de savoir si le transbordement a eu lieu en mer (pas de port).
     *
     * @param tra le transbordement
     * @return
     */
//    public static boolean isTransbordementEnMer(Tra tra) {
//        // S'il n'y a pas de port (attribut PO de la balise TRA) => la
//        // transbordement est en mer
//        return StringUtils.isBlank(tra.getTraPoLb());
//    }
    /**
     * Permet de savoir si le transbordement a eu dans un port.
     *
     * @param tra le transbordement
     * @return
     */
//    public static boolean isTransbordementAuPort(Tra tra) {
//        // S'il y a un port (attribut PO de la balise TRA) => la transbordement
//        // est au port
//        return StringUtils.isNotBlank(tra.getTraPoLb());
//    }
    /**
     * Retourne la dernière opération non modifiée de la marée et du navire.
     *
     * @param elogTnLb l'identifiant français de la marée
     * @param idNavire l'identifiant du navire
     * @return la dernière opération
     */
//    public static Ops findDernierOpsDeMaree(String elogTnLb, String idNavire) {
//        OpsDAO opsDAO = new OpsDAO(SessionProviderService.getService().getSession());
//        Ops dernierOpsDeMaree = null;
//        if (elogTnLb != null && idNavire != null) {
//            dernierOpsDeMaree = opsDAO.findLastOperationByElogTn(elogTnLb, idNavire);
//        }
//        return dernierOpsDeMaree;
//    }
    /**
     * Retourne le départ du navire après la date indiquée.
     *
     * @param idNavire l'identifiant du navire
     * @param date la date après laquelle on cherche un départ
     * @return le départ trouvé
     */
//    public static Dep finDepartSuivantEnBase(String idNavire, Date date) {
//        DepDAO depDAO = new DepDAO(SessionProviderService.getService().getSession());
//        Dep departSuivantEnBase = null;
//        if (idNavire != null && date != null) {
//            departSuivantEnBase = depDAO.findFirstDepAfterDateForVessel(idNavire, date);
//        }
//        return departSuivantEnBase;
//    }
    /**
     * Permet de savoir si le débarquement (LAN) est autorisé avant le dernier
     * événément de pêche déjà intégré pour la marée.
     *
     * @param dernierEvenementDePeche le dernier événément de pêche
     * @param rtp le retour au port
     * @param nbEvents le nombre d'événéments de pêche
     * @param nbEventsAnalyzed le nombre d'événéments de pêche déjà analysés ou
     * en cours d'analyse
     * @return
     */
//    public static boolean isLanAuthorizedBeforeLastEventForDatAndCor(EvenementDePeche dernierEvenementDePeche) {
//        boolean authorized = false;
//        // L'inspection (INS) est autorisée après le débarquement(LAN)
//        if ("INS".equals(dernierEvenementDePeche.getType())) {
//            authorized = true;
//        } // La capture (FAR) n'est autorisée après le retour au port
//        // (RTP) que si elle est nulle
//        else if ("FAR".equals(dernierEvenementDePeche.getType())) {
//            Far far = (Far) dernierEvenementDePeche;
//            if (ErsUtils.isCaptureNulle(far)) {
//                authorized = true;
//            }
//        } // Le transbordement (TRA) n'est autorisé après le débarquement(LAN)
//        // que s'il a lieu au port
//        else if ("TRA".equals(dernierEvenementDePeche.getType())) {
//            Tra tra = (Tra) dernierEvenementDePeche;
//            if (ErsUtils.isTransbordementAuPort(tra)) {
//                authorized = true;
//            }
//        }
//        return authorized;
//    }
    /**
     * Retourne le dernier événement de pêche de la dernière opération non
     * modifiée de la marée et du navire.
     *
     * @param elogTnLb l'identifiant français de la marée
     * @param idNavire l'identifiant du navire
     * @return
     */
//    public static EvenementDePeche findDernierEvtDernierOpsDeMaree(Ers ers, EvenementDePeche evt, String elogTnLb, String idNavire) {
//        Ops opsPrecedentDeMaree = findDernierOpsDeMaree(elogTnLb, idNavire);
//        List<EvenementDePeche> evtsOpsPrecedentDeMaree = ErsUtils.getAllEventsOfErs(ErsUtils.getERS(opsPrecedentDeMaree));
//        evtsOpsPrecedentDeMaree.addAll(ErsUtils.getAllEventsOfErs(ers));
//        evtsOpsPrecedentDeMaree.remove(evt);
//        EvenementDePeche dernierEvtMaree = null;
//        if (evtsOpsPrecedentDeMaree != null && !evtsOpsPrecedentDeMaree.isEmpty()) {
//            Collections.sort(evtsOpsPrecedentDeMaree, DateComparator.ORDER_DATI_DESC);
//            dernierEvtMaree = evtsOpsPrecedentDeMaree.iterator().next();
//        }
//        return dernierEvtMaree;
//    }
    /**
     * Permet de récupérer le dernier evenement qui n'est pas un INS, FAR avec
     * capture null, TRA (avec PO)
     *
     * @param listEvenement
     * @return
     */
//    public static EvenementDePeche getLastMsgDernier(List<? extends EvenementDePeche> listEvenement) {
//        Collections.sort(listEvenement, DateComparator.ORDER_DATI_DESC);
//        EvenementDePeche dernierEvtMaree = null;
//        if (listEvenement != null && !listEvenement.isEmpty()) {
//            // on boucle sur tous les évènements
//            for (EvenementDePeche evenementDePeche : listEvenement) {
//                // si c'est un INS, on continue la boucle
//                if (evenementDePeche instanceof Ins) {
//                    continue;
//                } else if (evenementDePeche instanceof Far) {
//                    Far far = (Far) evenementDePeche;
//                    // si c'est un FAR sans capture, on continue la boucle
//                    if (ErsUtils.isCaptureNulle(far)) {
//                        continue;
//                    }
//                } else if (evenementDePeche instanceof Tra) {
//                    Tra tra = (Tra) evenementDePeche;
//                    // si c'est un TRA avec PO, on continue la boucle
//                    if (ErsUtils.isTransbordementAuPort(tra)) {
//                        continue;
//                    }
//                }
//
//                // si on arrive jusque ici, c'est que ce n'est ni un INS, Far
//                // sans capture, TRA avec PO, on a du coup notre dernier Evt
//                dernierEvtMaree = evenementDePeche;
//                break;
//            }
//        }
//
//        return dernierEvtMaree;
//    }
    /**
     * Permet de savoir si l'événément de pêche est autorisé après le retour au
     * port (RTP) que l'on supprime.
     *
     * @param evenementDePeche l'événément de pêche
     * @param rtp le retour au port
     * @param nbEvents le nombre d'événéments de pêche
     * @param nbEventsAnalyzed le nombre d'événéments de pêche déjà analysés ou
     * en cours d'analyse
     * @return
     */
//    public static boolean isEventAuthorizedAfterRtpWhenDeletingRtp(EvenementDePeche evenementDePeche, Rtp rtp, int nbEvents, int nbEventsAnalyzed) {
//        boolean authorized = false;
//        // L'inspection (INS) n'est autorisée après le retour au port
//        // (RTP) que si c'est le dernier événement de pêche
//        if ("INS".equals(evenementDePeche.getType()) && nbEvents == nbEventsAnalyzed) {
//            authorized = true;
//        } // La capture (FAR) n'est autorisée après le retour au port
//        // (RTP) que si elle est nulle
//        else if ("FAR".equals(evenementDePeche.getType())) {
//            Far far = (Far) evenementDePeche;
//            if (ErsUtils.isCaptureNulle(far)) {
//                authorized = true;
//            }
//        } // Le transbordement (TRA) n'est autorisé après le retour au
//        // port (RTP) que s'il a lieu en mer
//        else if ("TRA".equals(evenementDePeche.getType())) {
//            Tra tra = (Tra) evenementDePeche;
//            if (ErsUtils.isTransbordementEnMer(tra)) {
//                authorized = true;
//            }
//        }
//        return authorized;
//    }
    /**
     * Vérifie la présence des attributs FE dans RAS du COE et du COX.
     *
     * @param coe l'entrée en zone
     * @param cox la sortie de zone
     * @return
     */
//    public static boolean isCroOrTrzValide(Coe coe, Cox cox) {
//        boolean isCroOrTrzValide = true;
//        if (coe == null || coe.getRas() == null || StringUtils.isBlank(coe.getRas().getRasFeLb())) {
//            isCroOrTrzValide = false;
//        }
//        if (cox == null || cox.getRas() == null || StringUtils.isBlank(cox.getRas().getRasFeLb())) {
//            isCroOrTrzValide = false;
//        }
//
//        return isCroOrTrzValide;
//    }
    /**
     * Vérifie la présence que le RAS du COE ou COX existe et que l'un des
     * attributs FE ou EZ est renseigné.
     *
     * @param ras la zone maritime
     * @return
     */
//    public static boolean isRasInCoeOrCoxValide(Ras ras) {
//        boolean isRasInCoeOrCoxValide = true;
//        if (ras == null || (StringUtils.isBlank(ras.getRasFeLb()) && StringUtils.isBlank(ras.getRasEzLb()))) {
//            isRasInCoeOrCoxValide = false;
//        }
//
//        return isRasInCoeOrCoxValide;
//    }
    /**
     * Vérifie qu'il y ait le même type d'événement de pêche dans l'ERS fourni.
     *
     * @param evt l'événement de pêche
     * @param ers le journal de bord dans lequel on doit trouver l'événement de
     * pêche de même type
     * @return <code>true</code> si un événement de même type a été trouvé
     */
//    public static boolean containsSameTypeOfEvent(EvenementDePeche evt, Ers ers) {
//        // Si l'ERS à corriger n'a pas été trouvé ou s'il ne contient pas de
//        // LOG ou s'il ne contient pas d'événement de pêche de même type
//        // (ex: FAR, TRA, LAN...) alors il n'y a pas d'événement de même type
//        boolean containsSameTypeOfEvent = false;
//        List<EvenementDePeche> evtsErs = getAllEventsOfErs(ers);
//        if (evtsErs != null && !evtsErs.isEmpty()) {
//            for (EvenementDePeche evenementDePeche : evtsErs) {
//                if (evt.getType().equals(evenementDePeche.getType())) {
//                    containsSameTypeOfEvent = true;
//                    break;
//                }
//            }
//        }
//        return containsSameTypeOfEvent;
//    }
    /**
     * Renvoie les informations du navire du message si DAT/COR, du message à
     * supprimer si DEL.
     *
     * @param ops l'opération reçue
     * @return
     */
//    public static HashMap<String, String> getVesselData(Ops ops) {
//        HashMap<String, String> properties = new HashMap<String, String>();
//        Ers ers;
//        // Récupération de l'ERS du DAT/COR/DEL
//        if (ops.getDel() != null) {
//            ErsDAO ersDAO = new ErsDAO(SessionProviderService.getService().getSession());
//            if (ErsUtils.isEmetteurFrancais(ops)) {
//                ers = ersDAO.findByFrenchRecordNumber(ops.getDel().getDelRnLb());
//            } else {
//                ers = ersDAO.findByRecordNumber(ops.getDel().getDelRnLb());
//            }
//        } else {
//            ers = getERS(ops);
//        }
//
//        // Si l'ERS n'est pas null on poursuit la recherche des informations
//        // sur le navire
//        if (ers != null) {
//            // L'identifiant obligatoire du navire
//            String irLb = null;
//            // Les autres informations navire
//            String rcLb = null;
//            String xrLb = null;
//            String naLb = null;
//            // Indique si toutes les informations navires sont renseignées dans
//            // l'ERS
//            boolean allVesselDataSetted = false;
//
//            if (ers.getLog() != null) {
//                irLb = ers.getLog().getLogIrLb();
//                rcLb = ers.getLog().getLogRcLb();
//                xrLb = ers.getLog().getLogXrLb();
//                naLb = ers.getLog().getLogNaLb();
//                if (!StringUtils.isEmpty(ers.getLog().getLogRcLb()) && !StringUtils.isEmpty(ers.getLog().getLogXrLb()) && !StringUtils.isEmpty(ers.getLog().getLogNaLb())) {
//                    allVesselDataSetted = true;
//                }
//            } else if (ers.getSal() != null) {
//                irLb = ers.getSal().getSalIrLb();
//                rcLb = ers.getSal().getSalRcLb();
//                xrLb = ers.getSal().getSalXrLb();
//                naLb = ers.getSal().getSalNaLb();
//                if (!StringUtils.isEmpty(ers.getSal().getSalRcLb()) && !StringUtils.isEmpty(ers.getSal().getSalXrLb()) && !StringUtils.isEmpty(ers.getSal().getSalNaLb())) {
//                    allVesselDataSetted = true;
//                }
//            }
//
//            if (!StringUtils.isEmpty(irLb)) {
//                properties.put("IR", irLb);
//                if (allVesselDataSetted) {
//                    properties.put("RC", rcLb);
//                    properties.put("XR", xrLb);
//                    properties.put("NA", naLb);
//                } else {
//                    NavireDAO navireDAO = new NavireDAO(SessionProviderService.getService().getSession());
//                    Navire navire = navireDAO.findNavireByIrBetweenDates(irLb, ops.getOpsOdotDt(), ops.getOpsOdotDt());
//                    if (navire != null) {
//                        properties.put("RC", navire.getNavireIrcscodLb());
//                        properties.put("XR", navire.getNavireMarqextLb());
//                        properties.put("NA", navire.getNavireNomLb());
//                    } else {
//                        // Si les champs ne sont pas nuls, on met leur valeur,
//                        // sinon une chaine vide
//                        properties.put("RC", rcLb != null ? rcLb : "");
//                        properties.put("XR", xrLb != null ? xrLb : "");
//                        properties.put("NA", naLb != null ? naLb : "");
//                    }
//                }
//            }
//        }
//
//        return properties;
//    }
//    public static Navire findNavireByQue(Que que) {
//        Navire navire = null;
//        String idValue = que.getQueIvLb();
//        if (!StringUtils.isEmpty(idValue)) {
//            NavireDAO navireDAO = new NavireDAO(SessionProviderService.getService().getSession());
//            if ("IR".equals(que.getQueIdLb())) {
//                navire = navireDAO.findNavireByIrBetweenDates(idValue, que.getOps().getOpsOdotDt(), que.getOps().getOpsOdotDt());
//            } else if ("XR".equals(que.getQueIdLb())) {
//                navire = navireDAO.findNavireByXrBetweenDates(idValue, que.getOps().getOpsOdotDt(), que.getOps().getOpsOdotDt());
//            } else if ("RC".equals(que.getQueIdLb())) {
//                navire = navireDAO.findNavireByRcBetweenDates(idValue, que.getOps().getOpsOdotDt(), que.getOps().getOpsOdotDt());
//            } else if ("NA".equals(que.getQueIdLb())) {
//                navire = navireDAO.findNavireByNaBetweenDates(idValue, que.getOps().getOpsOdotDt(), que.getOps().getOpsOdotDt());
//            }
//        }
//        return navire;
//    }
}
