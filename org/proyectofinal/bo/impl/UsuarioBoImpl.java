package org.proyectofinal.bo.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.bo.interfaces.UsuarioBo;
import org.proyectofinal.dao.ex.UserNotCorrectException;
import org.proyectofinal.dao.ex.UserNotValidException;
import org.proyectofinal.model.interfaces.Usuario;

public class UsuarioBoImpl implements UsuarioBo {
	
	public UsuarioBoImpl(){
		
	}
	
	public void verificar(Usuario u) throws UserNotValidException{
		
		if (u.getNombreUsuario() == null || u.getNombreUsuario().length() == 0 || 
			u.getPassword() == null || u.getPassword().length() == 0) {
			
			throw new UserNotValidException();
		}
	}
	
	public void verificar(String usuario) throws UserNotValidException{
		
		if (usuario == null || usuario.length() == 0){			
			throw new UserNotValidException();
		}
	}
	
	public void verificarDatosCorrectos(ResultSet res, Usuario u) throws UserNotCorrectException, SQLException, UserNotValidException{
		
		if (!res.getString("usuario").equals(u.getNombreUsuario()) || !res.getString("contrasenia").equals(u.getPassword()) || !(res.getInt("tipoUsuario") == u.getTipoUsuario())) {
			throw new UserNotCorrectException();
		}
	}
	
}
