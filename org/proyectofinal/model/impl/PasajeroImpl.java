package org.proyectofinal.model.impl;

import org.proyectofinal.model.abstracts.PersonaGenerica;
import org.proyectofinal.model.interfaces.Pasajero;
	
public class PasajeroImpl extends PersonaGenerica implements Pasajero {

	public PasajeroImpl() {
	
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	@Override
	public String toString() {

		String res = "Pasajero: \n";

		res += "DNI: " + getDni() + "\n";
		res += "Nombre: " + getNombre() + "\n";
		res += "Apellido: " + getApellido() + "\n";
		
		return res;
	}

	public Pasajero clone() throws CloneNotSupportedException {

		Pasajero p = new PasajeroImpl();

		p.setDni(getDni());
		p.setNombre(getNombre());
		p.setApellido(getApellido());

		return p;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		PasajeroImpl other = (PasajeroImpl) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
}