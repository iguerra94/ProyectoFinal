package org.proyectofinal.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.dao.abstracts.AbstractDao;
import org.proyectofinal.dao.interfaces.ReservaViajeDao;
import org.proyectofinal.model.interfaces.ReservaViaje;

/**
 * Implementacion de la clase de persistencia de datos de la entidad de dominio <strong>ReservaViaje</strong>: <code>ReservaViajeDao</code>.
 *  
 * @author Ivan Guerra
 * @version 1.0.0 
 */

public class ReservaViajeDaoImpl extends AbstractDao implements ReservaViajeDao {

	/**
	 * Instancia un nuevo objeto de la clase de persistencia de datos <code>ReservaViajeDao</code>.
	 */
	
	public ReservaViajeDaoImpl(){
		
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
	 * @see org.proyectofinal.dao.interfaces.ReservaViajeDao#consultar()
	 */
	
	public ResultSet consultar() throws ClassNotFoundException, SQLException{
		
		PreparedStatement sentencia = getConexion().prepareStatement("SELECT * FROM ReservaViaje");
		
		ResultSet resultado = sentencia.executeQuery();
		
		return resultado;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.ReservaViajeDao#consultarPorPasajero(org.proyectofinal.model.interfaces.ReservaViaje)
	 */

	public ResultSet consultarPorPasajero(ReservaViaje rV) throws ClassNotFoundException, SQLException{
		
		PreparedStatement sentencia = getConexion().prepareStatement("SELECT * FROM ReservaViaje WHERE dni = ?");
		
		sentencia.setString(1, rV.getPasajero().getDni());
		
		ResultSet resultado = sentencia.executeQuery();
		
		return resultado;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.ReservaViajeDao#consultarPorPersonaQueReserva(java.lang.String)
	 */
	
	public ResultSet consultarPorPersonaQueReserva(String dni) throws ClassNotFoundException, SQLException{
		
		PreparedStatement sentencia = getConexion().prepareStatement("SELECT * FROM ReservaViaje WHERE dniPersona = ?");
		
		sentencia.setString(1, dni);
		
		ResultSet resultado = sentencia.executeQuery();
		
		return resultado;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.ReservaViajeDao#consultarPorViaje(org.proyectofinal.model.interfaces.ReservaViaje)
	 */
	
	public ResultSet consultarPorViaje(ReservaViaje rV) throws ClassNotFoundException, SQLException{
		
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("SELECT * FROM ReservaViaje WHERE codViaje = ?");
		
		sentencia.setString(1, rV.getViaje().getCodigoViaje());
		
		ResultSet resultado = sentencia.executeQuery();
		
		return resultado;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.ReservaViajeDao#consultarAsientosPorViaje(java.lang.String)
	 */
	
	public ResultSet consultarAsientosPorViaje(String codViaje) throws ClassNotFoundException, SQLException{
		
		PreparedStatement sentencia = getConexion().prepareStatement("select distinct asiento from ReservaViaje where codViaje = ?");
		
		sentencia.setString(1, codViaje);
		
		ResultSet resultado = sentencia.executeQuery();

		return resultado;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.ReservaViajeDao#alta(org.proyectofinal.model.interfaces.ReservaViaje)
	 */
	
	public void alta(ReservaViaje rV) throws SQLException, ClassNotFoundException{
		
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("INSERT INTO ReservaViaje (codViaje, dniPasajero, fechaReserva, dniPersona, asiento, precio) VALUES (?,?,?,?,?,?)");
		
		sentencia.setString(1, rV.getViaje().getCodigoViaje());
		sentencia.setString(2, rV.getPasajero().getDni());
		sentencia.setTimestamp(3, rV.getFechaReserva());
		sentencia.setString(4, rV.getDniPersona());
		sentencia.setInt(5, rV.getAsiento());
		sentencia.setFloat(6, rV.getPrecio());
		
		sentencia.executeUpdate();

		desconectar();
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.ReservaViajeDao#baja(org.proyectofinal.model.interfaces.ReservaViaje)
	 */
	
	public void baja(ReservaViaje rV) throws SQLException, ClassNotFoundException{
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("DELETE FROM ReservaViaje WHERE codViaje = ? AND dni = ? AND fechaReserva = ?");
		
		sentencia.setString(1, rV.getViaje().getCodigoViaje());
		sentencia.setString(2, rV.getPasajero().getDni());
		sentencia.setTimestamp(3, rV.getFechaReserva());
		
		sentencia.executeUpdate();

		desconectar();
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.ReservaViajeDao#modificacion(java.lang.String, java.lang.String)
	 */

	public void modificacion(String dniNuevo, String dniAnterior) throws SQLException, ClassNotFoundException {
		
		this.conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("update ReservaViaje set dniPersona = ? where dniPersona = ?");

		sentencia.setString(1, dniNuevo);
		sentencia.setString(2, dniAnterior);
		
		sentencia.executeUpdate();

		this.desconectar();
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.ReservaViajeDao#consultarCantidadDeReservas(java.lang.String)
	 */
	
	@Override
	public ResultSet consultarCantidadDeReservas(String dni) throws SQLException {

		PreparedStatement sentencia = getConexion().prepareStatement("select COUNT(*) cantReservas from ReservaViaje where dniPersona = ?");
		
		sentencia.setString(1, dni);
		
		ResultSet resultado = sentencia.executeQuery();

		return resultado;
	}	

}