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
 * Rejet de poisson.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("DIS")
public class Dis extends EvenementDePecheImpl {

    private static final long serialVersionUID = 6105683871093069689L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long disCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("DA")
    @XStreamConverter(DateConverter.class)
    private Date disDaDt;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("TI")
    private String disTiLb;

    /**
     * nullable persistent field
     */
    @XStreamOmitField
    private Date disDatiDt;

    /**
     * persistent field
     */
    @XStreamOmitField
    private Log log;

    /**
     * persistent field
     */
    @XStreamAlias("POS")
    private Pos pos;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "SPE")
    private List<Spe> spes;

    public Long getDisCdn() {
        return this.disCdn;
    }

    public void setDisCdn(Long disCdn) {
        this.disCdn = disCdn;
    }

    public Date getDisDaDt() {
        return this.disDaDt;
    }

    public void setDisDaDt(Date disDaDt) {
        this.disDaDt = disDaDt;
    }

    public String getDisTiLb() {
        return this.disTiLb;
    }

    public void setDisTiLb(String disTiLb) {
        this.disTiLb = disTiLb;
    }

    public Date getDisDatiDt() {
        return this.disDatiDt;
    }

    public void setDisDatiDt(Date disDatiDt) {
        this.disDatiDt = disDatiDt;
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

    public Pos getPos() {
        return this.pos;
    }

    public void setPos(Pos pos) {
        this.pos = pos;
    }

    public List<Spe> getListSpe() {
        if (spes == null) {
            spes = new ArrayList<>();
        }
        return this.spes;
    }

    public void setListSpe(List<Spe> spes) {
        this.spes = spes;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getDisCdn();
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
        if (!(other instanceof Dis)) {
            return false;
        }
        Dis castOther = (Dis) other;
        return new EqualsBuilder().append(this.getDisCdn(),
                castOther.getDisCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getDisCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return disCdn;
    }

    /**
     * On va remplir les champs non présents dans le XML reçu. Cette méthode est
     * appelée automatiquement par XStream après la création de l'objet (DIS).
     *
     * @return this
     */
    private Object readResolve() {
        // On crée l'attribut disDatiDt (date/heure) qui est une concaténation
        // des attributs disDaDt (date) et disTiLb (heure)
        DateConverter converter = new DateConverter();
        String dateHeure = converter.toString(getDisDaDt()) + " "
                + getDisTiLb();
        Date disDatiDt = (Date) converter.fromDateTimeString(dateHeure);
        setDisDatiDt(disDatiDt);
        return this;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichier XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peut être exporté par XStream
     */
    public Dis cloneExportedFields(IExportConfiguration exportConfiguration) {
        Dis clone = new Dis();

        clone.setDisDaDt(getDisDaDt());
        clone.setDisTiLb(getDisTiLb());

        Pos pos = getPos();
        if (pos != null) {
            clone.setPos(pos.cloneExportedFields(exportConfiguration));
        } else {
            clone.setPos(null);
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
        return "DIS";
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDatiDt()
     */
    public Date getDatiDt() {
        return getDisDatiDt();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDaDt()
     */
    public Date getDaDt() {
        return getDisDaDt();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getTiLb()
     */
    public String getTiLb() {
        return getDisTiLb();
    }

    public void addToLog(Log log) {
        if (log.getListDis() == null) {
            log.setListDis(new ArrayList<Dis>());
        }
        log.getListDis().add(this);
    }

    public List<Ras> getRasList() {
        List<Ras> listRas = new ArrayList<Ras>();
        //listRas.add(getRas());
        if (getListSpe() != null) {
            for (Spe spe : getListSpe()) {
                listRas.add(spe.getRas());
            }
        }
        return listRas;
    }
}
