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
 * Matériel à bord du navire.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("GEA")
public class Gea implements Serializable {

    private static final long serialVersionUID = -4432067060801878880L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long geaCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("GE")
    private String geaGeLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("ME")
    private Integer geaMeNb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("GC")
    private String geaGcLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("FO")
    private Integer geaFoNb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("DU")
    private Integer geaDuNb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("FD")
    private Integer geaFdNb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("NH")
    private Integer geaNhNb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("GL")
    private Integer geaGlNb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("GD")
    private Integer geaGdNb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("QG")
    private Integer geaQgNb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("TL")
    private Integer geaTlNb;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Ecps> listEcps;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "GES")
    private List<Ges> listGes;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "GER")
    private List<Ger> listGer;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "GIL")
    private List<Gil> listGil;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Far> listFar;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Rtp> listRtp;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Dep> listDep;

    public Long getGeaCdn() {
        return this.geaCdn;
    }

    public void setGeaCdn(Long geaCdn) {
        this.geaCdn = geaCdn;
    }

    public String getGeaGeLb() {
        return this.geaGeLb;
    }

    public void setGeaGeLb(String geaGeLb) {
        this.geaGeLb = geaGeLb;
    }

    public Integer getGeaMeNb() {
        return this.geaMeNb;
    }

    public void setGeaMeNb(Integer geaMeNb) {
        this.geaMeNb = geaMeNb;
    }

    public String getGeaGcLb() {
        return this.geaGcLb;
    }

    public void setGeaGcLb(String geaGcLb) {
        this.geaGcLb = geaGcLb;
    }

    public Integer getGeaFoNb() {
        return this.geaFoNb;
    }

    public void setGeaFoNb(Integer geaFoNb) {
        this.geaFoNb = geaFoNb;
    }

    public Integer getGeaDuNb() {
        return this.geaDuNb;
    }

    public void setGeaDuNb(Integer geaDuNb) {
        this.geaDuNb = geaDuNb;
    }

    public Integer getGeaFdNb() {
        return this.geaFdNb;
    }

    public void setGeaFdNb(Integer geaFdNb) {
        this.geaFdNb = geaFdNb;
    }

    public Integer getGeaNhNb() {
        return this.geaNhNb;
    }

    public void setGeaNhNb(Integer geaNhNb) {
        this.geaNhNb = geaNhNb;
    }

    public Integer getGeaGlNb() {
        return this.geaGlNb;
    }

    public void setGeaGlNb(Integer geaGlNb) {
        this.geaGlNb = geaGlNb;
    }

    public Integer getGeaGdNb() {
        return this.geaGdNb;
    }

    public void setGeaGdNb(Integer geaGdNb) {
        this.geaGdNb = geaGdNb;
    }

    public Integer getGeaQgNb() {
        return this.geaQgNb;
    }

    public void setGeaQgNb(Integer geaQgNb) {
        this.geaQgNb = geaQgNb;
    }

    public Integer getGeaTlNb() {
        return this.geaTlNb;
    }

    public void setGeaTlNb(Integer geaTlNb) {
        this.geaTlNb = geaTlNb;
    }

    public Ecps getEcps() {
        if (getListEcps() == null || getListEcps().isEmpty()) {
            return null;
        } else {
            return getListEcps().get(0);
        }
    }

    public List<Ecps> getListEcps() {
        if (listEcps == null) {
            listEcps = new ArrayList<>();
        }
        return listEcps;
    }

    public void setListEcps(List<Ecps> listEcps) {
        this.listEcps = listEcps;
    }

    public Ger getGer() {
        if (getListGer() == null || getListGer().isEmpty()) {
            return null;
        } else {
            return getListGer().get(0);
        }
    }

    public List<Ger> getListGer() {
        if (listGer == null) {
            listGer = new ArrayList<>();
        }
        return this.listGer;
    }

    public void setListGer(List<Ger> listGer) {
        this.listGer = listGer;
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

    public Ges getGes() {
        if (getListGes() == null || getListGes().isEmpty()) {
            return null;
        } else {
            return getListGes().get(0);
        }
    }

    public List<Ges> getListGes() {
        if (listGes == null) {
            listGes = new ArrayList<>();
        }
        return this.listGes;
    }

    public void setListGes(List<Ges> listGes) {
        this.listGes = listGes;
    }

    public List<Rtp> getListRtp() {
        if (listRtp == null) {
            listRtp = new ArrayList<>();
        }
        return this.listRtp;
    }

    public void setListRtp(List<Rtp> listRtp) {
        this.listRtp = listRtp;
    }

    public List<Dep> getListDep() {
        if (listDep == null) {
            listDep = new ArrayList<>();
        }
        return this.listDep;
    }

    public void setListDep(List<Dep> listDep) {
        this.listDep = listDep;
    }

    public Gil getGil() {
        if (getListGil() == null || getListGil().isEmpty()) {
            return null;
        } else {
            return getListGil().get(0);
        }
    }

    public List<Gil> getListGil() {
        if (listGil == null) {
            listGil = new ArrayList<>();
        }
        return this.listGil;
    }

    public void setListGil(List<Gil> listGil) {
        this.listGil = listGil;
    }

    @Override
    public String toString() {
        return "Gea{" + "geaGeLb=" + geaGeLb + ", geaMeNb=" + geaMeNb + ", geaGcLb=" + geaGcLb + ", geaFoNb=" + geaFoNb + ", geaDuNb=" + geaDuNb + ", geaFdNb=" + geaFdNb + ", geaNhNb=" + geaNhNb + ", geaGlNb=" + geaGlNb + ", geaGdNb=" + geaGdNb + ", geaQgNb=" + geaQgNb + ", geaTlNb=" + geaTlNb + ", listEcps=" + listEcps + ", listGes=" + listGes + ", listGer=" + listGer + ", listGil=" + listGil + ", listFar=" + listFar + ", listRtp=" + listRtp + ", listDep=" + listDep + '}';
    }


    /* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if (!(other instanceof Gea)) {
            return false;
        }
        Gea castOther = (Gea) other;
        return new EqualsBuilder().append(this.getGeaCdn(),
                castOther.getGeaCdn()).isEquals();
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getGeaCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return geaCdn;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichier XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peut être exporté par XStream
     */
    public Gea cloneExportedFields(IExportConfiguration exportConfiguration) {
        Gea clone = new Gea();

        clone.setGeaGeLb(getGeaGeLb());
        clone.setGeaMeNb(getGeaMeNb());
        clone.setGeaGcLb(getGeaGcLb());
        clone.setGeaFoNb(getGeaFoNb());
        clone.setGeaDuNb(getGeaDuNb());
        clone.setGeaFdNb(getGeaFdNb());
        clone.setGeaNhNb(getGeaNhNb());
        clone.setGeaGlNb(getGeaGlNb());
        clone.setGeaGdNb(getGeaGdNb());
        clone.setGeaQgNb(getGeaQgNb());
        clone.setGeaTlNb(getGeaTlNb());

        // Clone des GER
        if (getListGer() != null && !getListGer().isEmpty()) {
            ArrayList<Ger> cloneGers = new ArrayList<Ger>();
            for (Ger ger : getListGer()) {
                cloneGers.add(ger.cloneExportedFields(exportConfiguration));
            }
            clone.setListGer(cloneGers);
        }

        // Clone des GES
        if (getListGes() != null && !getListGes().isEmpty()) {
            ArrayList<Ges> cloneGess = new ArrayList<Ges>();
            for (Ges ges : getListGes()) {
                cloneGess.add(ges.cloneExportedFields(exportConfiguration));
            }
            clone.setListGes(cloneGess);
        }

        // Clone des GIL
        if (getListGil() != null && !getListGil().isEmpty()) {
            ArrayList<Gil> cloneGils = new ArrayList<Gil>();
            for (Gil gil : getListGil()) {
                cloneGils.add(gil.cloneExportedFields(exportConfiguration));
            }
            clone.setListGil(cloneGils);
        }

        return clone;
    }
}
