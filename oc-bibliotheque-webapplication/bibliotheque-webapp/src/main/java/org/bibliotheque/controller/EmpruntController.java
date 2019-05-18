package org.bibliotheque.controller;

import org.bibliotheque.service.EmpruntService;
import org.bibliotheque.service.LivreService;
import org.bibliotheque.service.OuvrageService;
import org.bibliotheque.wsdl.EmpruntType;
import org.bibliotheque.wsdl.LivreType;
import org.bibliotheque.wsdl.OuvrageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class EmpruntController {


    @Autowired
    private EmpruntService empruntService;


    @RequestMapping(value = "/emprunt", method = RequestMethod.GET)
    public String getAllEmpruntByCompteId(Model model, @RequestParam(name = "compteId") Integer compteId){

        List<EmpruntType> empruntTypeList = empruntService.getAllEmpruntByCompteId(compteId);
        List<LivreType> livreTypeList = empruntService.livreTypeListEmprunter(empruntTypeList);
        List<OuvrageType> ouvrageTypeList = empruntService.ouvrageTypeListEmprunter(livreTypeList);

        model.addAttribute("empruntTypeList", empruntTypeList);
        model.addAttribute("livreTypeList", livreTypeList);
        model.addAttribute("ouvrageTypeList", ouvrageTypeList);

        return "compte/emprunt";
    }
}
