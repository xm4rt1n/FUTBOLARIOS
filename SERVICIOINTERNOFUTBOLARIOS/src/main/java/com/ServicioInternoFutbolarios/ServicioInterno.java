package com.ServicioInternoFutbolarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServicioInterno 
{
	@Autowired
    private JavaMailSender mailSender;
	
	@PostMapping("/EnviarCorreos")
	public void enviarCorreos(@RequestBody Correos correo)
	{
	   List<String> listaCorreos = correo.getCorreo();
	   String asunto = correo.getAsunto();
		
	   //Envio correos.  
	   for(String co : listaCorreos)
	   {
          SimpleMailMessage email = new SimpleMailMessage();
          email.setTo(co);
          email.setSubject("Futbolarios");
          email.setText(asunto);
          mailSender.send(email);  
	   } 	
	}
}
