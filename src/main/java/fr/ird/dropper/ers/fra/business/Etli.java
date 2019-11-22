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
 * <p>Classe Java pour ETliType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="Etli"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="type" use="required" type="{http://ec.europa.eu/fisheries/schema/ers/v3}ErsNat" /&gt;
 *       &lt;attribute name="OY" type="{http://ec.europa.eu/fisheries/schema/ers/v3}code_receiver_type" /&gt;
 *       &lt;attribute name="OI" type="{http://ec.europa.eu/fisheries/schema/ers/v3}ham" /&gt;
 *       &lt;attribute name="IY" type="{http://ec.europa.eu/fisheries/schema/ers/v3}code_storage_type" /&gt;
 *       &lt;attribute name="II" type="{http://ec.europa.eu/fisheries/schema/ers/v3}id_storage" /&gt;
 *       &lt;attribute name="TI" type="{http://ec.europa.eu/fisheries/schema/ers/v3}UtcTimeType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ETliType")
@Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
public class Etli {

    @XmlAttribute(name = "type", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected ErsNat type;
    @XmlAttribute(name = "OY")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected CodeReceiverType oy;
    @XmlAttribute(name = "OI")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Ham oi;
    @XmlAttribute(name = "IY")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected CodeStorageType iy;
    @XmlAttribute(name = "II")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected IdStorage ii;
    @XmlAttribute(name = "TI")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String ti;

    /**
     * Obtient la valeur de la propriété type.
     * 
     * @return
     *     possible object is
     *     {@link ErsNat }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public ErsNat getType() {
        return type;
    }

    /**
     * Définit la valeur de la propriété type.
     * 
     * @param value
     *     allowed object is
     *     {@link ErsNat }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setType(ErsNat value) {
        this.type = value;
    }

    /**
     * Obtient la valeur de la propriété oy.
     * 
     * @return
     *     possible object is
     *     {@link CodeReceiverType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public CodeReceiverType getOY() {
        return oy;
    }

    /**
     * Définit la valeur de la propriété oy.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeReceiverType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setOY(CodeReceiverType value) {
        this.oy = value;
    }

    /**
     * Obtient la valeur de la propriété oi.
     * 
     * @return
     *     possible object is
     *     {@link Ham }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Ham getOI() {
        return oi;
    }

    /**
     * Définit la valeur de la propriété oi.
     * 
     * @param value
     *     allowed object is
     *     {@link Ham }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setOI(Ham value) {
        this.oi = value;
    }

    /**
     * Obtient la valeur de la propriété iy.
     * 
     * @return
     *     possible object is
     *     {@link CodeStorageType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public CodeStorageType getIY() {
        return iy;
    }

    /**
     * Définit la valeur de la propriété iy.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeStorageType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setIY(CodeStorageType value) {
        this.iy = value;
    }

    /**
     * Obtient la valeur de la propriété ii.
     * 
     * @return
     *     possible object is
     *     {@link IdStorage }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public IdStorage getII() {
        return ii;
    }

    /**
     * Définit la valeur de la propriété ii.
     * 
     * @param value
     *     allowed object is
     *     {@link IdStorage }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setII(IdStorage value) {
        this.ii = value;
    }

    /**
     * Obtient la valeur de la propriété ti.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getTI() {
        return ti;
    }

    /**
     * Définit la valeur de la propriété ti.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setTI(String value) {
        this.ti = value;
    }

}
