package org.bibliotheque.repository;

import org.bibliotheque.client.LivreClient;
import org.bibliotheque.wsdl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LivreRepository {

    @Autowired
    private LivreClient client;

    /* ==== GET LIVRE BY ID ==== */
    public LivreType livreById(Integer id) {
        GetLivreByIdResponse response = client.getLivreById(id);
        return response.getLivreType();
    }

    /* ==== GET ALL LIVRES ==== */
    public List<LivreType> livreTypeList(){
        GetAllLivresResponse response = client.getAllLivres();
        return response.getLivreType();
    }

    /* ==== ADD LIVRE ==== */
    public String addLivre(LivreType livreType){
        AddLivreResponse response = client.addLivre(livreType);
        return response.getServiceStatus().getMessage();
    }

    /* ==== UPDATE LIVRE ==== */
    public String upLivre(LivreType livreType){
        UpdateLivreResponse response = client.updateLivre(livreType);
        return response.getServiceStatus().getMessage();
    }

    /* ==== DELETE LIVRE ==== */
    public String delLivre(Integer id){
        DeleteLivreResponse response = client.deleteLivre(id);
        return response.getServiceStatus().getMessage();
    }
}
