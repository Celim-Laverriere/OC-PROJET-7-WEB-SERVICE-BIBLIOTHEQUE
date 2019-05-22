package org.bibliotheque.service;

import org.bibliotheque.client.OuvrageClient;
import org.bibliotheque.repository.OuvrageRepository;
import org.bibliotheque.wsdl.LivreType;
import org.bibliotheque.wsdl.OuvrageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    /**
     * CETTE METHODE RÉCUPÉRER TOUS LES OUVRAGES CORRESPONDANT AU GENRE SELECTIONNE
     * @param motCle
     * @return UNE LISTE D'OUVRAGE TRIE PAR GENRE
     */
    public List<OuvrageType> ouvragesByGenreList(String motCle){

        List<OuvrageType> ouvrageTypeList = repository.ouvrageTypeList();
        List<OuvrageType> ouvrageTypeListByGenre = new ArrayList<>();

        for (OuvrageType ouvrageType : ouvrageTypeList){

            if (ouvrageType.getGenre().equals(motCle) || ouvrageType.getAuteur().equals(motCle)){
                ouvrageTypeListByGenre.add(ouvrageType);
            }
        }

        return ouvrageTypeListByGenre;
    }

    /**
     * CETTE METHODE RÉCUPÉRER LES GENRES DES OUVRAGES ET SUPPRIME LES DOUBLONS
     * @param ouvrageTypeList
     * @return UNE LISTE DE GENRES
     */
    public Set<String> ouvrageGenreList(List<OuvrageType> ouvrageTypeList){

        Set<String> genreSetList = new HashSet<>();

        for (OuvrageType ouvrageType : ouvrageTypeList){
            genreSetList.add(ouvrageType.getGenre());
        }

        return genreSetList;
    }

    /**
     * CETTE METHODE RÉCUPÉRER LES AUTEURS DES OUVRAGES ET SUPPRIME LES DOUBLONS
     * @param ouvrageTypeList
     * @return UNE LISTE D'AUTEURS
     */
    public Set<String> ouvrageAuteurList(List<OuvrageType> ouvrageTypeList){

        Set<String> auteurSetList = new HashSet<>();

        for (OuvrageType ouvrageType : ouvrageTypeList){
            auteurSetList.add(ouvrageType.getAuteur());
        }

        return auteurSetList;
    }








}
