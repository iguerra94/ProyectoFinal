package org.proyectofinal.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

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
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.awt.SystemColor;

public class DialogCambiarDatos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7726925233817947202L;

	private Usuario u;
	private Persona p;
	private ResultSet r;
	private PersonaBo pBo;
	private UsuarioBo uBo;
	private PersonaDao pDao;
	private UsuarioDao uDao;
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
	private JButton btnGuardarCambios;

	/**
	 * Create the Dialog.
	 */
	public DialogCambiarDatos(final Usuario user) {
		
		setBackground(SystemColor.window);
		getContentPane().setBackground(SystemColor.window);

		addWindowFocusListener(new WindowFocusListener() {
			@SuppressWarnings("deprecation")
			public void windowGainedFocus(WindowEvent arg0) {
				
				try {

					r = pDao.consultarPorUsuario(user);
					
					if (r.next()){

						txtDni.setText(r.getString("dni"));
						txtNombre.setText(r.getString("nombre"));
						txtApellido.setText(r.getString("apellido"));
						txtEmail.setText(r.getString("email"));
						txtTelefono.setText(r.getString("telefono"));
						dateChooserNacimiento.setDate(r.getDate("fechaNacimiento"));
						txtPais.setText(r.getString("pais"));
						txtCiudad.setText(r.getString("ciudad"));
						txtUsuario.setText(r.getString("usuario"));
						txtPassword.setText(r.getString("contrasenia"));
					
					}
					
					if (txtDni.getText().length() > 0){
						p.setDni(txtDni.getText());				
					}
					if (txtNombre.getText().length() > 0){			
						p.setNombre(txtNombre.getText());
					}
					if (txtApellido.getText().length() > 0){						
						p.setApellido(txtApellido.getText());
					}
					if (txtEmail.getText().length() > 0){
						p.setEmail(txtEmail.getText());
					}
					if (txtTelefono.getText().length() > 0){
						p.setTelefono(txtTelefono.getText());
					}
					if (dateChooserNacimiento.getDate() != null){
						p.setFechaNacimiento(new Date(dateChooserNacimiento.getDate().getTime()));
					}
					if (txtPais.getText().length() > 0){
						p.setPais(txtPais.getText());
					}
					if (txtCiudad.getText().length() > 0){
						p.setCiudad(txtCiudad.getText());
					}
					if (txtUsuario.getText().length() > 0){						
						u.setNombreUsuario(txtUsuario.getText());
					}
					if (txtPassword.getPassword().toString().length() > 0){
						u.setPassword(txtPassword.getText());
					}
	
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						r.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		
		u = new UsuarioImpl();
		
		p = new PersonaImpl();
		p.setUsuario(u);

		uBo = new UsuarioBoImpl();
		pBo = new PersonaBoImpl();
		
		uDao = new UsuarioDaoImpl();
		pDao = new PersonaDaoImpl();
		
		setResizable(false);
		setSize(440,478);
		setLocationRelativeTo(null);
		setModal(true);
		setTitle("Cambiar Datos Personales");
		
		getContentPane().setLayout(null);
		
		JPanel panelDatosPersona = new JPanel();
		panelDatosPersona.setBackground(SystemColor.window);
		panelDatosPersona.setBorder(new TitledBorder(null, "Datos de la persona", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59,59,59)));
		panelDatosPersona.setBounds(22, 20, 395, 280);
		getContentPane().add(panelDatosPersona);
		panelDatosPersona.setLayout(null);
		
		JLabel lblNombre = new JLabel("* Nombre:");
		lblNombre.setBounds(20, 60, 165, 15);
		panelDatosPersona.add(lblNombre);
		
		JLabel lblApellido = new JLabel("* Apellido: ");
		lblApellido.setBounds(20, 90, 165, 15);
		panelDatosPersona.add(lblApellido);
		
		JLabel lblDni = new JLabel("* Dni:");
		lblDni.setBounds(20, 30, 165, 15);
		panelDatosPersona.add(lblDni);
		
		JLabel lblEmail = new JLabel("* Email: ");
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
		txtDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if ((c >= '0' && c <= '9') || (c == KeyEvent.VK_KP_LEFT) || (c == KeyEvent.VK_KP_RIGHT) || (c == KeyEvent.VK_BACK_SPACE)){
					
					btnGuardarCambios.setEnabled(true);
					
					if (txtDni.getText().length() > 0){
						p.setDni(txtDni.getText());
					}else {
						p.setDni("");
					}
				}
								
			}
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if ((c < '0' || c > '9') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_BACK_SPACE)){
					e.consume();
				}
			}
		});
		txtDni.setBounds(185, 30, 187, 19);
		panelDatosPersona.add(txtDni);
		txtDni.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c == KeyEvent.VK_KP_LEFT) || (c == KeyEvent.VK_KP_RIGHT) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_BACK_SPACE)){
					
					btnGuardarCambios.setEnabled(true);
					
					if (txtNombre.getText().length() > 0){			
						p.setNombre(txtNombre.getText());
					}else {
						p.setNombre("");
					}
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
		txtNombre.setColumns(10);
		txtNombre.setBounds(185, 60, 187, 19);
		panelDatosPersona.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c == KeyEvent.VK_KP_LEFT) || (c == KeyEvent.VK_KP_RIGHT) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_BACK_SPACE)){
					
					btnGuardarCambios.setEnabled(true);
					
					if (txtApellido.getText().length() > 0){						
						p.setApellido(txtApellido.getText());
					}else {
						p.setApellido("");
					}
					
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
		txtApellido.setColumns(10);
		txtApellido.setBounds(185, 90, 187, 19);
		panelDatosPersona.add(txtApellido);
		
		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				char c = e.getKeyChar();
				
				if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || (c == KeyEvent.VK_KP_LEFT) || (c == KeyEvent.VK_KP_RIGHT) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_UNDERSCORE) || (c == '@') || (c == '.')){

					btnGuardarCambios.setEnabled(true);
					
					if (txtEmail.getText().length() > 0){
						p.setEmail(txtEmail.getText());
					}else {
						p.setEmail("");
					}
				}
				
			}
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_BACK_SPACE) && (c != KeyEvent.VK_UNDERSCORE) && (c != '@') && (c != '.')){
					e.consume();
				}
			}
		});
		txtEmail.setColumns(10);
		txtEmail.setBounds(185, 120, 187, 19);
		panelDatosPersona.add(txtEmail);
		
		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			
				char c = e.getKeyChar();
				
				if ((c >= '0' && c <= '9') || (c == KeyEvent.VK_KP_LEFT) || (c == KeyEvent.VK_KP_RIGHT) || (c == KeyEvent.VK_BACK_SPACE)){
					btnGuardarCambios.setEnabled(true);
					p.setTelefono(txtTelefono.getText());
				}

			}
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if ((c < '0' || c > '9') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_BACK_SPACE)){
					e.consume();
				}
			}
		});
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(185, 150, 187, 19);
		panelDatosPersona.add(txtTelefono);
		
		txtPais = new JTextField();
		txtPais.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c == KeyEvent.VK_KP_LEFT) || (c == KeyEvent.VK_KP_RIGHT) || (c == KeyEvent.VK_BACK_SPACE)  || (c == KeyEvent.VK_SPACE)){
					btnGuardarCambios.setEnabled(true);
					p.setPais(txtPais.getText());
				}

			}
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_BACK_SPACE) && (c != KeyEvent.VK_ENTER) && (c != KeyEvent.VK_SPACE)){
					e.consume();
				}
			}
		});
		txtPais.setColumns(10);
		txtPais.setBounds(185, 210, 187, 19);
		panelDatosPersona.add(txtPais);
		
		txtCiudad = new JTextField();
		txtCiudad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c == KeyEvent.VK_KP_LEFT) || (c == KeyEvent.VK_KP_RIGHT) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_SPACE)){
					btnGuardarCambios.setEnabled(true);
					p.setCiudad(txtCiudad.getText());
				}			
				
			}
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_BACK_SPACE) && (c != KeyEvent.VK_SPACE)){
					e.consume();
				}
			}
		});
		txtCiudad.setColumns(10);
		txtCiudad.setBounds(185, 240, 187, 19);
		panelDatosPersona.add(txtCiudad);
		
		dateChooserNacimiento = new JDateChooser();
		dateChooserNacimiento.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				if (dateChooserNacimiento.getDate() != null){
					btnGuardarCambios.setEnabled(true);
					p.setFechaNacimiento(new Date(dateChooserNacimiento.getDate().getTime()));
				}
			}
		});
		dateChooserNacimiento.setEnabled(false);
		dateChooserNacimiento.getCalendarButton().setEnabled(true);
		dateChooserNacimiento.setBounds(185, 180, 187, 19);
		panelDatosPersona.add(dateChooserNacimiento);
		
		JPanel panelDatosUsuario = new JPanel();
		panelDatosUsuario.setBackground(SystemColor.window);
		panelDatosUsuario.setBorder(new TitledBorder(null, "Datos del usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panelDatosUsuario.setBounds(22, 315, 395, 100);
		getContentPane().add(panelDatosUsuario);
		panelDatosUsuario.setLayout(null);
		
		JLabel lblUsuario = new JLabel("* Usuario: ");
		lblUsuario.setBounds(20, 30, 165, 15);
		panelDatosUsuario.add(lblUsuario);
		
		JLabel lblContrasenia = new JLabel("* Contraseña: ");
		lblContrasenia.setBounds(20, 60, 165, 15);
		panelDatosUsuario.add(lblContrasenia);
		
		txtUsuario = new JTextField();
		txtUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			
				char c = e.getKeyChar();
				
				if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || (c == KeyEvent.VK_KP_LEFT) || (c == KeyEvent.VK_KP_RIGHT) || (c == KeyEvent.VK_BACK_SPACE)){
				
					btnGuardarCambios.setEnabled(true);
					
					if (txtUsuario.getText().length() > 0){						
						u.setNombreUsuario(txtUsuario.getText());
					}else {
						u.setNombreUsuario("");
					}
				}
				
			}
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_BACK_SPACE)){
					e.consume();
				}
			}
		});
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(185, 28, 187, 19);
		panelDatosUsuario.add(txtUsuario);
		
		txtPassword = new JPasswordField();		
		txtPassword.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void keyReleased(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || (c == KeyEvent.VK_KP_LEFT) || (c == KeyEvent.VK_KP_RIGHT) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_PERIOD) || (c == KeyEvent.VK_COMMA)){
					
					btnGuardarCambios.setEnabled(true);
					
					if (txtPassword.getText().length() > 0){	
						u.setPassword(txtPassword.getText());					
					}else {
						u.setPassword("");
					}
				}

			}
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_BACK_SPACE) && (c != KeyEvent.VK_PERIOD) && (c != KeyEvent.VK_COMMA)){
					e.consume();
				}
			}
		});
		txtPassword.setBounds(185, 60, 187, 19);
		panelDatosUsuario.add(txtPassword);
		
		btnGuardarCambios = new JButton("Guardar Cambios");
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == btnGuardarCambios){
					
					try {
						
						pBo.verificarImportantes(p);
						uBo.verificar(u);
						
						r = pDao.consultarPorUsuario(user);
					
						if (r.next()) {
						
							u.setTipoUsuario(r.getInt("tipoUsuario"));
							u.setFechaInicio(r.getTimestamp("fechaInicio"));
							
							if (!r.getString("nombre").equals(p.getNombre())){	
								pDao.modificacion("nombre", p.getNombre(), r.getString("dni"));
							}
							if (!r.getString("apellido").equals(p.getApellido())){
								pDao.modificacion("apellido", p.getApellido(), r.getString("dni"));
							}
							if (!r.getString("email").equals(p.getEmail())){	
								pDao.modificacion("email", p.getEmail(), r.getString("dni"));
							}
							if (!r.getString("telefono").equals(p.getTelefono())){	
								pDao.modificacion("telefono", p.getTelefono(), r.getString("dni"));
							}
							if (!r.getDate("fechaNacimiento").equals(p.getFechaNacimiento())){	
								pDao.modificacion("fechaNacimiento", p.getFechaNacimiento().toString(), r.getString("dni"));							
							}
							if (!r.getString("ciudad").equals(p.getCiudad())){							
								pDao.modificacion("ciudad", p.getCiudad(), r.getString("dni"));
							}							
							if (!r.getString("usuario").equals(u.getNombreUsuario())) {	
								pDao.modificacion("usuario", u.getNombreUsuario(), r.getString("usuario"));
								uDao.modificacion("usuario", u.getNombreUsuario(), r.getString("usuario"));						
							}
							if (!r.getString("contrasenia").equals(u.getPassword())) {	
								uDao.modificacion("contrasenia", u.getPassword(), r.getString("usuario"));							
							}
							if (!r.getString("pais").equals(p.getPais())){	
								pDao.modificacion("pais", p.getPais(), r.getString("dni"));							
							}
							if (!r.getString("dni").equals(p.getDni())){
								pDao.modificacion("dni", p.getDni(), r.getString("dni")); 						
							}

						}
	
						JOptionPane.showMessageDialog(null, "Se ha modificado la informacion personal con exito!"); 
						setVisible(false);
					
					} catch (PersonNotValidException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (UserNotValidException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch(ClassNotFoundException e1){
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (SQLException e1){
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					finally {
						try {
							r.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
					}
					
				}
			}
		});
		btnGuardarCambios.setEnabled(false);
		btnGuardarCambios.setBounds(22, 425, 156, 25);
		getContentPane().add(btnGuardarCambios);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(277, 425, 140, 25);
		getContentPane().add(btnCancelar);

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