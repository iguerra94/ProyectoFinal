package org.proyectofinal.bo.interfaces;

import java.util.List;

import org.proyectofinal.bo.ex.NoFlightsFoundException;
import org.proyectofinal.bo.ex.NotOffersFoundException;
import org.proyectofinal.bo.ex.ViajeCabeceraNotValidException;
import org.proyectofinal.bo.ex.ViajeCabeceraOfferNotValidException;
import org.proyectofinal.model.interfaces.ViajeCabecera;

public interface ViajeCabeceraBo {
	
	public void verificarTodos(ViajeCabecera vC) throws ViajeCabeceraNotValidException;
	public void verificarImportantesConFecha(ViajeCabecera vC) throws ViajeCabeceraNotValidException;		
	public void verificarImportantesSinFecha(ViajeCabecera vC) throws ViajeCabeceraNotValidException;		
	public void verificarOferta(ViajeCabecera vC) throws ViajeCabeceraOfferNotValidException;
	public ViajeCabecera retornarViaje(String codViaje);
	public List<String> retornarOrigenes();
	public List<String> retornarDestinos();
	public List<String> retornarOrigenesDestinos();
	public List<String> retornarOfertas() throws NotOffersFoundException;
	public List<ViajeCabecera> retornarListaOfertas();
	public List<ViajeCabecera> retornarVuelosPorFecha(ViajeCabecera vC) throws NoFlightsFoundException;
	public List<ViajeCabecera> retornarVuelosCualquierFecha(ViajeCabecera vC) throws NoFlightsFoundException;
	public void actualizarCupo(ViajeCabecera viaje);
	public List<String> retornarCodigosViaje();
	public void cargarVuelo(ViajeCabecera vC);
	public void eliminarVuelo(String codigo);
	public void modificarVuelo(ViajeCabecera vC);
	public void cargarOferta(ViajeCabecera vC);
	public void eliminarOferta(ViajeCabecera vC);

}