package org.bibliotheque.repository;

import org.bibliotheque.client.LivreClient;
import org.bibliotheque.config.SoapConfig;
import org.bibliotheque.wsdl.GetAllLivresResponse;
import org.bibliotheque.wsdl.GetLivresByIdResponse;
import org.bibliotheque.wsdl.LivreType;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LivreRepository {

    private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapConfig.class);

    public LivreType livreById(Integer id) {
        LivreClient client = context.getBean(LivreClient.class);
        GetLivresByIdResponse response = client.getLivreById(new Integer(id));
        System.out.println("response: Movie id="+ response.getLivreType().getId()+", title=" +
                response.getLivreType().getOuvrageId() + ", category="+ response.getLivreType().getRefBibliotheque());
        return response.getLivreType();
    }

    public List<LivreType> livreTypeList(){
        LivreClient client = context.getBean(LivreClient.class);
        GetAllLivresResponse response = client.getAllLivres();
        return response.getLivreType();
    }
}
