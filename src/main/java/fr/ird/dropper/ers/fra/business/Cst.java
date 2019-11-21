package fr.ird.dropper.ers.fra.business;

import fr.ird.dropper.ers.fra.business.*;
import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.util.ArrayList;

/**
 * Envois repris.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("CST")
public class Cst implements Serializable {

    private static final long serialVersionUID = 3740049050984109086L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long cstCdn;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("SF")
    private String cstSfLb;

    /**
     * persistent field
     */
    @XStreamAlias("SPE")
    private Spe spe;

    /**
     * nullable persistent field
     */
    @XStreamAlias("ECST")
    private Ecst ecst;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Tli> listTli;

    public Long getCstCdn() {
        return this.cstCdn;
    }

    public void setCstCdn(Long cstCdn) {
        this.cstCdn = cstCdn;
    }

    public String getCstSfLb() {
        return this.cstSfLb;
    }

    public void setCstSfLb(String cstSfLb) {
        this.cstSfLb = cstSfLb;
    }

    public Spe getSpe() {
        return this.spe;
    }

    public void setSpe(Spe spe) {
        this.spe = spe;
    }

    public Ecst getEcst() {
        return this.ecst;
    }

    public void setEcst(Ecst ecst) {
        this.ecst = ecst;
    }

    public List<Tli> getListTli() {
        if (listTli == null) {
            listTli = new ArrayList<>();
        }
        return this.listTli;
    }

    public void setListTli(List<Tli> listTli) {
        this.listTli = listTli;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getCstCdn();
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
        if (!(other instanceof Cst)) {
            return false;
        }
        Cst castOther = (Cst) other;
        return new EqualsBuilder().append(this.getCstCdn(),
                castOther.getCstCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getCstCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return cstCdn;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichier XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peut être exporté par XStream
     */
    public Cst cloneExportedFields(IExportConfiguration exportConfiguration) {
        Cst clone = new Cst();

        clone.setCstSfLb(getCstSfLb());

        clone.setSpe(getSpe() == null ? null : getSpe().cloneExportedFields(exportConfiguration));

        Ecst ecst = getEcst();
        if (exportConfiguration.isExtensionsFrancaises() && ecst != null) {
            clone.setEcst(ecst.cloneExportedFields(exportConfiguration));
        } else {
            clone.setEcst(null);
        }

        return clone;
    }
}
