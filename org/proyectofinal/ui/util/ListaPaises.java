package org.proyectofinal.ui.util;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ListaPaises {
	
	private static List<PaisUtil> paises = null;
	
	public ListaPaises(){
		
		paises = new ArrayList<PaisUtil>();
		
		cargarPaises();	
	}
	
	public List<PaisUtil> getListaPaises(){
		return paises;
	}
	
	public PaisUtil inicializarPais(String pais, String shortPais){
		
		PaisUtil p = new PaisUtil(pais, shortPais);
		
		return p;
	}
	
	public void cargarPaises(){
		paises.add(inicializarPais("Argentina", "ARG"));
		paises.add(inicializarPais("Brasil", "BRA"));
		paises.add(inicializarPais("Estados Unidos", "USA"));
		paises.add(inicializarPais("Uruguay", "URY"));
	}
	
}
