package org.proyectofinal.bo.ex;

/**
 * Excepcion que se lanza cuando los atributos del objeto Pasajero no son validos
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public class UserAlreadyExistsException extends Exception {
	
	private static final long serialVersionUID = -3030102998950032560L;

	/**
	 * Instancia un nuevo objeto de la Excepcion <code>UserAlreadyExistsException</code>
	 */
	
	public UserAlreadyExistsException(){
		
	}
	
	/**
	 * Retorna un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 *
	 * @return Un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 */

	public String getMessage(){
		return "El usuario ingresado ya existe en el sistema.";
	}
}
