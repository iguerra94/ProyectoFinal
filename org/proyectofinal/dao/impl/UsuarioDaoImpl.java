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

	public void conectar() throws ClassNotFoundException, SQLException{
		super.conectar();
	}
	
	public void desconectar() throws SQLException{
		super.desconectar();
	}
	
	public ResultSet consultar() throws ClassNotFoundException, SQLException {
		
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("select * from Usuario");
		
		ResultSet resultado = sentencia.executeQuery();

		return resultado;
	}
	
	public ResultSet consultarPorUsuario(Usuario u) throws ClassNotFoundException, SQLException {

		PreparedStatement sentencia = getConexion().prepareStatement("select usuario, contrasenia from Usuario where usuario = ? and contrasenia = ?");
		
		sentencia.setString(1, u.getNombreUsuario());
		sentencia.setString(2, u.getPassword());
		
		ResultSet resultado = sentencia.executeQuery();

		return resultado;
	}
	
	public ResultSet consultarPorUsuario(String usuario) throws ClassNotFoundException, SQLException {
		
		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		
		try {
			conectar();
			
			sentencia = getConexion().prepareStatement("select * from Usuario where usuario = ?");

			sentencia.setString(1, usuario);
			
			resultado = sentencia.executeQuery();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
		
		res = consultarPorUsuario(valor);
		
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
	
	public void modificacionContrasenia(String contrasenia, String usuario) throws SQLException, ClassNotFoundException {
		
		conectar();
		
		PreparedStatement sentencia = null;

		sentencia = getConexion().prepareStatement("update Usuario set contrasenia = ? where usuario = ?");
		
		sentencia.setString(1, contrasenia);
		sentencia.setString(2, usuario);
		
		sentencia.executeUpdate();
		
		desconectar();
	}

	@Override
	public ResultSet consultarDniPorUsuario(String usuario) throws SQLException {
		
		PreparedStatement sentencia = getConexion().prepareStatement("SELECT dni FROM Usuario u inner join PersonaRegistrada p on u.usuario = p.usuario where u.usuario = ?");
		
		sentencia.setString(1, usuario);
		
		ResultSet resultado = sentencia.executeQuery();
		
		return resultado;		
	}

}