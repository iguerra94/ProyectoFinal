package org.proyectofinal.bo.interfaces;

import org.proyectofinal.bo.ex.NotValidPassengerException;
import org.proyectofinal.model.interfaces.ReservaViaje;

public interface ReservaViajeBo {
	
	public void verificarReserva(ReservaViaje rV) throws NotValidPassengerException;
}
