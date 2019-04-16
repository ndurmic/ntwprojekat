package com.example.kolekcijeservis;

import com.example.kolekcijeservis.Models.Knjiga;
import com.example.kolekcijeservis.Repository.KnjigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Optional;


@SpringBootApplication
@EnableJpaAuditing
@EnableEurekaClient
public class KolekcijeservisApplication {

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();

	}


	public static void main(String[] args) {

		SpringApplication.run(KolekcijeservisApplication.class, args);

	}

}
