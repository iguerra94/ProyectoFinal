package org.proyectofinal.model.impl;

import java.sql.Timestamp;

import org.proyectofinal.model.interfaces.Usuario;

/**
 * Implementacion de la clase de dominio Usuario.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public class UsuarioImpl implements Usuario {
	
	/** El nombre de usuario del Usuario. */
	private String nombreUsuario = null;
	
	/** La contraseña del Usuario. */
	private String password = null;
	
	/** El tipo de usuario del Usuario. */
	private Integer tipoUsuario = null;
	
	/** La fecha de registro del Usuario. */
	private Timestamp fechaInicio = null;
	
	/**
	 * Instancia un nuevo objeto de la clase Usuario.
	 */

	public UsuarioImpl(){
		
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.Usuario#getNombreUsuario()
	 */
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.Usuario#setNombreUsuario(java.lang.String)
	 */
	
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.Usuario#getPassword()
	 */
	
	public String getPassword() {
		return password;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.Usuario#setPassword(java.lang.String)
	 */
	
	public void setPassword(String password) {
		this.password = password;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.Usuario#getTipoUsuario()
	 */
	
	public Integer getTipoUsuario() {
		return tipoUsuario;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.Usuario#setTipoUsuario(java.lang.Integer)
	 */
	
	public void setTipoUsuario(Integer tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.Usuario#getFechaInicio()
	 */
	
	public Timestamp getFechaInicio() {
		return fechaInicio;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.model.interfaces.Usuario#setFechaInicio(java.sql.Timestamp)
	 */
	
	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fechaInicio == null) ? 0 : fechaInicio.hashCode());
		result = prime * result
				+ ((nombreUsuario == null) ? 0 : nombreUsuario.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((tipoUsuario == null) ? 0 : tipoUsuario.hashCode());
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
		UsuarioImpl other = (UsuarioImpl) obj;
		if (fechaInicio == null) {
			if (other.fechaInicio != null)
				return false;
		} else if (!fechaInicio.equals(other.fechaInicio))
			return false;
		if (nombreUsuario == null) {
			if (other.nombreUsuario != null)
				return false;
		} else if (!nombreUsuario.equals(other.nombreUsuario))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (tipoUsuario == null) {
			if (other.tipoUsuario != null)
				return false;
		} else if (!tipoUsuario.equals(other.tipoUsuario))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		
		String res = "Usuario: \n";
		
		res += "Nombre de Usuario: " + getNombreUsuario() + "\n";
		res += "Password: " + getPassword() + "\n";
		res += "Tipo de Usuario: " + getTipoUsuario() + "\n";
		res += "Fecha de Inicio: " + getFechaInicio() + "\n";
		
		return res; 
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	
	public Usuario clone() throws CloneNotSupportedException {
		
		Usuario u = new UsuarioImpl();
		
		u.setNombreUsuario(getNombreUsuario());
		u.setPassword(getPassword());
		u.setTipoUsuario(getTipoUsuario());
		u.setFechaInicio(getFechaInicio());
		
		return u;
	}
	
}