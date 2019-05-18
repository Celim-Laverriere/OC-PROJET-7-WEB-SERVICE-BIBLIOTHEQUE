package org.bibliotheque.service;

import org.bibliotheque.repository.EmpruntRepository;
import org.bibliotheque.repository.LivreRepository;
import org.bibliotheque.repository.OuvrageRepository;
import org.bibliotheque.wsdl.EmpruntType;
import org.bibliotheque.wsdl.LivreType;
import org.bibliotheque.wsdl.OuvrageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpruntService {

    @Autowired
    private EmpruntRepository empruntRepository;

    @Autowired
    private LivreRepository livreRepository;

    @Autowired
    private OuvrageRepository ouvrageRepository;


    /**
     * GET ALL EMPRUNTS BY ID COMPTE
     * @param id
     * @return Une liste des emprunts d'un compte
     */
    public List<EmpruntType> getAllEmpruntByCompteId(Integer id){
        return empruntRepository.getAllEmpruntByCompteId(id);
    }


    /**
     * CETTE METHODE RECUPERER TOUS LES LIVRES EMPRUNTES PAR UN CLIENT
     * @param empruntTypeList
     * @return UNE LISTE DE LIVRES
     */
    public List<LivreType> livreTypeListEmprunter(List<EmpruntType> empruntTypeList){

        List<LivreType> livreTypeList = new ArrayList<>();

        for (EmpruntType empruntType : empruntTypeList){
            LivreType livreType = livreRepository.livreById(empruntType.getLivreId());
            livreTypeList.add(livreType);
        }

        return livreTypeList;
    }

    /**
     * CETTE METHODE RECUPERER TOUS LES OUVRAGES DES LIVRES EMPRUNTES PAR LE CLIENT
     * @param livreTypeList
     * @return UNE LISTE D'OUVRAGES
     */
    public List<OuvrageType> ouvrageTypeListEmprunter(List<LivreType> livreTypeList){

        List<OuvrageType> ouvrageTypeList = new ArrayList<>();

        for (LivreType livreType : livreTypeList){
            OuvrageType ouvrageType = ouvrageRepository.ouvrageById(livreType.getOuvrageId());
            ouvrageTypeList.add(ouvrageType);
        }

        return ouvrageTypeList;
    }
}
