package com.everis.csturlam.cursojava.zoologico.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.everis.csturlam.cursojava.zoologico.dominio.AprendizDeCuidador;
import com.everis.csturlam.cursojava.zoologico.dominio.Cetrero;
import com.everis.csturlam.cursojava.zoologico.dominio.Cuidador;
import com.everis.csturlam.cursojava.zoologico.dominio.Empleado;
import com.everis.csturlam.cursojava.zoologico.dto.empleado.EmpleadoCrearDto;
import com.everis.csturlam.cursojava.zoologico.dto.empleado.EmpleadoHabitatDto;
import com.everis.csturlam.cursojava.zoologico.exception.PuestoConsoleException;
import com.everis.csturlam.cursojava.zoologico.util.FechaUtils;

@Component
public class EmpleadoMapper
{

	public Empleado map ( EmpleadoCrearDto empleadoCrearDto ) throws PuestoConsoleException
	{
		return this.setterEmpleado ( this.puestoEmpleado ( empleadoCrearDto ), empleadoCrearDto );
	}

	public EmpleadoCrearDto map ( Empleado empleado )
	{

		EmpleadoCrearDto empleadoCrearDto = new EmpleadoCrearDto ( );

		if ( empleado instanceof Cuidador )
		{
			empleadoCrearDto.setEspecialidadEnMamiferos ( ( ( Cuidador ) empleado ).getEspecialidadMamiferos ( ) );
		}
		if ( empleado instanceof Cetrero )
		{
			empleadoCrearDto.setEspecialidadEnMamiferos ( ( ( Cetrero ) empleado ).getEspecialidadEnAves ( ) );
		}
		empleadoCrearDto.setPuesto ( empleado.getClass ( )
				.getSimpleName ( ) );

		empleadoCrearDto.setNombreEmpleado ( empleado.getNombreEmpleado ( ) );
		empleadoCrearDto.setApellido1 ( empleado.getApellido1 ( ) );
		empleadoCrearDto.setApellido2 ( empleado.getApellido2 ( ) );
		empleadoCrearDto.setDni ( empleado.getDni ( ) );
		empleadoCrearDto.setFechaDeIncorporacionPuesto ( FechaUtils.parsearFechaString ( empleado.getFechaDeIncorporacionPuesto ( ) ) );
		empleadoCrearDto.setFechaDeIncorporacionZoo ( FechaUtils.parsearFechaString ( empleado.getFechaDeIncorporacionZoo ( ) ) );
		empleadoCrearDto.setSueldo ( empleado.getSueldo ( ) );

		return empleadoCrearDto;

	}

	public EmpleadoHabitatDto map ( Cuidador cuidador )
	{

		EmpleadoHabitatDto empleadoCompleto = new EmpleadoHabitatDto ( );

		if ( cuidador instanceof Cuidador )
		{
			empleadoCompleto.setEspecialidadEnMamiferos ( cuidador.getEspecialidadMamiferos ( ) );
		}
		if ( cuidador instanceof Cetrero )
		{
			empleadoCompleto.setEspecialidadEnMamiferos ( ( ( Cetrero ) cuidador ).getEspecialidadEnAves ( ) );
		}
		empleadoCompleto.setPuesto ( cuidador.getClass ( )
				.getSimpleName ( ) );

		empleadoCompleto.setNombreEmpleado ( cuidador.getNombreEmpleado ( ) );
		empleadoCompleto.setApellido1 ( cuidador.getApellido1 ( ) );
		empleadoCompleto.setApellido2 ( cuidador.getApellido2 ( ) );
		empleadoCompleto.setDni ( cuidador.getDni ( ) );
		empleadoCompleto.setFechaDeIncorporacionPuesto ( FechaUtils.parsearFechaString ( cuidador.getFechaDeIncorporacionPuesto ( ) ) );
		empleadoCompleto.setFechaDeIncorporacionZoo ( FechaUtils.parsearFechaString ( cuidador.getFechaDeIncorporacionZoo ( ) ) );
		empleadoCompleto.setSueldo ( cuidador.getSueldo ( ) );

		return empleadoCompleto;

	}

	public List < EmpleadoCrearDto > map ( List < Empleado > listarEmpleado )
	{
		List < EmpleadoCrearDto > listSalidaEmpleado = new ArrayList <> ( );
		for ( Empleado empleado : listarEmpleado )
		{
			listSalidaEmpleado.add ( map ( empleado ) );

		}
		return listSalidaEmpleado;

	}

	private Empleado puestoEmpleado ( EmpleadoCrearDto empleadoCrearDto ) throws PuestoConsoleException
	{

		Empleado empleado;
		switch ( empleadoCrearDto.getPuesto ( ) )
		{
		case "Aprendiz":
			empleado = new AprendizDeCuidador ( );
			break;
		case "Cuidador":
			empleado = new Cuidador ( );
			( ( Cuidador ) empleado ).setEspecialidadMamiferos ( empleadoCrearDto.getEspecialidadEnMamiferos ( ) );
			break;
		case "Cetrero":
			empleado = new Cetrero ( );
			( ( Cetrero ) empleado ).setEspecialidadEnAves ( empleadoCrearDto.getEspecialidadEnAves ( ) );
			break;
		default:
			throw new PuestoConsoleException ( "TIPO DE PUESTO OBLIGATORIO" );
		}

		return empleado;

	}

	private Empleado setterEmpleado ( Empleado empleado, EmpleadoCrearDto empleadoCrearDto )
	{
		empleado.setNombreEmpleado ( empleadoCrearDto.getNombreEmpleado ( ) );
		empleado.setApellido1 ( empleadoCrearDto.getApellido1 ( ) );
		empleado.setApellido2 ( empleadoCrearDto.getApellido2 ( ) );
		empleado.setDni ( empleadoCrearDto.getDni ( ) );
		empleado.setFechaDeIncorporacionZoo ( FechaUtils.parsearFecha ( empleadoCrearDto.getFechaDeIncorporacionZoo ( ) ) );
		empleado.setFechaDeIncorporacionPuesto ( FechaUtils.parsearFecha ( empleadoCrearDto.getFechaDeIncorporacionPuesto ( ) ) );
		empleado.setSueldo ( empleadoCrearDto.getSueldo ( ) );
		return empleado;
	}

	public Cuidador map ( EmpleadoHabitatDto empleadoHabitatDto )
	{
		Cuidador cuidador = new Cuidador ( );

		cuidador.setNombreEmpleado ( empleadoHabitatDto.getNombreEmpleado ( ) );
		cuidador.setApellido1 ( empleadoHabitatDto.getApellido1 ( ) );
		cuidador.setApellido2 ( empleadoHabitatDto.getApellido2 ( ) );
		cuidador.setDni ( empleadoHabitatDto.getDni ( ) );
		cuidador.setFechaDeIncorporacionZoo ( FechaUtils.parsearFecha ( empleadoHabitatDto.getFechaDeIncorporacionZoo ( ) ) );
		cuidador.setFechaDeIncorporacionPuesto ( FechaUtils.parsearFecha ( empleadoHabitatDto.getFechaDeIncorporacionPuesto ( ) ) );
		cuidador.setSueldo ( empleadoHabitatDto.getSueldo ( ) );

		return cuidador;
	}

}
