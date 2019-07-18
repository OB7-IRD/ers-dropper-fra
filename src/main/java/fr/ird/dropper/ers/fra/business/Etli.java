package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Extension (précision) de la prise de contrôle en ligne.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("ETLI")
public class Etli implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long etliCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("type")
    private String etliTypeLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("OY")
    private String etliOyLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("OI")
    private String etliOiLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("IY")
    private String etliIyLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("II")
    private String etliIiLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("TI")
    private String etliTiLb;

    /**
     * persistent field
     */
    @XStreamOmitField
    private Tli Tli;

    public Long getEtliCdn() {
        return this.etliCdn;
    }

    public void setEtliCdn(Long etliCdn) {
        this.etliCdn = etliCdn;
    }

    public String getEtliTypeLb() {
        return this.etliTypeLb;
    }

    public void setEtliTypeLb(String etliTypeLb) {
        this.etliTypeLb = etliTypeLb;
    }

    public String getEtliOyLb() {
        return this.etliOyLb;
    }

    public void setEtliOyLb(String etliOyLb) {
        this.etliOyLb = etliOyLb;
    }

    public String getEtliOiLb() {
        return this.etliOiLb;
    }

    public void setEtliOiLb(String etliOiLb) {
        this.etliOiLb = etliOiLb;
    }

    public String getEtliIyLb() {
        return this.etliIyLb;
    }

    public void setEtliIyLb(String etliIyLb) {
        this.etliIyLb = etliIyLb;
    }

    public String getEtliIiLb() {
        return this.etliIiLb;
    }

    public void setEtliIiLb(String etliIiLb) {
        this.etliIiLb = etliIiLb;
    }

    public String getEtliTiLb() {
        return this.etliTiLb;
    }

    public void setEtliTiLb(String etliTiLb) {
        this.etliTiLb = etliTiLb;
    }

    public Tli getTli() {
        return this.Tli;
    }

    public void setTli(Tli tli) {
        Tli = tli;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getEtliCdn();
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
        if (!(other instanceof Etli)) {
            return false;
        }
        Etli castOther = (Etli) other;
        return new EqualsBuilder().append(this.getEtliCdn(),
                castOther.getEtliCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getEtliCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return etliCdn;
    }

    /**
     * On va remplir les champs non présents dans le XML reçu. Cette méthode est
     * appelée automatiquement par XStream après la création de l'objet (ETLI).
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
    public Etli cloneExportedFields(IExportConfiguration exportConfiguration) {
        Etli clone = new Etli();

        clone.setEtliTypeLb(getEtliTypeLb());
        clone.setEtliOyLb(getEtliOyLb());
        clone.setEtliOiLb(getEtliOiLb());
        clone.setEtliIyLb(getEtliIyLb());
        clone.setEtliIiLb(getEtliIiLb());
        clone.setEtliTiLb(getEtliTiLb());

        return clone;
    }
}
