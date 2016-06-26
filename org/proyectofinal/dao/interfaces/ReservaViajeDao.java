package org.proyectofinal.dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.model.interfaces.ReservaViaje;

public interface ReservaViajeDao {

	public void conectar() throws ClassNotFoundException, SQLException;
	public void desconectar() throws SQLException;
	public ResultSet consultar() throws ClassNotFoundException, SQLException;
	public ResultSet consultarPorPasajero(ReservaViaje rV) throws ClassNotFoundException, SQLException;
	public ResultSet consultarPorPersonaQueReserva(String dni) throws ClassNotFoundException, SQLException;
	public ResultSet consultarPorViaje(ReservaViaje rV) throws ClassNotFoundException, SQLException;
	public ResultSet consultarAsientosPorViaje(String codViaje) throws ClassNotFoundException, SQLException;		
	public void alta(ReservaViaje rV) throws SQLException, ClassNotFoundException;
	public void baja(ReservaViaje rV) throws SQLException, ClassNotFoundException;
	public void modificacion(String dniNuevo, String dniAnterior) throws SQLException, ClassNotFoundException;
}