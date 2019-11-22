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
package fr.ird.dropper.ers.fra.common;


import fr.ird.dropper.ers.fra.business.*;
import org.apache.commons.lang.StringUtils;

import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author Julien Lebranchu <julien.lebranchu@ird.fr>
 */
public class DateComparator implements Comparator<Date> {

    /*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    @Override
    public int compare(Date o1, Date o2) {
        // Compare deux dates
        // Retourne 0 si les deux dates sont identiques
        // Retourne un chiffre négatif si o1 est > à o2
        // Retourne un chiffre positif si o1 est < à o2
        return o1.compareTo(o2);
    }

    /**
     * Comparateur permettant de trier des OPS par ordre croissant de date/heure
     * Attribut ODOT
     */
//    public static final Comparator<Ops> OPS_ORDER_ODOT_ASC = new Comparator<Ops>() {
//        public int compare(Ops e1, Ops e2) {
//            return e1.getOpsOdotDt().compareTo(e2.getOpsOdotDt());
//        }
//    };

    /**
     * Comparateur permettant de trier des événements de pêche par ordre
     * croissant de date/heure (ou seulement date si l'un des événements n'a pas
     * l'heure renseignée.
     */
    public static final Comparator<EvenementDePeche> ORDER_DATI_ASC = new Comparator<EvenementDePeche>() {
        public int compare(EvenementDePeche e1, EvenementDePeche e2) {
            if (!StringUtils.isEmpty(e1.getTiLb())
                    && !StringUtils.isEmpty(e2.getTiLb())) {
                return e1.getDatiDt().compareTo(e2.getDatiDt());
            } else {
                return e1.getDaDt().compareTo(e2.getDaDt());
            }
        }
    };

    /**
     * Comparateur permettant de trier des événements de pêche par ordre
     * décroissant de date/heure (ou seulement date si l'un des événements n'a
     * pas l'heure renseignée.
     */
    public static final Comparator<EvenementDePeche> ORDER_DATI_DESC = new Comparator<EvenementDePeche>() {
        public int compare(EvenementDePeche e1, EvenementDePeche e2) {
            if (!StringUtils.isEmpty(e1.getTiLb())
                    && !StringUtils.isEmpty(e2.getTiLb())) {
                return e2.getDatiDt().compareTo(e1.getDatiDt());
            } else {
                return e2.getDaDt().compareTo(e1.getDaDt());
            }
        }
    };

    /**
     * Comparateur permettant de trier des marées par ordre croissant de
     * date/heure (ou seulement date si le journal de bord n'a pas l'heure
     * renseignée.
     */
//    public static final Comparator<Ers> ORDER_ERS_DATI_ASC = new Comparator<Ers>() {
//        public int compare(Ers e1, Ers e2) {
//            if (!StringUtils.isEmpty(e1.getErsRtLb())
//                    && !StringUtils.isEmpty(e2.getErsRtLb())) {
//                return e1.getErsRdtDt().compareTo(e2.getErsRdtDt());
//            } else {
//                return e1.getErsRdDt().compareTo(e2.getErsRdDt());
//            }
//        }
//    };

    /**
     * Comparateur permettant de trier des marées par ordre décroissant de
     * date/heure (ou seulement date si le journal de bord n'a pas l'heure
     * renseignée.
     */
//    public static final Comparator<Ers> ORDER_ERS_DATI_DESC = new Comparator<Ers>() {
//        public int compare(Ers e1, Ers e2) {
//            if (!StringUtils.isEmpty(e1.getErsRtLb())
//                    && !StringUtils.isEmpty(e2.getErsRtLb())) {
//                return e2.getErsRdtDt().compareTo(e1.getErsRdtDt());
//            } else {
//                return e2.getErsRdDt().compareTo(e1.getErsRdDt());
//            }
//        }
//    };
}
