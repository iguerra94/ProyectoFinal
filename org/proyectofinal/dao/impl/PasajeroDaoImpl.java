package org.proyectofinal.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.dao.abstracts.AbstractDao;
import org.proyectofinal.dao.interfaces.PasajeroDao;
import org.proyectofinal.model.interfaces.Pasajero;

public class PasajeroDaoImpl extends AbstractDao implements PasajeroDao {
	
	public ResultSet consultar() throws SQLException, ClassNotFoundException {
		
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("select p.dni, p.nombre, p.apellido from Pasajero p inner join PersonaGenerica pg on p.dni = pg.dni");
		
		ResultSet resultado = sentencia.executeQuery();

//		sentencia.close();
		
//		desconectar();
		
		return resultado;
	}
	
	public ResultSet consultarPorDni(Pasajero p) throws SQLException, ClassNotFoundException {
		
		this.conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("select * from Pasajero p inner join PersonaGenerica pg on pg.dni = p.dni where pg.dni = ?");
		
		sentencia.setString(1, p.getDni());
		
		ResultSet resultado = sentencia.executeQuery();

//		desconectar();
		
		return resultado;
	}
	
	public ResultSet consultarPersonaPorDni(Pasajero p) throws SQLException, ClassNotFoundException {
		
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("select dni from PersonaGenerica where dni = ?");
		
		sentencia.setString(1, p.getDni());
		
		ResultSet resultado = sentencia.executeQuery();

//		desconectar();
		
		return resultado;
	}
	
	public void altaPasajero(Pasajero p) throws SQLException, ClassNotFoundException {
		
		this.conectar();
		
		ResultSet res1 = this.consultarPersonaPorDni(p);
		
		if (!res1.next()){
			PreparedStatement sentencia2 = getConexion().prepareStatement("insert into PersonaGenerica (dni, nombre, apellido) VALUES (?,?,?)");

			sentencia2.setString(1, p.getDni());
			sentencia2.setString(2, p.getNombre());
			sentencia2.setString(3, p.getApellido());

			sentencia2.executeUpdate();
		}
		
		PreparedStatement sentencia1 = getConexion().prepareStatement("insert into Pasajero values (?)");
		
		sentencia1.setString(1, p.getDni());

		sentencia1.executeUpdate();
		
//		sentencia1.close();
//		this.desconectar();
	}

	public void bajaPasajero(Pasajero p) throws SQLException, ClassNotFoundException{
		
		this.conectar();
		
//		PreparedStatement sentencia = getConexion().prepareStatement("delete from Pasajero where dni = ?");
//
//		sentencia.setString(1, p.getDni());
//		
//		sentencia.executeUpdate();
		
		this.desconectar();
	}

	public void modificacion(String atr, String valor, String dni) throws SQLException, ClassNotFoundException{	

		this.conectar();			
		
//		PreparedStatement sentencia = null;
//		
//		if (atr.equals("dni")) {
//			sentencia = getConexion().prepareStatement("update PersonaGenerica set dni = ? where dni = ?");
//		}
//
//		sentencia.setString(1, valor);
//		sentencia.setString(2, dni);
//		
//		sentencia.executeUpdate();

		this.desconectar();
	}

}