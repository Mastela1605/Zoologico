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

import com.everis.csturlam.cursojava.zoologico.dto.empleado.EmpleadoActualizarDto;
import com.everis.csturlam.cursojava.zoologico.dto.empleado.EmpleadoCrearDto;
import com.everis.csturlam.cursojava.zoologico.exception.PuestoConsoleException;
import com.everis.csturlam.cursojava.zoologico.service.EmpleadoService;

@RestController
@RequestMapping ( "/GestionEmpleado" )
public class EmpleadoController
{
	@Autowired
	private EmpleadoService empleadoService;

	// http://localhost:8080/GestionZoo/CrearZoo
	@PostMapping ( path = "/CreaEmpleado" )
	public ResponseEntity < EmpleadoCrearDto > crearEmpleado ( @RequestBody EmpleadoCrearDto empleadoCrearDto ) throws PuestoConsoleException
	{
		return new ResponseEntity <> ( empleadoService.crearEmpleado ( empleadoCrearDto ), HttpStatus.ACCEPTED );
	}

	@GetMapping ( path = "/ListarTodosEmpleados" )
	public ResponseEntity < List < EmpleadoCrearDto > > obtenerListaEmpleado ( )

	{

		return new ResponseEntity <> ( empleadoService.obtenerListaEmpleados ( ), HttpStatus.ACCEPTED );

	}

	@GetMapping ( path = "/BuscarEmpleadoPorId" )
	public ResponseEntity < EmpleadoCrearDto > obtenerAnimalPorId ( @RequestParam Long id )
	{
		return new ResponseEntity <> ( empleadoService.obtenerEmpleadoPorId ( id ), HttpStatus.ACCEPTED );
	}

	@PutMapping ( path = "/ActualizarEmpleado" )
	public ResponseEntity < Boolean > actualizarEmpleado ( @RequestBody EmpleadoActualizarDto empleadoActualizarDto )
	{
		if ( Boolean.TRUE.equals ( empleadoService.actualizarEmpleado ( empleadoActualizarDto ) ) )
		{
			return new ResponseEntity <> ( HttpStatus.ACCEPTED );
		}
		else
		{
			return new ResponseEntity <> ( HttpStatus.NOT_FOUND );

		}

	}

	@DeleteMapping ( path = "/BorrarEmpleado" )
	public ResponseEntity < Boolean > borrarEmpleado ( @RequestParam Long id )
	{

		if ( Boolean.TRUE.equals ( empleadoService.borrarEmpleadoPorId ( id ) ) )
		{
			return new ResponseEntity <> ( HttpStatus.ACCEPTED );
		}
		else
		{
			return new ResponseEntity <> ( HttpStatus.NOT_FOUND );
		}
	}

	@PutMapping ( "/AsociarAprendizAlCuidador" )
	public ResponseEntity < EmpleadoCrearDto > asociarAprendiz ( @RequestBody EmpleadoCrearDto empleadoCrearDto, @RequestParam Long idCuidador ) throws PuestoConsoleException
	{
		return new ResponseEntity <> ( empleadoService.asociarAprendizAlCuidador ( empleadoCrearDto, idCuidador ), HttpStatus.ACCEPTED );
	}

}