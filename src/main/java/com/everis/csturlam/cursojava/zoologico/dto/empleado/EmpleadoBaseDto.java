package com.everis.csturlam.cursojava.zoologico.dto.empleado;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class EmpleadoBaseDto
		implements Serializable
{
	private static final long serialVersionUID = 6604528722733704229L;

	/**
	 * 
	 */

	protected String puesto;

	protected String nombreEmpleado;

	protected String apellido1;

	protected String apellido2;

	protected String dni;

	protected String fechaDeIncorporacionZoo;

	protected String fechaDeIncorporacionPuesto;

	protected Float sueldo;

	protected String especialidadEnMamiferos;

	protected String especialidadEnAves;
}
