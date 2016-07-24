package org.proyectofinal.bo.ex;

/**
 * Excepcion que se lanza si no existe ningun objeto <code>ViajeCabecera</code> en la base de datos del sistema.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public class ViajeCabeceraNotFoundException extends Exception {
	
//	private static final long serialVersionUID = -5431279917975862341L;

	/**
	 * Instancia un nuevo objeto de la Excepcion <code>ViajeCabeceraNotFoundException</code>
	 */
	
	public ViajeCabeceraNotFoundException(){
		
	}
	
	/**
	 * Retorna un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 *
	 * @return Un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 */
	
	public String getMessage(){
		return "No se han encontrado vuelos en la base de datos del sistema.";
	}

}