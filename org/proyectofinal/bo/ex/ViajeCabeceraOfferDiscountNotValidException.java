package org.proyectofinal.bo.ex;

/**
 * Excepcion que se lanza si el atributo <em>oferta</em> del objeto <code>ViajeCabecera</code> es menor o igual a 0 (cero) o es mayor a 0.75 (cero con .75).
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public class ViajeCabeceraOfferDiscountNotValidException extends Exception {
	
//	private static final long serialVersionUID = -4141373341009555345L;

	/**
	 * Instancia un nuevo objeto de la Excepcion <code>ViajeCabeceraOfferDiscountNotValidException</code>
	 */
	
	public ViajeCabeceraOfferDiscountNotValidException(){
		
	}
	
	/**
	 * Retorna un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 *
	 * @return Un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 */
	
	@Override
	public String getMessage() {
		return "La oferta ingresada no es valida. El descuento debe ser mayor a 0 (cero) y menor o igual a 0.75 (cero con .75).";
	}
	
}