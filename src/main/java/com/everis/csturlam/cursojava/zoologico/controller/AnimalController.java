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

import com.everis.csturlam.cursojava.zoologico.dto.animal.AnimalActualizarDto;
import com.everis.csturlam.cursojava.zoologico.dto.animal.AnimalCrearDto;
import com.everis.csturlam.cursojava.zoologico.exception.AnimalTipoException;
import com.everis.csturlam.cursojava.zoologico.service.AnimalService;

@RestController
@RequestMapping ( "/GestionAnimal" )
public class AnimalController
{

	@Autowired
	private AnimalService animalService;

	// http://localhost:8080/GestionZoo/CrearZoo
	@PostMapping ( path = "/CreaAnimal" )
	public ResponseEntity < AnimalCrearDto > crear ( @RequestBody AnimalCrearDto animalCrearDto, @RequestParam Long idHabitat ) throws AnimalTipoException
	{
		return new ResponseEntity <> ( animalService.crear ( animalCrearDto, idHabitat ), HttpStatus.ACCEPTED );
	}

	@GetMapping ( path = "/ListarTodosAnimales" )
	public ResponseEntity < List < AnimalCrearDto > > obtenerListaAnimales ( )

	{
		return new ResponseEntity <> ( animalService.obtenerListaAnimales ( ), HttpStatus.ACCEPTED );
	}

	@GetMapping ( path = "/BuscarAnimalPorID" )
	public ResponseEntity < AnimalCrearDto > obtenerAnimalPorId ( @RequestParam Long id )
	{
		return new ResponseEntity <> ( animalService.obtenerAnimalPorId ( id ), HttpStatus.ACCEPTED );

	}

	@PutMapping ( path = "/ActualizarAnimal" )
	public ResponseEntity < Boolean > actulizarAnimal ( @RequestBody AnimalActualizarDto animalActualizarDto ) throws IOException, AnimalTipoException
	{
		if ( Boolean.TRUE.equals ( animalService.actualizarAnimal ( animalActualizarDto ) ) )
		{
			return new ResponseEntity <> ( HttpStatus.ACCEPTED );
		}
		else
		{
			return new ResponseEntity <> ( HttpStatus.NOT_FOUND );

		}

	}

	@DeleteMapping ( path = "/BorrarPorID" )
	public ResponseEntity < Boolean > borrarPorID ( @RequestParam Long id )
	{
		if ( Boolean.TRUE.equals ( animalService.borrarAnimalPorId ( id ) ) )
		{
			return new ResponseEntity <> ( HttpStatus.ACCEPTED );

		}
		else
		{
			return new ResponseEntity <> ( HttpStatus.NOT_FOUND );

		}
	}

}