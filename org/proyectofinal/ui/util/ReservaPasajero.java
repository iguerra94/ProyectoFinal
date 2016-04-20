package org.proyectofinal.ui.util;

import java.util.ArrayList;
import java.util.List;

public class ReservaPasajero {
	
	private List<Pasajero> listPasajeros;
	
	public ReservaPasajero(){
		listPasajeros = new ArrayList<Pasajero>();
	}
	
	public List<Pasajero> getListPasajeros() {
		return this.listPasajeros;
	}
	
	public void setListPasajeros(List<Pasajero> listPasajeros) {
		this.listPasajeros = listPasajeros;
	}
	
	public void agregarPasajero(Pasajero pasajero){
		getListPasajeros().add(pasajero);
	}
	
	public void eliminarPasajero(Integer indice){
		
		Pasajero p = this.getListPasajeros().get(indice);
		
		this.getListPasajeros().remove(p);
	}
	
}