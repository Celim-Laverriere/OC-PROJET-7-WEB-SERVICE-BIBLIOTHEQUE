package org.bibliotheque.controller;
import org.bibliotheque.service.EmpruntService;
import org.bibliotheque.service.OuvrageService;
import org.bibliotheque.wsdl.OuvrageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

@Controller
public class AccueilController {

    private static final Logger logger = LoggerFactory.getLogger(OuvrageController.class);

    @Autowired
    private OuvrageService ouvrageService;


    @RequestMapping(value = "/")
    public String accueil(Model model, HttpSession session){

        List<OuvrageType> ouvrageTypeList = ouvrageService.ouvrageTypeList();

        Set<String> genresSet = ouvrageService.ouvrageGenreList(ouvrageTypeList);
        Set<String> auteursSet = ouvrageService.ouvrageAuteurList(ouvrageTypeList);

        session.setAttribute("genreList", genresSet);
        session.setAttribute("auteurList", auteursSet);


//        Set<String> listAutoCompletion = new HashSet<>();
//
//        List<OuvrageType> ouvrageTypeList = ouvrageService.ouvrageTypeList();
//
//        for (OuvrageType ouvrageType : ouvrageTypeList){
//           listAutoCompletion.add(ouvrageType.getAuteur());
//           listAutoCompletion.add(ouvrageType.getTitre());
//        }
//
//        model.addAttribute("listAutoCompletion", listAutoCompletion);


        return "accueil";
    }
}
