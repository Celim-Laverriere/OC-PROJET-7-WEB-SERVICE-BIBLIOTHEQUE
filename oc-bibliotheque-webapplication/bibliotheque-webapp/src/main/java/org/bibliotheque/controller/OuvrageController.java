package org.bibliotheque.controller;

import org.bibliotheque.service.OuvrageService;
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

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

@Controller
public class OuvrageController {

    private static final Logger logger = LoggerFactory.getLogger(OuvrageController.class);

    @Autowired
    private OuvrageService ouvrageService;


    @RequestMapping(value = "/ouvrages", method = RequestMethod.GET)
    public String ouvrages(final Model model, HttpSession session) {

        List<OuvrageType> ouvrageTypeList = ouvrageService.ouvrageTypeList();
        Set<String> genresSet = ouvrageService.ouvrageGenreList(ouvrageTypeList);
        Set<String> auteursSet = ouvrageService.ouvrageAuteurList(ouvrageTypeList);

        logger.debug("Hello from Logback");
        logger.info("Liste d'ourages : {}", ouvrageTypeList.size());

        session.setAttribute("genreList", genresSet);
        session.setAttribute("auteurList", auteursSet);
        model.addAttribute("ouvrageList", ouvrageTypeList);

        return "ouvrage/ouvrageList";
    }


    @RequestMapping(value = "/ouvrage", method = RequestMethod.GET)
    public String ouvrageDetail(Model model, @RequestParam(name = "ouvrageId") Integer ouvrageId){

        OuvrageType ouvrageType = ouvrageService.ouvrageById(ouvrageId);
        List<LivreType> livreTypeListDispo = ouvrageService.nombreDeLivreDispo(ouvrageType.getLivres());

        model.addAttribute("livreTypeListDispo", livreTypeListDispo);
        model.addAttribute("ouvrageDetail", ouvrageType);

        return "ouvrage/ouvrageDetail";
    }


    @RequestMapping(value = "/ouvragesByGenre", method = RequestMethod.GET)
    public String ouvragesByGenre(Model model, @RequestParam(name = "motCle") String motCle){

        List<OuvrageType> ouvrageTypeList = ouvrageService.ouvragesByGenreList(motCle);

        model.addAttribute("ouvrageList", ouvrageTypeList);

        return "ouvrage/ouvrageList";
    }
}
