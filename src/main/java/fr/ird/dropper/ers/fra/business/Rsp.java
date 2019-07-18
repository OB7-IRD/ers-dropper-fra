package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import fr.ird.dropper.ers.fra.common.ErsUtils;

/**
 * Message de réponse.
 *
 * @author christelle.jeanberne
 */
@XStreamAlias("RSP")
public class Rsp implements Serializable {

    private static final long serialVersionUID = -1320884432363905184L;

    /**
     * identifier field
     */
    @XStreamOmitField
    private Long rspCdn;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("RS")
    private String rspRsLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("ON")
    private String rspOnLb;

    /**
     * nullable persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("RE")
    private String rspReLb;

    /**
     * persistent field
     */
    @XStreamAsAttribute
    @XStreamAlias("RP")
    private int rspRpBl;

    /**
     * persistent field
     */
    @XStreamOmitField
    private Ops opsByOpsCdnQue;

    /**
     * persistent field
     */
    @XStreamOmitField
    private Ops ops;

    /**
     * persistent field
     */
    @XStreamOmitField
    private String rspIrQueLb;

    /**
     * persistent field
     */
    @XStreamOmitField
    private String rspXrQueLb;

    /**
     * persistent field
     */
    @XStreamOmitField
    private String rspRcQueLb;

    /**
     * persistent field
     */
    @XStreamOmitField
    private String rspNaQueLb;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<Ers> listErs;

    /**
     * NON persistent field
     */
    @XStreamImplicit(itemFieldName = "ERS")
    private List<Ers> listErsOfXmlResponse;

    /**
     * persistent field
     */
    @XStreamOmitField
    private List<RspErsTn> listRspErsTn;

    public Long getRspCdn() {
        return this.rspCdn;
    }

    public void setRspCdn(Long rspCdn) {
        this.rspCdn = rspCdn;
    }

    public String getRspRsLb() {
        return this.rspRsLb;
    }

    public void setRspRsLb(String rspRsLb) {
        this.rspRsLb = rspRsLb;
    }

    public String getRspOnLb() {
        return this.rspOnLb;
    }

    public void setRspOnLb(String rspOnLb) {
        this.rspOnLb = rspOnLb;
    }

    public String getRspReLb() {
        return this.rspReLb;
    }

    public void setRspReLb(String rspReLb) {
        this.rspReLb = rspReLb;
    }

    public Ops getOpsByOpsCdnQue() {
        return this.opsByOpsCdnQue;
    }

    public void setOpsByOpsCdnQue(Ops opsByOpsCdnQue) {
        this.opsByOpsCdnQue = opsByOpsCdnQue;
    }

//	public void setDataFromOpsByOpsCdnQue(Ops opsByOpsCdnQue) {
//		// CRSP02: on stocke les informations navires de la question
//		setRspIrQueLb(null);
//		setRspXrQueLb(null);
//		setRspRcQueLb(null);
//		setRspNaQueLb(null);
//
//		if (opsByOpsCdnQue != null && opsByOpsCdnQue.getQue() != null) {
//			Que que = opsByOpsCdnQue.getQue();
//			String idValue = que.getQueIvLb();
//			if (!StringUtils.isEmpty(idValue)) {
//				Navire navire = ErsUtils.findNavireByQue(que);
//				if (navire != null) {
//					setRspIrQueLb(navire.getNavireCfrRfa());
//					setRspXrQueLb(navire.getNavireMarqextLb());
//					setRspRcQueLb(navire.getNavireIrcscodLb());
//					setRspNaQueLb(navire.getNavireNomLb());
//				}
//			}
//		}
//	}
    public Ops getOps() {
        return this.ops;
    }

    public void setOps(Ops ops) {
        this.ops = ops;
    }

    public List<Ers> getListErs() {
        return this.listErs;
    }

    public void setListErs(List<Ers> listErs) {
        this.listErs = listErs;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
     */
    public String toString() {
        return "" + getRspCdn();
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
        if (!(other instanceof Rsp)) {
            return false;
        }
        Rsp castOther = (Rsp) other;
        return new EqualsBuilder().append(this.getRspCdn(), castOther.getRspCdn()).isEquals();
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(getRspCdn()).toHashCode();
    }

    /**
     * Retourne l'identifiant.
     *
     * @return l'identifiant
     */
    public Serializable getIdentifier() {
        return rspCdn;
    }

    /**
     * Retourne un clone qui pourra être exporté par XStream dans un fichier XML
     * (on ne peut pas exporter directement un objet obtenu par Hibernate car ce
     * dernier est rempli de "proxies" que XStream ne gère pas correctement).
     *
     * @return un objet qui peut être exporté par XStream
     */
    public Rsp cloneExportedFields(IExportConfiguration exportConfiguration) {
        Rsp clone = new Rsp();

        clone.setRspRsLb(getRspRsLb());
        clone.setRspOnLb(getRspOnLb());
        clone.setRspReLb(getRspReLb());
        clone.setRspRpBl(getRspRpBl());

        // Clone des ERS
        if (getListErs() != null && !getListErs().isEmpty()) {
            ArrayList<Ers> cloneErss = new ArrayList<Ers>();
            for (Ers ers : getListErs()) {
                cloneErss.add(ers.cloneExportedFields(exportConfiguration));
            }
            clone.setListErs(cloneErss);
        }

        // Clone des ERS à exporter dans le XML
        if (getListErsOfXmlResponse() != null && !getListErsOfXmlResponse().isEmpty()) {
            ArrayList<Ers> cloneErss = new ArrayList<Ers>();
            for (Ers ers : getListErsOfXmlResponse()) {
                cloneErss.add(ers.cloneExportedFields(exportConfiguration));
            }
            clone.setListErsOfXmlResponse(cloneErss);
        }

        // Clone des ERS à exporter dans le XML
        if (getListErsOfXmlResponse() != null && !getListErsOfXmlResponse().isEmpty()) {
            ArrayList<Ers> cloneErss = new ArrayList<Ers>();
            for (Ers ers : getListErsOfXmlResponse()) {
                cloneErss.add(ers.cloneExportedFields(exportConfiguration));
            }
            clone.setListErsOfXmlResponse(cloneErss);
        }

        return clone;
    }

    public int getRspRpBl() {
        return rspRpBl;
    }

    public void setRspRpBl(int rspRpBl) {
        this.rspRpBl = rspRpBl;
    }

    /**
     * @return the rspIrQueLb
     */
    public String getRspIrQueLb() {
        return rspIrQueLb;
    }

    /**
     * @param rspIrQueLb the rspIrQueLb to set
     */
    public void setRspIrQueLb(String rspIrQueLb) {
        this.rspIrQueLb = rspIrQueLb;
    }

    /**
     * @return the rspXrQueLb
     */
    public String getRspXrQueLb() {
        return rspXrQueLb;
    }

    /**
     * @param rspXrQueLb the rspXrQueLb to set
     */
    public void setRspXrQueLb(String rspXrQueLb) {
        this.rspXrQueLb = rspXrQueLb;
    }

    /**
     * @return the rspRcQueLb
     */
    public String getRspRcQueLb() {
        return rspRcQueLb;
    }

    /**
     * @param rspRcQueLb the rspRcQueLb to set
     */
    public void setRspRcQueLb(String rspRcQueLb) {
        this.rspRcQueLb = rspRcQueLb;
    }

    /**
     * @return the rspNaQueLb
     */
    public String getRspNaQueLb() {
        return rspNaQueLb;
    }

    /**
     * @param rspNaQueLb the rspNaQueLb to set
     */
    public void setRspNaQueLb(String rspNaQueLb) {
        this.rspNaQueLb = rspNaQueLb;
    }

    public void setListErsOfXmlResponse(List<Ers> listErsOfXmlResponse) {
        this.listErsOfXmlResponse = listErsOfXmlResponse;
    }

    public List<Ers> getListErsOfXmlResponse() {
        return listErsOfXmlResponse;
    }

    /**
     * On va remplir les champs non présents dans le XML reçu. Cette méthode est
     * appelée automatiquement par XStream après la création de l'objet (RSP)
     *
     * @return this
     */
    private Object readResolve() {
        // Si des ers sont présents dans le XML, on les met dans l'attribut
        // listErs car c'est lui qui est persisté
        if (getListErsOfXmlResponse() != null) {
            setListErs(new ArrayList<Ers>());
            getListErs().addAll(getListErsOfXmlResponse());
        }
        return this;
    }

    public void setListRspErsTn(List<RspErsTn> listRspErsTn) {
        this.listRspErsTn = listRspErsTn;
    }

    public List<RspErsTn> getListRspErsTn() {
        return listRspErsTn;
    }

}
