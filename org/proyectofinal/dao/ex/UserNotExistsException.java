package org.proyectofinal.dao.ex;

public class UserNotExistsException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8441762609979567803L;

	public UserNotExistsException(){
		
	}
	
	public String getMessage(){
		return "El usuario ingresado no existe en la base de datos.";
	}

}
