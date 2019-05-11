package org.bibliotheque.endpoint;

import com.bibliotheque.gs_ws.CompteType;
import com.bibliotheque.gs_ws.LoginRequest;
import com.bibliotheque.gs_ws.LoginResponse;
import com.bibliotheque.gs_ws.ServiceStatus;
import lombok.NoArgsConstructor;
import org.bibliotheque.entity.CompteEntity;
import org.bibliotheque.service.contract.LoginService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.transaction.Transactional;

@Endpoint
@NoArgsConstructor
public class LoginEndpoint {

    public static final String NAMESPACE_URI = "http://www.webservice.org/bibliotheque-ws";

    private LoginService service;

    @Autowired
    public LoginEndpoint(LoginService service){
        this.service = service;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "loginRequest")
    @ResponsePayload
    @Transactional
    public LoginResponse loginResponse(@RequestPayload LoginRequest request){
        LoginResponse response = new LoginResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        CompteEntity compteEntity = service.getCompteByMail(request.getMail());
        CompteType compteType = new CompteType();

        if (compteEntity == null){
            serviceStatus.setStatusCode("CONFLICT");
            serviceStatus.setMessage("Exception while search Entity");
        } else {
            BeanUtils.copyProperties(compteEntity, compteType);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Content search Successfully");
        }

        response.setCompteType(compteType);
        response.setServiceStatus(serviceStatus);
        return response;
    }
}
