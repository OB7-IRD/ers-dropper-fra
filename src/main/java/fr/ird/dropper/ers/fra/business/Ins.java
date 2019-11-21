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
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import fr.ird.dropper.ers.fra.xstreamconverters.DateConverter;

/**
 * Inspection.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("INS")
public class Ins extends EvenementDePecheImpl {

    private static final long serialVersionUID = -7122727994538218835L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long insCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("IC")
    private String insIcLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("IA")
    private String insIaLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("SC")
    private String insScLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("DA")
    @XStreamConverter(DateConverter.class)
    private Date insDaDt;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("TI")
    private String insTiLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("PO")
    private String insPoLb;

    /**
     * nullable persistent field
     */
    @XStreamOmitField
    private Date insDatiDt;

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

    public Long getInsCdn() {
        return this.insCdn;
    }

    public void setInsCdn(Long insCdn) {
        this.insCdn = insCdn;
    }

    public String getInsIcLb() {
        return this.insIcLb;
    }

    public void setInsIcLb(String insIcLb) {
        this.insIcLb = insIcLb;
    }

    public String getInsIaLb() {
        return this.insIaLb;
    }

    public void setInsIaLb(String insIaLb) {
        this.insIaLb = insIaLb;
    }

    public String getInsScLb() {
        return this.insScLb;
    }

    public void setInsScLb(String insScLb) {
        this.insScLb = insScLb;
    }

    public Date getInsDaDt() {
        return this.insDaDt;
    }

    public void setInsDaDt(Date insDaDt) {
        this.insDaDt = insDaDt;
    }

    public String getInsTiLb() {
        return this.insTiLb;
    }

    public void setInsTiLb(String insTiLb) {
        this.insTiLb = insTiLb;
    }

    public String getInsPoLb() {
        return this.insPoLb;
    }

    public void setInsPoLb(String insPoLb) {
        this.insPoLb = insPoLb;
    }

    public Date getInsDatiDt() {
        return this.insDatiDt;
    }

    public void setInsDatiDt(Date insDatiDt) {
        this.insDatiDt = insDatiDt;
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

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getInsCdn();
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
        if (!(other instanceof Ins)) {
            return false;
        }
        Ins castOther = (Ins) other;
        return new EqualsBuilder().append(this.getInsCdn(),
                castOther.getInsCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getInsCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return insCdn;
    }

    /**
     * On va remplir les champs non présents dans le XML reçu. Cette méthode est
     * appelée automatiquement par XStream après la création de l'objet (INS)
     *
     * @return this
     */
    private Object readResolve() {
        // On crée l'attribut insDatiDt (date/heure) qui est une concaténation
        // des attributs insDaDt (date) et insTiLb (heure)
        DateConverter converter = new DateConverter();
        String dateHeure = converter.toString(getInsDaDt()) + " "
                + getInsTiLb();
        Date insDatiDt = (Date) converter.fromDateTimeString(dateHeure);
        setInsDatiDt(insDatiDt);
        return this;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichie XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peur être exporté par XStream
     */
    public Ins cloneExportedFields(IExportConfiguration exportConfiguration) {
        Ins clone = new Ins();

        clone.setInsIcLb(getInsIcLb());
        clone.setInsIaLb(getInsIaLb());
        clone.setInsDaDt(getInsDaDt());
        clone.setInsTiLb(getInsTiLb());
        clone.setInsPoLb(getInsPoLb());

        Pos pos = getPos();
        if (pos != null) {
            clone.setPos(pos.cloneExportedFields(exportConfiguration));
        } else {
            clone.setPos(null);
        }

        return clone;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getType()
     */
    public String getType() {
        return "INS";
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDatiDt()
     */
    public Date getDatiDt() {
        return getInsDatiDt();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDaDt()
     */
    public Date getDaDt() {
        return getInsDaDt();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getTiLb()
     */
    public String getTiLb() {
        return getInsTiLb();
    }

    public void addToLog(Log log) {
        if (log.getListIns() == null) {
            log.setListIns(new ArrayList<Ins>());
        }
        log.getListIns().add(this);
    }

    public List<Ras> getRasList() {
        List<Ras> listRas = new ArrayList<Ras>();
        /**
         * listRas.add(getRas()); for(Spe spe : getListSpe()){
         * listRas.add(spe.getRas());
		}*
         */
        return listRas;
    }
}
