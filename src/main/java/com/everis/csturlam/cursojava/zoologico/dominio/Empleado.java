package com.everis.csturlam.cursojava.zoologico.dominio;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

//Clase padre abstract, clases hijas Cuidador y AprendizDeCuidador
@Getter
@Setter
@Entity
@Inheritance ( strategy = InheritanceType.JOINED )
@Table ( name = "EMPLEADO" )
public abstract class Empleado
		implements Comparable < Empleado >, Serializable

{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1765047368323377007L;
	@Id
	@Column ( name = "ID" )
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	protected Long id;
	@Column ( name = "NOMBRE_EMPLEADO" )
	protected String nombreEmpleado;
	@Column ( name = "APELLIDO1" )
	protected String apellido1;
	@Column ( name = "APELLIDO2" )
	protected String apellido2;
	@Column ( name = "DNI" )
	protected String dni;
	@Column ( name = "FECHA_DE_INCORPORACION_ZOO" )
	protected LocalDate fechaDeIncorporacionZoo;
	@Column ( name = "FECHA_DE_INCORPORACION_PUESTO" )
	protected LocalDate fechaDeIncorporacionPuesto;
	@Column ( name = "SUELDO" )
	protected Float sueldo;
	@JsonIgnore
	@OneToOne ( mappedBy = "ayundanteDeCuidadorPrincipal" )
	protected Habitat ayundanteDeCuidadorPrincipal;

	@Override
	public int compareTo ( Empleado empleado )
	{
		int var;
		var = this.getClass ( )
				.getSimpleName ( )
				.compareTo ( empleado.getClass ( )
						.getSimpleName ( ) );
		if ( var == 0 )
		{
			return this.getNombreEmpleado ( )
					.compareTo ( empleado.nombreEmpleado );
		}
		else
		{
			return var;
		}
	}

	@Override
	public int hashCode ( )
	{
		// TODO Cambiar true parametro de entrada a false cuando estemos con BBDD
		return HashCodeBuilder.reflectionHashCode ( this, false );

	}

	@Override
	public boolean equals ( Object obj )
	{
		return EqualsBuilder.reflectionEquals ( this, obj );
	}

}
