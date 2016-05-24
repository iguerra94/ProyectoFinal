package org.proyectofinal.bo.ex;

public class NotValidPassengerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8712190458163669657L;

	
	public NotValidPassengerException(){
		
	}
	
	public String getMessage(){
		return "Faltan ingresar datos del pasajero. Complete los campos faltantes.";
	}
}
