//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.11.21 à 01:58:47 PM MUT 
//
package fr.ird.dropper.ers.fra.business;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Logbook declaration.
 *
 * <p>
 * Classe Java pour Log complex type.
 *
 * <p>
 * Le fragment de schéma suivant indique le contenu attendu figurant dans cette
 * classe.
 *
 * <pre>
 * &lt;complexType name="Log"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DEP" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Dep" minOccurs="0"/&gt;
 *         &lt;element name="FAR" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Far" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="RLC" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Rlc" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="TRA" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Tra" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="COE" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Coe" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="COX" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Cox" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="CRO" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Cro" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="TRZ" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Trz" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="INS" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Ins" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="DIS" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Dis" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="PNO" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Pno" minOccurs="0"/&gt;
 *         &lt;element name="PNT" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Pnt" minOccurs="0"/&gt;
 *         &lt;element name="EOF" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Eof" minOccurs="0"/&gt;
 *         &lt;element name="RTP" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Rtp" minOccurs="0"/&gt;
 *         &lt;element name="LAN" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Lan" minOccurs="0"/&gt;
 *         &lt;element name="ELOG" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://ec.europa.eu/fisheries/schema/ers/v3}Elog"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ECPS" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;extension base="{http://ec.europa.eu/fisheries/schema/ers/v3}Ecps"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="POS" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Pos" minOccurs="0"/&gt;
 *                             &lt;element name="GEA" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Gea" minOccurs="0"/&gt;
 *                             &lt;element name="EDCI" maxOccurs="unbounded"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;extension base="{http://ec.europa.eu/fisheries/schema/ers/v3}Edci"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="SPE" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Spe"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/extension&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="ETRC" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;extension base="{http://ec.europa.eu/fisheries/schema/ers/v3}Etrc"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="SPE" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Spe"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="IR" use="required" type="{http://ec.europa.eu/fisheries/schema/ers/v3}CfrType" /&gt;
 *       &lt;attribute name="RC" type="{http://ec.europa.eu/fisheries/schema/ers/v3}RadioCallSignType" /&gt;
 *       &lt;attribute name="XR" type="{http://ec.europa.eu/fisheries/schema/ers/v3}HullRegistrationType" /&gt;
 *       &lt;attribute name="NA" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="MA" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="MD" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="FS" use="required" type="{http://ec.europa.eu/fisheries/schema/ers/v3}CountryType" /&gt;
 *       &lt;attribute name="IN" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="IM" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogDeclarationType", propOrder = {
    "dep",
    "far",
    "rlc",
    "tra",
    "coe",
    "cox",
    "cro",
    "trz",
    "ins",
    "dis",
    "pno",
    "pnt",
    "eof",
    "rtp",
    "lan",
    "elog"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
public class Log {

    @XmlElement(name = "DEP")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected List<Dep> dep;
    @XmlElement(name = "FAR")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected List<Far> far;
    @XmlElement(name = "RLC")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected List<Rlc> rlc;
    @XmlElement(name = "TRA")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected List<Tra> tra;
    @XmlElement(name = "COE")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected List<Coe> coe;
    @XmlElement(name = "COX")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected List<Cox> cox;
    @XmlElement(name = "CRO")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected List<Cro> cro;
    @XmlElement(name = "TRZ")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected List<Trz> trz;
    @XmlElement(name = "INS")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected List<Ins> ins;
    @XmlElement(name = "DIS")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected List<Dis> dis;
    @XmlElement(name = "PNO")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Pno pno;
    @XmlElement(name = "PNT")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Pnt pnt;
    @XmlElement(name = "EOF")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Eof eof;
    @XmlElement(name = "RTP")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected List<Rtp> rtp;
    @XmlElement(name = "LAN")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected List<Lan> lan;
    @XmlElement(name = "ELOG")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Log.ELOG elog;
    @XmlAttribute(name = "IR", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String ir;
    @XmlAttribute(name = "RC")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String rc;
    @XmlAttribute(name = "XR")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String xr;
    @XmlAttribute(name = "NA")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String na;
    @XmlAttribute(name = "MA", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String ma;
    @XmlAttribute(name = "MD", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String md;
    @XmlAttribute(name = "FS", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String fs;
    @XmlAttribute(name = "IN")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String in;
    @XmlAttribute(name = "IM")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String im;

    /**
     * Obtient la valeur de la propriété dep.
     *
     * @return possible object is {@link Dep }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public List<Dep> getDEP() {
        if (dep == null) {
            dep = new ArrayList<Dep>();
        }
        return dep;
    }

    /**
     * Définit la valeur de la propriété dep.
     *
     * @param value allowed object is {@link Dep }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setDEP(List<Dep> value) {
        this.dep = value;
    }

    /**
     * Gets the value of the far property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the far property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFAR().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Far }
     *
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public List<Far> getFAR() {
        if (far == null) {
            far = new ArrayList<Far>();
        }
        return this.far;
    }

    /**
     * Gets the value of the rlc property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the rlc property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRLC().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Rlc }
     *
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public List<Rlc> getRLC() {
        if (rlc == null) {
            rlc = new ArrayList<Rlc>();
        }
        return this.rlc;
    }

    /**
     * Gets the value of the tra property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the tra property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTRA().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Tra }
     *
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public List<Tra> getTRA() {
        if (tra == null) {
            tra = new ArrayList<Tra>();
        }
        return this.tra;
    }

    /**
     * Gets the value of the coe property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the coe property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCOE().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Coe }
     *
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public List<Coe> getCOE() {
        if (coe == null) {
            coe = new ArrayList<Coe>();
        }
        return this.coe;
    }

    /**
     * Gets the value of the cox property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the cox property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCOX().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Cox }
     *
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public List<Cox> getCOX() {
        if (cox == null) {
            cox = new ArrayList<Cox>();
        }
        return this.cox;
    }

    /**
     * Gets the value of the cro property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the cro property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCRO().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Cro }
     *
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public List<Cro> getCRO() {
        if (cro == null) {
            cro = new ArrayList<Cro>();
        }
        return this.cro;
    }

    /**
     * Gets the value of the trz property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the trz property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTRZ().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Trz }
     *
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public List<Trz> getTRZ() {
        if (trz == null) {
            trz = new ArrayList<Trz>();
        }
        return this.trz;
    }

    /**
     * Gets the value of the ins property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the ins property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getINS().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Ins }
     *
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public List<Ins> getINS() {
        if (ins == null) {
            ins = new ArrayList<Ins>();
        }
        return this.ins;
    }

    /**
     * Gets the value of the dis property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the dis property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDIS().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Dis }
     *
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public List<Dis> getDIS() {
        if (dis == null) {
            dis = new ArrayList<Dis>();
        }
        return this.dis;
    }

    /**
     * Obtient la valeur de la propriété pno.
     *
     * @return possible object is {@link Pno }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Pno getPNO() {
        return pno;
    }

    /**
     * Définit la valeur de la propriété pno.
     *
     * @param value allowed object is {@link Pno }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setPNO(Pno value) {
        this.pno = value;
    }

    /**
     * Obtient la valeur de la propriété pnt.
     *
     * @return possible object is {@link Pnt }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Pnt getPNT() {
        return pnt;
    }

    /**
     * Définit la valeur de la propriété pnt.
     *
     * @param value allowed object is {@link Pnt }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setPNT(Pnt value) {
        this.pnt = value;
    }

    /**
     * Obtient la valeur de la propriété eof.
     *
     * @return possible object is {@link Eof }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Eof getEOF() {
        return eof;
    }

    /**
     * Définit la valeur de la propriété eof.
     *
     * @param value allowed object is {@link Eof }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setEOF(Eof value) {
        this.eof = value;
    }

    /**
     * Obtient la valeur de la propriété rtp.
     *
     * @return possible object is {@link Rtp }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public List<Rtp> getRTP() {
        if (rtp == null) {
            rtp = new ArrayList<Rtp>();
        }
        return this.rtp;
    }

    /**
     * Définit la valeur de la propriété rtp.
     *
     * @param value allowed object is {@link Rtp }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setRTP(List<Rtp> value) {
        this.rtp = value;
    }

    /**
     * Obtient la valeur de la propriété lan.
     *
     * @return possible object is {@link Lan }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public List<Lan> getLAN() {
        if (lan == null) {
            lan = new ArrayList<Lan>();
        }
        return this.lan;
    }

    /**
     * Définit la valeur de la propriété lan.
     *
     * @param value allowed object is {@link Lan }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setLAN(List<Lan> value) {
        this.lan = value;
    }

    /**
     * Obtient la valeur de la propriété elog.
     *
     * @return possible object is {@link LogDeclarationType.ELOG }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Log.ELOG getELOG() {
        return elog;
    }

    /**
     * Définit la valeur de la propriété elog.
     *
     * @param value allowed object is {@link LogDeclarationType.ELOG }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setELOG(Log.ELOG value) {
        this.elog = value;
    }

    /**
     * Obtient la valeur de la propriété ir.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getIR() {
        return ir;
    }

    /**
     * Définit la valeur de la propriété ir.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setIR(String value) {
        this.ir = value;
    }

    /**
     * Obtient la valeur de la propriété rc.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getRC() {
        return rc;
    }

    /**
     * Définit la valeur de la propriété rc.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setRC(String value) {
        this.rc = value;
    }

    /**
     * Obtient la valeur de la propriété xr.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getXR() {
        return xr;
    }

    /**
     * Définit la valeur de la propriété xr.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setXR(String value) {
        this.xr = value;
    }

    /**
     * Obtient la valeur de la propriété na.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getNA() {
        return na;
    }

    /**
     * Définit la valeur de la propriété na.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setNA(String value) {
        this.na = value;
    }

    /**
     * Obtient la valeur de la propriété ma.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getMA() {
        return ma;
    }

    /**
     * Définit la valeur de la propriété ma.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setMA(String value) {
        this.ma = value;
    }

    /**
     * Obtient la valeur de la propriété md.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getMD() {
        return md;
    }

    /**
     * Définit la valeur de la propriété md.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setMD(String value) {
        this.md = value;
    }

    /**
     * Obtient la valeur de la propriété fs.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getFS() {
        return fs;
    }

    /**
     * Définit la valeur de la propriété fs.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setFS(String value) {
        this.fs = value;
    }

    /**
     * Obtient la valeur de la propriété in.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getIN() {
        return in;
    }

    /**
     * Définit la valeur de la propriété in.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setIN(String value) {
        this.in = value;
    }

    /**
     * Obtient la valeur de la propriété im.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getIM() {
        return im;
    }

    /**
     * Définit la valeur de la propriété im.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setIM(String value) {
        this.im = value;
    }

    /**
     * <p>
     * Classe Java pour anonymous complex type.
     *
     * <p>
     * Le fragment de schéma suivant indique le contenu attendu figurant dans
     * cette classe.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{http://ec.europa.eu/fisheries/schema/ers/v3}Elog"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="ECPS" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;extension base="{http://ec.europa.eu/fisheries/schema/ers/v3}Ecps"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="POS" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Pos" minOccurs="0"/&gt;
     *                   &lt;element name="GEA" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Gea" minOccurs="0"/&gt;
     *                   &lt;element name="EDCI" maxOccurs="unbounded"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;extension base="{http://ec.europa.eu/fisheries/schema/ers/v3}Edci"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="SPE" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Spe"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/extension&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/extension&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="ETRC" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;extension base="{http://ec.europa.eu/fisheries/schema/ers/v3}Etrc"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="SPE" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Spe"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/extension&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ecps",
        "etrc"
    })
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public static class ELOG
            extends Elog {

        @XmlElement(name = "ECPS")
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        protected List<Log.ELOG.ECPS> ecps;
        @XmlElement(name = "ETRC")
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        protected List<Log.ELOG.ETRC> etrc;

        /**
         * Gets the value of the ecps property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a
         * snapshot. Therefore any modification you make to the returned list
         * will be present inside the JAXB object. This is why there is not a
         * <CODE>set</CODE> method for the ecps property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getECPS().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link LogDeclarationType.ELOG.ECPS }
         *
         *
         */
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        public List<Log.ELOG.ECPS> getECPS() {
            if (ecps == null) {
                ecps = new ArrayList<Log.ELOG.ECPS>();
            }
            return this.ecps;
        }

        /**
         * Gets the value of the etrc property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a
         * snapshot. Therefore any modification you make to the returned list
         * will be present inside the JAXB object. This is why there is not a
         * <CODE>set</CODE> method for the etrc property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getETRC().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link LogDeclarationType.ELOG.ETRC }
         *
         *
         */
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        public List<Log.ELOG.ETRC> getETRC() {
            if (etrc == null) {
                etrc = new ArrayList<Log.ELOG.ETRC>();
            }
            return this.etrc;
        }

        /**
         * <p>
         * Classe Java pour anonymous complex type.
         *
         * <p>
         * Le fragment de schéma suivant indique le contenu attendu figurant
         * dans cette classe.
         *
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;extension base="{http://ec.europa.eu/fisheries/schema/ers/v3}Ecps"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="POS" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Pos" minOccurs="0"/&gt;
         *         &lt;element name="GEA" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Gea" minOccurs="0"/&gt;
         *         &lt;element name="EDCI" maxOccurs="unbounded"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;extension base="{http://ec.europa.eu/fisheries/schema/ers/v3}Edci"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="SPE" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Spe"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/extension&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/sequence&gt;
         *     &lt;/extension&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "pos",
            "gea",
            "edci"
        })
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        public static class ECPS
                extends Ecps {

            @XmlElement(name = "POS")
            @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
            protected Pos pos;
            @XmlElement(name = "GEA")
            @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
            protected Gea gea;
            @XmlElement(name = "EDCI", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
            protected List<Log.ELOG.ECPS.EDCI> edci;

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
             * Obtient la valeur de la propriété gea.
             *
             * @return possible object is {@link Gea }
             *
             */
            @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
            public Gea getGEA() {
                return gea;
            }

            /**
             * Définit la valeur de la propriété gea.
             *
             * @param value allowed object is {@link Gea }
             *
             */
            @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
            public void setGEA(Gea value) {
                this.gea = value;
            }

            /**
             * Gets the value of the edci property.
             *
             * <p>
             * This accessor method returns a reference to the live list, not a
             * snapshot. Therefore any modification you make to the returned
             * list will be present inside the JAXB object. This is why there is
             * not a <CODE>set</CODE> method for the edci property.
             *
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getEDCI().add(newItem);
             * </pre>
             *
             *
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link LogDeclarationType.ELOG.ECPS.EDCI }
             *
             *
             */
            @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
            public List<Log.ELOG.ECPS.EDCI> getEDCI() {
                if (edci == null) {
                    edci = new ArrayList<Log.ELOG.ECPS.EDCI>();
                }
                return this.edci;
            }

            /**
             * <p>
             * Classe Java pour anonymous complex type.
             *
             * <p>
             * Le fragment de schéma suivant indique le contenu attendu figurant
             * dans cette classe.
             *
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;extension base="{http://ec.europa.eu/fisheries/schema/ers/v3}Edci"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="SPE" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Spe"/&gt;
             *       &lt;/sequence&gt;
             *     &lt;/extension&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             *
             *
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "spe"
            })
            @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
            public static class EDCI
                    extends Edci {

                @XmlElement(name = "SPE", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
                protected Spe spe;

                /**
                 * Obtient la valeur de la propriété spe.
                 *
                 * @return possible object is {@link Spe }
                 *
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
                public Spe getSPE() {
                    return spe;
                }

                /**
                 * Définit la valeur de la propriété spe.
                 *
                 * @param value allowed object is {@link Spe }
                 *
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
                public void setSPE(Spe value) {
                    this.spe = value;
                }

            }

        }

        /**
         * <p>
         * Classe Java pour anonymous complex type.
         *
         * <p>
         * Le fragment de schéma suivant indique le contenu attendu figurant
         * dans cette classe.
         *
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;extension base="{http://ec.europa.eu/fisheries/schema/ers/v3}Etrc"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="SPE" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Spe"/&gt;
         *       &lt;/sequence&gt;
         *     &lt;/extension&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "spe"
        })
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        public static class ETRC
                extends Etrc {

            @XmlElement(name = "SPE", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
            protected Spe spe;

            /**
             * Obtient la valeur de la propriété spe.
             *
             * @return possible object is {@link Spe }
             *
             */
            @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
            public Spe getSPE() {
                return spe;
            }

            /**
             * Définit la valeur de la propriété spe.
             *
             * @param value allowed object is {@link Spe }
             *
             */
            @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
            public void setSPE(Spe value) {
                this.spe = value;
            }

        }

    }

}
