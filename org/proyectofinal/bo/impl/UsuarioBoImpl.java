package org.proyectofinal.bo.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.proyectofinal.bo.interfaces.UsuarioBo;
import org.proyectofinal.dao.ex.UserAlreadyExistsException;
import org.proyectofinal.dao.ex.UserNotCorrectException;
import org.proyectofinal.dao.ex.UserNotExistsException;
import org.proyectofinal.dao.ex.UserNotValidException;
import org.proyectofinal.dao.impl.UsuarioDaoImpl;
import org.proyectofinal.dao.interfaces.UsuarioDao;
import org.proyectofinal.model.interfaces.Usuario;

public class UsuarioBoImpl implements UsuarioBo {
	
	public UsuarioBoImpl(){
		
	}
	
	public void verificar(Usuario u) throws UserNotValidException{
		
		if (u.getNombreUsuario().length() == 0 || u.getNombreUsuario() == null ||
			u.getPassword().length() == 0 || u.getPassword() == null || 
			u.getTipoUsuario() == -1 || u.getTipoUsuario() == null) {
			
			throw new UserNotValidException();
		}
	}
	
	public void verificarUsuario(String usuario) throws UserNotValidException{
		
		if (usuario == null || usuario.length() == 0){			
			throw new UserNotValidException();
		}
	}
	
	public void verificarDatosCorrectos(Usuario u) throws UserNotCorrectException{
		
		UsuarioDao uDao = new UsuarioDaoImpl();
		
		try {
			ResultSet res = uDao.consultarPorUsuario(u);
			
			if (!res.next()){
				throw new UserNotCorrectException();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void retornarUsuarioYPersona() {
		
	}
	
	public void registrarUsuario(Usuario u) throws ClassNotFoundException, SQLException, UserAlreadyExistsException {
		
		UsuarioDao uDao = new UsuarioDaoImpl();
	
		uDao.alta(u);		
	}

	public String recuperarPass(String usuario) throws ClassNotFoundException, SQLException, UserNotExistsException {

		String pass = "";

		UsuarioDao uDao = new UsuarioDaoImpl();
		
		ResultSet res = uDao.consultarPorUsuario(usuario);
		
		if (res.next()){
			pass = res.getString("contrasenia");
		}else{
			throw new UserNotExistsException();
		}
			
		return pass;
	}
	
}
