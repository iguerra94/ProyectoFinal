package org.proyectofinal.ui.plantillasUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import org.proyectofinal.bo.ex.ViajeCabeceraNotValidException;
import org.proyectofinal.bo.impl.PersonaRegistradaBoImpl;
import org.proyectofinal.bo.impl.UsuarioBoImpl;
import org.proyectofinal.bo.impl.ViajeCabeceraBoImpl;
import org.proyectofinal.bo.interfaces.PersonaRegistradaBo;
import org.proyectofinal.bo.interfaces.UsuarioBo;
import org.proyectofinal.bo.interfaces.ViajeCabeceraBo;
import org.proyectofinal.dao.ex.NoFlightsFoundException;
import org.proyectofinal.model.impl.ViajeCabeceraImpl;
import org.proyectofinal.model.interfaces.PersonaRegistrada;
import org.proyectofinal.model.interfaces.ViajeCabecera;
import org.proyectofinal.ui.DialogLoadFlight;
import org.proyectofinal.ui.DialogLogin;
import org.proyectofinal.ui.DialogPerfil;
import org.proyectofinal.ui.DialogRegistrarse;
import org.proyectofinal.ui.DialogRemoveFlight;
import org.proyectofinal.ui.ListadoVuelosUI;
import org.proyectofinal.ui.MainFrameUI;

import com.toedter.calendar.JDateChooser;

public class PlantillaMF extends JFrame {
	
	private static final long serialVersionUID = -9218140826797976946L;
	
	private Boolean logueado = false;
	private JMenuBar menuBar;
	private JButton btnRegistrarse;
	private JButton btnIniciarSesion;
	private JButton btnPerfil;
	private JButton btnCerrarSesion;
	private JPanel panelReserva;
	private JPanel panelFrecuente;
	private JPanel panelOfertas;
	private JTabbedPane paneReserva;
	private JTabbedPane paneOfertas;
	private JLabel lblOrigen;
	private JComboBox cmbOrigen;
	private JLabel lblFlecha;
	private JLabel lblDestino;
	private JComboBox cmbDestino;
	private JLabel lblFechaIda;
	private JDateChooser dateChooserFechaIda;
	private JCheckBox chckbxAcumularKilometrosAeropass;
	private ViajeCabecera vC;
	private String origen;
	private String destino;
	private Date fechaIda;
	private JLabel lblOrigenOferta1;
	private JLabel lblDestinoOferta1;
	private JLabel lblOrigenOferta2;
	private JLabel lblDestinoOferta2;
	private JLabel lblOrigenOferta3;
	private JLabel lblDestinoOferta3;
	private JLabel lblDescuentoOferta1;
	private JLabel lblPrecioOferta1;
	private JLabel lblDescuentoOferta2;
	private JLabel lblPrecioOferta2;
	private JLabel lblDescuentoOferta3;
	private JLabel lblPrecioOferta3;
	
	public PlantillaMF() {

	}
	
	protected void inicializarAtributos(){
		setTitle("AeroManagement");
		setSize(1301,744);
		getContentPane().setBackground(new Color(0,150,136));
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage());
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		getContentPane().setLayout(null);
	}
	
	protected void inicializarComponentes(){
		
		agregarMenu();
		
		agregarTabbedPaneReserva();
		
		agregarPanelFrecuente();
		
		agregarTabbedPaneOfertas();
	}

	private void agregarTabbedPaneReserva() {
		
		panelReserva = new JPanel();
		panelReserva.setBackground(new Color(48,63,159));
		panelReserva.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, null, Color.DARK_GRAY, null));
		panelReserva.setBounds(30, 50, (getWidth()/2)-30, (getHeight()/4));
		panelReserva.setLayout(null);
		
		agregarLabelsPaneReserva();
		agregarBotonBuscarVuelo();
		agregarCamposPaneReserva();
		
		paneReserva = new JTabbedPane(JTabbedPane.TOP);
		paneReserva.addTab("Reservá tu vuelo", null, panelReserva, null);	
		paneReserva.setFont(new Font("Roboto Regular", Font.PLAIN, 18));
		paneReserva.setBounds(30, 80, (getWidth()/2)-30, (getHeight()/4)+70);
		paneReserva.setBackground(new Color(255,255,255));
		getContentPane().add(paneReserva);
	}

	private void agregarLabelsPaneReserva() {
		
		lblOrigen = new JLabel("Origen");
		lblOrigen.setForeground(new Color(69, 90, 100));
		lblOrigen.setBounds(35, 30, 100, 30);
		panelReserva.add(lblOrigen);
		
		lblFlecha = new JLabel("");
		lblFlecha.setBounds(294,30,32,32);
		lblFlecha.setBackground(Color.WHITE);
		lblFlecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFlecha.setVerticalAlignment(SwingConstants.CENTER);
		
		ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/flecha_derecha1.png"));
		
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblFlecha.getWidth(), lblFlecha.getHeight(), Image.SCALE_DEFAULT));
		
		lblFlecha.setIcon(icono);
		panelReserva.add(lblFlecha);

		lblDestino = new JLabel("Destino");
		lblDestino.setForeground(new Color(69, 90, 100));
		lblDestino.setBounds(345, 30, 100, 30);
		panelReserva.add(lblDestino);
		
		lblFechaIda = new JLabel("Fecha Ida");
		lblFechaIda.setForeground(Color.GRAY);
		lblFechaIda.setBounds(35, 75, 100, 30);
		panelReserva.add(lblFechaIda);
		
	}

	private void agregarCamposPaneReserva() {
		
		cmbOrigen = new JComboBox();
		cmbOrigen.setModel(new DefaultComboBoxModel(new String[] {""}));
		cmbOrigen.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				cargarComboBoxOrigen();
			}
		});
		cmbOrigen.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				actualizarEtiquetaOrigen();
				actualizarComboDestino();
				cargarComboBoxDestino();
				actualizarEtiquetaDestino();

				if (cmbOrigen.getSelectedItem() != null){
					origen = cmbOrigen.getSelectedItem().toString().split("[(]")[0];
				}
				
			}
		});
		cmbOrigen.setBounds(25, 30, 260, 30);
		panelReserva.add(cmbOrigen);
		
		cmbDestino = new JComboBox();
		cmbDestino.setEnabled(false);
		cmbDestino.setModel(new DefaultComboBoxModel(new String[] {""}));
		cmbDestino.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				cargarComboBoxDestino();
				actualizarEtiquetaDestino();
			}
		});
		cmbDestino.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				actualizarEtiquetaDestino();	

				if (cmbDestino.getSelectedItem() != null){
					destino = cmbDestino.getSelectedItem().toString().split("[(]")[0];
				}
			}
		});
		cmbDestino.setBounds(335, 30, 260, 30);
		panelReserva.add(cmbDestino);
		
		chckbxAcumularKilometrosAeropass = new JCheckBox("Acumular Kilómetros AeroManagementPass");
		chckbxAcumularKilometrosAeropass.setSelected(false);
		chckbxAcumularKilometrosAeropass.setForeground(Color.WHITE);
		chckbxAcumularKilometrosAeropass.setBounds(25, 120, 300, 30);
		panelReserva.add(chckbxAcumularKilometrosAeropass);
		
		dateChooserFechaIda = new JDateChooser();
		dateChooserFechaIda.setBounds(25, 75, 260, 30);
		dateChooserFechaIda.setDate(new java.util.Date());
		dateChooserFechaIda.addPropertyChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				
				actualizarEtiquetaDate();
				dateChooserFechaIda.setMinSelectableDate(new java.util.Date());
				
				if (dateChooserFechaIda.getDate() != null){
					fechaIda = new Date(dateChooserFechaIda.getDate().getTime());
				} else{
					fechaIda = null;
				}
				
			}
		});
		dateChooserFechaIda.getCalendarButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actualizarEtiquetaDate();
			}
		});
		dateChooserFechaIda.getCalendarButton().addPropertyChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				actualizarEtiquetaDate();
			}
		});
		panelReserva.add(dateChooserFechaIda);

	}
	
	private void agregarBotonBuscarVuelo() {

		JButton btnBuscarVuelo = new JButton("Buscar Vuelo");
		btnBuscarVuelo.setBounds(25, 160, 200, 40);
		btnBuscarVuelo.setBackground(Color.WHITE);
		btnBuscarVuelo.setFont(new Font("Roboto Regular", Font.PLAIN, 18));
		btnBuscarVuelo.setForeground(new Color(48, 63, 159));
		btnBuscarVuelo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				vC = new ViajeCabeceraImpl();
				
				vC.setCiudadOrigen(origen);
				vC.setCiudadDestino(destino);
				vC.setFechaSalida(fechaIda);
				
				ViajeCabeceraBo vCBo = new ViajeCabeceraBoImpl();
				UsuarioBo uBo = new UsuarioBoImpl();
				
				try {
					
					vCBo.verificarImportantesConFecha(vC);
										
					List<ViajeCabecera> listViajes = vCBo.retornarVuelosPorFecha(vC);
					
					if (!getLogueado()){
						loguear();
					}
					
					String dni = null;

					if (btnPerfil != null){
						dni = uBo.retornarDniPorUsuario(btnPerfil.getText());						
					}
					
					ListadoVuelosUI ui = new ListadoVuelosUI();
						
					ui.setearDni(dni);
					
					ui.mostrarVuelos(listViajes);
					
					ui.setVisible(true);
					
				} catch (NoFlightsFoundException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (ViajeCabeceraNotValidException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}				
			}
		});
		panelReserva.add(btnBuscarVuelo);
	}
	
	private void agregarPanelFrecuente() {
		panelFrecuente = new JPanel();
		panelFrecuente.setBounds((getWidth()/2)+30, 105, (getWidth()/2)-60, (getHeight()/4)+45);
		panelFrecuente.setBackground(new Color(205,220,57));
//		panelFrecuente.setBorder(new MatteBorder(6, 0, 0, 6, Color.BLACK));
		panelFrecuente.setBorder(new MatteBorder(6, 0, 0, 6, new Color(0,80,72)));
		getContentPane().add(panelFrecuente);
		panelFrecuente.setLayout(null);
		
		JLabel lblFrecuente = new JLabel();
		lblFrecuente.setBounds(0,6,panelFrecuente.getWidth()-6,panelFrecuente.getHeight()-6);
		
		ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/frecuente.png"));
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblFrecuente.getWidth(), lblFrecuente.getHeight(), Image.SCALE_DEFAULT));
		
		lblFrecuente.setIcon(icono);
		panelFrecuente.add(lblFrecuente);
	}
	
	private void agregarTabbedPaneOfertas() {
		
		panelOfertas = new JPanel();
		panelOfertas.setOpaque(false);
		panelOfertas.setBounds(30, (getHeight()/2), getWidth()-60, 342);
		panelOfertas.setLayout(null);
		
		agregarPanelOferta1();
		agregarPanelOferta2();
		agregarPanelOferta3();
		
		paneOfertas = new JTabbedPane(JTabbedPane.TOP);
//		paneOfertas.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		paneOfertas.setBounds(30, (getHeight()/2), getWidth()-60, (getHeight()/2)-30);
		getContentPane().add(paneOfertas);
		paneOfertas.addTab("Ofertas especiales", null, panelOfertas, null);
	}

	private void agregarPanelOferta1() {
		
		JPanel panelOferta1 = new JPanel();
		panelOferta1.setBackground(new Color(33,33,33));
		panelOferta1.setBounds(0, 0, (panelOfertas.getWidth()/3), panelOfertas.getHeight()-34);
		panelOferta1.setFont(new Font("Roboto Regular", Font.PLAIN, 18));
		panelOfertas.add(panelOferta1);
		panelOferta1.setLayout(null);

//		JPanel panelImagenAvion = new JPanel();
//		panelImagenAvion.setBounds(1, 20, 55, 40);
//		panelImagenAvion.setBackground(new Color(0,121,107,190));
//		panelImagenAvion.setLayout(null);
//		panelOferta1.add(panelImagenAvion);
//		
//		JLabel lblImagenAvion = new JLabel("");
//		
//		lblImagenAvion.setBounds(0, 0, panelImagenAvion.getWidth(), panelImagenAvion.getHeight());
//
//		ImageIcon imagenAvion = new ImageIcon(getClass().getResource("/imagenes/avion_icono.png"));
//
//		Icon iconoAvion = new ImageIcon(imagenAvion.getImage().getScaledInstance(lblImagenAvion.getWidth(), lblImagenAvion.getHeight(), Image.SCALE_DEFAULT));
//		
//		lblImagenAvion.setIcon(iconoAvion);
//		panelImagenAvion.add(lblImagenAvion);
		
		
		JPanel panelDescuentoOferta = new JPanel();
		panelDescuentoOferta.setBounds(220, 145, 170, 100);
		panelOferta1.add(panelDescuentoOferta);
		panelDescuentoOferta.setBackground(new Color(0,121,107,190));
		panelDescuentoOferta.setLayout(null);
		
		lblDescuentoOferta1 = new JLabel("");
		lblDescuentoOferta1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescuentoOferta1.setBounds(0, 0, 155, 50);
		lblDescuentoOferta1.setForeground(Color.WHITE);
		lblDescuentoOferta1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 22));
		panelDescuentoOferta.add(lblDescuentoOferta1);
		
		JLabel label1 = new JLabel("<html>Desde <em>AR$</em></html>");
		label1.setVerticalAlignment(SwingConstants.TOP);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("Arial", Font.BOLD, 14));
		label1.setBounds(0, 65, 94, 35);
		panelDescuentoOferta.add(label1);
		
		lblPrecioOferta1 = new JLabel("");
		lblPrecioOferta1.setVerticalAlignment(SwingConstants.TOP);
		lblPrecioOferta1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioOferta1.setForeground(Color.WHITE);
		lblPrecioOferta1.setFont(new Font("Arial", Font.BOLD, 20));
		lblPrecioOferta1.setBounds(90, 60, 75, 40);
		panelDescuentoOferta.add(lblPrecioOferta1);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds((panelOferta1.getWidth()/2)-150, 20, 300, 200);
		
		ImageIcon imagenOferta1 = new ImageIcon(getClass().getResource("/imagenes/miami.jpg"));
		Icon iconoOferta1 = new ImageIcon(imagenOferta1.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
		
		lblImagen.setIcon(iconoOferta1);
		lblImagen.setHorizontalAlignment(JLabel.CENTER);
		panelOferta1.add(lblImagen);
		
		lblOrigenOferta1 = new JLabel("Buenos Aires");
		lblOrigenOferta1.setForeground(new Color(245, 245, 245));
		lblOrigenOferta1.setBounds(lblImagen.getX(), 235, 200, 30);
		lblOrigenOferta1.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		panelOferta1.add(lblOrigenOferta1);

		lblDestinoOferta1 = new JLabel("Miami");
		lblDestinoOferta1.setForeground(new Color(251, 192, 45));
		lblDestinoOferta1.setBounds(lblImagen.getX(), 265, 200, 30);
		lblDestinoOferta1.setFont(new Font("Roboto Bold", Font.PLAIN, 22));
		panelOferta1.add(lblDestinoOferta1);
		
		JButton botonReservaOferta1 = new JButton("Reservar");
		botonReservaOferta1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				java.util.Date dateUtil = new java.util.Date();
				Date fechaOferta = new Date(dateUtil.getTime());
				
				vC = new ViajeCabeceraImpl();
				
				vC.setCiudadOrigen(lblOrigenOferta1.getText());
				vC.setCiudadDestino(lblDestinoOferta1.getText());
				vC.setFechaSalida(fechaOferta);

				ViajeCabeceraBo vCBo = new ViajeCabeceraBoImpl();
				UsuarioBo uBo = new UsuarioBoImpl();
				
				try {
					
					List<ViajeCabecera> listViajes = vCBo.retornarVuelosCualquierFecha(vC);

					if (!getLogueado()){
						loguear();
					}

					String dni = null;
					
					if (btnPerfil != null){
						dni = uBo.retornarDniPorUsuario(btnPerfil.getText());						
					}
					
					ListadoVuelosUI ui = new ListadoVuelosUI();
					
					ui.setearDni(dni);
					
					ui.mostrarVuelos(listViajes);
					
					ui.setVisible(true);
				
				} catch (NoFlightsFoundException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

			}
		});
		botonReservaOferta1.setBounds(panelOferta1.getWidth()-110, panelOferta1.getHeight()-50,100,40);
		panelOferta1.add(botonReservaOferta1);
	}

	private void agregarPanelOferta2() {
		
		JPanel panelOferta2 = new JPanel();
		panelOferta2.setBackground(new Color(33,33,33));
		panelOferta2.setBounds((panelOfertas.getWidth()/3)+1, 0, (panelOfertas.getWidth()/3), panelOfertas.getHeight()-34);
		panelOfertas.add(panelOferta2);
		panelOferta2.setLayout(null);
		

		JPanel panelDescuentoOferta = new JPanel();
		panelDescuentoOferta.setBounds(220, 145, 170, 100);
		panelOferta2.add(panelDescuentoOferta);
		panelDescuentoOferta.setBackground(new Color(0,121,107,190));
		panelDescuentoOferta.setLayout(null);

		lblDescuentoOferta2 = new JLabel("");
		lblDescuentoOferta2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescuentoOferta2.setBounds(0, 0, 155, 50);
		lblDescuentoOferta2.setForeground(Color.WHITE);
		lblDescuentoOferta2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 22));
		panelDescuentoOferta.add(lblDescuentoOferta2);
		
		JLabel label1 = new JLabel("<html>Desde <em>AR$</em></html>");
		label1.setVerticalAlignment(SwingConstants.TOP);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("Arial", Font.BOLD, 14));
		label1.setBounds(0, 65, 94, 35);
		panelDescuentoOferta.add(label1);
		
		lblPrecioOferta2 = new JLabel("");
		lblPrecioOferta2.setVerticalAlignment(SwingConstants.TOP);
		lblPrecioOferta2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioOferta2.setForeground(Color.WHITE);
		lblPrecioOferta2.setFont(new Font("Arial", Font.BOLD, 20));
		lblPrecioOferta2.setBounds(90, 60, 75, 40);
		panelDescuentoOferta.add(lblPrecioOferta2);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds((panelOferta2.getWidth()/2)-150, 20, 300, 200);
		
		ImageIcon imagenOferta2 = new ImageIcon(getClass().getResource("/imagenes/roma.jpg"));
		
		Icon iconoOferta2 = new ImageIcon(imagenOferta2.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
				
		lblImagen.setIcon(iconoOferta2);
		lblImagen.setHorizontalAlignment(JLabel.CENTER);
		panelOferta2.add(lblImagen);
		
		lblOrigenOferta2 = new JLabel("Buenos Aires");
		lblOrigenOferta2.setForeground(new Color(245, 245, 245));
		lblOrigenOferta2.setBounds(lblImagen.getX(), 235, 200, 30);
		lblOrigenOferta2.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		panelOferta2.add(lblOrigenOferta2);

		lblDestinoOferta2 = new JLabel("Roma");
		lblDestinoOferta2.setForeground(new Color(251, 192, 45));
		lblDestinoOferta2.setBounds(lblImagen.getX(), 265, 200, 30);
		lblDestinoOferta2.setFont(new Font("Roboto Bold", Font.PLAIN, 22));
		panelOferta2.add(lblDestinoOferta2);
		
		JButton botonReservaOferta2 = new JButton("Reservar");
		botonReservaOferta2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				java.util.Date dateUtil = new java.util.Date();
				Date fechaOferta = new Date(dateUtil.getTime());
				
				vC = new ViajeCabeceraImpl();
				
				vC.setCiudadOrigen(lblOrigenOferta2.getText());
				vC.setCiudadDestino(lblDestinoOferta2.getText());
				vC.setFechaSalida(fechaOferta);

				ViajeCabeceraBo vCBo = new ViajeCabeceraBoImpl();
				UsuarioBo uBo = new UsuarioBoImpl();
				
				try {
					
					List<ViajeCabecera> listViajes = vCBo.retornarVuelosCualquierFecha(vC);
	
					if (!getLogueado()){
						loguear();
					}

					String dni = null;
					
					if (btnPerfil != null){
						dni = uBo.retornarDniPorUsuario(btnPerfil.getText());						
					}
					
					ListadoVuelosUI ui = new ListadoVuelosUI();
					
					ui.setearDni(dni);
					
					ui.mostrarVuelos(listViajes);
					
					ui.setVisible(true);
				
				} catch (NoFlightsFoundException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		botonReservaOferta2.setBounds(panelOferta2.getWidth()-110, panelOferta2.getHeight()-50,100,40);
		panelOferta2.add(botonReservaOferta2);
	}
	
	private void agregarPanelOferta3() {
		
		JPanel panelOferta3 = new JPanel();
		panelOferta3.setBackground(new Color(33,33,33));
		panelOferta3.setBounds((2*panelOfertas.getWidth()/3)+1, 0, (panelOfertas.getWidth()/3), panelOfertas.getHeight()-34);
		panelOfertas.add(panelOferta3);
		panelOferta3.setLayout(null);
		

		JPanel panelDescuentoOferta = new JPanel();
		panelDescuentoOferta.setBounds(220, 145, 170, 100);
		panelOferta3.add(panelDescuentoOferta);
		panelDescuentoOferta.setBackground(new Color(0,121,107,190));
		panelDescuentoOferta.setLayout(null);

		lblDescuentoOferta3 = new JLabel("");
		lblDescuentoOferta3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescuentoOferta3.setBounds(0, 0, 155, 50);
		lblDescuentoOferta3.setForeground(Color.WHITE);
		lblDescuentoOferta3.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 22));
		panelDescuentoOferta.add(lblDescuentoOferta3);
		
		JLabel label1 = new JLabel("<html>Desde <em>AR$</em></html>");
		label1.setVerticalAlignment(SwingConstants.TOP);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("Arial", Font.BOLD, 14));
		label1.setBounds(0, 65, 94, 35);
		panelDescuentoOferta.add(label1);
		
		lblPrecioOferta3 = new JLabel("<html><strong>2000.12</strong></html>");
		lblPrecioOferta3.setVerticalAlignment(SwingConstants.TOP);
		lblPrecioOferta3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioOferta3.setForeground(Color.WHITE);
		lblPrecioOferta3.setFont(new Font("Arial", Font.BOLD, 20));
		lblPrecioOferta3.setBounds(90, 60, 75, 40);
		panelDescuentoOferta.add(lblPrecioOferta3);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds((panelOferta3.getWidth()/2)-150, 20, 300, 200);
		
		ImageIcon imagenOferta3 = new ImageIcon(getClass().getResource("/imagenes/baires.jpg"));
		
		Icon iconoOferta3 = new ImageIcon(imagenOferta3.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));

		lblImagen.setIcon(iconoOferta3);
		lblImagen.setHorizontalAlignment(JLabel.CENTER);
		panelOferta3.add(lblImagen);
		
		lblOrigenOferta3 = new JLabel("Cordoba");
		lblOrigenOferta3.setForeground(new Color(245, 245, 245));
		lblOrigenOferta3.setBounds(lblImagen.getX(), 235, 200, 30);
		lblOrigenOferta3.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		panelOferta3.add(lblOrigenOferta3);
		
		lblDestinoOferta3 = new JLabel("Buenos Aires");
		lblDestinoOferta3.setForeground(new Color(251, 192, 45));
		lblDestinoOferta3.setBounds(lblImagen.getX(), 265, 200, 30);
		lblDestinoOferta3.setFont(new Font("Roboto Bold", Font.PLAIN, 22));
		panelOferta3.add(lblDestinoOferta3);
		
		JButton botonReservaOferta3 = new JButton("Reservar");
		botonReservaOferta3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				java.util.Date dateUtil = new java.util.Date();
				Date fechaOferta = new Date(dateUtil.getTime());
				
				vC = new ViajeCabeceraImpl();
				
				vC.setCiudadOrigen(lblOrigenOferta3.getText());
				vC.setCiudadDestino(lblDestinoOferta3.getText());
				vC.setFechaSalida(fechaOferta);

				ViajeCabeceraBo vCBo = new ViajeCabeceraBoImpl();
				UsuarioBo uBo = new UsuarioBoImpl();
				
				try {
					
					List<ViajeCabecera> listViajes = vCBo.retornarVuelosCualquierFecha(vC);
					
					if (!getLogueado()){
						loguear();
					}
					
					String dni = null;

					if (btnPerfil != null){
						dni = uBo.retornarDniPorUsuario(btnPerfil.getText());						
					}
					
					ListadoVuelosUI ui = new ListadoVuelosUI();
					
					ui.setearDni(dni);
					
					ui.mostrarVuelos(listViajes);
					
					ui.setVisible(true);
				
				} catch (NoFlightsFoundException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		botonReservaOferta3.setBounds(panelOferta3.getWidth()-110, panelOferta3.getHeight()-50,100,40);
		panelOferta3.add(botonReservaOferta3);
	}
	
	private void actualizarEtiquetaOrigen() {

		if (cmbOrigen.getSelectedIndex() != 0){
			panelReserva.remove(lblOrigen);					
		}else {
			panelReserva.add(lblOrigen);
			panelReserva.setComponentZOrder(lblOrigen, 1);
		}
		
		validate();
		repaint();
	}
	
	private void actualizarEtiquetaDestino() {
	
		if (cmbDestino.getSelectedIndex() != 0){
			panelReserva.remove(lblDestino);					
		}else {
			panelReserva.add(lblDestino);
			panelReserva.setComponentZOrder(lblDestino, 1);
		}
		
		validate();
		repaint();
	}
	
	private void actualizarEtiquetaDate() {

		if (dateChooserFechaIda.getDate() != null){
			panelReserva.remove(lblFechaIda);
		}else {
			panelReserva.add(lblFechaIda);
			panelReserva.setComponentZOrder(lblFechaIda, 5);
		}
		
		validate();
		repaint();
	}
	
	private void actualizarComboDestino(){
	
		if (cmbOrigen.getSelectedIndex() != 0){
			cmbDestino.setEnabled(true);
		}else{
			cmbDestino.setEnabled(false);
		}
		
		validate();
		repaint();
	}
	
	private void cargarComboBoxOrigen(){
		
		ViajeCabeceraBo vCBo = new ViajeCabeceraBoImpl();
		
		cmbOrigen.removeAllItems();

		cmbOrigen.addItem("");
		
		for (String origen : vCBo.retornarOrigenes()) {
			cmbOrigen.addItem(origen);
		}
		
		cmbDestino.setSelectedIndex(0);
	}
	
	private void cargarComboBoxDestino(){
		
		ViajeCabeceraBo vCBo = new ViajeCabeceraBoImpl();
		
		cmbDestino.removeAllItems();
		
		cmbDestino.addItem("");
		
		for (String destino : vCBo.retornarDestinos()) {	
			if (!destino.equals(cmbOrigen.getSelectedItem())){
				cmbDestino.addItem(destino);
			}
		}
		
		cmbDestino.setSelectedIndex(0);
	}
	
	protected void agregarBotonesNoLogueado() {
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(getWidth()-300, 30, 140, 35);
		btnRegistrarse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				registrar();
			}
		});
		getContentPane().add(btnRegistrarse);
		
		btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.setBounds(getWidth()-150, 30, 140, 35);
		btnIniciarSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loguear();
			}
		});
		getContentPane().add(btnIniciarSesion);
		
		getContentPane().validate();
		getContentPane().repaint();
	}
	
	protected void agregarBotonesLogueado() {

		btnPerfil.setToolTipText("Ver perfil");
		btnPerfil.setBounds(getWidth()-300, 30, 140, 35);
		btnPerfil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				verPerfil();
			}

		});
		getContentPane().add(btnPerfil);
		
		btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.setBounds(getWidth()-150, 30, 140, 35);
		btnCerrarSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setLogueado(false);
				dispose();
				PlantillaMF ui = new MainFrameUI();
			}
		});
		getContentPane().add(btnCerrarSesion);
		
		getContentPane().validate();
		getContentPane().repaint();
	}
	
//	private void removerBotonesLogueado(){
//		remove(btnPerfil);
//		remove(btnCerrarSesion);
//	}
	
	private void loguear(){
		dispose();
		DialogLogin d = new DialogLogin();
	}
	
	private void registrar(){
		DialogRegistrarse d = new DialogRegistrarse();
	}
	
	private void verPerfil() {
		
		PersonaRegistradaBo pBo = new PersonaRegistradaBoImpl();
		
		PersonaRegistrada persona = pBo.retornarPersonaPorUsuario(btnPerfil.getText());
		
		DialogPerfil ui = new DialogPerfil();
		
		ui.agregarPanelPersona(persona);
		
		ui.getLabelAvatar().setToolTipText(btnPerfil.getText());

		ui.setVisible(true);
	}

	protected void confirmarSalida() {
		
		String ObjButtons[] = {"Si","No"};
	    
		int PromptResult = JOptionPane.showOptionDialog(null, 
	        "Estas seguro que deseas salir?", "Advertencia", 
	        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, 
	        ObjButtons,ObjButtons[1]);
	    
		if(PromptResult == 0) {
			System.exit(0);          
	    }
	}

    protected void pintarComponentes(){

//    	if (getLogueado()){
//    		if (btnPerfil != null){
//    			btnPerfil.setBounds(getWidth()-300, 30, 140, 35);
//    			btnCerrarSesion.setBounds(getWidth()-150, 30, 140, 35);
//    		}
//    	}else{
//    		if (btnRegistrarse != null){
//    			btnRegistrarse.setBounds(getWidth()-300, 30, 140, 35);
//    			btnIniciarSesion.setBounds(getWidth()-150, 30, 140, 35);
//    		}
//    	}
    	
		menuBar.setBounds(0, 0, getWidth(), 20);
		
    	validate();
		repaint();
    	
//		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
//		
//		if (getWidth() <= (int)(d.getWidth()/2)){
//			paneReserva.setBounds(30, 80, getWidth()-60, (getHeight()/4)+70);
//			setBounds(getWidth()/2, 0, getWidth(), getHeight());
//		}else{
//			
//			paneReserva.setBounds(30, 80, (getWidth()/2)-30, (getHeight()/4)+70);
//			paneOfertas.setBounds(30, (getHeight()/2), getWidth()-60, (getHeight()/2)-30);
//		}
	}
	
	private void agregarMenu(){

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, getWidth(), 20);
		getContentPane().add(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmarSalida();
			}
		});
		mnArchivo.add(mntmSalir);
//		
//		JMenu mnDestinos = new JMenu("Destinos");
//		menuBar.add(mnDestinos);
//		
//		JMenuItem mntmArgentina = new JMenuItem("Argentina");
//		mnDestinos.add(mntmArgentina);
//		
//		JMenuItem mntmBrasil = new JMenuItem("Brasil");
//		mnDestinos.add(mntmBrasil);
//		
//		JMenuItem mntmMexico = new JMenuItem("Mexico");
//		mnDestinos.add(mntmMexico);
//		
//		JMenuItem mntmEEUU = new JMenuItem("Estados Unidos");
//		mnDestinos.add(mntmEEUU);
//	
//		JMenuItem mntmColombia = new JMenuItem("Colombia");
//		mnDestinos.add(mntmColombia);
//	
//		JMenuItem mntmOceania = new JMenuItem("Oceania");
//		mnDestinos.add(mntmOceania);
//		
//		JMenuItem mntmEuropa = new JMenuItem("Europa");
//		mnDestinos.add(mntmEuropa);
		
	}
	
	public void agregarMenuAdmin(){
		
		JMenu mnAcciones = new JMenu("Acciones");
		menuBar.add(mnAcciones);
		
		JMenu mnVuelos = new JMenu("Vuelos");
		mnAcciones.add(mnVuelos);
		
		JMenuItem mntmCargarVuelo = new JMenuItem("Cargar vuelo");
		mntmCargarVuelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarVuelo();
			}
		});
		mnVuelos.add(mntmCargarVuelo);
		
		JMenuItem mntmModificarVuelo = new JMenuItem("Modificar vuelo");
		mntmModificarVuelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarVuelo();				
			}
		});
		mnVuelos.add(mntmModificarVuelo);
		
		JMenuItem mntmEliminarVuelo = new JMenuItem("Eliminar vuelo");
		mntmEliminarVuelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarVuelo();
			}
		});
		mnVuelos.add(mntmEliminarVuelo);

		
		JMenu mnOfertas = new JMenu("Ofertas");
		mnAcciones.add(mnOfertas);
		
		JMenuItem mntmCargarOferta = new JMenuItem("Cargar oferta");
		mntmCargarOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarOferta();
			}
		});
		mnOfertas.add(mntmCargarOferta);
		
		JMenuItem mntmModificarOferta = new JMenuItem("Modificar oferta");
		mntmModificarOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarOferta();
			}
		});
		mnOfertas.add(mntmModificarOferta);
		
		JMenuItem mntmEliminarOferta = new JMenuItem("Eliminar oferta");
		mntmEliminarOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarOferta();
			}			
		});
		mnOfertas.add(mntmEliminarOferta);
		
	}
	
	private void cargarVuelo() {
		DialogLoadFlight dlf = new DialogLoadFlight();			
	}
	
	private void modificarVuelo() {
		DialogLoadFlight dlf = new DialogLoadFlight();			
	}
	
	private void eliminarVuelo() {
		DialogRemoveFlight drf = new DialogRemoveFlight();
	}
	
	private void cargarOferta() {
		DialogLoadFlight dlf = new DialogLoadFlight();			
	}
	
	private void modificarOferta() {
		DialogLoadFlight dlf = new DialogLoadFlight();			
	}
	
	private void eliminarOferta() {
		DialogLoadFlight dlf = new DialogLoadFlight();			
	}
	
	protected void agregarInfoPanelOferta1(){
		
		ViajeCabeceraBo vCBo = new ViajeCabeceraBoImpl();
		
		ViajeCabecera vC = new ViajeCabeceraImpl();
		
		vC.setCiudadOrigen(lblOrigenOferta1.getText());
		vC.setCiudadDestino(lblDestinoOferta1.getText());
		
		try {
			
			ViajeCabecera viaje = vCBo.retornarVuelosCualquierFecha(vC).get(0);
			
			Integer descuento = (int)(viaje.getOferta()*100);
			
			lblDescuentoOferta1.setText(descuento.toString()+"% OFF");
			
			lblPrecioOferta1.setText("<html><strong>"+String.format("%.2f", viaje.getPrecioClaseTur())+"</strong></html>");
			
		} catch (NoFlightsFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	protected void agregarInfoPanelOferta2(){
		
		ViajeCabeceraBo vCBo = new ViajeCabeceraBoImpl();
		
		ViajeCabecera vC = new ViajeCabeceraImpl();
		
		vC.setCiudadOrigen(lblOrigenOferta2.getText());
		vC.setCiudadDestino(lblDestinoOferta2.getText());
		
		try {
			
			ViajeCabecera viaje = vCBo.retornarVuelosCualquierFecha(vC).get(0);
			
			Integer descuento = (int)(viaje.getOferta()*100);
			
			lblDescuentoOferta2.setText(descuento.toString()+"% OFF");

			lblPrecioOferta2.setText("<html><strong>"+String.format("%.2f", viaje.getPrecioClaseTur())+"</strong></html>");
			
		} catch (NoFlightsFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	protected void agregarInfoPanelOferta3(){
		
		ViajeCabeceraBo vCBo = new ViajeCabeceraBoImpl();
		
		ViajeCabecera vC = new ViajeCabeceraImpl();
		
		vC.setCiudadOrigen(lblOrigenOferta3.getText());
		vC.setCiudadDestino(lblDestinoOferta3.getText());
		
		try {
			
			ViajeCabecera viaje = vCBo.retornarVuelosCualquierFecha(vC).get(0);
			
			Integer descuento = (int)(viaje.getOferta()*100);
			
			lblDescuentoOferta3.setText(descuento.toString()+"% OFF");
			
			lblPrecioOferta3.setText("<html><strong>"+String.format("%.2f", viaje.getPrecioClaseTur())+"</strong></html>");
			
		} catch (NoFlightsFoundException e) {
			e.printStackTrace();
		}
		
	}

	public Boolean getLogueado() {
		return logueado;
	}

	public void setLogueado(Boolean logueado) {
		this.logueado = logueado;
	}
	
	public JButton getBtnPerfil() {
		return btnPerfil;
	}
	
	public void setBtnPerfil(JButton btnPerfil) {
		this.btnPerfil = btnPerfil;
	}

}