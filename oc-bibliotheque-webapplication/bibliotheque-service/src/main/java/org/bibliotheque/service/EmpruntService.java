package org.bibliotheque.service;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import org.bibliotheque.repository.EmpruntRepository;
import org.bibliotheque.repository.LivreRepository;
import org.bibliotheque.repository.OuvrageRepository;
import org.bibliotheque.wsdl.EmpruntType;
import org.bibliotheque.wsdl.LivreType;
import org.bibliotheque.wsdl.OuvrageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeDate.setMonth;
import static jdk.nashorn.internal.objects.NativeDate.setYear;

@Service
public class EmpruntService {

    @Autowired
    private EmpruntRepository empruntRepository;

    @Autowired
    private LivreRepository livreRepository;

    @Autowired
    private OuvrageRepository ouvrageRepository;


    /**
     * GET ALL EMPRUNTS BY ID COMPTE
     * @param id
     * @return Une liste des emprunts d'un compte
     */
    public List<EmpruntType> getAllEmpruntByCompteId(Integer id){
        return empruntRepository.getAllEmpruntByCompteId(id);
    }


    /**
     * CETTE METHODE RECUPERER TOUS LES LIVRES EMPRUNTES PAR UN CLIENT
     * @param empruntTypeList
     * @return UNE LISTE DE LIVRES
     */
    public List<LivreType> livreTypeListEmprunter(List<EmpruntType> empruntTypeList){

        List<LivreType> livreTypeList = new ArrayList<>();

        for (EmpruntType empruntType : empruntTypeList){
            LivreType livreType = livreRepository.livreById(empruntType.getLivreId());
            livreTypeList.add(livreType);
        }

        return livreTypeList;
    }

    /**
     * CETTE METHODE RECUPERER TOUS LES OUVRAGES DES LIVRES EMPRUNTES PAR LE CLIENT
     * @param livreTypeList
     * @return UNE LISTE D'OUVRAGES
     */
    public List<OuvrageType> ouvrageTypeListEmprunter(List<LivreType> livreTypeList){

        List<OuvrageType> ouvrageTypeList = new ArrayList<>();

        for (LivreType livreType : livreTypeList){
            OuvrageType ouvrageType = ouvrageRepository.ouvrageById(livreType.getOuvrageId());
            ouvrageTypeList.add(ouvrageType);
        }

        return ouvrageTypeList;
    }

//    public List<EmpruntType> formatDate(List<EmpruntType> empruntTypeList) throws DatatypeConfigurationException {
//
//        List<EmpruntType> empruntTypes = new ArrayList<>();
//
//        for (EmpruntType empruntType : empruntTypeList){
//
//        }
//
//        return empruntTypes;
//    }


    /**
     * CETTE METHODE MET A JOUR LA DATE DE FIN D'UN EMPRUNT SUITE A UNE PROLONGATION DE CELUI-CI
     * @param empruntId
     * @return
     */
    public String upEmpruntProlongation(Integer empruntId) throws DatatypeConfigurationException, ParseException {

        EmpruntType empruntType = empruntRepository.getEmpruntById(empruntId);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(empruntType.getDateFin().toString());

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(GregorianCalendar.WEEK_OF_MONTH, 4);
        XMLGregorianCalendar dateProlongation = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        empruntType.setDateFin(dateProlongation);
        empruntType.setProlongation(true);

        String statusCode = empruntRepository.upEmpruntType(empruntType);

        return statusCode;
    }
}
