package org.proyectofinal.bo.ex;

/**
 * Excepcion que se lanza cuando los atributos del objeto Pasajero no son validos
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public class UserNotCorrectException extends Exception {
	
	private static final long serialVersionUID = 1360312902153430187L;

	/**
	 * Instancia un nuevo objeto de la Excepcion <code>UserNotCorrectException</code>
	 */
	
	public UserNotCorrectException(){
		
	}
	
	/**
	 * Retorna un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 *
	 * @return Un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 */
	
	public String getMessage(){
		return "Los datos ingresados, usuario, contraseña o tipo de usuario no son correctos.";
	}

}