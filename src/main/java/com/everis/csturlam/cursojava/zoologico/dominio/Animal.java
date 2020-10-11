package com.everis.csturlam.cursojava.zoologico.dominio;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.everis.csturlam.cursojava.zoologico.exception.AnimalAveNoAlimentableException;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

//Clase padre de Ave y Mamifero
@Getter
@Setter
@Entity
@Inheritance ( strategy = InheritanceType.JOINED )
@DiscriminatorColumn ( discriminatorType = DiscriminatorType.STRING, name = "ESPECIE" )
@Table ( name = "ANIMAL" )
public abstract class Animal
		implements Comparable < Animal >, Serializable

{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8973654419326381411L;
	@Id
	@Column ( name = "ID" )
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	protected Long id;
	@Column ( name = "NOMBRE" )
	protected String nombre;
	@Column ( name = "ALIMENTO" )
	protected String alimento;
	@Column ( name = "HAMBRE" )
	protected Boolean hambre = true;
	@Column ( name = "REFERENCIA_ANIMAL" )
	protected String referenciaAnimal;
	@Column ( name = "FECHA_NACIMIENTO" )
	protected LocalDateTime fechaNacimiento;
	@Column ( name = "ORIGEN" )
	protected String origen;
	@Column ( name = "FECHA_LLEGADA" )
	protected LocalDate fechaLlegada;
	@Column ( name = "ALTURA" )
	protected Float altura;
	@Column ( name = "PESO" )
	protected Float peso;
	@JsonIgnore
	@ManyToOne
	@JoinColumn ( name = "FK_HABITATANIMAL" )
	protected Habitat listaHabitatAnimal;

	public String recibirAlimento ( ) throws AnimalAveNoAlimentableException
	{
		String salida;

		if ( Boolean.TRUE.equals ( this.hambre ) )
		{

			salida = String.format ( "%s : me encanta comer %s %n", this.nombre, this.alimento );
			this.hambre = false;
		}
		else
		{
			salida = String.format ( "%s : flsssssasasssssssss %n", this.nombre );
		}
		return salida;
	}

	@Override
	public int compareTo ( Animal animal )
	{
		int var;
		var = this.getClass ( )
				.getSimpleName ( )
				.compareTo ( animal.getClass ( )
						.getSimpleName ( ) );
		if ( var == 0 )
		{
			return this.getNombre ( )
					.compareTo ( animal.nombre );
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
