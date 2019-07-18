package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import fr.ird.dropper.ers.fra.xstreamconverters.DateConverter;

/**
 * Sous déclaration des captures pour les espèces "JFO" (Raja hollandi).
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("JCI")
public class Jci implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long jciCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("DA")
    @XStreamConverter(DateConverter.class)
    private Date jciDaDt;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("TI")
    private String jciTiLb;

    /**
     * persistent field
     */
    @XStreamOmitField
    private Date jciDatiDt;

    /**
     * persistent field
     */
    @XStreamAlias("POS")
    private Pos pos;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Far> listFar;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "SPE")
    private List<Spe> listSpe;

    public Long getJciCdn() {
        return jciCdn;
    }

    public void setJciCdn(Long jciCdn) {
        this.jciCdn = jciCdn;
    }

    public Date getJciDaDt() {
        return jciDaDt;
    }

    public void setJciDaDt(Date jciDaDt) {
        this.jciDaDt = jciDaDt;
    }

    public String getJciTiLb() {
        return jciTiLb;
    }

    public void setJciTiLb(String jciTiLb) {
        this.jciTiLb = jciTiLb;
    }

    public Date getJciDatiDt() {
        return jciDatiDt;
    }

    public void setJciDatiDt(Date jciDatiDt) {
        this.jciDatiDt = jciDatiDt;
    }

    public Pos getPos() {
        return pos;
    }

    public void setPos(Pos pos) {
        this.pos = pos;
    }

    public List<Far> getListFar() {
        if (listFar == null) {
            listFar = new ArrayList<>();
        }
        return listFar;
    }

    public void setListFar(List<Far> listFar) {
        this.listFar = listFar;
    }

    public List<Spe> getListSpe() {
        if (listSpe == null) {
            listSpe = new ArrayList<>();
        }
        return listSpe;
    }

    public void setListSpe(List<Spe> listSpe) {
        this.listSpe = listSpe;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getJciCdn();
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
        if (!(other instanceof Jci)) {
            return false;
        }
        Jci castOther = (Jci) other;
        return new EqualsBuilder().append(this.getJciCdn(),
                castOther.getJciCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getJciCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return jciCdn;
    }

    /**
     * On va remplir les champs non présents dans le XML reçu. Cette méthode est
     * appelée automatiquement par XStream après la création de l'objet (JCI).
     *
     * @return this
     */
    private Object readResolve() {
        // On crée l'attribut depDatiDt (date/heure) qui est une concaténation
        // des attributs jciDaDt (date) et jciTiLb (heure)
        DateConverter converter = new DateConverter();
        String dateHeure = converter.toString(getJciDaDt()) + " "
                + getJciTiLb();
        Date datiDt = (Date) converter.fromDateTimeString(dateHeure);
        setJciDatiDt(datiDt);
        return this;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichier XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peut être exporté par XStream
     */
    public Jci cloneExportedFields(IExportConfiguration exportConfiguration) {
        Jci clone = new Jci();

        clone.setJciDaDt(getJciDaDt());
        clone.setJciTiLb(getJciTiLb());

        clone.setPos(getPos() == null ? null : getPos().cloneExportedFields(exportConfiguration));

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
