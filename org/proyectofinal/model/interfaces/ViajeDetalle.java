package org.proyectofinal.model.interfaces;

import java.sql.Date;

// TODO: Auto-generated Javadoc
/**
 * Interfaz de la entidad ViajeDetalle.
 */
public interface ViajeDetalle extends Cloneable {
	
	/**
	 * Obtiene la persona que reservó el viaje.
	 *
	 * @return La persona que reservó el viaje.
	 */
//	public Persona getPersona();
	
	/**
	 * Establece la persona que reservó el viaje.
	 *
	 * @param persona con la persona que reservó el viaje.
	 */
//	public void setPersona(Persona persona);
	
	/**
	 * Obtiene el viaje.
	 *
	 * @return El viaje.
	 */
	public ViajeCabecera getViaje();
	
	/**
	 * Establece el viaje.
	 *
	 * @param viaje con el viaje
	 */
	public void setViaje(ViajeCabecera viaje);
	
	/**
	 * Gets the fecha reserva.
	 *
	 * @return the fecha reserva
	 */
	public Date getFechaReserva();
	
	/**
	 * Sets the fecha reserva.
	 *
	 * @param fechaReserva the new fecha reserva
	 */
	public void setFechaReserva(Date fechaReserva);
	
	/**
	 * Gets the asiento.
	 *
	 * @return the asiento
	 */
//	public Integer getAsiento();
	
	/**
	 * Sets the asiento.
	 *
	 * @param asiento the new asiento
	 */
//	public void setAsiento(Integer asiento);
	
	/**
	 * Gets the precio.
	 *
	 * @return the precio
	 */
//	public Float getPrecio();
	
	/**
	 * Sets the precio.
	 *
	 * @param precio the new precio
	 */
//	public void setPrecio(Float precio);
	
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
	 * @return the viaje detalle
	 * @throws CloneNotSupportedException the clone not supported exception
	 */
	public ViajeDetalle clone() throws CloneNotSupportedException;
}