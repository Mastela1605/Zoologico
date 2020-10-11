package com.everis.csturlam.cursojava.zoologico.dto.area;

import java.util.List;

import com.everis.csturlam.cursojava.zoologico.dto.habitat.HabitatCompletoDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AreaCompletoDto
		extends AreaBaseDto
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8189636844590579733L;

	List < HabitatCompletoDto > listaHabitat;

}
