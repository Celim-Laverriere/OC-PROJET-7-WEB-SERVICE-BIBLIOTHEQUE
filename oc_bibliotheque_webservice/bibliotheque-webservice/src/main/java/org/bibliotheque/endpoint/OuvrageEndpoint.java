package org.bibliotheque.endpoint;

import com.bibliotheque.gs_ws.*;
import lombok.NoArgsConstructor;
import org.bibliotheque.entity.OuvrageEntity;
import org.bibliotheque.service.contract.OuvrageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
@NoArgsConstructor
public class OuvrageEndpoint {

    public static final String NAMESPACE_URI = "http://www.webservice.org/bibliotheque-ws";

    private OuvrageService service;

    @Autowired
    public OuvrageEndpoint(OuvrageService service){
        this.service = service;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOuvrageByIdRequest")
    @ResponsePayload
    public GetOuvrageByIdResponse getOuvrageById(@RequestPayload GetOuvrageByIdRequest request){
        GetOuvrageByIdResponse response = new GetOuvrageByIdResponse();
        OuvrageEntity ouvrageEntity = service.getOuvrageById(request.getOuvrageId());
        OuvrageType ouvrageType = new OuvrageType();
        BeanUtils.copyProperties(ouvrageEntity, ouvrageType);
        response.setOuvrageType(ouvrageType);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllOuvragesRequest")
    @ResponsePayload
    public GetAllOuvragesResponse getAllOuvrages(@RequestPayload GetAllOuvragesRequest request){
        GetAllOuvragesResponse response = new GetAllOuvragesResponse();
        List<OuvrageType> ouvrageTypeList = new ArrayList<>();
        List<OuvrageEntity> ouvrageEntityList = service.getAllOuvrages();

        for (OuvrageEntity entity : ouvrageEntityList){
            OuvrageType ouvrageType = new OuvrageType();
            BeanUtils.copyProperties(entity, ouvrageType);
            ouvrageTypeList.add(ouvrageType);
        }

        response.getOuvrageType().addAll(ouvrageTypeList);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addOuvrageRequest")
    @ResponsePayload
    public AddOuvrageResponse addOuvrage(@RequestPayload AddOuvrageRequest request){
        AddOuvrageResponse response = new AddOuvrageResponse();
        OuvrageType newOuvrageType = new OuvrageType();
        ServiceStatus serviceStatus = new ServiceStatus();
        OuvrageEntity newOuvrageEntity = new OuvrageEntity();

        BeanUtils.copyProperties(request.getOuvrageType(), newOuvrageEntity);
        OuvrageEntity savedOuvrageEntity = service.addOuvrage(newOuvrageEntity);

        if(savedOuvrageEntity == null){
            serviceStatus.setStatusCode("CONFLICT");
            serviceStatus.setMessage("Exception while adding Entity");
        } else {

            BeanUtils.copyProperties(savedOuvrageEntity, newOuvrageType);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Content Added Successfully");
        }

        response.setOuvrageType(newOuvrageType);
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateOuvrageRequest")
    @ResponsePayload
    public UpdateOuvrageResponse updateOuvrage(@RequestPayload UpdateOuvrageRequest request){
        UpdateOuvrageResponse response = new UpdateOuvrageResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        // 1. Trouver si le ouvrage est disponible
        OuvrageEntity upOuvrage = service.getOuvrageById(request.getOuvrageType().getId());

        if(upOuvrage == null){
            serviceStatus.setStatusCode("NOT FOUND");
            serviceStatus.setMessage("Ouvrage : " + request.getOuvrageType().getTitre() + " " +
                    request.getOuvrageType().getRef() + " " + " not found");
        } else {

            // 2. Obtenir les informations du compte à mettre à jour à partir de la requête
            BeanUtils.copyProperties(request.getOuvrageType(), upOuvrage);

            // 3. Mettre à jour le compte dans la base de données
            boolean flag = service.updateOuvrage(upOuvrage);

            if(flag == false){
                serviceStatus.setStatusCode("CONFLICT");
                serviceStatus.setMessage("Exception while updating Entity : " + request.getOuvrageType().getTitre() + " " +
                        request.getOuvrageType().getRef());
            } else {
                serviceStatus.setStatusCode("SUCCESS");
                serviceStatus.setMessage("Content updated Successfully");
            }
        }

        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteOuvrageRequest")
    @ResponsePayload
    public DeleteOuvrageResponse deleteOuvrage(@RequestPayload DeleteOuvrageRequest request){
        DeleteOuvrageResponse response = new DeleteOuvrageResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        boolean flag = service.deleteOuvrage(request.getOuvrageId());

        if(flag == false){
            serviceStatus.setStatusCode("FAIL");
            serviceStatus.setMessage("Exception while deletint Entity id : " + request.getOuvrageId());
        } else {
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Content Deleted Successfully");
        }

        response.setServiceStatus(serviceStatus);
        return response;
    }
}