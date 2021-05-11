package com.example.getapitutorialv2;

import com.example.getapitutorialv2.model.Customer;
import com.example.getapitutorialv2.repository.CustomerRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Loader {
    
    private static final Logger log = LoggerFactory.getLogger(Loader.class);

    @Bean
    CommandLineRunner initDb(CustomerRepo repo){
        return args -> {
            // log.info("Preloading " + repo.save(new Customer("Aleister", "Invoker")));
            // log.info("Preloading " + repo.save(new Customer("Eldlich", "Golden Lord")));
            // log.info("Preloading " + repo.save(new Customer("Hideo Kojima", "Director")));
            // log.info("Preloading " + repo.save(new Customer("Elon Musk", "Dogecoin Hypeman")));
        };
    }

}
