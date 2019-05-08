package org.bibliotheque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccueilController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String accueil(final Model model){
        return "accueil";
    }
}
