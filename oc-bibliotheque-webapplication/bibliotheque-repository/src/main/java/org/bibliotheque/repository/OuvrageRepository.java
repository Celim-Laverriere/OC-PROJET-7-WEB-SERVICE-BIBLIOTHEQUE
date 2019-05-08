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
    private OuvrageClient client;

    /* ==== GET OUVRAGE BY ID ==== */
    public OuvrageType ouvrageById(Integer id){
        GetOuvrageByIdResponse response = client.getOuvrageById(id);
        return response.getOuvrageType();
    }

    /* ==== GET ALL OUVRAGES ==== */
    public List<OuvrageType> ouvrageTypeList(){
        GetAllOuvragesResponse response = client.getAllOuvrages();
        return response.getOuvrageType();
    }
}
