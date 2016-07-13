package org.proyectofinal.bo.ex;

/**
 * Excepcion que se lanza si alguno de los atributos especificados del objeto <code>ViajeCabecera</code> relacionados con la oferta del viaje no es valido.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public class ViajeCabeceraOfferNotValidException extends Exception {
	
//	private static final long serialVersionUID = -4141373341009555345L;

	/**
	 * Instancia un nuevo objeto de la Excepcion <code>ViajeCabeceraOfferNotValidException</code>
	 */
	
	public ViajeCabeceraOfferNotValidException(){
		
	}
	
	/**
	 * Retorna un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 *
	 * @return Un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 */
	
	@Override
	public String getMessage() {
		return "La oferta ingresada no es valida. Faltan completar campos obligatorios";
	}
	
}