package org.bibliotheque.client;

import org.bibliotheque.wsdl.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class LoginClient extends WebServiceGatewaySupport {


    /* ==== GET COMPTE BY MAIL AND PASSWORD FOR LOGIN ==== */
    public LoginResponse login(String mail, String password){
        LoginRequest request = new LoginRequest();
        request.setMail(mail);
        request.setPassword(password);
        return (LoginResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    /* ==== GET COMPTE AFTER LOGIN SUCCESS ==== */
    public GetCompteAfterLoginSuccessResponse getCompteAfterLoginSuccess(String mail){
        GetCompteAfterLoginSuccessRequest request = new GetCompteAfterLoginSuccessRequest();
        request.setMail(mail);
        return (GetCompteAfterLoginSuccessResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
}
