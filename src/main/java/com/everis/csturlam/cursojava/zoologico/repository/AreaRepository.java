package com.everis.csturlam.cursojava.zoologico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.everis.csturlam.cursojava.zoologico.dominio.Area;

@Repository
public interface AreaRepository
		extends JpaRepository < Area, Long >
{
	@Query ( "SELECT area FROM Area area JOIN FETCH area.listaHabitat where area.id=:id " )
	Area findConRelacionesAreasById ( Long id );

	@Query ( "SELECT area FROM Area area where area.id=:id " )
	Area findAreasById ( Long id );

}
