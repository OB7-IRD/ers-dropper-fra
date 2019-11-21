package fr.ird.dropper.ers.fra.business;

import fr.ird.dropper.ers.fra.business.*;
import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Sous déclaration des captures pour les espèces "TT" (caouane, torpilles,
 * tortues, virli).
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("ETTS")
public class Etts implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long ettsCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("Type")
    private String ettsTypeLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("HN")
    private Integer ettsHnNb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("CD")
    private String ettsCdLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("SC")
    private Double ettsScNb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("SS")
    private Integer ettsSsNb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("ST")
    private Double ettsStNb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("WD")
    private String ettsWdLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("WS")
    private Double ettsWsNb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("FA")
    private String ettsFaLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("CM")
    private String ettsCmLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("SO")
    private Double ettsSoNb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("MP")
    private String ettsMpLb;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Efar> listEfar;

    public Long getEttsCdn() {
        return this.ettsCdn;
    }

    public void setEttsCdn(Long ettsCdn) {
        this.ettsCdn = ettsCdn;
    }

    public String getEttsTypeLb() {
        return this.ettsTypeLb;
    }

    public void setEttsTypeLb(String ettsTypeLb) {
        this.ettsTypeLb = ettsTypeLb;
    }

    public Integer getEttsHnNb() {
        return this.ettsHnNb;
    }

    public void setEttsHnNb(Integer ettsHnNb) {
        this.ettsHnNb = ettsHnNb;
    }

    public String getEttsCdLb() {
        return this.ettsCdLb;
    }

    public void setEttsCdLb(String ettsCdLb) {
        this.ettsCdLb = ettsCdLb;
    }

    public Double getEttsScNb() {
        return this.ettsScNb;
    }

    public void setEttsScNb(Double ettsScNb) {
        this.ettsScNb = ettsScNb;
    }

    public Integer getEttsSsNb() {
        return this.ettsSsNb;
    }

    public void setEttsSsNb(Integer ettsSsNb) {
        this.ettsSsNb = ettsSsNb;
    }

    public Double getEttsStNb() {
        return this.ettsStNb;
    }

    public void setEttsStNb(Double ettsStNb) {
        this.ettsStNb = ettsStNb;
    }

    public String getEttsWdLb() {
        return this.ettsWdLb;
    }

    public void setEttsWdLb(String ettsWdLb) {
        this.ettsWdLb = ettsWdLb;
    }

    public Double getEttsWsNb() {
        return this.ettsWsNb;
    }

    public void setEttsWsNb(Double ettsWsNb) {
        this.ettsWsNb = ettsWsNb;
    }

    public String getEttsFaLb() {
        return this.ettsFaLb;
    }

    public void setEttsFaLb(String ettsFaLb) {
        this.ettsFaLb = ettsFaLb;
    }

    public String getEttsCmLb() {
        return this.ettsCmLb;
    }

    public void setEttsCmLb(String ettsCmLb) {
        this.ettsCmLb = ettsCmLb;
    }

    public Double getEttsSoNb() {
        return this.ettsSoNb;
    }

    public void setEttsSoNb(Double ettsSoNb) {
        this.ettsSoNb = ettsSoNb;
    }

    public String getEttsMpLb() {
        return this.ettsMpLb;
    }

    public void setEttsMpLb(String ettsMpLb) {
        this.ettsMpLb = ettsMpLb;
    }

    public List<Efar> getListEfar() {
        return listEfar;
    }

    public void setListEfar(List<Efar> listEfar) {
        this.listEfar = listEfar;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getEttsCdn();
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
        if (!(other instanceof Etts)) {
            return false;
        }
        Etts castOther = (Etts) other;
        return new EqualsBuilder().append(this.getEttsCdn(),
                castOther.getEttsCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getEttsCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return ettsCdn;
    }

    /**
     * On va remplir les champs non présents dans le XML reçu. Cette méthode est
     * appelée automatiquement par XStream après la création de l'objet (ETTS).
     *
     * @return this
     */
    private Object readResolve() {
        return this;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichier XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peut être exporté par XStream
     */
    public Etts cloneExportedFields(IExportConfiguration exportConfiguration) {
        Etts clone = new Etts();

        clone.setEttsTypeLb(getEttsTypeLb());
        clone.setEttsHnNb(getEttsHnNb());
        clone.setEttsCdLb(getEttsCdLb());
        clone.setEttsScNb(getEttsScNb());
        clone.setEttsSsNb(getEttsSsNb());
        clone.setEttsStNb(getEttsStNb());
        clone.setEttsWdLb(getEttsWdLb());
        clone.setEttsWsNb(getEttsWsNb());
        clone.setEttsFaLb(getEttsFaLb());
        clone.setEttsCmLb(getEttsCmLb());
        clone.setEttsSoNb(getEttsSoNb());
        clone.setEttsMpLb(getEttsMpLb());

        return clone;
    }
}
