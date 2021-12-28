package com.ivanmoreno.respuestas.services;

import java.util.List;

import com.ivanmoreno.respuestas.models.entity.Respuesta;

public interface RespuestaService {
	
	public Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas);
	
	public List<Respuesta> findRespuestasByAlumnoByExamen(Long alumnoId, Long examenId);
	
	public List<Long> findExamenesIdsByAlumno(Long alumnoId);
	
	public List<Respuesta> findByAlumnoId(Long alumnoId);
}
