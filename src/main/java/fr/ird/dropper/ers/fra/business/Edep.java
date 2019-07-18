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
 * Extension (précision) du départ du port.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("EDEP")
public class Edep implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long edepCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("Type")
    private String edepTypeLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("ND")
    private Double edepNdNb;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Dep> listDep;

    public Long getEdepCdn() {
        return this.edepCdn;
    }

    public void setEdepCdn(Long edepCdn) {
        this.edepCdn = edepCdn;
    }

    public String getEdepTypeLb() {
        return this.edepTypeLb;
    }

    public void setEdepTypeLb(String edepTypeLb) {
        this.edepTypeLb = edepTypeLb;
    }

    public Double getEdepNdNb() {
        return this.edepNdNb;
    }

    public void setEdepNdNb(Double edepNdNb) {
        this.edepNdNb = edepNdNb;
    }

    public List<Dep> getListDep() {
        if (listDep == null) {
            listDep = new ArrayList<>();
        }
        return this.listDep;
    }

    public void setListDep(List<Dep> listDep) {
        this.listDep = listDep;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getEdepCdn();
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
        if (!(other instanceof Edep)) {
            return false;
        }
        Edep castOther = (Edep) other;
        return new EqualsBuilder().append(this.getEdepCdn(),
                castOther.getEdepCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getEdepCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return edepCdn;
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
    public Edep cloneExportedFields(IExportConfiguration exportConfiguration) {
        Edep clone = new Edep();

        clone.setEdepTypeLb(getEdepTypeLb());
        clone.setEdepNdNb(getEdepNdNb());

        return clone;
    }
}
