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

    public List<Kategorija> listaSvihKategorija(){
        List<Kategorija> kategorije = new ArrayList<>();
        kategorijaRepository.findAll().forEach(kategorije::add);
        return  kategorije;
    }

    //Optional for object/values which may be null
    public Optional<Kategorija> dajKategoriju(Integer id){
        return kategorijaRepository.findById(id); //tip parametra zavisi od tipa definisanog u repozitoriju
    }

    public Kategorija dodajKategoriju (Kategorija kategorija){

       return kategorijaRepository.save(kategorija);

    }

    public Kategorija azurirajKategoriju (Kategorija kategorija, Integer id){
        //JPA prepozna ako nema objekta onda ce ga dodati, ako ima azurirat ce ga u zavisnosti od ID koji se nalazi u entitetu
        //Zbog toga nema potrebe za metodom update, save radi oboje
        kategorija.setId(id);

        return kategorijaRepository.save(kategorija);

    }

    public String  obrisiKategoriju(Integer id){

        kategorijaRepository.deleteById(id);

        return "Kategorija uspješno obrisana";

    }

}
