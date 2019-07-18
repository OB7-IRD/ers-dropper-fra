package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Déploiement du filet de pêche.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("GIL")
public class Gil implements Serializable {

    private static final long serialVersionUID = -4309551906608817560L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long gilCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("NL")
    private int gilNlNb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("NN")
    private int gilNnNb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("FL")
    private int gilFlNb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("FD")
    private int gilFdNb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("ST")
    private int gilStNb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("GS")
    private String gilGsLb;

    /**
     * persistent field
     */
    @XStreamOmitField
    private Gea gea;

    /**
     * persistent field
     */
    @XStreamAlias("POS")
    private Pos pos;

    public Long getGilCdn() {
        return this.gilCdn;
    }

    public void setGilCdn(Long gilCdn) {
        this.gilCdn = gilCdn;
    }

    public int getGilNlNb() {
        return this.gilNlNb;
    }

    public void setGilNlNb(int gilNlNb) {
        this.gilNlNb = gilNlNb;
    }

    public int getGilNnNb() {
        return this.gilNnNb;
    }

    public void setGilNnNb(int gilNnNb) {
        this.gilNnNb = gilNnNb;
    }

    public int getGilFlNb() {
        return this.gilFlNb;
    }

    public void setGilFlNb(int gilFlNb) {
        this.gilFlNb = gilFlNb;
    }

    public int getGilFdNb() {
        return this.gilFdNb;
    }

    public void setGilFdNb(int gilFdNb) {
        this.gilFdNb = gilFdNb;
    }

    public int getGilStNb() {
        return this.gilStNb;
    }

    public void setGilStNb(int gilStNb) {
        this.gilStNb = gilStNb;
    }

    public String getGilGsLb() {
        return this.gilGsLb;
    }

    public void setGilGsLb(String gilGsLb) {
        this.gilGsLb = gilGsLb;
    }

    public Gea getGea() {
        return this.gea;
    }

    public void setGea(Gea gea) {
        this.gea = gea;
    }

    public Pos getPos() {
        return this.pos;
    }

    public void setPos(Pos pos) {
        this.pos = pos;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getGilCdn();
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
        if (!(other instanceof Gil)) {
            return false;
        }
        Gil castOther = (Gil) other;
        return new EqualsBuilder().append(this.getGilCdn(),
                castOther.getGilCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getGilCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return gilCdn;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichie XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peur être exporté par XStream
     */
    public Gil cloneExportedFields(IExportConfiguration exportConfiguration) {
        Gil clone = new Gil();

        clone.setGilNlNb(getGilNlNb());
        clone.setGilNnNb(getGilNnNb());
        clone.setGilFlNb(getGilFlNb());
        clone.setGilFdNb(getGilFdNb());
        clone.setGilStNb(getGilStNb());
        clone.setGilGsLb(getGilGsLb());

        clone.setPos(getPos() == null ? null : getPos().cloneExportedFields(exportConfiguration));

        return clone;
    }
}
