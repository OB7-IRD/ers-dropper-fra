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
 * Capture.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("FAR")
public class Far extends EvenementDePecheImpl {

    private static final long serialVersionUID = 5964336120038907692L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long farCdn;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("LR")
    private Integer farLrNb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("IS")
    private Integer farIsNb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("DA")
    @XStreamConverter(DateConverter.class)
    private Date farDaDt;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("TI")
    private String farTiLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("JF")
    private String farJfLb;

    /**
     * nullable persistent field
     */
    @XStreamOmitField
    private Date farDatiDt;

    /**
     * persistent field
     */
    @XStreamOmitField
    private Log log;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "PFP")
    private List<Pfp> listPfp;

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
    @XStreamAlias("GEA")
    private Gea gea;

    /**
     * persistent field
     */
    @XStreamAlias("GLS")
    private Gls gls;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "SPE")
    private List<Spe> listSpe;

    /**
     * persistent field
     */
    @XStreamAlias("CVT")
    private Cvt cvt;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "CVO")
    private List<Cvo> listCvo;

    /**
     * persistent field
     */
    @XStreamAlias("JCI")
    private Jci jci;

    /**
     * persistent field
     */
    @XStreamAlias("EFAR")
    private Efar efar;

    public Long getFarCdn() {
        return this.farCdn;
    }

    public void setFarCdn(Long farCdn) {
        this.farCdn = farCdn;
    }

    public Integer getFarLrNb() {
        return this.farLrNb;
    }

    public void setFarLrNb(Integer farLrNb) {
        this.farLrNb = farLrNb;
    }

    public Integer getFarIsNb() {
        return this.farIsNb;
    }

    public void setFarIsNb(Integer farIsNb) {
        this.farIsNb = farIsNb;
    }

    public Date getFarDaDt() {
        return this.farDaDt;
    }

    public void setFarDaDt(Date farDaDt) {
        this.farDaDt = farDaDt;
    }

    public String getFarTiLb() {
        return this.farTiLb;
    }

    public void setFarTiLb(String farTiLb) {
        this.farTiLb = farTiLb;
    }

    public String getFarJfLb() {
        return this.farJfLb;
    }

    public void setFarJfLb(String farJfLb) {
        this.farJfLb = farJfLb;
    }

    public Date getFarDatiDt() {
        return this.farDatiDt;
    }

    public void setFarDatiDt(Date farDatiDt) {
        this.farDatiDt = farDatiDt;
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

    public Gls getGls() {
        return this.gls;
    }

    public void setGls(Gls gls) {
        this.gls = gls;
    }

    public Gea getGea() {
        return this.gea;
    }

    public void setGea(Gea gea) {
        this.gea = gea;
    }

    public Ras getRas() {
        return this.ras;
    }

    public void setRas(Ras ras) {
        this.ras = ras;
    }

    public Cvt getCvt() {
        return this.cvt;
    }

    public void setCvt(Cvt cvt) {
        this.cvt = cvt;
    }

    public Pos getPos() {
        return this.pos;
    }

    public void setPos(Pos pos) {
        this.pos = pos;
    }

    public Efar getEfar() {
        return this.efar;
    }

    public void setEfar(Efar efar) {
        this.efar = efar;
    }

    public Jci getJci() {
        return this.jci;
    }

    public void setJci(Jci jci) {
        this.jci = jci;
    }

    public List<Pfp> getListPfp() {
        if (listPfp == null) {
            listPfp = new ArrayList<>();
        }
        return this.listPfp;
    }

    public void setListPfp(List<Pfp> listPfp) {
        this.listPfp = listPfp;
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

    public List<Cvo> getListCvo() {
        return this.listCvo;
    }

    public void setListCvo(List<Cvo> listCvo) {
        this.listCvo = listCvo;
    }

    @Override
    public String toString() {
        return "Far{" + "farLrNb=" + farLrNb + ", farIsNb=" + farIsNb + ", farDaDt=" + farDaDt + ", farTiLb=" + farTiLb + ", farJfLb=" + farJfLb + ", farDatiDt=" + farDatiDt + '}';
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
        if (!(other instanceof Far)) {
            return false;
        }
        Far castOther = (Far) other;
        return new EqualsBuilder().append(this.getFarCdn(),
                castOther.getFarCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getFarCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return farCdn;
    }

    /**
     * On va remplir les champs non présents dans le XML reçu. Cette méthode est
     * appelée automatiquement par XStream après la création de l'objet (FAR)
     *
     * @return this
     */
    private Object readResolve() {
        String heure = getFarTiLb();

        // si l'heure n'est pas fournie, on prend 0h00
        if (heure == null) {
            heure = "00:00";
        }

        // On crée l'attribut farDatiDt (date/heure) qui est une concaténation
        // des attributs farDaDt (date) et farTiLb (heure)
        DateConverter converter = new DateConverter();
        String dateHeure = converter.toString(getFarDaDt()) + " " + heure;
        Date farDatiDt = (Date) converter.fromDateTimeString(dateHeure);
        setFarDatiDt(farDatiDt);
        return this;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichie XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peur être exporté par XStream
     */
    public Far cloneExportedFields(IExportConfiguration exportConfiguration) {
        Far clone = new Far();

        clone.setFarLrNb(getFarLrNb());
        clone.setFarIsNb(getFarIsNb());
        clone.setFarDaDt(getFarDaDt());
        clone.setFarTiLb(getFarTiLb());
        clone.setFarJfLb(getFarJfLb());

        // Clone des PFP
        if (getListPfp() != null && !getListPfp().isEmpty()) {
            ArrayList<Pfp> clonePfps = new ArrayList<Pfp>();
            for (Pfp pfp : getListPfp()) {
                clonePfps.add(pfp.cloneExportedFields(exportConfiguration));
            }
            clone.setListPfp(clonePfps);
        }

        Ras ras = getRas();
        if (ras != null) {
            clone.setRas(ras.cloneExportedFields(exportConfiguration));
        } else {
            clone.setRas(null);
        }

        Pos pos = getPos();
        if (pos != null) {
            clone.setPos(pos.cloneExportedFields(exportConfiguration));
        } else {
            clone.setPos(null);
        }

        Gea gea = getGea();
        if (gea != null) {
            clone.setGea(gea.cloneExportedFields(exportConfiguration));
        } else {
            clone.setGea(null);
        }

        Gls gls = getGls();
        if (gls != null) {
            clone.setGls(getGls().cloneExportedFields(exportConfiguration));
        } else {
            clone.setGls(null);
        }

        // Clone des SPE
        if (getListSpe() != null && !getListSpe().isEmpty()) {
            ArrayList<Spe> cloneSpes = new ArrayList<Spe>();
            for (Spe spe : getListSpe()) {
                cloneSpes.add(spe.cloneExportedFields(exportConfiguration));
            }
            clone.setListSpe(cloneSpes);
        }

        Cvt cvt = getCvt();
        if (cvt != null) {
            clone.setCvt(getCvt().cloneExportedFields(exportConfiguration));
        } else {
            clone.setCvt(null);
        }

        // Clone des SPE
        if (getListCvo() != null && !getListCvo().isEmpty()) {
            ArrayList<Cvo> cloneCvos = new ArrayList<Cvo>();
            for (Cvo cvo : getListCvo()) {
                cloneCvos.add(cvo.cloneExportedFields(exportConfiguration));
            }
            clone.setListCvo(cloneCvos);
        }

        Jci jci = getJci();
        if (jci != null) {
            clone.setJci(getJci().cloneExportedFields(exportConfiguration));
        } else {
            clone.setJci(null);
        }

        Efar efar = getEfar();
        if (exportConfiguration.isExtensionsFrancaises() && efar != null) {
            clone.setEfar(getEfar().cloneExportedFields(exportConfiguration));
        } else {
            clone.setEfar(null);
        }

        return clone;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getType()
     */
    public String getType() {
        return "FAR";
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDatiDt()
     */
    public Date getDatiDt() {
        return getFarDatiDt();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDaDt()
     */
    public Date getDaDt() {
        return getFarDaDt();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getTiLb()
     */
    public String getTiLb() {
        return getFarTiLb();
    }

    public void addToLog(Log log) {
        if (log.getListFar() == null) {
            log.setListFar(new ArrayList<Far>());
        }
        log.getListFar().add(this);
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
