package org.bibliotheque.endpoint;

import com.bibliotheque.gs_ws.*;
import lombok.NoArgsConstructor;
import org.bibliotheque.entity.EmpruntEntity;
import org.bibliotheque.service.contract.EmpruntService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@Endpoint
@NoArgsConstructor
public class EmpruntEndpoint  {

    public static final String NAMESPACE_URI = "http://www.webservice.org/bibliotheque-ws";

    private EmpruntService service;

    @Autowired
    public EmpruntEndpoint(EmpruntService service) {
        this.service = service;
    }

    /**
     * @param request
     * @return Un emprunt par son ID.
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmpruntByIdRequest")
    @ResponsePayload
    public GetEmpruntByIdResponse getEmpruntById(@RequestPayload GetEmpruntByIdRequest request){
        GetEmpruntByIdResponse response = new GetEmpruntByIdResponse();
        EmpruntEntity empruntEntity = service.getEmpruntById(request.getEmpruntId());
        EmpruntType empruntType = new EmpruntType();
        BeanUtils.copyProperties(empruntEntity, empruntType);
        response.setEmpruntType(empruntType);
        return response;
    }


    /**
     * @param request
     * @return Tout les emprunts.
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllEmpruntRequest")
    @ResponsePayload
    public GetAllEmpruntResponse getAllEmprunt(@RequestPayload GetAllEmpruntRequest request){
        GetAllEmpruntResponse response = new GetAllEmpruntResponse();
        List<EmpruntType> empruntTypeList = new ArrayList<>();
        List<EmpruntEntity> empruntEntityList = service.getAllEmprunts();

        for (EmpruntEntity entity : empruntEntityList){
            EmpruntType empruntType = new EmpruntType();
            BeanUtils.copyProperties(entity, empruntType);
            empruntTypeList.add(empruntType);
        }

        response.getEmpruntType().addAll(empruntTypeList);
        return response;
    }


    /**
     * @param request id
     * @return La liste des emprunts d'un compte.
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllEmpruntByCompteIdRequest")
    @ResponsePayload
    public GetAllEmpruntByCompteIdResponse getAllEmpruntByCompteId(@RequestPayload GetAllEmpruntByCompteIdRequest request) throws DatatypeConfigurationException {
        GetAllEmpruntByCompteIdResponse response = new GetAllEmpruntByCompteIdResponse();
        List<EmpruntEntity> empruntEntityList = service.getAllEmpruntByCompteId(request.getId());
        List<EmpruntType> empruntTypeList = new ArrayList<>();

        GregorianCalendar calendar = new GregorianCalendar();

        for (EmpruntEntity entity : empruntEntityList){
            EmpruntType empruntType = new EmpruntType();

            calendar.setGregorianChange(entity.getDateDebut());
            XMLGregorianCalendar dateDebut = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);

            calendar.setGregorianChange(entity.getDateFin());
            XMLGregorianCalendar dateFin = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);

            empruntType.setId(entity.getId());
            empruntType.setDateDebut(dateDebut);
            empruntType.setDateFin(dateFin);
            empruntType.setProlongation(entity.getProlongation());
            empruntType.setCompteId(entity.getCompteId());
            empruntType.setLivreId(entity.getLivreId());

            empruntTypeList.add(empruntType);
        }

        response.getEmpruntType().addAll(empruntTypeList);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addEmpruntRequest")
    @ResponsePayload
    public AddEmpruntResponse addEmprunt(@RequestPayload AddEmpruntRequest request){
        AddEmpruntResponse response = new AddEmpruntResponse();
        EmpruntType newEmpruntType = new EmpruntType();
        EmpruntEntity newEmpruntEntity = new EmpruntEntity();
        ServiceStatus serviceStatus = new ServiceStatus();

        BeanUtils.copyProperties(request.getEmpruntType(), newEmpruntEntity);
        EmpruntEntity savedEmpruntEntity = service.addEmprunt(newEmpruntEntity);

        if(savedEmpruntEntity == null){
            serviceStatus.setStatusCode("CONFLICT");
            serviceStatus.setMessage("Exception while adding Entity");
        } else {

            BeanUtils.copyProperties(savedEmpruntEntity, newEmpruntType);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Content Added Successfully");
        }

        response.setEmpruntType(newEmpruntType);
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateEmpruntRequest")
    @ResponsePayload
    public UpdateEmpruntResponse updateEmprunt(@RequestPayload UpdateEmpruntRequest request){
        UpdateEmpruntResponse response = new UpdateEmpruntResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        // 1. Trouver si l'emprunt est disponible
        EmpruntEntity upEmprunt = service.getEmpruntById(request.getEmpruntType().getId());

        if (upEmprunt == null){
            serviceStatus.setStatusCode("NOT FOUND");
            serviceStatus.setMessage("Emprunt : " + request.getEmpruntType().getId() + " not found");
        } else {

            // 2. Obtenir les informations de l'emprunt à mettre à jour à partir de la requête
            BeanUtils.copyProperties(request.getEmpruntType(), upEmprunt);

            // 3. Mettre à jour l'emprunt dans la base de données
            boolean flag = service.updateEmprunt(upEmprunt);

            if(flag == false){
                serviceStatus.setStatusCode("CONFLICT");
                serviceStatus.setMessage("Exception while updating Entity : " + request.getEmpruntType().getId());
            } else {
                serviceStatus.setStatusCode("SUCCESS");
                serviceStatus.setMessage("Content updated Successfully");
            }
        }

        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteEmpruntRequest")
    @ResponsePayload
    public DeleteEmpruntResponse deleteEmprunt(@RequestPayload DeleteEmpruntRequest request){
        DeleteEmpruntResponse response = new DeleteEmpruntResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        boolean flag = service.deleteEmprunt(request.getEmpruntId());

        if (flag == false){
            serviceStatus.setStatusCode("FAIL");
            serviceStatus.setMessage("Exception while deletint Entity id : " + request.getEmpruntId());
        } else {
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Content Deleted Successfully");
        }

        response.setServiceStatus(serviceStatus);
        return response;
    }

}
