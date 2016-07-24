package org.proyectofinal.bo.ex;

/**
 * Excepcion que se lanza si el atributo <em>dni</em> del objeto <code>PersonaRegistrada</code> o del objeto <code>Pasajero</code> no es valido.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public class PersonGenericNotValidDniException extends Exception {
	
//	private static final long serialVersionUID = -5431279917975862341L;

	/**
	 * Instancia un nuevo objeto de la Excepcion <code>PersonGenericNotValidDniException</code>
	 */
	
	public PersonGenericNotValidDniException(){
		
	}
	
	/**
	 * Retorna un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 *
	 * @return Un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 */
	
	public String getMessage(){
		return "El dni debe tener una longitud de 8 (ocho) caracteres.";
	}

}