package com.everis.csturlam.cursojava.zoologico.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.everis.csturlam.cursojava.zoologico.dominio.Cuidador;
import com.everis.csturlam.cursojava.zoologico.dominio.Empleado;
import com.everis.csturlam.cursojava.zoologico.dominio.Habitat;
import com.everis.csturlam.cursojava.zoologico.dto.habitat.HabitatCompletoDto;
import com.everis.csturlam.cursojava.zoologico.dto.habitat.HabitatCrearDto;

@Component
public class HabitatMapper
{
	@Autowired
	private EmpleadoMapper empleadoMapper;
	@Autowired
	private AnimalMapper animalMapper;

	public Habitat map ( HabitatCrearDto habitatEmpleadoDto )
	{
		Habitat ambiente = new Habitat ( );
		ambiente.setNombre ( habitatEmpleadoDto.getNombre ( ) );
		ambiente.setCuidadorPrincipal ( empleadoMapper.map ( habitatEmpleadoDto.getEmpleadoHabitatDto ( ) ) );
		return ambiente;
	}

	public void map ( Empleado empleado, Habitat habitat )
	{

		if ( empleado instanceof Cuidador )
		{

			habitat.setCuidadorPrincipal ( ( Cuidador ) empleado );
		}
		if ( empleado != null )
		{
			habitat.setAyundanteDeCuidadorPrincipal ( empleado );
		}
	}

	public HabitatCompletoDto mapCompleto ( Habitat habitat )
	{

		HabitatCompletoDto habitatCompletoDto = new HabitatCompletoDto ( );
		habitatCompletoDto.setNombre ( habitat.getNombre ( ) );
		habitatCompletoDto.setEmpleadoHabitatDto ( empleadoMapper.map ( habitat.getCuidadorPrincipal ( ) ) );
		habitatCompletoDto.setListaAnimal ( animalMapper.map ( habitat.getListaAnimal ( ) ) );
		return habitatCompletoDto;
	}

	public HabitatCrearDto map ( Habitat habitat )
	{

		HabitatCrearDto habitatCrearDto = new HabitatCrearDto ( );
		habitatCrearDto.setNombre ( habitat.getNombre ( ) );
		habitatCrearDto.setEmpleadoHabitatDto ( empleadoMapper.map ( habitat.getCuidadorPrincipal ( ) ) );
		return habitatCrearDto;
	}

	public List < HabitatCompletoDto > map ( List < Habitat > listaHabitat )
	{
		List < HabitatCompletoDto > habitatEmpleado = new ArrayList <> ( );

		for ( Habitat ambiente : listaHabitat )
		{
			habitatEmpleado.add ( this.mapCompleto ( ambiente ) );
		}

		return habitatEmpleado;
	}

}
