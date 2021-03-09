package com.FUTBOLARIOS;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController 
{	
	@Autowired
	private NoticiasRepository Noticia;
	
	@Autowired
	private EquiposRepository Equipo;
	
	@Autowired
	private JugadoresRepository Jugador;
		
	@GetMapping("/Noticias")
	public String MetodoNoticias(Model model)
	{
		List<noticias> noticia = Noticia.findAll();
		model.addAttribute("NO", noticia);
		return "Noticias";
	}	
	
	@GetMapping("/Equipos")
	public String MetodoEquipos(Model model)
	{
		List<equipos> equipo = Equipo.findAll();
		model.addAttribute("EQ", equipo);
		return "Equipos";
	}	
	
	@GetMapping("/Jugadores")
	public String MetodoJugadores()
	{
		return "Jugadores_Menú";
	}	
	
	/******************* Equipos **************************/
	
	@GetMapping("/Equipos/Real Madrid")
	public String MetodoEquipos_RealMadrid(Model model)
	{
		List<jugadores> jugadores = Jugador.findAllDateTeamRealMadrid();
		model.addAttribute("JU", jugadores);
		return "Jugadores";
	}	
	
	@GetMapping("/Equipos/Barcelona")
	public String MetodoEquipos_Barcelona(Model model)
	{
		List<jugadores> jugadores = Jugador.findAllDateTeamBarcelona();
		model.addAttribute("JU", jugadores);
		return "Jugadores";
	}
	
	@GetMapping("/Equipos/Atlético de Madrid")
	public String MetodoEquipos_AtleticodeMadrid(Model model)
	{
		List<jugadores> jugadores = Jugador.findAllDateTeamAtleticoDeMadrid();
		model.addAttribute("JU", jugadores);
		return "Jugadores";
	}
	
	@GetMapping("/Equipos/Sevilla")
	public String MetodoEquipos_Sevilla(Model model)
	{
		List<jugadores> jugadores = Jugador.findAllDateTeamSevila();
		model.addAttribute("JU", jugadores);
		return "Jugadores";	
	}
	
	/*********************************************************/
	
	
	
	
	
	
}
