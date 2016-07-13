package org.proyectofinal.bo.ex;

/**
 * Excepcion que se lanza si el objeto <code>PersonaRegistrada</code> ya existe en la base de datos del sistema.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public class PersonAlreadyExistsException extends Exception {
	
//	private static final long serialVersionUID = 3281455937178533639L;

	/**
	 * Instancia un nuevo objeto de la Excepcion <code>PersonAlreadyExistsException</code>
	 */
	
	public PersonAlreadyExistsException(){
		
	}
	
	/**
	 * Retorna un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 *
	 * @return Un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 */
	
	public String getMessage(){
		return "La persona ingresada ya existe en el sistema.";
	}

}