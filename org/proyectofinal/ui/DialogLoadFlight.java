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

public class DialogLoadFlight extends PlantillaDLF {

	private JButton btnRealizarCambios;
	private ViajeCabecera vC;
	private ViajeCabeceraBo vCBo;
	private List<Integer> codigos;
	
	public DialogLoadFlight() {
	
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				
				codigos = new ArrayList<Integer>();
				
				ResultSet res = null;
				
				try {
					
					res = vCDao.consultarCodigosViaje();
				
					while(res.next()){
						codigos.add(res.getInt("codViaje"));
					}
					
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					try {
						vCDao.desconectar();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
			}
			public void windowLostFocus(WindowEvent e) {
				codigos = null;
			}
		});
		
		vC = new ViajeCabeceraImpl();
		vCBo = new ViajeCabeceraBoImpl();
	
		
		dateChooserFechaSalida.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
			
				if (dateChooserFechaSalida.getDate() != null){
					
					dateChooserFechaLlegada.setDate(dateChooserFechaSalida.getDate());
					dateChooserFechaLlegada.setMinSelectableDate(dateChooserFechaSalida.getDate());
					
					dateChooserFechaLlegada.validate();
					dateChooserFechaLlegada.repaint();
				}
				
			}
		});
		dateChooserFechaSalida.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dateChooserFechaSalida.setMinSelectableDate(dateChooserFechaSalida.getDate());
				
				dateChooserFechaLlegada.setDate(dateChooserFechaSalida.getDate());
				dateChooserFechaLlegada.setMinSelectableDate(dateChooserFechaSalida.getDate());
				
				dateChooserFechaSalida.validate();
				dateChooserFechaSalida.repaint();
				dateChooserFechaLlegada.validate();
				dateChooserFechaLlegada.repaint();
			}
		});
		cmbCiudadOrigen.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if (cmbCiudadOrigen.getSelectedIndex() == 0){
					vC.setPaisDestino(listaPaises.getListaPaises().get(0).getPais());
					vC.setShortPaisDestino(listaPaises.getListaPaises().get(0).getShortPais());
				}else if (cmbCiudadOrigen.getSelectedIndex() == 1){
					vC.setPaisDestino(listaPaises.getListaPaises().get(1).getPais());
					vC.setShortPaisDestino(listaPaises.getListaPaises().get(1).getShortPais());
				}else if (cmbCiudadOrigen.getSelectedIndex() == 2){
					vC.setPaisDestino(listaPaises.getListaPaises().get(2).getPais());
					vC.setShortPaisDestino(listaPaises.getListaPaises().get(2).getShortPais());
				}else if (cmbCiudadOrigen.getSelectedIndex() == 3){
					vC.setPaisDestino(listaPaises.getListaPaises().get(3).getPais());
					vC.setShortPaisDestino(listaPaises.getListaPaises().get(3).getShortPais());
				}
				
	
			}
		});
	}
	
}