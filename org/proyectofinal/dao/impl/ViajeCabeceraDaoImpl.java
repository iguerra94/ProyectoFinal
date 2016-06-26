package org.proyectofinal.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.dao.abstracts.AbstractDao;
import org.proyectofinal.dao.interfaces.ViajeCabeceraDao;
import org.proyectofinal.model.interfaces.ViajeCabecera;

public class ViajeCabeceraDaoImpl extends AbstractDao implements ViajeCabeceraDao {
	
	public void conectar() throws ClassNotFoundException, SQLException{
		super.conectar();
	}
	
	public void desconectar() throws SQLException{
		super.desconectar();
	}

	public ResultSet consultar() throws ClassNotFoundException, SQLException {
		
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("SELECT * FROM ViajeCabecera");
		
		ResultSet resultado = sentencia.executeQuery();
	//	sentencia.close();
		return resultado;
	}
	
	public ResultSet consultarCodigosViaje() throws SQLException, ClassNotFoundException {
		
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("SELECT codViaje FROM ViajeCabecera");
		
		ResultSet resultado = sentencia.executeQuery();
		
	//	sentencia.close();
		
		return resultado;
	}
	
	public ResultSet consultarPorCodigoViaje(String codViaje) throws SQLException, ClassNotFoundException {
		
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("SELECT * FROM ViajeCabecera WHERE codViaje = ?");
		
		sentencia.setString(1, codViaje);
		
		ResultSet resultado = sentencia.executeQuery();
	//	sentencia.close();
		
		return resultado;
	}
	
	public ResultSet consultarPorCodigoViaje(ViajeCabecera vC) throws SQLException, ClassNotFoundException {
	
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("SELECT * FROM ViajeCabecera WHERE codViaje = ?");
		
		sentencia.setString(1, vC.getCodigoViaje());
		
		ResultSet resultado = sentencia.executeQuery();
	//	sentencia.close();
		
		return resultado;
	}
	
	public ResultSet consultarPorFechaActualYFutura(Date fecha) throws SQLException, ClassNotFoundException {
	
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("SELECT * FROM ViajeCabecera where DATE(fechaSalida) >= DATE(?)");
		
		sentencia.setDate(1, fecha);
		
		ResultSet resultado = sentencia.executeQuery();
	//	sentencia.close();
		
		return resultado;
	}
	
	public ResultSet consultarOrigenes() throws ClassNotFoundException, SQLException {
		
		PreparedStatement sentencia = getConexion().prepareStatement("SELECT DISTINCT ciudadOrigen, shortPaisOrigen FROM ViajeCabecera");
		
		ResultSet resultado = sentencia.executeQuery();
	
		return resultado;		
	}
	
	public ResultSet consultarDestinos() throws ClassNotFoundException, SQLException {
		
		PreparedStatement sentencia = getConexion().prepareStatement("SELECT DISTINCT ciudadDestino, shortPaisDestino FROM ViajeCabecera");
		
		ResultSet resultado = sentencia.executeQuery();
		
		return resultado;
	}
	
	public ResultSet consultarVuelosPorFecha(ViajeCabecera vC) throws ClassNotFoundException, SQLException{
		
		PreparedStatement sentencia = getConexion().prepareStatement("SELECT * FROM ViajeCabecera where ciudadOrigen = ? and ciudadDestino = ? and date(fechaSalida) = ?");
		
		sentencia.setString(1, vC.getCiudadOrigen());
		sentencia.setString(2, vC.getCiudadDestino());
		sentencia.setDate(3, vC.getFechaSalida());
		
		ResultSet resultado = sentencia.executeQuery();
		
		return resultado;
	}
	
	public ResultSet consultarVuelosCualquierFecha(ViajeCabecera vC) throws ClassNotFoundException, SQLException{
		
		PreparedStatement sentencia = getConexion().prepareStatement("SELECT * FROM ViajeCabecera where ciudadOrigen = ? and ciudadDestino = ?");
		
		sentencia.setString(1, vC.getCiudadOrigen());
		sentencia.setString(2, vC.getCiudadDestino());
		
		ResultSet resultado = sentencia.executeQuery();
		
		return resultado;
	}
	
	public ResultSet calcularDuracion(ViajeCabecera vC) throws SQLException{
		
		PreparedStatement sentencia = getConexion().prepareStatement("UPDATE ViajeCabecera SET duracion = timediff(?,?) where codViaje = ?");
	
		sentencia.setTime(1, vC.getHoraLlegada());
		sentencia.setTime(2, vC.getHoraSalida());
		sentencia.setString(3, vC.getCodigoViaje());
		
		ResultSet resultado = sentencia.executeQuery();
		
		return resultado;
	}

	public void alta(ViajeCabecera vC) throws SQLException, ClassNotFoundException{
		
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("INSERT INTO ViajeCabecera VALUES (?,?,?,?,?,?,?,date_format(?, '%d%m%Y'),?,date_format(?, '%d%m%Y'),?,?)");
		
		sentencia.setString(1, vC.getCodigoViaje());
		sentencia.setString(2, vC.getCiudadOrigen());
		sentencia.setString(3, vC.getPaisOrigen());
		sentencia.setString(4, vC.getShortPaisOrigen());
		sentencia.setString(5, vC.getCiudadDestino());
		sentencia.setString(6, vC.getPaisDestino());
		sentencia.setString(7, vC.getShortPaisDestino());
		sentencia.setDate(8, vC.getFechaSalida());
		sentencia.setTime(9, vC.getHoraSalida());
		sentencia.setDate(10, vC.getFechaLlegada());
		sentencia.setTime(11, vC.getHoraLlegada());
		sentencia.setInt(12, vC.getCupo());
		
		sentencia.executeUpdate();
	//	sentencia.close();
		
		desconectar();
	}

	public void baja(Integer codigoViaje) throws SQLException, ClassNotFoundException{
		
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("DELETE FROM ViajeCabecera WHERE codViaje = ?");
		
		sentencia.setInt(1, codigoViaje);
		
		sentencia.executeUpdate();
	//	sentencia.close();
		
		desconectar();
	}

	public void actualizarCupo(ViajeCabecera vC) throws SQLException, ClassNotFoundException{
		
		conectar();			
		
		PreparedStatement sentencia = null;
		
		sentencia = getConexion().prepareStatement("update ViajeCabecera set cupo = cupo -1 where codViaje = ?");
		
		sentencia.setString(1, vC.getCodigoViaje());
		
		sentencia.executeUpdate();
	//	sentencia.close();
		
		desconectar();
	}
	
//	public void 
	
	public void modificacion(ViajeCabecera vC) throws SQLException, ClassNotFoundException{
		
		conectar();			
		
		PreparedStatement sentencia = null;
		
		sentencia = getConexion().prepareStatement("update ViajeCabecera set ciudadOrigen = ?, paisOrigen = ?, ciudadDestino = ?, paisDestino = ?, fechaSalida = ?, horaSalida = ?, fechaLlegada = ?, horaLlegada = ?, cupo = ? where codViaje = ?");
		
		sentencia.setString(1, vC.getCiudadOrigen());
		sentencia.setString(2, vC.getPaisOrigen());
		sentencia.setString(3, vC.getCiudadDestino());
		sentencia.setString(4, vC.getPaisDestino());
		sentencia.setDate(5, vC.getFechaSalida());
		sentencia.setTime(6, vC.getHoraSalida());
		sentencia.setDate(7, vC.getFechaLlegada());
		sentencia.setTime(8, vC.getHoraLlegada());
		sentencia.setInt(9, vC.getCupo());
		sentencia.setString(10, vC.getCodigoViaje());
		
		sentencia.executeUpdate();
	//	sentencia.close();
		
		desconectar();
	}
	
}