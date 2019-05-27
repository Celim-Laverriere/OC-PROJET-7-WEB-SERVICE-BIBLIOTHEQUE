package org.bibliotheque.client;

import org.bibliotheque.wsdl.GetAllPhotosRequest;
import org.bibliotheque.wsdl.GetAllPhotosResponse;
import org.bibliotheque.wsdl.GetPhotoByIdRequest;
import org.bibliotheque.wsdl.GetPhotoByIdResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.SoapFaultClientException;

public class PhotoClient extends WebServiceGatewaySupport {

    private static final Logger logger = LoggerFactory.getLogger(OuvrageClient.class);


    /**
     * ==== GET PHOTO BY ID ====
     * @param id
     * @return GetPhotoByIdResponse
     */
    public GetPhotoByIdResponse getPhotoById(Integer id){

        GetPhotoByIdResponse response = new GetPhotoByIdResponse();

        try{
            GetPhotoByIdRequest request = new GetPhotoByIdRequest();
            request.setPhotoId(id);
            response = (GetPhotoByIdResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        } catch (SoapFaultClientException pEX){
            logger.error("GetPhotoByIdResponse : {}", pEX.toString());
        }

        return response;
    }


    /**
     * ==== GET ALL PHOTOS ====
     * @return GetAllPhotosResponse
     */
    public GetAllPhotosResponse getAllPhotos(){

        GetAllPhotosResponse response = new GetAllPhotosResponse();

        try{
            GetAllPhotosRequest request = new GetAllPhotosRequest();
            response = (GetAllPhotosResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        } catch (SoapFaultClientException pEX){
            logger.error("GetAllPhotosResponse : {}", pEX.toString());
        }

        return response;
    }
}
