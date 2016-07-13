package org.proyectofinal.bo.ex;

/**
 * Excepcion que se lanza si el atributo <em>email</em> del objeto <code>PersonaRegistrada</code> no es valido.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public class EmailNotValidException extends Exception {
	
//	private static final long serialVersionUID = -5431279917975862341L;

	/**
	 * Instancia un nuevo objeto de la Excepcion <code>EmailNotValidException</code>
	 */
	
	public EmailNotValidException(){
		
	}
	
	/**
	 * Retorna un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 *
	 * @return Un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 */
	
	public String getMessage(){
		return "El email ingresado no es valido. Debe ser un mail del cliente de correo de gmail.";
	}

}