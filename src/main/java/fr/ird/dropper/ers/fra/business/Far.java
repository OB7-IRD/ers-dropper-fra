//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.11.21 à 01:58:47 PM MUT 
//
package fr.ird.dropper.ers.fra.business;

import fr.ird.common.DateTimeUtils;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Fishing Activity Report declaration. 2.0-3.0: Allowed more than one PFP
 * subdeclaration. 1.1-2.0: Merged FAR's FO and DU into the GEA subdeclaration.
 * Added PFP. Added ICCAT reporting features.
 *
 * <p>
 * Classe Java pour Far complex type.
 *
 * <p>
 * Le fragment de schéma suivant indique le contenu attendu figurant dans cette
 * classe.
 *
 * <pre>
 * &lt;complexType name="Far"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PFP" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Pfp" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="RAS" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Ras" minOccurs="0"/&gt;
 *         &lt;element name="POS" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Pos" minOccurs="0"/&gt;
 *         &lt;element name="GEA" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Gea" minOccurs="0"/&gt;
 *         &lt;element name="GLS" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Gls" minOccurs="0"/&gt;
 *         &lt;element name="SPE" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Spe" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="CVT" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Cvt" minOccurs="0"/&gt;
 *         &lt;element name="CVO" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Cvo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="JCI" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Jci" minOccurs="0"/&gt;
 *         &lt;element name="EFAR" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{http://ec.europa.eu/fisheries/schema/ers/v3}Efar"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ETTS" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Etts" minOccurs="0"/&gt;
 *                   &lt;element name="EPFA" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;extension base="{http://ec.europa.eu/fisheries/schema/ers/v3}Epfa"&gt;
 *                           &lt;sequence minOccurs="0"&gt;
 *                             &lt;element name="EFAD" maxOccurs="unbounded" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;extension base="{http://ec.europa.eu/fisheries/schema/ers/v3}Efad"&gt;
 *                                     &lt;sequence minOccurs="0"&gt;
 *                                       &lt;element name="ETDD" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Etdd" maxOccurs="unbounded" minOccurs="0"/&gt;
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
 *                 &lt;/sequence&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="LR" type="{http://ec.europa.eu/fisheries/schema/ers/v3}BooleanType" /&gt;
 *       &lt;attribute name="IS" type="{http://ec.europa.eu/fisheries/schema/ers/v3}BooleanType" /&gt;
 *       &lt;attribute name="DA" use="required" type="{http://ec.europa.eu/fisheries/schema/ers/v3}UtcDateType" /&gt;
 *       &lt;attribute name="TI" type="{http://ec.europa.eu/fisheries/schema/ers/v3}UtcTimeType" /&gt;
 *       &lt;attribute name="JF" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FarDeclarationType", propOrder = {
    "pfp",
    "ras",
    "pos",
    "gea",
    "gls",
    "spe",
    "cvt",
    "cvo",
    "jci",
    "efar"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
public class Far extends EvenementDePecheImpl {

    @XmlElement(name = "PFP")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected List<Pfp> pfp;
    @XmlElement(name = "RAS")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Ras ras;
    @XmlElement(name = "POS")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Pos pos;
    @XmlElement(name = "GEA")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Gea gea;
    @XmlElement(name = "GLS")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Gls gls;
    @XmlElement(name = "SPE")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected List<Spe> spe;
    @XmlElement(name = "CVT")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Cvt cvt;
    @XmlElement(name = "CVO")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected List<Cvo> cvo;
    @XmlElement(name = "JCI")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Jci jci;
    @XmlElement(name = "EFAR")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Far.EFAR efar;
    @XmlAttribute(name = "LR")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Integer lr;
    @XmlAttribute(name = "IS")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Integer is;
    @XmlAttribute(name = "DA", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected XMLGregorianCalendar da;
    @XmlAttribute(name = "TI")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String ti;
    @XmlAttribute(name = "JF")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String jf;

    @Override
    public String toString() {
        return "Far{" + "pfp=" + pfp + ", ras=" + ras + ", pos=" + pos + ", gea=" + gea + ", gls=" + gls + ", spe=" + spe + ", cvt=" + cvt + ", cvo=" + cvo + ", jci=" + jci + ", efar=" + efar + ", lr=" + lr + ", is=" + is + ", da=" + da + ", ti=" + ti + ", jf=" + jf + '}';
    }

    /**
     * Gets the value of the pfp property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the pfp property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPFP().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Pfp }
     *
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public List<Pfp> getPFP() {
        if (pfp == null) {
            pfp = new ArrayList<Pfp>();
        }
        return this.pfp;
    }

    /**
     * Obtient la valeur de la propriété ras.
     *
     * @return possible object is {@link Ras }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Ras getRAS() {
        return ras;
    }

    /**
     * Définit la valeur de la propriété ras.
     *
     * @param value allowed object is {@link Ras }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setRAS(Ras value) {
        this.ras = value;
    }

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
     * Obtient la valeur de la propriété gls.
     *
     * @return possible object is {@link Gls }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Gls getGLS() {
        return gls;
    }

    /**
     * Définit la valeur de la propriété gls.
     *
     * @param value allowed object is {@link Gls }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setGLS(Gls value) {
        this.gls = value;
    }

    /**
     * Gets the value of the spe property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the spe property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSPE().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Spe }
     *
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public List<Spe> getSPE() {
        if (spe == null) {
            spe = new ArrayList<Spe>();
        }
        return this.spe;
    }

    /**
     * Obtient la valeur de la propriété cvt.
     *
     * @return possible object is {@link Cvt }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Cvt getCVT() {
        return cvt;
    }

    /**
     * Définit la valeur de la propriété cvt.
     *
     * @param value allowed object is {@link Cvt }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setCVT(Cvt value) {
        this.cvt = value;
    }

    /**
     * Gets the value of the cvo property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the cvo property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCVO().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Cvo }
     *
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public List<Cvo> getCVO() {
        if (cvo == null) {
            cvo = new ArrayList<Cvo>();
        }
        return this.cvo;
    }

    /**
     * Obtient la valeur de la propriété jci.
     *
     * @return possible object is {@link Jci }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Jci getJCI() {
        return jci;
    }

    /**
     * Définit la valeur de la propriété jci.
     *
     * @param value allowed object is {@link Jci }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setJCI(Jci value) {
        this.jci = value;
    }

    /**
     * Obtient la valeur de la propriété efar.
     *
     * @return possible object is {@link FarDeclarationType.EFAR }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Far.EFAR getEFAR() {
        return efar;
    }

    /**
     * Définit la valeur de la propriété efar.
     *
     * @param value allowed object is {@link FarDeclarationType.EFAR }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setEFAR(Far.EFAR value) {
        this.efar = value;
    }

    /**
     * Obtient la valeur de la propriété lr.
     *
     * @return possible object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Integer getLR() {
        return lr;
    }

    /**
     * Définit la valeur de la propriété lr.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setLR(Integer value) {
        this.lr = value;
    }

    /**
     * Obtient la valeur de la propriété is.
     *
     * @return possible object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Integer getIS() {
        return is;
    }

    /**
     * Définit la valeur de la propriété is.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setIS(Integer value) {
        this.is = value;
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
     * Obtient la valeur de la propriété jf.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getJF() {
        return jf;
    }

    /**
     * Définit la valeur de la propriété jf.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setJF(String value) {
        this.jf = value;
    }

    @Override
    public void addToLog(Log log) {
        log.getFAR().add(this);
    }

    @Override
    public List<Ras> getRasList() {
        List<Ras> listRas = new ArrayList<Ras>();
        if (getRAS() != null) {
            listRas.add(getRAS());
        }
        if (getSPE() == null) {
            return listRas;
        }
        for (Spe spe : getSPE()) {
            listRas.add(spe.getRAS());
        }
        return listRas;
    }

    @Override
    public Date getDaDt() {
        return da.toGregorianCalendar().getTime();
    }

    @Override
    public Date getDatiDt() {
        return DateTimeUtils.createDateTime(getDaDt(), getTiLb()).toDate();
    }

    @Override
    public String getTiLb() {
        return ti;
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
     *     &lt;extension base="{http://ec.europa.eu/fisheries/schema/ers/v3}Efar"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="ETTS" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Etts" minOccurs="0"/&gt;
     *         &lt;element name="EPFA" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;extension base="{http://ec.europa.eu/fisheries/schema/ers/v3}Epfa"&gt;
     *                 &lt;sequence minOccurs="0"&gt;
     *                   &lt;element name="EFAD" maxOccurs="unbounded" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;extension base="{http://ec.europa.eu/fisheries/schema/ers/v3}Efad"&gt;
     *                           &lt;sequence minOccurs="0"&gt;
     *                             &lt;element name="ETDD" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Etdd" maxOccurs="unbounded" minOccurs="0"/&gt;
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
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "etts",
        "epfa"
    })
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public static class EFAR
            extends Efar {

        @XmlElement(name = "ETTS")
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        protected Etts etts;
        @XmlElement(name = "EPFA")
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        protected Far.EFAR.EPFA epfa;

        /**
         * Obtient la valeur de la propriété etts.
         *
         * @return possible object is {@link Etts }
         *
         */
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        public Etts getETTS() {
            return etts;
        }

        /**
         * Définit la valeur de la propriété etts.
         *
         * @param value allowed object is {@link Etts }
         *
         */
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        public void setETTS(Etts value) {
            this.etts = value;
        }

        /**
         * Obtient la valeur de la propriété epfa.
         *
         * @return possible object is {@link FarDeclarationType.EFAR.EPFA }
         *
         */
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        public Far.EFAR.EPFA getEPFA() {
            return epfa;
        }

        /**
         * Définit la valeur de la propriété epfa.
         *
         * @param value allowed object is {@link FarDeclarationType.EFAR.EPFA }
         *
         */
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        public void setEPFA(Far.EFAR.EPFA value) {
            this.epfa = value;
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
         *     &lt;extension base="{http://ec.europa.eu/fisheries/schema/ers/v3}Epfa"&gt;
         *       &lt;sequence minOccurs="0"&gt;
         *         &lt;element name="EFAD" maxOccurs="unbounded" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;extension base="{http://ec.europa.eu/fisheries/schema/ers/v3}Efad"&gt;
         *                 &lt;sequence minOccurs="0"&gt;
         *                   &lt;element name="ETDD" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Etdd" maxOccurs="unbounded" minOccurs="0"/&gt;
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
            "efad"
        })
        @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
        public static class EPFA
                extends Epfa {

            @XmlElement(name = "EFAD")
            @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
            protected List<Far.EFAR.EPFA.EFAD> efad;

            /**
             * Gets the value of the efad property.
             *
             * <p>
             * This accessor method returns a reference to the live list, not a
             * snapshot. Therefore any modification you make to the returned
             * list will be present inside the JAXB object. This is why there is
             * not a <CODE>set</CODE> method for the efad property.
             *
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getEFAD().add(newItem);
             * </pre>
             *
             *
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link FarDeclarationType.EFAR.EPFA.EFAD }
             *
             *
             */
            @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
            public List<Far.EFAR.EPFA.EFAD> getEFAD() {
                if (efad == null) {
                    efad = new ArrayList<Far.EFAR.EPFA.EFAD>();
                }
                return this.efad;
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
             *     &lt;extension base="{http://ec.europa.eu/fisheries/schema/ers/v3}Efad"&gt;
             *       &lt;sequence minOccurs="0"&gt;
             *         &lt;element name="ETDD" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Etdd" maxOccurs="unbounded" minOccurs="0"/&gt;
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
                "etdd"
            })
            @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
            public static class EFAD
                    extends Efad {

                @XmlElement(name = "ETDD")
                @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
                protected List<Etdd> etdd;

                /**
                 * Gets the value of the etdd property.
                 *
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object. This is
                 * why there is not a <CODE>set</CODE> method for the etdd
                 * property.
                 *
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getETDD().add(newItem);
                 * </pre>
                 *
                 *
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link Etdd }
                 *
                 *
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
                public List<Etdd> getETDD() {
                    if (etdd == null) {
                        etdd = new ArrayList<Etdd>();
                    }
                    return this.etdd;
                }

            }

        }

    }

}
