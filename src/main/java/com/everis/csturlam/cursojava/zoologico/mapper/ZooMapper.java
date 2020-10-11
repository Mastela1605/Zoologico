package com.everis.csturlam.cursojava.zoologico.mapper;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.everis.csturlam.cursojava.zoologico.dominio.Area;
import com.everis.csturlam.cursojava.zoologico.dominio.Zoo;
import com.everis.csturlam.cursojava.zoologico.dto.zoo.ZooCompletoDto;
import com.everis.csturlam.cursojava.zoologico.dto.zoo.ZooCrearDto;
import com.everis.csturlam.cursojava.zoologico.util.FechaUtils;

@Component
public class ZooMapper
{

	@Autowired
	private AreaMapper areaMapper;

	public Zoo map ( ZooCrearDto zooCrearDto )
	{
		Zoo zoo = new Zoo ( );

		zoo.setNombre ( zooCrearDto.getNombre ( ) );
		zoo.setFechaApertura ( FechaUtils.parsearFecha ( zooCrearDto.getFechaApertura ( ) ) );
		zoo.setHoraApertura ( LocalTime.parse ( zooCrearDto.getHoraApertura ( ) ) );
		zoo.setHoraCierre ( LocalTime.parse ( zooCrearDto.getHoraCierre ( ) ) );
		zoo.setPrecioAdulto ( zooCrearDto.getPrecioAdulto ( ) );
		zoo.setPrecioInfantil ( zooCrearDto.getPrecioInfantil ( ) );
		zoo.setUbicacion ( zooCrearDto.getUbicacion ( ) );

		return zoo;
	}

	public ZooCrearDto map ( Zoo zoo )
	{
		ZooCrearDto crear = new ZooCrearDto ( );

		crear.setNombre ( zoo.getNombre ( ) );
		crear.setHoraCierre ( String.valueOf ( zoo.getHoraCierre ( ) ) );
		crear.setFechaApertura ( FechaUtils.parsearFechaString ( zoo.getFechaApertura ( ) ) );
		crear.setPrecioAdulto ( zoo.getPrecioAdulto ( ) );
		crear.setPrecioInfantil ( zoo.getPrecioInfantil ( ) );
		crear.setUbicacion ( zoo.getUbicacion ( ) );

		return crear;

	}

	public ZooCompletoDto mapCompleto ( Zoo zoo )
	{
		ZooCompletoDto zooCompleto = new ZooCompletoDto ( );

		zooCompleto.setNombre ( zoo.getNombre ( ) );
		zooCompleto.setHoraCierre ( String.valueOf ( zoo.getHoraCierre ( ) ) );
		zooCompleto.setFechaApertura ( FechaUtils.parsearFechaString ( zoo.getFechaApertura ( ) ) );
		zooCompleto.setPrecioAdulto ( zoo.getPrecioAdulto ( ) );
		zooCompleto.setPrecioInfantil ( zoo.getPrecioInfantil ( ) );
		zooCompleto.setUbicacion ( zoo.getUbicacion ( ) );
		zooCompleto.setListaArea ( areaMapper.map ( zoo.getListaArea ( ) ) );

		return zooCompleto;
	}

	public List < ZooCompletoDto > map ( List < Zoo > listarZoo )
	{
		List < ZooCompletoDto > listSalidaZooDtos = new ArrayList <> ( );
		for ( Zoo zoo : listarZoo )
		{
			listSalidaZooDtos.add ( this.mapCompleto ( zoo ) );

		}
		return listSalidaZooDtos;

	}

	public void map ( Zoo zoo, Area area )
	{
		area.setZooArea ( zoo );

	}

}
