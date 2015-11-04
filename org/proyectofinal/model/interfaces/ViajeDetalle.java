package org.proyectofinal.model.interfaces;

import java.sql.Date;

public interface ViajeDetalle extends Cloneable {
	
	public Persona getPersona();
	public void setPersona(Persona persona);
	
	public ViajeCabecera getViaje();
	public void setViaje(ViajeCabecera viaje);
	
	public Date getFechaReserva();
	public void setFechaReserva(Date fechaReserva);
	
	public Integer getAsiento();
	public void setAsiento(Integer asiento);
	
	public Float getPrecio();
	public void setPrecio(Float precio);
	
	@Override
	public int hashCode();
	
	@Override
	public boolean equals(Object obj);
	
	@Override
	public String toString();
	
	public ViajeDetalle clone() throws CloneNotSupportedException;
}