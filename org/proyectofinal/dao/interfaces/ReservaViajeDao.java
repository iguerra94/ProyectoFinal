package org.proyectofinal.dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.model.interfaces.ReservaViaje;

/**
 * Interfaz de la Clase de Persistencia de Datos de la Entidad de Dominio <strong>ReservaViaje</strong>: <code>ReservaViajeDao</code>.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public interface ReservaViajeDao {

	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.abstracts.AbstractDao#conectar()
	 */
	
	public void conectar() throws ClassNotFoundException, SQLException;
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.abstracts.AbstractDao#desconectar()
	 */
	
	public void desconectar() throws SQLException;
	
	/**
	 * Metodo de Persistencia de Datos que retorna un objeto ResultSet con todos los datos de las <code>ReservaViaje</code> existentes en la base de datos del sistema con el atributo <em>dniPersona</em> pasado como parametro.
	 *
	 * @param dni El atributo <em>dniPersona</em> de las <code>ReservaViaje</code>.
	 * @return Un objeto ResultSet con todos los datos de las <code>ReservaViaje</code> existentes en la base de datos del sistema con el atributo <em>dniPersona</em> pasado como parametro.
	 * @throws ClassNotFoundException Si no se encuentra ninguna definicion de la clase buscada.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 */
	
	public ResultSet consultarPorPersonaQueReserva(String dni) throws ClassNotFoundException, SQLException;
	
	/**
	 * Metodo de Persistencia de Datos que retorna un objeto ResultSet con los asientos reservados del viaje relacionado a la <code>ReservaViaje</code> con el atributo <em>codViaje</em> pasado como parametro. 
	 *
	 * @param codViaje El atributo <em>codViaje</em> del viaje relacionado a la <code>ReservaViaje</code>.
	 * @return Un objeto ResultSet con los asientos reservados del viaje relacionado a la <code>ReservaViaje</code> con el atributo <em>codViaje</em> pasado como parametro.
	 * @throws ClassNotFoundException Si no se encuentra ninguna definicion de la clase buscada.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 */
	
	public ResultSet consultarAsientosPorViaje(String codViaje) throws ClassNotFoundException, SQLException;		
	
	/**
	 * Metodo de Persistencia de Datos que retorna un objeto ResultSet con la cantidad de <code>ReservaViaje</code> realizadas por la persona con el atributo <em>dniPersona</em> pasado como parametro.
	 *
	 * @param dni El atributo <em>dniPersona</em> de las <code>ReservaViaje</code>.
	 * @return Un objeto ResultSet con la cantidad de <code>ReservaViaje</code> realizadas por la persona con el atributo <em>dniPersona</em> pasado como parametro.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 */
	
	public ResultSet consultarCantidadDeReservas(String dni) throws SQLException;
	
	/**
	 * Metodo de Persistencia de Datos que inserta una nueva <code>ReservaViaje</code> en la base de datos del sistema.
	 *
	 * @param rV El objeto <code>ReservaViaje</code>.
	 * @throws ClassNotFoundException Si no se encuentra ninguna definicion de la clase buscada.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 */
	
	public void alta(ReservaViaje rV) throws ClassNotFoundException, SQLException;

}