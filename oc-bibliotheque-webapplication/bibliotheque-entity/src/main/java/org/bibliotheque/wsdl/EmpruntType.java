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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour empruntType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="empruntType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="dateDebut" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="dateFin" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="prolongation" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "empruntType", propOrder = {
    "id",
    "dateDebut",
    "dateFin",
    "prolongation"
})
public class EmpruntType {

    protected int id;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateDebut;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateFin;
    protected boolean prolongation;

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
     * Obtient la valeur de la propriété dateDebut.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateDebut() {
        return dateDebut;
    }

    /**
     * Définit la valeur de la propriété dateDebut.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateDebut(XMLGregorianCalendar value) {
        this.dateDebut = value;
    }

    /**
     * Obtient la valeur de la propriété dateFin.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateFin() {
        return dateFin;
    }

    /**
     * Définit la valeur de la propriété dateFin.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateFin(XMLGregorianCalendar value) {
        this.dateFin = value;
    }

    /**
     * Obtient la valeur de la propriété prolongation.
     * 
     */
    public boolean isProlongation() {
        return prolongation;
    }

    /**
     * Définit la valeur de la propriété prolongation.
     * 
     */
    public void setProlongation(boolean value) {
        this.prolongation = value;
    }

}
