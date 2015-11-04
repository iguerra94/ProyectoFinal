package org.proyectofinal.bo.impl;

import org.proyectofinal.bo.interfaces.PersonaBo;
import org.proyectofinal.dao.ex.PersonNotValidException;
import org.proyectofinal.model.interfaces.Persona;

public class PersonaBoImpl implements PersonaBo {
	
	public PersonaBoImpl(){
		
	}
	
	public void verificar(Persona p) throws PersonNotValidException{
		
		if (p.getDni() == null || p.getNombre() == null || p.getApellido() == null || 
			p.getEmail() == null || p.getFechaNacimiento() == null || p.getTelefono() == null ||
			p.getPais() == null || p.getCiudad() == null){
			
			throw new PersonNotValidException();
		}
		
	}
	
}