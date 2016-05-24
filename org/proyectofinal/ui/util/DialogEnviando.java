package org.proyectofinal.ui.util;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class DialogEnviando extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3067075479869575266L;

	/**
	 * Create the dialog.
	 */
	public DialogEnviando() {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 167, 66);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblEnviando = new JLabel("Enviando Mensaje..");
		lblEnviando.setBounds(12, 5, 147, 35);
		getContentPane().add(lblEnviando);
		
		setVisible(true);
	}

}
