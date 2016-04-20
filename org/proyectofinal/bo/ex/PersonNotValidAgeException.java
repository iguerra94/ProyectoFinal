package org.proyectofinal.bo.ex;

public class PersonNotValidAgeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1431841553888253108L;

	public PersonNotValidAgeException(){
		
	}
	
	public String getMessage(){
		return "Debes ser mayor de 18 años para poder registrarte en el sistema.";
	}
}
