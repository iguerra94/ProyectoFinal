package org.proyectofinal.model.interfaces;

import java.sql.Timestamp;

/**
 * Interfaz de la clase de dominio ReservaViaje.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public interface ReservaViaje extends Cloneable {
	
	/**
	 * Retorna el objeto ViajeCabecera relacionado a la ReservaViaje.
	 *
	 * @return El objeto ViajeCabecera relacionado a la ReservaViaje.
	 */

	public ViajeCabecera getViaje();
	
	/**
	 * Establece el objeto ViajeCabecera relacionado a la ReservaViaje.
	 *
	 * @param viaje El objeto ViajeCabecera relacionado a la ReservaViaje.
	 */
	
	public void setViaje(ViajeCabecera viaje);

	/**
	 * Retorna el objeto Pasajero al que esta destinado la ReservaViaje.
	 *
	 * @return El objeto Pasajero al que esta destinado la ReservaViaje.
	 */
	
	public Pasajero getPasajero();
	
	/**
	 * Establece el objeto Pasajero al que esta destinado la ReservaViaje.
	 *
	 * @param pasajero El objeto Pasajero al que esta destinado la ReservaViaje.
	 */
	
	public void setPasajero(Pasajero pasajero);

	/**
	 * Retorna la fecha de la ReservaViaje.
	 *
	 * @return La fecha de la ReservaViaje.
	 */
	
	public Timestamp getFechaReserva();
	
	/**
	 * Establece la fecha de la ReservaViaje.
	 *
	 * @param fechaReserva La fecha de la ReservaViaje.
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
	 * Retorna el precio de la ReservaViaje.
	 *
	 * @return El precio de la ReservaViaje.
	 */
	
	public Float getPrecio();
	
	/**
	 * Establece el precio de la ReservaViaje.
	 *
	 * @param precio El precio de la ReservaViaje.
	 */
	
	public void setPrecio(Float precio);
	
	/**
	 * Retorna una representacion del objeto ReservaViaje en un objeto String.
	 * 
	 * @return Una representacion del objeto ReservaViaje en un objeto String.
	 */
	
	@Override
	public String toString();

	/**
	 * Crea y retorna una copia del objeto ReservaViaje.
	 *
	 * @return Una copia de esta instancia del objeto ReservaViaje.
	 * @throws CloneNotSupportedException Si la clase del objeto no soporta la interfaz Cloneable.
	 */
	
	public ReservaViaje clone() throws CloneNotSupportedException;
	
	/**
	 * Retorna un codigo hash para el objeto ReservaViaje.
	 *
	 * @return Un entero representando el codigo hash del objeto ReservaViaje.
	 */
	
	@Override
	public int hashCode();
	
	/**
	 * Retorna true si y solo si el objeto obj pasado como parametro no es nulo y ademas los valores de los atributos del objeto ReservaViaje y los del objeto ReservaViaje obj a comparar son iguales.
	 *
	 * @param obj El objeto ReservaViaje a comparar.
	 * @return true, si la condicion se cumple.
	 */
	
	@Override
	public boolean equals(Object obj);

}