package com.ivanmoreno.respuestas.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ivanmoreno.commons.models.entity.Examen;

@FeignClient(name = "microservice-examenes")
public interface ExamenClientFeign {

	@GetMapping("/{id}")
	public Examen getExamenById(@PathVariable Long id);
	
}
