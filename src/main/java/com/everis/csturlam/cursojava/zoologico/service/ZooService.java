package com.everis.csturlam.cursojava.zoologico.service;

import java.util.List;

import com.everis.csturlam.cursojava.zoologico.dominio.Zoo;
import com.everis.csturlam.cursojava.zoologico.dto.zoo.ZooActualizarDto;
import com.everis.csturlam.cursojava.zoologico.dto.zoo.ZooCompletoDto;
import com.everis.csturlam.cursojava.zoologico.dto.zoo.ZooCrearDto;

public interface ZooService
{

	Boolean borrarZooPorId ( Long id );

	Zoo crear ( Zoo zoo );

	List < ZooCompletoDto > obtenerListaZoos ( );

	ZooCompletoDto obtenerZooPorId ( Long id );

	ZooCrearDto crear ( ZooCrearDto zooCrearDto );

	Boolean actualizarZoo ( ZooActualizarDto zooActualizarDto );

	Boolean asociarAreaAlZoo ( Long idArea, Long idZoo );

}