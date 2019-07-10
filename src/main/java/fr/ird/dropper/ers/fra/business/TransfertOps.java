package fr.ird.dropper.ers.fra.business;

import java.util.Date;

/**
 * Table utilisée pour mémoriser les transferts réalisés ou à réaliser.
 * 
 * MTTRAN07
 * Une table T_TRANSFERT_OPS est utilisée pour mémoriser les transferts réalisés ou à réaliser. Elle comporte les colonnes suivantes :
 * TRAOPS_CDN : identifiant technique auto-incrémenté du transfert
 * OPS_CDN : identifiant du message intégré en base concerné par le transfert
 * TRAOPS_DEST_LB : code du destinataire du transfert
 * TRAOPS_ENVOI_DT : date effective du transfert
 * TRAOPS_CREATION_DT : date de création du transfert
 * TRAOPS_TYPE_LB : type de transfert (SACROIS, IRD, OP)
 * 
 * @author conor.morgan
 */
public class TransfertOps {

	private Long cdn;
	
	private Long opsCdn;

	private String destLb;

	private String typeLb;

	private Date envoi;
	
	private Date creation;

	public Long getCdn() {
		return cdn;
	}

	public void setCdn(Long cdn) {
		this.cdn = cdn;
	}

	public Long getOpsCdn() {
		return opsCdn;
	}

	public void setOpsCdn(Long opsCdn) {
		this.opsCdn = opsCdn;
	}

	public String getDestLb() {
		return destLb;
	}

	public void setDestLb(String destLb) {
		this.destLb = destLb;
	}

	public String getTypeLb() {
		return typeLb;
	}

	public void setTypeLb(String typeLb) {
		this.typeLb = typeLb;
	}

	public Date getEnvoi() {
		return envoi;
	}

	public void setEnvoi(Date envoi) {
		this.envoi = envoi;
	}

	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}



}