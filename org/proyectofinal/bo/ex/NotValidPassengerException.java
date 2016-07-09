package org.proyectofinal.bo.ex;

/**
 * Excepcion que se lanza si algun atributo del objeto <code>Pasajero</code> no es valido.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public class NotValidPassengerException extends Exception {

	private static final long serialVersionUID = 8712190458163669657L;
	
	/**
	 * Instancia un nuevo objeto de la Excepcion <code>NotValidPassengerException</code>
	 */
	
	public NotValidPassengerException(){
		
	}
	
	/**
	 * Retorna un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 *
	 * @return Un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 */
	
	public String getMessage(){
		return "Faltan ingresar datos del pasajero. Complete los campos faltantes.";
	}
}
