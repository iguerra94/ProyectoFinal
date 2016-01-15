package org.proyectofinal.dao.ex;

public class MissFieldsException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5431279917975862341L;

	public MissFieldsException(){
		
	}
	
	public String getMessage(){
		return "Hay campos que no pueden estar vacios. Complete los campos obligatorios";
	}

}
