package org.proyectofinal.dao.interfaces;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.model.interfaces.ViajeCabecera;

public interface ViajeCabeceraDao {
	
	public void conectar() throws ClassNotFoundException, SQLException;
	public void desconectar() throws SQLException;
	public ResultSet consultar() throws ClassNotFoundException, SQLException;
	public ResultSet consultarCodigosViaje() throws SQLException, ClassNotFoundException;
	public ResultSet consultarPorCodigoViaje(String codViaje) throws SQLException, ClassNotFoundException;
	public ResultSet consultarPorCodigoViaje(ViajeCabecera vC) throws SQLException, ClassNotFoundException;
	public ResultSet consultarOrigenes() throws ClassNotFoundException, SQLException;
	public ResultSet consultarDestinos() throws ClassNotFoundException, SQLException;
	public ResultSet consultarVuelosPorFecha(ViajeCabecera vC) throws ClassNotFoundException, SQLException;
	public ResultSet consultarVuelosCualquierFecha(ViajeCabecera vC) throws ClassNotFoundException, SQLException;
	public void alta(ViajeCabecera vC) throws SQLException, ClassNotFoundException;
	public void baja(Integer codigoViaje) throws SQLException, ClassNotFoundException;
	public void actualizarCupo(ViajeCabecera vC) throws SQLException, ClassNotFoundException;
	public void modificacion(ViajeCabecera vC) throws SQLException, ClassNotFoundException;
	public ResultSet consultarPorFechaActualYFutura(Date fecha) throws SQLException, ClassNotFoundException;
}