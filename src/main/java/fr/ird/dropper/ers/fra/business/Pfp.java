package fr.ird.dropper.ers.fra.business;

import fr.ird.dropper.ers.fra.business.*;
import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.util.ArrayList;

/**
 * Navire donneur.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("PFP")
public class Pfp implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long pfpCdn;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("IR")
    private String pfpIrLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("RC")
    private String pfpRcLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("XR")
    private String pfpXrLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("FS")
    private String pfpFsLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("NA")
    private String pfpNaLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("MA")
    private String pfpMaLb;

    /**
     * persistent field
     */
    @XStreamOmitField
    private Log log;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Far> listFar;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Don> listDon;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Rec> listRec;

    public Long getPfpCdn() {
        return pfpCdn;
    }

    public void setPfpCdn(Long pfpCdn) {
        this.pfpCdn = pfpCdn;
    }

    public String getPfpIrLb() {
        return pfpIrLb;
    }

    public void setPfpIrLb(String pfpIrLb) {
        this.pfpIrLb = pfpIrLb;
    }

    public String getPfpRcLb() {
        return pfpRcLb;
    }

    public void setPfpRcLb(String pfpRcLb) {
        this.pfpRcLb = pfpRcLb;
    }

    public String getPfpXrLb() {
        return pfpXrLb;
    }

    public void setPfpXrLb(String pfpXrLb) {
        this.pfpXrLb = pfpXrLb;
    }

    public String getPfpFsLb() {
        return pfpFsLb;
    }

    public void setPfpFsLb(String pfpFsLb) {
        this.pfpFsLb = pfpFsLb;
    }

    public String getPfpNaLb() {
        return pfpNaLb;
    }

    public void setPfpNaLb(String pfpNaLb) {
        this.pfpNaLb = pfpNaLb;
    }

    public String getPfpMaLb() {
        return pfpMaLb;
    }

    public void setPfpMaLb(String pfpMaLb) {
        this.pfpMaLb = pfpMaLb;
    }

    public Log getLog() {
        return log;
    }

    public void setLog(Log log) {
        this.log = log;
    }

    public List<Far> getListFar() {        if (listFar == null) {
            listFar = new ArrayList<>();
        }
        return listFar;
    }

    public void setListFar(List<Far> listFar) {
        this.listFar = listFar;
    }

    public List<Don> getListDon() {
        return listDon;
    }

    public void setListDon(List<Don> listDon) {
        this.listDon = listDon;
    }

    public List<Rec> getListRec() {
        return listRec;
    }

    public void setListRec(List<Rec> listRec) {
        this.listRec = listRec;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getPfpCdn();
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
        if (!(other instanceof Pfp)) {
            return false;
        }
        Pfp castOther = (Pfp) other;
        return new EqualsBuilder().append(this.getPfpCdn(),
                castOther.getPfpCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getPfpCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return pfpCdn;
    }

    /**
     * On va remplir les champs non présents dans le XML reçu. Cette méthode est
     * appelée automatiquement par XStream après la création de l'objet (PFP).
     *
     * @return this
     */
    private Object readResolve() {
        return this;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichier XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peut être exporté par XStream
     */
    public Pfp cloneExportedFields(IExportConfiguration exportConfiguration) {
        Pfp clone = new Pfp();

        clone.setPfpIrLb(getPfpIrLb());
        clone.setPfpRcLb(getPfpRcLb());
        clone.setPfpXrLb(getPfpXrLb());
        clone.setPfpFsLb(getPfpFsLb());
        clone.setPfpNaLb(getPfpNaLb());
        clone.setPfpMaLb(getPfpMaLb());

        return clone;
    }
}
