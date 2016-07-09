package org.proyectofinal.dao.interfaces;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.model.interfaces.ViajeCabecera;

/**
 * Interfaz del DAO ViajeCabecera.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

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
	public void baja(String codigoViaje) throws SQLException, ClassNotFoundException;
	public void actualizarCupo(ViajeCabecera vC) throws SQLException, ClassNotFoundException;
	public void modificacion(ViajeCabecera vC) throws SQLException, ClassNotFoundException;
	public ResultSet consultarPorFechaActualYFutura(Date fecha) throws SQLException, ClassNotFoundException;
	public void altaOferta(ViajeCabecera vC) throws SQLException, ClassNotFoundException;
	public ResultSet consultarOrigenesYDestinos() throws SQLException, ClassNotFoundException;
	public void bajaOferta(ViajeCabecera vC) throws SQLException, ClassNotFoundException;
	public ResultSet consultarOrigenesDestinos() throws SQLException, ClassNotFoundException;
	public ResultSet consultarDatosOferta() throws SQLException, ClassNotFoundException;
}