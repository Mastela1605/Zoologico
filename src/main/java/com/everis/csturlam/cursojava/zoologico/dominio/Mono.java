package com.everis.csturlam.cursojava.zoologico.dominio;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table ( name = "MONO" )
public class Mono
		extends Mamifero

{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2618419001792393247L;

}
