package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import fr.ird.dropper.ers.fra.xstreamconverters.DateConverter;

/**
 * Message de requête.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("QUE")
public class Que implements Serializable {

    private static final long serialVersionUID = -6013095499737396163L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long queCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("CD")
    private String queCdLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("ID")
    private String queIdLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("IV")
    private String queIvLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("SD")
    @XStreamConverter(DateConverter.class)
    private Date queSdDt;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("ED")
    @XStreamConverter(DateConverter.class)
    private Date queEdDt;

    /**
     * persistent field
     */
    @XStreamOmitField
    private Ops ops;

    /**
     * persistent field
     */
    @XStreamOmitField
    private Ops opsByOpsCdnTransf;

    public Long getQueCdn() {
        return this.queCdn;
    }

    public void setQueCdn(Long queCdn) {
        this.queCdn = queCdn;
    }

    public String getQueCdLb() {
        return this.queCdLb;
    }

    public void setQueCdLb(String queCdLb) {
        this.queCdLb = queCdLb;
    }

    public String getQueIdLb() {
        return this.queIdLb;
    }

    public void setQueIdLb(String queIdLb) {
        this.queIdLb = queIdLb;
    }

    public String getQueIvLb() {
        return this.queIvLb;
    }

    public void setQueIvLb(String queIvLb) {
        this.queIvLb = queIvLb;
    }

    public Date getQueSdDt() {
        return this.queSdDt;
    }

    public void setQueSdDt(Date queSdDt) {
        this.queSdDt = queSdDt;
    }

    public Date getQueEdDt() {
        return this.queEdDt;
    }

    public void setQueEdDt(Date queEdDt) {
        this.queEdDt = queEdDt;
    }

    public Ops getOps() {
        return this.ops;
    }

    public void setOps(Ops ops) {
        this.ops = ops;
    }

    public Ops getOpsByOpsCdnTransf() {
        return this.opsByOpsCdnTransf;
    }

    public void setOpsByOpsCdnTransf(Ops opsByOpsCdnTransf) {
        this.opsByOpsCdnTransf = opsByOpsCdnTransf;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getQueCdn();
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
        if (!(other instanceof Que)) {
            return false;
        }
        Que castOther = (Que) other;
        return new EqualsBuilder().append(this.getQueCdn(),
                castOther.getQueCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getQueCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return queCdn;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichier XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peut être exporté par XStream
     */
    public Que cloneExportedFields(IExportConfiguration exportConfiguration) {
        Que clone = new Que();

        clone.setQueCdLb(getQueCdLb());
        clone.setQueIdLb(getQueIdLb());
        clone.setQueIvLb(getQueIvLb());
        clone.setQueSdDt(getQueSdDt());
        clone.setQueEdDt(getQueEdDt());

        return clone;
    }
}
