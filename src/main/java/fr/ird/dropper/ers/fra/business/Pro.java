package fr.ird.dropper.ers.fra.business;

import fr.ird.dropper.ers.fra.business.*;
import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.util.ArrayList;

/**
 * Traitement sur le poisson.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("PRO")
public class Pro implements Serializable {

    private static final long serialVersionUID = -3479691165440373908L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long proCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("FF")
    private String proFfLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("PS")
    private String proPsLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("PR")
    private String proPrLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("TY")
    private String proTyLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("NN")
    private Integer proNnNb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("AW")
    private Double proAwNb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("CF")
    private Double proCfNb;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Spe> listSpe;

    public Long getProCdn() {
        return this.proCdn;
    }

    public void setProCdn(Long proCdn) {
        this.proCdn = proCdn;
    }

    public String getProFfLb() {
        return this.proFfLb;
    }

    public void setProFfLb(String proFfLb) {
        this.proFfLb = proFfLb;
    }

    public String getProPsLb() {
        return this.proPsLb;
    }

    public void setProPsLb(String proPsLb) {
        this.proPsLb = proPsLb;
    }

    public String getProPrLb() {
        return this.proPrLb;
    }

    public void setProPrLb(String proPrLb) {
        this.proPrLb = proPrLb;
    }

    public String getProTyLb() {
        return this.proTyLb;
    }

    public void setProTyLb(String proTyLb) {
        this.proTyLb = proTyLb;
    }

    public Integer getProNnNb() {
        return this.proNnNb;
    }

    public void setProNnNb(Integer proNnNb) {
        this.proNnNb = proNnNb;
    }

    public Double getProAwNb() {
        return this.proAwNb;
    }

    public void setProAwNb(Double proAwNb) {
        this.proAwNb = proAwNb;
    }

    public Double getProCfNb() {
        return this.proCfNb;
    }

    public void setProCfNb(Double proCfNb) {
        this.proCfNb = proCfNb;
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
        return "" + getProCdn();
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
        if (!(other instanceof Pro)) {
            return false;
        }
        Pro castOther = (Pro) other;
        return new EqualsBuilder().append(this.getProCdn(),
                castOther.getProCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getProCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return proCdn;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichie XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peur être exporté par XStream
     */
    public Pro cloneExportedFields(IExportConfiguration exportConfiguration) {
        Pro clone = new Pro();

        clone.setProFfLb(getProFfLb());
        clone.setProPsLb(getProPsLb());
        clone.setProPrLb(getProPrLb());
        clone.setProTyLb(getProTyLb());
        clone.setProNnNb(getProNnNb());
        clone.setProAwNb(getProAwNb());
        clone.setProCfNb(getProCfNb());

        return clone;
    }
}
