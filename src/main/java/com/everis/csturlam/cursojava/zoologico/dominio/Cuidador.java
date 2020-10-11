package com.everis.csturlam.cursojava.zoologico.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.everis.csturlam.cursojava.zoologico.exception.AnimalAveNoAlimentableException;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

//Clase hija de Empleado
@Entity
@Getter
@Setter
@Table ( name = "CUIDADOR" )
public class Cuidador
		extends Empleado

{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7049214110426668394L;

	@Column ( name = "ESPECILIDAD_MAMIFEROS" )
	private String especialidadMamiferos;

	@OneToMany ( mappedBy = "cuidadorAsignado", fetch = FetchType.EAGER, cascade = CascadeType.ALL )
	private List < AprendizDeCuidador > listaAprendiz;
	@JsonIgnore
	@OneToOne ( mappedBy = "cuidadorPrincipal" )
	private Habitat cuidadorPrincipal;

	public Cuidador ( )
	{

		super ( );
		listaAprendiz = new ArrayList <> ( );

	}

	public String alimentar ( Animal animal )
	{

		try
		{

			return String.format ( "El cuidador %s va a alimentar al  %s con %s %n%s%n", this.nombreEmpleado, animal.getClass ( )
					.getSimpleName ( ), animal.getAlimento ( ), animal.recibirAlimento ( ) );
		}
		catch ( AnimalAveNoAlimentableException e )
		{

			return String.format ( "El cuidador %s ha tratado de dar de comer al %s y ha salido trasquilado %n", this.nombreEmpleado, animal.getClass ( )
					.getSimpleName ( ) );
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
