package org.bibliotheque.client;

import org.bibliotheque.wsdl.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class EmpruntClient extends WebServiceGatewaySupport {

    /* ==== GET ALL EMPRUNTS BY ID COMPTE ==== */
    public GetAllEmpruntByCompteIdResponse getAllEmpruntByCompteId(Integer id){
        GetAllEmpruntByCompteIdRequest request = new GetAllEmpruntByCompteIdRequest();
        request.setId(id);
        return (GetAllEmpruntByCompteIdResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    /* ==== GET EMPRUNT BY ID ==== */
    public GetEmpruntByIdResponse getEmpruntById(Integer id){
        GetEmpruntByIdRequest request = new GetEmpruntByIdRequest();
        request.setEmpruntId(id);
        return (GetEmpruntByIdResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    /* ==== UPDATE EMPRUNT ==== */
    public UpdateEmpruntResponse updateEmprunt(EmpruntType empruntType){
        UpdateEmpruntRequest request = new UpdateEmpruntRequest();
        request.setEmpruntType(empruntType);
        return (UpdateEmpruntResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
}
