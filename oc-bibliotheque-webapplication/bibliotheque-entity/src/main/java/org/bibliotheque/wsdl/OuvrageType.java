//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.05.08 à 04:06:04 PM CEST 
//


package org.bibliotheque.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour ouvrageType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="ouvrageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="titre" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="genre" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="resumer" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="auteur" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="editeur" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ref" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="photos" type="{http://www.webservice.org/bibliotheque-ws}photoType"/&gt;
 *         &lt;element name="livres" type="{http://www.webservice.org/bibliotheque-ws}livreType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ouvrageType", propOrder = {
    "id",
    "titre",
    "genre",
    "resumer",
    "auteur",
    "editeur",
    "ref",
    "photos",
    "livres"
})
public class OuvrageType {

    protected int id;
    @XmlElement(required = true)
    protected String titre;
    @XmlElement(required = true)
    protected String genre;
    @XmlElement(required = true)
    protected String resumer;
    @XmlElement(required = true)
    protected String auteur;
    @XmlElement(required = true)
    protected String editeur;
    @XmlElement(required = true)
    protected String ref;
    @XmlElement(required = true)
    protected PhotoType photos;
    @XmlElement(required = true)
    protected LivreType livres;

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
     * Obtient la valeur de la propriété titre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Définit la valeur de la propriété titre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitre(String value) {
        this.titre = value;
    }

    /**
     * Obtient la valeur de la propriété genre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Définit la valeur de la propriété genre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenre(String value) {
        this.genre = value;
    }

    /**
     * Obtient la valeur de la propriété resumer.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResumer() {
        return resumer;
    }

    /**
     * Définit la valeur de la propriété resumer.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResumer(String value) {
        this.resumer = value;
    }

    /**
     * Obtient la valeur de la propriété auteur.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuteur() {
        return auteur;
    }

    /**
     * Définit la valeur de la propriété auteur.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuteur(String value) {
        this.auteur = value;
    }

    /**
     * Obtient la valeur de la propriété editeur.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEditeur() {
        return editeur;
    }

    /**
     * Définit la valeur de la propriété editeur.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEditeur(String value) {
        this.editeur = value;
    }

    /**
     * Obtient la valeur de la propriété ref.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRef() {
        return ref;
    }

    /**
     * Définit la valeur de la propriété ref.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRef(String value) {
        this.ref = value;
    }

    /**
     * Obtient la valeur de la propriété photos.
     * 
     * @return
     *     possible object is
     *     {@link PhotoType }
     *     
     */
    public PhotoType getPhotos() {
        return photos;
    }

    /**
     * Définit la valeur de la propriété photos.
     * 
     * @param value
     *     allowed object is
     *     {@link PhotoType }
     *     
     */
    public void setPhotos(PhotoType value) {
        this.photos = value;
    }

    /**
     * Obtient la valeur de la propriété livres.
     * 
     * @return
     *     possible object is
     *     {@link LivreType }
     *     
     */
    public LivreType getLivres() {
        return livres;
    }

    /**
     * Définit la valeur de la propriété livres.
     * 
     * @param value
     *     allowed object is
     *     {@link LivreType }
     *     
     */
    public void setLivres(LivreType value) {
        this.livres = value;
    }

}
