package org.proyectofinal.ui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.JOptionPane;

import org.proyectofinal.bo.ex.NotOffersFoundException;
import org.proyectofinal.bo.impl.ViajeCabeceraBoImpl;
import org.proyectofinal.bo.interfaces.ViajeCabeceraBo;
import org.proyectofinal.ui.plantillasUI.PlantillaDRF;
import org.proyectofinal.ui.plantillasUI.PlantillaDRO;

public class DialogRemoveOffer extends PlantillaDRO implements WindowListener {
	
	public DialogRemoveOffer(){
	
		inicializarAtributosRO();
		inicializarComponentesRO();
		addWindowListener(this);
		
		setVisible(true);
	}

	@Override
	public void windowOpened(WindowEvent e) {

		ViajeCabeceraBo vCBo = new ViajeCabeceraBoImpl();
		
		List<String> modeloOfertas;
		
		try {
		
			modeloOfertas = vCBo.retornarOfertas();
			
			cargarOfertas(modeloOfertas);
	
		} catch (NotOffersFoundException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		
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