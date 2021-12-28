package com.ivanmoreno.respuestas.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ivanmoreno.respuestas.models.entity.Respuesta;
import com.ivanmoreno.respuestas.services.RespuestaService;

@RestController
public class RespuestaController {

	@Autowired
	private RespuestaService service;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody List<Respuesta> respuestas) {
		respuestas = respuestas.stream()
				.map(respuesta -> {
					respuesta.setAlumnoId(respuesta.getAlumno().getId());
					respuesta.setPreguntaId(respuesta.getPregunta().getId());
					return respuesta;
				}).collect(Collectors.toList());
		
		List<Respuesta> respuestasSaved = (List<Respuesta>) service.saveAll(respuestas);
		return ResponseEntity.status(HttpStatus.CREATED).body(respuestasSaved);
	}
	
	@GetMapping("/alumno/{alumnoId}/examen/{examenId}")
	public ResponseEntity<?> showRespuestasByAlumnoIdAndExamenId(@PathVariable Long alumnoId, @PathVariable Long examenId) {
		List<Respuesta> respuestas = service.findRespuestasByAlumnoByExamen(alumnoId, examenId);
		return ResponseEntity.ok(respuestas);
	}
	
	@GetMapping("/alumno/{alumnoId}/examenes-respondidos")
	public ResponseEntity<?> obtenerExamenesIdsByAlumnoId(@PathVariable Long alumnoId) {
		List<Long> examenesIds = service.findExamenesIdsByAlumno(alumnoId);
		return ResponseEntity.ok(examenesIds);
	}
}
