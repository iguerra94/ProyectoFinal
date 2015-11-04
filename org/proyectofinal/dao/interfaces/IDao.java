package org.proyectofinal.dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDao {
	
	public void conectar() throws ClassNotFoundException, SQLException;
	
	public void desconectar() throws SQLException;
	
	public ResultSet consultar() throws SQLException, ClassNotFoundException;
}