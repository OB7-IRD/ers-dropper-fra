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
 * Extension (précision) du retour au port.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("ERTP")
public class Ertp implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long ertpCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("Type")
    private String ertpTypeLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("ND")
    private Double ertpNdNb;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Rtp> listRtp;

    public Long getErtpCdn() {
        return this.ertpCdn;
    }

    public void setErtpCdn(Long ertpCdn) {
        this.ertpCdn = ertpCdn;
    }

    public String getErtpTypeLb() {
        return ertpTypeLb;
    }

    public void setErtpTypeLb(String ertpTypeLb) {
        this.ertpTypeLb = ertpTypeLb;
    }

    public Double getErtpNdNb() {
        return this.ertpNdNb;
    }

    public void setErtpNdNb(Double ertpNdNb) {
        this.ertpNdNb = ertpNdNb;
    }

    public List<Rtp> getListRtp() {
        if (listRtp == null) {
            listRtp = new ArrayList<>();
        }
        return this.listRtp;
    }

    public void setListRtp(List<Rtp> listRtp) {
        this.listRtp = listRtp;
    }

    @Override
    public String toString() {
        return "Ertp{" + "ertpTypeLb=" + ertpTypeLb + ", ertpNdNb=" + ertpNdNb + ", listRtp=" + listRtp + '}';
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
        if (!(other instanceof Ertp)) {
            return false;
        }
        Ertp castOther = (Ertp) other;
        return new EqualsBuilder().append(this.getErtpCdn(),
                castOther.getErtpCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getErtpCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return ertpCdn;
    }

    /**
     * On va remplir les champs non présents dans le XML reçu. Cette méthode est
     * appelée automatiquement par XStream après la création de l'objet (ERTP).
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
    public Ertp cloneExportedFields(IExportConfiguration exportConfiguration) {
        Ertp clone = new Ertp();

        clone.setErtpTypeLb(getErtpTypeLb());
        clone.setErtpNdNb(getErtpNdNb());

        return clone;
    }
}
