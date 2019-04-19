package org.service.webservice;

import org.service.business.contract.ManagerFactory;
import org.service.business.contract.manager.CompteManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class AbstractWebService {

   ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/webserviceContext.xml");
   private ManagerFactory managerFactory = context.getBean("managerFactory", ManagerFactory.class);

    public ManagerFactory getManagerFactory() {
        return managerFactory;
    }

    public void setManagerFactory(ManagerFactory managerFactory) {
        this.managerFactory = managerFactory;
    }

//
//    ApplicationContext context2 = new AnnotationConfigApplicationContext("org.service");
//    private ManagerFactory managerFactory2 = context2.getBean("managerFactory", ManagerFactory.class);
//
//    public ManagerFactory getManagerFactory2() {
//        return managerFactory2;
//    }
//
//    public void setManagerFactory2(ManagerFactory managerFactory2) {
//        this.managerFactory2 = managerFactory2;
//    }

//    private ManagerFactory managerFactory;
//
//    public ManagerFactory getManagerFactory() {
//        return managerFactory;
//    }
//
//    public void setManagerFactory(ManagerFactory managerFactory) {
//        this.managerFactory = managerFactory;
//    }
}
