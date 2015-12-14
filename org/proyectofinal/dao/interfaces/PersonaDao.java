package org.proyectofinal.dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.model.interfaces.Persona;
import org.proyectofinal.model.interfaces.Usuario;

public interface PersonaDao {
	
	public ResultSet consultarPorDni(Persona p) throws SQLException, ClassNotFoundException;
	
	public ResultSet consultarPorUsuario(Usuario u) throws SQLException, ClassNotFoundException;

	public ResultSet consultarPorUsuario(String u) throws SQLException, ClassNotFoundException;

	public void alta(Persona p) throws SQLException, ClassNotFoundException;

	public void baja(Persona p) throws SQLException, ClassNotFoundException;

	public void modificacion(String atr, String valor, String dni) throws SQLException, ClassNotFoundException;
}