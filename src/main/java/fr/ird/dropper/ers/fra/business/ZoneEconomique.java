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
 * <p>Classe Java pour zone_economique.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="zone_economique"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="AGO"/&gt;
 *     &lt;enumeration value="BEL"/&gt;
 *     &lt;enumeration value="BGR"/&gt;
 *     &lt;enumeration value="CAN"/&gt;
 *     &lt;enumeration value="CPV"/&gt;
 *     &lt;enumeration value="COM"/&gt;
 *     &lt;enumeration value="CIV"/&gt;
 *     &lt;enumeration value="HRV"/&gt;
 *     &lt;enumeration value="CYP"/&gt;
 *     &lt;enumeration value="DNK"/&gt;
 *     &lt;enumeration value="EST"/&gt;
 *     &lt;enumeration value="FIN"/&gt;
 *     &lt;enumeration value="FRA"/&gt;
 *     &lt;enumeration value="GAB"/&gt;
 *     &lt;enumeration value="DEU"/&gt;
 *     &lt;enumeration value="GRC"/&gt;
 *     &lt;enumeration value="GRL"/&gt;
 *     &lt;enumeration value="GIN"/&gt;
 *     &lt;enumeration value="GNB"/&gt;
 *     &lt;enumeration value="ISL"/&gt;
 *     &lt;enumeration value="IRL"/&gt;
 *     &lt;enumeration value="ITA"/&gt;
 *     &lt;enumeration value="LVA"/&gt;
 *     &lt;enumeration value="LTU"/&gt;
 *     &lt;enumeration value="KIR"/&gt;
 *     &lt;enumeration value="MDG"/&gt;
 *     &lt;enumeration value="MLT"/&gt;
 *     &lt;enumeration value="MRT"/&gt;
 *     &lt;enumeration value="MUS"/&gt;
 *     &lt;enumeration value="FSM"/&gt;
 *     &lt;enumeration value="MAR"/&gt;
 *     &lt;enumeration value="MOZ"/&gt;
 *     &lt;enumeration value="NLD"/&gt;
 *     &lt;enumeration value="NOR"/&gt;
 *     &lt;enumeration value="POL"/&gt;
 *     &lt;enumeration value="PRT"/&gt;
 *     &lt;enumeration value="ROM"/&gt;
 *     &lt;enumeration value="STP"/&gt;
 *     &lt;enumeration value="SYC"/&gt;
 *     &lt;enumeration value="SVN"/&gt;
 *     &lt;enumeration value="ESP"/&gt;
 *     &lt;enumeration value="SWE"/&gt;
 *     &lt;enumeration value="GBR"/&gt;
 *     &lt;enumeration value="XNE"/&gt;
 *     &lt;enumeration value="XNW"/&gt;
 *     &lt;enumeration value="XCA"/&gt;
 *     &lt;enumeration value="XEU"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "zone_economique")
@XmlEnum
@Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
public enum ZoneEconomique {

    AGO,
    BEL,
    BGR,
    CAN,
    CPV,
    COM,
    CIV,
    HRV,
    CYP,
    DNK,
    EST,
    FIN,
    FRA,
    GAB,
    DEU,
    GRC,
    GRL,
    GIN,
    GNB,
    ISL,
    IRL,
    ITA,
    LVA,
    LTU,
    KIR,
    MDG,
    MLT,
    MRT,
    MUS,
    FSM,
    MAR,
    MOZ,
    NLD,
    NOR,
    POL,
    PRT,
    ROM,
    STP,
    SYC,
    SVN,
    ESP,
    SWE,
    GBR,
    XNE,
    XNW,
    XCA,
    XEU;

    public String value() {
        return name();
    }

    public static ZoneEconomique fromValue(String v) {
        return valueOf(v);
    }

}
