package org.bibliotheque.repository;

import org.bibliotheque.client.LoginClient;
import org.bibliotheque.wsdl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class LoginRepository {

    @Autowired
    private LoginClient client;

    /* ==== GET COMPTE BY MAIL FRO LOGIN ==== */
    public Optional<ServiceStatus> loginCompte(String mail, String password){
        LoginResponse response = client.login(mail, password);
        return Optional.ofNullable(response.getServiceStatus());
    }

    /* ==== GET COMPTE AFTER LOGIN SUCCESS ==== */
    public CompteType getCompteAfterLoginSuccess(String mail){
        GetCompteAfterLoginSuccessResponse response = client.getCompteAfterLoginSuccess(mail);
        return response.getCompteType();
    }

}
