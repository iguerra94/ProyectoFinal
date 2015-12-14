package org.proyectofinal.dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.dao.ex.UserNotExistsException;
import org.proyectofinal.model.interfaces.Usuario;

public interface UsuarioDao {
	 
	public ResultSet consultarPorUsuario(Usuario u) throws SQLException, ClassNotFoundException, UserNotExistsException;

	public ResultSet consultarPorUsuario(String usuario) throws ClassNotFoundException, SQLException, UserNotExistsException;
	
	public void alta(Usuario u) throws SQLException, ClassNotFoundException;
	
	public void baja(Usuario u) throws SQLException, ClassNotFoundException;

	public void modificacion(String atr, String valor, String user) throws SQLException, ClassNotFoundException;
}