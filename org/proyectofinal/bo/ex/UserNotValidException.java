package org.proyectofinal.bo.ex;

/**
 * Excepcion que se lanza si algun atributo del objeto <code>Usuario</code> no es valido.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public class UserNotValidException extends Exception {

//	private static final long serialVersionUID = -7798071003952352001L;

	/**
	 * Instancia un nuevo objeto de la Excepcion <code>UserNotValidException</code>
	 */
	
	public UserNotValidException(){
		
	}
	
	/**
	 * Retorna un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 *
	 * @return Un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 */
	
	public String getMessage(){
		return "El usuario no es valido. Faltan ingresar campos obligatorios";
	}

}