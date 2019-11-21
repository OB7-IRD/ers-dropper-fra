package fr.ird.dropper.ers.fra.business;

import fr.ird.dropper.ers.fra.business.*;
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

import fr.ird.dropper.ers.fra.xstreamconverters.XsDateConverter;

/**
 * Informations sur le transfert et son navire.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("ETRC")
public class Etrc implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long etrcCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("Type")
    private String etrcTypeLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("FH")
    private String etrcFhLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("NH")
    private String etrcNhLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("DA")
    @XStreamConverter(XsDateConverter.class)
    private Date etrcDaDt;

    /**
     * persistent field
     */
    @XStreamOmitField
    private Elog elog;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "SPE")
    private List<Spe> listSpe;

    public Long getEtrcCdn() {
        return this.etrcCdn;
    }

    public void setEtrcCdn(Long etrcCdn) {
        this.etrcCdn = etrcCdn;
    }

    public String getEtrcTypeLb() {
        return this.etrcTypeLb;
    }

    public void setEtrcTypeLb(String etrcTypeLb) {
        this.etrcTypeLb = etrcTypeLb;
    }

    public String getEtrcFhLb() {
        return this.etrcFhLb;
    }

    public void setEtrcFhLb(String etrcFhLb) {
        this.etrcFhLb = etrcFhLb;
    }

    public String getEtrcNhLb() {
        return this.etrcNhLb;
    }

    public void setEtrcNhLb(String etrcNhLb) {
        this.etrcNhLb = etrcNhLb;
    }

    public Date getEtrcDaDt() {
        return this.etrcDaDt;
    }

    public void setEtrcDaDt(Date etrcDaDt) {
        this.etrcDaDt = etrcDaDt;
    }

    public Elog getElog() {
        return this.elog;
    }

    public void setElog(Elog elog) {
        this.elog = elog;
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

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getEtrcCdn();
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
        if (!(other instanceof Etrc)) {
            return false;
        }
        Etrc castOther = (Etrc) other;
        return new EqualsBuilder().append(this.getEtrcCdn(),
                castOther.getEtrcCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getEtrcCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return etrcCdn;
    }

    /**
     * On va remplir les champs non présents dans le XML reçu. Cette méthode est
     * appelée automatiquement par XStream après la création de l'objet (ETRC).
     *
     * @return this
     */
    private Object readResolve() {
        return this;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichier XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peut être exporté par XStream
     */
    public Etrc cloneExportedFields(IExportConfiguration exportConfiguration) {
        Etrc clone = new Etrc();

        clone.setEtrcTypeLb(getEtrcTypeLb());
        clone.setEtrcFhLb(getEtrcFhLb());
        clone.setEtrcNhLb(getEtrcNhLb());
        clone.setEtrcDaDt(getEtrcDaDt());

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
