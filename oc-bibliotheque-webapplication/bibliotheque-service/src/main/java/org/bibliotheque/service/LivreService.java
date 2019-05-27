package org.bibliotheque.service;

import org.bibliotheque.client.LivreClient;
import org.bibliotheque.repository.LivreRepository;
import org.bibliotheque.wsdl.LivreType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreService {

    @Autowired
    private LivreRepository repository;


    /**
     * GET LIVRE BY ID
     * @param id
     * @return LivreType
     * @see LivreClient#getLivreById(Integer)
     */
    public LivreType livreById(Integer id){
        return repository.livreById(id);
    }

    /**
     * GET ALL LIVRES
     * @return livreTypeList
     * @see LivreClient#getAllLivres()
     */
    public List<LivreType> livreTypeList(){
        return repository.livreTypeList();
    }

    /**
     * ADD LIVRE
     * @param livreType
     * @return message de confirmation
     * @see LivreClient#addLivre(LivreType)
     */
    public String addLivre(LivreType livreType){
        return repository.addLivre(livreType);
    }

    /**
     * UPDATE LIVRE
     * @param livreType
     * @return message de confirmation
     * @see LivreClient#updateLivre(LivreType)
     */
    public String upLivre(LivreType livreType){
        return repository.upLivre(livreType);
    }

    /**
     * DELETE LIVRE
     * @param id
     * @return message de confirmation
     * @see LivreClient#deleteLivre(Integer)
     */
    public String delLivre(Integer id){
        return repository.delLivre(id);
    }
}
