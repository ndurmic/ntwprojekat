package etf.nwt.knjigemikroservis.amqpProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import etf.nwt.knjigemikroservis.model.Knjiga;

@Service
public class KnjigaSender {

	private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;
    
    private Logger logger = LoggerFactory.getLogger(KnjigaSender.class);

    @Autowired
    public KnjigaSender(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    public void dodajKnjigu(Knjiga knjiga) {
        this.rabbitTemplate.convertAndSend("rabbitmqkm.dodajknjigu", knjiga);
        logger.info("Published message '{}'", "poruka poslana za dodavanje knjiga");
    }
    
    public void azurirajKnjigu(Knjiga knjiga, Integer id) {
    	knjiga.setId(id);
        this.rabbitTemplate.convertAndSend("rabbitmqkm.azurirajknjigu", knjiga);
        logger.info("Published message '{}'", "poruka poslana za azuriranje knjiga");
    }
    
    public void obrisiKnjigu(Integer id) {
        this.rabbitTemplate.convertAndSend("rabbitmqkm.obrisiknjigu", id);
        logger.info("Published message '{}'", "poruka poslana za brisanje knjiga");
    }
}
