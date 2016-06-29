package org.proyectofinal.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.proyectofinal.bo.ex.ViajeCabeceraNotValidException;
import org.proyectofinal.bo.impl.ViajeCabeceraBoImpl;
import org.proyectofinal.bo.interfaces.ViajeCabeceraBo;
import org.proyectofinal.dao.impl.ViajeCabeceraDaoImpl;
import org.proyectofinal.dao.interfaces.ViajeCabeceraDao;
import org.proyectofinal.model.impl.ViajeCabeceraImpl;
import org.proyectofinal.model.interfaces.ViajeCabecera;
import org.proyectofinal.ui.plantillasUI.PlantillaDLF;
import org.proyectofinal.ui.util.ListaPaises;
import org.proyectofinal.ui.util.PaisUtil;

import com.toedter.calendar.JDateChooser;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Font;

public class DialogLoadFlight extends PlantillaDLF implements WindowListener {

	private JButton btnRealizarCambios;
	private ViajeCabecera vC;
	private ViajeCabeceraBo vCBo;
	private List<Integer> codigos;
	
	public DialogLoadFlight() {
	
		inicializarAtributos();
		inicializarComponentes();
		addWindowListener(this);
		
		setVisible(true);

//		addWindowFocusListener(new WindowFocusListener() {
//			public void windowGainedFocus(WindowEvent e) {
//				
//				codigos = new ArrayList<Integer>();
//				
//				ResultSet res = null;
//				
//				try {
//					
//					res = vCDao.consultarCodigosViaje();
//				
//					while(res.next()){
//						codigos.add(res.getInt("codViaje"));
//					}
//					
//				} catch (SQLException e2) {
//					e2.printStackTrace();
//				} catch (ClassNotFoundException e1) {
//					e1.printStackTrace();
//				} finally {
//					try {
//						vCDao.desconectar();
//					} catch (SQLException e1) {
//						e1.printStackTrace();
//					}
//				}
//				
//			}
//			public void windowLostFocus(WindowEvent e) {
//				codigos = null;
//			}
//		});
	
	}

	@Override
	public void windowOpened(WindowEvent e) {
		cargarPaisesOrigen();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}
	
}