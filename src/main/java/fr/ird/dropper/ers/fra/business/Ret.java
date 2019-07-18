package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Message de retour.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("RET")
public class Ret implements Serializable {

    private static final long serialVersionUID = 6524469966162317945L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long retCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("RS")
    private String retRsLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("ON")
    private String retOnLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("RE")
    private String retReLb;

    /**
     * persistent field
     */
    @XStreamOmitField
    private Ers ers;

    /**
     * persistent field
     */
    @XStreamOmitField
    private Ops ops;

    /**
     * persistent field
     */
    @XStreamOmitField
    private Ops opsAcquite;

    /**
     * persistent field
     */
    @XStreamOmitField
    private String retIrAcquit;

    /**
     * persistent field
     */
    @XStreamOmitField
    private String retXrAcquit;

    /**
     * persistent field
     */
    @XStreamOmitField
    private String retRcAcquit;

    /**
     * persistent field
     */
    @XStreamOmitField
    private String retNaAcquit;

    /**
     * non persistent field
     */
    @XStreamOmitField
    private boolean transfertAcquittement = false;

    public Long getRetCdn() {
        return this.retCdn;
    }

    public void setRetCdn(Long retCdn) {
        this.retCdn = retCdn;
    }

    public String getRetRsLb() {
        return this.retRsLb;
    }

    public void setRetRsLb(String retRsLb) {
        this.retRsLb = retRsLb;
    }

    public String getRetOnLb() {
        return this.retOnLb;
    }

    public void setRetOnLb(String retOnLb) {
        this.retOnLb = retOnLb;
    }

    public String getRetReLb() {
        return this.retReLb;
    }

    public void setRetReLb(String retReLb) {
        this.retReLb = retReLb;
    }

    public Ers getErs() {
        return this.ers;
    }

    public void setErs(Ers ers) {
        this.ers = ers;
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
        return "" + getRetCdn();
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
        if (!(other instanceof Ret)) {
            return false;
        }
        Ret castOther = (Ret) other;
        return new EqualsBuilder().append(this.getRetCdn(),
                castOther.getRetCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getRetCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return retCdn;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichier XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peut être exporté par XStream
     */
    public Ret cloneExportedFields(IExportConfiguration exportConfiguration) {
        Ret clone = new Ret();

        clone.setRetRsLb(getRetRsLb());
        clone.setRetOnLb(getRetOnLb());
        clone.setRetReLb(getRetReLb());

        Ers ers = getErs();
        if (ers != null) {
            clone.setErs(ers.cloneExportedFields(exportConfiguration));
        } else {
            clone.setErs(null);
        }

        return clone;
    }

    /**
     * @param opsAcquite the opsAcquite to set
     */
    public void setOpsAcquite(Ops opsAcquite) {
        if (opsAcquite != null && opsAcquite.isTsRenseigne()) {
            // si on renseigne l'opsAcquite, il sera persité en base, ce qui ne doit
            // pas être fait si son attribut TS est renseigné (règle MSGR06)
            this.opsAcquite = null;
        } else {
            this.opsAcquite = opsAcquite;
        }
    }

    /**
     * @return the opsAcquite
     */
    public Ops getOpsAcquite() {
        return opsAcquite;
    }

    /**
     * @return the transfertAcquittement
     */
    public boolean isTransfertAcquittement() {
        return transfertAcquittement;
    }

    /**
     * @param transfertAcquittement the transfertAcquittement to set
     */
    public void setTransfertAcquittement(boolean transfertAcquittement) {
        this.transfertAcquittement = transfertAcquittement;
    }

    /**
     * @return the retIrAcquit
     */
    public String getRetIrAcquit() {
        return retIrAcquit;
    }

    /**
     * @param retIrAcquit the retIrAcquit to set
     */
    public void setRetIrAcquit(String retIrAcquit) {
        this.retIrAcquit = retIrAcquit;
    }

    /**
     * @return the retXrAcquit
     */
    public String getRetXrAcquit() {
        return retXrAcquit;
    }

    /**
     * @param retXrAcquit the retXrAcquit to set
     */
    public void setRetXrAcquit(String retXrAcquit) {
        this.retXrAcquit = retXrAcquit;
    }

    /**
     * @return the retRcAcquit
     */
    public String getRetRcAcquit() {
        return retRcAcquit;
    }

    /**
     * @param retRcAcquit the retRcAcquit to set
     */
    public void setRetRcAcquit(String retRcAcquit) {
        this.retRcAcquit = retRcAcquit;
    }

    /**
     * @return the retNaAcquit
     */
    public String getRetNaAcquit() {
        return retNaAcquit;
    }

    /**
     * @param retNaAcquit the retNaAcquit to set
     */
    public void setRetNaAcquit(String retNaAcquit) {
        this.retNaAcquit = retNaAcquit;
    }
}
