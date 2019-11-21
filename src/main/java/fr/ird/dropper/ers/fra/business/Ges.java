package fr.ird.dropper.ers.fra.business;

import fr.ird.dropper.ers.fra.business.*;
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
 * Matériel lancé à la mer.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("GES")
public class Ges implements Serializable {

    private static final long serialVersionUID = 1823192993237209985L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long gesCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("DA")
    @XStreamConverter(DateConverter.class)
    private Date gesDaDt;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("TI")
    private String gesTiLb;

    /**
     * nullable persistent field
     */
    @XStreamOmitField
    private Date gesDatiDt;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("GS")
    private String gesGsLb;

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

    public Long getGesCdn() {
        return this.gesCdn;
    }

    public void setGesCdn(Long gesCdn) {
        this.gesCdn = gesCdn;
    }

    public Date getGesDaDt() {
        return this.gesDaDt;
    }

    public void setGesDaDt(Date gesDaDt) {
        this.gesDaDt = gesDaDt;
    }

    public String getGesTiLb() {
        return this.gesTiLb;
    }

    public void setGesTiLb(String gesTiLb) {
        this.gesTiLb = gesTiLb;
    }

    public Date getGesDatiDt() {
        return this.gesDatiDt;
    }

    public void setGesDatiDt(Date gesDatiDt) {
        this.gesDatiDt = gesDatiDt;
    }

    public String getGesGsLb() {
        return this.gesGsLb;
    }

    public void setGesGsLb(String gesGsLb) {
        this.gesGsLb = gesGsLb;
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

    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getGesCdn();
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if (!(other instanceof Ges)) {
            return false;
        }
        Ges castOther = (Ges) other;
        return new EqualsBuilder().append(this.getGesCdn(),
                castOther.getGesCdn()).isEquals();
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getGesCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return gesCdn;
    }

    /**
     * On va remplir les champs non présents dans le XML reçu. Cette méthode est
     * appelée automatiquement par XStream après la création de l'objet (GES)
     *
     * @return this
     */
    private Object readResolve() {
        // On crée l'attribut gesDatiDt (date/heure) qui est une concaténation
        // des attributs gesDaDt (date) et gesTiLb (heure)
        DateConverter convester = new DateConverter();
        String dateHeure = convester.toString(getGesDaDt()) + " "
                + getGesTiLb();
        Date gesDatiDt = (Date) convester.fromDateTimeString(dateHeure);
        setGesDatiDt(gesDatiDt);
        return this;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichie XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peur être exporté par XStream
     */
    public Ges cloneExportedFields(IExportConfiguration exportConfiguration) {
        Ges clone = new Ges();

        clone.setGesDaDt(getGesDaDt());
        clone.setGesTiLb(getGesTiLb());
        clone.setGesGsLb(getGesGsLb());

        clone.setPos(getPos() == null ? null : getPos().cloneExportedFields(exportConfiguration));

        return clone;
    }
}
