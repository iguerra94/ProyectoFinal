package org.proyectofinal.bo.interfaces;

import org.proyectofinal.dao.ex.PersonNotValidException;
import org.proyectofinal.model.interfaces.Persona;

public interface PersonaBo {

	public void verificarTodos(Persona p) throws PersonNotValidException;
	public void verificarImportantes(Persona p) throws PersonNotValidException;

}