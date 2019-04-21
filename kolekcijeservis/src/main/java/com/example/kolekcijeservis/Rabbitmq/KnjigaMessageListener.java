package com.example.kolekcijeservis.Rabbitmq;

import com.example.kolekcijeservis.Models.Knjiga;
import com.example.kolekcijeservis.Models.KnjigaExternal;
import com.example.kolekcijeservis.Repository.KnjigaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class KnjigaMessageListener {

    private void azuriraj(KnjigaExternal x, Integer id){
        knjigaRepository.findById(id).map(knjiga -> {
            knjiga.setId(id);
            try{
                knjiga.setDatumIzdavanja(new SimpleDateFormat("dd.MM.yyyy").parse(x.getDatumIzdavanja()));
            }
            catch(Exception e){

            }
            knjiga.setNaslov(x.getNaslov());
            knjiga.setOpis(x.getOpis());


            return knjigaRepository.save(knjiga);
        });
    }

    @Autowired
   // private KnjigaService knjigaService;
    private KnjigaRepository knjigaRepository;

    private Logger logger = LoggerFactory.getLogger(KnjigaMessageListener.class);

    @RabbitListener(queues = "rabbitmqkm.dodajknjigu")
    public void dodajKnjigu(KnjigaExternal knjigaExternal) {
        logger.info("Poruka: '{}'","Primljena novokreirana knjiga");
        Knjiga knjiga = new Knjiga();
        knjiga.setId(knjigaExternal.getId());
        knjiga.setOpis(knjigaExternal.getOpis());
        knjiga.setNaslov(knjigaExternal.getNaslov());
        try{
            knjiga.setDatumIzdavanja(new SimpleDateFormat("dd.MM.yyyy").parse(knjigaExternal.getDatumIzdavanja()));
        }
        catch(Exception e){

        }
         knjigaRepository.save(knjiga);
    }

    @RabbitListener(queues = "rabbitmqkm.azurirajknjigu")
    public void azurirajKnjigu(KnjigaExternal knjiga) {
        logger.info("Poruka: '{}'","Primljena azurirana knjiga");
        this.azuriraj(knjiga, knjiga.getId());
    }

    @RabbitListener(queues = "rabbitmqkm.obrisiknjigu")
    public void obrisiKnjigu(Integer id) {
        logger.info("Poruka: '{}'","Primljena obrisana knjiga");
        knjigaRepository.deleteById(id);

    }
}

