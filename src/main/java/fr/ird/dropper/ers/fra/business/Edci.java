package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Détail pour chaque individu d'espèce protégée.
 * 
 * @author christelle.jeanberne
 */
@XStreamAlias("EDCI")
public class Edci implements Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
	@XStreamOmitField
	private Long edciCdn;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("Type")
	private String edciTypeLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("SE")
	private String edciSeLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("HE")
	private String edciHeLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("CA")
	private String edciCaLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("RI")
	private String edciRiLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("FT")
	private String edciFtLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("CO")
	private String edciCoLb;

	/** persistent field */
	@XStreamAlias("SPE")
	private Spe spe;

	/** persistent field */
	@XStreamOmitField
	private Ecps ecps;

	public Long getEdciCdn() {
		return this.edciCdn;
	}

	public void setEdciCdn(Long edciCdn) {
		this.edciCdn = edciCdn;
	}

	public String getEdciTypeLb() {
		return this.edciTypeLb;
	}

	public void setEdciTypeLb(String edciTypeLb) {
		this.edciTypeLb = edciTypeLb;
	}

	public String getEdciSeLb() {
		return this.edciSeLb;
	}

	public void setEdciSeLb(String edciSeLb) {
		this.edciSeLb = edciSeLb;
	}

	public String getEdciHeLb() {
		return this.edciHeLb;
	}

	public void setEdciHeLb(String edciHeLb) {
		this.edciHeLb = edciHeLb;
	}

	public String getEdciCaLb() {
		return this.edciCaLb;
	}

	public void setEdciCaLb(String edciCaLb) {
		this.edciCaLb = edciCaLb;
	}

	public String getEdciRiLb() {
		return this.edciRiLb;
	}

	public void setEdciRiLb(String edciRiLb) {
		this.edciRiLb = edciRiLb;
	}

	public String getEdciFtLb() {
		return this.edciFtLb;
	}

	public void setEdciFtLb(String edciFtLb) {
		this.edciFtLb = edciFtLb;
	}

	public String getEdciCoLb() {
		return this.edciCoLb;
	}

	public void setEdciCoLb(String edciCoLb) {
		this.edciCoLb = edciCoLb;
	}

	public Spe getSpe() {
		return this.spe;
	}

	public void setSpe(Spe spe) {
		this.spe = spe;
	}

	public Ecps getEcps() {
		return this.ecps;
	}

	public void setEcps(Ecps ecps) {
		this.ecps = ecps;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "" + getEdciCdn();
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
		if (!(other instanceof Edci)) {
			return false;
		}
		Edci castOther = (Edci) other;
		return new EqualsBuilder().append(this.getEdciCdn(),
				castOther.getEdciCdn()).isEquals();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(getEdciCdn()).toHashCode();
	}

	/**
	 * Retourne l'identifiant.
	 * 
	 * @return l'identifiant
	 */
	public Serializable getIdentifier() {
		return edciCdn;
	}

	/**
	 * On va remplir les champs non présents dans le XML reçu. Cette méthode est
	 * appelée automatiquement par XStream après la création de l'objet (ECSS).
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
	public Edci cloneExportedFields(IExportConfiguration exportConfiguration) {
		Edci clone = new Edci();

		clone.setEdciTypeLb(getEdciTypeLb());
		clone.setEdciSeLb(getEdciSeLb());
		clone.setEdciHeLb(getEdciHeLb());
		clone.setEdciCaLb(getEdciCaLb());
		clone.setEdciRiLb(getEdciRiLb());
		clone.setEdciFtLb(getEdciFtLb());
		clone.setEdciCoLb(getEdciCoLb());
		
		if (getSpe() != null) {
			clone.setSpe(getSpe().cloneExportedFields(exportConfiguration));
		} else {
			clone.setSpe(null);
		}

		return clone;
	}
}