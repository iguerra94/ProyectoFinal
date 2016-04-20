package org.proyectofinal.model.impl;

import java.sql.Date;

import org.proyectofinal.model.interfaces.Persona;
import org.proyectofinal.model.interfaces.Usuario;

// TODO: Auto-generated Javadoc
/**
 * Clase de implementacion de la entidad Persona.
 */
public class PersonaImpl implements Persona {
	
	/** Dni de la persona. */
	private String dni = null;
	
	/** Nombre de la persona. */
	private String nombre = null;
	
	/** Apellido de la persona. */
	private String apellido = null;
	
	/** Email de la persona. */
	private String email = null;
	
	/** Fecha de nacimiento de la persona. */
	private Date fechaNacimiento = null;
	
	/** Telefono de la persona. */
	private String telefono = null;
	
	/** Pais de residencia de la persona. */
	private String pais = null;
	
	/** Ciudad de residencia de la persona. */
	private String ciudad = null;
	
	/** Usuario relacionado con la persona */
	private Usuario usuario = null;
	
	/**
	 * Constructor de la clase.
	 */
	public PersonaImpl(){
		
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.Persona#getDni()
	 */
	public String getDni() {
		return dni;
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
		return nombre;
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
		return apellido;
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
		return email;
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
		return fechaNacimiento;
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
		return telefono;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.Persona#setTelefono(java.lang.String)
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.Persona#getPais()
	 */
	public String getPais() {
		return pais;
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
		return ciudad;
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
		return usuario;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.Persona#setUsuario(org.proyectofinal.model.interfaces.Usuario)
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((ciudad == null) ? 0 : ciudad.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		result = prime * result
				+ ((telefono == null) ? 0 : telefono.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		PersonaImpl other = (PersonaImpl) obj;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		String res = "Persona: \n";
		
		res += "DNI: " + getDni() + "\n";
		res += "Nombre: " + getNombre() + "\n";
		res += "Apellido: " + getApellido() + "\n";
		res += "Email: " + getEmail() + "\n";
		res += "Fecha de Nacimiento: " + getFechaNacimiento() + "\n";
		res += "Telefono: " + getTelefono() + "\n"; 
		res += "Pais: " + getPais() + "\n";
		res += "Ciudad: " + getCiudad() + "\n";
		res += getUsuario().toString();
		
		return res; 
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Persona clone() throws CloneNotSupportedException {
		
		Persona p = new PersonaImpl();
		
		p.setDni(getDni());
		p.setNombre(getNombre());
		p.setApellido(getApellido());
		p.setEmail(getEmail());
		p.setFechaNacimiento(getFechaNacimiento());
		p.setTelefono(getTelefono());
		p.setPais(getPais());
		p.setCiudad(getCiudad());
		p.setUsuario(getUsuario());
		
		return p;
	}
	
}