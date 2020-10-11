package com.everis.csturlam.cursojava.zoologico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.everis.csturlam.cursojava.zoologico.dominio.Cuidador;

@Repository
public interface CuidadorRepository
		extends JpaRepository < Cuidador, Long >
{
	@Query ( "SELECT cuidador FROM Cuidador cuidador where cuidador.id=:id " )
	Cuidador findConRelacionesById ( Long id );
}
