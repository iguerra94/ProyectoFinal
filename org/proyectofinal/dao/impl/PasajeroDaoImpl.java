package org.proyectofinal.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.dao.abstracts.AbstractDao;
import org.proyectofinal.dao.interfaces.PasajeroDao;
import org.proyectofinal.model.interfaces.Pasajero;

/**
 * Implementacion del DAO Pasajero.
 *  
 * @author Ivan Guerra
 * @version 1.0.0 
 */

public class PasajeroDaoImpl extends AbstractDao implements PasajeroDao {
	
	public void conectar() throws ClassNotFoundException, SQLException{
		super.conectar();
	}
	
	public void desconectar() throws SQLException{
		super.desconectar();
	}
	
	public ResultSet consultar() throws SQLException, ClassNotFoundException {
		
		PreparedStatement sentencia = getConexion().prepareStatement("select p.dni, p.nombre, p.apellido from Pasajero p inner join PersonaGenerica pg on p.dni = pg.dni");
		
		ResultSet resultado = sentencia.executeQuery();
		
		return resultado;
	}
	
	public ResultSet consultarPorDni(Pasajero p) throws SQLException, ClassNotFoundException {
		
		PreparedStatement sentencia = getConexion().prepareStatement("select * from Pasajero p inner join PersonaGenerica pg on pg.dni = p.dni where pg.dni = ?");
		
		sentencia.setString(1, p.getDni());
		
		ResultSet resultado = sentencia.executeQuery();

		return resultado;
	}
	
	public ResultSet consultarPorDni(String dniPasajero) throws SQLException, ClassNotFoundException {
		
		PreparedStatement sentencia = getConexion().prepareStatement("select * from Pasajero p inner join PersonaGenerica pg on pg.dni = p.dni where pg.dni = ?");
		
		sentencia.setString(1, dniPasajero);
		
		ResultSet resultado = sentencia.executeQuery();

		return resultado;
	}
	
	public ResultSet consultarPersonaPorDni(Pasajero p) throws SQLException, ClassNotFoundException {
		
		PreparedStatement sentencia = getConexion().prepareStatement("select dni from PersonaGenerica where dni = ?");
		
		sentencia.setString(1, p.getDni());
		
		ResultSet resultado = sentencia.executeQuery();

		return resultado;
	}
	
	public void altaPasajero(Pasajero p) throws SQLException, ClassNotFoundException {
		
		conectar();
		
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
		
		desconectar();
	}

}