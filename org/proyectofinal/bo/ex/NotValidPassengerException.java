package org.proyectofinal.bo.ex;

public class NotValidPassengerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8712190458163669657L;

	
	public NotValidPassengerException(){
		
	}
	/**
	 * Excepcion de negocio que lanza un mensaje descriptivo cuando los datos del pasajero no son validos, es decir, que faltan ingresar datos del pasajero.
	 */
	public String getMessage(){
		return "Faltan ingresar datos del pasajero. Complete los campos faltantes.";
	}
}
