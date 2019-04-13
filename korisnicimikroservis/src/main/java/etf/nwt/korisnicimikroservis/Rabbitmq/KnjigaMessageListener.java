package etf.nwt.korisnicimikroservis.Rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import etf.nwt.korisnicimikroservis.Models.KnjigaModel;
import etf.nwt.korisnicimikroservis.Services.KnjigaService;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class KnjigaMessageListener {
	
	@Autowired
	private KnjigaService knjigaService;
	
	@RabbitListener(queues = "rabbitmqkm.dodajknjigu")
	public void dodajKnjigu(KnjigaModel knjiga) {
		knjigaService.addKnjiga(knjiga);
	}
	
	@RabbitListener(queues = "rabbitmqkm.azurirajknjigu")
	public void azurirajKnjiug(KnjigaModel knjiga, Integer id) {
		knjigaService.azurirajKnjigu(knjiga,id);
	}
	
	@RabbitListener(queues = "rabbitmqkm.obrisiknjigu")
	public void obrisiKnjigu(Integer id) {
		knjigaService.obrisiKnjigu(id);
	}

}
