package com.everis.csturlam.cursojava.zoologico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.everis.csturlam.cursojava.zoologico.dominio.Habitat;

@Repository
public interface HabitatRepository
		extends JpaRepository < Habitat, Long >
{
	@Query ( "SELECT habitat FROM Habitat habitat JOIN FETCH habitat.listaAnimal where habitat.id=:id " )
	Habitat findConRelacionesHabitatById ( Long id );

	@Query ( "SELECT habitat FROM Habitat habitat where habitat.id=:id " )
	Habitat findHabitatById ( Long id );
}
