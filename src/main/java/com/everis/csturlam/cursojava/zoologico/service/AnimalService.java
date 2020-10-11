package com.everis.csturlam.cursojava.zoologico.service;

import java.io.IOException;
import java.util.List;

import com.everis.csturlam.cursojava.zoologico.dominio.Animal;
import com.everis.csturlam.cursojava.zoologico.dto.animal.AnimalActualizarDto;
import com.everis.csturlam.cursojava.zoologico.dto.animal.AnimalCrearDto;
import com.everis.csturlam.cursojava.zoologico.exception.AnimalTipoException;

public interface AnimalService
{

	Boolean actualizarAnimal ( AnimalActualizarDto animalActualizarDto ) throws IOException, AnimalTipoException;

	AnimalCrearDto obtenerAnimalPorId ( Long id );

	List < AnimalCrearDto > obtenerListaAnimales ( );

	Boolean borrarAnimalPorId ( Long id );

	AnimalCrearDto crear ( AnimalCrearDto animalCrearDto, Long idHabitat ) throws AnimalTipoException;

	Animal crear ( Animal animal );

}