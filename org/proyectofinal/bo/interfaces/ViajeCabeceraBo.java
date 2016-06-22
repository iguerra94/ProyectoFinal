package org.proyectofinal.bo.interfaces;

import java.util.List;

import org.proyectofinal.bo.ex.ViajeCabeceraNotValidException;
import org.proyectofinal.dao.ex.NoFlightsFoundException;
import org.proyectofinal.model.interfaces.ViajeCabecera;

public interface ViajeCabeceraBo {
	
	public void verificarTodos(ViajeCabecera vC) throws ViajeCabeceraNotValidException;
	public void verificarImportantes(ViajeCabecera vC) throws ViajeCabeceraNotValidException;		
	public ViajeCabecera retornarViaje(String codViaje);
	public List<String> retornarOrigenes();
	public List<String> retornarDestinos();
	public List<ViajeCabecera> retornarVuelos(ViajeCabecera vC) throws NoFlightsFoundException;
}