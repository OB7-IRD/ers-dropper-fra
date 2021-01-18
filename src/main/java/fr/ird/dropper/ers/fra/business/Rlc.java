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
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Relocation declaration 2.0-3.0: JTI renamed to BTI 1.1-2.0: Moved IR/TT/TC to
 * REC, moved RF/TF/RC to DON. Added JTI: ICCAT reporting features.
 *
 * <p>
 * Classe Java pour Rlc complex type.
 *
 * <p>
 * Le fragment de schéma suivant indique le contenu attendu figurant dans cette
 * classe.
 *
 * <pre>
 * &lt;complexType name="Rlc"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="REC" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Rec" minOccurs="0"/&gt;
 *         &lt;element name="DON" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Don" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="POS" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Pos" minOccurs="0"/&gt;
 *         &lt;element name="SPE" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Spe" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="BTI" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Bti" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="DA" use="required" type="{http://ec.europa.eu/fisheries/schema/ers/v3}UtcDateType" /&gt;
 *       &lt;attribute name="TI" type="{http://ec.europa.eu/fisheries/schema/ers/v3}UtcTimeType" /&gt;
 *       &lt;attribute name="RT" type="{http://ec.europa.eu/fisheries/schema/ers/v3}RelocationToType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RlcDeclarationType", propOrder = {
    "rec",
    "don",
    "pos",
    "spe",
    "bti"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
public class Rlc {

    @XmlElement(name = "REC")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Rec rec;
    @XmlElement(name = "DON")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected List<Don> don;
    @XmlElement(name = "POS")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Pos pos;
    @XmlElement(name = "SPE")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected List<Spe> spe;
    @XmlElement(name = "BTI")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Bti bti;
    @XmlAttribute(name = "DA", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected XMLGregorianCalendar da;
    @XmlAttribute(name = "TI")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String ti;
    @XmlAttribute(name = "RT")
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected String rt;

    /**
     * Obtient la valeur de la propriété rec.
     *
     * @return possible object is {@link Rec }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Rec getREC() {
        return rec;
    }

    /**
     * Définit la valeur de la propriété rec.
     *
     * @param value allowed object is {@link Rec }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setREC(Rec value) {
        this.rec = value;
    }

    /**
     * Gets the value of the don property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the don property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDON().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Don }
     *
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public List<Don> getDON() {
        if (don == null) {
            don = new ArrayList<Don>();
        }
        return this.don;
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
     * Obtient la valeur de la propriété bti.
     *
     * @return possible object is {@link Bti }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Bti getBTI() {
        return bti;
    }

    /**
     * Définit la valeur de la propriété bti.
     *
     * @param value allowed object is {@link Bti }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setBTI(Bti value) {
        this.bti = value;
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
     * Obtient la valeur de la propriété rt.
     *
     * @return possible object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public String getRT() {
        return rt;
    }

    /**
     * Définit la valeur de la propriété rt.
     *
     * @param value allowed object is {@link String }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setRT(String value) {
        this.rt = value;
    }

}
