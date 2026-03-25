package java_microservices.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/hello")
    public String hello() {
        return "Bem-vindo ao Java Microservices Demo!";
    }
}
