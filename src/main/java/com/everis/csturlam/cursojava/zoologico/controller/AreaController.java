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

import com.everis.csturlam.cursojava.zoologico.dto.area.AreaActualizarDto;
import com.everis.csturlam.cursojava.zoologico.dto.area.AreaCompletoDto;
import com.everis.csturlam.cursojava.zoologico.dto.area.AreaCrearDto;
import com.everis.csturlam.cursojava.zoologico.service.AreaService;

@RestController
@RequestMapping ( "/GestionArea" )
public class AreaController
{

	@Autowired
	private AreaService areaService;

	// http://localhost:8080/GestionZoo/CrearZoo
	@PostMapping ( path = "/CreaArea" )
	public ResponseEntity < AreaCrearDto > crear ( @RequestBody AreaCrearDto areaCrearDto, @RequestParam Long idHabitat )
	{
		return new ResponseEntity <> ( areaService.crear ( areaCrearDto, idHabitat ), HttpStatus.ACCEPTED );
	}

	@GetMapping ( path = "/ListarTodasAreas" )
	public ResponseEntity < List < AreaCompletoDto > > obtenerListaAreas ( )

	{
		return new ResponseEntity <> ( areaService.obtenerListaAreas ( ), HttpStatus.ACCEPTED );
	}

	@GetMapping ( path = "/BuscarAreasPorID" )
	public ResponseEntity < AreaCompletoDto > obtenerAreaPorId ( @RequestParam Long id )
	{
		return new ResponseEntity <> ( areaService.obtenerAreaPorId ( id ), HttpStatus.ACCEPTED );

	}

	@PutMapping ( path = "/ActualizarArea" )
	public ResponseEntity < Boolean > actulizarArea ( @RequestBody AreaActualizarDto areaActualizarDto )
	{
		if ( Boolean.TRUE.equals ( areaService.actualizarArea ( areaActualizarDto ) ) )
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
		if ( Boolean.TRUE.equals ( areaService.borrarAreaPorId ( id ) ) )
		{
			return new ResponseEntity <> ( HttpStatus.ACCEPTED );

		}
		else
		{
			return new ResponseEntity <> ( HttpStatus.NOT_FOUND );

		}
	}

}