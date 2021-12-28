package com.ivanmoreno.respuestas.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.ivanmoreno.commons.models.entity.Examen;

@FeignClient(name = "microservice-examenes")
public interface ExamenClientFeign {

	@GetMapping("/{id}")
	public Examen getExamenById(@PathVariable Long id);
	
	@GetMapping("/respondidos-por-preguntas")
	public List<Long> getExamenesIdsByPreguntasId(@RequestParam List<Long> preguntasId);
}
