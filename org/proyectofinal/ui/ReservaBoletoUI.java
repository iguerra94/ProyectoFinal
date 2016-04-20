package org.proyectofinal.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.SystemColor;
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
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import org.proyectofinal.ui.botones.BotonPasajero;
import org.proyectofinal.ui.util.Pasajero;
import org.proyectofinal.ui.util.ReservaPasajero;
import org.proyectofinal.ui.util.ex.NotValidPassengerException;

import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

public class ReservaBoletoUI extends JFrame implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3014223326291727038L;
	
	private JLabel lblNumeroDeViaje;
	private JLabel lblOrigen;
	private JLabel lblDestino;
	private JLabel lblSalida;
	private JLabel lblLlegada;
	private JLabel lblAsientosDisp;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbCantPasajeros;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtAsiento;
	private JTextField txtPrecio;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private List<BotonPasajero> botones;
	private List<BotonPasajero> botonesSeleccionados = new ArrayList<>();
	private int a = 1;
	private Object opcion;
	private Pasajero pasajero;
	private Boolean estadoAnterior = false;
	private BotonPasajero b;
//	private List<Pasajero> lista;
	private ReservaPasajero reserva;
	
	/**
	 * Create the frame.
	 */
	@SuppressWarnings("rawtypes")
	public ReservaBoletoUI() {
		
		final JLabel lblSeleccioneCantPasajeros = new JLabel("  Seleccione la cantidad de pasajeros");
		lblSeleccioneCantPasajeros.setIcon(new ImageIcon(ReservaBoletoUI.class.getResource("/imagenes/flecha_derecha.png")));
		lblSeleccioneCantPasajeros.setBounds(245, 43, 333, 65);
		getContentPane().add(lblSeleccioneCantPasajeros);

		addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
				if (txtNombre.getText().trim().length() > 0){
					pasajero.setNombre(txtNombre.getText());
				}else{
					pasajero.setNombre("");
				}
				
				if (txtApellido.getText().trim().length() > 0){
					pasajero.setApellido(txtApellido.getText());
				}else{
					pasajero.setApellido("");
				}
				
				if (txtDni.getText().trim().length() > 0){
					pasajero.setDni(Integer.parseInt(txtDni.getText()));
				}else{
					pasajero.setDni(-1);
				}
				
				pasajero.setAsientoPasajero(b);
				
				if (pasajero.getAsientoPasajero() != null){
					
					if (txtAsiento.getText().length() > 0){
						pasajero.getAsientoPasajero().setAsiento(txtAsiento.getText());
						pasajero.getAsientoPasajero().setPrecio(Float.parseFloat(txtPrecio.getText()));
					}
					if (txtAsiento.getText().length() == 0){
						pasajero.setAsientoPasajero(null);
						pasajero.getAsientoPasajero().setAsiento("");
						pasajero.getAsientoPasajero().setPrecio(-1f);
					}
					
				}
				
			}
		});
		
		final JPanel panelAsientos = new JPanel();
		panelAsientos.setBounds(12, 12, 537, 585);
		panelAsientos.setLayout(null);
		getContentPane().add(panelAsientos);
		
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				
				cmbCantPasajeros.requestFocus();
				
				if (cmbCantPasajeros.getSelectedIndex() == 0){
					getContentPane().remove(panelAsientos);
					getContentPane().validate();
					getContentPane().repaint();
				}
				
				if (txtNombre.getText().trim().length() == 0){
					pasajero.setNombre("");
				}else{
					pasajero.setNombre(txtNombre.getText());
				}
				
				if (txtApellido.getText().trim().length() == 0){
					pasajero.setApellido("");
				}else{
					pasajero.setApellido(txtApellido.getText());
				}
				
				if (txtDni.getText().trim().length() == 0){
					pasajero.setDni(-1);
				}else{
					pasajero.setDni(Integer.parseInt(txtDni.getText()));
				}
				
//				if (txtAsiento.getText().trim().length() == 0){
//					pasajero.setAsientoPasajero(null);
//				}else{
//					pasajero.setAsientoPasajero(b);
//					pasajero.getAsientoPasajero().setAsiento(txtAsiento.getText());
//				}
//				
//				if (txtPrecio.getText().trim().length() == 0){
//					pasajero.getAsientoPasajero().setPrecio(-1f);
//				}else{
//					pasajero.getAsientoPasajero().setPrecio(Float.parseFloat(txtPrecio.getText()));
//				}
				
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
		
		pasajero = new Pasajero();
		
//		reserva = new ReservaPasajero();
		
		botones = new ArrayList<BotonPasajero>();
		
//		pasajeros = new ArrayList<List<Object>>();
		
		setTitle("Reserva de Boleto");
		getContentPane().setLayout(null);

		setSize(970,632);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);

		final JPanel panelPasajeros = new JPanel();
		panelPasajeros.setLayout(null);
		panelPasajeros.setBorder(new LineBorder(new Color(99, 130, 191), 4));
		panelPasajeros.setBackground(Color.GRAY);
		panelPasajeros.setBounds(580, 12, 374, 323);
		getContentPane().add(panelPasajeros);
		
		JPanel panelInfoVuelo = new JPanel();
		panelInfoVuelo.setBorder(new LineBorder(new Color(99, 130, 191), 4));
		panelInfoVuelo.setBackground(UIManager.getColor("EditorPane.inactiveForeground"));
		panelInfoVuelo.setBounds(580, 346, 374, 250);
		panelInfoVuelo.setLayout(null);
		getContentPane().add(panelInfoVuelo);
		
		lblAsientosDisp = new JLabel("");
		lblAsientosDisp.setBounds(109, 12, 40, 44);
		panelAsientos.add(lblAsientosDisp);
		lblAsientosDisp.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsientosDisp.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAsientosDisp.setForeground(new Color(0, 128, 0));
		
		JLabel lblCantidadDeAsientos = new JLabel("<html><center>Asientos disponibles: </center></html>");
		lblCantidadDeAsientos.setBounds(12, 12, 98, 44);
		panelAsientos.add(lblCantidadDeAsientos);
		lblCantidadDeAsientos.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(173, 142, 51, 124);
		panelAsientos.add(panel1);
		panel1.setOpaque(false);
		panel1.setLayout(new GridLayout(3, 2, 0, 7));
	
		final BotonPasajero btnNro1 = new BotonPasajero("1", 180f);			
		btnNro1.setName("btnNro1");
		btnNro1.addMouseListener(this);
		btnNro1.setBackground(new Color(0, 128, 0));
		btnNro1.setContentAreaFilled(false);
		btnNro1.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro1.setMargin(new Insets(2, 0, 2, 0));
		panel1.add(btnNro1);
		
		botones.add(btnNro1);
		
		final BotonPasajero btnNro2 = new BotonPasajero("2", 180f);		
		btnNro2.setName("btnNro2");
		btnNro2.addMouseListener(this);
		btnNro2.setBackground(new Color(0, 128, 0));
		btnNro2.setContentAreaFilled(false);
		btnNro2.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro2.setMargin(new Insets(2, 0, 2, 0));
		btnNro2.setHorizontalTextPosition(SwingConstants.CENTER);
		panel1.add(btnNro2);

		botones.add(btnNro2);
		
		final BotonPasajero btnNro7 = new BotonPasajero("7", 180f);
		btnNro7.setName("btnNro7");
		btnNro7.addMouseListener(this);
		btnNro7.setBackground(new Color(0, 128, 0));
		btnNro7.setContentAreaFilled(false);
		btnNro7.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro7.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro7.setMargin(new Insets(2, 0, 2, 0));
		panel1.add(btnNro7);

		botones.add(btnNro7);
		
		final BotonPasajero btnNro8 = new BotonPasajero("8", 180f);
		btnNro8.setName("btnNro8");
		btnNro8.addMouseListener(this);
		btnNro8.setBackground(new Color(0, 128, 0));
		btnNro8.setContentAreaFilled(false);
		btnNro8.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro8.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro8.setMargin(new Insets(2, 0, 2, 0));
		panel1.add(btnNro8);

		botones.add(btnNro8);
		
		final BotonPasajero btnNro13 = new BotonPasajero("13", 180f);
		btnNro13.setName("btnNro13");
		btnNro13.addMouseListener(this);
		btnNro13.setBackground(new Color(0, 128, 0));
		btnNro13.setContentAreaFilled(false);
		btnNro13.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro13.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro13.setMargin(new Insets(2, 0, 2, 0));
		panel1.add(btnNro13);

		botones.add(btnNro13);
		
		final BotonPasajero btnNro14 = new BotonPasajero("14", 180f);
		btnNro14.setName("btnNro14");
		btnNro14.addMouseListener(this);
		btnNro14.setBackground(new Color(0, 128, 0));
		btnNro14.setContentAreaFilled(false);
		btnNro14.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro14.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro14.setMargin(new Insets(2, 0, 2, 0));
		panel1.add(btnNro14);

		botones.add(btnNro14);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(237, 142, 58, 124);
		panelAsientos.add(panel2);
		panel2.setOpaque(false);
		panel2.setLayout(new GridLayout(3, 2, 0, 7));
		
		final BotonPasajero btnNro3 = new BotonPasajero("3", 180f);
		btnNro3.setName("btnNro3");
		btnNro3.addMouseListener(this);
		btnNro3.setBackground(new Color(0, 128, 0));
		btnNro3.setContentAreaFilled(false);
		btnNro3.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro3.setMargin(new Insets(2, 0, 2, 0));
		panel2.add(btnNro3);

		botones.add(btnNro3);
		
		final BotonPasajero btnNro4 = new BotonPasajero("4", 180f);
		btnNro4.setName("btnNro4");
		btnNro4.addMouseListener(this);
		btnNro4.setBackground(new Color(0, 128, 0));
		btnNro4.setContentAreaFilled(false);
		btnNro4.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro4.setMargin(new Insets(2, 0, 2, 0));
		panel2.add(btnNro4);

		botones.add(btnNro4);
		
		final BotonPasajero btnNro9 = new BotonPasajero("9", 180f);
		btnNro9.setName("btnNro9");
		btnNro9.addMouseListener(this);
		btnNro9.setBackground(new Color(0, 128, 0));
		btnNro9.setContentAreaFilled(false);
		btnNro9.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro9.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro9.setMargin(new Insets(2, 0, 2, 0));
		panel2.add(btnNro9);

		botones.add(btnNro9);
		
		final BotonPasajero btnNro10 = new BotonPasajero("10", 180f);
		btnNro10.setName("btnNro10");
		btnNro10.addMouseListener(this);
		btnNro10.setBackground(new Color(0, 128, 0));
		btnNro10.setContentAreaFilled(false);
		btnNro10.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro10.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro10.setMargin(new Insets(2, 0, 2, 0));
		panel2.add(btnNro10);

		botones.add(btnNro10);
		
		final BotonPasajero btnNro15 = new BotonPasajero("15", 180f);
		btnNro15.setName("btnNro15");
		btnNro15.addMouseListener(this);
		btnNro15.setBackground(new Color(0, 128, 0));
		btnNro15.setContentAreaFilled(false);
		btnNro15.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro15.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro15.setMargin(new Insets(2, 0, 2, 0));
		panel2.add(btnNro15);

		botones.add(btnNro15);
		
		final BotonPasajero btnNro16 = new BotonPasajero("16", 180f);
		btnNro16.setName("btnNro16");
		btnNro16.addMouseListener(this);
		btnNro16.setBackground(new Color(0, 128, 0));
		btnNro16.setContentAreaFilled(false);
		btnNro16.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro16.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro16.setMargin(new Insets(2, 0, 2, 0));
		panel2.add(btnNro16);

		botones.add(btnNro16);
		
		JPanel panel3 = new JPanel();
		panel3.setBounds(307, 142, 57, 124);
		panelAsientos.add(panel3);
		panel3.setOpaque(false);
		panel3.setLayout(new GridLayout(3, 2, 0, 7));
		
		final BotonPasajero btnNro5 = new BotonPasajero("5", 180f);
		btnNro5.setName("btnNro5");
		btnNro5.addMouseListener(this);
		btnNro5.setBackground(new Color(0, 128, 0));
		btnNro5.setContentAreaFilled(false);
		btnNro5.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro5.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro5.setMargin(new Insets(2, 0, 2, 0));
		panel3.add(btnNro5);

		botones.add(btnNro5);
		
		final BotonPasajero btnNro6 = new BotonPasajero("6", 180f);
		btnNro6.setName("btnNro6");
		btnNro6.addMouseListener(this);
		btnNro6.setBackground(new Color(0, 128, 0));
		btnNro6.setContentAreaFilled(false);
		btnNro6.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro6.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro6.setMargin(new Insets(2, 2, 2, 2));
		panel3.add(btnNro6);

		botones.add(btnNro6);
		
		final BotonPasajero btnNro11 = new BotonPasajero("11", 180f);
		btnNro11.setName("btnNro11");
		btnNro11.addMouseListener(this);
		btnNro11.setBackground(new Color(0, 128, 0));
		btnNro11.setContentAreaFilled(false);
		btnNro11.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro11.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro11.setMargin(new Insets(2, 0, 2, 0));
		panel3.add(btnNro11);

		botones.add(btnNro11);
		
		final BotonPasajero btnNro12 = new BotonPasajero("12", 180f);
		btnNro12.setName("btnNro12");
		btnNro12.addMouseListener(this);
		btnNro12.setBackground(new Color(0, 128, 0));
		btnNro12.setContentAreaFilled(false);
		btnNro12.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro12.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro12.setMargin(new Insets(2, 0, 2, 0));
		panel3.add(btnNro12);

		botones.add(btnNro12);
		
		final BotonPasajero btnNro17 = new BotonPasajero("17", 180f);
		btnNro17.setName("btnNro17");
		btnNro17.addMouseListener(this);
		btnNro17.setBackground(new Color(0, 128, 0));
		btnNro17.setContentAreaFilled(false);
		btnNro17.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro17.setMargin(new Insets(2, 0, 2, 0));
		btnNro17.setHorizontalTextPosition(SwingConstants.CENTER);
		panel3.add(btnNro17);

		botones.add(btnNro17);
		
		final BotonPasajero btnNro18 = new BotonPasajero("18", 180f);
		btnNro18.setName("btnNro18");
		btnNro18.addMouseListener(this);
		btnNro18.setBackground(new Color(0, 128, 0));
		btnNro18.setContentAreaFilled(false);
		btnNro18.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro18.setMargin(new Insets(2, 0, 2, 0));
		btnNro18.setHorizontalTextPosition(SwingConstants.CENTER);
		panel3.add(btnNro18);

		botones.add(btnNro18);
		
		JPanel panel4 = new JPanel();
		panel4.setBounds(173, 281, 51, 292);
		panelAsientos.add(panel4);
		panel4.setOpaque(false);
		panel4.setLayout(new GridLayout(8, 2, 0, 7));
		
		final BotonPasajero btnNro19 = new BotonPasajero("19", 90f);
		btnNro19.setName("btnNro19");
		btnNro19.addMouseListener(this);
		btnNro19.setBackground(new Color(0, 128, 0));
		btnNro19.setContentAreaFilled(false);
		btnNro19.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro19.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro19.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro19);

		botones.add(btnNro19);
		
		final BotonPasajero btnNro20 = new BotonPasajero("20", 90f);
		btnNro20.setName("btnNro20");
		btnNro20.addMouseListener(this);
		btnNro20.setBackground(new Color(0, 128, 0));
		btnNro20.setContentAreaFilled(false);
		btnNro20.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro20.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro20.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro20);

		botones.add(btnNro20);
		
		final BotonPasajero btnNro25 = new BotonPasajero("25", 90f);
		btnNro25.setName("btnNro25");
		btnNro25.addMouseListener(this);
		btnNro25.setBackground(new Color(0, 128, 0));
		btnNro25.setContentAreaFilled(false);
		btnNro25.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro25.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro25.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro25);

		botones.add(btnNro25);
		
		final BotonPasajero btnNro26 = new BotonPasajero("26", 90f);
		btnNro26.setName("btnNro26");
		btnNro26.addMouseListener(this);
		btnNro26.setBackground(new Color(0, 128, 0));
		btnNro26.setContentAreaFilled(false);
		btnNro26.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro26.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro26.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro26);

		botones.add(btnNro26);
		
		final BotonPasajero btnNro31 = new BotonPasajero("31", 90f);
		btnNro31.setName("btnNro31");
		btnNro31.addMouseListener(this);
		btnNro31.setBackground(new Color(0, 128, 0));
		btnNro31.setContentAreaFilled(false);
		btnNro31.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro31.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro31.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro31);

		botones.add(btnNro31);
		
		final BotonPasajero btnNro32 = new BotonPasajero("32", 90f);
		btnNro32.setName("btnNro32");
		btnNro32.addMouseListener(this);
		btnNro32.setBackground(new Color(0, 128, 0));
		btnNro32.setContentAreaFilled(false);
		btnNro32.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro32.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro32.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro32);

		botones.add(btnNro32);
		
		final BotonPasajero btnNro37 = new BotonPasajero("37", 90f);
		btnNro37.setName("btnNro37");
		btnNro37.addMouseListener(this);
		btnNro37.setBackground(new Color(0, 128, 0));
		btnNro37.setContentAreaFilled(false);
		btnNro37.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro37.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro37.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro37);

		botones.add(btnNro37);
		
		final BotonPasajero btnNro38 = new BotonPasajero("38", 90f);
		btnNro38.setName("btnNro38");
		btnNro38.addMouseListener(this);
		btnNro38.setBackground(new Color(0, 128, 0));
		btnNro38.setContentAreaFilled(false);
		btnNro38.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro38.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro38.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro38);

		botones.add(btnNro38);
		
		final BotonPasajero btnNro43 = new BotonPasajero("43", 90f);
		btnNro43.setName("btnNro43");
		btnNro43.addMouseListener(this);
		btnNro43.setBackground(new Color(0, 128, 0));
		btnNro43.setContentAreaFilled(false);
		btnNro43.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro43.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro43.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro43);

		botones.add(btnNro43);
		
		final BotonPasajero btnNro44 = new BotonPasajero("44", 90f);
		btnNro44.setName("btnNro44");
		btnNro44.addMouseListener(this);
		btnNro44.setBackground(new Color(0, 128, 0));
		btnNro44.setContentAreaFilled(false);
		btnNro44.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro44.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro44.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro44);

		botones.add(btnNro44);
		
		final BotonPasajero btnNro49 = new BotonPasajero("49", 90f);
		btnNro49.setName("btnNro49");
		btnNro49.addMouseListener(this);
		btnNro49.setBackground(new Color(0, 128, 0));
		btnNro49.setContentAreaFilled(false);
		btnNro49.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro49.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro49.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro49);

		botones.add(btnNro49);
		
		final BotonPasajero btnNro50 = new BotonPasajero("50", 90f);
		btnNro50.setName("btnNro50");
		btnNro50.addMouseListener(this);
		btnNro50.setBackground(new Color(0, 128, 0));
		btnNro50.setContentAreaFilled(false);
		btnNro50.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro50.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro50.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro50);

		botones.add(btnNro50);
		
		final BotonPasajero btnNro55 = new BotonPasajero("55", 90f);
		btnNro55.setName("btnNro55");
		btnNro55.addMouseListener(this);
		btnNro55.setBackground(new Color(0, 128, 0));
		btnNro55.setContentAreaFilled(false);
		btnNro55.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro55.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro55.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro55);

		botones.add(btnNro55);
		
		final BotonPasajero btnNro56 = new BotonPasajero("56", 90f);
		btnNro56.setName("btnNro56");
		btnNro56.addMouseListener(this);
		btnNro56.setBackground(new Color(0, 128, 0));
		btnNro56.setContentAreaFilled(false);
		btnNro56.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro56.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro56.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro56);

		botones.add(btnNro56);
		
		final BotonPasajero btnNro61 = new BotonPasajero("61", 90f);
		btnNro61.setName("btnNro61");
		btnNro61.addMouseListener(this);
		btnNro61.setBackground(new Color(0, 128, 0));
		btnNro61.setContentAreaFilled(false);
		btnNro61.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro61.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro61.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro61);

		botones.add(btnNro61);
		
		final BotonPasajero btnNro62 = new BotonPasajero("62", 90f);
		btnNro62.setName("btnNro62");
		btnNro62.addMouseListener(this);
		btnNro62.setBackground(new Color(0, 128, 0));
		btnNro62.setContentAreaFilled(false);
		btnNro62.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro62.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro62.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro62);

		botones.add(btnNro62);
		
		JPanel panel5 = new JPanel();
		panel5.setBounds(237, 281, 58, 292);
		panelAsientos.add(panel5);
		panel5.setOpaque(false);
		panel5.setLayout(new GridLayout(8, 2, 0, 7));
		
		final BotonPasajero btnNro21 = new BotonPasajero("21", 90f);
		btnNro21.setName("btnNro21");
		btnNro21.addMouseListener(this);
		btnNro21.setBackground(new Color(0, 128, 0));
		btnNro21.setContentAreaFilled(false);
		btnNro21.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro21.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro21.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro21);

		botones.add(btnNro21);
		
		final BotonPasajero btnNro22 = new BotonPasajero("22", 90f);
		btnNro22.setName("btnNro22");
		btnNro22.addMouseListener(this);
		btnNro22.setBackground(new Color(0, 128, 0));
		btnNro22.setContentAreaFilled(false);
		btnNro22.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro22.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro22.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro22);

		botones.add(btnNro22);
		
		final BotonPasajero btnNro27 = new BotonPasajero("27", 90f);
		btnNro27.setName("btnNro27");
		btnNro27.addMouseListener(this);
		btnNro27.setBackground(new Color(0, 128, 0));
		btnNro27.setContentAreaFilled(false);
		btnNro27.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro27.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro27.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro27);

		botones.add(btnNro27);
		
		final BotonPasajero btnNro28 = new BotonPasajero("28", 90f);
		btnNro28.setName("btnNro28");
		btnNro28.addMouseListener(this);
		btnNro28.setBackground(new Color(0, 128, 0));
		btnNro28.setContentAreaFilled(false);
		btnNro28.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro28.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro28.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro28);

		botones.add(btnNro28);
		
		final BotonPasajero btnNro33 = new BotonPasajero("33", 90f);
		btnNro33.setName("btnNro33");
		btnNro33.addMouseListener(this);
		btnNro33.setBackground(new Color(0, 128, 0));
		btnNro33.setContentAreaFilled(false);
		btnNro33.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro33.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro33.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro33);

		botones.add(btnNro33);
		
		final BotonPasajero btnNro34 = new BotonPasajero("34", 90f);
		btnNro34.setName("btnNro34");
		btnNro34.addMouseListener(this);
		btnNro34.setBackground(new Color(0, 128, 0));
		btnNro34.setContentAreaFilled(false);
		btnNro34.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro34.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro34.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro34);

		botones.add(btnNro34);
		
		final BotonPasajero btnNro39 = new BotonPasajero("39", 90f);
		btnNro39.setName("btnNro39");
		btnNro39.addMouseListener(this);
		btnNro39.setBackground(new Color(0, 128, 0));
		btnNro39.setContentAreaFilled(false);
		btnNro39.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro39.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro39.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro39);

		botones.add(btnNro39);
		
		final BotonPasajero btnNro40 = new BotonPasajero("40", 90f);
		btnNro40.setName("btnNro40");
		btnNro40.addMouseListener(this);
		btnNro40.setBackground(new Color(0, 128, 0));
		btnNro40.setContentAreaFilled(false);
		btnNro40.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro40.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro40.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro40);

		botones.add(btnNro40);
		
		final BotonPasajero btnNro45 = new BotonPasajero("45", 90f);
		btnNro45.setName("btnNro45");
		btnNro45.addMouseListener(this);
		btnNro45.setBackground(new Color(0, 128, 0));
		btnNro45.setContentAreaFilled(false);
		btnNro45.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro45.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro45.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro45);

		botones.add(btnNro45);
		
		final BotonPasajero btnNro46 = new BotonPasajero("46", 90f);
		btnNro46.setName("btnNro46");
		btnNro46.addMouseListener(this);
		btnNro46.setBackground(new Color(0, 128, 0));
		btnNro46.setContentAreaFilled(false);
		btnNro46.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro46.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro46.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro46);

		botones.add(btnNro46);
		
		final BotonPasajero btnNro51 = new BotonPasajero("51", 90f);
		btnNro51.setName("btnNro51");
		btnNro51.addMouseListener(this);
		btnNro51.setBackground(new Color(0, 128, 0));
		btnNro51.setContentAreaFilled(false);
		btnNro51.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro51.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro51.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro51);

		botones.add(btnNro51);
		
		final BotonPasajero btnNro52 = new BotonPasajero("52", 90f);
		btnNro52.setName("btnNro52");
		btnNro52.addMouseListener(this);
		btnNro52.setBackground(new Color(0, 128, 0));
		btnNro52.setContentAreaFilled(false);
		btnNro52.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro52.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro52.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro52);

		botones.add(btnNro52);
		
		final BotonPasajero btnNro57 = new BotonPasajero("57", 90f);
		btnNro57.setName("btnNro57");
		btnNro57.addMouseListener(this);
		btnNro57.setBackground(new Color(0, 128, 0));
		btnNro57.setContentAreaFilled(false);
		btnNro57.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro57.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro57.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro57);

		botones.add(btnNro57);
		
		final BotonPasajero btnNro58 = new BotonPasajero("58", 90f);
		btnNro58.setName("btnNro58");
		btnNro58.addMouseListener(this);
		btnNro58.setBackground(new Color(0, 128, 0));
		btnNro58.setContentAreaFilled(false);
		btnNro58.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro58.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro58.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro58);

		botones.add(btnNro58);
		
		final BotonPasajero btnNro63 = new BotonPasajero("63", 90f);
		btnNro63.setName("btnNro63");
		btnNro63.addMouseListener(this);
		btnNro63.setBackground(new Color(0, 128, 0));
		btnNro63.setContentAreaFilled(false);
		btnNro63.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro63.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro63.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro63);

		botones.add(btnNro63);
		
		final BotonPasajero btnNro64 = new BotonPasajero("64", 90f);
		btnNro64.setName("btnNro64");
		btnNro64.addMouseListener(this);
		btnNro64.setBackground(new Color(0, 128, 0));
		btnNro64.setContentAreaFilled(false);
		btnNro64.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro64.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro64.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro64);

		botones.add(btnNro64);
		
		JPanel panel6 = new JPanel();
		panel6.setBounds(306, 281, 58, 292);
		panelAsientos.add(panel6);
		panel6.setOpaque(false);
		panel6.setLayout(new GridLayout(8, 2, 0, 7));
		
		final BotonPasajero btnNro23 = new BotonPasajero("23", 90f);
		btnNro23.setName("btnNro23");
		btnNro23.addMouseListener(this);
		btnNro23.setBackground(new Color(0, 128, 0));
		btnNro23.setContentAreaFilled(false);
		btnNro23.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro23.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro23.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro23);
		
		botones.add(btnNro23);
		
		final BotonPasajero btnNro24 = new BotonPasajero("24", 90f);
		btnNro24.setName("btnNro24");
		btnNro24.addMouseListener(this);
		btnNro24.setBackground(new Color(0, 128, 0));
		btnNro24.setContentAreaFilled(false);
		btnNro24.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro24.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro24.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro24);
				
		botones.add(btnNro24);
		
		final BotonPasajero btnNro29 = new BotonPasajero("29", 90f);
		btnNro29.setName("btnNro29");
		btnNro29.addMouseListener(this);
		btnNro29.setBackground(new Color(0, 128, 0));
		btnNro29.setContentAreaFilled(false);
		btnNro29.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro29.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro29.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro29);
		
		botones.add(btnNro29);
		
		final BotonPasajero btnNro30 = new BotonPasajero("30", 90f);
		btnNro30.setName("btnNro30");
		btnNro30.addMouseListener(this);
		btnNro30.setBackground(new Color(0, 128, 0));
		btnNro30.setContentAreaFilled(false);
		btnNro30.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro30.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro30.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro30);
									
		botones.add(btnNro30);
		
		final BotonPasajero btnNro35 = new BotonPasajero("35", 90f);
		btnNro35.setName("btnNro35");
		btnNro35.addMouseListener(this);
		btnNro35.setBackground(new Color(0, 128, 0));
		btnNro35.setContentAreaFilled(false);
		btnNro35.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro35.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro35.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro35);
											
		botones.add(btnNro35);
		
		final BotonPasajero btnNro36 = new BotonPasajero("36", 90f);
		btnNro36.setName("btnNro36");
		btnNro36.addMouseListener(this);
		btnNro36.setBackground(new Color(0, 128, 0));
		btnNro36.setContentAreaFilled(false);
		btnNro36.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro36.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro36.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro36);
											
		botones.add(btnNro36);
		
		final BotonPasajero btnNro41 = new BotonPasajero("41", 90f);
		btnNro41.setName("btnNro41");
		btnNro41.addMouseListener(this);
		btnNro41.setBackground(new Color(0, 128, 0));
		btnNro41.setContentAreaFilled(false);
		btnNro41.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro41.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro41.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro41);
														
		botones.add(btnNro41);
		
		final BotonPasajero btnNro42 = new BotonPasajero("42", 90f);
		btnNro42.setName("btnNro42");
		btnNro42.addMouseListener(this);
		btnNro42.setBackground(new Color(0, 128, 0));
		btnNro42.setContentAreaFilled(false);
		btnNro42.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro42.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro42.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro42);
																
		botones.add(btnNro42);
		
		final BotonPasajero btnNro47 = new BotonPasajero("47", 90f);
		btnNro47.setName("btnNro47");
		btnNro47.addMouseListener(this);
		btnNro47.setBackground(new Color(0, 128, 0));
		btnNro47.setContentAreaFilled(false);
		btnNro47.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro47.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro47.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro47);
																		
		botones.add(btnNro47);
		
		final BotonPasajero btnNro48 = new BotonPasajero("48", 90f);
		btnNro48.setName("btnNro48");
		btnNro48.addMouseListener(this);
		btnNro48.setBackground(new Color(0, 128, 0));
		btnNro48.setContentAreaFilled(false);
		btnNro48.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro48.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro48.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro48);
																				
		botones.add(btnNro48);
		
		final BotonPasajero btnNro53 = new BotonPasajero("53", 90f);
		btnNro53.setName("btnNro53");
		btnNro53.addMouseListener(this);
		btnNro53.setBackground(new Color(0, 128, 0));
		btnNro53.setContentAreaFilled(false);
		btnNro53.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro53.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro53.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro53);
																						
		botones.add(btnNro53);
		
		final BotonPasajero btnNro54 = new BotonPasajero("54", 90f);
		btnNro54.setName("btnNro54");
		btnNro54.addMouseListener(this);
		btnNro54.setBackground(new Color(0, 128, 0));
		btnNro54.setContentAreaFilled(false);
		btnNro54.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro54.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro54.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro54);
		
		botones.add(btnNro54);
		
		final BotonPasajero btnNro59 = new BotonPasajero("59", 90f);
		btnNro59.setName("btnNro59");
		btnNro59.addMouseListener(this);
		btnNro59.setBackground(new Color(0, 128, 0));
		btnNro59.setContentAreaFilled(false);
		btnNro59.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro59.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro59.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro59);

		botones.add(btnNro59);
		
		final BotonPasajero btnNro60 = new BotonPasajero("60", 90f);
		btnNro60.setName("btnNro60");
		btnNro60.addMouseListener(this);
		btnNro60.setBackground(new Color(0, 128, 0));
		btnNro60.setContentAreaFilled(false);
		btnNro60.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro60.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro60.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro60);
																										
		botones.add(btnNro60);
		
		final BotonPasajero btnNro65 = new BotonPasajero("65", 90f);
		btnNro65.setName("btnNro65");
		btnNro65.addMouseListener(this);
		btnNro65.setBackground(new Color(0, 128, 0));
		btnNro65.setContentAreaFilled(false);
		btnNro65.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro65.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro65.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro65);
																												
		botones.add(btnNro65);
		
		final BotonPasajero btnNro66 = new BotonPasajero("66", 90f);
		btnNro66.setName("btnNro66");
		btnNro66.addMouseListener(this);
		btnNro66.setBackground(new Color(0, 128, 0));
		btnNro66.setContentAreaFilled(false);
		btnNro66.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro66.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro66.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro66);
																												
		botones.add(btnNro66);
		
		JLabel lblAvion = new JLabel("");
		lblAvion.setBounds(0, 0, 537, 584);
		panelAsientos.add(lblAvion);
		lblAvion.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvion.setIcon(new ImageIcon(ReservaBoletoUI.class.getResource("/imagenes/avion.png")));
		
		lblNumeroDeViaje = new JLabel("Numero de viaje: ");
		lblNumeroDeViaje.setBounds(20, 80, 337, 30);
		panelInfoVuelo.add(lblNumeroDeViaje);
		
		lblOrigen = new JLabel("Origen: ");
		lblOrigen.setBounds(20, 110, 337, 30);
		panelInfoVuelo.add(lblOrigen);
		
		lblDestino = new JLabel("Destino: ");
		lblDestino.setBounds(20, 140, 337, 30);
		panelInfoVuelo.add(lblDestino);
		
		lblSalida = new JLabel("Salida: ");
		lblSalida.setBounds(20, 170, 337, 30);
		panelInfoVuelo.add(lblSalida);
		
		lblLlegada = new JLabel("Llegada: ");
		lblLlegada.setBounds(20, 200, 337, 30);
		panelInfoVuelo.add(lblLlegada);
		
		JLabel lblInformacionSobreEl = new JLabel("<html><center>Información sobre el vuelo <br />seleccionado: </center></html>");
		lblInformacionSobreEl.setBounds(0, 11, 374, 65);
		panelInfoVuelo.add(lblInformacionSobreEl);
		lblInformacionSobreEl.setForeground(SystemColor.controlDkShadow);
		lblInformacionSobreEl.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacionSobreEl.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblCantPasajeros = new JLabel("Cantidad de pasajeros: ");
		lblCantPasajeros.setBounds(20, 48, 183, 30);
		panelPasajeros.add(lblCantPasajeros);
		
//		Integer cant = Integer.parseInt(getCantDisp());
		
//		Object[] cantidad = new String[cant];
		
//		for(int i = 0; i < cant; i++){
//			cantidad[i] = i+1;
//		}
		
		final JPanel panelDatosPasajeros = new JPanel();
		panelDatosPasajeros.setBackground(Color.GRAY);
		panelDatosPasajeros.setBounds(20, 89, 333, 182);
		panelDatosPasajeros.setLayout(null);

		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					if (estadoAnterior){
						for (BotonPasajero boton: botones){
							if (boton.getEstadoAsiento().equals("SELECCIONADO")){
								System.out.println(boton.getText());
								pasajero.setNombre(txtNombre.getText());
								pasajero.setApellido(txtApellido.getText());
								pasajero.setDni(Integer.parseInt(txtDni.getText()));
								pasajero.setAsientoPasajero(boton);
								pasajero.getAsientoPasajero().setAsiento(boton.getAsiento());
								pasajero.getAsientoPasajero().setPrecio(boton.getPrecio());
							}
						}
						estadoAnterior = false;
					}else{
						
						//Setear el asiento del pasajero seleccionado
						pasajero.setAsientoPasajero(b);
						
						if (pasajero.getAsientoPasajero() != null){
	
							//Colocar texto en campos de asiento y precio
							if (txtAsiento.getText().trim().length() > 0){
								pasajero.getAsientoPasajero().setAsiento(txtAsiento.getText());
							}else{
								pasajero.getAsientoPasajero().setAsiento("");
							}
							
							if (txtPrecio.getText().trim().length() > 0){
								pasajero.getAsientoPasajero().setPrecio(Float.parseFloat(txtPrecio.getText()));
							}else{
								pasajero.getAsientoPasajero().setPrecio(-1f);
							}
						}
					}
					
					//Verifico que los datos del pasajero sean correctos y sino lanza excepcion 
					pasajero.verificarDatosPasajero(pasajero);
				
//					if (a > 1 && reserva.getListPasajeros().get(a).getDni() != null){
//						System.out.println("a");
//						txtNombre.setText(reserva.getListPasajeros().get(a).getNombre());
//						txtApellido.setText(reserva.getListPasajeros().get(a).getApellido());
//						txtDni.setText(reserva.getListPasajeros().get(a).getDni().toString());
//						botonesSeleccionados.get(a).setBackground(Color.WHITE);
//						botonesSeleccionados.add(a);
//						txtAsiento.setText(reserva.getListPasajeros().get(a).getAsientoPasajero().getAsiento());
//						txtPrecio.setText(reserva.getListPasajeros().get(a).getAsientoPasajero().getPrecio().toString());	
//					}
					
//					System.out.println(a);
					//Aumento la variable que controla el numero de pasajero en uno
					a++;
					
					panelPasajeros.remove(panelDatosPasajeros);
					panelPasajeros.remove(btnSiguiente);
					
					panelDatosPasajeros.setBorder(new TitledBorder(null, "Pasajero " + a +"/" + opcion, TitledBorder.LEADING, TitledBorder.TOP, null, null));
					
					panelPasajeros.add(panelDatosPasajeros);
					
					panelPasajeros.add(btnSiguiente);
					
					if (a > 1){
						panelPasajeros.add(btnAnterior);
						
						if (a == (Integer) opcion){
							btnSiguiente.setText("Finalizar");						
						} else{
							btnSiguiente.setText("Siguiente");
						}
					}else {
						panelPasajeros.remove(btnAnterior);
					}
					
					panelPasajeros.validate();
					panelPasajeros.repaint();
				
				} catch (NotValidPassengerException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
					
				}finally{
				
					if (txtNombre.getText().length() > 0 && 
						txtApellido.getText().length() > 0 && 
						txtDni.getText().length() > 0 && 
						txtAsiento.getText().length() > 0 && 
						txtPrecio.getText().length() > 0){

						reserva.agregarPasajero(pasajero);

						pasajero.getAsientoPasajero().setContentAreaFilled(true);
						pasajero.getAsientoPasajero().setBackground(Color.WHITE);
						pasajero.getAsientoPasajero().setEnabled(false);
						
						botonesSeleccionados.add(pasajero.getAsientoPasajero());
						
//						for (BotonPasajero botonSelec : botonesSeleccionados){
//							
//							getContentPane().validate();
//							getContentPane().repaint();
//						}
						
						if (a > (Integer)opcion){

							//Generar PDF
							
							//....
							
							for (int i = 0; i < reserva.getListPasajeros().size(); i++){
								JOptionPane.showMessageDialog(null, reserva.getListPasajeros().get(i));
							}
							
							dispose();
						}
						
						txtNombre.setText("");
						txtApellido.setText("");
						txtDni.setText("");
						txtAsiento.setText("");
//						b = null;
						txtPrecio.setText("");		
						
						pasajero = new Pasajero();
					}
				}
			}
		});
		btnSiguiente.setBounds(234, 283, 116, 29);
		
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
				
					txtNombre.setText(reserva.getListPasajeros().get(a-1).getNombre());
					txtApellido.setText(reserva.getListPasajeros().get(a-1).getApellido());
					txtDni.setText(reserva.getListPasajeros().get(a-1).getDni().toString());
					
					botonesSeleccionados.remove(a-1);

					botonAnterior.setBackground(new Color(0,128,0));
					botonAnterior.setEnabled(true);
//					txtAsiento.setText(reserva.getListPasajeros().get(a-1).getAsientoPasajero().getAsiento());
//					txtPrecio.setText(reserva.getListPasajeros().get(a-1).getAsientoPasajero().getPrecio().toString());

					txtAsiento.setText(botonAnterior.getAsiento());
					txtPrecio.setText(botonAnterior.getPrecio().toString());
					
					reserva.eliminarPasajero(a-1);
					
					estadoAnterior = true;
					
					panelPasajeros.remove(panelDatosPasajeros);
					panelPasajeros.remove(btnAnterior);
					panelPasajeros.remove(btnSiguiente);
					
					panelDatosPasajeros.setBorder(new TitledBorder(null, "Pasajero " + a +"/" + opcion, TitledBorder.LEADING, TitledBorder.TOP, null, null));
					
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
		btnAnterior.setBounds(20, 283, 116, 29);
		
		cmbCantPasajeros = new JComboBox();
		cmbCantPasajeros.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				reserva = null;
				
				for (int i = 0; i < botonesSeleccionados.size(); i++) {
					botonesSeleccionados.remove(i);
				}
				
				for (BotonPasajero boton : botones){
					boton.setContentAreaFilled(false);
					boton.setEnabled(true);
				}
			}
		});
		cmbCantPasajeros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (cmbCantPasajeros.getSelectedIndex() > 0){
					
					reserva = new ReservaPasajero();
					
					a = 1;
					opcion = cmbCantPasajeros.getSelectedItem();
					
					panelDatosPasajeros.setBorder(new TitledBorder(null, "Pasajero " + a +"/" + opcion, TitledBorder.LEADING, TitledBorder.TOP, null, null));
					
					getContentPane().remove(lblSeleccioneCantPasajeros);
					getContentPane().add(panelAsientos);
					panelPasajeros.add(panelDatosPasajeros);
					panelPasajeros.add(btnSiguiente);
					
					if (a == 1){
						if (a == (Integer) opcion){
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
				
				}else{
					
					getContentPane().remove(panelAsientos);
					getContentPane().add(lblSeleccioneCantPasajeros);
		
					panelPasajeros.remove(panelDatosPasajeros);

					panelPasajeros.remove(btnSiguiente);
					panelPasajeros.remove(btnAnterior);
					
					reserva = null;
					
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
			}
		});
		cmbCantPasajeros.setBounds(205, 52, 68, 22);
		panelPasajeros.add(cmbCantPasajeros);
		
		JLabel lblinformacinSobrePasajeros = new JLabel("<html><center>Informaci\u00F3n sobre pasajeros: </center></html>");
		lblinformacinSobrePasajeros.setHorizontalAlignment(SwingConstants.CENTER);
		lblinformacinSobrePasajeros.setForeground(Color.DARK_GRAY);
		lblinformacinSobrePasajeros.setFont(new Font("Dialog", Font.BOLD, 16));
		lblinformacinSobrePasajeros.setBounds(0, 0, 374, 50);
		panelPasajeros.add(lblinformacinSobrePasajeros);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 25, 116, 20);
		panelDatosPasajeros.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(20, 55, 116, 20);
		panelDatosPasajeros.add(lblApellido);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(20, 85, 116, 20);
		panelDatosPasajeros.add(lblDni);
		
		JLabel lblAsiento = new JLabel("Asiento: ");
		lblAsiento.setBounds(20, 115, 116, 20);
		panelDatosPasajeros.add(lblAsiento);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(20, 145, 116, 20);
		panelDatosPasajeros.add(lblPrecio);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(99, 25, 176, 20);
		txtNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			
				if (txtNombre.getText().trim().length() > 0){
					pasajero.setNombre(txtNombre.getText());
				}else{
					pasajero.setNombre("");
				}
				
			}
		});
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
					
				if (txtNombre.getText().trim().length() > 0){
					pasajero.setNombre(txtNombre.getText());
				}else{
					pasajero.setNombre("");
				}
				
			}
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_SPACE) && (c != KeyEvent.VK_BACK_SPACE)){
					e.consume();
				}
			}
		});
		panelDatosPasajeros.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(99, 55, 176, 20);
		txtApellido.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if (txtApellido.getText().trim().length() > 0){
					pasajero.setApellido(txtApellido.getText());
				}else{
					pasajero.setApellido("");
				}
			}
		});
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				if (txtApellido.getText().trim().length() > 0){
					pasajero.setApellido(txtApellido.getText());
				}else{
					pasajero.setApellido("");
				}
				
			}
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_SPACE) && (c != KeyEvent.VK_BACK_SPACE)){
					e.consume();
				}
			}
		});
		panelDatosPasajeros.add(txtApellido);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(99, 85, 176, 20);
		txtDni.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
					
				if (txtDni.getText().trim().length() > 0){
					pasajero.setDni(Integer.parseInt(txtDni.getText()));
				}else{
					pasajero.setDni(-1);
				}
				
			}
		});
		txtDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				if (txtDni.getText().trim().length() > 0){
					pasajero.setDni(Integer.parseInt(txtDni.getText()));
				}else{
					pasajero.setDni(-1);
				}
			
			}
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if ((c < '0' || c > '9') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_SPACE) && (c != KeyEvent.VK_BACK_SPACE)){
					e.consume();
				}
			}
		});
		panelDatosPasajeros.add(txtDni);
		
		txtAsiento = new JTextField();
		txtAsiento.setEnabled(false);
		txtAsiento.setColumns(10);
		txtAsiento.setBounds(99, 115, 176, 20);
		panelDatosPasajeros.add(txtAsiento);
		
		txtPrecio = new JTextField();
		txtPrecio.setEnabled(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(99, 145, 176, 20);
		panelDatosPasajeros.add(txtPrecio);
		
	}
	
	public JLabel getLblNumeroDeViaje() {
		return lblNumeroDeViaje;
	}

	public void setLblNumeroDeViaje(JLabel lblNumeroDeViaje) {
		this.lblNumeroDeViaje = lblNumeroDeViaje;
	}

	public JLabel getLblOrigen() {
		return lblOrigen;
	}

	public void setLblOrigen(JLabel lblOrigen) {
		this.lblOrigen = lblOrigen;
	}

	public JLabel getLblDestino() {
		return lblDestino;
	}

	public void setLblDestino(JLabel lblDestino) {
		this.lblDestino = lblDestino;
	}

	public JLabel getLblSalida() {
		return lblSalida;
	}

	public void setLblSalida(JLabel lblSalida) {
		this.lblSalida = lblSalida;
	}

	public JLabel getLblLlegada() {
		return lblLlegada;
	}

	public void setLblLlegada(JLabel lblLlegada) {
		this.lblLlegada = lblLlegada;
	}
	
	public JLabel getLblAsientosDisp() {
		return lblAsientosDisp;
	}

	public void setLblAsientosDisp(JLabel lblAsientosDisp) {
		this.lblAsientosDisp = lblAsientosDisp;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getComboBox() {
		return cmbCantPasajeros;
	}

	@SuppressWarnings("rawtypes")
	public void setComboBox(JComboBox comboBox) {
		this.cmbCantPasajeros = comboBox;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		b = (BotonPasajero) e.getSource();
		
		if (cmbCantPasajeros.getSelectedIndex() > 0){
		
			if (botonesSeleccionados.size() > 0){
				
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
							}
						}
						
						for (BotonPasajero botones : botonesSeleccionados){
							botones.setContentAreaFilled(true);
							botones.setBackground(Color.WHITE);
							botones.setEnabled(false);
						}
						
						if (b.getEstadoAsiento().equals("SELECCIONADO")){
							txtAsiento.setText(b.getAsiento());
							txtPrecio.setText(b.getPrecio().toString());
						}else{
							txtAsiento.setText("");
							txtPrecio.setText("");
						}
					}
					
//					getContentPane().validate();
//					getContentPane().repaint();
				}
				
				
			}else{
				
				for (BotonPasajero boton : botones){
					if (boton.getName() != b.getName()){
						boton.setContentAreaFilled(false);
					}
					
//					if (boton.getEstadoAsiento() == "SELECCIONADO" && estadoAnterior){ 
//						
//						pasajero.setNombre(txtNombre.getText());
//						pasajero.setApellido(txtApellido.getText());
//						pasajero.setDni(Integer.parseInt(txtDni.getText()));
//						pasajero.setAsientoPasajero(boton);
//						pasajero.getAsientoPasajero().setAsiento(boton.getAsiento());
//						pasajero.getAsientoPasajero().setPrecio(boton.getPrecio());
//					
//					}
				}
				
				if (b.getEstadoAsiento().equals("SELECCIONADO")){
					txtAsiento.setText(b.getAsiento());
					txtPrecio.setText(b.getPrecio().toString());
				}else{
					txtAsiento.setText("");
					txtPrecio.setText("");
				}
			}


				
		}
		
	}

//	private void focalizarCampo(){
//		
//		JOptionPane.showMessageDialog(null, "Hola");
//		if (txtNombre.getText().equals("")){
//			txtNombre.requestFocus();
//		}
//		
//		if (txtApellido.getText().equals("")){
//			txtApellido.requestFocus();
//		}
//		
//		if (txtDni.getText().length() == 1){
//			txtDni.requestFocus();
//		}
//	}
}