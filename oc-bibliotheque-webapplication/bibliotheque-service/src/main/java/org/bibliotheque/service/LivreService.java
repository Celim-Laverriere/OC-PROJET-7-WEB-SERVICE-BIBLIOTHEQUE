package org.bibliotheque.service;

import org.bibliotheque.repository.LivreRepository;
import org.bibliotheque.wsdl.LivreType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreService {

    @Autowired
    private LivreRepository repository;

    public LivreType LivreById(Integer id){
      return repository.livreById(id);
    }

    public List<LivreType> livreTypeList(){
        return repository.livreTypeList();
    }
}
