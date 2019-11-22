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
 * <p>Classe Java pour association.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="association"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="FS"/&gt;
 *     &lt;enumeration value="NL"/&gt;
 *     &lt;enumeration value="AL"/&gt;
 *     &lt;enumeration value="SV"/&gt;
 *     &lt;enumeration value="FA"/&gt;
 *     &lt;enumeration value="BD"/&gt;
 *     &lt;enumeration value="SW"/&gt;
 *     &lt;enumeration value="NW"/&gt;
 *     &lt;enumeration value="OTH"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "association")
@XmlEnum
@Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
public enum Association {

    FS,
    NL,
    AL,
    SV,
    FA,
    BD,
    SW,
    NW,
    OTH;

    public String value() {
        return name();
    }

    public static Association fromValue(String v) {
        return valueOf(v);
    }

}
