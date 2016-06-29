package org.proyectofinal.ui;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;

import org.proyectofinal.ui.plantillasUI.PlantillaDL;
import org.proyectofinal.ui.plantillasUI.PlantillaMF;

public class DialogLogin extends PlantillaDL implements WindowListener {

	public DialogLogin() {
		
		inicializarAtributos();
		inicializarComponentes();
		
		addWindowListener(this);
		
		setVisible(true);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		PlantillaMF ui = new MainFrameUI();
		ui.setLogueado(false);
	}

	@Override
	public void windowClosed(WindowEvent e) {

		PlantillaMF ui = new MainFrameUI();
		
		ui.setLogueado(true);

		ui.setBtnPerfil(new JButton(""));
		
		ui.getBtnPerfil().setText(getUsuario().getNombreUsuario());
		
		if (getUsuario().getTipoUsuario() == 0){
			ui.agregarMenuAdmin();
			ui.getBtnPerfil().setForeground(Color.RED);
		}else if (getUsuario().getTipoUsuario() == 1){
			ui.getBtnPerfil().setForeground(Color.BLACK);
		}
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
