package org.proyectofinal.ui.plantillasUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import org.proyectofinal.bo.ex.DniNotValidException;
import org.proyectofinal.bo.ex.NotValidBookingException;
import org.proyectofinal.bo.ex.NotValidPassengerException;
import org.proyectofinal.bo.impl.PasajeroBoImpl;
import org.proyectofinal.bo.impl.PersonaRegistradaBoImpl;
import org.proyectofinal.bo.impl.ReservaViajeBoImpl;
import org.proyectofinal.bo.impl.ViajeCabeceraBoImpl;
import org.proyectofinal.bo.interfaces.PasajeroBo;
import org.proyectofinal.bo.interfaces.PersonaRegistradaBo;
import org.proyectofinal.bo.interfaces.ReservaViajeBo;
import org.proyectofinal.bo.interfaces.ViajeCabeceraBo;
import org.proyectofinal.model.impl.PasajeroImpl;
import org.proyectofinal.model.impl.ReservaViajeImpl;
import org.proyectofinal.model.interfaces.Pasajero;
import org.proyectofinal.model.interfaces.ReservaViaje;
import org.proyectofinal.model.interfaces.ViajeCabecera;
import org.proyectofinal.ui.botones.BotonPasajero;
import org.proyectofinal.ui.util.Boleto;
import org.proyectofinal.ui.util.BoletoEmail;
import org.proyectofinal.ui.util.Reservas;

import com.itextpdf.text.DocumentException;

public class PlantillaRV extends JDialog implements MouseListener{

	private static final long serialVersionUID = -8111075447874816925L;
	
	private JPanel panelAsientos;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel panel6;
	
	private JPanel panelInfoVuelo;
	private JLabel lblCodigoViaje;
	private JLabel lblSalida;
	private JLabel lblLlegada;
	private JLabel lblDuracion;
	private JLabel lblAcumula;

	private JPanel panelPasajeros;
	private JLabel lblSeleccioneCantPasajeros;
	private JComboBox<Integer> cmbCantPasajeros;
	private JButton btnAnterior;
	private JButton btnSiguiente;

	private JPanel panelDatosPasajeros;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	
	private JTextField txtAsiento;
	private JTextField txtPrecio;
	
	private JLabel lblCantAsientosDisp;
	private List<BotonPasajero> botones;
	private List<BotonPasajero> botonesSeleccionados = new ArrayList<BotonPasajero>();
	private List<BotonPasajero> botonesOcupados = new ArrayList<BotonPasajero>();
	private int a = 1;
	private Integer opcion;
	private Pasajero pasajero;
	private PasajeroBo pBo;
	private Boolean estadoAnterior = false;
	private BotonPasajero b;
	private Reservas reservas;
	private ReservaViaje rV;
	private ViajeCabeceraBo vCBo;
	private ReservaViajeBo rVBo;
	private PersonaRegistradaBo pRBo;	
	private String dniPersona;
	private Integer distancia;

	public PlantillaRV(){
	}

	protected void inicializarAtributos() {
		setTitle("Reserva de Boleto");
		getContentPane().setBackground(Color.WHITE);
		setModal(true);
		setSize(970,710);
		setResizable(false);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
	}
	
	private void agregarPanelAsientos(ViajeCabecera viaje) {

		botones = new ArrayList<BotonPasajero>();

		panelAsientos = new JPanel();
		panelAsientos.setBounds(20, 45, 537, 585);
		panelAsientos.setLayout(null);
		panelAsientos.setBackground(Color.WHITE);

		agregarAsientosPrimera(viaje);
		agregarAsientosTurista(viaje);

		accionesBotonesOcupados(viaje);
		
		setearToolTipBotonesDisponibles();

		agregarInfoSobreAsientosPanelAsientos();
		agregarLabelsEtiquetasPanelAsientos();
		agregarLabelCantAsientosDisponibles(viaje);
		agregarFondoAvion();
		
	}
	
	private void agregarAsientosPrimera(ViajeCabecera viaje) {

		Float precioPrim = viaje.getPrecioClasePrim()*(1-Float.parseFloat(viaje.getOferta()));

		String precioFormateado = String.format(Locale.ROOT, "%.2f", precioPrim);
		
		precioPrim = Float.parseFloat(precioFormateado);

		panel1 = new JPanel();
		panel1.setBounds(173, 144, 53, 119);
		panelAsientos.add(panel1);
		panel1.setOpaque(false);
		panel1.setLayout(new GridLayout(3, 2, 0, 7));
	
		panel2 = new JPanel();
		panel2.setBounds(240, 144, 54, 119);
		panelAsientos.add(panel2);
		panel2.setOpaque(false);
		panel2.setLayout(new GridLayout(3, 2, 0, 7));
		
		panel3 = new JPanel();
		panel3.setBounds(308, 144, 56, 119);
		panelAsientos.add(panel3);
		panel3.setOpaque(false);
		panel3.setLayout(new GridLayout(3, 2, 0, 7));
		
		final BotonPasajero btnNro1 = new BotonPasajero(1, precioPrim);
		btnNro1.setName("btnNro1");
		btnNro1.addMouseListener(this);
		btnNro1.setBackground(new Color(0, 128, 0));
		btnNro1.setContentAreaFilled(false);
		btnNro1.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro1.setMargin(new Insets(2, 0, 2, 0));
		panel1.add(btnNro1);
		
		final BotonPasajero btnNro2 = new BotonPasajero(2, precioPrim);		
		btnNro2.setName("btnNro2");
		btnNro2.addMouseListener(this);
		btnNro2.setBackground(new Color(0, 128, 0));
		btnNro2.setContentAreaFilled(false);
		btnNro2.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro2.setMargin(new Insets(2, 0, 2, 0));
		btnNro2.setHorizontalTextPosition(SwingConstants.CENTER);
		panel1.add(btnNro2);
		
		final BotonPasajero btnNro7 = new BotonPasajero(7, precioPrim);
		btnNro7.setName("btnNro7");
		btnNro7.addMouseListener(this);
		btnNro7.setBackground(new Color(0, 128, 0));
		btnNro7.setContentAreaFilled(false);
		btnNro7.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro7.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro7.setMargin(new Insets(2, 0, 2, 0));
		panel1.add(btnNro7);
		
		final BotonPasajero btnNro8 = new BotonPasajero(8, precioPrim);
		btnNro8.setName("btnNro8");
		btnNro8.addMouseListener(this);
		btnNro8.setBackground(new Color(0, 128, 0));
		btnNro8.setContentAreaFilled(false);
		btnNro8.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro8.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro8.setMargin(new Insets(2, 0, 2, 0));
		panel1.add(btnNro8);
		
		final BotonPasajero btnNro13 = new BotonPasajero(13, precioPrim);
		btnNro13.setName("btnNro13");
		btnNro13.addMouseListener(this);
		btnNro13.setBackground(new Color(0, 128, 0));
		btnNro13.setContentAreaFilled(false);
		btnNro13.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro13.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro13.setMargin(new Insets(2, 0, 2, 0));
		panel1.add(btnNro13);
		
		final BotonPasajero btnNro14 = new BotonPasajero(14, precioPrim);
		btnNro14.setName("btnNro14");
		btnNro14.addMouseListener(this);
		btnNro14.setBackground(new Color(0, 128, 0));
		btnNro14.setContentAreaFilled(false);
		btnNro14.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro14.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro14.setMargin(new Insets(2, 0, 2, 0));
		panel1.add(btnNro14);
		
		final BotonPasajero btnNro3 = new BotonPasajero(3, precioPrim);
		btnNro3.setName("btnNro3");
		btnNro3.addMouseListener(this);
		btnNro3.setBackground(new Color(0, 128, 0));
		btnNro3.setContentAreaFilled(false);
		btnNro3.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro3.setMargin(new Insets(2, 0, 2, 0));
		panel2.add(btnNro3);

		final BotonPasajero btnNro4 = new BotonPasajero(4, precioPrim);
		btnNro4.setName("btnNro4");
		btnNro4.addMouseListener(this);
		btnNro4.setBackground(new Color(0, 128, 0));
		btnNro4.setContentAreaFilled(false);
		btnNro4.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro4.setMargin(new Insets(2, 0, 2, 0));
		panel2.add(btnNro4);
		
		final BotonPasajero btnNro9 = new BotonPasajero(9, precioPrim);
		btnNro9.setName("btnNro9");
		btnNro9.addMouseListener(this);
		btnNro9.setBackground(new Color(0, 128, 0));
		btnNro9.setContentAreaFilled(false);
		btnNro9.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro9.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro9.setMargin(new Insets(2, 0, 2, 0));
		panel2.add(btnNro9);
		
		final BotonPasajero btnNro10 = new BotonPasajero(10, precioPrim);
		btnNro10.setName("btnNro10");
		btnNro10.addMouseListener(this);
		btnNro10.setBackground(new Color(0, 128, 0));
		btnNro10.setContentAreaFilled(false);
		btnNro10.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro10.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro10.setMargin(new Insets(2, 0, 2, 0));
		panel2.add(btnNro10);

		final BotonPasajero btnNro15 = new BotonPasajero(15, precioPrim);
		btnNro15.setName("btnNro15");
		btnNro15.addMouseListener(this);
		btnNro15.setBackground(new Color(0, 128, 0));
		btnNro15.setContentAreaFilled(false);
		btnNro15.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro15.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro15.setMargin(new Insets(2, 0, 2, 0));
		panel2.add(btnNro15);
		
		final BotonPasajero btnNro16 = new BotonPasajero(16, precioPrim);
		btnNro16.setName("btnNro16");
		btnNro16.addMouseListener(this);
		btnNro16.setBackground(new Color(0, 128, 0));
		btnNro16.setContentAreaFilled(false);
		btnNro16.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro16.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro16.setMargin(new Insets(2, 0, 2, 0));
		panel2.add(btnNro16);
		
		final BotonPasajero btnNro5 = new BotonPasajero(5, precioPrim);
		btnNro5.setName("btnNro5");
		btnNro5.addMouseListener(this);
		btnNro5.setBackground(new Color(0, 128, 0));
		btnNro5.setContentAreaFilled(false);
		btnNro5.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro5.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro5.setMargin(new Insets(2, 0, 2, 0));
		panel3.add(btnNro5);
		
		final BotonPasajero btnNro6 = new BotonPasajero(6, precioPrim);
		btnNro6.setName("btnNro6");
		btnNro6.addMouseListener(this);
		btnNro6.setBackground(new Color(0, 128, 0));
		btnNro6.setContentAreaFilled(false);
		btnNro6.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro6.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro6.setMargin(new Insets(2, 2, 2, 2));
		panel3.add(btnNro6);
		
		final BotonPasajero btnNro11 = new BotonPasajero(11, precioPrim);
		btnNro11.setName("btnNro11");
		btnNro11.addMouseListener(this);
		btnNro11.setBackground(new Color(0, 128, 0));
		btnNro11.setContentAreaFilled(false);
		btnNro11.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro11.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro11.setMargin(new Insets(2, 0, 2, 0));
		panel3.add(btnNro11);

		final BotonPasajero btnNro12 = new BotonPasajero(12, precioPrim);
		btnNro12.setName("btnNro12");
		btnNro12.addMouseListener(this);
		btnNro12.setBackground(new Color(0, 128, 0));
		btnNro12.setContentAreaFilled(false);
		btnNro12.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro12.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro12.setMargin(new Insets(2, 0, 2, 0));
		panel3.add(btnNro12);
		
		final BotonPasajero btnNro17 = new BotonPasajero(17, precioPrim);
		btnNro17.setName("btnNro17");
		btnNro17.addMouseListener(this);
		btnNro17.setBackground(new Color(0, 128, 0));
		btnNro17.setContentAreaFilled(false);
		btnNro17.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro17.setMargin(new Insets(2, 0, 2, 0));
		btnNro17.setHorizontalTextPosition(SwingConstants.CENTER);
		panel3.add(btnNro17);
		
		final BotonPasajero btnNro18 = new BotonPasajero(18, precioPrim);
		btnNro18.setName("btnNro18");
		btnNro18.addMouseListener(this);
		btnNro18.setBackground(new Color(0, 128, 0));
		btnNro18.setContentAreaFilled(false);
		btnNro18.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro18.setMargin(new Insets(2, 0, 2, 0));
		btnNro18.setHorizontalTextPosition(SwingConstants.CENTER);
		panel3.add(btnNro18);
		
		
		botones.add(0, btnNro1);
		botones.add(1, btnNro2);
		botones.add(2, btnNro3);
		botones.add(3, btnNro4);
		botones.add(4, btnNro5);
		botones.add(5, btnNro6);
		botones.add(6, btnNro7);
		botones.add(7, btnNro8);
		botones.add(8, btnNro9);
		botones.add(9, btnNro10);
		botones.add(10, btnNro11);
		botones.add(11, btnNro12);
		botones.add(12, btnNro13);
		botones.add(13, btnNro14);
		botones.add(14, btnNro15);
		botones.add(15, btnNro16);
		botones.add(16, btnNro17);
		botones.add(17, btnNro18);	
	}

	private void agregarAsientosTurista(ViajeCabecera viaje) {
		
		Float precioTur = viaje.getPrecioClaseTur()*(1-Float.parseFloat(viaje.getOferta()));

		String precioFormateado = String.format(Locale.ROOT, "%.2f", precioTur);
		
		precioTur = Float.parseFloat(precioFormateado);
		
		panel4 = new JPanel();
		panel4.setBounds(175, 282, 50, 289);
		panelAsientos.add(panel4);
		panel4.setOpaque(false);
		panel4.setLayout(new GridLayout(8, 2, 0, 7));
		
		panel5 = new JPanel();
		panel5.setBounds(240, 282, 52, 289);
		panelAsientos.add(panel5);
		panel5.setOpaque(false);
		panel5.setLayout(new GridLayout(8, 2, 0, 7));
		
		panel6 = new JPanel();
		panel6.setBounds(308, 282, 54, 289);
		panelAsientos.add(panel6);
		panel6.setOpaque(false);
		panel6.setLayout(new GridLayout(8, 2, 0, 7));
		
		
		final BotonPasajero btnNro19 = new BotonPasajero(19, precioTur);
		btnNro19.setName("btnNro19");
		btnNro19.addMouseListener(this);
		btnNro19.setBackground(new Color(0, 128, 0));
		btnNro19.setContentAreaFilled(false);
		btnNro19.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro19.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro19.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro19);

		final BotonPasajero btnNro20 = new BotonPasajero(20, precioTur);
		btnNro20.setName("btnNro20");
		btnNro20.addMouseListener(this);
		btnNro20.setBackground(new Color(0, 128, 0));
		btnNro20.setContentAreaFilled(false);
		btnNro20.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro20.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro20.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro20);

		final BotonPasajero btnNro25 = new BotonPasajero(25, precioTur);
		btnNro25.setName("btnNro25");
		btnNro25.addMouseListener(this);
		btnNro25.setBackground(new Color(0, 128, 0));
		btnNro25.setContentAreaFilled(false);
		btnNro25.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro25.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro25.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro25);
		
		final BotonPasajero btnNro26 = new BotonPasajero(26, precioTur);
		btnNro26.setName("btnNro26");
		btnNro26.addMouseListener(this);
		btnNro26.setBackground(new Color(0, 128, 0));
		btnNro26.setContentAreaFilled(false);
		btnNro26.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro26.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro26.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro26);

		final BotonPasajero btnNro31 = new BotonPasajero(31, precioTur);
		btnNro31.setName("btnNro31");
		btnNro31.addMouseListener(this);
		btnNro31.setBackground(new Color(0, 128, 0));
		btnNro31.setContentAreaFilled(false);
		btnNro31.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro31.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro31.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro31);

		final BotonPasajero btnNro32 = new BotonPasajero(32, precioTur);
		btnNro32.setName("btnNro32");
		btnNro32.addMouseListener(this);
		btnNro32.setBackground(new Color(0, 128, 0));
		btnNro32.setContentAreaFilled(false);
		btnNro32.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro32.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro32.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro32);

		final BotonPasajero btnNro37 = new BotonPasajero(37, precioTur);
		btnNro37.setName("btnNro37");
		btnNro37.addMouseListener(this);
		btnNro37.setBackground(new Color(0, 128, 0));
		btnNro37.setContentAreaFilled(false);
		btnNro37.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro37.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro37.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro37);

		final BotonPasajero btnNro38 = new BotonPasajero(38, precioTur);
		btnNro38.setName("btnNro38");
		btnNro38.addMouseListener(this);
		btnNro38.setBackground(new Color(0, 128, 0));
		btnNro38.setContentAreaFilled(false);
		btnNro38.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro38.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro38.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro38);
		
		final BotonPasajero btnNro43 = new BotonPasajero(43, precioTur);
		btnNro43.setName("btnNro43");
		btnNro43.addMouseListener(this);
		btnNro43.setBackground(new Color(0, 128, 0));
		btnNro43.setContentAreaFilled(false);
		btnNro43.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro43.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro43.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro43);

		final BotonPasajero btnNro44 = new BotonPasajero(44, precioTur);
		btnNro44.setName("btnNro44");
		btnNro44.addMouseListener(this);
		btnNro44.setBackground(new Color(0, 128, 0));
		btnNro44.setContentAreaFilled(false);
		btnNro44.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro44.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro44.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro44);
		
		final BotonPasajero btnNro49 = new BotonPasajero(49, precioTur);
		btnNro49.setName("btnNro49");
		btnNro49.addMouseListener(this);
		btnNro49.setBackground(new Color(0, 128, 0));
		btnNro49.setContentAreaFilled(false);
		btnNro49.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro49.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro49.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro49);

		final BotonPasajero btnNro50 = new BotonPasajero(50, precioTur);
		btnNro50.setName("btnNro50");
		btnNro50.addMouseListener(this);
		btnNro50.setBackground(new Color(0, 128, 0));
		btnNro50.setContentAreaFilled(false);
		btnNro50.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro50.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro50.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro50);

		final BotonPasajero btnNro55 = new BotonPasajero(55, precioTur);
		btnNro55.setName("btnNro55");
		btnNro55.addMouseListener(this);
		btnNro55.setBackground(new Color(0, 128, 0));
		btnNro55.setContentAreaFilled(false);
		btnNro55.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro55.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro55.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro55);
		
		final BotonPasajero btnNro56 = new BotonPasajero(56, precioTur);
		btnNro56.setName("btnNro56");
		btnNro56.addMouseListener(this);
		btnNro56.setBackground(new Color(0, 128, 0));
		btnNro56.setContentAreaFilled(false);
		btnNro56.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro56.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro56.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro56);
		
		final BotonPasajero btnNro61 = new BotonPasajero(61, precioTur);
		btnNro61.setName("btnNro61");
		btnNro61.addMouseListener(this);
		btnNro61.setBackground(new Color(0, 128, 0));
		btnNro61.setContentAreaFilled(false);
		btnNro61.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro61.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro61.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro61);

		final BotonPasajero btnNro62 = new BotonPasajero(62, precioTur);
		btnNro62.setName("btnNro62");
		btnNro62.addMouseListener(this);
		btnNro62.setBackground(new Color(0, 128, 0));
		btnNro62.setContentAreaFilled(false);
		btnNro62.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro62.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro62.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro62);
		
		final BotonPasajero btnNro21 = new BotonPasajero(21, precioTur);
		btnNro21.setName("btnNro21");
		btnNro21.addMouseListener(this);
		btnNro21.setBackground(new Color(0, 128, 0));
		btnNro21.setContentAreaFilled(false);
		btnNro21.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro21.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro21.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro21);
		
		final BotonPasajero btnNro22 = new BotonPasajero(22, precioTur);
		btnNro22.setName("btnNro22");
		btnNro22.addMouseListener(this);
		btnNro22.setBackground(new Color(0, 128, 0));
		btnNro22.setContentAreaFilled(false);
		btnNro22.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro22.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro22.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro22);

		final BotonPasajero btnNro27 = new BotonPasajero(27, precioTur);
		btnNro27.setName("btnNro27");
		btnNro27.addMouseListener(this);
		btnNro27.setBackground(new Color(0, 128, 0));
		btnNro27.setContentAreaFilled(false);
		btnNro27.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro27.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro27.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro27);

		final BotonPasajero btnNro28 = new BotonPasajero(28, precioTur);
		btnNro28.setName("btnNro28");
		btnNro28.addMouseListener(this);
		btnNro28.setBackground(new Color(0, 128, 0));
		btnNro28.setContentAreaFilled(false);
		btnNro28.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro28.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro28.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro28);

		final BotonPasajero btnNro33 = new BotonPasajero(33, precioTur);
		btnNro33.setName("btnNro33");
		btnNro33.addMouseListener(this);
		btnNro33.setBackground(new Color(0, 128, 0));
		btnNro33.setContentAreaFilled(false);
		btnNro33.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro33.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro33.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro33);

		final BotonPasajero btnNro34 = new BotonPasajero(34, precioTur);
		btnNro34.setName("btnNro34");
		btnNro34.addMouseListener(this);
		btnNro34.setBackground(new Color(0, 128, 0));
		btnNro34.setContentAreaFilled(false);
		btnNro34.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro34.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro34.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro34);
		
		final BotonPasajero btnNro39 = new BotonPasajero(39, precioTur);
		btnNro39.setName("btnNro39");
		btnNro39.addMouseListener(this);
		btnNro39.setBackground(new Color(0, 128, 0));
		btnNro39.setContentAreaFilled(false);
		btnNro39.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro39.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro39.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro39);
		
		final BotonPasajero btnNro40 = new BotonPasajero(40, precioTur);
		btnNro40.setName("btnNro40");
		btnNro40.addMouseListener(this);
		btnNro40.setBackground(new Color(0, 128, 0));
		btnNro40.setContentAreaFilled(false);
		btnNro40.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro40.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro40.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro40);
		
		final BotonPasajero btnNro45 = new BotonPasajero(45, precioTur);
		btnNro45.setName("btnNro45");
		btnNro45.addMouseListener(this);
		btnNro45.setBackground(new Color(0, 128, 0));
		btnNro45.setContentAreaFilled(false);
		btnNro45.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro45.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro45.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro45);

		final BotonPasajero btnNro46 = new BotonPasajero(46, precioTur);
		btnNro46.setName("btnNro46");
		btnNro46.addMouseListener(this);
		btnNro46.setBackground(new Color(0, 128, 0));
		btnNro46.setContentAreaFilled(false);
		btnNro46.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro46.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro46.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro46);

		final BotonPasajero btnNro51 = new BotonPasajero(51, precioTur);
		btnNro51.setName("btnNro51");
		btnNro51.addMouseListener(this);
		btnNro51.setBackground(new Color(0, 128, 0));
		btnNro51.setContentAreaFilled(false);
		btnNro51.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro51.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro51.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro51);
		
		final BotonPasajero btnNro52 = new BotonPasajero(52, precioTur);
		btnNro52.setName("btnNro52");
		btnNro52.addMouseListener(this);
		btnNro52.setBackground(new Color(0, 128, 0));
		btnNro52.setContentAreaFilled(false);
		btnNro52.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro52.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro52.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro52);

		final BotonPasajero btnNro57 = new BotonPasajero(57, precioTur);
		btnNro57.setName("btnNro57");
		btnNro57.addMouseListener(this);
		btnNro57.setBackground(new Color(0, 128, 0));
		btnNro57.setContentAreaFilled(false);
		btnNro57.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro57.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro57.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro57);

		final BotonPasajero btnNro58 = new BotonPasajero(58, precioTur);
		btnNro58.setName("btnNro58");
		btnNro58.addMouseListener(this);
		btnNro58.setBackground(new Color(0, 128, 0));
		btnNro58.setContentAreaFilled(false);
		btnNro58.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro58.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro58.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro58);

		final BotonPasajero btnNro63 = new BotonPasajero(63, precioTur);
		btnNro63.setName("btnNro63");
		btnNro63.addMouseListener(this);
		btnNro63.setBackground(new Color(0, 128, 0));
		btnNro63.setContentAreaFilled(false);
		btnNro63.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro63.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro63.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro63);
		
		final BotonPasajero btnNro64 = new BotonPasajero(64, precioTur);
		btnNro64.setName("btnNro64");
		btnNro64.addMouseListener(this);
		btnNro64.setBackground(new Color(0, 128, 0));
		btnNro64.setContentAreaFilled(false);
		btnNro64.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro64.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro64.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro64);
		
		final BotonPasajero btnNro23 = new BotonPasajero(23, precioTur);
		btnNro23.setName("btnNro23");
		btnNro23.addMouseListener(this);
		btnNro23.setBackground(new Color(0, 128, 0));
		btnNro23.setContentAreaFilled(false);
		btnNro23.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro23.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro23.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro23);
		
		final BotonPasajero btnNro24 = new BotonPasajero(24, precioTur);
		btnNro24.setName("btnNro24");
		btnNro24.addMouseListener(this);
		btnNro24.setBackground(new Color(0, 128, 0));
		btnNro24.setContentAreaFilled(false);
		btnNro24.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro24.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro24.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro24);
		
		final BotonPasajero btnNro29 = new BotonPasajero(29, precioTur);
		btnNro29.setName("btnNro29");
		btnNro29.addMouseListener(this);
		btnNro29.setBackground(new Color(0, 128, 0));
		btnNro29.setContentAreaFilled(false);
		btnNro29.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro29.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro29.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro29);
		
		final BotonPasajero btnNro30 = new BotonPasajero(30, precioTur);
		btnNro30.setName("btnNro30");
		btnNro30.addMouseListener(this);
		btnNro30.setBackground(new Color(0, 128, 0));
		btnNro30.setContentAreaFilled(false);
		btnNro30.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro30.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro30.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro30);
		
		final BotonPasajero btnNro35 = new BotonPasajero(35, precioTur);
		btnNro35.setName("btnNro35");
		btnNro35.addMouseListener(this);
		btnNro35.setBackground(new Color(0, 128, 0));
		btnNro35.setContentAreaFilled(false);
		btnNro35.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro35.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro35.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro35);

		final BotonPasajero btnNro36 = new BotonPasajero(36, precioTur);
		btnNro36.setName("btnNro36");
			btnNro36.addMouseListener(this);
		btnNro36.setBackground(new Color(0, 128, 0));
		btnNro36.setContentAreaFilled(false);
		btnNro36.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro36.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro36.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro36);
		
		final BotonPasajero btnNro41 = new BotonPasajero(41, precioTur);
		btnNro41.setName("btnNro41");
		btnNro41.addMouseListener(this);
		btnNro41.setBackground(new Color(0, 128, 0));
		btnNro41.setContentAreaFilled(false);
		btnNro41.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro41.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro41.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro41);
		
		final BotonPasajero btnNro42 = new BotonPasajero(42, precioTur);
		btnNro42.setName("btnNro42");
		btnNro42.addMouseListener(this);
		btnNro42.setBackground(new Color(0, 128, 0));
		btnNro42.setContentAreaFilled(false);
		btnNro42.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro42.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro42.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro42);
		
		final BotonPasajero btnNro47 = new BotonPasajero(47, precioTur);
		btnNro47.setName("btnNro47");
		btnNro47.addMouseListener(this);
		btnNro47.setBackground(new Color(0, 128, 0));
		btnNro47.setContentAreaFilled(false);
		btnNro47.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro47.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro47.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro47);
		
		final BotonPasajero btnNro48 = new BotonPasajero(48, precioTur);
		btnNro48.setName("btnNro48");
		btnNro48.addMouseListener(this);
		btnNro48.setBackground(new Color(0, 128, 0));
		btnNro48.setContentAreaFilled(false);
		btnNro48.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro48.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro48.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro48);
		
		final BotonPasajero btnNro53 = new BotonPasajero(53, precioTur);
		btnNro53.setName("btnNro53");
		btnNro53.addMouseListener(this);
		btnNro53.setBackground(new Color(0, 128, 0));
		btnNro53.setContentAreaFilled(false);
		btnNro53.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro53.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro53.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro53);
		
		final BotonPasajero btnNro54 = new BotonPasajero(54, precioTur);
		btnNro54.setName("btnNro54");
		btnNro54.addMouseListener(this);
		btnNro54.setBackground(new Color(0, 128, 0));
		btnNro54.setContentAreaFilled(false);
		btnNro54.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro54.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro54.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro54);
		
		final BotonPasajero btnNro59 = new BotonPasajero(59, precioTur);
		btnNro59.setName("btnNro59");
		btnNro59.addMouseListener(this);
		btnNro59.setBackground(new Color(0, 128, 0));
		btnNro59.setContentAreaFilled(false);
		btnNro59.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro59.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro59.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro59);

		final BotonPasajero btnNro60 = new BotonPasajero(60, precioTur);
		btnNro60.setName("btnNro60");
		btnNro60.addMouseListener(this);
		btnNro60.setBackground(new Color(0, 128, 0));
		btnNro60.setContentAreaFilled(false);
		btnNro60.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro60.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro60.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro60);
		
		final BotonPasajero btnNro65 = new BotonPasajero(65, precioTur);
		btnNro65.setName("btnNro65");
		btnNro65.addMouseListener(this);
		btnNro65.setBackground(new Color(0, 128, 0));
		btnNro65.setContentAreaFilled(false);
		btnNro65.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro65.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro65.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro65);
		
		final BotonPasajero btnNro66 = new BotonPasajero(66, precioTur);
		btnNro66.setName("btnNro66");
		btnNro66.addMouseListener(this);
		btnNro66.setBackground(new Color(0, 128, 0));
		btnNro66.setContentAreaFilled(false);
		btnNro66.setBorder(new LineBorder(Color.BLACK, 1));
		btnNro66.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro66.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro66);
		
		
		botones.add(18,btnNro19);
		botones.add(19,btnNro20);
		botones.add(20,btnNro21);
		botones.add(21,btnNro22);
		botones.add(22,btnNro23);
		botones.add(23,btnNro24);
		botones.add(24,btnNro25);
		botones.add(25,btnNro26);
		botones.add(26,btnNro27);
		botones.add(27,btnNro28);
		botones.add(28,btnNro29);
		botones.add(29,btnNro30);
		botones.add(30,btnNro31);
		botones.add(31,btnNro32);
		botones.add(32,btnNro33);
		botones.add(33,btnNro34);
		botones.add(34,btnNro35);
		botones.add(35,btnNro36);
		botones.add(36,btnNro37);
		botones.add(37,btnNro38);
		botones.add(38,btnNro39);
		botones.add(39,btnNro40);
		botones.add(40,btnNro41);
		botones.add(41,btnNro42);
		botones.add(42,btnNro43);
		botones.add(43,btnNro44);
		botones.add(44,btnNro45);
		botones.add(45,btnNro46);
		botones.add(46,btnNro47);
		botones.add(47,btnNro48);
		botones.add(48,btnNro49);
		botones.add(49,btnNro50);
		botones.add(50,btnNro51);
		botones.add(51,btnNro52);
		botones.add(52,btnNro53);
		botones.add(53,btnNro54);
		botones.add(54,btnNro55);
		botones.add(55,btnNro56);
		botones.add(56,btnNro57);
		botones.add(57,btnNro58);
		botones.add(58,btnNro59);
		botones.add(59,btnNro60);
		botones.add(60,btnNro61);
		botones.add(61,btnNro62);
		botones.add(62,btnNro63);
		botones.add(63,btnNro64);
		botones.add(64,btnNro65);
		botones.add(65,btnNro66);
	}
	
	private void agregarInfoSobreAsientosPanelAsientos() {
	
		JButton btnAsientoDisp = new JButton("10");
		btnAsientoDisp.setContentAreaFilled(false);
		btnAsientoDisp.setMargin(new Insets(2, 0, 2, 0));
		btnAsientoDisp.setForeground(Color.BLACK);
		btnAsientoDisp.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAsientoDisp.setBorder(new LineBorder(Color.BLACK, 1));
		btnAsientoDisp.setBackground(Color.GRAY);
		btnAsientoDisp.setBounds(397, 142, 25, 36);
		panelAsientos.add(btnAsientoDisp);

		JLabel lblAsientoDisp = new JLabel("<html><center>Asiento Disponible</center></html>");
		lblAsientoDisp.setBounds(429, 142, 93, 36);
		panelAsientos.add(lblAsientoDisp);

		JButton btnAsientoSelec = new JButton("10");
		btnAsientoSelec.setBounds(397, 190, 25, 36);
		btnAsientoSelec.setMargin(new Insets(2, 0, 2, 0));
		btnAsientoSelec.setForeground(Color.BLACK);
		btnAsientoSelec.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAsientoSelec.setBorder(new LineBorder(Color.BLACK, 1));
		btnAsientoSelec.setBackground(new Color(0, 128, 0));
		panelAsientos.add(btnAsientoSelec);
		
		JLabel lblAsientoSelecc = new JLabel("<html><center>Asiento Seleccionado</center></html>");
		lblAsientoSelecc.setBounds(429, 190, 93, 36);
		panelAsientos.add(lblAsientoSelecc);
		
		JButton btnAsientoOcup = new JButton("10");
		btnAsientoOcup.setBounds(397, 238, 25, 36);
		btnAsientoOcup.setContentAreaFilled(true);
		btnAsientoOcup.setBackground(Color.BLACK);
		btnAsientoOcup.setForeground(Color.BLACK);
		btnAsientoOcup.setBorder(new LineBorder(Color.BLACK, 1));
		btnAsientoOcup.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAsientoOcup.setMargin(new Insets(2, 0, 2, 0));
		panelAsientos.add(btnAsientoOcup);		
		btnAsientoOcup.setEnabled(false);
	
		JLabel lblAsientoOcup = new JLabel("<html><center>Asiento Ocupado</center></html>");
		lblAsientoOcup.setBounds(429, 238, 93, 36);
		panelAsientos.add(lblAsientoOcup);
	}

	private void agregarLabelsEtiquetasPanelAsientos() {
		JLabel lblCantidadDeAsientos = new JLabel("<html><center>Asientos disponibles:</center></html>");
		lblCantidadDeAsientos.setBounds(10,0,95,45);
		lblCantidadDeAsientos.setFont(new Font("Arial", Font.PLAIN, 14));
		panelAsientos.add(lblCantidadDeAsientos);
	}
	
	private void agregarLabelCantAsientosDisponibles(ViajeCabecera viaje) {
		lblCantAsientosDisp = new JLabel(viaje.getCupo().toString());
		lblCantAsientosDisp.setBounds(105, 0, 35, 45);
		lblCantAsientosDisp.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantAsientosDisp.setFont(new Font("Arial", Font.BOLD, 16));
		lblCantAsientosDisp.setForeground(Color.RED);
		panelAsientos.add(lblCantAsientosDisp);
	}

	private void agregarFondoAvion() {
		JLabel lblAvion = new JLabel("");
		lblAvion.setBounds(0, 0, 537, 584);
		panelAsientos.add(lblAvion);
		lblAvion.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvion.setIcon(new ImageIcon(getClass().getResource("/imagenes/avionC.png")));
	}

	private void setearToolTipBotonesDisponibles() {
		for(BotonPasajero boton: botones){
			boton.setToolTipText("DISPONIBLE");
		}
		panelAsientos.validate();
		panelAsientos.repaint();
		
	}

	protected void removerBotonesOcupadosDeListaDeBotones() {
		for (int i = 0; i < botonesOcupados.size(); i++){	
			botones.remove(botonesOcupados.get(i));
		}
	}

	protected void setearPropiedadesBotonesOcupados() {
		for (BotonPasajero boton: botonesOcupados){
			boton.setEstadoAsiento("OCUPADO");
			boton.setToolTipText("OCUPADO");
			boton.setContentAreaFilled(true);
			boton.setBackground(Color.BLACK);
			boton.setForeground(Color.BLACK);
			boton.setEnabled(false);
			boton.validate();
			boton.repaint();
		}
	}

	protected void controlarAsientosOcupados(ViajeCabecera viaje) {
	
		rVBo = new ReservaViajeBoImpl();
	
		List<Integer> listaOcupados = rVBo.retornarAsientosOcupados(viaje);

		for (Integer asiento : listaOcupados) {
			botonesOcupados.add(botones.get(asiento-1));					
		}
	}
			
	protected void accionesCmbCantPasajerosAlTenerFocoLaVentana() {
		cmbCantPasajeros.requestFocus();

		if (cmbCantPasajeros.getSelectedIndex() == 0){
			getContentPane().remove(panelAsientos);
			getContentPane().validate();
			getContentPane().repaint();
		}
	}
		
	private void agregarPanelInfoPasajeros(ViajeCabecera viaje, String dni) {

		agregarLabelSeleccioneCantPasajeros();
		
		panelPasajeros = new JPanel();
		panelPasajeros.setLayout(null);
		panelPasajeros.setBorder(new MatteBorder(5,0,0,5, new Color(0,121,107)));
		panelPasajeros.setBackground(new Color(0,150,136));
		panelPasajeros.setBounds(580, 20, 370, 375);
		getContentPane().add(panelPasajeros);
		
		agregarLabelsPanelInfoPasajeros();
		agregarCamposPanelInfoPasajeros(viaje, dni);
		
		agregarPanelDatosPasajeros();
		
	}
	
	private void agregarLabelSeleccioneCantPasajeros() {
		lblSeleccioneCantPasajeros = new JLabel("  Seleccione la cantidad de pasajeros");
		lblSeleccioneCantPasajeros.setIcon(new ImageIcon(getClass().getResource("/imagenes/flecha_derecha.png")));
		lblSeleccioneCantPasajeros.setBounds(294, 72, 286, 44);
		getContentPane().add(lblSeleccioneCantPasajeros);
	}
	
	private void agregarLabelsPanelInfoPasajeros() {
		JLabel lblinformacinSobrePasajeros = new JLabel("Información sobre los pasajeros");
		lblinformacinSobrePasajeros.setHorizontalAlignment(SwingConstants.CENTER);
		lblinformacinSobrePasajeros.setForeground(Color.WHITE);
		lblinformacinSobrePasajeros.setFont(new Font("Arial", Font.BOLD, 18));
		lblinformacinSobrePasajeros.setBounds(0, 0, 370, 60);
		panelPasajeros.add(lblinformacinSobrePasajeros);
				
		JLabel lblCantPasajeros = new JLabel("Cantidad de pasajeros: ");
		lblCantPasajeros.setForeground(Color.WHITE);
		lblCantPasajeros.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCantPasajeros.setBounds(25, 60, 180, 30);
		panelPasajeros.add(lblCantPasajeros);
	}
	
	private void agregarCamposPanelInfoPasajeros(ViajeCabecera viaje, String dni) {
		agregarCmbCantPasajeros();
		agregarBotonSiguiente(viaje, dni);
		agregarBotonAnterior();
	}

	private void agregarCmbCantPasajeros() {
		cmbCantPasajeros = new JComboBox<Integer>();
		cmbCantPasajeros.setModel(new DefaultComboBoxModel<Integer>(new Integer[]{0,1,2}));
		cmbCantPasajeros.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				cambioItemSeleccionadoCmbCantPasajeros();
			}
		});
		cmbCantPasajeros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (cmbCantPasajeros.getSelectedIndex() > 0){
					actionCmbCantPasajerosItemSeleccionadoMayorACero();
				}else{
					actionCmbCantPasajerosItemSeleccionadoIgualACero();
				}
			}
		});
		cmbCantPasajeros.setBounds(205, 60, 68, 30);
		panelPasajeros.add(cmbCantPasajeros);
	}
	
	private void actionCmbCantPasajerosItemSeleccionadoMayorACero() {

		reservas = new Reservas();
		
		a = 1;
		
		opcion = (Integer) cmbCantPasajeros.getSelectedItem();
		
		getContentPane().remove(lblSeleccioneCantPasajeros);
		getContentPane().add(panelAsientos);
		
		panelDatosPasajeros.setBorder(new TitledBorder(null, "Pasajero " + a +"/" + opcion, TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial", Font.PLAIN, 16), Color.WHITE));			
		

		panelPasajeros.add(panelDatosPasajeros);
		panelPasajeros.add(btnSiguiente);
		
		if (a == 1){
			if (a == opcion){
				btnSiguiente.setText("Finalizar");
			}else{
				btnSiguiente.setText("Siguiente");
			}
			panelPasajeros.remove(btnAnterior);
		}else if (a > 1){
			panelPasajeros.add(btnAnterior);					
		}else {
			panelPasajeros.remove(btnAnterior);
		}
		
		txtNombre.setText("");
		txtApellido.setText("");
		txtDni.setText("");
		txtAsiento.setText("");
		txtPrecio.setText("");
		
		panelPasajeros.validate();
		panelPasajeros.repaint();
		getContentPane().validate();
		getContentPane().repaint();
	}

	private void actionCmbCantPasajerosItemSeleccionadoIgualACero() {
		
		getContentPane().remove(panelAsientos);
		getContentPane().add(lblSeleccioneCantPasajeros);

		panelPasajeros.remove(panelDatosPasajeros);

		panelPasajeros.remove(btnSiguiente);
		panelPasajeros.remove(btnAnterior);
		
		reservas = null;
		
		for (int i = 0; i < botonesSeleccionados.size(); i++) {
			botonesSeleccionados.remove(i);
		}
			
		for (BotonPasajero boton : botones){
			boton.setContentAreaFilled(false);
			boton.setEnabled(true);
		}
		
		panelPasajeros.validate();
		panelPasajeros.repaint();
		getContentPane().validate();
		getContentPane().repaint();
	}

	private void agregarPanelDatosPasajeros() {
	
		panelDatosPasajeros = new JPanel();
		panelDatosPasajeros.setBackground(new Color(0, 121, 107));
		panelDatosPasajeros.setBounds(25, 105, 320, 200);
		panelDatosPasajeros.setLayout(null);
		
		agregarLabelsPanelDatosPasajeros();
		agregarCamposPanelDatosPasajeros();
	}

	private void agregarLabelsPanelDatosPasajeros() {
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(20, 25, 80, 28);
		panelDatosPasajeros.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 14));
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setBounds(20, 58, 80, 28);
		panelDatosPasajeros.add(lblApellido);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDni.setForeground(Color.WHITE);
		lblDni.setBounds(20, 91, 80, 28);
		panelDatosPasajeros.add(lblDni);
		
		JLabel lblAsiento = new JLabel("Asiento: ");
		lblAsiento.setFont(new Font("Arial", Font.PLAIN, 14));
		lblAsiento.setForeground(Color.WHITE);
		lblAsiento.setBounds(20, 124, 80, 28);
		panelDatosPasajeros.add(lblAsiento);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setBounds(20, 157, 80, 28);
		panelDatosPasajeros.add(lblPrecio);
	}

	private void agregarCamposPanelDatosPasajeros() {

		pasajero = new PasajeroImpl();
		
		txtNombre = new JTextField();
		txtNombre.setBounds(95, 25, 210, 28);
		txtNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				setearNombre();
			}
		});
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				setearNombre();				
			}
			@Override
			public void keyTyped(KeyEvent e) {
				controlarTeclasLetras(e);
			}
		});
		panelDatosPasajeros.add(txtNombre);
		
		pasajero.setNombre(txtNombre.getText());
		
		txtApellido = new JTextField();
		txtApellido.setBounds(95, 58, 210, 28);
		txtApellido.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				setearApellido();
			}
		});
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				setearApellido();
			}
			@Override
			public void keyTyped(KeyEvent e) {
				controlarTeclasLetras(e);
			}
		});
		panelDatosPasajeros.add(txtApellido);
		
		pasajero.setApellido(txtApellido.getText());
		
		txtDni = new JTextField();
		txtDni.setBounds(95, 91, 210, 28);
		txtDni.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				setearDni();				
			}
		});
		txtDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				setearDni();			
			}
			@Override
			public void keyTyped(KeyEvent e) {
				controlarTeclasNumericas(e);				
			}
		});
		panelDatosPasajeros.add(txtDni);
		
		pasajero.setDni(txtDni.getText());
		
		txtAsiento = new JTextField();
		txtAsiento.setEditable(false);
		txtAsiento.setBounds(95, 124, 210, 28);
		panelDatosPasajeros.add(txtAsiento);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(95, 157, 210, 28);
		panelDatosPasajeros.add(txtPrecio);
		
		rV.setAsiento(-1);
	}
	
	protected void setearNombre() {
		if (pasajero != null){
			if (txtNombre.getText().trim().length() > 0){
				pasajero.setNombre(txtNombre.getText());
			}else{
				pasajero.setNombre("");
			}
		}
	}
	
	protected void setearApellido() {
		if (pasajero != null){
			if (txtApellido.getText().trim().length() > 0){
				pasajero.setApellido(txtApellido.getText());
			}else{
				pasajero.setApellido("");
			}
		}
	}
	
	protected void setearDni() {
		
		if (pasajero != null){		
			if (txtDni.getText().trim().length() > 0){
				pasajero.setDni(txtDni.getText());
			}else{
				pasajero.setDni("");
			}
		}
	}
	
	protected void setearAsientoYPrecio() {
		if (txtAsiento.getText().length() > 0){
			rV.setAsiento(Integer.parseInt(txtAsiento.getText()));
			rV.setPrecio(Float.parseFloat(txtPrecio.getText()));
		} else {
			rV.setAsiento(-1);
			rV.setPrecio(-1f);
		}
	}
	
	private void controlarTeclasLetras(KeyEvent e) {
		char c = e.getKeyChar();
		
		if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_SPACE) && (c != KeyEvent.VK_BACK_SPACE)){
			e.consume();
		}
	}
	
	private void controlarTeclasNumericas(KeyEvent e) {
		char c = e.getKeyChar();
		
		if ((c < '0' || c > '9') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_SPACE) && (c != KeyEvent.VK_BACK_SPACE)){
			e.consume();
		}
	}

	private void agregarBotonSiguiente(ViajeCabecera viaje, String dni) {

		rV = new ReservaViajeImpl();
		
		rV.setViaje(viaje);
		rV.setDniPersona(dni);

		distancia = rV.getViaje().getDistancia();
		dniPersona = rV.getDniPersona();
		
		vCBo = new ViajeCabeceraBoImpl();
		pBo = new PasajeroBoImpl();
		pRBo = new PersonaRegistradaBoImpl();
		rVBo = new ReservaViajeBoImpl();
		
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					
					if (estadoAnterior){
						accionesEstadoAnterior();
					}else{
						setearAsientoYPrecio();
					}
					
					//Verifico que los datos del pasajero sean correctos y sino lanza excepcion 
					pBo.verificarDatosPasajero(pasajero);
					pBo.verificarDniPasajero(pasajero);
					
					rVBo.verificarReserva(rV);
					
					//Aumento la variable que controla el numero de pasajero en uno
					a++;
					
					panelPasajeros.remove(panelDatosPasajeros);
					panelPasajeros.remove(btnSiguiente);

					panelDatosPasajeros.setBorder(new TitledBorder(null, "Pasajero " + a +"/" + opcion, TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial", Font.PLAIN, 16), Color.WHITE));
					
					panelPasajeros.add(panelDatosPasajeros);				
					panelPasajeros.add(btnSiguiente);
					
					if (a > 1){
						panelPasajeros.add(btnAnterior);
						
						if (a == opcion){
							btnSiguiente.setText("Finalizar");						
						} else{
							btnSiguiente.setText("Siguiente");
						}
					}else {
						panelPasajeros.remove(btnAnterior);
					}
					
					panelPasajeros.validate();
					panelPasajeros.repaint();
				
				} catch (DniNotValidException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (NotValidPassengerException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (NotValidBookingException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} finally{
				
					if (txtNombre.getText().length() > 0 && 
						txtApellido.getText().length() > 0 && 
						txtDni.getText().length() > 0 && 
						txtAsiento.getText().length() > 0 && 
						txtPrecio.getText().length() > 0){

						Date d = new Date();
						
						rV.setPasajero(pasajero);
						rV.setFechaReserva(new Timestamp(d.getTime()));
						
						reservas.agregarReserva(rV);

						b.setContentAreaFilled(true);
						b.setBackground(Color.WHITE);
						b.setEnabled(false);
						
						botonesSeleccionados.add(b);
						
						if (a > opcion){							
							agregarReserva();
						}
					
						txtNombre.setText("");
						txtApellido.setText("");
						txtDni.setText("");
						txtAsiento.setText("");
						txtPrecio.setText("");		
						
						rV = new ReservaViajeImpl();
						rV.setViaje(reservas.getListReservas().get(0).getViaje());
						rV.setDniPersona(reservas.getListReservas().get(0).getDniPersona());
						
						pasajero = new PasajeroImpl();
					
					}
				}
			}

		});
		btnSiguiente.setBounds(225, 320, 120, 30);
	}
	
	private void agregarReserva() {
		
		for (int i = 0; i < reservas.getListReservas().size(); i++){									
			
			pBo.agregarPasajero(reservas.getListReservas().get(i).getPasajero());
			
			rVBo.agregarReserva(reservas.getListReservas().get(i));

			vCBo.actualizarCupo(reservas.getListReservas().get(0).getViaje());
			
			if (lblAcumula.getText().equals("SI")){
				pRBo.actualizarSaldo(distancia, dniPersona);
			}
		}
		
		//Generar PDF
		
		Boleto boleto = new Boleto();
		
		BoletoEmail bE = new BoletoEmail();
		
		String email = pRBo.retornarEmail(reservas.getListReservas().get(0).getDniPersona());
		
		try {
			
			boleto.crearBoleto(reservas);
			dispose();
			JOptionPane.showMessageDialog(null, "Se esta enviando un mail a su correo con su boleto.");
			bE.enviarMail(email, boleto.retornarBoleto());

		} catch (IOException e2) {
			e2.printStackTrace();
		} catch (DocumentException e2) {
			e2.printStackTrace();
		} finally {
		
			JOptionPane.showMessageDialog(null, "El mail ha sido enviado a su correo con el boleto para que este disponible para su descarga cuando lo requiera. Gracias.");			
			boleto.abrirBoleto();
		
		}
	}
		
	private void accionesEstadoAnterior() {
		for (BotonPasajero boton: botones){
			if (boton.getEstadoAsiento().equals("SELECCIONADO")){
				pasajero.setNombre(txtNombre.getText());
				pasajero.setApellido(txtApellido.getText());
				pasajero.setDni(txtDni.getText());
				rV.setAsiento(Integer.parseInt(boton.getText()));
				rV.setPrecio(Float.parseFloat(boton.getText()));							
			}
		}
		estadoAnterior = false;
	}

	private void agregarBotonAnterior() {
		btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (a < (Integer) opcion || a > 0){
					
					a--;
					
					for (BotonPasajero boton: botones){
						boton.setContentAreaFilled(false);
						boton.setEstadoAsiento("NO SELECCIONADO");
					}
					
					BotonPasajero botonAnterior = botonesSeleccionados.get(a-1);
					
					botonAnterior.setContentAreaFilled(true);
					botonAnterior.setEstadoAsiento("SELECCIONADO");
				
					txtNombre.setText(reservas.getListReservas().get(a-1).getPasajero().getNombre());
					txtApellido.setText(reservas.getListReservas().get(a-1).getPasajero().getApellido());
					txtDni.setText(reservas.getListReservas().get(a-1).getPasajero().getDni());
					
					botonesSeleccionados.remove(a-1);

					botonAnterior.setBackground(new Color(0,128,0));
					botonAnterior.setEnabled(true);

					txtAsiento.setText(botonAnterior.getAsiento().toString());
					txtPrecio.setText(botonAnterior.getPrecio().toString());
					
					reservas.eliminarReserva(a-1);
					
					estadoAnterior = true;
					
					panelPasajeros.remove(panelDatosPasajeros);
					panelPasajeros.remove(btnAnterior);
					panelPasajeros.remove(btnSiguiente);
					
					panelDatosPasajeros.setBorder(new TitledBorder(null, "Pasajero " + a +"/" + opcion, TitledBorder.LEADING, TitledBorder.TOP, new Font("Arial", Font.PLAIN, 16), Color.WHITE));
					
					panelPasajeros.add(panelDatosPasajeros);
					panelPasajeros.add(btnSiguiente);
					
					btnSiguiente.setText("Siguiente");
					
					if (a <= 1){
						a = 1;
					}else {
						panelPasajeros.add(btnAnterior);
					}

					panelPasajeros.validate();
					panelPasajeros.repaint();
				}
				
			}
		});
		btnAnterior.setBounds(25, 320, 120, 30);
	}
	
	private void agregarPanelInfoViaje(ViajeCabecera viaje, Boolean acumula) {
		
		panelInfoVuelo = new JPanel();
		panelInfoVuelo.setBorder(new MatteBorder(0,5,5,0, new Color(25,35,90)));
		panelInfoVuelo.setBackground(new Color(48,63,159));
		panelInfoVuelo.setBounds(580, 415, 370, 265);
		panelInfoVuelo.setLayout(null);
		getContentPane().add(panelInfoVuelo);

		agregarLabelsEtiquetasPanelInfoVuelo();
		agregarLabelsInfoPanelPanelInfoVuelo(viaje, acumula);
	}

	private void agregarLabelsEtiquetasPanelInfoVuelo() {
		
		JLabel label1 = new JLabel("Información sobre el vuelo");
		label1.setFont(new Font("Arial", Font.BOLD, 18));
		label1.setBounds(0, 0, 370, 60);
		label1.setForeground(Color.WHITE);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		panelInfoVuelo.add(label1);
		
		JLabel label2 = new JLabel("Codigo de viaje: ");
		label2.setFont(new Font("Arial", Font.PLAIN, 14));
		label2.setBounds(25, 65, 120, 20);
		label2.setForeground(Color.WHITE);
		panelInfoVuelo.add(label2);
		
		JLabel label3 = new JLabel("Salida: ");
		label3.setFont(new Font("Arial", Font.PLAIN, 14));
		label3.setBounds(25, 95, 120, 20);
		label3.setForeground(Color.WHITE);
		panelInfoVuelo.add(label3);
		
		JLabel label4 = new JLabel("Llegada: ");
		label4.setFont(new Font("Arial", Font.PLAIN, 14));
		label4.setBounds(25, 145, 120, 20);
		label4.setForeground(Color.WHITE);
		panelInfoVuelo.add(label4);
		
		JLabel label5 = new JLabel("Duracion: ");
		label5.setFont(new Font("Arial", Font.PLAIN, 14));
		label5.setBounds(25, 195, 120, 20);
		label5.setForeground(Color.WHITE);
		panelInfoVuelo.add(label5);
		
		JLabel label6 = new JLabel("¿Acumula Kilometros AMPass? ");
		label6.setFont(new Font("Arial", Font.PLAIN, 14));
		label6.setBounds(25, 225, 210, 20);
		label6.setForeground(Color.WHITE);
		panelInfoVuelo.add(label6);
		
	}
	
	private void agregarLabelsInfoPanelPanelInfoVuelo(ViajeCabecera viaje, Boolean acumula) {
		
		lblCodigoViaje = new JLabel(viaje.getCodigoViaje());
		lblCodigoViaje.setFont(new Font("Arial", Font.BOLD, 14));
		lblCodigoViaje.setBounds(145, 65, 80, 20);
		lblCodigoViaje.setForeground(Color.WHITE);
		lblCodigoViaje.setHorizontalAlignment(SwingConstants.LEFT);
		panelInfoVuelo.add(lblCodigoViaje);

		String fechaSalida = viaje.getFechaSalida().toString().substring(8, 10) + "/" + viaje.getFechaSalida().toString().substring(5, 7) + "/" + viaje.getFechaSalida().toString().substring(0, 4);
		String horaSalida = viaje.getHoraSalida().toString().substring(0, 5);
		
		lblSalida = new JLabel("<html>"+viaje.getCiudadOrigen()+" ("+viaje.getPlataformaOrigen()+")<br />"+fechaSalida+" -- "+horaSalida+"</html>");
		lblSalida.setFont(new Font("Arial", Font.BOLD, 14));
		lblSalida.setBounds(145, 95, 200, 40);
		lblSalida.setForeground(Color.WHITE);
		lblSalida.setHorizontalAlignment(SwingConstants.LEFT);
		panelInfoVuelo.add(lblSalida);
	
		String fechaLlegada = viaje.getFechaLlegada().toString().substring(8, 10) + "/" + viaje.getFechaLlegada().toString().substring(5, 7) + "/" + viaje.getFechaLlegada().toString().substring(0, 4);
		String horaLlegada = viaje.getHoraLlegada().toString().substring(0, 5);
		
		lblLlegada = new JLabel("<html>"+viaje.getCiudadDestino()+" ("+viaje.getPlataformaDestino()+")<br />"+fechaLlegada+" -- "+horaLlegada+"</html>");
		lblLlegada.setFont(new Font("Arial", Font.BOLD, 14));
		lblLlegada.setBounds(145, 145, 200, 40);
		lblLlegada.setForeground(Color.WHITE);
		lblLlegada.setHorizontalAlignment(SwingConstants.LEFT);
		panelInfoVuelo.add(lblLlegada);

		String duracion = viaje.getDuracion().toString().substring(0, 5);
		
		lblDuracion = new JLabel(duracion+" hs");
		lblDuracion.setFont(new Font("Arial", Font.BOLD, 14));
		lblDuracion.setBounds(145, 195, 90, 20);
		lblDuracion.setForeground(Color.WHITE);
		lblDuracion.setHorizontalAlignment(SwingConstants.LEFT);
		panelInfoVuelo.add(lblDuracion);		
		
		if (acumula){			
			lblAcumula = new JLabel("SI");
		}else{
			lblAcumula = new JLabel("NO");
		}
		lblAcumula.setFont(new Font("Arial", Font.BOLD, 14));
		lblAcumula.setBounds(235, 225, 40, 20);
		lblAcumula.setForeground(Color.WHITE);
		lblAcumula.setHorizontalAlignment(SwingConstants.LEFT);
		panelInfoVuelo.add(lblAcumula);		
	}
	
	private void cambioItemSeleccionadoCmbCantPasajeros() {
		
		reservas = null;
		
		for (int i = 0; i < botonesSeleccionados.size(); i++) {
			botonesSeleccionados.remove(i);
		}
		
		for (BotonPasajero boton : botones){
			boton.setContentAreaFilled(false);
			boton.setEnabled(true);
		}
	}
	
	public void cargarInfoVuelo(ViajeCabecera viaje, Boolean acumula) {
		agregarPanelInfoViaje(viaje, acumula);	
	}
	
	public ReservaViaje getrV() {
		return rV;
	}

	public void setrV(ReservaViaje rV) {
		this.rV = rV;
	}

	protected void actionPulsarBoton(MouseEvent e){
		
		b = (BotonPasajero) e.getSource();
		
		if (cmbCantPasajeros.getSelectedIndex() > 0){
		
			if (botonesSeleccionados.size() > 0){
				actionPulsarBotonYListaBotonesSeleccionadosMayorACero();				
			}else{
				actionPulsarBotonYListaBotonesSeleccionadosIgualACero();
			}
			
		}
		
	}

	private void actionPulsarBotonYListaBotonesSeleccionadosMayorACero() {
		
		for (BotonPasajero botonSelec : botonesSeleccionados){

			if (b.getName() == botonSelec.getName() && txtAsiento.getText().length() > 0){
				txtAsiento.setText(txtAsiento.getText());
				txtPrecio.setText(txtPrecio.getText());
				botonSelec.setContentAreaFilled(true);
				
				botonSelec.setBackground(Color.WHITE);
				botonSelec.setEnabled(false);
			}else if (b.getName() != botonSelec.getName()){
				
				for (BotonPasajero boton : botones){
					if (boton.getName() != b.getName()){
						boton.setContentAreaFilled(false);
						boton.setToolTipText("DISPONIBLE");
					}
				}
				
				for (BotonPasajero botones : botonesSeleccionados){
					botones.setContentAreaFilled(true);
					botones.setBackground(Color.WHITE);
					botones.setEnabled(false);
				}
				
				if (b.getEstadoAsiento().equals("SELECCIONADO")){
					txtAsiento.setText(b.getAsiento().toString());
					txtPrecio.setText(b.getPrecio().toString());
				}else{
					txtAsiento.setText("");
					txtPrecio.setText("");
				}
			}
			
		}
		
	}

	private void actionPulsarBotonYListaBotonesSeleccionadosIgualACero() {
		
		for (BotonPasajero boton : botones){
			if (boton.getName() != b.getName()){
				boton.setContentAreaFilled(false);
				boton.setToolTipText("DISPONIBLE");
			}

		}
		
		if (b.getEstadoAsiento().equals("SELECCIONADO")){
			txtAsiento.setText(b.getAsiento().toString());
			txtPrecio.setText(b.getPrecio().toString());
		} else {
		    
			txtAsiento.setText("");
			txtPrecio.setText("");

			if (b.getEstadoAsiento().equals("OCUPADO")){
			
			}
		    
		}
	}
	
	public void cargarAsientos(ViajeCabecera viaje){
		agregarPanelAsientos(viaje);
	}
	
	public void setearViajeYDniReserva(ViajeCabecera viaje, String dni) {
		agregarPanelInfoPasajeros(viaje, dni);
	}

	protected void accionesBotonesOcupados(ViajeCabecera viaje){
	
		controlarAsientosOcupados(viaje);
		
		setearPropiedadesBotonesOcupados();
		
		removerBotonesOcupadosDeListaDeBotones();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		actionPulsarBoton(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}