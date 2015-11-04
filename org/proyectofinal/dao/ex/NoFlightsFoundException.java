package org.proyectofinal.dao.ex;

public class NoFlightsFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5431279917975862341L;

	public NoFlightsFoundException(){
		
	}
	
	public String getMessage(){
		return "No se han encontrado vuelos con los parametros ingresados.";
	}

}
