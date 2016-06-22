package org.proyectofinal.dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.dao.ex.UserAlreadyExistsException;
import org.proyectofinal.dao.ex.UserNotExistsException;
import org.proyectofinal.model.interfaces.Usuario;

public interface UsuarioDao {
	 
	public ResultSet consultarPorUsuario(Usuario u) throws SQLException, ClassNotFoundException;
	public ResultSet consultarPorUsuario(String usuario) throws ClassNotFoundException, SQLException, UserNotExistsException;
	public void alta(Usuario u) throws SQLException, ClassNotFoundException, UserAlreadyExistsException;
	public void baja(Usuario u) throws SQLException, ClassNotFoundException;
	public void modificacionNombreUsuario(String valor, String user) throws SQLException, ClassNotFoundException, UserAlreadyExistsException;
	public void modificacionContrasenia(String valor, String user) throws SQLException, ClassNotFoundException;		
}