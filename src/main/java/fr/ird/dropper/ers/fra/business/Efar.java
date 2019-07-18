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
 * Extension (précision) de la capture.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("EFAR")
public class Efar implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long efarCdn;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("DF")
    private Integer efarDfNb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("Type")
    private String efarTypeLb;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Far> listFar;

    /**
     * persistent field
     */
    @XStreamAlias("ETTS")
    private Etts etts;

    /**
     * persistent field
     */
    @XStreamAlias("EPFA")
    private Epfa epfa;

    public Long getEfarCdn() {
        return this.efarCdn;
    }

    public void setEfarCdn(Long efarCdn) {
        this.efarCdn = efarCdn;
    }

    public Integer getEfarDfNb() {
        return this.efarDfNb;
    }

    public void setEfarDfNb(Integer efarDfNb) {
        this.efarDfNb = efarDfNb;
    }

    public String getEfarTypeLb() {
        return this.efarTypeLb;
    }

    public void setEfarTypeLb(String efarTypeLb) {
        this.efarTypeLb = efarTypeLb;
    }

    public List<Far> getListFar() {
        if (listFar == null) {
            listFar = new ArrayList<>();
        }
        return listFar;
    }

    public void setListFar(List<Far> listFar) {
        this.listFar = listFar;
    }

    public Etts getEtts() {
        return this.etts;
    }

    public void setEtts(Etts etts) {
        this.etts = etts;
    }

    public Epfa getEpfa() {
        return this.epfa;
    }

    public void setEpfa(Epfa epfa) {
        this.epfa = epfa;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getEfarCdn();
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
        if (!(other instanceof Efar)) {
            return false;
        }
        Efar castOther = (Efar) other;
        return new EqualsBuilder().append(this.getEfarCdn(),
                castOther.getEfarCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getEfarCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return efarCdn;
    }

    /**
     * On va remplir les champs non présents dans le XML reçu. Cette méthode est
     * appelée automatiquement par XStream après la création de l'objet (EFAR).
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
    public Efar cloneExportedFields(IExportConfiguration exportConfiguration) {
        Efar clone = new Efar();

        clone.setEfarTypeLb(getEfarTypeLb());
        clone.setEfarDfNb(getEfarDfNb());

        Etts etts = getEtts();
        if (etts != null) {
            clone.setEtts(etts.cloneExportedFields(exportConfiguration));
        } else {
            clone.setEtts(null);
        }

        Epfa epfa = getEpfa();
        if (epfa != null) {
            clone.setEpfa(epfa.cloneExportedFields(exportConfiguration));
        } else {
            clone.setEpfa(null);
        }

        return clone;
    }
}
