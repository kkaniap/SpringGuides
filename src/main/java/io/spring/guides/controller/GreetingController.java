package io.spring.guides.controller;

import io.spring.guides.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping(path = "/greeting")
    public Greeting greeting(@RequestParam(defaultValue = "World") String name){
        return new Greeting(1, String.format("Hello %s", name));
    }
}
