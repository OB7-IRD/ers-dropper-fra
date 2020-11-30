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
 * <p>Classe Java pour zee_nat.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="zee_nat"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="BGV"/&gt;
 *     &lt;enumeration value="JEA"/&gt;
 *     &lt;enumeration value="JEB"/&gt;
 *     &lt;enumeration value="JEC"/&gt;
 *     &lt;enumeration value="JED"/&gt;
 *     &lt;enumeration value="JEE"/&gt;
 *     &lt;enumeration value="JEF"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "zee_nat")
@XmlEnum
@Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
public enum ZeeNat {


    /**
     * baie de Granville mer commune
     * 
     */
    BGV,

    /**
     * baie de Granville zone A
     * 
     */
    JEA,

    /**
     * baie de Granville zone B
     * 
     */
    JEB,

    /**
     * baie de Granville zone C
     * 
     */
    JEC,

    /**
     * baie de Granville zone D
     * 
     */
    JED,

    /**
     * baie de Granville zone E
     * 
     */
    JEE,

    /**
     * baie de Granville zone F
     * 
     */
    JEF;

    public String value() {
        return name();
    }

    public static ZeeNat fromValue(String v) {
        return valueOf(v);
    }

}
