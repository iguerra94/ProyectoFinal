package org.proyectofinal.model.impl;

import java.sql.Date;

import org.proyectofinal.model.abstracts.PersonaGenerica;
import org.proyectofinal.model.interfaces.PersonaRegistrada;
import org.proyectofinal.model.interfaces.Usuario;

// TODO: Auto-generated Javadoc
/**
 * Clase de implementacion de la entidad Persona Registrada.
 */
public class PersonaRegistradaImpl extends PersonaGenerica implements PersonaRegistrada {
	
	private String email = null;
	private Date fechaNacimiento = null;
	private String telefono = null;
	private String shortPais = null;
	private String pais = null;
	private String ciudad = null;
	private Usuario usuario = null;
	
	public PersonaRegistradaImpl(){
		
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.Persona#getDni()
	 */
	public String getDni() {
		return this.dni;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.Persona#setDni(java.lang.String)
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.Persona#getNombre()
	 */
	public String getNombre() {
		return this.nombre;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.Persona#setNombre(java.lang.String)
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.Persona#getApellido()
	 */
	public String getApellido() {
		return this.apellido;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.Persona#setApellido(java.lang.String)
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.Persona#getEmail()
	 */
	public String getEmail() {
		return this.email;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.Persona#setEmail(java.lang.String)
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.Persona#getFechaNacimiento()
	 */
	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.Persona#setFechaNacimiento(java.sql.Date)
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.Persona#getTelefono()
	 */
	public String getTelefono() {
		return this.telefono;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.Persona#setTelefono(java.lang.String)
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getShortPais() {
		return this.shortPais;
	}

	public void setShortPais(String shortPais) {
		this.shortPais = shortPais;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.Persona#getPais()
	 */
	public String getPais() {
		return this.pais;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.Persona#setPais(java.lang.String)
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.Persona#getCiudad()
	 */
	public String getCiudad() {
		return this.ciudad;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.Persona#setCiudad(java.lang.String)
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.Persona#getUsuario()
	 */
	public Usuario getUsuario() {
		return this.usuario;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.Persona#setUsuario(org.proyectofinal.model.interfaces.Usuario)
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		String res = "Persona Registrada: \n";
		
		res += "DNI: " + getDni() + "\n";
		res += "Nombre: " + getNombre() + "\n";
		res += "Apellido: " + getApellido() + "\n";
		res += "Email: " + getEmail() + "\n";
		res += "Fecha de Nacimiento: " + getFechaNacimiento() + "\n";
		res += "Telefono: " + getTelefono() + "\n"; 
		res += "Pais: " + getPais() + " (" + getShortPais() + ")\n";
		res += "Ciudad: " + getCiudad() + "\n";
		res += getUsuario().toString();
		
		return res; 
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public PersonaRegistrada clone() throws CloneNotSupportedException {
		
		PersonaRegistrada p = new PersonaRegistradaImpl();
		
		p.setDni(getDni());
		p.setNombre(getNombre());
		p.setApellido(getApellido());
		p.setEmail(getEmail());
		p.setFechaNacimiento(getFechaNacimiento());
		p.setTelefono(getTelefono());
		p.setShortPais(getShortPais());
		p.setPais(getPais());
		p.setCiudad(getCiudad());
		p.setUsuario(getUsuario());
		
		return p;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((ciudad == null) ? 0 : ciudad.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		result = prime * result + ((shortPais == null) ? 0 : shortPais.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		PersonaRegistradaImpl other = (PersonaRegistradaImpl) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (ciudad == null) {
			if (other.ciudad != null)
				return false;
		} else if (!ciudad.equals(other.ciudad))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fechaNacimiento == null) {
			if (other.fechaNacimiento != null)
				return false;
		} else if (!fechaNacimiento.equals(other.fechaNacimiento))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		if (shortPais == null) {
			if (other.shortPais != null)
				return false;
		} else if (!shortPais.equals(other.shortPais))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
}