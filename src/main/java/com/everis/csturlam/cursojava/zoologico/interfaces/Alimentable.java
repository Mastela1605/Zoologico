package com.everis.csturlam.cursojava.zoologico.interfaces;

import com.everis.csturlam.cursojava.zoologico.exception.AnimalAveNoAlimentableException;

public interface Alimentable
{
	public String recibirAlimento ( ) throws AnimalAveNoAlimentableException;

}