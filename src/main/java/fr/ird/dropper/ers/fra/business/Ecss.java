package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.util.ArrayList;

/**
 * Extension(précision) des envois vendus.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("ECSS")
public class Ecss implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long ecssCdn;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("EF")
    private String ecssEfLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("RR")
    private String ecssRrLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("VC")
    private String ecssVcLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("type")
    private String ecssTypeLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("PN")
    private String ecssPnLb;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Css> listCss;

    public Long getEcssCdn() {
        return ecssCdn;
    }

    public void setEcssCdn(Long ecssCdn) {
        this.ecssCdn = ecssCdn;
    }

    public String getEcssEfLb() {
        return ecssEfLb;
    }

    public void setEcssEfLb(String ecssEfLb) {
        this.ecssEfLb = ecssEfLb;
    }

    public String getEcssRrLb() {
        return ecssRrLb;
    }

    public void setEcssRrLb(String ecssRrLb) {
        this.ecssRrLb = ecssRrLb;
    }

    public String getEcssVcLb() {
        return ecssVcLb;
    }

    public void setEcssVcLb(String ecssVcLb) {
        this.ecssVcLb = ecssVcLb;
    }

    public String getEcssTypeLb() {
        return ecssTypeLb;
    }

    public void setEcssTypeLb(String ecssTypeLb) {
        this.ecssTypeLb = ecssTypeLb;
    }

    public String getEcssPnLb() {
        return ecssPnLb;
    }

    public void setEcssPnLb(String ecssPnLb) {
        this.ecssPnLb = ecssPnLb;
    }

    public List<Css> getListCss() {
        if (listCss == null) {
            listCss = new ArrayList<>();
        }
        return listCss;
    }

    public void setListCss(List<Css> listCss) {
        this.listCss = listCss;
    }

    @Override
    public String toString() {
        return "Ecss{" + "ecssEfLb=" + ecssEfLb + ", ecssRrLb=" + ecssRrLb + ", ecssVcLb=" + ecssVcLb + ", ecssTypeLb=" + ecssTypeLb + ", ecssPnLb=" + ecssPnLb + ", listCss=" + listCss + '}';
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
        if (!(other instanceof Ecss)) {
            return false;
        }
        Ecss castOther = (Ecss) other;
        return new EqualsBuilder().append(this.getEcssCdn(),
                castOther.getEcssCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getEcssCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return ecssCdn;
    }

    /**
     * On va remplir les champs non présents dans le XML reçu. Cette méthode est
     * appelée automatiquement par XStream après la création de l'objet (ECSS).
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
    public Ecss cloneExportedFields(IExportConfiguration exportConfiguration) {
        Ecss clone = new Ecss();

        clone.setEcssTypeLb(getEcssTypeLb());
        clone.setEcssEfLb(getEcssEfLb());
        clone.setEcssRrLb(getEcssRrLb());
        clone.setEcssVcLb(getEcssVcLb());
        clone.setEcssPnLb(getEcssPnLb());

        return clone;
    }
}
