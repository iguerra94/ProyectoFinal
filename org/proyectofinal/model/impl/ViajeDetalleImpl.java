package org.proyectofinal.model.impl;

import java.sql.Date;

import org.proyectofinal.model.interfaces.Persona;
import org.proyectofinal.model.interfaces.ViajeCabecera;
import org.proyectofinal.model.interfaces.ViajeDetalle;
import org.proyectofinal.ui.util.Pasajero;

public class ViajeDetalleImpl implements ViajeDetalle {
	
//	private Persona persona = null;
	private Pasajero pasajero = null;
	private ViajeCabecera viaje = null;
	private Date fechaReserva = null;
//	private Integer asiento = null;
//	private Float precio = null;
	
	public ViajeDetalleImpl(){
		
	}

//	public Persona getPersona() {
//		return persona;
//	}

//	public void setPersona(Persona persona) {
//		this.persona = persona;
//	}

	public ViajeCabecera getViaje() {
		return viaje;
	}

	public void setViaje(ViajeCabecera viaje) {
		this.viaje = viaje;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

//	public Integer getAsiento() {
//		return asiento;
//	}
//
//	public void setAsiento(Integer asiento) {
//		this.asiento = asiento;
//	}
//
//	public Float getPrecio() {
//		return precio;
//	}
//
//	public void setPrecio(Float precio) {
//		this.precio = precio;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((asiento == null) ? 0 : asiento.hashCode());
		result = prime * result
				+ ((fechaReserva == null) ? 0 : fechaReserva.hashCode());
//		result = prime * result + ((persona == null) ? 0 : persona.hashCode());
//		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
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
		ViajeDetalleImpl other = (ViajeDetalleImpl) obj;
//		if (asiento == null) {
//			if (other.asiento != null)
//				return false;
//		} else if (!asiento.equals(other.asiento))
//			return false;
		if (fechaReserva == null) {
			if (other.fechaReserva != null)
				return false;
		} else if (!fechaReserva.equals(other.fechaReserva))
			return false;
//		if (persona == null) {
//			if (other.persona != null)
//				return false;
//		} else if (!persona.equals(other.persona))
//			return false;
//		if (precio == null) {
//			if (other.precio != null)
//				return false;
//		} else if (!precio.equals(other.precio))
//			return false;
		if (viaje == null) {
			if (other.viaje != null)
				return false;
		} else if (!viaje.equals(other.viaje))
			return false;
		return true;
	}

	@Override
	public String toString() {

		String res = "Detalle del Viaje: \n";
		
		res += getPersona().toString() + "\n";
		res += getViaje().toString() + "\n";
		res += "Fecha de Reserva: " + getFechaReserva() + "\n";
//		res += "Asiento: " + getAsiento() + "\n";
//		res += "Precio: " + getPrecio() + "\n";
		
		return res; 
	}

	public ViajeDetalle clone() throws CloneNotSupportedException {

		ViajeDetalle vD = new ViajeDetalleImpl();
		
		vD.setPersona(getPersona());
		vD.setViaje(getViaje());
		vD.setFechaReserva(getFechaReserva());
//		vD.setAsiento(getAsiento());
//		vD.setPrecio(getPrecio());
		
		return vD;
	}
		
}