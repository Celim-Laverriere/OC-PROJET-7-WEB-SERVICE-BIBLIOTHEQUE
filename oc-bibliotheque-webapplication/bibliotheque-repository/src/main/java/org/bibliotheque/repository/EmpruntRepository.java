package org.bibliotheque.repository;

import org.bibliotheque.client.EmpruntClient;
import org.bibliotheque.wsdl.EmpruntType;
import org.bibliotheque.wsdl.GetAllEmpruntByCompteIdResponse;
import org.bibliotheque.wsdl.GetEmpruntByIdResponse;
import org.bibliotheque.wsdl.UpdateEmpruntResponse;
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

    /* ==== GET EMPRUNT BY ID ==== */
    public EmpruntType getEmpruntById(Integer id){
        GetEmpruntByIdResponse response = client.getEmpruntById(id);
        return response.getEmpruntType();
    }

    /* ==== UPDATE EMPRUNT ==== */
    public String upEmpruntType(EmpruntType empruntType){
        UpdateEmpruntResponse response = client.updateEmprunt(empruntType);
        return response.getServiceStatus().getStatusCode();
    }
}
