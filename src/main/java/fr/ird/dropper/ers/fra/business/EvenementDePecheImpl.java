package fr.ird.dropper.ers.fra.business;

import fr.ird.dropper.ers.fra.business.*;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

public abstract class EvenementDePecheImpl implements EvenementDePeche {

    private static final long serialVersionUID = 1L;

    /* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDaDt()
     */
    public Date getDaDt() {
        return null;
    }

    /* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDatiDt()
     */
    public Date getDatiDt() {
        return null;
    }

    /* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getTiLb()
     */
    public String getTiLb() {
        return null;
    }

    /* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getType()
     */
    public String getType() {
        return null;
    }

    /* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getLog()
     */
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
