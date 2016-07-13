package org.proyectofinal.dao.abstracts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase abstracta que contiene los metodos basicos para conectarse a la base de datos del sistema.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public class AbstractDao {
	
	/** El objeto <code>Connection</code> que establecera la conexion con la base de datos del sistema.  */
	
	protected Connection conexion = null;
	
	/**
	 * Metodo que establece la conexion con la base de datos del sistema a traves del atributo <em>conexion</em>.
	 *
	 * @throws ClassNotFoundException Si no se encuentra ninguna definicion de la clase buscada.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 */
	
	public void conectar() throws ClassNotFoundException, SQLException{
	
		Class.forName("com.mysql.jdbc.Driver");

		this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ReservasAvion", "root", "genius34");
	}
	
	/**
	 * Metodo que se desconecta de la base de datos del sistema liberando el objeto Connection de la conexion y los recursos JDBC.
	 *
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 */
	
	public void desconectar() throws SQLException{
		getConexion().close();
	}
	
	/**
	 * Metodo que retorna el objeto <code>Connection</code> encargado de establecer la conexion con la base de datos del sistema.
	 *
	 * @return El objeto <code>Connection</code> encargado de establecer la conexion con la base de datos del sistema.
	 */
	
	public Connection getConexion() {
		return this.conexion;
	}
	
}