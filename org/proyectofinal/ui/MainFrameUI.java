package org.proyectofinal.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.proyectofinal.bo.impl.UsuarioBoImpl;
import org.proyectofinal.bo.interfaces.UsuarioBo;
import org.proyectofinal.dao.ex.UserNotCorrectException;
import org.proyectofinal.dao.ex.UserNotExistsException;
import org.proyectofinal.dao.ex.UserNotValidException;
import org.proyectofinal.dao.impl.PersonaDaoImpl;
import org.proyectofinal.dao.impl.UsuarioDaoImpl;
import org.proyectofinal.dao.interfaces.PersonaDao;
import org.proyectofinal.dao.interfaces.UsuarioDao;
import org.proyectofinal.model.impl.UsuarioImpl;
import org.proyectofinal.model.interfaces.Usuario;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class MainFrameUI extends JFrame {

	private static final long serialVersionUID = 3667571948857412383L;
	
	private panelUsuario pU;
//	private panelInicio pI;
	private JTextField txtNombreUsuario;
	private JPasswordField txtContrasea;
	private JButton btnCerrarSesin;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbTipoUsuario;
	private UsuarioBo uBo;
	private UsuarioDao uDao;
	private PersonaDao pDao;
	private ResultSet persona;
	private Usuario u;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrameUI frame = new MainFrameUI();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error de MainFrame");
				}
			}
			
		});
		
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MainFrameUI() {
		
		u = new UsuarioImpl();
		uBo = new UsuarioBoImpl();
		uDao = new UsuarioDaoImpl();
		pDao = new PersonaDaoImpl();		
	
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {

				u = new UsuarioImpl();
				
				if (txtNombreUsuario.getText().trim().length() > 0){
					u.setNombreUsuario(txtNombreUsuario.getText());
				}
				
				String pass = new String(txtContrasea.getPassword());
				
				if (pass.trim().length() > 0){
					u.setPassword(pass);
				}
				
				if (cmbTipoUsuario.getSelectedIndex() == 2){
					u.setTipoUsuario(1);
				}else if (cmbTipoUsuario.getSelectedIndex() == 3){
					u.setTipoUsuario(0);
				}
				
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		
		
		
		setResizable(false);
		setTitle("Sistema de Gestion de Boletos de Avion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		setSize(1006, 576);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		final JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1000, 21);
		getContentPane().add(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		final JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == mntmSalir){
					System.exit(0);
				}
			}
		});
		mnArchivo.add(mntmSalir);
		
		final JMenu mnVuelos = new JMenu("Vuelos");
		
		final JMenuItem mntmVerListado = new JMenuItem("Ver Listado..");
		mntmVerListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == mntmVerListado){
					ListadoVuelosUI ui = new ListadoVuelosUI();
					
					ui.setSize(970, 460);
					
					ui.setVisible(true);
				}
			}
		});
		mnVuelos.add(mntmVerListado);
		
		@SuppressWarnings("unused")
		ImageIcon icono = new ImageIcon(MainFrameUI.class.getResource("/imagenes/user-resized.png"));
		
		
		final JLabel lblSistemaDeGestion = new JLabel("SISTEMA DE GESTIÓN DE BOLETOS DE AVIÓN");
		lblSistemaDeGestion.setBounds(0, 485, 978, 49);
		getContentPane().add(lblSistemaDeGestion);
		lblSistemaDeGestion.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 35));
		lblSistemaDeGestion.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSistemaDeGestion.setHorizontalAlignment(SwingConstants.CENTER);
		
		final JLabel lblIconoAvion = new JLabel("");
		lblIconoAvion.setBounds(616, 70, 329, 205);
		getContentPane().add(lblIconoAvion);
		lblIconoAvion.setIcon(new ImageIcon(MainFrameUI.class.getResource("/imagenes/avion4.png")));
		lblIconoAvion.setHorizontalAlignment(SwingConstants.CENTER);
		
		final JPanel panelInicioSesion = new JPanel();
		panelInicioSesion.setBounds(20, 35, 547, 300);
		panelInicioSesion.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Iniciar Sesi\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panelInicioSesion);
		panelInicioSesion.setLayout(null);
				
		JLabel lblNombreUsuario = new JLabel("Nombre de Usuario: ");
		lblNombreUsuario.setBounds(25, 35, 153, 30);
		lblNombreUsuario.setLabelFor(txtNombreUsuario);
		panelInicioSesion.add(lblNombreUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña: ");
		lblContrasea.setBounds(25, 75, 153, 30);
		lblContrasea.setLabelFor(txtContrasea);
		panelInicioSesion.add(lblContrasea);
		
		JLabel lblTipoUsuario = new JLabel("Tipo de Usuario: ");
		lblTipoUsuario.setBounds(25, 115, 153, 30);
		lblTipoUsuario.setLabelFor(cmbTipoUsuario);
		panelInicioSesion.add(lblTipoUsuario);
		
		txtNombreUsuario = new JTextField();
		txtNombreUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if (txtNombreUsuario.getText().trim().length() > 0){
					u.setNombreUsuario(txtNombreUsuario.getText());
				}
			}
		});
		txtNombreUsuario.setBounds(184, 41, 155, 19);
		panelInicioSesion.add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);
		
		txtContrasea = new JPasswordField();
		txtContrasea.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				String pass = new String(txtContrasea.getPassword());
				
				if (pass.trim().length() > 0){
					u.setPassword(pass);
				}
			}
		});
		txtContrasea.setBounds(184, 81, 155, 19);
		panelInicioSesion.add(txtContrasea);
		
		cmbTipoUsuario = new JComboBox();
		cmbTipoUsuario.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				
				if (cmbTipoUsuario.getSelectedIndex() == 2){
					u.setTipoUsuario(1);
				} else if (cmbTipoUsuario.getSelectedIndex() == 3){
					u.setTipoUsuario(0);
				} else {
					u.setTipoUsuario(null);
				}
			}
		});
		cmbTipoUsuario.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				if (cmbTipoUsuario.getSelectedIndex() == 2){
					u.setTipoUsuario(1);
				} else if (cmbTipoUsuario.getSelectedIndex() == 3){
					u.setTipoUsuario(0);
				} else {
					u.setTipoUsuario(null);
				}
			}
		});
		cmbTipoUsuario.setModel(new DefaultComboBoxModel(new String[] {"Seleccione tipo", "", "Común", "Administrador"}));
		cmbTipoUsuario.setBounds(184, 121, 153, 19);
		panelInicioSesion.add(cmbTipoUsuario);
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setBounds(360, 18, 150, 170);
		lblIcono.setIcon(new ImageIcon(MainFrameUI.class.getResource("/imagenes/user-resized.png")));
		panelInicioSesion.add(lblIcono);
		

		btnCerrarSesin = new JButton("Cerrar Sesión");
		btnCerrarSesin.setBounds(790, 73, 180, 50);
		btnCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == btnCerrarSesin){
					
					getContentPane().remove(btnCerrarSesin);
					getContentPane().remove(pU);
					menuBar.remove(mnVuelos);
					
					getContentPane().add(panelInicioSesion);
					getContentPane().add(lblIconoAvion);
					getContentPane().add(lblSistemaDeGestion);

					txtNombreUsuario.setText("");
					txtContrasea.setText("");
					cmbTipoUsuario.setSelectedIndex(0);
					
					txtNombreUsuario.requestFocus();
					
					validate();
					repaint();
				}
			
			}
		});
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					uBo.verificar(u);
					
					ResultSet res = uDao.consultarPorUsuario(u.getNombreUsuario());
				
					uBo.verificarDatosCorrectos(res, u);
					
					remove(panelInicioSesion);
					remove(lblIconoAvion);
					remove(lblSistemaDeGestion);
					
					getContentPane().add(btnCerrarSesin);
					
					pU = new panelUsuario(u);
					pU.setBounds(10, 22, 978, 550);		
					getContentPane().add(pU);
		
					menuBar.add(mnVuelos);
					
					persona = pDao.consultarPorUsuario(u);
					
					if (persona.next()){
						
						pU.getLblDni().setText(pU.getLblDni().getText() + persona.getString("dni"));
						pU.getLblNombre().setText(pU.getLblNombre().getText() + persona.getString("nombre"));
						pU.getLblApellido().setText(pU.getLblApellido().getText() + persona.getString("apellido"));
						pU.getLblUsuario().setText(pU.getLblUsuario().getText() + persona.getString("usuario"));
						pU.getLblEmail().setText(pU.getLblEmail().getText() + persona.getString("email"));
						pU.getLblCiudad().setText(pU.getLblCiudad().getText() + persona.getString("ciudad"));
						pU.getLblPais().setText(pU.getLblPais().getText() + persona.getString("pais"));
						

						if (persona.getInt("tipoUsuario") == 0){
							pU.getLblBienvenido().setText("Bienvenido Administrador!");
							pU.getLblBienvenido().setForeground(Color.RED);	
						}else if (persona.getInt("tipoUsuario") == 1){
							pU.getLblBienvenido().setText("Bienvenido " + persona.getString("nombre") + "!");
							pU.getLblBienvenido().setForeground(Color.BLACK);								
						}
						
						pU.add(pU.getLblBienvenido());
					
					}
					
//					System.out.println(SwingUtilities.getWindowAncestor(pU));			
					
					validate();
					repaint();
					
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos.");
					limpiar();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					limpiar();
				} catch (UserNotValidException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					limpiar();
				} catch (UserNotCorrectException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					limpiar();
				} catch (UserNotExistsException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					limpiar();
				}
			}
		});
		btnIngresar.setBounds(25, 165, 165, 30);
		panelInicioSesion.add(btnIngresar);
		
		JLabel btnaunNoEs = new JLabel("¿Aun no es usuario?");
		btnaunNoEs.setBounds(25, 217, 170, 25);
		panelInicioSesion.add(btnaunNoEs);
		btnaunNoEs.setHorizontalTextPosition(SwingConstants.LEFT);
		btnaunNoEs.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel btnOlvidSuContrasea = new JLabel("¿Olvidó su contraseña?");
		btnOlvidSuContrasea.setHorizontalTextPosition(SwingConstants.LEFT);
		btnOlvidSuContrasea.setHorizontalAlignment(SwingConstants.LEFT);
		btnOlvidSuContrasea.setBounds(25, 244, 170, 25);
		panelInicioSesion.add(btnOlvidSuContrasea);
		
		final JButton btnRegistrese = new JButton("<html><u>Regístrese</u></html>");
		btnRegistrese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnRegistrese){
					DialogRegistrarse dR = new DialogRegistrarse();
					dR.setVisible(true);
				}
			}
		});
		btnRegistrese.setForeground(new Color(0, 0, 205));
		btnRegistrese.setContentAreaFilled(false);
		btnRegistrese.setBorderPainted(false);
		btnRegistrese.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegistrese.setHorizontalTextPosition(SwingConstants.LEFT);
		btnRegistrese.setMargin(new Insets(0, 0, 0, 0));
		btnRegistrese.setBounds(199, 217, 100, 25);
		panelInicioSesion.add(btnRegistrese);
		
		final JButton btnRecuperarla = new JButton("<html><u>Recuperarla</u></html>");
		btnRecuperarla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnRecuperarla){
					DialogMissedPass dM = new DialogMissedPass();
					dM.setVisible(true);
				}
			}
		});
		btnRecuperarla.setMargin(new Insets(0, 0, 0, 0));
		btnRecuperarla.setHorizontalTextPosition(SwingConstants.LEFT);
		btnRecuperarla.setHorizontalAlignment(SwingConstants.LEFT);
		btnRecuperarla.setForeground(new Color(0, 0, 205));
		btnRecuperarla.setContentAreaFilled(false);
		btnRecuperarla.setBorderPainted(false);
		btnRecuperarla.setBounds(199, 244, 100, 25);
		panelInicioSesion.add(btnRecuperarla);
		
	}	

	private void limpiar(){
		txtContrasea.setText("");
		cmbTipoUsuario.setSelectedIndex(0);
		txtNombreUsuario.requestFocus();
	}

	




}