package org.proyectofinal.ui.plantillasUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import org.proyectofinal.bo.impl.ViajeCabeceraBoImpl;
import org.proyectofinal.bo.interfaces.ViajeCabeceraBo;
import org.proyectofinal.model.impl.ViajeCabeceraImpl;
import org.proyectofinal.model.interfaces.ViajeCabecera;
import org.proyectofinal.ui.DialogRemoveOffer;

public class PlantillaDRO extends JDialog {

	private static final long serialVersionUID = -4390353818332303704L;

	private ViajeCabecera vC;

	private JComboBox<String> cmbOfertas;
	
	public PlantillaDRO(){
		
	}
	
	public void inicializarAtributosRO(){
		setTitle("Eliminar Oferta");
		setModal(true);
		setBounds(10,10,350,175);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);		
	}
	
	public void inicializarComponentesRO(){
		agregarLabel();
		agregarBotonEliminarOferta();
	}
		
	private void agregarLabel() {
		JLabel lblListadoDeOfertas = new JLabel("Listado de ofertas");
		lblListadoDeOfertas.setHorizontalTextPosition(SwingConstants.CENTER);
		lblListadoDeOfertas.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoDeOfertas.setFont(new Font("Arial", Font.BOLD, 18));
		lblListadoDeOfertas.setBounds(0, 0, 350, 50);
		getContentPane().add(lblListadoDeOfertas);
	}
	
	private void agregarCmbOfertas(List<String> modeloOfertas) {
		
		vC = new ViajeCabeceraImpl();
		
		String[] listaOfertas = new String[modeloOfertas.size()];
		
		int i = 0;
		
		for (String oferta : modeloOfertas) {
			listaOfertas[i] = oferta;
			i++;
		}
		
		cmbOfertas = new JComboBox<String>();
		cmbOfertas.setBounds(25, 55, 300, 30);
		cmbOfertas.setModel(new DefaultComboBoxModel<String>(listaOfertas));
		getContentPane().add(cmbOfertas);
	}
	
	private void agregarBotonEliminarOferta() {
		JButton btnEliminarOferta = new JButton("Eliminar Oferta");
		btnEliminarOferta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String origen = cmbOfertas.getSelectedItem().toString().split(" - ")[0];
				String destino = cmbOfertas.getSelectedItem().toString().split(" - ")[1];
				
				vC.setCiudadOrigen(origen.split("[(]")[0]);
				vC.setShortPaisOrigen(origen.substring(origen.length()-4, origen.length()-1));
				vC.setCiudadDestino(destino.split("[(]")[0]);
				vC.setShortPaisDestino(destino.substring(destino.length()-4, destino.length()-1));

				int opcionElegida = confirmarEliminacion();
				
				if (opcionElegida == 1){					
					
					eliminarOferta(vC);
					
					JOptionPane.showMessageDialog(null, "Se ha eliminado la oferta con exito.");
					
					dispose();
					
					continuarEliminando();
				}
						
			}
		});
		btnEliminarOferta.setForeground(Color.RED);
		btnEliminarOferta.setFont(new Font("Arial", Font.BOLD, 16));
		btnEliminarOferta.setBounds(100, 105, 150, 35);
		getContentPane().add(btnEliminarOferta);
	}
	
	public void cargarOfertas(List<String> modeloOfertas){
		agregarCmbOfertas(modeloOfertas);		
	}
	
	private void eliminarOferta(ViajeCabecera vC) {
		
		ViajeCabeceraBo vCBo = new ViajeCabeceraBoImpl();
		
		vCBo.eliminarOferta(vC);
	}
	
	private int confirmarEliminacion() {
		
		String ObjButtons[] = {"No","Si"};
	    
		int PromptResult = JOptionPane.showOptionDialog(null, 
	        "¿Estás seguro que deseas eliminar la oferta seleccionada?", "Advertencia", 
	        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, 
	        ObjButtons,ObjButtons[0]);
	    
		return PromptResult;
	}
	
	private void continuarEliminando() {
		
		String ObjButtons[] = {"No","Si"};
	    
		int PromptResult = JOptionPane.showOptionDialog(null, 
	        "¿Desea seguir eliminando ofertas?", "Mensaje", 
	        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
	        ObjButtons,ObjButtons[0]);

		if (PromptResult == 1){
			DialogRemoveOffer dro = new DialogRemoveOffer();
			dro.setVisible(true);
		}
	}
	
}