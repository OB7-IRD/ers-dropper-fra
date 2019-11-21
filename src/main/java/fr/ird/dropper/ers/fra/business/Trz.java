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
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Déclaration de changement de zone d'effort.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("TRZ")
public class Trz extends EvenementDePecheImpl {

    private static final long serialVersionUID = 5297009911354866152L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long trzCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("COE")
    private Coe coe;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("COX")
    private Cox cox;

    /**
     * persistent field
     */
    @XStreamOmitField
    private Log log;

    public Long getTrzCdn() {
        return this.trzCdn;
    }

    public void setTrzCdn(Long trzCdn) {
        this.trzCdn = trzCdn;
    }

    public Coe getCoe() {
        return this.coe;
    }

    public void setCoe(Coe coe) {
        this.coe = coe;
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

    public Cox getCox() {
        return this.cox;
    }

    public void setCox(Cox cox) {
        this.cox = cox;
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getTrzCdn();
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if (!(other instanceof Trz)) {
            return false;
        }
        Trz castOther = (Trz) other;
        return new EqualsBuilder().append(this.getTrzCdn(),
                castOther.getTrzCdn()).isEquals();
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getTrzCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return trzCdn;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichier XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peut être exporté par XStream
     */
    public Trz cloneExportedFields(IExportConfiguration exportConfiguration) {
        Trz clone = new Trz();

        clone.setCoe(getCoe().cloneExportedFields(exportConfiguration));
        clone.setCox(getCox().cloneExportedFields(exportConfiguration));

        return clone;
    }

    /* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getType()
     */
    public String getType() {
        return "TRZ";
    }

    /* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDatiDt()
     */
    public Date getDatiDt() {
        Date datiDt = null;
        if (getCoe() != null && getCoe().getCoeDatiDt() != null) {
            datiDt = getCoe().getCoeDatiDt();
        }
        if (datiDt == null && getCox() != null && getCox().getCoxDatiDt() != null) {
            datiDt = getCox().getCoxDatiDt();
        }
        return datiDt;
    }

    /* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDaDt()
     */
    public Date getDaDt() {
        Date daDt = null;
        if (getCoe() != null && getCoe().getCoeDaDt() != null) {
            daDt = getCoe().getCoeDaDt();
        }
        if (daDt == null && getCox() != null && getCox().getCoxDaDt() != null) {
            daDt = getCox().getCoxDaDt();
        }
        return daDt;
    }

    /* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getTiLb()
     */
    public String getTiLb() {
        String tiLb = null;
        if (getCoe() != null && getCoe().getCoeTiLb() != null) {
            tiLb = getCoe().getCoeTiLb();
        }
        if (tiLb == null && getCox() != null && getCox().getCoxTiLb() != null) {
            tiLb = getCox().getCoxTiLb();
        }
        return tiLb;

    }

    public void addToLog(Log log) {
        if (log.getListTrz() == null) {
            log.setListTrz(new ArrayList<Trz>());
        }
        log.getListTrz().add(this);
    }

    public List<Ras> getRasList() {
        List<Ras> listRas = new ArrayList<Ras>();
        /*if(getCoe()!=null){
			listRas.addAll(getCoe().getRasList());
		}
		if(getCox()!=null){
			listRas.addAll(getCox().getRasList());
		}*/
        return listRas;

    }
}
