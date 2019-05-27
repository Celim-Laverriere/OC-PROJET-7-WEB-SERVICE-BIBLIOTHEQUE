package org.bibliotheque.service;

import org.bibliotheque.client.CompteClient;
import org.bibliotheque.repository.CompteRepository;
import org.bibliotheque.wsdl.CompteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteService {

    @Autowired
    private CompteRepository repository;

    /**
     * ==== CETTE METHODE RECUPERER UN COMPTE CLIENT PAR SON IDENTIFIANT ====
     * @param id
     * @return LES INFORMATIONS D'UN COMPTE
     * @see CompteRepository#compteById(Integer)
     */
    public CompteType compteById(Integer id){
        return repository.compteById(id);
    }

    /**
     * GET ALL COMPTES
     * @return compteList
     * @see CompteClient#getAllComptes() (Integer)
     */
    public List<CompteType> compteList(){
        return  repository.compteList();
    }

    /**
     * ADD COMPTE
     * @param compteType @return message de confirmation
     * @see CompteClient#addCompte(CompteType)
     */
    public String addCompte(CompteType compteType){
        return repository.addCompte(compteType);
    }

    /**
     * UPDATE COMPTE
     * @param compteType @return message de confirmation
     * @see CompteClient#updateCompte(CompteType)
     */
    public String upCompte(CompteType compteType){
        return repository.upCompte(compteType);
    }

    /**
     * DELETE COMPTE
     * @param id @return message de confirmation
     * @see CompteClient#deleteCompte(Integer)
     */
    public String delCompte(Integer id){
        return repository.delCompte(id);
    }

}
