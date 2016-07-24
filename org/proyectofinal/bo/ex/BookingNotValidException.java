package org.proyectofinal.bo.ex;

/**
 * Excepcion que se lanza si algun atributo del objeto <code>ReservaViaje</code> no es valido.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public class BookingNotValidException extends Exception {

//	private static final long serialVersionUID = -2930872059061582353L;
	
	/**
	 * Instancia un nuevo objeto de la Excepcion <code>BookingNotValidException</code>
	 */
	
	public BookingNotValidException(){
		
	}
	
	/**
	 * Retorna un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 *
	 * @return Un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 */
	
	public String getMessage(){
		return "La reserva no es válida. Faltan ingresar campos obligatorios";
	}

}