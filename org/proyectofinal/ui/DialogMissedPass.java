package org.proyectofinal.ui;

import java.awt.Color;
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

import org.proyectofinal.bo.ex.UserNotExistsException;
import org.proyectofinal.bo.ex.UserNotValidException;
import org.proyectofinal.bo.impl.UsuarioBoImpl;
import org.proyectofinal.bo.interfaces.UsuarioBo;
import org.proyectofinal.dao.impl.UsuarioDaoImpl;
import org.proyectofinal.dao.interfaces.UsuarioDao;
import org.proyectofinal.ui.plantillasUI.PlantillaDMP;

public class DialogMissedPass extends PlantillaDMP {

	public DialogMissedPass() {
			
		inicializarAtributos();
		inicializarComponentes();
		setVisible(true);
	}

}
