package com.everis.csturlam.cursojava.zoologico.dto.animal;

import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

//Clase padre de Ave y Mamifero
@Getter
@Setter

public abstract class AnimalBaseDto
		implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1375342060708370697L;

	protected String tipo;

	protected String nombre;

	protected String alimento;

	protected String referenciaAnimal;
	@DateTimeFormat ( pattern = "dd-MM-yyyy HH:mm" )
	protected String fechaNacimiento;

	protected String origen;
	@DateTimeFormat ( pattern = "dd-MM-yyyy" )
	protected String fechaLlegada;

	protected Float altura;

	protected Float peso;

	protected String zonaDeCaza;
	protected String emvergadura;

	protected Integer velocidad;

}
