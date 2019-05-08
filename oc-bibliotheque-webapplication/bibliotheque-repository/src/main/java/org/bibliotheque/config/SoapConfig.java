package org.bibliotheque.config;

import org.bibliotheque.client.CompteClient;
import org.bibliotheque.client.LivreClient;
import org.bibliotheque.client.OuvrageClient;
import org.bibliotheque.client.PhotoClient;
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

    @Bean
    public CompteClient compteClient(Jaxb2Marshaller marshaller){
        CompteClient client = new CompteClient();
        client.setDefaultUri("http://localhost:8088/ws/bibliotheque.wsdl");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    @Bean
    public OuvrageClient ouvrageClient(Jaxb2Marshaller marshaller){
        OuvrageClient client = new OuvrageClient();
        client.setDefaultUri("http://localhost:8088/ws/bibliotheque.wsdl");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    @Bean
    public PhotoClient photoClient(Jaxb2Marshaller marshaller) {
        PhotoClient client = new PhotoClient();
        client.setDefaultUri("http://localhost:8088/ws/bibliotheque.wsdl");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
