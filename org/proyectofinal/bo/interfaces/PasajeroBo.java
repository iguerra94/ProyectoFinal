package org.proyectofinal.bo.interfaces;

import org.proyectofinal.bo.ex.NotValidPassengerException;
import org.proyectofinal.model.interfaces.Pasajero;

public interface PasajeroBo {
	
	public void verificarDatosPasajero(Pasajero p) throws NotValidPassengerException;

	public void agregarPasajero(Pasajero pasajero);

	public Pasajero retornarPasajero(String dniPasajero);
}
