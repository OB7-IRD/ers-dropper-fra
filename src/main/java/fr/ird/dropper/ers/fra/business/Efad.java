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
 * Notification d'activité sur le dispositif de concentration de poissons (DCP)
 * : lancement, visite, transfert.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("EFAD")
public class Efad implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long efadCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("Type")
    private String efadTypeLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("TF")
    private String efadTfLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("TP")
    private String efadTp;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("IF")
    private String efadIfLb;

    /**
     * persistent field
     */
    @XStreamOmitField
    private Epfa efpa;

    /**
     * persistent field
     */
    @XStreamImplicit(itemFieldName = "ETDD")
    private List<Etdd> listEtdd;

    public Long getEfadCdn() {
        return this.efadCdn;
    }

    public void setEfadCdn(Long efadCdn) {
        this.efadCdn = efadCdn;
    }

    public String getEfadTypeLb() {
        return this.efadTypeLb;
    }

    public void setEfadTypeLb(String efadTypeLb) {
        this.efadTypeLb = efadTypeLb;
    }

    public String getEfadTfLb() {
        return this.efadTfLb;
    }

    public void setEfadTfLb(String efadTfLb) {
        this.efadTfLb = efadTfLb;
    }

    public String getEfadTp() {
        return this.efadTp;
    }

    public void setEfadTp(String efadTp) {
        this.efadTp = efadTp;
    }

    public String getEfadIfLb() {
        return this.efadIfLb;
    }

    public void setEfadIfLb(String efadIfLb) {
        this.efadIfLb = efadIfLb;
    }

    public Epfa getEfpa() {
        return this.efpa;
    }

    public void setEfpa(Epfa efpa) {
        this.efpa = efpa;
    }

    public List<Etdd> getListEtdd() {
        if (listEtdd == null) {
            listEtdd = new ArrayList<>();
        }
        return this.listEtdd;
    }

    public void setListEtdd(List<Etdd> listEtdd) {
        this.listEtdd = listEtdd;
    }

    @Override
    public String toString() {
        return "Efad{" + "efadTypeLb=" + efadTypeLb + ", efadTfLb=" + efadTfLb + ", efadTp=" + efadTp + ", efadIfLb=" + efadIfLb + ", efpa=" + efpa + ", listEtdd=" + listEtdd + '}';
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
        if (!(other instanceof Efad)) {
            return false;
        }
        Efad castOther = (Efad) other;
        return new EqualsBuilder().append(this.getEfadCdn(),
                castOther.getEfadCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getEfadCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return efadCdn;
    }

    /**
     * On va remplir les champs non présents dans le XML reçu. Cette méthode est
     * appelée automatiquement par XStream après la création de l'objet (EFAD).
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
    public Efad cloneExportedFields(IExportConfiguration exportConfiguration) {
        Efad clone = new Efad();

        clone.setEfadTypeLb(getEfadTypeLb());
        clone.setEfadTfLb(getEfadTfLb());
        clone.setEfadTp(getEfadTp());
        clone.setEfadIfLb(getEfadIfLb());

        // Clone des ETDD
        if (getListEtdd() != null && !getListEtdd().isEmpty()) {
            ArrayList<Etdd> cloneEtdds = new ArrayList<Etdd>();
            for (Etdd etdd : getListEtdd()) {
                cloneEtdds.add(etdd.cloneExportedFields(exportConfiguration));
            }
            clone.setListEtdd(cloneEtdds);
        }
        return clone;
    }
}
