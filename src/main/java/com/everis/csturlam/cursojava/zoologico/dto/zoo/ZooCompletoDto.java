package com.everis.csturlam.cursojava.zoologico.dto.zoo;

import java.io.Serializable;
import java.util.List;

import com.everis.csturlam.cursojava.zoologico.dto.area.AreaCompletoDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ZooCompletoDto
		extends ZooBaseDto
		implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -497127478107556080L;
	private List < AreaCompletoDto > listaArea;
}
