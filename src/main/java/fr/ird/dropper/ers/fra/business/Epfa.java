package fr.ird.dropper.ers.fra.business;

import fr.ird.dropper.ers.fra.business.*;
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
 * Captures relâchées ou récupérées.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("EPFA")
public class Epfa implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long epfaCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("Type")
    private String epfaTypeLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("PF")
    private String epfaPfLb;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Efar> listEfar;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "EFAD")
    private List<Efad> listEfad;

    public Long getEpfaCdn() {
        return this.epfaCdn;
    }

    public void setEpfaCdn(Long epfaCdn) {
        this.epfaCdn = epfaCdn;
    }

    public String getEpfaTypeLb() {
        return this.epfaTypeLb;
    }

    public void setEpfaTypeLb(String epfaTypeLb) {
        this.epfaTypeLb = epfaTypeLb;
    }

    public String getEpfaPfLb() {
        return this.epfaPfLb;
    }

    public void setEpfaPfLb(String epfaPfLb) {
        this.epfaPfLb = epfaPfLb;
    }

    public List<Efar> getListEfar() {
        if (listEfar == null) {
            listEfar = new ArrayList<>();
        }
        return listEfar;
    }

    public void setListEfar(List<Efar> listEfar) {
        this.listEfar = listEfar;
    }

    public List<Efad> getListEfad() {
        if (listEfad == null) {
            listEfad = new ArrayList<>();
        }
        return this.listEfad;
    }

    public void setListEfad(List<Efad> listEfad) {
        this.listEfad = listEfad;
    }

    @Override
    public String toString() {
        return "Epfa{" + "epfaTypeLb=" + epfaTypeLb + ", epfaPfLb=" + epfaPfLb + ", listEfar=" + listEfar + ", listEfad=" + listEfad + '}';
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
        if (!(other instanceof Epfa)) {
            return false;
        }
        Epfa castOther = (Epfa) other;
        return new EqualsBuilder().append(this.getEpfaCdn(),
                castOther.getEpfaCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getEpfaCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return epfaCdn;
    }

    /**
     * On va remplir les champs non présents dans le XML reçu. Cette méthode est
     * appelée automatiquement par XStream après la création de l'objet (EPFA).
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
    public Epfa cloneExportedFields(IExportConfiguration exportConfiguration) {
        Epfa clone = new Epfa();

        clone.setEpfaTypeLb(getEpfaTypeLb());
        clone.setEpfaPfLb(getEpfaPfLb());

        // Clone des EFAD
        if (getListEfad() != null && !getListEfad().isEmpty()) {
            ArrayList<Efad> cloneEfads = new ArrayList<Efad>();
            for (Efad efad : getListEfad()) {
                cloneEfads.add(efad.cloneExportedFields(exportConfiguration));
            }
            clone.setListEfad(cloneEfads);
        }

        return clone;
    }
}
