package org.proyectofinal.ui.util;

import org.proyectofinal.ui.botones.BotonPasajero;
import org.proyectofinal.ui.util.ex.NotValidPassengerException;

public class Pasajero {

	private String nombre;
	private String apellido;
	private Integer dni;
	private BotonPasajero asientoPasajero;
	
	public Pasajero(String nombre, String apellido, Integer dni, BotonPasajero asientoPasajero){
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.asientoPasajero = asientoPasajero;
	}
	
	public Pasajero(){
	
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public Integer getDni() {
		return dni;
	}
	
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	
	public BotonPasajero getAsientoPasajero() {
		return asientoPasajero;
	}
	
	public void setAsientoPasajero(BotonPasajero asientoPasajero) {
		this.asientoPasajero = asientoPasajero;
	}

	@Override
	public String toString(){
		String res = "";
		
		res = "DNI: " + getDni() + "\n";
		res += "NOMBRE: " + getNombre() + "\n";
		res += "APELLIDO: " + getApellido() + "\n";
		res += "ASIENTO: " + getAsientoPasajero().getAsiento() + "\n";
		res += "PRECIO: " + getAsientoPasajero().getPrecio() + "\n";
		
		return res;				
	}
	
	public void verificarDatosPasajero(Pasajero p) throws NotValidPassengerException {
		
		if (p.getDni() == -1 || p.getDni().equals("") || 
			p.getNombre().trim().length() == 0 ||  
			p.getApellido().trim().length() == 0 || 
			p.getAsientoPasajero() == null || 
			p.getAsientoPasajero().getAsiento().trim().length() == 0 || 
			p.getAsientoPasajero().getPrecio() == -1f){
			
			throw new NotValidPassengerException();
		}
	}
		
}