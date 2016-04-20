package org.proyectofinal.model.interfaces;

import java.sql.Date;

// TODO: Auto-generated Javadoc
/**
 *  Interfaz de la Entidad Persona
 */
public interface Persona extends Cloneable {

	/**
	 * Obtiene el dni de la persona.
	 *
	 * @return El dni de la persona.
	 */
	public String getDni();
	
	/**
	 * Establece el dni de la persona.
	 *
	 * @param dni con el dni de la persona.
	 */
	public void setDni(String dni);

	/**
	 * Obtiene el nombre de la persona.
	 *
	 * @return El nombre de la persona.
	 */
	public String getNombre();
	
	/**
	 * Establece el nombre de la persona. 
	 *
	 * @param nombre con el nombre de la persona.
	 */
	public void setNombre(String nombre);

	/**
	 * Obtiene el apellido de la persona.
	 *
	 * @return el apellido de la persona.
	 */
	public String getApellido();
	
	/**
	 * Establece el apellido de la persona.
	 *
	 * @param apellido con el apellido de la persona.
	 */
	public void setApellido(String apellido);

	/**
	 * Obtiene el email de contacto de la persona.
	 *
	 * @return El email de contacto de la persona.
	 */
	public String getEmail();
	
	/**
	 * Establece el email de contacto la persona.
	 *
	 * @param email con el email de contacto de la persona.
	 */
	public void setEmail(String email);

	/**
	 * Obtiene la fecha de nacimiento de la persona.
	 *
	 * @return La fecha de nacimiento de la persona.
	 */
	public Date getFechaNacimiento();
	
	/**
	 * Establece la fecha de nacimiento de la persona.
	 *
	 * @param fechaNacimiento con la fecha de nacimiento de la persona.
	 */
	public void setFechaNacimiento(Date fechaNacimiento);
	
	/**
	 * Obtiene el telefono de la persona.
	 *
	 * @return El telefono de la persona.
	 */
	public String getTelefono();
	
	/**
	 * Establece el telefono de la persona.
	 *
	 * @param telefono con el telefono de la persona.
	 */
	public void setTelefono(String telefono);
	
	/**
	 * Obtiene el pais de residencia de la persona.
	 *
	 * @return El pais de residencia de la persona.
	 */
	public String getPais();
	
	/**
	 * Establece el pais de residencia de la persona.
	 *
	 * @param pais con el pais de residencia de la persona.
	 */
	public void setPais(String pais);

	/**
	 * Obtiene la ciudad de residencia de la persona.
	 *
	 * @return La ciudad de residencia de la persona.
	 */
	public String getCiudad();
	
	/**
	 * Establece la ciudad de residencia de la persona.
	 *
	 * @param ciudad con la ciudad de residencia de la persona.
	 */
	public void setCiudad(String ciudad);
	
	/**
	 * Gets the usuario.
	 *
	 * @return the usuario
	 */
	public Usuario getUsuario();
	
	/**
	 * Sets the usuario.
	 *
	 * @param usuario the new usuario
	 */
	public void setUsuario(Usuario usuario);
	
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
	 * @return the persona
	 * @throws CloneNotSupportedException the clone not supported exception
	 */
	public Persona clone() throws CloneNotSupportedException;
}