//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.05.02 à 04:50:30 PM CEST 
//


package org.bibliotheque.wsdl;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.bibliotheque.wsdl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.bibliotheque.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetLivresByIdRequest }
     * 
     */
    public GetLivresByIdRequest createGetLivresByIdRequest() {
        return new GetLivresByIdRequest();
    }

    /**
     * Create an instance of {@link GetLivresByIdResponse }
     * 
     */
    public GetLivresByIdResponse createGetLivresByIdResponse() {
        return new GetLivresByIdResponse();
    }

    /**
     * Create an instance of {@link LivreType }
     * 
     */
    public LivreType createLivreType() {
        return new LivreType();
    }

    /**
     * Create an instance of {@link GetAllLivresRequest }
     * 
     */
    public GetAllLivresRequest createGetAllLivresRequest() {
        return new GetAllLivresRequest();
    }

    /**
     * Create an instance of {@link GetAllLivresResponse }
     * 
     */
    public GetAllLivresResponse createGetAllLivresResponse() {
        return new GetAllLivresResponse();
    }

    /**
     * Create an instance of {@link AddLivreRequest }
     * 
     */
    public AddLivreRequest createAddLivreRequest() {
        return new AddLivreRequest();
    }

    /**
     * Create an instance of {@link AddLivreResponse }
     * 
     */
    public AddLivreResponse createAddLivreResponse() {
        return new AddLivreResponse();
    }

    /**
     * Create an instance of {@link ServiceStatus }
     * 
     */
    public ServiceStatus createServiceStatus() {
        return new ServiceStatus();
    }

    /**
     * Create an instance of {@link UpdateLivreRequest }
     * 
     */
    public UpdateLivreRequest createUpdateLivreRequest() {
        return new UpdateLivreRequest();
    }

    /**
     * Create an instance of {@link UpdateLivreResponse }
     * 
     */
    public UpdateLivreResponse createUpdateLivreResponse() {
        return new UpdateLivreResponse();
    }

    /**
     * Create an instance of {@link DeleteLivreRequest }
     * 
     */
    public DeleteLivreRequest createDeleteLivreRequest() {
        return new DeleteLivreRequest();
    }

    /**
     * Create an instance of {@link DeleteLivreResponse }
     * 
     */
    public DeleteLivreResponse createDeleteLivreResponse() {
        return new DeleteLivreResponse();
    }

}
