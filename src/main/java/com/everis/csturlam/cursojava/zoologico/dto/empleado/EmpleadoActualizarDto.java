package com.everis.csturlam.cursojava.zoologico.dto.empleado;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class EmpleadoActualizarDto
		extends EmpleadoBaseDto
		implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2164597951416205037L;

	private Long id;

}
