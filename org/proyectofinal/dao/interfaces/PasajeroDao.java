package org.proyectofinal.dao.interfaces;
	
import java.sql.ResultSet;
import java.sql.SQLException;
import org.proyectofinal.model.interfaces.Pasajero;

public interface PasajeroDao {
	
	public void conectar() throws ClassNotFoundException, SQLException;
	public void desconectar() throws SQLException;
	public ResultSet consultar() throws SQLException, ClassNotFoundException;
	public ResultSet consultarPorDni(Pasajero p) throws SQLException, ClassNotFoundException;
	public ResultSet consultarPorDni(String dniPasajero) throws SQLException, ClassNotFoundException;
	public ResultSet consultarPersonaPorDni(Pasajero p) throws SQLException, ClassNotFoundException;
	public void altaPasajero(Pasajero p) throws SQLException, ClassNotFoundException;
	public void bajaPasajero(Pasajero p) throws SQLException, ClassNotFoundException;
	public void modificacion(String atr, String valor, String dni) throws SQLException, ClassNotFoundException;
}