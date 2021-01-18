//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.11.21 à 01:58:47 PM MUT 
//
package fr.ird.dropper.ers.fra.business;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Classe Java pour ERasType complex type.
 *
 * <p>
 * Le fragment de schéma suivant indique le contenu attendu figurant dans cette
 * classe.
 *
 * <pre>
 * &lt;complexType name="Eras"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="Type" use="required" type="{http://ec.europa.eu/fisheries/schema/ers/v3}ErsNat" /&gt;
 *       &lt;attribute name="VG" type="{http://ec.europa.eu/fisheries/schema/ers/v3}valorization_geographical_code" /&gt;
 *       &lt;attribute name="ZC" type="{http://ec.europa.eu/fisheries/schema/ers/v3}zone_cgpm" /&gt;
 *       &lt;attribute name="ZU" type="{http://ec.europa.eu/fisheries/schema/ers/v3}zone_uga" /&gt;
 *       &lt;attribute name="ZG" type="{http://ec.europa.eu/fisheries/schema/ers/v3}zone_gisement" /&gt;
 *       &lt;attribute name="ZN" type="{http://ec.europa.eu/fisheries/schema/ers/v3}zone_NAFO" /&gt;
 *       &lt;attribute name="RM" type="{http://ec.europa.eu/fisheries/schema/ers/v3}rectangle_cgpm" /&gt;
 *       &lt;attribute name="ZA" type="{http://ec.europa.eu/fisheries/schema/ers/v3}zee_nat" /&gt;
 *       &lt;attribute name="ZS" type="{http://ec.europa.eu/fisheries/schema/ers/v3}zone_specifique" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ERasType")
@Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
public class Eras {

    @XmlAttribute(name = "Type", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected ErsNat type;
    @XmlAttribute(name = "VG")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected ValorizationGeographicalCode vg;
    @XmlAttribute(name = "ZC")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String zc;
    @XmlAttribute(name = "ZU")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected ZoneUga zu;
    @XmlAttribute(name = "ZG")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String zg;
    @XmlAttribute(name = "ZN")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String zn;
    @XmlAttribute(name = "RM")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String rm;
    @XmlAttribute(name = "ZA")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected ZeeNat za;
    @XmlAttribute(name = "ZS")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected ZoneSpecifique zs;

    /**
     * Obtient la valeur de la propriété type.
     *
     * @return possible object is {@link ErsNat }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public ErsNat getType() {
        return type;
    }

    /**
     * Définit la valeur de la propriété type.
     *
     * @param value allowed object is {@link ErsNat }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setType(ErsNat value) {
        this.type = value;
    }

    /**
     * Obtient la valeur de la propriété vg.
     *
     * @return possible object is {@link ValorizationGeographicalCode }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public ValorizationGeographicalCode getVG() {
        return vg;
    }

    /**
     * Définit la valeur de la propriété vg.
     *
     * @param value allowed object is {@link ValorizationGeographicalCode }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setVG(ValorizationGeographicalCode value) {
        this.vg = value;
    }

    /**
     * Obtient la valeur de la propriété zc.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getZC() {
        return zc;
    }

    /**
     * Définit la valeur de la propriété zc.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setZC(String value) {
        this.zc = value;
    }

    /**
     * Obtient la valeur de la propriété zu.
     *
     * @return possible object is {@link ZoneUga }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public ZoneUga getZU() {
        return zu;
    }

    /**
     * Définit la valeur de la propriété zu.
     *
     * @param value allowed object is {@link ZoneUga }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setZU(ZoneUga value) {
        this.zu = value;
    }

    /**
     * Obtient la valeur de la propriété zg.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getZG() {
        return zg;
    }

    /**
     * Définit la valeur de la propriété zg.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setZG(String value) {
        this.zg = value;
    }

    /**
     * Obtient la valeur de la propriété zn.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getZN() {
        return zn;
    }

    /**
     * Définit la valeur de la propriété zn.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setZN(String value) {
        this.zn = value;
    }

    /**
     * Obtient la valeur de la propriété rm.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getRM() {
        return rm;
    }

    /**
     * Définit la valeur de la propriété rm.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setRM(String value) {
        this.rm = value;
    }

    /**
     * Obtient la valeur de la propriété za.
     *
     * @return possible object is {@link ZeeNat }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public ZeeNat getZA() {
        return za;
    }

    /**
     * Définit la valeur de la propriété za.
     *
     * @param value allowed object is {@link ZeeNat }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setZA(ZeeNat value) {
        this.za = value;
    }

    /**
     * Obtient la valeur de la propriété zs.
     *
     * @return possible object is {@link ZoneSpecifique }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public ZoneSpecifique getZS() {
        return zs;
    }

    /**
     * Définit la valeur de la propriété zs.
     *
     * @param value allowed object is {@link ZoneSpecifique }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setZS(ZoneSpecifique value) {
        this.zs = value;
    }

}
