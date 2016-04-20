package org.proyectofinal.bo.impl;

import java.sql.Date;

import org.proyectofinal.bo.ex.PersonNotValidAgeException;
import org.proyectofinal.bo.interfaces.PersonaBo;
import org.proyectofinal.dao.ex.PersonNotValidException;
import org.proyectofinal.model.interfaces.Persona;

public class PersonaBoImpl implements PersonaBo {
	
	public PersonaBoImpl(){
		
	}
	
	public void verificarTodos(Persona p) throws PersonNotValidException{
		
		if (p.getDni() == null || p.getNombre() == null || p.getApellido() == null || 
			p.getEmail() == null || p.getFechaNacimiento() == null || p.getTelefono() == null ||
			p.getPais() == null || p.getCiudad() == null){
			
			throw new PersonNotValidException();
		}
		
	}
	
	public void verificarImportantes(Persona p) throws PersonNotValidException {
	
		if (p.getDni() == null || p.getDni().length() == 0 || p.getNombre() == null || p.getNombre().length() == 0 || p.getApellido() == null || 
			p.getApellido().length() == 0 || p.getEmail() == null || p.getEmail().length() == 0){
			
			throw new PersonNotValidException();
		}
		
	}
	
	public void verificarEdad(Persona p) throws PersonNotValidAgeException {
		
		Integer edad = null;
		
		Integer anioNacimiento = Integer.parseInt(p.getFechaNacimiento().toString().substring(0, 4));
		Integer mesNacimiento = Integer.parseInt(p.getFechaNacimiento().toString().substring(5, 7));

		java.util.Date now = new java.util.Date();
		
		Date date = new Date(now.getTime());
		
		Integer anioActual = Integer.parseInt(date.toString().substring(0, 4));
		Integer mesActual = Integer.parseInt(date.toString().substring(5, 7));
		
		if (mesActual < mesNacimiento){
			edad = anioActual-anioNacimiento-1;
		}else{
			edad = anioActual-anioNacimiento;
		}
		
		if (edad < 18){
			throw new PersonNotValidAgeException();
		}

	}
	
}