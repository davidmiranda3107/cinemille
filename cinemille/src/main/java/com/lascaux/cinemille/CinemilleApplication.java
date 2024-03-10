package com.lascaux.cinemille;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class CinemilleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemilleApplication.class, args);
	}

}
