package fr.ird.dropper.ers.fra.business;

import fr.ird.dropper.ers.fra.business.*;
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
 * Extension (précision) sur le registre des événements de pêche.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("ELOG")
public class Elog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long elogCdn;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("OS")
    private String elogOsLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("CH")
    private String elogChLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("TN")
    private String elogTnLb;

    @XStreamOmitField
    private String elogTnOrigLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("Type")
    private String elogTypeLb;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Log> logs;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "ECPS")
    private List<Ecps> listEcps;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "ETRC")
    private List<Etrc> listEtrc;

    public Long getElogCdn() {
        return elogCdn;
    }

    public void setElogCdn(Long elogCdn) {
        this.elogCdn = elogCdn;
    }

    public String getElogOsLb() {
        return elogOsLb;
    }

    public void setElogOsLb(String elogOsLb) {
        this.elogOsLb = elogOsLb;
    }

    public String getElogChLb() {
        return elogChLb;
    }

    public void setElogChLb(String elogChLb) {
        this.elogChLb = elogChLb;
    }

    public String getElogTnLb() {
        return elogTnLb;
    }

    public void setElogTnLb(String elogTnLb) {
        this.elogTnLb = elogTnLb;
    }

    public String getElogTypeLb() {
        return elogTypeLb;
    }

    public void setElogTypeLb(String elogTypeLb) {
        this.elogTypeLb = elogTypeLb;
    }

    public List<Ecps> getListEcps() {
        if (listEcps == null) {
            listEcps = new ArrayList<>();
        }
        return listEcps;
    }

    public List<Log> getLogs() {
        if (logs == null) {
            logs = new ArrayList<>();
        }
        return logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }

    public void setListEcps(List<Ecps> listEcps) {
        this.listEcps = listEcps;
    }

    public List<Etrc> getListEtrc() {
        if (listEtrc == null) {
            listEtrc = new ArrayList<>();
        }
        return listEtrc;
    }

    public void setListEtrc(List<Etrc> listEtrc) {
        this.listEtrc = listEtrc;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getElogCdn();
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
        if (!(other instanceof Elog)) {
            return false;
        }
        Elog castOther = (Elog) other;
        return new EqualsBuilder().append(this.getElogCdn(),
                castOther.getElogCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getElogCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return elogCdn;
    }

    /**
     * On va remplir les champs non présents dans le XML reçu. Cette méthode est
     * appelée automatiquement par XStream après la création de l'objet (ELOG).
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
    public Elog cloneExportedFields(IExportConfiguration exportConfiguration) {
        Elog clone = new Elog();

        clone.setElogTypeLb(getElogTypeLb());
        clone.setElogOsLb(getElogOsLb());
        clone.setElogChLb(getElogChLb());
        clone.setElogTnLb(getElogTnOrigLb());
        clone.setElogTnOrigLb(getElogTnOrigLb());

        // Clone des ECPS
        if (getListEcps() != null && !getListEcps().isEmpty()) {
            ArrayList<Ecps> cloneEcpss = new ArrayList<Ecps>();
            for (Ecps ecps : getListEcps()) {
                cloneEcpss.add(ecps.cloneExportedFields(exportConfiguration));
            }
            clone.setListEcps(cloneEcpss);
        }

        // Clone des ETRC
        if (getListEtrc() != null && !getListEtrc().isEmpty()) {
            ArrayList<Etrc> cloneEtrcs = new ArrayList<Etrc>();
            for (Etrc etrc : getListEtrc()) {
                cloneEtrcs.add(etrc.cloneExportedFields(exportConfiguration));
            }
            clone.setListEtrc(cloneEtrcs);
        }

        return clone;
    }

    /**
     * @param elogTnOrigLb the elogTnOrigLb to set
     */
    public void setElogTnOrigLb(String elogTnOrigLb) {
        this.elogTnOrigLb = elogTnOrigLb;
    }

    /**
     * @return the elogTnOrigLb
     */
    public String getElogTnOrigLb() {
        return elogTnOrigLb;
    }
}
