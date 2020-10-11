package com.everis.csturlam.cursojava.zoologico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.everis.csturlam.cursojava.zoologico.dominio.Zoo;

@Repository
public interface ZooRepository
		extends JpaRepository < Zoo, Long >
{

	@Query ( "SELECT zoo FROM Zoo zoo JOIN FETCH zoo.listaArea where zoo.id=:id " )
	Zoo findConRelacionesAreasById ( Long id );

	@Query ( "SELECT zoo FROM Zoo zoo where zoo.id=:id " )
	Zoo findZooById ( Long id );
}
