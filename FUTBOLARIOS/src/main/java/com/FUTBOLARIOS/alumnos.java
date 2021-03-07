package com.FUTBOLARIOS;

public class alumnos {

	private int numero;
	private String nombre;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "alumnos [numero=" + numero + ", nombre=" + nombre + "]";
	}
	
	
	
}
