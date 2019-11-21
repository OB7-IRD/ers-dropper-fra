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
 * Extension (précision) sur le matériel récupéré.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("EGER")
public class Eger implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long egerCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("Type")
    private String egerTypeLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("RF")
    private Integer egerRfBl;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Ger> listGer;

    public Long getEgerCdn() {
        return this.egerCdn;
    }

    public void setEgerCdn(Long egerCdn) {
        this.egerCdn = egerCdn;
    }

    public String getEgerTypeLb() {
        return this.egerTypeLb;
    }

    public void setEgerTypeLb(String egerTypeLb) {
        this.egerTypeLb = egerTypeLb;
    }

    public Integer getEgerRfBl() {
        return this.egerRfBl;
    }

    public void setEgerRfBl(Integer egerRfBl) {
        this.egerRfBl = egerRfBl;
    }

    public List<Ger> getListGer() {
        if (listGer == null) {
            listGer = new ArrayList<>();
        }
        return this.listGer;
    }

    public void setListGer(List<Ger> listGer) {
        this.listGer = listGer;
    }

    @Override
    public String toString() {
        return "Eger{" + "egerTypeLb=" + egerTypeLb + ", egerRfBl=" + egerRfBl + ", listGer=" + listGer + '}';
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
        if (!(other instanceof Eger)) {
            return false;
        }
        Eger castOther = (Eger) other;
        return new EqualsBuilder().append(this.getEgerCdn(),
                castOther.getEgerCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getEgerCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return egerCdn;
    }

    /**
     * On va remplir les champs non présents dans le XML reçu. Cette méthode est
     * appelée automatiquement par XStream après la création de l'objet (EGER).
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
    public Eger cloneExportedFields(IExportConfiguration exportConfiguration) {
        Eger clone = new Eger();

        clone.setEgerTypeLb(getEgerTypeLb());
        clone.setEgerRfBl(getEgerRfBl());

        return clone;
    }
}
