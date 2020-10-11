package com.everis.csturlam.cursojava.zoologico.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.everis.csturlam.cursojava.zoologico.dto.habitat.HabitatActualizarDto;
import com.everis.csturlam.cursojava.zoologico.dto.habitat.HabitatCompletoDto;
import com.everis.csturlam.cursojava.zoologico.dto.habitat.HabitatCrearDto;
import com.everis.csturlam.cursojava.zoologico.service.HabitatService;

@RestController
@RequestMapping ( "/GestionHabitat" )
public class HabitatController
{

	@Autowired
	HabitatService habitatService;

	// http://localhost:8080/GestionZoo/CrearZoo
	@PostMapping ( path = "/CrearHabitat" )
	public ResponseEntity < HabitatCrearDto > crearHabitat ( @RequestBody HabitatCrearDto habitatEmpleadoDto ) throws IOException
	{
		return new ResponseEntity <> ( habitatService.crear ( habitatEmpleadoDto ), HttpStatus.ACCEPTED );
	}

	@GetMapping ( path = "/ListarTodosLosHabitats" )
	public ResponseEntity < List < HabitatCompletoDto > > listadoDeHabitat ( )
	{
		return new ResponseEntity <> ( habitatService.obtenerListaHabitats ( ), HttpStatus.ACCEPTED );

	}

	@GetMapping ( path = "/BuscarHabitatPorID" )
	public ResponseEntity < HabitatCompletoDto > obtenerHabitatPorId ( Long id )
	{
		return new ResponseEntity <> ( habitatService.obtenerHabitatPorId ( id ), HttpStatus.ACCEPTED );

	}

	@DeleteMapping ( path = "/BorrarPorId" )
	public ResponseEntity < Boolean > borrarPorId ( @RequestParam Long id )
	{

		if ( Boolean.TRUE.equals ( habitatService.borrarHabitatPorId ( id ) ) )
		{
			return new ResponseEntity <> ( HttpStatus.ACCEPTED );
		}
		else
		{
			return new ResponseEntity <> ( HttpStatus.NOT_FOUND );
		}

	}

	@PutMapping ( path = "/ActualizarHabitat" )
	public ResponseEntity < Boolean > actualizarHabitat ( @RequestBody HabitatActualizarDto habitatActualizarDto )
	{

		if ( Boolean.TRUE.equals ( habitatService.actualizarHabitat ( habitatActualizarDto ) ) )
		{
			return new ResponseEntity <> ( HttpStatus.ACCEPTED );
		}
		else
		{
			return new ResponseEntity <> ( HttpStatus.NOT_FOUND );
		}

	}

}