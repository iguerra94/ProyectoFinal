package org.proyectofinal.ui.botones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class BotonPasajero extends JButton implements ActionListener, MouseListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4718785825566238975L;
	private Float precio;
	private String asiento;
	private Integer cant;
	private String estadoAsiento;
	
	public BotonPasajero(String asiento, Float precio){
		
		this.precio = precio;
		this.asiento = asiento;

		this.setText(asiento);
		this.addActionListener(this);
	
		this.cant = 0;
	}
	
	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public String getAsiento() {
		return asiento;
	}

	public void setAsiento(String asiento) {
		this.asiento = asiento;
	}

	public String getEstadoAsiento() {
		return estadoAsiento;
	}

	public void setEstadoAsiento(String estadoAsiento) {
		this.estadoAsiento = estadoAsiento;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == this){
			
			if (cant % 2 == 0){
				
//				System.out.println("Numero: " + getAsiento());
//				System.out.println("Precio: $" + getPrecio());
				
				this.setContentAreaFilled(true);
				
				setEstadoAsiento("SELECCIONADO");
				
				cant++;
			}else{
				this.setContentAreaFilled(false);
				
				setEstadoAsiento("NO SELECCIONADO");
				
				cant--;
			}
		}
                
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
//		System.out.println("Numero: " + getAsiento());
//		System.out.println("Precio: $" + getPrecio());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}