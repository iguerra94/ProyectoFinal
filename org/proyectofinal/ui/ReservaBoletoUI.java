package org.proyectofinal.ui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import org.proyectofinal.ui.plantillasUI.PlantillaRV;

public class ReservaBoletoUI extends PlantillaRV implements WindowFocusListener {

	private static final long serialVersionUID = -7926334781725184834L;

	public ReservaBoletoUI() {
		
		inicializarAtributos();
		
		addWindowFocusListener(this);
	}

	@Override
	public void windowGainedFocus(WindowEvent e) {
		accionesCmbCantPasajerosAlTenerFocoLaVentana();
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		
	}

}