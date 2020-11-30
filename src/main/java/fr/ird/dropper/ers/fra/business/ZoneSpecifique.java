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
 * <p>Classe Java pour zone_specifique.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="zone_specifique"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="lingue bleue / Plateau continental écossais"/&gt;
 *     &lt;enumeration value="lingue bleue / Rosemary Bank"/&gt;
 *     &lt;enumeration value="merlu / Golfe de Gascogne"/&gt;
 *     &lt;enumeration value="espèce / zone, de type 1"/&gt;
 *     &lt;enumeration value="espèce / zone, de type 2"/&gt;
 *     &lt;enumeration value="espèce / zone, de type 3"/&gt;
 *     &lt;enumeration value="espèce / zone, de type 4"/&gt;
 *     &lt;enumeration value="espèce / zone, de type 5"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "zone_specifique")
@XmlEnum
@Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
public enum ZoneSpecifique {

    @XmlEnumValue("lingue bleue / Plateau continental \u00e9cossais")
    LINGUE_BLEUE_PLATEAU_CONTINENTAL_ÉCOSSAIS("lingue bleue / Plateau continental \u00e9cossais"),
    @XmlEnumValue("lingue bleue / Rosemary Bank")
    LINGUE_BLEUE_ROSEMARY_BANK("lingue bleue / Rosemary Bank"),
    @XmlEnumValue("merlu / Golfe de Gascogne")
    MERLU_GOLFE_DE_GASCOGNE("merlu / Golfe de Gascogne"),
    @XmlEnumValue("esp\u00e8ce / zone, de type 1")
    ESPÈCE_ZONE_DE_TYPE_1("esp\u00e8ce / zone, de type 1"),
    @XmlEnumValue("esp\u00e8ce / zone, de type 2")
    ESPÈCE_ZONE_DE_TYPE_2("esp\u00e8ce / zone, de type 2"),
    @XmlEnumValue("esp\u00e8ce / zone, de type 3")
    ESPÈCE_ZONE_DE_TYPE_3("esp\u00e8ce / zone, de type 3"),
    @XmlEnumValue("esp\u00e8ce / zone, de type 4")
    ESPÈCE_ZONE_DE_TYPE_4("esp\u00e8ce / zone, de type 4"),
    @XmlEnumValue("esp\u00e8ce / zone, de type 5")
    ESPÈCE_ZONE_DE_TYPE_5("esp\u00e8ce / zone, de type 5");
    private final String value;

    ZoneSpecifique(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ZoneSpecifique fromValue(String v) {
        for (ZoneSpecifique c: ZoneSpecifique.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
