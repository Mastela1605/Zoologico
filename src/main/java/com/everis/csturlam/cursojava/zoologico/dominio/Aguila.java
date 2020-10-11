package com.everis.csturlam.cursojava.zoologico.dominio;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table ( name = "AGUILA" )
public class Aguila
		extends Ave

{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6896191393501660408L;

}
