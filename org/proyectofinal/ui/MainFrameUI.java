package org.proyectofinal.ui;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

import org.proyectofinal.bo.impl.UsuarioBoImpl;
import org.proyectofinal.bo.impl.ViajeCabeceraBoImpl;
import org.proyectofinal.bo.interfaces.UsuarioBo;
import org.proyectofinal.bo.interfaces.ViajeCabeceraBo;
import org.proyectofinal.model.interfaces.ViajeCabecera;
import org.proyectofinal.ui.plantillasUI.PlantillaMF;

public class MainFrameUI extends PlantillaMF implements WindowListener, WindowFocusListener, ComponentListener {
	
	public MainFrameUI() {
		
		inicializarAtributos();
		inicializarComponentes();
		
		addWindowListener(this);
		addWindowFocusListener(this);
		addComponentListener(this);
			
		setVisible(true);
	}

	@Override
	public void windowGainedFocus(WindowEvent e) {
		
		ViajeCabeceraBo vCBo = new ViajeCabeceraBoImpl();
		
		List<ViajeCabecera> listaViajes = vCBo.retornarListaOfertas();
		
		cargarOfertas(listaViajes);		
		
		getPanelOfertas().validate();
        getPanelOfertas().repaint();
        
        pack();
	}

	@Override
	public void windowLostFocus(WindowEvent e) {		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		
		if (getLogueado()){
			agregarBotonesLogueado();	
		}else{
			agregarBotonesNoLogueado();
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		confirmarSalida();
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
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		pintarComponentes();
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
	}
}