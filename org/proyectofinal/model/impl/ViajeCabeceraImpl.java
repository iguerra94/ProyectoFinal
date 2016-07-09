package org.proyectofinal.model.impl;

import java.sql.Date;
import java.sql.Time;

import org.proyectofinal.model.interfaces.ViajeCabecera;

/**
 * Implementacion de la clase de dominio ViajeCabecera.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public class ViajeCabeceraImpl implements ViajeCabecera {

	/** El codigo del viaje. */
	private String codigoViaje = null;
	
	/** La ciudad de origen del viaje. */
	private String ciudadOrigen = null;
	
	/** El pais de origen del viaje. */
	private String paisOrigen = null;
	
	/** El pais de origen del viaje en formato ISO 3166-1 alfa-3. */
	private String shortPaisOrigen = null;
	
	/** La plataforma de origen del viaje. */
	private String plataformaOrigen = null;
	
	/** La ciudad de destino del viaje. */
	private String ciudadDestino = null;
	
	/** El pais de destino del viaje. */
	private String paisDestino = null;
	
	/** El pais de destino del viaje en formato ISO 3166-1 alfa-3 */
	private String shortPaisDestino = null;
	
	/** La plataforma de destino del viaje. */
	private String plataformaDestino = null;
	
	/** La fecha de salida del viaje. */
	private Date fechaSalida = null;
	
	/** La hora de salida del viaje. */
	private Time horaSalida = null;
	
	/** La fecha de llegada del viaje. */
	private Date fechaLlegada = null;
	
	/** La hora de llegada del viaje. */
	private Time horaLlegada = null;
	
	/** La distancia entre la ciudad de origen y destino del viaje. */
	private Integer distancia = null;
	
	/** La duracion del viaje. */
	private Time duracion = null;
	
	/** El precio de la clase turista del viaje. */
	private Float precioClaseTur = null;
	
	/** El precio de la primera clase del viaje. */
	private Float precioClasePrim = null;
	
	/** La oferta de descuento que dispone el viaje (entre 0.0 y 0.75). */
	private String oferta = null;
	
	/** La ruta de la imagen del destino de la oferta del viaje. */
	private String imagenOferta = null;
	
	/** La ruta de la primera imagen descriptiva del destino del viaje. */
	private String imagen1 = null;
	
	/** La ruta de la segunda imagen descriptiva del destino del viaje. */
	private String imagen2 = null;
	
	/** El cupo de pasajeros del viaje. */
	private Integer cupo = null;
	
	/**
	 * Instancia un nuevo objeto de la clase ViajeCabecera.
	 */
	
	public ViajeCabeceraImpl(){
		
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#getCodigoViaje()
	 */
	
	public String getCodigoViaje() {
		return codigoViaje;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#setCodigoViaje(java.lang.String)
	 */
	
	public void setCodigoViaje(String codigoViaje) {
		this.codigoViaje = codigoViaje;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#getCiudadOrigen()
	 */
	
	public String getCiudadOrigen() {
		return ciudadOrigen;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#setCiudadOrigen(java.lang.String)
	 */
	
	public void setCiudadOrigen(String ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#getPaisOrigen()
	 */
	
	public String getPaisOrigen() {
		return paisOrigen;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#setPaisOrigen(java.lang.String)
	 */
	
	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#getShortPaisOrigen()
	 */
	
	public String getShortPaisOrigen() {
		return shortPaisOrigen;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#setShortPaisOrigen(java.lang.String)
	 */
	
	public void setShortPaisOrigen(String shortPaisOrigen) {
		this.shortPaisOrigen = shortPaisOrigen;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#getPlataformaOrigen()
	 */
	
	public String getPlataformaOrigen() {
		return plataformaOrigen;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#setPlataformaOrigen(java.lang.String)
	 */
	
	public void setPlataformaOrigen(String plataformaOrigen) {
		this.plataformaOrigen = plataformaOrigen;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#getCiudadDestino()
	 */
	
	public String getCiudadDestino() {
		return ciudadDestino;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#setCiudadDestino(java.lang.String)
	 */
	
	public void setCiudadDestino(String ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#getPaisDestino()
	 */
	
	public String getPaisDestino() {
		return paisDestino;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#setPaisDestino(java.lang.String)
	 */
	
	public void setPaisDestino(String paisDestino) {
		this.paisDestino = paisDestino;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#getShortPaisDestino()
	 */
	
	public String getShortPaisDestino() {
		return shortPaisDestino;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#setShortPaisDestino(java.lang.String)
	 */
	
	public void setShortPaisDestino(String shortPaisDestino) {
		this.shortPaisDestino = shortPaisDestino;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#getPlataformaDestino()
	 */
	
	public String getPlataformaDestino() {
		return plataformaDestino;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#setPlataformaDestino(java.lang.String)
	 */
	
	public void setPlataformaDestino(String plataformaDestino) {
		this.plataformaDestino = plataformaDestino;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#getFechaSalida()
	 */
	
	public Date getFechaSalida() {
		return fechaSalida;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#setFechaSalida(java.sql.Date)
	 */
	
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#getHoraSalida()
	 */
	
	public Time getHoraSalida() {
		return horaSalida;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#setHoraSalida(java.sql.Time)
	 */
	
	public void setHoraSalida(Time horaSalida) {
		this.horaSalida = horaSalida;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#getFechaLlegada()
	 */
	
	public Date getFechaLlegada() {
		return fechaLlegada;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#setFechaLlegada(java.sql.Date)
	 */
	
	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#getHoraLlegada()
	 */
	
	public Time getHoraLlegada() {
		return horaLlegada;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#setHoraLlegada(java.sql.Time)
	 */
	
	public void setHoraLlegada(Time horaLlegada) {
		this.horaLlegada = horaLlegada;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#getDistancia()
	 */
	
	public Integer getDistancia() {
		return distancia;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#setDistancia(java.lang.Integer)
	 */
	
	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#getDuracion()
	 */
	
	public Time getDuracion() {
		return duracion;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#setDuracion(java.sql.Time)
	 */
	
	public void setDuracion(Time duracion) {
		this.duracion = duracion;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#getPrecioClaseTur()
	 */
	
	public Float getPrecioClaseTur() {
		return precioClaseTur;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#setPrecioClaseTur(java.lang.Float)
	 */
	
	public void setPrecioClaseTur(Float precioClaseTur) {
		this.precioClaseTur = precioClaseTur;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#getPrecioClasePrim()
	 */
	
	public Float getPrecioClasePrim() {
		return precioClasePrim;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#setPrecioClasePrim(java.lang.Float)
	 */
	
	public void setPrecioClasePrim(Float precioClasePrim) {
		this.precioClasePrim = precioClasePrim;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#getOferta()
	 */
	
	public String getOferta() {
		return oferta;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#setOferta(java.lang.String)
	 */
	
	public void setOferta(String oferta) {
		this.oferta = oferta;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#getImagenOferta()
	 */
	
	public String getImagenOferta() {
		return imagenOferta;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#setImagenOferta(java.lang.String)
	 */
	
	public void setImagenOferta(String imagenOferta) {
		this.imagenOferta = imagenOferta;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#getImagen1()
	 */
	
	public String getImagen1() {
		return imagen1;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#setImagen1(java.lang.String)
	 */
	
	public void setImagen1(String imagen1) {
		this.imagen1 = imagen1;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#getImagen2()
	 */
	
	public String getImagen2() {
		return imagen2;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#setImagen2(java.lang.String)
	 */
	
	public void setImagen2(String imagen2) {
		this.imagen2 = imagen2;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#getCupo()
	 */
	
	public Integer getCupo() {
		return cupo;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.ViajeCabecera#setCupo(java.lang.Integer)
	 */
	
	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {

		String res = "Viaje Cabecera: \n";
		
		res += "Codigo Viaje: " + getCodigoViaje() + "\n";
		res += "Ciudad de origen: " + getCiudadOrigen() + "\n";
		res += "Pais de origen: " + getPaisOrigen() + " (" + getShortPaisOrigen() + ")" + "\n";
		res += "Plataforma de origen: " + getPlataformaOrigen() + "\n";
		res += "Ciudad de destino: " + getCiudadDestino() + "\n";
		res += "Pais de destino: " + getPaisDestino() + " (" + getShortPaisDestino() + ")" + "\n";
		res += "Plataforma de destino: " + getPlataformaDestino() + "\n";
		res += "Distancia: " + getDistancia() + "\n";
		res += "Fecha de Salida: " + getFechaSalida() + "\n";
		res += "Hora de Salida: " + getHoraSalida() + "\n";
		res += "Fecha de Llegada: " + getFechaLlegada() + "\n";
		res += "Hora de Llegada: " + getHoraLlegada() + "\n";
		res += "Cupo: " + getCupo() + "\n";

		return res; 
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	
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
		vC.setImagenOferta(getImagenOferta());
		vC.setImagen1(getImagen1());
		vC.setImagen2(getImagen2());
		vC.setCupo(getCupo());
		
		return vC;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	
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
		result = prime * result + ((imagenOferta == null) ? 0 : imagenOferta.hashCode());
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
		if (imagenOferta == null) {
			if (other.imagenOferta != null)
				return false;
		} else if (!imagenOferta.equals(other.imagenOferta))
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