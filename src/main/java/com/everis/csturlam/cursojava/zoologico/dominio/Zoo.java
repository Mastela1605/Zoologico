package com.everis.csturlam.cursojava.zoologico.dominio;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table ( name = "ZOO" )
public class Zoo
		implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5276666517777152902L;
	@Id
	@Column ( name = "ID" )
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	private Long id;
	@Column ( name = "NOMBRE" )
	private String nombre;
	@Column ( name = "UBICACION" )
	private String ubicacion;
	@Column ( name = "FECHA_APERTURA" )
	private LocalDate fechaApertura;
	@Column ( name = "HORA_APERTURA" )
	private LocalTime horaApertura;
	@Column ( name = "HORA_CIERRE" )
	private LocalTime horaCierre;
	@Column ( name = "PRECIO_ADULTO" )
	private Float precioAdulto;
	@Column ( name = "PRECIO_INFANTIL" )
	private Float precioInfantil;
	@OneToMany ( mappedBy = "zooArea", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE )
	private List < Area > listaArea;

	public Zoo ( )
	{
		super ( );
		listaArea = new ArrayList <> ( );
	}
}
