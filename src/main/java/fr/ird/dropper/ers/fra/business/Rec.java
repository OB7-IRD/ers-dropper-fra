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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Receiving vessel identification: For transfer	under BFT rules, fill out BTI
 * instead. 1.1-2.0: Receiving vessel. One of REC or DON must be referring to
 * "this vessel", meaning the one identified in the LOG super-element. Required
 * unless reporting under ICCAT BFT rules.
 *
 * <p>
 * Classe Java pour Rec complex type.
 *
 * <p>
 * Le fragment de schéma suivant indique le contenu attendu figurant dans cette
 * classe.
 *
 * <pre>
 * &lt;complexType name="Rec"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PFP" type="{http://ec.europa.eu/fisheries/schema/ers/v3}Pfp"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecDeclarationType", propOrder = {
    "pfp"
})
@Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
public class Rec {

    @XmlElement(name = "PFP", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    protected Pfp pfp;

    /**
     * Obtient la valeur de la propriété pfp.
     *
     * @return possible object is {@link Pfp }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public Pfp getPFP() {
        return pfp;
    }

    /**
     * Définit la valeur de la propriété pfp.
     *
     * @param value allowed object is {@link Pfp }
     *
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2019-11-21T01:58:47+04:00", comments = "JAXB RI v2.3.0")
    public void setPFP(Pfp value) {
        this.pfp = value;
    }

}
