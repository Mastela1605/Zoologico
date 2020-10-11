package com.everis.csturlam.cursojava.zoologico.dto.zoo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ZooBaseDto
		implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8634950370460887071L;
	protected String nombre;
	protected String ubicacion;
	protected String fechaApertura;
	protected String horaApertura;
	protected String horaCierre;
	protected Float precioAdulto;
	protected Float precioInfantil;
}
