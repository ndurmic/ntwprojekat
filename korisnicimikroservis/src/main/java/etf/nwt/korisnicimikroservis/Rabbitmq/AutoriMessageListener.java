package etf.nwt.korisnicimikroservis.Rabbitmq;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import etf.nwt.korisnicimikroservis.Models.Autor;
import etf.nwt.korisnicimikroservis.Services.AutorService;

import org.springframework.beans.factory.annotation.Autowired;


@Component
public class AutoriMessageListener {

	@Autowired
	private AutorService autoriService;
	
	private Logger logger = LoggerFactory.getLogger(AutoriMessageListener.class);
	
	@RabbitListener(queues = "rabbitmqkm.dodajautora")
	public void dodajAutora(Autor autor) {
		logger.info("Poruka: ", "Primljen novokreirani autor");
		autoriService.dodajAutora(autor);
	}
	
	@RabbitListener(queues = "rabbitmqkm.azurirajautora")
	public void azurirajAutora(Autor autor, Integer id) {
		logger.info("Poruka: ", "Primljen azurirani autor");
		autoriService.azurirajAutora(autor, id);
	}
	
	@RabbitListener(queues = "rabbitmqkm.obrisiautora")
	public void obrisiAutora(Integer id) {
		logger.info("Poruka: ", "Primljen obrisani autor");
		autoriService.obrisiAutora(id);;
	}
}
