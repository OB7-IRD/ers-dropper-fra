package fr.ird.dropper.ers.fra.business;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Classe des navires.
 * 
 * @author christelle.jeanberne
 */
public class Navire {

	private static final long serialVersionUID = 1L;

	/** identifier field */
	private String navireCda;

	/** persistent field */
	private String navireCfrRfa;

	/** persistent field */
	private String navireNumimmatLb;

	/** nullable persistent field */
	private String navireNomLb;

	/** persistent field */
	private String navireMarqextLb;

	/** persistent field */
	private Boolean navireVmsOn;

	/** persistent field */
	private Boolean navireIrcsOn;

	/** nullable persistent field */
	private String navireIrcscodLb;

	/** nullable persistent field */
	private BigDecimal navireLoaNb;

	/** nullable persistent field */
	private BigDecimal navireLbpNb;

	/** nullable persistent field */
	private BigDecimal navireTonnagegtNb;

	/** nullable persistent field */
	private BigDecimal navireTonnageautreNb;

	/** nullable persistent field */
	private BigDecimal navireGtsNb;

	/** nullable persistent field */
	private BigDecimal navirePuissanceprincNb;

	/** nullable persistent field */
	private BigDecimal navirePuissanceauxNb;

	/** persistent field */
	private Boolean navireLicenceOn;

	/** nullable persistent field */
	private Date navireMesDt;

	/** nullable persistent field */
	private Date navireDecadmDt;

	/** nullable persistent field */
	private String navireConsAnneeNb;

	/** nullable persistent field */
	private String navireLieuconsLb;

	/** persistent field */
	private Date navireDebvalDt;

	/** persistent field */
	private Date navireFinvalDt;

	/** persistent field */
	private Date navireCreationDt;

	/** persistent field */
	private Date navireModifDt;

	/** nullable persistent field */
	private String navireCommentTxt;

	/** nullable persistent field */
	private Long navireCfrNb;

	/**
	 * Retourne l'identifiant du navire.
	 * 
	 * @return l'identifiant
	 */
	public String getNavireCda() {
		return this.navireCda;
	}

	/**
	 * Affecte l'identifiant du navire.
	 * 
	 * @param navireCda l'identifiant
	 */
	public void setNavireCda(String navireCda) {
		this.navireCda = navireCda;
	}

	/**
	 * Retourne le no CFR du navire.
	 * 
	 * @return le no CFR du navire
	 */
	public String getNavireCfrRfa() {
		return this.navireCfrRfa;
	}

	/**
	 * Affecte le no CFR du navire.
	 * 
	 * @param navireCfrRfa le no CFR du navire
	 */
	public void setNavireCfrRfa(String navireCfrRfa) {
		this.navireCfrRfa = navireCfrRfa;
	}

	/**
	 * Retourne le no d'immatriculation.
	 * 
	 * @return le no d'immatriculation
	 */
	public String getNavireNumimmatLb() {
		return this.navireNumimmatLb;
	}

	/**
	 * Affecte le no d'immatriculation.
	 * 
	 * @param navireNumimmatLb le no d'immatriculation
	 */
	public void setNavireNumimmatLb(String navireNumimmatLb) {
		this.navireNumimmatLb = navireNumimmatLb;
	}

	/**
	 * Retourne le nom du navire.
	 * 
	 * @return le nom du navire
	 */
	public String getNavireNomLb() {
		return this.navireNomLb;
	}

	/**
	 * Affecte le nom du navire.
	 * 
	 * @param navireNomLb le nom du navire
	 */
	public void setNavireNomLb(String navireNomLb) {
		this.navireNomLb = navireNomLb;
	}

	/**
	 * Retourne le no de marquage externe du navire.
	 * 
	 * @return le no de marquage externe du navire
	 */
	public String getNavireMarqextLb() {
		return this.navireMarqextLb;
	}

	/**
	 * Affecte le no de marquage externe du navire.
	 * 
	 * @param navireMarqextLb le no de marquage externe du navire
	 */
	public void setNavireMarqextLb(String navireMarqextLb) {
		this.navireMarqextLb = navireMarqextLb;
	}

	/**
	 * Retourne navireVmsOn.
	 * 
	 * @return navireVmsOn
	 */
	public Boolean getNavireVmsOn() {
		return this.navireVmsOn;
	}

	/**
	 * Affecte navireVmsOn.
	 * 
	 * @param navireVmsOn
	 */
	public void setNavireVmsOn(Boolean navireVmsOn) {
		this.navireVmsOn = navireVmsOn;
	}

	/**
	 * Retourne si le navire a un no IRCS.
	 * 
	 * @return si le navire a un no IRCS
	 */
	public Boolean getNavireIrcsOn() {
		return this.navireIrcsOn;
	}

	/**
	 * Affecte si le navire a un no IRCS.
	 * 
	 * @param navireIrcsOn true si le navire a un no IRCS
	 */
	public void setNavireIrcsOn(Boolean navireIrcsOn) {
		this.navireIrcsOn = navireIrcsOn;
	}

	/**
	 * Retourne le no IRCS du navire.
	 * 
	 * @return le no IRCS du navire
	 */
	public String getNavireIrcscodLb() {
		return this.navireIrcscodLb;
	}

	/**
	 * Affecte le no IRCS du navire.
	 * 
	 * @param navireIrcscodLb le no IRCS du navire
	 */
	public void setNavireIrcscodLb(String navireIrcscodLb) {
		this.navireIrcscodLb = navireIrcscodLb;
	}

	/**
	 * Retourne navireLoaNb.
	 * 
	 * @return navireLoaNb
	 */
	public BigDecimal getNavireLoaNb() {
		return this.navireLoaNb;
	}

	/**
	 * Affecte navireLoaNb.
	 * 
	 * @param navireLoaNb
	 */
	public void setNavireLoaNb(BigDecimal navireLoaNb) {
		this.navireLoaNb = navireLoaNb;
	}

	/**
	 * Retourne navireLbpNb.
	 * 
	 * @return navireLbpNb
	 */
	public BigDecimal getNavireLbpNb() {
		return this.navireLbpNb;
	}

	/**
	 * Affecte navireLbpNb;
	 * 
	 * @param navireLbpNb
	 */
	public void setNavireLbpNb(BigDecimal navireLbpNb) {
		this.navireLbpNb = navireLbpNb;
	}

	/**
	 * Retourne le tonnage GT.
	 * 
	 * @return le tonnage GT
	 */
	public BigDecimal getNavireTonnagegtNb() {
		return this.navireTonnagegtNb;
	}

	/**
	 * Affecte le tonnage GT.
	 * 
	 * @param navireTonnagegtNb le tonnage GT
	 */
	public void setNavireTonnagegtNb(BigDecimal navireTonnagegtNb) {
		this.navireTonnagegtNb = navireTonnagegtNb;
	}

	/**
	 * Retourne l'autre tonnage.
	 * 
	 * @return l'autre tonnage
	 */
	public BigDecimal getNavireTonnageautreNb() {
		return this.navireTonnageautreNb;
	}

	/**
	 * Affecte l'autre tonnage.
	 * 
	 * @param navireTonnageautreNb l'autre tonnage
	 */
	public void setNavireTonnageautreNb(BigDecimal navireTonnageautreNb) {
		this.navireTonnageautreNb = navireTonnageautreNb;
	}

	/**
	 * Retourne navireGtsNb.
	 * 
	 * @return navireGtsNb
	 */
	public BigDecimal getNavireGtsNb() {
		return this.navireGtsNb;
	}

	/**
	 * Affecte navireGtsNb.
	 * 
	 * @param navireGtsNb
	 */
	public void setNavireGtsNb(BigDecimal navireGtsNb) {
		this.navireGtsNb = navireGtsNb;
	}

	/**
	 * Retourne la puissance principale.
	 * 
	 * @return la puissance principale
	 */
	public BigDecimal getNavirePuissanceprincNb() {
		return this.navirePuissanceprincNb;
	}

	/**
	 * Affecte la puissance principale.
	 * 
	 * @param navirePuissanceprincNb la puissance principale
	 */
	public void setNavirePuissanceprincNb(BigDecimal navirePuissanceprincNb) {
		this.navirePuissanceprincNb = navirePuissanceprincNb;
	}

	/**
	 * Retourne la puissance auxiliaire.
	 * 
	 * @return la puissance auxiliaire
	 */
	public BigDecimal getNavirePuissanceauxNb() {
		return this.navirePuissanceauxNb;
	}

	/**
	 * Affecte la puissance auxiliaire.
	 * 
	 * @param navirePuissanceauxNb la puissance auxiliaire
	 */
	public void setNavirePuissanceauxNb(BigDecimal navirePuissanceauxNb) {
		this.navirePuissanceauxNb = navirePuissanceauxNb;
	}

	/**
	 * Retourne navireLicenceOn.
	 * 
	 * @return navireLicenceOn
	 */
	public Boolean getNavireLicenceOn() {
		return this.navireLicenceOn;
	}

	/**
	 * Affecte navireLicenceOn.
	 * 
	 * @param navireLicenceOn
	 */
	public void setNavireLicenceOn(Boolean navireLicenceOn) {
		this.navireLicenceOn = navireLicenceOn;
	}

	/**
	 * Retourne navireMesDt.
	 * 
	 * @return navireMesDt
	 */
	public Date getNavireMesDt() {
		return this.navireMesDt;
	}

	/**
	 * Affecte navireMesDt.
	 * 
	 * @param navireMesDt
	 */
	public void setNavireMesDt(Date navireMesDt) {
		this.navireMesDt = navireMesDt;
	}

	/**
	 * Retourne navireDecadmDt.
	 * 
	 * @return navireDecadmDt
	 */
	public Date getNavireDecadmDt() {
		return this.navireDecadmDt;
	}

	/**
	 * Affecte navireDecadmDt.
	 * 
	 * @param navireDecadmDt
	 */
	public void setNavireDecadmDt(Date navireDecadmDt) {
		this.navireDecadmDt = navireDecadmDt;
	}

	/**
	 * Retourne l'année de construction.
	 * 
	 * @return l'année de construction
	 */
	public String getNavireConsAnneeNb() {
		return this.navireConsAnneeNb;
	}

	/**
	 * Affecte l'année de construction.
	 * 
	 * @param navireConsAnneeNb l'année de construction
	 */
	public void setNavireConsAnneeNb(String navireConsAnneeNb) {
		this.navireConsAnneeNb = navireConsAnneeNb;
	}

	/**
	 * Retourne le lieu de construction.
	 * 
	 * @return le lieu de construction
	 */
	public String getNavireLieuconsLb() {
		return this.navireLieuconsLb;
	}

	/**
	 * Affecte le lieu de construction.
	 * 
	 * @param navireLieuconsLb le lieu de construction
	 */
	public void setNavireLieuconsLb(String navireLieuconsLb) {
		this.navireLieuconsLb = navireLieuconsLb;
	}

	/**
	 * Retourne la date de début de validité du navire.
	 * 
	 * @return la date de début de validité
	 */
	public Date getNavireDebvalDt() {
		return this.navireDebvalDt;
	}

	/**
	 * Affecte la date de début de validité du navire.
	 * 
	 * @param navireDebvalDt la date de début de validité
	 */
	public void setNavireDebvalDt(Date navireDebvalDt) {
		this.navireDebvalDt = navireDebvalDt;
	}

	/**
	 * Retourne la date de fin de validité du navire.
	 * 
	 * @return la date de fin de validité
	 */
	public Date getNavireFinvalDt() {
		return this.navireFinvalDt;
	}

	/**
	 * Affecte la date de fin de validité du navire.
	 * 
	 * @param navireFinvalDt la date de fin de validité
	 */
	public void setNavireFinvalDt(Date navireFinvalDt) {
		this.navireFinvalDt = navireFinvalDt;
	}

	/**
	 * Retourne la date de création du navire.
	 * 
	 * @return la date de création
	 */
	public Date getNavireCreationDt() {
		return this.navireCreationDt;
	}

	/**
	 * Affecte la date de création du navire.
	 * 
	 * @param navireCreationDt la date de création
	 */
	public void setNavireCreationDt(Date navireCreationDt) {
		this.navireCreationDt = navireCreationDt;
	}

	/**
	 * Retourne la date de modification du navire.
	 * 
	 * @return la date de modification
	 */
	public Date getNavireModifDt() {
		return this.navireModifDt;
	}

	/**
	 * Affecte la date de modification du navire.
	 * 
	 * @param navireModifDt la date de modification
	 */
	public void setNavireModifDt(Date navireModifDt) {
		this.navireModifDt = navireModifDt;
	}

	/**
	 * Retourne le commentaire sur le navire.
	 * 
	 * @return le commentaire
	 */
	public String getNavireCommentTxt() {
		return this.navireCommentTxt;
	}

	/**
	 * Retourne le commentaire sur le navire.
	 * 
	 * @param navireCommentTxt le commentaire
	 */
	public void setNavireCommentTxt(String navireCommentTxt) {
		this.navireCommentTxt = navireCommentTxt;
	}

	/**
	 * Retourne
	 * 
	 * @return
	 */
	public Long getNavireCfrNb() {
		return this.navireCfrNb;
	}

	/**
	 * @param navireCfrNb
	 */
	public void setNavireCfrNb(Long navireCfrNb) {
		this.navireCfrNb = navireCfrNb;
	}
}