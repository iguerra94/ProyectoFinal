package org.proyectofinal.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.proyectofinal.bo.impl.UsuarioBoImpl;
import org.proyectofinal.bo.interfaces.UsuarioBo;
import org.proyectofinal.dao.ex.UserNotExistsException;
import org.proyectofinal.dao.ex.UserNotValidException;
import org.proyectofinal.dao.impl.UsuarioDaoImpl;
import org.proyectofinal.dao.interfaces.UsuarioDao;

public class DialogMissedPass extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1303226988829139714L;
	private JTextField txtUsuario;
	private UsuarioBo uBo;
	private UsuarioDao uDao;
	private String usuario = null;

	/**
	 * Create the dialog.
	 */
	public DialogMissedPass() {
		
		uBo = new UsuarioBoImpl();
		uDao = new UsuarioDaoImpl();
		
		setResizable(false);
		setModal(true);
		setTitle("Recuperación de contraseña");
		setBounds(200, 200, 337, 110);
		getContentPane().setLayout(null);
		
		JLabel lblIngreseSuUsuario = new JLabel("Ingrese su usuario:");
		lblIngreseSuUsuario.setBounds(12, 20, 150, 22);
		getContentPane().add(lblIngreseSuUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				if (txtUsuario.getText().trim().length() > 0){
					usuario = txtUsuario.getText();
				}else{
					usuario = null;
				}

			}
		});
		txtUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if (txtUsuario.getText().trim().length() > 0){
					usuario = txtUsuario.getText();
				}else{
					usuario = null;
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				
				if (txtUsuario.getText().trim().length() > 0){
					usuario = txtUsuario.getText();
				}else{
					usuario = null;
				}
			}
		});
		txtUsuario.setBounds(165, 20, 150, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		final JButton btnRecuperar = new JButton("Recuperar");
		btnRecuperar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == btnRecuperar){
					
					try {
					
						uBo.verificar(usuario);
						
						ResultSet res = uDao.consultarPorUsuario(usuario);

						if (res.next()){
							JOptionPane.showMessageDialog(null, "Contraseña: " + res.getString("contrasenia"));
						}else{
							throw new UserNotExistsException();
						}
						
					} catch (ClassNotFoundException e1) {
						JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos.");
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Ocurrio en error en la base de datos. Compruebe su conexión y vuelva a intentarlo.");
					} catch (UserNotExistsException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (UserNotValidException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage()); 
					} finally {
						limpiar();
					}
										
				}
			}

		});
		btnRecuperar.setBounds(12, 60, 117, 25);
		getContentPane().add(btnRecuperar);
		
		getRootPane().setDefaultButton(btnRecuperar);
	}

	private void limpiar() {
		txtUsuario.requestFocus();
		txtUsuario.selectAll();
	}
}
