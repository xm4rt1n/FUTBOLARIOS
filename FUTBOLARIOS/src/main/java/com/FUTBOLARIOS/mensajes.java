package com.FUTBOLARIOS;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class mensajes {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int Codigo_Mensaje;

	private String Apodo;
	private String Texto;
	private String Fecha;

	
	//CONSTRUCTOR. 
    protected mensajes(){}
    
    public mensajes(String AP, String TX, String FC)
    {
    	this.Apodo=AP;
    	this.Texto=TX;
    	this.Fecha=FC;
    }

    //GETTERS, SETTERS y TOSTRING
	public int getCodigo_Mensaje() {
		return Codigo_Mensaje;
	}

	public void setCodigo_Mensaje(int codigo_Mensaje) {
		Codigo_Mensaje = codigo_Mensaje;
	}

	public String getApodo() {
		return Apodo;
	}

	public void setApodo(String apodo) {
		Apodo = apodo;
	}

	public String getTexto() {
		return Texto;
	}

	public void setTexto(String texto) {
		Texto = texto;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	@Override
	public String toString() {
		return "mensajes [Codigo_Mensaje=" + Codigo_Mensaje + ", Apodo=" + Apodo + ", Texto=" + Texto + ", Fecha="
				+ Fecha + "]";
	}  
}
    