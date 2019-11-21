package fr.ird.dropper.ers.fra.business;

import fr.ird.dropper.ers.fra.business.*;
import java.util.Date;

/**
 * Classe des messages ERSW.
 *
 * @author conor.morgan
 */
public class MessageERSW {

    private static final long serialVersionUID = 1L;

    /**
     * identifier field
     */
    private Long mescdn;

    /**
     * persistent field
     */
    private Boolean opChanged;

    /**
     * persistent field
     */
    private Boolean transfert;

    /**
     * persistent field
     */
    private Boolean treated;

    /**
     * persistent field
     */
    private Long navcdn;

    /**
     * persistent field
     */
    private Date creation;

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public Date getModification() {
        return modification;
    }

    public void setModification(Date modification) {
        this.modification = modification;
    }

    /**
     * persistent field
     */
    private Date modification;

    public Long getNavcdn() {
        return navcdn;
    }

    public void setNavcdn(Long navcdn) {
        this.navcdn = navcdn;
    }

    public Long getMescdn() {
        return mescdn;
    }

    public void setMescdn(Long mescdn) {
        this.mescdn = mescdn;
    }

    public Boolean getOpChanged() {
        return opChanged;
    }

    public void setOpChanged(Boolean opChanged) {
        this.opChanged = opChanged;
    }

    public Boolean getTransfert() {
        return transfert;
    }

    public void setTransfert(Boolean transfert) {
        this.transfert = transfert;
    }

    public Boolean getTreated() {
        return treated;
    }

    public void setTreated(Boolean treated) {
        this.treated = treated;
    }

}
