package org.proyectofinal.model.interfaces;

/**
 * Interfaz de la clase de dominio Pasajero.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public interface Pasajero extends Cloneable{
	
	/**
	 * Retorna el dni del Pasajero.
	 *
	 * @return El dni del Pasajero.
	 */
	
	public String getDni();
	
	/**
	 * Establece el dni del Pasajero.
	 *
	 * @param dni El dni del Pasajero.
	 */
	
	public void setDni(String dni);
	
	/**
	 * Retorna el nombre del Pasajero.
	 *
	 * @return El nombre del Pasajero.
	 */
	
	public String getNombre();
	
	/**
	 * Establece el nombre del Pasajero.
	 *
	 * @param nombre El nombre del Pasajero.
	 */
	
	public void setNombre(String nombre);
	
	/**
	 * Retorna el apellido del Pasajero.
	 *
	 * @return El apellido del Pasajero.
	 */
	
	public String getApellido();
	
	/**
	 * Establece el apellido del Pasajero.
	 *
	 * @param apellido El apellido del Pasajero.
	 */
	
	public void setApellido(String apellido);
	
	/**
	 * Retorna una representacion del objeto Pasajero en un objeto String.
	 * 
	 * @return Una representacion del objeto Pasajero en un objeto String.
	 */
	
	public String toString();
	
	/**
	 * Crea y retorna una copia del objeto Pasajero.
	 *
	 * @return Una copia de esta instancia del objeto Pasajero.
	 * @throws CloneNotSupportedException Si la clase del objeto no soporta la interfaz Cloneable.
	 */
	
	public Pasajero clone() throws CloneNotSupportedException;
	
	/**
	 * Retorna un codigo hash para el objeto Pasajero.
	 *
	 * @return Un entero representando el codigo hash del objeto Pasajero.
	 */
	
	public int hashCode();
		
	/**
	 * Retorna true si y solo si el objeto obj pasado como parametro no es nulo y ademas los valores de los atributos del objeto Pasajero y los del objeto Pasajero obj a comparar son iguales.
	 *
	 * @param obj El objeto Pasajero a comparar.
	 * @return true, si la condicion se cumple.
	 */
	
	public boolean equals(Object obj);
	
}