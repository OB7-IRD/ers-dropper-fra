package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Extension(précision) des envois repris.
 * 
 * @author christelle.jeanberne
 */
@XStreamAlias("ECST")
public class Ecst implements Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
	@XStreamOmitField
	private Long ecstCdn;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("EF")
	private String ecstEfLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("VC")
	private String ecstVcLb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("type")
	private String ecstTypeLb;

	/** persistent field */
	@XStreamOmitField
	private List<Cst> listCst;

	public Long getEcstCdn() {
		return this.ecstCdn;
	}

	public void setEcstCdn(Long ecstCdn) {
		this.ecstCdn = ecstCdn;
	}

	public String getEcstEfLb() {
		return this.ecstEfLb;
	}

	public void setEcstEfLb(String ecstEfLb) {
		this.ecstEfLb = ecstEfLb;
	}

	public String getEcstVcLb() {
		return this.ecstVcLb;
	}

	public void setEcstVcLb(String ecstVcLb) {
		this.ecstVcLb = ecstVcLb;
	}

	public String getEcstTypeLb() {
		return this.ecstTypeLb;
	}

	public void setEcstTypeLb(String ecstTypeLb) {
		this.ecstTypeLb = ecstTypeLb;
	}

	public List<Cst> getListCst() {
		return this.listCst;
	}

	public void setListCst(List<Cst> listCst) {
		this.listCst = listCst;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "" + getEcstCdn();
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
		if (!(other instanceof Ecst)) {
			return false;
		}
		Ecst castOther = (Ecst) other;
		return new EqualsBuilder().append(this.getEcstCdn(),
				castOther.getEcstCdn()).isEquals();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(getEcstCdn()).toHashCode();
	}

	/**
	 * Retourne l'identifiant.
	 * 
	 * @return l'identifiant
	 */
	public Serializable getIdentifier() {
		return ecstCdn;
	}

	/**
	 * On va remplir les champs non présents dans le XML reçu. Cette méthode est
	 * appelée automatiquement par XStream après la création de l'objet (ECST).
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
	public Ecst cloneExportedFields(IExportConfiguration exportConfiguration) {
		Ecst clone = new Ecst();

		clone.setEcstTypeLb(getEcstTypeLb());
		clone.setEcstEfLb(getEcstEfLb());
		clone.setEcstVcLb(getEcstVcLb());

		return clone;
	}
}