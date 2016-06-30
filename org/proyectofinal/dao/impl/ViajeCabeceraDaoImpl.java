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

	public void alta(ViajeCabecera vC) throws SQLException, ClassNotFoundException{
		
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("INSERT INTO ViajeCabecera VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		sentencia.setString(1, vC.getCodigoViaje());
		sentencia.setString(2, vC.getCiudadOrigen());
		sentencia.setString(3, vC.getPaisOrigen());
		sentencia.setString(4, vC.getShortPaisOrigen());
		sentencia.setString(5, vC.getPlataformaOrigen());
		sentencia.setString(6, vC.getCiudadDestino());
		sentencia.setString(7, vC.getPaisDestino());
		sentencia.setString(8, vC.getShortPaisDestino());
		sentencia.setString(9, vC.getPlataformaDestino());
		sentencia.setDate(10, vC.getFechaSalida());
		sentencia.setTime(11, vC.getHoraSalida());
		sentencia.setDate(12, vC.getFechaLlegada());
		sentencia.setTime(13, vC.getHoraLlegada());
		sentencia.setInt(14, vC.getDistancia());
		sentencia.setTime(15, vC.getDuracion());
		sentencia.setFloat(16, vC.getPrecioClaseTur());
		sentencia.setFloat(17, vC.getPrecioClasePrim());
		sentencia.setFloat(18, vC.getOferta());
		sentencia.setString(19, vC.getImagen1());
		sentencia.setString(20, vC.getImagen2());
		sentencia.setInt(21, vC.getCupo());

		
		sentencia.executeUpdate();
	
		desconectar();
	}

	public void baja(String codigoViaje) throws SQLException, ClassNotFoundException{
		
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("DELETE FROM ViajeCabecera WHERE codViaje = ?");
		
		sentencia.setString(1, codigoViaje);
		
		sentencia.executeUpdate();
	
		desconectar();
	}

	public void actualizarCupo(ViajeCabecera vC) throws SQLException, ClassNotFoundException{
		
		conectar();
		
		PreparedStatement sentencia = null;
		
		sentencia = getConexion().prepareStatement("update ViajeCabecera set cupo = cupo -1 where codViaje = ?");
		
		sentencia.setString(1, vC.getCodigoViaje());
		
		sentencia.executeUpdate();
	
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