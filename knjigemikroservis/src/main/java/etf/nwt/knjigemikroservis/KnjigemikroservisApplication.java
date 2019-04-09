package etf.nwt.knjigemikroservis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class KnjigemikroservisApplication {

    public static void main(String[] args) {

        SpringApplication.run(KnjigemikroservisApplication.class, args);
    }

}
