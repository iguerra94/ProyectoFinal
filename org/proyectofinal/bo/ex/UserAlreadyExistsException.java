package org.proyectofinal.bo.ex;

public class UserAlreadyExistsException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3030102998950032560L;

	public UserAlreadyExistsException(){
		
	}

	public String getMessage(){
		return "El usuario ingresado ya existe en el sistema.";
	}
}
