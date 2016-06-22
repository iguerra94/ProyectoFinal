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
		setSize(395,478);
		setLocationRelativeTo(null);
		setModal(true);
		
		getContentPane().setLayout(null);
	}
	
	protected void inicializarComponentes(){

		agregarPanelPersona();
		agregarBotones();
		agregarPanelMostrarInfo();
//			agregarPanelEstadoCuenta();
//			agregarPanelReservas();
//			agregarPanelDatos();
//			agregarPanelCambiarClave();
//		
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

	private void agregarPanelMostrarInfo() {
		
	}

	private void agregarPanelEstadoCuenta() {
		
	}
	
	private void agregarPanelReservas() {
		
	}
	
	private void agregarPanelDatos() {
		
	}

	private void agregarPanelCambiarClave() {
		
	}
	
//	private void agregarPaneDatosPersona() {
//		
//		panelDatosPersona = new JPanel();
//		panelDatosPersona.setBackground(Color.WHITE);
//		panelDatosPersona.setBounds(10, 10, getWidth()-20, 290);
//		getContentPane().add(panelDatosPersona);
//		panelDatosPersona.setLayout(null);		
//		
//		agregarLabelsPanelDatosPersona();
//		agregarCamposPanelDatosPersona();
//		
//		JTabbedPane paneDatosPersona = new JTabbedPane(JTabbedPane.TOP);
//		paneDatosPersona.addTab("Datos de la Persona", null, panelDatosPersona, null);	
//		paneDatosPersona.setBounds(10, 10, getWidth()-20, 290);
//		getContentPane().add(paneDatosPersona);
//	}
//
//	private void agregarLabelsPanelDatosPersona() {
//		
//		JLabel lblDni = new JLabel("* Dni:");
//		lblDni.setBounds(20, 15, 150, 25);
//		panelDatosPersona.add(lblDni);
//		
//		JLabel lblNombre = new JLabel("* Nombre:");
//		lblNombre.setBounds(20, 45, 150, 25);
//		panelDatosPersona.add(lblNombre);
//		
//		JLabel lblApellido = new JLabel("* Apellido: ");
//		lblApellido.setBounds(20, 75, 150, 25);
//		panelDatosPersona.add(lblApellido);
//		
//		JLabel lblEmail = new JLabel("* Email: ");
//		lblEmail.setBounds(20, 105, 150, 25);
//		panelDatosPersona.add(lblEmail);
//		
//		JLabel lblTelefono = new JLabel("Telefono: ");
//		lblTelefono.setBounds(20, 135, 150, 25);
//		panelDatosPersona.add(lblTelefono);
//		
//		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento: ");
//		lblFechaDeNacimiento.setBounds(20, 165, 150, 25);
//		panelDatosPersona.add(lblFechaDeNacimiento);
//		
//		JLabel lblPais = new JLabel("Pais: ");
//		lblPais.setBounds(20, 195, 150, 25);
//		panelDatosPersona.add(lblPais);
//		
//		JLabel lblCiudad = new JLabel("Ciudad: ");
//		lblCiudad.setBounds(20, 225, 150, 25);
//		panelDatosPersona.add(lblCiudad);
//	}
//	
//	private void agregarCamposPanelDatosPersona() {
//		
//		p = new PersonaRegistradaImpl();
//		
//		txtDni = new JTextField();
//		txtDni.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent e) {
//				setearDni(e);
//			}
//			@Override
//			public void keyTyped(KeyEvent e) {
//				controlarTeclasNumericas(e);
//			}
//		});
//		txtDni.setBounds(185, 15, 170, 25);
//		panelDatosPersona.add(txtDni);
//		
//		txtNombre = new JTextField();
//		txtNombre.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent e) {
//				setearNombre(e);				
//			}
//			@Override
//			public void keyTyped(KeyEvent e) {
//				controlarTeclasLetras(e);
//			}
//		});
//		txtNombre.setBounds(185, 45, 170, 25);
//		panelDatosPersona.add(txtNombre);
//		
//		txtApellido = new JTextField();
//		txtApellido.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent e) {				
//				setearApellido(e);			
//			}
//			@Override
//			public void keyTyped(KeyEvent e) {
//				controlarTeclasLetras(e);
//			}
//		});
//		txtApellido.setBounds(185, 75, 170, 25);
//		panelDatosPersona.add(txtApellido);
//		
//		txtEmail = new JTextField();
//		txtEmail.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent e) {
//				setearEmail(e);				
//			}
//			@Override
//			public void keyTyped(KeyEvent e) {
//				controlarTeclasLetras(e);
//			}
//		});
//		txtEmail.setBounds(185, 105, 170, 25);
//		panelDatosPersona.add(txtEmail);
//		
//		txtTelefono = new JTextField();
//		txtTelefono.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent e) {
//				setearTelefono(e);
//			}
//			@Override
//			public void keyTyped(KeyEvent e) {
//				controlarTeclasNumericas(e);
//			}
//		});
//		txtTelefono.setBounds(185, 135, 170, 25);
//		panelDatosPersona.add(txtTelefono);
//		
//		dateChooserNacimiento = new JDateChooser();
//		dateChooserNacimiento.addPropertyChangeListener(new PropertyChangeListener() {
//			public void propertyChange(PropertyChangeEvent arg0) {
//				setearFechaNacimiento();
//			}
//		});
//		dateChooserNacimiento.setEnabled(false);
//		dateChooserNacimiento.getCalendarButton().setEnabled(true);
//		dateChooserNacimiento.setBounds(185, 165, 170, 25);
//		panelDatosPersona.add(dateChooserNacimiento);
//		
//		txtPais = new JTextField();
//		txtPais.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent e) {
//				setearPais(e);
//			}
//			@Override
//			public void keyTyped(KeyEvent e) {
//				controlarTeclasLetras(e);
//			}
//		});
//		txtPais.setBounds(185, 195, 170, 25);
//		panelDatosPersona.add(txtPais);
//		
//		txtCiudad = new JTextField();
//		txtCiudad.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent e) {
//				setearCiudad(e);						
//			}
//			@Override
//			public void keyTyped(KeyEvent e) {
//				controlarTeclasLetras(e);
//			}
//		});
//		txtCiudad.setBounds(185, 225, 170, 25);
//		panelDatosPersona.add(txtCiudad);
//	}
//
//	private void setearNombre(KeyEvent e) {
//		 
//		char c = e.getKeyChar();
//		
//		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c == KeyEvent.VK_KP_LEFT) || (c == KeyEvent.VK_KP_RIGHT) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_BACK_SPACE)){
//			
//			btnGuardarCambios.setEnabled(true);
//			
//			if (txtNombre.getText().length() > 0){			
//				p.setNombre(txtNombre.getText());
//			}else {
//				p.setNombre("");
//			}
//		}
//	}
//	
//	private void setearApellido(KeyEvent e) {
//		
//		char c = e.getKeyChar();
//		
//		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c == KeyEvent.VK_KP_LEFT) || (c == KeyEvent.VK_KP_RIGHT) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_BACK_SPACE)){
//			
//			btnGuardarCambios.setEnabled(true);
//			
//			if (txtApellido.getText().length() > 0){						
//				p.setApellido(txtApellido.getText());
//			}else {
//				p.setApellido("");
//			}
//			
//		} 
//	}
//	
//	private void setearDni(KeyEvent e) {
//		
//		char c = e.getKeyChar();
//		
//		if ((c >= '0' && c <= '9') || (c == KeyEvent.VK_KP_LEFT) || (c == KeyEvent.VK_KP_RIGHT) || (c == KeyEvent.VK_BACK_SPACE)){
//			
//			btnGuardarCambios.setEnabled(true);
//			
//			if (txtDni.getText().length() > 0){
//				p.setDni(txtDni.getText());
//			}else {
//				p.setDni("");
//			}
//		}
//	}
//
//	private void setearEmail(KeyEvent e) {
//		
//		char c = e.getKeyChar();
//		
//		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || (c == KeyEvent.VK_KP_LEFT) || (c == KeyEvent.VK_KP_RIGHT) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_UNDERSCORE) || (c == '@') || (c == '.')){
//
//			btnGuardarCambios.setEnabled(true);
//			
//			if (txtEmail.getText().length() > 0){
//				p.setEmail(txtEmail.getText());
//			}else {
//				p.setEmail("");
//			}
//		}
//	}
//	
//	private void setearTelefono(KeyEvent e) {
//		
//		char c = e.getKeyChar();
//		
//		if ((c >= '0' && c <= '9') || (c == KeyEvent.VK_KP_LEFT) || (c == KeyEvent.VK_KP_RIGHT) || (c == KeyEvent.VK_BACK_SPACE)){
//			btnGuardarCambios.setEnabled(true);
//			p.setTelefono(txtTelefono.getText());
//		}
//	}
//	
//	private void setearPais(KeyEvent e) {
//		
//		char c = e.getKeyChar();
//		
//		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c == KeyEvent.VK_KP_LEFT) || (c == KeyEvent.VK_KP_RIGHT) || (c == KeyEvent.VK_BACK_SPACE)  || (c == KeyEvent.VK_SPACE)){
//			btnGuardarCambios.setEnabled(true);
//			p.setPais(txtPais.getText());
//		}
//	}
//	
//	private void setearCiudad(KeyEvent e) {
//		
//		char c = e.getKeyChar();
//		
//		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c == KeyEvent.VK_KP_LEFT) || (c == KeyEvent.VK_KP_RIGHT) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_SPACE)){
//			btnGuardarCambios.setEnabled(true);
//			p.setCiudad(txtCiudad.getText());
//		}	
//	}
//	
//	private void setearFechaNacimiento() {
//		
//		if (dateChooserNacimiento.getDate() != null){
//			btnGuardarCambios.setEnabled(true);
//			p.setFechaNacimiento(new Date(dateChooserNacimiento.getDate().getTime()));
//		}
//	}
//	
//	private void controlarTeclasLetras(KeyEvent e) {
//
//		char c = e.getKeyChar();
//		
//		if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_SPACE) && (c != KeyEvent.VK_BACK_SPACE)){
//			e.consume();
//		}
//	}
//	
//	private void controlarTeclasNumericas(KeyEvent e) {
//		char c = e.getKeyChar();
//		
//		if ((c < '0' || c > '9') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_BACK_SPACE)){
//			e.consume();
//		}
//	}
//
//	private void agregarPaneDatosUsuario() {
//
//		u = new UsuarioImpl();
//		
//		panelDatosUsuario = new JPanel();
//		panelDatosUsuario.setBackground(Color.WHITE);
//		panelDatosUsuario.setBounds(10, 315, getWidth()-20, 100);
//		getContentPane().add(panelDatosUsuario);
//		panelDatosUsuario.setLayout(null);	
//
//		agregarLabelsPanelDatosUsuario();
//		agregarCamposPanelDatosUsuario();
//		
//		JTabbedPane paneDatosUsuario = new JTabbedPane(JTabbedPane.TOP);
//		paneDatosUsuario.addTab("Datos del Usuario", null, panelDatosUsuario, null);	
//		paneDatosUsuario.setBounds(10, 315, getWidth()-20, 100);
//		getContentPane().add(paneDatosUsuario);
//	}
//	
//	private void agregarLabelsPanelDatosUsuario() {
//	
//		JLabel lblUsuario = new JLabel("* Usuario: ");
//		lblUsuario.setBounds(20, 15, 150, 30);
//		panelDatosUsuario.add(lblUsuario);
//		
//		JLabel lblContrasenia = new JLabel("* Contraseña: ");
//		lblContrasenia.setBounds(20, 45, 150, 30);
//		panelDatosUsuario.add(lblContrasenia);
//	}
//
//	private void agregarCamposPanelDatosUsuario() {
//
//		txtUsuario = new JTextField();
//		txtUsuario.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent e) {
//				setearUsuario();			
//			}
//		});
//		txtUsuario.setBounds(185, 15, 170, 30);
//		panelDatosUsuario.add(txtUsuario);
//		
//		txtPassword = new JPasswordField();		
//		txtPassword.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent e) {
//				setearPassword();
//			}
//		});
//		txtPassword.setBounds(185, 50, 170, 30);
//		panelDatosUsuario.add(txtPassword);
//	}
//
//	private void setearUsuario() {
//		
//		btnGuardarCambios.setEnabled(true);
//		
//		if (txtUsuario.getText().length() > 0){						
//			u.setNombreUsuario(txtUsuario.getText());
//		}else {
//			u.setNombreUsuario("");
//		}
//	}
//	
//	private void setearPassword() {
//		
//		btnGuardarCambios.setEnabled(true);
//		
//		if (txtPassword.getPassword().toString().length() > 0){	
//			u.setPassword(txtPassword.getPassword().toString());
//		}else {
//			u.setPassword("");
//		}
//	}
//	
//	private void agregarBotones(){
//		
//		btnGuardarCambios = new JButton("Guardar Cambios");
//		btnGuardarCambios.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				if (e.getSource() == btnGuardarCambios){
//					
////					try {
////						
////						pBo.verificarImportantes(p);
////						uBo.verificar(u);
////						
////						res = pDao.consultarPorPersonaYUsuario(dni);
////						
////						if (res.next()) {
////						
////							u.setTipoUsuario(res.getInt("tipoUsuario"));
////							u.setFechaInicio(res.getTimestamp("fechaInicio"));
////							
////							if (!res.getString("nombre").equals(p.getNombre())){	
////								pDao.modificacion("nombre", p.getNombre(), res.getString("dni"));
////							}
////							if (!res.getString("apellido").equals(p.getApellido())){
////								pDao.modificacion("apellido", p.getApellido(), res.getString("dni"));
////							}
////							if (!res.getString("email").equals(p.getEmail())){	
////								pDao.modificacion("email", p.getEmail(), res.getString("dni"));
////							}
////							if (!res.getString("telefono").equals(p.getTelefono())){	
////								pDao.modificacion("telefono", p.getTelefono(), res.getString("dni"));
////							}
////							if (!res.getDate("fechaNacimiento").equals(p.getFechaNacimiento())){	
////								pDao.modificacion("fechaNacimiento", p.getFechaNacimiento().toString(), res.getString("dni"));							
////							}
////							if (!res.getString("ciudad").equals(p.getCiudad())){							
////								pDao.modificacion("ciudad", p.getCiudad(), res.getString("dni"));
////							}							
////							if (!res.getString("usuario").equals(u.getNombreUsuario())) {
////								uDao.modificacionNombreUsuario(u.getNombreUsuario(), res.getString("usuario"));
////								pDao.modificacion("usuario", u.getNombreUsuario(), res.getString("usuario"));
////							}
////							if (!res.getString("contrasenia").equals(u.getPassword())) {	
////								uDao.modificacionContrasenia(u.getPassword(), res.getString("usuario"));							
////							}
////							if (!res.getString("pais").equals(p.getPais())){	
////								pDao.modificacion("pais", p.getPais(), res.getString("dni"));
////							}
////							if (!res.getString("dni").equals(p.getDni())){
////								pDao.modificacionDni("dni", p.getDni(), res.getString("dni"));
////								rVDao.modificacion(p.getDni(), dni);
////							}
////
////						}
////	
////						JOptionPane.showMessageDialog(null, "Se ha modificado la informacion personal con exito!"); 
////						setVisible(false);
////					
////					} catch (PersonNotValidException e1) {
////						JOptionPane.showMessageDialog(null, e1.getMessage());
////					} catch (UserNotValidException e1) {
////						JOptionPane.showMessageDialog(null, e1.getMessage());
////					} catch(ClassNotFoundException e1){
////						JOptionPane.showMessageDialog(null, e1.getMessage());
////					} catch (SQLException e1){
////						JOptionPane.showMessageDialog(null, e1.getMessage());
////					} catch (PersonAlreadyExistsException e1) {
////						JOptionPane.showMessageDialog(null, e1.getMessage());
////					} catch (UserAlreadyExistsException e1) {
////						JOptionPane.showMessageDialog(null, e1.getMessage());
////					}
//					
//				}
//			}
//		});
//		btnGuardarCambios.setEnabled(false);
//		btnGuardarCambios.setBounds(22, 425, 156, 25);
//		getContentPane().add(btnGuardarCambios);
//		
//		JButton btnCancelar = new JButton("Cancelar");
//		btnCancelar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				dispose();
//			}
//		});
//		btnCancelar.setBounds(277, 425, 140, 25);
//		getContentPane().add(btnCancelar);
//	}
}