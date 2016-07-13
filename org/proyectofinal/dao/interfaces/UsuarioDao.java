package org.proyectofinal.dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.model.interfaces.Usuario;

/**
 * Interfaz del DAO Usuario.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public interface UsuarioDao {
	 
	public void conectar() throws ClassNotFoundException, SQLException;
	public void desconectar() throws SQLException;
	public ResultSet consultar() throws ClassNotFoundException, SQLException;
	public ResultSet consultarPorUsuario(Usuario u) throws SQLException, ClassNotFoundException;
	public ResultSet consultarPorUsuario(String usuario) throws ClassNotFoundException, SQLException;
	public ResultSet consultarDniPorUsuario(String usuario) throws SQLException;
	public void alta(Usuario u) throws SQLException, ClassNotFoundException;
	public void modificacionContrasenia(String contrasenia, String usuario) throws SQLException, ClassNotFoundException;
	public void baja(Usuario u) throws SQLException, ClassNotFoundException;

}