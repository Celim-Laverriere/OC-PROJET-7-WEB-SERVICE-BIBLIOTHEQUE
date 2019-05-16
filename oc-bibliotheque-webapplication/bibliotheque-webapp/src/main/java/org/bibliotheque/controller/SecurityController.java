package org.bibliotheque.controller;

import org.bibliotheque.repository.LoginRepository;
import org.bibliotheque.wsdl.CompteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class SecurityController {

    @Autowired
    private LoginRepository loginRepository;

    @RequestMapping(value = "/login")
    public String login(){
        return "login/login";
    }


    @RequestMapping(value = "/loginSuccess")
    public String afterLogin(HttpSession session, HttpServletRequest servletRequest){
        CompteType compteType = loginRepository.getCompteAfterLoginSuccess(servletRequest.getRemoteUser());
        session.setAttribute("user", compteType);
        return "accueil";
    }

}
