package org.proyectofinal.ui.plantillasUI;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.SwingConstants;

import org.proyectofinal.bo.impl.ViajeCabeceraBoImpl;
import org.proyectofinal.bo.interfaces.ViajeCabeceraBo;
import org.proyectofinal.ui.DialogRemoveFlight;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class PlantillaDRF extends JDialog{

	private JComboBox cmbVuelos;
	
	public PlantillaDRF(){
		
	}
	
	public void inicializarAtributos(){
		setTitle("Eliminar Vuelo");
		setModal(true);
		setBounds(10,10,200,170);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
	}
	
	public void inicializarComponentes(){
		agregarLabel();
		agregarBotonEliminar();	
	}
	
	private void agregarLabel() {
		JLabel lblListadoDeVuelos = new JLabel("Listado de vuelos");
		lblListadoDeVuelos.setHorizontalTextPosition(SwingConstants.CENTER);
		lblListadoDeVuelos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoDeVuelos.setFont(new Font("Arial", Font.BOLD, 14));
		lblListadoDeVuelos.setBounds(0, 0, 200, 50);
		getContentPane().add(lblListadoDeVuelos);
	}

	private void agregarCmbVuelos(String[] modeloVuelos) {
		cmbVuelos = new JComboBox();
		cmbVuelos.setBounds(40, 55, 120, 30);
		cmbVuelos.setModel(new DefaultComboBoxModel<>(modeloVuelos));
		getContentPane().add(cmbVuelos);
	}

	private void agregarBotonEliminar() {
		JButton btnEliminarVuelo = new JButton("Eliminar Vuelo");
		btnEliminarVuelo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String codigo = (String)cmbVuelos.getSelectedItem();

				int opcionElegida = confirmarEliminacion(codigo);
				
				if (opcionElegida == 1){					
					
					eliminarVuelo(codigo);
					
					JOptionPane.showMessageDialog(null, "Se ha eliminado el vuelo con exito.");
					
					dispose();
					
					continuarEliminando();
				}
				
			}
		});
		btnEliminarVuelo.setForeground(Color.RED);
		btnEliminarVuelo.setFont(new Font("Arial", Font.BOLD, 16));
		btnEliminarVuelo.setBounds(30, 100, 140, 40);
		getContentPane().add(btnEliminarVuelo);
	}
	
	private int confirmarEliminacion(String codigo) {
		
		String ObjButtons[] = {"No","Si"};
	    
		int PromptResult = JOptionPane.showOptionDialog(null, 
	        "¿Estás seguro que deseas eliminar el vuelo con codigo de viaje \""+codigo +"\"?", "Advertencia", 
	        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, 
	        ObjButtons,ObjButtons[0]);
	    
		return PromptResult;
	}

	private void continuarEliminando() {
		
		String ObjButtons[] = {"No","Si"};
	    
		int PromptResult = JOptionPane.showOptionDialog(null, 
	        "¿Desea seguir eliminando vuelos?", "Mensaje", 
	        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
	        ObjButtons,ObjButtons[0]);

		if (PromptResult == 1){
			DialogRemoveFlight drf = new DialogRemoveFlight();
		}
	}
	
	private void eliminarVuelo(String codigo) {
		
		ViajeCabeceraBo vCBo = new ViajeCabeceraBoImpl();
		
		vCBo.eliminarVuelo(codigo);
	}
	
	protected void cargarVuelos(String[] modeloVuelos){
		agregarCmbVuelos(modeloVuelos);		
	}

}
