package org.proyectofinal.ui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;

import org.proyectofinal.ui.plantillasUI.PlantillaRV;

public class ReservaBoletoUI extends PlantillaRV implements WindowListener, WindowFocusListener {

	private static final long serialVersionUID = -7926334781725184834L;

	public ReservaBoletoUI() {
		
		inicializarAtributos();
		addWindowListener(this);
		
		addWindowFocusListener(this);
	}

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
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		
	}

}