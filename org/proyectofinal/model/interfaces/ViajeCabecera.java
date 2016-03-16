package org.proyectofinal.model.interfaces;

import java.sql.Date;
import java.sql.Time;

public interface ViajeCabecera extends Cloneable {
	
	public Integer getCodigoViaje();
	public void setCodigoViaje(Integer codigoViaje);

	public String getCiudadOrigen();
	public void setCiudadOrigen(String ciudadOrigen);
	
	public String getPaisOrigen();
	public void setPaisOrigen(String paisOrigen);
	
	public String getCiudadDestino();
	public void setCiudadDestino(String ciudadDestino);
	
	public String getPaisDestino();
	public void setPaisDestino(String paisDestino);
	
	public Date getFechaSalida();
	public void setFechaSalida(Date fechaSalida);

	public Time getHoraSalida();
	public void setHoraSalida(Time horaSalida);
	
	public Date getFechaLlegada();
	public void setFechaLlegada(Date fechaLlegada);

	public Time getHoraLlegada();
	public void setHoraLlegada(Time horaLlegada);

	public Integer getCupo();
	public void setCupo(Integer cupo);

	@Override
	public int hashCode();
	
	@Override
	public boolean equals(Object obj);
	
	@Override
	public String toString();
	
	public ViajeCabecera clone() throws CloneNotSupportedException;
}