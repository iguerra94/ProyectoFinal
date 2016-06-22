package org.proyectofinal.bo.ex;

public class ViajeCabeceraNotValidException extends Exception {

	private static final long serialVersionUID = 5289689674712157362L;

	public ViajeCabeceraNotValidException(){
		
	}
	
	@Override
	public String getMessage() {
		return "El vuelo ingresado no es valido. Faltan completar campos obligatorios";
	}
}