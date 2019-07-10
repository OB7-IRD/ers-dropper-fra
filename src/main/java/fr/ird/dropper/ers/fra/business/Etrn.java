package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Extension (précision) du transport.
 * 
 * @author christelle.jeanberne
 */
@XStreamAlias("ETRN")
public class Etrn implements Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
	@XStreamOmitField
	private Long etrnCdn;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("Type")
	private String etrnTypeLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("TD")
	private String etrnTdLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("DT")
	private String etrnDtLb;

	/** persistent field */
	@XStreamOmitField
	private List<Trn> listTrn;

	public Long getEtrnCdn() {
		return etrnCdn;
	}

	public void setEtrnCdn(Long etrnCdn) {
		this.etrnCdn = etrnCdn;
	}

	public String getEtrnTypeLb() {
		return etrnTypeLb;
	}

	public void setEtrnTypeLb(String etrnTypeLb) {
		this.etrnTypeLb = etrnTypeLb;
	}

	public String getEtrnTdLb() {
		return etrnTdLb;
	}

	public void setEtrnTdLb(String etrnTdLb) {
		this.etrnTdLb = etrnTdLb;
	}

	public String getEtrnDtLb() {
		return etrnDtLb;
	}

	public void setEtrnDtLb(String etrnDtLb) {
		this.etrnDtLb = etrnDtLb;
	}

	public List<Trn> getListTrn() {
		return listTrn;
	}

	public void setListTrn(List<Trn> listTrn) {
		this.listTrn = listTrn;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "" + getEtrnCdn();
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
		if (!(other instanceof Etrn)) {
			return false;
		}
		Etrn castOther = (Etrn) other;
		return new EqualsBuilder().append(this.getEtrnCdn(),
				castOther.getEtrnCdn()).isEquals();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(getEtrnCdn()).toHashCode();
	}

	/**
	 * Retourne l'identifiant.
	 * 
	 * @return l'identifiant
	 */
	public Serializable getIdentifier() {
		return etrnCdn;
	}

	/**
	 * On va remplir les champs non présents dans le XML reçu. Cette méthode est
	 * appelée automatiquement par XStream après la création de l'objet (ETRN).
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
	public Etrn cloneExportedFields(IExportConfiguration exportConfiguration) {
		Etrn clone = new Etrn();

		clone.setEtrnTypeLb(getEtrnTypeLb());
		clone.setEtrnTdLb(getEtrnTdLb());
		clone.setEtrnDtLb(getEtrnDtLb());

		return clone;
	}
}