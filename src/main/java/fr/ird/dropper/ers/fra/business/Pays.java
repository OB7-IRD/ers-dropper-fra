package fr.ird.dropper.ers.fra.business;

import java.util.Date;

/**
 * Table des pays (REF_SIP.T_PAYS).
 * 
 * @author christelle.jeanberne
 */
public class Pays {

	private String paysCda;

	private String paysIso3Rfa;

	private String paysIso2Rfa;

	private String paysInseeLb;

	private int paysRfn;

	private String paysFrLb;

	private String paysEnLb;

	private boolean paysCeOn;

	private Date paysDebvalDt;

	private Date paysFinvalDt;

	private Date paysCreationDt;

	private Date paysModifDt;

	private String paysCommentTxt;

	public String getPaysCda() {
		return paysCda;
	}

	public void setPaysCda(String paysCda) {
		this.paysCda = paysCda;
	}

	public String getPaysIso3Rfa() {
		return paysIso3Rfa;
	}

	public void setPaysIso3Rfa(String paysIso3Rfa) {
		this.paysIso3Rfa = paysIso3Rfa;
	}

	public String getPaysIso2Rfa() {
		return paysIso2Rfa;
	}

	public void setPaysIso2Rfa(String paysIso2Rfa) {
		this.paysIso2Rfa = paysIso2Rfa;
	}

	public String getPaysInseeLb() {
		return paysInseeLb;
	}

	public void setPaysInseeLb(String paysInseeLb) {
		this.paysInseeLb = paysInseeLb;
	}

	public int getPaysRfn() {
		return paysRfn;
	}

	public void setPaysRfn(int paysRfn) {
		this.paysRfn = paysRfn;
	}

	public String getPaysFrLb() {
		return paysFrLb;
	}

	public void setPaysFrLb(String paysFrLb) {
		this.paysFrLb = paysFrLb;
	}

	public String getPaysEnLb() {
		return paysEnLb;
	}

	public void setPaysEnLb(String paysEnLb) {
		this.paysEnLb = paysEnLb;
	}

	public boolean isPaysCeOn() {
		return paysCeOn;
	}

	public void setPaysCeOn(boolean paysCeOn) {
		this.paysCeOn = paysCeOn;
	}

	public Date getPaysDebvalDt() {
		return paysDebvalDt;
	}

	public void setPaysDebvalDt(Date paysDebvalDt) {
		this.paysDebvalDt = paysDebvalDt;
	}

	public Date getPaysFinvalDt() {
		return paysFinvalDt;
	}

	public void setPaysFinvalDt(Date paysFinvalDt) {
		this.paysFinvalDt = paysFinvalDt;
	}

	public Date getPaysCreationDt() {
		return paysCreationDt;
	}

	public void setPaysCreationDt(Date paysCreationDt) {
		this.paysCreationDt = paysCreationDt;
	}

	public Date getPaysModifDt() {
		return paysModifDt;
	}

	public void setPaysModifDt(Date paysModifDt) {
		this.paysModifDt = paysModifDt;
	}

	public String getPaysCommentTxt() {
		return paysCommentTxt;
	}

	public void setPaysCommentTxt(String paysCommentTxt) {
		this.paysCommentTxt = paysCommentTxt;
	}
}