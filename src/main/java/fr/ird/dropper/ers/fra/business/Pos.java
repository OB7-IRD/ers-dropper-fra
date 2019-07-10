package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Position à midi si aucune capture n'a été faite.
 * 
 * @author christelle.jeanberne
 */
@XStreamAlias("POS")
public class Pos implements Serializable {

	private static final long serialVersionUID = -1710227780426719987L;

	/** identifier field */
	@XStreamOmitField
	private Long posCdn;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("LT")
	private double posLtNb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("LG")
	private double posLgNb;

	/** persistent field */
	@XStreamOmitField
	private List<Tra> tras;

	/** persistent field */
	@XStreamOmitField
	private List<Ger> gers;

	/** persistent field */
	@XStreamOmitField
	private List<Ges> listGes;

	/** persistent field */
	@XStreamOmitField
	private List<Coe> listCoe;

	/** persistent field */
	@XStreamOmitField
	private List<Cox> coxs;

	/** persistent field */
	@XStreamOmitField
	private List<Pno> pnos;

	/** persistent field */
	@XStreamOmitField
	private List<Pnt> listPnt;

	/** persistent field */
	@XStreamOmitField
	private List<Jci> listJci;

	/** persistent field */
	@XStreamOmitField
	private List<Ecps> listEcps;

	/** persistent field */
	@XStreamOmitField
	private List<Far> listFar;

	/** persistent field */
	@XStreamOmitField
	private List<Rlc> rlcs;

	/** persistent field */
	@XStreamOmitField
	private List<Ins> listIns;

	/** persistent field */
	@XStreamOmitField
	private List<Gil> gils;

	/** persistent field */
	@XStreamOmitField
	private List<Dis> listDis;

	/** persistent field */
	@XStreamOmitField
	private List<Gls> listGls;

	/** persistent field */
	@XStreamOmitField
	private List<Bti> listBti;

	public Long getPosCdn() {
		return this.posCdn;
	}

	public void setPosCdn(Long posCdn) {
		this.posCdn = posCdn;
	}

	public double getPosLtNb() {
		return this.posLtNb;
	}

	public void setPosLtNb(double posLtNb) {
		this.posLtNb = posLtNb;
	}

	public double getPosLgNb() {
		return this.posLgNb;
	}

	public void setPosLgNb(double posLgNb) {
		this.posLgNb = posLgNb;
	}

	public List<Tra> getTras() {
		return this.tras;
	}

	public void setTras(List<Tra> tras) {
		this.tras = tras;
	}

	public List<Ger> getGers() {
		return this.gers;
	}

	public void setGers(List<Ger> gers) {
		this.gers = gers;
	}

	public List<Ges> getListGes() {
		return this.listGes;
	}

	public void setListGes(List<Ges> listGes) {
		this.listGes = listGes;
	}

	public List<Coe> getListCoe() {
		return this.listCoe;
	}

	public void setListCoe(List<Coe> listCoe) {
		this.listCoe = listCoe;
	}

	public List<Cox> getCoxs() {
		return this.coxs;
	}

	public void setCoxs(List<Cox> coxs) {
		this.coxs = coxs;
	}

	public List<Pno> getPnos() {
		return this.pnos;
	}

	public void setPnos(List<Pno> pnos) {
		this.pnos = pnos;
	}

	public List<Pnt> getListPnt() {
		return this.listPnt;
	}

	public void setListPnt(List<Pnt> listPnt) {
		this.listPnt = listPnt;
	}

	public List<Jci> getListJci() {
		return this.listJci;
	}

	public void setListJci(List<Jci> listJci) {
		this.listJci = listJci;
	}

	public List<Ecps> getListEcps() {
		return this.listEcps;
	}

	public void setListEcps(List<Ecps> listEcps) {
		this.listEcps = listEcps;
	}

	public List<Far> getListFar() {
		return this.listFar;
	}

	public void setListFar(List<Far> listFar) {
		this.listFar = listFar;
	}

	public List<Rlc> getRlcs() {
		return this.rlcs;
	}

	public void setRlcs(List<Rlc> rlcs) {
		this.rlcs = rlcs;
	}

	public List<Ins> getListIns() {
		return this.listIns;
	}

	public void setListIns(List<Ins> listIns) {
		this.listIns = listIns;
	}

	public List<Gil> getGils() {
		return this.gils;
	}

	public void setGils(List<Gil> gils) {
		this.gils = gils;
	}

	public List<Dis> getListDis() {
		return this.listDis;
	}

	public void setListDis(List<Dis> listDis) {
		this.listDis = listDis;
	}

	public List<Gls> getListGls() {
		return this.listGls;
	}

	public void setListGls(List<Gls> listGls) {
		this.listGls = listGls;
	}

	public List<Bti> getListBti() {
		return this.listBti;
	}

	public void setListBti(List<Bti> listBti) {
		this.listBti = listBti;
	}

	public String toString() {
		return "" + getPosCdn();
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
		if (!(other instanceof Pos)) {
			return false;
		}
		Pos castOther = (Pos) other;
		return new EqualsBuilder().append(this.getPosCdn(),
				castOther.getPosCdn()).isEquals();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(getPosCdn()).toHashCode();
	}

	/**
	 * Retourne l'identifiant.
	 * 
	 * @return l'identifiant
	 */
	public Serializable getIdentifier() {
		return posCdn;
	}

	/**
	 * Retourne un clone qui pourra être exporté par XStream dans un fichier XML
	 * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
	 * dernier est rempli de "proxies" que XStream ne gère pas correctement).
	 * 
	 * @return un objet qui peut être exporté par XStream
	 */
	public Pos cloneExportedFields(IExportConfiguration exportConfiguration) {
		Pos clone = new Pos();

		clone.setPosLtNb(getPosLtNb());
		clone.setPosLgNb(getPosLgNb());

		return clone;
	}
}