package com.FUTBOLARIOS;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class usuarios 
{
	 @Id
	 private String Apodo;
	 
	 private String Nombre;
	 private String Apellidos;
	 private int Edad;
	 private String Correo;
	 private String Contraseña;
	 private String Equipo_Favorito;
	 private String equipos_nombre;
	 
	//CONSTRUCTOR. 
    protected usuarios() {}
		    
	public usuarios(String ID, String NM, String AP, int ED, String CR, String CN, String EF, String EN)
	{
	   this.Apodo=ID;
       this.Nombre=NM;
       this.Apellidos=AP;
       this.Edad=ED;
       this.Correo=CR;
       this.Contraseña=CN;
       this.Equipo_Favorito=EF;
       this.equipos_nombre=EN;
	}

	//GETTERS, SETTERS y TOSTRING
	public String getNombre() {
		return Nombre;
	}

	public String getApodo() {
		return Apodo;
	}

	public void setApodo(String apodo) {
		Apodo = apodo;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public String getContraseña() {
		return Contraseña;
	}

	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}

	public String getEquipo_Favorito() {
		return Equipo_Favorito;
	}

	public void setEquipo_Favorito(String equipo_Favorito) {
		Equipo_Favorito = equipo_Favorito;
	}

	public String getEquipos_nombre() {
		return equipos_nombre;
	}

	public void setEquipos_nombre(String equipos_nombre) {
		this.equipos_nombre = equipos_nombre;
	}

	@Override
	public String toString() {
		return "usuarios [Apodo=" + Apodo + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", Edad=" + Edad
				+ ", Correo=" + Correo + ", Contraseña=" + Contraseña + ", Equipo_Favorito=" + Equipo_Favorito
				+ ", equipos_nombre=" + equipos_nombre + "]";
	}

	//HASHCODE Y EQUALS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Apodo == null) ? 0 : Apodo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		usuarios other = (usuarios) obj;
		if (Apodo == null) {
			if (other.Apodo != null)
				return false;
		} else if (!Apodo.equals(other.Apodo))
			return false;
		return true;
	}	 
}