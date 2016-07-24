package org.proyectofinal.dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.model.interfaces.Usuario;

/**
 * Interfaz de la Clase de Persistencia de Datos de la Entidad de Dominio <strong>Usuario</strong>: <code>UsuarioDao</code>.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public interface UsuarioDao {
	 
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.impl.UsuarioDaoImpl#conectar()
	 */
	
	public void conectar() throws ClassNotFoundException, SQLException;
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.impl.UsuarioDaoImpl#desconectar()
	 */
	
	public void desconectar() throws SQLException;
	
	/**
	 * Metodo de Persistencia de Datos que verifica que los atributos <em>usuario</em> y <em>contrasenia</em> del objeto <code>Usuario</code> pasado como parametro sean correctos, es decir, que existan en la base de datos del sistema y, de ser asi, retorna un objeto ResultSet con el usuario y la contrasenia del <code>Usuario</code>.
	 *
	 * @param u El objeto <code>Usuario</code>.
	 * @return Un objeto ResultSet con el usuario y la contrasenia del <code>Usuario</code>.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 * @throws ClassNotFoundException Si no se encuentra ninguna definicion de la clase buscada.
	 */
	
	public ResultSet consultarPorUsuario(Usuario u) throws SQLException, ClassNotFoundException;
	
	/**
	 * Metodo de Persistencia de Datos que retorna un objeto ResultSet con todos los datos del <code>Usuario</code> con el atributo <em>usuario</em> pasado como parametro.
	 *
	 * @param usuario El atributo <em>usuario</em> del objeto <code>Usuario</code>.
	 * @return Un objeto ResultSet con todos los datos del <code>Usuario</code> con el atributo <em>usuario</em> pasado como parametro.
	 * @throws ClassNotFoundException Si no se encuentra ninguna definicion de la clase buscada.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 */
	
	public ResultSet consultarPorUsuario(String usuario) throws ClassNotFoundException, SQLException;
	
	/**
	 * Metodo de Persistencia de Datos que retorna un objeto ResultSet con el atributo <em>dni</em> de la <code>PersonaRegistrada</code> relacionada con el <code>Usuario</code> que tiene el atributo <em>usuario</em> pasado como parametro.
	 *
	 * @param usuario El atributo <em>usuario</em> del objeto <code>Usuario</code>.
	 * @return Un objeto ResultSet con el atributo <em>dni</em> de la <code>PersonaRegistrada</code> relacionada con el <code>Usuario</code> que tiene el atributo <em>usuario</em> pasado como parametro.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 */
	
	public ResultSet consultarDniPorUsuario(String usuario) throws SQLException;
	
	/**
	 * Metodo de Persistencia de Datos que inserta un nuevo <code>Usuario</code> en la base de datos del sistema.
	 *
	 * @param u El objeto <code>Usuario</code>.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 * @throws ClassNotFoundException Si no se encuentra ninguna definicion de la clase buscada.
	 */
	
	public void alta(Usuario u) throws SQLException, ClassNotFoundException;
	
	/**
	 * Metodo de Persistencia de Datos que modifica en la base de datos del sistema el valor del atributo <em>contrasenia</em> del <code>Usuario</code> con el atributo <em>usuario</em> pasado como parametro.
	 *
	 * @param contrasenia El nuevo valor del atributo <em>contrasenia</em> del <code>Usuario</code>.
	 * @param usuario El atributo <em>usuario</em> del <code>Usuario</code>.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 * @throws ClassNotFoundException Si no se encuentra ninguna definicion de la clase buscada.
	 */
	
	public void modificacionContrasenia(String contrasenia, String usuario) throws SQLException, ClassNotFoundException;

}