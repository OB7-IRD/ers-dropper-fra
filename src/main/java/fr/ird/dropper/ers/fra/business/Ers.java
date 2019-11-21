package fr.ird.dropper.ers.fra.business;

import fr.ird.dropper.ers.fra.business.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import fr.ird.dropper.ers.fra.xstreamconverters.DateConverter;

/**
 * Journal de bord électronique.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("ERS")
public class Ers implements Serializable {

    private static final long serialVersionUID = 8205876309683149078L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long ersCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("RN")
    private String ersRnLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("RD")
    @XStreamConverter(DateConverter.class)
    private Date ersRdDt;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("RT")
    private String ersRtLb;

    /**
     * nullable persistent field
     */
    @XStreamOmitField
    private Date ersRdtDt;

    /**
     * persistent field
     */
    @XStreamOmitField
    private Date ersCreationDt;

    /**
     * nullable persistent field
     */
    @XStreamOmitField
    private Date ersModificationDt;

    /**
     * persistent field
     */
    @XStreamOmitField
    private String ersTypeLb;

    /**
     * persistent field
     */
    @XStreamOmitField
    private transient String ersGroupeLb;

    /**
     * nullable persistent field
     */
    @XStreamOmitField
    private String ersFrRnLb;

    /**
     * nullable persistent field
     */
    @XStreamOmitField
    private List<Dat> dats;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "SAL")
    private List<Sal> sals;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Cor> cors;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Rsp> listRsp;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "LOG")
    private List<Log> logs;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Del> dels;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "TRN")
    private List<Trn> trns;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Ret> rets;

    public Long getErsCdn() {
        return this.ersCdn;
    }

    public void setErsCdn(Long ersCdn) {
        this.ersCdn = ersCdn;
    }

    public String getErsRnLb() {
        return this.ersRnLb;
    }

    public void setErsRnLb(String ersRnLb) {
        this.ersRnLb = ersRnLb;
    }

    public Date getErsRdDt() {
        return this.ersRdDt;
    }

    public void setErsRdDt(Date ersRdDt) {
        this.ersRdDt = ersRdDt;
    }

    public String getErsRtLb() {
        return this.ersRtLb;
    }

    public void setErsRtLb(String ersRtLb) {
        this.ersRtLb = ersRtLb;
    }

    public Date getErsRdtDt() {
        return this.ersRdtDt;
    }

    public void setErsRdtDt(Date ersRdtDt) {
        this.ersRdtDt = ersRdtDt;
    }

    public Date getErsCreationDt() {
        return this.ersCreationDt;
    }

    public void setErsCreationDt(Date ersCreationDt) {
        this.ersCreationDt = ersCreationDt;
    }

    public Date getErsModificationDt() {
        return this.ersModificationDt;
    }

    public void setErsModificationDt(Date ersModificationDt) {
        this.ersModificationDt = ersModificationDt;
    }

    public String getErsTypeLb() {
        return this.ersTypeLb;
    }

    public void setErsTypeLb(String ersTypeLb) {
        this.ersTypeLb = ersTypeLb;
    }

    public String getErsGroupeLb() {
        return this.ersGroupeLb;
    }

    public void setErsGroupeLb(String ersGroupeLb) {
        this.ersGroupeLb = ersGroupeLb;
    }

    public String getErsFrRnLb() {
        return this.ersFrRnLb;
    }

    public void setErsFrRnLb(String ersFrRnLb) {
        this.ersFrRnLb = ersFrRnLb;
    }

    public List<Dat> getDats() {
        return this.dats;
    }

    public void setDats(List<Dat> dats) {
        this.dats = dats;
    }

    public Sal getSal() {
        if (getSals() == null || getSals().isEmpty()) {
            return null;
        } else {
            return getSals().get(0);
        }
    }

    public List<Sal> getSals() {
        return this.sals;
    }

    public void setSals(List<Sal> sals) {
        this.sals = sals;
    }

    public List<Cor> getCors() {
        return this.cors;
    }

    public void setCors(List<Cor> cors) {
        this.cors = cors;
    }

    public List<Rsp> getListRsp() {
        if (listRsp == null) {
            listRsp = new ArrayList<>();
        }
        return this.listRsp;
    }

    public void setListRsp(List<Rsp> listRsp) {
        this.listRsp = listRsp;
    }

    public Log getLog() {
        if (getLogs() == null || getLogs().isEmpty()) {
            return null;
        } else {
            return getLogs().get(0);
        }
    }

    public List<Log> getLogs() {
        return this.logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }

    public List<Del> getDels() {
        return this.dels;
    }

    public void setDels(List<Del> dels) {
        this.dels = dels;
    }

    public List<Trn> getTrns() {
        return this.trns;
    }

    public Trn getTrn() {
        if (getTrns() == null || getTrns().isEmpty()) {
            return null;
        } else {
            return getTrns().get(0);
        }
    }

    public void setTrns(List<Trn> trns) {
        this.trns = trns;
    }

    public List<Ret> getRets() {
        return this.rets;
    }

    public void setRets(List<Ret> rets) {
        this.rets = rets;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getErsCdn();
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
        if (!(other instanceof Ers)) {
            return false;
        }
        Ers castOther = (Ers) other;
        return new EqualsBuilder().append(this.getErsCdn(),
                castOther.getErsCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getErsCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return ersCdn;
    }

    /**
     * On va remplir les champs non présents dans le XML reçu. Cette méthode est
     * appelée automatiquement par XStream après la création de l'objet (ERS).
     *
     * @return this
     */
    private Object readResolve() {
        // ERS01 : on met la date/heure courante pour le champs creationDt
        if (getErsCreationDt() == null) {
            setErsCreationDt(new Date());
        }

        // ERS02 : on met un type de message suivant la balise fille du fichier
        // XML
        if (getLog() != null) {
            setErsTypeLb("LOG");
        } else if (getSal() != null) {
            setErsTypeLb("SAL");
        } else {
            setErsTypeLb("TRN");
        }

        // ERS03 : on met null pour le champs modificationDt
        setErsModificationDt(null);

        // On crée l'attribut ersRdtDt (date/heure) qui est une concaténation
        // des attributs ersRdDt (date) et ersRtDt (heure)
        DateConverter converter = new DateConverter();
        String dateHeure = converter.toString(getErsRdDt()) + " "
                + getErsRtLb();
        Date ersRdtDt = (Date) converter.fromDateTimeString(dateHeure);
        setErsRdtDt(ersRdtDt);

        if (getErsGroupeLb() == null) {
            setErsGroupeLb(getErsRnLb());
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
    public Ers cloneExportedFields(IExportConfiguration exportConfiguration) {
        Ers clone = new Ers();

        clone.setErsRnLb(getErsRnLb());
        clone.setErsRdDt(getErsRdDt());
        clone.setErsRtLb(getErsRtLb());

        // Clone des LOG
        if (getLogs() != null && !getLogs().isEmpty()) {
            ArrayList<Log> cloneLogs = new ArrayList<Log>();
            for (Log log : getLogs()) {
                cloneLogs.add(log.cloneExportedFields(exportConfiguration));
            }
            clone.setLogs(cloneLogs);
        }

        // Clone des SAL
        if (getSals() != null && !getSals().isEmpty()) {
            ArrayList<Sal> cloneSals = new ArrayList<Sal>();
            for (Sal sal : getSals()) {
                cloneSals.add(sal.cloneExportedFields(exportConfiguration));
            }
            clone.setSals(cloneSals);
        }

        // Clone des TRN
        if (getTrns() != null && !getTrns().isEmpty()) {
            ArrayList<Trn> cloneTrns = new ArrayList<Trn>();
            for (Trn trn : getTrns()) {
                cloneTrns.add(trn.cloneExportedFields(exportConfiguration));
            }
            clone.setTrns(cloneTrns);
        }

        return clone;
    }
}
