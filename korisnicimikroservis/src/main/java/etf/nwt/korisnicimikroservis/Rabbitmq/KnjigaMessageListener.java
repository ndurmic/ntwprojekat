package etf.nwt.korisnicimikroservis.Rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import etf.nwt.korisnicimikroservis.Models.Knjiga;
import etf.nwt.korisnicimikroservis.Services.KnjigaService;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class KnjigaMessageListener {
	
	@Autowired
	private KnjigaService knjigaService;
	
	private Logger logger = LoggerFactory.getLogger(KnjigaMessageListener.class);
	
	@RabbitListener(queues = "rabbitmqkm.dodajknjigu")
	public void dodajKnjigu(Knjiga knjiga) {
		logger.info("Poruka: ","Primljena novokreirana knjiga");
		knjigaService.addKnjiga(knjiga);
	}
	
	@RabbitListener(queues = "rabbitmqkm.azurirajknjigu")
	public void azurirajKnjiug(Knjiga knjiga, Integer id) {
		logger.info("Poruka: ","Primljena azurirana knjiga");
		knjigaService.azurirajKnjigu(knjiga,id);
	}
	
	@RabbitListener(queues = "rabbitmqkm.obrisiknjigu")
	public void obrisiKnjigu(Integer id) {
		logger.info("Poruka: ","Primljena obrisana knjiga");
		knjigaService.obrisiKnjigu(id);
	}

}
