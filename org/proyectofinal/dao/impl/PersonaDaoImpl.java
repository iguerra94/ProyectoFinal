package org.proyectofinal.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.dao.abstracts.AbstractDao;
import org.proyectofinal.dao.interfaces.PersonaDao;
import org.proyectofinal.model.interfaces.Persona;
import org.proyectofinal.model.interfaces.Usuario;

public class PersonaDaoImpl extends AbstractDao implements PersonaDao {
	
	public ResultSet consultar() throws SQLException, ClassNotFoundException {
		
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("select * from persona");
		
		ResultSet resultado = sentencia.executeQuery();

		desconectar();
		
		return resultado;
	}
	
	public ResultSet consultarPorDni(Persona p) throws SQLException, ClassNotFoundException {
		
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("select * from persona where dni = ?");
		
		sentencia.setString(1, p.getDni());
		
		ResultSet resultado = sentencia.executeQuery();

		desconectar();
		
		return resultado;
	}
	
	public ResultSet consultarPorUsuario(Usuario u) throws SQLException, ClassNotFoundException {
		
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("select p.dni, p.nombre, p.apellido, p.email, p.telefono, p.fechaNacimiento, p.pais, p.ciudad, u.usuario, u.contrasenia, u.tipoUsuario, u.fechaInicio from Usuario u inner join Persona p on u.usuario = p.usuario where u.usuario = ?");
		
		sentencia.setString(1, u.getNombreUsuario());

		ResultSet resultado = sentencia.executeQuery();
	
		return resultado;
	}

	public ResultSet consultarPorUsuario(String user) throws SQLException, ClassNotFoundException {

		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("select p.dni, p.nombre, p.apellido, p.email, p.telefono, p.fechaNacimiento, p.pais, p.ciudad, u.usuario, u.contrasenia, u.tipoUsuario, u.fechaInicio from Usuario u inner join Persona p on u.usuario = p.usuario where u.usuario = ?");

		sentencia.setString(1, user);
		
		ResultSet resultado = sentencia.executeQuery();

		desconectar();
		
		return resultado;
	}
	
	public void alta(Persona p) throws SQLException, ClassNotFoundException{
		
		this.conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("insert into Persona (dni, nombre, apellido, email, telefono, fechaNacimiento, pais, ciudad, usuario) VALUES (?,?,?,?,?,?,?,?,?)");
		
		sentencia.setString(1, p.getDni());
		sentencia.setString(2, p.getNombre());
		sentencia.setString(3, p.getApellido());
		sentencia.setString(4, p.getEmail());
		sentencia.setString(5, p.getTelefono());
		sentencia.setDate(6, p.getFechaNacimiento());
		sentencia.setString(7, p.getPais());
		sentencia.setString(8, p.getCiudad());
		sentencia.setString(9, p.getUsuario().getNombreUsuario());
		
		sentencia.executeUpdate();
		
		this.desconectar();
	}

	public void baja(Persona p) throws SQLException, ClassNotFoundException{
		
		this.conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("delete from persona where dni = ?");

		sentencia.setString(1, p.getDni());
		
		sentencia.executeUpdate();
		
		this.desconectar();
	}

	public void modificacion(String atr, String valor, String dni) throws SQLException, ClassNotFoundException{	

		this.conectar();			
		
		PreparedStatement sentencia = null;
		
		if (atr.equals("dni")) {
			sentencia = getConexion().prepareStatement("update Persona set dni = ? where dni = ?");
		} else if (atr.equals("nombre")) { 
			sentencia = getConexion().prepareStatement("update Persona set nombre = ? where dni = ?");
		} else if (atr.equals("apellido")) {
			sentencia = getConexion().prepareStatement("update Persona set apellido = ? where dni = ?");
		} else if (atr.equals("email")) {
			sentencia = getConexion().prepareStatement("update Persona set email = ? where dni = ?");
		} else if (atr.equals("telefono")) {
			sentencia = getConexion().prepareStatement("update Persona set telefono = ? where dni = ?");
		} else if (atr.equals("fechaNacimiento")) {
			sentencia = getConexion().prepareStatement("update Persona set fechaNacimiento = ? where dni = ?");
		} else if (atr.equals("pais")) {
			sentencia = getConexion().prepareStatement("update Persona set pais = ? where dni = ?");
		} else if (atr.equals("ciudad")) {
			sentencia = getConexion().prepareStatement("update Persona set ciudad = ? where dni = ?");
		} else if (atr.equals("usuario")) {
			sentencia = getConexion().prepareStatement("update Persona set usuario = ? where dni = ?");
		}

		sentencia.setString(1, valor);
		sentencia.setString(2, dni);
		
		sentencia.executeUpdate();

		this.desconectar();
	}

}