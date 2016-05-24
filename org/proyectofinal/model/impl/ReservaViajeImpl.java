package org.proyectofinal.model.impl;
	
import java.sql.Timestamp;

import org.proyectofinal.model.interfaces.Pasajero;
import org.proyectofinal.model.interfaces.ReservaViaje;
import org.proyectofinal.model.interfaces.ViajeCabecera;

public class ReservaViajeImpl implements ReservaViaje {
	
	private ViajeCabecera viaje = null;
	private Pasajero pasajero = null;
	private Timestamp fechaReserva = null;
	private String dniPersona = null;
	private Integer asiento = null;
	private Float precio = null;
	
	public ReservaViajeImpl(){
		
		java.util.Date d = new java.util.Date();
		
		java.sql.Timestamp fecha = new java.sql.Timestamp(d.getTime());
		
		this.setFechaReserva(fecha);
	}

	public ViajeCabecera getViaje() {
		return this.viaje;
	}
	
	public void setViaje(ViajeCabecera viaje) {
		this.viaje = viaje;
	}
	
	public Pasajero getPasajero() {
		return this.pasajero;
	}
	
	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}

	public Timestamp getFechaReserva() {
		return this.fechaReserva;
	}
	
	public void setFechaReserva(Timestamp fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public String getDniPersona() {
		return dniPersona;
	}

	public void setDniPersona(String dniPersona) {
		this.dniPersona = dniPersona;
	}
	
	public Integer getAsiento(){
		return this.asiento;
	}
	
	public void setAsiento(Integer asiento){
		this.asiento = asiento;
	}
	
	public Float getPrecio(){
		return this.precio;
	}
	
	public void setPrecio(Float precio){
		this.precio = precio;
	}
	
	@Override
	public String toString() {

		String res = "Reserva del Viaje: \n";
		
		res += getViaje().toString() + "\n";
		res += getPasajero().toString() + "\n";
		res += "Fecha de Reserva: " + getFechaReserva() + "\n";
		res += "Persona que reservó: " + getDniPersona() + "\n";
		res += "Asiento: " + getAsiento() + "\n";
		res += "Precio: " + getPrecio() + "\n";
		
		return res; 
	}

	public ReservaViaje clone() throws CloneNotSupportedException {

		ReservaViaje rV = new ReservaViajeImpl();
	
		rV.setViaje(getViaje());
		rV.setPasajero(getPasajero());
		rV.setFechaReserva(getFechaReserva());
		rV.setDniPersona(getDniPersona());
		rV.setAsiento(getAsiento());
		rV.setPrecio(getPrecio());
		
		return rV;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asiento == null) ? 0 : asiento.hashCode());
		result = prime * result + ((dniPersona == null) ? 0 : dniPersona.hashCode());
		result = prime * result + ((fechaReserva == null) ? 0 : fechaReserva.hashCode());
		result = prime * result + ((pasajero == null) ? 0 : pasajero.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		result = prime * result + ((viaje == null) ? 0 : viaje.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservaViajeImpl other = (ReservaViajeImpl) obj;
		if (asiento == null) {
			if (other.asiento != null)
				return false;
		} else if (!asiento.equals(other.asiento))
			return false;
		if (dniPersona == null) {
			if (other.dniPersona != null)
				return false;
		} else if (!dniPersona.equals(other.dniPersona))
			return false;
		if (fechaReserva == null) {
			if (other.fechaReserva != null)
				return false;
		} else if (!fechaReserva.equals(other.fechaReserva))
			return false;
		if (pasajero == null) {
			if (other.pasajero != null)
				return false;
		} else if (!pasajero.equals(other.pasajero))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		if (viaje == null) {
			if (other.viaje != null)
				return false;
		} else if (!viaje.equals(other.viaje))
			return false;
		return true;
	}

	
}