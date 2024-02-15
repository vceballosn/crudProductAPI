package com.gym.crud;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}
   
	@GetMapping(path = "/")
	public List<String> getNames() {
	   
   
	   return List.of("vladimir","Mijail","jonathan");
	   
   }
}
