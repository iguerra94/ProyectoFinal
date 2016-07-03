package org.proyectofinal.ui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import org.proyectofinal.bo.impl.ViajeCabeceraBoImpl;
import org.proyectofinal.bo.interfaces.ViajeCabeceraBo;
import org.proyectofinal.ui.plantillasUI.PlantillaDRF;

public class DialogSelectFlight extends PlantillaDRF implements WindowListener {
	
	public DialogSelectFlight(){
	
		inicializarAtributosSF();
		inicializarComponentesSF();
		addWindowListener(this);
		
		setVisible(true);
	}

	@Override
	public void windowOpened(WindowEvent e) {

		ViajeCabeceraBo vCBo = new ViajeCabeceraBoImpl();
		
		List<String> modeloVuelos = vCBo.retornarCodigosViaje();
		
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