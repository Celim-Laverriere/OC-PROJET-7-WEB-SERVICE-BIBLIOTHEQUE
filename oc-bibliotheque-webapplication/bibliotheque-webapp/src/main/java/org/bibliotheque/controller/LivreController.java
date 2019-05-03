package org.bibliotheque.controller;

import org.bibliotheque.service.LivreService;
import org.bibliotheque.wsdl.CompteType;
import org.bibliotheque.wsdl.LivreType;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String afficherBonjour(final ModelMap pModel){
        pModel.addAttribute("personne", "Théo");
//        String livre = livreService.Livres();
//        pModel.addAttribute("livre", livre);
        pModel.addAttribute("nom","Laverriere");
        return "livres";
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String AfficherMessage(final ModelMap modelMap){
        LivreType livreType = livreService.LivreById(5);
        CompteType compteType = new CompteType();
        modelMap.addAttribute("compteType", compteType);
        List<LivreType> livreTypes = livreService.livreTypeList();
        modelMap.addAttribute("livres", livreTypes);

        for (LivreType livre : livreTypes) {
            System.out.println(livre.getRefBibliotheque());
        }
        modelMap.addAttribute("test", livreType.getRefBibliotheque());
        return "msg";
    }
}
