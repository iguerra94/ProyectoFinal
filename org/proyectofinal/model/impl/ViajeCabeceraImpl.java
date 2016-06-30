package org.proyectofinal.model.impl;

import java.sql.Date;
import java.sql.Time;

import org.proyectofinal.model.interfaces.ViajeCabecera;

public class ViajeCabeceraImpl implements ViajeCabecera {

	private String codigoViaje = null;
	private String ciudadOrigen = null;
	private String paisOrigen = null;
	private String shortPaisOrigen = null;
	private String plataformaOrigen = null;
	private String ciudadDestino = null;
	private String paisDestino = null;
	private String shortPaisDestino = null;
	private String plataformaDestino = null;
	private Date fechaSalida = null;
	private Time horaSalida = null;
	private Date fechaLlegada = null;
	private Time horaLlegada = null;
	private Integer distancia = null;
	private Time duracion = null;
	private Float precioClaseTur = null;
	private Float precioClasePrim = null;
	private Float oferta = null;
	private String imagen1 = null;
	private String imagen2 = null;
	private Integer cupo = null;
	
	public ViajeCabeceraImpl(){
		
	}
	
	public String getCodigoViaje() {
		return codigoViaje;
	}

	public void setCodigoViaje(String codigoViaje) {
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

	public String getShortPaisOrigen() {
		return shortPaisOrigen;
	}

	public void setShortPaisOrigen(String shortPaisOrigen) {
		this.shortPaisOrigen = shortPaisOrigen;
	}

	public String getPlataformaOrigen() {
		return plataformaOrigen;
	}

	public void setPlataformaOrigen(String plataformaOrigen) {
		this.plataformaOrigen = plataformaOrigen;
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

	public String getShortPaisDestino() {
		return shortPaisDestino;
	}

	public void setShortPaisDestino(String shortPaisDestino) {
		this.shortPaisDestino = shortPaisDestino;
	}

	public String getPlataformaDestino() {
		return plataformaDestino;
	}

	public void setPlataformaDestino(String plataformaDestino) {
		this.plataformaDestino = plataformaDestino;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Time getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(Time horaSalida) {
		this.horaSalida = horaSalida;
	}

	public Date getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public Time getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(Time horaLlegada) {
		this.horaLlegada = horaLlegada;
	}
	
	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

	public Time getDuracion() {
		return duracion;
	}

	public void setDuracion(Time duracion) {
		this.duracion = duracion;
	}

	public Float getPrecioClaseTur() {
		return precioClaseTur;
	}

	public void setPrecioClaseTur(Float precioClaseTur) {
		this.precioClaseTur = precioClaseTur;
	}

	public Float getPrecioClasePrim() {
		return precioClasePrim;
	}

	public void setPrecioClasePrim(Float precioClasePrim) {
		this.precioClasePrim = precioClasePrim;
	}
	
	public Float getOferta() {
		return oferta;
	}

	public void setOferta(Float oferta) {
		this.oferta = oferta;
	}
	
	public String getImagen1() {
		return imagen1;
	}

	public void setImagen1(String imagen1) {
		this.imagen1 = imagen1;
	}

	public String getImagen2() {
		return imagen2;
	}

	public void setImagen2(String imagen2) {
		this.imagen2 = imagen2;
	}

	public Integer getCupo() {
		return cupo;
	}

	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}

	@Override
	public String toString() {

		String res = "Viaje Cabecera: \n";
		
		res += "Codigo Viaje: " + getCodigoViaje() + "\n";
		res += "Ciudad de origen: " + getCiudadOrigen() + "\n";
		res += "Pais de origen: " + getPaisOrigen() + " (" + getShortPaisOrigen() + ")" + "\n";
		res += "Plataforma de origen: " + getPlataformaOrigen() + "\n";
		res += "Ciudad de destino: " + getCiudadDestino() + "\n";
		res += "Pais de destino: " + getPaisDestino() + "(" + getShortPaisDestino() + ")" + "\n";
		res += "Plataforma de destino: " + getPlataformaDestino() + "\n";
		res += "Distancia: " + getDistancia() + "\n";
		res += "Fecha de Salida: " + getFechaSalida() + "\n";
		res += "Hora de Salida: " + getHoraSalida() + "\n";
		res += "Fecha de Llegada: " + getFechaLlegada() + "\n";
		res += "Hora de Llegada: " + getHoraLlegada() + "\n";
		res += "Cupo: " + getCupo() + "\n";

		return res; 
	}

	public ViajeCabecera clone() throws CloneNotSupportedException {
		
		ViajeCabecera vC = new ViajeCabeceraImpl();
		
		vC.setCodigoViaje(getCodigoViaje());
		vC.setCiudadOrigen(getCiudadOrigen());
		vC.setPaisOrigen(getPaisOrigen());
		vC.setShortPaisOrigen(getShortPaisOrigen());
		vC.setPlataformaOrigen(getPlataformaOrigen());
		vC.setCiudadDestino(getCiudadDestino());
		vC.setPaisDestino(getPaisDestino());
		vC.setShortPaisDestino(getShortPaisDestino());
		vC.setPlataformaDestino(getPlataformaDestino());
		vC.setDistancia(getDistancia());
		vC.setFechaSalida(getFechaSalida());
		vC.setHoraSalida(getHoraSalida());
		vC.setFechaLlegada(getFechaLlegada());
		vC.setHoraLlegada(getHoraLlegada());
		vC.setDuracion(getDuracion());
		vC.setPrecioClaseTur(getPrecioClaseTur());
		vC.setPrecioClasePrim(getPrecioClasePrim());
		vC.setOferta(getOferta());
		vC.setImagen1(getImagen1());
		vC.setImagen2(getImagen2());
		vC.setCupo(getCupo());
		
		return vC;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ciudadDestino == null) ? 0 : ciudadDestino.hashCode());
		result = prime * result + ((ciudadOrigen == null) ? 0 : ciudadOrigen.hashCode());
		result = prime * result + ((codigoViaje == null) ? 0 : codigoViaje.hashCode());
		result = prime * result + ((cupo == null) ? 0 : cupo.hashCode());
		result = prime * result + ((distancia == null) ? 0 : distancia.hashCode());
		result = prime * result + ((duracion == null) ? 0 : duracion.hashCode());
		result = prime * result + ((fechaLlegada == null) ? 0 : fechaLlegada.hashCode());
		result = prime * result + ((fechaSalida == null) ? 0 : fechaSalida.hashCode());
		result = prime * result + ((horaLlegada == null) ? 0 : horaLlegada.hashCode());
		result = prime * result + ((horaSalida == null) ? 0 : horaSalida.hashCode());
		result = prime * result + ((imagen1 == null) ? 0 : imagen1.hashCode());
		result = prime * result + ((imagen2 == null) ? 0 : imagen2.hashCode());
		result = prime * result + ((oferta == null) ? 0 : oferta.hashCode());
		result = prime * result + ((paisDestino == null) ? 0 : paisDestino.hashCode());
		result = prime * result + ((paisOrigen == null) ? 0 : paisOrigen.hashCode());
		result = prime * result + ((plataformaDestino == null) ? 0 : plataformaDestino.hashCode());
		result = prime * result + ((plataformaOrigen == null) ? 0 : plataformaOrigen.hashCode());
		result = prime * result + ((precioClasePrim == null) ? 0 : precioClasePrim.hashCode());
		result = prime * result + ((precioClaseTur == null) ? 0 : precioClaseTur.hashCode());
		result = prime * result + ((shortPaisDestino == null) ? 0 : shortPaisDestino.hashCode());
		result = prime * result + ((shortPaisOrigen == null) ? 0 : shortPaisOrigen.hashCode());
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
		if (cupo == null) {
			if (other.cupo != null)
				return false;
		} else if (!cupo.equals(other.cupo))
			return false;
		if (distancia == null) {
			if (other.distancia != null)
				return false;
		} else if (!distancia.equals(other.distancia))
			return false;
		if (duracion == null) {
			if (other.duracion != null)
				return false;
		} else if (!duracion.equals(other.duracion))
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
		if (horaLlegada == null) {
			if (other.horaLlegada != null)
				return false;
		} else if (!horaLlegada.equals(other.horaLlegada))
			return false;
		if (horaSalida == null) {
			if (other.horaSalida != null)
				return false;
		} else if (!horaSalida.equals(other.horaSalida))
			return false;
		if (imagen1 == null) {
			if (other.imagen1 != null)
				return false;
		} else if (!imagen1.equals(other.imagen1))
			return false;
		if (imagen2 == null) {
			if (other.imagen2 != null)
				return false;
		} else if (!imagen2.equals(other.imagen2))
			return false;
		if (oferta == null) {
			if (other.oferta != null)
				return false;
		} else if (!oferta.equals(other.oferta))
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
		if (plataformaDestino == null) {
			if (other.plataformaDestino != null)
				return false;
		} else if (!plataformaDestino.equals(other.plataformaDestino))
			return false;
		if (plataformaOrigen == null) {
			if (other.plataformaOrigen != null)
				return false;
		} else if (!plataformaOrigen.equals(other.plataformaOrigen))
			return false;
		if (precioClasePrim == null) {
			if (other.precioClasePrim != null)
				return false;
		} else if (!precioClasePrim.equals(other.precioClasePrim))
			return false;
		if (precioClaseTur == null) {
			if (other.precioClaseTur != null)
				return false;
		} else if (!precioClaseTur.equals(other.precioClaseTur))
			return false;
		if (shortPaisDestino == null) {
			if (other.shortPaisDestino != null)
				return false;
		} else if (!shortPaisDestino.equals(other.shortPaisDestino))
			return false;
		if (shortPaisOrigen == null) {
			if (other.shortPaisOrigen != null)
				return false;
		} else if (!shortPaisOrigen.equals(other.shortPaisOrigen))
			return false;
		return true;
	}
	
}