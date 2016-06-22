package org.proyectofinal.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.dao.abstracts.AbstractDao;
import org.proyectofinal.dao.ex.UserAlreadyExistsException;
import org.proyectofinal.dao.ex.UserNotExistsException;
import org.proyectofinal.dao.interfaces.UsuarioDao;
import org.proyectofinal.model.interfaces.Usuario;

public class UsuarioDaoImpl extends AbstractDao implements UsuarioDao {

	public ResultSet consultar() throws ClassNotFoundException, SQLException {
		
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("select * from Usuario");
		
		ResultSet resultado = sentencia.executeQuery();

		return resultado;
	}
	
	public ResultSet consultarPorUsuario(Usuario u) throws ClassNotFoundException, SQLException {
		
		conectar();

		PreparedStatement sentencia = getConexion().prepareStatement("select * from Usuario where usuario = ? and contrasenia = ? and tipoUsuario = ?");
		
		sentencia.setString(1, u.getNombreUsuario());
		sentencia.setString(2, u.getPassword());
		sentencia.setInt(3, u.getTipoUsuario());
		
		ResultSet resultado = sentencia.executeQuery();

		return resultado;
	}
	
	public ResultSet consultarPorUsuario(String usuario) throws UserNotExistsException {
		
		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		
		try {
			conectar();
			
			sentencia = getConexion().prepareStatement("select * from Usuario where usuario = ?");

			sentencia.setString(1, usuario);
			
			resultado = sentencia.executeQuery();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultado;
	}

	public void alta(Usuario u) throws SQLException, ClassNotFoundException, UserAlreadyExistsException{
		
		conectar();
		
		ResultSet res = this.consultarPorUsuario(u);
		
		if (!res.next()){
			PreparedStatement sentencia = getConexion().prepareStatement("insert into Usuario (usuario, contrasenia, tipoUsuario, fechaInicio) values (?,?, 1, ?)");
			
			sentencia.setString(1, u.getNombreUsuario());
			sentencia.setString(2, u.getPassword());
			sentencia.setTimestamp(3, u.getFechaInicio());
			
			sentencia.executeUpdate();

			desconectar();
		}else{
			throw new UserAlreadyExistsException();
		}
		
	
	}

	public void baja(Usuario u) throws SQLException, ClassNotFoundException {
			
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("delete from usuario where usuario = ?");

		sentencia.setString(1, u.getNombreUsuario());
		
		sentencia.executeUpdate();

		desconectar();
	}

	public void modificacionNombreUsuario(String valor, String user) throws SQLException, ClassNotFoundException, UserAlreadyExistsException{
	
		conectar();
		
		PreparedStatement sentencia = null;

		ResultSet res = null;
		
		try {
			res = consultarPorUsuario(valor);
		} catch (UserNotExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		if (res.next()){
			throw new UserAlreadyExistsException();
		}else {
			sentencia = getConexion().prepareStatement("update Usuario set usuario = ? where usuario = ?");
		}
		
		sentencia.setString(1, valor);
		sentencia.setString(2, user);
		
		sentencia.executeUpdate();
	//	sentencia.close();
	//	res.close();
		desconectar();
	}
	
	public void modificacionContrasenia(String valor, String user) throws SQLException, ClassNotFoundException {
		
		conectar();
		
		PreparedStatement sentencia = null;

		sentencia = getConexion().prepareStatement("update Usuario set contrasenia = ? where usuario = ?");
		
		sentencia.setString(1, valor);
		sentencia.setString(2, user);
		
		sentencia.executeUpdate();
		
		desconectar();
	}

}