//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.05.18 à 04:23:27 PM CEST 
//


package org.bibliotheque.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ouvrageType" type="{http://www.webservice.org/bibliotheque-ws}ouvrageType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "ouvrageType"
})
@XmlRootElement(name = "getOuvrageByIdResponse")
public class GetOuvrageByIdResponse {

    @XmlElement(required = true)
    protected OuvrageType ouvrageType;

    /**
     * Obtient la valeur de la propriété ouvrageType.
     * 
     * @return
     *     possible object is
     *     {@link OuvrageType }
     *     
     */
    public OuvrageType getOuvrageType() {
        return ouvrageType;
    }

    /**
     * Définit la valeur de la propriété ouvrageType.
     * 
     * @param value
     *     allowed object is
     *     {@link OuvrageType }
     *     
     */
    public void setOuvrageType(OuvrageType value) {
        this.ouvrageType = value;
    }

}
