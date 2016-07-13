package org.proyectofinal.ui.plantillasUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import org.proyectofinal.bo.ex.EmailNotValidException;
import org.proyectofinal.bo.ex.NotEqualPasswordException;
import org.proyectofinal.bo.ex.UserNotExistsException;
import org.proyectofinal.bo.impl.PersonaRegistradaBoImpl;
import org.proyectofinal.bo.impl.ReservaViajeBoImpl;
import org.proyectofinal.bo.impl.UsuarioBoImpl;
import org.proyectofinal.bo.interfaces.PersonaRegistradaBo;
import org.proyectofinal.bo.interfaces.ReservaViajeBo;
import org.proyectofinal.bo.interfaces.UsuarioBo;
import org.proyectofinal.model.impl.PersonaRegistradaImpl;
import org.proyectofinal.model.interfaces.PersonaRegistrada;
import org.proyectofinal.model.interfaces.ReservaViaje;
import org.proyectofinal.model.interfaces.Usuario;
import org.proyectofinal.ui.util.Carnet;

import com.itextpdf.text.DocumentException;

public class PlantillaDP extends JDialog {
	
	private static final long serialVersionUID = 6944716547588591882L;
	
	private JPanel panelPersona;
	private JLabel labelAvatar;
	private JLabel lblNomPersona;
	private JLabel lblSaldo;

	private JPanel panelMostrarInfo;
	private JPasswordField txtContraseniaActual;
	private JPasswordField txtNuevaContrasenia;
	private JPasswordField txtConfirmarContrasenia;
	private PersonaRegistrada persona;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private JButton btnGuardarCambiosDatosPersona;
	private JButton btnGuardarCambiosClave;
	String nombre;
	String apellido;
	Carnet c;
	private String ruta;

	public PlantillaDP(){
		
	}

	protected void inicializarAtributos(){
		setTitle("Perfil de usuario");
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setSize(710,550);
		setLocationRelativeTo(null);
		setModal(true);
		
		getContentPane().setLayout(null);
	}
	
	protected void inicializarComponentes(){
		agregarPanelPersona();
		agregarBotones();
		agregarPanelMostrarInfo();
	}

	//PANEL PERSONA
	public void agregarPanelPersona() {
		
		panelPersona = new JPanel();
		panelPersona.setBorder(new MatteBorder(0, 4, 4, 0, (Color) new Color(0, 0, 0)));
		panelPersona.setBounds(20, 20, 200, 200);
		panelPersona.setBackground(new Color(48, 63, 159));
		getContentPane().add(panelPersona);
		panelPersona.setLayout(null);
		
		labelAvatar = new JLabel("");
		labelAvatar.setBounds(40, 15, 120, 120);
		
		ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/avatar.png"));		
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(labelAvatar.getWidth(), labelAvatar.getHeight(), Image.SCALE_DEFAULT));
	
		labelAvatar.setIcon(icono);
		
		panelPersona.add(labelAvatar);
	}
	
	protected void agregarLabelsInfo(PersonaRegistrada pR) {

		lblNomPersona = new JLabel(pR.getNombre() + " " + pR.getApellido());
		lblNomPersona.setBounds(0, 145, 200, 20);
		lblNomPersona.setForeground(Color.WHITE);
		lblNomPersona.setFont(new Font("Arial", Font.BOLD, 16));
		lblNomPersona.setHorizontalAlignment(SwingConstants.CENTER);
		panelPersona.add(lblNomPersona);
				
		lblSaldo = new JLabel("Saldo: " + pR.getSaldo() + " KMS");
		lblSaldo.setBounds(0,170,200,20);
		lblSaldo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaldo.setForeground(new Color(255, 193, 7));
		lblSaldo.setFont(new Font("Arial", Font.BOLD, 14));
		panelPersona.add(lblSaldo);
	}
	
	protected void removerLabelsInfo(){
		panelPersona.remove(lblNomPersona);
		panelPersona.remove(lblSaldo);
	}
	
	//BOTONES
	private void agregarBotones() {
		agregarBotonEstadoCuenta();
		agregarBotonCarnet();
		agregarBotonDatos();
		agregarBotonCambiarClave();
	}
	
	private void agregarBotonEstadoCuenta() {
		JButton btnEstadoCuenta = new JButton("Estado de Cuenta");
		btnEstadoCuenta.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				panelMostrarInfo.removeAll();
				
				PersonaRegistradaBo pRBo = new PersonaRegistradaBoImpl();
				
				PersonaRegistrada pR = pRBo.retornarPersonaPorUsuario(getLabelAvatar().getToolTipText());
				
				ReservaViajeBo rVBo = new ReservaViajeBoImpl();
				
				Integer cantReservas = rVBo.retornarCantidadDeReservas(pR.getDni());
				
				agregarPanelEstadoCuenta(pR, cantReservas);
				
				List<ReservaViaje> listaReservas = rVBo.retornarReservasSegunDni(pR.getDni());
				
				agregarReservas(listaReservas);
				
				panelMostrarInfo.validate();
				panelMostrarInfo.repaint();
			}
		});
		btnEstadoCuenta.setBounds(20, 240, 200, 40);
		getContentPane().add(btnEstadoCuenta);
	}
	
	private void agregarBotonCarnet() {
		
		JButton btnCarnet = new JButton("Carnet Viajero Frecuente");
		btnCarnet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				panelMostrarInfo.removeAll();

				PersonaRegistradaBo pRBo = new PersonaRegistradaBoImpl();
				
				PersonaRegistrada pR = pRBo.retornarPersonaPorUsuario(getLabelAvatar().getToolTipText());
			
				String ruta = "/home/ivang94/workspace/ProyectoFinal/bin/carnets/png/carnet" + pR.getNombre().substring(0, 1) + pR.getApellido().substring(0, 1) + pR.getDni().substring(5) + ".png";
				File fichero = new File(ruta);
				
				c = new Carnet();
				
				if (!fichero.exists()){

					try {

						c.crearCarnet(pR);
											
					} catch (MalformedURLException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (DocumentException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					
				}
				
				agregarPanelCarnet(pR);
				getContentPane().validate();
				getContentPane().repaint();
				
			}
		});
		btnCarnet.setBounds(20, 290, 200, 40);
		getContentPane().add(btnCarnet);
	}

	private void agregarBotonDatos() {
		JButton btnMisDatos = new JButton("Mis Datos");
		btnMisDatos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				panelMostrarInfo.removeAll();
									
				PersonaRegistradaBo pRBo = new PersonaRegistradaBoImpl();

				PersonaRegistrada pR = pRBo.retornarPersonaPorUsuario(getLabelAvatar().getToolTipText());
				
				agregarPanelDatos(pR);
				
				panelMostrarInfo.validate();
				panelMostrarInfo.repaint();
			}
		});
		btnMisDatos.setBounds(20, 340, 200, 40);
		getContentPane().add(btnMisDatos);
	}

	private void agregarBotonCambiarClave() {
		JButton btnCambiarClave = new JButton("Cambiar clave");
		btnCambiarClave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				panelMostrarInfo.removeAll();
				
				try {
					
					UsuarioBo uBo = new UsuarioBoImpl();

					Usuario u = uBo.retornarUsuario(getLabelAvatar().getToolTipText());
					
					agregarPanelCambiarClave(u);

				} catch (UserNotExistsException e1) {
					e1.printStackTrace();
				}
				
				panelMostrarInfo.validate();
				panelMostrarInfo.repaint();
			}
		});
		btnCambiarClave.setBounds(20, 390, 200, 40);
		getContentPane().add(btnCambiarClave);	
	}

	//PANEL MOSTRAR INFO
	private void agregarPanelMostrarInfo() {
		
		panelMostrarInfo = new JPanel();
		panelMostrarInfo.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelMostrarInfo.setBackground(Color.WHITE);
		panelMostrarInfo.setBounds(240, 20, 450, 495);
		getContentPane().add(panelMostrarInfo);
		panelMostrarInfo.setLayout(null);		
	}

	//PANEL ESTADO CUENTA
	private void agregarPanelEstadoCuenta(PersonaRegistrada pR, Integer cantReservas) {
		agregarLabelsEtiquetasPanelEstadoCuenta();
		agregarLabelsInfoPanelEstadoCuenta(pR, cantReservas);
		agregarPanelEtiquetasReservas();
	}
	
	private void agregarLabelsEtiquetasPanelEstadoCuenta() {
		JLabel label1 = new JLabel("Tu saldo es: ");
		label1.setBounds(20, 20, 90, 40);
		panelMostrarInfo.add(label1);
	
		JLabel label2 = new JLabel("Cantidad de reservas realizadas: ");
		label2.setBounds(20, 60, 220, 40);
		panelMostrarInfo.add(label2);
	
		JLabel label3 = new JLabel("Ultimas 10 reservas:");
		label3.setBounds(20, 100, 150, 40);
		panelMostrarInfo.add(label3);
	}
	
	private void agregarLabelsInfoPanelEstadoCuenta(PersonaRegistrada pR, Integer cantReservas) {
		JLabel lblSaldo = new JLabel(pR.getSaldo() + " KMS");
		lblSaldo.setBounds(110, 20, 300, 40);
		panelMostrarInfo.add(lblSaldo);
		
		JLabel lblReservasRealizadas = new JLabel(cantReservas.toString());
		lblReservasRealizadas.setBounds(240, 60, 100, 40);
		panelMostrarInfo.add(lblReservasRealizadas);
	}

	private void agregarPanelEtiquetasReservas() {
		JPanel panelEtiquetasReservas = new JPanel();
		panelEtiquetasReservas.setBounds(20, 150, 410, 25);
		panelEtiquetasReservas.setBackground(Color.WHITE);
		panelMostrarInfo.add(panelEtiquetasReservas);
		panelEtiquetasReservas.setLayout(null);
		
		JLabel label4 = new JLabel("Origen");
		label4.setBorder(new LineBorder(new Color(0, 0, 0)));
		label4.setBounds(0, 0, 160, 25);
		panelEtiquetasReservas.add(label4);
		label4.setHorizontalTextPosition(SwingConstants.CENTER);
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label5 = new JLabel("Destino");
		label5.setBorder(new LineBorder(new Color(0, 0, 0)));
		label5.setBounds(160, 0, 160, 25);
		panelEtiquetasReservas.add(label5);
		label5.setHorizontalTextPosition(SwingConstants.CENTER);
		label5.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label6 = new JLabel("Fecha");
		label6.setBorder(new LineBorder(new Color(0, 0, 0)));
		label6.setBounds(320, 0, 90, 25);
		panelEtiquetasReservas.add(label6);
		label6.setHorizontalTextPosition(SwingConstants.CENTER);
		label6.setHorizontalAlignment(SwingConstants.CENTER);
	}

	public void agregarReservas(List<ReservaViaje> listaReservas){
		
		int i = 0;
		
		for (ReservaViaje reservaViaje : listaReservas) {

			if (i>9){
				break;
			}
			
			agregarPanelInfoReservas(reservaViaje, i);
			i++;
		}
		
	}
	
	private void agregarPanelInfoReservas(ReservaViaje rV, int i) {

		JPanel panelReservas = new JPanel();
		if (i % 2 == 0){
			panelReservas.setBackground(Color.LIGHT_GRAY);
		}else{
			panelReservas.setBackground(Color.WHITE);
		}
		panelReservas.setBounds(20, 175 + (30*i), 410, 30);
		panelMostrarInfo.add(panelReservas);
		panelReservas.setLayout(null);
		
		JLabel lblOrigen = new JLabel(rV.getViaje().getCiudadOrigen() + " (" + rV.getViaje().getPlataformaOrigen() + ")");
		lblOrigen.setBounds(0, 0, 160, 30);
		panelReservas.add(lblOrigen);
		lblOrigen.setHorizontalTextPosition(SwingConstants.CENTER);
		lblOrigen.setHorizontalAlignment(SwingConstants.CENTER);
	
		JLabel lblDestino = new JLabel(rV.getViaje().getCiudadDestino() + " (" + rV.getViaje().getPlataformaDestino() + ")");
		lblDestino.setBounds(160, 0, 160, 30);
		panelReservas.add(lblDestino);
		lblDestino.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDestino.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblFecha = new JLabel(rV.getFechaReserva().toString().substring(8, 10) + "/" + rV.getFechaReserva().toString().substring(5, 7) + "/" + rV.getFechaReserva().toString().substring(0, 4));
		lblFecha.setBounds(320, 0, 90, 30);
		panelReservas.add(lblFecha);
		lblFecha.setHorizontalTextPosition(SwingConstants.CENTER);
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);	
	}
	
	//PANEL CARNET
	private void agregarPanelCarnet(final PersonaRegistrada pR){
		
		JLabel label1 = new JLabel("Carnet Viajero Frecuente AeroManagementPass");
		label1.setBounds(20, 20, 320, 30);
		panelMostrarInfo.add(label1);
		
		JButton btnVerCarnet = new JButton("Ver carnet");
		btnVerCarnet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				verCarnet(pR);
			}
		});
		btnVerCarnet.setBounds(25, 60, 100, 35);
		panelMostrarInfo.add(btnVerCarnet);
		

		JButton btnImprimirCarnet = new JButton("Imprimir carnet");
		btnImprimirCarnet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				imprimirCarnet(pR);
			}
	
		});
		btnImprimirCarnet.setBounds(145, 60, 150, 35);
		panelMostrarInfo.add(btnImprimirCarnet);
	}
	
	private void verCarnet(PersonaRegistrada pR){
		
		JDialog verCarnet = new JDialog();
		verCarnet.setTitle("Carnet AMPass");
		verCarnet.setBounds(100,100,227,142);
		verCarnet.setModal(true);
		verCarnet.setResizable(false);
		verCarnet.setLocationRelativeTo(null);
		verCarnet.getContentPane().setLayout(null);
		
		JLabel lblCarnet = new JLabel("Imagen Carnet");
		lblCarnet.setBounds(0, 0, 227, 142);
	
		String ruta = "/home/ivang94/workspace/ProyectoFinal/bin/carnets/png/carnet"+pR.getNombre().substring(0, 1) + pR.getApellido().substring(0, 1) + pR.getDni().substring(5) + ".png";

		try {
		
			BufferedImage imagen = ImageIO.read(new File(ruta));

			lblCarnet.setIcon(new ImageIcon(imagen));
			
			verCarnet.getContentPane().add(lblCarnet);
			
			verCarnet.setVisible(true);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void imprimirCarnet(PersonaRegistrada pR) {
		
		FileInputStream inputStream = null;
        
		String ruta = "/home/ivang94/workspace/ProyectoFinal/src/carnets/pdf/carnet" + pR.getNombre().substring(0, 1) + pR.getApellido().substring(0, 1) + pR.getDni().substring(5) + ".pdf";
		
		try {
            inputStream = new FileInputStream(ruta);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		
        if (inputStream == null) {
            return;
        }
 
        DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
        
        Doc document = new SimpleDoc(inputStream, docFormat, null);
 
        PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
 
        PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
 
 
        if (defaultPrintService != null) {
            
        	DocPrintJob printJob = defaultPrintService.createPrintJob();
            
            try {
 
            	printJob.print(document, attributeSet);
 
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else {
        	JOptionPane.showMessageDialog(null, "No existen impresoras instaladas");
        }
 
        try {
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//PANEL DATOS
	public void agregarPanelDatos(PersonaRegistrada pR) {
		agregarLabelsPanelDatos();
		agregarCamposPanelDatos(pR);
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

	private void agregarCamposPanelDatos(final PersonaRegistrada pR) {
		
		persona = new PersonaRegistradaImpl();
		
		nombre = pR.getNombre();
		apellido = pR.getApellido();
		
		txtDni = new JTextField(pR.getDni());
		txtDni.setEditable(false);
		txtDni.setBounds(105, 20, 200, 30);
		panelMostrarInfo.add(txtDni);
		
		persona.setDni(txtDni.getText());
	
		txtNombre = new JTextField(pR.getNombre());
		txtNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtNombre.getText().length() > 0){
					persona.setNombre(txtNombre.getText());
				}else{
					txtNombre.setText(pR.getNombre());
				}
			}
		});
		txtNombre.addKeyListener(new KeyAdapter() {	
			@Override
			
			public void keyTyped(KeyEvent e) {			
				controlarCaracteresLetrasApellidoNombre(e);			
			}
			@Override
			public void keyReleased(KeyEvent e) {
				persona.setNombre(txtNombre.getText());
			}
		});
		txtNombre.setBounds(105, 60, 200, 30);
		panelMostrarInfo.add(txtNombre);
	
		txtApellido = new JTextField(pR.getApellido());
		txtApellido.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtApellido.getText().length() > 0){
					persona.setApellido(txtApellido.getText());
				}else{
					txtApellido.setText(pR.getApellido());
				}
			}
		});
		txtApellido.addKeyListener(new KeyAdapter() {	
			@Override
			public void keyTyped(KeyEvent e) {			
				controlarCaracteresLetrasApellidoNombre(e);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				persona.setApellido(txtApellido.getText());
			}
		});
		txtApellido.setBounds(105, 100, 200, 30);
		panelMostrarInfo.add(txtApellido);
		
		txtEmail = new JTextField(pR.getEmail());
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtEmail.getText().length() > 0){
					persona.setEmail(txtEmail.getText());
				}else{
					txtEmail.setText(pR.getEmail());
				}
			}
		});
		txtEmail.addKeyListener(new KeyAdapter() {	
			@Override
			public void keyReleased(KeyEvent e) {
				persona.setEmail(txtEmail.getText());
			}
		});
		txtEmail.setBounds(105, 140, 200, 30);
		panelMostrarInfo.add(txtEmail);
	
		txtTelefono = new JTextField(pR.getTelefono());
		txtTelefono.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtTelefono.getText().length() > 0){
					persona.setTelefono(txtTelefono.getText());
				}else{
					txtTelefono.setText(pR.getTelefono());
				}
			}
		});
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {			
				controlarCaracteresNumericos(e);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				persona.setTelefono(txtTelefono.getText());
			}
		});
		txtTelefono.setBounds(105, 180, 200, 30);
		panelMostrarInfo.add(txtTelefono);
	}

	private void agregarBotonPanelDatos() {
		btnGuardarCambiosDatosPersona = new JButton("Guardar cambios");
		btnGuardarCambiosDatosPersona.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (persona.getNombre() == null){
					persona.setNombre(txtNombre.getText());
				}
				
				if (persona.getApellido() == null){
					persona.setApellido(txtApellido.getText());
				}
				
				if (persona.getEmail() == null){
					persona.setEmail(txtEmail.getText());
				}
				
				if (persona.getTelefono() == null){
					persona.setTelefono(txtTelefono.getText());
				}
				
				PersonaRegistradaBo pRBo = new PersonaRegistradaBoImpl();
				
				try {
				
					pRBo.verificarEmail(persona);

					pRBo.modificarPersona(persona);
					
					JOptionPane.showMessageDialog(null, "Se ha modificado los datos de la persona con exito!");
					
					PersonaRegistrada p = pRBo.retornarPersonaPorUsuario(getLabelAvatar().getToolTipText());
		
					txtNombre.setText(p.getNombre());
					txtApellido.setText(p.getApellido());
					txtEmail.setText(p.getEmail());
					txtTelefono.setText(p.getTelefono());		
					
					nombre = p.getNombre();
					apellido = p.getApellido();
					
					if (!nombre.equals(persona.getNombre()) || !apellido.equals(persona.getApellido())) {

						c = new Carnet();
						
						try {
							c.crearCarnet(persona);
						} catch (MalformedURLException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						} catch (DocumentException e1) {
							e1.printStackTrace();
						}
					}
				
				} catch (EmailNotValidException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}

			}
		});
		btnGuardarCambiosDatosPersona.setBounds(25, 230, 155, 40);
		panelMostrarInfo.add(btnGuardarCambiosDatosPersona);
	}
	
	private void controlarCaracteresLetrasApellidoNombre(KeyEvent e) {
		
		char c = e.getKeyChar();
		
		if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_BACK_SPACE)){
			e.consume();
		}
	}
	
	private void controlarCaracteresNumericos(KeyEvent e) {
		
		char c = e.getKeyChar();
		
		if ((c < '0' || c > '9') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_SPACE) && (c != KeyEvent.VK_BACK_SPACE) || txtTelefono.getText().length() == 11){
			e.consume();
		}
	}
	
	//PANEL CAMBIAR CLAVE
	private void agregarPanelCambiarClave(Usuario u) {
		agregarLabelsPanelCambiarClave();
		agregarCamposPanelCambiarClave(u);
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

	private void agregarCamposPanelCambiarClave(Usuario u) {
		txtContraseniaActual = new JPasswordField(u.getPassword());
		txtContraseniaActual.setEditable(false);
		txtContraseniaActual.setBounds(220, 20, 200, 30);
		panelMostrarInfo.add(txtContraseniaActual);
		
		txtNuevaContrasenia = new JPasswordField();
		txtNuevaContrasenia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {			
				setearEstadoTxtConfirmarContrasenia();
			}
		});
		txtNuevaContrasenia.setBounds(220, 60, 200, 30);
		panelMostrarInfo.add(txtNuevaContrasenia);
		
		txtConfirmarContrasenia = new JPasswordField();
		txtConfirmarContrasenia.setEnabled(false);
		txtConfirmarContrasenia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				setearEstadoBtnGuardarClave();
			}
		});
		txtConfirmarContrasenia.setBounds(220, 100, 200, 30);
		panelMostrarInfo.add(txtConfirmarContrasenia);
	}

	private void agregarBotonPanelCambiarClave() {
		btnGuardarCambiosClave = new JButton("Guardar cambios");
		btnGuardarCambiosClave.setEnabled(false);
		btnGuardarCambiosClave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (txtNuevaContrasenia.getPassword().length > 0){
					
					try {
						
						UsuarioBo uBo = new UsuarioBoImpl();
						
						uBo.controlarNuevaContrasenia(txtNuevaContrasenia.getPassword(), txtConfirmarContrasenia.getPassword());
						
						String contraseña = new String(txtNuevaContrasenia.getPassword());
						
						uBo.modificarContrasenia(contraseña, getLabelAvatar().getToolTipText());
						
						JOptionPane.showMessageDialog(null, "Se ha modificado la clave con exito!");
						
						Usuario u = uBo.retornarUsuario(getLabelAvatar().getToolTipText());
						
						txtContraseniaActual.setText(u.getPassword());
						
						limpiarContrasenia();
					
					} catch (NotEqualPasswordException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
						limpiarContrasenia();
					} catch (UserNotExistsException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					
				}
			}
		});
		btnGuardarCambiosClave.setBounds(25, 150, 155, 40);
		panelMostrarInfo.add(btnGuardarCambiosClave);
	}

	private void setearEstadoTxtConfirmarContrasenia() {
		if (txtNuevaContrasenia.getPassword().length > 0) {
			txtConfirmarContrasenia.setEnabled(true);
		}else{
			txtConfirmarContrasenia.setText("");
			txtConfirmarContrasenia.setEnabled(false);
			if (btnGuardarCambiosClave.isEnabled()){
				btnGuardarCambiosClave.setEnabled(false);
			}
		}
	}
	
	private void setearEstadoBtnGuardarClave() {
		if (txtConfirmarContrasenia.getPassword().length > 0){
			btnGuardarCambiosClave.setEnabled(true);
		}else{
			btnGuardarCambiosClave.setEnabled(false);
		}
	}
	
	private void limpiarContrasenia(){
		txtNuevaContrasenia.setText("");
		txtConfirmarContrasenia.setText("");
		txtConfirmarContrasenia.setEnabled(false);
		btnGuardarCambiosClave.setEnabled(false);
	}
	
	public JLabel getLabelAvatar() {
		return labelAvatar;
	}

	public void setLabelAvatar(JLabel labelAvatar) {
		this.labelAvatar = labelAvatar;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

}