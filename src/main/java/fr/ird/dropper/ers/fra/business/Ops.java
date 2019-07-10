package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import fr.gouv.agriculture.adage.ers.service.GenerationService;
import fr.gouv.agriculture.adage.ers.service.SessionProviderService;
import fr.gouv.agriculture.adage.ers.service.utils.ErsUtils;
import fr.ird.dropper.ers.fra.xstreamconverters.DateConverter;

/**
 * Opération.
 * 
 * @author christelle.jeanberne
 */
@XStreamAlias("OPS")
public class Ops implements Serializable {

	public static String namespace = "ers:";

	private static final long serialVersionUID = 2111338633013674878L;

	@SuppressWarnings("unused")
	@XStreamAsAttribute
	@XStreamAlias("xmlns:xsi")
	private String xmlns_xsi = Constants.XMLNS_XSI;

	/** identifier field */
	@XStreamOmitField
	private Long opsCdn;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("AD")
	private String opsAdLb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("FR")
	private String opsFrLb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("ON")
	private String opsOnLb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("OD")
	@XStreamConverter(DateConverter.class)
	private Date opsOdDt;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("OT")
	private String opsOtLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("TS")
	private String opsTsLb;

	/** persistent field */
	@XStreamOmitField
	private Date opsOdotDt;

	/** persistent field */
	@XStreamOmitField
	private Date opsCreationDt;

	/** nullable persistent field */
	@XStreamOmitField
	private Date opsConversionDt;

	/** persistent field */
	@XStreamOmitField
	private transient String opsTypeMesLb;
	
	/** nullable persistent field */
	@XStreamOmitField
	private Long idXmlf;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("EAV")
	private String opsEavLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("EVL")
	private String opsEvlLb;

	/** persistent field */
	@XStreamOmitField
	private String opsVersionErsLb;

	/** persistent field */
	@XStreamOmitField
	private Operateur operateur;

	/** persistent field */
	@XStreamOmitField
	private List<Rsp> rspsByOpsCdnQue;

	/** persistent field */
	@XStreamImplicit(itemFieldName = "RSP")
	private List<Rsp> rsps;

	/** persistent field */
	@XStreamImplicit(itemFieldName = "DAT")
	private List<Dat> dats;

	/** persistent field */
	@XStreamImplicit(itemFieldName = "COR")
	private List<Cor> cors;

	/** persistent field */
	@XStreamImplicit(itemFieldName = "DEL")
	private List<Del> dels;

	/** persistent field */
	@XStreamImplicit(itemFieldName = "RET")
	private List<Ret> rets;

	/** persistent field */
	@XStreamImplicit(itemFieldName = "EVZO")
	private List<Evzo> evzos;

	/** persistent field */
	@XStreamImplicit(itemFieldName = "QUE")
	private List<Que> ques;

	/** persistent field */
	@XStreamOmitField
	private List<Que> quesByOpsCdnTransf;

	/** persistent field */
	@XStreamImplicit(itemFieldName = "EMAV")
	private List<Emav> emavs;

	/** persistent field */
	@XStreamOmitField
	private List<Journal> journals;

	/** nullable persistent field */
	@XStreamOmitField
	private Long fdCdn;

	/** nullable persistent field */
	@XStreamOmitField
	private Long rspCdn;
	
	/**
	 * Retourne l'identifiant.
	 */
	public Long getOpsCdn() {
		return this.opsCdn;
	}

	public void setOpsCdn(Long opsCdn) {
		this.opsCdn = opsCdn;
	}

	/**
	 * Retourne le destinataire.
	 */
	public String getOpsAdLb() {
		return this.opsAdLb;
	}

	public void setOpsAdLb(String opsAdLb) {
		this.opsAdLb = opsAdLb;
	}

	/**
	 * Retourne l'expéditeur.
	 */
	public String getOpsFrLb() {
		return this.opsFrLb;
	}

	public void setOpsFrLb(String opsFrLb) {
		this.opsFrLb = opsFrLb;
	}

	/**
	 * Retourne le numéro d'opération.
	 */
	public String getOpsOnLb() {
		return this.opsOnLb;
	}

	public void setOpsOnLb(String opsOnLb) {
		this.opsOnLb = opsOnLb;
	}

	/**
	 * Retourne la date.
	 */
	public Date getOpsOdDt() {
		return this.opsOdDt;
	}

	public void setOpsOdDt(Date opsOdDt) {
		this.opsOdDt = opsOdDt;
	}

	/**
	 * Retourne l'heure.
	 */
	public String getOpsOtLb() {
		return this.opsOtLb;
	}

	public void setOpsOtLb(String opsOtLb) {
		this.opsOtLb = opsOtLb;
	}

	/**
	 * Retourne une valeur indiquant qu'il s'agit d'un fichier de test.
	 */
	public String getOpsTsLb() {
		return this.opsTsLb;
	}

	public void setOpsTsLb(String opsTsLb) {
		this.opsTsLb = opsTsLb;
	}

	/**
	 * Retourne la date/heure.
	 */
	public Date getOpsOdotDt() {
		return this.opsOdotDt;
	}

	public void setOpsOdotDt(Date opsOdotDt) {
		this.opsOdotDt = opsOdotDt;
	}

	/**
	 * Retourne la date/heure de création.
	 */
	public Date getOpsCreationDt() {
		return this.opsCreationDt;
	}

	public void setOpsCreationDt(Date opsCreationDt) {
		this.opsCreationDt = opsCreationDt;
	}

	/**
	 * Retourne la date/heure de conversion.
	 */
	public Date getOpsConversionDt() {
		return this.opsConversionDt;
	}

	public void setOpsConversionDt(Date opsConversionDt) {
		this.opsConversionDt = opsConversionDt;
	}

	/**
	 * Retourne le type de message (DAT/COR/DEL/RET/QUE/RSP/EMAV/EVZO).
	 */
	public String getOpsTypeMesLb() {
		return this.opsTypeMesLb;
	}

	public void setOpsTypeMesLb(String opsTypeMesLb) {
		this.opsTypeMesLb = opsTypeMesLb;
	}

	/**
	 * Retourne le tag indiquant un message corrigé par l'administration et la
	 * raison.
	 */
	public String getOpsEavLb() {
		return opsEavLb;
	}

	public void setOpsEavLb(String opsEavLb) {
		this.opsEavLb = opsEavLb;
	}

	/**
	 * Retourne le logiciel et version du logiciel producteur du document.
	 */
	public String getOpsEvlLb() {
		return opsEvlLb;
	}

	public void setOpsEvlLb(String opsEvlLb) {
		this.opsEvlLb = opsEvlLb;
	}

	/**
	 * Retourne la version d'ERS ("V3" ou "V1->V3").
	 */
	public String getOpsVersionErsLb() {
		return opsVersionErsLb;
	}

	public void setOpsVersionErsLb(String opsVersionErsLb) {
		this.opsVersionErsLb = opsVersionErsLb;
	}

	/**
	 * Retourne l'identifiant du fichier XML.
	 */
	public Long getFdCdn() {
		return this.fdCdn;
	}

	public void setFdCdn(Long fdCdn) {
		this.fdCdn = fdCdn;
	}

	/**
	 * Retourne l'opérateur.
	 */
	public Operateur getOperateur() {
		return this.operateur;
	}

	public void setOperateur(Operateur operateur) {
		this.operateur = operateur;
	}

	public List<Rsp> getRspsByOpsCdnQue() {
		return this.rspsByOpsCdnQue;
	}

	public void setRspsByOpsCdnQue(List<Rsp> rspsByOpsCdnQue) {
		this.rspsByOpsCdnQue = rspsByOpsCdnQue;
	}

	public Rsp getRsp() {
		if (getRsps() == null || getRsps().isEmpty()) {
			return null;
		} else {
			return getRsps().get(0);
		}
	}

	public List<Rsp> getRsps() {
		return this.rsps;
	}

	public void setRsps(List<Rsp> rsps) {
		this.rsps = rsps;
	}

	public Dat getDat() {
		if (getDats() == null || getDats().isEmpty()) {
			return null;
		} else {
			return getDats().get(0);
		}
	}

	public List<Dat> getDats() {
		return this.dats;
	}

	public void setDats(List<Dat> dats) {
		this.dats = dats;
	}

	public Evzo getEvzo() {
		if (getEvzos() == null || getEvzos().isEmpty()) {
			return null;
		} else {
			return getEvzos().get(0);
		}
	}

	public List<Evzo> getEvzos() {
		return this.evzos;
	}

	public void setEvzos(List<Evzo> evzos) {
		this.evzos = evzos;
	}

	public Cor getCor() {
		if (getCors() == null || getCors().isEmpty()) {
			return null;
		} else {
			return getCors().get(0);
		}
	}

	public List<Cor> getCors() {
		return this.cors;
	}

	public void setCors(List<Cor> cors) {
		this.cors = cors;
	}

	public Del getDel() {
		if (getDels() == null || getDels().isEmpty()) {
			return null;
		} else {
			return getDels().get(0);
		}
	}

	public List<Del> getDels() {
		return this.dels;
	}

	public void setDels(List<Del> dels) {
		this.dels = dels;
	}

	public Que getQue() {
		if (getQues() == null || getQues().isEmpty()) {
			return null;
		} else {
			return getQues().get(0);
		}
	}

	public List<Que> getQues() {
		return this.ques;
	}

	public void setQues(List<Que> ques) {
		this.ques = ques;
	}

	public List<Que> getQuesByOpsCdnTransf() {
		return this.quesByOpsCdnTransf;
	}

	public void setQuesByOpsCdnTransf(List<Que> quesByOpsCdnTransf) {
		this.quesByOpsCdnTransf = quesByOpsCdnTransf;
	}

	public Ret getRet() {
		if (getRets() == null || getRets().isEmpty()) {
			return null;
		} else {
			return getRets().get(0);
		}
	}

	public List<Ret> getRets() {
		return this.rets;
	}

	public void setRets(List<Ret> rets) {
		this.rets = rets;
	}

	public Emav getEmav() {
		if (getEmavs() == null || getEmavs().isEmpty()) {
			return null;
		} else {
			return getEmavs().get(0);
		}
	}

	public List<Emav> getEmavs() {
		return this.emavs;
	}

	public void setEmavs(List<Emav> emavs) {
		this.emavs = emavs;
	}

	public List<Journal> getJournals() {
		return this.journals;
	}

	public void setJournals(List<Journal> journals) {
		this.journals = journals;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "OpsCdn:" + getOpsCdn() + " OpsAdLb:" + getOpsAdLb() + " OpsFrLb:" + getOpsFrLb() + " OpsOnLb:"
				+ getOpsOnLb() + " OpsOdDt:" + getOpsOdDt() + " OpsOtLb:" + getOpsOtLb() + " OpsTsLb:" + getOpsTsLb()
				+ " OpsOdotDt:" + getOpsOdotDt() + " OpsCreationDt:" + getOpsCreationDt() + " OpsTypeMesLb:"
				+ getOpsTypeMesLb() + " Operateur:" + getOperateur() + " Journals:" + getJournals() + " FdCdn:"
				+ getFdCdn() + " IdXMLF:" +getIdXmlf();
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
		if (!(other instanceof Ops)) {
			return false;
		}
		Ops castOther = (Ops) other;
		return new EqualsBuilder().append(this.getOpsCdn(), castOther.getOpsCdn()).isEquals();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(getOpsCdn()).toHashCode();
	}

	/**
	 * Retourne l'identifiant.
	 * 
	 * @return l'identifiant
	 */
	public Serializable getIdentifier() {
		return opsCdn;
	}

	/**
	 * On va remplir les champs non présents dans le XML reçu. Cette méthode est
	 * appelée automatiquement par XStream après la création de l'objet (OPS).
	 * 
	 * @return this
	 */
	private Object readResolve() {
		// On crée l'attribut opsOdotDt (date/heure) qui est une concaténation
		// des attributs opsOdDt (date) et opsOtLb (heure)
		DateConverter converter = new DateConverter();
		String dateHeure = converter.toString(getOpsOdDt()) + " " + getOpsOtLb();
		Date opsOdotDt = (Date) converter.fromDateTimeString(dateHeure);
		setOpsOdotDt(opsOdotDt);

		// On met la date/heure courante pour le champs creationDt
		setOpsCreationDt(new Date());

		// On met un type de message suivant la balise fille du fichier XML
		if (getDat() != null) {
			setOpsTypeMesLb("DAT");
		} else if (getCor() != null) {
			setOpsTypeMesLb("COR");
		} else if (getDel() != null) {
			setOpsTypeMesLb("DEL");
		} else if (getQue() != null) {
			setOpsTypeMesLb("QUE");
		} else if (getRsp() != null) {
			setOpsTypeMesLb("RSP");
		} else if (getRet() != null) {
			setOpsTypeMesLb("RET");
		} else if (getEmav() != null) {
			setOpsTypeMesLb("EMAV");
		} else if (getEvzo() != null) {
			setOpsTypeMesLb("EVZO");
		}

		// ERS04 : si l'émetteur est la France, on renseigne ERS_RN_LB et
		// ERS_FR_RN_LB
		if (getDats() != null && !getDats().isEmpty()) {
			for (Dat dat : getDats()) {
				if (SessionProviderService.getService().getSession() != null && ErsUtils.isEmetteurFrancais(this)) {
					dat.getErs().setErsFrRnLb(getDat().getErs().getErsRnLb());
					dat.getErs().setErsRnLb(
							GenerationService.getService().getNextRecordNumber(
									SessionProviderService.getService().getSession()));

				}
				if (dat.getErs() != null && dat.getErs().getLog() != null) {
					if (dat.getErs().getLog().getPno() != null) {
						dat.getErs().getLog().getPno().setNonPersistedOps(this);
					}

					if (dat.getErs().getLog().getPnt() != null) {
						dat.getErs().getLog().getPnt().setNonPersistedOps(this);
					}
				}
			}
		} else if (getCors() != null && !getCors().isEmpty()) {
			for (Cor cor : getCors()) {
				if (SessionProviderService.getService().getSession() != null && ErsUtils.isEmetteurFrancais(this)) {
					cor.getErs().setErsFrRnLb(getCor().getErs().getErsRnLb());
					cor.getErs().setErsRnLb(
							GenerationService.getService().getNextRecordNumber(
									SessionProviderService.getService().getSession()));
				}
				if (cor.getErs() != null && cor.getErs().getLog() != null) {
					if (cor.getErs().getLog().getPno() != null) {
						cor.getErs().getLog().getPno().setNonPersistedOps(this);
					}

					if (cor.getErs().getLog().getPnt() != null) {
						cor.getErs().getLog().getPnt().setNonPersistedOps(this);
					}
				}
			}
		} else if (getDels() != null && !getDels().isEmpty()) {
			for (Del del : getDels()) {
				if (del.getErs() != null && del.getErs().getLog() != null) {
					if (del.getErs().getLog().getPno() != null) {
						del.getErs().getLog().getPno().setNonPersistedOps(this);
					}

					if (del.getErs().getLog().getPnt() != null) {
						del.getErs().getLog().getPnt().setNonPersistedOps(this);
					}
				}
			}
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
	public Ops cloneExportedFields(IExportConfiguration exportConfiguration) {
		Ops clone = new Ops();

		clone.setOpsAdLb(getOpsAdLb());
		clone.setOpsFrLb(getOpsFrLb());
		clone.setOpsOnLb(getOpsOnLb());
		clone.setOpsOdDt(getOpsOdDt());
		clone.setOpsOtLb(getOpsOtLb());
		clone.setOpsTsLb(getOpsTsLb());
		clone.setOpsEavLb(getOpsEavLb());
		clone.setOpsEvlLb(getOpsEvlLb());

		// Clone des RSP
		if (getRsps() != null && !getRsps().isEmpty()) {
			ArrayList<Rsp> cloneRsps = new ArrayList<Rsp>();
			for (Rsp rsp : getRsps()) {
				cloneRsps.add(rsp.cloneExportedFields(exportConfiguration));
			}
			clone.setRsps(cloneRsps);
		}

		// Clone des DAT
		if (getDats() != null && !getDats().isEmpty()) {
			ArrayList<Dat> cloneDats = new ArrayList<Dat>();
			for (Dat dat : getDats()) {
				cloneDats.add(dat.cloneExportedFields(exportConfiguration));
			}
			clone.setDats(cloneDats);
		}

		// Clone des COR
		if (getCors() != null && !getCors().isEmpty()) {
			ArrayList<Cor> cloneCors = new ArrayList<Cor>();
			for (Cor cor : getCors()) {
				cloneCors.add(cor.cloneExportedFields(exportConfiguration));
			}
			clone.setCors(cloneCors);
		}

		// Clone des DEL
		if (getDels() != null && !getDels().isEmpty()) {
			ArrayList<Del> cloneDels = new ArrayList<Del>();
			for (Del del : getDels()) {
				cloneDels.add(del.cloneExportedFields(exportConfiguration));
			}
			clone.setDels(cloneDels);
		}

		// Clone des QUE
		if (getQues() != null && !getQues().isEmpty()) {
			ArrayList<Que> cloneQues = new ArrayList<Que>();
			for (Que que : getQues()) {
				cloneQues.add(que.cloneExportedFields(exportConfiguration));
			}
			clone.setQues(cloneQues);
		}

		// Clone des RET
		if (getRets() != null && !getRets().isEmpty()) {
			ArrayList<Ret> cloneRets = new ArrayList<Ret>();
			for (Ret ret : getRets()) {
				cloneRets.add(ret.cloneExportedFields(exportConfiguration));
			}
			clone.setRets(cloneRets);
		}

		// Clone des EMAV
		if (exportConfiguration.isExtensionsFrancaises() && getEmavs() != null && !getEmavs().isEmpty()) {
			ArrayList<Emav> cloneEmavs = new ArrayList<Emav>();
			for (Emav emav : getEmavs()) {
				cloneEmavs.add(emav.cloneExportedFields(exportConfiguration));
			}
			clone.setEmavs(cloneEmavs);
		}

		// Clone des EVZO
		if (exportConfiguration.isExtensionsFrancaises() && getEvzos() != null && !getEvzos().isEmpty()) {
			ArrayList<Evzo> cloneEvzos = new ArrayList<Evzo>();
			for (Evzo evzo : getEvzos()) {
				cloneEvzos.add(evzo.cloneExportedFields(exportConfiguration));
			}
			clone.setEvzos(cloneEvzos);
		}

		return clone;
	}

	/**
	 * Permet de savoir si l'attribut TS est renseigné.
	 * 
	 * @return
	 */
	public boolean isTsRenseigne() {
		return StringUtils.isNotBlank(getOpsTsLb());
	}

	public Long getRspCdn() {
		return rspCdn;
	}

	public void setRspCdn(Long rspCdn) {
		this.rspCdn = rspCdn;
	}
	
	public Long getIdXmlf() {
		return idXmlf;
	}

	public void setIdXmlf(Long idXmlf) {
		this.idXmlf = idXmlf;
	}
	
}