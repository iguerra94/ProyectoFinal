package org.proyectofinal.bo.ex;

/**
 * Excepcion que se lanza si algun atributo del objeto <code>PersonaRegistrada</code> no es valido.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public class PersonNotValidException extends Exception {

	private static final long serialVersionUID = -7798071003952352001L;

	/**
	 * Instancia un nuevo objeto de la Excepcion <code>PersonNotValidException</code>
	 */
	
	public PersonNotValidException(){
		
	}
	
	/**
	 * Retorna un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 *
	 * @return Un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 */
	
	public String getMessage(){
		return "La persona no es válida. Faltan ingresar campos obligatorios";
	}

}