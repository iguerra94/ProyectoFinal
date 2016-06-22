package org.proyectofinal.ui.util;

import java.util.ArrayList;
import java.util.List;

public class ListaCiudades {
	
	private static List<CiudadUtil> ciudades = null;
	
	public ListaCiudades(){
		
		ciudades = new ArrayList<CiudadUtil>();
		
		cargarCiudades();	
	}
	
	public List<CiudadUtil> getListaCiudades(){
		return ciudades;
	}
	
	public CiudadUtil inicializarCiudad(String ciudad, String shortPais){
		
		CiudadUtil c = new CiudadUtil(ciudad, shortPais);
		
		return c;
	}
	
	public void cargarCiudades(){
		ciudades.add(inicializarCiudad("Buenos Aires", "ARG"));
		ciudades.add(inicializarCiudad("Catamarca", "ARG"));
		ciudades.add(inicializarCiudad("Chaco", "ARG"));
		ciudades.add(inicializarCiudad("Chubut", "ARG"));
		ciudades.add(inicializarCiudad("Cordoba", "ARG"));
		ciudades.add(inicializarCiudad("Corrientes", "ARG"));
		ciudades.add(inicializarCiudad("Entre Ríos", "ARG"));
		ciudades.add(inicializarCiudad("Formosa", "ARG"));
		ciudades.add(inicializarCiudad("Jujuy", "ARG"));
		ciudades.add(inicializarCiudad("La Pampa", "ARG"));
		ciudades.add(inicializarCiudad("La Rioja", "ARG"));
		ciudades.add(inicializarCiudad("Mendoza", "ARG"));
		ciudades.add(inicializarCiudad("Misiones", "ARG"));
		ciudades.add(inicializarCiudad("Neuquén", "ARG"));
		ciudades.add(inicializarCiudad("Río Negro", "ARG"));
		ciudades.add(inicializarCiudad("Salta", "ARG"));
		ciudades.add(inicializarCiudad("San Juan", "ARG"));
		ciudades.add(inicializarCiudad("San Luis", "ARG"));
		ciudades.add(inicializarCiudad("Santa Cruz", "ARG"));
		ciudades.add(inicializarCiudad("Santa Fe", "ARG"));
		ciudades.add(inicializarCiudad("Santiago del Estero", "ARG"));
		ciudades.add(inicializarCiudad("Tierra del Fuego", "ARG"));
		ciudades.add(inicializarCiudad("Tucumán", "ARG"));
		ciudades.add(inicializarCiudad("Los Angeles", "USA"));
		ciudades.add(inicializarCiudad("San Diego", "USA"));
		ciudades.add(inicializarCiudad("Medellin", "COL"));
		ciudades.add(inicializarCiudad("Bogotá", "COL"));
		ciudades.add(inicializarCiudad("Miami", "USA"));
		ciudades.add(inicializarCiudad("Madrid", "ESP"));
		ciudades.add(inicializarCiudad("Paris", "FRA"));
		ciudades.add(inicializarCiudad("Milan", "ITA"));
		ciudades.add(inicializarCiudad("Roma", "ITA"));
	}
	
}