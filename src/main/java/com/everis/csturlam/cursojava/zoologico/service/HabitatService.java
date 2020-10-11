package com.everis.csturlam.cursojava.zoologico.service;

import java.util.List;

import com.everis.csturlam.cursojava.zoologico.dominio.Habitat;
import com.everis.csturlam.cursojava.zoologico.dto.habitat.HabitatActualizarDto;
import com.everis.csturlam.cursojava.zoologico.dto.habitat.HabitatCompletoDto;
import com.everis.csturlam.cursojava.zoologico.dto.habitat.HabitatCrearDto;

public interface HabitatService
{

	HabitatCompletoDto obtenerHabitatPorId ( Long id );

	List < HabitatCompletoDto > obtenerListaHabitats ( );

	Boolean borrarHabitatPorId ( Long id );

	Boolean actualizarHabitat ( HabitatActualizarDto habitatActualizarDto );

	Habitat crear ( Habitat habitat );

	Habitat obtenerHabitatParaAnimal ( Long id );

	HabitatCrearDto crear ( HabitatCrearDto habitatEmpleadoDto );

}