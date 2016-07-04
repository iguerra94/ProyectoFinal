package org.proyectofinal.ui.plantillasUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.proyectofinal.bo.ex.ViajeCabeceraOfferNotValidException;
import org.proyectofinal.bo.impl.ViajeCabeceraBoImpl;
import org.proyectofinal.bo.interfaces.ViajeCabeceraBo;
import org.proyectofinal.model.impl.ViajeCabeceraImpl;
import org.proyectofinal.model.interfaces.ViajeCabecera;
import org.proyectofinal.ui.DialogLoadFlight;
import org.proyectofinal.ui.DialogLoadOffer;
import org.proyectofinal.ui.DialogRemoveFlight;
import org.proyectofinal.ui.util.CiudadUtil;
import org.proyectofinal.ui.util.ListaCiudades;
import org.proyectofinal.ui.util.ListaPaises;
import org.proyectofinal.ui.util.PaisUtil;

public class PlantillaDLO extends JDialog {
	
	
	private JPanel panelOrigenDestino;
	private JComboBox cmbOrigenDestino;
	
	private JPanel panelOferta;
	private JTextField txtOferta;
	private JTextField txtImagen;
	private FileNameExtensionFilter filterjpg = new FileNameExtensionFilter("Archivo de Imagen JPG", "jpg");
	private FileNameExtensionFilter filterpng = new FileNameExtensionFilter("Archivo de Imagen PNG", "png");
	
	private ViajeCabecera vC;
	private ViajeCabeceraBo vCBo;
	
	public PlantillaDLO(){
	}
	
	public void inicializarAtributosLO(){
		setTitle("Cargar Oferta");
		setModal(true);
		setBounds(10,10,570,345);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);		
	}
	
	public void inicializarComponentesLO(){
		agregarPanelOrigenDestino();
		agregarPanelOferta();
		agregarBotonCargarOferta();		
	}

	private void agregarPanelOrigenDestino() {
		
		panelOrigenDestino = new JPanel();
		panelOrigenDestino.setBorder(new TitledBorder(null, "Origen y Destino", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelOrigenDestino.setBackground(Color.WHITE);
		panelOrigenDestino.setBounds(20, 20, 340, 80);
		getContentPane().add(panelOrigenDestino);
		panelOrigenDestino.setLayout(null);
		
		agregarCamposPanelOrigen();
	}

	private void agregarCamposPanelOrigen() {
		
		vC = new ViajeCabeceraImpl();

		vCBo = new ViajeCabeceraBoImpl();

		List<String> modeloOrigenDestino = vCBo.retornarOrigenesDestinos();
		
		String[] listaOrigenDestino = new String[modeloOrigenDestino.size()];
		
		int i = 0;
		
		for (String origenDestino : modeloOrigenDestino) {
			listaOrigenDestino[i] = origenDestino;
			i++;
		}
		
		cmbOrigenDestino = new JComboBox();
		cmbOrigenDestino.setBounds(20, 30, 300, 30);
		cmbOrigenDestino.setModel(new DefaultComboBoxModel<>(listaOrigenDestino));
		cmbOrigenDestino.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if (cmbOrigenDestino.getSelectedItem() != null){
					String origen = cmbOrigenDestino.getSelectedItem().toString().split(" - ")[0];
					String destino = cmbOrigenDestino.getSelectedItem().toString().split(" - ")[1];
					
					vC.setCiudadOrigen(origen.split("[(]")[0]);
					vC.setShortPaisOrigen(origen.substring(origen.length()-4, origen.length()-1));
	
					vC.setCiudadDestino(destino.split("[(]")[0]);
					vC.setShortPaisDestino(destino.substring(destino.length()-4, destino.length()-1));
				}
			}
		});
		panelOrigenDestino.add(cmbOrigenDestino);		
		
		String origen = cmbOrigenDestino.getSelectedItem().toString().split(" - ")[0];
		String destino = cmbOrigenDestino.getSelectedItem().toString().split(" - ")[1];
		
		vC.setCiudadOrigen(origen.split("[(]")[0]);
		vC.setShortPaisOrigen(origen.substring(origen.length()-4, origen.length()-1));

		vC.setCiudadDestino(destino.split("[(]")[0]);
		vC.setShortPaisDestino(destino.substring(destino.length()-4, destino.length()-1));
	}
	
	private void cargarComboBoxOrigenDestino(){
		
		ViajeCabeceraBo vCBo = new ViajeCabeceraBoImpl();
		
		cmbOrigenDestino.removeAllItems();

		for (String origenDestino : vCBo.retornarOrigenesDestinos()) {
			cmbOrigenDestino.addItem(origenDestino);
		}
		
		cmbOrigenDestino.setSelectedIndex(0);
	}
	
	private void agregarPanelOferta() {
		
		panelOferta = new JPanel();
		panelOferta.setLayout(null);
		panelOferta.setBorder(new TitledBorder(null, "Oferta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOferta.setBackground(Color.WHITE);
		panelOferta.setBounds(20, 120, 530, 120);
		getContentPane().add(panelOferta);
		
		agregarLabelsPanelOferta();
		agregarCamposPanelOferta();
	}

	private void agregarLabelsPanelOferta() {
		JLabel label5 = new JLabel("Oferta: ");
		label5.setBounds(20, 30, 130, 30);
		panelOferta.add(label5);
		
		JLabel label6 = new JLabel("Imagen de Oferta: ");
		label6.setBounds(20, 70, 130, 30);
		panelOferta.add(label6);
	}

	private void agregarCamposPanelOferta() {
		
		txtOferta = new JTextField();
		txtOferta.setBounds(150, 30, 120, 30);
		txtOferta.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if (txtOferta.getText().trim().length() > 0){
					vC.setOferta(txtOferta.getText());					
				}else{
					vC.setOferta("0.0");		
				}
			}
		});
		txtOferta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				controlarTeclasParaTiposFlotantes(e);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				
				if (txtOferta.getText().trim().length() > 0){
					vC.setOferta(txtOferta.getText());					
				}else{
					vC.setOferta("0.0");		
				}

			}
		});
		txtOferta.setToolTipText("DEBE SER UN NUMERO ENTRE 0 Y 1. POR EJ: 0.1");
		panelOferta.add(txtOferta);
		
		txtImagen = new JTextField();
		txtImagen.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {

				if (txtImagen.getText().length() > 0){
					vC.setImagenOferta(txtImagen.getText());				
				}else{
					vC.setImagenOferta("");
				}
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				if (txtImagen.getText().length() > 0){
					vC.setImagenOferta(txtImagen.getText());				
				}else{
					vC.setImagenOferta("");
				}
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				
			}
		});
		txtImagen.setEditable(false);
		txtImagen.setBounds(150, 70, 200, 30);
		panelOferta.add(txtImagen);
		
		JButton btnAgregarImagen = new JButton("Agregar Imagen");
		btnAgregarImagen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actionBtnImagen();				
			}

		});
		btnAgregarImagen.setBounds(360, 70, 150, 30);
		panelOferta.add(btnAgregarImagen);
		
		vC.setOferta("0.0");
		vC.setImagenOferta("");
	}
	
	private void controlarTeclasParaTiposFlotantes(KeyEvent e) {
	
		char c = e.getKeyChar();
		
		if ((c < '0' || c > '9') && (c != '.') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_SPACE) && (c != KeyEvent.VK_BACK_SPACE) || txtOferta.getText().length() == 4){
			e.consume();
		}
		
	}

	private void actionBtnImagen() {
		
		JFileChooser imagen = new JFileChooser("/home/ivang94/workspace/ProyectoFinal/src/imagenes");
		
		imagen.setFileFilter(filterpng);
		imagen.setFileFilter(filterjpg);
		
		int opcion = imagen.showOpenDialog(this);
		
		if (opcion == JFileChooser.APPROVE_OPTION){
			txtImagen.setText(imagen.getSelectedFile().getPath().substring(41));
		}
	}
	
	private void agregarBotonCargarOferta() {
		JButton btnCargarOferta = new JButton("Cargar Oferta");
		btnCargarOferta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					
					vCBo.verificarOferta(vC);
	
					vCBo.cargarOferta(vC);
					
					
					JOptionPane.showMessageDialog(null, "Se ha cargado la oferta con exito!"); 
					
					dispose();
					
					continuarCargando();
					
				} catch (ViajeCabeceraOfferNotValidException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
		
			}
		});
		btnCargarOferta.setFont(new Font("Arial", Font.BOLD, 14));
		btnCargarOferta.setBounds(20, 260, 150, 35);
		getContentPane().add(btnCargarOferta);
	}
	
	private void continuarCargando() {
		
		String ObjButtons[] = {"No","Si"};
	    
		int PromptResult = JOptionPane.showOptionDialog(null, 
	        "¿Desea seguir cargando ofertas?", "Mensaje", 
	        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
	        ObjButtons,ObjButtons[0]);

		if (PromptResult == 1){
			DialogLoadOffer dlo = new DialogLoadOffer();
		}
	}

}