package com.FUTBOLARIOS;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	/******************* Equipos **************************/
	
	@GetMapping("/Equipos/Real Madrid")
	public String MetodoEquipos_RealMadrid()
	{
		return "Equipos_RealMadrid";
	}	
	
	@GetMapping("/Equipos/Barcelona")
	public String MetodoEquipos_Barcelona()
	{
		return "Equipos_Barcelona";
	}
	
	@GetMapping("/Equipos/Atlético de Madrid")
	public String MetodoEquipos_AtleticodeMadrid()
	{
		return "Equipos_AtleticodeMadrid";
	}
	
	@GetMapping("/Equipos/Sevilla")
	public String MetodoEquipos_Sevilla()
	{
		return "Equipos_Sevilla";
	}
	
	/*********************************************************/
	
	
	
	
	
	
}
