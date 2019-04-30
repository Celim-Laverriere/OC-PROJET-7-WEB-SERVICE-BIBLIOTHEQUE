package org.bibliotheque.endpoint;

import com.bibliotheque.gs_ws.*;
import org.bibliotheque.entity.LivreEntity;
import org.bibliotheque.service.LivreService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class BibliothequeEndpoint {

    public static final String NAMESPACE_URI = "http://www.webservice.org/bibliotheque-ws";

    private LivreService service;

    public BibliothequeEndpoint(){

    }

    @Autowired
    public BibliothequeEndpoint(LivreService service){
        this.service = service;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLivresByIdRequest")
    @ResponsePayload
    public GetLivresByIdResponse getLivreById(@RequestPayload GetLivresByIdRequest request){
        GetLivresByIdResponse response = new GetLivresByIdResponse();
        LivreEntity livreEntity = service.getLivreById(request.getLivreId());
        LivreType livreType = new LivreType();
        BeanUtils.copyProperties(livreEntity, livreType);
        response.setLivreType(livreType);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllLivresRequest")
    @ResponsePayload
    public GetAllLivresResponse getAllLivre(@RequestPayload GetAllLivresRequest request){
        GetAllLivresResponse response = new GetAllLivresResponse();
        List<LivreType> livreTypeList = new ArrayList<LivreType>();
        List<LivreEntity> livreEntityList = service.getAllLivres();
        for (LivreEntity entity : livreEntityList){
            LivreType livreType = new LivreType();
            BeanUtils.copyProperties(entity, livreType);
            livreTypeList.add(livreType);
        }
        response.getLivreType().addAll(livreTypeList);
        return response;
    }
}
