package org.proyectofinal.model.interfaces;

import java.sql.Timestamp;

/**
 * Interfaz de la clase de dominio <code>ReservaViaje</code>.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public interface ReservaViaje extends Cloneable {
	
	/**
	 * Retorna el objeto <code>ViajeCabecera</code> relacionado a la <code>ReservaViaje</code>.
	 *
	 * @return El objeto <code>ViajeCabecera</code> relacionado a la <code>ReservaViaje</code>.
	 */

	public ViajeCabecera getViaje();
	
	/**
	 * Establece el objeto <code>ViajeCabecera</code> relacionado a la <code>ReservaViaje</code>.
	 *
	 * @param viaje El objeto <code>ViajeCabecera</code> relacionado a la <code>ReservaViaje</code>.
	 */
	
	public void setViaje(ViajeCabecera viaje);

	/**
	 * Retorna el objeto <code>Pasajero</code> al que esta destinado la <code>ReservaViaje</code>.
	 *
	 * @return El objeto <code>Pasajero</code> al que esta destinado la <code>ReservaViaje</code>.
	 */
	
	public Pasajero getPasajero();
	
	/**
	 * Establece el objeto <code>Pasajero</code> al que esta destinado la <code>ReservaViaje</code>.
	 *
	 * @param pasajero El objeto <code>Pasajero</code> al que esta destinado la <code>ReservaViaje</code>.
	 */
	
	public void setPasajero(Pasajero pasajero);

	/**
	 * Retorna la fecha de la <code>ReservaViaje</code>.
	 *
	 * @return La fecha de la <code>ReservaViaje</code>.
	 */
	
	public Timestamp getFechaReserva();
	
	/**
	 * Establece la fecha de la <code>ReservaViaje</code>.
	 *
	 * @param fechaReserva La fecha de la <code>ReservaViaje</code>.
	 */
	
	public void setFechaReserva(Timestamp fechaReserva);

	/**
	 * Retorna el dni de la persona que reserva el viaje.
	 *
	 * @return El dni de la persona que reserva el viaje.
	 */
	
	public String getDniPersona();
	
	/**
	 * Establece el dni de la persona que reserva el viaje.
	 *
	 * @param dniPersona El dni de la persona que reserva el viaje.
	 */
	
	public void setDniPersona(String dniPersona);

	/**
	 * Retorna el asiento del pasajero.
	 *
	 * @return El asiento del pasajero.
	 */
	
	public Integer getAsiento();
	
	/**
	 * Establece el asiento del pasajero.
	 *
	 * @param asiento El asiento del pasajero.
	 */
	
	public void setAsiento(Integer asiento);
	
	/**
	 * Retorna el precio de la <code>ReservaViaje</code>.
	 *
	 * @return El precio de la <code>ReservaViaje</code>.
	 */
	
	public Float getPrecio();
	
	/**
	 * Establece el precio de la <code>ReservaViaje</code>.
	 *
	 * @param precio El precio de la <code>ReservaViaje</code>.
	 */
	
	public void setPrecio(Float precio);
	
	/**
	 * Retorna una representacion del objeto <code>ReservaViaje</code> en un objeto String.
	 * 
	 * @return Una representacion del objeto <code>ReservaViaje</code> en un objeto String.
	 */
	
	@Override
	public String toString();

	/**
	 * Crea y retorna una copia del objeto <code>ReservaViaje</code>.
	 *
	 * @return Una copia de esta instancia del objeto <code>ReservaViaje</code>.
	 * @throws CloneNotSupportedException Si la clase del objeto no soporta la interfaz Cloneable.
	 */
	
	public ReservaViaje clone() throws CloneNotSupportedException;
	
	/**
	 * Retorna un codigo hash para el objeto <code>ReservaViaje</code>.
	 *
	 * @return Un entero representando el codigo hash del objeto <code>ReservaViaje</code>.
	 */
	
	@Override
	public int hashCode();
	
	/**
	 * Retorna true si y solo si el objeto obj pasado como parametro no es nulo y ademas los valores de los atributos del objeto <code>ReservaViaje</code> y los del objeto <code>ReservaViaje</code> obj a comparar son iguales.
	 *
	 * @param obj El objeto <code>ReservaViaje</code> a comparar.
	 * @return true, si la condicion se cumple.
	 */
	
	@Override
	public boolean equals(Object obj);

}