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
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.proyectofinal.bo.ex.ViajeCabeceraNotValidException;

import com.toedter.calendar.JDateChooser;

public class PlantillaDLF extends JDialog {
	
	private JTextField txtCodigoViaje;
	
	public PlantillaDLF(){
		
		String[] modelHora = new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
		String[] modelMinuto = new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};	
		
		java.util.Date now = new java.util.Date();
		
	}
	
	public void inicializarAtributos(){
		setResizable(false);
		setModal(true);
		setTitle("Cargar Vuelo..");
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 870, 660);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(null);	
	}
	
	public void inicializarComponentes(){
		agregarCodigoViaje();
		agregarPanelSalida();
		agregarPanelLlegada();
		agregarPanelPrecios();
		agregarPanelImagenes();
		agregarPanelInfoExtra();
		agregarBotonGuardarCambios();
	}

	private void agregarBotonGuardarCambios() {
		btnRealizarCambios = new JButton("");
		btnRealizarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				if (dateChooserFechaSalida.getDate() != null){
					Date salida = new Date(dateChooserFechaSalida.getDate().getTime());
					vC.setFechaSalida(salida);
				}else{
					vC.setFechaSalida(null);
				}
				
				if (dateChooserFechaLlegada.getDate() != null){
					Date llegada = new Date(dateChooserFechaLlegada.getDate().getTime());
					vC.setFechaLlegada(llegada);
				}else{
					vC.setFechaLlegada(null);
				}
			
				String horaSalida = cmbHoraSalida.getSelectedItem() + ":" + cmbMinutoSalida.getSelectedItem() + ":00";
				vC.setHoraSalida(Time.valueOf(horaSalida));
				
				String horaLlegada = cmbHoraLlegada.getSelectedItem() + ":" + cmbMinutoLlegada.getSelectedItem() + ":00";
				vC.setHoraLlegada(Time.valueOf(horaLlegada));
			
				try {
					vCBo.verificarTodos(vC);
				} catch (ViajeCabeceraNotValidException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
				if (getBtnRealizarCambios().getText() == "Cargar vuelo"){
					
					try {
						vCDao.alta(vC);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					
					JOptionPane.showMessageDialog(null, "Se ha cargado el vuelo con exito!");
					
				}
				
				if (getBtnRealizarCambios().getText() == "Guardar cambios"){
				
					try {
						vCDao.modificacion(vC);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					
					JOptionPane.showMessageDialog(null, "Se ha modificado el vuelo con exito!");
					
				}
				
				dispose();
				
				
			}
		});
		btnRealizarCambios.setBounds(25, 605, 170, 35);
		getContentPane().add(btnRealizarCambios);
	}

	private void agregarCodigoViaje() {
		
		JLabel lblCodigoDeViaje = new JLabel("Codigo de Viaje: ");
		lblCodigoDeViaje.setBounds(25, 20, 120, 30);
		getContentPane().add(lblCodigoDeViaje);
		
		txtCodigoViaje = new JTextField();
		txtCodigoViaje.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if (txtCodigoViaje.getText().trim().length() > 0){
					vC.setCodigoViaje(txtCodigoViaje.getText());						
				}else{
					vC.setCodigoViaje("");
				}
			}
		});
		txtCodigoViaje.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
		
				char c = e.getKeyChar();
				
				if ((c < '0' || c > '9') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_SPACE) && (c != KeyEvent.VK_BACK_SPACE)){
					e.consume();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtCodigoViaje.getText().trim().length() > 0){
					
					for (Integer codigo : codigos) {
						
						if (Integer.parseInt(txtCodigoViaje.getText()) == codigo){
							JOptionPane.showMessageDialog(null, "El vuelo ingresado ya existe. Ingrese otro Codigo de Viaje");
							txtCodigoViaje.setText("");
							break;
						}else{
							vC.setCodigoViaje("");						
						}						
					}
					
				}else{
					vC.setCodigoViaje("");
				}
			}
		});
		txtCodigoViaje.setBounds(145, 20, 190, 30);
		getContentPane().add(txtCodigoViaje);
		
	}

	private void agregarPanelSalida() {
		agregarLabelsPanelSalida();
		agregarCamposPanelSalida();
		JPanel panelSalida = new JPanel();
		panelSalida.setBorder(new TitledBorder(null, "Salida", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panelSalida.setBounds(20, 70, 400, 250);
		getContentPane().add(panelSalida);
		panelSalida.setLayout(null);
		
		JLabel lblPaisDeOrigen = new JLabel("Pais de Origen: ");
		lblPaisDeOrigen.setBounds(20, 30, 160, 30);
		panelSalida.add(lblPaisDeOrigen);
		
		JLabel lblCiudadDeOrigen = new JLabel("Ciudad de Origen: ");
		lblCiudadDeOrigen.setBounds(20, 70, 160, 30);
		panelSalida.add(lblCiudadDeOrigen);
		
		JLabel lblPlataformaOrigen = new JLabel("Plataforma de Origen: ");
		lblPlataformaOrigen.setBounds(20, 110, 160, 30);
		panelSalida.add(lblPlataformaOrigen);
		
		JLabel lblFechaDeSalida = new JLabel("Fecha de Salida: ");
		lblFechaDeSalida.setBounds(20, 150, 160, 30);
		panelSalida.add(lblFechaDeSalida);
		
		JLabel lblHoraDeSalida = new JLabel("Hora de Salida: ");
		lblHoraDeSalida.setBounds(20, 190, 160, 30);
		panelSalida.add(lblHoraDeSalida);
		
		cmbPaisOrigen = new JComboBox();
		cmbPaisOrigen.setBounds(180, 30, 190, 30);
		panelSalida.add(cmbPaisOrigen);
		cmbPaisOrigen.setModel(new DefaultComboBoxModel(modelPaises));
		cmbPaisOrigen.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if (cmbPaisOrigen.getSelectedIndex() == 0){
					vC.setPaisOrigen(listaPaises.getListaPaises().get(0).getPais());
					vC.setShortPaisOrigen(listaPaises.getListaPaises().get(0).getShortPais());
				}else if (cmbPaisOrigen.getSelectedIndex() == 1){
					vC.setPaisOrigen(listaPaises.getListaPaises().get(1).getPais());
					vC.setShortPaisOrigen(listaPaises.getListaPaises().get(1).getShortPais());
				}else if (cmbPaisOrigen.getSelectedIndex() == 2){
					vC.setPaisOrigen(listaPaises.getListaPaises().get(2).getPais());
					vC.setShortPaisOrigen(listaPaises.getListaPaises().get(2).getShortPais());
				}else if (cmbPaisOrigen.getSelectedIndex() == 3){
					vC.setPaisOrigen(listaPaises.getListaPaises().get(3).getPais());
					vC.setShortPaisOrigen(listaPaises.getListaPaises().get(3).getShortPais());
				}
				
			}
		});
		
		
		cmbCiudadOrigen = new JComboBox();
		cmbCiudadOrigen.setBounds(180, 70, 190, 30);
		panelSalida.add(cmbCiudadOrigen);
		cmbCiudadOrigen.setModel(new DefaultComboBoxModel(modelPaises));
		
		JComboBox cmbPlatOrigen = new JComboBox();
		cmbPlatOrigen.setBounds(180, 110, 190, 30);
		panelSalida.add(cmbPlatOrigen);
		
		dateChooserFechaSalida = new JDateChooser();
		dateChooserFechaSalida.setBounds(180, 150, 190, 30);
		panelSalida.add(dateChooserFechaSalida);
		dateChooserFechaSalida.setDate(now);
		
		cmbHoraSalida = new JComboBox();
		cmbHoraSalida.setBounds(180, 190, 50, 30);
		panelSalida.add(cmbHoraSalida);
		cmbHoraSalida.setModel(new DefaultComboBoxModel(modelHora));
		
		JLabel label1 = new JLabel(":");
		label1.setFont(new Font("DejaVu Sans", Font.PLAIN, 14));
		label1.setBounds(240, 190, 15, 30);
		panelSalida.add(label1);
		
		cmbMinutoSalida = new JComboBox();
		cmbMinutoSalida.setBounds(255, 190, 50, 30);
		panelSalida.add(cmbMinutoSalida);
		cmbMinutoSalida.setModel(new DefaultComboBoxModel(modelMinuto));
	}

	private void agregarPanelLlegada() {
		agregarLabelsPanelLlegada();
		agregarCamposPanelLlegada();
		JPanel panelLlegada = new JPanel();
		panelLlegada.setLayout(null);
		panelLlegada.setBorder(new TitledBorder(null, "Llegada", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panelLlegada.setBounds(440, 70, 400, 250);
		getContentPane().add(panelLlegada);
		
		JLabel lblPaisDestino = new JLabel("Pais de Destino: ");
		lblPaisDestino.setBounds(20, 30, 160, 30);
		panelLlegada.add(lblPaisDestino);
		
		JLabel lblCiudadDestino = new JLabel("Ciudad de Destino: ");
		lblCiudadDestino.setBounds(20, 70, 160, 30);
		panelLlegada.add(lblCiudadDestino);
		
		JLabel lblPlataformaDestino = new JLabel("Plataforma de Destino: ");
		lblPlataformaDestino.setBounds(20, 110, 160, 30);
		panelLlegada.add(lblPlataformaDestino);
		
		JLabel lblFechaLlegada = new JLabel("Fecha de Llegada: ");
		lblFechaLlegada.setBounds(20, 150, 160, 30);
		panelLlegada.add(lblFechaLlegada);
		
		JLabel lblHoraLlegada = new JLabel("Hora de Llegada: ");
		lblHoraLlegada.setBounds(20, 190, 160, 30);
		panelLlegada.add(lblHoraLlegada);
		
		JComboBox cmbPaisDestino = new JComboBox();
		cmbPaisDestino.setBounds(180, 30, 190, 30);
		panelLlegada.add(cmbPaisDestino);
		
		JComboBox cmbCiudadDestino = new JComboBox();
		cmbCiudadDestino.setBounds(180, 70, 190, 30);
		panelLlegada.add(cmbCiudadDestino);
		
		JComboBox cmbPlatDestino = new JComboBox();
		cmbPlatDestino.setBounds(180, 110, 190, 30);
		panelLlegada.add(cmbPlatDestino);
		
		JDateChooser dateChooserFechaLlegada = new JDateChooser();
		dateChooserFechaLlegada.setBounds(180, 150, 190, 30);
		panelLlegada.add(dateChooserFechaLlegada);
		
		JComboBox cmbHoraLlegada = new JComboBox();
		cmbHoraLlegada.setBounds(180, 190, 50, 30);
		cmbHoraLlegada.setModel(new DefaultComboBoxModel(modelHora));
		panelLlegada.add(cmbHoraLlegada);
		
		JLabel label2 = new JLabel(":");
		label2.setFont(new Font("DejaVu Sans", Font.PLAIN, 14));
		label2.setBounds(240, 190, 15, 30);
		panelLlegada.add(label2);
		
		JComboBox cmbMinutoLlegada = new JComboBox();
		cmbMinutoLlegada.setBounds(255, 190, 50, 30);
		cmbMinutoLlegada.setModel(new DefaultComboBoxModel(modelMinuto));
		panelLlegada.add(cmbMinutoLlegada);
	}

	private void agregarPanelPrecios() {
		JPanel panelPrecios = new JPanel();
		panelPrecios.setLayout(null);
		panelPrecios.setBorder(new TitledBorder(null, "Precios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panelPrecios.setBounds(20, 345, 290, 130);
		getContentPane().add(panelPrecios);
		
		JLabel lblPrecioClaseTurista = new JLabel("Precio Clase Turista:");
		lblPrecioClaseTurista.setBounds(20, 30, 150, 30);
		panelPrecios.add(lblPrecioClaseTurista);
		
		JLabel lblPrecioPrimeraClase = new JLabel("Precio Primera Clase:");
		lblPrecioPrimeraClase.setBounds(20, 70, 150, 30);
		panelPrecios.add(lblPrecioPrimeraClase);
		
		txtPrecioTurista = new JTextField();
		txtPrecioTurista.setBounds(170, 30, 100, 30);
		panelPrecios.add(txtPrecioTurista);
		
		txtPrecioPrimera = new JTextField();
		txtPrecioPrimera.setBounds(170, 70, 100, 30);
		panelPrecios.add(txtPrecioPrimera);
	
		agregarLabelsPanelPrecios();
		agregarCamposPanelPrecios();
	}

	private void agregarPanelImagenes() {
		agregarLabelsPanelImagenes();
		agregarCamposPanelImagenes();
		JPanel panelImagenes = new JPanel();
		panelImagenes.setLayout(null);
		panelImagenes.setBorder(new TitledBorder(null, "Imagenes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panelImagenes.setBounds(330, 345, 510, 130);
		getContentPane().add(panelImagenes);
		
		JLabel lblImagen1 = new JLabel("Imagen 1:");
		lblImagen1.setBounds(20, 30, 80, 30);
		panelImagenes.add(lblImagen1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(100, 70, 140, 30);
		panelImagenes.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblImagen2 = new JLabel("Imagen 2:");
		lblImagen2.setBounds(20, 70, 80, 30);
		panelImagenes.add(lblImagen2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(100, 30, 140, 30);
		panelImagenes.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblImagen3 = new JLabel("Imagen 3:");
		lblImagen3.setBounds(260, 30, 80, 30);
		panelImagenes.add(lblImagen3);
		
		JLabel lblImagen4 = new JLabel("Imagen 4:");
		lblImagen4.setBounds(260, 70, 80, 30);
		panelImagenes.add(lblImagen4);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(340, 30, 140, 30);
		panelImagenes.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(340, 70, 140, 30);
		panelImagenes.add(textField_1);
	}

	private void agregarPanelInfoExtra() {
		JPanel panelInfoExtra = new JPanel();
		panelInfoExtra.setBounds(25, 495, 815, 90);
		getContentPane().add(panelInfoExtra);
		panelInfoExtra.setLayout(null);
		panelInfoExtra.setBorder(new TitledBorder(null, "Informacion extra", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		
		JLabel lblDistancia = new JLabel("Distancia:");
		lblDistancia.setBounds(20, 30, 100, 30);
		panelInfoExtra.add(lblDistancia);
		
		JLabel lblDuracion = new JLabel("Duracion:");
		lblDuracion.setBounds(295, 30, 80, 30);
		panelInfoExtra.add(lblDuracion);
		
		JLabel lblCupo = new JLabel("Cupo: ");
		lblCupo.setBounds(550, 30, 70, 30);
		panelInfoExtra.add(lblCupo);
		
		txtDistancia = new JTextField();
		txtDistancia.setColumns(10);
		txtDistancia.setBounds(120, 30, 125, 30);
		panelInfoExtra.add(txtDistancia);
		
		JComboBox cmbHoraDuracion = new JComboBox();
		cmbHoraDuracion.setBounds(375, 30, 50, 30);
		panelInfoExtra.add(cmbHoraDuracion);
		
		JLabel label3 = new JLabel(":");
		label3.setFont(new Font("DejaVu Sans", Font.PLAIN, 14));
		label3.setBounds(435, 30, 15, 30);
		panelInfoExtra.add(label3);
		
		JComboBox cmbMinutoDuracion = new JComboBox();
		cmbMinutoDuracion.setBounds(450, 30, 50, 30);
		panelInfoExtra.add(cmbMinutoDuracion);
		
		txtCupo = new JTextField();
		txtCupo.setEditable(false);
		txtCupo.setText("66");
		txtCupo.setBounds(620, 30, 165, 30);
		panelInfoExtra.add(txtCupo);
		agregarLabelsPanelInfoExtra();
		agregarCamposPanelInfoExtra();
	}

}