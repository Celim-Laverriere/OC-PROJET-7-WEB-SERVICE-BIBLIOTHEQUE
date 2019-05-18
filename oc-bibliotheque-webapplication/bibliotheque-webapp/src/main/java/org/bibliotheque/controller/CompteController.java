package org.bibliotheque.controller;


import org.bibliotheque.service.CompteService;
import org.bibliotheque.wsdl.CompteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class CompteController {

    @Autowired
    private CompteService compteService;

    @Secured(value = "ROLE_USER")
    @RequestMapping(value = "/compte", method = RequestMethod.GET)
    public String compte(){
        return "/compte/compte";
    }

    @RequestMapping(value = "formCompte", method = RequestMethod.GET)
    public String fromCompte(final Model pModel){
        CompteType compteType = new CompteType();
        pModel.addAttribute("compteType", compteType);
        return "msg";
    }


    @RequestMapping(value = "addCompte", method = RequestMethod.POST)
    public String addCompte (@Valid CompteType compteType, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        String message = compteService.addCompte(compteType);
        System.out.println(message);
        return "msg";

    }

    @RequestMapping(value = "delCompte", method = RequestMethod.POST)
    public String delCompte (@Valid CompteType compteType,BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
        String message = compteService.delCompte(compteType.getId());
        System.out.println(message);
        return "msg";
    }

    @Secured(value = "ROLE_USER")
    @RequestMapping(value = "/infoPerso", method = RequestMethod.GET)
    public String formUpCompte(CompteType compteType, @RequestParam(name = "compteId") Integer compteId, Model model){
        compteType = compteService.compteById(compteId);
        model.addAttribute("compteType", compteType);
        return "compte/infoPerso";

    }

    @Secured(value = "ROLE_USER")
    @RequestMapping(value = "/upCompte", method = RequestMethod.POST)
    public String uuCompte(@Valid CompteType compteType, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){
        String message = compteService.upCompte(compteType);
        System.out.println(message);
        return "compte/infoPerso";
    }

}
