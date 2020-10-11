package com.everis.csturlam.cursojava.zoologico.service;

import java.util.List;

import com.everis.csturlam.cursojava.zoologico.dominio.Area;
import com.everis.csturlam.cursojava.zoologico.dto.area.AreaActualizarDto;
import com.everis.csturlam.cursojava.zoologico.dto.area.AreaCompletoDto;
import com.everis.csturlam.cursojava.zoologico.dto.area.AreaCrearDto;

public interface AreaService
{

	Boolean actualizarArea ( AreaActualizarDto AreaActualizarDto );

	AreaCrearDto crear ( AreaCrearDto areaCrearDto, Long idHabitat );

	AreaCompletoDto obtenerAreaPorId ( Long id );

	List < AreaCompletoDto > obtenerListaAreas ( );

	Area crear ( Area area );

	Boolean borrarAreaPorId ( Long id );

	Area obtenerAreaParaZooId ( Long id );
}