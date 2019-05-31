package org.bibliotheque.controller;

import org.bibliotheque.wsdl.ServiceStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;

@Controller
public class SecurityController {

    private static final Logger logger = LoggerFactory.getLogger(SecurityController.class);


    @RequestMapping(value = "/login")
    public String login(Model model, HttpSession session, @RequestParam(value = "actionUser", defaultValue = "noActionUser") String actionUser){

        String returnLogin;
        String serviceStatus = (String) session.getAttribute("loginError");

        if (serviceStatus == null){
            serviceStatus = "Undefined";
        }

        if (actionUser.equals("loginUser")){
            returnLogin = "login/login";
        } else {

            if (serviceStatus.equals("CONFLICT")){
                model.addAttribute("accessConflict", serviceStatus);

                serviceStatus = null;
                session.setAttribute("loginError", serviceStatus);

                returnLogin = "login/login";
            } else {
                logger.error("Methode login : error 403 !");
                returnLogin = "error/403";
            }
        }

        return returnLogin;
    }


    @RequestMapping(value = "/loginSuccess")
    public String afterLogin(){
        return "accueil";
    }



}
