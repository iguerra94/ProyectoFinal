package org.proyectofinal.dao.ex;

public class ViajeCabeceraNotValidException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5289689674712157362L;

	public ViajeCabeceraNotValidException(){
		
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "El viaje ingresado no es valido. Faltan completar campos obligatorios";
	}
}
