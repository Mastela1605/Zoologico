package com.everis.csturlam.cursojava.zoologico.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfiguration
{
	@Value ( value = "${database.user}" )
	private String user;
	@Value ( value = "${database.password}" )
	private String pass;

	/**
	 * Bean que representa la conexión a la base de datos
	 * 
	 * @return {@link javax.sql.DataSource} bean que permite la conexión a la base de datos
	 */
	@Bean
	public DataSource dataSource ( )
	{
		HikariDataSource dataSource = new HikariDataSource ( );

		dataSource.setDriverClassName ( "org.hsqldb.jdbcDriver" );
		dataSource.setJdbcUrl ( "jdbc:hsqldb:mem:zooDatabase" );
		dataSource.setUsername ( user );
		dataSource.setPassword ( pass );

		dataSource.setMaximumPoolSize ( 5 );
		dataSource.setPoolName ( "CursoJava-HikariCP" );

		dataSource.addDataSourceProperty ( "dataSource.cachePrepStmts", "true" );
		dataSource.addDataSourceProperty ( "dataSource.prepStmtCacheSize", "250" );
		dataSource.addDataSourceProperty ( "dataSource.prepStmtCacheSqlLimit", "2048" );
		dataSource.addDataSourceProperty ( "dataSource.useServerPrepStmts", "true" );

		return dataSource;
	}

}
