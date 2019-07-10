package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Envois vendus.
 * 
 * @author christelle.jeanberne
 */
@XStreamAlias("CSS")
public class Css implements Serializable {

	private static final long serialVersionUID = -8676692227760885472L;

	/** identifier field */
	@XStreamOmitField
	private Long cssCdn;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("FP")
	private double cssFpNb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("TP")
	private double cssTpNb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("CR")
	private String cssCrLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("SF")
	private String cssSfLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("PP")
	private String cssPpLb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("WD")
	private String cssWdLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("OP")
	private String cssOpLb;

	/** persistent field */
	@XStreamAlias("SPE")
	private Spe spe;

	/** nullable persistent field */
	@XStreamAlias("ECSS")
	private Ecss ecss;

	/** persistent field */
	@XStreamOmitField
	private List<Sli> listSli;

	public Long getCssCdn() {
		return this.cssCdn;
	}

	public void setCssCdn(Long cssCdn) {
		this.cssCdn = cssCdn;
	}

	public double getCssFpNb() {
		return this.cssFpNb;
	}

	public void setCssFpNb(double cssFpNb) {
		this.cssFpNb = cssFpNb;
	}

	public Double getCssTpNb() {
		return this.cssTpNb;
	}

	public void setCssTpNb(Double cssTpNb) {
		this.cssTpNb = cssTpNb;
	}

	public String getCssCrLb() {
		return this.cssCrLb;
	}

	public void setCssCrLb(String cssCrLb) {
		this.cssCrLb = cssCrLb;
	}

	public String getCssSfLb() {
		return this.cssSfLb;
	}

	public void setCssSfLb(String cssSfLb) {
		this.cssSfLb = cssSfLb;
	}

	public String getCssPpLb() {
		return this.cssPpLb;
	}

	public void setCssPpLb(String cssPpLb) {
		this.cssPpLb = cssPpLb;
	}

	public String getCssWdLb() {
		return this.cssWdLb;
	}

	public void setCssWdLb(String cssWdLb) {
		this.cssWdLb = cssWdLb;
	}

	public String getCssOpLb() {
		return this.cssOpLb;
	}

	public void setCssOpLb(String cssOpLb) {
		this.cssOpLb = cssOpLb;
	}

	public Spe getSpe() {
		return this.spe;
	}

	public void setSpe(Spe spe) {
		this.spe = spe;
	}

	public Ecss getEcss() {
		return this.ecss;
	}

	public void setEcss(Ecss ecss) {
		this.ecss = ecss;
	}

	public List<Sli> getListSli() {
		return this.listSli;
	}

	public void setListSli(List<Sli> listSli) {
		this.listSli = listSli;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "" + getCssCdn();
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
		if (!(other instanceof Css)) {
			return false;
		}
		Css castOther = (Css) other;
		return new EqualsBuilder().append(this.getCssCdn(),
				castOther.getCssCdn()).isEquals();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(getCssCdn()).toHashCode();
	}

	/**
	 * Retourne l'identifiant.
	 * 
	 * @return l'identifiant
	 */
	public Serializable getIdentifier() {
		return cssCdn;
	}

	/**
	 * Retourne un clone qui pourra être exporté par XStream dans un fichier XML
	 * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
	 * dernier est rempli de "proxies" que XStream ne gère pas correctement).
	 * 
	 * @return un objet qui peut être exporté par XStream
	 */
	public Css cloneExportedFields(IExportConfiguration exportConfiguration) {
		Css clone = new Css();

		clone.setCssFpNb(getCssFpNb());
		clone.setCssTpNb(getCssTpNb());
		clone.setCssCrLb(getCssCrLb());
		clone.setCssSfLb(getCssSfLb());
		clone.setCssPpLb(getCssPpLb());
		clone.setCssWdLb(getCssWdLb());
		clone.setCssOpLb(getCssOpLb());

		clone.setSpe(getSpe() == null ? null : getSpe().cloneExportedFields(exportConfiguration));

		Ecss ecss = getEcss();
		if (exportConfiguration.isExtensionsFrancaises() && ecss != null) {
			clone.setEcss(ecss.cloneExportedFields(exportConfiguration));
		} else {
			clone.setEcss(null);
		}

		return clone;
	}
}