package org.proyectofinal.bo.impl;

import org.proyectofinal.bo.ex.NotValidPassengerException;
import org.proyectofinal.bo.interfaces.ReservaViajeBo;
import org.proyectofinal.model.interfaces.ReservaViaje;

public class ReservaViajeBoImpl implements ReservaViajeBo {
	
	public void verificarReserva(ReservaViaje rV) throws NotValidPassengerException {
		if (rV.getAsiento() == -1){ throw new NotValidPassengerException(); }
	}

}
