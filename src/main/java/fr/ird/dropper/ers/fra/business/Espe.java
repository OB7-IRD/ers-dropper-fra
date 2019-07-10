package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Extension (précision) de l'espèce.
 * 
 * @author christelle.jeanberne
 */
@XStreamAlias("ESPE")
public class Espe implements Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
	@XStreamOmitField
	private Long espeCdn;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("MR")
	private Integer espeMrNb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("ZO")
	private String espeZoLb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("Type")
	private String espeTypeLb;

	/** persistent field */
	@XStreamOmitField
	private List<Spe> listSpe;

	public Long getEspeCdn() {
		return this.espeCdn;
	}

	public void setEspeCdn(Long espeCdn) {
		this.espeCdn = espeCdn;
	}

	public Integer getEspeMrNb() {
		return this.espeMrNb;
	}

	public void setEspeMrNb(Integer espeMrNb) {
		this.espeMrNb = espeMrNb;
	}

	public String getEspeZoLb() {
		return this.espeZoLb;
	}

	public void setEspeZoLb(String espeZoLb) {
		this.espeZoLb = espeZoLb;
	}

	public String getEspeTypeLb() {
		return this.espeTypeLb;
	}

	public void setEspeTypeLb(String espeTypeLb) {
		this.espeTypeLb = espeTypeLb;
	}

	public List<Spe> getListSpe() {
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
		return "" + getEspeCdn();
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
		if (!(other instanceof Espe)) {
			return false;
		}
		Espe castOther = (Espe) other;
		return new EqualsBuilder().append(this.getEspeCdn(),
				castOther.getEspeCdn()).isEquals();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(getEspeCdn()).toHashCode();
	}

	/**
	 * Retourne l'identifiant.
	 * 
	 * @return l'identifiant
	 */
	public Serializable getIdentifier() {
		return espeCdn;
	}

	/**
	 * On va remplir les champs non présents dans le XML reçu. Cette méthode est
	 * appelée automatiquement par XStream après la création de l'objet (ESPE).
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
	public Espe cloneExportedFields(IExportConfiguration exportConfiguration) {
		Espe clone = new Espe();

		clone.setEspeTypeLb(getEspeTypeLb());
		clone.setEspeZoLb(getEspeZoLb());
		clone.setEspeMrNb(getEspeMrNb());

		return clone;
	}
}