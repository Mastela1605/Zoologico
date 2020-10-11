package com.everis.csturlam.cursojava.zoologico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.everis.csturlam.cursojava.zoologico.dominio.Animal;

@Repository
public interface AnimalRepository
		extends JpaRepository < Animal, Long >
{
	@Query ( "SELECT animal FROM Animal animal where animal.id=:id " )
	Animal findConRelacionesByIdAnimal ( Long id );
}
