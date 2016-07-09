package org.proyectofinal.ui.botones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class BotonPasajero extends JButton implements ActionListener, MouseListener {

	private static final long serialVersionUID = -4718785825566238975L;

	private Float precio;
	private Integer asiento;
	private Integer cant;
	private String estadoAsiento;

	public BotonPasajero(Integer asiento, Float precio) {
		
		this.precio = precio;
		this.asiento = asiento;

		this.setText(asiento.toString());
		this.addActionListener(this);
		
		this.cant = 0;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Integer getAsiento() {
		return this.asiento;
	}

	public void setAsiento(Integer asiento) {
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

		if (e.getSource() == this) {

			if (cant % 2 == 0) {

				this.setContentAreaFilled(true);

				setEstadoAsiento("SELECCIONADO");
				setToolTipText("SELECCIONADO");
				
				cant++;
			} else {
				this.setContentAreaFilled(false);

				setEstadoAsiento("NO SELECCIONADO");
				setToolTipText("DISPONIBLE");
				
				cant--;
			}
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public String toString() {
		return "Asiento: ".concat(getAsiento().toString()).concat("\nPrecio: ").concat(getPrecio().toString().concat("\n"));
	}

}