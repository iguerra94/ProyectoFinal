package org.proyectofinal.dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.model.interfaces.PersonaRegistrada;

/**
 * Interfaz de la Clase de Persistencia de Datos de la Entidad de Dominio <strong>PersonaRegistrada</strong>: <code>PersonaRegistradaDao</code>.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public interface PersonaRegistradaDao {
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.impl.PersonaRegistradaDaoImpl#conectar()
	 */
	
	public void conectar() throws ClassNotFoundException, SQLException;
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.impl.PersonaRegistradaDaoImpl#desconectar()
	 */
	
	public void desconectar() throws SQLException;
	
	/**
	 * Metodo de Persistencia de Datos que retorna un objeto ResultSet con todos los datos de la <code>PersonaRegistrada</code> con el atributo <em>usuario</em> pasado como parametro.
	 *
	 * @param user El atributo <em>usuario</em> de la <code>PersonaRegistrada</code>.
	 * @return Un objeto ResultSet con todos los datos de la <code>PersonaRegistrada</code> con el atributo <em>usuario</em> pasado como parametro.
	 * @throws ClassNotFoundException Si no se encuentra ninguna definicion de la clase buscada.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 */
	
	public ResultSet consultarDatosPersonaRegistradaPorUsuario(String user) throws ClassNotFoundException, SQLException;
	
	/**
	 * Metodo de Persistencia de Datos que retorna un objeto ResultSet con todos los datos de la <code>PersonaRegistrada</code> con el atributo <em>dni</em> del objeto <code>PersonaRegistrada</code> pasado como parametro.
	 *
	 * @param p El objeto <code>PersonaRegistrada</code>.
	 * @return Un objeto ResultSet con todos los datos de la <code>PersonaRegistrada</code> con el atributo <em>dni</em> del objeto <code>PersonaRegistrada</code> pasado como parametro.
	 * @throws ClassNotFoundException Si no se encuentra ninguna definicion de la clase buscada.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 */
	
	public ResultSet consultarPorDni(PersonaRegistrada p) throws ClassNotFoundException, SQLException;
	
	/**
	 * Metodo de Persistencia de Datos que retorna un objeto ResultSet con el atributo <em>email</em> de la <code>PersonaRegistrada</code> con el atributo <em>dni</em> pasado como parametro.
	 *
	 * @param dni El atributo <em>dni</em> de la <code>PersonaRegistrada</code>.
	 * @return Un objeto ResultSet con el atributo <em>email</em> de la <code>PersonaRegistrada</code> con el atributo <em>dni</em> pasado como parametro.
	 * @throws ClassNotFoundException Si no se encuentra ninguna definicion de la clase buscada.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 */
	
	public ResultSet consultarEmail(String dni) throws ClassNotFoundException, SQLException;
	
	/**
	 * Metodo de Persistencia de Datos que retorna un objeto ResultSet con todos los datos de la <code>PersonaGenerica</code> con el atributo <em>dni</em> del objeto <code>PersonaRegistrada</code> pasado como parametro.
	 *
	 * @param p El objeto <code>PersonaRegistrada</code> que extiende de <code>PersonaGenerica</code>.
	 * @return Un objeto ResultSet con todos los datos de la <code>PersonaGenerica</code> con el atributo <em>dni</em> del objeto <code>PersonaRegistrada</code> pasado como parametro.
	 * @throws ClassNotFoundException Si no se encuentra ninguna definicion de la clase buscada.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 */
	
	public ResultSet consultarPersonaGenericaPorDni(PersonaRegistrada p) throws ClassNotFoundException, SQLException;
	
	/**
	 * Metodo de Persistencia de Datos que inserta una nueva <code>PersonaGenerica</code> en la base de datos del sistema si esta no existe aún.
	 *
	 * @param p El objeto <code>PersonaRegistrada</code> que extiende de <code>PersonaGenerica</code>.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 */
	
	public void altaPersonaGenerica(PersonaRegistrada p) throws SQLException;
	
	/**
	 * Metodo de Persistencia de Datos que inserta una nueva <code>PersonaRegistrada</code> en la base de datos del sistema.
	 *
	 * @param p El objeto <code>PersonaRegistrada</code>.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 */
	
	public void altaPersonaRegistrada(PersonaRegistrada p) throws SQLException;
	
	/**
	 * Metodo de Persistencia de Datos que modifica en la base de datos del sistema los valores de los atributos de la <code>PersonaGenerica</code> y/o la <code>PersonaRegistrada</code> con el atributo <em>dni</em> del objeto <code>PersonaRegistrada</code> pasado como parametro.
	 *
	 * @param pR El objeto <code>PersonaRegistrada</code> con los nuevos valores en los atributos a modificar en las Entidades <code>PersonaGenerica</code> y/o <code>PersonaRegistrada</code> en la base de datos del sistema.
	 * @throws ClassNotFoundException Si no se encuentra ninguna definicion de la clase buscada.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 */
	
	public void modificacion(PersonaRegistrada pR) throws ClassNotFoundException, SQLException;
	
	/**
	 * Metodo de Persistencia de Datos que modifica el atributo <em>saldo</em> de un objeto <code>PersonaRegistrada</code>.
	 *
	 * @param distancia El atributo <em>distancia</em> de un <code>ViajeCabecera</code> que sera acumulado al atributo <em>saldo</em> del objeto <code>PersonaRegistrada</code>.
	 * @param dniPersona El atributo <em>dni</em> del objeto <code>PersonaRegistrada</code> al cual se le modificara el atributo <em>saldo</em>.
	 * @throws ClassNotFoundException Si no se encuentra ninguna definicion de la clase buscada.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 */
	
	public void modificarSaldo(Integer distancia, String dniPersona) throws ClassNotFoundException, SQLException;

}