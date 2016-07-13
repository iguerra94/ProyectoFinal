package org.proyectofinal.dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.model.interfaces.PersonaRegistrada;
import org.proyectofinal.model.interfaces.Usuario;

/**
 * Interfaz de la Clase de Persistencia de Datos de la Entidad de Dominio <strong>PersonaRegistrada</strong>: <code>PersonaRegistradaDao</code>.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public interface PersonaRegistradaDao {
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.abstracts.AbstractDao#conectar()
	 */
	
	public void conectar() throws ClassNotFoundException, SQLException;
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.abstracts.AbstractDao#desconectar()
	 */
	
	public void desconectar() throws SQLException;
	
	/**
	 * Consultar datos persona registrada por usuario.
	 *
	 * @param user the user
	 * @return the result set
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	
	public ResultSet consultarDatosPersonaRegistradaPorUsuario(String user) throws ClassNotFoundException, SQLException;
	
	/**
	 * Consultar persona registrada por usuario.
	 *
	 * @param u the u
	 * @return the result set
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	
	public ResultSet consultarPersonaRegistradaPorUsuario(Usuario u) throws ClassNotFoundException, SQLException;
	
	/**
	 * Consultar por dni.
	 *
	 * @param p the p
	 * @return the result set
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	
	public ResultSet consultarPorDni(PersonaRegistrada p) throws ClassNotFoundException, SQLException;
	
	/**
	 * Consultar email.
	 *
	 * @param dni the dni
	 * @return the result set
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	
	public ResultSet consultarEmail(String dni) throws ClassNotFoundException, SQLException;
	
	/**
	 * Consultar persona generica por dni.
	 *
	 * @param p the p
	 * @return the result set
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	
	public ResultSet consultarPersonaGenericaPorDni(PersonaRegistrada p) throws ClassNotFoundException, SQLException;
	
	/**
	 * Alta persona generica.
	 *
	 * @param p the p
	 * @throws SQLException the SQL exception
	 */
	
	public void altaPersonaGenerica(PersonaRegistrada p) throws SQLException;
	
	/**
	 * Alta persona registrada.
	 *
	 * @param p the p
	 * @throws SQLException the SQL exception
	 */
	
	public void altaPersonaRegistrada(PersonaRegistrada p) throws SQLException;
	
	/**
	 * Modificacion.
	 *
	 * @param pR the p r
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	
	public void modificacion(PersonaRegistrada pR) throws ClassNotFoundException, SQLException;
	
	/**
	 * Modificar saldo.
	 *
	 * @param distancia the distancia
	 * @param dniPersona the dni persona
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	
	public void modificarSaldo(Integer distancia, String dniPersona) throws ClassNotFoundException, SQLException;

}