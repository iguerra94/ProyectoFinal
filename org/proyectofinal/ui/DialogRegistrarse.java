package org.proyectofinal.ui;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.proyectofinal.bo.impl.PersonaBoImpl;
import org.proyectofinal.bo.impl.UsuarioBoImpl;
import org.proyectofinal.bo.interfaces.PersonaBo;
import org.proyectofinal.bo.interfaces.UsuarioBo;
import org.proyectofinal.dao.ex.PersonNotValidException;
import org.proyectofinal.dao.ex.UserNotValidException;
import org.proyectofinal.dao.impl.PersonaDaoImpl;
import org.proyectofinal.dao.impl.UsuarioDaoImpl;
import org.proyectofinal.dao.interfaces.PersonaDao;
import org.proyectofinal.dao.interfaces.UsuarioDao;
import org.proyectofinal.model.impl.PersonaImpl;
import org.proyectofinal.model.impl.UsuarioImpl;
import org.proyectofinal.model.interfaces.Persona;
import org.proyectofinal.model.interfaces.Usuario;

import com.toedter.calendar.JDateChooser;

public class DialogRegistrarse extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8710372283429686677L;
	
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private JTextField txtPais;
	private JTextField txtCiudad;
	private JTextField txtNombreUsuario;
	private JPasswordField txtContrasea;
	private JDateChooser birthDateChooser;
	private Usuario u;
	private Persona p;
	private UsuarioBo uBo;
	private PersonaBo pBo;
	private UsuarioDao uDao;
	private PersonaDao pDao;
	private JPanel panelDatosPersonales;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogRegistrarse dialog = new DialogRegistrarse();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error de DialogRegistrarse");
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogRegistrarse() {
		
		getContentPane().setBackground(SystemColor.window);
		setBackground(SystemColor.window);
		
		u = new UsuarioImpl();
		p = new PersonaImpl();
		
		uBo = new UsuarioBoImpl();
		pBo = new PersonaBoImpl();
		
		uDao = new UsuarioDaoImpl();
		pDao = new PersonaDaoImpl();
		
		setResizable(false);
		setTitle("Registrarse");
		setModal(true);
		setBounds(100, 100, 400, 445);
		getContentPane().setLayout(null);
		
		birthDateChooser = new JDateChooser();
		birthDateChooser.setBounds(187, 150, 177, 20);
		
		panelDatosPersonales = new JPanel();
		panelDatosPersonales.setBackground(SystemColor.window);
		panelDatosPersonales.setBorder(new TitledBorder(null, "Datos personales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panelDatosPersonales.setBounds(12, 12, 376, 280);
		panelDatosPersonales.add(birthDateChooser);
		getContentPane().add(panelDatosPersonales);
		panelDatosPersonales.setLayout(null);
		
		JLabel lblDni = new JLabel("* DNI: ");
		lblDni.setBounds(20, 90, 170, 15);
		panelDatosPersonales.add(lblDni);
		
		JLabel lblNombre = new JLabel("* Nombre: ");
		lblNombre.setBounds(20, 30, 170, 15);
		panelDatosPersonales.add(lblNombre);
			
		JLabel lblApellido = new JLabel("* Apellido: ");
		lblApellido.setBounds(20, 60, 170, 15);
		panelDatosPersonales.add(lblApellido);
	
		JLabel lblEmail = new JLabel("* Email: ");
		lblEmail.setBounds(20, 120, 170, 15);
		panelDatosPersonales.add(lblEmail);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento: ");
		lblFechaDeNacimiento.setBounds(20, 150, 170, 15);
		panelDatosPersonales.add(lblFechaDeNacimiento);
	
		JLabel lblPais = new JLabel("Pais: ");
		lblPais.setBounds(20, 210, 170, 15);
		panelDatosPersonales.add(lblPais);
	
		JLabel lblTelefono = new JLabel("Telefono: ");
		lblTelefono.setBounds(20, 180, 170, 15);
		panelDatosPersonales.add(lblTelefono);
	
		JLabel lblCiudad = new JLabel("Ciudad: ");
		lblCiudad.setBounds(20, 240, 170, 15);
		panelDatosPersonales.add(lblCiudad);
	
		txtDni = new JTextField();
		txtDni.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if (txtDni.getText().trim().length() > 0){
					p.setDni(txtDni.getText());
				}
			}
		});
		txtDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
		
				char c = e.getKeyChar();
				
				if ((c < '0' || c > '9') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_SPACE) && (c != KeyEvent.VK_BACK_SPACE)){
					e.consume();
				}
			}
		});
		txtDni.setBounds(187, 87, 177, 20);
		panelDatosPersonales.add(txtDni);
		txtDni.setColumns(10);
	
		txtNombre = new JTextField();
		txtNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			
				if (txtNombre.getText().trim().length() > 0){
					p.setNombre(txtNombre.getText());
				}
			}
		});
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_SPACE) && (c != KeyEvent.VK_BACK_SPACE)){
					e.consume();
				}
			}
		});
		txtNombre.setColumns(10);
		txtNombre.setBounds(187, 27, 177, 20);
		panelDatosPersonales.add(txtNombre);
	
		txtApellido = new JTextField();
		txtApellido.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if (txtApellido.getText().trim().length() > 0){
					p.setApellido(txtApellido.getText());
				}
			}
		});
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_SPACE) && (c != KeyEvent.VK_BACK_SPACE)){
					e.consume();
				}
			}
		});
		txtApellido.setColumns(10);
		txtApellido.setBounds(187, 56, 177, 20);
		panelDatosPersonales.add(txtApellido);		
		
		txtEmail = new JTextField();
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if (txtEmail.getText().trim().length() > 0){
					p.setEmail(txtEmail.getText());
				}
			}
		});
		txtEmail.setColumns(10);
		txtEmail.setBounds(187, 120, 177, 20);
		panelDatosPersonales.add(txtEmail);

		txtTelefono = new JTextField();
		txtTelefono.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				p.setTelefono(txtTelefono.getText());				
			}
		});
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if ((c < '0' || c > '9') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_SPACE) && (c != KeyEvent.VK_BACK_SPACE)){
					e.consume();
				}
			}
		});
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(187, 180, 177, 20);
		panelDatosPersonales.add(txtTelefono);

		txtPais = new JTextField();
		txtPais.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				p.setPais(txtPais.getText());
			}
		});
		txtPais.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_SPACE) && (c != KeyEvent.VK_BACK_SPACE)){
					e.consume();
				}
			}
		});
		txtPais.setColumns(10);
		txtPais.setBounds(187, 210, 177, 20);
		panelDatosPersonales.add(txtPais);
			
		txtCiudad = new JTextField();
		txtCiudad.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				p.setCiudad(txtCiudad.getText());
			}
		});
		txtCiudad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_SPACE) && (c != KeyEvent.VK_BACK_SPACE)){
					e.consume();
				}
			}
		});
		txtCiudad.setColumns(10);
		txtCiudad.setBounds(187, 240, 177, 20);
		panelDatosPersonales.add(txtCiudad);
		
		JPanel panelDatosUsuario = new JPanel();
		panelDatosUsuario.setBackground(SystemColor.window);
		panelDatosUsuario.setBorder(new TitledBorder(null, "Datos del usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDatosUsuario.setBounds(12, 304, 376, 95);
		getContentPane().add(panelDatosUsuario);
		panelDatosUsuario.setLayout(null);
			
		JLabel lblNombreUsuario = new JLabel("* Nombre de usuario: ");
		lblNombreUsuario.setBounds(20, 30, 170, 20);
		panelDatosUsuario.add(lblNombreUsuario);
	
		txtNombreUsuario = new JTextField();
		txtNombreUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if (txtNombreUsuario.getText().trim().length() > 0){
					u.setNombreUsuario(txtNombreUsuario.getText());
				}
			}
		});
		txtNombreUsuario.setColumns(10);
		txtNombreUsuario.setBounds(187, 30, 177, 20);
		panelDatosUsuario.add(txtNombreUsuario);
	
		JLabel lblContrasea = new JLabel("* Contraseña: ");
		lblContrasea.setBounds(20, 60, 170, 20);
		panelDatosUsuario.add(lblContrasea);
	
		txtContrasea = new JPasswordField();
		txtContrasea.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				String pass = new String(txtContrasea.getPassword());
				
				if (pass.trim().length() > 0){
					u.setPassword(pass);					
				}
				
			}
		});
		txtContrasea.setBounds(187, 60, 177, 20);
		panelDatosUsuario.add(txtContrasea);
	
		final JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {			
			
			public void actionPerformed(ActionEvent e) {	
				
				if (e.getSource() == btnRegistrarse){
					
					java.util.Date now = new java.util.Date();
					Timestamp fechaActual = new Timestamp(now.getTime());
					
					if (birthDateChooser.getDate() != null){
						Date date = new Date(birthDateChooser.getDate().getTime());
						p.setFechaNacimiento(date);
					}
					
					u.setFechaInicio(fechaActual);
					
					p.setUsuario(u);	
					
					try {
													
						uBo.verificar(u);
						pBo.verificarImportantes(p);
						
						uDao.alta(u);
						pDao.alta(p);
						
						JOptionPane.showMessageDialog(null, "Se ha registrado el usuario con exito!"); 
						setVisible(false);

					} catch (ClassNotFoundException e1) {
						JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos.");
						limpiar();
					} catch (SQLException e1) {
						e1.printStackTrace();
						limpiar();
					} catch (UserNotValidException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
						limpiarUsuario();
					} catch (PersonNotValidException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
						limpiarPersona();
					}

				}
			
			}

			
		});
		btnRegistrarse.setBounds(12, 405, 174, 25);
		getContentPane().add(btnRegistrarse);
		
		getRootPane().setDefaultButton(btnRegistrarse);

		final JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				if (e.getSource() == btnCancelar){
					dispose();
				}
			}
		});
		btnCancelar.setBounds(271, 405, 117, 25);
		getContentPane().add(btnCancelar);
	
	}
	
	private void limpiarPersona() {
	
		txtDni.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtEmail.setText("");
		txtTelefono.setText("");
		birthDateChooser.setDate(null);
		txtPais.setText("");
		txtCiudad.setText("");
		
		txtDni.requestFocus();
	}
	
	private void limpiarUsuario() {

		txtNombreUsuario.setText("");
		txtContrasea.setText("");
		
		txtNombreUsuario.requestFocus();
	}
	
	private void limpiar() {

		txtDni.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtEmail.setText("");
		txtTelefono.setText("");
		birthDateChooser.setDate(null);
		txtPais.setText("");
		txtCiudad.setText("");
		txtNombreUsuario.setText("");
		txtContrasea.setText("");
		
		txtDni.requestFocus();	
	}
}