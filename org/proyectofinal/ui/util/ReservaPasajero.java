package org.proyectofinal.ui.util;

import java.util.List;

public class ReservaPasajero {
	
	private List<Pasajero> listPasajeros;
	
	public ReservaPasajero(){
		
	}
	
	public List<Pasajero> getListPasajeros() {
		return listPasajeros;
	}
	
	public void setListPasajeros(List<Pasajero> listPasajeros) {
		this.listPasajeros = listPasajeros;
	}
	
	public void agregarPasajero(Pasajero pasajero){
		listPasajeros.add(pasajero);
	}
	
	public void EliminarPasajero(Pasajero pasajero){
		listPasajeros.remove(pasajero);
	}

}