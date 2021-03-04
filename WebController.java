package com.FUTBOLARIOS;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController 
{
	@GetMapping("/Noticias")
	public String MetodoNoticias()
	{
		return "Noticias";
	}	
	
	@GetMapping("/Equipos")
	public String MetodoEquipos()
	{
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
