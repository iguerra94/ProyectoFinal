package org.proyectofinal.model.interfaces;

import java.sql.Date;

public interface Persona extends Cloneable {

	public String getDni();
	public void setDni(String dni);

	public String getNombre();
	public void setNombre(String nombre);

	public String getApellido();
	public void setApellido(String apellido);

	public String getEmail();
	public void setEmail(String email);

	public Date getFechaNacimiento();
	public void setFechaNacimiento(Date fechaNacimiento);
	
	public String getTelefono();
	public void setTelefono(String telefono);
	
	public String getPais();
	public void setPais(String pais);

	public String getCiudad();
	public void setCiudad(String ciudad);
	
	public Usuario getUsuario();
	public void setUsuario(Usuario usuario);
	
	@Override
	public int hashCode();
	
	@Override
	public boolean equals(Object obj);
	
	@Override
	public String toString();
	
	public Persona clone() throws CloneNotSupportedException;
}