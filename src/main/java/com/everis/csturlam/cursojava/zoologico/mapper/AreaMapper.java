package com.everis.csturlam.cursojava.zoologico.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.everis.csturlam.cursojava.zoologico.dominio.Area;
import com.everis.csturlam.cursojava.zoologico.dominio.Habitat;
import com.everis.csturlam.cursojava.zoologico.dto.area.AreaCompletoDto;
import com.everis.csturlam.cursojava.zoologico.dto.area.AreaCrearDto;

@Component
public class AreaMapper
{

	@Autowired
	private HabitatMapper habitatMapper;

	public Area map ( AreaCrearDto areaCrearDto )
	{
		Area continente = new Area ( );

		continente.setNombreContinente ( areaCrearDto.getNombre ( ) );

		return continente;
	}

	public AreaCrearDto map ( Area area )
	{

		AreaCrearDto areaCrearDto = new AreaCrearDto ( );

		areaCrearDto.setNombre ( area.getNombreContinente ( ) );

		return areaCrearDto;

	}

	public AreaCompletoDto mapCompleto ( Area area )
	{
		AreaCompletoDto areaCompleto = new AreaCompletoDto ( );

		areaCompleto.setNombre ( area.getNombreContinente ( ) );
		areaCompleto.setListaHabitat ( habitatMapper.map ( area.getListaHabitat ( ) ) );

		return areaCompleto;
	}

	public List < AreaCompletoDto > map ( List < Area > listarAreas )
	{
		List < AreaCompletoDto > listSalidaAreaCrearDtos = new ArrayList <> ( );
		for ( Area continente : listarAreas )
		{
			listSalidaAreaCrearDtos.add ( this.mapCompleto ( continente ) );

		}
		return listSalidaAreaCrearDtos;

	}

	public void map ( Area area, Habitat habitat )
	{
		habitat.setAreaHabitat ( area );

	}
}
