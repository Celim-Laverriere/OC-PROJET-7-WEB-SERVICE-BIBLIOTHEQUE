package org.bibliotheque.controller;

import org.bibliotheque.service.LivreService;
import org.bibliotheque.service.OuvrageService;
import org.bibliotheque.wsdl.LivreType;
import org.bibliotheque.wsdl.OuvrageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class LivreController {

    @Autowired
    private LivreService livreService;

    @Autowired
    private OuvrageService ouvrageService;

    @RequestMapping(value = "livres", method = RequestMethod.GET)
    public String AfficherMessage(final ModelMap modelMap){
        List<LivreType> livreTypeList = livreService.livreTypeList();
        modelMap.addAttribute("livres", livreTypeList);
        List<OuvrageType> ouvrageTypeList = ouvrageService.ouvrageTypeList();

        for (OuvrageType ouvrage : ouvrageTypeList) {
            for (LivreType livre : livreTypeList) {

                if (ouvrage.getId() == livre.getOuvrageId()){
                    System.out.println(ouvrage.getTitre());
                    System.out.println(ouvrage.getAuteur());
                    System.out.println(livre.getRefBibliotheque());
                    System.out.println(livre.getOuvrageId());
                }
            }
        }

        modelMap.addAttribute("ouvrages", ouvrageTypeList);
        return "ouvrageList";
    }
}
