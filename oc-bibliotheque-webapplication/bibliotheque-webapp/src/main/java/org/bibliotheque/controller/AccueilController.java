package org.bibliotheque.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AccueilController {

    @PreAuthorize("hasAnyRole('USER')")
    @RequestMapping(value = "/")
    public String accueil(final Model model){
        return "accueil";
    }
}
