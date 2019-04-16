package etf.nwt.knjigemikroservis.service;

import etf.nwt.knjigemikroservis.model.Autor;
import etf.nwt.knjigemikroservis.repository.AutorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;
    /*
    //RABBIT MQ --START--
    private Logger logger = LoggerFactory.getLogger(AutorService.class);

    private int messageNumber = 0;

    private static List<String> ROUTING_KEYS = Arrays.asList(
            "autor.created",
            "autor.edited",
            "autor.deleted");

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public AutorService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void sendMessage(String routingKey) {
        String message = String.format("Event no. %d of type '%s'", ++messageNumber, routingKey);
        rabbitTemplate.convertAndSend("Autor exchange", routingKey, message);
        logger.info("Published message '{}'", message);
    }
    //RABBIT MQ --END--
	*/
    public List<Autor> listaSvihAutora(){
        List<Autor> autori = new ArrayList<>();
        autorRepository.findAll().forEach(autori::add);
        return  autori;
    }

    //Optional for object/values which may be null
    public Optional<Autor> dajAutora(Integer id){
        return autorRepository.findById(id); //tip parametra zavisi od tipa definisanog u repozitoriju
    }

    public void dodajAutora (Autor autor){

        autorRepository.save(autor);
        //sendMessage(ROUTING_KEYS.get(0));
    }

    public void azurirajAutora (Autor autor, Integer id){
        //JPA prepozna ako nema objekta onda ce ga dodati, ako ima azurirat ce ga u zavisnosti od ID koji se nalazi u entitetu
        //Zbog toga nema potrebe za metodom update, save radi oboje
        autor.setId(id);
        autorRepository.save(autor);
        //sendMessage(ROUTING_KEYS.get(1));
    }

    public void obrisiAutora(Integer id){

        autorRepository.deleteById(id);
        //sendMessage(ROUTING_KEYS.get(2));
    }


}
