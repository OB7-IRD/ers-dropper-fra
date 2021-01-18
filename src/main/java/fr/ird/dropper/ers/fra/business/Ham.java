//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.11.21 à 01:58:47 PM MUT 
//
package fr.ird.dropper.ers.fra.business;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Classe Java pour ham.
 *
 * <p>
 * Le fragment de schéma suivant indique le contenu attendu figurant dans cette
 * classe.
 * <p>
 * <
 * pre>
 * &lt;simpleType name="ham"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="AC"/&gt;
 *     &lt;enumeration value="AD"/&gt;
 *     &lt;enumeration value="AG"/&gt;
 *     &lt;enumeration value="BL"/&gt;
 *     &lt;enumeration value="BT"/&gt;
 *     &lt;enumeration value="CA"/&gt;
 *     &lt;enumeration value="CC"/&gt;
 *     &lt;enumeration value="CH"/&gt;
 *     &lt;enumeration value="CR"/&gt;
 *     &lt;enumeration value="DK"/&gt;
 *     &lt;enumeration value="DP"/&gt;
 *     &lt;enumeration value="DZ"/&gt;
 *     &lt;enumeration value="EQ"/&gt;
 *     &lt;enumeration value="FP"/&gt;
 *     &lt;enumeration value="GA"/&gt;
 *     &lt;enumeration value="GD"/&gt;
 *     &lt;enumeration value="GL"/&gt;
 *     &lt;enumeration value="GO"/&gt;
 *     &lt;enumeration value="GR"/&gt;
 *     &lt;enumeration value="GV"/&gt;
 *     &lt;enumeration value="IO"/&gt;
 *     &lt;enumeration value="LC"/&gt;
 *     &lt;enumeration value="LG"/&gt;
 *     &lt;enumeration value="LN"/&gt;
 *     &lt;enumeration value="LO"/&gt;
 *     &lt;enumeration value="LR"/&gt;
 *     &lt;enumeration value="LS"/&gt;
 *     &lt;enumeration value="NO"/&gt;
 *     &lt;enumeration value="PB"/&gt;
 *     &lt;enumeration value="PN"/&gt;
 *     &lt;enumeration value="PO"/&gt;
 *     &lt;enumeration value="PV"/&gt;
 *     &lt;enumeration value="QB"/&gt;
 *     &lt;enumeration value="RO"/&gt;
 *     &lt;enumeration value="RY"/&gt;
 *     &lt;enumeration value="SG"/&gt;
 *     &lt;enumeration value="SJ"/&gt;
 *     &lt;enumeration value="SM"/&gt;
 *     &lt;enumeration value="SQ"/&gt;
 *     &lt;enumeration value="ST"/&gt;
 *     &lt;enumeration value="TB"/&gt;
 *     &lt;enumeration value="YE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 *
 */
@XmlType(name = "ham")
@XmlEnum
@Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
public enum Ham {

    AC,
    AD,
    AG,
    BL,
    BT,
    CA,
    CC,
    CH,
    CR,
    DK,
    DP,
    DZ,
    EQ,
    FP,
    GA,
    GD,
    GL,
    GO,
    GR,
    GV,
    IO,
    LC,
    LG,
    LN,
    LO,
    LR,
    LS,
    NO,
    PB,
    PN,
    PO,
    PV,
    QB,
    RO,
    RY,
    SG,
    SJ,
    SM,
    SQ,
    ST,
    TB,
    YE;

    public String value() {
        return name();
    }

    public static Ham fromValue(String v) {
        return valueOf(v);
    }

}
