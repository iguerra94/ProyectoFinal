package org.proyectofinal.ui.plantillasUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import org.proyectofinal.bo.ex.PersonAlreadyExistsException;
import org.proyectofinal.bo.ex.PersonGenericNotValidDniException;
import org.proyectofinal.bo.ex.PersonNotValidAgeException;
import org.proyectofinal.bo.ex.PersonNotValidEmailException;
import org.proyectofinal.bo.ex.PersonNotValidException;
import org.proyectofinal.bo.ex.UserAlreadyExistsException;
import org.proyectofinal.bo.ex.UserNotValidException;
import org.proyectofinal.bo.impl.PersonaRegistradaBoImpl;
import org.proyectofinal.bo.impl.UsuarioBoImpl;
import org.proyectofinal.bo.interfaces.PersonaRegistradaBo;
import org.proyectofinal.bo.interfaces.UsuarioBo;
import org.proyectofinal.model.impl.PersonaRegistradaImpl;
import org.proyectofinal.model.impl.UsuarioImpl;
import org.proyectofinal.model.interfaces.PersonaRegistrada;
import org.proyectofinal.model.interfaces.Usuario;
import org.proyectofinal.ui.util.CiudadUtil;
import org.proyectofinal.ui.util.ListaCiudades;
import org.proyectofinal.ui.util.ListaPaises;
import org.proyectofinal.ui.util.PaisUtil;

import com.toedter.calendar.JDateChooser;

public class PlantillaDR extends JDialog {
	
	private static final long serialVersionUID = 7802271145872718024L;
	
	private JPanel panelDatosPersonales;
	private JPanel panelDatosUsuario;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private JDateChooser birthDateChooser;
	private JComboBox<PaisUtil> cmbPais;
	private JComboBox<CiudadUtil> cmbCiudad;
	private JTextField txtNombreUsuario;
	private JPasswordField txtContrasea;
	private JButton btnRegistrarse;
	private Usuario u;
	private PersonaRegistrada p;
	private UsuarioBo uBo;
	private PersonaRegistradaBo pBo;
	private java.util.Date now;

	public PlantillaDR(){
	}
	
	protected void inicializarAtributos(){
		setTitle("Registrarse");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 424, 620);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
	}
	
	protected void agregarPanelPersona(){
		
		p = new PersonaRegistradaImpl();

		JPanel panelEtiquetaPersona = new JPanel();
		panelEtiquetaPersona.setBackground(Color.WHITE);
		panelEtiquetaPersona.setLayout(null);
		panelEtiquetaPersona.setBorder(new MatteBorder(0,0,1,0, new Color(27, 0, 136)));
		panelEtiquetaPersona.setBounds(12, 10, 400, 40);
		getContentPane().add(panelEtiquetaPersona);
		
		JLabel labelEtiquetaPersona = new JLabel("Datos Personales");
		labelEtiquetaPersona.setFont(new Font("Roboto Light", Font.PLAIN, 18));
		labelEtiquetaPersona.setForeground(new Color(27, 0, 136));
		labelEtiquetaPersona.setBounds(10, 0, 400, 40);
		panelEtiquetaPersona.add(labelEtiquetaPersona);
	
		panelDatosPersonales = new JPanel();
		panelDatosPersonales.setBackground(Color.WHITE);
		panelDatosPersonales.setLayout(null);
		panelDatosPersonales.setBounds(12, 50, 400, 335);
		getContentPane().add(panelDatosPersonales);
		
		agregarLabelsPanelPersona();
		agregarCamposPanelPersona();
	}

	private void agregarLabelsPanelPersona() {

		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(20, 15, 170, 30);
		lblNombre.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		panelDatosPersonales.add(lblNombre);
			
		JLabel lblApellido = new JLabel("Apellido: ");
		lblApellido.setBounds(20, 55, 170, 30);
		lblApellido.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		panelDatosPersonales.add(lblApellido);
		
		JLabel lblDni = new JLabel("DNI: ");
		lblDni.setBounds(20, 95, 170, 30);
		lblDni.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		panelDatosPersonales.add(lblDni);
	
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setBounds(20, 135, 170, 30);
		lblEmail.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		panelDatosPersonales.add(lblEmail);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento: ");
		lblFechaDeNacimiento.setBounds(20, 175, 170, 30);
		lblFechaDeNacimiento.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		panelDatosPersonales.add(lblFechaDeNacimiento);
	
		JLabel lblTelefono = new JLabel("Telefono: ");
		lblTelefono.setBounds(20, 215, 170, 30);
		lblTelefono.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		panelDatosPersonales.add(lblTelefono);
		
		JLabel lblPais = new JLabel("Pais: ");
		lblPais.setBounds(20, 255, 170, 30);
		lblPais.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		panelDatosPersonales.add(lblPais);
		
		JLabel lblCiudad = new JLabel("Ciudad: ");
		lblCiudad.setBounds(20, 295, 170, 30);
		lblCiudad.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		panelDatosPersonales.add(lblCiudad);
	}

	private void agregarCamposPanelPersona() {
	
		txtNombre = new JTextField();
		txtNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			
				if (txtNombre.getText().trim().length() > 0){
					p.setNombre(txtNombre.getText());
				}else{
					p.setNombre("");
				}
			}
		});
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {				
				controlarCaracteresLetras(e);				
			}
			public void keyReleased(KeyEvent e){
				if (txtNombre.getText().trim().length() > 0){
					p.setNombre(txtNombre.getText());
				}else{
					p.setNombre("");
				}
			}
		});
		txtNombre.setBounds(186, 15, 180, 30);
		txtNombre.setFont(new Font("Roboto Regular", Font.PLAIN, 14));
		txtNombre.requestFocus();
		panelDatosPersonales.add(txtNombre);
	
		txtApellido = new JTextField();
		txtApellido.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if (txtApellido.getText().trim().length() > 0){
					p.setApellido(txtApellido.getText());
				}else{
					p.setApellido("");
				}
			}
		});
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				controlarCaracteresLetras(e);
			}
			public void keyReleased(KeyEvent e){
				if (txtApellido.getText().trim().length() > 0){
					p.setApellido(txtApellido.getText());
				}else{
					p.setApellido("");
				}
			}
		});
		txtApellido.setBounds(186, 55, 180, 30);
		txtApellido.setFont(new Font("Roboto Regular", Font.PLAIN, 14));
		panelDatosPersonales.add(txtApellido);		
		
		txtDni = new JTextField();
		txtDni.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if (txtDni.getText().trim().length() > 0){
					p.setDni(txtDni.getText());
				}else{
					p.setDni("");
				}
			}
		});
		txtDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {				
				controlarCaracteresNumericosDNI(e);
			}
			public void keyReleased(KeyEvent e){
				if (txtDni.getText().trim().length() > 0){
					p.setDni(txtDni.getText());
				}else{
					p.setDni("");
				}
			}
		});
		txtDni.setBounds(186, 95, 180, 30);
		txtDni.setFont(new Font("Roboto Regular", Font.PLAIN, 14));
		panelDatosPersonales.add(txtDni);
		
		txtEmail = new JTextField();
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if (txtEmail.getText().trim().length() > 0){
					p.setEmail(txtEmail.getText());
				}else{
					p.setEmail("");
				}
			}
		});
		txtEmail.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent e){
				if (txtEmail.getText().trim().length() > 0){
					p.setEmail(txtEmail.getText());
				}else{
					p.setEmail("");
				}
			}
			
		});
		txtEmail.setBounds(186, 135, 180, 30);
		txtEmail.setFont(new Font("Roboto Regular", Font.PLAIN, 14));
		panelDatosPersonales.add(txtEmail);

		now = new java.util.Date();
		
		birthDateChooser = new JDateChooser();
		birthDateChooser.setDate(now);
		birthDateChooser.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				establecerFecha();
			}
		});
		birthDateChooser.setBounds(186, 175, 180, 30);
		birthDateChooser.setFont(new Font("Roboto Regular", Font.PLAIN, 14));
		panelDatosPersonales.add(birthDateChooser);
	
		JButton btnMayorDeEdad = new JButton("<html>?</html>");
		btnMayorDeEdad.setToolTipText("Debes ser mayor de 18 años para poder registrarte en el sistema.");
		btnMayorDeEdad.setForeground(new Color(27,0,136));
		btnMayorDeEdad.setContentAreaFilled(false);
		btnMayorDeEdad.setBorderPainted(false);
		btnMayorDeEdad.setBounds(366, 175, 34, 30);
		btnMayorDeEdad.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		panelDatosPersonales.add(btnMayorDeEdad);
		
		txtTelefono = new JTextField();
		txtTelefono.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if (txtTelefono.getText().trim().length() > 0){
					p.setTelefono(txtTelefono.getText());				
				}else{
					p.setTelefono("");
				}
			}
		});
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {				
				controlarCaracteresNumericosTELEFONO(e);
			}
			public void keyReleased(KeyEvent e){
				if (txtTelefono.getText().trim().length() > 0){
					p.setTelefono(txtTelefono.getText());				
				}else{
					p.setTelefono("");
				}
			}
		});
		txtTelefono.setBounds(186, 215, 180, 30);
		txtTelefono.setFont(new Font("Roboto Regular", Font.PLAIN, 14));
		panelDatosPersonales.add(txtTelefono);
		
		cmbPais = new JComboBox<PaisUtil>();
		cmbPais.setBounds(186, 255, 180, 30);
		cmbPais.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				actualizarComboCiudad();
				cargarCiudades();
				
				if (cmbPais.getSelectedIndex()!=0){
					PaisUtil pais = (PaisUtil)cmbPais.getSelectedItem();
					p.setPais(pais.getPais());
					p.setShortPais(pais.getShortPais());
				}else{
					p.setPais("");
					p.setShortPais("");
				}
			}
		});
		cmbPais.setFont(new Font("Roboto Regular", Font.PLAIN, 14));
		panelDatosPersonales.add(cmbPais);
		
		cmbCiudad = new JComboBox<CiudadUtil>();
		cmbCiudad.setBounds(186, 295, 180, 30);
		cmbCiudad.setEnabled(false);
		cmbCiudad.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (cmbCiudad.getSelectedIndex()!=0){
					CiudadUtil ciudad = (CiudadUtil)cmbCiudad.getSelectedItem();
					p.setCiudad(ciudad.getCiudad());
				}else{
					p.setCiudad("");
				}
			}
		});
		cmbCiudad.setFont(new Font("Roboto Regular", Font.PLAIN, 14));
		panelDatosPersonales.add(cmbCiudad);
		
		p.setDni("");
		p.setNombre("");
		p.setApellido("");
		p.setEmail("");
		p.setTelefono("");
	}
	
	
	protected void agregarPanelUsuario(){
		
		u = new UsuarioImpl();
		
		JPanel panelEtiquetaUsuario = new JPanel();
		panelEtiquetaUsuario.setBackground(Color.WHITE);
		panelEtiquetaUsuario.setLayout(null);
		panelEtiquetaUsuario.setBorder(new MatteBorder(0,0,1,0, new Color(27, 0, 136)));
		panelEtiquetaUsuario.setBounds(12, 400, 400, 40);
		getContentPane().add(panelEtiquetaUsuario);
		
		JLabel labelEtiquetaUsuario = new JLabel("Datos del Usuario");
		labelEtiquetaUsuario.setFont(new Font("Roboto Light", Font.PLAIN, 18));
		labelEtiquetaUsuario.setForeground(new Color(27, 0, 136));
		labelEtiquetaUsuario.setBounds(10, 0, 400, 40);
		panelEtiquetaUsuario.add(labelEtiquetaUsuario);
	
		
		panelDatosUsuario = new JPanel();
		panelDatosUsuario.setBackground(Color.WHITE);
		panelDatosUsuario.setLayout(null);
		panelDatosUsuario.setBounds(12, 440, 400, 95);
		getContentPane().add(panelDatosUsuario);

		agregarLabelsPaneUsuario();
		agregarCamposPaneUsuario();
		
	}
	
	
	private void agregarLabelsPaneUsuario() {
		
		JLabel lblNombreUsuario = new JLabel("Nombre de usuario: ");
		lblNombreUsuario.setBounds(20, 15, 170, 30);
		lblNombreUsuario.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		panelDatosUsuario.add(lblNombreUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña: ");
		lblContrasea.setBounds(20, 55, 170, 30);
		lblContrasea.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		panelDatosUsuario.add(lblContrasea);
	}
	

	private void agregarCamposPaneUsuario() {
		
		txtNombreUsuario = new JTextField();
		txtNombreUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if (txtNombreUsuario.getText().trim().length() > 0){
					u.setNombreUsuario(txtNombreUsuario.getText());
				}else{
					u.setNombreUsuario("");
				}
			}
		});
		txtNombreUsuario.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e){
				if (txtNombreUsuario.getText().trim().length() > 0){
					u.setNombreUsuario(txtNombreUsuario.getText());
				}else{
					u.setNombreUsuario("");
				}
			}
		});
		txtNombreUsuario.setBounds(186, 15, 180, 30);
		txtNombreUsuario.setFont(new Font("Roboto Regular", Font.PLAIN, 14));
		panelDatosUsuario.add(txtNombreUsuario);
	
		txtContrasea = new JPasswordField();
		txtContrasea.addFocusListener(new FocusAdapter() {
			
			public void focusLost(FocusEvent arg0) {
				
				String pass = new String(txtContrasea.getPassword());
				
				if (pass.trim().length() > 0){
					u.setPassword(pass);					
				}else{
					u.setPassword("");
				}
				
			}
		});
		txtContrasea.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e){
				String pass = new String(txtContrasea.getPassword());
				
				if (pass.trim().length() > 0){
					u.setPassword(pass);					
				}else{
					u.setPassword("");
				}
			}
		});
		txtContrasea.setBounds(186, 55, 180, 30);
		txtContrasea.setFont(new Font("Roboto Regular", Font.PLAIN, 14));
		panelDatosUsuario.add(txtContrasea);
		
		u.setNombreUsuario("");
		u.setPassword("");
	}

	
	protected void agregarBotones(){
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {			
			
			public void actionPerformed(ActionEvent e) {	
				
				if (e.getSource() == btnRegistrarse){
					actionBtnRegistrarse();
				}
			
			}
		});
		btnRegistrarse.setBounds(20, 545, 170, 40);
		btnRegistrarse.setBackground(new Color(0,100,90));
		btnRegistrarse.setFont(new Font("Roboto Regular", Font.PLAIN, 18));
		btnRegistrarse.setForeground(Color.WHITE);
		getContentPane().add(btnRegistrarse);
		
		getRootPane().setDefaultButton(btnRegistrarse);
	}
	
	private void controlarCaracteresLetras(KeyEvent e) {
		
		char c = e.getKeyChar();
		
		if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_SPACE) && (c != KeyEvent.VK_BACK_SPACE)){
			e.consume();
		}
	}

	private void controlarCaracteresNumericosDNI(KeyEvent e) {
		
		char c = e.getKeyChar();
		
		if ((c < '0' || c > '9') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_SPACE) && (c != KeyEvent.VK_BACK_SPACE) || txtDni.getText().length() == 8){
			e.consume();
		}
	}
	
	private void controlarCaracteresNumericosTELEFONO(KeyEvent e) {
		
		char c = e.getKeyChar();
		
		if ((c < '0' || c > '9') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_SPACE) && (c != KeyEvent.VK_BACK_SPACE) || txtTelefono.getText().length() == 11){
			e.consume();
		}
	}
	
	private void actionBtnRegistrarse(){

		uBo = new UsuarioBoImpl();
		pBo = new PersonaRegistradaBoImpl();
		
		java.util.Date now = new java.util.Date();
		Timestamp fechaActual = new Timestamp(now.getTime());
		
		if (birthDateChooser.getDate() != null){
			Date date = new Date(birthDateChooser.getDate().getTime());
			p.setFechaNacimiento(date);
		}
		
		u.setTipoUsuario(1);
		u.setFechaInicio(fechaActual);
		
		p.setSaldo(0);
		p.setUsuario(u);
		
		try {
		
			uBo.verificar(u);
			
			pBo.verificarTodos(p);
			pBo.verificarDni(p);
			pBo.verificarEmail(p);
			pBo.verificarEdad(p);
			
			uBo.controlarExistenciaUsuario(p.getUsuario());
			pBo.controlarExistenciaPersona(p);
			
			uBo.registrarUsuario(u);
			pBo.registrarPersona(p);

			JOptionPane.showMessageDialog(null, "Se ha registrado el usuario con exito!"); 

			dispose();
			
		} catch (UserNotValidException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (PersonGenericNotValidDniException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (PersonNotValidEmailException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (PersonNotValidAgeException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (PersonNotValidException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (UserAlreadyExistsException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (PersonAlreadyExistsException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	protected void establecerFecha(){
		
		Date fechaActual = new Date(now.getTime());
		
		Integer day = Integer.parseInt(fechaActual.toString().substring(8, 10));
		Integer month = Integer.parseInt(fechaActual.toString().substring(5, 7));
		Integer year = Integer.parseInt(fechaActual.toString().substring(0, 4))-18;
	
		String date = day + "-" + month + "-" + year; 
		
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			java.util.Date fecha = formatoFecha.parse(date);
			birthDateChooser.setMaxSelectableDate(fecha);	
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

	protected void cargarPaises(){
		
		ListaPaises paises = new ListaPaises();
		
		PaisUtil[] modelPaises = new PaisUtil[paises.getListaPaises().size()+1];
	
		modelPaises[0] = new PaisUtil("","");
		
		int i = 1;

		for (PaisUtil p : paises.getListaPaises()) {
			modelPaises[i] = p;
			i++;
		}
		
		cmbPais.setModel(new DefaultComboBoxModel<PaisUtil>(modelPaises));
		cmbPais.setSelectedIndex(0);
	}
	
	protected void cargarCiudades(){
		
		ListaCiudades ciudades = new ListaCiudades();
		
		List<CiudadUtil> listaModeloCiudades = new ArrayList<CiudadUtil>();

		listaModeloCiudades.add(new CiudadUtil("", "", false));
		
		PaisUtil pais = (PaisUtil)cmbPais.getSelectedItem();
		
		for (CiudadUtil c : ciudades.getListaCiudades()) {
			if (c.getShortPais().equals( pais.getShortPais()) ){
				listaModeloCiudades.add(c);
			}
		}

		CiudadUtil[] modelCiudades = new CiudadUtil[listaModeloCiudades.size()];
		
		int i = 0;
		
		for (CiudadUtil c : listaModeloCiudades) {
			modelCiudades[i] = c;
			
			i++;
		}
		
		cmbCiudad.setModel(new DefaultComboBoxModel<CiudadUtil>(modelCiudades));
		cmbCiudad.setSelectedIndex(0);
	}
	
	protected void actualizarComboCiudad(){
		
		if (cmbPais.getSelectedIndex() != 0){
			cmbCiudad.setEnabled(true);
		}else{
			cmbCiudad.setEnabled(false);
			if (cmbCiudad.getModel().getSize()>0){
				cmbCiudad.setSelectedIndex(0);
			}
		}

		panelDatosPersonales.validate();
		panelDatosPersonales.repaint();
	}
	
}