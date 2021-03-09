package com.FUTBOLARIOS;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController 
{	
	@Autowired
	private NoticiasRepository Noticia;
	
	@Autowired
	private EquiposRepository Equipo;
	
	@Autowired
	private JugadoresRepository Jugador;
	
	@Autowired
	private mensajeRepository Mensaje;
		
	@GetMapping("/Noticias")
	public String MetodoNoticias(Model model)
	{
		List<noticias> noticia = Noticia.findAll();
		model.addAttribute("NO", noticia);
		return "Noticias_Menú";
	}	
	
	@RequestMapping("/Noticias/Avanzado")
	public String MetodoAvanzadoNoticias(Model model, @RequestParam String userName)
	{	
		List<noticias> noticia = Noticia.findAll();
		noticias NO = new noticias(noticia.get(0).getNombre_Escritor(), noticia.get(0).getApellidos_Escritor(), userName, noticia.get(0).getTexto(), noticia.get(0).getEquipo(), noticia.get(0).getFecha());
		if(noticia.contains(NO))
		{   
		   int posicion = noticia.indexOf(NO);
		   model.addAttribute("name", noticia.get(posicion));
		}	
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
	
	@GetMapping("/Foro")
	public String MetodoForo(Model model)
	{
		List<Mensaje> mensaje = Mensaje.findAll();
		model.addAttribute("ME", mensaje);
		return "Foro";
	}
	
	/******************* EQUIPOS **************************/
	
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
