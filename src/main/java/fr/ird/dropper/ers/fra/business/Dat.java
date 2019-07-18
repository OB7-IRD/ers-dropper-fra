package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Message de données.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("DAT")
public class Dat implements Serializable {

    private static final long serialVersionUID = 5481090138979968230L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long datCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("TM")
    private String datTmLb;

    /**
     * nullable persistent field
     */
    @XStreamAlias("ERS")
    private Ers ers;

    /**
     * persistent field
     */
    @XStreamOmitField
    private Ops ops;

    public Long getDatCdn() {
        return this.datCdn;
    }

    public void setDatCdn(Long datCdn) {
        this.datCdn = datCdn;
    }

    public String getDatTmLb() {
        return datTmLb;
    }

    public void setDatTmLb(String datTmLb) {
        this.datTmLb = datTmLb;
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
        return "" + getDatCdn();
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
        if (!(other instanceof Dat)) {
            return false;
        }
        Dat castOther = (Dat) other;
        return new EqualsBuilder().append(this.getDatCdn(),
                castOther.getDatCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getDatCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return datCdn;
    }

    /**
     * On va remplir les champs non présents dans le XML reçu. Cette méthode est
     * appelée automatiquement par XStream après la création de l'objet (DAT)
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
    public Dat cloneExportedFields(IExportConfiguration exportConfiguration) {
        Dat clone = new Dat();

        clone.setDatTmLb(getDatTmLb());
        clone.setErs(getErs() == null ? null : getErs().cloneExportedFields(exportConfiguration));

        return clone;
    }
}
