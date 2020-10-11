package com.everis.csturlam.cursojava.zoologico.dto.animal;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AnimalActualizarDto
		extends AnimalBaseDto
		implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3049871411028561928L;
	private Long id;

}
