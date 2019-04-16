package etf.nwt.knjigemikroservis.amqpProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import etf.nwt.knjigemikroservis.model.Kategorija;
import etf.nwt.knjigemikroservis.model.Knjiga;

@Service
public class KategorijaSender {

	private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;
    
    private Logger logger = LoggerFactory.getLogger(KategorijaSender.class);

    @Autowired
    public KategorijaSender(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    public void dodajKategoriju(Kategorija kategorija) {
        this.rabbitTemplate.convertAndSend("rabbitmqkm.dodajkategoriju", kategorija);
        logger.info("Published message '{}'", "poruka poslana za dodavanje kategorije");
    }
    
    public void azurirajKategoriju(Kategorija kategorija, Integer id) {
    	kategorija.setId(id);
        this.rabbitTemplate.convertAndSend("rabbitmqkm.azurirajkategoriju", kategorija);
        logger.info("Published message '{}'", "poruka poslana za azuriranje kategorije");
    }
    
    public void obrisiKategoriju(Integer id) {
        this.rabbitTemplate.convertAndSend("rabbitmqkm.obrisikategoriju", id);
        logger.info("Published message '{}'", "poruka poslana za brisanje kategorije");
    }
}
