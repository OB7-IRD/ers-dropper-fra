package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Composition du poisson s'il est en dessous de la taille minimale.
 * 
 * @author christelle.jeanberne
 */
@XStreamAlias("SIZ")
public class Siz implements Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
	@XStreamOmitField
	private Long sizCdn;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("S6")
	private double sizS6Nb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("S8")
	private double sizS8Nb;

	/** persistent field */
	@XStreamOmitField
	private List<Spe> listSpe;

	public Long getSizCdn() {
		return this.sizCdn;
	}

	public void setSizCdn(Long sizCdn) {
		this.sizCdn = sizCdn;
	}

	public double getSizS6Nb() {
		return this.sizS6Nb;
	}

	public void setSizS6Nb(double sizS6Nb) {
		this.sizS6Nb = sizS6Nb;
	}

	public double getSizS8Nb() {
		return this.sizS8Nb;
	}

	public void setSizS8Nb(double sizS8Nb) {
		this.sizS8Nb = sizS8Nb;
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
		return "" + getSizCdn();
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
		if (!(other instanceof Siz)) {
			return false;
		}
		Siz castOther = (Siz) other;
		return new EqualsBuilder().append(this.getSizCdn(),
				castOther.getSizCdn()).isEquals();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(getSizCdn()).toHashCode();
	}

	/**
	 * Retourne l'identifiant.
	 * 
	 * @return l'identifiant
	 */
	public Serializable getIdentifier() {
		return sizCdn;
	}

	/**
	 * On va remplir les champs non présents dans le XML reçu. Cette méthode est
	 * appelée automatiquement par XStream après la création de l'objet (SIZ).
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
	public Siz cloneExportedFields(IExportConfiguration exportConfiguration) {
		Siz clone = new Siz();

		clone.setSizS6Nb(getSizS6Nb());
		clone.setSizS8Nb(getSizS8Nb());

		return clone;
	}
}