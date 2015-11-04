package org.proyectofinal.model.interfaces;

import java.sql.Timestamp;

public interface Usuario extends Cloneable {

	public String getNombreUsuario();
	public void setNombreUsuario(String nombreUsuario);

	public String getPassword();
	public void setPassword(String password);
	
	public Integer getTipoUsuario();
	public void setTipoUsuario(Integer tipoUsuario);
	
	public Timestamp getFechaInicio();
	public void setFechaInicio(Timestamp fechaInicio);
	
	@Override
	public int hashCode();
	
	@Override
	public boolean equals(Object obj);
	
	@Override
	public String toString();
	
	public Usuario clone() throws CloneNotSupportedException;
}