/*
 * Copyright (C) 2017 Ob7, IRD
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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
    String getType();

    /**
     * Retourne la date et l'heure.
     *
     * @return la date et l'heure
     */
    Date getDatiDt();

    /**
     * Retourne la date.
     *
     * @return la date
     */
    Date getDaDt();

    /**
     * Retourne l'heure.
     *
     * @return l'heure
     */
    String getTiLb();

    /**
     * Retourne le log père.
     *
     * @return le log père
     */
    Log getLog();

    /**
     * Ajoute l'évènement à un LOG donné.
     *
     * @param log LOG auquel l'évènement sera ajouté.
     */
    void addToLog(Log log);

    /**
     * Retourne liste des RAS.
     *
     * @return liste des RAS
     */
    List<Ras> getRasList();
}
