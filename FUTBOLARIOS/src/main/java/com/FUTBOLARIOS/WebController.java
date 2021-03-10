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
	private UsuariosRepository Usuario;
		
	//NOTICIAS
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
	
	//EQUIPOS
	@GetMapping("/Equipos")
	public String MetodoEquipos(Model model)
	{
		List<equipos> equipo = Equipo.findAll();
		model.addAttribute("EQ", equipo);
		return "Equipos";
	}	
	
	//JUGADORES
	@GetMapping("/Jugadores")
	public String MetodoJugadores(Model model)
	{
		List<equipos> equipo = Equipo.findAll();
		model.addAttribute("EQ", equipo);
		return "Jugadores_Menú";
	}	
	
	@RequestMapping("/Jugadores/Avanzado")
	public String MetodoAvanzadoJugadores(Model model, @RequestParam String userName)
	{	
		if("Real Madrid".equals(userName))
		{
			List<jugadores> jugadores = Jugador.findAllDateTeamRealMadrid();
			model.addAttribute("JU", jugadores);
			return "Jugadores";
		}
		
		if("Barcelona".equals(userName))
		{
			List<jugadores> jugadores = Jugador.findAllDateTeamBarcelona();
			model.addAttribute("JU", jugadores);
			return "Jugadores";
		}
		
		if("Sevilla".equals(userName))
		{
			List<jugadores> jugadores = Jugador.findAllDateTeamSevila();
			model.addAttribute("JU", jugadores);
			return "Jugadores";	
		}
		
		if("Atlético de Madrid".equals(userName))
		{
			List<jugadores> jugadores = Jugador.findAllDateTeamAtleticoDeMadrid();
			model.addAttribute("JU", jugadores);
			return "Jugadores";
		}
		
		return "Jugadores";	
	}	
	
	//USUARIOS
	@GetMapping("/Usuario")
	public String MetodoUsuarios()
	{
		return "Usuarios";
	}
	
	@GetMapping("/Usuario/Registrarse")
	public String MetodoUsuariosRegistrarse()
	{
		return "Registrarse";
	}
	
	@RequestMapping("/Usuario/Registrarse/Avanzado")
	public String MetodoAvanzadoRegistrarse(Model model, @RequestParam String apodo, @RequestParam String nombre, @RequestParam String apellido, @RequestParam int edad, @RequestParam String correo, @RequestParam String contraseña, @RequestParam String equipofavorito)
	{	
		List<usuarios> usuario = Usuario.findAll();
		usuarios US = new usuarios(apodo,nombre,apellido,edad,correo,contraseña,equipofavorito);
		
		if(usuario.contains(US))
		{   
			model.addAttribute("apodo", apodo);
		    return "ErrorApodo";
		}	
		else
		{
			Usuario.save(US);
			return "UsuarioRegistrado";
		}
	}
	
	@GetMapping("/Usuario/IniciarSesion")
	public String MetodoUsuariosIniciarSesion()
	{
		return "Iniciar_Sesion";
	}
	
	@RequestMapping("/Usuario/IniciarSesion/Avanzado")
	public String MetodoAvanzadoIniciarSesion(Model model, @RequestParam String apodo, @RequestParam String contraseña)
	{		
		List<usuarios> usuario = Usuario.findAll();
		usuarios US = new usuarios(apodo,"nombre","apellido",0,"correo",contraseña,"equipofavorito");
		
		if(usuario.contains(US))
		{   
			usuarios US2 = new usuarios(apodo,"nombre","apellido",0,"correo",contraseña,"equipofavorito");
			
		    int index = usuario.indexOf(US);
		    US = usuario.get(index);
			
			if(US.getContraseña().equals(US2.getContraseña()))
			{
			   model.addAttribute("usuario", US);
			   return "Perfil_Usuario";
			}
			else
			{
			   return "ErrorContraseña";
			}
		}	
		else
		{
			model.addAttribute("usuario", apodo);
			return "UsuarioNoRegistrado";
		}	
	}	
	
	@RequestMapping("/Usuario/IniciarSesion/Avanzado/EliminarPerfil")
	public String MetodoEliminarPerfil(@RequestParam String apodo)
	{
	    Usuario.deleteById(apodo);
		
		return "UsuarioEliminado";
	}
	
	@RequestMapping("/Usuario/IniciarSesion/Avanzado/ModificarPerfil")
	public String MetodoModificarPerfil(@RequestParam String apodo)
	{		
		return "ModificarPerfil";
	}
	
	@RequestMapping("/Usuario/IniciarSesion/Avanzado/ModificarPerfil/Fin")
	public String MetodoModificarPerfilFin(Model model, @RequestParam String apodoantiguo, @RequestParam String apodonuevo, @RequestParam String nombre, @RequestParam String apellido, @RequestParam int edad, @RequestParam String correo, @RequestParam String contraseña, @RequestParam String equipofavorito)
	{	   
	   
	   if(!apodonuevo.isEmpty())
	   {
		  usuarios AU = Usuario.getOne(apodoantiguo);
		  usuarios UC = new usuarios(apodonuevo,AU.getNombre(),AU.getApellidos(),AU.getEdad(),AU.getCorreo(),AU.getContraseña(),AU.getEquipo_Favorito());
		  Usuario.deleteById(apodoantiguo);
		  Usuario.save(UC); 
		  
		  if(!nombre.isEmpty())
		   {
			  AU = Usuario.getOne(apodonuevo);
			  UC = new usuarios(AU.getApodo(),nombre,AU.getApellidos(),AU.getEdad(),AU.getCorreo(),AU.getContraseña(),AU.getEquipo_Favorito());
			  Usuario.deleteById(apodonuevo);
			  Usuario.save(UC);   
		   }	   
		   if(!apellido.isEmpty())
		   {
			   AU = Usuario.getOne(apodonuevo);
			   UC = new usuarios(AU.getApodo(),AU.getNombre(),apellido,AU.getEdad(),AU.getCorreo(),AU.getContraseña(),AU.getEquipo_Favorito());
			   Usuario.deleteById(apodonuevo);
			   Usuario.save(UC);     
		   }
		   if(edad!=Usuario.getOne(apodonuevo).getEdad())
		   {
			   AU = Usuario.getOne(apodonuevo);
			   UC = new usuarios(AU.getApodo(),AU.getNombre(),AU.getApellidos(),edad,AU.getCorreo(),AU.getContraseña(),AU.getEquipo_Favorito());
			   Usuario.deleteById(apodonuevo);
			   Usuario.save(UC);     
		   }
		   if(!correo.isEmpty())
		   {
			   AU = Usuario.getOne(apodonuevo);
			   UC = new usuarios(AU.getApodo(),AU.getNombre(),AU.getApellidos(),AU.getEdad(),correo,AU.getContraseña(),AU.getEquipo_Favorito());
			   Usuario.deleteById(apodonuevo);
			   Usuario.save(UC);     
		   }
		   if(!contraseña.isEmpty())
		   {
			   AU = Usuario.getOne(apodonuevo);
			   UC = new usuarios(AU.getApodo(),AU.getNombre(),AU.getApellidos(),AU.getEdad(),AU.getCorreo(),contraseña,AU.getEquipo_Favorito());
			   Usuario.deleteById(apodonuevo);
			   Usuario.save(UC);     
		   }
		   if(!equipofavorito.isEmpty())
		   {
			   AU = Usuario.getOne(apodonuevo);
			   UC = new usuarios(AU.getApodo(),AU.getNombre(),AU.getApellidos(),AU.getEdad(),AU.getCorreo(),AU.getContraseña(),equipofavorito);
			   Usuario.deleteById(apodonuevo);
			   Usuario.save(UC);     
		   }	   
	   }
	   else
	   {
		   usuarios AU = Usuario.getOne(apodoantiguo);
		   usuarios UC = new usuarios(apodoantiguo,AU.getNombre(),AU.getApellidos(),AU.getEdad(),AU.getCorreo(),AU.getContraseña(),AU.getEquipo_Favorito());
		   Usuario.deleteById(apodoantiguo);
		   Usuario.save(UC); 
			  
		   if(!nombre.isEmpty())
		   {
			  AU = Usuario.getOne(apodoantiguo);
			  UC = new usuarios(AU.getApodo(),nombre,AU.getApellidos(),AU.getEdad(),AU.getCorreo(),AU.getContraseña(),AU.getEquipo_Favorito());
			  Usuario.deleteById(apodoantiguo);
			  Usuario.save(UC);   
		   }	   
		   if(!apellido.isEmpty())
		   {
			   AU = Usuario.getOne(apodoantiguo);
			   UC = new usuarios(AU.getApodo(),AU.getNombre(),apellido,AU.getEdad(),AU.getCorreo(),AU.getContraseña(),AU.getEquipo_Favorito());
			   Usuario.deleteById(apodoantiguo);
			   Usuario.save(UC);     
		   }
		   if(edad!=Usuario.getOne(apodoantiguo).getEdad())
		   {
			   AU = Usuario.getOne(apodoantiguo);
			   UC = new usuarios(AU.getApodo(),AU.getNombre(),AU.getApellidos(),edad,AU.getCorreo(),AU.getContraseña(),AU.getEquipo_Favorito());
			   Usuario.deleteById(apodoantiguo);
			   Usuario.save(UC);     
		   }
		   if(!correo.isEmpty())
		   {
			   AU = Usuario.getOne(apodoantiguo);
			   UC = new usuarios(AU.getApodo(),AU.getNombre(),AU.getApellidos(),AU.getEdad(),correo,AU.getContraseña(),AU.getEquipo_Favorito());
			   Usuario.deleteById(apodoantiguo);
			   Usuario.save(UC);     
		   }
		   if(!contraseña.isEmpty())
		   {
			   AU = Usuario.getOne(apodoantiguo);
			   UC = new usuarios(AU.getApodo(),AU.getNombre(),AU.getApellidos(),AU.getEdad(),AU.getCorreo(),contraseña,AU.getEquipo_Favorito());
			   Usuario.deleteById(apodoantiguo);
			   Usuario.save(UC);     
		   }
		   if(!equipofavorito.isEmpty())
		   {
			   AU = Usuario.getOne(apodoantiguo);
			   UC = new usuarios(AU.getApodo(),AU.getNombre(),AU.getApellidos(),AU.getEdad(),AU.getCorreo(),AU.getContraseña(),equipofavorito);
			   Usuario.deleteById(apodoantiguo);
			   Usuario.save(UC);     
		   }	   	   
	   }
	 	
	   return "DatosModificados";
	}
}
