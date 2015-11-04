package org.proyectofinal.model.impl;

import java.sql.Timestamp;

import org.proyectofinal.model.interfaces.Usuario;

public class UsuarioImpl implements Usuario {
	
	private String nombreUsuario = null;
	private String password = null;
	private Integer tipoUsuario = null;
	private Timestamp fechaInicio = null;
	
	public UsuarioImpl(){
		
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(Integer tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Timestamp getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

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

	@Override
	public String toString() {
		
		String res = "Usuario: \n";
		
		res += "Nombre de Usuario: " + getNombreUsuario() + "\n";
		res += "Password: " + getPassword() + "\n";
		res += "Tipo de Usuario: " + getTipoUsuario() + "\n";
		res += "Fecha de Inicio: " + getFechaInicio() + "\n";
		
		return res; 
	}

	public Usuario clone() throws CloneNotSupportedException {
		
		Usuario u = new UsuarioImpl();
		
		u.setNombreUsuario(getNombreUsuario());
		u.setPassword(getPassword());
		u.setTipoUsuario(getTipoUsuario());
		u.setFechaInicio(getFechaInicio());
		
		return u;
	}
	
}
