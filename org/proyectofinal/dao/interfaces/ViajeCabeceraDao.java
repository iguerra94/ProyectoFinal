package org.proyectofinal.dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.model.interfaces.ViajeCabecera;

/**
 * Interfaz de la Clase de Persistencia de Datos de la Entidad de Dominio <strong>ViajeCabecera</strong>: <code>ViajeCabeceraDao</code>.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public interface ViajeCabeceraDao {
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.abstracts.AbstractDao#conectar()
	 */
	
	public void conectar() throws ClassNotFoundException, SQLException;
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.abstracts.AbstractDao#desconectar()
	 */
	
	public void desconectar() throws SQLException;
	
	/**
	 * Consultar por codigo viaje.
	 *
	 * @param codViaje the cod viaje
	 * @return the result set
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	
	public ResultSet consultarPorCodigoViaje(String codViaje) throws SQLException, ClassNotFoundException;
	
	/**
	 * Consultar codigos viaje.
	 *
	 * @return the result set
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	
	public ResultSet consultarCodigosViaje() throws SQLException, ClassNotFoundException;
	
	/**
	 * Consultar vuelos por fecha.
	 *
	 * @param vC the v c
	 * @return the result set
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	
	public ResultSet consultarVuelosPorFecha(ViajeCabecera vC) throws ClassNotFoundException, SQLException;
	
	/**
	 * Consultar vuelos cualquier fecha.
	 *
	 * @param vC the v c
	 * @return the result set
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	
	public ResultSet consultarVuelosCualquierFecha(ViajeCabecera vC) throws ClassNotFoundException, SQLException;
	
	/**
	 * Consultar origenes destinos.
	 *
	 * @return the result set
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	
	public ResultSet consultarOrigenesDestinos() throws SQLException, ClassNotFoundException;
	
	/**
	 * Consultar origenes.
	 *
	 * @return the result set
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	
	public ResultSet consultarOrigenes() throws ClassNotFoundException, SQLException;
	
	/**
	 * Consultar destinos.
	 *
	 * @return the result set
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	
	public ResultSet consultarDestinos() throws ClassNotFoundException, SQLException;
	
	/**
	 * Consultar datos oferta.
	 *
	 * @return the result set
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	
	public ResultSet consultarDatosOferta() throws SQLException, ClassNotFoundException;
	
	/**
	 * Consultar origenes y destinos.
	 *
	 * @return the result set
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	
	public ResultSet consultarOrigenesYDestinos() throws SQLException, ClassNotFoundException;
	
	/**
	 * Alta.
	 *
	 * @param vC the v c
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public void alta(ViajeCabecera vC) throws SQLException, ClassNotFoundException;
	
	/**
	 * Alta oferta.
	 *
	 * @param vC the v c
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	
	public void altaOferta(ViajeCabecera vC) throws SQLException, ClassNotFoundException;
	
	/**
	 * Baja.
	 *
	 * @param codigoViaje the codigo viaje
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	
	public void baja(String codigoViaje) throws SQLException, ClassNotFoundException;
	
	/**
	 * Baja oferta.
	 *
	 * @param vC the v c
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	
	public void bajaOferta(ViajeCabecera vC) throws SQLException, ClassNotFoundException;	
	
	/**
	 * Modificacion.
	 *
	 * @param vC the v c
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	
	public void modificacion(ViajeCabecera vC) throws SQLException, ClassNotFoundException;
	
	/**
	 * Actualizar cupo.
	 *
	 * @param vC the v c
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	
	public void actualizarCupo(ViajeCabecera vC) throws SQLException, ClassNotFoundException;

}