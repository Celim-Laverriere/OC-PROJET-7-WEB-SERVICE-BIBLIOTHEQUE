package org.bibliotheque.service;

import org.bibliotheque.repository.CompteRepository;
import org.bibliotheque.wsdl.CompteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteService {

    @Autowired
    private CompteRepository repository;

    public CompteType compteById(Integer id){
        return repository.compteById(id);
    }

    public List<CompteType> compteList(){
        return  repository.compteList();
    }

    public String addCompte(CompteType compteType){
        return repository.addCompte(compteType);
    }

    public String delCompt(Integer id){
        return repository.delCompte(id);
    }

    public String upCompte(CompteType compteType){
        return repository.upCompte(compteType);
    }
}
