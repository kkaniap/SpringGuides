package io.spring.guides;

import io.spring.guides.model.Quote;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class GuidesApplication {


    private static final Logger log = Logger.getLogger(GuidesApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(GuidesApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate){
        return args -> {
            Quote quote = restTemplate.getForObject(
                    "https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
            log.log(Level.INFO, quote.toString());
        };
    }

}
