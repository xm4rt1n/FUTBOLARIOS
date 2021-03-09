
package com.FUTBOLARIOS;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mensaje {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int Codigo_Mensaje;
	
	private String Autor_Mensaje;
	private String Contenido_Mensaje;
	private String Fecha;
	
	
	 //CONSTRUCTOR. 
	   protected Mensaje() {}
	   
	   public Mensaje(int codigo_Mensaje, String autor_Mensaje, String contenido_Mensaje, String fecha) 
	   {
		   Codigo_Mensaje = codigo_Mensaje;
		   Autor_Mensaje = autor_Mensaje;
		   Contenido_Mensaje = contenido_Mensaje;
		   Fecha = fecha;
	   }


	//GETTERS Y SETTERS.
	public int getCodigo_Mensaje() {
		return Codigo_Mensaje;
	}


	public void setCodigo_Mensaje(int codigo_Mensaje) {
		Codigo_Mensaje = codigo_Mensaje;
	}


	public String getAutor_Mensaje() {
		return Autor_Mensaje;
	}


	public void setAutor_Mensaje(String autor_Mensaje) {
		Autor_Mensaje = autor_Mensaje;
	}


	public String getContenido_Mensaje() {
		return Contenido_Mensaje;
	}


	public void setContenido_Mensaje(String contenido_Mensaje) {
		Contenido_Mensaje = contenido_Mensaje;
	}


	public String getFecha() {
		return Fecha;
	}


	public void setFecha(String fecha) {
		Fecha = fecha;
	}


	@Override
	public String toString() {
		return "Mensaje [Codigo_Mensaje=" + Codigo_Mensaje + ", Autor_Mensaje=" + Autor_Mensaje + ", Contenido_Mensaje="
				+ Contenido_Mensaje + ", Fecha=" + Fecha + "]";
	}
	
	
	
}
