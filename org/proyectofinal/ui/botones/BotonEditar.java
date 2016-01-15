package org.proyectofinal.ui.botones;

import javax.swing.JButton;

public class BotonEditar extends JButton {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6458089467978920785L;
	private Boolean estado;
	
	
	public BotonEditar(String texto) {
	
		this.setText(texto);
		this.setEstado(false);
		
	}


	public Boolean getEstado() {
		return estado;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

}