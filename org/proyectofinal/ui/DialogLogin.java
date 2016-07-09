package org.proyectofinal.ui;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import org.proyectofinal.bo.ex.UserNotExistsException;
import org.proyectofinal.bo.impl.UsuarioBoImpl;
import org.proyectofinal.bo.interfaces.UsuarioBo;
import org.proyectofinal.model.interfaces.Usuario;
import org.proyectofinal.ui.plantillasUI.PlantillaDL;
import org.proyectofinal.ui.plantillasUI.PlantillaMF;

public class DialogLogin extends PlantillaDL implements WindowListener {

	private static final long serialVersionUID = 7573163474919271943L;

	public DialogLogin() {
		inicializarAtributos();
		inicializarComponentes();
		
		addWindowListener(this);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		
		PlantillaMF ui = new MainFrameUI();
		
		ui.setLogueado(false);
		
		ui.setVisible(true);
	}

	@Override
	public void windowClosed(WindowEvent e) {

		PlantillaMF ui = new MainFrameUI();
		
		ui.setLogueado(true);
		
		ui.agregarBotonesLogueado();
		ui.agregarBotonPerfil(getUsuario().getNombreUsuario());
		
		
		UsuarioBo uBo = new UsuarioBoImpl();
		
		try {
			
			Usuario u = uBo.retornarUsuario(getUsuario().getNombreUsuario());
			
			if (u.getTipoUsuario() == 0){
				ui.agregarMenuAdmin();
				ui.getBtnPerfil().setForeground(Color.RED);
			} else {
				ui.getBtnPerfil().setForeground(Color.BLACK);
			}
		} catch (UserNotExistsException e1) {
			e1.printStackTrace();
		}
		
		ui.setVisible(true);
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