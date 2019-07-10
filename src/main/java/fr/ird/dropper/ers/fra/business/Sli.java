package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import fr.ird.dropper.ers.fra.xstreamconverters.DateConverter;

/**
 * Ligne de vente.
 * 
 * @author christelle.jeanberne
 */
@XStreamAlias("SLI")
public class Sli implements Serializable {

	private static final long serialVersionUID = 5318410088347118399L;

	/** identifier field */
	@XStreamOmitField
	private Long sliCdn;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("DA")
	@XStreamConverter(DateConverter.class)
	private Date sliDaDt;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("SC")
	private String sliScLb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("SL")
	private String sliSlLb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("NS")
	private String sliNsLb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("NB")
	private String sliNbLb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("VN")
	private String sliVnLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("CN")
	private String sliCnLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("BC")
	private String sliBcLb;

	/** persistent field */
	@XStreamAlias("SRC")
	private Src src;

	/** persistent field */
	@XStreamImplicit(itemFieldName = "CSS")
	private List<Css> listCss;

	/** persistent field */
	@XStreamImplicit(itemFieldName = "ESLI")
	private List<Esli> listEsli;

	/** persistent field */
	@XStreamOmitField
	private List<Sal> listSal;

	public Long getSliCdn() {
		return this.sliCdn;
	}

	public void setSliCdn(Long sliCdn) {
		this.sliCdn = sliCdn;
	}

	public Date getSliDaDt() {
		return this.sliDaDt;
	}

	public void setSliDaDt(Date sliDaDt) {
		this.sliDaDt = sliDaDt;
	}

	public String getSliScLb() {
		return this.sliScLb;
	}

	public void setSliScLb(String sliScLb) {
		this.sliScLb = sliScLb;
	}

	public String getSliSlLb() {
		return this.sliSlLb;
	}

	public void setSliSlLb(String sliSlLb) {
		this.sliSlLb = sliSlLb;
	}

	public String getSliNsLb() {
		return this.sliNsLb;
	}

	public void setSliNsLb(String sliNsLb) {
		this.sliNsLb = sliNsLb;
	}

	public String getSliNbLb() {
		return this.sliNbLb;
	}

	public void setSliNbLb(String sliNbLb) {
		this.sliNbLb = sliNbLb;
	}

	public String getSliVnLb() {
		return this.sliVnLb;
	}

	public void setSliVnLb(String sliVnLb) {
		this.sliVnLb = sliVnLb;
	}

	public String getSliCnLb() {
		return this.sliCnLb;
	}

	public void setSliCnLb(String sliCnLb) {
		this.sliCnLb = sliCnLb;
	}

	public String getSliBcLb() {
		return this.sliBcLb;
	}

	public void setSliBcLb(String sliBcLb) {
		this.sliBcLb = sliBcLb;
	}

	public Src getSrc() {
		return this.src;
	}

	public void setSrc(Src src) {
		this.src = src;
	}

	public List<Css> getListCss() {
		return this.listCss;
	}

	public void setListCss(List<Css> listCss) {
		this.listCss = listCss;
	}

	public List<Esli> getListEsli() {
		return this.listEsli;
	}

	public void setListEsli(List<Esli> listEsli) {
		this.listEsli = listEsli;
	}

	public List<Sal> getListSal() {
		return this.listSal;
	}

	public void setListSal(List<Sal> listSal) {
		this.listSal = listSal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "" + getSliCdn();
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
		if (!(other instanceof Sli)) {
			return false;
		}
		Sli castOther = (Sli) other;
		return new EqualsBuilder().append(this.getSliCdn(),
				castOther.getSliCdn()).isEquals();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(getSliCdn()).toHashCode();
	}

	/**
	 * Retourne l'identifiant.
	 * 
	 * @return l'identifiant
	 */
	public Serializable getIdentifier() {
		return sliCdn;
	}

	/**
	 * Retourne un clone qui pourra être exporté par XStream dans un fichie XML
	 * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
	 * dernier est rempli de "proxies" que XStream ne gère pas correctement).
	 * 
	 * @return un objet qui peur être exporté par XStream
	 */
	public Sli cloneExportedFields(IExportConfiguration exportConfiguration) {
		Sli clone = new Sli();

		clone.setSliDaDt(getSliDaDt());
		clone.setSliScLb(getSliScLb());
		clone.setSliSlLb(getSliSlLb());
		clone.setSliNsLb(getSliNsLb());
		clone.setSliNbLb(getSliNbLb());
		clone.setSliVnLb(getSliVnLb());
		clone.setSliCnLb(getSliCnLb());
		clone.setSliBcLb(getSliBcLb());

		clone.setSrc(getSrc().cloneExportedFields(exportConfiguration));

		// Clone des CSS
		if (getListCss() != null && !getListCss().isEmpty()) {
			ArrayList<Css> cloneCsss = new ArrayList<Css>();
			for (Css css : getListCss()) {
				cloneCsss.add(css.cloneExportedFields(exportConfiguration));
			}
			clone.setListCss(cloneCsss);
		}

		// Clone des ESLI
		if (exportConfiguration.isExtensionsFrancaises() && 
				getListEsli() != null && !getListEsli().isEmpty()) {
			ArrayList<Esli> cloneEslis = new ArrayList<Esli>();
			for (Esli esli : getListEsli()) {
				cloneEslis.add(esli.cloneExportedFields(exportConfiguration));
			}
			clone.setListEsli(cloneEslis);
		}

		return clone;
	}
}