package org.bibliotheque.controller;


import org.bibliotheque.service.CompteService;
import org.bibliotheque.wsdl.CompteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CompteController {

    @Autowired
    private CompteService compteService;

    @RequestMapping(value = "compte", method = RequestMethod.GET)
    public String getCompteById(final Model pModel){
        CompteType compteType = new CompteType();
        List<CompteType> compteList = compteService.compteList();
        pModel.addAttribute("compteType", compteType);
        pModel.addAttribute("compte", compteList);
        return "msg";
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
        String message = compteService.delCompt(compteType.getId());
        System.out.println(message);
        return "msg";
    }
}
