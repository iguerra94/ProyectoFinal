package org.proyectofinal.ui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import org.proyectofinal.bo.impl.ViajeCabeceraBoImpl;
import org.proyectofinal.bo.interfaces.ViajeCabeceraBo;
import org.proyectofinal.ui.plantillasUI.PlantillaDRF;

public class DialogRemoveFlight extends PlantillaDRF implements WindowListener {
	
	public DialogRemoveFlight(){
	
		inicializarAtributos();
		inicializarComponentes();
		addWindowListener(this);
		
		setVisible(true);
	}

	@Override
	public void windowOpened(WindowEvent e) {

		ViajeCabeceraBo vCBo = new ViajeCabeceraBoImpl();
		
		String[] modeloVuelos = vCBo.retornarCodigosViaje();
		
		cargarVuelos(modeloVuelos);
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