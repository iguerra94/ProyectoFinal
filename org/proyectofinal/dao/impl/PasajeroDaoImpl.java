package org.proyectofinal.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.dao.abstracts.AbstractDao;
import org.proyectofinal.dao.interfaces.PasajeroDao;
import org.proyectofinal.model.interfaces.Pasajero;

/**
 * Implementacion de la Clase de Persistencia de Datos de la Entidad de Dominio <strong>Pasajero</strong>: <code>PasajeroDao</code>.
 *  
 * @author Ivan Guerra
 * @version 1.0.0 
 */

public class PasajeroDaoImpl extends AbstractDao implements PasajeroDao {
	
	/**
	 * Instancia un nuevo objeto de la Clase de Persistencia de Datos <code>PasajeroDao</code>.
	 */
	
	public PasajeroDaoImpl(){
		
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
	 * @see org.proyectofinal.dao.interfaces.PasajeroDao#consultarPorDni(org.proyectofinal.model.interfaces.Pasajero)
	 */
	
	public ResultSet consultarPersonaGenericaPorDni(Pasajero p) throws SQLException, ClassNotFoundException {
		
		PreparedStatement sentencia = getConexion().prepareStatement("select * from PersonaGenerica where dni = ?");
		
		sentencia.setString(1, p.getDni());
		
		ResultSet resultado = sentencia.executeQuery();

		return resultado;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.PasajeroDao#consultarPorDni(java.lang.String)
	 */
	
	public ResultSet consultarPasajeroPorDni(String dniPasajero) throws SQLException, ClassNotFoundException {
		
		PreparedStatement sentencia = getConexion().prepareStatement("select * from Pasajero p inner join PersonaGenerica pg on pg.dni = p.dni where pg.dni = ?");
		
		sentencia.setString(1, dniPasajero);
		
		ResultSet resultado = sentencia.executeQuery();

		return resultado;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.PasajeroDao#altaPersonaGenerica(org.proyectofinal.model.interfaces.Pasajero)
	 */
	
	@Override
	public void altaPersonaGenerica(Pasajero p) throws SQLException {

		PreparedStatement sentencia1 = getConexion().prepareStatement("insert into PersonaGenerica (dni, nombre, apellido) VALUES (?,?,?)");

		sentencia1.setString(1, p.getDni());
		sentencia1.setString(2, p.getNombre());
		sentencia1.setString(3, p.getApellido());

		sentencia1.executeUpdate();		
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.PasajeroDao#altaPasajero(org.proyectofinal.model.interfaces.Pasajero)
	 */
	
	public void altaPasajero(Pasajero p) throws SQLException {
		
		PreparedStatement sentencia1 = getConexion().prepareStatement("insert into Pasajero values (?)");
		
		sentencia1.setString(1, p.getDni());

		sentencia1.executeUpdate();
	}

}