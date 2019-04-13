package etf.nwt.korisnicimikroservis.Rabbitmq;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import etf.nwt.korisnicimikroservis.Models.Autor;
import etf.nwt.korisnicimikroservis.Services.AutorService;

import org.springframework.beans.factory.annotation.Autowired;


@Component
public class AutoriMessageListener {

	@Autowired
	private AutorService autoriService;
	
	@RabbitListener(queues = "rabbitmqkm.dodajautora")
	public void dodajAutora(Autor autor) {
		autoriService.dodajAutora(autor);
	}
	
	@RabbitListener(queues = "rabbitmqkm.azurirajautora")
	public void azurirajAutora(Autor autor, Integer id) {
		autoriService.azurirajAutora(autor, id);
	}
	
	@RabbitListener(queues = "rabbitmqkm.obrisiautora")
	public void obrisiAutora(Integer id) {
		autoriService.obrisiAutora(id);;
	}
}
