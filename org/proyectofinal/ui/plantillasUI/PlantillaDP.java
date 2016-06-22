package org.proyectofinal.ui.plantillasUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;

public class PlantillaDP extends JDialog {
	
	private JPanel panelPersona;
//	private String dni;
//	private Usuario u;
//	private PersonaRegistrada p;
//	private PersonaRegistradaBo pBo;
//	private UsuarioBo uBo;
//	private PersonaRegistradaDao pDao;
//	private ReservaViajeDao rVDao;
//	private UsuarioDao uDao;
//	private JPanel panelDatosPersona;
//	private JTextField txtNombre;
//	private JTextField txtApellido;
//	private JTextField txtDni;
//	private JTextField txtEmail;
//	private JTextField txtTelefono;
//	private JDateChooser dateChooserNacimiento;
//	private JTextField txtPais;
//	private JTextField txtCiudad;
//	private JPanel panelDatosUsuario;
//	private JTextField txtUsuario;
//	private JPasswordField txtPassword;
//	private JButton btnGuardarCambios;
	
	public PlantillaDP(){
		
	}

	protected void inicializarAtributos(){
		setTitle("Perfil de usuario");
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setSize(700,500);
		setLocationRelativeTo(null);
		setModal(true);
		
		getContentPane().setLayout(null);
	}
	
	protected void inicializarComponentes(){

		agregarPanelPersona();
		agregarBotones();
		agregarPaneMostrarInfo();
//		agregarPaneDatosPersona();
//		agregarPaneDatosUsuario();
//		agregarBotones();	
	}

	private void agregarPanelPersona() {
		panelPersona = new JPanel();
		panelPersona.setBorder(new MatteBorder(0, 4, 4, 0, (Color) new Color(0, 0, 0)));
		panelPersona.setBounds(20, 20, 200, 200);
		panelPersona.setBackground(new Color(48, 63, 159));
		getContentPane().add(panelPersona);
		panelPersona.setLayout(null);
		
		agregarLabelAvatar();
		agregarLabelsInfo();
	}
	
	private void agregarLabelAvatar() {
		JLabel labelAvatar = new JLabel("");
		labelAvatar.setBounds(40, 15, 120, 120);
		
		ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/avatar.png"));		
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(labelAvatar.getWidth(), labelAvatar.getHeight(), Image.SCALE_DEFAULT));
	
		labelAvatar.setIcon(icono);
		panelPersona.add(labelAvatar);
	}
	
	private void agregarLabelsInfo() {
		JLabel lblNomPersona = new JLabel("Ivan Guerra");
		lblNomPersona.setBounds(0, 145, 200, 20);
		lblNomPersona.setForeground(Color.WHITE);
		lblNomPersona.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNomPersona.setHorizontalAlignment(SwingConstants.CENTER);
		panelPersona.add(lblNomPersona);
				
		JLabel lblSaldo = new JLabel("Saldo: 14000 KMS");
		lblSaldo.setBounds(0,170,200,20);
		lblSaldo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaldo.setForeground(new Color(255, 193, 7));
		lblSaldo.setFont(new Font("Dialog", Font.BOLD, 14));
		panelPersona.add(lblSaldo);
		
	}
	
	private void agregarBotones() {
		agregarBotonEstadoCuenta();
		agregarBotonReservas();
		agregarBotonDatos();
		agregarBotonCambiarClave();
	}
	
	private void agregarBotonEstadoCuenta() {
		JButton btnEstadoDeCuenta = new JButton("Estado de Cuenta");
		btnEstadoDeCuenta.setBounds(45, 390, 150, 40);
		getContentPane().add(btnEstadoDeCuenta);
	}
	
	private void agregarBotonReservas() {
		JButton btnMisReservas = new JButton("Mis Reservas");
		btnMisReservas.setBounds(45, 340, 150, 40);
		getContentPane().add(btnMisReservas);
	}

	private void agregarBotonDatos() {
		JButton btnMisDatos = new JButton("Mis Datos");
		btnMisDatos.setBounds(45, 240, 150, 40);
		getContentPane().add(btnMisDatos);
	}

	private void agregarBotonCambiarClave() {
		JButton btnCambiarClave = new JButton("Cambiar clave");
		btnCambiarClave.setBounds(45, 290, 150, 40);
		getContentPane().add(btnCambiarClave);	
	}

	private void agregarPaneMostrarInfo() {
	
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		tabbedPane.setBackground(Color.BLACK);
		tabbedPane.setBounds(240, 20, 440, 460);
		getContentPane().add(tabbedPane);
	}

	private void agregarPanelEstadoCuenta() {
		
	}
	
	private void agregarPanelReservas() {
		
	}
	
	private void agregarPanelDatos() {
		
	}

	private void agregarPanelCambiarClave() {
		
	}

}