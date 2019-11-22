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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Classe Java pour anonymous complex type.
 *
 * <p>
 * Le fragment de schéma suivant indique le contenu attendu figurant dans cette
 * classe.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="DAT" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Dat"/&gt;
 *         &lt;element name="RET" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Ret"/&gt;
 *         &lt;element name="DEL" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Del"/&gt;
 *         &lt;element name="COR" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Cor"/&gt;
 *         &lt;element name="QUE" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Que"/&gt;
 *         &lt;element name="RSP" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Rsp"/&gt;
 *         &lt;element name="EMAV"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;attribute name="Type" use="required" type="{http://ec.europa.eu/fisheries/schema/ers/v3}ErsNat" /&gt;
 *                 &lt;attribute name="IR" use="required"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                       &lt;length value="12"/&gt;
 *                     &lt;/restriction&gt;
 *                   &lt;/simpleType&gt;
 *                 &lt;/attribute&gt;
 *                 &lt;attribute name="RS" use="required" type="{http://ec.europa.eu/fisheries/schema/ers/v3}message_type" /&gt;
 *                 &lt;attribute name="ON"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                       &lt;length value="17"/&gt;
 *                     &lt;/restriction&gt;
 *                   &lt;/simpleType&gt;
 *                 &lt;/attribute&gt;
 *                 &lt;attribute name="MC" use="required"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                       &lt;maxLength value="300"/&gt;
 *                     &lt;/restriction&gt;
 *                   &lt;/simpleType&gt;
 *                 &lt;/attribute&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="EVZO"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;attribute name="Type" use="required" type="{http://ec.europa.eu/fisheries/schema/ers/v3}ErsNat" /&gt;
 *                 &lt;attribute name="IR" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="DA" type="{http://www.w3.org/2001/XMLSchema}date" /&gt;
 *                 &lt;attribute name="TI" type="{http://www.w3.org/2001/XMLSchema}time" /&gt;
 *                 &lt;attribute name="EZ" type="{http://ec.europa.eu/fisheries/schema/ers/v3}zone_economique" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute name="AD" use="required" type="{http://ec.europa.eu/fisheries/schema/ers/v3}CountryType" /&gt;
 *       &lt;attribute name="FR" use="required" type="{http://ec.europa.eu/fisheries/schema/ers/v3}CountryType" /&gt;
 *       &lt;attribute name="ON" use="required" type="{http://ec.europa.eu/fisheries/schema/ers/v3}RecordNumberType" /&gt;
 *       &lt;attribute name="OD" use="required" type="{http://ec.europa.eu/fisheries/schema/ers/v3}UtcDateType" /&gt;
 *       &lt;attribute name="OT" use="required" type="{http://ec.europa.eu/fisheries/schema/ers/v3}UtcTimeType" /&gt;
 *       &lt;attribute name="TS" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="EAV"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;maxLength value="300"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="EVL"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;maxLength value="300"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dat",
    "ret",
    "del",
    "cor",
    "que",
    "rsp",
    "emav",
    "evzo"
})
@XmlRootElement(name = "OPS")
@Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
public class Ops {

    @XmlElement(name = "DAT")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Dat dat;
    @XmlElement(name = "RET")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Ret ret;
    @XmlElement(name = "DEL")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Del del;
    @XmlElement(name = "COR")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Cor cor;
    @XmlElement(name = "QUE")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Que que;
    @XmlElement(name = "RSP")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Rsp rsp;
    @XmlElement(name = "EMAV")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Ops.EMAV emav;
    @XmlElement(name = "EVZO")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Ops.EVZO evzo;
    @XmlAttribute(name = "AD", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String ad;
    @XmlAttribute(name = "FR", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String fr;
    @XmlAttribute(name = "ON", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String on;
    @XmlAttribute(name = "OD", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected XMLGregorianCalendar od;
    @XmlAttribute(name = "OT", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String ot;
    @XmlAttribute(name = "TS")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String ts;
    @XmlAttribute(name = "EAV")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String eav;
    @XmlAttribute(name = "EVL")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String evl;

    @Override
    public String toString() {
        return "Ops{" + "dat=" + dat + ", ret=" + ret + ", del=" + del + ", cor=" + cor + ", que=" + que + ", rsp=" + rsp + ", emav=" + emav + ", evzo=" + evzo + ", ad=" + ad + ", fr=" + fr + ", on=" + on + ", od=" + od + ", ot=" + ot + ", ts=" + ts + ", eav=" + eav + ", evl=" + evl + '}';
    }

    /**
     * Obtient la valeur de la propriété dat.
     *
     * @return possible object is {@link Dat }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Dat getDAT() {
        return dat;
    }

    /**
     * Définit la valeur de la propriété dat.
     *
     * @param value allowed object is {@link Dat }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setDAT(Dat value) {
        this.dat = value;
    }

    /**
     * Obtient la valeur de la propriété ret.
     *
     * @return possible object is {@link Ret }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Ret getRET() {
        return ret;
    }

    /**
     * Définit la valeur de la propriété ret.
     *
     * @param value allowed object is {@link Ret }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setRET(Ret value) {
        this.ret = value;
    }

    /**
     * Obtient la valeur de la propriété del.
     *
     * @return possible object is {@link Del }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Del getDEL() {
        return del;
    }

    /**
     * Définit la valeur de la propriété del.
     *
     * @param value allowed object is {@link Del }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setDEL(Del value) {
        this.del = value;
    }

    /**
     * Obtient la valeur de la propriété cor.
     *
     * @return possible object is {@link Cor }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Cor getCOR() {
        return cor;
    }

    /**
     * Définit la valeur de la propriété cor.
     *
     * @param value allowed object is {@link Cor }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setCOR(Cor value) {
        this.cor = value;
    }

    /**
     * Obtient la valeur de la propriété que.
     *
     * @return possible object is {@link Que }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Que getQUE() {
        return que;
    }

    /**
     * Définit la valeur de la propriété que.
     *
     * @param value allowed object is {@link Que }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setQUE(Que value) {
        this.que = value;
    }

    /**
     * Obtient la valeur de la propriété rsp.
     *
     * @return possible object is {@link Rsp }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Rsp getRSP() {
        return rsp;
    }

    /**
     * Définit la valeur de la propriété rsp.
     *
     * @param value allowed object is {@link Rsp }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setRSP(Rsp value) {
        this.rsp = value;
    }

    /**
     * Obtient la valeur de la propriété emav.
     *
     * @return possible object is {@link OPS.EMAV }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Ops.EMAV getEMAV() {
        return emav;
    }

    /**
     * Définit la valeur de la propriété emav.
     *
     * @param value allowed object is {@link OPS.EMAV }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setEMAV(Ops.EMAV value) {
        this.emav = value;
    }

    /**
     * Obtient la valeur de la propriété evzo.
     *
     * @return possible object is {@link OPS.EVZO }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Ops.EVZO getEVZO() {
        return evzo;
    }

    /**
     * Définit la valeur de la propriété evzo.
     *
     * @param value allowed object is {@link OPS.EVZO }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setEVZO(Ops.EVZO value) {
        this.evzo = value;
    }

    /**
     * Obtient la valeur de la propriété ad.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getAD() {
        return ad;
    }

    /**
     * Définit la valeur de la propriété ad.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setAD(String value) {
        this.ad = value;
    }

    /**
     * Obtient la valeur de la propriété fr.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getFR() {
        return fr;
    }

    /**
     * Définit la valeur de la propriété fr.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setFR(String value) {
        this.fr = value;
    }

    /**
     * Obtient la valeur de la propriété on.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getON() {
        return on;
    }

    /**
     * Définit la valeur de la propriété on.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setON(String value) {
        this.on = value;
    }

    /**
     * Obtient la valeur de la propriété od.
     *
     * @return possible object is {@link XMLGregorianCalendar }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public XMLGregorianCalendar getOD() {
        return od;
    }

    /**
     * Définit la valeur de la propriété od.
     *
     * @param value allowed object is {@link XMLGregorianCalendar }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setOD(XMLGregorianCalendar value) {
        this.od = value;
    }

    /**
     * Obtient la valeur de la propriété ot.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getOT() {
        return ot;
    }

    /**
     * Définit la valeur de la propriété ot.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setOT(String value) {
        this.ot = value;
    }

    /**
     * Obtient la valeur de la propriété ts.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getTS() {
        return ts;
    }

    /**
     * Définit la valeur de la propriété ts.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setTS(String value) {
        this.ts = value;
    }

    /**
     * Obtient la valeur de la propriété eav.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getEAV() {
        return eav;
    }

    /**
     * Définit la valeur de la propriété eav.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setEAV(String value) {
        this.eav = value;
    }

    /**
     * Obtient la valeur de la propriété evl.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getEVL() {
        return evl;
    }

    /**
     * Définit la valeur de la propriété evl.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setEVL(String value) {
        this.evl = value;
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
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;attribute name="Type" use="required" type="{http://ec.europa.eu/fisheries/schema/ers/v3}ErsNat" /&gt;
     *       &lt;attribute name="IR" use="required"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *             &lt;length value="12"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
     *       &lt;attribute name="RS" use="required" type="{http://ec.europa.eu/fisheries/schema/ers/v3}message_type" /&gt;
     *       &lt;attribute name="ON"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *             &lt;length value="17"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
     *       &lt;attribute name="MC" use="required"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *             &lt;maxLength value="300"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public static class EMAV {

        @XmlAttribute(name = "Type", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        protected ErsNat type;
        @XmlAttribute(name = "IR", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        protected String ir;
        @XmlAttribute(name = "RS", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        protected MessageType rs;
        @XmlAttribute(name = "ON")
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        protected String on;
        @XmlAttribute(name = "MC", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        protected String mc;

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
         * Obtient la valeur de la propriété rs.
         *
         * @return possible object is {@link MessageType }
         *
         */
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        public MessageType getRS() {
            return rs;
        }

        /**
         * Définit la valeur de la propriété rs.
         *
         * @param value allowed object is {@link MessageType }
         *
         */
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        public void setRS(MessageType value) {
            this.rs = value;
        }

        /**
         * Obtient la valeur de la propriété on.
         *
         * @return possible object is {@link String }
         *
         */
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        public String getON() {
            return on;
        }

        /**
         * Définit la valeur de la propriété on.
         *
         * @param value allowed object is {@link String }
         *
         */
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        public void setON(String value) {
            this.on = value;
        }

        /**
         * Obtient la valeur de la propriété mc.
         *
         * @return possible object is {@link String }
         *
         */
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        public String getMC() {
            return mc;
        }

        /**
         * Définit la valeur de la propriété mc.
         *
         * @param value allowed object is {@link String }
         *
         */
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        public void setMC(String value) {
            this.mc = value;
        }

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
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;attribute name="Type" use="required" type="{http://ec.europa.eu/fisheries/schema/ers/v3}ErsNat" /&gt;
     *       &lt;attribute name="IR" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="DA" type="{http://www.w3.org/2001/XMLSchema}date" /&gt;
     *       &lt;attribute name="TI" type="{http://www.w3.org/2001/XMLSchema}time" /&gt;
     *       &lt;attribute name="EZ" type="{http://ec.europa.eu/fisheries/schema/ers/v3}zone_economique" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public static class EVZO {

        @XmlAttribute(name = "Type", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        protected ErsNat type;
        @XmlAttribute(name = "IR")
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        protected String ir;
        @XmlAttribute(name = "DA")
        @XmlSchemaType(name = "date")
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        protected XMLGregorianCalendar da;
        @XmlAttribute(name = "TI")
        @XmlSchemaType(name = "time")
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        protected XMLGregorianCalendar ti;
        @XmlAttribute(name = "EZ")
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        protected ZoneEconomique ez;

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
         * @return possible object is {@link XMLGregorianCalendar }
         *
         */
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        public XMLGregorianCalendar getTI() {
            return ti;
        }

        /**
         * Définit la valeur de la propriété ti.
         *
         * @param value allowed object is {@link XMLGregorianCalendar }
         *
         */
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        public void setTI(XMLGregorianCalendar value) {
            this.ti = value;
        }

        /**
         * Obtient la valeur de la propriété ez.
         *
         * @return possible object is {@link ZoneEconomique }
         *
         */
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        public ZoneEconomique getEZ() {
            return ez;
        }

        /**
         * Définit la valeur de la propriété ez.
         *
         * @param value allowed object is {@link ZoneEconomique }
         *
         */
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        public void setEZ(ZoneEconomique value) {
            this.ez = value;
        }

    }

}
