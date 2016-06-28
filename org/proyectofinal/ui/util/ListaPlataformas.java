package org.proyectofinal.ui.util;

import java.util.ArrayList;
import java.util.List;

public class ListaPlataformas {
	
	private static List<PlataformaUtil> plataformas = null;
	
	public ListaPlataformas(){
		
		plataformas = new ArrayList<PlataformaUtil>();
		
		cargarPlataformas();	
	}
	
	public List<PlataformaUtil> getListaPlataformas(){
		return plataformas;
	}
	
	public PlataformaUtil inicializarPlataforma(String plataforma, String ciudad){
		
		PlataformaUtil p = new PlataformaUtil(plataforma, ciudad);
		
		return p;
	}
	
	public void cargarPlataformas(){
		plataformas.add(inicializarPlataforma("AEP", "Buenos Aires"));
		plataformas.add(inicializarPlataforma("EZE", "Buenos Aires"));
		plataformas.add(inicializarPlataforma("COR", "Cordoba"));
		plataformas.add(inicializarPlataforma("MIA", "Miami"));
		plataformas.add(inicializarPlataforma("SFO", "San Francisco"));
		plataformas.add(inicializarPlataforma("FCO", "Roma"));
	}
	
}
