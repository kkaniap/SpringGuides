package io.spring.guides;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GuidesApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuidesApplication.class, args);
    }

}
