package com.everis.csturlam.cursojava.zoologico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.everis.csturlam.cursojava.zoologico.dominio.Empleado;

@Repository
public interface EmpleadoRepository
		extends JpaRepository < Empleado, Long >
{
	@Query ( "SELECT empleado FROM Empleado empleado where empleado.id=:id " )
	Empleado findConRelacionesById ( Long id );
}
