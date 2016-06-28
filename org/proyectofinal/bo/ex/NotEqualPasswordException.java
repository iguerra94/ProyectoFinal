package org.proyectofinal.bo.ex;

public class NotEqualPasswordException extends Exception {

	public NotEqualPasswordException(){
		
	}
	
	public String getMessage(){
		return "Las contraseñas no coinciden. Asegurese que sean iguales.";
	}
}
