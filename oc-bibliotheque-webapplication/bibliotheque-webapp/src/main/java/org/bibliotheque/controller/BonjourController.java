package org.bibliotheque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BonjourController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String afficherBonjour(final ModelMap pModel){
        pModel.addAttribute("personne", "Théo");
        pModel.addAttribute("nom","Laverriere");
        return "bonjour";
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String AfficherMessage(final ModelMap modelMap){
        modelMap.addAttribute("message", "un super message pour commencer");
        return "msg";
    }
}
