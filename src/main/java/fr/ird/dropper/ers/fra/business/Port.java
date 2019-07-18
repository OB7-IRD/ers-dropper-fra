package fr.ird.dropper.ers.fra.business;

import java.util.Date;

/**
 * Classe des ports.
 *
 * @author christelle.jeanberne
 */
public class Port {

    private static final long serialVersionUID = 1L;

    /**
     * identifier field
     */
    private String portConcatCda;

    /**
     * persistent field
     */
    private String portRfa;

    /**
     * persistent field
     */
    private String portLb;

    /**
     * persistent field
     */
    private Date portDebvalDt;

    /**
     * persistent field
     */
    private Date portFinvalDt;

    /**
     * persistent field
     */
    private Date portCreationDt;

    /**
     * persistent field
     */
    private Date portModifDt;

    /**
     * nullable persistent field
     */
    private String portCommentTxt;

    /**
     * nullable persistent field
     */
    private String portConcatRfa;

    /**
     * nullable persistent field
     */
    private String portLocodeRfa;

    /**
     * nullable persistent field
     */
    private Double portLongitudeNb;

    /**
     * nullable persistent field
     */
    private Double portLatitudeNb;

    /**
     * persistent field
     */
    private Pays pays;

    /**
     * Retourne l'identifiant du port.
     *
     * @return l'identifiant
     */
    public String getPortConcatCda() {
        return this.portConcatCda;
    }

    /**
     * Affecte l'identifiant du port.
     *
     * @param portConcatCda l'identifiant
     */
    public void setPortConcatCda(String portConcatCda) {
        this.portConcatCda = portConcatCda;
    }

    /**
     * Retourne le code rfa du port.
     *
     * @return le code rfa
     */
    public String getPortRfa() {
        return this.portRfa;
    }

    /**
     * Affecte le code rfa du port.
     *
     * @param portRfa le code rfa
     */
    public void setPortRfa(String portRfa) {
        this.portRfa = portRfa;
    }

    /**
     * Retourne le nom du port.
     *
     * @return le nom
     */
    public String getPortLb() {
        return this.portLb;
    }

    /**
     * Affecte le nom du port.
     *
     * @param portLb le nom
     */
    public void setPortLb(String portLb) {
        this.portLb = portLb;
    }

    /**
     * Retourne la date de début validité du port.
     *
     * @return la date de début validité
     */
    public Date getPortDebvalDt() {
        return this.portDebvalDt;
    }

    /**
     * Affecte la date de début validité du port.
     *
     * @param portDebvalDt la date de début validité
     */
    public void setPortDebvalDt(Date portDebvalDt) {
        this.portDebvalDt = portDebvalDt;
    }

    /**
     * Retourne la date de fin validité du port.
     *
     * @return la date de fin validité
     */
    public Date getPortFinvalDt() {
        return this.portFinvalDt;
    }

    /**
     * Affecte la date de fin validité du port.
     *
     * @param portFinvalDt la date de fin validité
     */
    public void setPortFinvalDt(Date portFinvalDt) {
        this.portFinvalDt = portFinvalDt;
    }

    /**
     * Retourne la date de création du port.
     *
     * @return la date de création
     */
    public Date getPortCreationDt() {
        return this.portCreationDt;
    }

    /**
     * Affecte la date de création du port.
     *
     * @param portCreationDt la date de création
     */
    public void setPortCreationDt(Date portCreationDt) {
        this.portCreationDt = portCreationDt;
    }

    /**
     * Retourne la date de modification du port.
     *
     * @return la date de modification
     */
    public Date getPortModifDt() {
        return this.portModifDt;
    }

    /**
     * Affecte la date de modification du port.
     *
     * @param portModifDt la date de modification
     */
    public void setPortModifDt(Date portModifDt) {
        this.portModifDt = portModifDt;
    }

    /**
     * Retourne le commentaire sur le port.
     *
     * @return le commentaire
     */
    public String getPortCommentTxt() {
        return this.portCommentTxt;
    }

    /**
     * Affecte le commentaire sur le port.
     *
     * @param portCommentTxt le commentaire
     */
    public void setPortCommentTxt(String portCommentTxt) {
        this.portCommentTxt = portCommentTxt;
    }

    /**
     * Retourne la concaténation entre le rfa et le code pays ISO3.
     *
     * @return rfa+paysIso3Rfa
     */
    public String getPortConcatRfa() {
        return this.portConcatRfa;
    }

    /**
     * Affecte la concaténation entre le rfa et le code pays ISO3.
     *
     * @param portConcatRfa rfa+paysIso3Rfa
     */
    public void setPortConcatRfa(String portConcatRfa) {
        this.portConcatRfa = portConcatRfa;
    }

    /**
     * Retourne le code rfa de location du port.
     *
     * @return le code rfa de location
     */
    public String getPortLocodeRfa() {
        return this.portLocodeRfa;
    }

    /**
     * Affecte le code rfa de location du port.
     *
     * @param portLocodeRfa le code rfa de location
     */
    public void setPortLocodeRfa(String portLocodeRfa) {
        this.portLocodeRfa = portLocodeRfa;
    }

    /**
     * Retourne la longitude.
     *
     * @return la longitude
     */
    public Double getPortLongitudeNb() {
        return this.portLongitudeNb;
    }

    /**
     * Affecte la longitude.
     *
     * @param portLongitudeNb la longitude
     */
    public void setPortLongitudeNb(Double portLongitudeNb) {
        this.portLongitudeNb = portLongitudeNb;
    }

    /**
     * Retourne la latitude.
     *
     * @return la latitude
     */
    public Double getPortLatitudeNb() {
        return this.portLatitudeNb;
    }

    /**
     * Affecte la latitude.
     *
     * @param portLatitudeNb la latitude
     */
    public void setPortLatitudeNb(Double portLatitudeNb) {
        this.portLatitudeNb = portLatitudeNb;
    }

    /**
     * Retourne le pays.
     *
     * @return le pays
     */
    public Pays getPays() {
        return this.pays;
    }

    /**
     * Affecte le pays.
     *
     * @param pays
     */
    public void setPays(Pays pays) {
        this.pays = pays;
    }
}
