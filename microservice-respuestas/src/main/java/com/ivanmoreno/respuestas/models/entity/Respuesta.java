package com.ivanmoreno.respuestas.models.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ivanmoreno.commons.models.entity.Alumno;
import com.ivanmoreno.commons.models.entity.Pregunta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "respuestas")
public class Respuesta {

	@Id
	private String id;
	
	private String texto;
	
	@Transient
	private Alumno alumno;
	
	private Long alumnoId;
	
	@Transient
	private Pregunta pregunta;
	
	private Long preguntaId;
}
