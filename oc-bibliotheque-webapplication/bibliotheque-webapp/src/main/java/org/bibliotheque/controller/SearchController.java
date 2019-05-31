package org.bibliotheque.controller;

import org.bibliotheque.service.OuvrageService;
import org.bibliotheque.service.SearchService;
import org.bibliotheque.wsdl.LivreType;
import org.bibliotheque.wsdl.OuvrageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;


@Controller
public class SearchController {

    private static final Logger logger = LoggerFactory.getLogger(OuvrageController.class);

    @Autowired
    private SearchService searchService;

    @Autowired
    private OuvrageService ouvrageService;


    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchOuvrageByKeyword(Model model, @RequestParam(value = "keyword")String keyword){

        List<OuvrageType> ouvrageTypeList = searchService.ouvrageTypeListByKeyword(keyword);
        ouvrageTypeList = ouvrageService.LivresDispoForOuvrage(ouvrageTypeList);

        model.addAttribute("ouvrageList", ouvrageTypeList);

        return "ouvrage/ouvrageList";
    }
}
