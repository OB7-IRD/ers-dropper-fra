package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Autre navire de pêche lié à la marée.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("CVO")
public class Cvo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long cvoCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("NA")
    private String cvoNaLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("IN")
    private String cvoInLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("IM")
    private String cvoImLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("IR")
    private String cvoIrLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("RC")
    private String cvoRcLb;

    /**
     * persistent field
     */
    @XStreamOmitField
    private Far far;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "SPE")
    private List<Spe> listSpe;

    public Long getCvoCdn() {
        return this.cvoCdn;
    }

    public void setCvoCdn(Long cvoCdn) {
        this.cvoCdn = cvoCdn;
    }

    public String getCvoNaLb() {
        return this.cvoNaLb;
    }

    public void setCvoNaLb(String cvoNaLb) {
        this.cvoNaLb = cvoNaLb;
    }

    public String getCvoInLb() {
        return this.cvoInLb;
    }

    public void setCvoInLb(String cvoInLb) {
        this.cvoInLb = cvoInLb;
    }

    public String getCvoImLb() {
        return this.cvoImLb;
    }

    public void setCvoImLb(String cvoImLb) {
        this.cvoImLb = cvoImLb;
    }

    public String getCvoIrLb() {
        return this.cvoIrLb;
    }

    public void setCvoIrLb(String cvoIrLb) {
        this.cvoIrLb = cvoIrLb;
    }

    public String getCvoRcLb() {
        return this.cvoRcLb;
    }

    public void setCvoRcLb(String cvoRcLb) {
        this.cvoRcLb = cvoRcLb;
    }

    public Far getFar() {
        return far;
    }

    public void setFar(Far far) {
        this.far = far;
    }

    public List<Spe> getListSpe() {
        if (listSpe == null) {
            listSpe = new ArrayList<>();
        }
        return this.listSpe;
    }

    public void setListSpe(List<Spe> listSpe) {
        this.listSpe = listSpe;
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getCvoCdn();
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if (!(other instanceof Cvo)) {
            return false;
        }
        Cvo castOther = (Cvo) other;
        return new EqualsBuilder().append(this.getCvoCdn(),
                castOther.getCvoCdn()).isEquals();
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getCvoCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return cvoCdn;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichier XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peut être exporté par XStream
     */
    public Cvo cloneExportedFields(IExportConfiguration exportConfiguration) {
        Cvo clone = new Cvo();

        clone.setCvoNaLb(getCvoNaLb());
        clone.setCvoInLb(getCvoInLb());
        clone.setCvoImLb(getCvoImLb());
        clone.setCvoIrLb(getCvoIrLb());
        clone.setCvoRcLb(getCvoRcLb());

        // Clone des SPE
        if (getListSpe() != null && !getListSpe().isEmpty()) {
            ArrayList<Spe> cloneSpes = new ArrayList<Spe>();
            for (Spe spe : getListSpe()) {
                cloneSpes.add(spe.cloneExportedFields(exportConfiguration));
            }
            clone.setListSpe(cloneSpes);
        }

        return clone;
    }
}
