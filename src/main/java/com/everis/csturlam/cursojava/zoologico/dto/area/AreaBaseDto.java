package com.everis.csturlam.cursojava.zoologico.dto.area;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AreaBaseDto
		implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2718198146539183702L;
	protected String nombre;
}
