package etf.nwt.knjigemikroservis.amqpProducer;

import etf.nwt.knjigemikroservis.service.AutorService;
import etf.nwt.knjigemikroservis.service.KategorijaService;
import etf.nwt.knjigemikroservis.service.KnjigaService;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@Profile("publisher")
@Configuration
@EnableScheduling
public class EvenetPublisherConfiguration {


    @Bean
    public KnjigaService knjigaService(RabbitTemplate rabbitTemplate) {
        return new KnjigaService(rabbitTemplate);
    }

    @Bean
    public AutorService autorService(RabbitTemplate rabbitTemplate) {
        return new AutorService(rabbitTemplate);
    }

    @Bean
    public KategorijaService kategorijaService(RabbitTemplate rabbitTemplate) {
        return new KategorijaService(rabbitTemplate);
    }

}

