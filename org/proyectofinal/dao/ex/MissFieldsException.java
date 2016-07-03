package org.proyectofinal.dao.ex;

public class MissFieldsException extends Exception {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3533001076891102793L;

	public MissFieldsException(){
		
	}
	
	public String getMessage(){
		return "Hay campos que no pueden estar vacios. Complete los campos obligatorios";
	}

}
