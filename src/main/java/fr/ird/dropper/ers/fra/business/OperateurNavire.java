package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;

/**
 * Opérateur du navire.
 *
 * @author christelle.jeanberne
 */
public class OperateurNavire implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * identifier field
     */
    private Long opnCdn;

    /**
     * persistent field
     */
    private String opnCfr;

    /**
     * persistent field
     */
    private String opnVersionLb;

    /**
     * persistent field
     */
    private String operateurRfa;

    private Operateur operateur;

    /**
     * Empty constructor
     */
    public OperateurNavire() {
        super();
    }

    public Long getOpnCdn() {
        return this.opnCdn;
    }

    public void setOpnCdn(Long opnCdn) {
        this.opnCdn = opnCdn;
    }

    public String getOpnCfr() {
        return this.opnCfr;
    }

    public void setOpnCfr(String opnCfr) {
        this.opnCfr = opnCfr;
    }

    public String getOpnVersionLb() {
        return this.opnVersionLb;
    }

    public void setOpnVersionLb(String opnVersionLb) {
        this.opnVersionLb = opnVersionLb;
    }

    public String getOperateurRfa() {
        return operateurRfa;
    }

    public void setOperateurRfa(String operateurRfa) {
        this.operateurRfa = operateurRfa;
    }

    public Operateur getOperateur() {
        return this.operateur;
    }

    public void setOperateur(Operateur operateur) {
        this.operateur = operateur;
    }
}
