package com.everis.csturlam.cursojava.zoologico.dto.habitat;

import java.io.Serializable;

import com.everis.csturlam.cursojava.zoologico.dto.empleado.EmpleadoHabitatDto;

import lombok.Getter;
import lombok.Setter;

//Clase padre de Ave y Mamifero
@Getter
@Setter

public abstract class HabitatBaseDto
		implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8085345658962013269L;

	/**
	 * 
	 */

	protected String nombre;
	protected EmpleadoHabitatDto empleadoHabitatDto;

}
