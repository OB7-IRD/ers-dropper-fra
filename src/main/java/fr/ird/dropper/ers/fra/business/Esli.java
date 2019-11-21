package fr.ird.dropper.ers.fra.business;

import fr.ird.dropper.ers.fra.business.*;
import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Extension (précision) de la ligne de vente.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("ESLI")
public class Esli implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long esliCdn;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("BI")
    private String esliBiLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("BY")
    private String esliByLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("SI")
    private String esliSiLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("SY")
    private String esliSyLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("TI")
    private String esliTiLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("type")
    private String esliTypeLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("LO")
    private String esliLoNb;

    /**
     * persistent field
     */
    @XStreamOmitField
    private Sli sli;

    public Long getEsliCdn() {
        return this.esliCdn;
    }

    public void setEsliCdn(Long esliCdn) {
        this.esliCdn = esliCdn;
    }

    public String getEsliBiLb() {
        return this.esliBiLb;
    }

    public void setEsliBiLb(String esliBiLb) {
        this.esliBiLb = esliBiLb;
    }

    public String getEsliByLb() {
        return this.esliByLb;
    }

    public void setEsliByLb(String esliByLb) {
        this.esliByLb = esliByLb;
    }

    public String getEsliSiLb() {
        return this.esliSiLb;
    }

    public void setEsliSiLb(String esliSiLb) {
        this.esliSiLb = esliSiLb;
    }

    public String getEsliSyLb() {
        return this.esliSyLb;
    }

    public void setEsliSyLb(String esliSyLb) {
        this.esliSyLb = esliSyLb;
    }

    public String getEsliTiLb() {
        return this.esliTiLb;
    }

    public void setEsliTiLb(String esliTiLb) {
        this.esliTiLb = esliTiLb;
    }

    public String getEsliTypeLb() {
        return this.esliTypeLb;
    }

    public void setEsliTypeLb(String esliTypeLb) {
        this.esliTypeLb = esliTypeLb;
    }

    public String getEsliLoNb() {
        return this.esliLoNb;
    }

    public void setEsliLoNb(String esliLoNb) {
        this.esliLoNb = esliLoNb;
    }

    public Sli getSli() {
        return this.sli;
    }

    public void setSli(Sli sli) {
        this.sli = sli;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getEsliCdn();
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
        if (!(other instanceof Esli)) {
            return false;
        }
        Esli castOther = (Esli) other;
        return new EqualsBuilder().append(this.getEsliCdn(),
                castOther.getEsliCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getEsliCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return esliCdn;
    }

    /**
     * On va remplir les champs non présents dans le XML reçu. Cette méthode est
     * appelée automatiquement par XStream après la création de l'objet (ESLI).
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
    public Esli cloneExportedFields(IExportConfiguration exportConfiguration) {
        Esli clone = new Esli();

        clone.setEsliTypeLb(getEsliTypeLb());
        clone.setEsliBiLb(getEsliBiLb());
        clone.setEsliByLb(getEsliByLb());
        clone.setEsliSiLb(getEsliSiLb());
        clone.setEsliSyLb(getEsliSyLb());
        clone.setEsliTiLb(getEsliTiLb());
        clone.setEsliLoNb(getEsliLoNb());

        return clone;
    }
}
