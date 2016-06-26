package org.proyectofinal.ui;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;

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
		
		agregarInfoPanelOferta1();
		agregarInfoPanelOferta2();
		agregarInfoPanelOferta3();
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