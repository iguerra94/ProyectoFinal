package org.proyectofinal.ui.plantillasUI;

import java.awt.Color;
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
import java.sql.SQLException;
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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import org.proyectofinal.bo.ex.PersonNotValidAgeException;
import org.proyectofinal.bo.impl.PersonaRegistradaBoImpl;
import org.proyectofinal.bo.impl.UsuarioBoImpl;
import org.proyectofinal.bo.interfaces.PersonaRegistradaBo;
import org.proyectofinal.bo.interfaces.UsuarioBo;
import org.proyectofinal.dao.ex.PersonAlreadyExistsException;
import org.proyectofinal.dao.ex.PersonNotValidException;
import org.proyectofinal.dao.ex.UserAlreadyExistsException;
import org.proyectofinal.dao.ex.UserNotValidException;
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
	
	private JPanel panelDatosPersonales;
	private JPanel panelDatosUsuario;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private JDateChooser birthDateChooser;
	private JComboBox cmbPais;
	private JComboBox cmbCiudad;
	private JTextField txtCiudad;
	private JTextField txtNombreUsuario;
	private JPasswordField txtContrasea;
	private JButton btnRegistrarse;
	private JButton btnCancelar;
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
		setBounds(100, 100, 410, 490);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
	}
	
	protected void agregarPanePersona(){
		
		p = new PersonaRegistradaImpl();
		
		panelDatosPersonales = new JPanel();
		panelDatosPersonales.setBackground(Color.WHITE);
		panelDatosPersonales.setLayout(null);
		getContentPane().add(panelDatosPersonales);
		
		agregarLabelsPanelPersona();
		agregarCamposPanelPersona();
		
		JTabbedPane panePersona = new JTabbedPane(JTabbedPane.TOP);
		panePersona.addTab("Datos Personales", null, panelDatosPersonales, null);	
		panePersona.setBounds(12, 12, 390, 290);
		getContentPane().add(panePersona);
	}

	private void agregarLabelsPanelPersona() {
		
		JLabel lblDni = new JLabel("* DNI: ");
		lblDni.setBounds(20, 80, 170, 15);
		panelDatosPersonales.add(lblDni);
		
		JLabel lblNombre = new JLabel("* Nombre: ");
		lblNombre.setBounds(20, 20, 170, 15);
		panelDatosPersonales.add(lblNombre);
			
		JLabel lblApellido = new JLabel("* Apellido: ");
		lblApellido.setBounds(20, 50, 170, 15);
		panelDatosPersonales.add(lblApellido);
	
		JLabel lblEmail = new JLabel("* Email: ");
		lblEmail.setBounds(20, 110, 170, 15);
		panelDatosPersonales.add(lblEmail);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento: ");
		lblFechaDeNacimiento.setBounds(20, 140, 170, 15);
		panelDatosPersonales.add(lblFechaDeNacimiento);
	
		JLabel lblPais = new JLabel("Pais: ");
		lblPais.setBounds(20, 200, 170, 15);
		panelDatosPersonales.add(lblPais);
	
		JLabel lblTelefono = new JLabel("Telefono: ");
		lblTelefono.setBounds(20, 170, 170, 15);
		panelDatosPersonales.add(lblTelefono);
	
		JLabel lblCiudad = new JLabel("Ciudad: ");
		lblCiudad.setBounds(20, 230, 170, 15);
		panelDatosPersonales.add(lblCiudad);
	}

	private void agregarCamposPanelPersona() {
		
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
				controlarCaracteresNumericos(e);				
			}
		});
		txtDni.setBounds(186, 75, 170, 25);
		panelDatosPersonales.add(txtDni);
		txtDni.setColumns(10);
	
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
		});
		txtNombre.setColumns(10);
		txtNombre.setBounds(186, 15, 170, 25);
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
		});
		txtApellido.setColumns(10);
		txtApellido.setBounds(186, 45, 170, 25);
		panelDatosPersonales.add(txtApellido);		
		
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
		txtEmail.setColumns(10);
		txtEmail.setBounds(186, 105, 170, 25);
		panelDatosPersonales.add(txtEmail);

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
				
				controlarCaracteresNumericos(e);
			}
		});
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(186, 165, 170, 25);
		panelDatosPersonales.add(txtTelefono);

		now = new java.util.Date();
		
		birthDateChooser = new JDateChooser();
		birthDateChooser.setDate(now);
		birthDateChooser.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				establecerFecha();
			}
		});
		birthDateChooser.setBounds(186, 135, 170, 25);
		panelDatosPersonales.add(birthDateChooser);
	
		JButton btnMayorDeEdad = new JButton("<html><strong>?</strong></html>");
		btnMayorDeEdad.setToolTipText("Debes ser mayor de 18 años para poder registrarte en el sistema.");
		btnMayorDeEdad.setForeground(Color.BLUE);
		btnMayorDeEdad.setContentAreaFilled(false);
		btnMayorDeEdad.setBorderPainted(false);
		btnMayorDeEdad.setBounds(353, 135, 31, 24);
		panelDatosPersonales.add(btnMayorDeEdad);
		
		cmbPais = new JComboBox();
		cmbPais.setBounds(186, 195, 170, 25);
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
		panelDatosPersonales.add(cmbPais);
		
		cmbCiudad = new JComboBox();
		cmbCiudad.setBounds(186, 225, 170, 25);
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
		panelDatosPersonales.add(cmbCiudad);
		
	}
	
	protected void agregarPaneUsuario(){
		
		u = new UsuarioImpl();
		
		panelDatosUsuario = new JPanel();
		panelDatosUsuario.setBackground(Color.WHITE);
		panelDatosUsuario.setLayout(null);

		agregarLabelsPaneUsuario();
		agregarCamposPaneUsuario();
		
		JTabbedPane paneUsuario = new JTabbedPane(JTabbedPane.TOP);
		paneUsuario.addTab("Datos del usuario", null, panelDatosUsuario, null);	
		paneUsuario.setBounds(12, 315, 390, 120);
		getContentPane().add(paneUsuario);
	}
	
	private void agregarLabelsPaneUsuario() {
		
		JLabel lblNombreUsuario = new JLabel("* Nombre de usuario: ");
		lblNombreUsuario.setBounds(20, 20, 170, 15);
		panelDatosUsuario.add(lblNombreUsuario);
		
		JLabel lblContrasea = new JLabel("* Contraseña: ");
		lblContrasea.setBounds(20, 50, 170, 15);
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
		txtNombreUsuario.setColumns(10);
		txtNombreUsuario.setBounds(186, 15, 170, 25);
		panelDatosUsuario.add(txtNombreUsuario);
	
		txtContrasea = new JPasswordField();
		txtContrasea.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				String pass = new String(txtContrasea.getPassword());
				
				if (pass.trim().length() > 0){
					u.setPassword(pass);					
				}else{
					u.setPassword("");
				}
				
			}
		});
		txtContrasea.setBounds(186, 45, 170, 25);
		panelDatosUsuario.add(txtContrasea);
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
		btnRegistrarse.setBounds(12, 435, 174, 25);
		getContentPane().add(btnRegistrarse);
		
		getRootPane().setDefaultButton(btnRegistrarse);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				if (e.getSource() == btnCancelar){
					dispose();
				}
			}
		});
		btnCancelar.setBounds(270, 435, 117, 25);
		getContentPane().add(btnCancelar);
	}
	
	private void controlarCaracteresLetras(KeyEvent e) {
		
		char c = e.getKeyChar();
		
		if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_SPACE) && (c != KeyEvent.VK_BACK_SPACE)){
			e.consume();
		}
	}

	private void controlarCaracteresNumericos(KeyEvent e) {
		
		char c = e.getKeyChar();
		
		if ((c < '0' || c > '9') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_SPACE) && (c != KeyEvent.VK_BACK_SPACE)){
			e.consume();
		}
	}
	
	private void actionBtnRegistrarse(){

		pBo = new PersonaRegistradaBoImpl();
		uBo = new UsuarioBoImpl();
		
		java.util.Date now = new java.util.Date();
		Timestamp fechaActual = new Timestamp(now.getTime());
		
		if (birthDateChooser.getDate() != null){
			Date date = new Date(birthDateChooser.getDate().getTime());
			p.setFechaNacimiento(date);
		}
		
		u.setTipoUsuario(1);
		u.setFechaInicio(fechaActual);
		
		p.setUsuario(u);
		
		try {
		
			uBo.verificar(u);
			
			pBo.verificarImportantes(p);
			pBo.verificarEdad(p);
			
			uBo.registrarUsuario(u);
			pBo.registrarPersona(p);

			JOptionPane.showMessageDialog(null, "Se ha registrado el usuario con exito!"); 

			System.out.println(p);

			setVisible(false);
			
		} catch (UserNotValidException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (UserAlreadyExistsException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (PersonNotValidException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (PersonNotValidAgeException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (PersonAlreadyExistsException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (SQLException e) {
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
		
		cmbPais.setModel(new DefaultComboBoxModel(modelPaises));
		cmbPais.setSelectedIndex(0);
	}
	
	protected void cargarCiudades(){
		
		ListaCiudades ciudades = new ListaCiudades();
		
		List<CiudadUtil> listaModeloCiudades = new ArrayList<CiudadUtil>();

		listaModeloCiudades.add(new CiudadUtil("", ""));
		
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
		
		cmbCiudad.setModel(new DefaultComboBoxModel(modelCiudades));
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
