package com.everis.csturlam.cursojava.zoologico.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.csturlam.cursojava.zoologico.dominio.Aguila;
import com.everis.csturlam.cursojava.zoologico.dominio.Animal;
import com.everis.csturlam.cursojava.zoologico.dominio.Leon;
import com.everis.csturlam.cursojava.zoologico.dominio.Loro;
import com.everis.csturlam.cursojava.zoologico.dominio.Mono;
import com.everis.csturlam.cursojava.zoologico.dto.animal.AnimalActualizarDto;
import com.everis.csturlam.cursojava.zoologico.dto.animal.AnimalCrearDto;
import com.everis.csturlam.cursojava.zoologico.exception.AnimalTipoException;
import com.everis.csturlam.cursojava.zoologico.mapper.AnimalMapper;
import com.everis.csturlam.cursojava.zoologico.repository.AnimalRepository;
import com.everis.csturlam.cursojava.zoologico.util.FechaUtils;

@Service
public class AnimalServiceImpl
		implements AnimalService
{
	@Autowired
	private AnimalRepository animalRepository;
	@Autowired
	private AnimalMapper animalMapper;
	@Autowired
	private HabitatService habitatService;

	@Override
	public Boolean actualizarAnimal ( AnimalActualizarDto animalActualizarDto ) throws IOException, AnimalTipoException
	{
		if ( animalRepository.existsById ( animalActualizarDto.getId ( ) ) )
		{
			Animal update = animalRepository.findConRelacionesByIdAnimal ( animalActualizarDto.getId ( ) );
			if ( !animalActualizarDto.getNombre ( )
					.trim ( )
					.isEmpty ( ) )
			{
				update.setNombre ( animalActualizarDto.getNombre ( ) );
			}
			if ( !animalActualizarDto.getAlimento ( )
					.trim ( )
					.isEmpty ( ) )
			{
				update.setAlimento ( animalActualizarDto.getAlimento ( ) );
			}
			if ( animalActualizarDto.getFechaNacimiento ( ) != null )
			{
				update.setFechaNacimiento ( FechaUtils.parsearFechaHora ( animalActualizarDto.getFechaNacimiento ( ) ) );
			}
			if ( !animalActualizarDto.getOrigen ( )
					.trim ( )
					.isEmpty ( ) )
			{
				update.setOrigen ( animalActualizarDto.getOrigen ( ) );
			}
			if ( animalActualizarDto.getFechaLlegada ( ) != null )
			{
				update.setFechaLlegada ( FechaUtils.parsearFecha ( animalActualizarDto.getFechaLlegada ( ) ) );
			}
			if ( animalActualizarDto.getAltura ( ) != 0 )
			{
				update.setAltura ( animalActualizarDto.getAltura ( ) );
			}
			if ( animalActualizarDto.getPeso ( ) != 0 )
			{
				update.setPeso ( animalActualizarDto.getPeso ( ) );
			}
			if ( ( update instanceof Loro ) && ! ( animalActualizarDto.getEmvergadura ( )
					.trim ( )
					.isEmpty ( ) ) )
			{
				( ( Loro ) update ).setEnvergadura ( animalActualizarDto.getEmvergadura ( ) );
			}
			if ( ( update instanceof Loro ) && ! ( animalActualizarDto.getZonaDeCaza ( )
					.trim ( )
					.isEmpty ( ) ) )
			{
				( ( Loro ) update ).setZonaDeCaza ( animalActualizarDto.getZonaDeCaza ( ) );
			}
			if ( ( update instanceof Aguila ) && ! ( animalActualizarDto.getEmvergadura ( )
					.trim ( )
					.isEmpty ( ) ) )
			{
				( ( Aguila ) update ).setEnvergadura ( animalActualizarDto.getEmvergadura ( ) );
			}
			if ( ( update instanceof Aguila ) && ! ( animalActualizarDto.getZonaDeCaza ( )
					.trim ( )
					.isEmpty ( ) ) )
			{
				( ( Aguila ) update ).setZonaDeCaza ( animalActualizarDto.getZonaDeCaza ( ) );
			}
			if ( ( update instanceof Leon ) && ( animalActualizarDto.getVelocidad ( ) != 0 ) )
			{
				( ( Leon ) update ).setVelocidad ( animalActualizarDto.getVelocidad ( ) );
			}
			if ( ( update instanceof Mono ) && ( animalActualizarDto.getVelocidad ( ) != 0 ) )
			{
				( ( Mono ) update ).setVelocidad ( animalActualizarDto.getVelocidad ( ) );
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
	public AnimalCrearDto crear ( AnimalCrearDto animalCrearDto, Long idHabitat ) throws AnimalTipoException
	{
		Animal animal = animalMapper.map ( animalCrearDto );
		animalMapper.map ( animal, habitatService.obtenerHabitatParaAnimal ( idHabitat ) );

		return animalMapper.map ( this.crear ( animal ) );
	}

	@Override
	public AnimalCrearDto obtenerAnimalPorId ( Long id )
	{
		return animalMapper.map ( animalRepository.findConRelacionesByIdAnimal ( id ) );
	}

	@Override
	public List < AnimalCrearDto > obtenerListaAnimales ( )
	{
		return animalMapper.map ( animalRepository.findAll ( ) );
	}

	@Override
	public Animal crear ( Animal animal )
	{
		return animalRepository.save ( animal );
	}

	@Override
	public Boolean borrarAnimalPorId ( Long id )
	{
		if ( animalRepository.existsById ( id ) )
		{
			animalRepository.deleteById ( id );
			return true;
		}
		else
		{
			return false;
		}
	}

}
