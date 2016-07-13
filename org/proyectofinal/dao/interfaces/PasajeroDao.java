package org.proyectofinal.dao.interfaces;
	
import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.model.interfaces.Pasajero;

/**
 * Interfaz del DAO Pasajero.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public interface PasajeroDao {
	
	public void conectar() throws ClassNotFoundException, SQLException;
	public void desconectar() throws SQLException;
	public ResultSet consultar() throws SQLException, ClassNotFoundException;
	public ResultSet consultarPorDni(Pasajero p) throws SQLException, ClassNotFoundException;
	public ResultSet consultarPorDni(String dniPasajero) throws SQLException, ClassNotFoundException;
	public ResultSet consultarPersonaPorDni(Pasajero p) throws SQLException, ClassNotFoundException;
	public void altaPersonaGenerica(Pasajero p) throws SQLException;
	public void altaPasajero(Pasajero p) throws SQLException;
}