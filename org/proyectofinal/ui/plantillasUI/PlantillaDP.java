package org.proyectofinal.ui.plantillasUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import org.proyectofinal.bo.interfaces.PersonaRegistradaBo;
import org.proyectofinal.bo.interfaces.UsuarioBo;
import org.proyectofinal.model.interfaces.PersonaRegistrada;

public class PlantillaDP extends JDialog {
	
	private JPanel panelPersona;
	private JLabel labelAvatar;
	private JPanel panelMostrarInfo;
	private JPasswordField txtContraseniaActual;
	private JPasswordField txtNuevaContrasenia;
	private JPasswordField txtConfirmarContrasenia;
	private JButton btnGuardarCambiosClave;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private JButton btnGuardarCambiosDatosPersona;
	private PersonaRegistradaBo pRBo;
	private UsuarioBo uBo;
	
//	private String dni;
//	private Usuario u;
//	private PersonaRegistrada p;
//	private PersonaRegistradaBo pBo;
//	private UsuarioBo uBo;
	
	public PlantillaDP(){
//		inicializarAtributos();
//		inicializarComponentes();
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

		agregarBotones();
		agregarPanelMostrarInfo();
	}

	public void agregarPanelPersona(PersonaRegistrada pR) {
		
		panelPersona = new JPanel();
		panelPersona.setBorder(new MatteBorder(0, 4, 4, 0, (Color) new Color(0, 0, 0)));
		panelPersona.setBounds(20, 20, 200, 200);
		panelPersona.setBackground(new Color(48, 63, 159));
		getContentPane().add(panelPersona);
		panelPersona.setLayout(null);
		
		agregarLabelAvatar();
		agregarLabelsInfo(pR);
	}
	
	private void agregarLabelAvatar() {
		labelAvatar = new JLabel("");
		labelAvatar.setBounds(40, 15, 120, 120);
		
		ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/avatar.png"));		
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(labelAvatar.getWidth(), labelAvatar.getHeight(), Image.SCALE_DEFAULT));
	
		labelAvatar.setIcon(icono);
		panelPersona.add(labelAvatar);
	}
	
	private void agregarLabelsInfo(PersonaRegistrada pR) {
		JLabel lblNomPersona = new JLabel(pR.getNombre() + " " + pR.getApellido());
		lblNomPersona.setBounds(0, 145, 200, 20);
		lblNomPersona.setForeground(Color.WHITE);
		lblNomPersona.setFont(new Font("Arial", Font.BOLD, 16));
		lblNomPersona.setHorizontalAlignment(SwingConstants.CENTER);
		panelPersona.add(lblNomPersona);
				
		JLabel lblSaldo = new JLabel("Saldo: " + pR.getSaldo() + " KMS");
		lblSaldo.setBounds(0,170,200,20);
		lblSaldo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaldo.setForeground(new Color(255, 193, 7));
		lblSaldo.setFont(new Font("Arial", Font.BOLD, 14));
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
		btnEstadoDeCuenta.setBounds(45, 240, 150, 40);
		getContentPane().add(btnEstadoDeCuenta);
	}
	
	private void agregarBotonReservas() {
		JButton btnMisReservas = new JButton("Mis Reservas");
		btnMisReservas.setBounds(45, 290, 150, 40);
		getContentPane().add(btnMisReservas);
	}

	private void agregarBotonDatos() {
		JButton btnMisDatos = new JButton("Mis Datos");
		btnMisDatos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				panelMostrarInfo.removeAll();
				
				agregarPanelDatos();
				
				panelMostrarInfo.validate();
				panelMostrarInfo.repaint();
			}
		});
		btnMisDatos.setBounds(45, 340, 150, 40);
		getContentPane().add(btnMisDatos);
	}

	private void agregarBotonCambiarClave() {
		JButton btnCambiarClave = new JButton("Cambiar clave");
		btnCambiarClave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				panelMostrarInfo.removeAll();
				
				agregarPanelCambiarClave();
				
				panelMostrarInfo.validate();
				panelMostrarInfo.repaint();
			}
		});
		btnCambiarClave.setBounds(45, 390, 150, 40);
		getContentPane().add(btnCambiarClave);	
	}

	private void agregarPanelMostrarInfo() {
		panelMostrarInfo = new JPanel();
		panelMostrarInfo.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelMostrarInfo.setBackground(Color.WHITE);
		panelMostrarInfo.setBounds(240, 20, 440, 460);
		getContentPane().add(panelMostrarInfo);
		panelMostrarInfo.setLayout(null);
	}

	private void agregarPanelEstadoCuenta() {
		
	}
	
	private void agregarPanelReservas() {
		
	}
	
	private void agregarPanelDatos() {
		agregarLabelsPanelDatos();
		agregarCamposPanelDatos();
		agregarBotonPanelDatos();
	}

	private void agregarLabelsPanelDatos() {
		JLabel lblDni = new JLabel("Dni: ");
		lblDni.setBounds(25, 20, 75, 30);
		panelMostrarInfo.add(lblDni);
	
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(25, 60, 75, 30);
		panelMostrarInfo.add(lblNombre);
	
		JLabel lblApellido = new JLabel("Apellido: ");
		lblApellido.setBounds(25, 100, 75, 30);
		panelMostrarInfo.add(lblApellido);
	
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(25, 140, 75, 30);
		panelMostrarInfo.add(lblEmail);
	
		JLabel lblTelefono = new JLabel("Telefono: ");
		lblTelefono.setBounds(25, 180, 75, 30);
		panelMostrarInfo.add(lblTelefono);
	}

	private void agregarCamposPanelDatos() {
		txtDni = new JTextField();
		txtDni.setBounds(105, 20, 200, 30);
		panelMostrarInfo.add(txtDni);
	
		txtNombre = new JTextField();
		txtNombre.setBounds(105, 60, 200, 30);
		panelMostrarInfo.add(txtNombre);
	
		txtApellido = new JTextField();
		txtApellido.setBounds(105, 100, 200, 30);
		panelMostrarInfo.add(txtApellido);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(105, 140, 200, 30);
		panelMostrarInfo.add(txtEmail);
	
		txtTelefono = new JTextField();
		txtTelefono.setBounds(105, 180, 200, 30);
		panelMostrarInfo.add(txtTelefono);
	}

	private void agregarBotonPanelDatos() {
		btnGuardarCambiosDatosPersona = new JButton("Guardar cambios");
		btnGuardarCambiosDatosPersona.setBounds(25, 230, 155, 40);
		panelMostrarInfo.add(btnGuardarCambiosDatosPersona);
	}

	private void agregarPanelCambiarClave() {
		agregarLabelsPanelCambiarClave();
		agregarCamposPanelCambiarClave();
		agregarBotonPanelCambiarClave();
	}

	private void agregarLabelsPanelCambiarClave() {
		
		JLabel lblContraseaActual = new JLabel("Contraseña actual: ");
		lblContraseaActual.setBounds(25, 20, 140, 30);
		panelMostrarInfo.add(lblContraseaActual);
		
		JLabel lblNuevaContrasea = new JLabel("Nueva Contraseña:");
		lblNuevaContrasea.setBounds(25, 60, 140, 30);
		panelMostrarInfo.add(lblNuevaContrasea);
		
		JLabel lblConfirmarNuevaContrasea = new JLabel("Confirmar nueva Contraseña:");
		lblConfirmarNuevaContrasea.setBounds(25, 100, 200, 30);
		panelMostrarInfo.add(lblConfirmarNuevaContrasea);
	}

	private void agregarCamposPanelCambiarClave() {
		txtContraseniaActual = new JPasswordField();
		txtContraseniaActual.setBounds(220, 20, 200, 30);
		panelMostrarInfo.add(txtContraseniaActual);
		
		txtNuevaContrasenia = new JPasswordField();
		txtNuevaContrasenia.setBounds(220, 60, 200, 30);
		panelMostrarInfo.add(txtNuevaContrasenia);
		
		txtConfirmarContrasenia = new JPasswordField();
		txtConfirmarContrasenia.setBounds(220, 100, 200, 30);
		panelMostrarInfo.add(txtConfirmarContrasenia);
	}

	private void agregarBotonPanelCambiarClave() {
		btnGuardarCambiosClave = new JButton("Guardar cambios");
		btnGuardarCambiosClave.setBounds(25, 150, 155, 40);
		panelMostrarInfo.add(btnGuardarCambiosClave);
	}

	public JLabel getLabelAvatar() {
		return labelAvatar;
	}

	public void setLabelAvatar(JLabel labelAvatar) {
		this.labelAvatar = labelAvatar;
	}

}