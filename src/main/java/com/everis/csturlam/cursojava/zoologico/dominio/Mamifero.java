package com.everis.csturlam.cursojava.zoologico.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public abstract class Mamifero
		extends Animal

{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2499716723752306749L;
	@Column ( name = "VELOCIDAD" )
	protected Integer velocidad;

	/**
	 * @return the velocidad
	 */
	@Override
	public int hashCode ( )
	{
		// TODO Cambiar true parametro de entrada a false cuando estemos con BBDD
		return super.hashCode ( );
	}

	@Override
	public boolean equals ( Object obj )
	{
		return super.equals ( obj );
	}
}