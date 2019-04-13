package etf.nwt.korisnicimikroservis.Rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import etf.nwt.korisnicimikroservis.Models.Kategorija;
import etf.nwt.korisnicimikroservis.Services.KategorijaService;

@Component
public class KategorijeMessageListener {

	@Autowired
	private KategorijaService kategorijeService;
	
	@RabbitListener(queues = "rabbitmqkm.dodajkategoriju")
	public void dodajKategoriju(Kategorija kategorija) {
		kategorijeService.dodajKategoriju(kategorija);
	}
	
	@RabbitListener(queues = "rabbitmqkm.azurirajkategoriju")
	public void azurirajKategoriju(Kategorija kategorija, Integer id) {
		kategorijeService.azurirajKategoriju(kategorija, id);
	}
	
	@RabbitListener(queues = "rabbitmqkm.obrisikategoriju")
	public void obrisiKategoriju(Integer id) {
		kategorijeService.obrisiKategoriju(id);
	}
}
