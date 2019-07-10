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

import fr.gouv.agriculture.adage.ers.service.utils.ErsUtils;
import fr.ird.dropper.ers.fra.xstreamconverters.DateConverter;

/**
 * Notification de transfert.
 * 
 * @author christelle.jeanberne
 */
@XStreamAlias("PNT")
public class Pnt extends EvenementDePecheImpl {

	private static final long serialVersionUID = 1L;

	/** identifier field */
	@XStreamOmitField
	private Long pntCdn;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("DA")
	@XStreamConverter(DateConverter.class)
	private Date pntDaDt;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("TI")
	private String pntTiLb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("NA")
	private String pntNaLb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("IN")
	private String pntInLb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("CT")
	private int pntCtNb;

	/** nullable persistent field */
	@XStreamOmitField
	private Date pntDatiDt;

	/** persistent field */
	@XStreamOmitField
	private Log log;

	/** persistent field */
	@XStreamImplicit(itemFieldName = "SPE")
	private List<Spe> listSpe;

	/** persistent field */
	@XStreamAlias("POS")
	private Pos pos;

	/** non persistent field */
	@XStreamOmitField
	private Ops nonPersistedOps;
	
	
	public Long getPntCdn() {
		return this.pntCdn;
	}

	public void setPntCdn(Long pntCdn) {
		this.pntCdn = pntCdn;
	}

	public Date getPntDaDt() {
		return this.pntDaDt;
	}

	public void setPntDaDt(Date pntDaDt) {
		this.pntDaDt = pntDaDt;
	}

	public String getPntTiLb() {
		return this.pntTiLb;
	}

	public void setPntTiLb(String pntTiLb) {
		this.pntTiLb = pntTiLb;
	}

	public String getPntNaLb() {
		return this.pntNaLb;
	}

	public void setPntNaLb(String pntNaLb) {
		this.pntNaLb = pntNaLb;
	}

	public String getPntInLb() {
		return this.pntInLb;
	}

	public void setPntInLb(String pntInLb) {
		this.pntInLb = pntInLb;
	}

	public int getPntCtNb() {
		return this.pntCtNb;
	}

	public void setPntCtNb(int pntCtNb) {
		this.pntCtNb = pntCtNb;
	}

	public Date getPntDatiDt() {
		return this.pntDatiDt;
	}

	public void setPntDatiDt(Date pntDatiDt) {
		this.pntDatiDt = pntDatiDt;
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

	public Pos getPos() {
		return this.pos;
	}

	public void setPos(Pos pos) {
		this.pos = pos;
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
		return "" + getPntCdn();
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
		if (!(other instanceof Pnt)) {
			return false;
		}
		Pnt castOther = (Pnt) other;
		return new EqualsBuilder().append(this.getPntCdn(),
				castOther.getPntCdn()).isEquals();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(getPntCdn()).toHashCode();
	}

	/**
	 * Retourne l'identifiant.
	 * 
	 * @return l'identifiant
	 */
	public Serializable getIdentifier() {
		return pntCdn;
	}

	/**
	 * On va remplir les champs non présents dans le XML reçu. Cette méthode est
	 * appelée automatiquement par XStream après la création de l'objet (PNT)
	 * 
	 * @return this
	 */
	private Object readResolve() {
		DateConverter converter = new DateConverter();
		// On crée l'attribut pntPdptDt (date/heure) qui est une concaténation
		// des attributs pntPdDt (date) et pntPtLb (heure)
		String dateHeure = converter.toString(getPntDaDt()) + " "
				+ getPntTiLb();
		Date datiDt = (Date) converter.fromDateTimeString(dateHeure);
		setPntDatiDt(datiDt);

		if (getPntDaDt() != null && getPntTiLb() != null) {
			String heure = getPntTiLb();

			// si l'heure n'est pas fournie, on prend 0h00
			if (heure == null) {
				heure = "00:00";
			}

			// On crée l'attribut pntDatiDt (date/heure) qui est une
			// concaténation des attributs pntDaDt (date) et pntTiLb (heure)
			String dateHeure2 = converter.toString(getPntDaDt()) + " " + heure;
			Date pntDatiDt = (Date) converter.fromDateTimeString(dateHeure2);
			setPntDatiDt(pntDatiDt);
		} else {
			setPntDatiDt(null);
		}

		return this;
	}

	/**
	 * Retourne un clone qui pourra être exporté par XStream dans un fichie XML
	 * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
	 * dernier est rempli de "proxies" que XStream ne gère pas correctement).
	 * 
	 * @return un objet qui peur être exporté par XStream
	 */
	public Pnt cloneExportedFields(IExportConfiguration exportConfiguration) {
		Pnt clone = new Pnt();

		clone.setPntDaDt(getPntDaDt());
		clone.setPntTiLb(getPntTiLb());
		clone.setPntNaLb(getPntNaLb());
		clone.setPntInLb(getPntInLb());
		clone.setPntCtNb(getPntCtNb());

		Pos pos = getPos();
		if (pos != null) {
			clone.setPos(pos.cloneExportedFields(exportConfiguration));
		} else {
			clone.setPos(null);
		}

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
		return "PNT";
	}

	public Ops getOpsAncetre() {
		Ops opsAncetre;
		
		if (getNonPersistedOps() != null) {
			opsAncetre = getNonPersistedOps();
		} else {
			opsAncetre = ErsUtils.getOps(this);
		}
		
		return opsAncetre;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDatiDt()
	 */
	public Date getDatiDt() {
		Ops opsAncetre = this.getOpsAncetre();
		if (opsAncetre != null) {
			return opsAncetre.getOpsOdotDt();
		} else {
			return this.getPntDatiDt();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDatiDt()
	 */
	public Date getDaDt() {
		Ops opsAncetre = this.getOpsAncetre();
		if (opsAncetre != null) {
			return opsAncetre.getOpsOdDt();
		} else {
			return this.getPntDaDt();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDatiDt()
	 */
	public String getTiLb() {
		Ops opsAncetre = this.getOpsAncetre();
		if (opsAncetre != null) {
			return opsAncetre.getOpsOtLb();
		} else {
			return this.getPntTiLb();
		}
	}
	/**
	 * @return the nonPersistedOps
	 */
	public Ops getNonPersistedOps() {
		return nonPersistedOps;
	}

	/**
	 * @param nonPersistedOps the nonPersistedOps to set
	 */
	public void setNonPersistedOps(Ops nonPersistedOps) {
		this.nonPersistedOps = nonPersistedOps;
	}


	public void addToLog(Log log) {
		if (log.getListPnt() == null) {
			log.setListPnt(new ArrayList<Pnt>());
		}
		log.getListPnt().add(this);
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