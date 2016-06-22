package org.proyectofinal.dao.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDao {
	
	public void conectar() throws ClassNotFoundException, SQLException;
	
	public void desconectar() throws SQLException;
	
	public Connection getConexion();
}