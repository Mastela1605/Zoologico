package com.everis.csturlam.cursojava.zoologico.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.everis.csturlam.cursojava.zoologico.dominio.Area;
import com.everis.csturlam.cursojava.zoologico.dominio.Habitat;
import com.everis.csturlam.cursojava.zoologico.dto.area.AreaActualizarDto;
import com.everis.csturlam.cursojava.zoologico.dto.area.AreaCompletoDto;
import com.everis.csturlam.cursojava.zoologico.dto.area.AreaCrearDto;
import com.everis.csturlam.cursojava.zoologico.mapper.AreaMapper;
import com.everis.csturlam.cursojava.zoologico.repository.AreaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AreaServiceImpl
		implements AreaService
{

	private final AreaRepository areaRepository;
	private final AreaMapper areaMapper;
	private final HabitatService habitatService;

	@Override
	public Boolean actualizarArea ( AreaActualizarDto areaActualizarDto )
	{
		Boolean exito = Boolean.FALSE;

		if ( areaRepository.existsById ( areaActualizarDto.getId ( ) ) )
		{
			Area update = areaRepository.findAreasById ( areaActualizarDto.getId ( ) );
			if ( !areaActualizarDto.getNombre ( )
					.trim ( )
					.isEmpty ( ) )
			{
				update.setNombreContinente ( areaActualizarDto.getNombre ( ) );
			}
			this.crear ( update );
			exito = Boolean.TRUE;
		}

		return exito;
	}

	@Override
	public AreaCrearDto crear ( AreaCrearDto areaCrearDto, Long idHabitat )
	{
		Area continente = areaMapper.map ( areaCrearDto );
		Habitat habitat = habitatService.obtenerHabitatParaAnimal ( idHabitat );
		areaMapper.map ( continente, habitat );

		return areaMapper.map ( this.crear ( continente ) );
	}

	@Override
	public AreaCompletoDto obtenerAreaPorId ( Long id )
	{
		return areaMapper.mapCompleto ( areaRepository.findAreasById ( id ) );
	}

	@Override
	public List < AreaCompletoDto > obtenerListaAreas ( )
	{
		return areaMapper.map ( areaRepository.findAll ( ) );
	}

	@Override
	public Area crear ( Area area )
	{
		return areaRepository.save ( area );
	}

	@Override
	public Boolean borrarAreaPorId ( Long id )
	{
		if ( areaRepository.existsById ( id ) )
		{
			Area area = areaRepository.findAreasById ( id );

			for ( Habitat habitat : area.getListaHabitat ( ) )
			{
				habitat.setAreaHabitat ( null );
				habitatService.crear ( habitat );
			}

			areaRepository.deleteById ( id );
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public Area obtenerAreaParaZooId ( Long id )
	{
		return areaRepository.findAreasById ( id );
	}
}
