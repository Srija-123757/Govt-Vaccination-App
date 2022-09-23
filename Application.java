package project.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application{

	
	@CrossOrigin(origins="http://localhost:62062/")
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}	
	}


