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
import fr.ird.dropper.ers.fra.xstreamconverters.XsDateConverter;
import fr.ird.dropper.ers.fra.xstreamconverters.XsTimeConverter;

/**
 * Déclaration des espèces protégées.
 * 
 * @author christelle.jeanberne
 */
@XStreamAlias("ECPS")
public class Ecps extends EvenementDePecheImpl {

	private static final long serialVersionUID = 1L;

	/** identifier field */
	@XStreamOmitField
	private Long ecpsCdn;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("Type")
	private String ecpsTypeLb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("DA")
	@XStreamConverter(XsDateConverter.class)
	private Date ecpsDaDt;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("TI")
	@XStreamConverter(XsTimeConverter.class)
	private Date ecpsTiDt;

	/** nullable persistent field */
	@XStreamOmitField
	private Date ecpsDatiDt;

	/** persistent field */
	@XStreamOmitField
	private Elog elog;

	/** persistent field */
	@XStreamAlias("POS")
	private Pos pos;

	/** persistent field */
	@XStreamAlias("GEA")
	private Gea gea;

	/** persistent field */
	@XStreamImplicit(itemFieldName = "EDCI")
	private List<Edci> listEdci;

	public Long getEcpsCdn() {
		return this.ecpsCdn;
	}

	public void setEcpsCdn(Long ecpsCdn) {
		this.ecpsCdn = ecpsCdn;
	}

	public String getEcpsTypeLb() {
		return this.ecpsTypeLb;
	}

	public void setEcpsTypeLb(String ecpsTypeLb) {
		this.ecpsTypeLb = ecpsTypeLb;
	}

	public Date getEcpsDaDt() {
		return this.ecpsDaDt;
	}

	public void setEcpsDaDt(Date ecpsDaDt) {
		this.ecpsDaDt = ecpsDaDt;
	}

	public Date getEcpsTiDt() {
		return this.ecpsTiDt;
	}

	public void setEcpsTiDt(Date ecpsTiDt) {
		this.ecpsTiDt = ecpsTiDt;
	}

	public Date getEcpsDatiDt() {
		return this.ecpsDatiDt;
	}

	public void setEcpsDatiDt(Date ecpsDatiDt) {
		this.ecpsDatiDt = ecpsDatiDt;
	}

	public Elog getElog() {
		return this.elog;
	}

	public void setElog(Elog elog) {
		this.elog = elog;
	}

	public Pos getPos() {
		return this.pos;
	}

	public void setPos(Pos pos) {
		this.pos = pos;
	}

	public Gea getGea() {
		return this.gea;
	}

	public void setGea(Gea gea) {
		this.gea = gea;
	}

	public List<Edci> getListEdci() {
		return this.listEdci;
	}

	public void setListEdci(List<Edci> listEdci) {
		this.listEdci = listEdci;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "" + getEcpsCdn();
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
		if (!(other instanceof Ecps)) {
			return false;
		}
		Ecps castOther = (Ecps) other;
		return new EqualsBuilder().append(this.getEcpsCdn(),
				castOther.getEcpsCdn()).isEquals();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(getEcpsCdn()).toHashCode();
	}

	/**
	 * Retourne l'identifiant.
	 * 
	 * @return l'identifiant
	 */
	public Serializable getIdentifier() {
		return ecpsCdn;
	}

	/**
	 * On va remplir les champs non présents dans le XML reçu. Cette méthode est
	 * appelée automatiquement par XStream après la création de l'objet (ECPS).
	 * 
	 * @return this
	 */
	private Object readResolve() {
	    	DateConverter converter = new DateConverter();
		String dateHeure = converter.toString(getEcpsDaDt()) + " "
				+ converter.toTimeString(getEcpsTiDt());
		Date ecpsDatiDt = (Date) converter.fromDateTimeString(dateHeure);
		setEcpsDatiDt(ecpsDatiDt);
		return this;
	}

	/**
	 * Retourne un clone qui pourra être exporté par XStream dans un fichier XML
	 * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
	 * dernier est rempli de "proxies" que XStream ne gère pas correctement).
	 * 
	 * @return un objet qui peut être exporté par XStream
	 */
	public Ecps cloneExportedFields(IExportConfiguration exportConfiguration) {
		Ecps clone = new Ecps();

		clone.setEcpsTypeLb(getEcpsTypeLb());
		clone.setEcpsDaDt(getEcpsDaDt());
		clone.setEcpsTiDt(getEcpsTiDt());

		Pos pos = getPos();
		if (pos != null) {
			clone.setPos(pos.cloneExportedFields(exportConfiguration));
		} else {
			clone.setPos(null);
		}

		Gea gea = getGea();
		if (gea != null) {
			clone.setGea(gea.cloneExportedFields(exportConfiguration));
		} else {
			clone.setGea(null);
		}

		// Clone des EDCI
		if (getListEdci() != null && !getListEdci().isEmpty()) {
			ArrayList<Edci> cloneListEdci = new ArrayList<Edci>();
			for (Edci edci : getListEdci()) {
				cloneListEdci.add(edci.cloneExportedFields(exportConfiguration));
			}
			clone.setListEdci(cloneListEdci);
		}

		return clone;
	}
	
	/* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDaDt()
	 */
	public Date getDaDt() {
		return getEcpsDaDt();
	}

	/* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDatiDt()
	 */
	public Date getDatiDt() {
		return getEcpsDatiDt();
	}

	/* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getTiLb()
	 */
	public String getTiLb() {
		return new XsTimeConverter().toString(getEcpsTiDt());
	}

	/* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getType()
	 */
	public String getType() {
		return "ECPS";
	}

	/* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getLog()
	 */
	public Log getLog() {
		if (getElog() != null && getElog().getLogs() != null && !getElog().getLogs().isEmpty()) {
			return getElog().getLogs().iterator().next();
		} else {
			return null;
		}
	}

	public void addToLog(Log log) {
		if (log.getElog() == null) {
			return;
		}
		
		if (log.getElog().getListEcps() == null) {
			log.getElog().setListEcps(new ArrayList<Ecps>());
		}
		log.getElog().getListEcps().add(this);
	}
	
	
	public List<Ras> getRasList() {
		List<Ras> listRas = new ArrayList<Ras>();
		return listRas;
	}
}