package etf.nwt.knjigemikroservis.service;

import etf.nwt.knjigemikroservis.model.Kategorija;
import etf.nwt.knjigemikroservis.repository.KategorijaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Exchange;
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
public class KategorijaService {

    @Autowired
    private KategorijaRepository kategorijaRepository;

    //RABBIT MQ --START--
    private Logger logger = LoggerFactory.getLogger(AutorService.class);

    private int messageNumber = 0;

    private static List<String> ROUTING_KEYS = Arrays.asList(
            "kategorija.created",
            "kategorija.edited",
            "kategorija.deleted");

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public KategorijaService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void sendMessage(String routingKey) {
        String message = String.format("Event no. %d of type '%s'", ++messageNumber, routingKey);
        rabbitTemplate.convertAndSend("Kategorija exchange", routingKey, message);
        logger.info("Published message '{}'", message);
    }
    //RABBIT MQ --END--

    public List<Kategorija> listaSvihKategorija(){
        List<Kategorija> kategorije = new ArrayList<>();
        kategorijaRepository.findAll().forEach(kategorije::add);
        return  kategorije;
    }

    //Optional for object/values which may be null
    public Optional<Kategorija> dajKategoriju(Integer id){
        return kategorijaRepository.findById(id); //tip parametra zavisi od tipa definisanog u repozitoriju
    }

    public void dodajKategoriju (Kategorija kategorija){

        kategorijaRepository.save(kategorija);
        sendMessage(ROUTING_KEYS.get(0));
    }

    public void azurirajKategoriju (Kategorija kategorija, Integer id){
        //JPA prepozna ako nema objekta onda ce ga dodati, ako ima azurirat ce ga u zavisnosti od ID koji se nalazi u entitetu
        //Zbog toga nema potrebe za metodom update, save radi oboje
        kategorija.setId(id);
        kategorijaRepository.save(kategorija);
        sendMessage(ROUTING_KEYS.get(1));
    }

    public void obrisiKategoriju(Integer id){

        kategorijaRepository.deleteById(id);
        sendMessage(ROUTING_KEYS.get(2));
    }

}
