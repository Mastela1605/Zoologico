package com.everis.csturlam.cursojava.zoologico.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.csturlam.cursojava.zoologico.dominio.Area;
import com.everis.csturlam.cursojava.zoologico.dominio.Zoo;
import com.everis.csturlam.cursojava.zoologico.dto.zoo.ZooActualizarDto;
import com.everis.csturlam.cursojava.zoologico.dto.zoo.ZooCompletoDto;
import com.everis.csturlam.cursojava.zoologico.dto.zoo.ZooCrearDto;
import com.everis.csturlam.cursojava.zoologico.mapper.ZooMapper;
import com.everis.csturlam.cursojava.zoologico.repository.ZooRepository;
import com.everis.csturlam.cursojava.zoologico.util.FechaUtils;

@Service
public class ZooServiceImpl
		implements ZooService

{

	@Autowired
	private ZooRepository zooRepository;
	@Autowired
	private ZooMapper zooMapper;

	@Autowired
	private AreaService areaService;

	@Override
	public Boolean actualizarZoo ( ZooActualizarDto zooActualizarDto )
	{
		if ( zooRepository.existsById ( zooActualizarDto.getId ( ) ) )
		{
			Zoo update = zooRepository.findZooById ( zooActualizarDto.getId ( ) );
			if ( !zooActualizarDto.getNombre ( )
					.trim ( )
					.isEmpty ( ) )
			{
				update.setNombre ( zooActualizarDto.getNombre ( ) );
			}
			if ( zooActualizarDto.getFechaApertura ( ) != null )
			{
				update.setFechaApertura ( FechaUtils.parsearFecha ( zooActualizarDto.getFechaApertura ( ) ) );
			}
			if ( zooActualizarDto.getHoraApertura ( ) != null )
			{
				update.setHoraApertura ( LocalTime.parse ( zooActualizarDto.getHoraApertura ( ) ) );
			}
			if ( zooActualizarDto.getHoraCierre ( ) != null )
			{
				update.setHoraCierre ( LocalTime.parse ( zooActualizarDto.getHoraCierre ( ) ) );
			}
			if ( zooActualizarDto.getPrecioAdulto ( ) != null )
			{
				update.setPrecioAdulto ( zooActualizarDto.getPrecioAdulto ( ) );
			}
			if ( zooActualizarDto.getPrecioInfantil ( ) != null )
			{
				update.setPrecioInfantil ( zooActualizarDto.getPrecioInfantil ( ) );
			}
			if ( !zooActualizarDto.getUbicacion ( )
					.trim ( )
					.isEmpty ( ) )
			{
				update.setUbicacion ( zooActualizarDto.getUbicacion ( ) );
			}
			this.crear ( update );
			return true;
		}
		else
		{
			return false;
		}

	}

	@Override
	public ZooCrearDto crear ( ZooCrearDto zooCrearDto )
	{

		return zooMapper.map ( this.crear ( zooMapper.map ( zooCrearDto ) ) );
	}

	@Override
	public ZooCompletoDto obtenerZooPorId ( Long id )
	{
		return zooMapper.mapCompleto ( zooRepository.findZooById ( id ) );
	}

	@Override
	public List < ZooCompletoDto > obtenerListaZoos ( )
	{
		return zooMapper.map ( zooRepository.findAll ( ) );
	}

	@Override
	public Zoo crear ( Zoo zoo )
	{
		return zooRepository.save ( zoo );
	}

	@Override
	public Boolean borrarZooPorId ( Long id )
	{
		if ( zooRepository.existsById ( id ) )
		{
			Zoo zoo = zooRepository.findZooById ( id );

			for ( Area area : zoo.getListaArea ( ) )
			{
				area.setZooArea ( null );
				areaService.crear ( area );
			}
			zooRepository.deleteById ( id );
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public Boolean asociarAreaAlZoo ( Long idArea, Long idZoo )
	{
		if ( zooRepository.findZooById ( idZoo ) != null && areaService.obtenerAreaParaZooId ( idArea ) != null )
		{

			zooMapper.map ( zooRepository.findZooById ( idZoo ), areaService.obtenerAreaParaZooId ( idArea ) );

			areaService.crear ( areaService.obtenerAreaParaZooId ( idArea ) );
			return true;
		}
		else
		{
			return false;
		}

	}
}
