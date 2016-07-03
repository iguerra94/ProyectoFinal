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
import org.proyectofinal.ui.DialogRemoveFlight;
import org.proyectofinal.ui.DialogRemoveOffer;

public class PlantillaDRO extends JDialog {

//	private JPanel panelOrigen;
//	private JComboBox cmbOrigen;
//	String origen;
//	
//	private JPanel panelDestino;
//	private JComboBox cmbDestino;
//	String destino;
//	
	private ViajeCabecera vC;
	private ViajeCabeceraBo vCBo;

	private JComboBox cmbOfertas;
	
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

//	private void agregarPanelOrigen() {
//		
//		panelOrigen = new JPanel();
//		panelOrigen.setBorder(new TitledBorder(null, "Origen", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
//		panelOrigen.setBackground(Color.WHITE);
//		panelOrigen.setBounds(20, 20, 360, 80);
//		getContentPane().add(panelOrigen);
//		panelOrigen.setLayout(null);
//		
//		agregarLabelsPanelOrigen();
//		agregarCamposPanelOrigen();
//	}
//
//	private void agregarLabelsPanelOrigen() {
//		
//		JLabel label1 = new JLabel("Origen: ");
//		label1.setBounds(20, 30, 130, 30);
//		panelOrigen.add(label1);
//	}
//
//	private void agregarCamposPanelOrigen() {
//		
//		vC = new ViajeCabeceraImpl();
//
//		vCBo = new ViajeCabeceraBoImpl();
//
//		cmbOrigen = new JComboBox();
//		cmbOrigen.setBounds(150, 30, 190, 30);
//		cmbOrigen.addPropertyChangeListener(new PropertyChangeListener() {
//			public void propertyChange(PropertyChangeEvent arg0) {
//				cargarComboBoxOrigen();
//			}
//		});
//		cmbOrigen.addItemListener(new ItemListener() {
//			public void itemStateChanged(ItemEvent e) {
//				actualizarComboDestino();
//				cargarComboBoxDestino();
//
//				
//				if (cmbOrigen.getSelectedIndex() > 0){
//					String origen = cmbOrigen.getSelectedItem().toString();
//					vC.setCiudadOrigen(origen.split("[(]")[0]);
//					vC.setShortPaisOrigen(origen.substring(origen.length()-4, origen.length()-1));
//				}
//				
//			}
//		});
//		panelOrigen.add(cmbOrigen);		
//		
//		vC.setCiudadOrigen("");
//		vC.setShortPaisOrigen("");
//	}
//	
//	private void cargarComboBoxOrigen(){
//		
//		ViajeCabeceraBo vCBo = new ViajeCabeceraBoImpl();
//		
//		cmbOrigen.removeAllItems();
//
//		cmbOrigen.addItem("");
//		
//		for (String origen : vCBo.retornarOrigenes()) {
//			cmbOrigen.addItem(origen);
//		}
//		
//		cmbDestino.setSelectedIndex(0);
//	}
//
//	private void agregarPanelDestino(){
//		
//		panelDestino = new JPanel();
//		panelDestino.setLayout(null);
//		panelDestino.setBorder(new TitledBorder(null, "Destino", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
//		panelDestino.setBackground(Color.WHITE);
//		panelDestino.setBounds(400, 20, 360, 80);
//		getContentPane().add(panelDestino);
//		
//		agregarLabelsPanelDestino();
//		agregarCamposPanelDestino();
//	}
//	
//	private void agregarLabelsPanelDestino() {
//		
//		JLabel label2 = new JLabel("Destino: ");
//		label2.setBounds(20, 30, 130, 30);
//		panelDestino.add(label2);	
//	}
//
//	private void agregarCamposPanelDestino() {
//		
//		cmbDestino = new JComboBox();
//		cmbDestino.setEnabled(false);
//		cmbDestino.setModel(new DefaultComboBoxModel(new String[] {""}));
//		cmbDestino.addPropertyChangeListener(new PropertyChangeListener() {
//			public void propertyChange(PropertyChangeEvent arg0) {
//				cargarComboBoxDestino();
//			}
//		});
//		cmbDestino.addItemListener(new ItemListener() {
//			public void itemStateChanged(ItemEvent e) {
//
//				if (cmbDestino.getSelectedIndex() > 0){
//					String destino = cmbDestino.getSelectedItem().toString();
//					vC.setCiudadDestino(destino.split("[(]")[0]);
//					vC.setShortPaisDestino(destino.substring(destino.length()-4, destino.length()-1));
//				}
//			}
//		});
//		cmbDestino.setBounds(150, 30, 190, 30);
//		panelDestino.add(cmbDestino);
//
//		vC.setCiudadDestino("");
//		vC.setShortPaisDestino("");
//	}
//	
//	private void actualizarComboDestino(){
//	
//		if (cmbOrigen.getSelectedIndex() != 0){
//			cmbDestino.setEnabled(true);
//		}else{
//			cmbDestino.setEnabled(false);
//		}
//		
//		validate();
//		repaint();
//	}
//	
//	private void cargarComboBoxDestino(){
//		
//		ViajeCabeceraBo vCBo = new ViajeCabeceraBoImpl();
//		
//		cmbDestino.removeAllItems();
//		
//		cmbDestino.addItem("");
//		
//		for (String destino : vCBo.retornarDestinos()) {	
//			if (!destino.equals(cmbOrigen.getSelectedItem())){
//				cmbDestino.addItem(destino);
//			}
//		}
//		
//		cmbDestino.setSelectedIndex(0);
//	}
	
	
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
		
		cmbOfertas = new JComboBox();
		cmbOfertas.setBounds(25, 55, 300, 30);
		cmbOfertas.setModel(new DefaultComboBoxModel<>(listaOfertas));
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
		}
	}
	
}