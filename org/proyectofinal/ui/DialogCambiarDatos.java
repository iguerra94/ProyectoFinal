package org.proyectofinal.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.proyectofinal.dao.impl.PersonaDaoImpl;
import org.proyectofinal.dao.impl.UsuarioDaoImpl;
import org.proyectofinal.dao.interfaces.PersonaDao;
import org.proyectofinal.dao.interfaces.UsuarioDao;
import org.proyectofinal.model.impl.BotonEditar;
import org.proyectofinal.model.impl.PersonaImpl;
import org.proyectofinal.model.impl.UsuarioImpl;
import org.proyectofinal.model.interfaces.Persona;
import org.proyectofinal.model.interfaces.Usuario;

import com.toedter.calendar.JDateChooser;

public class DialogCambiarDatos extends JDialog {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7726925233817947202L;

	private Usuario u;
	private Persona p;
	private ResultSet r;
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
	public DialogCambiarDatos(final Usuario user) {

		p = new PersonaImpl();
		u = new UsuarioImpl();

		pDao = new PersonaDaoImpl();
		uDao = new UsuarioDaoImpl();

		try {
			r = pDao.consultarPorUsuario(user);
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		setResizable(false);
		setSize(510,507);
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
		txtDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if ((c >= '0' && c <= '9') || (c == KeyEvent.VK_KP_LEFT) || (c == KeyEvent.VK_KP_RIGHT) || (c == KeyEvent.VK_BACK_SPACE)){
					btnGuardarCambios.setEnabled(true);
					
					p.setDni(txtDni.getText());					
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
		txtDni.setEnabled(false);
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
					p.setNombre(txtNombre.getText());
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
		txtNombre.setEnabled(false);
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
					p.setApellido(txtApellido.getText());
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
		txtApellido.setEnabled(false);
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
					p.setEmail(txtEmail.getText());
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
		txtEmail.setEnabled(false);
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
		txtTelefono.setEnabled(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(185, 150, 187, 19);
		panelDatosPersona.add(txtTelefono);
		
		txtPais = new JTextField();
		txtPais.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c == KeyEvent.VK_KP_LEFT) || (c == KeyEvent.VK_KP_RIGHT) || (c == KeyEvent.VK_BACK_SPACE)){
					btnGuardarCambios.setEnabled(true);
					p.setPais(txtPais.getText());
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_BACK_SPACE)){
					e.consume();
				}
			}
		});
		txtPais.setEnabled(false);
		txtPais.setColumns(10);
		txtPais.setBounds(185, 210, 187, 19);
		panelDatosPersona.add(txtPais);
		
		txtCiudad = new JTextField();
		txtCiudad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c == KeyEvent.VK_KP_LEFT) || (c == KeyEvent.VK_KP_RIGHT) || (c == KeyEvent.VK_BACK_SPACE)){
					btnGuardarCambios.setEnabled(true);
					p.setCiudad(txtCiudad.getText());
				}			
			}
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_BACK_SPACE)){
					e.consume();
				}
			}
		});
		txtCiudad.setEnabled(false);
		txtCiudad.setColumns(10);
		txtCiudad.setBounds(185, 240, 187, 19);
		panelDatosPersona.add(txtCiudad);
		
		dateChooserNacimiento = new JDateChooser();
		dateChooserNacimiento.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				btnGuardarCambios.setEnabled(true);
				p.setFechaNacimiento(new Date(dateChooserNacimiento.getDate().getTime()));
			}
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if ((c < '0' || c > '9') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_BACK_SPACE) && (c != KeyEvent.VK_SLASH)){
					e.consume();
				}
			}
		});
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
						
						try {
							
							while (r.next()){
								txtDni.setText(r.getString("dni"));
							}
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						txtDni.setEnabled(false);
						btnEditarDni.setEstado(false);
						btnGuardarCambios.setEnabled(false);
						
						txtDni.validate();
						txtDni.repaint();
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
						
						try {
							
							while (r.next()){
								txtNombre.setText(r.getString("nombre"));
							}
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} finally {
							try {
								r.close();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
						txtNombre.setEnabled(false);
						btnEditarNombre.setEstado(false);
						btnGuardarCambios.setEnabled(false);
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
						
						try {
							
							while (r.next()){
								txtApellido.setText(r.getString("apellido"));
							}
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} finally {
							try {
								r.close();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
						txtApellido.setEnabled(false);
						btnEditarApellido.setEstado(false);
						btnGuardarCambios.setEnabled(false);
						
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
						
						try {
							
							while (r.next()){
								txtEmail.setText(r.getString("email"));
							}
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} finally {
							try {
								r.close();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
						txtEmail.setEnabled(false);
						btnEditarEmail.setEstado(false);
						btnGuardarCambios.setEnabled(false);
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
						
						try {
							
							while (r.next()){
								txtTelefono.setText(r.getString("telefono"));
							}
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} finally {
							try {
								r.close();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
						txtTelefono.setEnabled(false);
						btnEditarTelefono.setEstado(false);
						btnGuardarCambios.setEnabled(false);
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
						
						try {
							
							while (r.next()){
								dateChooserNacimiento.setDate(r.getDate("fechaNacimiento"));
							}
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} finally {
							try {
								r.close();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
						dateChooserNacimiento.setEnabled(false);
						btnEditarNacimiento.setEstado(false);
						btnGuardarCambios.setEnabled(false);
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
						
						try {
							
							while (r.next()){
								txtPais.setText(r.getString("pais"));
							}
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} finally {
							try {
								r.close();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
						txtPais.setEnabled(false);
						btnEditarPais.setEstado(false);
						btnGuardarCambios.setEnabled(false);
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
						
						try {
							
							while (r.next()){
								txtCiudad.setText(r.getString("ciudad"));
							}
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} finally {
							try {
								r.close();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
						txtCiudad.setEnabled(false);
						btnEditarCiudad.setEstado(false);
						btnGuardarCambios.setEnabled(false);
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
		txtUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			
				char c = e.getKeyChar();
				
				if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || (c == KeyEvent.VK_KP_LEFT) || (c == KeyEvent.VK_KP_RIGHT) || (c == KeyEvent.VK_BACK_SPACE)){
					btnGuardarCambios.setEnabled(true);
					u.setNombreUsuario(txtUsuario.getText());
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
		txtUsuario.setEnabled(false);
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(185, 30, 187, 19);
		panelDatosUsuario.add(txtUsuario);
		
		txtPassword = new JPasswordField();		
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || (c == KeyEvent.VK_KP_LEFT) || (c == KeyEvent.VK_KP_RIGHT) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_PERIOD) || (c == KeyEvent.VK_COMMA)){
					btnGuardarCambios.setEnabled(true);
					u.setPassword(txtPassword.getPassword().toString());
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
						
						try {
							
							while (r.next()){
								txtUsuario.setText(r.getString("usuario"));
							}
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} finally {
							try {
								r.close();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
						txtUsuario.setEnabled(false);
						btnEditarUsuario.setEstado(false);
						btnGuardarCambios.setEnabled(false);
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
						
						try {
							
							while (r.next()){
								txtPassword.setText(r.getString("contrasenia"));
							}
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} finally {
							try {
								r.close();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
						txtPassword.setEnabled(false);
						btnEditarContrasenia.setEstado(false);
						btnGuardarCambios.setEnabled(false);
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
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == btnGuardarCambios){
					
					try {
						
						while (r.next()) {
						
							if (!r.getString("dni").equals(p.getDni())){
								pDao.modificacion("dni", p.getDni(), r.getString("dni")); 						
							}
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
//							if (!r.getDate("fechaNacimiento").equals(p.getFechaNacimiento())){	
//								pDao.modificacion("fechaNacimiento", p.getFechaNacimiento().toString(), r.getString("dni"));							
//							}
							if (!r.getString("pais").equals(p.getPais())){	
								pDao.modificacion("pais", p.getPais(), r.getString("dni"));							
							}
							if (!r.getString("ciudad").equals(p.getCiudad())){							
								pDao.modificacion("ciudad", p.getCiudad(), r.getString("dni"));
							}
							if (!r.getString("usuario").equals(u.getNombreUsuario())) {	
								uDao.modificacion("usuario", u.getNombreUsuario(), r.getString("usuario"));						
							}
							if (!r.getString("contrasenia").equals(u.getPassword())) {	
								uDao.modificacion("contrasenia", u.getPassword(), r.getString("usuario"));							
							}

						}

						JOptionPane.showMessageDialog(null, "Se ha modificado la informacion personal con exito!"); 
						setVisible(false);
						
					}
					catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			}
		});
		btnGuardarCambios.setEnabled(false);
		btnGuardarCambios.setBounds(24, 470, 156, 25);
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