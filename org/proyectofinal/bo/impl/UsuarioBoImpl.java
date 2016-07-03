package org.proyectofinal.bo.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.bo.ex.NotEqualPasswordException;
import org.proyectofinal.bo.interfaces.UsuarioBo;
import org.proyectofinal.dao.ex.UserAlreadyExistsException;
import org.proyectofinal.dao.ex.UserNotCorrectException;
import org.proyectofinal.dao.ex.UserNotExistsException;
import org.proyectofinal.dao.ex.UserNotValidException;
import org.proyectofinal.dao.impl.UsuarioDaoImpl;
import org.proyectofinal.dao.interfaces.UsuarioDao;
import org.proyectofinal.model.impl.UsuarioImpl;
import org.proyectofinal.model.interfaces.Usuario;

public class UsuarioBoImpl implements UsuarioBo {
	
	public UsuarioBoImpl(){
		
	}
	
	public void verificar(Usuario u) throws UserNotValidException{
		
		if (u.getNombreUsuario().length() == 0 || u.getNombreUsuario() == null ||
			u.getPassword().length() == 0 || u.getPassword() == null) {
			
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
			
			uDao.conectar();
			
			ResultSet res = uDao.consultarPorUsuario(u);
			
			if (!res.next()){
				throw new UserNotCorrectException();
			}
			
			uDao.desconectar();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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

	@Override
	public Usuario retornarUsuario(String usuario) throws UserNotExistsException{
		
		Usuario u = new UsuarioImpl();

		UsuarioDao uDao = new UsuarioDaoImpl();
		
		try {
			
			uDao.conectar();
			
			ResultSet res = uDao.consultarPorUsuario(usuario);
			
			while (res.next()) {
				u.setNombreUsuario(res.getString("usuario"));
				u.setPassword(res.getString("contrasenia"));
				u.setTipoUsuario(res.getInt("tipoUsuario"));
				u.setFechaInicio(res.getTimestamp("fechaInicio"));
			}

			uDao.desconectar();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return u;
	}
	
	public void controlarNuevaContrasenia(char[] nueva, char[] confirmar) throws NotEqualPasswordException {

		Boolean igual = true;
		
		if (nueva.length != confirmar.length){
			igual = false;
		}else{
			for (int i = 0; i < nueva.length && igual; i++){
				
				if (nueva[i] != confirmar[i]){
					igual = false;			
				}
			}
		}
		
		if (!igual){
			throw new NotEqualPasswordException();
		}
	}

	@Override
	public void modificarUsuario(String contrasenia, String usuario) {
		
		UsuarioDao uDao = new UsuarioDaoImpl();
		
		try {
			uDao.modificacionContrasenia(contrasenia, usuario);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String retornarDniPorUsuario(String usuario) {

		String dni = null;
		
		
		UsuarioDao uDao = new UsuarioDaoImpl();
	
		try {

			uDao.conectar();
			
			ResultSet res = uDao.consultarDniPorUsuario(usuario);
			
			while(res.next()){
				dni = res.getString("dni");
			}
			
			uDao.desconectar();
	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dni;	
	}
	
}
