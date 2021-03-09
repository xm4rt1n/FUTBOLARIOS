package com.FUTBOLARIOS;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class equipos 
{
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private String Nombre;
	 
	 private int Num_Jugadores;
	 private int Goles_Marcados;
	 private int Goles_Encajados;
	 private int Partidos_Ganados;
	 private int Partidos_Perdidos;
	 private int Partidos_Empatados;
	 private int Puntos;
	 
	 @Lob
	 @JsonIgnore
	 private Blob Imagen;
	 
	 //CONSTRUCTOR. 
	 protected equipos() {}
	    
	 public equipos(int NJ, int GM, int GE, int PG, int PP, int PE, int PU, Blob IM)
	 {
	    this.Num_Jugadores=NJ;
	    this.Goles_Marcados=GM;
	    this.Goles_Encajados=GE;
	    this.Partidos_Ganados=PG;
	    this.Partidos_Perdidos=PP;
	    this.Partidos_Empatados=PE;
        this.Puntos=PU;
        this.Imagen=IM;
	}
	 
	//GETTERS, SETTERS y TOSTRING
    public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getNum_Jugadores() {
		return Num_Jugadores;
	}

	public void setNum_Jugadores(int num_Jugadores) {
		Num_Jugadores = num_Jugadores;
	}

	public int getGoles_Marcados() {
		return Goles_Marcados;
	}

	public void setGoles_Marcados(int goles_Marcados) {
		Goles_Marcados = goles_Marcados;
	}

	public int getGoles_Encajados() {
		return Goles_Encajados;
	}

	public void setGoles_Encajados(int goles_Encajados) {
		Goles_Encajados = goles_Encajados;
	}

	public int getPartidos_Ganados() {
		return Partidos_Ganados;
	}

	public void setPartidos_Ganados(int partidos_Ganados) {
		Partidos_Ganados = partidos_Ganados;
	}

	public int getPartidos_Perdidos() {
		return Partidos_Perdidos;
	}

	public void setPartidos_Perdidos(int partidos_Perdidos) {
		Partidos_Perdidos = partidos_Perdidos;
	}

	public int getPartidos_Empatados() {
		return Partidos_Empatados;
	}

	public void setPartidos_Empatados(int partidos_Empatados) {
		Partidos_Empatados = partidos_Empatados;
	}

	public int getPuntos() {
		return Puntos;
	}

	public void setPuntos(int puntos) {
		Puntos = puntos;
	}

	public Blob getImagen() {
		return Imagen;
	}

	public void setImagen(Blob imagen) {
		Imagen = imagen;
	}

	@Override
	public String toString() {
		return "equipos [Nombre=" + Nombre + ", Num_Jugadores=" + Num_Jugadores + ", Goles_Marcados=" + Goles_Marcados
				+ ", Goles_Encajados=" + Goles_Encajados + ", Partidos_Ganados=" + Partidos_Ganados
				+ ", Partidos_Perdidos=" + Partidos_Perdidos + ", Partidos_Empatados=" + Partidos_Empatados
				+ ", Puntos=" + Puntos + ", Imagen=" + Imagen + "]";
	}
}
