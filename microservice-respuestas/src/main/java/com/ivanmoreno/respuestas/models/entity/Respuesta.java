package com.ivanmoreno.respuestas.models.entity;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ivanmoreno.commons.models.entity.Alumno;
import com.ivanmoreno.commons.models.entity.Pregunta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "respuestas")
public class Respuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String texto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "alumno_id", referencedColumnName = "id")
	private Alumno alumno;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pregunta_id", referencedColumnName = "id")
	private Pregunta pregunta;
	
}
