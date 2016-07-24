package org.proyectofinal.ui;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import org.proyectofinal.bo.ex.UserNotExistsException;
import org.proyectofinal.bo.impl.UsuarioBoImpl;
import org.proyectofinal.bo.interfaces.UsuarioBo;
import org.proyectofinal.model.interfaces.Usuario;
import org.proyectofinal.model.interfaces.ViajeCabecera;
import org.proyectofinal.ui.plantillasUI.PlantillaDL;
import org.proyectofinal.ui.plantillasUI.PlantillaMF;

public class DialogLogin extends PlantillaDL implements WindowListener, WindowFocusListener {

	private static final long serialVersionUID = 7573163474919271943L;

	private String mensaje = null;
	private ViajeCabecera viaje = null;
	private Boolean acumula = null;
	
	public DialogLogin(String mensaje) {
		inicializarAtributos();
		inicializarComponentes();
		
		this.setMensaje(mensaje);
		
		addWindowListener(this);
		addWindowFocusListener(this);
	}

	public DialogLogin(String mensaje, ViajeCabecera viaje, Boolean acumula) {

		this.setMensaje(mensaje);
		this.setViaje(viaje);
		this.setAcumula(acumula);
		
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
		
		ui.agregarBotonPerfil(getUsuario().getNombreUsuario());
		ui.agregarBotonesLogueado();
		
		UsuarioBo uBo = new UsuarioBoImpl();
		
		try {
			
			Usuario u = uBo.retornarUsuario(getUsuario().getNombreUsuario());
			
			if (u.getTipoUsuario() == 0){
				ui.agregarMenuAdmin();
				ui.getBtnPerfil().setForeground(new Color(255, 193, 7));
			} else {
				ui.getBtnPerfil().setForeground(Color.WHITE);
			}
		} catch (UserNotExistsException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		
		ui.setVisible(true);
		
		if (getMensaje().equals("RESERVA")){
			
			String dni = uBo.retornarDniPorUsuario(getUsuario().getNombreUsuario());
			
			ReservaBoletoUI rVui = new ReservaBoletoUI();
			
			rVui.cargarAsientos(getViaje());
			
			rVui.setearViajeYDniReserva(getViaje(), dni);
			
			rVui.cargarInfoVuelo(getViaje(), getAcumula());
			
			dispose();
			
			rVui.setVisible(true);
		}
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

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public ViajeCabecera getViaje() {
		return viaje;
	}

	public void setViaje(ViajeCabecera viaje) {
		this.viaje = viaje;
	}

	public Boolean getAcumula() {
		return acumula;
	}

	public void setAcumula(Boolean acumula) {
		this.acumula = acumula;
	}

	@Override
	public void windowGainedFocus(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		requestFocus();
	}
}