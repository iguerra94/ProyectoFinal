package org.proyectofinal.ui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;

import org.proyectofinal.ui.plantillasUI.PlantillaRV;

public class ReservaBoletoUI extends PlantillaRV implements WindowListener, WindowFocusListener {

	public ReservaBoletoUI() {
		inicializarAtributos();
		inicializarComponentes();
		addWindowListener(this);
		addWindowFocusListener(this);
	}


	@Override
	public void windowOpened(WindowEvent e) {
		
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

	@Override
	public void windowGainedFocus(WindowEvent e) {
		accionesCmbCantPasajerosAlTenerFocoLaVentana();
//		setearNombre();
//		setearApellido();
//		setearDni();
//		setearAsientoYPrecio();
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		
	}

}