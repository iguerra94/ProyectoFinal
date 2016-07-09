package org.proyectofinal.ui;

import org.proyectofinal.model.interfaces.ViajeCabecera;
import org.proyectofinal.ui.plantillasUI.PlantillaDLF;

public class DialogAlterFlight extends PlantillaDLF {
	
	private static final long serialVersionUID = 7758607405909809949L;

	public DialogAlterFlight(ViajeCabecera viaje) {
		inicializarAtributosAF();
		inicializarComponentesAF(viaje);
	}
	
}