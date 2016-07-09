package org.proyectofinal.model.impl;
	
import java.sql.Timestamp;

import org.proyectofinal.model.interfaces.Pasajero;
import org.proyectofinal.model.interfaces.ReservaViaje;
import org.proyectofinal.model.interfaces.ViajeCabecera;

/**
 * Implementacion de la clase de dominio ReservaViaje.
 * <br /><br />Representa una Reserva de un pasajero en un viaje en particular, con todos los datos correspondientes.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public class ReservaViajeImpl implements ReservaViaje {
	
	/** El ViajeCabecera relacionado a la ReservaViaje. */
	private ViajeCabecera viaje = null;
	
	/** El Pasajero al que esta destinado la ReservaViaje */
	private Pasajero pasajero = null;
	
	/** La fecha de la ReservaViaje */
	private Timestamp fechaReserva = null;
	
	/** El dni de la persona que reserva el viaje. */
	private String dniPersona = null;
	
	/** El asiento del pasajero. */
	private Integer asiento = null;
	
	/** El precio de la ReservaViaje. */
	private Float precio = null;
	
	/**
	 * Instancia un nuevo objeto de la clase ReservaViaje.
	 */

	public ReservaViajeImpl(){
		
		java.util.Date d = new java.util.Date();
		
		java.sql.Timestamp fecha = new java.sql.Timestamp(d.getTime());
		
		this.setFechaReserva(fecha);
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ReservaViaje#getViaje()
	 */
	
	public ViajeCabecera getViaje() {
		return this.viaje;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ReservaViaje#setViaje(org.proyectofinal.model.interfaces.ViajeCabecera)
	 */
	
	public void setViaje(ViajeCabecera viaje) {
		this.viaje = viaje;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ReservaViaje#getPasajero()
	 */
	
	public Pasajero getPasajero() {
		return this.pasajero;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ReservaViaje#setPasajero(org.proyectofinal.model.interfaces.Pasajero)
	 */
	
	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ReservaViaje#getFechaReserva()
	 */
	
	public Timestamp getFechaReserva() {
		return this.fechaReserva;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ReservaViaje#setFechaReserva(java.sql.Timestamp)
	 */
	
	public void setFechaReserva(Timestamp fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ReservaViaje#getDniPersona()
	 */
	
	public String getDniPersona() {
		return dniPersona;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ReservaViaje#setDniPersona(java.lang.String)
	 */
	
	public void setDniPersona(String dniPersona) {
		this.dniPersona = dniPersona;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ReservaViaje#getAsiento()
	 */
	
	public Integer getAsiento(){
		return this.asiento;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ReservaViaje#setAsiento(java.lang.Integer)
	 */
	
	public void setAsiento(Integer asiento){
		this.asiento = asiento;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ReservaViaje#getPrecio()
	 */
	
	public Float getPrecio(){
		return this.precio;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ReservaViaje#setPrecio(java.lang.Float)
	 */
	
	public void setPrecio(Float precio){
		this.precio = precio;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
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

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	
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

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	
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