package com.FUTBOLARIOS;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JugadoresRepository extends JpaRepository<jugadores,Integer> 
{
	@Query(
       value = "SELECT * FROM futbolarios.jugadores WHERE equipo = \"Barcelona\" ", 
	   nativeQuery = true)
	List<jugadores>findAllDateTeamBarcelona();	
	
	@Query(
	   value = "SELECT * FROM futbolarios.jugadores WHERE equipo = \"Real Madrid\" ", 
	   nativeQuery = true)
    List<jugadores>findAllDateTeamRealMadrid();	
			
	@Query(
	   value = "SELECT * FROM futbolarios.jugadores WHERE equipo = \"Sevilla\" ", 
	   nativeQuery = true)
	List<jugadores>findAllDateTeamSevila();	

	@Query(
	   value = "SELECT * FROM futbolarios.jugadores WHERE equipo = \"Atlético de Madrid\" ", 
	   nativeQuery = true)
    List<jugadores>findAllDateTeamAtleticoDeMadrid();	
}