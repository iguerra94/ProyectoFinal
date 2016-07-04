package org.proyectofinal.dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.bo.ex.UserAlreadyExistsException;
import org.proyectofinal.model.interfaces.Usuario;

public interface UsuarioDao {
	 
	public void conectar() throws ClassNotFoundException, SQLException;
	public void desconectar() throws SQLException;
	public ResultSet consultarPorUsuario(Usuario u) throws SQLException, ClassNotFoundException;
	public ResultSet consultarPorUsuario(String usuario) throws ClassNotFoundException, SQLException;
	public void alta(Usuario u) throws SQLException, ClassNotFoundException, UserAlreadyExistsException;
	public void baja(Usuario u) throws SQLException, ClassNotFoundException;
	public void modificacionNombreUsuario(String valor, String user) throws SQLException, ClassNotFoundException, UserAlreadyExistsException;
	public void modificacionContrasenia(String contrasenia, String usuario) throws SQLException, ClassNotFoundException;
	public ResultSet consultarDniPorUsuario(String usuario) throws SQLException;
			
}