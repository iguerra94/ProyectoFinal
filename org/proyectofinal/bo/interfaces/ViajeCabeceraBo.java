package org.proyectofinal.bo.interfaces;

import org.proyectofinal.dao.ex.ViajeCabeceraNotValidException;
import org.proyectofinal.dao.interfaces.ViajeCabeceraDao;
import org.proyectofinal.model.interfaces.ViajeCabecera;

public interface ViajeCabeceraBo {
	
	public void verificarTodos(ViajeCabecera vC) throws ViajeCabeceraNotValidException;	
	public ViajeCabecera retornarViaje(ViajeCabeceraDao vCDao, Integer codViaje);
}
