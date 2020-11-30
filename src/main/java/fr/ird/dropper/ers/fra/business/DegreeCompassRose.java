//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.11.21 à 01:58:47 PM MUT 
//


package fr.ird.dropper.ers.fra.business;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour degree_compass_rose.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="degree_compass_rose"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="N"/&gt;
 *     &lt;enumeration value="NbE"/&gt;
 *     &lt;enumeration value="NNE"/&gt;
 *     &lt;enumeration value="NEbN"/&gt;
 *     &lt;enumeration value="NE"/&gt;
 *     &lt;enumeration value="NEbE"/&gt;
 *     &lt;enumeration value="ENE"/&gt;
 *     &lt;enumeration value="EbN"/&gt;
 *     &lt;enumeration value="E"/&gt;
 *     &lt;enumeration value="EbS"/&gt;
 *     &lt;enumeration value="ESE"/&gt;
 *     &lt;enumeration value="SEbE"/&gt;
 *     &lt;enumeration value="SE"/&gt;
 *     &lt;enumeration value="SEbS"/&gt;
 *     &lt;enumeration value="SSE"/&gt;
 *     &lt;enumeration value="SbE"/&gt;
 *     &lt;enumeration value="S"/&gt;
 *     &lt;enumeration value="SbW"/&gt;
 *     &lt;enumeration value="SSW"/&gt;
 *     &lt;enumeration value="SWbS"/&gt;
 *     &lt;enumeration value="SW"/&gt;
 *     &lt;enumeration value="SWbW"/&gt;
 *     &lt;enumeration value="WSW"/&gt;
 *     &lt;enumeration value="WbS"/&gt;
 *     &lt;enumeration value="W"/&gt;
 *     &lt;enumeration value="WbN"/&gt;
 *     &lt;enumeration value="WNW"/&gt;
 *     &lt;enumeration value="NWbW"/&gt;
 *     &lt;enumeration value="NW"/&gt;
 *     &lt;enumeration value="NWbN"/&gt;
 *     &lt;enumeration value="NNW"/&gt;
 *     &lt;enumeration value="NbW"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "degree_compass_rose")
@XmlEnum
@Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
public enum DegreeCompassRose {

    N("N"),
    @XmlEnumValue("NbE")
    NB_E("NbE"),
    NNE("NNE"),
    @XmlEnumValue("NEbN")
    N_EB_N("NEbN"),
    NE("NE"),
    @XmlEnumValue("NEbE")
    N_EB_E("NEbE"),
    ENE("ENE"),
    @XmlEnumValue("EbN")
    EB_N("EbN"),
    E("E"),
    @XmlEnumValue("EbS")
    EB_S("EbS"),
    ESE("ESE"),
    @XmlEnumValue("SEbE")
    S_EB_E("SEbE"),
    SE("SE"),
    @XmlEnumValue("SEbS")
    S_EB_S("SEbS"),
    SSE("SSE"),
    @XmlEnumValue("SbE")
    SB_E("SbE"),
    S("S"),
    @XmlEnumValue("SbW")
    SB_W("SbW"),
    SSW("SSW"),
    @XmlEnumValue("SWbS")
    S_WB_S("SWbS"),
    SW("SW"),
    @XmlEnumValue("SWbW")
    S_WB_W("SWbW"),
    WSW("WSW"),
    @XmlEnumValue("WbS")
    WB_S("WbS"),
    W("W"),
    @XmlEnumValue("WbN")
    WB_N("WbN"),
    WNW("WNW"),
    @XmlEnumValue("NWbW")
    N_WB_W("NWbW"),
    NW("NW"),
    @XmlEnumValue("NWbN")
    N_WB_N("NWbN"),
    NNW("NNW"),
    @XmlEnumValue("NbW")
    NB_W("NbW");
    private final String value;

    DegreeCompassRose(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DegreeCompassRose fromValue(String v) {
        for (DegreeCompassRose c: DegreeCompassRose.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
