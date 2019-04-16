package etf.nwt.korisnicimikroservis.Rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import etf.nwt.korisnicimikroservis.Models.KorisnikModel;

@Service
public class KorisnikMessageSender {

	private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;
    
    private Logger logger = LoggerFactory.getLogger(KorisnikMessageSender.class);

    @Autowired
    public KorisnikMessageSender(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    public void dodajKorisnika(KorisnikModel korisnik) {
        this.rabbitTemplate.convertAndSend("rabbitmqkm.dodankorisnik", korisnik);
        logger.info("Poruka: '{}'","Poslan novokreirani korisnik");
    }
    
    public void azurirajKorisnika(KorisnikModel korisnik, Integer id) {
    	korisnik.setId(id);
        this.rabbitTemplate.convertAndSend("rabbitmqkm.azurirankorisnik", korisnik);
        logger.info("Poruka: '{}'","Poslan azuriran korisnik");
    }
    
    public void obrisiKorisnika(Integer id) {
        this.rabbitTemplate.convertAndSend("rabbitmqkm.obrisankorisnik", id);
        logger.info("Poruka: '{}'","Poslan obrisani korisnik");
    }
}
