package com.everis.csturlam.cursojava.zoologico.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table ( name = "CETRERO" )
public class Cetrero
		extends Cuidador
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8125349404541587629L;

	@Column ( name = "ESPECILIDAD_AVES" )
	private String especialidadEnAves;

	public String sacarDeCazaAve ( Animal animal )
	{
		( ( Ave ) animal ).salirDeCaza ( );
		if ( Boolean.TRUE.equals ( ( ( Ave ) animal ).getHambre ( ) ) )
		{
			return String.format ( "El cetrero %s ha tratado de sacar a cazar al %s y este solo ha dado un vuelo para estirar las alas %n", this.nombreEmpleado,
					( ( Ave ) animal ).getClass ( )
							.getSimpleName ( ) );
		}
		else
		{
			return String.format ( "El cetrero %s saca a cazar a %s%n", this.nombreEmpleado, animal.nombre );
		}

	}

	@Override
	public int hashCode ( )
	{
		// TODO Cambiar true parametro de entrada a false cuando estemos con BBDD
		return super.hashCode ( );
	}

	@Override
	public boolean equals ( Object obj )
	{
		return super.equals ( obj );
	}
}
