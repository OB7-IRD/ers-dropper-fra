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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Inspection declaration, to be provided by the authorities, not the master.
 * Not the same as 1224/2009 Art 76.
 *
 * <p>
 * Classe Java pour Ins complex type.
 *
 * <p>
 * Le fragment de schéma suivant indique le contenu attendu figurant dans cette
 * classe.
 *
 * <pre>
 * &lt;complexType name="Ins"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element name="POS" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Pos"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="IC" use="required" type="{http://ec.europa.eu/fisheries/schema/ers/v3}CountryType" /&gt;
 *       &lt;attribute name="IA" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="SC" type="{http://ec.europa.eu/fisheries/schema/ers/v3}CountryType" /&gt;
 *       &lt;attribute name="DA" use="required" type="{http://ec.europa.eu/fisheries/schema/ers/v3}UtcDateType" /&gt;
 *       &lt;attribute name="TI" use="required" type="{http://ec.europa.eu/fisheries/schema/ers/v3}UtcTimeType" /&gt;
 *       &lt;attribute name="PO" type="{http://ec.europa.eu/fisheries/schema/ers/v3}PortType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsDeclarationType", propOrder = {
    "pos"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
public class Ins {

    @XmlElement(name = "POS")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Pos pos;
    @XmlAttribute(name = "IC", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String ic;
    @XmlAttribute(name = "IA")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String ia;
    @XmlAttribute(name = "SC")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String sc;
    @XmlAttribute(name = "DA", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected XMLGregorianCalendar da;
    @XmlAttribute(name = "TI", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String ti;
    @XmlAttribute(name = "PO")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String po;

    /**
     * Obtient la valeur de la propriété pos.
     *
     * @return possible object is {@link Pos }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Pos getPOS() {
        return pos;
    }

    /**
     * Définit la valeur de la propriété pos.
     *
     * @param value allowed object is {@link Pos }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setPOS(Pos value) {
        this.pos = value;
    }

    /**
     * Obtient la valeur de la propriété ic.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getIC() {
        return ic;
    }

    /**
     * Définit la valeur de la propriété ic.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setIC(String value) {
        this.ic = value;
    }

    /**
     * Obtient la valeur de la propriété ia.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getIA() {
        return ia;
    }

    /**
     * Définit la valeur de la propriété ia.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setIA(String value) {
        this.ia = value;
    }

    /**
     * Obtient la valeur de la propriété sc.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getSC() {
        return sc;
    }

    /**
     * Définit la valeur de la propriété sc.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setSC(String value) {
        this.sc = value;
    }

    /**
     * Obtient la valeur de la propriété da.
     *
     * @return possible object is {@link XMLGregorianCalendar }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public XMLGregorianCalendar getDA() {
        return da;
    }

    /**
     * Définit la valeur de la propriété da.
     *
     * @param value allowed object is {@link XMLGregorianCalendar }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setDA(XMLGregorianCalendar value) {
        this.da = value;
    }

    /**
     * Obtient la valeur de la propriété ti.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getTI() {
        return ti;
    }

    /**
     * Définit la valeur de la propriété ti.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setTI(String value) {
        this.ti = value;
    }

    /**
     * Obtient la valeur de la propriété po.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getPO() {
        return po;
    }

    /**
     * Définit la valeur de la propriété po.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setPO(String value) {
        this.po = value;
    }

}
