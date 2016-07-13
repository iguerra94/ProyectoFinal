package org.proyectofinal.model.interfaces;

import java.sql.Timestamp;

/**
 * Interfaz de la clase de dominio <code>Usuario</code>.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public interface Usuario extends Cloneable {

	/**
	 * Retorna el nombre de usuario del <code>Usuario</code>.
	 * 
	 * @return El nombre de usuario del <code>Usuario</code>.
	 */
	
	public String getNombreUsuario();
	
	/**
	 * Establece el nombre de usuario del <code>Usuario</code>.
	 *
	 * @param nombreUsuario El nombre de usuario del <code>Usuario</code>.
	 */
	
	public void setNombreUsuario(String nombreUsuario);

	/**
	 * Retorna la contraseña del <code>Usuario</code>.
	 *
	 * @return La contraseña del <code>Usuario</code>.
	 */
	
	public String getPassword();
	
	/**
	 * Establece la contraseña del <code>Usuario</code>.
	 *
	 * @param password La contraseña del <code>Usuario</code>.
	 */
	
	public void setPassword(String password);
	
	/**
	 * Retorna el tipo de usuario del <code>Usuario</code>.
	 *
	 * @return El tipo de usuario del <code>Usuario</code>.
	 */
	
	public Integer getTipoUsuario();
	
	/**
	 * Establece el tipo de usuario del <code>Usuario</code>.
	 * 
	 * @param tipoUsuario El tipo de usuario del <code>Usuario</code>.
	 */
	
	public void setTipoUsuario(Integer tipoUsuario);
	
	/**
	 * Retorna la fecha de registro del <code>Usuario</code>.
	 *
	 * @return La fecha de registro del <code>Usuario</code>.
	 */
	
	public Timestamp getFechaInicio();
	
	/**
	 * Establece la fecha de registro del <code>Usuario</code>.
	 *
	 * @param fechaInicio La fecha de registro del <code>Usuario</code>.
	 */
	
	public void setFechaInicio(Timestamp fechaInicio);
	
	/**
	 * Retorna una representacion del objeto <code>Usuario</code> en un objeto String.
	 * 
	 * @return Una representacion del objeto <code>Usuario</code> en un objeto String.
	 */
	
	@Override
	public String toString();
	
	/**
	 * Crea y retorna una copia del objeto <code>Usuario</code>.
	 *
	 * @return Una copia de esta instancia del objeto <code>Usuario</code>.
	 * @throws CloneNotSupportedException Si la clase del objeto no soporta la interfaz Cloneable.
	 */
	
	public Usuario clone() throws CloneNotSupportedException;
	
	/**
	 * Retorna un codigo hash para el objeto <code>Usuario</code>.
	 *
	 * @return Un entero representando el codigo hash del objeto <code>Usuario</code>.
	 */
	
	@Override
	public int hashCode();
	
	/**
	 * Retorna true si y solo si el objeto obj pasado como parametro no es nulo y ademas los valores de los atributos del objeto <code>Usuario</code> y los del objeto <code>Usuario</code> obj a comparar son iguales.
	 *
	 * @param obj El objeto <code>Usuario</code> a comparar.
	 * @return true, si la condicion se cumple.
	 */
	
	@Override
	public boolean equals(Object obj);
	
}