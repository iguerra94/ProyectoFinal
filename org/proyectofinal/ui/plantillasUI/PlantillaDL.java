package org.proyectofinal.ui.plantillasUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Window;
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
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.proyectofinal.bo.impl.UsuarioBoImpl;
import org.proyectofinal.bo.interfaces.UsuarioBo;
import org.proyectofinal.dao.ex.UserNotCorrectException;
import org.proyectofinal.dao.ex.UserNotValidException;
import org.proyectofinal.model.impl.UsuarioImpl;
import org.proyectofinal.model.interfaces.Usuario;
import org.proyectofinal.ui.DialogMissedPass;
import org.proyectofinal.ui.MainFrameUI;

public class PlantillaDL extends JDialog {
	
	private JTextField txtUsuario;
	private JPasswordField txtContrasea;
	private JComboBox cmbTipoUsuario;
	private JButton btnIngresar;
	private JButton btnOlvidoSuContrasea;
	private Usuario u;
	private UsuarioBo uBo;
	
	public PlantillaDL(){
		
	}
	
	protected void inicializarAtributos(){
		setResizable(false);
		setTitle("Iniciar Sesión");
		getContentPane().setBackground(Color.WHITE);
		setModal(true);
		setBounds(new Rectangle(0, 0, 310, 480));
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
		
		JLabel lblUsuario = new JLabel("USUARIO:");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(15, 132, 284, 39);
		getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("CONTRASEÑA:");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setHorizontalTextPosition(SwingConstants.CENTER);
		lblContrasea.setBounds(15, 212, 284, 39);
		getContentPane().add(lblContrasea);
		
		JLabel lblTipoUsuario = new JLabel("TIPO DE USUARIO:");
		lblTipoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoUsuario.setBounds(15, 318, 284, 39);
		getContentPane().add(lblTipoUsuario);
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
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);

		txtContrasea = new JPasswordField();
		txtContrasea.setBounds(45, 256, 220, 30);
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
		getContentPane().add(txtContrasea);
		
		cmbTipoUsuario = new JComboBox();
		cmbTipoUsuario.setAlignmentX(Component.RIGHT_ALIGNMENT);
		cmbTipoUsuario.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				setearTipoUsuario();
			}
		});
		cmbTipoUsuario.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				setearTipoUsuario();
			}

		});
		cmbTipoUsuario.setModel(new DefaultComboBoxModel(new String[] {"","COMÚN", "ADMINISTRADOR"}));
		cmbTipoUsuario.setBounds(45, 362, 220, 30);
		getContentPane().add(cmbTipoUsuario);
	}
	
	private void agregarBotones() {
		
		uBo = new UsuarioBoImpl();
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(75, 408, 160, 34);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					
					uBo.verificar(u);
					
					uBo.verificarDatosCorrectos(u);
					
					dispose();

//					persona = pDao.consultarPorUsuario(u);
//					
//					if (persona.next()){
//						
//						pU.getLblNombre().setText(persona.getString("nombre"));
//						pU.getLblApellido().setText(persona.getString("apellido"));
//						pU.getLblEmail().setText(persona.getString("email"));
//						pU.getLblTelefono().setText(persona.getString("telefono"));
//						pU.getLblCiudad().setText(persona.getString("ciudad"));
//						pU.getLblPais().setText(persona.getString("pais"));
//						pU.getLblDni().setText(persona.getString("dni"));
//
//						if (persona.getInt("tipoUsuario") == 0){
//							pU.getLblBienvenido().setText("Bienvenido Administrador!");
//							pU.getLblBienvenido().setForeground(Color.RED);	
//						}else if (persona.getInt("tipoUsuario") == 1){
//							pU.getLblBienvenido().setText("Bienvenido " + persona.getString("nombre") + "!");
//							pU.getLblBienvenido().setForeground(Color.BLACK);								
//						}
//						
//						pU.add(pU.getLblBienvenido());
//					
//					}
//					
//					validate();
//					repaint();
					
				}catch (UserNotValidException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (UserNotCorrectException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
			}
		});
		getContentPane().add(btnIngresar);
		
		btnOlvidoSuContrasea = new JButton("¿Olvidó su contraseña?");
		btnOlvidoSuContrasea.setHorizontalAlignment(SwingConstants.LEFT);
		btnOlvidoSuContrasea.setMargin(new Insets(2, 0, 2, 0));
		btnOlvidoSuContrasea.setHorizontalTextPosition(SwingConstants.CENTER);
		btnOlvidoSuContrasea.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == btnOlvidoSuContrasea){
					recuperarPass();
				}
			}
		});
		btnOlvidoSuContrasea.setBorderPainted(false);
		btnOlvidoSuContrasea.setForeground(Color.BLUE);
		btnOlvidoSuContrasea.setContentAreaFilled(false);
		btnOlvidoSuContrasea.setBounds(30, 286, 235, 30);
		getContentPane().add(btnOlvidoSuContrasea);
	}

	private void recuperarPass(){
		DialogMissedPass d = new DialogMissedPass();
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

	private void setearTipoUsuario() {
		if (cmbTipoUsuario.getSelectedIndex() == 1){
			u.setTipoUsuario(1);
		} else if (cmbTipoUsuario.getSelectedIndex() == 2){
			u.setTipoUsuario(0);
		} else {
			u.setTipoUsuario(-1);
		}
	}
	
	public Usuario getUsuario() {
		return u;
	}

	
	public void setUsuario(Usuario u) {
		this.u = u;
	}

}