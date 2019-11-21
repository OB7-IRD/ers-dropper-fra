package fr.ird.dropper.ers.fra.business;

import fr.ird.dropper.ers.fra.business.*;
import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Navire donneur.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("DON")
public class Don implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long donCdn;

    /**
     * persistent field
     */
    @XStreamAlias("PFP")
    private Pfp pfp;

    /**
     * persistent field
     */
    @XStreamOmitField
    private Rlc rlc;

    public Long getDonCdn() {
        return this.donCdn;
    }

    public void setDonCdn(Long donCdn) {
        this.donCdn = donCdn;
    }

    public Pfp getPfp() {
        return this.pfp;
    }

    public void setPfp(Pfp pfp) {
        this.pfp = pfp;
    }

    public Rlc getRlc() {
        return this.rlc;
    }

    public void setRlc(Rlc rlc) {
        this.rlc = rlc;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getDonCdn();
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
        if (!(other instanceof Don)) {
            return false;
        }
        Don castOther = (Don) other;
        return new EqualsBuilder().append(this.getDonCdn(),
                castOther.getDonCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getDonCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return getDonCdn();
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichier XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peut être exporté par XStream
     */
    public Don cloneExportedFields(IExportConfiguration exportConfiguration) {
        Don clone = new Don();

        if (getPfp() != null) {
            clone.setPfp(getPfp().cloneExportedFields(exportConfiguration));
        } else {
            clone.setPfp(null);
        }

        return clone;
    }
}
