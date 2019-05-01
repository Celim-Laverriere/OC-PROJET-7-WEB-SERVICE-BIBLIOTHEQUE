package org.bibliotheque.config;

import org.bibliotheque.client.LivreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this is the package name specified in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("org.bibliotheque.wsdl");
        return marshaller;
    }

    @Bean
    public LivreClient livreClient(Jaxb2Marshaller marshaller) {
        LivreClient client = new LivreClient();
        client.setDefaultUri("http://localhost:8088/ws/bibliotheque.wsdl");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
