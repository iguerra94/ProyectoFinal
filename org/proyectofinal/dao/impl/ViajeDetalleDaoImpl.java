package org.proyectofinal.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.dao.abstracts.AbstractDao;
import org.proyectofinal.dao.interfaces.ViajeDetalleDao;
import org.proyectofinal.model.interfaces.ViajeDetalle;

public class ViajeDetalleDaoImpl extends AbstractDao implements ViajeDetalleDao {
	
	public ResultSet consultar() throws ClassNotFoundException, SQLException{
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("SELECT * FROM ViajeDetalle");
		
		ResultSet resultado = sentencia.executeQuery();
		
		desconectar();
		
		return resultado;
	}
	
	public ResultSet consultarPorPersona(ViajeDetalle vD) throws ClassNotFoundException, SQLException{
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("SELECT * FROM ViajeDetalle WHERE dni = ?");
		
		sentencia.setString(1, vD.getPersona().getDni());
		
		ResultSet resultado = sentencia.executeQuery();
		
		desconectar();
		
		return resultado;
	}
	
	public ResultSet consultarPorViaje(ViajeDetalle vD) throws ClassNotFoundException, SQLException{
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("SELECT * FROM ViajeDetalle WHERE codViaje = ?");
		
		sentencia.setInt(1, vD.getViaje().getCodigoViaje());
		
		ResultSet resultado = sentencia.executeQuery();
		
		desconectar();
		
		return resultado;
	}
	
	public void alta(ViajeDetalle vD) throws SQLException, ClassNotFoundException{
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("INSERT INTO ViajeDetalle  (codViaje, dni, fechaReserva, asiento, precio) VALUES (?,?,?,?,?)");
		
		sentencia.setInt(1, vD.getViaje().getCodigoViaje());
		sentencia.setString(2, vD.getPersona().getDni());
		sentencia.setDate(3, vD.getFechaReserva());
		sentencia.setInt(4, vD.getAsiento());
		sentencia.setFloat(5, vD.getPrecio());
		
		sentencia.executeUpdate();
		
		desconectar();
	}
	
	public void baja(ViajeDetalle vD) throws SQLException, ClassNotFoundException{
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("DELETE FROM ViajeDetalle WHERE codViaje = ? AND dni = ? AND fechaReserva = ?");
		
		sentencia.setInt(1, vD.getViaje().getCodigoViaje());
		sentencia.setString(2, vD.getPersona().getDni());
		sentencia.setDate(3, vD.getFechaReserva());
		
		sentencia.executeUpdate();
		
		desconectar();
	}
	
	public void modificacion(ViajeDetalle vD) throws SQLException, ClassNotFoundException{
		conectar();
		desconectar();
	}	

}