package etf.nwt.korisnicimikroservis.Rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import etf.nwt.korisnicimikroservis.Models.Kategorija;
import etf.nwt.korisnicimikroservis.Services.KategorijaService;

@Component
public class KategorijeMessageListener {

	@Autowired
	private KategorijaService kategorijeService;
	
	private Logger logger = LoggerFactory.getLogger(KategorijeMessageListener.class);
	
	@RabbitListener(queues = "rabbitmqkm.dodajkategoriju")
	public void dodajKategoriju(Kategorija kategorija) {
		logger.info("Poruka: '{}'", "Primljena novokreirana kategorija");
		kategorijeService.dodajKategoriju(kategorija);
	}
	
	@RabbitListener(queues = "rabbitmqkm.azurirajkategoriju")
	public void azurirajKategoriju(Kategorija kategorija, Integer id) {
		logger.info("Poruka: '{}'", "Primljena azurirana kategorija");
		kategorijeService.azurirajKategoriju(kategorija, id);
	}
	
	@RabbitListener(queues = "rabbitmqkm.obrisikategoriju")
	public void obrisiKategoriju(Integer id) {
		logger.info("Poruka: '{}'", "Primljena obrisana kategorija");
		kategorijeService.obrisiKategoriju(id);
	}
}
