package com.fhqiwcw.dnspod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Import({QuartzConifg.class})
@RestController
public class Application {
	
	@GetMapping("/")
	public String hello() {
		return "hello world!";
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
