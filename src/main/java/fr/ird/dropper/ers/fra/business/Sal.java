package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import fr.ird.dropper.ers.fra.xstreamconverters.DateConverter;

/**
 * Note de vente.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("SAL")
public class Sal implements Serializable {

    private static final long serialVersionUID = -1478789457426902777L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long salCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("IR")
    private String salIrLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("RC")
    private String salRcLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("XR")
    private String salXrLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("FS")
    private String salFsLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("NA")
    private String salNaLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("NR")
    private String salNrLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("ND")
    @XStreamConverter(DateConverter.class)
    private Date salNdDt;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("CN")
    private String salCnLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("TR")
    private String salTrLb;

    /**
     * persistent field
     */
    @XStreamOmitField
    private Ers ers;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "SLI")
    private List<Sli> listSli;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "TLI")
    private List<Tli> listTli;

    /**
     * persistent field
     */
    @XStreamAlias("ESAL")
    private Esal esal;

    public Long getSalCdn() {
        return this.salCdn;
    }

    public void setSalCdn(Long salCdn) {
        this.salCdn = salCdn;
    }

    public String getSalIrLb() {
        return this.salIrLb;
    }

    public void setSalIrLb(String salIrLb) {
        this.salIrLb = salIrLb;
    }

    public String getSalRcLb() {
        return this.salRcLb;
    }

    public void setSalRcLb(String salRcLb) {
        this.salRcLb = salRcLb;
    }

    public String getSalXrLb() {
        return this.salXrLb;
    }

    public void setSalXrLb(String salXrLb) {
        this.salXrLb = salXrLb;
    }

    public String getSalFsLb() {
        return this.salFsLb;
    }

    public void setSalFsLb(String salFsLb) {
        this.salFsLb = salFsLb;
    }

    public String getSalNaLb() {
        return this.salNaLb;
    }

    public void setSalNaLb(String salNaLb) {
        this.salNaLb = salNaLb;
    }

    public String getSalNrLb() {
        return this.salNrLb;
    }

    public void setSalNrLb(String salNrLb) {
        this.salNrLb = salNrLb;
    }

    public Date getSalNdDt() {
        return this.salNdDt;
    }

    public void setSalNdDt(Date salNdDt) {
        this.salNdDt = salNdDt;
    }

    public String getSalCnLb() {
        return this.salCnLb;
    }

    public void setSalCnLb(String salCnLb) {
        this.salCnLb = salCnLb;
    }

    public String getSalTrLb() {
        return this.salTrLb;
    }

    public void setSalTrLb(String salTrLb) {
        this.salTrLb = salTrLb;
    }

    public Ers getErs() {
        return this.ers;
    }

    public void setErs(Ers ers) {
        this.ers = ers;
    }

    public Esal getEsal() {
        return this.esal;
    }

    public void setEsal(Esal esal) {
        this.esal = esal;
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
        return "" + getSalCdn();
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
        if (!(other instanceof Sal)) {
            return false;
        }
        Sal castOther = (Sal) other;
        return new EqualsBuilder().append(this.getSalCdn(),
                castOther.getSalCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getSalCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return salCdn;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichie XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peur être exporté par XStream
     */
    public Sal cloneExportedFields(IExportConfiguration exportConfiguration) {
        Sal clone = new Sal();

        clone.setSalIrLb(getSalIrLb());
        clone.setSalRcLb(getSalRcLb());
        clone.setSalXrLb(getSalXrLb());
        clone.setSalFsLb(getSalFsLb());
        clone.setSalNaLb(getSalNaLb());
        clone.setSalNrLb(getSalNrLb());
        clone.setSalNdDt(getSalNdDt());
        clone.setSalCnLb(getSalCnLb());
        clone.setSalTrLb(getSalTrLb());

        Esal esal = getEsal();
        if (exportConfiguration.isExtensionsFrancaises() && esal != null) {
            clone.setEsal(esal.cloneExportedFields(exportConfiguration));
        } else {
            clone.setEsal(null);
        }

        // Clone des SLI
        if (getListSli() != null && !getListSli().isEmpty()) {
            ArrayList<Sli> cloneSlis = new ArrayList<Sli>();
            for (Sli sli : getListSli()) {
                cloneSlis.add(sli.cloneExportedFields(exportConfiguration));
            }
            clone.setListSli(cloneSlis);
        }

        // Clone des TLI
        if (getListTli() != null && !getListTli().isEmpty()) {
            ArrayList<Tli> cloneTlis = new ArrayList<Tli>();
            for (Tli tli : getListTli()) {
                cloneTlis.add(tli.cloneExportedFields(exportConfiguration));
            }
            clone.setListTli(cloneTlis);
        }

        return clone;
    }
}
