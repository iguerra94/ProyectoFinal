package org.proyectofinal.model.interfaces;

import java.sql.Timestamp;

// TODO: Auto-generated Javadoc
/**
 * Interfaz de la entidad ReservaViaje.
 */
public interface ReservaViaje extends Cloneable {
	
	public ViajeCabecera getViaje();
	public void setViaje(ViajeCabecera viaje);

	public Pasajero getPasajero();
	public void setPasajero(Pasajero pasajero);

	public Timestamp getFechaReserva();
	public void setFechaReserva(Timestamp fechaReserva);

	public String getDniPersona();
	public void setDniPersona(String dniPersona);

	public Integer getAsiento();
	public void setAsiento(Integer asiento);
	
	public Float getPrecio();
	public void setPrecio(Float precio);
	
	@Override
	public String toString();

	public ReservaViaje clone() throws CloneNotSupportedException;
	
	@Override
	public int hashCode();
	
	@Override
	public boolean equals(Object obj);
}