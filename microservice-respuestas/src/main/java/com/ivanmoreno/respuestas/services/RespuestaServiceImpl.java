package com.ivanmoreno.respuestas.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ivanmoreno.respuestas.models.entity.Respuesta;
import com.ivanmoreno.respuestas.models.respository.RespuestaRepository;

@Service
public class RespuestaServiceImpl implements RespuestaService {

	private RespuestaRepository respuestaRepo;
	
	public RespuestaServiceImpl(RespuestaRepository repository) {
		this.respuestaRepo = repository;
	}
	
	@Override
	@Transactional
	public Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas) {
		return respuestaRepo.saveAll(respuestas);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Respuesta> findRespuestasByAlumnoByExamen(Long alumnoId, Long examenId) {
		return respuestaRepo.findRespuestasByAlumnoByExamen(alumnoId, examenId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Long> findExamenesIdsByAlumno(Long alumnoId) {
		return respuestaRepo.findExamenesIdsByAlumno(alumnoId);
	}

}
