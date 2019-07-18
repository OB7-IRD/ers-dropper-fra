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
import fr.ird.dropper.ers.fra.common.ErsUtils;

import fr.ird.dropper.ers.fra.xstreamconverters.DateConverter;

/**
 * Notification de retour au port.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("PNO")
public class Pno extends EvenementDePecheImpl {

    private static final long serialVersionUID = 4827703372831281161L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long pnoCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("PD")
    @XStreamConverter(DateConverter.class)
    private Date pnoPdDt;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("PT")
    private String pnoPtLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("PO")
    private String pnoPoLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("DA")
    @XStreamConverter(DateConverter.class)
    private Date pnoDaDt;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("TI")
    private String pnoTiLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("PC")
    private String pnoPcLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("DS")
    @XStreamConverter(DateConverter.class)
    private Date pnoDsDt;

    /**
     * nullable persistent field
     */
    @XStreamOmitField
    private Date pnoPdptDt;

    /**
     * nullable persistent field
     */
    @XStreamOmitField
    private Date pnoDatiDt;

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
    @XStreamImplicit(itemFieldName = "SPE")
    private List<Spe> listSpe;

    /**
     * persistent field
     */
    @XStreamAlias("POS")
    private Pos pos;

    /**
     * non persistent field
     */
    @XStreamOmitField
    private Ops nonPersistedOps;

    public Long getPnoCdn() {
        return this.pnoCdn;
    }

    public void setPnoCdn(Long pnoCdn) {
        this.pnoCdn = pnoCdn;
    }

    public Date getPnoPdDt() {
        return this.pnoPdDt;
    }

    public void setPnoPdDt(Date pnoPdDt) {
        this.pnoPdDt = pnoPdDt;
    }

    public String getPnoPtLb() {
        return this.pnoPtLb;
    }

    public void setPnoPtLb(String pnoPtLb) {
        this.pnoPtLb = pnoPtLb;
    }

    public String getPnoPoLb() {
        return this.pnoPoLb;
    }

    public void setPnoPoLb(String pnoPoLb) {
        this.pnoPoLb = pnoPoLb;
    }

    public Date getPnoDaDt() {
        return this.pnoDaDt;
    }

    public void setPnoDaDt(Date pnoDaDt) {
        this.pnoDaDt = pnoDaDt;
    }

    public String getPnoTiLb() {
        return this.pnoTiLb;
    }

    public void setPnoTiLb(String pnoTiLb) {
        this.pnoTiLb = pnoTiLb;
    }

    public String getPnoPcLb() {
        return this.pnoPcLb;
    }

    public void setPnoPcLb(String pnoPcLb) {
        this.pnoPcLb = pnoPcLb;
    }

    public Date getPnoDsDt() {
        return this.pnoDsDt;
    }

    public void setPnoDsDt(Date pnoDsDt) {
        this.pnoDsDt = pnoDsDt;
    }

    public Date getPnoPdptDt() {
        return this.pnoPdptDt;
    }

    public void setPnoPdptDt(Date pnoPdptDt) {
        this.pnoPdptDt = pnoPdptDt;
    }

    public Date getPnoDatiDt() {
        return this.pnoDatiDt;
    }

    public void setPnoDatiDt(Date pnoDatiDt) {
        this.pnoDatiDt = pnoDatiDt;
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
        return "" + getPnoCdn();
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
        if (!(other instanceof Pno)) {
            return false;
        }
        Pno castOther = (Pno) other;
        return new EqualsBuilder().append(this.getPnoCdn(),
                castOther.getPnoCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getPnoCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return pnoCdn;
    }

    /**
     * On va remplir les champs non présents dans le XML reçu. Cette méthode est
     * appelée automatiquement par XStream après la création de l'objet (PNO)
     *
     * @return this
     */
    private Object readResolve() {
        DateConverter converter = new DateConverter();
        // On crée l'attribut pnoPdptDt (date/heure) qui est une concaténation
        // des attributs pnoPdDt (date) et pnoPtLb (heure)
        String dateHeure = converter.toString(getPnoPdDt()) + " "
                + getPnoPtLb();
        Date pnoPdptDt = (Date) converter.fromDateTimeString(dateHeure);
        setPnoPdptDt(pnoPdptDt);

        if (getPnoDaDt() != null && getPnoTiLb() != null) {
            String heure = getPnoTiLb();

            // si l'heure n'est pas fournie, on prend 0h00
            if (heure == null) {
                heure = "00:00";
            }

            // On crée l'attribut pnoDatiDt (date/heure) qui est une
            // concaténation
            // des attributs pnoDaDt (date) et pnoTiLb (heure)
            String dateHeure2 = converter.toString(getPnoDaDt()) + " " + heure;
            Date pnoDatiDt = (Date) converter.fromDateTimeString(dateHeure2);
            setPnoDatiDt(pnoDatiDt);
        } else {
            setPnoDatiDt(null);
        }

        return this;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichie XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peur être exporté par XStream
     */
    public Pno cloneExportedFields(IExportConfiguration exportConfiguration) {
        Pno clone = new Pno();

        clone.setPnoPdDt(getPnoPdDt());
        clone.setPnoPtLb(getPnoPtLb());
        clone.setPnoPoLb(getPnoPoLb());
        clone.setPnoDaDt(getPnoDaDt());
        clone.setPnoTiLb(getPnoTiLb());
        clone.setPnoPcLb(getPnoPcLb());
        clone.setPnoDsDt(getPnoDsDt());

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
        return "PNO";
    }

    public Ops getOpsAncetre() {
        Ops opsAncetre;

        if (getNonPersistedOps() != null) {
            opsAncetre = getNonPersistedOps();
        } else {
            opsAncetre = ErsUtils.getOps(this);
        }

        return opsAncetre;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDatiDt()
     */
    public Date getDatiDt() {
        Ops opsAncetre = this.getOpsAncetre();
        if (opsAncetre != null) {
            return opsAncetre.getOpsOdotDt();
        } else {
            return this.getPnoDatiDt();
        }
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDatiDt()
     */
    public Date getDaDt() {
        Ops opsAncetre = this.getOpsAncetre();
        if (opsAncetre != null) {
            return opsAncetre.getOpsOdDt();
        } else {
            return this.getPnoDaDt();
        }
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDatiDt()
     */
    public String getTiLb() {
        Ops opsAncetre = this.getOpsAncetre();
        if (opsAncetre != null) {
            return opsAncetre.getOpsOtLb();
        } else {
            return this.getPnoTiLb();
        }
    }

    /**
     * Affecte l'Ops lié au PNO pour pouvoir connaître sa date/heure.
     *
     * @param nonPersistedOps : Ops non persisté
     */
    public void setNonPersistedOps(Ops nonPersistedOps) {
        this.nonPersistedOps = nonPersistedOps;
    }

    /**
     * Retourne l'Ops lié au PNO pour pouvoir connaître sa date/heure.
     *
     * @return l'Ops non persisté
     */
    public Ops getNonPersistedOps() {
        return nonPersistedOps;
    }

    public void addToLog(Log log) {
        if (log.getListPno() == null) {
            log.setListPno(new ArrayList<Pno>());
        }
        log.getListPno().add(this);
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
