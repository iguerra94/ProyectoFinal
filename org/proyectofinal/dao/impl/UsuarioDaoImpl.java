package org.proyectofinal.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.dao.abstracts.AbstractDao;
import org.proyectofinal.dao.interfaces.UsuarioDao;
import org.proyectofinal.model.interfaces.Usuario;

/**
 * Implementacion de la Clase de Persistencia de Datos de la Entidad de Dominio <strong>Usuario</strong>: <code>UsuarioDao</code>.
 *  
 * @author Ivan Guerra
 * @version 1.0.0 
 */

public class UsuarioDaoImpl extends AbstractDao implements UsuarioDao {

	/**
	 * Instancia un nuevo objeto de la Clase de Persistencia de Datos <code>UsuarioDao</code>.
	 */
	
	public UsuarioDaoImpl(){
		
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.abstracts.AbstractDao#conectar()
	 */
	
	public void conectar() throws ClassNotFoundException, SQLException{
		super.conectar();
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.abstracts.AbstractDao#desconectar()
	 */
	
	public void desconectar() throws SQLException{
		super.desconectar();
	}
		
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.UsuarioDao#consultarPorUsuario(org.proyectofinal.model.interfaces.Usuario)
	 */
	
	public ResultSet consultarPorUsuario(Usuario u) throws ClassNotFoundException, SQLException {

		PreparedStatement sentencia = getConexion().prepareStatement("select usuario, contrasenia from Usuario where usuario = ? and contrasenia = ?");
		
		sentencia.setString(1, u.getNombreUsuario());
		sentencia.setString(2, u.getPassword());
		
		ResultSet resultado = sentencia.executeQuery();

		return resultado;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.UsuarioDao#consultarPorUsuario(java.lang.String)
	 */
	
	public ResultSet consultarPorUsuario(String usuario) throws ClassNotFoundException, SQLException {
		
		PreparedStatement sentencia = getConexion().prepareStatement("select * from Usuario where usuario = ?");
		
		sentencia.setString(1, usuario);

		ResultSet resultado = sentencia.executeQuery();

		return resultado;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.UsuarioDao#consultarDniPorUsuario(java.lang.String)
	 */
	
	@Override
	public ResultSet consultarDniPorUsuario(String usuario) throws SQLException {
		
		PreparedStatement sentencia = getConexion().prepareStatement("SELECT dni FROM Usuario u inner join PersonaRegistrada p on u.usuario = p.usuario where u.usuario = ?");
		
		sentencia.setString(1, usuario);
		
		ResultSet resultado = sentencia.executeQuery();
		
		return resultado;		
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.UsuarioDao#alta(org.proyectofinal.model.interfaces.Usuario)
	 */
	
	public void alta(Usuario u) throws SQLException, ClassNotFoundException{
		
		PreparedStatement sentencia = getConexion().prepareStatement("insert into Usuario (usuario, contrasenia, tipoUsuario, fechaInicio) values (?,?, 1, ?)");
		
		sentencia.setString(1, u.getNombreUsuario());
		sentencia.setString(2, u.getPassword());
		sentencia.setTimestamp(3, u.getFechaInicio());
		
		sentencia.executeUpdate();		
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.UsuarioDao#modificacionContrasenia(java.lang.String, java.lang.String)
	 */
	
	public void modificacionContrasenia(String contrasenia, String usuario) throws SQLException, ClassNotFoundException {
		
		conectar();
		
		PreparedStatement sentencia = null;

		sentencia = getConexion().prepareStatement("update Usuario set contrasenia = ? where usuario = ?");
		
		sentencia.setString(1, contrasenia);
		sentencia.setString(2, usuario);
		
		sentencia.executeUpdate();
		
		desconectar();
	}

}