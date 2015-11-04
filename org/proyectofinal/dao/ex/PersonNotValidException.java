package org.proyectofinal.dao.ex;

public class PersonNotValidException extends Exception {

	private static final long serialVersionUID = -7798071003952352001L;

	public PersonNotValidException(){
		
	}
	
	public String getMessage(){
		return "La persona no es valida. Faltan ingresar campos obligatorios";
	}

}
