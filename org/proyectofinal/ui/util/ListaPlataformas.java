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
		
		plataformas.add(inicializarPlataforma("MDZ", "Mendoza"));
		
		plataformas.add(inicializarPlataforma("ROS", "Rosario, Santa Fe"));
		
		plataformas.add(inicializarPlataforma("SLA", "Salta"));
		
		plataformas.add(inicializarPlataforma("TUC", "San Miguel de Tucuman"));

		plataformas.add(inicializarPlataforma("GIG", "Buzios"));
		plataformas.add(inicializarPlataforma("SDU", "Buzios"));
		
		plataformas.add(inicializarPlataforma("FLN", "Florianopolis"));
		
		plataformas.add(inicializarPlataforma("GIG", "Rio de Janeiro"));
		plataformas.add(inicializarPlataforma("SDU", "Rio de Janeiro"));

		plataformas.add(inicializarPlataforma("GRU", "San Pablo"));
		
		plataformas.add(inicializarPlataforma("CUN", "Cancun"));
		
		plataformas.add(inicializarPlataforma("MEX", "Ciudad de Mexico"));
		
		plataformas.add(inicializarPlataforma("CUN", "Playa del Carmen"));

		plataformas.add(inicializarPlataforma("LAX", "Los Angeles"));

		plataformas.add(inicializarPlataforma("MIA", "Miami"));
		
		plataformas.add(inicializarPlataforma("JFK", "Nueva York"));
		plataformas.add(inicializarPlataforma("LGA", "Nueva York"));
		
		plataformas.add(inicializarPlataforma("SFO", "San Francisco"));
		
		plataformas.add(inicializarPlataforma("BWI", "Washington"));
		plataformas.add(inicializarPlataforma("DCA", "Washington"));
		plataformas.add(inicializarPlataforma("IAD", "Washington"));
		
		plataformas.add(inicializarPlataforma("SYD", "Sydney"));
		
		plataformas.add(inicializarPlataforma("AKL", "Auckland"));
		
		plataformas.add(inicializarPlataforma("BOG", "Bogota"));
		
		plataformas.add(inicializarPlataforma("CLO", "Cali"));
		
		plataformas.add(inicializarPlataforma("MDE", "Medellin"));
		
		plataformas.add(inicializarPlataforma("MAD", "Madrid"));
		
		plataformas.add(inicializarPlataforma("CDG", "Paris"));
		
		plataformas.add(inicializarPlataforma("LCY", "Londres"));
		plataformas.add(inicializarPlataforma("LHR", "Londres"));

		plataformas.add(inicializarPlataforma("MXP", "Milan"));
		
		plataformas.add(inicializarPlataforma("FCO", "Roma"));
	}
	
}