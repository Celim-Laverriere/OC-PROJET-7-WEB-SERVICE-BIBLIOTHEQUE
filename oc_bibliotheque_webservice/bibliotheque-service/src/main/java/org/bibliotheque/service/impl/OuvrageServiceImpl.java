package org.bibliotheque.service.impl;

import lombok.NoArgsConstructor;
import org.bibliotheque.entity.OuvrageEntity;
import org.bibliotheque.repository.OuvrageRepository;
import org.bibliotheque.service.contract.OuvrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@NoArgsConstructor
public class OuvrageServiceImpl implements OuvrageService {

    private OuvrageRepository repository;

    @Autowired
    public OuvrageServiceImpl(OuvrageRepository repository){
        this.repository = repository;
    }

    @Override
    public OuvrageEntity getOuvrageById(Integer id) {
        return null;
    }

    @Override
    public List<OuvrageEntity> getAllOuvrages() {
        return null;
    }

    @Override
    public OuvrageEntity addOuvrage(OuvrageEntity ouvrage) {
        return null;
    }

    @Override
    public boolean updateOuvrage(OuvrageEntity ouvrage) {
        return false;
    }

    @Override
    public boolean deleteOuvrage(Integer id) {
        return false;
    }
}
