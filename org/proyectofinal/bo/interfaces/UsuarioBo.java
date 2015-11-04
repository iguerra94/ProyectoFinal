package org.proyectofinal.bo.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.dao.ex.UserNotCorrectException;
import org.proyectofinal.dao.ex.UserNotValidException;
import org.proyectofinal.model.interfaces.Usuario;

public interface UsuarioBo {
	
	public void verificar(Usuario u) throws UserNotValidException;

	public void verificar(String usuario) throws UserNotValidException;

	public void verificarDatosCorrectos(ResultSet res, Usuario u) throws UserNotCorrectException, SQLException, UserNotValidException;
}
