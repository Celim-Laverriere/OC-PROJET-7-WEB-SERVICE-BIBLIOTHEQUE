package org.bibliotheque.controller;

import org.bibliotheque.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

    @Autowired
    private LoginRepository loginRepository;

    @RequestMapping(value = "/login")
    public String login(){
        return "login/login";
    }

    @RequestMapping(value = "/loginSuccess")
    public String afterLogin(){
        return "accueil";
    }

}
