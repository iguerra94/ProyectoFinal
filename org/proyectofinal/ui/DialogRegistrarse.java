package org.proyectofinal.ui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import org.proyectofinal.ui.plantillasUI.PlantillaDR;

public class DialogRegistrarse extends PlantillaDR implements WindowFocusListener {
	
	private static final long serialVersionUID = 8710372283429686677L;
	
	public DialogRegistrarse() {

		inicializarAtributos();
		agregarPanePersona();
		agregarPaneUsuario();
		agregarBotones();
		addWindowFocusListener(this);
		
		setVisible(true);
	}

	@Override
	public void windowGainedFocus(WindowEvent e) {
		cargarPaises();
		actualizarComboCiudad();
		establecerFecha();
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		
	}

}