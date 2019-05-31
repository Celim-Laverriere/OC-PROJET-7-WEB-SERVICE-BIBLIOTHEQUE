package org.bibliotheque.repository;

import org.bibliotheque.client.OuvrageClient;
import org.bibliotheque.wsdl.GetAllOuvragesResponse;
import org.bibliotheque.wsdl.GetOuvrageByIdResponse;
import org.bibliotheque.wsdl.OuvrageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OuvrageRepository {


    @Autowired
    private OuvrageClient ouvrageClient;


    /**
     * GET OUVRAGE BY ID
     * @param id
     * @return UN OUVRAGE
     * @see OuvrageClient#getOuvrageById(Integer)
     */
    public OuvrageType ouvrageById(Integer id){
        GetOuvrageByIdResponse response = ouvrageClient.getOuvrageById(id);
        return response.getOuvrageType();
    }

    /**
     * GET ALL OUVRAGES
     * @return UNE LISTE D'OUVRAGES
     * @see OuvrageClient#getAllOuvrages()
     */
    public List<OuvrageType> ouvrageTypeList(){
        GetAllOuvragesResponse response = ouvrageClient.getAllOuvrages();
        return response.getOuvrageType();
    }
}
