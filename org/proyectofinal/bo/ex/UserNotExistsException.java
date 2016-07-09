package org.proyectofinal.bo.ex;

/**
 * Excepcion que se lanza cuando los atributos del objeto Pasajero no son validos
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public class UserNotExistsException extends Exception {
	
	private static final long serialVersionUID = -8441762609979567803L;

	/**
	 * Instancia un nuevo objeto de la Excepcion <code>UserNotExistsException</code>
	 */
	
	public UserNotExistsException(){
		
	}
	
	/**
	 * Retorna un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 *
	 * @return Un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 */
	
	public String getMessage(){
		return "El usuario ingresado no existe en la base de datos.";
	}

}
