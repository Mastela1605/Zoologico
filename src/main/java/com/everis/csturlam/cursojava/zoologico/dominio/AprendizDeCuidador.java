package com.everis.csturlam.cursojava.zoologico.dominio;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

//Clase hija de Empleado
@Entity
@Getter
@Setter
@Table ( name = "APRENDIZDECUIDADOR" )
public class AprendizDeCuidador
		extends Empleado
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6638385179605138497L;
	// Atributo cuidadorAsignado el esta asociado a la clase Cuidador, con ello conseguimos que solo le podamos pasar objetos pertenecientes a esta clase.
	@JsonIgnore
	@ManyToOne
	@JoinColumn ( name = "FK_CUIDADORASIGNADO" )
	private Cuidador cuidadorAsignado;

	@Override
	public int compareTo ( Empleado o )
	{

		return compareTo ( o );
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
