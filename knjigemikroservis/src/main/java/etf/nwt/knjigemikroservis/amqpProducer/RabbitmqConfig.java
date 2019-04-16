package etf.nwt.knjigemikroservis.amqpProducer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@EnableRabbit
@Configuration
public class RabbitmqConfig {

	
	// sender
	final static String queueDodajKnjigu = "rabbitmqkm.dodajknjigu";
	final static String queueAzurirajKnjigu = "rabbitmqkm.azurirajknjigu";
	final static String queueObrisiKnjigu = "rabbitmqkm.obrisiknjigu";
	
	final static String queueDodajAutora = "rabbitmqkm.dodajautora";
	final static String queueAzurirajAutora = "rabbitmqkm.azurirajautora";
	final static String queueObrisiAutora = "rabbitmqkm.obrisiautora";
	
	final static String queueDodajKategoriju = "rabbitmqkm.dodajkategoriju";
	final static String queueAzurirajKategoriju = "rabbitmqkm.azurirajkategoriju";
	final static String queueObrisiKategoriju = "rabbitmqkm.obrisikategoriju";
	
	
	@Bean
	@Primary
    public Queue queueDodajKnjigu() {
        return new Queue(RabbitmqConfig.queueDodajKnjigu);
    }
	
	@Bean
    public Queue queueAzurirajKnjigu() {
        return new Queue(RabbitmqConfig.queueAzurirajKnjigu);
    }
	
	@Bean
    public Queue queueObrisiKnjigu() {
        return new Queue(RabbitmqConfig.queueObrisiKnjigu);
    }
	
	@Bean
    public Queue queueDodajAutora() {
        return new Queue(RabbitmqConfig.queueDodajAutora);
    }
	
	@Bean
    public Queue queueAzurirajAutora() {
        return new Queue(RabbitmqConfig.queueAzurirajAutora);
    }
	
	@Bean
    public Queue queueObrisiAutora() {
        return new Queue(RabbitmqConfig.queueObrisiAutora);
    }
	
	@Bean
    public Queue queueDodajKategoriju() {
        return new Queue(RabbitmqConfig.queueDodajKategoriju);
    }
	
	@Bean
    public Queue queueAzurirajKategoriju() {
        return new Queue(RabbitmqConfig.queueAzurirajKategoriju);
    }
	
	@Bean
    public Queue queueObrisiKategoriju() {
        return new Queue(RabbitmqConfig.queueObrisiKategoriju);
    }
	
	@Bean
    TopicExchange exchangeRabbitmqkm1() {
        return new TopicExchange("rabbitmqkmExchange");
    }
	
	@Bean
	Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("rabbitmqkm.#");
    }
	
	@Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
	
}
