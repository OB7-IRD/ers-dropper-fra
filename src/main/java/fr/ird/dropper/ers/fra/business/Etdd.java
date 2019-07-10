package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Etiquette électronique.
 * 
 * @author christelle.jeanberne
 */
@XStreamAlias("ETDD")
public class Etdd implements Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
	@XStreamOmitField
	private Long etddCdn;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("Type")
	private String etddTypeLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("GT")
	private String etddGtLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("GI")
	private String etddGiLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("GO")
	private String etddGoLb;

	/** persistent field */
	@XStreamOmitField
	private Efad efad;

	public Long getEtddCdn() {
		return etddCdn;
	}

	public void setEtddCdn(Long etddCdn) {
		this.etddCdn = etddCdn;
	}

	public String getEtddTypeLb() {
		return etddTypeLb;
	}

	public void setEtddTypeLb(String etddTypeLb) {
		this.etddTypeLb = etddTypeLb;
	}

	public String getEtddGtLb() {
		return etddGtLb;
	}

	public void setEtddGtLb(String etddGtLb) {
		this.etddGtLb = etddGtLb;
	}

	public String getEtddGiLb() {
		return etddGiLb;
	}

	public void setEtddGiLb(String etddGiLb) {
		this.etddGiLb = etddGiLb;
	}

	public String getEtddGoLb() {
		return etddGoLb;
	}

	public void setEtddGoLb(String etddGoLb) {
		this.etddGoLb = etddGoLb;
	}

	public Efad getEfad() {
		return efad;
	}

	public void setEfad(Efad efad) {
		this.efad = efad;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "" + getEtddCdn();
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
		if (!(other instanceof Etdd)) {
			return false;
		}
		Etdd castOther = (Etdd) other;
		return new EqualsBuilder().append(this.getEtddCdn(),
				castOther.getEtddCdn()).isEquals();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(getEtddCdn()).toHashCode();
	}

	/**
	 * Retourne l'identifiant.
	 * 
	 * @return l'identifiant
	 */
	public Serializable getIdentifier() {
		return etddCdn;
	}

	/**
	 * On va remplir les champs non présents dans le XML reçu. Cette méthode est
	 * appelée automatiquement par XStream après la création de l'objet (ETDD).
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
	public Etdd cloneExportedFields(IExportConfiguration exportConfiguration) {
		Etdd clone = new Etdd();

		clone.setEtddTypeLb(getEtddTypeLb());
		clone.setEtddGtLb(getEtddGtLb());
		clone.setEtddGiLb(getEtddGiLb());
		clone.setEtddGoLb(getEtddGoLb());

		return clone;
	}
}