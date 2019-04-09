package com.example.kolekcijeservis;

import com.example.kolekcijeservis.Models.Knjiga;
import com.example.kolekcijeservis.Repository.KnjigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Date;
import java.util.Optional;


@SpringBootApplication
@EnableJpaAuditing
@EnableEurekaClient
public class KolekcijeservisApplication {




	public static void main(String[] args) {

		SpringApplication.run(KolekcijeservisApplication.class, args);

	}

}
