package com.everis.csturlam.cursojava.zoologico.dto.zoo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ZooActualizarDto
		extends ZooBaseDto
		implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1659390199365402067L;

	private Long id;

}
