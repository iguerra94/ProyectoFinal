package org.proyectofinal.bo.interfaces;

import java.sql.SQLException;

import org.proyectofinal.bo.ex.PersonNotValidAgeException;
import org.proyectofinal.dao.ex.PersonAlreadyExistsException;
import org.proyectofinal.dao.ex.PersonNotValidException;
import org.proyectofinal.dao.interfaces.PersonaRegistradaDao;
import org.proyectofinal.model.interfaces.PersonaRegistrada;

public interface PersonaRegistradaBo {

	public void verificarTodos(PersonaRegistrada p) throws PersonNotValidException;
	public void verificarImportantes(PersonaRegistrada p) throws PersonNotValidException;
	public void verificarEdad(PersonaRegistrada p) throws PersonNotValidAgeException;
	public void registrarPersona(PersonaRegistrada p) throws ClassNotFoundException, SQLException, PersonAlreadyExistsException;
	public String retornarEmail(String dni);
	public PersonaRegistrada retornarPersonaPorUsuario(String usuario);
}