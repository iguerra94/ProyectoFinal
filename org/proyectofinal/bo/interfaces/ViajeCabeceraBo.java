package org.proyectofinal.bo.interfaces;

import java.util.List;

import org.proyectofinal.bo.ex.ViajeCabeceraNotValidException;
import org.proyectofinal.dao.ex.NoFlightsFoundException;
import org.proyectofinal.model.interfaces.ViajeCabecera;

public interface ViajeCabeceraBo {
	
	public void verificarTodos(ViajeCabecera vC) throws ViajeCabeceraNotValidException;
	public void verificarImportantesConFecha(ViajeCabecera vC) throws ViajeCabeceraNotValidException;		
	public void verificarImportantesSinFecha(ViajeCabecera vC) throws ViajeCabeceraNotValidException;		
	public ViajeCabecera retornarViaje(String codViaje);
	public List<String> retornarOrigenes();
	public List<String> retornarDestinos();
	public List<ViajeCabecera> retornarVuelosPorFecha(ViajeCabecera vC) throws NoFlightsFoundException;
	public List<ViajeCabecera> retornarVuelosCualquierFecha(ViajeCabecera vC) throws NoFlightsFoundException;
	public void actualizarCupo(ViajeCabecera viaje);
	public String[] retornarCodigosViaje();
	public void cargarVuelo(ViajeCabecera vC);
	public void eliminarVuelo(String codigo);
}