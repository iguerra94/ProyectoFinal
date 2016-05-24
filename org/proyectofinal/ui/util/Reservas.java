package org.proyectofinal.ui.util;

import java.util.ArrayList;
import java.util.List;
import org.proyectofinal.model.interfaces.ReservaViaje;

public class Reservas{
	
	private List<ReservaViaje> listReservas;
	
	public Reservas(){
		setListReservas(new ArrayList<ReservaViaje>());
	}
	
	public List<ReservaViaje> getListReservas() {
		return this.listReservas;
	}
	
	public void setListReservas(List<ReservaViaje> listReservas) {
		this.listReservas = listReservas;
	}

	public void agregarReserva(ReservaViaje rV){
		getListReservas().add(rV);
	}
	
	public void eliminarReserva(Integer indice){
		
		ReservaViaje rV = this.getListReservas().get(indice);
		
		this.getListReservas().remove(rV);
	}
	
}