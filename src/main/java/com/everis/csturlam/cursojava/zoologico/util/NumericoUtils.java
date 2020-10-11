package com.everis.csturlam.cursojava.zoologico.util;

public final class NumericoUtils
{
	private NumericoUtils ( )
	{
		throw new IllegalStateException ( "Numerico utilidad" );
	}

	public static Float parseoFloat ( String texto )
	{
		if ( texto.trim ( )
				.isEmpty ( ) )
		{
			texto = "0";
		}
		return Float.parseFloat ( texto );

	}

	public static Integer parseoInteger ( String texto )
	{

		if ( texto.trim ( )
				.isEmpty ( ) )
		{
			texto = "0";
		}
		return Integer.parseInt ( texto );

	}
}
