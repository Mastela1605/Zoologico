package com.everis.csturlam.cursojava.zoologico.dominio;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table ( name = "LORO" )
@DiscriminatorValue ( "LORO" )
public class Loro
		extends Ave

{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2132550733279713740L;

}