package batch;

import org.bibliotheque.wsdl.EmpruntType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class MailResaProcessor implements ItemProcessor<EmpruntType, EmpruntType> {


    private static final Logger logger = LoggerFactory.getLogger(MailResaProcessor.class);

    @Override
    public EmpruntType process(EmpruntType empruntType) throws Exception {
        return null;
    }
}
