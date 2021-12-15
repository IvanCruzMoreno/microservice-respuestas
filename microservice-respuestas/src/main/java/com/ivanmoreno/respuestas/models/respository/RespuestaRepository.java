package com.ivanmoreno.respuestas.models.respository;

import org.springframework.data.repository.CrudRepository;

import com.ivanmoreno.respuestas.models.entity.Respuesta;

public interface RespuestaRepository extends CrudRepository<Respuesta, Long> {

}
