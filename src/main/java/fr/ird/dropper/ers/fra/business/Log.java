package fr.ird.dropper.ers.fra.business;

import fr.ird.dropper.ers.fra.business.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Registre des événements de pêche (départ, capture, rejet, retour au port...).
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("LOG")
public class Log implements Serializable {

    private static final long serialVersionUID = 3101094322422315289L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long logCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("IR")
    private String logIrLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("RC")
    private String logRcLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("XR")
    private String logXrLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("NA")
    private String logNaLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("MA")
    private String logMaLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("MD")
    private String logMdLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("FS")
    private String logFsLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("IN")
    private String logInLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("IM")
    private String logImLb;

    /**
     * persistent field
     */
    @XStreamOmitField
    private Ers ers;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "DEP")
    private List<Dep> listDep;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "FAR")
    private List<Far> listFar;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "RLC")
    private List<Rlc> listRlc;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "TRA")
    private List<Tra> listTra;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "COE")
    private List<Coe> listCoe;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "COX")
    private List<Cox> listCox;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "CRO")
    private List<Cro> listCro;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "TRZ")
    private List<Trz> listTrz;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "INS")
    private List<Ins> listIns;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "DIS")
    private List<Dis> listDis;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "PNO")
    private List<Pno> listPno;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "PNT")
    private List<Pnt> listPnt;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "EOF")
    private List<Eof> listEof;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "RTP")
    private List<Rtp> listRtp;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "LAN")
    private List<Lan> listLan;

    /**
     * persistent field
     */
    @XStreamAlias("ELOG")
    private Elog elog;

    public Long getLogCdn() {
        return this.logCdn;
    }

    public void setLogCdn(Long logCdn) {
        this.logCdn = logCdn;
    }

    public String getLogIrLb() {
        return this.logIrLb;
    }

    public void setLogIrLb(String logIrLb) {
        this.logIrLb = logIrLb;
    }

    public String getLogRcLb() {
        return this.logRcLb;
    }

    public void setLogRcLb(String logRcLb) {
        this.logRcLb = logRcLb;
    }

    public String getLogXrLb() {
        return this.logXrLb;
    }

    public void setLogXrLb(String logXrLb) {
        this.logXrLb = logXrLb;
    }

    public String getLogNaLb() {
        return this.logNaLb;
    }

    public void setLogNaLb(String logNaLb) {
        this.logNaLb = logNaLb;
    }

    public String getLogMaLb() {
        return this.logMaLb;
    }

    public void setLogMaLb(String logMaLb) {
        this.logMaLb = logMaLb;
    }

    public String getLogMdLb() {
        return this.logMdLb;
    }

    public void setLogMdLb(String logMdLb) {
        this.logMdLb = logMdLb;
    }

    public String getLogFsLb() {
        return this.logFsLb;
    }

    public void setLogFsLb(String logFsLb) {
        this.logFsLb = logFsLb;
    }

    public String getLogInLb() {
        return this.logInLb;
    }

    public void setLogInLb(String logInLb) {
        this.logInLb = logInLb;
    }

    public String getLogImLb() {
        return this.logImLb;
    }

    public void setLogImLb(String logImLb) {
        this.logImLb = logImLb;
    }

    public Ers getErs() {
        return this.ers;
    }

    public void setErs(Ers ers) {
        this.ers = ers;
    }

    public Elog getElog() {
        return this.elog;
    }

    public void setElog(Elog elog) {
        this.elog = elog;
    }

    public List<Tra> getListTra() {
        if (listTra == null) {
            this.listTra = new ArrayList<>();
        }
        return this.listTra;
    }

    public void setListTra(List<Tra> listTra) {
        this.listTra = listTra;
    }

    public List<Cox> getListCox() {
        if (listCox == null) {
            this.listCox = new ArrayList<>();
        }
        return this.listCox;
    }

    public void setListCox(List<Cox> listCox) {
        this.listCox = listCox;
    }

    public Dep getDep() {
        if (getListDep() == null || getListDep().isEmpty()) {
            return null;
        } else {
            return getListDep().get(0);
        }
    }

    public List<Dep> getListDep() {
        if (listDep == null) {
            this.listDep = new ArrayList<>();
        }
        return this.listDep;
    }

    public void setListDep(List<Dep> listDep) {
        this.listDep = listDep;
    }

    public Rtp getRtp() {
        if (getListRtp() == null || getListRtp().isEmpty()) {
            return null;
        } else {
            return getListRtp().get(0);
        }
    }

    public List<Rtp> getListRtp() {
        if (listRtp == null) {
            this.listRtp = new ArrayList<>();
        }
        return this.listRtp;
    }

    public void setListRtp(List<Rtp> listRtp) {
        this.listRtp = listRtp;
    }

    public List<Far> getListFar() {
        if (listFar == null) {
            this.listFar = new ArrayList<>();
        }
        return this.listFar;
    }

    public void setListFar(List<Far> listFar) {
        this.listFar = listFar;
    }

    public List<Rlc> getListRlc() {
        if (listRlc == null) {
            this.listRlc = new ArrayList<>();
        }
        return this.listRlc;
    }

    public void setListRlc(List<Rlc> listRlc) {
        this.listRlc = listRlc;
    }

    public List<Ins> getListIns() {
        if (listIns == null) {
            this.listIns = new ArrayList<>();
        }
        return this.listIns;
    }

    public void setListIns(List<Ins> listIns) {
        this.listIns = listIns;
    }

    public List<Trz> getListTrz() {
        if (listTrz == null) {
            this.listTrz = new ArrayList<>();
        }
        return this.listTrz;
    }

    public void setListTrz(List<Trz> listTrz) {
        this.listTrz = listTrz;
    }

    public List<Coe> getListCoe() {
        if (listCoe == null) {
            this.listCoe = new ArrayList<>();
        }
        return this.listCoe;
    }

    public void setListCoe(List<Coe> listCoe) {
        this.listCoe = listCoe;
    }

    public List<Cro> getListCro() {
        if (listCro == null) {
            this.listCro = new ArrayList<>();
        }
        return this.listCro;
    }

    public void setListCro(List<Cro> listCro) {
        this.listCro = listCro;
    }

    public Lan getLan() {
        if (getListLan() == null || getListLan().isEmpty()) {
            return null;
        } else {
            return getListLan().get(0);
        }
    }

    public List<Lan> getListLan() {
        if (listLan == null) {
            this.listLan = new ArrayList<>();
        }
        return this.listLan;
    }

    public void setListLan(List<Lan> listLan) {
        this.listLan = listLan;
    }

    public Eof getEof() {
        if (getListEof() == null || getListEof().isEmpty()) {
            return null;
        } else {
            return getListEof().get(0);
        }
    }

    public List<Eof> getListEof() {
        if (listEof == null) {
            this.listEof = new ArrayList<>();
        }
        return this.listEof;
    }

    public void setListEof(List<Eof> listEof) {
        this.listEof = listEof;
    }

    public Pno getPno() {
        if (getListPno() == null || getListPno().isEmpty()) {
            return null;
        } else {
            return getListPno().get(0);
        }
    }

    public List<Pno> getListPno() {
        if (listPno == null) {
            this.listPno = new ArrayList<>();
        }
        return this.listPno;
    }

    public void setListPno(List<Pno> listPno) {
        this.listPno = listPno;
    }

    public Pnt getPnt() {
        if (getListPnt() == null || getListPnt().isEmpty()) {
            return null;
        } else {
            return getListPnt().get(0);
        }
    }

    public List<Pnt> getListPnt() {
        if (listPnt == null) {
            this.listPnt = new ArrayList<>();
        }
        return listPnt;
    }

    public void setListPnt(List<Pnt> listPnt) {
        this.listPnt = listPnt;
    }

    public List<Dis> getListDis() {
        if (listDis == null) {
            this.listDis = new ArrayList<>();
        }
        return this.listDis;
    }

    public void setListDis(List<Dis> listDis) {
        this.listDis = listDis;
    }

    @Override
    public String toString() {
        return "Log{" + "logCdn=" + logCdn + ", logIrLb=" + logIrLb + ", logRcLb=" + logRcLb + ", logXrLb=" + logXrLb + ", logNaLb=" + logNaLb + ", logMaLb=" + logMaLb + ", logMdLb=" + logMdLb + ", logFsLb=" + logFsLb + ", logInLb=" + logInLb + ", logImLb=" + logImLb + ", ers=" + ers + ", listDep=" + listDep + ", listFar=" + listFar + ", listRlc=" + listRlc + ", listTra=" + listTra + ", listCoe=" + listCoe + ", listCox=" + listCox + ", listCro=" + listCro + ", listTrz=" + listTrz + ", listIns=" + listIns + ", listDis=" + listDis + ", listPno=" + listPno + ", listPnt=" + listPnt + ", listEof=" + listEof + ", listRtp=" + listRtp + ", listLan=" + listLan + ", elog=" + elog + '}';
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if (!(other instanceof Log)) {
            return false;
        }
        Log castOther = (Log) other;
        return new EqualsBuilder().append(this.getLogCdn(),
                castOther.getLogCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getLogCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return logCdn;
    }

    /**
     * On va remplir les champs non présents dans le XML reçu. Cette méthode est
     * appelée automatiquement par XStream après la création de l'objet (LOG).
     *
     * @return this
     */
    private Object readResolve() {
        if (getListCoe() == null) {
            setListCoe(new ArrayList<Coe>());
        }

        if (getListCox() == null) {
            setListCox(new ArrayList<Cox>());
        }

        if (getListCro() != null) {
            for (Cro cro : getListCro()) {

                if (cro.getCoe() != null) {
                    getListCoe().add(cro.getCoe());
                    cro.getCoe().setLog(this);
                }

                if (cro.getCox() != null) {
                    getListCox().add(cro.getCox());
                    cro.getCox().setLog(this);
                }
            }
        }

        if (getListTrz() != null) {
            for (Trz trz : getListTrz()) {
                if (trz.getCoe() != null) {
                    getListCoe().add(trz.getCoe());
                    trz.getCoe().setLog(this);
                }

                if (trz.getCox() != null) {
                    getListCox().add(trz.getCox());
                    trz.getCox().setLog(this);
                }
            }
        }

        // Affectation du TnOrigLb et du Tn de l'ELOG: 
        // le TnOrigLb contiendra le contenu de l'attribut TB
        // le Tn contiendra la concaténation de l'IR du LOG et du TN de l'ELOG
        if (getElog() != null) {
            getElog().setElogTnOrigLb(getElog().getElogTnLb());
            getElog().setElogTnLb(getLogIrLb() + "-" + getElog().getElogTnLb());
        }

        return this;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichier XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peut être exporté par XStream
     */
    public Log cloneExportedFields(IExportConfiguration exportConfiguration) {
        Log clone = new Log();

        clone.setLogIrLb(getLogIrLb());
        clone.setLogRcLb(getLogRcLb());
        clone.setLogXrLb(getLogXrLb());
        clone.setLogNaLb(getLogNaLb());
        clone.setLogMaLb(getLogMaLb());
        clone.setLogMdLb(getLogMdLb());
        clone.setLogFsLb(getLogFsLb());
        clone.setLogInLb(getLogInLb());
        clone.setLogImLb(getLogImLb());

        // Clone des DEP
        if (getListDep() != null && !getListDep().isEmpty()) {
            ArrayList<Dep> cloneDeps = new ArrayList<Dep>();
            for (Dep dep : getListDep()) {
                cloneDeps.add(dep.cloneExportedFields(exportConfiguration));
            }
            clone.setListDep(cloneDeps);
        }

        // Clone des FAR
        if (getListFar() != null && !getListFar().isEmpty()) {
            ArrayList<Far> cloneFars = new ArrayList<Far>();
            for (Far far : getListFar()) {
                cloneFars.add(far.cloneExportedFields(exportConfiguration));
            }
            clone.setListFar(cloneFars);
        }

        // Clone des RLC
        if (getListRlc() != null && !getListRlc().isEmpty()) {
            ArrayList<Rlc> cloneRlcs = new ArrayList<Rlc>();
            for (Rlc rlc : getListRlc()) {
                cloneRlcs.add(rlc.cloneExportedFields(exportConfiguration));
            }
            clone.setListRlc(cloneRlcs);
        }

        // Clone des TRA
        if (getListTra() != null && !getListTra().isEmpty()) {
            ArrayList<Tra> cloneTras = new ArrayList<Tra>();
            for (Tra tra : getListTra()) {
                cloneTras.add(tra.cloneExportedFields(exportConfiguration));
            }
            clone.setListTra(cloneTras);
        }

        // Clone des COE
        if (getListCoe() != null && !getListCoe().isEmpty()) {
            ArrayList<Coe> cloneCoes = new ArrayList<Coe>();
            for (Coe coe : getListCoe()) {
                cloneCoes.add(coe.cloneExportedFields(exportConfiguration));
            }
            clone.setListCoe(cloneCoes);
        }

        // Clone des COX
        if (getListCox() != null && !getListCox().isEmpty()) {
            ArrayList<Cox> cloneCoxs = new ArrayList<Cox>();
            for (Cox cox : getListCox()) {
                cloneCoxs.add(cox.cloneExportedFields(exportConfiguration));
            }
            clone.setListCox(cloneCoxs);
        }

        // Clone des CRO
        if (getListCro() != null && !getListCro().isEmpty()) {
            ArrayList<Cro> cloneCros = new ArrayList<Cro>();
            for (Cro cro : getListCro()) {
                cloneCros.add(cro.cloneExportedFields(exportConfiguration));
            }
            clone.setListCro(cloneCros);
        }

        // Clone des TRZ
        if (getListTrz() != null && !getListTrz().isEmpty()) {
            ArrayList<Trz> cloneTrzs = new ArrayList<Trz>();
            for (Trz trz : getListTrz()) {
                cloneTrzs.add(trz.cloneExportedFields(exportConfiguration));
            }
            clone.setListTrz(cloneTrzs);
        }

        // Clone des INS
        if (getListIns() != null && !getListIns().isEmpty()) {
            ArrayList<Ins> cloneInss = new ArrayList<Ins>();
            for (Ins ins : getListIns()) {
                cloneInss.add(ins.cloneExportedFields(exportConfiguration));
            }
            clone.setListIns(cloneInss);
        }

        // Clone des DIS
        if (getListDis() != null && !getListDis().isEmpty()) {
            ArrayList<Dis> cloneDiss = new ArrayList<Dis>();
            for (Dis dis : getListDis()) {
                cloneDiss.add(dis.cloneExportedFields(exportConfiguration));
            }
            clone.setListDis(cloneDiss);
        }

        // Clone des PNO
        if (getListPno() != null && !getListPno().isEmpty()) {
            ArrayList<Pno> clonePnos = new ArrayList<Pno>();
            for (Pno pno : getListPno()) {
                clonePnos.add(pno.cloneExportedFields(exportConfiguration));
            }
            clone.setListPno(clonePnos);
        }

        // Clone des PNT
        if (getListPnt() != null && !getListPnt().isEmpty()) {
            ArrayList<Pnt> clonePnts = new ArrayList<Pnt>();
            for (Pnt pnt : getListPnt()) {
                clonePnts.add(pnt.cloneExportedFields(exportConfiguration));
            }
            clone.setListPnt(clonePnts);
        }

        // Clone des EOF
        if (getListEof() != null && !getListEof().isEmpty()) {
            ArrayList<Eof> cloneEofs = new ArrayList<Eof>();
            for (Eof eof : getListEof()) {
                cloneEofs.add(eof.cloneExportedFields(exportConfiguration));
            }
            clone.setListEof(cloneEofs);
        }

        // Clone des RTP
        if (getListRtp() != null && !getListRtp().isEmpty()) {
            ArrayList<Rtp> cloneRtps = new ArrayList<Rtp>();
            for (Rtp rtp : getListRtp()) {
                cloneRtps.add(rtp.cloneExportedFields(exportConfiguration));
            }
            clone.setListRtp(cloneRtps);
        }

        // Clone des LAN
        if (getListLan() != null && !getListLan().isEmpty()) {
            ArrayList<Lan> cloneLans = new ArrayList<Lan>();
            for (Lan lan : getListLan()) {
                cloneLans.add(lan.cloneExportedFields(exportConfiguration));
            }
            clone.setListLan(cloneLans);
        }

        // La balise ELOG n'est présente dans les réponses que si les extensions françaises 
        // sont demandées et si la taille du TN est de 8, en effet, les messages V1 ont pour 
        // TN le ersGroupeLb qui a une taille supérieure à 8 et ne serait donc pas valide
        // par rapport au xsd
        if (exportConfiguration.isExtensionsFrancaises() && getElog() != null
                && getElog().getElogTnLb() != null
                && getElog().getElogTnOrigLb().length() == Constant.ELOG_TN_LB_LENGTH) {
            clone.setElog(getElog().cloneExportedFields(exportConfiguration));
        } else {
            clone.setElog(null);
        }

        return clone;
    }

    /**
     * Retourne tous les événements de pêche, en incluant les COE et COX fils de
     * TRZ et CRO.
     *
     * @return the evts les événements de pêche
     */
    public List<? extends EvenementDePeche> getEvts() {
        return getEvts(true);
    }

    /**
     * Retourne tous les événements de pêche, en incluant ou non les COE et COX
     * qui ne sont pas directement sous LOG.
     *
     * @param includeAllCoesAndCox si <code>true</code>, tous les COE et COX
     * sont retournés, même ceux qui ne sont pas directement fils de LOG (c-a-d
     * les fils COE et COX des TRZ et CRO sont inclus). Si <code>false<code>, seuls les COE et COX qui sont directement sous
     * LOG sont inclus.
     *
     * @return the evts les événements de pêche
     */
    @SuppressWarnings("unchecked")
    public List<? extends EvenementDePeche> getEvts(boolean includeAllCoesAndCox) {
        List evts = new ArrayList();
        if (getDep() != null) {
            evts.add(getDep());
        }
        if (getListFar() != null && !getListFar().isEmpty()) {
            evts.addAll(getListFar());
        }
        if (getListRlc() != null && !getListRlc().isEmpty()) {
            evts.addAll(getListRlc());
        }

        if (getListCoe() != null && !getListCoe().isEmpty()) {
            if (includeAllCoesAndCox) {
                evts.addAll(getListCoe());
            } else {
                for (Coe coe : getListCoe()) {
                    if (isCoeInLog(coe)) {
                        evts.add(coe);
                    }
                }
            }
        }
        if (getListCox() != null && !getListCox().isEmpty()) {
            if (includeAllCoesAndCox) {
                evts.addAll(getListCox());
            } else {
                for (Cox cox : getListCox()) {
                    if (isCoxInLog(cox)) {
                        evts.add(cox);
                    }
                }
            }
        }
        if (getListCro() != null && !getListCro().isEmpty()) {
            evts.addAll(getListCro());
        }
        if (getListTrz() != null && !getListTrz().isEmpty()) {
            evts.addAll(getListTrz());
        }
        if (getListDis() != null && !getListDis().isEmpty()) {
            evts.addAll(getListDis());
        }

        if (getElog() != null && getElog().getListEcps() != null && !getElog().getListEcps().isEmpty()) {
            evts.addAll(getElog().getListEcps());
        }

        if (getEof() != null) {
            evts.add(getEof());
        }

        if (getListIns() != null && !getListIns().isEmpty()) {
            evts.addAll(getListIns());
        }
        if (getPno() != null) {
            evts.add(getPno());
        }
        if (getPnt() != null) {
            evts.add(getPnt());
        }
        if (getRtp() != null) {
            evts.add(getRtp());
        }
        if (getLan() != null) {
            evts.add(getLan());
        }
        if (getListTra() != null && !getListTra().isEmpty()) {
            evts.addAll(getListTra());
        }
        return evts;
    }

    /**
     * Indique si un COE est associé directement à ce LOG et pas à l'un de ses
     * éventuels CRO ou TRZ
     *
     * @param coe
     * @return
     */
    public boolean isCoeInLog(Coe coe) {
        if (getListCoe() == null || getListCoe().isEmpty() || !getListCoe().contains(coe)) {
            return false;
        }

        // on vérifie si le coe appartient à un CRO
        if (getListCro() != null) {
            for (Cro cro : getListCro()) {
                if (coe == cro.getCoe()) {
                    return false;
                }
            }
        }

        // on vérifie si le coe appartient à un TRZ
        if (getListTrz() != null) {
            for (Trz trz : getListTrz()) {
                if (coe == trz.getCoe()) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Indique si un COX est associé directement à ce LOG et pas à l'un de ses
     * éventuels CRO ou TRZ
     *
     * @param coe
     * @return
     */
    public boolean isCoxInLog(Cox cox) {
        if (getListCox() == null || getListCox().isEmpty() || !getListCox().contains(cox)) {
            return false;
        }

        // on vérifie si le cox appartient à un CRO
        if (getListCro() != null) {
            for (Cro cro : getListCro()) {
                if (cox == cro.getCox()) {
                    return false;
                }
            }
        }

        // on vérifie si le cox appartient à un TRZ
        if (getListTrz() != null) {
            for (Trz trz : getListTrz()) {
                if (cox == trz.getCox()) {
                    return false;
                }
            }
        }

        return true;
    }
}
