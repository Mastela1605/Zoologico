package com.everis.csturlam.cursojava.zoologico.dominio;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table ( name = "LEON" )
public class Leon
		extends Mamifero
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5226808007289118894L;

}
