package org.proyectofinal.ui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import org.proyectofinal.ui.plantillasUI.PlantillaDLF;

public class DialogLoadFlight extends PlantillaDLF implements WindowListener {

	private static final long serialVersionUID = 1765228890572535013L;

	public DialogLoadFlight() {
		inicializarAtributosLF();
		inicializarComponentesLF();
		
		addWindowListener(this);
	}

	
	@Override
	public void windowOpened(WindowEvent e) {
		cargarPaisesOrigen();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}
	
}