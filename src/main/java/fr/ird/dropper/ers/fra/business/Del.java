package fr.ird.dropper.ers.fra.business;

import fr.ird.dropper.ers.fra.business.*;
import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Message de suppression.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("DEL")
public class Del implements Serializable {

    private static final long serialVersionUID = -829488799851104810L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long delCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("RN")
    private String delRnLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("RE")
    private String delReLb;

    /**
     * persistent field
     */
    @XStreamOmitField
    private Ers ers;

    /**
     * persistent field
     */
    @XStreamOmitField
    private Ops ops;

    public Long getDelCdn() {
        return this.delCdn;
    }

    public void setDelCdn(Long delCdn) {
        this.delCdn = delCdn;
    }

    public String getDelRnLb() {
        return this.delRnLb;
    }

    public void setDelRnLb(String delRnLb) {
        this.delRnLb = delRnLb;
    }

    public String getDelReLb() {
        return this.delReLb;
    }

    public void setDelReLb(String delReLb) {
        this.delReLb = delReLb;
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

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getDelCdn();
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
        if (!(other instanceof Del)) {
            return false;
        }
        Del castOther = (Del) other;
        return new EqualsBuilder().append(this.getDelCdn(),
                castOther.getDelCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getDelCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return delCdn;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichier XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peut être exporté par XStream
     */
    public Del cloneExportedFields(IExportConfiguration exportConfiguration) {
        Del clone = new Del();

        clone.setDelRnLb(getDelRnLb());
        clone.setDelReLb(getDelReLb());

        return clone;
    }
}
