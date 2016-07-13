package org.proyectofinal.bo.ex;

/**
 * Excepcion que se lanza si algun atributo del objeto <code>ViajeCabecera</code> no es valido.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public class ViajeCabeceraNotValidException extends Exception {

//	private static final long serialVersionUID = 5289689674712157362L;

	/**
	 * Instancia un nuevo objeto de la Excepcion <code>ViajeCabeceraNotValidException</code>
	 */
	
	public ViajeCabeceraNotValidException(){
		
	}
	
	/**
	 * Retorna un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 *
	 * @return Un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 */
	
	@Override
	public String getMessage() {
		return "El vuelo ingresado no es valido. Faltan completar campos obligatorios";
	}
}