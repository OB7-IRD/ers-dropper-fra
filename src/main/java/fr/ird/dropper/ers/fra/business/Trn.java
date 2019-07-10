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
 * Transport.
 * 
 * @author christelle.jeanberne
 */
@XStreamAlias("TRN")
public class Trn implements Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
	@XStreamOmitField
	private Long trnCdn;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("DC")
	private String trnDcLb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("LP")
	private String trnLpLb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("XR")
	private String trnXrLb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("NA")
	private String trnNaLb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("PL")
	private String trnPlLb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("DL")
	@XStreamConverter(DateConverter.class)
	private Date trnDlDt;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("NC")
	private String trnNcLb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("AC")
	private String trnAcLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("TR")
	private String trnTrLb;

	/** persistent field */
	@XStreamOmitField
	private List<Ers> listErs;

	/** persistent field */
	@XStreamImplicit(itemFieldName = "SPE")
	private List<Spe> listSpe;

	/** persistent field */
	@XStreamAlias("ETRN")
	private Etrn etrn;

	/** persistent field */
	@XStreamOmitField
	private List<Lan> listLan;

	public Long getTrnCdn() {
		return this.trnCdn;
	}

	public void setTrnCdn(Long trnCdn) {
		this.trnCdn = trnCdn;
	}

	public String getTrnDcLb() {
		return this.trnDcLb;
	}

	public void setTrnDcLb(String trnDcLb) {
		this.trnDcLb = trnDcLb;
	}

	public String getTrnLpLb() {
		return this.trnLpLb;
	}

	public void setTrnLpLb(String trnLpLb) {
		this.trnLpLb = trnLpLb;
	}

	public String getTrnXrLb() {
		return this.trnXrLb;
	}

	public void setTrnXrLb(String trnXrLb) {
		this.trnXrLb = trnXrLb;
	}

	public String getTrnNaLb() {
		return this.trnNaLb;
	}

	public void setTrnNaLb(String trnNaLb) {
		this.trnNaLb = trnNaLb;
	}

	public String getTrnPlLb() {
		return this.trnPlLb;
	}

	public void setTrnPlLb(String trnPlLb) {
		this.trnPlLb = trnPlLb;
	}

	public Date getTrnDlDt() {
		return this.trnDlDt;
	}

	public void setTrnDlDt(Date trnDlDt) {
		this.trnDlDt = trnDlDt;
	}

	public String getTrnNcLb() {
		return this.trnNcLb;
	}

	public void setTrnNcLb(String trnNcLb) {
		this.trnNcLb = trnNcLb;
	}

	public String getTrnAcLb() {
		return this.trnAcLb;
	}

	public void setTrnAcLb(String trnAcLb) {
		this.trnAcLb = trnAcLb;
	}

	public String getTrnTrLb() {
		return this.trnTrLb;
	}

	public void setTrnTrLb(String trnTrLb) {
		this.trnTrLb = trnTrLb;
	}

	public List<Ers> getListErs() {
		return listErs;
	}

	public void setListErs(List<Ers> listErs) {
		this.listErs = listErs;
	}

	public Etrn getEtrn() {
		return this.etrn;
	}

	public void setEtrn(Etrn etrn) {
		this.etrn = etrn;
	}

	public List<Lan> getListLan() {
		return this.listLan;
	}

	public void setListLan(List<Lan> listLan) {
		this.listLan = listLan;
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
		return "" + getTrnCdn();
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
		if (!(other instanceof Trn)) {
			return false;
		}
		Trn castOther = (Trn) other;
		return new EqualsBuilder().append(this.getTrnCdn(),
				castOther.getTrnCdn()).isEquals();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(getTrnCdn()).toHashCode();
	}

	/**
	 * Retourne l'identifiant.
	 * 
	 * @return l'identifiant
	 */
	public Serializable getIdentifier() {
		return trnCdn;
	}

	/**
	 * On va remplir les champs non présents dans le XML reçu. Cette méthode est
	 * appelée automatiquement par XStream après la création de l'objet (TRN).
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
	public Trn cloneExportedFields(IExportConfiguration exportConfiguration) {
		Trn clone = new Trn();

		clone.setTrnDcLb(getTrnDcLb());
		clone.setTrnLpLb(getTrnLpLb());
		clone.setTrnXrLb(getTrnXrLb());
		clone.setTrnNaLb(getTrnNaLb());
		clone.setTrnPlLb(getTrnPlLb());
		clone.setTrnDlDt(getTrnDlDt());
		clone.setTrnNcLb(getTrnNcLb());
		clone.setTrnAcLb(getTrnAcLb());
		clone.setTrnTrLb(getTrnTrLb());

		// Clone des SPE
		if (getListSpe() != null && !getListSpe().isEmpty()) {
			ArrayList<Spe> cloneSpes = new ArrayList<Spe>();
			for (Spe spe : getListSpe()) {
				cloneSpes.add(spe.cloneExportedFields(exportConfiguration));
			}
			clone.setListSpe(cloneSpes);
		}

		Etrn etrn = getEtrn();
		if (exportConfiguration.isExtensionsFrancaises() && etrn != null) {
			clone.setEtrn(etrn.cloneExportedFields(exportConfiguration));
		} else {
			clone.setEtrn(null);
		}

		return clone;
	}
}