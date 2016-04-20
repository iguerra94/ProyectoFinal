package org.proyectofinal.model.interfaces;

import java.sql.Timestamp;

// TODO: Auto-generated Javadoc
/**
 * The Interface Usuario.
 */
public interface Usuario extends Cloneable {

	/**
	 * Obtiene el nombre de usuario
	 *
	 * @return El nombre de usuario.
	 */
	public String getNombreUsuario();
	
	/**
	 * Establece el nombre de usuario.
	 *
	 * @param nombreUsuario con el nombre de usuario.
	 */
	public void setNombreUsuario(String nombreUsuario);

	/**
	 * Obtiene la contraseña.
	 *
	 * @return La contraseña.
	 */
	public String getPassword();
	
	/**
	 * Establece la contraseña.
	 *
	 * @param password con la contraseña.
	 */
	public void setPassword(String password);
	
	/**
	 * Obtiene el tipo de usuario.
	 *
	 * @return El tipo de usuario.
	 */
	public Integer getTipoUsuario();
	
	/**
	 * Establece el tipo de usuario.
	 *
	 * @param tipoUsuario con el tipo de usuario.
	 */
	public void setTipoUsuario(Integer tipoUsuario);
	
	/**
	 * Obtiene la fecha de registro del usuario.
	 *
	 * @return La fecha de registro del usuario.
	 */
	public Timestamp getFechaInicio();
	
	/**
	 * Establece la fecha de registro del usuario.
	 *
	 * @param fechaInicio con la fecha de registro del usuario.
	 */
	public void setFechaInicio(Timestamp fechaInicio);
	
	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode();
	
	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj);
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString();
	
	/**
	 * Clone.
	 *
	 * @return the usuario
	 * @throws CloneNotSupportedException the clone not supported exception
	 */
	public Usuario clone() throws CloneNotSupportedException;
}