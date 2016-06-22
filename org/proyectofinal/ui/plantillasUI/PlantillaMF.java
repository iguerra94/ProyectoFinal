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

import org.proyectofinal.bo.ex.ViajeCabeceraNotValidException;
import org.proyectofinal.bo.impl.ViajeCabeceraBoImpl;
import org.proyectofinal.bo.interfaces.ViajeCabeceraBo;
import org.proyectofinal.dao.ex.NoFlightsFoundException;
import org.proyectofinal.model.impl.ViajeCabeceraImpl;
import org.proyectofinal.model.interfaces.ViajeCabecera;
import org.proyectofinal.ui.DialogLogin;
import org.proyectofinal.ui.DialogPerfil;
import org.proyectofinal.ui.DialogRegistrarse;
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
	private ViajeCabecera vC;
	private String origen;
	private String destino;
	private Date fechaIda;
	
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
		agregarCamposPaneReserva();
		agregarBotonBuscarVuelo();
		
		paneReserva = new JTabbedPane(JTabbedPane.TOP);
		paneReserva.addTab("Reservá tu vuelo", null, panelReserva, null);	
		paneReserva.setFont(new Font("Roboto Regular", Font.PLAIN, 18));
		paneReserva.setBounds(30, 80, (getWidth()/2)-30, (getHeight()/4)+70);
		paneReserva.setBackground(new Color(255,255,255));
		getContentPane().add(paneReserva);
	}

//	ResultSet res = null;
//	
//	Calendar c = null;
//	
//	java.util.Date dateUtil = null; 
//	
//	Date dateSql = null;
//	
//	try {
//		
//		int a = model.getRowCount() - 1;
//		
//		for(int i = a; i >= 0; i--){
//			model.removeRow(0);
//		}
//		
//		Object[] fila = new Object[6];
//		
//		vCDao.conectar();
//
//		int k = 6;
//		
//		for (int i = 1; i <= k; i++){
//			
//			res = vCDao.consultarVuelos(vC);
//			
//			String fecha = "";
//
//			if (res.next()){
//				
//				fila[0] = res.getInt("codViaje");
//				fila[1] = res.getString("ciudadOrigen") + ", " + res.getString("paisOrigen");
//				fila[2] = res.getString("ciudadDestino") + ", " + res.getString("paisDestino");							
//			
//				fecha = res.getDate("fechaSalida").toString().substring(8, 10) + "-" + res.getDate("fechaSalida").toString().substring(5, 7) + "-" + res.getDate("fechaSalida").toString().substring(0, 4);
//				
//				fila[3] = fecha + " " + res.getTime("horaSalida").toString().substring(0, 5);
//				
//				fecha = res.getDate("fechaLlegada").toString().substring(8, 10) + "-" + res.getDate("fechaLlegada").toString().substring(5, 7) + "-" + res.getDate("fechaLlegada").toString().substring(0, 4);
//				
//				fila[4] = fecha + " " + res.getTime("horaLlegada").toString().substring(0, 5);
//				
//				fila[5] = res.getInt("cupo");
//				
//				model.addRow(fila);					
//				
//				while (res.next()){
//				
//					fila[0] = res.getInt("codViaje");
//					fila[1] = res.getString("ciudadOrigen") + ", " + res.getString("paisOrigen");
//					fila[2] = res.getString("ciudadDestino") + ", " + res.getString("paisDestino");							
//				
//					fecha = res.getDate("fechaSalida").toString().substring(8, 10) + "-" + res.getDate("fechaSalida").toString().substring(5, 7) + "-" + res.getDate("fechaSalida").toString().substring(0, 4);
//					
//					fila[3] = fecha + " " + res.getTime("horaSalida").toString().substring(0, 5);
//					
//					fecha = res.getDate("fechaLlegada").toString().substring(8, 10) + "-" + res.getDate("fechaLlegada").toString().substring(5, 7) + "-" + res.getDate("fechaLlegada").toString().substring(0, 4);
//					
//					fila[4] = fecha + " " + res.getTime("horaLlegada").toString().substring(0, 5);
//					
//					fila[5] = res.getInt("cupo");
//					
//					model.addRow(fila);								
//				}
//			
//			}					
//
//			c = Calendar.getInstance();
//			
//			c.setTime(new java.util.Date(fechaSalida.getTime()));
//		
//			c.add(Calendar.DATE, i);
//			
//			dateUtil = c.getTime();
//			
//			dateSql = new Date(dateUtil.getTime());
//			
//			vC.setFechaSalida(dateSql);							
//		}
//		
//		if (model.getRowCount() == 0){	
//			throw new NoFlightsFoundException();
//		}
//		
//		vCDao.desconectar();
//	
//	} catch (ClassNotFoundException e) {
//		JOptionPane.showMessageDialog(null, e.getMessage());
//	} catch (SQLException e) {
//		JOptionPane.showMessageDialog(null, e.getMessage());
//	} catch (NoFlightsFoundException e) {
//		JOptionPane.showMessageDialog(null, e.getMessage());
//	}
//	

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
		
		JCheckBox chckbxAcumularKilometrosAeropass = new JCheckBox("Acumular Kilometros AeroPass");
		chckbxAcumularKilometrosAeropass.setForeground(Color.WHITE);
		chckbxAcumularKilometrosAeropass.setBounds(25, 120, 260, 30);
		panelReserva.add(chckbxAcumularKilometrosAeropass);
		
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
			
				try {
					
					vCBo.verificarImportantes(vC);
					
					List<ViajeCabecera> listViajes = vCBo.retornarVuelos(vC);
					
					ListadoVuelosUI ui = new ListadoVuelosUI();
					
					ui.mostrarVuelos(listViajes);
					
					ui.setVisible(true);
					
				} catch (ViajeCabeceraNotValidException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (NoFlightsFoundException e1) {
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
		panelFrecuente.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, null, Color.DARK_GRAY, null));
		getContentPane().add(panelFrecuente);
		panelFrecuente.setLayout(null);
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
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds((panelOferta1.getWidth()/2)-150, 20, 300, 200);
		
		ImageIcon imagenOferta1 = new ImageIcon(getClass().getResource("/imagenes/miami.jpg"));
		
		Icon iconoOferta1 = new ImageIcon(imagenOferta1.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
		
		lblImagen.setIcon(iconoOferta1);
		lblImagen.setHorizontalAlignment(JLabel.CENTER);
		panelOferta1.add(lblImagen);
		
		final JLabel lblOrigen = new JLabel("Buenos Aires");
		lblOrigen.setForeground(new Color(245, 245, 245));
		lblOrigen.setBounds(lblImagen.getX(), 235, 200, 30);
		lblOrigen.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		panelOferta1.add(lblOrigen);
		
		final JLabel lblDestino = new JLabel("Miami");
		lblDestino.setForeground(new Color(251, 192, 45));
		lblDestino.setBounds(lblImagen.getX(), 265, 200, 30);
		lblDestino.setFont(new Font("Roboto Bold", Font.PLAIN, 22));
		panelOferta1.add(lblDestino);
		
//		JLabel lblPrecio = new JLabel("<html>Desde AR$ 1979 <br />o 12 cuotas de AR$ 167</html> ");
//		lblPrecio.setBounds(120, 230, 209, 30);
//		panelOferta1.add(lblPrecio);
		
		JButton botonReservaOferta1 = new JButton("Reservar");
		botonReservaOferta1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actionPanelOfertas();
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
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds((panelOferta2.getWidth()/2)-150, 20, 300, 200);
		
		ImageIcon imagenOferta2 = new ImageIcon(getClass().getResource("/imagenes/roma.jpg"));
		
		Icon iconoOferta2 = new ImageIcon(imagenOferta2.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
				
		lblImagen.setIcon(iconoOferta2);
		lblImagen.setHorizontalAlignment(JLabel.CENTER);
		panelOferta2.add(lblImagen);
		
		final JLabel lblOrigen = new JLabel("Buenos Aires");
		lblOrigen.setForeground(new Color(245, 245, 245));
		lblOrigen.setBounds(lblImagen.getX(), 235, 200, 30);
		lblOrigen.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		panelOferta2.add(lblOrigen);

		final JLabel lblDestino = new JLabel("Roma");
		lblDestino.setForeground(new Color(251, 192, 45));
		lblDestino.setBounds(lblImagen.getX(), 265, 200, 30);
		lblDestino.setFont(new Font("Roboto Bold", Font.PLAIN, 22));
		panelOferta2.add(lblDestino);
		
//		JLabel lblPrecio = new JLabel("<html>Desde AR$ 1979 <br />o 12 cuotas de AR$ 167</html> ");
//		lblPrecio.setBounds(120, 230, 209, 30);
//		panelOferta2.add(lblPrecio);
		
		JButton botonReservaOferta2 = new JButton("Reservar");
		botonReservaOferta2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actionPanelOfertas();
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
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds((panelOferta3.getWidth()/2)-150, 20, 300, 200);
		
		ImageIcon imagenOferta3 = new ImageIcon(getClass().getResource("/imagenes/baires.jpg"));
		
		Icon iconoOferta3 = new ImageIcon(imagenOferta3.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));

		lblImagen.setIcon(iconoOferta3);
		lblImagen.setHorizontalAlignment(JLabel.CENTER);
		panelOferta3.add(lblImagen);
		
		final JLabel lblOrigen = new JLabel("Cordoba");
		lblOrigen.setForeground(new Color(245, 245, 245));
		lblOrigen.setBounds(lblImagen.getX(), 235, 200, 30);
		lblOrigen.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		panelOferta3.add(lblOrigen);

		final JLabel lblDestino = new JLabel("Buenos Aires");
		lblDestino.setForeground(new Color(251, 192, 45));
		lblDestino.setBounds(lblImagen.getX(), 265, 200, 30);
		lblDestino.setFont(new Font("Roboto Bold", Font.PLAIN, 22));
		panelOferta3.add(lblDestino);
		
//		JLabel lblPrecio = new JLabel("<html>Desde AR$ 1979 <br />o 12 cuotas de AR$ 167</html> ");
//		lblPrecio.setBounds(120, 230, 209, 30);
//		panelOferta3.add(lblPrecio);
		
		JButton botonReservaOferta3 = new JButton("Reservar");
		botonReservaOferta3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actionPanelOfertas();
			}
		});
		botonReservaOferta3.setBounds(panelOferta3.getWidth()-110, panelOferta3.getHeight()-50,100,40);
		panelOferta3.add(botonReservaOferta3);
	}

	private void actionPanelOfertas() {
		
		java.util.Date dateUtil = new java.util.Date();
		Date fecha = new Date(dateUtil.getTime());
		
		vC = new ViajeCabeceraImpl();
		
		vC.setCiudadOrigen(lblOrigen.getText());
		vC.setCiudadDestino(lblDestino.getText());
		vC.setFechaSalida(fecha);

		ViajeCabeceraBo vCBo = new ViajeCabeceraBoImpl();
		
		try {
			
			List<ViajeCabecera> listViajes = vCBo.retornarVuelos(vC);

			ListadoVuelosUI ui = new ListadoVuelosUI();
			
			ui.mostrarVuelos(listViajes);
			
			ui.setVisible(true);
		
		} catch (NoFlightsFoundException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
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
		// TODO Auto-generated method stub

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
	
	private void removerBotonesLogueado(){
		remove(btnPerfil);
		remove(btnCerrarSesion);
	}
	
	private void loguear(){
		dispose();
		DialogLogin d = new DialogLogin();
	}
	
	private void registrar(){
		DialogRegistrarse d = new DialogRegistrarse();
	}
	
	private void verPerfil() {
		DialogPerfil ui = new DialogPerfil();
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

    	if (getLogueado()){
    		if (btnPerfil != null){
    			btnPerfil.setBounds(getWidth()-300, 30, 140, 35);
    			btnCerrarSesion.setBounds(getWidth()-150, 30, 140, 35);
    		}
    	}else{
    		if (btnRegistrarse != null){
    			btnRegistrarse.setBounds(getWidth()-300, 30, 140, 35);
    			btnIniciarSesion.setBounds(getWidth()-150, 30, 140, 35);
    		}
    	}
    	
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
		
		JMenu mnDestinos = new JMenu("Destinos");
		menuBar.add(mnDestinos);
		
		JMenuItem mntmArgentina = new JMenuItem("Argentina");
		mnDestinos.add(mntmArgentina);
		
		JMenuItem mntmBrasil = new JMenuItem("Brasil");
		mnDestinos.add(mntmBrasil);
		
		JMenuItem mntmMexico = new JMenuItem("Mexico");
		mnDestinos.add(mntmMexico);
		
		JMenuItem mntmEEUU = new JMenuItem("Estados Unidos");
		mnDestinos.add(mntmEEUU);
	
		JMenuItem mntmColombia = new JMenuItem("Colombia");
		mnDestinos.add(mntmColombia);
	
		JMenuItem mntmOceania = new JMenuItem("Oceania");
		mnDestinos.add(mntmOceania);
		
		JMenuItem mntmEuropa = new JMenuItem("Europa");
		mnDestinos.add(mntmEuropa);
		
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