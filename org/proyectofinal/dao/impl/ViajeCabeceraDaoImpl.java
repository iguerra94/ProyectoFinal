package org.proyectofinal.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.dao.abstracts.AbstractDao;
import org.proyectofinal.dao.interfaces.ViajeCabeceraDao;
import org.proyectofinal.model.interfaces.ViajeCabecera;

/**
 * Implementacion de la Clase de Persistencia de Datos de la Entidad de Dominio <strong>ViajeCabecera</strong>: <code>ViajeCabeceraDao</code>.
 *  
 * @author Ivan Guerra
 * @version 1.0.0 
 */

public class ViajeCabeceraDaoImpl extends AbstractDao implements ViajeCabeceraDao {

	/**
	 * Instancia un nuevo objeto de la Clase de Persistencia de Datos <code>ViajeCabeceraDao</code>.
	 */
	
	public ViajeCabeceraDaoImpl(){
		
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.abstracts.AbstractDao#conectar()
	 */
	
	public void conectar() throws ClassNotFoundException, SQLException{
		super.conectar();
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.abstracts.AbstractDao#desconectar()
	 */
	
	public void desconectar() throws SQLException{
		super.desconectar();
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.ViajeCabeceraDao#consultarPorCodigoViaje(java.lang.String)
	 */

	public ResultSet consultarPorCodigoViaje(String codViaje) throws SQLException, ClassNotFoundException {
		
		PreparedStatement sentencia = getConexion().prepareStatement("SELECT * FROM ViajeCabecera WHERE codViaje = ?");
		
		sentencia.setString(1, codViaje);
		
		ResultSet resultado = sentencia.executeQuery();
		
		return resultado;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.ViajeCabeceraDao#consultarCodigosViaje()
	 */

	public ResultSet consultarCodigosViaje() throws SQLException, ClassNotFoundException {
		
		PreparedStatement sentencia = getConexion().prepareStatement("SELECT codViaje FROM ViajeCabecera");
		
		ResultSet resultado = sentencia.executeQuery();
		
		return resultado;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.ViajeCabeceraDao#consultarVuelosPorFecha(org.proyectofinal.model.interfaces.ViajeCabecera)
	 */
	
	public ResultSet consultarVuelosPorFecha(ViajeCabecera vC) throws ClassNotFoundException, SQLException{
		
		PreparedStatement sentencia = getConexion().prepareStatement("SELECT * FROM ViajeCabecera where ciudadOrigen = ? and ciudadDestino = ? and date(fechaSalida) = ?");
		
		sentencia.setString(1, vC.getCiudadOrigen());
		sentencia.setString(2, vC.getCiudadDestino());
		sentencia.setDate(3, vC.getFechaSalida());
		
		ResultSet resultado = sentencia.executeQuery();
		
		return resultado;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.ViajeCabeceraDao#consultarVuelosCualquierFecha(org.proyectofinal.model.interfaces.ViajeCabecera)
	 */
	
	public ResultSet consultarVuelosCualquierFecha(ViajeCabecera vC) throws ClassNotFoundException, SQLException{
		
		PreparedStatement sentencia = getConexion().prepareStatement("SELECT * FROM ViajeCabecera where ciudadOrigen = ? and ciudadDestino = ?");
		
		sentencia.setString(1, vC.getCiudadOrigen());
		sentencia.setString(2, vC.getCiudadDestino());
		
		ResultSet resultado = sentencia.executeQuery();
		
		return resultado;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.ViajeCabeceraDao#consultarOrigenesDestinos()
	 */
	
	@Override
	public ResultSet consultarOrigenesDestinos() throws SQLException, ClassNotFoundException {
		
		PreparedStatement sentencia = getConexion().prepareStatement("SELECT DISTINCT ciudadOrigen, shortPaisOrigen, ciudadDestino, shortPaisDestino FROM ViajeCabecera");
		
		ResultSet resultado = sentencia.executeQuery();
	
		return resultado;		
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.ViajeCabeceraDao#consultarOrigenes()
	 */
	
	public ResultSet consultarOrigenes() throws ClassNotFoundException, SQLException {
		
		PreparedStatement sentencia = getConexion().prepareStatement("SELECT DISTINCT ciudadOrigen, shortPaisOrigen FROM ViajeCabecera");
		
		ResultSet resultado = sentencia.executeQuery();
	
		return resultado;		
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.ViajeCabeceraDao#consultarDestinos()
	 */
	
	public ResultSet consultarDestinos() throws ClassNotFoundException, SQLException {
		
		PreparedStatement sentencia = getConexion().prepareStatement("SELECT DISTINCT ciudadDestino, shortPaisDestino FROM ViajeCabecera");
		
		ResultSet resultado = sentencia.executeQuery();
		
		return resultado;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.ViajeCabeceraDao#consultarDatosOferta()
	 */
	
	public ResultSet consultarDatosOferta() throws SQLException, ClassNotFoundException {
			
		PreparedStatement sentencia = getConexion().prepareStatement("SELECT DISTINCT ciudadOrigen, shortPaisOrigen, ciudadDestino, shortPaisDestino, oferta, imagenOferta, precioClaseTur FROM ViajeCabecera");
		
		ResultSet resultado = sentencia.executeQuery();
	
		return resultado;		
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.ViajeCabeceraDao#consultarOrigenesYDestinos()
	 */
	
	@Override
	public ResultSet consultarOrigenesYDestinos() throws SQLException, ClassNotFoundException {

		PreparedStatement sentencia = getConexion().prepareStatement("SELECT DISTINCT ciudadOrigen, shortPaisOrigen, ciudadDestino, shortPaisDestino, oferta FROM ViajeCabecera");
		
		ResultSet resultado = sentencia.executeQuery();
	
		return resultado;		
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.ViajeCabeceraDao#alta(org.proyectofinal.model.interfaces.ViajeCabecera)
	 */
	
	public void alta(ViajeCabecera vC) throws SQLException, ClassNotFoundException{
		
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("INSERT INTO ViajeCabecera VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
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
		sentencia.setString(18, vC.getOferta());
		sentencia.setString(19, vC.getImagenOferta());
		sentencia.setString(20, vC.getImagen1());
		sentencia.setString(21, vC.getImagen2());
		sentencia.setInt(22, vC.getCupo());

		
		sentencia.executeUpdate();
	
		desconectar();
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.ViajeCabeceraDao#altaOferta(org.proyectofinal.model.interfaces.ViajeCabecera)
	 */
	
	@Override
	public void altaOferta(ViajeCabecera vC) throws SQLException, ClassNotFoundException {
		
		conectar();			
		
		PreparedStatement sentencia = null;
		
		sentencia = getConexion().prepareStatement("update ViajeCabecera set oferta = ?, imagenOferta = ? where ciudadOrigen = ? and shortPaisOrigen = ? and ciudadDestino = ? and shortPaisDestino = ?");

		sentencia.setString(1, vC.getOferta());
		sentencia.setString(2, vC.getImagenOferta());
		
		sentencia.setString(3, vC.getCiudadOrigen());
		sentencia.setString(4, vC.getShortPaisOrigen());
		sentencia.setString(5, vC.getCiudadDestino());
		sentencia.setString(6, vC.getShortPaisDestino());
	
		sentencia.executeUpdate();
		
		desconectar();
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.ViajeCabeceraDao#baja(java.lang.String)
	 */
	
	public void baja(String codigoViaje) throws SQLException, ClassNotFoundException{
		
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("DELETE FROM ViajeCabecera WHERE codViaje = ?");
		
		sentencia.setString(1, codigoViaje);
		
		sentencia.executeUpdate();
	
		desconectar();
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.ViajeCabeceraDao#bajaOferta(org.proyectofinal.model.interfaces.ViajeCabecera)
	 */
	
	@Override
	public void bajaOferta(ViajeCabecera vC) throws SQLException, ClassNotFoundException {
		
		conectar();
		
		PreparedStatement sentencia = null;
		
		sentencia = getConexion().prepareStatement("update ViajeCabecera set oferta = 0, imagenOferta = '' where ciudadOrigen = ? and shortPaisOrigen = ? and ciudadDestino = ? and shortPaisDestino = ?");
		
		sentencia.setString(1, vC.getCiudadOrigen());
		sentencia.setString(2, vC.getShortPaisOrigen());
		sentencia.setString(3, vC.getCiudadDestino());
		sentencia.setString(4, vC.getShortPaisDestino());

		sentencia.executeUpdate();
	
		desconectar();
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.ViajeCabeceraDao#modificacion(org.proyectofinal.model.interfaces.ViajeCabecera)
	 */
	
	public void modificacion(ViajeCabecera vC) throws SQLException, ClassNotFoundException{
		
		conectar();			
		
		PreparedStatement sentencia = null;
		
		sentencia = getConexion().prepareStatement("update ViajeCabecera set ciudadOrigen = ?, paisOrigen = ?, shortPaisOrigen = ?, plataformaOrigen = ?, ciudadDestino = ?, paisDestino = ?, shortpaisDestino = ?, plataformaDestino = ?, fechaSalida = ?, horaSalida = ?, fechaLlegada = ?, horaLlegada = ?, distancia = ?, duracion = ?, precioClaseTur = ?, precioClasePrim = ?, oferta = ?, imagenOferta = ?, imagen1 = ?, imagen2 = ?, cupo = ? where codViaje = ?");
		
		sentencia.setString(1, vC.getCiudadOrigen());
		sentencia.setString(2, vC.getPaisOrigen());
		sentencia.setString(3, vC.getShortPaisOrigen());
		sentencia.setString(4, vC.getPlataformaOrigen());
		
		sentencia.setString(5, vC.getCiudadDestino());
		sentencia.setString(6, vC.getPaisDestino());
		sentencia.setString(7, vC.getShortPaisDestino());
		sentencia.setString(8, vC.getPlataformaDestino());
		
		sentencia.setDate(9, vC.getFechaSalida());
		sentencia.setTime(10, vC.getHoraSalida());
		
		sentencia.setDate(11, vC.getFechaLlegada());
		sentencia.setTime(12, vC.getHoraLlegada());		
		
		sentencia.setInt(13, vC.getDistancia());
		sentencia.setTime(14, vC.getDuracion());
		sentencia.setFloat(15, vC.getPrecioClaseTur());
		sentencia.setFloat(16, vC.getPrecioClasePrim());
		sentencia.setString(17, vC.getOferta());
		sentencia.setString(18, vC.getImagenOferta());
		sentencia.setString(19, vC.getImagen1());
		sentencia.setString(20, vC.getImagen2());
		sentencia.setInt(21, vC.getCupo());
	
		sentencia.setString(22, vC.getCodigoViaje());
		
		sentencia.executeUpdate();
		
		desconectar();
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.ViajeCabeceraDao#actualizarCupo(org.proyectofinal.model.interfaces.ViajeCabecera)
	 */
	
	public void actualizarCupo(ViajeCabecera vC) throws SQLException, ClassNotFoundException{
		
		conectar();
		
		PreparedStatement sentencia = null;
		
		sentencia = getConexion().prepareStatement("update ViajeCabecera set cupo = cupo -1 where codViaje = ?");
		
		sentencia.setString(1, vC.getCodigoViaje());
		
		sentencia.executeUpdate();
	
		desconectar();
	}

}