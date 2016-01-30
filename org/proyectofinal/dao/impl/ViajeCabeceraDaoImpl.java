package org.proyectofinal.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.dao.abstracts.AbstractDao;
import org.proyectofinal.dao.ex.NoFlightsFoundException;
import org.proyectofinal.dao.interfaces.ViajeCabeceraDao;
import org.proyectofinal.model.interfaces.ViajeCabecera;

public class ViajeCabeceraDaoImpl extends AbstractDao implements ViajeCabeceraDao {
	
	private Connection conexion = null;
	
	public void conectar() throws ClassNotFoundException, SQLException{
	
		Class.forName("com.mysql.jdbc.Driver");

//		this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3305/ReservasAvion", "root", "asd123");
		this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ReservasAvion", "root", "genius34");
	}
	
	public void desconectar() throws SQLException{
		getConexion().close();
	}

	public Connection getConexion() {
		return this.conexion;
	}
	
	public ResultSet consultar() throws ClassNotFoundException, SQLException {
		
		PreparedStatement sentencia = getConexion().prepareStatement("SELECT * FROM ViajeCabecera");
		
		ResultSet resultado = sentencia.executeQuery();
		
		return resultado;
	}
	
	public ResultSet consultarPorCodigoViaje(Integer codViaje) throws SQLException, ClassNotFoundException {
		
		PreparedStatement sentencia = getConexion().prepareStatement("SELECT * FROM ViajeCabecera WHERE codViaje = ?");
		
		sentencia.setInt(1, codViaje);
		
		ResultSet resultado = sentencia.executeQuery();
		
		return resultado;
	}
	
	public ResultSet consultarOrigenes() throws ClassNotFoundException, SQLException {
		
		PreparedStatement sentencia = getConexion().prepareStatement("SELECT DISTINCT ciudadOrigen, paisOrigen FROM ViajeCabecera");
		
		ResultSet resultado = sentencia.executeQuery();
		
		return resultado;		
	}
	
	public ResultSet consultarDestinos() throws ClassNotFoundException, SQLException {
		
		PreparedStatement sentencia = getConexion().prepareStatement("SELECT DISTINCT ciudadDestino, paisDestino FROM ViajeCabecera");
		
		ResultSet resultado = sentencia.executeQuery();

		return resultado;
	}
	
	public ResultSet consultarVuelos(ViajeCabecera vC) throws ClassNotFoundException, SQLException, NoFlightsFoundException {
		
		PreparedStatement sentencia = getConexion().prepareStatement("SELECT * FROM ViajeCabecera where ciudadOrigen = ? and paisOrigen = ? and ciudadDestino = ? and paisDestino = ? and date(fechaSalida) = ?");
		
		sentencia.setString(1, vC.getCiudadOrigen());
		sentencia.setString(2, vC.getPaisOrigen());
		sentencia.setString(3, vC.getCiudadDestino());
		sentencia.setString(4, vC.getPaisDestino());
		
		Date date = new Date(vC.getFechaSalida().getTime());
		
		sentencia.setDate(5, date);
		
		ResultSet resultado = sentencia.executeQuery();
		
//		if (!resultado.next()) throw new NoFlightsFoundException();

		return resultado;		
	}

	public void alta(ViajeCabecera vC) throws SQLException, ClassNotFoundException{
		
		PreparedStatement sentencia = getConexion().prepareStatement("INSERT INTO ViajeCabecera (codViaje, ciudadOrigen, paisOrigen, ciudadDestino, paisDestino, fechaSalida, horaSalida, fechaLlegada, horaLlegada) VALUES (?,?,?,?,?,?,?,?,?)");
		
		sentencia.setInt(1, vC.getCodigoViaje());
		sentencia.setString(2, vC.getCiudadOrigen());
		sentencia.setString(3, vC.getPaisOrigen());
		sentencia.setString(4, vC.getCiudadDestino());
		sentencia.setString(5, vC.getPaisDestino());
		sentencia.setDate(6, vC.getFechaSalida());
		sentencia.setTime(7, vC.getHoraSalida());
		sentencia.setDate(8, vC.getFechaLlegada());
		sentencia.setTime(9, vC.getHoraLlegada());
		
		sentencia.executeUpdate();

		desconectar();
	}

	public void baja(Integer codigoViaje) throws SQLException, ClassNotFoundException{
		
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("DELETE FROM ViajeCabecera WHERE codViaje = ?");
		
		sentencia.setInt(1, codigoViaje);
		
		sentencia.executeUpdate();

		desconectar();
	}

	public void modificacion(ViajeCabecera vC) throws SQLException, ClassNotFoundException{
		conectar();
		desconectar();
	}
	
}