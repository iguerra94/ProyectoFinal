package org.proyectofinal.bo.ex;

/**
 * Excepcion que se lanza cuando los atributos del objeto Pasajero no son validos
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public class NotOffersFoundException extends Exception {
	
	private static final long serialVersionUID = -3038320082924640966L;

	/**
	 * Instancia un nuevo objeto de la Excepcion <code>NotOffersFoundException</code>
	 */
	
	public NotOffersFoundException(){
		
	}
	
	/**
	 * Retorna un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 *
	 * @return Un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 */
	
	public String getMessage(){
		return "No se han encontrado ofertas en el sistema.";
	}

}
