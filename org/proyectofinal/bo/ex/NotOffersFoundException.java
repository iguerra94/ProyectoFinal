package org.proyectofinal.bo.ex;

public class NotOffersFoundException extends Exception {
	
	public NotOffersFoundException(){
		
	}
	
	public String getMessage(){
		return "No se han encontrado ofertas en el sistema.";
	}

}
