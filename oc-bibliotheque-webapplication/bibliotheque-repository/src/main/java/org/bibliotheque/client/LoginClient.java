package org.bibliotheque.client;

import org.bibliotheque.wsdl.LoginRequest;
import org.bibliotheque.wsdl.LoginResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class LoginClient extends WebServiceGatewaySupport {


    /* ==== GET COMPTE BY MAIL FRO LOGIN ==== */
    public LoginResponse login(String mail){
        LoginRequest request = new LoginRequest();
        request.setMail(mail);
        return (LoginResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
}
