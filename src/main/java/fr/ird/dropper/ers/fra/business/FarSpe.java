package fr.ird.dropper.ers.fra.business;

import fr.ird.dropper.ers.fra.business.*;
import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Table d'association entre les captures et les espèces.
 *
 * @author christelle.jeanberne
 */
public class FarSpe implements Serializable {

    private static final long serialVersionUID = -5879283349046063838L;

    /**
     * identifier field
     */
    private Long fsCdn;

    /**
     * persistent field
     */
    @XStreamAlias("SPE")
    private Spe Spe;

    /**
     * persistent field
     */
    @XStreamOmitField
    private Far far;

    /**
     * full constructor
     */
    public FarSpe(Long fsCdn, Spe Spe, Far far) {
        this.fsCdn = fsCdn;
        this.Spe = Spe;
        this.far = far;
    }

    /**
     * default constructor
     */
    public FarSpe() {
    }

    public Long getFsCdn() {
        return this.fsCdn;
    }

    public void setFsCdn(Long fsCdn) {
        this.fsCdn = fsCdn;
    }

    public Spe getSpe() {
        return this.Spe;
    }

    public void setSpe(Spe Spe) {
        this.Spe = Spe;
    }

    public Far getFar() {
        return this.far;
    }

    public void setFar(Far far) {
        this.far = far;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getFsCdn();
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
        if (!(other instanceof FarSpe)) {
            return false;
        }
        FarSpe castOther = (FarSpe) other;
        return new EqualsBuilder()
                .append(this.getFsCdn(), castOther.getFsCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getFsCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return fsCdn;
    }
}
