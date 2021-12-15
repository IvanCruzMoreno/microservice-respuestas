package com.ivanmoreno.respuestas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EntityScan({"com.ivanmoreno.commons.models.entity",
		     "com.ivanmoreno.respuestas.models.entity"})
@EnableEurekaClient
@SpringBootApplication
public class MicroserviceRespuestasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceRespuestasApplication.class, args);
	}

}
