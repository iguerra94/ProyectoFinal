package org.proyectofinal.dao.abstracts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.proyectofinal.dao.interfaces.IDao;

public class AbstractDao implements IDao {
	
	protected Connection conexion = null;
	
	public void conectar() throws ClassNotFoundException, SQLException{
	
		Class.forName("com.mysql.jdbc.Driver");

		this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ReservasAvion", "root", "genius34");
	}
	
	public void desconectar() throws SQLException{
		getConexion().close();
	}

	public Connection getConexion() {
		return this.conexion;
	}
	
}