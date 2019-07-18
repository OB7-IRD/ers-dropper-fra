package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Navire receveur (hors "BFT" : thon rouge qui est dans balise BTI).
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("REC")
public class Rec implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long recCdn;

    /**
     * persistent field
     */
    @XStreamAlias("PFP")
    private Pfp pfp;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Rlc> listRlc;

    public Long getRecCdn() {
        return this.recCdn;
    }

    public void setRecCdn(Long recCdn) {
        this.recCdn = recCdn;
    }

    public Pfp getPfp() {
        return this.pfp;
    }

    public void setPfp(Pfp pfp) {
        this.pfp = pfp;
    }

    public List<Rlc> getListRlc() {
        return listRlc;
    }

    public void setListRlc(List<Rlc> listRlc) {
        this.listRlc = listRlc;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getRecCdn();
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
        if (!(other instanceof Rec)) {
            return false;
        }
        Rec castOther = (Rec) other;
        return new EqualsBuilder().append(this.getRecCdn(),
                castOther.getRecCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getRecCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return recCdn;
    }

    /**
     * On va remplir les champs non présents dans le XML reçu. Cette méthode est
     * appelée automatiquement par XStream après la création de l'objet (REC).
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
    public Rec cloneExportedFields(IExportConfiguration exportConfiguration) {
        Rec clone = new Rec();

        if (getPfp() != null) {
            clone.setPfp(getPfp().cloneExportedFields(exportConfiguration));
        } else {
            clone.setPfp(null);
        }

        return clone;
    }
}
