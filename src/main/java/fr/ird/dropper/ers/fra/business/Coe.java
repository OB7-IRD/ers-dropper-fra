package fr.ird.dropper.ers.fra.business;

import fr.ird.dropper.ers.fra.business.*;
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
 * Entrée dans une zone d'effort.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("COE")
public class Coe extends EvenementDePecheImpl {

    private static final long serialVersionUID = -6302744737711531450L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long coeCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("DA")
    @XStreamConverter(DateConverter.class)
    private Date coeDaDt;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("TI")
    private String coeTiLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("TS")
    private String coeTsLb;

    /**
     * nullable persistent field
     */
    @XStreamOmitField
    private Date coeDatiDt;

    /**
     * persistent field
     */
    @XStreamOmitField
    private Log log;

    /**
     * persistent field
     */
    @XStreamAlias("RAS")
    private Ras ras;

    /**
     * persistent field
     */
    @XStreamAlias("POS")
    private Pos pos;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "SPE")
    private List<Spe> listSpe;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Cro> listCro;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Trz> listTrz;

    public Long getCoeCdn() {
        return this.coeCdn;
    }

    public void setCoeCdn(Long coeCdn) {
        this.coeCdn = coeCdn;
    }

    public Date getCoeDaDt() {
        return this.coeDaDt;
    }

    public void setCoeDaDt(Date coeDaDt) {
        this.coeDaDt = coeDaDt;
    }

    public String getCoeTiLb() {
        return this.coeTiLb;
    }

    public void setCoeTiLb(String coeTiLb) {
        this.coeTiLb = coeTiLb;
    }

    public String getCoeTsLb() {
        return this.coeTsLb;
    }

    public void setCoeTsLb(String coeTsLb) {
        this.coeTsLb = coeTsLb;
    }

    public Date getCoeDatiDt() {
        return this.coeDatiDt;
    }

    public void setCoeDatiDt(Date coeDatiDt) {
        this.coeDatiDt = coeDatiDt;
    }

    /* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePecheImpl#getLog()
     */
    @Override
    public Log getLog() {
        return this.log;
    }

    public void setLog(Log log) {
        this.log = log;
    }

    public Ras getRas() {
        return this.ras;
    }

    public void setRas(Ras ras) {
        this.ras = ras;
    }

    public Pos getPos() {
        return this.pos;
    }

    public void setPos(Pos pos) {
        this.pos = pos;
    }

    public Cro getCro() {
        if (getListCro() == null || getListCro().isEmpty()) {
            return null;
        } else {
            return getListCro().get(0);
        }
    }

    public List<Cro> getListCro() {
        return this.listCro;
    }

    public void setListCro(List<Cro> listCro) {
        this.listCro = listCro;
    }

    public Trz getTrz() {
        if (getListTrz() == null || getListTrz().isEmpty()) {
            return null;
        } else {
            return getListTrz().get(0);
        }
    }

    public List<Trz> getListTrz() {
        if (listTrz == null) {
            listTrz = new ArrayList<>();
        }
        return this.listTrz;
    }

    public void setListTrz(List<Trz> listTrz) {
        this.listTrz = listTrz;
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

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getCoeCdn();
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
        if (!(other instanceof Coe)) {
            return false;
        }
        Coe castOther = (Coe) other;
        return new EqualsBuilder().append(this.getCoeCdn(),
                castOther.getCoeCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getCoeCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return coeCdn;
    }

    /**
     * On va remplir les champs non présents dans le XML reçu. Cette méthode est
     * appelée automatiquement par XStream après la création de l'objet (COE)
     *
     * @return this
     */
    private Object readResolve() {
        // On crée l'attribut coeDatiDt (date/heure) qui est une concaténation
        // des attributs coeDaDt (date) et coeTiLb (heure)
        DateConverter converter = new DateConverter();
        String dateHeure = converter.toString(getCoeDaDt()) + " "
                + getCoeTiLb();
        Date coeDatiDt = (Date) converter.fromDateTimeString(dateHeure);
        setCoeDatiDt(coeDatiDt);
        return this;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichier XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peut être exporté par XStream
     */
    public Coe cloneExportedFields(IExportConfiguration exportConfiguration) {
        Coe clone = new Coe();

        clone.setCoeDaDt(getCoeDaDt());
        clone.setCoeTiLb(getCoeTiLb());
        clone.setCoeTsLb(getCoeTsLb());

        clone.setPos(getPos() == null ? null : getPos().cloneExportedFields(exportConfiguration));

        Ras ras = getRas();
        if (ras != null) {
            clone.setRas(ras.cloneExportedFields(exportConfiguration));
        } else {
            clone.setRas(null);
        }

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

    /*
	 * (non-Javadoc)
	 * 
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getType()
     */
    public String getType() {
        return "COE";
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDatiDt()
     */
    public Date getDatiDt() {
        return getCoeDatiDt();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDaDt()
     */
    public Date getDaDt() {
        return getCoeDaDt();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.gouv.agriculture.adage.ers.business.EvenementDePecheImpl#getTiLb()
     */
    public String getTiLb() {
        return getCoeTiLb();
    }

    public void addToLog(Log log) {
        if (log.getListCoe() == null) {
            log.setListCoe(new ArrayList<Coe>());
        }
        log.getListCoe().add(this);
    }

    public List<Ras> getRasList() {
        List<Ras> listRas = new ArrayList<Ras>();
        if (getRas() != null) {
            listRas.add(getRas());
        }
        if (getListSpe() == null) {
            return listRas;
        }
        for (Spe spe : getListSpe()) {
            listRas.add(spe.getRas());
        }
        return listRas;
    }
}
