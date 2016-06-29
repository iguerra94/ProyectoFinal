package org.proyectofinal.ui.plantillasUI;

import java.awt.Color;
import java.awt.Font;
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
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.proyectofinal.bo.ex.ViajeCabeceraNotValidException;
import org.proyectofinal.bo.impl.ViajeCabeceraBoImpl;
import org.proyectofinal.bo.interfaces.ViajeCabeceraBo;
import org.proyectofinal.model.impl.ViajeCabeceraImpl;
import org.proyectofinal.model.interfaces.ViajeCabecera;
import org.proyectofinal.ui.util.CiudadUtil;
import org.proyectofinal.ui.util.ListaCiudades;
import org.proyectofinal.ui.util.ListaPaises;
import org.proyectofinal.ui.util.ListaPlataformas;
import org.proyectofinal.ui.util.PaisUtil;
import org.proyectofinal.ui.util.PlataformaUtil;

import com.toedter.calendar.JDateChooser;

public class PlantillaDLF extends JDialog {
	
	private JTextField txtCodigoViaje;
	
	private JPanel panelSalida;
	private JComboBox cmbPaisOrigen;
	private JComboBox cmbCiudadOrigen;
	private JComboBox cmbPlatOrigen;
	private JDateChooser dateChooserFechaSalida;
	private java.util.Date now;
	private Date fechaSalida;
	private JComboBox cmbHoraSalida;
	private String horaSalida;
	private JComboBox cmbMinutoSalida;
	private String minutoSalida;
	
	private JPanel panelLlegada;
	private JComboBox cmbPaisDestino;
	private JComboBox cmbCiudadDestino;
	private JComboBox cmbPlatDestino;
	private JDateChooser dateChooserFechaLlegada;
	private JComboBox cmbHoraLlegada;
	private JComboBox cmbMinutoLlegada;
	
	private JPanel panelPrecios;
	private JTextField txtPrecioTurista;
	private JTextField txtPrecioPrimera;
	
	private JPanel panelImagenes;
	private JTextField txtImagen1;
	private JTextField txtImagen2;
	private FileNameExtensionFilter filterjpg = new FileNameExtensionFilter("Archivo de Imagen JPG", "jpg");
	private FileNameExtensionFilter filterpng = new FileNameExtensionFilter("Archivo de Imagen PNG", "png");
	
	private JPanel panelInfoExtra;
	private JTextField txtDistancia;
	private JComboBox cmbHoraDuracion;
	private JComboBox cmbMinutoDuracion;
	private JTextField txtCupo;
	
	private JButton btnCargarVuelo;
	
	private ViajeCabecera vC;
	private ViajeCabeceraBo vCBo;
	
	
	public PlantillaDLF(){

	}
	
	public void inicializarAtributos(){
		setResizable(false);
		setModal(true);
		setTitle("Cargar Vuelo..");
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 870, 660);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(null);	
	}
	
	public void inicializarComponentes(){
		agregarCodigoViaje();
		agregarPanelSalida();
		agregarPanelLlegada();
		agregarPanelPrecios();
		agregarPanelImagenes();
		agregarPanelInfoExtra();
		agregarBotonGuardarCambios();
	}

	private void agregarCodigoViaje() {
		
		vC = new ViajeCabeceraImpl();
		
		JLabel lblCodigoDeViaje = new JLabel("Codigo de Viaje: ");
		lblCodigoDeViaje.setBounds(25, 20, 120, 30);
		getContentPane().add(lblCodigoDeViaje);
		
		txtCodigoViaje = new JTextField();
		txtCodigoViaje.setToolTipText("SOLO LETRAS MAYUSCULAS Y NUMEROS. POR EJ: \"AR 1024\"");
		txtCodigoViaje.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if (txtCodigoViaje.getText().trim().length() > 0){
					vC.setCodigoViaje(txtCodigoViaje.getText());						
				}else{
					vC.setCodigoViaje("");
				}
			}
		});
		txtCodigoViaje.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				controlarTeclasAlfanumericas(e);
			}
			@Override
			public void keyReleased(KeyEvent e) {
			
//				if (txtCodigoViaje.getText().trim().length() > 0){
//					
////					for (Integer codigo : codigos) {
//						
//						if (Integer.parseInt(txtCodigoViaje.getText()) == codigo){
//							JOptionPane.showMessageDialog(null, "El vuelo ingresado ya existe. Ingrese otro Codigo de Viaje");
//							txtCodigoViaje.setText("");
//							break;
//						}else{
//							vC.setCodigoViaje("");
//						}						
//					}
//					
//				}else{
//					vC.setCodigoViaje("");
//				}
			}
		});
		txtCodigoViaje.setBounds(145, 20, 190, 30);
		getContentPane().add(txtCodigoViaje);
		
		vC.setCodigoViaje("");
	}
	
	private void controlarTeclasAlfanumericas(KeyEvent e) {
		char c = e.getKeyChar();
		
		if ((c < '0' || c > '9') && (c < 'A' || c > 'Z') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_SPACE) && (c != KeyEvent.VK_BACK_SPACE)){
			e.consume();
		}
	}

	private void agregarPanelSalida() {
		
		panelSalida = new JPanel();
		panelSalida.setBorder(new TitledBorder(null, "Salida", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panelSalida.setBounds(20, 70, 400, 250);
		panelSalida.setBackground(Color.WHITE);
		getContentPane().add(panelSalida);
		panelSalida.setLayout(null);
		
		agregarLabelsPanelSalida();
		agregarCamposPanelSalida();		
	}

	private void agregarLabelsPanelSalida() {
		JLabel lblPaisDeOrigen = new JLabel("Pais de Origen: ");
		lblPaisDeOrigen.setBounds(20, 30, 160, 30);
		panelSalida.add(lblPaisDeOrigen);
		
		JLabel lblCiudadDeOrigen = new JLabel("Ciudad de Origen: ");
		lblCiudadDeOrigen.setBounds(20, 70, 160, 30);
		panelSalida.add(lblCiudadDeOrigen);
		
		JLabel lblPlataformaOrigen = new JLabel("Plataforma de Origen: ");
		lblPlataformaOrigen.setBounds(20, 110, 160, 30);
		panelSalida.add(lblPlataformaOrigen);
		
		JLabel lblFechaDeSalida = new JLabel("Fecha de Salida: ");
		lblFechaDeSalida.setBounds(20, 150, 160, 30);
		panelSalida.add(lblFechaDeSalida);
		
		JLabel lblHoraDeSalida = new JLabel("Hora de Salida: ");
		lblHoraDeSalida.setBounds(20, 190, 160, 30);
		panelSalida.add(lblHoraDeSalida);
	}

	private void agregarCamposPanelSalida() {

		String[] modelHora = new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
		String[] modelMinuto = new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};

		cmbPaisOrigen = new JComboBox();
		cmbPaisOrigen.setBounds(180, 30, 190, 30);
		panelSalida.add(cmbPaisOrigen);
		cmbPaisOrigen.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				actualizarComboCiudadOrigen();
				cargarCiudadesOrigen();
				
				if (cmbPaisOrigen.getSelectedIndex() != 0){
					PaisUtil pais = (PaisUtil)cmbPaisOrigen.getSelectedItem();
					vC.setPaisOrigen(pais.getPais());
					vC.setShortPaisOrigen(pais.getShortPais());
				}else{
					vC.setPaisOrigen("");
					vC.setShortPaisOrigen("");
				}
				
			}
		});
		
		cmbCiudadOrigen = new JComboBox();
		cmbCiudadOrigen.setBounds(180, 70, 190, 30);
		cmbCiudadOrigen.setEnabled(false);
		cmbCiudadOrigen.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				actualizarComboPlatOrigen();
				cargarPlataformasOrigen();
				actualizarComboPaisDestino();
				cargarPaisesDestino();
				
				if (cmbCiudadOrigen.getSelectedIndex() != 0){
					CiudadUtil ciudad = (CiudadUtil)cmbCiudadOrigen.getSelectedItem();
					vC.setCiudadOrigen(ciudad.getCiudad());
				}else{
					vC.setCiudadOrigen("");
				}
				
			}
		});
		panelSalida.add(cmbCiudadOrigen);
		
		cmbPlatOrigen = new JComboBox();
		cmbPlatOrigen.setEnabled(false);
		cmbPlatOrigen.setBounds(180, 110, 190, 30);
		cmbPlatOrigen.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if (cmbPlatOrigen.getSelectedIndex() != 0){
					PlataformaUtil plat = (PlataformaUtil) cmbPlatOrigen.getSelectedItem();
					vC.setPlataformaOrigen(plat.getPlataforma());
				}else{
					vC.setPlataformaOrigen("");
				}
				
			}
		});
		panelSalida.add(cmbPlatOrigen);

		now = new java.util.Date();
		
		dateChooserFechaSalida = new JDateChooser();
		dateChooserFechaSalida.setDate(now);
		dateChooserFechaSalida.setMinSelectableDate(now);
		dateChooserFechaSalida.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
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
	
				dateChooserFechaLlegada.setDate(dateChooserFechaSalida.getDate());
				dateChooserFechaLlegada.setMinSelectableDate(dateChooserFechaSalida.getDate());
				
				dateChooserFechaLlegada.validate();
				dateChooserFechaLlegada.repaint();
			}
		});
		dateChooserFechaSalida.setBounds(180, 150, 190, 30);
		panelSalida.add(dateChooserFechaSalida);
		
		cmbHoraSalida = new JComboBox();
		cmbHoraSalida.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
			
				if (dateChooserFechaSalida.getDate().equals(dateChooserFechaLlegada.getDate())){
					cmbHoraLlegada.setSelectedIndex(cmbHoraSalida.getSelectedIndex());
					cmbMinutoLlegada.setSelectedIndex(cmbMinutoSalida.getSelectedIndex());
				}
				
			}
		});
		cmbHoraSalida.setBounds(180, 190, 50, 30);
		panelSalida.add(cmbHoraSalida);
		cmbHoraSalida.setModel(new DefaultComboBoxModel(modelHora));
		
		JLabel label1 = new JLabel(":");
		label1.setBounds(240, 190, 15, 30);
		panelSalida.add(label1);
		
		cmbMinutoSalida = new JComboBox();
		cmbMinutoSalida.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
			
				if (dateChooserFechaSalida.getDate().equals(dateChooserFechaLlegada.getDate())){
					cmbMinutoLlegada.setSelectedIndex(cmbMinutoSalida.getSelectedIndex());
				}
				
			}
		});
		cmbMinutoSalida.setBounds(255, 190, 50, 30);
		panelSalida.add(cmbMinutoSalida);
		cmbMinutoSalida.setModel(new DefaultComboBoxModel(modelMinuto));
		
		vC.setPaisOrigen("");
		vC.setCiudadOrigen("");
		vC.setPlataformaOrigen("");
		vC.setFechaSalida(null);
		vC.setHoraSalida(Time.valueOf("00:00:00"));
		
	}
		
	protected void actualizarComboCiudadOrigen(){
		
		if (cmbPaisOrigen.getSelectedIndex() != 0){
			cmbCiudadOrigen.setEnabled(true);
		}else{
			cmbCiudadOrigen.setEnabled(false);
			if (cmbCiudadOrigen.getModel().getSize()>0){
				cmbCiudadOrigen.setSelectedIndex(0);
			}
		}
	}
	
	protected void actualizarComboPlatOrigen(){
		
		if (cmbCiudadOrigen.getSelectedIndex() != 0){
			cmbPlatOrigen.setEnabled(true);
			cmbPlatOrigen.requestFocus();
		}else{
			cmbPlatOrigen.setEnabled(false);
			if (cmbPlatOrigen.getModel().getSize()>0){
				cmbPlatOrigen.setSelectedIndex(0);
			}
		}
	}
	
	protected void cargarPaisesOrigen(){
		
		ListaPaises paises = new ListaPaises();
		
		PaisUtil[] modelPaises = new PaisUtil[paises.getListaPaises().size()+1];
	
		modelPaises[0] = new PaisUtil("","");
		
		int i = 1;

		for (PaisUtil p : paises.getListaPaises()) {
			modelPaises[i] = p;
			i++;
		}
		
		cmbPaisOrigen.setModel(new DefaultComboBoxModel(modelPaises));
		cmbPaisOrigen.setSelectedIndex(0);
	}
	
	protected void cargarCiudadesOrigen(){
		
		ListaCiudades ciudades = new ListaCiudades();
		
		List<CiudadUtil> listaModeloCiudades = new ArrayList<CiudadUtil>();

		listaModeloCiudades.add(new CiudadUtil("", ""));
		
		PaisUtil pais = (PaisUtil)cmbPaisOrigen.getSelectedItem();
		
		for (CiudadUtil c : ciudades.getListaCiudades()) {
			if (c.getShortPais().equals( pais.getShortPais()) ){
				listaModeloCiudades.add(c);
			}
		}

		CiudadUtil[] modelCiudades = new CiudadUtil[listaModeloCiudades.size()];
		
		int i = 0;
		
		for (CiudadUtil c : listaModeloCiudades) {
			modelCiudades[i] = c;
			
			i++;
		}
		
		cmbCiudadOrigen.setModel(new DefaultComboBoxModel(modelCiudades));
		cmbCiudadOrigen.setSelectedIndex(0);
	}
	
	protected void cargarPlataformasOrigen(){
		
		ListaPlataformas plataformas = new ListaPlataformas();
		
		List<PlataformaUtil> listaModeloPlataformas = new ArrayList<PlataformaUtil>();

		listaModeloPlataformas.add(new PlataformaUtil("", ""));
		
		CiudadUtil ciudad = (CiudadUtil)cmbCiudadOrigen.getSelectedItem();
		
		for (PlataformaUtil plat : plataformas.getListaPlataformas()) {
			if (plat.getCiudad().equals( ciudad.getCiudad() )){
				listaModeloPlataformas.add(plat);
			}
		}

		PlataformaUtil[] modelPlataformas = new PlataformaUtil[listaModeloPlataformas.size()];
		
		int i = 0;
		
		for (PlataformaUtil plat : listaModeloPlataformas) {
			modelPlataformas[i] = plat;
			
			i++;
		}
		
		cmbPlatOrigen.setModel(new DefaultComboBoxModel(modelPlataformas));
		cmbPlatOrigen.setSelectedIndex(0);
	}
	
	private void agregarPanelLlegada() {
		
		panelLlegada = new JPanel();
		panelLlegada.setLayout(null);
		panelLlegada.setBackground(Color.WHITE);
		panelLlegada.setBorder(new TitledBorder(null, "Llegada", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panelLlegada.setBounds(440, 70, 400, 250);
		getContentPane().add(panelLlegada);

		agregarLabelsPanelLlegada();
		agregarCamposPanelLlegada();
	}

	private void agregarLabelsPanelLlegada() {
		JLabel lblPaisDestino = new JLabel("Pais de Destino: ");
		lblPaisDestino.setBounds(20, 30, 160, 30);
		panelLlegada.add(lblPaisDestino);
		
		JLabel lblCiudadDestino = new JLabel("Ciudad de Destino: ");
		lblCiudadDestino.setBounds(20, 70, 160, 30);
		panelLlegada.add(lblCiudadDestino);
		
		JLabel lblPlataformaDestino = new JLabel("Plataforma de Destino: ");
		lblPlataformaDestino.setBounds(20, 110, 160, 30);
		panelLlegada.add(lblPlataformaDestino);
		
		JLabel lblFechaLlegada = new JLabel("Fecha de Llegada: ");
		lblFechaLlegada.setBounds(20, 150, 160, 30);
		panelLlegada.add(lblFechaLlegada);
		
		JLabel lblHoraLlegada = new JLabel("Hora de Llegada: ");
		lblHoraLlegada.setBounds(20, 190, 160, 30);
		panelLlegada.add(lblHoraLlegada);
	}

	private void agregarCamposPanelLlegada() {

		String[] modelHora = new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
		String[] modelMinuto = new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};
		
		cmbPaisDestino = new JComboBox();
		cmbPaisDestino.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				actualizarComboCiudadDestino();
				cargarCiudadesDestino();
				actualizarComboPlatDestino();
				
				if (cmbPaisDestino.getSelectedIndex() != 0){
					PaisUtil pais = (PaisUtil)cmbPaisDestino.getSelectedItem();
					vC.setPaisDestino(pais.getPais());
					vC.setShortPaisDestino(pais.getShortPais());
				}else{
					vC.setPaisDestino("");
					vC.setShortPaisDestino("");
				}
				
			}
		});
		cmbPaisDestino.setEnabled(false);
		cmbPaisDestino.setBounds(180, 30, 190, 30);
		panelLlegada.add(cmbPaisDestino);
		
		cmbCiudadDestino = new JComboBox();
		cmbCiudadDestino.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				actualizarComboPlatDestino();
				cargarPlataformasDestino();
				
				if (cmbCiudadDestino.getSelectedIndex() != 0){
					CiudadUtil ciudad = (CiudadUtil)cmbCiudadDestino.getSelectedItem();
					vC.setCiudadDestino(ciudad.getCiudad());
				}else{
					vC.setCiudadDestino("");
				}
				
			}
		});
		cmbCiudadDestino.setEnabled(false);
		cmbCiudadDestino.setBounds(180, 70, 190, 30);
		panelLlegada.add(cmbCiudadDestino);
		
		cmbPlatDestino = new JComboBox();
		cmbPlatDestino.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if (cmbPlatDestino.getSelectedIndex() != 0){
					PlataformaUtil plat = (PlataformaUtil) cmbPlatDestino.getSelectedItem();
					vC.setPlataformaDestino(plat.getPlataforma());
				}else{
					vC.setPlataformaDestino("");
				}
				
			}
		});
		cmbPlatDestino.setEnabled(false);
		cmbPlatDestino.setBounds(180, 110, 190, 30);
		panelLlegada.add(cmbPlatDestino);
		
		dateChooserFechaLlegada = new JDateChooser();
		dateChooserFechaLlegada.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				
				if (dateChooserFechaSalida.getDate().equals(dateChooserFechaLlegada.getDate())){
					
					if (cmbHoraLlegada.getSelectedIndex() < cmbHoraSalida.getSelectedIndex()){
						cmbHoraLlegada.setSelectedIndex(cmbHoraSalida.getSelectedIndex());
					}
					
					if ( (cmbMinutoLlegada.getSelectedIndex() < cmbMinutoSalida.getSelectedIndex()) && (cmbHoraLlegada.getSelectedIndex() <= cmbHoraSalida.getSelectedIndex()) ){
						cmbMinutoLlegada.setSelectedIndex(cmbMinutoSalida.getSelectedIndex());
					}
					
				}
				
			}
		});
		dateChooserFechaLlegada.setBounds(180, 150, 190, 30);
		panelLlegada.add(dateChooserFechaLlegada);
		
		cmbHoraLlegada = new JComboBox();
		cmbHoraLlegada.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				if (dateChooserFechaSalida.getDate().equals(dateChooserFechaLlegada.getDate())){
					
					if (cmbHoraLlegada.getSelectedIndex() < cmbHoraSalida.getSelectedIndex()){
						cmbHoraLlegada.setSelectedIndex(cmbHoraSalida.getSelectedIndex());
					}
				}
				
			}
		});
		cmbHoraLlegada.setBounds(180, 190, 50, 30);
		cmbHoraLlegada.setModel(new DefaultComboBoxModel(modelHora));
		panelLlegada.add(cmbHoraLlegada);
		
		JLabel label2 = new JLabel(":");
		label2.setFont(new Font("DejaVu Sans", Font.PLAIN, 14));
		label2.setBounds(240, 190, 15, 30);
		panelLlegada.add(label2);
		
		cmbMinutoLlegada = new JComboBox();
		cmbMinutoLlegada.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				if (dateChooserFechaSalida.getDate().equals(dateChooserFechaLlegada.getDate())){
					
					if ( (cmbMinutoLlegada.getSelectedIndex() < cmbMinutoSalida.getSelectedIndex()) && (cmbHoraLlegada.getSelectedIndex() <= cmbHoraSalida.getSelectedIndex()) ){
						cmbMinutoLlegada.setSelectedIndex(cmbMinutoSalida.getSelectedIndex());
					}
					
				}
				
			}
		});
		cmbMinutoLlegada.setBounds(255, 190, 50, 30);
		cmbMinutoLlegada.setModel(new DefaultComboBoxModel(modelMinuto));
		panelLlegada.add(cmbMinutoLlegada);

		vC.setPaisDestino("");
		vC.setCiudadDestino("");
		vC.setPlataformaDestino("");
		vC.setFechaLlegada(null);
		vC.setHoraLlegada(Time.valueOf("00:00:00"));
	
	}

	protected void actualizarComboPaisDestino(){
		
		if (cmbCiudadOrigen.getSelectedIndex() != 0){
			cmbPaisDestino.setEnabled(true);
			
			if (cmbCiudadDestino.isEnabled()){
				cargarCiudadesDestino();
				actualizarComboPlatDestino();
			}
		}else{
			cmbPaisDestino.setEnabled(false);
			if (cmbPaisDestino.getModel().getSize()>0){
				cmbPaisDestino.setSelectedIndex(0);
			}
		}
	}
	
	protected void actualizarComboCiudadDestino(){
		
		if (cmbPaisDestino.getSelectedIndex() != 0 && cmbCiudadOrigen.getSelectedIndex() != 0){
			cmbCiudadDestino.setEnabled(true);
		}else{
			cmbCiudadDestino.setEnabled(false);
			if (cmbCiudadDestino.getModel().getSize()>0){
				cmbCiudadDestino.setSelectedIndex(0);
			}
		}
	}
	
	protected void actualizarComboPlatDestino(){
		
		if (cmbCiudadDestino.getSelectedIndex() != 0){
			cmbPlatDestino.setEnabled(true);
		}else{
			cmbPlatDestino.setEnabled(false);
			if (cmbPlatDestino.getModel().getSize()>0){
				cmbPlatDestino.setSelectedIndex(0);
			}
		}
	}
	
	protected void cargarPaisesDestino(){
		
		if (cmbPaisDestino.getModel().getSize() == 0){
			
			ListaPaises paises = new ListaPaises();
			
			PaisUtil[] modelPaises = new PaisUtil[paises.getListaPaises().size()+1];
			
			modelPaises[0] = new PaisUtil("","");
			
			int i = 1;
			
			for (PaisUtil p : paises.getListaPaises()) {
				modelPaises[i] = p;
				i++;
			}
			
			cmbPaisDestino.setModel(new DefaultComboBoxModel(modelPaises));
			cmbPaisDestino.setSelectedIndex(0);
		}
	
	}
	
	protected void cargarCiudadesDestino(){
		
		ListaCiudades ciudades = new ListaCiudades();
		
		List<CiudadUtil> listaModeloCiudades = new ArrayList<CiudadUtil>();

		listaModeloCiudades.add(new CiudadUtil("", ""));
		
		PaisUtil pais = (PaisUtil)cmbPaisDestino.getSelectedItem();
		
		CiudadUtil ciudadOrigen = (CiudadUtil) cmbCiudadOrigen.getSelectedItem();
		
		for (CiudadUtil c : ciudades.getListaCiudades()) {
			if (c.getShortPais().equals( pais.getShortPais()) && !c.getCiudad().equals(ciudadOrigen.getCiudad() )){
				listaModeloCiudades.add(c);
			}
		}

		CiudadUtil[] modelCiudades = new CiudadUtil[listaModeloCiudades.size()];
		
		int i = 0;
		
		for (CiudadUtil c : listaModeloCiudades) {
			modelCiudades[i] = c;
			
			i++;
		}
		
		cmbCiudadDestino.setModel(new DefaultComboBoxModel(modelCiudades));
		cmbCiudadDestino.setSelectedIndex(0);
	}
	
	protected void cargarPlataformasDestino(){
		
		ListaPlataformas plataformas = new ListaPlataformas();
		
		List<PlataformaUtil> listaModeloPlataformas = new ArrayList<PlataformaUtil>();

		listaModeloPlataformas.add(new PlataformaUtil("", ""));
		
		CiudadUtil ciudad = (CiudadUtil)cmbCiudadDestino.getSelectedItem();
		
		for (PlataformaUtil plat : plataformas.getListaPlataformas()) {
			if (plat.getCiudad().equals( ciudad.getCiudad()) ){
				listaModeloPlataformas.add(plat);
			}
		}

		PlataformaUtil[] modelPlataformas = new PlataformaUtil[listaModeloPlataformas.size()];
		
		int i = 0;
		
		for (PlataformaUtil plat : listaModeloPlataformas) {
			modelPlataformas[i] = plat;
			
			i++;
		}
		
		cmbPlatDestino.setModel(new DefaultComboBoxModel(modelPlataformas));
		cmbPlatDestino.setSelectedIndex(0);
	}
	
	private void agregarPanelPrecios() {
		panelPrecios = new JPanel();
		panelPrecios.setLayout(null);
		panelPrecios.setBackground(Color.WHITE);
		panelPrecios.setBorder(new TitledBorder(null, "Precios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panelPrecios.setBounds(20, 345, 290, 130);
		getContentPane().add(panelPrecios);
		
		agregarLabelsPanelPrecios();
		agregarCamposPanelPrecios();
	}

	private void agregarLabelsPanelPrecios() {
		JLabel lblPrecioClaseTurista = new JLabel("Precio Clase Turista:");
		lblPrecioClaseTurista.setBounds(20, 30, 150, 30);
		panelPrecios.add(lblPrecioClaseTurista);
		
		JLabel lblPrecioPrimeraClase = new JLabel("Precio Primera Clase:");
		lblPrecioPrimeraClase.setBounds(20, 70, 150, 30);
		panelPrecios.add(lblPrecioPrimeraClase);
	}
	
	private void agregarCamposPanelPrecios() {

		txtPrecioTurista = new JTextField();
		txtPrecioTurista.setToolTipText("SOLO NUMEROS Y .(PUNTO). POR EJ: 120.04");
		txtPrecioTurista.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if (txtPrecioTurista.getText().trim().length() > 0){
					vC.setPrecioClaseTur(Float.parseFloat(txtPrecioTurista.getText()));						
				}else{
					vC.setPrecioClaseTur(-1f);
				}
			}
		});
		txtPrecioTurista.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				controlarTeclasParaTiposFlotantes(e);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtPrecioTurista.getText().trim().length() > 0){
					vC.setPrecioClaseTur(Float.parseFloat(txtPrecioTurista.getText()));						
				}else{
					vC.setPrecioClaseTur(-1f);
				}
			}

		});
		txtPrecioTurista.setBounds(170, 30, 100, 30);
		panelPrecios.add(txtPrecioTurista);
	
		txtPrecioPrimera = new JTextField();
		txtPrecioPrimera.setToolTipText("SOLO NUMEROS Y .(PUNTO). POR EJ: 120.04");
		txtPrecioPrimera.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if (txtPrecioPrimera.getText().trim().length() > 0){
					vC.setPrecioClasePrim(Float.parseFloat(txtPrecioPrimera.getText()));						
				}else{
					vC.setPrecioClasePrim(-1f);
				}
			}
		});
		txtPrecioPrimera.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				controlarTeclasParaTiposFlotantes(e);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtPrecioPrimera.getText().trim().length() > 0){
					vC.setPrecioClasePrim(Float.parseFloat(txtPrecioPrimera.getText()));						
				}else{
					vC.setPrecioClasePrim(-1f);
				}
			}

		});
		txtPrecioPrimera.setBounds(170, 70, 100, 30);
		panelPrecios.add(txtPrecioPrimera);
		
		vC.setPrecioClaseTur(-1f);
		vC.setPrecioClasePrim(-1f);
	}

	private void controlarTeclasParaTiposFlotantes(KeyEvent e) {
		char c = e.getKeyChar();
		
		if ((c < '0' || c > '9') && (c != '.') && (c != KeyEvent.VK_KP_LEFT) && c != (KeyEvent.VK_KP_RIGHT) && (c != KeyEvent.VK_SPACE) && (c != KeyEvent.VK_BACK_SPACE)){
			e.consume();
		}
	}
	
	private void agregarPanelImagenes() {

		panelImagenes = new JPanel();
		panelImagenes.setLayout(null);
		panelImagenes.setBackground(Color.WHITE);		
		panelImagenes.setBorder(new TitledBorder(null, "Imagenes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panelImagenes.setBounds(330, 345, 510, 130);
		getContentPane().add(panelImagenes);
		
		agregarLabelsPanelImagenes();
		agregarCamposPanelImagenes();
	}

	private void agregarLabelsPanelImagenes() {
		JLabel lblImagen1 = new JLabel("Imagen 1:");
		lblImagen1.setBounds(20, 30, 80, 30);
		panelImagenes.add(lblImagen1);
		
		JLabel lblImagen2 = new JLabel("Imagen 2:");
		lblImagen2.setBounds(20, 70, 80, 30);
		panelImagenes.add(lblImagen2);
	}

	private void agregarCamposPanelImagenes() {

		txtImagen1 = new JTextField();
		txtImagen1.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {

				if (txtImagen1.getText().length() > 0){
					vC.setImagen1(txtImagen1.getText());				
				}else{
					vC.setImagen1("");
				}
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
			
				if (txtImagen1.getText().length() > 0){
					vC.setImagen1(txtImagen1.getText());				
				}else{
					vC.setImagen1("");
				}
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				
			}
		});
		txtImagen1.setEditable(false);
		txtImagen1.setBounds(100, 30, 215, 30);
		panelImagenes.add(txtImagen1);
		
		JButton btnImagen1 = new JButton("Agregar Imagen..");
		btnImagen1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actionBtnImagen1();				
			}

		});
		btnImagen1.setBounds(330, 30, 150, 30);
		panelImagenes.add(btnImagen1);
		
		txtImagen2 = new JTextField();
		txtImagen2.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				
				if (txtImagen2.getText().length() > 0){
					vC.setImagen2(txtImagen2.getText());				
				}else{
					vC.setImagen2("");
				}
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				
				if (txtImagen2.getText().length() > 0){
					vC.setImagen2(txtImagen2.getText());				
				}else{
					vC.setImagen2("");
				}
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});
		txtImagen2.setEditable(false);
		txtImagen2.setBounds(100, 70, 215, 30);
		panelImagenes.add(txtImagen2);
		
		JButton btnImagen2 = new JButton("Agregar Imagen..");
		btnImagen2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actionBtnImagen2();				
			}

		});
		btnImagen2.setBounds(330, 70, 150, 30);
		panelImagenes.add(btnImagen2);
		
		vC.setImagen1("");
		vC.setImagen2("");
	}
	
	private void actionBtnImagen1() {

		JFileChooser imagen1 = new JFileChooser("/home/ivang94/workspace/ProyectoFinal/src/imagenes");
		
		imagen1.setFileFilter(filterjpg);
		imagen1.setFileFilter(filterpng);
		
		int opcion = imagen1.showOpenDialog(this);
		
		if (opcion == JFileChooser.APPROVE_OPTION){
			txtImagen1.setText(imagen1.getSelectedFile().getPath());
		}
		
	}
	
	private void actionBtnImagen2(){
		
		JFileChooser imagen2 = new JFileChooser("/home/ivang94/workspace/ProyectoFinal/src/imagenes");
		
		imagen2.setFileFilter(filterjpg);
		imagen2.setFileFilter(filterpng);
		
		int opcion = imagen2.showOpenDialog(this);
		
		if (opcion == JFileChooser.APPROVE_OPTION){
			txtImagen2.setText(imagen2.getSelectedFile().getPath());
		}
	}
	
	private void agregarPanelInfoExtra() {
		
		panelInfoExtra = new JPanel();
		panelInfoExtra.setBounds(25, 495, 815, 90);
		panelInfoExtra.setBackground(Color.WHITE);
		getContentPane().add(panelInfoExtra);
		panelInfoExtra.setLayout(null);
		panelInfoExtra.setBorder(new TitledBorder(null, "Informacion extra", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		
		agregarLabelsPanelInfoExtra();
		agregarCamposPanelInfoExtra();		
	}

	private void agregarLabelsPanelInfoExtra() {
		JLabel lblDistancia = new JLabel("Distancia:");
		lblDistancia.setBounds(20, 30, 100, 30);
		panelInfoExtra.add(lblDistancia);
		
		JLabel lblDuracion = new JLabel("Duracion:");
		lblDuracion.setBounds(295, 30, 80, 30);
		panelInfoExtra.add(lblDuracion);
		
		JLabel lblCupo = new JLabel("Cupo: ");
		lblCupo.setBounds(550, 30, 70, 30);
		panelInfoExtra.add(lblCupo);
	}

	private void agregarCamposPanelInfoExtra() {

		String[] modelHora = new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
		String[] modelMinuto = new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};
		
		txtDistancia = new JTextField();
		txtDistancia.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if (txtDistancia.getText().trim().length() > 0){
					vC.setDistancia(Float.parseFloat(txtDistancia.getText()));						
				}else{
					vC.setDistancia(-1f);
				}
			}
		});
		txtDistancia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				controlarTeclasParaTiposFlotantes(e);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtDistancia.getText().trim().length() > 0){
					vC.setDistancia(Float.parseFloat(txtDistancia.getText()));						
				}else{
					vC.setDistancia(-1f);
				}
			}

		});
		txtDistancia.setBounds(120, 30, 125, 30);
		panelInfoExtra.add(txtDistancia);

		cmbHoraDuracion = new JComboBox();
		cmbHoraDuracion.setEnabled(false);
		cmbHoraDuracion.setModel(new DefaultComboBoxModel<>(modelHora));
		cmbHoraDuracion.setBounds(375, 30, 50, 30);
		panelInfoExtra.add(cmbHoraDuracion);
		
		JLabel label3 = new JLabel(":");
		label3.setFont(new Font("DejaVu Sans", Font.PLAIN, 14));
		label3.setBounds(435, 30, 15, 30);
		panelInfoExtra.add(label3);
		
		cmbMinutoDuracion = new JComboBox();
		cmbMinutoDuracion.setEnabled(false);
		cmbMinutoDuracion.setModel(new DefaultComboBoxModel<>(modelMinuto));
		cmbMinutoDuracion.setBounds(450, 30, 50, 30);
		panelInfoExtra.add(cmbMinutoDuracion);
		
		txtCupo = new JTextField();
		txtCupo.setEditable(false);
		txtCupo.setText("66");
		txtCupo.setBounds(620, 30, 165, 30);
		panelInfoExtra.add(txtCupo);
		
		vC.setDistancia(-1f);
		vC.setDuracion(Time.valueOf("00:00:00"));
		vC.setCupo(Integer.parseInt(txtCupo.getText()));
	}

	private void agregarBotonGuardarCambios() {
		
		btnCargarVuelo = new JButton("Cargar vuelo");
		btnCargarVuelo.addActionListener(new ActionListener() {
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
			
				String duracion = cmbHoraDuracion.getSelectedItem() + ":" + cmbMinutoDuracion.getSelectedItem() + ":00";
				vC.setDuracion(Time.valueOf(duracion));
				
				System.out.println(vC.getImagen1());
				System.out.println(vC.getImagen2());
				System.out.println(vC.getPrecioClaseTur());
				System.out.println(vC.getPrecioClasePrim());
				System.out.println(vC.getDuracion());
				
				vCBo = new ViajeCabeceraBoImpl();
				
				try {
					vCBo.verificarTodos(vC);
				} catch (ViajeCabeceraNotValidException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
//				if (getBtnRealizarCambios().getText() == "Cargar vuelo"){
//					
//					try {
//						vCDao.alta(vC);
//					} catch (ClassNotFoundException e1) {
//						JOptionPane.showMessageDialog(null, e1.getMessage());
//					} catch (SQLException e1) {
//						JOptionPane.showMessageDialog(null, e1.getMessage());
//					}
//					
//					JOptionPane.showMessageDialog(null, "Se ha cargado el vuelo con exito!");
//					
//				}
//				
//				if (getBtnRealizarCambios().getText() == "Guardar cambios"){
//				
//					try {
//						vCDao.modificacion(vC);
//					} catch (ClassNotFoundException e1) {
//						JOptionPane.showMessageDialog(null, e1.getMessage());
//					} catch (SQLException e1) {
//						JOptionPane.showMessageDialog(null, e1.getMessage());
//					}
//					
//					JOptionPane.showMessageDialog(null, "Se ha modificado el vuelo con exito!");
//					
//				}
//				
//				dispose();				
			}
		});
		btnCargarVuelo.setBounds(25, 605, 170, 35);
		getContentPane().add(btnCargarVuelo);
	}

}