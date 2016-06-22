package org.proyectofinal.bo.interfaces;

import java.sql.SQLException;

import org.proyectofinal.dao.ex.UserAlreadyExistsException;
import org.proyectofinal.dao.ex.UserNotCorrectException;
import org.proyectofinal.dao.ex.UserNotExistsException;
import org.proyectofinal.dao.ex.UserNotValidException;
import org.proyectofinal.model.interfaces.Usuario;

public interface UsuarioBo {
	
	public void verificar(Usuario u) throws UserNotValidException;

	public void verificarUsuario(String usuario) throws UserNotValidException;

	public void verificarDatosCorrectos(Usuario u) throws UserNotCorrectException;

	public void registrarUsuario(Usuario u) throws ClassNotFoundException, SQLException, UserAlreadyExistsException;

	public String recuperarPass(String usuario) throws ClassNotFoundException, SQLException, UserNotExistsException;
}