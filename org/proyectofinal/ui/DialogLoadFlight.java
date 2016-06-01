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

import org.proyectofinal.bo.impl.ViajeCabeceraBoImpl;
import org.proyectofinal.bo.interfaces.ViajeCabeceraBo;
import org.proyectofinal.dao.ex.ViajeCabeceraNotValidException;
import org.proyectofinal.dao.impl.ViajeCabeceraDaoImpl;
import org.proyectofinal.dao.interfaces.ViajeCabeceraDao;
import org.proyectofinal.model.impl.ViajeCabeceraImpl;
import org.proyectofinal.model.interfaces.ViajeCabecera;
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

public class DialogLoadFlight extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2618894532538789035L;
	/**
	 * 
	 */
	private JTextField txtCodigoViaje;
	private JTextField txtCiudadOrigen;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbPaisOrigen;
	private JTextField txtCiudadDestino;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbPaisDestino;
	private JDateChooser dateChooserFechaSalida;
	private JDateChooser dateChooserFechaLlegada;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbHoraSalida;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbMinutoSalida;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbHoraLlegada;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbMinutoLlegada;
	private JTextField txtCupo;
	private JButton btnRealizarCambios;
	private ViajeCabecera vC;
	private ViajeCabeceraBo vCBo;
	private ViajeCabeceraDao vCDao;
	private List<Integer> codigos;
	private ListaPaises listaPaises;
	private PaisUtil[] modelPaises = new PaisUtil[4];
	
	
	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DialogLoadFlight() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				
				if (txtCodigoViaje.getText().trim().length() > 0){
					vC.setCodigoViaje(Integer.parseInt(txtCodigoViaje.getText()));
				}else{
					vC.setCodigoViaje(-1);
				}
				
				if (txtCiudadOrigen.getText().trim().length() > 0){
					vC.setCiudadOrigen(txtCiudadOrigen.getText());
				}else {
					vC.setCiudadOrigen("");
				}
				
				if (cmbPaisOrigen.getSelectedIndex() == 0){
					vC.setPaisOrigen(listaPaises.getListaPaises().get(0).getPais());
					vC.setShortPaisOrigen(listaPaises.getListaPaises().get(0).getShortPais());
				}
				
				if (txtCiudadDestino.getText().trim().length() > 0){
					vC.setCiudadDestino(txtCiudadDestino.getText());
				}else{
					vC.setCiudadDestino("");					
				}
				
				if (cmbPaisDestino.getSelectedIndex() == 0){
					vC.setPaisDestino(listaPaises.getListaPaises().get(0).getPais());
					vC.setShortPaisDestino(listaPaises.getListaPaises().get(0).getShortPais());
				}
				
				if (dateChooserFechaSalida.getDate() != null){
					Date salida = new Date(dateChooserFechaSalida.getDate().getTime());
					vC.setFechaSalida(salida);
				}else{
					vC.setFechaSalida(null);
				}
				
//				if (txtHoraSalida.getText().trim().length() == 8){
//					vC.setHoraSalida(Time.valueOf(txtHoraSalida.getText()));
//				}else{
//					vC.setHoraSalida(Time.valueOf("00:00:00"));
//				}
				
				if (dateChooserFechaLlegada.getDate() != null){
					Date llegada = new Date(dateChooserFechaLlegada.getDate().getTime());
					vC.setFechaLlegada(llegada);
				}else{
					vC.setFechaLlegada(null);
				}
				
//				if (txtHoraLlegada.getText().trim().length() == 8){
//					vC.setHoraLlegada(Time.valueOf(txtHoraLlegada.getText()));
//				}else{
//					vC.setHoraLlegada(Time.valueOf("00:00:00"));
//				}
				
				if (txtCupo.getText().trim().length() > 0){
					vC.setCupo(Integer.parseInt(txtCupo.getText()));
				}else{
					vC.setCupo(-1);
				}
				
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
						res.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
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
		vCDao = new ViajeCabeceraDaoImpl();
		
		listaPaises = new ListaPaises();
		
		int i = 0;
		
		for (PaisUtil p : listaPaises.getListaPaises()) {
			modelPaises[i] = p;
			i++;
		}
		
		String[] modelHora = new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
		String[] modelMinuto = new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};
		
		setTitle("Cargar Vuelo..");
		setBounds(100, 100, 635, 331);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(null);
		
		JLabel lblCodigoDeViaje = new JLabel("Codigo de Viaje: ");
		lblCodigoDeViaje.setBounds(15, 18, 119, 15);
		getContentPane().add(lblCodigoDeViaje);
		
		JLabel lblCiudadDeOrigen = new JLabel("Ciudad de Origen: ");
		lblCiudadDeOrigen.setBounds(15, 45, 143, 15);
		getContentPane().add(lblCiudadDeOrigen);
		
		JLabel lblPaisDeOrigen = new JLabel("Pais de Origen: ");
		lblPaisDeOrigen.setBounds(15, 75, 119, 15);
		getContentPane().add(lblPaisDeOrigen);
		
		JLabel lblCiudadDeDestino = new JLabel("Ciudad de Destino: ");
		lblCiudadDeDestino.setBounds(15, 105, 143, 15);
		getContentPane().add(lblCiudadDeDestino);
		
		JLabel lblPaisDeDestino = new JLabel("Pais de Destino: ");
		lblPaisDeDestino.setBounds(15, 135, 143, 15);
		getContentPane().add(lblPaisDeDestino);
		
		JLabel lblFechaDeSalida = new JLabel("Fecha de Salida: ");
		lblFechaDeSalida.setBounds(15, 165, 146, 15);
		getContentPane().add(lblFechaDeSalida);
		
		JLabel lblHoraDeSalida = new JLabel("Hora de Salida: ");
		lblHoraDeSalida.setBounds(371, 162, 130, 15);
		getContentPane().add(lblHoraDeSalida);
		
		JLabel lblFechaDeLlegada = new JLabel("Fecha de Llegada: ");
		lblFechaDeLlegada.setBounds(15, 195, 143, 15);
		getContentPane().add(lblFechaDeLlegada);
		
		JLabel lblHoraDeLlegada = new JLabel("Hora de Llegada: ");
		lblHoraDeLlegada.setBounds(371, 192, 137, 15);
		getContentPane().add(lblHoraDeLlegada);
		
		JLabel lblCupo = new JLabel("Cupo: ");
		lblCupo.setBounds(15, 225, 119, 15);
		getContentPane().add(lblCupo);
		
		txtCodigoViaje = new JTextField();
		txtCodigoViaje.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if (txtCodigoViaje.getText().trim().length() > 0){
					vC.setCodigoViaje(Integer.parseInt(txtCodigoViaje.getText()));						
				}else{
					vC.setCodigoViaje(-1);
				}
			}
		});
		txtCodigoViaje.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
		
				char c = e.getKeyChar();
				
				if ((c < '0' || c > '9') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_SPACE) && (c != KeyEvent.VK_BACK_SPACE)){
					e.consume();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtCodigoViaje.getText().trim().length() > 0){
					
					for (Integer codigo : codigos) {
						
						if (Integer.parseInt(txtCodigoViaje.getText()) == codigo){
							JOptionPane.showMessageDialog(null, "El vuelo ingresado ya existe. Ingrese otro Codigo de Viaje");
							txtCodigoViaje.setText("");
							break;
						}else{
							vC.setCodigoViaje(Integer.parseInt(txtCodigoViaje.getText()));						
						}						
					}
					
				}else{
					vC.setCodigoViaje(-1);
				}
			}
		});
		txtCodigoViaje.setBounds(160, 15, 188, 19);
		getContentPane().add(txtCodigoViaje);
		txtCodigoViaje.setColumns(10);
		
		txtCiudadOrigen = new JTextField();
		txtCiudadOrigen.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if (txtCiudadOrigen.getText().trim().length() > 0){
					vC.setCiudadOrigen(txtCiudadOrigen.getText());
				}else {
					vC.setCiudadOrigen("");
				}
			}
		});
		txtCiudadOrigen.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
		
				char c = e.getKeyChar();
				
				if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_SPACE) && (c != KeyEvent.VK_BACK_SPACE)){
					e.consume();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtCiudadOrigen.getText().trim().length() > 0){
					vC.setCiudadOrigen(txtCiudadOrigen.getText());
				}else {
					vC.setCiudadOrigen("");
				}
			}
		});
		txtCiudadOrigen.setColumns(10);
		txtCiudadOrigen.setBounds(160, 45, 188, 19);
		getContentPane().add(txtCiudadOrigen);
		
		txtCiudadDestino = new JTextField();
		txtCiudadDestino.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if (txtCiudadDestino.getText().trim().length() > 0){
					vC.setCiudadDestino(txtCiudadDestino.getText());
				}else{
					vC.setCiudadDestino("");					
				}
			}
		});
		txtCiudadDestino.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
		
				char c = e.getKeyChar();
				
				if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_SPACE) && (c != KeyEvent.VK_BACK_SPACE)){
					e.consume();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtCiudadDestino.getText().trim().length() > 0){
					vC.setCiudadDestino(txtCiudadDestino.getText());
				}else{
					vC.setCiudadDestino("");					
				}
			}
		});
		
		cmbPaisOrigen = new JComboBox();
		cmbPaisOrigen.setModel(new DefaultComboBoxModel(modelPaises));
		cmbPaisOrigen.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if (cmbPaisOrigen.getSelectedIndex() == 0){
					vC.setPaisOrigen(listaPaises.getListaPaises().get(0).getPais());
					vC.setShortPaisOrigen(listaPaises.getListaPaises().get(0).getShortPais());
				}else if (cmbPaisOrigen.getSelectedIndex() == 1){
					vC.setPaisOrigen(listaPaises.getListaPaises().get(1).getPais());
					vC.setShortPaisOrigen(listaPaises.getListaPaises().get(1).getShortPais());
				}else if (cmbPaisOrigen.getSelectedIndex() == 2){
					vC.setPaisOrigen(listaPaises.getListaPaises().get(2).getPais());
					vC.setShortPaisOrigen(listaPaises.getListaPaises().get(2).getShortPais());
				}else if (cmbPaisOrigen.getSelectedIndex() == 3){
					vC.setPaisOrigen(listaPaises.getListaPaises().get(3).getPais());
					vC.setShortPaisOrigen(listaPaises.getListaPaises().get(3).getShortPais());
				}
				
			}
		});
		cmbPaisOrigen.setBounds(160, 73, 188, 22);
		getContentPane().add(cmbPaisOrigen);
		txtCiudadDestino.setColumns(10);
		txtCiudadDestino.setBounds(160, 105, 188, 19);
		getContentPane().add(txtCiudadDestino);
		
		
		cmbPaisDestino = new JComboBox();
		cmbPaisDestino.setModel(new DefaultComboBoxModel(modelPaises));
		cmbPaisDestino.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if (cmbPaisDestino.getSelectedIndex() == 0){
					vC.setPaisDestino(listaPaises.getListaPaises().get(0).getPais());
					vC.setShortPaisDestino(listaPaises.getListaPaises().get(0).getShortPais());
				}else if (cmbPaisDestino.getSelectedIndex() == 1){
					vC.setPaisDestino(listaPaises.getListaPaises().get(1).getPais());
					vC.setShortPaisDestino(listaPaises.getListaPaises().get(1).getShortPais());
				}else if (cmbPaisDestino.getSelectedIndex() == 2){
					vC.setPaisDestino(listaPaises.getListaPaises().get(2).getPais());
					vC.setShortPaisDestino(listaPaises.getListaPaises().get(2).getShortPais());
				}else if (cmbPaisDestino.getSelectedIndex() == 3){
					vC.setPaisDestino(listaPaises.getListaPaises().get(3).getPais());
					vC.setShortPaisDestino(listaPaises.getListaPaises().get(3).getShortPais());
				}
				
	
			}
		});
		cmbPaisDestino.setBounds(160, 130, 188, 22);
		getContentPane().add(cmbPaisDestino);

		dateChooserFechaLlegada = new JDateChooser();
		dateChooserFechaLlegada.setBounds(160, 191, 188, 19);
		getContentPane().add(dateChooserFechaLlegada);
		
		java.util.Date now = new java.util.Date();
		
		dateChooserFechaSalida = new JDateChooser();
		dateChooserFechaSalida.setDate(now);
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
		dateChooserFechaSalida.setBounds(160, 161, 188, 19);
		getContentPane().add(dateChooserFechaSalida);
		
		cmbHoraSalida = new JComboBox();
		cmbHoraSalida.setModel(new DefaultComboBoxModel(modelHora));
		cmbHoraSalida.setBounds(499, 160, 49, 20);
		getContentPane().add(cmbHoraSalida);
		
		cmbHoraLlegada = new JComboBox();
		cmbHoraLlegada.setModel(new DefaultComboBoxModel(modelHora));
		cmbHoraLlegada.setBounds(499, 190, 49, 20);
		getContentPane().add(cmbHoraLlegada);
		
		cmbMinutoLlegada = new JComboBox();
		cmbMinutoLlegada.setModel(new DefaultComboBoxModel(modelMinuto));
		cmbMinutoLlegada.setBounds(568, 190, 49, 20);
		getContentPane().add(cmbMinutoLlegada);
		
		cmbMinutoSalida = new JComboBox();
		cmbMinutoSalida.setModel(new DefaultComboBoxModel(modelMinuto));
		cmbMinutoSalida.setBounds(568, 160, 49, 20);
		getContentPane().add(cmbMinutoSalida);
		
		txtCupo = new JTextField();
		txtCupo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if (txtCupo.getText().trim().length() > 0){
					vC.setCupo(Integer.parseInt(txtCupo.getText()));
				}else{
					vC.setCupo(-1);
				}
			}
		});
		txtCupo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
		
				char c = e.getKeyChar();
				
				if ((c < '0' || c > '9') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_SPACE) && (c != KeyEvent.VK_BACK_SPACE)){
					e.consume();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtCupo.getText().trim().length() > 0){
					vC.setCupo(Integer.parseInt(txtCupo.getText()));
				}else{
					vC.setCupo(-1);
				}
			}
		});
		txtCupo.setColumns(10);
		txtCupo.setBounds(160, 225, 188, 19);
		getContentPane().add(txtCupo);
		
		btnRealizarCambios = new JButton("");
		btnRealizarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				if (dateChooserFechaSalida.getDate() != null){
					Date salida = new Date(dateChooserFechaSalida.getDate().getTime());
					vC.setFechaSalida(salida);
				}else{
					vC.setFechaSalida(null);
				}
				
				if (dateChooserFechaLlegada.getDate() != null){
					Date llegada = new Date(dateChooserFechaLlegada.getDate().getTime());
					vC.setFechaLlegada(llegada);
				}else{
					vC.setFechaLlegada(null);
				}
			
				String horaSalida = cmbHoraSalida.getSelectedItem() + ":" + cmbMinutoSalida.getSelectedItem() + ":00";
				vC.setHoraSalida(Time.valueOf(horaSalida));
				
				String horaLlegada = cmbHoraLlegada.getSelectedItem() + ":" + cmbMinutoLlegada.getSelectedItem() + ":00";
				vC.setHoraLlegada(Time.valueOf(horaLlegada));
			
				try {
					vCBo.verificarTodos(vC);
				} catch (ViajeCabeceraNotValidException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
				if (getBtnRealizarCambios().getText() == "Cargar vuelo"){
					
					try {
						vCDao.alta(vC);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					
					JOptionPane.showMessageDialog(null, "Se ha cargado el vuelo con exito!");
					
				}
				
				if (getBtnRealizarCambios().getText() == "Guardar cambios"){
				
					try {
						vCDao.modificacion(vC);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					
					JOptionPane.showMessageDialog(null, "Se ha modificado el vuelo con exito!");
					
				}
				
				dispose();
				
			}
		});
		btnRealizarCambios.setBounds(15, 260, 171, 37);
		getContentPane().add(btnRealizarCambios);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(500, 272, 117, 25);
		getContentPane().add(btnCancelar);
		
		JLabel label1 = new JLabel(":");
		label1.setBounds(556, 160, 19, 15);
		getContentPane().add(label1);
		
		JLabel label2 = new JLabel(":");
		label2.setBounds(556, 190, 19, 15);
		getContentPane().add(label2);
	}

	public JTextField getTxtCodigoViaje() {
		return txtCodigoViaje;
	}

	public void setTxtCodigoViaje(JTextField txtCodigoViaje) {
		this.txtCodigoViaje = txtCodigoViaje;
	}

	public JTextField getTxtCiudadOrigen() {
		return txtCiudadOrigen;
	}

	public void setTxtCiudadOrigen(JTextField txtCiudadOrigen) {
		this.txtCiudadOrigen = txtCiudadOrigen;
	}

	public JTextField getTxtCiudadDestino() {
		return txtCiudadDestino;
	}

	public void setTxtCiudadDestino(JTextField txtCiudadDestino) {
		this.txtCiudadDestino = txtCiudadDestino;
	}
	
	public JDateChooser getDateChooserFechaSalida() {
		return dateChooserFechaSalida;
	}

	public void setDateChooserFechaSalida(JDateChooser dateChooserFechaSalida) {
		this.dateChooserFechaSalida = dateChooserFechaSalida;
	}

	public JDateChooser getDateChooserFechaLlegada() {
		return dateChooserFechaLlegada;
	}

	public void setDateChooserFechaLlegada(JDateChooser dateChooserFechaLlegada) {
		this.dateChooserFechaLlegada = dateChooserFechaLlegada;
	}
	
	@SuppressWarnings("rawtypes")
	public JComboBox getCmbHoraSalida() {
		return cmbHoraSalida;
	}

	@SuppressWarnings("rawtypes")
	public void setCmbHoraSalida(JComboBox cmbHoraSalida) {
		this.cmbHoraSalida = cmbHoraSalida;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCmbMinutoSalida() {
		return cmbMinutoSalida;
	}

	@SuppressWarnings("rawtypes")
	public void setCmbMinutoSalida(JComboBox cmbMinutoSalida) {
		this.cmbMinutoSalida = cmbMinutoSalida;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCmbHoraLlegada() {
		return cmbHoraLlegada;
	}

	@SuppressWarnings("rawtypes")
	public void setCmbHoraLlegada(JComboBox cmbHoraLlegada) {
		this.cmbHoraLlegada = cmbHoraLlegada;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCmbMinutoLlegada() {
		return cmbMinutoLlegada;
	}

	@SuppressWarnings("rawtypes")
	public void setCmbMinutoLlegada(JComboBox cmbMinutoLlegada) {
		this.cmbMinutoLlegada = cmbMinutoLlegada;
	}

	public JTextField getTxtCupo() {
		return txtCupo;
	}

	public void setTxtCupo(JTextField txtCupo) {
		this.txtCupo = txtCupo;
	}

	public JButton getBtnRealizarCambios() {
		return btnRealizarCambios;
	}

	public void setBtnRealizarCambios(JButton btnRealizarCambios) {
		this.btnRealizarCambios = btnRealizarCambios;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCmbPaisOrigen() {
		return cmbPaisOrigen;
	}

	@SuppressWarnings("rawtypes")
	public void setCmbPaisOrigen(JComboBox cmbPaisOrigen) {
		this.cmbPaisOrigen = cmbPaisOrigen;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCmbPaisDestino() {
		return cmbPaisDestino;
	}

	@SuppressWarnings("rawtypes")
	public void setCmbPaisDestino(JComboBox cmbPaisDestino) {
		this.cmbPaisDestino = cmbPaisDestino;
	}
}