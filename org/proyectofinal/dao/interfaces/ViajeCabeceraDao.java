package org.proyectofinal.dao.interfaces;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.dao.ex.NoFlightsFoundException;
import org.proyectofinal.model.interfaces.ViajeCabecera;

public interface ViajeCabeceraDao {
	
	public void conectar() throws ClassNotFoundException, SQLException;
	
	public void desconectar() throws SQLException;
	
	public Connection getConexion();
	
	public ResultSet consultar() throws ClassNotFoundException, SQLException;
	
	public ResultSet consultarCodigosViaje() throws SQLException, ClassNotFoundException;

	public ResultSet consultarPorCodigoViaje(Integer codViaje) throws SQLException, ClassNotFoundException;
	
	public ResultSet consultarPorCodigoViaje(ViajeCabecera vC) throws SQLException, ClassNotFoundException;
	
	public ResultSet consultarOrigenes() throws ClassNotFoundException, SQLException;

	public ResultSet consultarDestinos() throws ClassNotFoundException, SQLException;
	
	public ResultSet consultarVuelos(ViajeCabecera vC) throws ClassNotFoundException, SQLException;
	
	public void alta(ViajeCabecera vC) throws SQLException, ClassNotFoundException;
	
	public void baja(Integer codigoViaje) throws SQLException, ClassNotFoundException;

	public void actualizarCupo(ViajeCabecera vC) throws SQLException, ClassNotFoundException;
	
	public void modificacion(ViajeCabecera vC) throws SQLException, ClassNotFoundException;

	public ResultSet consultarPorFechaActualYFutura(Date fecha) throws SQLException, ClassNotFoundException;
}