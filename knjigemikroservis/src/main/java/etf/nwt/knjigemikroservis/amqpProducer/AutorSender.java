package etf.nwt.knjigemikroservis.amqpProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import etf.nwt.knjigemikroservis.model.Autor;
import etf.nwt.knjigemikroservis.model.Kategorija;
import etf.nwt.knjigemikroservis.model.Knjiga;

@Service
public class AutorSender {

	private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;
    
    private Logger logger = LoggerFactory.getLogger(KnjigaSender.class);

    @Autowired
    public AutorSender(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    public void dodajAutora(Autor autor) {
        this.rabbitTemplate.convertAndSend("rabbitmqkm.dodajautora", autor);
        logger.info("Published message '{}'", "poruka poslana za dodavanje autora");
    }
    
    public void azurirajAutora(Autor autor, Integer id) {
    	autor.setId(id);
        this.rabbitTemplate.convertAndSend("rabbitmqkm.azurirajautora", autor);
        logger.info("Published message '{}'", "poruka poslana za azuriranje autora");
    }
    
    public void obrisiAutora(Integer id) {
        this.rabbitTemplate.convertAndSend("rabbitmqkm.obrisiautora", id);
        logger.info("Published message '{}'", "poruka poslana za brisanje autora");
    }
}
