package org.bibliotheque.service;

import org.bibliotheque.client.OuvrageClient;
import org.bibliotheque.repository.OuvrageRepository;
import org.bibliotheque.wsdl.LivreType;
import org.bibliotheque.wsdl.OuvrageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OuvrageService {

    @Autowired
    private OuvrageRepository repository;

    /**
     * GET OUVRAGE BY ID
     * @param id @return OuvrageType
     * @see OuvrageClient#getOuvrageById(Integer)
     */
    public OuvrageType ouvrageById(Integer id){
        return repository.ouvrageById(id);
    }

    /**
     * GET ALL OUVRAGES
     * @return ouvrageTypeList
     * @see OuvrageClient#getAllOuvrages()
     */
    public List<OuvrageType> ouvrageTypeList(){
        return repository.ouvrageTypeList();
    }

    public List<LivreType> nombreDeLivreDispo(List<LivreType> livreTypeList){

        List<LivreType> livreTypeListDispo = new ArrayList<>();

        for (LivreType livreType : livreTypeList){
            if (livreType.getStatut().equals("disponible")){
                livreTypeListDispo.add(livreType);
            }
        }

        return livreTypeListDispo;
    }
}
