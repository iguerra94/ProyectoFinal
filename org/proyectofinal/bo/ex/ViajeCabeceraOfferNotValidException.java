package org.proyectofinal.bo.ex;

public class ViajeCabeceraOfferNotValidException extends Exception {
	
	public ViajeCabeceraOfferNotValidException(){
		
	}
	
	
	@Override
	public String getMessage() {
		return "La oferta ingresada no es valida. Faltan completar campos obligatorios";
	}
	
}