package org.proyectofinal.bo.impl;

import org.proyectofinal.bo.ex.NotValidPassengerException;
import org.proyectofinal.bo.interfaces.PasajeroBo;
import org.proyectofinal.model.interfaces.Pasajero;

public class PasajeroBoImpl implements PasajeroBo {

	public void verificarDatosPasajero(Pasajero p) throws NotValidPassengerException {
		
		if (p.getDni().length() == 0 || p.getDni() == null || 
			p.getNombre().trim().length() == 0 ||  
			p.getApellido().trim().length() == 0){ 
			
			throw new NotValidPassengerException();
		}
	}
}
