package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * La zone (en mer) concernée.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("RAS")
public class Ras implements Serializable {

    private static final long serialVersionUID = -7143572063069480483L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long rasCdn;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("FA")
    private String rasFaLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("SA")
    private String rasSaLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("ID")
    private String rasIdLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("SD")
    private String rasSdLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("UI")
    private String rasUiLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("EZ")
    private String rasEzLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("SR")
    private String rasSrLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("FE")
    private String rasFeLb;

    /**
     * persistent field
     */
    @XStreamAlias("ERAS")
    private Eras eras;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Tra> tras;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Far> fars;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Coe> coes;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Cox> coxs;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Pno> pnos;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Spe> spes;

    public Long getRasCdn() {
        return this.rasCdn;
    }

    public void setRasCdn(Long rasCdn) {
        this.rasCdn = rasCdn;
    }

    public String getRasFaLb() {
        return this.rasFaLb;
    }

    public void setRasFaLb(String rasFaLb) {
        this.rasFaLb = rasFaLb;
    }

    public String getRasSaLb() {
        return this.rasSaLb;
    }

    public void setRasSaLb(String rasSaLb) {
        this.rasSaLb = rasSaLb;
    }

    public String getRasIdLb() {
        return this.rasIdLb;
    }

    public void setRasIdLb(String rasIdLb) {
        this.rasIdLb = rasIdLb;
    }

    public String getRasSdLb() {
        return this.rasSdLb;
    }

    public void setRasSdLb(String rasSdLb) {
        this.rasSdLb = rasSdLb;
    }

    public String getRasUiLb() {
        return this.rasUiLb;
    }

    public void setRasUiLb(String rasUiLb) {
        this.rasUiLb = rasUiLb;
    }

    public String getRasEzLb() {
        return this.rasEzLb;
    }

    public void setRasEzLb(String rasEzLb) {
        this.rasEzLb = rasEzLb;
    }

    public String getRasSrLb() {
        return this.rasSrLb;
    }

    public void setRasSrLb(String rasSrLb) {
        this.rasSrLb = rasSrLb;
    }

    public String getRasFeLb() {
        return this.rasFeLb;
    }

    public void setRasFeLb(String rasFeLb) {
        this.rasFeLb = rasFeLb;
    }

    public Eras getEras() {
        return this.eras;
    }

    public void setEras(Eras eras) {
        this.eras = eras;
    }

    public List<Tra> getTras() {
        return this.tras;
    }

    public void setTras(List<Tra> tras) {
        this.tras = tras;
    }

    public List<Far> getFars() {
        return this.fars;
    }

    public void setFars(List<Far> fars) {
        this.fars = fars;
    }

    public List<Coe> getCoes() {
        return this.coes;
    }

    public void setCoes(List<Coe> coes) {
        this.coes = coes;
    }

    public List<Cox> getCoxs() {
        return this.coxs;
    }

    public void setCoxs(List<Cox> coxs) {
        this.coxs = coxs;
    }

    public List<Pno> getPnos() {
        return this.pnos;
    }

    public void setPnos(List<Pno> pnos) {
        this.pnos = pnos;
    }

    public List<Spe> getSpes() {
        return this.spes;
    }

    public void setSpes(List<Spe> spes) {
        this.spes = spes;
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getRasCdn();
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if (!(other instanceof Ras)) {
            return false;
        }
        Ras castOther = (Ras) other;
        return new EqualsBuilder().append(this.getRasCdn(),
                castOther.getRasCdn()).isEquals();
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getRasCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return rasCdn;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichier XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peut être exporté par XStream
     */
    public Ras cloneExportedFields(IExportConfiguration exportConfiguration) {
        Ras clone = new Ras();

        clone.setRasFaLb(getRasFaLb());
        clone.setRasSaLb(getRasSaLb());
        clone.setRasIdLb(getRasIdLb());
        clone.setRasSdLb(getRasSdLb());
        clone.setRasEzLb(getRasEzLb());
        clone.setRasSrLb(getRasSrLb());
        clone.setRasFeLb(getRasFeLb());

        if (exportConfiguration.isExtensionsFrancaises() && getEras() != null) {
            clone.setEras(getEras().cloneExportedFields(exportConfiguration));
        } else {
            clone.setEras(null);
        }

        return clone;
    }

    /**
     * Convert RAS variables to upper case
     */
    public void toUpperCase() {
        if (getRasFaLb() != null) {
            setRasFaLb(getRasFaLb().toUpperCase());
        }
        if (getRasSaLb() != null) {
            setRasSaLb(getRasSaLb());
        }
        if (getRasIdLb() != null) {
            setRasIdLb(getRasIdLb());
        }
        if (getRasSdLb() != null) {
            setRasSdLb(getRasSdLb());
        }
        if (getRasEzLb() != null) {
            setRasEzLb(getRasEzLb());
        }
        if (getRasSrLb() != null) {
            setRasSrLb(getRasSrLb());
        }
        if (getRasFeLb() != null) {
            setRasFeLb(getRasFeLb());
        }
    }

}
