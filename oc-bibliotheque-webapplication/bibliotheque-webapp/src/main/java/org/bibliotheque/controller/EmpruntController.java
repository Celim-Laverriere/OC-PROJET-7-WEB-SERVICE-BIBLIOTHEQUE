package org.bibliotheque.controller;

import org.bibliotheque.security.entity.Users;
import org.bibliotheque.service.EmpruntService;
import org.bibliotheque.service.LivreService;
import org.bibliotheque.service.OuvrageService;
import org.bibliotheque.wsdl.CompteType;
import org.bibliotheque.wsdl.EmpruntType;
import org.bibliotheque.wsdl.LivreType;
import org.bibliotheque.wsdl.OuvrageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.RedirectViewControllerRegistration;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


import javax.servlet.http.HttpSession;
import javax.swing.*;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Controller
public class EmpruntController {


    @Autowired
    private EmpruntService empruntService;


    @RequestMapping(value = "/emprunt", method = RequestMethod.GET)
    public String getAllEmpruntByCompteId(Model model, @RequestParam(name = "compteId") Integer compteId) {

        System.out.println("test");

        List<EmpruntType> empruntTypeList = empruntService.getAllEmpruntByCompteId(compteId);
        List<LivreType> livreTypeList = empruntService.livreTypeListEmprunter(empruntTypeList);
        List<OuvrageType> ouvrageTypeList = empruntService.ouvrageTypeListEmprunter(livreTypeList);

        model.addAttribute("empruntTypeList", empruntTypeList);
        model.addAttribute("livreTypeList", livreTypeList);
        model.addAttribute("ouvrageTypeList", ouvrageTypeList);

        return "compte/emprunt";
    }

    @RequestMapping(value = "/prolongation", method = RequestMethod.GET)
    public String upEmpruntProlongation(Model model, @RequestParam(name = "empruntId")Integer empruntId, HttpSession session) throws DatatypeConfigurationException, ParseException {

        String statusCode = empruntService.upEmpruntProlongation(empruntId);
       Users users = (Users) session.getAttribute("user");


        return "redirect:/emprunt?compteId=" + users.getUserId();
    }
}
