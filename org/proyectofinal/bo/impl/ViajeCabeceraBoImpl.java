package org.proyectofinal.bo.impl;

import org.proyectofinal.bo.interfaces.ViajeCabeceraBo;
import org.proyectofinal.dao.ex.ViajeCabeceraNotValidException;
import org.proyectofinal.model.interfaces.ViajeCabecera;

public class ViajeCabeceraBoImpl implements ViajeCabeceraBo {

	public void verificarTodos(ViajeCabecera vC) throws ViajeCabeceraNotValidException{
		
		if (vC.getCodigoViaje() == -1 || 
			vC.getCiudadOrigen().length() == 0 || 
			vC.getPaisOrigen().length() == 0 || 
			vC.getCiudadDestino().length() == 0 || 
			vC.getPaisDestino().length() == 0 || 
			vC.getFechaSalida() == null ||
			vC.getFechaLlegada() == null ||
			vC.getHoraSalida().toString() == "00:00:00" ||
			vC.getHoraLlegada().toString() == "00:00:00" || 
			vC.getCupo() == -1){

			throw new ViajeCabeceraNotValidException();
		}
		
	}

}
