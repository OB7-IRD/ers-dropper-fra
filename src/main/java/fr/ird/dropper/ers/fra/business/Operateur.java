package fr.ird.dropper.ers.fra.business;

import fr.ird.dropper.ers.fra.business.*;
import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Opérateur.
 *
 * @author christelle.jeanberne
 */
public class Operateur implements Serializable {

    private static final long serialVersionUID = 4666162858055363756L;

    /**
     * identifier field
     */
    private String oprRfa;

    /**
     * persistent field
     */
    private String oprLb;

    /**
     * persistent field
     */
    private boolean oprCauBl;

    /**
     * persistent field
     */
    private List<OperateurNavire> listOperateurNavire;

    /**
     * persistent field
     */
    private List<Ops> listOps;

    /**
     * persistent field
     */
    private List<Emav> listEmav;

    public String getOprRfa() {
        return this.oprRfa;
    }

    public void setOprRfa(String oprRfa) {
        this.oprRfa = oprRfa;
    }

    public String getOprLb() {
        return this.oprLb;
    }

    public void setOprLb(String oprLb) {
        this.oprLb = oprLb;
    }

    public boolean isOprCauBl() {
        return this.oprCauBl;
    }

    public void setOprCauBl(boolean oprCauBl) {
        this.oprCauBl = oprCauBl;
    }

    public List<OperateurNavire> getListOperateurNavire() {
        return this.listOperateurNavire;
    }

    public void setListOperateurNavire(List<OperateurNavire> listOperateurNavire) {
        this.listOperateurNavire = listOperateurNavire;
    }

    public List<Ops> getListOps() {
        return this.listOps;
    }

    public void setListOps(List<Ops> listOps) {
        this.listOps = listOps;
    }

    public List<Emav> getListEmav() {
        return this.listEmav;
    }

    public void setListEmav(List<Emav> listEmav) {
        this.listEmav = listEmav;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getOprRfa();
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
        if (!(other instanceof Operateur)) {
            return false;
        }
        Operateur castOther = (Operateur) other;
        return new EqualsBuilder().append(this.getOprRfa(),
                castOther.getOprRfa()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getOprRfa()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return oprRfa;
    }
}
