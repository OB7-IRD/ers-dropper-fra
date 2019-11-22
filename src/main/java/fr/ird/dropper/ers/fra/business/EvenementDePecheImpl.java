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

import org.apache.commons.lang.StringUtils;

import java.util.Date;

public abstract class EvenementDePecheImpl implements EvenementDePeche {

    private static final long serialVersionUID = 1L;

    /**
     * @see fr.ird.driver.ers.business.EvenementDePeche#getDaDt()
     */
    @Override
    public abstract Date getDaDt();

    /**
     * @see fr.ird.driver.ers.business.EvenementDePeche#getDatiDt()
     */
    @Override
    public abstract Date getDatiDt();

    /**
     * @see fr.ird.driver.ers.business.EvenementDePeche#getTiLb()
     */
    @Override
    public abstract String getTiLb();

    /**
     * @see fr.ird.driver.ers.business.EvenementDePeche#getType()
     */
    @Override
    public String getType() {
        return null;
    }

    /**
     * @see fr.ird.driver.ers.business.EvenementDePeche#getLog()
     */
    @Override
    public Log getLog() {
        return null;
    }

    public int compareTo(EvenementDePeche o2) {
        if (!StringUtils.isEmpty(getTiLb()) && !StringUtils.isEmpty(o2.getTiLb())) {
            if (getDatiDt().after(o2.getDatiDt())) {
                return 1;
            } else if (getDatiDt().compareTo(o2.getDatiDt()) == 0) {
                return 0;
            } else {
                return -1;
            }
        } else {
            if (getDaDt().after(o2.getDaDt())) {
                return 1;
            } else if (getDaDt().compareTo(o2.getDaDt()) == 0) {
                return 0;
            } else {
                return -1;
            }
        }
    }
}
