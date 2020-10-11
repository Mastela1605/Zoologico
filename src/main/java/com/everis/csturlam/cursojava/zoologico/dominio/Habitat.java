package com.everis.csturlam.cursojava.zoologico.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table ( name = "HABITAT" )
public class Habitat
		implements Comparable < Habitat >, Serializable

{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8405034447388157668L;
	@Id
	@Column ( name = "ID" )
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	private Long id;
	@Column ( name = "NOMBRE" )
	private String nombre;
	// Atributo cuidadorPrincipal el cual esta asociado a la clase Cuidador para que solo pueda informarla objetos de dicha clase,
	// por otro lado tiene el parametro "final" que hace que lo que se informe durante la ejecucion no se pueda cambiar.
	@OneToOne
	@JoinColumn ( name = "FK_CUIDADOR", nullable = true )
	private Cuidador cuidadorPrincipal;

	// Atributo ayudanteDeCuidadorPrincipal asociado a la clase Empleado,
	// para que asi se le pueda informar las clases hijas que cuelgan de el , como es Cuidador y AprendizDeCuidador.
	@OneToOne
	@JoinColumn ( name = "FK_AYUDANTEDECUIDADORPRINCIPAL" )
	private Empleado ayundanteDeCuidadorPrincipal;

	// Atributo animales lista, para poder realizar el listado de los animales que se informan en el main.
	@OneToMany ( mappedBy = "listaHabitatAnimal", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE )
	private List < Animal > listaAnimal;

	@JsonIgnore
	@ManyToOne
	@JoinColumn ( name = "FK_AREAHABITAT" )
	private Area areaHabitat;

	/**
	 * 
	 * Constructor que inicializa la variable cuidadorPrincipal con objeto de la Clase Cuidador, en este caso al ser un constructor y estar asociado a la clase Habitat, para informar el parametro de entrada se debe informar de la siguiente Forma Habitat habitat1 = new Habitat ("objeto del Cuidador");
	 * 
	 * @param cuidadorObligatorio
	 */
	public Habitat ( )
	{

		super ( );
		listaAnimal = new ArrayList <> ( );

	}

	// Metodo alimentarTodosAnimales la cual contiene un for de la lista animales,
	// donde el atributo cuidadorPrincipal asociada a la Clase Cuidador , tiene la funcion alimentar, donde se le pasa el
	// parametro animal(objeto pertenecientes a la lista de "this.animales")
	public void alimentarTodosAnimales ( )
	{
		for ( Animal animal : this.listaAnimal )
		{

			System.out.printf ( this.cuidadorPrincipal.alimentar ( animal ) );

		}
	}

	@Override
	public int compareTo ( Habitat o )
	{
		int aux;

		aux = this.nombre.compareTo ( o.nombre );

		return aux;
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
