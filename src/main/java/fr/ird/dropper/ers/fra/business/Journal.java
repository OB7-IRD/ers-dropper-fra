package fr.ird.dropper.ers.fra.business;

import fr.ird.dropper.ers.fra.business.*;
import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * @author christelle.jeanberne
 *
 */
public class Journal implements Serializable {

    private static final long serialVersionUID = 7411598948043904177L;

    /**
     * identifier field
     */
    private Long jouCdn;

    /**
     * persistent field
     */
    private String jouMsgLb;

    /**
     * persistent field
     */
    private Date jouCreationDt;

    /**
     * persistent field
     */
    private String jouTypeLb;

    /**
     * persistent field
     */
    private String jouCleLb;

    /**
     * nullable persistent field
     */
    private Long jouFdCdn;

    /**
     * persistent field
     */
    private boolean jouAlerteBl;

    /**
     * persistent field
     */
    private boolean jouTraiteBl;

    /**
     * persistent field
     */
    private Ops ops = null;

    /**
     * full constructor
     */
    public Journal(Long jouCdn, String jouMsgLb, Date jouCreationDt,
            String jouTypeLb, String jouCleLb, Long jouFdCdn,
            boolean jouAlerteBl, boolean jouTraiteBl, Ops ops) {
        this.jouCdn = jouCdn;
        this.jouMsgLb = jouMsgLb;
        this.jouCreationDt = jouCreationDt;
        this.jouTypeLb = jouTypeLb;
        this.jouCleLb = jouCleLb;
        this.jouFdCdn = jouFdCdn;
        this.jouAlerteBl = jouAlerteBl;
        this.jouTraiteBl = jouTraiteBl;
        this.ops = ops;
    }

    /**
     * default constructor
     */
    public Journal() {
    }

    /**
     * minimal constructor
     */
    public Journal(Long jouCdn, String jouMsgLb, Date jouCreationDt,
            String jouTypeLb, String jouCleLb, boolean jouAlerteBl,
            boolean jouTraiteBl, Ops ops) {
        this.jouCdn = jouCdn;
        this.jouMsgLb = jouMsgLb;
        this.jouCreationDt = jouCreationDt;
        this.jouTypeLb = jouTypeLb;
        this.jouCleLb = jouCleLb;
        this.jouAlerteBl = jouAlerteBl;
        this.jouTraiteBl = jouTraiteBl;
        this.ops = ops;
    }

    public Long getJouCdn() {
        return this.jouCdn;
    }

    public void setJouCdn(Long jouCdn) {
        this.jouCdn = jouCdn;
    }

    public String getJouMsgLb() {
        return this.jouMsgLb;
    }

    public void setJouMsgLb(String jouMsgLb) {
        this.jouMsgLb = jouMsgLb;
    }

    public Date getJouCreationDt() {
        return this.jouCreationDt;
    }

    public void setJouCreationDt(Date jouCreationDt) {
        this.jouCreationDt = jouCreationDt;
    }

    public String getJouTypeLb() {
        return this.jouTypeLb;
    }

    public void setJouTypeLb(String jouTypeLb) {
        this.jouTypeLb = jouTypeLb;
    }

    public String getJouCleLb() {
        return this.jouCleLb;
    }

    public void setJouCleLb(String jouCleLb) {
        this.jouCleLb = jouCleLb;
    }

    public Long getJouFdCdn() {
        return this.jouFdCdn;
    }

    public void setJouFdCdn(Long jouFdCdn) {
        this.jouFdCdn = jouFdCdn;
    }

    public boolean isJouAlerteBl() {
        return this.jouAlerteBl;
    }

    public void setJouAlerteBl(boolean jouAlerteBl) {
        this.jouAlerteBl = jouAlerteBl;
    }

    public boolean isJouTraiteBl() {
        return this.jouTraiteBl;
    }

    public void setJouTraiteBl(boolean jouTraiteBl) {
        this.jouTraiteBl = jouTraiteBl;
    }

    public Ops getOps() {
        return this.ops;
    }

    public void setOps(Ops ops) {
        this.ops = ops;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getJouCdn();
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
        if (!(other instanceof Journal)) {
            return false;
        }
        Journal castOther = (Journal) other;
        return new EqualsBuilder().append(this.getJouCdn(),
                castOther.getJouCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getJouCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return jouCdn;
    }
}
