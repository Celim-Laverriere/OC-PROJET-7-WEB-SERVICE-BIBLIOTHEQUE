package org.bibliotheque.service.impl;

import org.bibliotheque.entity.LivreEntity;
import org.bibliotheque.repository.LivreRepository;
import org.bibliotheque.service.contract.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LivreServiceImpl implements LivreService {

    private LivreRepository repository;

    public  LivreServiceImpl(){

    }

    @Autowired
    public LivreServiceImpl(LivreRepository repository){
        this.repository = repository;
    }

    @Override
    public LivreEntity getLivreById(Integer id) {
        return this.repository.findById(id).get();
    }

    @Override
    public List<LivreEntity> getAllLivres() {
        List<LivreEntity> livreEntities = new ArrayList<LivreEntity>();
        repository.findAll().forEach(e -> livreEntities.add(e));
        return livreEntities;
    }

    @Override
    public LivreEntity getLivreByRef(String ref) {
        return this.repository.findByRefBibliotheque(ref);
    }

    @Override
    public LivreEntity addLivre(LivreEntity livre) {
        try{
            return this.repository.save(livre);
        } catch (Exception pEX){
            pEX.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateLivre(LivreEntity livre) {
        try{
            this.repository.save(livre);
            return true;
        } catch (Exception pEX){
            pEX.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteLivre(Integer id) {
        try {
            this.repository.deleteById(id);
            return true;
        } catch (Exception pEX){
            return false;
        }
    }


}
