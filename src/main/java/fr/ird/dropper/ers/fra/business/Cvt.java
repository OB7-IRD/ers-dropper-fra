package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Navire à qui on a transféré du thon rouge.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("CVT")
public class Cvt implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long cvtCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("NA")
    private String cvtNaLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("IN")
    private String cvtInLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("IM")
    private String cvtImLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("IR")
    private String cvtIrLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("RC")
    private String cvtRcLb;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Far> listFar;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Bti> listBti;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "SPE")
    private List<Spe> listSpe;

    public Long getCvtCdn() {
        return this.cvtCdn;
    }

    public void setCvtCdn(Long cvtCdn) {
        this.cvtCdn = cvtCdn;
    }

    public String getCvtNaLb() {
        return this.cvtNaLb;
    }

    public void setCvtNaLb(String cvtNaLb) {
        this.cvtNaLb = cvtNaLb;
    }

    public String getCvtInLb() {
        return this.cvtInLb;
    }

    public void setCvtInLb(String cvtInLb) {
        this.cvtInLb = cvtInLb;
    }

    public String getCvtImLb() {
        return this.cvtImLb;
    }

    public void setCvtImLb(String cvtImLb) {
        this.cvtImLb = cvtImLb;
    }

    public String getCvtIrLb() {
        return this.cvtIrLb;
    }

    public void setCvtIrLb(String cvtIrLb) {
        this.cvtIrLb = cvtIrLb;
    }

    public String getCvtRcLb() {
        return this.cvtRcLb;
    }

    public void setCvtRcLb(String cvtRcLb) {
        this.cvtRcLb = cvtRcLb;
    }

    public List<Far> getListFar() {
        if (listFar == null) {
            listFar = new ArrayList<>();
        }
        return this.listFar;
    }

    public void setListFar(List<Far> listFar) {
        this.listFar = listFar;
    }

    public List<Bti> getListBti() {
        if (listBti == null) {
            listBti = new ArrayList<>();
        }
        return this.listBti;
    }

    public void setListBti(List<Bti> listBti) {
        this.listBti = listBti;
    }

    public List<Spe> getListSpe() {
        if (listSpe == null) {
            listSpe = new ArrayList<>();
        }
        return this.listSpe;
    }

    public void setListSpe(List<Spe> listSpe) {
        this.listSpe = listSpe;
    }

    @Override
    public String toString() {
        return "Cvt{" + "cvtNaLb=" + cvtNaLb + ", cvtInLb=" + cvtInLb + ", cvtImLb=" + cvtImLb + ", cvtIrLb=" + cvtIrLb + ", cvtRcLb=" + cvtRcLb + ", listFar=" + listFar + ", listBti=" + listBti + ", listSpe=" + listSpe + '}';
    }


    /* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if (!(other instanceof Cvt)) {
            return false;
        }
        Cvt castOther = (Cvt) other;
        return new EqualsBuilder().append(this.getCvtCdn(),
                castOther.getCvtCdn()).isEquals();
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getCvtCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return getCvtCdn();
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichier XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peut être exporté par XStream
     */
    public Cvt cloneExportedFields(IExportConfiguration exportConfiguration) {
        Cvt clone = new Cvt();

        clone.setCvtNaLb(getCvtNaLb());
        clone.setCvtInLb(getCvtInLb());
        clone.setCvtImLb(getCvtImLb());
        clone.setCvtIrLb(getCvtIrLb());
        clone.setCvtRcLb(getCvtRcLb());

        // Clone des SPE
        if (getListSpe() != null && !getListSpe().isEmpty()) {
            ArrayList<Spe> cloneSpes = new ArrayList<Spe>();
            for (Spe spe : getListSpe()) {
                cloneSpes.add(spe.cloneExportedFields(exportConfiguration));
            }
            clone.setListSpe(cloneSpes);
        }

        return clone;
    }
}
