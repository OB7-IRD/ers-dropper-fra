package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Message des autorités françaises au navire.
 * 
 * @author christelle.jeanberne
 */
@XStreamAlias("EMAV")
public class Emav implements Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
	@XStreamOmitField
	private Long emavCdn;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("Type")
	private String emavTypeLb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("IR")
	private String emavIrLb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("RS")
	private String emavRsLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("ON")
	private String emavOnLb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("MC")
	private String emavMcLb;

	/** persistent field */
	@XStreamOmitField
	private Operateur operateur;

	/** persistent field */
	@XStreamOmitField
	private Ops ops;

	public Long getEmavCdn() {
		return this.emavCdn;
	}

	public void setEmavCdn(Long emavCdn) {
		this.emavCdn = emavCdn;
	}

	public String getEmavTypeLb() {
		return this.emavTypeLb;
	}

	public void setEmavTypeLb(String emavTypeLb) {
		this.emavTypeLb = emavTypeLb;
	}

	public String getEmavIrLb() {
		return this.emavIrLb;
	}

	public void setEmavIrLb(String emavIrLb) {
		this.emavIrLb = emavIrLb;
	}

	public String getEmavRsLb() {
		return this.emavRsLb;
	}

	public void setEmavRsLb(String emavRsLb) {
		this.emavRsLb = emavRsLb;
	}

	public String getEmavOnLb() {
		return this.emavOnLb;
	}

	public void setEmavOnLb(String emavOnLb) {
		this.emavOnLb = emavOnLb;
	}

	public String getEmavMcLb() {
		return this.emavMcLb;
	}

	public void setEmavMcLb(String emavMcLb) {
		this.emavMcLb = emavMcLb;
	}

	public Operateur getOperateur() {
		return this.operateur;
	}

	public void setOperateur(Operateur operateur) {
		this.operateur = operateur;
	}

	public Ops getOps() {
		return this.ops;
	}

	public void setOps(Ops ops) {
		this.ops = ops;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "" + getEmavCdn();
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
		if (!(other instanceof Emav)) {
			return false;
		}
		Emav castOther = (Emav) other;
		return new EqualsBuilder().append(this.getEmavCdn(),
				castOther.getEmavCdn()).isEquals();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(getEmavCdn()).toHashCode();
	}

	/**
	 * Retourne l'identifiant.
	 * 
	 * @return l'identifiant
	 */
	public Serializable getIdentifier() {
		return emavCdn;
	}

	/**
	 * On va remplir les champs non présents dans le XML reçu. Cette méthode est
	 * appelée automatiquement par XStream après la création de l'objet (EMAV).
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
	public Emav cloneExportedFields(IExportConfiguration exportConfiguration) {
		Emav clone = new Emav();

		clone.setEmavTypeLb(getEmavTypeLb());
		clone.setEmavIrLb(getEmavIrLb());
		clone.setEmavRsLb(getEmavRsLb());
		clone.setEmavOnLb(getEmavOnLb());
		clone.setEmavMcLb(getEmavMcLb());
		
		return clone;
	}
}