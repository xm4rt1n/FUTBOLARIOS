package com.FUTBOLARIOS;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class jugadores {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int Codigo_Jugador;
	
	private String Nombre;
	private int Edad;
	private String Nacionalidad;
	private String Equipo;
	private int Goles;
	private int Asistencias;
	private int Partidos_Jugados;
	
	//CONSTRUCTOR. 
    protected jugadores() {}
    
    public jugadores(String NM, int ED, String NC, String EQ, int GO, int AS, int PJ)
    {
    	this.Nombre=NM;
    	this.Edad=ED;
    	this.Nacionalidad=NC;
    	this.Equipo=EQ;
    	this.Goles=GO;
    	this.Asistencias=AS;
    	this.Partidos_Jugados=PJ;
    }

    //GETTERS, SETTERS y TOSTRING
	public int getCodigo_Jugador() {
		return Codigo_Jugador;
	}

	public void setCodigo_Jugador(int codigo_Jugador) {
		Codigo_Jugador = codigo_Jugador;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

	public String getNacionalidad() {
		return Nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}

	public String getEquipo() {
		return Equipo;
	}

	public void setEquipo(String equipo) {
		Equipo = equipo;
	}

	public int getGoles() {
		return Goles;
	}

	public void setGoles(int goles) {
		Goles = goles;
	}

	public int getAsistencias() {
		return Asistencias;
	}

	public void setAsistencias(int asistencias) {
		Asistencias = asistencias;
	}

	public int getPartidos_Jugados() {
		return Partidos_Jugados;
	}

	public void setPartidos_Jugados(int partidos_Jugados) {
		Partidos_Jugados = partidos_Jugados;
	}

	@Override
	public String toString() {
		return "jugadores [Codigo_Jugador=" + Codigo_Jugador + ", Nombre=" + Nombre + ", Edad=" + Edad
				+ ", Nacionalidad=" + Nacionalidad + ", Equipo=" + Equipo + ", Goles=" + Goles + ", Asistencias="
				+ Asistencias + ", Partidos_Jugados=" + Partidos_Jugados + "]";
	}
}
