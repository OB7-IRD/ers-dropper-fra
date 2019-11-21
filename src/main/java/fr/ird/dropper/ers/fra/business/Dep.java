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
import fr.ird.common.log.LogService;

import fr.ird.dropper.ers.fra.xstreamconverters.DateConverter;

/**
 * Départ du port.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("DEP")
public class Dep extends EvenementDePecheImpl {

    public Dep() {
        LogService.getService().logApplicationDebug("Lecture DEP");
    }

    private static final long serialVersionUID = 4876282444792431924L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long depCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("DA")
    @XStreamConverter(DateConverter.class)
    private Date depDaDt;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("TI")
    private String depTiLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("PO")
    private String depPoLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("AA")
    private String depAaLb;

    /**
     * nullable persistent field
     */
    @XStreamOmitField
    private Date depDatiDt;

    /**
     * persistent field
     */
    @XStreamOmitField
    private Log log;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "GEA")
    private List<Gea> listGea;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "SPE")
    private List<Spe> listSpe;

    /**
     * persistent field
     */
    @XStreamAlias("EDEP")
    private Edep edep;

    public Long getDepCdn() {
        return this.depCdn;
    }

    public void setDepCdn(Long depCdn) {
        this.depCdn = depCdn;
    }

    public Date getDepDaDt() {
        return this.depDaDt;
    }

    public void setDepDaDt(Date depDaDt) {
        this.depDaDt = depDaDt;
    }

    public String getDepTiLb() {
        return this.depTiLb;
    }

    public void setDepTiLb(String depTiLb) {
        this.depTiLb = depTiLb;
    }

    public String getDepPoLb() {
        return this.depPoLb;
    }

    public void setDepPoLb(String depPoLb) {
        this.depPoLb = depPoLb;
    }

    public String getDepAaLb() {
        return this.depAaLb;
    }

    public void setDepAaLb(String depAaLb) {
        this.depAaLb = depAaLb;
    }

    public Date getDepDatiDt() {
        return this.depDatiDt;
    }

    public void setDepDatiDt(Date depDatiDt) {
        this.depDatiDt = depDatiDt;
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

    public Edep getEdep() {
        return edep;
    }

    public void setEdep(Edep edep) {
        this.edep = edep;
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

    public List<Gea> getListGea() {
        if (listGea == null) {
            listGea = new ArrayList<>();
        }
        return this.listGea;
    }

    public void setListGea(List<Gea> listGea) {
        this.listGea = listGea;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Dep{" + "depCdn=" + depCdn + ", depDaDt=" + depDaDt + ", depTiLb=" + depTiLb + ", depPoLb=" + depPoLb + ", depAaLb=" + depAaLb + ", depDatiDt=" + depDatiDt + ", log=" + log + ", listGea=" + listGea + ", listSpe=" + listSpe + ", edep=" + edep + '}';
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
        if (!(other instanceof Dep)) {
            return false;
        }
        Dep castOther = (Dep) other;
        return new EqualsBuilder().append(this.getDepCdn(),
                castOther.getDepCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getDepCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return depCdn;
    }

    /**
     * On va remplir les champs non présents dans le XML reçu. Cette méthode est
     * appelée automatiquement par XStream après la création de l'objet (DEP).
     *
     * @return this
     */
    private Object readResolve() {
        // On crée l'attribut depDatiDt (date/heure) qui est une concaténation
        // des attributs depDaDt (date) et depTiLb (heure)

        LogService.getService().logApplicationDebug("DEP " + this);

        DateConverter converter = new DateConverter();
        String dateHeure = converter.toString(getDepDaDt()) + " "
                + getDepTiLb();
        Date depDatiDt = (Date) converter.fromDateTimeString(dateHeure);
        setDepDatiDt(depDatiDt);
        return this;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichier XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peut être exporté par XStream
     */
    public Dep cloneExportedFields(IExportConfiguration exportConfiguration) {
        Dep clone = new Dep();

        clone.setDepDaDt(getDepDaDt());
        clone.setDepTiLb(getDepTiLb());
        clone.setDepPoLb(getDepPoLb());
        clone.setDepAaLb(getDepAaLb());

        // Clone des SPE
        if (getListSpe() != null && !getListSpe().isEmpty()) {
            ArrayList<Spe> cloneSpes = new ArrayList<Spe>();
            for (Spe spe : getListSpe()) {
                cloneSpes.add(spe.cloneExportedFields(exportConfiguration));
            }
            clone.setListSpe(cloneSpes);
        }

        // Clone des GEA
        if (getListGea() != null && !getListGea().isEmpty()) {
            ArrayList<Gea> cloneGeas = new ArrayList<Gea>();
            for (Gea gea : getListGea()) {
                cloneGeas.add(gea.cloneExportedFields(exportConfiguration));
            }
            clone.setListGea(cloneGeas);
        }

        Edep edep = getEdep();
        if (exportConfiguration.isExtensionsFrancaises() && edep != null) {
            clone.setEdep(edep.cloneExportedFields(exportConfiguration));
        } else {
            clone.setEdep(null);
        }

        return clone;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getType()
     */
    public String getType() {
        return "DEP";
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDatiDt()
     */
    public Date getDatiDt() {
        return getDepDatiDt();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDaDt()
     */
    public Date getDaDt() {
        return getDepDaDt();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getTiLb()
     */
    public String getTiLb() {
        return getDepTiLb();
    }

    public void addToLog(Log log) {
        if (log.getListDep() == null) {
            log.setListDep(new ArrayList<Dep>());
        }
        log.getListDep().add(this);
    }

    public List<Ras> getRasList() {
        List<Ras> listRas = new ArrayList<Ras>();
        //listRas.add(getRas());
        if (getListSpe() == null) {
            return listRas;
        }
        for (Spe spe : getListSpe()) {
            listRas.add(spe.getRas());
        }
        return listRas;
    }
}
