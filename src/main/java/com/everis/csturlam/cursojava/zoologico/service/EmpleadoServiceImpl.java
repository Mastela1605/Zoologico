package com.everis.csturlam.cursojava.zoologico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.csturlam.cursojava.zoologico.dominio.AprendizDeCuidador;
import com.everis.csturlam.cursojava.zoologico.dominio.Cetrero;
import com.everis.csturlam.cursojava.zoologico.dominio.Cuidador;
import com.everis.csturlam.cursojava.zoologico.dominio.Empleado;
import com.everis.csturlam.cursojava.zoologico.dto.empleado.EmpleadoActualizarDto;
import com.everis.csturlam.cursojava.zoologico.dto.empleado.EmpleadoCrearDto;
import com.everis.csturlam.cursojava.zoologico.exception.PuestoConsoleException;
import com.everis.csturlam.cursojava.zoologico.mapper.EmpleadoMapper;
import com.everis.csturlam.cursojava.zoologico.repository.EmpleadoRepository;
import com.everis.csturlam.cursojava.zoologico.util.FechaUtils;

@Service
public class EmpleadoServiceImpl
		implements EmpleadoService
{
	@Autowired
	private EmpleadoRepository empleadoRepository;
	@Autowired
	private EmpleadoMapper empleadoMapper;

	@Override
	public EmpleadoCrearDto crearEmpleado ( EmpleadoCrearDto empleadoCrearDto ) throws PuestoConsoleException
	{

		return empleadoMapper.map ( this.crear ( empleadoMapper.map ( empleadoCrearDto ) ) );

	}

	@Override
	public EmpleadoCrearDto asociarAprendizAlCuidador ( EmpleadoCrearDto empleadoCrearDto, Long idCuidador ) throws PuestoConsoleException
	{
		AprendizDeCuidador aprendiz = ( AprendizDeCuidador ) empleadoMapper.map ( empleadoCrearDto );
		Cuidador cuidador = ( Cuidador ) empleadoRepository.findConRelacionesById ( idCuidador );

		aprendiz.setCuidadorAsignado ( cuidador );
		return empleadoMapper.map ( this.crear ( aprendiz ) );
	}

	@Override
	public Boolean actualizarEmpleado ( EmpleadoActualizarDto empleadoActualizarDto )
	{
		if ( empleadoRepository.existsById ( empleadoActualizarDto.getId ( ) ) )
		{
			Empleado update = empleadoRepository.findConRelacionesById ( empleadoActualizarDto.getId ( ) );
			if ( !empleadoActualizarDto.getNombreEmpleado ( )
					.trim ( )
					.isEmpty ( ) )
			{
				update.setNombreEmpleado ( empleadoActualizarDto.getNombreEmpleado ( ) );
			}
			if ( !empleadoActualizarDto.getApellido1 ( )
					.trim ( )
					.isEmpty ( ) )
			{
				update.setApellido1 ( empleadoActualizarDto.getApellido1 ( ) );
			}
			if ( !empleadoActualizarDto.getApellido2 ( )
					.trim ( )
					.isEmpty ( ) )
			{
				update.setApellido2 ( empleadoActualizarDto.getApellido2 ( ) );
			}
			if ( empleadoActualizarDto.getFechaDeIncorporacionZoo ( ) != null )
			{
				update.setFechaDeIncorporacionZoo ( FechaUtils.parsearFecha ( empleadoActualizarDto.getFechaDeIncorporacionZoo ( ) ) );
			}
			if ( empleadoActualizarDto.getFechaDeIncorporacionPuesto ( ) != null )
			{
				update.setFechaDeIncorporacionPuesto ( FechaUtils.parsearFecha ( empleadoActualizarDto.getFechaDeIncorporacionPuesto ( ) ) );
			}
			if ( empleadoActualizarDto.getSueldo ( ) != 0 )
			{
				update.setSueldo ( empleadoActualizarDto.getSueldo ( ) );
			}
			if ( ( update instanceof Cuidador ) && ( empleadoActualizarDto.getEspecialidadEnMamiferos ( ) != null ) )
			{
				( ( Cuidador ) update ).setEspecialidadMamiferos ( empleadoActualizarDto.getEspecialidadEnMamiferos ( ) );
			}
			if ( ( update instanceof Cetrero ) && ( empleadoActualizarDto.getEspecialidadEnAves ( ) != null ) )
			{
				( ( Cetrero ) update ).setEspecialidadEnAves ( empleadoActualizarDto.getEspecialidadEnAves ( ) );
			}
			this.crear ( update );
			return true;
		}
		else
		{
			return false;
		}

	}

	@Override
	public Empleado crear ( Empleado empleado )
	{
		return empleadoRepository.save ( empleado );

	}

	@Override
	public EmpleadoCrearDto obtenerEmpleadoPorId ( Long id )
	{
		return empleadoMapper.map ( empleadoRepository.findConRelacionesById ( id ) );
	}

	@Override
	public List < EmpleadoCrearDto > obtenerListaEmpleados ( )
	{
		return empleadoMapper.map ( empleadoRepository.findAll ( ) );
	}

	public Boolean borrarEmpleadoPorId ( Long id )
	{
		if ( empleadoRepository.existsById ( id ) )
		{
			empleadoRepository.deleteById ( id );
			return true;
		}
		else
		{
			return false;
		}
	}

}
