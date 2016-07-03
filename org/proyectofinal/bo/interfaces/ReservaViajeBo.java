package org.proyectofinal.bo.interfaces;

import java.util.List;

import org.proyectofinal.bo.ex.NotValidPassengerException;
import org.proyectofinal.model.interfaces.ReservaViaje;
import org.proyectofinal.model.interfaces.ViajeCabecera;

public interface ReservaViajeBo {
	
	public void verificarReserva(ReservaViaje rV) throws NotValidPassengerException;
	public List<Integer> controlarAsientosOcupados(ViajeCabecera viaje);		
	public void agregarReserva(ReservaViaje reservaViaje);
	public Integer retornarCantidadDeReservas(String dni);
	public List<ReservaViaje> retornarReservasSegunDni(String dni);
}
