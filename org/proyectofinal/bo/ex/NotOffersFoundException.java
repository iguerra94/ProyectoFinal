package org.proyectofinal.bo.ex;

/**
 * Excepcion que se lanza si no existe ningun objeto <code>ViajeCabecera</code> en la base de datos del sistema con el atributo <em>oferta</em> mayor a cero.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public class NotOffersFoundException extends Exception {
	
//	private static final long serialVersionUID = -3038320082924640966L;

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