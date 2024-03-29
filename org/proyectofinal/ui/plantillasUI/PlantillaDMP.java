package org.proyectofinal.ui.plantillasUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.proyectofinal.bo.ex.UserNotExistsException;
import org.proyectofinal.bo.ex.UserNotValidException;
import org.proyectofinal.bo.impl.UsuarioBoImpl;
import org.proyectofinal.bo.interfaces.UsuarioBo;

public class PlantillaDMP extends JDialog {

	private static final long serialVersionUID = 3722630771177336425L;

	private JTextField txtUsuario;
	private JButton btnRecuperar;
	private UsuarioBo uBo;
	private String usuario;
	
	public PlantillaDMP(){
		
	}
	
	protected void inicializarAtributos(){
		setResizable(false);
		setModal(true);
		getContentPane().setBackground(Color.WHITE);
		setTitle("Recuperación de contraseña");
		setBounds(200, 200, 337, 130);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
	}
	
	protected void inicializarComponentes(){
		agregarLabels();
		agregarCampos();
		agregarBotones();
	}
	
	private void agregarLabels(){
		
		JLabel lblIngreseSuUsuario = new JLabel("Nombre de usuario:");
		lblIngreseSuUsuario.setBounds(12, 15, 150, 30);
		lblIngreseSuUsuario.setFont(new Font("Roboto Regular", Font.BOLD, 14));
		getContentPane().add(lblIngreseSuUsuario);
	}

	private void agregarCampos() {
		
		txtUsuario = new JTextField();
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
			@Override
			public void focusGained(FocusEvent e) {
				setearUsuario();
			}
		});
		txtUsuario.setBounds(165, 15, 150, 30);
		txtUsuario.setFont(new Font("Roboto Regular", Font.PLAIN, 14));
		getContentPane().add(txtUsuario);
		
	}

	private void agregarBotones() {
		
		btnRecuperar = new JButton("Recuperar");
		btnRecuperar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == btnRecuperar){					
					actionBtnRecuperar();					
				}
			}
		});
		btnRecuperar.setBounds(12, 55, 117, 35);
		btnRecuperar.setBackground(new Color(0,100,90));
		btnRecuperar.setFont(new Font("Roboto Regular", Font.PLAIN, 16));
		btnRecuperar.setForeground(Color.WHITE);
		getContentPane().add(btnRecuperar);
		
		getRootPane().setDefaultButton(btnRecuperar);
	}

	private void setearUsuario(){
		if (txtUsuario.getText().trim().length() > 0){
			usuario = txtUsuario.getText();
		}else{
			usuario = "";
		}
	}
	
	private void actionBtnRecuperar() {
		
		uBo = new UsuarioBoImpl();

		try {
		
			uBo.verificarUsuario(usuario);
			
			String contrasenia = uBo.recuperarPass(usuario);
			
			if (contrasenia.length() > 0){
				JOptionPane.showMessageDialog(null, "Contraseña: " + contrasenia);
			}
			
		} catch (UserNotExistsException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		} catch (UserNotValidException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage()); 
		} finally {
			limpiar();
		}
		
	}
	
	private void limpiar() {
		txtUsuario.requestFocus();
		txtUsuario.selectAll();
	}

}