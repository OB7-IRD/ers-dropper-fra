package fr.ird.dropper.ers.fra.business;

import fr.ird.dropper.ers.fra.business.*;
import java.util.Date;

/**
 * Table des navires concernés par l’IRD. MTTRAN09 Les navires concernés par
 * l’IRD sont stockés dans la table T_NAVIRE_IRD comportant la structure
 * suivante : NIRD_CDN : identifiant technique du navire NIRD_CFR_LB : no CFR du
 * navire NIRD_DEB_DT : date de début IRD  NIRD_FIN_DT : date de fin IRD
 *
 * @author conor.morgan
 */
public class NavireIRD {

    private Integer cdn;

    private String cfrLb;

    private Date deb;

    private Date fin;

    public Integer getCdn() {
        return cdn;
    }

    public void setCdn(Integer cdn) {
        this.cdn = cdn;
    }

    public String getCfrLb() {
        return cfrLb;
    }

    public void setCfrLb(String cfrLb) {
        this.cfrLb = cfrLb;
    }

    public Date getDeb() {
        return deb;
    }

    public void setDeb(Date deb) {
        this.deb = deb;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

}
