package com.ServicioInternoFutbolarios;

import java.util.List;

public class Correos 
{
	private List<String> correo;
	private String asunto;
	
	public Correos(List<String> Correo, String Asunto)
	{
		this.correo = Correo;
		this.asunto = Asunto;	
	}

	public List<String> getCorreo() {
		return correo;
	}

	public void setCorreo(List<String> correo) {
		this.correo = correo;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
}
