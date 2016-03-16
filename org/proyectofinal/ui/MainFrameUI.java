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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.proyectofinal.bo.impl.UsuarioBoImpl;
import org.proyectofinal.bo.interfaces.UsuarioBo;
import org.proyectofinal.dao.ex.UserNotCorrectException;
import org.proyectofinal.dao.ex.UserNotExistsException;
import org.proyectofinal.dao.ex.UserNotValidException;
import org.proyectofinal.dao.impl.PersonaDaoImpl;
import org.proyectofinal.dao.impl.UsuarioDaoImpl;
import org.proyectofinal.dao.impl.ViajeCabeceraDaoImpl;
import org.proyectofinal.dao.interfaces.PersonaDao;
import org.proyectofinal.dao.interfaces.UsuarioDao;
import org.proyectofinal.dao.interfaces.ViajeCabeceraDao;
import org.proyectofinal.model.impl.UsuarioImpl;
import org.proyectofinal.model.interfaces.Usuario;
import org.proyectofinal.ui.util.AccionTableCellRenderer;
import org.proyectofinal.ui.util.CeldaAccionEditor;

public class MainFrameUI extends JFrame {

	private static final long serialVersionUID = 3667571948857412383L;
	
	private panelUsuario pU;
	private DialogCambiarDatos dCD;
//	private panelIniciio pI;
	private JTextField txtNombreUsuario;
	private JPasswordField txtContrasea;
	private JButton btnCerrarSesin;
	private JButton btnCambiarDatosPersonales;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbTipoUsuario;
	private UsuarioBo uBo;
	private UsuarioDao uDao;
	private PersonaDao pDao;
	private ResultSet persona;
	private Usuario u;
	private ResultSet r;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrameUI frame = new MainFrameUI();
					frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				String ObjButtons[] = {"Si","No"};
			    
				int PromptResult = JOptionPane.showOptionDialog(null, 
			        "Estas seguro que deseas salir?", "Advertencia", 
			        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, 
			        ObjButtons,ObjButtons[1]);
			    
				if(PromptResult == 0) {
					System.exit(0);          
			    }
			}
		});
		
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
				
				if (pU instanceof panelUsuario){
					
					try {
						
						r = pDao.consultarPorUsuario(u);
						
						if (r.next()) {
							
							if (!r.getString("nombre").equals(pU.getLblNombre().getText())){
								pU.getLblNombre().setText(r.getString("nombre"));
							}
							if (!r.getString("apellido").equals(pU.getLblApellido().getText())){
								pU.getLblApellido().setText(r.getString("apellido"));
							}
							if (!r.getString("email").equals(pU.getLblEmail().getText())){
								pU.getLblEmail().setText(r.getString("email"));
							}
							if (!r.getString("telefono").equals(pU.getLblTelefono().getText())){
								pU.getLblTelefono().setText(r.getString("telefono"));
							}
							if (!r.getString("ciudad").equals(pU.getLblCiudad().getText())){
								pU.getLblCiudad().setText(r.getString("ciudad"));
							}
							if (!r.getString("pais").equals(pU.getLblPais().getText())){
								pU.getLblPais().setText(r.getString("pais"));	
							}
							if (!r.getString("dni").equals(pU.getLblDni().getText())){
								pU.getLblDni().setText(r.getString("dni"));							
							}
							
						}

						pU.getLblTelefono().validate();
						pU.getLblTelefono().repaint();
					
						pU.getLblNombre().validate();
						pU.getLblNombre().repaint();
						
						pU.getLblApellido().validate();
						pU.getLblApellido().repaint();
						
						pU.getLblEmail().validate();
						pU.getLblEmail().repaint();
						
						pU.getLblCiudad().validate();
						pU.getLblCiudad().repaint();
						
						pU.getLblPais().validate();
						pU.getLblPais().repaint();

						pU.getLblDni().validate();
						pU.getLblDni().repaint();

					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
//						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
//						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} finally {
						try {
							r.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
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
					
					String ObjButtons[] = {"Si","No"};
				    
					int PromptResult = JOptionPane.showOptionDialog(null, 
				        "Estas seguro que deseas salir?", "Advertencia", 
				        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, 
				        ObjButtons,ObjButtons[1]);
				    
					if(PromptResult == 0)
				    {
						System.exit(0);          
				    }
					
				}
			}
		});
		mnArchivo.add(mntmSalir);
		
		final JMenu mnVuelos = new JMenu("Vuelos");
		
		final JMenuItem mntmVerListado = new JMenuItem("Ver Listado..");
		mntmVerListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == mntmVerListado){
					
					try {

						final ListadoVuelosUI ui = new ListadoVuelosUI(u);
						
						if (u.getTipoUsuario() == 1){
							SwingUtilities.invokeLater(new Runnable() {
							    @Override public void run() {
							        ui.getTable().removeColumn(ui.getTable().getColumnModel().getColumn(6));
							    }
							});
						}
						
						ui.ocultarCampos();
						
						DefaultTableModel model = (DefaultTableModel) ui.getTable().getModel();
						
						int a = model.getRowCount() - 1;
						
						for(int i = a; i >= 0; i--){
							model.removeRow(0);
						}
						
						Object[] fila = null;
						
						if (u.getTipoUsuario() == 0){
							fila = new Object[8];
						}else if (u.getTipoUsuario() == 1){
							fila = new Object[6];
						}
						
						ViajeCabeceraDao vCDao = new ViajeCabeceraDaoImpl();
						
						vCDao.conectar();

						ResultSet res = vCDao.consultar();
						
						String fecha = "";

						while (res.next()){

							fila[0] = res.getInt("codViaje");
							fila[1] = res.getString("ciudadOrigen") + ", " + res.getString("paisOrigen");
							fila[2] = res.getString("ciudadDestino") + ", " + res.getString("paisDestino");							
						
							fecha = res.getDate("fechaSalida").toString().substring(8, 10) + "-" + res.getDate("fechaSalida").toString().substring(5, 7) + "-" + res.getDate("fechaSalida").toString().substring(0, 4);
							
							fila[3] = fecha + " " + res.getTime("horaSalida").toString().substring(0, 5);
							
							fecha = res.getDate("fechaLlegada").toString().substring(8, 10) + "-" + res.getDate("fechaLlegada").toString().substring(5, 7) + "-" + res.getDate("fechaLlegada").toString().substring(0, 4);
							
							fila[4] = fecha + " " + res.getTime("horaLlegada").toString().substring(0, 5);
							
							fila[5] = res.getInt("cupo");
							
							if (u.getTipoUsuario() == 0){
								ui.getTable().getColumnModel().getColumn(6).setCellRenderer(new AccionTableCellRenderer());
								ui.getTable().getColumnModel().getColumn(6).setCellEditor(new CeldaAccionEditor());
							}
							
							model.addRow(fila);					
						}
						
						vCDao.desconectar();
					
						if (u.getTipoUsuario() == 0){
							ui.setSize(970,380);
						}else if (u.getTipoUsuario() == 1){
							ui.remove(ui.getBtnAgregar());
							ui.setSize(970,330);
						}
						
						ui.setLocationRelativeTo(null);
						ui.setResizable(false);
						
						ui.validate();
						ui.repaint();
						
						ui.setVisible(true);

					} catch (ClassNotFoundException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					
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
		
		ImageIcon iconAvion = new ImageIcon(MainFrameUI.class.getResource("/imagenes/avion4.png"));
		iconAvion.setDescription("Avion");
		lblIconoAvion.setIcon(iconAvion);
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
		cmbTipoUsuario.setModel(new DefaultComboBoxModel(new String[] {"Seleccione tipo", "-----------------------", "Común", "Administrador"}));
		cmbTipoUsuario.setBounds(184, 121, 153, 19);
		panelInicioSesion.add(cmbTipoUsuario);
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setBounds(360, 18, 150, 170);
		lblIcono.setIcon(new ImageIcon(MainFrameUI.class.getResource("/imagenes/user-resized.png")));
		panelInicioSesion.add(lblIcono);
		
		final JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					uBo.verificar(u);
					
					ResultSet res = uDao.consultarPorUsuario(u.getNombreUsuario());
				
					if (res.next()){
						u.setFechaInicio(res.getTimestamp("fechaInicio"));
					}
					
					uBo.verificarDatosCorrectos(res, u);
					
					remove(panelInicioSesion);
					remove(lblIconoAvion);
					remove(lblSistemaDeGestion);
					
					getContentPane().add(btnCerrarSesin);
					getContentPane().add(btnCambiarDatosPersonales);
					
					pU = new panelUsuario(u);
					pU.setBounds(10, 22, 978, 550);		
					getContentPane().add(pU);
		
					menuBar.add(mnVuelos);
						
					persona = pDao.consultarPorUsuario(u);
				
					if (persona.next()){
						
						pU.getLblNombre().setText(persona.getString("nombre"));
						pU.getLblApellido().setText(persona.getString("apellido"));
						pU.getLblEmail().setText(persona.getString("email"));
						pU.getLblTelefono().setText(persona.getString("telefono"));
						pU.getLblCiudad().setText(persona.getString("ciudad"));
						pU.getLblPais().setText(persona.getString("pais"));
						pU.getLblDni().setText(persona.getString("dni"));

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
					
				}catch (UserNotValidException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					limpiar();
				} catch (UserNotCorrectException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					limpiar();
				} catch (UserNotExistsException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					limpiar();
				} catch (SQLException e1) {
	//				e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
					limpiar();
				} catch (ClassNotFoundException e1) {
	//				e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos.");
					limpiar();
				} finally {
					try {
						if (persona != null){
							persona.close();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}
				
			}
		});
		btnIngresar.setBounds(25, 165, 165, 30);
		panelInicioSesion.add(btnIngresar);
		
		getRootPane().setDefaultButton(btnIngresar);

		btnCerrarSesin = new JButton("Cerrar Sesión");
		btnCerrarSesin.setBounds(790, 73, 180, 50);
		btnCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == btnCerrarSesin){
					
					getContentPane().remove(btnCerrarSesin);
					getContentPane().remove(btnCambiarDatosPersonales);
					getContentPane().remove(pU);
					menuBar.remove(mnVuelos);
					
					getContentPane().add(panelInicioSesion);
					getContentPane().add(lblIconoAvion);
					getContentPane().add(lblSistemaDeGestion);
					
					getRootPane().setDefaultButton(btnIngresar);

					txtNombreUsuario.setText("");
					txtContrasea.setText("");
					cmbTipoUsuario.setSelectedIndex(0);
					
					txtNombreUsuario.requestFocus();
					
					validate();
					repaint();
				}
			
			}
		});
		
		btnCambiarDatosPersonales = new JButton("<html><center>Cambiar<br />datos<br />personales<center></html>");
		btnCambiarDatosPersonales.setBounds(790, 140, 180, 70);
		btnCambiarDatosPersonales.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == btnCambiarDatosPersonales){
					
					dCD = new DialogCambiarDatos(u);
	
					try {
						
						persona = pDao.consultarPorUsuario(u);
						
						if (persona.next()){
							
							dCD.getTxtNombre().setText(dCD.getTxtNombre().getText() + persona.getString("nombre"));
							dCD.getTxtApellido().setText(dCD.getTxtApellido().getText() + persona.getString("apellido"));
							dCD.getTxtEmail().setText(dCD.getTxtEmail().getText() + persona.getString("email"));
							dCD.getTxtTelefono().setText(dCD.getTxtTelefono().getText() + persona.getString("telefono"));
							dCD.getDateChooserNacimiento().setDate(persona.getDate("fechaNacimiento"));
							dCD.getTxtPais().setText(dCD.getTxtPais().getText() + persona.getString("pais"));
							dCD.getTxtCiudad().setText(dCD.getTxtCiudad().getText() + persona.getString("ciudad"));
							
							dCD.getTxtUsuario().setText(dCD.getTxtUsuario().getText() + persona.getString("usuario"));
							dCD.getTxtPassword().setText(dCD.getTxtPassword().getText() + persona.getString("contrasenia"));
							
							dCD.getTxtDni().setText(dCD.getTxtDni().getText() + persona.getString("dni"));
						}
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
//						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
//						JOptionPane.showMessageDialog(null, e1.getMessage());
					} 
					finally {
						try {
							if (persona != null){
								persona.close();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					dCD.setVisible(true);
				}
			
			}
		});
		
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
//	
//	private ImageIcon createImageIcon(String path, String description){
//		
//		ImageIcon icon = new ImageIcon(MainFrameUI.class.getResource(path));
//		
//		icon.setDescription(description);
//		
//		return icon;
//		
//	}
	
}

