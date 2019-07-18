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
 * Transfert.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("RLC")
public class Rlc extends EvenementDePecheImpl {

    private static final long serialVersionUID = 2338136858417191089L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long rlcCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("DA")
    @XStreamConverter(DateConverter.class)
    private Date rlcDaDt;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("TI")
    private String rlcTiLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("RT")
    private String rlcRtLb;

    /**
     * nullable persistent field
     */
    @XStreamOmitField
    private Date rlcDatiDt;

    /**
     * persistent field
     */
    @XStreamOmitField
    private Log log;

    /**
     * persistent field
     */
    @XStreamAlias("REC")
    private Rec rec;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "DON")
    private List<Don> dons;

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
    @XStreamAlias("BTI")
    private Bti bti;

    /**
     * Retourne l'identifiant.
     */
    public Long getRlcCdn() {
        return this.rlcCdn;
    }

    public void setRlcCdn(Long rlcCdn) {
        this.rlcCdn = rlcCdn;
    }

    /**
     * Retourne la date.
     */
    public Date getRlcDaDt() {
        return this.rlcDaDt;
    }

    public void setRlcDaDt(Date rlcDaDt) {
        this.rlcDaDt = rlcDaDt;
    }

    /**
     * Retourne l'heure.
     */
    public String getRlcTiLb() {
        return this.rlcTiLb;
    }

    public void setRlcTiLb(String rlcTiLb) {
        this.rlcTiLb = rlcTiLb;
    }

    /**
     * Retourne le code de relocalisation.
     */
    public String getRlcRtLb() {
        return this.rlcRtLb;
    }

    public void setRlcRtLb(String rlcRtLb) {
        this.rlcRtLb = rlcRtLb;
    }

    /**
     * Retourne la date/heure.
     */
    public Date getRlcDatiDt() {
        return this.rlcDatiDt;
    }

    public void setRlcDatiDt(Date rlcDatiDt) {
        this.rlcDatiDt = rlcDatiDt;
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

    public Bti getBti() {
        return this.bti;
    }

    public void setBti(Bti bti) {
        this.bti = bti;
    }

    public Rec getRec() {
        return this.rec;
    }

    public void setRec(Rec rec) {
        this.rec = rec;
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

    public List<Don> getDons() {
        return this.dons;
    }

    public void setDons(List<Don> dons) {
        this.dons = dons;
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getRlcCdn();
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if (!(other instanceof Rlc)) {
            return false;
        }
        Rlc castOther = (Rlc) other;
        return new EqualsBuilder().append(this.getRlcCdn(),
                castOther.getRlcCdn()).isEquals();
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getRlcCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return rlcCdn;
    }

    /**
     * On va remplir les champs non présents dans le XML reçu. Cette méthode est
     * appelée automatiquement par XStream après la création de l'objet (RLC)
     *
     * @return this
     */
    private Object readResolve() {
        // On crée l'attribut rlcDatiDt (date/heure) qui est une concaténation
        // des attributs rlcDaDt (date) et rlcTiLb (heure)
        DateConverter converter = new DateConverter();
        String dateHeure = converter.toString(getRlcDaDt());
        if (getRlcTiLb() == null) {
            dateHeure += " 00:00";
        } else {
            dateHeure += " " + getRlcTiLb();
        }
        Date rlcDatiDt = (Date) converter.fromDateTimeString(dateHeure);
        setRlcDatiDt(rlcDatiDt);
        return this;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichier XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peut être exporté par XStream
     */
    public Rlc cloneExportedFields(IExportConfiguration exportConfiguration) {
        Rlc clone = new Rlc();

        clone.setRlcDaDt(getRlcDaDt());
        clone.setRlcTiLb(getRlcTiLb());
        clone.setRlcRtLb(getRlcRtLb());

        Pos pos = getPos();
        if (pos != null) {
            clone.setPos(pos.cloneExportedFields(exportConfiguration));
        } else {
            clone.setPos(null);
        }

        Rec rec = getRec();
        if (rec != null) {
            clone.setRec(rec.cloneExportedFields(exportConfiguration));
        } else {
            clone.setRec(null);
        }

        Bti bti = getBti();
        if (bti != null) {
            clone.setBti(bti.cloneExportedFields(exportConfiguration));
        } else {
            clone.setBti(null);
        }

        // Clone des DON
        if (getDons() != null && !getDons().isEmpty()) {
            ArrayList<Don> cloneDons = new ArrayList<Don>();
            for (Don don : getDons()) {
                cloneDons.add(don.cloneExportedFields(exportConfiguration));
            }
            clone.setDons(cloneDons);
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
        return "RLC";
    }

    /* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDatiDt()
     */
    public Date getDatiDt() {
        return getRlcDatiDt();
    }

    /* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDaDt()
     */
    public Date getDaDt() {
        return getRlcDaDt();
    }

    /* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getTiLb()
     */
    public String getTiLb() {
        return getRlcTiLb();
    }

    public void addToLog(Log log) {
        if (log.getListRlc() == null) {
            log.setListRlc(new ArrayList<Rlc>());
        }
        log.getListRlc().add(this);
    }

    public List<Ras> getRasList() {
        List<Ras> listRas = new ArrayList<Ras>();
        if (getListSpe() == null) {
            return listRas;
        }
        for (Spe spe : getListSpe()) {
            listRas.add(spe.getRas());
        }
        return listRas;
    }
}
