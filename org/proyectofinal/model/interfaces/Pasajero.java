package org.proyectofinal.model.interfaces;

public interface Pasajero extends Cloneable{
	
	public String getDni();
	public void setDni(String dni);
	public String getNombre();
	public void setNombre(String nombre);
	public String getApellido();
	public void setApellido(String apellido);
	@Override
	public String toString();
	public Pasajero clone() throws CloneNotSupportedException;
	@Override
	public int hashCode();
	@Override
	public boolean equals(Object obj);
}