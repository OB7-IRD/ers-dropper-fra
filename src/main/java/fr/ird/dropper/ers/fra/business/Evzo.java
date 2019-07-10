package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import fr.ird.dropper.ers.fra.xstreamconverters.DateConverter;
import fr.ird.dropper.ers.fra.xstreamconverters.XsDateConverter;
import fr.ird.dropper.ers.fra.xstreamconverters.XsTimeConverter;

/**
 * Message technique de fmc au hub français pour indiquer les changements de
 * zone d'effort d'un navire.
 * 
 * @author christelle.jeanberne
 */
@XStreamAlias("EVZO")
public class Evzo implements Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
	@XStreamOmitField
	private Long evzoCdn;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("Type")
	private String evzoTypeLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("IR")
	private String evzoIrLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("DA")
	@XStreamConverter(XsDateConverter.class)
	private Date evzoDaDt;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("TI")
	@XStreamConverter(XsTimeConverter.class)
	private Date evzoTiDt;

	/** nullable persistent field */
	@XStreamOmitField
	private Date evzoDatiDt;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("EZ")
	private String evzoEzLb;

	/** persistent field */
	@XStreamOmitField
	private Ops ops;

	public Long getEvzoCdn() {
		return this.evzoCdn;
	}

	public void setEvzoCdn(Long evzoCdn) {
		this.evzoCdn = evzoCdn;
	}

	public String getEvzoTypeLb() {
		return this.evzoTypeLb;
	}

	public void setEvzoTypeLb(String evzoTypeLb) {
		this.evzoTypeLb = evzoTypeLb;
	}

	public String getEvzoIrLb() {
		return this.evzoIrLb;
	}

	public void setEvzoIrLb(String evzoIrLb) {
		this.evzoIrLb = evzoIrLb;
	}

	public Date getEvzoDaDt() {
		return this.evzoDaDt;
	}

	public void setEvzoDaDt(Date evzoDaDt) {
		this.evzoDaDt = evzoDaDt;
	}

	public Date getEvzoTiDt() {
		return this.evzoTiDt;
	}

	public void setEvzoTiDt(Date evzoTiDt) {
		this.evzoTiDt = evzoTiDt;
	}

	public Date getEvzoDatiDt() {
		return this.evzoDatiDt;
	}

	public void setEvzoDatiDt(Date evzoDatiDt) {
		this.evzoDatiDt = evzoDatiDt;
	}

	public String getEvzoEzLb() {
		return this.evzoEzLb;
	}

	public void setEvzoEzLb(String evzoEzLb) {
		this.evzoEzLb = evzoEzLb;
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
		return "" + getEvzoCdn();
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
		if (!(other instanceof Evzo)) {
			return false;
		}
		Evzo castOther = (Evzo) other;
		return new EqualsBuilder().append(this.getEvzoCdn(),
				castOther.getEvzoCdn()).isEquals();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(getEvzoCdn()).toHashCode();
	}

	/**
	 * Retourne l'identifiant.
	 * 
	 * @return l'identifiant
	 */
	public Serializable getIdentifier() {
		return evzoCdn;
	}

	/**
	 * On va remplir les champs non présents dans le XML reçu. Cette méthode est
	 * appelée automatiquement par XStream après la création de l'objet (EVZO).
	 * 
	 * @return this
	 */
	private Object readResolve() {
		// On crée l'attribut evzoDatiDt (date/heure) qui est une concaténation
		// des attributs evzoDaDt (date) et evzoTiDt (heure)
		if (getEvzoDaDt() != null) {
			DateConverter converter = new DateConverter();
			String dateHeure = converter.toString(getEvzoDaDt());
			
			if (getEvzoTiDt() != null) {
				dateHeure = dateHeure + " "
					+ converter.toTimeString(getEvzoTiDt());
				Date datiDt = (Date) converter.fromDateTimeString(dateHeure);
				setEvzoDatiDt(datiDt);
			}
			
		}
		return this;
	}

	/**
	 * Retourne un clone qui pourra être exporté par XStream dans un fichier XML
	 * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
	 * dernier est rempli de "proxies" que XStream ne gère pas correctement).
	 * 
	 * @return un objet qui peut être exporté par XStream
	 */
	public Evzo cloneExportedFields(IExportConfiguration exportConfiguration) {
		Evzo clone = new Evzo();

		clone.setEvzoTypeLb(getEvzoTypeLb());
		clone.setEvzoIrLb(getEvzoIrLb());
		clone.setEvzoDaDt(getEvzoDaDt());
		clone.setEvzoTiDt(getEvzoTiDt());
		clone.setEvzoEzLb(getEvzoEzLb());

		return clone;
	}
}