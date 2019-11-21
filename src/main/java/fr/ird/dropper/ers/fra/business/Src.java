package fr.ird.dropper.ers.fra.business;

import fr.ird.dropper.ers.fra.business.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import fr.ird.dropper.ers.fra.xstreamconverters.DateConverter;

/**
 * Document source de la ligne de vente (balise SLI).
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("SRC")
public class Src implements Serializable {

    private static final long serialVersionUID = 4060294555730325669L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long srcCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("DL")
    @XStreamConverter(DateConverter.class)
    private Date srcDlDt;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("PO")
    private String srcPoLb;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Sli> listSli;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Tli> listTli;

    public Long getSrcCdn() {
        return this.srcCdn;
    }

    public void setSrcCdn(Long srcCdn) {
        this.srcCdn = srcCdn;
    }

    public Date getSrcDlDt() {
        return this.srcDlDt;
    }

    public void setSrcDlDt(Date srcDlDt) {
        this.srcDlDt = srcDlDt;
    }

    public String getSrcPoLb() {
        return this.srcPoLb;
    }

    public void setSrcPoLb(String srcPoLb) {
        this.srcPoLb = srcPoLb;
    }

    public List<Sli> getListSli() {
        return this.listSli;
    }

    public void setListSli(List<Sli> listSli) {
        this.listSli = listSli;
    }

    public List<Tli> getListTli() {
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
        return "" + getSrcCdn();
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
        if (!(other instanceof Src)) {
            return false;
        }
        Src castOther = (Src) other;
        return new EqualsBuilder().append(this.getSrcCdn(),
                castOther.getSrcCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getSrcCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return srcCdn;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichier XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peut être exporté par XStream
     */
    public Src cloneExportedFields(IExportConfiguration exportConfiguration) {
        Src clone = new Src();

        clone.setSrcDlDt(getSrcDlDt());
        clone.setSrcPoLb(getSrcPoLb());

        return clone;
    }
}
