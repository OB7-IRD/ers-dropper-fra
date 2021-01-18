//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.11.21 à 01:58:47 PM MUT 
//
package fr.ird.dropper.ers.fra.business;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * Additional subdeclaration under TT fishing
 *
 * <p>
 * Classe Java pour Etts complex type.
 *
 * <p>
 * Le fragment de schéma suivant indique le contenu attendu figurant dans cette
 * classe.
 *
 * <pre>
 * &lt;complexType name="Etts"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="Type" use="required" type="{http://ec.europa.eu/fisheries/schema/ers/v3}ErsNat" /&gt;
 *       &lt;attribute name="HN" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="CD" type="{http://ec.europa.eu/fisheries/schema/ers/v3}degree_compass_rose" /&gt;
 *       &lt;attribute name="SC"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}float"&gt;
 *             &lt;minInclusive value="0"/&gt;
 *             &lt;maxInclusive value="100"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="SS"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *             &lt;minInclusive value="0"/&gt;
 *             &lt;maxInclusive value="9"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="ST"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *             &lt;fractionDigits value="1"/&gt;
 *             &lt;totalDigits value="3"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="WD" type="{http://ec.europa.eu/fisheries/schema/ers/v3}degree_compass_rose" /&gt;
 *       &lt;attribute name="WS"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *             &lt;fractionDigits value="1"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="FA" type="{http://ec.europa.eu/fisheries/schema/ers/v3}association" /&gt;
 *       &lt;attribute name="CM"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;maxLength value="300"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="SO" type="{http://www.w3.org/2001/XMLSchema}float" /&gt;
 *       &lt;attribute name="MP"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *             &lt;enumeration value="0"/&gt;
 *             &lt;enumeration value="1"/&gt;
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
@XmlType(name = "ETtsType")
@Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
public class Etts {

    @XmlAttribute(name = "Type", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected ErsNat type;
    @XmlAttribute(name = "HN")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Integer hn;
    @XmlAttribute(name = "CD")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected DegreeCompassRose cd;
    @XmlAttribute(name = "SC")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Double sc;
    @XmlAttribute(name = "SS")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Integer ss;
    @XmlAttribute(name = "ST")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Double st;
    @XmlAttribute(name = "WD")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected DegreeCompassRose wd;
    @XmlAttribute(name = "WS")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Double ws;
    @XmlAttribute(name = "FA")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Association fa;
    @XmlAttribute(name = "CM")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String cm;
    @XmlAttribute(name = "SO")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Double so;
    @XmlAttribute(name = "MP")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Integer mp;

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
     * Obtient la valeur de la propriété hn.
     *
     * @return possible object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Integer getHN() {
        return hn;
    }

    /**
     * Définit la valeur de la propriété hn.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setHN(Integer value) {
        this.hn = value;
    }

    /**
     * Obtient la valeur de la propriété cd.
     *
     * @return possible object is {@link DegreeCompassRose }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public DegreeCompassRose getCD() {
        return cd;
    }

    /**
     * Définit la valeur de la propriété cd.
     *
     * @param value allowed object is {@link DegreeCompassRose }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setCD(DegreeCompassRose value) {
        this.cd = value;
    }

    /**
     * Obtient la valeur de la propriété sc.
     *
     * @return possible object is {@link Double }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Double getSC() {
        return sc;
    }

    /**
     * Définit la valeur de la propriété sc.
     *
     * @param value allowed object is {@link Double }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setSC(Double value) {
        this.sc = value;
    }

    /**
     * Obtient la valeur de la propriété ss.
     *
     * @return possible object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Integer getSS() {
        return ss;
    }

    /**
     * Définit la valeur de la propriété ss.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setSS(Integer value) {
        this.ss = value;
    }

    /**
     * Obtient la valeur de la propriété st.
     *
     * @return possible object is {@link Double }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Double getST() {
        return st;
    }

    /**
     * Définit la valeur de la propriété st.
     *
     * @param value allowed object is {@link Double }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setST(Double value) {
        this.st = value;
    }

    /**
     * Obtient la valeur de la propriété wd.
     *
     * @return possible object is {@link DegreeCompassRose }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public DegreeCompassRose getWD() {
        return wd;
    }

    /**
     * Définit la valeur de la propriété wd.
     *
     * @param value allowed object is {@link DegreeCompassRose }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setWD(DegreeCompassRose value) {
        this.wd = value;
    }

    /**
     * Obtient la valeur de la propriété ws.
     *
     * @return possible object is {@link Double }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Double getWS() {
        return ws;
    }

    /**
     * Définit la valeur de la propriété ws.
     *
     * @param value allowed object is {@link Double }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setWS(Double value) {
        this.ws = value;
    }

    /**
     * Obtient la valeur de la propriété fa.
     *
     * @return possible object is {@link Association }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Association getFA() {
        return fa;
    }

    /**
     * Définit la valeur de la propriété fa.
     *
     * @param value allowed object is {@link Association }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setFA(Association value) {
        this.fa = value;
    }

    /**
     * Obtient la valeur de la propriété cm.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getCM() {
        return cm;
    }

    /**
     * Définit la valeur de la propriété cm.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setCM(String value) {
        this.cm = value;
    }

    /**
     * Obtient la valeur de la propriété so.
     *
     * @return possible object is {@link Double }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Double getSO() {
        return so;
    }

    /**
     * Définit la valeur de la propriété so.
     *
     * @param value allowed object is {@link Double }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setSO(Double value) {
        this.so = value;
    }

    /**
     * Obtient la valeur de la propriété mp.
     *
     * @return possible object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Integer getMP() {
        return mp;
    }

    /**
     * Définit la valeur de la propriété mp.
     *
     * @param value allowed object is {@link Integer }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setMP(Integer value) {
        this.mp = value;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
