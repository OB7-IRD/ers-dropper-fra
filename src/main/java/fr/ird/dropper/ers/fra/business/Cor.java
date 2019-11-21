package fr.ird.dropper.ers.fra.business;

import fr.ird.dropper.ers.fra.business.*;
import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Message de correction.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("COR")
public class Cor implements Serializable {

    private static final long serialVersionUID = 100713332277381860L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long corCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("RN")
    private String corRnLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("RE")
    private String corReLb;

    /**
     * persistent field
     */
    @XStreamAlias("ERS")
    private Ers ers;

    /**
     * persistent field
     */
    @XStreamOmitField
    private Ops ops;

    public Long getCorCdn() {
        return this.corCdn;
    }

    public void setCorCdn(Long corCdn) {
        this.corCdn = corCdn;
    }

    public String getCorRnLb() {
        return this.corRnLb;
    }

    public void setCorRnLb(String corRnLb) {
        this.corRnLb = corRnLb;
    }

    public String getCorReLb() {
        return this.corReLb;
    }

    public void setCorReLb(String corReLb) {
        this.corReLb = corReLb;
    }

    public Ers getErs() {
        return this.ers;
    }

    public void setErs(Ers ers) {
        this.ers = ers;
    }

    public Ops getOps() {
        return this.ops;
    }

    public void setOps(Ops ops) {
        this.ops = ops;
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getCorCdn();
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if (!(other instanceof Cor)) {
            return false;
        }
        Cor castOther = (Cor) other;
        return new EqualsBuilder().append(this.getCorCdn(),
                castOther.getCorCdn()).isEquals();
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getCorCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return corCdn;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichier XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peut être exporté par XStream
     */
    public Cor cloneExportedFields(IExportConfiguration exportConfiguration) {
        Cor clone = new Cor();

        clone.setCorRnLb(getCorRnLb());
        clone.setCorReLb(getCorReLb());

        clone.setErs(getErs() == null ? null : getErs().cloneExportedFields(exportConfiguration));

        return clone;
    }
}
