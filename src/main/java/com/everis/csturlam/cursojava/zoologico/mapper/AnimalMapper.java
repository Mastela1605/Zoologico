package com.everis.csturlam.cursojava.zoologico.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.everis.csturlam.cursojava.zoologico.dominio.Aguila;
import com.everis.csturlam.cursojava.zoologico.dominio.Animal;
import com.everis.csturlam.cursojava.zoologico.dominio.Habitat;
import com.everis.csturlam.cursojava.zoologico.dominio.Leon;
import com.everis.csturlam.cursojava.zoologico.dominio.Loro;
import com.everis.csturlam.cursojava.zoologico.dominio.Mono;
import com.everis.csturlam.cursojava.zoologico.dto.animal.AnimalCrearDto;
import com.everis.csturlam.cursojava.zoologico.exception.AnimalTipoException;
import com.everis.csturlam.cursojava.zoologico.util.FechaUtils;

@Component
public class AnimalMapper
{

	public Animal map ( AnimalCrearDto animalCrearDto ) throws AnimalTipoException
	{
		return this.settearAnimal ( this.tipoAnimal ( animalCrearDto ), animalCrearDto );
	}

	public AnimalCrearDto map ( Animal animal )
	{

		AnimalCrearDto animalCrearDto = new AnimalCrearDto ( );

		if ( animal instanceof Loro )
		{
			animalCrearDto.setEmvergadura ( ( ( Loro ) animal ).getEnvergadura ( ) );
			animalCrearDto.setZonaDeCaza ( ( ( Loro ) animal ).getZonaDeCaza ( ) );
		}
		if ( animal instanceof Aguila )
		{
			animalCrearDto.setEmvergadura ( ( ( Aguila ) animal ).getEnvergadura ( ) );
			animalCrearDto.setZonaDeCaza ( ( ( Aguila ) animal ).getZonaDeCaza ( ) );
		}
		if ( animal instanceof Leon )
		{
			animalCrearDto.setVelocidad ( ( ( Leon ) animal ).getVelocidad ( ) );
		}
		if ( animal instanceof Mono )
		{
			animalCrearDto.setVelocidad ( ( ( Mono ) animal ).getVelocidad ( ) );
		}
		animalCrearDto.setTipo ( animal.getClass ( )
				.getSimpleName ( ) );
		animalCrearDto.setNombre ( animal.getNombre ( ) );
		animalCrearDto.setAlimento ( animal.getAlimento ( ) );
		animalCrearDto.setReferenciaAnimal ( animal.getReferenciaAnimal ( ) );
		animalCrearDto.setFechaNacimiento ( FechaUtils.parsearFechaHoraString ( animal.getFechaNacimiento ( ) ) );
		animalCrearDto.setOrigen ( animal.getOrigen ( ) );
		animalCrearDto.setFechaLlegada ( FechaUtils.parsearFechaString ( animal.getFechaLlegada ( ) ) );
		animalCrearDto.setAltura ( animal.getAltura ( ) );
		animalCrearDto.setPeso ( animal.getPeso ( ) );
		return animalCrearDto;

	}

	public List < AnimalCrearDto > map ( List < Animal > listarAnimal )
	{
		List < AnimalCrearDto > listSalidaAnimalCrearDtos = new ArrayList <> ( );
		for ( Animal animal : listarAnimal )
		{
			listSalidaAnimalCrearDtos.add ( map ( animal ) );

		}
		return listSalidaAnimalCrearDtos;

	}

	public void map ( Animal animal, Habitat habitat )
	{
		animal.setListaHabitatAnimal ( habitat );

	}

	private Animal tipoAnimal ( AnimalCrearDto animalCrearDto ) throws AnimalTipoException
	{

		Animal animal;
		switch ( animalCrearDto.getTipo ( ) )
		{
		case "Loro":
			// Creamos objeto ave1 de la clase Ave y la cual tiene acceso a la Clase Loro dado que es su padre.
			animal = new Loro ( );
			( ( Loro ) animal ).setEnvergadura ( animalCrearDto.getEmvergadura ( ) );
			( ( Loro ) animal ).setZonaDeCaza ( animalCrearDto.getZonaDeCaza ( ) );
			break;
		case "Aguila":

			animal = new Aguila ( );
			( ( Aguila ) animal ).setEnvergadura ( animalCrearDto.getEmvergadura ( ) );
			( ( Aguila ) animal ).setZonaDeCaza ( animalCrearDto.getZonaDeCaza ( ) );
			break;
		case "Leon":

			animal = new Leon ( );
			( ( Leon ) animal ).setVelocidad ( animalCrearDto.getVelocidad ( ) );
			break;
		case "Mono":

			animal = new Mono ( );
			( ( Mono ) animal ).setVelocidad ( animalCrearDto.getVelocidad ( ) );
			break;
		default:
			throw new AnimalTipoException ( "TIPO ANIMAL OBLIGATORIO" );
		}

		return animal;

	}

	private Animal settearAnimal ( Animal animal, AnimalCrearDto animalCrearDto )
	{
		animal.setNombre ( animalCrearDto.getNombre ( ) );
		animal.setAlimento ( animalCrearDto.getAlimento ( ) );
		animal.setReferenciaAnimal ( animalCrearDto.getReferenciaAnimal ( ) );
		animal.setFechaNacimiento ( FechaUtils.parsearFechaHora ( animalCrearDto.getFechaNacimiento ( ) ) );
		animal.setOrigen ( animalCrearDto.getOrigen ( ) );
		animal.setFechaLlegada ( FechaUtils.parsearFecha ( animalCrearDto.getFechaLlegada ( ) ) );
		animal.setAltura ( animalCrearDto.getAltura ( ) );
		animal.setPeso ( animalCrearDto.getPeso ( ) );
		return animal;
	}

}
