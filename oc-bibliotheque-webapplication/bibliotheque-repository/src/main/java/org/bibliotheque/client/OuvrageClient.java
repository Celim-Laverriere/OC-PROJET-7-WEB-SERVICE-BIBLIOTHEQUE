package org.bibliotheque.client;

import org.bibliotheque.wsdl.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class OuvrageClient extends WebServiceGatewaySupport {


    /* ==== GET OUVRAGE BY ID ==== */
    public GetOuvrageByIdResponse getOuvrageById(Integer id){
        GetOuvrageByIdRequest request = new GetOuvrageByIdRequest();
        request.setOuvrageId(id);
        return (GetOuvrageByIdResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    /* ==== GET ALL OUVRAGES ==== */
    public GetAllOuvragesResponse getAllOuvrages(){
        GetAllOuvragesRequest request = new GetAllOuvragesRequest();
        return (GetAllOuvragesResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    /* ==== ADD OUVRAGE ==== */
    public AddOuvrageResponse addOuvrage(OuvrageType ouvrageType){
        AddOuvrageRequest request = new AddOuvrageRequest();
        request.setOuvrageType(ouvrageType);
        return (AddOuvrageResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    /* ==== UPDATE OUVRAGE ==== */
    public UpdateOuvrageResponse updateOuvrage(OuvrageType ouvrageType){
        UpdateOuvrageRequest request = new UpdateOuvrageRequest();
        request.setOuvrageType(ouvrageType);
        return (UpdateOuvrageResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    /* ==== DELETE OUVRAGE ==== */
    public DeleteOuvrageResponse deleteOuvrage(Integer id){
        DeleteOuvrageRequest request = new DeleteOuvrageRequest();
        request.setOuvrageId(id);
        return (DeleteOuvrageResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
}
