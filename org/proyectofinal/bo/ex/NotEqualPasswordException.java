package org.proyectofinal.bo.ex;

public class NotEqualPasswordException extends Exception {

	public NotEqualPasswordException(){
		
	}
	
	/**
	 * Excepcion de negocio que lanza un mensaje descriptivo cuando las contraseñas no coinciden al cambiar la clave.
	 */
	public String getMessage(){
		return "Las contraseñas no coinciden. Asegurese que sean iguales.";
	}
}
