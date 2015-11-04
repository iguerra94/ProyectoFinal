package org.proyectofinal.dao.ex;

public class UserNotCorrectException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1360312902153430187L;

	public UserNotCorrectException(){
		
	}
	
	public String getMessage(){
		return "Los datos ingresados, usuario, contraseña o tipo de usuario no son correctos.";
	}

}