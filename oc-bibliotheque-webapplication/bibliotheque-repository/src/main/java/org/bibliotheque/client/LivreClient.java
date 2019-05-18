package org.bibliotheque.client;

import org.bibliotheque.wsdl.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class LivreClient extends WebServiceGatewaySupport {


    /* ==== GET LIVRE BY ID ==== */
    public GetLivreByIdResponse getLivreById(Integer id) {
        GetLivreByIdRequest request = new GetLivreByIdRequest();
        request.setLivreId(id);
        return (GetLivreByIdResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    /* ==== GET ALL LIVRES ==== */
    public GetAllLivresResponse getAllLivres(){
        GetAllLivresRequest request = new GetAllLivresRequest();
        return (GetAllLivresResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    /* ==== ADD LIVRE ==== */
    public AddLivreResponse addLivre(LivreType livreType){
        AddLivreRequest request = new AddLivreRequest();
        request.setLivreType(livreType);
        return (AddLivreResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    /* ==== UPDATE LIVRE ==== */
    public UpdateLivreResponse updateLivre(LivreType livreType){
        UpdateLivreRequest request = new UpdateLivreRequest();
        request.setLivreType(livreType);
        return (UpdateLivreResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    /* ==== DELETE LIVRE ==== */
    public DeleteLivreResponse deleteLivre(Integer id){
        DeleteLivreRequest request = new DeleteLivreRequest();
        request.setLivreId(id);
        return (DeleteLivreResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

}
