package org.proyectofinal.dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.model.interfaces.ViajeDetalle;

public interface ViajeDetalleDao {

	public ResultSet consultarPorPersona(ViajeDetalle vD) throws ClassNotFoundException, SQLException;
	
	public ResultSet consultarPorViaje(ViajeDetalle vD) throws ClassNotFoundException, SQLException;
	
	public void alta(ViajeDetalle vD) throws SQLException, ClassNotFoundException;
	
	public void baja(ViajeDetalle vD) throws SQLException, ClassNotFoundException;
	
	public void modificacion(ViajeDetalle vD) throws SQLException, ClassNotFoundException;
}