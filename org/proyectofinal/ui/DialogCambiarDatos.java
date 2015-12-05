package org.proyectofinal.ui;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import org.proyectofinal.model.impl.BotonEditar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogCambiarDatos extends JDialog {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7726925233817947202L;
	
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private JDateChooser dateChooserNacimiento;
	private JTextField txtPais;
	private JTextField txtCiudad;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	private BotonEditar btnEditarDni;
	private BotonEditar btnEditarNombre;
	private BotonEditar btnEditarApellido;
	private BotonEditar btnEditarEmail;
	private BotonEditar btnEditarTelefono;
	private BotonEditar btnEditarNacimiento;
	private BotonEditar btnEditarPais;
	private BotonEditar btnEditarCiudad;
	private BotonEditar btnEditarUsuario;
	private BotonEditar btnEditarContrasenia;
	private JButton btnGuardarCambios;

	/**
	 * Create the Dialog.
	 */
	public DialogCambiarDatos() {

		setResizable(false);
		setSize(510,540);
		setLocationRelativeTo(null);
		setModal(true);
		setTitle("Cambiar Datos Personales");
		
		getContentPane().setLayout(null);
		
		JPanel panelDatosPersona = new JPanel();
		panelDatosPersona.setBorder(new TitledBorder(null, "Datos de la persona", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDatosPersona.setBounds(22, 57, 460, 280);
		getContentPane().add(panelDatosPersona);
		panelDatosPersona.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 60, 165, 15);
		panelDatosPersona.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido: ");
		lblApellido.setBounds(20, 90, 165, 15);
		panelDatosPersona.add(lblApellido);
		
		JLabel lblDni = new JLabel("Dni:");
		lblDni.setBounds(20, 30, 165, 15);
		panelDatosPersona.add(lblDni);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setBounds(20, 120, 165, 15);
		panelDatosPersona.add(lblEmail);
		
		JLabel lblTelefono = new JLabel("Telefono: ");
		lblTelefono.setBounds(20, 150, 165, 15);
		panelDatosPersona.add(lblTelefono);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento: ");
		lblFechaDeNacimiento.setBounds(20, 180, 165, 15);
		panelDatosPersona.add(lblFechaDeNacimiento);
		
		JLabel lblPais = new JLabel("Pais: ");
		lblPais.setBounds(20, 210, 165, 15);
		panelDatosPersona.add(lblPais);
		
		JLabel lblCiudad = new JLabel("Ciudad: ");
		lblCiudad.setBounds(20, 240, 165, 15);
		panelDatosPersona.add(lblCiudad);
		
		txtDni = new JTextField();
		txtDni.setEnabled(false);
		txtDni.setBounds(185, 30, 187, 19);
		panelDatosPersona.add(txtDni);
		txtDni.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(185, 60, 187, 19);
		panelDatosPersona.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setEnabled(false);
		txtApellido.setColumns(10);
		txtApellido.setBounds(185, 90, 187, 19);
		panelDatosPersona.add(txtApellido);
		
		txtEmail = new JTextField();
		txtEmail.setEnabled(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(185, 120, 187, 19);
		panelDatosPersona.add(txtEmail);
		
		txtTelefono = new JTextField();
		txtTelefono.setEnabled(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(185, 150, 187, 19);
		panelDatosPersona.add(txtTelefono);
		
		txtPais = new JTextField();
		txtPais.setEnabled(false);
		txtPais.setColumns(10);
		txtPais.setBounds(185, 210, 187, 19);
		panelDatosPersona.add(txtPais);
		
		txtCiudad = new JTextField();
		txtCiudad.setEnabled(false);
		txtCiudad.setColumns(10);
		txtCiudad.setBounds(185, 240, 187, 19);
		panelDatosPersona.add(txtCiudad);
		
		dateChooserNacimiento = new JDateChooser();
		dateChooserNacimiento.setEnabled(false);
		dateChooserNacimiento.setBounds(185, 180, 187, 19);
		panelDatosPersona.add(dateChooserNacimiento);
		
		btnEditarDni = new BotonEditar("<html><u>Editar</u></html>");
		btnEditarDni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == btnEditarDni){
				
					if (!btnEditarDni.getEstado()){
						txtDni.setEnabled(true);
						btnEditarDni.setEstado(true);
					} else if (btnEditarDni.getEstado()){
						txtDni.setEnabled(false);
						btnEditarDni.setEstado(false);
					}
				}
			
			}
		});
		btnEditarDni.setForeground(Color.BLUE);
		btnEditarDni.setContentAreaFilled(false);
		btnEditarDni.setBorderPainted(false);
		btnEditarDni.setBounds(375, 30, 83, 19);
		panelDatosPersona.add(btnEditarDni);
		
		btnEditarNombre = new BotonEditar("<html><u>Editar</u></html>");
		btnEditarNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == btnEditarNombre){
					
					if (!btnEditarNombre.getEstado()){
						txtNombre.setEnabled(true);
						btnEditarNombre.setEstado(true);
					} else if (btnEditarNombre.getEstado()){
						txtNombre.setEnabled(false);
						btnEditarNombre.setEstado(false);
					}
				}
				
			}
		});
		btnEditarNombre.setForeground(Color.BLUE);
		btnEditarNombre.setContentAreaFilled(false);
		btnEditarNombre.setBorderPainted(false);
		btnEditarNombre.setBounds(375, 60, 83, 19);
		panelDatosPersona.add(btnEditarNombre);
		
		btnEditarApellido = new BotonEditar("<html><u>Editar</u></html>");
		btnEditarApellido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == btnEditarApellido){
					
					if (!btnEditarApellido.getEstado()){
						txtApellido.setEnabled(true);
						btnEditarApellido.setEstado(true);
					} else if (btnEditarApellido.getEstado()){
						txtApellido.setEnabled(false);
						btnEditarApellido.setEstado(false);
					}
				}
				
			}
		});
		btnEditarApellido.setForeground(Color.BLUE);
		btnEditarApellido.setContentAreaFilled(false);
		btnEditarApellido.setBorderPainted(false);
		btnEditarApellido.setBounds(375, 90, 83, 19);
		panelDatosPersona.add(btnEditarApellido);
		
		btnEditarEmail = new BotonEditar("<html><u>Editar</u></html>");
		btnEditarEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == btnEditarEmail){
					
					if (!btnEditarEmail.getEstado()){
						txtEmail.setEnabled(true);
						btnEditarEmail.setEstado(true);
					} else if (btnEditarEmail.getEstado()){
						txtEmail.setEnabled(false);
						btnEditarEmail.setEstado(false);
					}
				}
				
			}
		});
		btnEditarEmail.setForeground(Color.BLUE);
		btnEditarEmail.setContentAreaFilled(false);
		btnEditarEmail.setBorderPainted(false);
		btnEditarEmail.setBounds(375, 120, 83, 19);
		panelDatosPersona.add(btnEditarEmail);
		
		btnEditarTelefono = new BotonEditar("<html><u>Editar</u></html>");
		btnEditarTelefono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == btnEditarTelefono){
					
					if (!btnEditarTelefono.getEstado()){
						txtTelefono.setEnabled(true);
						btnEditarTelefono.setEstado(true);
					} else if (btnEditarTelefono.getEstado()){
						txtTelefono.setEnabled(false);
						btnEditarTelefono.setEstado(false);
					}
				}
				
			}
		});
		btnEditarTelefono.setForeground(Color.BLUE);
		btnEditarTelefono.setContentAreaFilled(false);
		btnEditarTelefono.setBorderPainted(false);
		btnEditarTelefono.setBounds(375, 150, 83, 19);
		panelDatosPersona.add(btnEditarTelefono);
		
		btnEditarNacimiento = new BotonEditar("<html><u>Editar</u></html>");
		btnEditarNacimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == btnEditarNacimiento){
					
					if (!btnEditarNacimiento.getEstado()){
						dateChooserNacimiento.setEnabled(true);
						btnEditarNacimiento.setEstado(true);
					} else if (btnEditarNacimiento.getEstado()){
						dateChooserNacimiento.setEnabled(false);
						btnEditarNacimiento.setEstado(false);
					}
				}
				
			}
		});
		btnEditarNacimiento.setForeground(Color.BLUE);
		btnEditarNacimiento.setContentAreaFilled(false);
		btnEditarNacimiento.setBorderPainted(false);
		btnEditarNacimiento.setBounds(375, 180, 83, 19);
		panelDatosPersona.add(btnEditarNacimiento);
		
		btnEditarPais = new BotonEditar("<html><u>Editar</u></html>");
		btnEditarPais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == btnEditarPais){
					
					if (!btnEditarPais.getEstado()){
						txtPais.setEnabled(true);
						btnEditarPais.setEstado(true);
					} else if (btnEditarPais.getEstado()){
						txtPais.setEnabled(false);
						btnEditarPais.setEstado(false);
					}
				}
				
			}
		});
		btnEditarPais.setForeground(Color.BLUE);
		btnEditarPais.setContentAreaFilled(false);
		btnEditarPais.setBorderPainted(false);
		btnEditarPais.setBounds(375, 210, 83, 19);
		panelDatosPersona.add(btnEditarPais);
		
		btnEditarCiudad = new BotonEditar("<html><u>Editar</u></html>");
		btnEditarCiudad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == btnEditarCiudad){
					
					if (!btnEditarCiudad.getEstado()){
						txtCiudad.setEnabled(true);
						btnEditarCiudad.setEstado(true);
					} else if (btnEditarCiudad.getEstado()){
						txtCiudad.setEnabled(false);
						btnEditarCiudad.setEstado(false);
					}
				}
				
			}
		});
		btnEditarCiudad.setForeground(Color.BLUE);
		btnEditarCiudad.setContentAreaFilled(false);
		btnEditarCiudad.setBorderPainted(false);
		btnEditarCiudad.setBounds(375, 240, 83, 19);
		panelDatosPersona.add(btnEditarCiudad);
		
		JPanel panelDatosUsuario = new JPanel();
		panelDatosUsuario.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Datos del usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panelDatosUsuario.setBounds(22, 361, 460, 100);
		getContentPane().add(panelDatosUsuario);
		panelDatosUsuario.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setBounds(20, 30, 165, 15);
		panelDatosUsuario.add(lblUsuario);
		
		JLabel lblContrasenia = new JLabel("Contraseña: ");
		lblContrasenia.setBounds(20, 60, 165, 15);
		panelDatosUsuario.add(lblContrasenia);
		
		txtUsuario = new JTextField();
		txtUsuario.setEnabled(false);
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(185, 30, 187, 19);
		panelDatosUsuario.add(txtUsuario);
		
		txtPassword = new JPasswordField();		
		txtPassword.setEnabled(false);
		txtPassword.setBounds(185, 60, 187, 19);
		panelDatosUsuario.add(txtPassword);
		
		btnEditarUsuario = new BotonEditar("<html><u>Editar</u></html>");
		btnEditarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == btnEditarUsuario){
					
					if (!btnEditarUsuario.getEstado()){
						txtUsuario.setEnabled(true);
						btnEditarUsuario.setEstado(true);
					} else if (btnEditarUsuario.getEstado()){
						txtUsuario.setEnabled(false);
						btnEditarUsuario.setEstado(false);
					}
				}
				
			}
		});
		btnEditarUsuario.setForeground(Color.BLUE);
		btnEditarUsuario.setContentAreaFilled(false);
		btnEditarUsuario.setBorderPainted(false);
		btnEditarUsuario.setBounds(375, 30, 83, 19);
		panelDatosUsuario.add(btnEditarUsuario);
		
		btnEditarContrasenia = new BotonEditar("<html><u>Editar</u></html>");
		btnEditarContrasenia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == btnEditarContrasenia){
					
					if (!btnEditarContrasenia.getEstado()){
						txtPassword.setEnabled(true);
						btnEditarContrasenia.setEstado(true);
					} else if (btnEditarContrasenia.getEstado()){
						txtPassword.setEnabled(false);
						btnEditarContrasenia.setEstado(false);
					}
				}
				
			}
		});
		btnEditarContrasenia.setForeground(Color.BLUE);
		btnEditarContrasenia.setContentAreaFilled(false);
		btnEditarContrasenia.setBorderPainted(false);
		btnEditarContrasenia.setBounds(375, 60, 83, 19);
		panelDatosUsuario.add(btnEditarContrasenia);
		
		JLabel lblCambiarDatosPersonales = new JLabel("Cambiar Datos Personales");
		lblCambiarDatosPersonales.setHorizontalAlignment(SwingConstants.CENTER);
		lblCambiarDatosPersonales.setFont(new Font("Dialog", Font.BOLD, 17));
		lblCambiarDatosPersonales.setBounds(12, 12, 486, 33);
		getContentPane().add(lblCambiarDatosPersonales);
		
		btnGuardarCambios = new JButton("Guardar Cambios");
		btnGuardarCambios.setEnabled(false);
		btnGuardarCambios.setBounds(22, 470, 156, 25);
		getContentPane().add(btnGuardarCambios);

	}

	public JTextField getTxtDni() {
		return txtDni;
	}

	public void setTxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public JTextField getTxtPais() {
		return txtPais;
	}

	public void setTxtPais(JTextField txtPais) {
		this.txtPais = txtPais;
	}

	public JTextField getTxtCiudad() {
		return txtCiudad;
	}

	public void setTxtCiudad(JTextField txtCiudad) {
		this.txtCiudad = txtCiudad;
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(JPasswordField txtPassword) {
		this.txtPassword = txtPassword;
	}

	public JDateChooser getDateChooserNacimiento() {
		return dateChooserNacimiento;
	}

	public void setDateChooserNacimiento(JDateChooser dateChooserNacimiento) {
		this.dateChooserNacimiento = dateChooserNacimiento;
	}
}