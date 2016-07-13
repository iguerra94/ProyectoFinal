package org.proyectofinal.dao.interfaces;
	
import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.model.interfaces.Pasajero;

/**
 * Interfaz de la Clase de Persistencia de Datos de la Entidad de Dominio <strong>Pasajero</strong>: <code>PasajeroDao</code>.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public interface PasajeroDao {

	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.abstracts.AbstractDao#conectar()
	 */

	public void conectar() throws ClassNotFoundException, SQLException;
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.abstracts.AbstractDao#desconectar()
	 */
	
	public void desconectar() throws SQLException;
	
	/**
	 * Metodo de Persistencia de Datos que retorna un objeto ResultSet con todos los datos de la <code>PersonaGenerica</code> con el atributo <em>dni</em> del objeto <code>Pasajero</code> pasado como parametro.
	 *
	 * @param p El objeto <code>Pasajero</code> que extiende de <code>PersonaGenerica</code>.
	 * @return Un objeto ResultSet con todos los datos de la <code>PersonaGenerica</code> con el atributo <em>dni</em> del objeto <code>Pasajero</code> pasado como parametro.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 * @throws ClassNotFoundException Si no se encuentra ninguna definicion de la clase buscada.
	 */
	
	public ResultSet consultarPersonaGenericaPorDni(Pasajero p) throws SQLException, ClassNotFoundException;
	
	/**
	 * Metodo de Persistencia de Datos que retorna un objeto ResultSet con todos los datos del <code>Pasajero</code> con el atributo <em>dni</em> pasado como parametro.
	 *
	 * @param dniPasajero El atributo <em>dni</em> del <code>Pasajero</code>.
	 * @return Un objeto ResultSet con todos los datos del <code>Pasajero</code> con el atributo <em>dni</em> pasado como parametro.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 * @throws ClassNotFoundException Si no se encuentra ninguna definicion de la clase buscada.
	 */
	
	public ResultSet consultarPasajeroPorDni(String dniPasajero) throws SQLException, ClassNotFoundException;
	
	/**
	 * Metodo de Persistencia de Datos que inserta una nueva <code>PersonaGenerica</code> en la base de datos del sistema si esta no existe aún.
	 *
	 * @param p El objeto <code>Pasajero</code> que extiende de <code>PersonaGenerica</code>.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 */
	
	public void altaPersonaGenerica(Pasajero p) throws SQLException;
	
	/**
	 * Metodo de Persistencia de Datos que inserta un nuevo <code>Pasajero</code> en la base de datos del sistema.
	 *
	 * @param p El objeto <code>Pasajero</code>.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 */
	
	public void altaPasajero(Pasajero p) throws SQLException;
	
}