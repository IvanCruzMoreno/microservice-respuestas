package com.ivanmoreno.respuestas.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ivanmoreno.commons.models.entity.Examen;
import com.ivanmoreno.commons.models.entity.Pregunta;
import com.ivanmoreno.respuestas.clients.ExamenClientFeign;
import com.ivanmoreno.respuestas.models.entity.Respuesta;
import com.ivanmoreno.respuestas.models.respository.RespuestaRepository;

@Service
public class RespuestaServiceImpl implements RespuestaService {

	private RespuestaRepository respuestaRepo;
	private ExamenClientFeign examenFeignClient;
	
	public RespuestaServiceImpl(RespuestaRepository repository, ExamenClientFeign examenFeign) {
		this.respuestaRepo = repository;
		this.examenFeignClient = examenFeign;
	}
	
	@Override
	public Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas) {
		return respuestaRepo.saveAll(respuestas);
	}

	@Override
	public List<Respuesta> findRespuestasByAlumnoByExamen(Long alumnoId, Long examenId) {
		
		Examen examen = examenFeignClient.getExamenById(examenId);
		List<Pregunta> preguntas = examen.getPreguntas();
		List<Long> preguntasId = preguntas
				.stream()
				.map(Pregunta::getId)
				.collect(Collectors.toList());
		
		List<Respuesta> respuestas = respuestaRepo.findRespuestasByAlumnoIdByPreguntasId(alumnoId, preguntasId)
				.stream()
				.map(repuesta -> this.setFullPregunta(repuesta, preguntas))
				.collect(Collectors.toList());
		
		return respuestas;
	}

	private Respuesta setFullPregunta(Respuesta respuesta, List<Pregunta> preguntas) {
		
		preguntas.forEach(pregunta -> {
			if(pregunta.getId() == respuesta.getPreguntaId()) {
				respuesta.setPregunta(pregunta);
			}
		});
		
		return respuesta;
	}
	
	@Override
	public List<Long> findExamenesIdsByAlumno(Long alumnoId) {
		List<Respuesta> respuestasByAlumno = respuestaRepo.findByAlumnoId(alumnoId);
		List<Long> examenesIds = Collections.emptyList();
		
		if(respuestasByAlumno != null && respuestasByAlumno.size() > 0) {
			
			List<Long> preguntasIds = respuestasByAlumno.stream()
					.map(Respuesta::getPreguntaId)
					.collect(Collectors.toList());
			
			examenesIds = examenFeignClient.getExamenesIdsByPreguntasId(preguntasIds);
		}
		
		return examenesIds;
	}

	@Override
	public List<Respuesta> findByAlumnoId(Long alumnoId) {
		return this.respuestaRepo.findByAlumnoId(alumnoId);
	}

}
