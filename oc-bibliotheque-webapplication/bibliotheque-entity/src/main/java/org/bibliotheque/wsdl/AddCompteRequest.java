//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.05.31 à 03:10:45 PM CEST 
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
 *         &lt;element name="compteType" type="{http://www.webservice.org/bibliotheque-ws}compteType"/&gt;
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
    "compteType"
})
@XmlRootElement(name = "addCompteRequest")
public class AddCompteRequest {

    @XmlElement(required = true)
    protected CompteType compteType;

    /**
     * Obtient la valeur de la propriété compteType.
     * 
     * @return
     *     possible object is
     *     {@link CompteType }
     *     
     */
    public CompteType getCompteType() {
        return compteType;
    }

    /**
     * Définit la valeur de la propriété compteType.
     * 
     * @param value
     *     allowed object is
     *     {@link CompteType }
     *     
     */
    public void setCompteType(CompteType value) {
        this.compteType = value;
    }

}
