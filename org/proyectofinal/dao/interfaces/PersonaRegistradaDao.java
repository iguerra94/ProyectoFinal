package org.proyectofinal.dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.model.interfaces.PersonaRegistrada;
import org.proyectofinal.model.interfaces.Usuario;

/**
 * Interfaz del DAO PersonaRegistrada.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public interface PersonaRegistradaDao {
	
	public void conectar() throws ClassNotFoundException, SQLException;
	public void desconectar() throws SQLException;
	public ResultSet consultar() throws SQLException, ClassNotFoundException;
	public ResultSet consultarPorDni(PersonaRegistrada p) throws SQLException, ClassNotFoundException;
	public ResultSet consultarPorUsuario(Usuario u) throws SQLException, ClassNotFoundException;
	public ResultSet consultarPorPersonaYUsuario(String dni) throws SQLException, ClassNotFoundException;
	public ResultSet consultarPorUsuario(String user) throws SQLException, ClassNotFoundException;
	public ResultSet consultarPersonaPorDni(PersonaRegistrada p) throws SQLException, ClassNotFoundException;
	public ResultSet consultarPersonaPorDni(String dni) throws SQLException, ClassNotFoundException;
	public ResultSet consultarEmail(String dni) throws SQLException, ClassNotFoundException;
	public void altaPersonaGenerica(PersonaRegistrada p) throws SQLException;
	public void altaPersonaRegistrada(PersonaRegistrada p) throws SQLException;
	public void bajaPersonaRegistrada(PersonaRegistrada p) throws SQLException, ClassNotFoundException;
	public void modificacion(PersonaRegistrada pR) throws SQLException, ClassNotFoundException;
	public void modificarSaldo(Integer distancia, String dniPersona) throws SQLException, ClassNotFoundException;

}