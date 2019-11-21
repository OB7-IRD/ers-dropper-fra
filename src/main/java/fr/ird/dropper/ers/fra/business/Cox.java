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
 * Sortie d'une zone d'effort.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("COX")
public class Cox extends EvenementDePecheImpl {

    private static final long serialVersionUID = 1016678940689938150L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long coxCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("DA")
    @XStreamConverter(DateConverter.class)
    private Date coxDaDt;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("TI")
    private String coxTiLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("TS")
    private String coxTsLb;

    /**
     * nullable persistent field
     */
    @XStreamOmitField
    private Date coxDatiDt;

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

    public Long getCoxCdn() {
        return this.coxCdn;
    }

    public void setCoxCdn(Long coxCdn) {
        this.coxCdn = coxCdn;
    }

    public Date getCoxDaDt() {
        return this.coxDaDt;
    }

    public void setCoxDaDt(Date coxDaDt) {
        this.coxDaDt = coxDaDt;
    }

    public String getCoxTiLb() {
        return this.coxTiLb;
    }

    public void setCoxTiLb(String coxTiLb) {
        this.coxTiLb = coxTiLb;
    }

    public String getCoxTsLb() {
        return this.coxTsLb;
    }

    public void setCoxTsLb(String coxTsLb) {
        this.coxTsLb = coxTsLb;
    }

    public Date getCoxDatiDt() {
        return this.coxDatiDt;
    }

    public void setCoxDatiDt(Date coxDatiDt) {
        this.coxDatiDt = coxDatiDt;
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

    public List<Cro> getListCro() {
        if (listCro == null) {
            listCro = new ArrayList<>();
        }
        return this.listCro;
    }

    public void setListCro(List<Cro> listCro) {
        this.listCro = listCro;
    }

    public List<Spe> getListSpe() {
        if (listSpe == null) {
            listSpe = new ArrayList<>();
        }
        return this.listSpe;
    }

    public void setListSpe(List<Spe> listSpe) {
        if (listSpe == null) {
            listSpe = new ArrayList<>();
        }
        this.listSpe = listSpe;
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

    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getCoxCdn();
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if (!(other instanceof Cox)) {
            return false;
        }
        Cox castOther = (Cox) other;
        return new EqualsBuilder().append(this.getCoxCdn(),
                castOther.getCoxCdn()).isEquals();
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getCoxCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return coxCdn;
    }

    /**
     * On va remplir les champs non présents dans le XML reçu. Cette méthode est
     * appelée automatiquement par XStream après la création de l'objet (COX)
     *
     * @return this
     */
    private Object readResolve() {
        // On crée l'attribut coxDatiDt (date/heure) qui est une concaténation
        // des attributs coxDaDt (date) et coxTiLb (heure)
        DateConverter converter = new DateConverter();
        String dateHeure = converter.toString(getCoxDaDt()) + " "
                + getCoxTiLb();
        Date coxDatiDt = (Date) converter.fromDateTimeString(dateHeure);
        setCoxDatiDt(coxDatiDt);
        return this;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichie XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peur être exporté par XStream
     */
    public Cox cloneExportedFields(IExportConfiguration exportConfiguration) {
        Cox clone = new Cox();

        clone.setCoxDaDt(getCoxDaDt());
        clone.setCoxTiLb(getCoxTiLb());
        clone.setCoxTsLb(getCoxTsLb());

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

    /* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getType()
     */
    public String getType() {
        return "COX";
    }

    /* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDatiDt()
     */
    public Date getDatiDt() {
        return getCoxDatiDt();
    }

    /* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDaDt()
     */
    public Date getDaDt() {
        return getCoxDaDt();
    }

    /* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getTiLb()
     */
    public String getTiLb() {
        return getCoxTiLb();
    }

    public void addToLog(Log log) {
        if (log.getListCox() == null) {
            log.setListCox(new ArrayList<Cox>());
        }
        log.getListCox().add(this);
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
