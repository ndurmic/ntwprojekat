package etf.nwt.knjigemikroservis.service;

//Creating a  Spring business service

import etf.nwt.knjigemikroservis.model.*;
import etf.nwt.knjigemikroservis.repository.AutorRepository;
import etf.nwt.knjigemikroservis.repository.KategorijaRepository;
import etf.nwt.knjigemikroservis.repository.KategorijeKnjigeRepository;
import etf.nwt.knjigemikroservis.repository.KnjigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

@Service
public class KnjigaService {

        @Autowired
        private KnjigaRepository knjigaRepository;
        @Autowired
        private KategorijaRepository kategorijaRepository;
        @Autowired
        private AutorRepository autorRepository;
        @Autowired
        private KategorijeKnjigeRepository kategorijeKnjigeRepository;
        /*
        //RABBIT MQ --START--
        private Logger logger = LoggerFactory.getLogger(KnjigaService.class);

        private int messageNumber = 0;

        private static List<String> ROUTING_KEYS = Arrays.asList(
            "knjiga.created",
            "knjiga.edited",
            "knjiga.deleted");

        private final RabbitTemplate rabbitTemplate;

        @Autowired
        public KnjigaService(RabbitTemplate rabbitTemplate) {
            this.rabbitTemplate = rabbitTemplate;
        }

        @Scheduled(fixedDelay = 1000, initialDelay = 500)
        public void sendMessage(String routingKey) {
            String message = String.format("Event no. %d of type '%s'", ++messageNumber, routingKey);
            rabbitTemplate.convertAndSend("Knjiga exchange", routingKey, message);
            logger.info("Published message '{}'", message);
        }
        //RABBIT MQ --END--
		*/
        public List<Knjiga> listaSvihKnjiga(){
            List<Knjiga> knjige = new ArrayList<>();
            knjigaRepository.findAll().forEach(knjige::add);
            return  knjige;
        }

        //Optional for object/values which may be null
        public Optional<Knjiga> dajKnjigu(Integer id){
           return knjigaRepository.findById(id); //tip parametra zavisi od tipa definisanog u repozitoriju
        }

        public void dodajKnjigu (Knjiga knjiga){

            knjigaRepository.save(knjiga);
            //sendMessage(ROUTING_KEYS.get(0));
        }

        public void azurirajKnjigu (Knjiga knjiga, Integer id){
            //JPA prepozna ako nema objekta onda ce ga dodati, ako ima azurirat ce ga u zavisnosti od ID koji se nalazi u entitetu
            //Zbog toga nema potrebe za metodom update, save radi oboje
            knjiga.setId(id);
            knjigaRepository.save(knjiga);
            //sendMessage(ROUTING_KEYS.get(1));
        }

        public void obrisiKnjigu(Integer id){

            knjigaRepository.deleteById(id);
            //sendMessage(ROUTING_KEYS.get(2));
        }

        public List<Optional<Knjiga>> knjigePoKategoriji(Integer idKategorije){
           Iterable<KategorijeKnjige> listaKategorija = kategorijeKnjigeRepository.findAll();
           List<Optional<Knjiga>> listaKnjiga = new ArrayList<>();

            for (KategorijeKnjige kategorijeKnjige : listaKategorija) {
                if(kategorijeKnjige.getKategorija_id()==idKategorije)
                listaKnjiga.add(knjigaRepository.findById(kategorijeKnjige.getKnjiga_id()));
            }

           return  listaKnjiga;

        }


        //Najpopularnije ocjene - u korisnicima

        //Najapopularniji autori u kolekcijama

        //Najpopularnije knjige u kolekcijama

}
