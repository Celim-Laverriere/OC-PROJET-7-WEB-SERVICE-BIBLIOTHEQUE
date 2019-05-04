package org.bibliotheque.client;

import org.bibliotheque.wsdl.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class CompteClient extends WebServiceGatewaySupport {

    public GetCompteByIdResponse getCompteById(Integer id){
        GetCompteByIdRequest request = new GetCompteByIdRequest();
        request.setCompteId(id);

        return (GetCompteByIdResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    public GetAllComptesResponse getAllComptes(){
        GetAllComptesRequest request = new GetAllComptesRequest();
        return (GetAllComptesResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    public AddCompteResponse addCompte(CompteType compteType){
        AddCompteRequest request = new AddCompteRequest();
        request.setCompteType(compteType);
        return (AddCompteResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    public DeleteCompteResponse deleteCompte(Integer id){
        DeleteCompteRequest request = new DeleteCompteRequest();
        request.setId(id);
        return (DeleteCompteResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    public UpdateCompteResponse updateCompte(CompteType compteType){
        UpdateCompteRequest request = new UpdateCompteRequest();
        request.setCompteType(compteType);
        return (UpdateCompteResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
}
