package batch;

import org.bibliotheque.wsdl.EmpruntType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;



public class MailItemProcessor implements ItemProcessor<EmpruntType, EmpruntType> {


    private static final Logger logger = LoggerFactory.getLogger(MailItemProcessor.class);


    @Override
    public EmpruntType process(EmpruntType empruntType) throws Exception {
        System.out.println("Test batch");


        System.out.println(empruntType.getDateDebut() + " : " + empruntType.getDateFin());

        return null;
    }
}
