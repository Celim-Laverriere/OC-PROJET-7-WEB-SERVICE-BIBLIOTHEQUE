package org.bibliotheque.repository;

import org.bibliotheque.client.CompteClient;
import org.bibliotheque.config.SoapConfig;
import org.bibliotheque.wsdl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompteRepository {

    private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapConfig.class);

    @Autowired
    CompteClient client = context.getBean(CompteClient.class);

    public CompteType compteById(Integer id){
        GetCompteByIdResponse response = client.getCompteById(new Integer(id));
        return response.getCompteType();
    }

    public List<CompteType> compteList(){
        GetAllComptesResponse response = client.getAllComptes();
        return response.getCompteType();
    }

    public String addCompte(CompteType compteType){
        AddCompteResponse response = client.addCompte(compteType);
        return response.getServiceStatus().getMessage();
    }

    public String delCompte(Integer id){
        DeleteCompteResponse response = client.deleteCompte(id);
        return response.getServiceStatus().getStatusCode();
    }

    public String upCompte(CompteType compteType){
        UpdateCompteResponse response = client.updateCompte(compteType);
        return response.getServiceStatus().getMessage();
    }
}
