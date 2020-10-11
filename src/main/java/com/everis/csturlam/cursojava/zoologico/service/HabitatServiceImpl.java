package com.everis.csturlam.cursojava.zoologico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.csturlam.cursojava.zoologico.dominio.Animal;
import com.everis.csturlam.cursojava.zoologico.dominio.Cetrero;
import com.everis.csturlam.cursojava.zoologico.dominio.Cuidador;
import com.everis.csturlam.cursojava.zoologico.dominio.Habitat;
import com.everis.csturlam.cursojava.zoologico.dto.habitat.HabitatActualizarDto;
import com.everis.csturlam.cursojava.zoologico.dto.habitat.HabitatCompletoDto;
import com.everis.csturlam.cursojava.zoologico.dto.habitat.HabitatCrearDto;
import com.everis.csturlam.cursojava.zoologico.mapper.HabitatMapper;
import com.everis.csturlam.cursojava.zoologico.repository.HabitatRepository;
import com.everis.csturlam.cursojava.zoologico.util.FechaUtils;

@Service
public class HabitatServiceImpl
		implements HabitatService
{
	@Autowired
	private HabitatRepository habitatRepository;
	@Autowired
	private HabitatMapper habitatMapper;
	@Autowired
	private EmpleadoService empleadoService;
	@Autowired
	private AnimalService animalService;

	@Override
	public HabitatCrearDto crear ( HabitatCrearDto habitatEmpleadoDto )
	{
		// Con el Switch se hace una validacion del campo tipoDeAnimal que entra a dicha funcion y dependiendo de lo que venga (Ave1 o Ave2) realiza los siguietne seteos

		Habitat habitat = habitatMapper.map ( habitatEmpleadoDto );
		empleadoService.crear ( habitat.getCuidadorPrincipal ( ) );
		return habitatMapper.map ( this.crear ( habitat ) );
	}

	@Override
	public Habitat crear ( Habitat habitat )
	{
		return habitatRepository.save ( habitat );
	}

	@Override
	public HabitatCompletoDto obtenerHabitatPorId ( Long id )
	{
		return habitatMapper.mapCompleto ( habitatRepository.findHabitatById ( id ) );
	}

	@Override
	public Habitat obtenerHabitatParaAnimal ( Long id )
	{
		return habitatRepository.findHabitatById ( id );
	}

	@Override
	public List < HabitatCompletoDto > obtenerListaHabitats ( )
	{
		return habitatMapper.map ( habitatRepository.findAll ( ) );
	}

	@Override
	public Boolean borrarHabitatPorId ( Long id )
	{
		if ( habitatRepository.existsById ( id ) )
		{
			Habitat habitat = habitatRepository.findHabitatById ( id );

			habitat.setCuidadorPrincipal ( null );

			for ( Animal animal : habitat.getListaAnimal ( ) )
			{
				animal.setListaHabitatAnimal ( null );
				animalService.crear ( animal );
			}

			habitatRepository.deleteById ( id );
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public Boolean actualizarHabitat ( HabitatActualizarDto habitatActualizarDto )
	{
		if ( habitatRepository.existsById ( habitatActualizarDto.getId ( ) ) )
		{
			Habitat update = habitatRepository.findConRelacionesHabitatById ( habitatActualizarDto.getId ( ) );

			if ( !habitatActualizarDto.getNombre ( )
					.trim ( )
					.isEmpty ( ) )
			{
				update.setNombre ( habitatActualizarDto.getNombre ( ) );
			}

			if ( !habitatActualizarDto.getEmpleadoHabitatDto ( )
					.getNombreEmpleado ( )
					.trim ( )
					.isEmpty ( ) )
			{
				update.getCuidadorPrincipal ( )
						.setNombreEmpleado ( habitatActualizarDto.getEmpleadoHabitatDto ( )
								.getNombreEmpleado ( ) );
			}
			if ( !habitatActualizarDto.getEmpleadoHabitatDto ( )
					.getApellido1 ( )
					.trim ( )
					.isEmpty ( ) )
			{
				update.getCuidadorPrincipal ( )
						.setApellido1 ( habitatActualizarDto.getEmpleadoHabitatDto ( )
								.getApellido1 ( ) );
			}
			if ( !habitatActualizarDto.getEmpleadoHabitatDto ( )
					.getApellido2 ( )
					.trim ( )
					.isEmpty ( ) )
			{
				update.getCuidadorPrincipal ( )
						.setApellido2 ( habitatActualizarDto.getEmpleadoHabitatDto ( )
								.getApellido2 ( ) );
			}
			if ( habitatActualizarDto.getEmpleadoHabitatDto ( )
					.getFechaDeIncorporacionZoo ( ) != null )
			{
				update.getCuidadorPrincipal ( )
						.setFechaDeIncorporacionZoo ( FechaUtils.parsearFecha ( habitatActualizarDto.getEmpleadoHabitatDto ( )
								.getFechaDeIncorporacionZoo ( ) ) );
			}
			if ( habitatActualizarDto.getEmpleadoHabitatDto ( )
					.getFechaDeIncorporacionPuesto ( ) != null )
			{
				update.getCuidadorPrincipal ( )
						.setFechaDeIncorporacionPuesto ( FechaUtils.parsearFecha ( habitatActualizarDto.getEmpleadoHabitatDto ( )
								.getFechaDeIncorporacionPuesto ( ) ) );
			}
			if ( habitatActualizarDto.getEmpleadoHabitatDto ( )
					.getSueldo ( ) != 0 )
			{
				update.getCuidadorPrincipal ( )
						.setSueldo ( habitatActualizarDto.getEmpleadoHabitatDto ( )
								.getSueldo ( ) );
			}
			if ( ( update.getCuidadorPrincipal ( ) instanceof Cuidador ) && ( habitatActualizarDto.getEmpleadoHabitatDto ( )
					.getEspecialidadEnMamiferos ( ) != null ) )
			{
				update.getCuidadorPrincipal ( )
						.setEspecialidadMamiferos ( habitatActualizarDto.getEmpleadoHabitatDto ( )
								.getEspecialidadEnMamiferos ( ) );
			}
			if ( ( update.getCuidadorPrincipal ( ) instanceof Cetrero ) && ( habitatActualizarDto.getEmpleadoHabitatDto ( )
					.getEspecialidadEnAves ( ) != null ) )
			{
				( ( Cetrero ) update.getCuidadorPrincipal ( ) ).setEspecialidadEnAves ( habitatActualizarDto.getEmpleadoHabitatDto ( )
						.getEspecialidadEnAves ( ) );
			}
			this.crear ( update );
			return true;
		}
		else
		{
			return false;
		}

	}

}
