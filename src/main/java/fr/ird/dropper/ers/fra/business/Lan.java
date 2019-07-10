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
 * Débarquement.
 * 
 * @author christelle.jeanberne
 */
@XStreamAlias("LAN")
public class Lan extends EvenementDePecheImpl {

	private static final long serialVersionUID = -3529253898598523142L;

	/** identifier field */
	@XStreamOmitField
	private Long lanCdn;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("DA")
	@XStreamConverter(DateConverter.class)
	private Date lanDaDt;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("TI")
	private String lanTiLb;
	
	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("TS")
	private String lanTsLb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("PO")
	private String lanPoLb;

	/** nullable persistent field */
	@XStreamOmitField
	private Date lanDatiDt;

	/** persistent field */
	@XStreamOmitField
	private Log log;

	/** persistent field */
	@XStreamImplicit(itemFieldName = "SPE")
	private List<Spe> listSpe;

	/** persistent field */
	@XStreamImplicit(itemFieldName = "TRN")
	private List<Trn> listTrn;

	/**
	 * Retourne l'identifiant.
	 */
	public Long getLanCdn() {
		return this.lanCdn;
	}

	public void setLanCdn(Long lanCdn) {
		this.lanCdn = lanCdn;
	}

	/**
	 * Retourne la date.
	 */
	public Date getLanDaDt() {
		return this.lanDaDt;
	}

	public void setLanDaDt(Date lanDaDt) {
		this.lanDaDt = lanDaDt;
	}

	/**
	 * Retourne l'heure.
	 */
	public String getLanTiLb() {
		return this.lanTiLb;
	}

	public void setLanTiLb(String lanTiLb) {
		this.lanTiLb = lanTiLb;
	}

	/**
	 * Retourne le port.
	 */
	public String getLanPoLb() {
		return this.lanPoLb;
	}

	public void setLanPoLb(String lanPoLb) {
		this.lanPoLb = lanPoLb;
	}

	/**
	 * Retourne le type d'expéditeur (MAS: maître, REP: son représentant, AGE: Agent).
	 */
	public String getLanTsLb() {
		return this.lanTsLb;
	}

	public void setLanTsLb(String lanTsLb) {
		this.lanTsLb = lanTsLb;
	}

	/**
	 * Retourne la date/heure.
	 */
	public Date getLanDatiDt() {
		return this.lanDatiDt;
	}

	public void setLanDatiDt(Date lanDatiDt) {
		this.lanDatiDt = lanDatiDt;
	}

	/* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePecheImpl#getLog()
	 */
	@Override
	public Log getLog() {
		return this.log;
	}

	public void setLog(Log log) {
		this.log = log;
	}

	public List<Trn> getListTrn() {
		return this.listTrn;
	}

	public void setListTrn(List<Trn> listTrn) {
		this.listTrn = listTrn;
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
		return "" + getLanCdn();
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
		if (!(other instanceof Lan)) {
			return false;
		}
		Lan castOther = (Lan) other;
		return new EqualsBuilder().append(this.getLanCdn(),
				castOther.getLanCdn()).isEquals();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(getLanCdn()).toHashCode();
	}

	/**
	 * Retourne l'identifiant.
	 * 
	 * @return l'identifiant
	 */
	public Serializable getIdentifier() {
		return lanCdn;
	}

	/**
	 * On va remplir les champs non présents dans le XML reçu. Cette méthode est
	 * appelée automatiquement par XStream après la création de l'objet (LAN)
	 * 
	 * @return this
	 */
	private Object readResolve() {
		// On crée l'attribut lanDatiDt (date/heure) qui est une concaténation
		// des attributs lanDaDt (date) et lanTiLb (heure)
		DateConverter converter = new DateConverter();
		String dateHeure = converter.toString(getLanDaDt());
		if(getLanTiLb() == null) {
		    dateHeure += " 00:00";
		} else {
		    dateHeure += " " + getLanTiLb();
		}
		Date lanDatiDt = (Date) converter.fromDateTimeString(dateHeure);
		setLanDatiDt(lanDatiDt);
		return this;
	}

	/**
	 * Retourne un clone qui pourra être exporté par XStream dans un fichie XML
	 * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
	 * dernier est rempli de "proxies" que XStream ne gère pas correctement).
	 * 
	 * @return un objet qui peur être exporté par XStream
	 */
	public Lan cloneExportedFields(IExportConfiguration exportConfiguration) {
		Lan clone = new Lan();

		clone.setLanDaDt(getLanDaDt());
		clone.setLanTiLb(getLanTiLb());
		clone.setLanTsLb(getLanTsLb());
		clone.setLanPoLb(getLanPoLb());

		// Clone des SPE
		if (getListSpe() != null && !getListSpe().isEmpty()) {
			ArrayList<Spe> cloneSpes = new ArrayList<Spe>();
			for (Spe spe : getListSpe()) {
				cloneSpes.add(spe.cloneExportedFields(exportConfiguration));
			}
			clone.setListSpe(cloneSpes);
		}

		return clone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getType()
	 */
	public String getType() {
		return "LAN";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDatiDt()
	 */
	public Date getDatiDt() {
		return getLanDatiDt();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDaDt()
	 */
	public Date getDaDt() {
		return getLanDaDt();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getTiLb()
	 */
	public String getTiLb() {
		return getLanTiLb();
	}


	public void addToLog(Log log) {
		if (log.getListLan() == null) {
			log.setListLan(new ArrayList<Lan>());
		}
		log.getListLan().add(this);
	}
	
	public List<Ras> getRasList() {
		List<Ras> listRas = new ArrayList<Ras>();
		if(getListSpe()==null){
			return listRas;
		}
		for(Spe spe : getListSpe()){
			listRas.add(spe.getRas());
		}
		return listRas;
	}

}