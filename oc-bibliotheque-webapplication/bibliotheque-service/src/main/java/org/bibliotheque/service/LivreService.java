package org.bibliotheque.service;

import org.bibliotheque.repository.LivreRepository;
import org.bibliotheque.wsdl.LivreType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreService {

    @Autowired
    private LivreRepository runLivre;

    public LivreType LivreId(Integer id){
      return runLivre.livreType(id);
    }

    public List<LivreType> livreTypeList(){
        return runLivre.livreTypeList();
    }
}
