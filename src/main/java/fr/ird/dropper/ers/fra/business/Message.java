package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Message applicatif récupéré de la base de données.
 *
 * @author christelle.jeanberne
 */
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    private String mesCodeLb;

    private String mesFrLb;

    private String mesEnLb;

    private Date mesMajDt;

    public String getMesCodeLb() {
        return mesCodeLb;
    }

    public void setMesCodeLb(String mesCodeLb) {
        this.mesCodeLb = mesCodeLb;
    }

    public String getMesFrLb() {
        return mesFrLb;
    }

    public void setMesFrLb(String mesFrLb) {
        this.mesFrLb = mesFrLb;
    }

    public String getMesEnLb() {
        return mesEnLb;
    }

    public void setMesEnLb(String mesEnLb) {
        this.mesEnLb = mesEnLb;
    }

    public Date getMesMajDt() {
        return mesMajDt;
    }

    public void setMesMajDt(Date mesMajDt) {
        this.mesMajDt = mesMajDt;
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
        if (!(other instanceof Message)) {
            return false;
        }
        Message castOther = (Message) other;
        return new EqualsBuilder().append(this.getMesCodeLb(),
                castOther.getMesCodeLb()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getMesCodeLb()).toHashCode();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "mesCodeLb:" + mesCodeLb + " mesFrLb:" + mesFrLb + " mesEnLb:"
                + mesEnLb + " mesMajDt:" + mesMajDt;
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return mesCodeLb;
    }
}
