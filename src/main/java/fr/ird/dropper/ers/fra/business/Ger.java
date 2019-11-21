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
 * Matériel récupéré.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("GER")
public class Ger implements Serializable {

    private static final long serialVersionUID = 5139161528539565976L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long gerCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("DA")
    @XStreamConverter(DateConverter.class)
    private Date gerDaDt;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("TI")
    private String gerTiLb;

    /**
     * nullable persistent field
     */
    @XStreamOmitField
    private Date gerDatiDt;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("GS")
    private String gerGsLb;

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

    /**
     * persistent field
     */
    @XStreamAlias("EGER")
    private Eger eger;

    public Long getGerCdn() {
        return this.gerCdn;
    }

    public void setGerCdn(Long gerCdn) {
        this.gerCdn = gerCdn;
    }

    public Date getGerDaDt() {
        return this.gerDaDt;
    }

    public void setGerDaDt(Date gerDaDt) {
        this.gerDaDt = gerDaDt;
    }

    public String getGerTiLb() {
        return this.gerTiLb;
    }

    public void setGerTiLb(String gerTiLb) {
        this.gerTiLb = gerTiLb;
    }

    public Date getGerDatiDt() {
        return this.gerDatiDt;
    }

    public void setGerDatiDt(Date gerDatiDt) {
        this.gerDatiDt = gerDatiDt;
    }

    public String getGerGsLb() {
        return this.gerGsLb;
    }

    public void setGerGsLb(String gerGsLb) {
        this.gerGsLb = gerGsLb;
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

    public Eger getEger() {
        return this.eger;
    }

    public void setEger(Eger eger) {
        this.eger = eger;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getGerCdn();
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
        if (!(other instanceof Ger)) {
            return false;
        }
        Ger castOther = (Ger) other;
        return new EqualsBuilder().append(this.getGerCdn(),
                castOther.getGerCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getGerCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return gerCdn;
    }

    /**
     * On va remplir les champs non présents dans le XML reçu. Cette méthode est
     * appelée automatiquement par XStream après la création de l'objet (GER)
     *
     * @return this
     */
    private Object readResolve() {
        // On crée l'attribut gerDatiDt (date/heure) qui est une concaténation
        // des attributs gerDaDt (date) et gerTiLb (heure)
        DateConverter converter = new DateConverter();
        String dateHeure = converter.toString(getGerDaDt()) + " "
                + getGerTiLb();
        Date gerDatiDt = (Date) converter.fromDateTimeString(dateHeure);
        setGerDatiDt(gerDatiDt);
        return this;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichier XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peut être exporté par XStream
     */
    public Ger cloneExportedFields(IExportConfiguration exportConfiguration) {
        Ger clone = new Ger();

        clone.setGerDaDt(getGerDaDt());
        clone.setGerTiLb(getGerTiLb());
        clone.setGerGsLb(getGerGsLb());

        clone.setPos(getPos() == null ? null : getPos().cloneExportedFields(exportConfiguration));

        Eger eger = getEger();
        if (exportConfiguration.isExtensionsFrancaises() && eger != null) {
            clone.setEger(eger.cloneExportedFields(exportConfiguration));
        } else {
            clone.setEger(null);
        }

        return clone;
    }
}
