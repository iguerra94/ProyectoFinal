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
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import org.proyectofinal.bo.ex.ViajeCabeceraNotFoundException;
import org.proyectofinal.bo.ex.ViajeCabeceraNotFoundParametersException;
import org.proyectofinal.bo.ex.ViajeCabeceraNotValidException;
import org.proyectofinal.bo.ex.ViajeCabeceraOfferNotFoundException;
import org.proyectofinal.bo.impl.PersonaRegistradaBoImpl;
import org.proyectofinal.bo.impl.UsuarioBoImpl;
import org.proyectofinal.bo.impl.ViajeCabeceraBoImpl;
import org.proyectofinal.bo.interfaces.PersonaRegistradaBo;
import org.proyectofinal.bo.interfaces.UsuarioBo;
import org.proyectofinal.bo.interfaces.ViajeCabeceraBo;
import org.proyectofinal.model.impl.ViajeCabeceraImpl;
import org.proyectofinal.model.interfaces.PersonaRegistrada;
import org.proyectofinal.model.interfaces.ViajeCabecera;
import org.proyectofinal.ui.DialogLoadFlight;
import org.proyectofinal.ui.DialogLoadOffer;
import org.proyectofinal.ui.DialogLogin;
import org.proyectofinal.ui.DialogPerfil;
import org.proyectofinal.ui.DialogRegistrarse;
import org.proyectofinal.ui.DialogRemoveFlight;
import org.proyectofinal.ui.DialogRemoveOffer;
import org.proyectofinal.ui.DialogSelectFlight;
import org.proyectofinal.ui.ListadoVuelosUI;
import org.proyectofinal.ui.MainFrameUI;

import com.toedter.calendar.JDateChooser;

public class PlantillaMF extends JFrame {
	
	private static final long serialVersionUID = -9218140826797976946L;
	
	private Boolean logueado = false;
	private JMenuBar menuBar;
	private JButton btnRegistrarse;
	private JButton btnIniciarSesion;
	JPanel panelBotonesLogueado;
	private JButton btnPerfil;
	private JButton btnCerrarSesion;
	private JPanel panelReserva;
	private JPanel panelFrecuente;
	private JPanel panelOfertas;
	private JLabel lblOrigen;
	private JComboBox<String> cmbOrigen;
	private JLabel lblFlecha;
	private JLabel lblDestino;
	private JComboBox<String> cmbDestino;
	private JLabel lblFechaIda;
	private JDateChooser dateChooserFechaIda;
	private JCheckBox chckbxAcumularKilometrosAeropass;
	private ViajeCabecera vC;
	private String origen;
	private String destino;
	private Date fechaIda;
	private String dni;
	
	public PlantillaMF() {

	}
	
	protected void inicializarAtributos(){
		setTitle("AeroManagement");
		setSize(1301,744);
		getContentPane().setBackground(Color.WHITE);
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage());
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		getContentPane().setLayout(null);
	}
	
	protected void inicializarComponentes(){
		
		agregarMenu();
		agregarPanelReserva();
		agregarPanelFrecuente();
		agregarPanelOfertas();
	}

	private void agregarPanelReserva() {
		
		JPanel panelEtiquetaReserva = new JPanel();
		panelEtiquetaReserva.setBackground(new Color(27,0,136));
		panelEtiquetaReserva.setBounds(30, 99, 200, 40);
		panelEtiquetaReserva.setLayout(null);
		getContentPane().add(panelEtiquetaReserva);
		
//		JLabel labelBordeEtiquetaReserva = new JLabel();
//		labelBordeEtiquetaReserva.setBorder(new MatteBorder(0,1,1,0, Color.WHITE));
//		labelBordeEtiquetaReserva.setIcon(new ImageIcon(getClass().getResource("/imagenes/borde_et_reserva.png")));
//		labelBordeEtiquetaReserva.setBounds(180, 0, 20, 20);
//		panelEtiquetaReserva.add(labelBordeEtiquetaReserva);
		
		JLabel labelBordeEtiquetaReserva2 = new JLabel();
		labelBordeEtiquetaReserva2.setBorder(new MatteBorder(0,0,1,1, Color.WHITE));
		labelBordeEtiquetaReserva2.setIcon(new ImageIcon(getClass().getResource("/imagenes/borde_et_reserva2.png")));
		labelBordeEtiquetaReserva2.setBounds(0, 0, 20, 20);
		panelEtiquetaReserva.add(labelBordeEtiquetaReserva2);
		
		JLabel labelEtiquetaReserva = new JLabel("Reserva tu vuelo");
		labelEtiquetaReserva.setFont(new Font("Roboto Bold", Font.PLAIN, 16));
		labelEtiquetaReserva.setHorizontalAlignment(JLabel.CENTER);
		labelEtiquetaReserva.setForeground(Color.WHITE);
		labelEtiquetaReserva.setBounds(20, 0, 175, 40);
		panelEtiquetaReserva.add(labelEtiquetaReserva);
			
		
		panelReserva = new JPanel();
		panelReserva.setBackground(new Color(27,0,136));
		panelReserva.setBounds(30, 140, (getWidth()/2)-30, (getHeight()/4)+30);
		panelReserva.setLayout(null);
		getContentPane().add(panelReserva);
		
		agregarLabelsPaneReserva();
		agregarBotonBuscarVuelo();
		agregarCamposPaneReserva();
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
		
		cmbOrigen = new JComboBox<String>();
		cmbOrigen.setModel(new DefaultComboBoxModel<String>(new String[] {""}));
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
		
		cmbDestino = new JComboBox<String>();
		cmbDestino.setEnabled(false);
		cmbDestino.setModel(new DefaultComboBoxModel<String>(new String[] {""}));
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
		btnBuscarVuelo.setBackground(new Color(0,100,90));
		btnBuscarVuelo.setFont(new Font("Roboto Light", Font.PLAIN, 18));
		btnBuscarVuelo.setForeground(Color.WHITE);
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
				
					String dni = "";
					
					if (getLogueado()){
						dni = uBo.retornarDniPorUsuario(btnPerfil.getText());
					}					
					
					ListadoVuelosUI ui = new ListadoVuelosUI();
					
					if (chckbxAcumularKilometrosAeropass.isSelected()){
						ui.setearDniyAcumula(dni, true);
					}else{
						ui.setearDniyAcumula(dni, false);
					}
					
					ui.mostrarVuelos(listViajes);
					
					ui.setVisible(true);

				} catch (ViajeCabeceraNotValidException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (ViajeCabeceraNotFoundParametersException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
							
			}
		});
		panelReserva.add(btnBuscarVuelo);
	}
	
	private void agregarPanelFrecuente() {
		
		panelFrecuente = new JPanel();
		panelFrecuente.setBounds((getWidth()/2)+30, 140, (getWidth()/2)-60, (getHeight()/4)+30);
		panelFrecuente.setBackground(new Color(27,0,136));
		panelFrecuente.setLayout(null);
		getContentPane().add(panelFrecuente);
		
		JLabel lblFrecuente = new JLabel();
		lblFrecuente.setBounds(0,6,panelFrecuente.getWidth()-6,panelFrecuente.getHeight()-6);
		
		ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/frecuente.png"));
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblFrecuente.getWidth(), lblFrecuente.getHeight(), Image.SCALE_DEFAULT));
		
		lblFrecuente.setIcon(icono);
		panelFrecuente.add(lblFrecuente);
	}
	
	private void agregarPanelOfertas(){
		
		panelOfertas = new JPanel();
		panelOfertas.setOpaque(false);
		panelOfertas.setBounds(30, 372, getWidth()-60, 350);
		panelOfertas.setLayout(null);
		getContentPane().add(panelOfertas);
		
	}
	
	protected void cargarOfertas(List<ViajeCabecera> listaViajes){
		
//		scrollPane = new JScrollPane();
//		scrollPane.setBounds(10, 30, 730, 240);
//		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
//		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//		scrollPane.setViewportView(panelVuelos);
//		scrollPane.getViewport().setView(panelVuelos);
//		getContentPane().add(scrollPane);

		panelOfertas.removeAll();
		
		int i = 0;
		
		for (ViajeCabecera viaje : listaViajes) {		
			agregarPanelOferta(viaje, i);
			i++;
		}
		
	}
	
	protected void removePanelOfertas(){
		getContentPane().remove(panelOfertas);
	}

	private void agregarPanelOferta(ViajeCabecera viaje, int i) {
		
		JPanel panelOferta = new JPanel();
		panelOferta.setBackground(new Color(0,121,107));
		panelOferta.setBounds((300*i),0,280,350);
		panelOferta.setFont(new Font("Roboto Regular", Font.PLAIN, 18));
		panelOfertas.add(panelOferta);
		panelOferta.setLayout(null);
		
		JLabel bordeImagenOferta = new JLabel();
		bordeImagenOferta.setIcon(new ImageIcon(getClass().getResource("/imagenes/borde_imagen_oferta.png")));
		bordeImagenOferta.setBounds(0, 170, 280, 10);
		panelOferta.add(bordeImagenOferta);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds(0, 0, 280, 180);
		
		ImageIcon imagenOferta = new ImageIcon(getClass().getResource(viaje.getImagenOferta()));
		Icon iconoOferta = new ImageIcon(imagenOferta.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));

		lblImagen.setIcon(iconoOferta);
		lblImagen.setHorizontalAlignment(JLabel.CENTER);
		panelOferta.add(lblImagen);
		
		JLabel lblOrigenOferta = new JLabel(viaje.getCiudadOrigen());
		lblOrigenOferta.setForeground(new Color(245, 245, 245));
		lblOrigenOferta.setBounds(15, 200, 200, 30);
		lblOrigenOferta.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		panelOferta.add(lblOrigenOferta);

		JLabel lblDestinoOferta = new JLabel(viaje.getCiudadDestino());
		lblDestinoOferta.setForeground(new Color(245, 245, 245));
		lblDestinoOferta.setBounds(15, 235, 200, 30);
		lblDestinoOferta.setFont(new Font("Roboto Bold", Font.PLAIN, 22));
		panelOferta.add(lblDestinoOferta);

		
		JLabel label1 = new JLabel("<html>Desde <em>AR$</em></html>");
		label1.setVerticalAlignment(SwingConstants.TOP);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		label1.setBounds(105, 270, 90, 40);
		panelOferta.add(label1);
		
		JLabel lblPrecioOferta = new JLabel(viaje.getPrecioClaseTur().toString());
		lblPrecioOferta.setVerticalAlignment(SwingConstants.TOP);
		lblPrecioOferta.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioOferta.setForeground(Color.WHITE);
		lblPrecioOferta.setFont(new Font("Roboto Regular", Font.BOLD, 20));
		lblPrecioOferta.setBounds(190, 265, 80, 40);
		panelOferta.add(lblPrecioOferta);
		
		JPanel panelDescuentoOferta = new JPanel();
		panelDescuentoOferta.setBounds(125, 300, 130, 40);
		panelOferta.add(panelDescuentoOferta);
		panelDescuentoOferta.setBackground(new Color(0,102,97));
		panelDescuentoOferta.setLayout(null);
		
		Double oferta = Double.parseDouble(viaje.getOferta())*100; 
		
		String ofertaS = oferta.toString().substring(0, oferta.toString().length()-2);
		
		
		JLabel lblDescuentoOferta = new JLabel(ofertaS +"% OFF");
		lblDescuentoOferta.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescuentoOferta.setBounds(0, 0, 130, 40);
		lblDescuentoOferta.setForeground(Color.WHITE);
		lblDescuentoOferta.setFont(new Font("Roboto Regular", Font.BOLD | Font.ITALIC, 22));
		panelDescuentoOferta.add(lblDescuentoOferta);
		
		
//		botonReservaOferta = new JButton("Reservar");
//		botonReservaOferta.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				if (!getLogueado()){
//					loguear();
//				}else{
//				
//					java.util.Date dateUtil = new java.util.Date();
//					Date fechaOferta = new Date(dateUtil.getTime());
//					
//					vC = new ViajeCabeceraImpl();
//					
//					vC.setCiudadOrigen(lblOrigenOferta.getText());
//					vC.setCiudadDestino(lblDestinoOferta.getText());
//					vC.setFechaSalida(fechaOferta);
//					
//					ViajeCabeceraBo vCBo = new ViajeCabeceraBoImpl();
//					UsuarioBo uBo = new UsuarioBoImpl();
//						
//					try {
//						
//						List<ViajeCabecera> listViajes = vCBo.retornarVuelosCualquierFecha(vC);
//	
//						String dni = uBo.retornarDniPorUsuario(btnPerfil.getText());
//						
//						ListadoVuelosUI ui = new ListadoVuelosUI();
//						
//						ui.setearDniyAcumula(dni, true);
//						ui.mostrarVuelos(listViajes);
//						
//						ui.setVisible(true);
//					
//					} catch (NoFlightsFoundException e1) {
//						e1.printStackTrace();
//					}
//				}
//
//
//			}
//		});
//		botonReservaOferta.setBounds(panelOferta.getWidth()-110, panelOferta.getHeight()-50,100,40);
//		panelOferta.add(botonReservaOferta);
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
	
	protected void cargarComboBoxOrigen(){
		
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
		
		for (String destino : vCBo.retornarDestinos(origen)) {	
			if (!destino.equals(cmbOrigen.getSelectedItem())){
				cmbDestino.addItem(destino);
			}
		}
		
		cmbDestino.setSelectedIndex(0);
	}
	
	protected void agregarBotonesNoLogueado() {
		
		JPanel panelBotonesNoLogueado = new JPanel();
		panelBotonesNoLogueado.setBounds(0, 20, 1301, 50);
		panelBotonesNoLogueado.setBackground(new Color(27,0,136));
		panelBotonesNoLogueado.setLayout(null);
		getContentPane().add(panelBotonesNoLogueado);
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		btnRegistrarse.setBackground(new Color(179,15,59));
		btnRegistrarse.setForeground(Color.WHITE);
		btnRegistrarse.setBounds(getWidth()-300, 8, 140, 35);
		btnRegistrarse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				registrar();
			}
		});
		panelBotonesNoLogueado.add(btnRegistrarse);
		
		btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		btnIniciarSesion.setBackground(new Color(179,15,59));
		btnIniciarSesion.setForeground(Color.WHITE);
		btnIniciarSesion.setBounds(getWidth()-150, 8, 140, 35);
		btnIniciarSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loguear();
			}
		});
		panelBotonesNoLogueado.add(btnIniciarSesion);
		
		panelBotonesNoLogueado.validate();
		panelBotonesNoLogueado.repaint();
	}
	
	public void agregarBotonPerfil(String usuario){
	
		panelBotonesLogueado = new JPanel();
		panelBotonesLogueado.setBounds(0, 20, 1301, 50);
		panelBotonesLogueado.setBackground(new Color(27,0,136));
		panelBotonesLogueado.setLayout(null);
		getContentPane().add(panelBotonesLogueado);
		
		btnPerfil = new JButton(usuario);
		btnPerfil.setToolTipText("Ver perfil");
		btnPerfil.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		btnPerfil.setBackground(new Color(179,15,59));
		btnPerfil.setForeground(Color.WHITE);
		btnPerfil.setBounds(getWidth()-300, 8, 140, 35);
		btnPerfil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				verPerfil();
			}

		});
		panelBotonesLogueado.add(btnPerfil);

		getContentPane().validate();
		getContentPane().repaint();
	}
	
	public void agregarBotonesLogueado() {
		
		btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		btnCerrarSesion.setBackground(new Color(179,15,59));
		btnCerrarSesion.setForeground(Color.WHITE);
		btnCerrarSesion.setBounds(getWidth()-150, 8, 140, 35);
		btnCerrarSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setLogueado(false);
				dispose();
				PlantillaMF ui = new MainFrameUI();
				ui.setVisible(true);
			}
		});
		panelBotonesLogueado.add(btnCerrarSesion);
		
		getContentPane().validate();
		getContentPane().repaint();
	}
	
	private void loguear(){
		dispose();
		DialogLogin d = new DialogLogin("");
		d.setVisible(true);
	}
	
	private void registrar(){
		DialogRegistrarse d = new DialogRegistrarse();
		d.setVisible(true);
	}
	
	private void verPerfil() {
		
		PersonaRegistradaBo pBo = new PersonaRegistradaBoImpl();
		
		PersonaRegistrada persona = pBo.retornarPersonaPorUsuario(btnPerfil.getText());
		
		DialogPerfil ui = new DialogPerfil();
		
		ui.getLabelAvatar().setToolTipText(btnPerfil.getText());

		ui.agregarLabelsInfo(persona);
		
		ui.agregarPanelDatos(persona);
		
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
		menuBar.setBounds(0, 0, 1301, 20);
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
		
		JMenuItem mntmCargarOferta = new JMenuItem("Cargar/Modificar oferta");
		mntmCargarOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarOferta();
			}
		});
		mnOfertas.add(mntmCargarOferta);
		
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
		dlf.setVisible(true);
	}
	
	private void modificarVuelo() {

		try {
			
			ViajeCabeceraBo vCBo = new ViajeCabeceraBoImpl();

			List<ViajeCabecera> listaVuelos = vCBo.consultarVuelos();

			if ( listaVuelos.size() > 0 ){								
				DialogSelectFlight dsf = new DialogSelectFlight();
				dsf.setVisible(true);
			}
	
		} catch (ViajeCabeceraNotFoundException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}

	}
	
	private void eliminarVuelo() {

		try {
			
			ViajeCabeceraBo vCBo = new ViajeCabeceraBoImpl();

			List<ViajeCabecera> listaVuelos = vCBo.consultarVuelos();

			if ( listaVuelos.size() > 0 ){				
				DialogRemoveFlight drf = new DialogRemoveFlight();
				drf.setVisible(true);
			}
	
		} catch (ViajeCabeceraNotFoundException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}

	}
	
	private void cargarOferta() {

		try {
			
			ViajeCabeceraBo vCBo = new ViajeCabeceraBoImpl();

			List<ViajeCabecera> listaVuelos = vCBo.consultarVuelos();

			if ( listaVuelos.size() > 0 ){				
				
				DialogLoadOffer dlo = new DialogLoadOffer();
				
				dlo.setVisible(true);
			}
	
		} catch (ViajeCabeceraNotFoundException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		
	}
	
	private void eliminarOferta() {

		try {
		
			ViajeCabeceraBo vCBo = new ViajeCabeceraBoImpl();

			List<String> modeloOfertas = vCBo.retornarOfertas();

			if ( modeloOfertas.size() > 0 ){				
				
				DialogRemoveOffer dro = new DialogRemoveOffer();

				dro.cargarOfertas(modeloOfertas);

				dro.setVisible(true);
			}
	
		} catch (ViajeCabeceraOfferNotFoundException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
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
	
	public JPanel getPanelOfertas() {
		return panelOfertas;
	}

	public void setPanelOfertas(JPanel panelOfertas) {
		this.panelOfertas = panelOfertas;
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

}