package org.proyectofinal.model.interfaces;

import java.sql.Date;
import java.sql.Time;

public interface ViajeCabecera extends Cloneable {

	public String getCodigoViaje();
	public void setCodigoViaje(String codigoViaje);

	public String getCiudadOrigen();
	public void setCiudadOrigen(String ciudadOrigen);

	public String getPaisOrigen();
	public void setPaisOrigen(String paisOrigen);

	public String getShortPaisOrigen();
	public void setShortPaisOrigen(String shortPaisOrigen);

	public String getPlataformaOrigen();
	public void setPlataformaOrigen(String plataformaOrigen);

	public String getCiudadDestino();
	public void setCiudadDestino(String ciudadDestino);

	public String getPaisDestino();
	public void setPaisDestino(String paisDestino);

	public String getShortPaisDestino();
	public void setShortPaisDestino(String shortPaisDestino);
	
	public String getPlataformaDestino();
	public void setPlataformaDestino(String plataformaDestino);

	public Float getDistancia();
	public void setDistancia(Float distancia);

	public Date getFechaSalida();
	public void setFechaSalida(Date fechaSalida);
	
	public Time getHoraSalida();
	public void setHoraSalida(Time horaSalida);

	public Date getFechaLlegada();
	public void setFechaLlegada(Date fechaLlegada);

	public Time getHoraLlegada();
	public void setHoraLlegada(Time horaLlegada);
	
	public Time getDuracion();
	public void setDuracion(Time duracion);

	public Float getPrecioClaseTur();
	public void setPrecioClaseTur(Float precioClaseTur);

	public Float getPrecioClasePrim();
	public void setPrecioClasePrim(Float precioClasePrim);
	
	public Float getOferta();
	public void setOferta(Float oferta);

	public String getImagen1();
	public void setImagen1(String imagen1);

	public String getImagen2();
	public void setImagen2(String imagen2);
	
	public Integer getCupo();
	public void setCupo(Integer cupo);

	@Override
	public String toString();

	public ViajeCabecera clone() throws CloneNotSupportedException;
	
	@Override
	public int hashCode();
	
	@Override
	public boolean equals(Object obj);

}