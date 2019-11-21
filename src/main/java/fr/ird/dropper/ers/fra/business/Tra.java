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
 * Transbordement.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("TRA")
public class Tra extends EvenementDePecheImpl {

    private static final long serialVersionUID = 4735021771120382826L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long traCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("DA")
    @XStreamConverter(DateConverter.class)
    private Date traDaDt;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("TI")
    private String traTiLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("PO")
    private String traPoLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("IR")
    private String traIrLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("TT")
    private String traTtLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("TC")
    private String traTcLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("RF")
    private String traRfLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("TF")
    private String traTfLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("FC")
    private String traFcLb;

    /**
     * nullable persistent field
     */
    @XStreamOmitField
    private Date traDatiDt;

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
     * Retourne l'identifiant.
     */
    public Long getTraCdn() {
        return this.traCdn;
    }

    public void setTraCdn(Long traCdn) {
        this.traCdn = traCdn;
    }

    /**
     * Retourne la date.
     */
    public Date getTraDaDt() {
        return this.traDaDt;
    }

    public void setTraDaDt(Date traDaDt) {
        this.traDaDt = traDaDt;
    }

    /**
     * Retourne l'heure.
     */
    public String getTraTiLb() {
        return this.traTiLb;
    }

    public void setTraTiLb(String traTiLb) {
        this.traTiLb = traTiLb;
    }

    /**
     * Retourne le port.
     */
    public String getTraPoLb() {
        return this.traPoLb;
    }

    public void setTraPoLb(String traPoLb) {
        this.traPoLb = traPoLb;
    }

    /**
     * Retourne l'identifiant (NAVIRE_CFR_RFA) du navire receveur.
     */
    public String getTraIrLb() {
        return this.traIrLb;
    }

    public void setTraIrLb(String traIrLb) {
        this.traIrLb = traIrLb;
    }

    /**
     * Retourne l'identifiant (NAVIRE_IRCSCOD_LB) du navire receveur.
     */
    public String getTraTtLb() {
        return this.traTtLb;
    }

    public void setTraTtLb(String traTtLb) {
        this.traTtLb = traTtLb;
    }

    /**
     * Retourne le pays du navire receveur.
     */
    public String getTraTcLb() {
        return this.traTcLb;
    }

    public void setTraTcLb(String traTcLb) {
        this.traTcLb = traTcLb;
    }

    /**
     * Retourne l'identifiant (NAVIRE_CFR_RFA) du navire donneur.
     */
    public String getTraRfLb() {
        return this.traRfLb;
    }

    public void setTraRfLb(String traRfLb) {
        this.traRfLb = traRfLb;
    }

    /**
     * Retourne l'identifiant (NAVIRE_IRCSCOD_LB) du navire donneur.
     */
    public String getTraTfLb() {
        return this.traTfLb;
    }

    public void setTraTfLb(String traTfLb) {
        this.traTfLb = traTfLb;
    }

    /**
     * Retourne le pays du navire donneur.
     */
    public String getTraFcLb() {
        return this.traFcLb;
    }

    public void setTraFcLb(String traFcLb) {
        this.traFcLb = traFcLb;
    }

    /**
     * Retourne la date/heure.
     */
    public Date getTraDatiDt() {
        return this.traDatiDt;
    }

    public void setTraDatiDt(Date traDatiDt) {
        this.traDatiDt = traDatiDt;
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

    public Ras getRas() {
        return this.ras;
    }

    public void setRas(Ras ras) {
        this.ras = ras;
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
        return "" + getTraCdn();
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
        if (!(other instanceof Tra)) {
            return false;
        }
        Tra castOther = (Tra) other;
        return new EqualsBuilder().append(this.getTraCdn(),
                castOther.getTraCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getTraCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return traCdn;
    }

    /**
     * On va remplir les champs non présents dans le XML reçu. Cette méthode est
     * appelée automatiquement par XStream après la création de l'objet (TRA).
     *
     * @return this
     */
    private Object readResolve() {
        // On crée l'attribut traDatiDt (date/heure) qui est une concaténation
        // des attributs traDaDt (date) et traTiLb (heure)
        DateConverter converter = new DateConverter();
        String dateHeure = converter.toString(getTraDaDt());
        if (getTraTiLb() == null) {
            dateHeure += " 00:00";
        } else {
            dateHeure += " " + getTraTiLb();
        }
        Date traDatiDt = (Date) converter.fromDateTimeString(dateHeure);
        setTraDatiDt(traDatiDt);
        return this;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichier XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peut être exporté par XStream
     */
    public Tra cloneExportedFields(IExportConfiguration exportConfiguration) {
        Tra clone = new Tra();

        clone.setTraDaDt(getTraDaDt());
        clone.setTraTiLb(getTraTiLb());
        clone.setTraPoLb(getTraPoLb());
        clone.setTraIrLb(getTraIrLb());
        clone.setTraTtLb(getTraTtLb());
        clone.setTraTcLb(getTraTcLb());
        clone.setTraRfLb(getTraRfLb());
        clone.setTraTfLb(getTraTfLb());
        clone.setTraFcLb(getTraFcLb());

        Pos pos = getPos();
        if (pos != null) {
            clone.setPos(pos.cloneExportedFields(exportConfiguration));
        } else {
            clone.setPos(null);
        }

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
        return "TRA";
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDatiDt()
     */
    public Date getDatiDt() {
        return getTraDatiDt();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDaDt()
     */
    public Date getDaDt() {
        return getTraDaDt();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getTiLb()
     */
    public String getTiLb() {
        return getTraTiLb();
    }

    public void addToLog(Log log) {
        if (log.getListTra() == null) {
            log.setListTra(new ArrayList<Tra>());
        }
        log.getListTra().add(this);
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
