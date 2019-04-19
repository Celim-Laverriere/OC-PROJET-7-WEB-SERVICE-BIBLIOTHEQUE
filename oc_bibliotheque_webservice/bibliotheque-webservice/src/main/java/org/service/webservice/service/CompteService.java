package org.service.webservice.service;

import org.service.business.contract.ManagerFactory;
import org.service.webservice.AbstractWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "Compte")
public class CompteService extends AbstractWebService{

    @Inject
    private ManagerFactory managerFactory;



    @WebMethod(operationName = "compte")
    public String compte(){
        String user = getManagerFactory().getCompteManager().nomPrenom();
//        String user = getManagerFactory2().getCompteManager().nomPrenom();
        String user2 = "Théo Laverriere";
        System.out.println(user);
        return user;
    }

//    public static void main (String[] args){
//        CompteService compteService = new CompteService();
//            System.out.println(compteService.compte());
////        ApplicationContext context = new AnnotationConfigApplicationContext("org.service");
////        CompteManager compteManager= context.getBean(CompteManager.class);
////        String user = compteManager.nomPrenom();
////        System.out.println(user);
//    }


}
