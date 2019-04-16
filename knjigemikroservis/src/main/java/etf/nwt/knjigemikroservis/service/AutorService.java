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

    public List<Autor> listaSvihAutora(){
        List<Autor> autori = new ArrayList<>();
        autorRepository.findAll().forEach(autori::add);
        return  autori;
    }

    //Optional for object/values which may be null
    public Optional<Autor> dajAutora(Integer id){
        return autorRepository.findById(id); //tip parametra zavisi od tipa definisanog u repozitoriju
    }

    public Autor dodajAutora (Autor autor){

        return autorRepository.save(autor);

    }

    public Autor azurirajAutora (Autor autor, Integer id){
        //JPA prepozna ako nema objekta onda ce ga dodati, ako ima azurirat ce ga u zavisnosti od ID koji se nalazi u entitetu
        //Zbog toga nema potrebe za metodom update, save radi oboje
        autor.setId(id);
        return  autorRepository.save(autor);
    }

    public String obrisiAutora(Integer id){

        autorRepository.deleteById(id);

        return "Autor uspješno obrisan";
    }


}
