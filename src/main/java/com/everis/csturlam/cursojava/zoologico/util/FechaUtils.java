package com.everis.csturlam.cursojava.zoologico.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public final class FechaUtils

{

	private FechaUtils ( )
	{
		throw new IllegalStateException ( "Fecha utilidad" );
	}

	public static LocalDate parsearFecha ( String texto )
	{
		return FechaUtils.parsearFecha ( "dd-MM-yyyy", texto );
	}

	public static LocalDateTime parsearFechaHora ( String texto )
	{
		return FechaUtils.parsearFechaHora ( "dd-MM-yyyy HH:mm", texto );
	}

	public static String parsearFechaString ( LocalDate fecha )
	{
		return FechaUtils.parsearStringFecha ( fecha, "dd-MM-yyyy" );
	}

	public static String parsearFechaHoraString ( LocalDateTime fechaHora )
	{
		return FechaUtils.parsearStringFechaHora ( fechaHora, "dd-MM-yyyy HH:mm" );
	}

	private static LocalDateTime parsearFechaHora ( String formatterPattern, String entrada )
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern ( formatterPattern );
		LocalDateTime salida;

		try
		{
			salida = LocalDateTime.parse ( entrada.trim ( ), formatter );
		}
		catch ( DateTimeParseException e )
		{
			salida = null;
		}

		return salida;
	}

	private static LocalDate parsearFecha ( String formatterPattern, String entrada )
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern ( formatterPattern );
		LocalDate salida;

		try
		{
			salida = LocalDate.parse ( entrada.trim ( ), formatter );
		}
		catch ( DateTimeParseException e )
		{
			salida = null;
		}

		return salida;
	}

	private static String parsearStringFechaHora ( LocalDateTime fechaHora, String entrada )
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern ( entrada );
		String salida;

		salida = fechaHora.format ( formatter );

		return salida;
	}

	private static String parsearStringFecha ( LocalDate fecha, String entrada )
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern ( entrada );
		String salida;

		salida = fecha.format ( formatter );

		return salida;
	}
}