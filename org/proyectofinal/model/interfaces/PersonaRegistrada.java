package org.proyectofinal.model.interfaces;
	
import java.sql.Date;

/**
 * Interfaz de la clase de dominio PersonaRegistrada.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public interface PersonaRegistrada extends Cloneable {

	/**
	 * Retorna el dni de la PersonaRegistrada.
	 *
	 * @return El dni de la PersonaRegistrada.
	 */

	public String getDni();
	
	/**
	 * Establece el dni de la PersonaRegistrada.
	 *
	 * @param dni El dni de la PersonaRegistrada.
	 */
	
	public void setDni(String dni);
	
	/**
	 * Retorna el nombre de la PersonaRegistrada.
	 *
	 * @return El nombre de la PersonaRegistrada.
	 */
	
	public String getNombre();
	
	/**
	 * Establece el nombre de la PersonaRegistrada.
	 *
	 * @param nombre El nombre de la PersonaRegistrada.
	 */
	
	public void setNombre(String nombre);
	
	/**
	 * Retorna el apellido de la PersonaRegistrada.
	 *
	 * @return El apellido de la PersonaRegistrada.
	 */
	
	public String getApellido();
	
	/**
	 * Establece el apellido de la PersonaRegistrada.
	 *
	 * @param apellido El apellido de la PersonaRegistrada.
	 */
	
	public void setApellido(String apellido);
	
	/**
	 * Retorna el email de la PersonaRegistrada.
	 *
	 * @return El email de la PersonaRegistrada.
	 */
	
	public String getEmail();
	
	/**
	 * Establece el email de la PersonaRegistrada.
	 *
	 * @param email El email de la PersonaRegistrada.
	 */
	
	public void setEmail(String email);
	
	/**
	 * Retorna la fecha de nacimiento de la PersonaRegistrada.
	 *
	 * @return La fecha de nacimiento de la PersonaRegistrada.
	 */
	
	public Date getFechaNacimiento();
	
	/**
	 * Establece la fecha de nacimiento de la PersonaRegistrada.
	 *
	 * @param fechaNacimiento La fecha de nacimiento de la PersonaRegistrada.
	 */
	
	public void setFechaNacimiento(Date fechaNacimiento);
	
	/**
	 * Retorna el telefono de la PersonaRegistrada.
	 *
	 * @return El telefono de la PersonaRegistrada.
	 */
	
	public String getTelefono();
	
	/**
	 * Establece el telefono de la PersonaRegistrada.
	 *
	 * @param telefono El telefono de la PersonaRegistrada.
	 */
	
	public void setTelefono(String telefono);
	
	/**
	 * Retorna el pais de la PersonaRegistrada en formato ISO 3166-1 alfa-3.
	 *
	 * @return El pais de la PersonaRegistrada en formato ISO 3166-1 alfa-3.
	 */
	
	public String getShortPais();
	
	/**
	 * Establece el pais de la PersonaRegistrada en formato ISO 3166-1 alfa-3.
	 *
	 * @param shortPais El pais de la PersonaRegistrada en formato ISO 3166-1 alfa-3.
	 */
	
	public void setShortPais(String shortPais);
	
	/**
	 * Retorna el pais de la PersonaRegistrada.
	 *
	 * @return El pais de la PersonaRegistrada.
	 */
	
	public String getPais();
	
	/**
	 * Establece el pais de la PersonaRegistrada.
	 *
	 * @param pais El pais de la PersonaRegistrada.
	 */
	
	public void setPais(String pais);
	
	/**
	 * Retorna la ciudad de la PersonaRegistrada.
	 *
	 * @return La ciudad de la PersonaRegistrada.
	 */
	
	public String getCiudad();
	
	/**
	 * Establece la ciudad de la PersonaRegistrada.
	 *
	 * @param ciudad La ciudad de la PersonaRegistrada.
	 */
	
	public void setCiudad(String ciudad);
	
	/**
	 * Retorna el saldo de kilometros acumulados de la PersonaRegistrada.
	 *
	 * @return El saldo de kilometros acumulados de la PersonaRegistrada.
	 */
	
	public Integer getSaldo();
	
	/**
	 * Establece el saldo de kilometros acumulados de la PersonaRegistrada.
	 *
	 * @param saldo El saldo de kilometros acumulados de la PersonaRegistrada.
	 */
	
	public void setSaldo(Integer saldo);
	
	/**
	 * Retorna el objeto Usuario relacionado a la PersonaRegistrada.
	 *
	 * @return El objeto Usuario relacionado a la PersonaRegistrada.
	 */
	
	public Usuario getUsuario();
	
	/**
	 * Establece el objeto Usuario relacionado a la PersonaRegistrada.
	 *
	 * @param usuario El objeto Usuario relacionado a la PersonaRegistrada.
	 */
	
	public void setUsuario(Usuario usuario);
	
	/**
	 * Retorna una representacion del objeto PersonaRegistrada en un objeto String.
	 * 
	 * @return Una representacion del objeto PersonaRegistrada en un objeto String.
	 */
	
	@Override
	public String toString();
	
	/**
	 * Crea y retorna una copia del objeto PersonaRegistrada.
	 *
	 * @return Una copia de esta instancia del objeto PersonaRegistrada.
	 * @throws CloneNotSupportedException Si la clase del objeto no soporta la interfaz Cloneable.
	 */
	
	public PersonaRegistrada clone() throws CloneNotSupportedException;
	
	/**
	 * Retorna un codigo hash para el objeto PersonaRegistrada.
	 *
	 * @return Un entero representando el codigo hash del objeto PersonaRegistrada.
	 */
	
	@Override
	public int hashCode();

	/**
	 * Retorna true si y solo si el objeto obj pasado como parametro no es nulo y ademas los valores de los atributos del objeto PersonaRegistrada y los del objeto PersonaRegistrada obj a comparar son iguales.
	 *
	 * @param obj El objeto PersonaRegistrada a comparar.
	 * @return true, si la condicion se cumple.
	 */
	
	@Override
	public boolean equals(Object obj);

}