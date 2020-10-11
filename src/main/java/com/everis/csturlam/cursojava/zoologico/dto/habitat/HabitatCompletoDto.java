package com.everis.csturlam.cursojava.zoologico.dto.habitat;

import java.io.Serializable;
import java.util.List;

import com.everis.csturlam.cursojava.zoologico.dto.animal.AnimalCrearDto;

import lombok.Getter;
import lombok.Setter;

//Clase padre de Ave y Mamifero
@Getter
@Setter

public class HabitatCompletoDto
		extends HabitatBaseDto
		implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1790421605935760374L;

	private List < AnimalCrearDto > listaAnimal;

}
