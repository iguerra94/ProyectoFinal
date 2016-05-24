package org.proyectofinal.dao.ex;

public class PersonAlreadyExistsException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3281455937178533639L;

	public PersonAlreadyExistsException(){
		
	}
	
	public String getMessage(){
		return "La persona ingresada ya existe en el sistema.";
	}

}
