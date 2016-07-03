package org.proyectofinal.dao.ex;

public class UserNotValidException extends Exception {

	private static final long serialVersionUID = -7798071003952352001L;

	public UserNotValidException(){
		
	}
	
	public String getMessage(){
		return "El usuario no es valido. Faltan ingresar campos obligatorios";
	}

}