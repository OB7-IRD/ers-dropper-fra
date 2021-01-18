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

/**
 * GEA: gear deployment sub-declaration.
 *
 * <p>
 * Classe Java pour Gea complex type.
 *
 * <p>
 * Le fragment de schéma suivant indique le contenu attendu figurant dans cette
 * classe.
 *
 * <pre>
 * &lt;complexType name="Gea"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GES" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Ges" minOccurs="0"/&gt;
 *         &lt;element name="GER" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Ger" minOccurs="0"/&gt;
 *         &lt;element name="GIL" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Gil" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="GE" use="required" type="{http://ec.europa.eu/fisheries/schema/ers/v3}GearType" /&gt;
 *       &lt;attribute name="ME" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="GC" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="FO" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="DU" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="FD" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="NH" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="GL" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="GD" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="QG" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="TL" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeaDeclarationType", propOrder = {
    "ges",
    "ger",
    "gil"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
public class Gea {

    @XmlElement(name = "GES")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Ges ges;
    @XmlElement(name = "GER")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Ger ger;
    @XmlElement(name = "GIL")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Gil gil;
    @XmlAttribute(name = "GE", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String ge;
    @XmlAttribute(name = "ME")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Integer me;
    @XmlAttribute(name = "GC")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String gc;
    @XmlAttribute(name = "FO")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Integer fo;
    @XmlAttribute(name = "DU")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Integer du;
    @XmlAttribute(name = "FD")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Integer fd;
    @XmlAttribute(name = "NH")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Integer nh;
    @XmlAttribute(name = "GL")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Integer gl;
    @XmlAttribute(name = "GD")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Integer gd;
    @XmlAttribute(name = "QG")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Integer qg;
    @XmlAttribute(name = "TL")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Integer tl;

    /**
     * Obtient la valeur de la propriété ges.
     *
     * @return possible object is {@link Ges }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Ges getGES() {
        return ges;
    }

    /**
     * Définit la valeur de la propriété ges.
     *
     * @param value allowed object is {@link Ges }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setGES(Ges value) {
        this.ges = value;
    }

    /**
     * Obtient la valeur de la propriété ger.
     *
     * @return possible object is {@link Ger }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Ger getGER() {
        return ger;
    }

    /**
     * Définit la valeur de la propriété ger.
     *
     * @param value allowed object is {@link Ger }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setGER(Ger value) {
        this.ger = value;
    }

    /**
     * Obtient la valeur de la propriété gil.
     *
     * @return possible object is {@link Gil }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Gil getGIL() {
        return gil;
    }

    /**
     * Définit la valeur de la propriété gil.
     *
     * @param value allowed object is {@link Gil }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setGIL(Gil value) {
        this.gil = value;
    }

    /**
     * Obtient la valeur de la propriété ge.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getGE() {
        return ge;
    }

    /**
     * Définit la valeur de la propriété ge.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setGE(String value) {
        this.ge = value;
    }

    /**
     * Obtient la valeur de la propriété me.
     *
     * @return possible object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Integer getME() {
        return me;
    }

    /**
     * Définit la valeur de la propriété me.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setME(Integer value) {
        this.me = value;
    }

    /**
     * Obtient la valeur de la propriété gc.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getGC() {
        return gc;
    }

    /**
     * Définit la valeur de la propriété gc.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setGC(String value) {
        this.gc = value;
    }

    /**
     * Obtient la valeur de la propriété fo.
     *
     * @return possible object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Integer getFO() {
        return fo;
    }

    /**
     * Définit la valeur de la propriété fo.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setFO(Integer value) {
        this.fo = value;
    }

    /**
     * Obtient la valeur de la propriété du.
     *
     * @return possible object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Integer getDU() {
        return du;
    }

    /**
     * Définit la valeur de la propriété du.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setDU(Integer value) {
        this.du = value;
    }

    /**
     * Obtient la valeur de la propriété fd.
     *
     * @return possible object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Integer getFD() {
        return fd;
    }

    /**
     * Définit la valeur de la propriété fd.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setFD(Integer value) {
        this.fd = value;
    }

    /**
     * Obtient la valeur de la propriété nh.
     *
     * @return possible object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Integer getNH() {
        return nh;
    }

    /**
     * Définit la valeur de la propriété nh.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setNH(Integer value) {
        this.nh = value;
    }

    /**
     * Obtient la valeur de la propriété gl.
     *
     * @return possible object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Integer getGL() {
        return gl;
    }

    /**
     * Définit la valeur de la propriété gl.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setGL(Integer value) {
        this.gl = value;
    }

    /**
     * Obtient la valeur de la propriété gd.
     *
     * @return possible object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Integer getGD() {
        return gd;
    }

    /**
     * Définit la valeur de la propriété gd.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setGD(Integer value) {
        this.gd = value;
    }

    /**
     * Obtient la valeur de la propriété qg.
     *
     * @return possible object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Integer getQG() {
        return qg;
    }

    /**
     * Définit la valeur de la propriété qg.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setQG(Integer value) {
        this.qg = value;
    }

    /**
     * Obtient la valeur de la propriété tl.
     *
     * @return possible object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Integer getTL() {
        return tl;
    }

    /**
     * Définit la valeur de la propriété tl.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setTL(Integer value) {
        this.tl = value;
    }

}
