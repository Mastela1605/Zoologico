package com.everis.csturlam.cursojava.zoologico.controller;

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

import com.everis.csturlam.cursojava.zoologico.dto.zoo.ZooActualizarDto;
import com.everis.csturlam.cursojava.zoologico.dto.zoo.ZooCompletoDto;
import com.everis.csturlam.cursojava.zoologico.dto.zoo.ZooCrearDto;
import com.everis.csturlam.cursojava.zoologico.service.ZooService;

@RestController
@RequestMapping ( "/GestionZoo" )
public class ZooController
{

	@Autowired
	private ZooService zooService;

	// http://localhost:8080/GestionZoo/CrearZoo
	@PostMapping ( path = "/CrearZoo" )
	public ResponseEntity < ZooCrearDto > crear ( @RequestBody ZooCrearDto zooCrearDto )
	{
		return new ResponseEntity <> ( zooService.crear ( zooCrearDto ), HttpStatus.ACCEPTED );
	}

	@GetMapping ( path = "/ListarTodosZoos" )
	public ResponseEntity < List < ZooCompletoDto > > listadoDeZoos ( )
	{
		return new ResponseEntity <> ( zooService.obtenerListaZoos ( ), HttpStatus.ACCEPTED );

	}

	@GetMapping ( path = "/BuscarZooPorID" )
	public ResponseEntity < ZooCompletoDto > obtenerZooPorId ( @RequestParam Long id )
	{
		return new ResponseEntity <> ( zooService.obtenerZooPorId ( id ), HttpStatus.ACCEPTED );

	}

	@PutMapping ( path = "/ActualizarZoo" )
	public ResponseEntity < Boolean > actulizarZoo ( @RequestBody ZooActualizarDto zooActualizarDto )
	{
		if ( Boolean.TRUE.equals ( zooService.actualizarZoo ( zooActualizarDto ) ) )
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
		if ( Boolean.TRUE.equals ( zooService.borrarZooPorId ( id ) ) )
		{
			return new ResponseEntity <> ( HttpStatus.ACCEPTED );

		}
		else
		{
			return new ResponseEntity <> ( HttpStatus.NOT_FOUND );

		}
	}

	@PutMapping ( path = "/AsociarAreaAlZoo" )
	public ResponseEntity < Boolean > asociarAreaAlZoo ( @RequestParam Long idZoo, @RequestParam Long idArea )
	{
		if ( Boolean.TRUE.equals ( zooService.asociarAreaAlZoo ( idArea, idZoo ) ) )
		{
			return new ResponseEntity <> ( HttpStatus.ACCEPTED );

		}
		else
		{
			return new ResponseEntity <> ( HttpStatus.NOT_FOUND );

		}
	}

}