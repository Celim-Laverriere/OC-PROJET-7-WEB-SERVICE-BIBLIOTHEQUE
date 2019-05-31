package org.bibliotheque.service;

import org.bibliotheque.repository.SearchRepository;
import org.bibliotheque.wsdl.OuvrageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private SearchRepository searchRepository;


    /**
     * ==== GET OUVRAGES BY KEYWORD ====
     * @param keyword
     * @return UNE LISTE D'OUVRAGES
     */
    public List<OuvrageType> ouvrageTypeListByKeyword(String keyword){
        return searchRepository.ouvrageTypeListByKeyword(keyword);
    }
}
