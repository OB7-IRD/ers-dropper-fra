package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import fr.ird.dropper.ers.fra.xstreamconverters.DateConverter;

/**
 * Matériel perdu.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("GLS")
public class Gls implements Serializable {

    private static final long serialVersionUID = -6658006402196308635L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long glsCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("DA")
    @XStreamConverter(DateConverter.class)
    private Date glsDaDt;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("TI")
    private String glsTiLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("NN")
    private int glsNnNb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("MG")
    private String glsMgLb;

    /**
     * nullable persistent field
     */
    @XStreamOmitField
    private Date glsDatiDt;

    /**
     * persistent field
     */
    @XStreamAlias("POS")
    private Pos pos;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Far> fars;

    public Long getGlsCdn() {
        return this.glsCdn;
    }

    public void setGlsCdn(Long glsCdn) {
        this.glsCdn = glsCdn;
    }

    public Date getGlsDaDt() {
        return this.glsDaDt;
    }

    public void setGlsDaDt(Date glsDaDt) {
        this.glsDaDt = glsDaDt;
    }

    public String getGlsTiLb() {
        return glsTiLb;
    }

    public void setGlsTiLb(String glsTiLb) {
        this.glsTiLb = glsTiLb;
    }

    public int getGlsNnNb() {
        return this.glsNnNb;
    }

    public void setGlsNnNb(int glsNnNb) {
        this.glsNnNb = glsNnNb;
    }

    public String getGlsMgLb() {
        return this.glsMgLb;
    }

    public void setGlsMgLb(String glsMgLb) {
        this.glsMgLb = glsMgLb;
    }

    public Date getGlsDatiDt() {
        return this.glsDatiDt;
    }

    public void setGlsDatiDt(Date glsDatiDt) {
        this.glsDatiDt = glsDatiDt;
    }

    public Pos getPos() {
        return this.pos;
    }

    public void setPos(Pos pos) {
        this.pos = pos;
    }

    public List<Far> getFars() {
        return this.fars;
    }

    public void setFars(List<Far> fars) {
        this.fars = fars;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getGlsCdn();
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
        if (!(other instanceof Gls)) {
            return false;
        }
        Gls castOther = (Gls) other;
        return new EqualsBuilder().append(this.getGlsCdn(),
                castOther.getGlsCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getGlsCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return glsCdn;
    }

    /**
     * On va remplir les champs non présents dans le XML reçu. Cette méthode est
     * appelée automatiquement par XStream après la création de l'objet (ECPS).
     *
     * @return this
     */
    private Object readResolve() {
        // On crée l'attribut glsDatiDt (date/heure) qui est une concaténation
        // des attributs glsDaDt (date) et glsTiLb (heure)
        DateConverter converter = new DateConverter();
        String dateHeure = converter.toDateTimeString(getGlsDaDt()) + " "
                + getGlsTiLb();
        Date glsDatiDt = (Date) converter.fromDateTimeString(dateHeure);
        setGlsDatiDt(glsDatiDt);
        return this;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichier XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peut être exporté par XStream
     */
    public Gls cloneExportedFields(IExportConfiguration exportConfiguration) {
        Gls clone = new Gls();

        clone.setGlsDaDt(getGlsDaDt());
        clone.setGlsTiLb(getGlsTiLb());
        clone.setGlsNnNb(getGlsNnNb());
        clone.setGlsMgLb(getGlsMgLb());

        Pos pos = getPos();
        if (pos != null) {
            clone.setPos(pos.cloneExportedFields(exportConfiguration));
        } else {
            clone.setPos(null);
        }
        return clone;
    }
}
