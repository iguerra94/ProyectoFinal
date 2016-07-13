package org.proyectofinal.model.interfaces;
	
import java.sql.Date;

/**
 * Interfaz de la clase de dominio <code>PersonaRegistrada</code>.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public interface PersonaRegistrada extends Cloneable {

	/**
	 * Retorna el dni de la <code>PersonaRegistrada</code>.
	 *
	 * @return El dni de la <code>PersonaRegistrada</code>.
	 */

	public String getDni();
	
	/**
	 * Establece el dni de la <code>PersonaRegistrada</code>.
	 *
	 * @param dni El dni de la <code>PersonaRegistrada</code>.
	 */
	
	public void setDni(String dni);
	
	/**
	 * Retorna el nombre de la <code>PersonaRegistrada</code>.
	 *
	 * @return El nombre de la <code>PersonaRegistrada</code>.
	 */
	
	public String getNombre();
	
	/**
	 * Establece el nombre de la <code>PersonaRegistrada</code>.
	 *
	 * @param nombre El nombre de la <code>PersonaRegistrada</code>.
	 */
	
	public void setNombre(String nombre);
	
	/**
	 * Retorna el apellido de la <code>PersonaRegistrada</code>.
	 *
	 * @return El apellido de la <code>PersonaRegistrada</code>.
	 */
	
	public String getApellido();
	
	/**
	 * Establece el apellido de la <code>PersonaRegistrada</code>.
	 *
	 * @param apellido El apellido de la <code>PersonaRegistrada</code>.
	 */
	
	public void setApellido(String apellido);
	
	/**
	 * Retorna el email de la <code>PersonaRegistrada</code>.
	 *
	 * @return El email de la <code>PersonaRegistrada</code>.
	 */
	
	public String getEmail();
	
	/**
	 * Establece el email de la <code>PersonaRegistrada</code>.
	 *
	 * @param email El email de la <code>PersonaRegistrada</code>.
	 */
	
	public void setEmail(String email);
	
	/**
	 * Retorna la fecha de nacimiento de la <code>PersonaRegistrada</code>.
	 *
	 * @return La fecha de nacimiento de la <code>PersonaRegistrada</code>.
	 */
	
	public Date getFechaNacimiento();
	
	/**
	 * Establece la fecha de nacimiento de la <code>PersonaRegistrada</code>.
	 *
	 * @param fechaNacimiento La fecha de nacimiento de la <code>PersonaRegistrada</code>.
	 */
	
	public void setFechaNacimiento(Date fechaNacimiento);
	
	/**
	 * Retorna el telefono de la <code>PersonaRegistrada</code>.
	 *
	 * @return El telefono de la <code>PersonaRegistrada</code>.
	 */
	
	public String getTelefono();
	
	/**
	 * Establece el telefono de la <code>PersonaRegistrada</code>.
	 *
	 * @param telefono El telefono de la <code>PersonaRegistrada</code>.
	 */
	
	public void setTelefono(String telefono);
	
	/**
	 * Retorna el pais de la <code>PersonaRegistrada</code> en formato ISO 3166-1 alfa-3.
	 *
	 * @return El pais de la <code>PersonaRegistrada</code> en formato ISO 3166-1 alfa-3.
	 */
	
	public String getShortPais();
	
	/**
	 * Establece el pais de la <code>PersonaRegistrada</code> en formato ISO 3166-1 alfa-3.
	 *
	 * @param shortPais El pais de la <code>PersonaRegistrada</code> en formato ISO 3166-1 alfa-3.
	 */
	
	public void setShortPais(String shortPais);
	
	/**
	 * Retorna el pais de la <code>PersonaRegistrada</code>.
	 *
	 * @return El pais de la <code>PersonaRegistrada</code>.
	 */
	
	public String getPais();
	
	/**
	 * Establece el pais de la <code>PersonaRegistrada</code>.
	 *
	 * @param pais El pais de la <code>PersonaRegistrada</code>.
	 */
	
	public void setPais(String pais);
	
	/**
	 * Retorna la ciudad de la <code>PersonaRegistrada</code>.
	 *
	 * @return La ciudad de la <code>PersonaRegistrada</code>.
	 */
	
	public String getCiudad();
	
	/**
	 * Establece la ciudad de la <code>PersonaRegistrada</code>.
	 *
	 * @param ciudad La ciudad de la <code>PersonaRegistrada</code>.
	 */
	
	public void setCiudad(String ciudad);
	
	/**
	 * Retorna el saldo de kilometros acumulados de la <code>PersonaRegistrada</code>.
	 *
	 * @return El saldo de kilometros acumulados de la <code>PersonaRegistrada</code>.
	 */
	
	public Integer getSaldo();
	
	/**
	 * Establece el saldo de kilometros acumulados de la <code>PersonaRegistrada</code>.
	 *
	 * @param saldo El saldo de kilometros acumulados de la <code>PersonaRegistrada</code>.
	 */
	
	public void setSaldo(Integer saldo);
	
	/**
	 * Retorna el objeto Usuario relacionado a la <code>PersonaRegistrada</code>.
	 *
	 * @return El objeto Usuario relacionado a la <code>PersonaRegistrada</code>.
	 */
	
	public Usuario getUsuario();
	
	/**
	 * Establece el objeto Usuario relacionado a la <code>PersonaRegistrada</code>.
	 *
	 * @param usuario El objeto Usuario relacionado a la <code>PersonaRegistrada</code>.
	 */
	
	public void setUsuario(Usuario usuario);
	
	/**
	 * Retorna una representacion del objeto <code>PersonaRegistrada</code> en un objeto String.
	 * 
	 * @return Una representacion del objeto <code>PersonaRegistrada</code> en un objeto String.
	 */
	
	@Override
	public String toString();
	
	/**
	 * Crea y retorna una copia del objeto <code>PersonaRegistrada</code>.
	 *
	 * @return Una copia de esta instancia del objeto <code>PersonaRegistrada</code>.
	 * @throws CloneNotSupportedException Si la clase del objeto no soporta la interfaz Cloneable.
	 */
	
	public PersonaRegistrada clone() throws CloneNotSupportedException;
	
	/**
	 * Retorna un codigo hash para el objeto <code>PersonaRegistrada</code>.
	 *
	 * @return Un entero representando el codigo hash del objeto <code>PersonaRegistrada</code>.
	 */
	
	@Override
	public int hashCode();

	/**
	 * Retorna true si y solo si el objeto obj pasado como parametro no es nulo y ademas los valores de los atributos del objeto <code>PersonaRegistrada</code> y los del objeto <code>PersonaRegistrada</code> obj a comparar son iguales.
	 *
	 * @param obj El objeto <code>PersonaRegistrada</code> a comparar.
	 * @return true, si la condicion se cumple.
	 */
	
	@Override
	public boolean equals(Object obj);

}