package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Espèce de poisson.
 * 
 * @author christelle.jeanberne
 */
@XStreamAlias("SPE")
public class Spe implements Serializable {

	private static final long serialVersionUID = 2555914717716514057L;

	/** identifier field */
	@XStreamOmitField
	private Long speCdn;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("SN")
	private String speSnLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("WT")
	private Double speWtNb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("NF")
	private Integer speNfNb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("WL")
	private Double speWlNb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("FL")
	private Integer speFlNb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("NQ")
	private Double speNqNb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("NB")
	private Integer speNbNb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("GE")
	private String speGeLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("MM")
	private String speMmLb;

	/** persistent field */
	@XStreamAlias("SIZ")
	private Siz siz;

	/** persistent field */
	@XStreamAlias("RAS")
	private Ras ras;

	/** persistent field */
	@XStreamAlias("PRO")
	private Pro pro;

	/** persistent field */
	@XStreamAlias("ESPE")
	private Espe espe;

	/** persistent field */
	@XStreamOmitField
	private List<Tra> listTra;

	/** persistent field */
	@XStreamOmitField
	private List<Lan> listLan;

	/** persistent field */
	@XStreamOmitField
	private List<Dis> listDis;

	/** persistent field */
	@XStreamOmitField
	private List<Rlc> listRlc;

	/** persistent field */
	@XStreamOmitField
	private List<Dep> listDep;

	/** persistent field */
	@XStreamOmitField
	private List<Cox> listCox;

	/** persistent field */
	@XStreamOmitField
	private List<Cst> listCst;

	/** persistent field */
	@XStreamOmitField
	private List<Css> listCss;

	/** persistent field */
	@XStreamOmitField
	private List<Pno> listPno;

	/** persistent field */
	@XStreamOmitField
	private List<Coe> listCoe;

	/** persistent field */
	@XStreamOmitField
	private List<Far> listFar;

	/** persistent field */
	@XStreamOmitField
	private List<Cvo> listCvo;

	/** persistent field */
	@XStreamOmitField
	private List<Bti> listBti;

	/** persistent field */
	@XStreamOmitField
	private List<Trn> listTrn;

	/** persistent field */
	@XStreamOmitField
	private List<Pnt> listPnt;

	/** persistent field */
	@XStreamOmitField
	private List<Etrc> listEtrc;

	/** persistent field */
	@XStreamOmitField
	private List<Jci> listJci;

	/** persistent field */
	@XStreamOmitField
	private List<Edci> listEdci;

	/** persistent field */
	@XStreamOmitField
	private List<Cvt> listCvt;

	/**
	 * Retourne l'identifiant.
	 */
	public Long getSpeCdn() {
		return this.speCdn;
	}

	public void setSpeCdn(Long speCdn) {
		this.speCdn = speCdn;
	}

	/**
	 * Retourne le code de l'espèce.
	 */
	public String getSpeSnLb() {
		return this.speSnLb;
	}

	public void setSpeSnLb(String speSnLb) {
		this.speSnLb = speSnLb;
	}

	/**
	 * Retourne le poids en kg.
	 */
	public Double getSpeWtNb() {
		return this.speWtNb;
	}

	public void setSpeWtNb(Double speWtNb) {
		this.speWtNb = speWtNb;
	}

	/**
	 * Retourne le nombre de poissons.
	 */
	public Integer getSpeNfNb() {
		return this.speNfNb;
	}

	public void setSpeNfNb(Integer speNfNb) {
		this.speNfNb = speNfNb;
	}

	/**
	 * Retourne le poids total des poissons à débarquer ou à transborder.
	 */
	public Double getSpeWlNb() {
		return this.speWlNb;
	}

	public void setSpeWlNb(Double speWlNb) {
		this.speWlNb = speWlNb;
	}

	/**
	 * Retourne nombre total des poissons à débarquer ou à transborder.
	 */
	public Integer getSpeFlNb() {
		return this.speFlNb;
	}

	public void setSpeFlNb(Integer speFlNb) {
		this.speFlNb = speFlNb;
	}

	/**
	 * Retourne quantité de poissons dans les filets.
	 */
	public Double getSpeNqNb() {
		return this.speNqNb;
	}

	public void setSpeNqNb(Double speNqNb) {
		this.speNqNb = speNqNb;
	}

	/**
	 * Retourne nombre de poissons dans les filets.
	 */
	public Integer getSpeNbNb() {
		return this.speNbNb;
	}

	public void setSpeNbNb(Integer speNbNb) {
		this.speNbNb = speNbNb;
	}

	/**
	 * Retourne l'engin utilisé pour la capture.
	 */
	public String getSpeGeLb() {
		return this.speGeLb;
	}

	public void setSpeGeLb(String speGeLb) {
		this.speGeLb = speGeLb;
	}

	/**
	 * Retourne le moyen de mesure du poids: estimation (EST), pesage à bord (GTH).
	 */
	public String getSpeMmLb() {
		return this.speMmLb;
	}

	public void setSpeMmLb(String speMmLb) {
		this.speMmLb = speMmLb;
	}

	public Pro getPro() {
		return this.pro;
	}

	public void setPro(Pro pro) {
		this.pro = pro;
	}

	public Ras getRas() {
		return this.ras;
	}

	public void setRas(Ras ras) {
		this.ras = ras;
	}

	public Siz getSiz() {
		return this.siz;
	}

	public void setSiz(Siz siz) {
		this.siz = siz;
	}

	public Espe getEspe() {
		return this.espe;
	}

	public void setEspe(Espe espe) {
		this.espe = espe;
	}

	public List<Tra> getListTra() {
		return this.listTra;
	}

	public void setListTra(List<Tra> listTra) {
		this.listTra = listTra;
	}

	public List<Lan> getListLan() {
		return this.listLan;
	}

	public void setListLan(List<Lan> listLan) {
		this.listLan = listLan;
	}

	public List<Dis> getListDis() {
		return this.listDis;
	}

	public void setListDis(List<Dis> listDis) {
		this.listDis = listDis;
	}

	public List<Rlc> getListRlc() {
		return this.listRlc;
	}

	public void setListRlc(List<Rlc> listRlc) {
		this.listRlc = listRlc;
	}

	public List<Dep> getListDep() {
		return this.listDep;
	}

	public void setListDep(List<Dep> listDep) {
		this.listDep = listDep;
	}

	public List<Cox> getListCox() {
		return this.listCox;
	}

	public void setListCox(List<Cox> listCox) {
		this.listCox = listCox;
	}

	public List<Cst> getListCst() {
		return this.listCst;
	}

	public void setListCst(List<Cst> listCst) {
		this.listCst = listCst;
	}

	public List<Css> getListCss() {
		return this.listCss;
	}

	public void setListCss(List<Css> listCss) {
		this.listCss = listCss;
	}

	public List<Pno> getListPno() {
		return this.listPno;
	}

	public void setListPno(List<Pno> listPno) {
		this.listPno = listPno;
	}

	public List<Coe> getListCoe() {
		return this.listCoe;
	}

	public void setListCoe(List<Coe> listCoe) {
		this.listCoe = listCoe;
	}

	public List<Far> getListFar() {
		return this.listFar;
	}

	public void setListFar(List<Far> listFar) {
		this.listFar = listFar;
	}

	public List<Cvo> getListCvo() {
		return this.listCvo;
	}

	public void setListCvo(List<Cvo> listCvo) {
		this.listCvo = listCvo;
	}

	public List<Bti> getListBti() {
		return this.listBti;
	}

	public void setListBti(List<Bti> listBti) {
		this.listBti = listBti;
	}

	public List<Trn> getListTrn() {
		return this.listTrn;
	}

	public void setListTrn(List<Trn> listTrn) {
		this.listTrn = listTrn;
	}

	public List<Pnt> getListPnt() {
		return this.listPnt;
	}

	public void setListPnt(List<Pnt> listPnt) {
		this.listPnt = listPnt;
	}

	public List<Etrc> getListEtrc() {
		return this.listEtrc;
	}

	public void setListEtrc(List<Etrc> listEtrc) {
		this.listEtrc = listEtrc;
	}

	public List<Jci> getListJci() {
		return this.listJci;
	}

	public void setListJci(List<Jci> listJci) {
		this.listJci = listJci;
	}

	public List<Edci> getListEdci() {
		return this.listEdci;
	}

	public void setListEdci(List<Edci> listEdci) {
		this.listEdci = listEdci;
	}

	public List<Cvt> getListCvt() {
		return this.listCvt;
	}

	public void setListCvt(List<Cvt> listCvt) {
		this.listCvt = listCvt;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "" + getSpeCdn();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if (!(other instanceof Spe)) {
			return false;
		}
		Spe castOther = (Spe) other;
		return new EqualsBuilder().append(this.getSpeCdn(),
				castOther.getSpeCdn()).isEquals();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(getSpeCdn()).toHashCode();
	}

	/**
	 * Retourne l'identifiant.
	 * 
	 * @return l'identifiant
	 */
	public Serializable getIdentifier() {
		return speCdn;
	}

	/** 
	 * Retourne un clone qui pourra être exporté par XStream dans 
	 * un fichier XML (on ne peut pas exporter directement un objet
	 * obtenu par Hibernate car ce dernier est rempli de "proxies"
	 * que XStream ne gère pas correctement).
	 * 
	 * @return un objet qui peut être exporté par XStream
	 */
	public Spe cloneExportedFields(IExportConfiguration exportConfiguration)  {
		Spe clone = new Spe();

		clone.setSpeSnLb(getSpeSnLb());
		clone.setSpeWtNb(getSpeWtNb());
		clone.setSpeNfNb(getSpeNfNb());
		clone.setSpeWlNb(getSpeWlNb());
		clone.setSpeFlNb(getSpeFlNb());
		clone.setSpeNqNb(getSpeNqNb());
		clone.setSpeNbNb(getSpeNbNb());
		clone.setSpeGeLb(getSpeGeLb());
		clone.setSpeMmLb(getSpeMmLb());
		
		// La balise SIZ est facultative dans SPE - il faut gérer les valeurs nulles
		Siz siz = getSiz();
		if (siz != null) {
			clone.setSiz(siz.cloneExportedFields(exportConfiguration));
		} else {
			clone.setSiz(null) ;
		}
		
		clone.setRas(getRas() == null ? null : getRas().cloneExportedFields(exportConfiguration));

		// La balise PRO est facultative dans SPE - il faut gérer les valeurs nulles
		Pro pro = getPro();
		if (pro != null) {
			clone.setPro(pro.cloneExportedFields(exportConfiguration));
		} else {
			clone.setPro(null) ;
		}
		
		// La balise ESPE est facultative dans SPE - il faut gérer les valeurs nulles
		Espe espe = getEspe();
		if (exportConfiguration.isExtensionsFrancaises() && espe != null) {
			clone.setEspe(espe.cloneExportedFields(exportConfiguration));
		} else {
			clone.setEspe(null) ;
		}
		
		return clone;
	}
}