package org.bibliotheque.client;

import org.bibliotheque.wsdl.GetAllLivresRequest;
import org.bibliotheque.wsdl.GetAllLivresResponse;
import org.bibliotheque.wsdl.GetLivresByIdRequest;
import org.bibliotheque.wsdl.GetLivresByIdResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;


public class LivreClient extends WebServiceGatewaySupport {


    public GetLivresByIdResponse getLivreById(Integer id) {
        GetLivresByIdRequest request = new GetLivresByIdRequest();
        request.setLivreId(id);

        return (GetLivresByIdResponse) getWebServiceTemplate().marshalSendAndReceive(request);

    }

    public GetAllLivresResponse getAllLivres(){
        GetAllLivresRequest request = new GetAllLivresRequest();

        return (GetAllLivresResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

}
