package org.proyectofinal.bo.ex;

/**
 * Excepcion que se lanza si el objeto <code>Usuario</code> relacionado a la <code>PersonaRegistrada</code> ya existe en la base de datos del sistema.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public class UserAlreadyExistsException extends Exception {
	
//	private static final long serialVersionUID = -3030102998950032560L;

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