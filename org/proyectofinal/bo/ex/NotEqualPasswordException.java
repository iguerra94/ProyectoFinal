package org.proyectofinal.bo.ex;

/**
 * Excepcion que se lanza si las contrasenias pasadas como parametro no coinciden.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public class NotEqualPasswordException extends Exception {

//	private static final long serialVersionUID = 5662687613513737464L;

	/**
	 * Instancia un nuevo objeto de la Excepcion <code>NotEqualPasswordException</code>
	 */
	
	public NotEqualPasswordException(){
		
	}
	
	/**
	 * Retorna un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 *
	 * @return Un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 */
	
	public String getMessage(){
		return "Las contraseñas no coinciden. Asegurese que sean iguales.";
	}
}