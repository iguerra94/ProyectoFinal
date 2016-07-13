package org.proyectofinal.bo.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.bo.ex.NotEqualPasswordException;
import org.proyectofinal.bo.ex.UserNotExistsException;
import org.proyectofinal.bo.ex.UserNotValidException;
import org.proyectofinal.bo.interfaces.UsuarioBo;
import org.proyectofinal.dao.impl.UsuarioDaoImpl;
import org.proyectofinal.dao.interfaces.UsuarioDao;
import org.proyectofinal.model.impl.UsuarioImpl;
import org.proyectofinal.model.interfaces.Usuario;

/**
 * Implementacion de la Clase de Negocio de la entidad de dominio <strong>Usuario</strong>: <code>UsuarioBo</code>.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public class UsuarioBoImpl implements UsuarioBo {
	
	/**
	 * Instancia un nuevo objeto de la Clase de Negocio <code>UsuarioBo</code>.
	 */
	
	public UsuarioBoImpl(){
		
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.UsuarioBo#verificar(org.proyectofinal.model.interfaces.Usuario)
	 */
	
	public void verificar(Usuario u) throws UserNotValidException{
		
		if (u.getNombreUsuario().length() == 0 || u.getNombreUsuario() == null ||
			u.getPassword().length() == 0 || u.getPassword() == null) {
			
			throw new UserNotValidException();
		}
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.UsuarioBo#verificarUsuario(java.lang.String)
	 */
	
	public void verificarUsuario(String usuario) throws UserNotValidException{
		
		if (usuario == null || usuario.length() == 0){			
			throw new UserNotValidException();
		}
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.UsuarioBo#verificarDatosCorrectos(org.proyectofinal.model.interfaces.Usuario)
	 */
	
	public void verificarDatosCorrectos(Usuario u) throws UserNotExistsException{
		
		UsuarioDao uDao = new UsuarioDaoImpl();
		
		try {
			
			uDao.conectar();
			
			ResultSet res = uDao.consultarPorUsuario(u);
			
			if (!res.next()){
				throw new UserNotExistsException();
			}
			
			uDao.desconectar();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.UsuarioBo#controlarNuevaContrasenia(char[], char[])
	 */
	
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

	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.UsuarioBo#retornarUsuario(java.lang.String)
	 */
	
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
			
			if (!res.next()){
				throw new UserNotExistsException();
			}

			uDao.desconectar();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return u;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.UsuarioBo#retornarDniPorUsuario(java.lang.String)
	 */
	
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
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.UsuarioBo#recuperarPass(java.lang.String)
	 */
	
	public String recuperarPass(String usuario) throws UserNotExistsException {

		String pass = "";

		UsuarioDao uDao = new UsuarioDaoImpl();
		
		try {
			
			ResultSet res = uDao.consultarPorUsuario(usuario);
			
			if (res.next()){
				pass = res.getString("contrasenia");
			}else{
				throw new UserNotExistsException();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pass;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.UsuarioBo#registrarUsuario(org.proyectofinal.model.interfaces.Usuario)
	 */
	
	public void registrarUsuario(Usuario u){
		
		UsuarioDao uDao = new UsuarioDaoImpl();
	
		try {
			
			uDao.conectar();
			
			uDao.alta(u);	
			
			uDao.desconectar();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.UsuarioBo#modificarUsuario(java.lang.String, java.lang.String)
	 */
	
	@Override
	public void modificarContrasenia(String contrasenia, String usuario) {
		
		UsuarioDao uDao = new UsuarioDaoImpl();
		
		try {
			uDao.modificacionContrasenia(contrasenia, usuario);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}