package fr.ird.dropper.ers.fra.business;

import fr.ird.dropper.ers.fra.business.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Données concernant les ERS générés lors d'un RSP émis par la France.
 *
 * @author adrian.carretero
 */
public class RspErsTn implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * identifier field
     */
    private Long rspErsTnCdn;

    /**
     * persistent field
     */
    private String elogTnLb;

    /**
     * persistent field
     */
    private String ersRnLb;

    /**
     * nullable persistent field
     */
    private Date ersRdDt;

    /**
     * persistent field
     */
    private String ersRtLb;

    /**
     * persistent field
     */
    private Rsp rsp;

    /**
     * @return the rspErsTnCdn
     */
    public Long getRspErsTnCdn() {
        return rspErsTnCdn;
    }

    /**
     * @param rspErsTnCdn the rspErsTnCdn to set
     */
    public void setRspErsTnCdn(Long rspErsTnCdn) {
        this.rspErsTnCdn = rspErsTnCdn;
    }

    /**
     * @return the elogTnLb
     */
    public String getElogTnLb() {
        return elogTnLb;
    }

    /**
     * @param elogTnLb the elogTnLb to set
     */
    public void setElogTnLb(String elogTnLb) {
        this.elogTnLb = elogTnLb;
    }

    /**
     * @return the ersRnLb
     */
    public String getErsRnLb() {
        return ersRnLb;
    }

    /**
     * @param ersRnLb the ersRnLb to set
     */
    public void setErsRnLb(String ersRnLb) {
        this.ersRnLb = ersRnLb;
    }

    /**
     * @return the ersRdDt
     */
    public Date getErsRdDt() {
        return ersRdDt;
    }

    /**
     * @param ersRdDt the ersRdDt to set
     */
    public void setErsRdDt(Date ersRdDt) {
        this.ersRdDt = ersRdDt;
    }

    /**
     * @return the ersRtLb
     */
    public String getErsRtLb() {
        return ersRtLb;
    }

    /**
     * @param ersRtLb the ersRtLb to set
     */
    public void setErsRtLb(String ersRtLb) {
        this.ersRtLb = ersRtLb;
    }

    /**
     * @return the rsp
     */
    public Rsp getRsp() {
        return rsp;
    }

    /**
     * @param rsp the rsp to set
     */
    public void setRsp(Rsp rsp) {
        this.rsp = rsp;
    }

}
