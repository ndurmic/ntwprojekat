package com.example.kolekcijeservis.Rabbitmq;


import com.example.kolekcijeservis.Models.Korisnik;

import com.example.kolekcijeservis.Repository.KorisnikRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class KorisnikMessageListener {

    private void azuriraj(Korisnik x, Integer id){
        korisnikRepository.findById(id).map(korisnik -> {
            korisnik.setId(id);
            korisnik.setUsername(x.getUsername());
            korisnik.setPassword(x.getPassword());
            korisnik.setIme(x.getIme());
            korisnik.setPrezime(x.getPrezime());
            korisnik.setEmail(x.getEmail());
            korisnik.setSlika(x.getSlika());
            korisnik.setRola(x.getRola());


            return korisnikRepository.save(korisnik);
        });
    }

    @Autowired
    private KorisnikRepository korisnikRepository;

    private Logger logger = LoggerFactory.getLogger(KnjigaMessageListener.class);

    @RabbitListener(queues = "rabbitmqkm.dodankorisnik")
    public void dodajKorisnika(Korisnik korisnik) {
        logger.info("Poruka: '{}'","Primljen novokreiran korisnik");

        korisnikRepository.save(korisnik);
    }

    @RabbitListener(queues = "rabbitmqkm.azurirankorisnik")
    public void azurirajKorisnika(Korisnik korisnik) {
        logger.info("Poruka: '{}'","Primljen azuriran korisnik");
        this.azuriraj(korisnik, korisnik.getId());
    }

    @RabbitListener(queues = "rabbitmqkm.obrisankorisnik")
    public void obrisiKnjigu(Integer id) {
        logger.info("Poruka: '{}'","Primljen obrisan korisnik");
        korisnikRepository.deleteById(id);

    }
}

