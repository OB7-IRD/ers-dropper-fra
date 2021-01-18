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
 * Species sub-declaration.
 *
 * <p>
 * Classe Java pour Spe complex type.
 *
 * <p>
 * Le fragment de schéma suivant indique le contenu attendu figurant dans cette
 * classe.
 *
 * <pre>
 * &lt;complexType name="Spe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SIZ" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Siz" minOccurs="0"/&gt;
 *         &lt;element name="RAS" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Ras"/&gt;
 *         &lt;element name="PRO" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Pro" minOccurs="0"/&gt;
 *         &lt;element name="ESPE" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Espe" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="SN" use="required" type="{http://ec.europa.eu/fisheries/schema/ers/v3}SpeciesType" /&gt;
 *       &lt;attribute name="WT" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *       &lt;attribute name="NF" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="WL" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *       &lt;attribute name="FL" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="NQ" type="{http://www.w3.org/2001/XMLSchema}decimal" /&gt;
 *       &lt;attribute name="NB" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="GE" type="{http://ec.europa.eu/fisheries/schema/ers/v3}GearType" /&gt;
 *       &lt;attribute name="MM" type="{http://ec.europa.eu/fisheries/schema/ers/v3}MeansOfWeightMeasureType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpeDeclarationType", propOrder = {
    "siz",
    "ras",
    "pro",
    "espe"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
public class Spe {

    @XmlElement(name = "SIZ")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Siz siz;
    @XmlElement(name = "RAS", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Ras ras;
    @XmlElement(name = "PRO")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Pro pro;
    @XmlElement(name = "ESPE")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Espe espe;
    @XmlAttribute(name = "SN", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String sn;
    @XmlAttribute(name = "WT")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Double wt;
    @XmlAttribute(name = "NF")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Integer nf;
    @XmlAttribute(name = "WL")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Double wl;
    @XmlAttribute(name = "FL")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Integer fl;
    @XmlAttribute(name = "NQ")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Double nq;
    @XmlAttribute(name = "NB")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Integer nb;
    @XmlAttribute(name = "GE")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String ge;
    @XmlAttribute(name = "MM")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String mm;

    @Override
    public String toString() {
        return "Spe{" + "siz=" + siz + ", ras=" + ras + ", pro=" + pro + ", espe=" + espe + ", sn=" + sn + ", wt=" + wt + ", nf=" + nf + ", wl=" + wl + ", fl=" + fl + ", nq=" + nq + ", nb=" + nb + ", ge=" + ge + ", mm=" + mm + '}';
    }

    /**
     * Obtient la valeur de la propriété siz.
     *
     * @return possible object is {@link Siz }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Siz getSIZ() {
        return siz;
    }

    /**
     * Définit la valeur de la propriété siz.
     *
     * @param value allowed object is {@link Siz }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setSIZ(Siz value) {
        this.siz = value;
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
     * Obtient la valeur de la propriété pro.
     *
     * @return possible object is {@link Pro }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Pro getPRO() {
        return pro;
    }

    /**
     * Définit la valeur de la propriété pro.
     *
     * @param value allowed object is {@link Pro }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setPRO(Pro value) {
        this.pro = value;
    }

    /**
     * Obtient la valeur de la propriété espe.
     *
     * @return possible object is {@link Espe }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Espe getESPE() {
        return espe;
    }

    /**
     * Définit la valeur de la propriété espe.
     *
     * @param value allowed object is {@link Espe }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setESPE(Espe value) {
        this.espe = value;
    }

    /**
     * Obtient la valeur de la propriété sn.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getSN() {
        return sn;
    }

    /**
     * Définit la valeur de la propriété sn.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setSN(String value) {
        this.sn = value;
    }

    /**
     * Obtient la valeur de la propriété wt.
     *
     * @return possible object is {@link Double }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Double getWT() {
        return wt;
    }

    /**
     * Définit la valeur de la propriété wt.
     *
     * @param value allowed object is {@link Double }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setWT(Double value) {
        this.wt = value;
    }

    /**
     * Obtient la valeur de la propriété nf.
     *
     * @return possible object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Integer getNF() {
        return nf;
    }

    /**
     * Définit la valeur de la propriété nf.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setNF(Integer value) {
        this.nf = value;
    }

    /**
     * Obtient la valeur de la propriété wl.
     *
     * @return possible object is {@link Double }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Double getWL() {
        return wl;
    }

    /**
     * Définit la valeur de la propriété wl.
     *
     * @param value allowed object is {@link Double }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setWL(Double value) {
        this.wl = value;
    }

    /**
     * Obtient la valeur de la propriété fl.
     *
     * @return possible object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Integer getFL() {
        return fl;
    }

    /**
     * Définit la valeur de la propriété fl.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setFL(Integer value) {
        this.fl = value;
    }

    /**
     * Obtient la valeur de la propriété nq.
     *
     * @return possible object is {@link Double }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Double getNQ() {
        return nq;
    }

    /**
     * Définit la valeur de la propriété nq.
     *
     * @param value allowed object is {@link Double }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setNQ(Double value) {
        this.nq = value;
    }

    /**
     * Obtient la valeur de la propriété nb.
     *
     * @return possible object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Integer getNB() {
        return nb;
    }

    /**
     * Définit la valeur de la propriété nb.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setNB(Integer value) {
        this.nb = value;
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
     * Obtient la valeur de la propriété mm.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getMM() {
        return mm;
    }

    /**
     * Définit la valeur de la propriété mm.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setMM(String value) {
        this.mm = value;
    }

}
