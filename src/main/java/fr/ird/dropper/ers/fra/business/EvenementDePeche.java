package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public interface EvenementDePeche extends Serializable {

    /**
     * Retourne le type (nom de la balise, ex : FAR).
     *
     * @return le type
     */
    public String getType();

    /**
     * Retourne la date et l'heure.
     *
     * @return la date et l'heure
     */
    public Date getDatiDt();

    /**
     * Retourne la date.
     *
     * @return la date
     */
    public Date getDaDt();

    /**
     * Retourne l'heure.
     *
     * @return l'heure
     */
    public String getTiLb();

    /**
     * Retourne le log père.
     *
     * @return le log père
     */
    public Log getLog();

    /**
     * Ajoute l'évènement à un LOG donné.
     *
     * @param log LOG auquel l'évènement sera ajouté.
     */
    public void addToLog(Log log);

    /**
     * Retourne liste des RAS.
     *
     * @return liste des RAS
     */
    public List<Ras> getRasList();
}
