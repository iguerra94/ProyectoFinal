package org.proyectofinal.model.impl;

import java.sql.Timestamp;

import org.proyectofinal.model.interfaces.ViajeCabecera;

public class ViajeCabeceraImpl implements ViajeCabecera {
	
	private Integer codigoViaje = null;
	private String ciudadOrigen = null;
	private String paisOrigen = null;
	private String ciudadDestino = null;
	private String paisDestino = null;
	private Timestamp fechaSalida = null;
	private Timestamp fechaLlegada = null;
	
	public ViajeCabeceraImpl(){
		
	}

	public Integer getCodigoViaje() {
		return codigoViaje;
	}

	public void setCodigoViaje(Integer codigoViaje) {
		this.codigoViaje = codigoViaje;
	}

	public String getCiudadOrigen() {
		return ciudadOrigen;
	}

	public void setCiudadOrigen(String ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	public String getCiudadDestino() {
		return ciudadDestino;
	}

	public void setCiudadDestino(String ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}

	public String getPaisDestino() {
		return paisDestino;
	}

	public void setPaisDestino(String paisDestino) {
		this.paisDestino = paisDestino;
	}

	public Timestamp getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Timestamp fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Timestamp getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(Timestamp fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((ciudadDestino == null) ? 0 : ciudadDestino.hashCode());
		result = prime * result
				+ ((ciudadOrigen == null) ? 0 : ciudadOrigen.hashCode());
		result = prime * result
				+ ((codigoViaje == null) ? 0 : codigoViaje.hashCode());
		result = prime * result
				+ ((fechaLlegada == null) ? 0 : fechaLlegada.hashCode());
		result = prime * result
				+ ((fechaSalida == null) ? 0 : fechaSalida.hashCode());
		result = prime * result
				+ ((paisDestino == null) ? 0 : paisDestino.hashCode());
		result = prime * result
				+ ((paisOrigen == null) ? 0 : paisOrigen.hashCode());
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
		ViajeCabeceraImpl other = (ViajeCabeceraImpl) obj;
		if (ciudadDestino == null) {
			if (other.ciudadDestino != null)
				return false;
		} else if (!ciudadDestino.equals(other.ciudadDestino))
			return false;
		if (ciudadOrigen == null) {
			if (other.ciudadOrigen != null)
				return false;
		} else if (!ciudadOrigen.equals(other.ciudadOrigen))
			return false;
		if (codigoViaje == null) {
			if (other.codigoViaje != null)
				return false;
		} else if (!codigoViaje.equals(other.codigoViaje))
			return false;
		if (fechaLlegada == null) {
			if (other.fechaLlegada != null)
				return false;
		} else if (!fechaLlegada.equals(other.fechaLlegada))
			return false;
		if (fechaSalida == null) {
			if (other.fechaSalida != null)
				return false;
		} else if (!fechaSalida.equals(other.fechaSalida))
			return false;
		if (paisDestino == null) {
			if (other.paisDestino != null)
				return false;
		} else if (!paisDestino.equals(other.paisDestino))
			return false;
		if (paisOrigen == null) {
			if (other.paisOrigen != null)
				return false;
		} else if (!paisOrigen.equals(other.paisOrigen))
			return false;
		return true;
	}

	@Override
	public String toString() {

		String res = "Viaje Cabecera: \n";
		
		res += "Codigo Viaje: " + getCodigoViaje() + "\n";
		res += "Ciudad de origen: " + getCiudadOrigen() + "\n";
		res += "Pais de origen: " + getPaisOrigen() + "\n";
		res += "Ciudad de destino: " + getCiudadDestino() + "\n";
		res += "Pais de destino: " + getPaisDestino() + "\n";
		res += "Fecha de Salida: " + getFechaSalida() + "\n";
		res += "Fecha de Llegada: " + getFechaLlegada() + "\n";
	
		return res; 
	}

	public ViajeCabecera clone() throws CloneNotSupportedException {
		
		ViajeCabecera vC = new ViajeCabeceraImpl();
		
		vC.setCodigoViaje(getCodigoViaje());
		vC.setCiudadOrigen(getCiudadOrigen());
		vC.setPaisOrigen(getPaisOrigen());
		vC.setCiudadDestino(getCiudadDestino());
		vC.setPaisDestino(getPaisDestino());
		vC.setFechaSalida(getFechaSalida());
		vC.setFechaLlegada(getFechaLlegada());
		
		return vC;
	}

}
