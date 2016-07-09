package org.proyectofinal.model.interfaces;

import java.sql.Timestamp;

/**
 * Interfaz de la clase de dominio Usuario.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public interface Usuario extends Cloneable {

	/**
	 * Retorna el nombre de usuario del Usuario.
	 * 
	 * @return El nombre de usuario del Usuario.
	 */
	
	public String getNombreUsuario();
	
	/**
	 * Establece el nombre de usuario del Usuario.
	 *
	 * @param nombreUsuario El nombre de usuario del Usuario.
	 */
	
	public void setNombreUsuario(String nombreUsuario);

	/**
	 * Retorna la contraseña del Usuario.
	 *
	 * @return La contraseña del Usuario.
	 */
	
	public String getPassword();
	
	/**
	 * Establece la contraseña del Usuario.
	 *
	 * @param password La contraseña del Usuario.
	 */
	
	public void setPassword(String password);
	
	/**
	 * Retorna el tipo de usuario del Usuario.
	 *
	 * @return El tipo de usuario del Usuario.
	 */
	
	public Integer getTipoUsuario();
	
	/**
	 * Establece el tipo de usuario del Usuario.
	 * 
	 * @param tipoUsuario El tipo de usuario del Usuario.
	 */
	
	public void setTipoUsuario(Integer tipoUsuario);
	
	/**
	 * Retorna la fecha de registro del Usuario.
	 *
	 * @return La fecha de registro del Usuario.
	 */
	
	public Timestamp getFechaInicio();
	
	/**
	 * Establece la fecha de registro del Usuario.
	 *
	 * @param fechaInicio La fecha de registro del Usuario.
	 */
	
	public void setFechaInicio(Timestamp fechaInicio);
	
	/**
	 * Retorna una representacion del objeto Usuario en un objeto String.
	 * 
	 * @return Una representacion del objeto Usuario en un objeto String.
	 */
	
	@Override
	public String toString();
	
	/**
	 * Crea y retorna una copia del objeto Usuario.
	 *
	 * @return Una copia de esta instancia del objeto Usuario.
	 * @throws CloneNotSupportedException Si la clase del objeto no soporta la interfaz Cloneable.
	 */
	
	public Usuario clone() throws CloneNotSupportedException;
	
	/**
	 * Retorna un codigo hash para el objeto Usuario.
	 *
	 * @return Un entero representando el codigo hash del objeto Usuario.
	 */
	
	@Override
	public int hashCode();
	
	/**
	 * Retorna true si y solo si el objeto obj pasado como parametro no es nulo y ademas los valores de los atributos del objeto Usuario y los del objeto Usuario obj a comparar son iguales.
	 *
	 * @param obj El objeto Usuario a comparar.
	 * @return true, si la condicion se cumple.
	 */
	
	@Override
	public boolean equals(Object obj);
	
}