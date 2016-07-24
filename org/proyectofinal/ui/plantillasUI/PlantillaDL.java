package org.proyectofinal.ui.plantillasUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.proyectofinal.bo.ex.UserNotExistsException;
import org.proyectofinal.bo.ex.UserNotValidException;
import org.proyectofinal.bo.impl.UsuarioBoImpl;
import org.proyectofinal.bo.interfaces.UsuarioBo;
import org.proyectofinal.model.impl.UsuarioImpl;
import org.proyectofinal.model.interfaces.Usuario;
import org.proyectofinal.ui.DialogMissedPass;
import org.proyectofinal.ui.DialogRegistrarse;

public class PlantillaDL extends JDialog {
	
	private static final long serialVersionUID = -6234766295289047065L;
	
	JTextField txtUsuario;
	JPasswordField txtContrasea;
	JButton btnIngresar;
	private Usuario u;
	UsuarioBo uBo;
	
	public PlantillaDL(){
	}
	
	protected void inicializarAtributos(){
		setResizable(false);
		setTitle("Iniciar Sesión");
		getContentPane().setBackground(Color.WHITE);
		setModal(true);
		setBounds(new Rectangle(0, 0, 310, 450));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
	}
	
	protected void inicializarComponentes(){
		agregarLabels();
		agregarCampos();
		agregarBotones();
	}
	
	private void agregarLabels(){
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setHorizontalTextPosition(SwingConstants.CENTER);
		lblImagen.setBounds(107, 20, 96, 96);
		
		ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/avatar.png"));
		
		Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(),java.awt.Image.SCALE_DEFAULT));
	
		lblImagen.setIcon(icon);
		getContentPane().add(lblImagen);
		
		JLabel lblUsuario = new JLabel("Nombre de usuario:");
		lblUsuario.setLabelFor(txtUsuario);
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(15, 132, 284, 39);
		lblUsuario.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setLabelFor(txtContrasea);
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setHorizontalTextPosition(SwingConstants.CENTER);
		lblContrasea.setBounds(15, 236, 284, 39);
		lblContrasea.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		getContentPane().add(lblContrasea);
	}
	
	private void agregarCampos() {

		u = new UsuarioImpl();
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(45, 176, 220, 30);
		txtUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				setearUsuario();
			}
			
		});
		txtUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				setearUsuario();
			}
		});
		txtUsuario.setFont(new Font("Roboto Regular", Font.PLAIN, 14));
		getContentPane().add(txtUsuario);

		txtContrasea = new JPasswordField();
		txtContrasea.setBounds(45, 280, 220, 30);
		txtContrasea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				setearPass();
			}
		});
		txtContrasea.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				setearPass();
			}
		});
		txtContrasea.setFont(new Font("Roboto Regular", Font.PLAIN, 14));
		getContentPane().add(txtContrasea);		
	}
	
	private void agregarBotones() {
		
		uBo = new UsuarioBoImpl();
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(75, 355, 160, 40);
		btnIngresar.setBackground(new Color(0,100,90));
		btnIngresar.setFont(new Font("Roboto Regular", Font.PLAIN, 18));
		btnIngresar.setForeground(Color.WHITE);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					
					uBo.verificar(u);
					
					uBo.verificarDatosCorrectos(u);
					
					dispose();
						
				} catch (UserNotValidException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (UserNotExistsException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}
		});
		getContentPane().add(btnIngresar);
		getRootPane().setDefaultButton(btnIngresar);
	
		JButton btnUsuarioNuevo = new JButton("¿Es la primera vez que ingresa?");
		btnUsuarioNuevo.setMargin(new Insets(2, 0, 2, 0));
		btnUsuarioNuevo.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {			
				registrar();
			}			
		});
		btnUsuarioNuevo.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnUsuarioNuevo.setForeground(new Color(27,0,136));
		btnUsuarioNuevo.setContentAreaFilled(false);
		btnUsuarioNuevo.setBorderPainted(false);
		btnUsuarioNuevo.setBounds(40, 206, 250, 30);
		btnUsuarioNuevo.setFont(new Font("Roboto Thin", Font.BOLD, 12));
		getContentPane().add(btnUsuarioNuevo);
		
		JButton btnOlvidoSuContrasea = new JButton("¿Olvidó su contraseña?");
		btnOlvidoSuContrasea.setMargin(new Insets(2, 0, 2, 0));
		btnOlvidoSuContrasea.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {				
				recuperarPass();				
			}
		});
		btnOlvidoSuContrasea.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnOlvidoSuContrasea.setForeground(new Color(27,0,136));
		btnOlvidoSuContrasea.setContentAreaFilled(false);
		btnOlvidoSuContrasea.setBorderPainted(false);
		btnOlvidoSuContrasea.setBounds(65, 310, 250, 30);
		btnOlvidoSuContrasea.setFont(new Font("Roboto Thin", Font.BOLD, 12));
		getContentPane().add(btnOlvidoSuContrasea);
	}

	private void registrar() {
		DialogRegistrarse ui = new DialogRegistrarse();
		ui.setVisible(true);
	}
	
	private void recuperarPass(){
		DialogMissedPass d = new DialogMissedPass();
		d.setVisible(true);
	}
	
	private void setearUsuario() {
		
		if (txtUsuario.getText().trim().length() > 0){
			u.setNombreUsuario(txtUsuario.getText());
		}else{
			u.setNombreUsuario("");
		}
	}

	private void setearPass() {
		
		String pass = new String(txtContrasea.getPassword());
		
		if (pass.trim().length() > 0){
			u.setPassword(pass);
		}else{
			u.setPassword("");
		}
	}
	
	public Usuario getUsuario() {
		return u;
	}

	public void setUsuario(Usuario u) {
		this.u = u;
	}

}