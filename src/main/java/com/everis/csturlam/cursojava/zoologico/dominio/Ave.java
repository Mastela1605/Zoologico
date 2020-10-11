package com.everis.csturlam.cursojava.zoologico.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.everis.csturlam.cursojava.zoologico.exception.AnimalAveNoAlimentableException;

import lombok.Getter;
import lombok.Setter;

//Clase hija de Animal
@Getter
@Setter
@Entity
@Table ( name = "AVE" )
public abstract class Ave
		extends Animal

{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9103440483248765392L;
	@Column ( name = "ZONA_DE_CAZA" )
	protected String zonaDeCaza;
	@Column ( name = "ENVERGADURA" )
	protected String envergadura;

	@Override
	public String recibirAlimento ( ) throws AnimalAveNoAlimentableException
	{

		throw new AnimalAveNoAlimentableException ( "ERROR AL ALIMENTAR AVES" );

	}

	public void salirDeCaza ( )
	{
		if ( Boolean.TRUE.equals ( this.hambre ) )
		{
			this.hambre = false;
		}
		else
		{
			this.hambre = true;
		}

	}

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