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
 * <p>
 * Classe Java pour seller_type.
 *
 * <p>
 * Le fragment de schéma suivant indique le contenu attendu figurant dans cette
 * classe.
 * <p>
 * <
 * pre>
 * &lt;simpleType name="seller_type"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="HAM"/&gt;
 *     &lt;enumeration value="Autre"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 *
 */
@XmlType(name = "seller_type")
@XmlEnum
@Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
public enum SellerType {

    HAM("HAM"),
    @XmlEnumValue("Autre")
    AUTRE("Autre");
    private final String value;

    SellerType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SellerType fromValue(String v) {
        for (SellerType c : SellerType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
