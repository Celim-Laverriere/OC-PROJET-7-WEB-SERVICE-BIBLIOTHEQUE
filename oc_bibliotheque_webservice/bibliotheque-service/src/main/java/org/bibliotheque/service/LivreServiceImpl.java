package org.bibliotheque.service;

import org.bibliotheque.entity.LivreEntity;
import org.bibliotheque.repository.BibliothequeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LivreServiceImpl implements LivreService {

    private BibliothequeRepository repository;

    public  LivreServiceImpl(){

    }

    @Autowired
    public LivreServiceImpl(BibliothequeRepository repository){
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
}
