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
	
	public CiudadUtil inicializarCiudad(String ciudad, String shortPais, Boolean enVuelos){
		
		CiudadUtil c = new CiudadUtil(ciudad, shortPais, enVuelos);
		
		return c;
	}
	
	public void cargarCiudades(){
	
		ciudades.add(inicializarCiudad("Buenos Aires", "ARG", true));
		ciudades.add(inicializarCiudad("Catamarca", "ARG", false));
		ciudades.add(inicializarCiudad("Chaco", "ARG", false));
		ciudades.add(inicializarCiudad("Chubut", "ARG", false));
		ciudades.add(inicializarCiudad("Cordoba", "ARG", true));
		ciudades.add(inicializarCiudad("Corrientes", "ARG", false));
		ciudades.add(inicializarCiudad("Entre Rios", "ARG", false));
		ciudades.add(inicializarCiudad("Formosa", "ARG", false));
		ciudades.add(inicializarCiudad("Jujuy", "ARG", false));
		ciudades.add(inicializarCiudad("La Pampa", "ARG", false));
		ciudades.add(inicializarCiudad("La Rioja", "ARG", false));
		ciudades.add(inicializarCiudad("Mendoza", "ARG", true));
		ciudades.add(inicializarCiudad("Misiones", "ARG", false));
		ciudades.add(inicializarCiudad("Neuquen", "ARG", false));
		ciudades.add(inicializarCiudad("Río Negro", "ARG", false));
		ciudades.add(inicializarCiudad("Rosario, Santa Fe", "ARG", true));
		ciudades.add(inicializarCiudad("Salta", "ARG", true));
		ciudades.add(inicializarCiudad("San Juan", "ARG", false));
		ciudades.add(inicializarCiudad("San Luis", "ARG", false));
		ciudades.add(inicializarCiudad("San Miguel de Tucuman", "ARG", true));
		ciudades.add(inicializarCiudad("Santa Cruz", "ARG", false));
		ciudades.add(inicializarCiudad("Santiago del Estero", "ARG", false));
		ciudades.add(inicializarCiudad("Tierra del Fuego", "ARG", false));

		ciudades.add(inicializarCiudad("Buzios", "BRA", true));
		ciudades.add(inicializarCiudad("Florianopolis", "BRA", true));
		ciudades.add(inicializarCiudad("Rio de Janeiro", "BRA", true));
		ciudades.add(inicializarCiudad("San Pablo", "BRA", true));
		
		ciudades.add(inicializarCiudad("Cancun", "MEX", true));
		ciudades.add(inicializarCiudad("Ciudad de Mexico", "MEX", true));
		ciudades.add(inicializarCiudad("Playa del Carmen", "MEX", true));

		ciudades.add(inicializarCiudad("Los Angeles", "USA", true));
		ciudades.add(inicializarCiudad("Miami", "USA", true));
		ciudades.add(inicializarCiudad("Nueva York", "USA", true));
		ciudades.add(inicializarCiudad("San Francisco", "USA", true));
		ciudades.add(inicializarCiudad("Washington", "USA", true));

		ciudades.add(inicializarCiudad("Sydney", "AUS", true));

		ciudades.add(inicializarCiudad("Auckland", "NZL", true));

		ciudades.add(inicializarCiudad("Bogota", "COL", true));
		ciudades.add(inicializarCiudad("Cali", "COL", true));
		ciudades.add(inicializarCiudad("Medellin", "COL", true));

		ciudades.add(inicializarCiudad("Madrid", "ESP", true));
		
		ciudades.add(inicializarCiudad("Paris", "FRA", true));
		
		ciudades.add(inicializarCiudad("Londres", "GBR", true));
		
		ciudades.add(inicializarCiudad("Milan", "ITA", true));
		ciudades.add(inicializarCiudad("Roma", "ITA", true));
	}
	
}