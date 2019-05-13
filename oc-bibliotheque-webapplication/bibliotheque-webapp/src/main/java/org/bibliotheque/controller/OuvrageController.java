package org.bibliotheque.controller;

import org.bibliotheque.service.OuvrageService;
import org.bibliotheque.wsdl.OuvrageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class OuvrageController {


    @Autowired
    private OuvrageService ouvrageService;


    @RequestMapping(value = "/ouvrages", method = RequestMethod.GET)
    public String ouvrages(final Model model){
        List<OuvrageType> ouvrageTypeList = ouvrageService.ouvrageTypeList();
        model.addAttribute("ouvrageList", ouvrageTypeList);
        return "ouvrage/ouvrageList";
    }

    @Secured(value = "ROLE_ADMIN")
    @RequestMapping(value = "/ouvrage", method = RequestMethod.GET)
    public String ouvrageDetail(OuvrageType ouvrageType, Model model, @RequestParam(name = "ouvrageId") Integer ouvrageId){
        ouvrageType = ouvrageService.ouvrageById(ouvrageId);
        model.addAttribute("ouvrageDetail", ouvrageType);
        return "ouvrage/ouvrageDetail";
    }
}
