package org.bibliotheque.repository;

import org.bibliotheque.client.EmpruntClient;
import org.bibliotheque.wsdl.EmpruntType;
import org.bibliotheque.wsdl.GetAllEmpruntByCompteIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpruntRepository {

    @Autowired
    private EmpruntClient client;

    /* ==== GET ALL EMPRUNTS BY ID COMPTE ==== */
    public List<EmpruntType> getAllEmpruntByCompteId(Integer id){
        GetAllEmpruntByCompteIdResponse response = client.getAllEmpruntByCompteId(id);
        return response.getEmpruntType();
    }
}
