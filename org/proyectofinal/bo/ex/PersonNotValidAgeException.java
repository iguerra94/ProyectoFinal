package org.proyectofinal.bo.ex;

/**
 * Excepcion que se lanza si el atributo <em>edad</em> del objeto <code>PersonaRegistrada</code> es menor a 18.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public class PersonNotValidAgeException extends Exception {

//	private static final long serialVersionUID = -1431841553888253108L;

	/**
	 * Instancia un nuevo objeto de la Excepcion <code>PersonNotValidAgeException</code>
	 */
	
	public PersonNotValidAgeException(){
		
	}
	
	/**
	 * Retorna un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 *
	 * @return Un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 */
	
	public String getMessage(){
		return "Debes ser mayor de 18 años para poder registrarte en el sistema.";
	}
}