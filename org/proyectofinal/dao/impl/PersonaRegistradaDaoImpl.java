package org.proyectofinal.dao.impl;

//import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.dao.abstracts.AbstractDao;
import org.proyectofinal.dao.ex.PersonAlreadyExistsException;
import org.proyectofinal.dao.interfaces.PersonaRegistradaDao;
import org.proyectofinal.model.interfaces.PersonaRegistrada;
import org.proyectofinal.model.interfaces.Usuario;

public class PersonaRegistradaDaoImpl extends AbstractDao implements PersonaRegistradaDao {
	
	public void conectar() throws ClassNotFoundException, SQLException{
		super.conectar();
	}
	
	public void desconectar() throws SQLException{
		super.desconectar();
	}
	
	public ResultSet consultar() throws SQLException, ClassNotFoundException {
		
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("select * from PersonaRegistrada inner join PersonaGenerica");
		
		ResultSet resultado = sentencia.executeQuery();

//		sentencia.close();
		
//		desconectar();
		
		return resultado;
	}
	
	public ResultSet consultarPorDni(PersonaRegistrada p) throws SQLException, ClassNotFoundException {
		
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("select * from PersonaRegistrada preg inner join PersonaGenerica pr on pr.dni = preg.dni where pr.dni = ?");
		
		sentencia.setString(1, p.getDni());
		
		ResultSet resultado = sentencia.executeQuery();

//		sentencia.close();
//		desconectar();
		
		return resultado;
	}
	
	public ResultSet consultarPersonaPorDni(PersonaRegistrada p) throws SQLException, ClassNotFoundException {
		
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("select * from PersonaGenerica where dni = ?");
		
		sentencia.setString(1, p.getDni());
		
		ResultSet resultado = sentencia.executeQuery();

//		sentencia.close();
//		desconectar();
		
		return resultado;
	}
	
	public ResultSet consultarPersonaPorDni(String dni) throws SQLException, ClassNotFoundException {
		
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("select * from PersonaGenerica where dni = ?");
		
		sentencia.setString(1, dni);
		
		ResultSet resultado = sentencia.executeQuery();

//		sentencia.close();
//		desconectar();
		
		return resultado;
	}
	
	public ResultSet consultarPorPersonaYUsuario(String dni) throws SQLException, ClassNotFoundException {
		
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("select * from PersonaRegistrada preg inner join PersonaGenerica pr on pr.dni = preg.dni inner join Usuario u on u.usuario = preg.usuario where pr.dni = ?");
		
		sentencia.setString(1, dni);
		
		ResultSet resultado = sentencia.executeQuery();

//		sentencia.close();
//		desconectar();
		
		return resultado;
	}
	
	public ResultSet consultarPorUsuario(Usuario u) throws SQLException, ClassNotFoundException {
		
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("select * from Usuario u inner join PersonaRegistrada preg on u.usuario = preg.usuario inner join PersonaGenerica pr on pr.dni = preg.dni where u.usuario = ?");
		
		sentencia.setString(1, u.getNombreUsuario());

		ResultSet resultado = sentencia.executeQuery();
	
//		sentencia.close();
		
		return resultado;
	}
	
//	public ResultSet consultarPorUsuario(String user) throws SQLException, ClassNotFoundException {
//
//		conectar();
//		
//		PreparedStatement sentencia = getConexion().prepareStatement("select * from Usuario u inner join PersonaRegistrada preg on u.usuario = preg.usuario inner join PersonaGenerica pr on pr.dni = preg.dni where u.usuario = ?");
//
//		sentencia.setString(1, user);
//		
//		ResultSet resultado = sentencia.executeQuery();
//
////		sentencia.close();
////		desconectar();
//		
//		return resultado;
//	}

	public ResultSet consultarPorUsuario(String user) throws SQLException, ClassNotFoundException {
		
		PreparedStatement sentencia = getConexion().prepareStatement("select * from PersonaRegistrada pr inner join PersonaGenerica pg on pg.dni = pr.dni where usuario = ?");

		sentencia.setString(1, user);
		
		ResultSet resultado = sentencia.executeQuery();
		
		return resultado;
	}
	
	public ResultSet consultarEmail(String dni) throws SQLException, ClassNotFoundException {
		
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("select email from PersonaRegistrada where dni = ?");
		
		sentencia.setString(1, dni);
		
		ResultSet resultado = sentencia.executeQuery();
		
//		sentencia.close();
		
		return resultado;
	}
	
	public void altaPersonaRegistrada(PersonaRegistrada p) throws SQLException, ClassNotFoundException, PersonAlreadyExistsException {
		
		this.conectar();
		
		ResultSet res1 = this.consultarPorDni(p);
		ResultSet res2 = this.consultarPersonaPorDni(p);
		
		if (!res1.next()){

			if (!res2.next()){
				
				PreparedStatement sentencia1 = getConexion().prepareStatement("insert into PersonaGenerica (dni, nombre, apellido) VALUES (?,?,?)");
				
				sentencia1.setString(1, p.getDni());
				sentencia1.setString(2, p.getNombre());
				sentencia1.setString(3, p.getApellido());
				
				sentencia1.executeUpdate();
//				sentencia1.close();
			}
			
			PreparedStatement sentencia2 = getConexion().prepareStatement("insert into PersonaRegistrada (dni, email, telefono, fechaNacimiento, pais, ciudad, usuario) VALUES (?,?,?,?,?,?,?)");
		
			sentencia2.setString(1, p.getDni());
			sentencia2.setString(2, p.getEmail());
			sentencia2.setString(3, p.getTelefono());
			sentencia2.setDate(4, p.getFechaNacimiento());
			sentencia2.setString(5, p.getPais());
			sentencia2.setString(6, p.getCiudad());
			sentencia2.setString(7, p.getUsuario().getNombreUsuario());
			
			sentencia2.executeUpdate();

//			sentencia2.close();
			
//			res1.close();
//			res2.close();
			
			this.desconectar();
		} else {
			throw new PersonAlreadyExistsException();
		}
	}

	public void bajaPersonaRegistrada(PersonaRegistrada p) throws SQLException, ClassNotFoundException{
		
		this.conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("delete from personaRegistrada where dni = ?");

		sentencia.setString(1, p.getDni());
		
		sentencia.executeUpdate();
		
//		sentencia.close();
		
		this.desconectar();
	}

	public void modificacionDni(String atr, String valor, String dni) throws SQLException, ClassNotFoundException, PersonAlreadyExistsException {	
		
		this.conectar();	
		
		ResultSet res = null;
		PreparedStatement sentencia = null;
		
		if (atr.equals("dni")) {

			res = this.consultarPersonaPorDni(valor);
			
			if (res.next()){
				throw new PersonAlreadyExistsException();
			}else{
				sentencia = getConexion().prepareStatement("update PersonaGenerica set dni = ? where dni = ?");	
			}
			
		}
		
		sentencia.setString(1, valor);
		sentencia.setString(2, dni);
		
		sentencia.executeUpdate();
		
//		res.close();
//		sentencia.close();
		
		this.desconectar();
	}
	
	public void modificacion(String atr, String valor, String dni) throws SQLException, ClassNotFoundException {	
		
		this.conectar();			
		
		PreparedStatement sentencia = null;
		
		if (atr.equals("nombre")) {
			sentencia = getConexion().prepareStatement("update PersonaGenerica set nombre = ? where dni = ?");
		} else if (atr.equals("apellido")) {
			sentencia = getConexion().prepareStatement("update PersonaGenerica set apellido = ? where dni = ?");
		} else if (atr.equals("email")) {
			sentencia = getConexion().prepareStatement("update PersonaRegistrada set email = ? where dni = ?");
		} else if (atr.equals("telefono")) {
			sentencia = getConexion().prepareStatement("update PersonaRegistrada set telefono = ? where dni = ?");
		} else if (atr.equals("fechaNacimiento")) {
			sentencia = getConexion().prepareStatement("update PersonaRegistrada set fechaNacimiento = ? where dni = ?");
		} else if (atr.equals("pais")) {
			sentencia = getConexion().prepareStatement("update PersonaRegistrada set pais = ? where dni = ?");
		} else if (atr.equals("ciudad")) {
			sentencia = getConexion().prepareStatement("update PersonaRegistrada set ciudad = ? where dni = ?");
		} else if (atr.equals("usuario")) {
			sentencia = getConexion().prepareStatement("update PersonaRegistrada set usuario = ? where dni = ?");
		}

		sentencia.setString(1, valor);
		sentencia.setString(2, dni);
		
		sentencia.executeUpdate();

//		sentencia.close();
		
		this.desconectar();
	}

}