package com.everis.csturlam.cursojava.zoologico.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table ( name = "AREA" )
public class Area
		implements Comparable < Area >, Serializable
{

	@Id
	@Column ( name = "ID" )
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	private Long id;
	@Column ( name = "NOMBRE_CONTINENTE" )
	private String nombreContinente;
	@OneToMany ( mappedBy = "areaHabitat", fetch = FetchType.LAZY )
	private List < Habitat > listaHabitat;
	@JsonIgnore
	@ManyToOne
	@JoinColumn ( name = "FK_ZOOAREA" )
	private Zoo zooArea;

	public Area ( )
	{
		listaHabitat = new ArrayList <> ( );
	}

	@Override
	public int compareTo ( Area o )
	{
		int aux;

		aux = this.nombreContinente.compareTo ( o.nombreContinente );

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
