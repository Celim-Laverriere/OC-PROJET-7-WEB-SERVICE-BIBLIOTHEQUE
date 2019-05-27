package org.bibliotheque.client;

import org.bibliotheque.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.SoapFaultClientException;

public class CompteClient extends WebServiceGatewaySupport {

    private static final Logger logger = LoggerFactory.getLogger(OuvrageClient.class);

    /**
     * ==== CETTE METHODE RECUPERER UN COMPTE CLIENT PAR SON IDENTIFIANT ====
     * @param id
     * @return LES INFORMATIONS D'UN COMPTE
     */
    public GetCompteByIdResponse getCompteById(Integer id){

        GetCompteByIdResponse response = new GetCompteByIdResponse();

        try{
            GetCompteByIdRequest request = new GetCompteByIdRequest();
            request.setCompteId(id);
            response = (GetCompteByIdResponse) getWebServiceTemplate().marshalSendAndReceive(request);
        } catch (SoapFaultClientException pEX){
            logger.error("GetCompteByIdResponse : {}", pEX.toString());
        }

        return response;
    }


    /* ==== GET ALL COMPTES ==== */
    public GetAllComptesResponse getAllComptes(){
        GetAllComptesRequest request = new GetAllComptesRequest();
        return (GetAllComptesResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    /* ==== ADD COMPTE ==== */
    public AddCompteResponse addCompte(CompteType compteType){
        AddCompteRequest request = new AddCompteRequest();
        request.setCompteType(compteType);
        return (AddCompteResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    /* ==== UPDATE COMPTE ==== */
    public UpdateCompteResponse updateCompte(CompteType compteType){
        UpdateCompteRequest request = new UpdateCompteRequest();
        request.setCompteType(compteType);
        return (UpdateCompteResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    /* ==== DELETE COMPTE ==== */
    public DeleteCompteResponse deleteCompte(Integer id){
        DeleteCompteRequest request = new DeleteCompteRequest();
        request.setCompteId(id);
        return (DeleteCompteResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
}
