package com.everis.csturlam.cursojava.zoologico.service;

import java.util.List;

import com.everis.csturlam.cursojava.zoologico.dominio.Empleado;
import com.everis.csturlam.cursojava.zoologico.dto.empleado.EmpleadoActualizarDto;
import com.everis.csturlam.cursojava.zoologico.dto.empleado.EmpleadoCrearDto;
import com.everis.csturlam.cursojava.zoologico.exception.PuestoConsoleException;

public interface EmpleadoService
{

	Boolean actualizarEmpleado ( EmpleadoActualizarDto empleadoActualizarDto );

	Empleado crear ( Empleado empleado );

	EmpleadoCrearDto obtenerEmpleadoPorId ( Long id );

	List < EmpleadoCrearDto > obtenerListaEmpleados ( );

	EmpleadoCrearDto crearEmpleado ( EmpleadoCrearDto empleadoCrearDto ) throws PuestoConsoleException;

	EmpleadoCrearDto asociarAprendizAlCuidador ( EmpleadoCrearDto empleadoCrearDto, Long idCuidador ) throws PuestoConsoleException;

	Boolean borrarEmpleadoPorId ( Long id );

}