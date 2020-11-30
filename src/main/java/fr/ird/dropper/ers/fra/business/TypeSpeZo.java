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
 * Classe Java pour type_spe_zo.
 *
 * <p>
 * Le fragment de schéma suivant indique le contenu attendu figurant dans cette
 * classe.
 * <p>
 * <
 * pre>
 * &lt;simpleType name="type_spe_zo"&gt; &lt;restriction
 * base="{http://www.w3.org/2001/XMLSchema}string"&gt; &lt;enumeration
 * value="YFT01"/&gt; &lt;enumeration value="YFT02"/&gt; &lt;enumeration
 * value="YFT03"/&gt; &lt;enumeration value="YFT04"/&gt; &lt;enumeration
 * value="YFT05"/&gt; &lt;enumeration value="YFT06"/&gt; &lt;enumeration
 * value="YFT07"/&gt; &lt;enumeration value="YFT08"/&gt; &lt;enumeration
 * value="YFT09"/&gt; &lt;enumeration value="YFT10"/&gt; &lt;enumeration
 * value="YFT11"/&gt; &lt;enumeration value="YFT13"/&gt; &lt;enumeration
 * value="SKJ01"/&gt; &lt;enumeration value="SKJ02"/&gt; &lt;enumeration
 * value="SKJ03"/&gt; &lt;enumeration value="SKJ04"/&gt; &lt;enumeration
 * value="SKJ05"/&gt; &lt;enumeration value="SKJ06"/&gt; &lt;enumeration
 * value="SKJ08"/&gt; &lt;enumeration value="SKJ09"/&gt; &lt;enumeration
 * value="BET01"/&gt; &lt;enumeration value="BET02"/&gt; &lt;enumeration
 * value="BET03"/&gt; &lt;enumeration value="BET04"/&gt; &lt;enumeration
 * value="BET05"/&gt; &lt;enumeration value="BET06"/&gt; &lt;enumeration
 * value="BET07"/&gt; &lt;enumeration value="BET08"/&gt; &lt;enumeration
 * value="BET09"/&gt; &lt;enumeration value="BET10"/&gt; &lt;enumeration
 * value="BET11"/&gt; &lt;enumeration value="BET13"/&gt; &lt;enumeration
 * value="ALB01"/&gt; &lt;enumeration value="ALB03"/&gt; &lt;enumeration
 * value="ALB06"/&gt; &lt;enumeration value="ALB11"/&gt; &lt;enumeration
 * value="FRI09"/&gt; &lt;/restriction&gt; &lt;/simpleType&gt;
 * </pre>
 *
 */
@XmlType(name = "type_spe_zo")
@XmlEnum
@Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
public enum TypeSpeZo {

    /**
     * moins de 3 kg
     *
     */
    @XmlEnumValue("YFT01")
    YFT_01("YFT01"),
    /**
     * 3 à 10 kg
     *
     */
    @XmlEnumValue("YFT02")
    YFT_02("YFT02"),
    /**
     * 10 à 30 kg
     *
     */
    @XmlEnumValue("YFT03")
    YFT_03("YFT03"),
    /**
     * 6 à 20 kg
     *
     */
    @XmlEnumValue("YFT04")
    YFT_04("YFT04"),
    /**
     * 30 à 50 kg
     *
     */
    @XmlEnumValue("YFT05")
    YFT_05("YFT05"),
    /**
     * 20 à 40 kg
     *
     */
    @XmlEnumValue("YFT06")
    YFT_06("YFT06"),
    /**
     * plus de 50 kg
     *
     */
    @XmlEnumValue("YFT07")
    YFT_07("YFT07"),
    /**
     * 40 à 60 kg
     *
     */
    @XmlEnumValue("YFT08")
    YFT_08("YFT08"),
    /**
     * inconnu
     *
     */
    @XmlEnumValue("YFT09")
    YFT_09("YFT09"),
    /**
     * moins de 10 kg
     *
     */
    @XmlEnumValue("YFT10")
    YFT_10("YFT10"),
    /**
     * plus de 10 kg
     *
     */
    @XmlEnumValue("YFT11")
    YFT_11("YFT11"),
    /**
     * plus de 30 kg
     *
     */
    @XmlEnumValue("YFT13")
    YFT_13("YFT13"),
    /**
     * moins de 1.8 kg
     *
     */
    @XmlEnumValue("SKJ01")
    SKJ_01("SKJ01"),
    /**
     * plus de 1.8 kg
     *
     */
    @XmlEnumValue("SKJ02")
    SKJ_02("SKJ02"),
    /**
     * 1.8 à 4 kg
     *
     */
    @XmlEnumValue("SKJ03")
    SKJ_03("SKJ03"),
    /**
     * 1.8 à 6 kg
     *
     */
    @XmlEnumValue("SKJ04")
    SKJ_04("SKJ04"),
    /**
     * 4 à 6 kg
     *
     */
    @XmlEnumValue("SKJ05")
    SKJ_05("SKJ05"),
    /**
     * 4 à 8 kg
     *
     */
    @XmlEnumValue("SKJ06")
    SKJ_06("SKJ06"),
    /**
     * plus de 8 kg
     *
     */
    @XmlEnumValue("SKJ08")
    SKJ_08("SKJ08"),
    /**
     * inconnu
     *
     */
    @XmlEnumValue("SKJ09")
    SKJ_09("SKJ09"),
    /**
     * moins de 3 kg
     *
     */
    @XmlEnumValue("BET01")
    BET_01("BET01"),
    /**
     * 3 à 10 kg
     *
     */
    @XmlEnumValue("BET02")
    BET_02("BET02"),
    /**
     * 10 à 30 kg
     *
     */
    @XmlEnumValue("BET03")
    BET_03("BET03"),
    /**
     * 6 à 20 kg
     *
     */
    @XmlEnumValue("BET04")
    BET_04("BET04"),
    /**
     * 30 à 50 kg
     *
     */
    @XmlEnumValue("BET05")
    BET_05("BET05"),
    /**
     * 20 à 40 kg
     *
     */
    @XmlEnumValue("BET06")
    BET_06("BET06"),
    /**
     * plus de 50 kg
     *
     */
    @XmlEnumValue("BET07")
    BET_07("BET07"),
    /**
     * 40 à 60 kg
     *
     */
    @XmlEnumValue("BET08")
    BET_08("BET08"),
    /**
     * inconnu
     *
     */
    @XmlEnumValue("BET09")
    BET_09("BET09"),
    /**
     * moins de 10 kg
     *
     */
    @XmlEnumValue("BET10")
    BET_10("BET10"),
    /**
     * plus de 10 kg
     *
     */
    @XmlEnumValue("BET11")
    BET_11("BET11"),
    /**
     * plus de 30 kg
     *
     */
    @XmlEnumValue("BET13")
    BET_13("BET13"),
    /**
     * moins de 3 kg
     *
     */
    @XmlEnumValue("ALB01")
    ALB_01("ALB01"),
    /**
     * 10 à 30 kg
     *
     */
    @XmlEnumValue("ALB03")
    ALB_03("ALB03"),
    /**
     * 20 à 40 kg
     *
     */
    @XmlEnumValue("ALB06")
    ALB_06("ALB06"),
    /**
     * plus de 10 kg
     *
     */
    @XmlEnumValue("ALB11")
    ALB_11("ALB11"),
    /**
     * inconnu
     *
     */
    @XmlEnumValue("FRI09")
    FRI_09("FRI09");
    private final String value;

    TypeSpeZo(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return "TypeSpeZo{" + "value=" + value + '}';
    }

    public static TypeSpeZo fromValue(String v) {
        for (TypeSpeZo c : TypeSpeZo.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
