package org.proyectofinal.model.interfaces;

/**
 * Interfaz de la clase de dominio <code>Pasajero</code>.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public interface Pasajero extends Cloneable{
	
	/**
	 * Retorna el dni del <code>Pasajero</code>.
	 *
	 * @return El dni del <code>Pasajero</code>.
	 */
	
	public String getDni();
	
	/**
	 * Establece el dni del <code>Pasajero</code>.
	 *
	 * @param dni El dni del <code>Pasajero</code>.
	 */
	
	public void setDni(String dni);
	
	/**
	 * Retorna el nombre del <code>Pasajero</code>.
	 *
	 * @return El nombre del <code>Pasajero</code>.
	 */
	
	public String getNombre();
	
	/**
	 * Establece el nombre del <code>Pasajero</code>.
	 *
	 * @param nombre El nombre del <code>Pasajero</code>.
	 */
	
	public void setNombre(String nombre);
	
	/**
	 * Retorna el apellido del <code>Pasajero</code>.
	 *
	 * @return El apellido del <code>Pasajero</code>.
	 */
	
	public String getApellido();
	
	/**
	 * Establece el apellido del <code>Pasajero</code>.
	 *
	 * @param apellido El apellido del <code>Pasajero</code>.
	 */
	
	public void setApellido(String apellido);
	
	/**
	 * Retorna una representacion del objeto <code>Pasajero</code> en un objeto String.
	 * 
	 * @return Una representacion del objeto <code>Pasajero</code> en un objeto String.
	 */
	
	public String toString();
	
	/**
	 * Crea y retorna una copia del objeto <code>Pasajero</code>.
	 *
	 * @return Una copia de esta instancia del objeto <code>Pasajero</code>.
	 * @throws CloneNotSupportedException Si la clase del objeto no soporta la interfaz Cloneable.
	 */
	
	public Pasajero clone() throws CloneNotSupportedException;
	
	/**
	 * Retorna un codigo hash para el objeto <code>Pasajero</code>.
	 *
	 * @return Un entero representando el codigo hash del objeto <code>Pasajero</code>.
	 */
	
	public int hashCode();
		
	/**
	 * Retorna true si y solo si el objeto obj pasado como parametro no es nulo y ademas los valores de los atributos del objeto <code>Pasajero</code> y los del objeto <code>Pasajero</code> obj a comparar son iguales.
	 *
	 * @param obj El objeto <code>Pasajero</code> a comparar.
	 * @return true, si la condicion se cumple.
	 */
	
	public boolean equals(Object obj);
	
}