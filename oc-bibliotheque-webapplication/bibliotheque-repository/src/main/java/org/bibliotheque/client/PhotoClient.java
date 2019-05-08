package org.bibliotheque.client;

import org.bibliotheque.wsdl.GetAllPhotosRequest;
import org.bibliotheque.wsdl.GetAllPhotosResponse;
import org.bibliotheque.wsdl.GetPhotoByIdRequest;
import org.bibliotheque.wsdl.GetPhotoByIdResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class PhotoClient extends WebServiceGatewaySupport {


    /* ==== GET PHOTO BY ID ==== */
    public GetPhotoByIdResponse getPhotoById(Integer id){
        GetPhotoByIdRequest request = new GetPhotoByIdRequest();
        request.setPhotoId(id);
        return (GetPhotoByIdResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    /* ==== GET ALL PHOTOS ==== */
    public GetAllPhotosResponse getAllPhotos(){
        GetAllPhotosRequest request = new GetAllPhotosRequest();
        return (GetAllPhotosResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
}
