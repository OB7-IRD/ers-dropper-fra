package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Navire receveur (uniquement "BFT" : thon rouge, les autres espèces sont dans
 * la balise REC).
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("BTI")
public class Bti implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long btiCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("NA")
    private String btiNaLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("IN")
    private String btiInLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("FN")
    private String btiFnLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("FI")
    private String btiFiLb;

    /**
     * persistent field
     */
    @XStreamAlias("CVT")
    private Cvt cvt;

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
    private List<Rlc> listRlc;

    public Long getBtiCdn() {
        return this.btiCdn;
    }

    public void setBtiCdn(Long btiCdn) {
        this.btiCdn = btiCdn;
    }

    public String getBtiNaLb() {
        return this.btiNaLb;
    }

    public void setBtiNaLb(String btiNaLb) {
        this.btiNaLb = btiNaLb;
    }

    public String getBtiInLb() {
        return this.btiInLb;
    }

    public void setBtiInLb(String btiInLb) {
        this.btiInLb = btiInLb;
    }

    public String getBtiFnLb() {
        return this.btiFnLb;
    }

    public void setBtiFnLb(String btiFnLb) {
        this.btiFnLb = btiFnLb;
    }

    public String getBtiFiLb() {
        return this.btiFiLb;
    }

    public void setBtiFiLb(String btiFiLb) {
        this.btiFiLb = btiFiLb;
    }

    public Pos getPos() {
        return this.pos;
    }

    public void setPos(Pos pos) {
        this.pos = pos;
    }

    public Cvt getCvt() {
        return this.cvt;
    }

    public void setCvt(Cvt cvt) {
        this.cvt = cvt;
    }

    public List<Spe> getListSpe() {if (listSpe == null) {
            listSpe = new ArrayList<>();
        }
        return this.listSpe;
    }

    public void setListSpe(List<Spe> listSpe) {
        this.listSpe = listSpe;
    }

    public List<Rlc> getListRlc() {
        return this.listRlc;
    }

    public void setListRlc(List<Rlc> listRlc) {
        this.listRlc = listRlc;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getBtiCdn();
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
        if (!(other instanceof Bti)) {
            return false;
        }
        Bti castOther = (Bti) other;
        return new EqualsBuilder().append(this.getBtiCdn(),
                castOther.getBtiCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getBtiCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return this.btiCdn;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichier XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peut être exporté par XStream
     */
    public Bti cloneExportedFields(IExportConfiguration exportConfiguration) {
        Bti clone = new Bti();

        clone.setBtiNaLb(getBtiNaLb());
        clone.setBtiInLb(getBtiInLb());
        clone.setBtiFnLb(getBtiFnLb());
        clone.setBtiFiLb(getBtiFiLb());
        clone.setCvt(getCvt().cloneExportedFields(exportConfiguration));
        clone.setPos(getPos().cloneExportedFields(exportConfiguration));

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
