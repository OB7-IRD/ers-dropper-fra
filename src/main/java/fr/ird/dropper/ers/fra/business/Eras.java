package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Extension (précision) de la zone (en mer) concernée.
 * 
 * @author christelle.jeanberne
 */
@XStreamAlias("ERAS")
public class Eras implements Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
	@XStreamOmitField
	private Long erasCdn;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("Type")
	private String erasTypeLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("VG")
	private String erasVgLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("ZC")
	private String erasZcLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("ZU")
	private String erasZuLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("ZG")
	private String erasZgLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("ZN")
	private String erasZnLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("RM")
	private String erasRmLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("ZA")
	private String erasZaLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("ZS")
	private String erasZsLb;

	/** persistent field */
	@XStreamOmitField
	private List<Ras> listRas;

	public Long getErasCdn() {
		return this.erasCdn;
	}

	public void setErasCdn(Long erasCdn) {
		this.erasCdn = erasCdn;
	}

	public String getErasTypeLb() {
		return this.erasTypeLb;
	}

	public void setErasTypeLb(String erasTypeLb) {
		this.erasTypeLb = erasTypeLb;
	}

	public String getErasVgLb() {
		return this.erasVgLb;
	}

	public void setErasVgLb(String erasVgLb) {
		this.erasVgLb = erasVgLb;
	}

	public String getErasZcLb() {
		return this.erasZcLb;
	}

	public void setErasZcLb(String erasZcLb) {
		this.erasZcLb = erasZcLb;
	}

	public String getErasZuLb() {
		return this.erasZuLb;
	}

	public void setErasZuLb(String erasZuLb) {
		this.erasZuLb = erasZuLb;
	}

	public String getErasZgLb() {
		return this.erasZgLb;
	}

	public void setErasZgLb(String erasZgLb) {
		this.erasZgLb = erasZgLb;
	}

	public String getErasZnLb() {
		return this.erasZnLb;
	}

	public void setErasZnLb(String erasZnLb) {
		this.erasZnLb = erasZnLb;
	}

	public String getErasRmLb() {
		return this.erasRmLb;
	}

	public void setErasRmLb(String erasRmLb) {
		this.erasRmLb = erasRmLb;
	}

	public String getErasZaLb() {
		return this.erasZaLb;
	}

	public void setErasZaLb(String erasZaLb) {
		this.erasZaLb = erasZaLb;
	}

	public String getErasZsLb() {
		return this.erasZsLb;
	}

	public void setErasZsLb(String erasZsLb) {
		this.erasZsLb = erasZsLb;
	}

	public List<Ras> getListRas() {
		return this.listRas;
	}

	public void setListRas(List<Ras> listRas) {
		this.listRas = listRas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "" + getErasCdn();
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
		if (!(other instanceof Eras)) {
			return false;
		}
		Eras castOther = (Eras) other;
		return new EqualsBuilder().append(this.getErasCdn(),
				castOther.getErasCdn()).isEquals();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(getErasCdn()).toHashCode();
	}

	/**
	 * Retourne l'identifiant.
	 * 
	 * @return l'identifiant
	 */
	public Serializable getIdentifier() {
		return erasCdn;
	}

	/**
	 * On va remplir les champs non présents dans le XML reçu. Cette méthode est
	 * appelée automatiquement par XStream après la création de l'objet (ERAS).
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
	public Eras cloneExportedFields(IExportConfiguration exportConfiguration) {
		Eras clone = new Eras();

		clone.setErasTypeLb(getErasTypeLb());
		clone.setErasVgLb(getErasVgLb());
		clone.setErasZcLb(getErasZcLb());
		clone.setErasZuLb(getErasZuLb());
		clone.setErasZgLb(getErasZgLb());
		clone.setErasRmLb(getErasRmLb());
		clone.setErasZaLb(getErasZaLb());
		clone.setErasZsLb(getErasZsLb());

		return clone;
	}
}