package org.proyectofinal.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.sql.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.proyectofinal.bo.interfaces.ViajeCabeceraBo;
import org.proyectofinal.model.interfaces.ViajeCabecera;
import org.proyectofinal.ui.plantillasUI.PlantillaLV;
import javax.swing.JButton;

public class ListadoVuelosUI extends PlantillaLV {

	private String dni;
	private Date datePosterior;

	public ListadoVuelosUI() {
		
		inicializarAtributos();
		inicializarComponentes();		
		
	}
}