package com.FUTBOLARIOS;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class noticias 
{	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Codigo_Noticia;
    
    private String Nombre_Escritor;
    private String Apellidos_Escritor;
    private String Titulo;
    private String Texto;
    private String Equipo;
    private String Fecha;
    
    //CONSTRUCTOR. 
    protected noticias() {}
    
    public noticias(String Nombre, String Apellidos, String Titulo, String Texto, String Equipo, String Fecha)
    {
       this.Nombre_Escritor=Nombre;
       this.Apellidos_Escritor=Apellidos;
       this.Titulo=Titulo;
       this.Texto=Texto;
       this.Equipo=Equipo;
       this.Fecha=Fecha;  	
    }

    //GETTERS, SETTERS y TOSTRING
	public long getCodigo_Noticia() {
		return Codigo_Noticia;
	}

	public void setCodigo_Noticia(long codigo_Noticia) {
		Codigo_Noticia = codigo_Noticia;
	}

	public String getNombre_Escritor() {
		return Nombre_Escritor;
	}

	public void setNombre_Escritor(String nombre_Escritor) {
		Nombre_Escritor = nombre_Escritor;
	}

	public String getApellidos_Escritor() {
		return Apellidos_Escritor;
	}

	public void setApellidos_Escritor(String apellidos_Escritor) {
		Apellidos_Escritor = apellidos_Escritor;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getTexto() {
		return Texto;
	}

	public void setTexto(String texto) {
		Texto = texto;
	}

	public String getEquipo() {
		return Equipo;
	}

	public void setEquipo(String equipo) {
		Equipo = equipo;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	@Override
	public String toString() {
		return "noticias [Codigo_Noticia=" + Codigo_Noticia + ", Nombre_Escritor=" + Nombre_Escritor
				+ ", Apellidos_Escritor=" + Apellidos_Escritor + ", Titulo=" + Titulo + ", Texto=" + Texto + ", Equipo="
				+ Equipo + ", Fecha=" + Fecha + "]";
	}
}
