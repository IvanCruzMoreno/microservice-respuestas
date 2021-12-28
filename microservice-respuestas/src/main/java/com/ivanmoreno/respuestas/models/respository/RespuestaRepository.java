package com.ivanmoreno.respuestas.models.respository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ivanmoreno.respuestas.models.entity.Respuesta;

public interface RespuestaRepository extends MongoRepository<Respuesta, String> {

	@Query("{'alumnoId': ?0, 'preguntaId': { $in: ?1 } }")
	public List<Respuesta> findRespuestasByAlumnoIdByPreguntasId(Long alumnoId, List<Long> examenId);
	
	@Query("{'alumnoId' : ?0 }")
	public List<Respuesta> findByAlumnoId(Long alumnoId);
	
//	@Query("select r from Respuesta r join fetch r.pregunta p join fetch p.examen e where r.alumnoId=?1 and e.id=?2")
//	public List<Respuesta> findRespuestasByAlumnoByExamen(Long alumnoId, Long examenId);
//	
//	@Query("select e.id from Respuesta r join r.pregunta p join p.examen e where r.alumnoId=?1 group by e.id")
//	public List<Long> findExamenesIdsByAlumno(Long alumnoId);
}
