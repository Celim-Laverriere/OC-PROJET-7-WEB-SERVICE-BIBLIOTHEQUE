//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.05.13 à 10:10:51 AM CEST 
//


package org.bibliotheque.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour photoType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="photoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="urlPhoto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nomPhoto" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ouvrage" type="{http://www.webservice.org/bibliotheque-ws}ouvrageType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "photoType", propOrder = {
    "id",
    "urlPhoto",
    "nomPhoto",
    "ouvrage"
})
public class PhotoType {

    protected int id;
    @XmlElement(required = true)
    protected String urlPhoto;
    @XmlElement(required = true)
    protected String nomPhoto;
    @XmlElement(required = true)
    protected OuvrageType ouvrage;

    /**
     * Obtient la valeur de la propriété id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété urlPhoto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlPhoto() {
        return urlPhoto;
    }

    /**
     * Définit la valeur de la propriété urlPhoto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlPhoto(String value) {
        this.urlPhoto = value;
    }

    /**
     * Obtient la valeur de la propriété nomPhoto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomPhoto() {
        return nomPhoto;
    }

    /**
     * Définit la valeur de la propriété nomPhoto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomPhoto(String value) {
        this.nomPhoto = value;
    }

    /**
     * Obtient la valeur de la propriété ouvrage.
     * 
     * @return
     *     possible object is
     *     {@link OuvrageType }
     *     
     */
    public OuvrageType getOuvrage() {
        return ouvrage;
    }

    /**
     * Définit la valeur de la propriété ouvrage.
     * 
     * @param value
     *     allowed object is
     *     {@link OuvrageType }
     *     
     */
    public void setOuvrage(OuvrageType value) {
        this.ouvrage = value;
    }

}
