package org.proyectofinal.ui;

import org.proyectofinal.model.interfaces.ViajeCabecera;
import org.proyectofinal.ui.plantillasUI.PlantillaDLF;

public class DialogAlterFlight extends PlantillaDLF {
	
	public DialogAlterFlight(ViajeCabecera viaje) {
	
		inicializarAtributosAF();
		inicializarComponentesAF(viaje);
		
		setVisible(true);
	}
	
}