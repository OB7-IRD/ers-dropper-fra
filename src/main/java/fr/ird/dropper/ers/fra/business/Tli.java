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
 * Prise de contrôle en ligne.
 * 
 * @author christelle.jeanberne
 */
@XStreamAlias("TLI")
public class Tli implements Serializable {

	private static final long serialVersionUID = 5573930157755388666L;

	/** identifier field */
	@XStreamOmitField
	private Long tliCdn;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("DA")
	@XStreamConverter(DateConverter.class)
	private Date tliDaDt;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("SC")
	private String tliScLb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("SL")
	private String tliSlLb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("NT")
	private String tliNtLb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("NF")
	private String tliNfLb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("AF")
	private String tliAfLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("TR")
	private String tliTrLb;

	/** persistent field */
	@XStreamAlias("SRC")
	private Src src;

	/** persistent field */
	@XStreamImplicit(itemFieldName = "CST")
	private List<Cst> listCst;

	/** persistent field */
	@XStreamImplicit(itemFieldName = "ETLI")
	private List<Etli> listEtli;

	/** persistent field */
	@XStreamOmitField
	private List<Sal> listSal;

	/** Empty constructor */
	public Tli() {
		super();
	}

	public Long getTliCdn() {
		return this.tliCdn;
	}

	public void setTliCdn(Long tliCdn) {
		this.tliCdn = tliCdn;
	}

	public Date getTliDaDt() {
		return this.tliDaDt;
	}

	public void setTliDaDt(Date tliDaDt) {
		this.tliDaDt = tliDaDt;
	}

	public String getTliScLb() {
		return this.tliScLb;
	}

	public void setTliScLb(String tliScLb) {
		this.tliScLb = tliScLb;
	}

	public String getTliSlLb() {
		return this.tliSlLb;
	}

	public void setTliSlLb(String tliSlLb) {
		this.tliSlLb = tliSlLb;
	}

	public String getTliNtLb() {
		return this.tliNtLb;
	}

	public void setTliNtLb(String tliNtLb) {
		this.tliNtLb = tliNtLb;
	}

	public String getTliNfLb() {
		return this.tliNfLb;
	}

	public void setTliNfLb(String tliNfLb) {
		this.tliNfLb = tliNfLb;
	}

	public String getTliAfLb() {
		return this.tliAfLb;
	}

	public void setTliAfLb(String tliAfLb) {
		this.tliAfLb = tliAfLb;
	}

	public String getTliTrLb() {
		return this.tliTrLb;
	}

	public void setTliTrLb(String tliTrLb) {
		this.tliTrLb = tliTrLb;
	}

	public Src getSrc() {
		return this.src;
	}

	public void setSrc(Src src) {
		this.src = src;
	}

	public List<Etli> getListEtli() {
		return this.listEtli;
	}

	public void setListEtli(List<Etli> listEtli) {
		this.listEtli = listEtli;
	}

	public List<Sal> getListSal() {
		return this.listSal;
	}

	public void setListSal(List<Sal> listSal) {
		this.listSal = listSal;
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
		return "" + getTliCdn();
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
		if (!(other instanceof Tli)) {
			return false;
		}
		Tli castOther = (Tli) other;
		return new EqualsBuilder().append(this.getTliCdn(),
				castOther.getTliCdn()).isEquals();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(getTliCdn()).toHashCode();
	}

	/**
	 * Retourne l'identifiant.
	 * 
	 * @return l'identifiant
	 */
	public Serializable getIdentifier() {
		return tliCdn;
	}

	/**
	 * Retourne un clone qui pourra être exporté par XStream dans un fichie XML
	 * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
	 * dernier est rempli de "proxies" que XStream ne gère pas correctement).
	 * 
	 * @return un objet qui peur être exporté par XStream
	 */
	public Tli cloneExportedFields(IExportConfiguration exportConfiguration) {
		Tli clone = new Tli();

		clone.setTliDaDt(getTliDaDt());
		clone.setTliScLb(getTliScLb());
		clone.setTliSlLb(getTliSlLb());
		clone.setTliNtLb(getTliNtLb());
		clone.setTliNfLb(getTliNfLb());
		clone.setTliAfLb(getTliAfLb());
		clone.setTliTrLb(getTliTrLb());

		clone.setSrc(getSrc() == null ? null : getSrc().cloneExportedFields(exportConfiguration));

		// Clone des CST
		if (getListCst() != null && !getListCst().isEmpty()) {
			ArrayList<Cst> cloneCsts = new ArrayList<Cst>();
			for (Cst cst : getListCst()) {
				cloneCsts.add(cst.cloneExportedFields(exportConfiguration));
			}
			clone.setListCst(cloneCsts);
		}

		// Clone des ETLI
		if (exportConfiguration.isExtensionsFrancaises() && 
				getListEtli() != null && !getListEtli().isEmpty()) {
			ArrayList<Etli> cloneEtlis = new ArrayList<Etli>();
			for (Etli etli : getListEtli()) {
				cloneEtlis.add(etli.cloneExportedFields(exportConfiguration));
			}
			clone.setListEtli(cloneEtlis);
		}

		return clone;
	}
}