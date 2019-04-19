package org.service.webservice.service;

import org.service.model.bean.Livre;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "LivreService")
public class LivreService {



    @WebMethod
    public List<Livre> listLivre(){

        return null;
    }
}
