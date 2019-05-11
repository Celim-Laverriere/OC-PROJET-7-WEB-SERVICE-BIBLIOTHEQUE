package org.bibliotheque.repository;

import org.bibliotheque.client.LoginClient;
import org.bibliotheque.wsdl.CompteType;
import org.bibliotheque.wsdl.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class LoginRepository {

    @Autowired
    private LoginClient client;

    /* ==== GET COMPTE BY MAIL FRO LOGIN ==== */
    public Optional<CompteType> loginCompte(String mail){
        LoginResponse response = client.login(mail);
        return Optional.ofNullable(response.getCompteType());
    }
}
