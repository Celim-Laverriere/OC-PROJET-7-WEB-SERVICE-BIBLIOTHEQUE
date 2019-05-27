package org.bibliotheque.client;

import org.bibliotheque.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.SoapFaultClientException;

public class OuvrageClient extends WebServiceGatewaySupport {

    private static final Logger logger = LoggerFactory.getLogger(OuvrageClient.class);

    /**
     * ==== GET OUVRAGE BY ID ====
     * @param id
     * @return GetOuvrageByIdResponse
     */
    public GetOuvrageByIdResponse getOuvrageById(Integer id){

        GetOuvrageByIdResponse response = new GetOuvrageByIdResponse();

        try{
            GetOuvrageByIdRequest request = new GetOuvrageByIdRequest();
            request.setOuvrageId(id);
            response = (GetOuvrageByIdResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        } catch (SoapFaultClientException pEX){
            logger.error("GetOuvrageByIdResponse : {}", pEX.toString());
        }

        return response;
    }


    /**
     * ==== GET ALL OUVRAGES ====
     * @return GetAllOuvragesResponse
     */
    public GetAllOuvragesResponse getAllOuvrages(){

        GetAllOuvragesResponse response = new GetAllOuvragesResponse();

        try{
            GetAllOuvragesRequest request = new GetAllOuvragesRequest();
            response = (GetAllOuvragesResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        } catch (SoapFaultClientException pEX){
            logger.error("GetAllOuvragesResponse : {}", pEX.toString());
        }

        return response;
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
