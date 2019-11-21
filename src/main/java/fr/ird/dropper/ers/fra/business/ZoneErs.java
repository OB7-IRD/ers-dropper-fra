package fr.ird.dropper.ers.fra.business;

import fr.ird.dropper.ers.fra.business.*;
import java.io.Serializable;

/**
 * @author conor.morgan
 *
 */
public class ZoneErs implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 345612944874573826L;

    private Integer id;
    private String tZoneErsRfa;
    private String zoneErsRfa;
    private String zoneFrLb;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTZoneErsRfa() {
        return tZoneErsRfa;
    }

    public void setTZoneErsRfa(String zoneErsRfa) {
        tZoneErsRfa = zoneErsRfa;
    }

    public String getZoneErsRfa() {
        return zoneErsRfa;
    }

    public void setZoneErsRfa(String zoneErsRfa) {
        this.zoneErsRfa = zoneErsRfa;
    }

    public String getZoneFrLb() {
        return zoneFrLb;
    }

    public void setZoneFrLb(String zoneFrLb) {
        this.zoneFrLb = zoneFrLb;
    }

}
