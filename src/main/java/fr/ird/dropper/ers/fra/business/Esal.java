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
 * Extension (précision) de la note de vente.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("ESAL")
public class Esal implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long esalCdn;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("NM")
    private String esalNmLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("Type")
    private String esalTypeLb;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Sal> listSal;

    public Long getEsalCdn() {
        return esalCdn;
    }

    public void setEsalCdn(Long esalCdn) {
        this.esalCdn = esalCdn;
    }

    public String getEsalNmLb() {
        return esalNmLb;
    }

    public void setEsalNmLb(String esalNmLb) {
        this.esalNmLb = esalNmLb;
    }

    public String getEsalTypeLb() {
        return esalTypeLb;
    }

    public void setEsalTypeLb(String esalTypeLb) {
        this.esalTypeLb = esalTypeLb;
    }

    public List<Sal> getListSal() {
        if (listSal == null) {
            listSal = new ArrayList<>();
        }
        return listSal;
    }

    public void setListSal(List<Sal> listSal) {
        this.listSal = listSal;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getEsalCdn();
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
        if (!(other instanceof Esal)) {
            return false;
        }
        Esal castOther = (Esal) other;
        return new EqualsBuilder().append(this.getEsalCdn(),
                castOther.getEsalCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getEsalCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return esalCdn;
    }

    /**
     * On va remplir les champs non présents dans le XML reçu. Cette méthode est
     * appelée automatiquement par XStream après la création de l'objet (ESAL).
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
    public Esal cloneExportedFields(IExportConfiguration exportConfiguration) {
        Esal clone = new Esal();

        clone.setEsalTypeLb(getEsalTypeLb());
        clone.setEsalNmLb(getEsalNmLb());

        return clone;
    }
}
