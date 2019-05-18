package org.bibliotheque.client;

import org.bibliotheque.wsdl.GetAllEmpruntByCompteIdRequest;
import org.bibliotheque.wsdl.GetAllEmpruntByCompteIdResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class EmpruntClient extends WebServiceGatewaySupport {

    /* ==== GET ALL EMPRUNTS BY ID COMPTE ==== */
    public GetAllEmpruntByCompteIdResponse getAllEmpruntByCompteId(Integer id){
        GetAllEmpruntByCompteIdRequest request = new GetAllEmpruntByCompteIdRequest();
        request.setId(id);
        return (GetAllEmpruntByCompteIdResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
}
