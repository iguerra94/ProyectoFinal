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
import org.proyectofinal.ui.DialogLoadFlight;
import org.proyectofinal.ui.util.CiudadUtil;
import org.proyectofinal.ui.util.ListaCiudades;
import org.proyectofinal.ui.util.ListaPaises;
import org.proyectofinal.ui.util.ListaPlataformas;
import org.proyectofinal.ui.util.PaisUtil;
import org.proyectofinal.ui.util.PlataformaUtil;

import com.toedter.calendar.JDateChooser;

public class PlantillaDLF extends JDialog {
	
	private static final long serialVersionUID = 3529251422781102033L;

	private JTextField txtCodigoViaje;
	List<String> codigos;
	
	private JPanel panelSalida;
	private JComboBox<PaisUtil> cmbPaisOrigen;
	private JComboBox<CiudadUtil> cmbCiudadOrigen;
	private JComboBox<PlataformaUtil> cmbPlatOrigen;
	private JDateChooser dateChooserFechaSalida;
	private java.util.Date now;
	private JComboBox<String> cmbHoraSalida;
	private JComboBox<String> cmbMinutoSalida;
	
	private JPanel panelLlegada;
	private JComboBox<PaisUtil> cmbPaisDestino;
	private JComboBox<CiudadUtil> cmbCiudadDestino;
	private JComboBox<PlataformaUtil> cmbPlatDestino;
	private JDateChooser dateChooserFechaLlegada;
	private JComboBox<String> cmbHoraLlegada;
	private JComboBox<String> cmbMinutoLlegada;
	
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
	private JComboBox<String> cmbHoraDuracion;
	private JComboBox<String> cmbMinutoDuracion;
	private JTextField txtCupo;
	
	private JButton btnCargarVuelo;
	
	private ViajeCabecera vC;
	private ViajeCabeceraBo vCBo;
	
	public PlantillaDLF(){

	}
	
	protected void inicializarAtributosLF(){
		setResizable(false);
		setModal(true);
		setTitle("Cargar Vuelo..");
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 870, 670);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(null);	
	}
	
	protected void inicializarAtributosAF(){
		setResizable(false);
		setModal(true);
		setTitle("Modificar Vuelo..");
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 870, 660);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(null);	
	}
	
	protected void inicializarComponentesLF(){
		agregarCodigoViaje();
		agregarPanelSalida();
		agregarPanelLlegada();
		agregarPanelPrecios();
		agregarPanelImagenes();
		agregarPanelInfoExtra();
		agregarBotonCargarVuelo();
	}
	
	public void inicializarComponentesAF(ViajeCabecera viaje){
		agregarCodigoViajeAF(viaje);
		agregarPanelSalidaAF(viaje);
		agregarPanelLlegadaAF(viaje);
		agregarPanelPreciosAF(viaje);
		agregarPanelImagenesAF(viaje);
		agregarPanelInfoExtraAF(viaje);
		agregarBotonGuardarCambios();
	}

	private void agregarCodigoViaje() {
		
		vC = new ViajeCabeceraImpl();

		vCBo = new ViajeCabeceraBoImpl();
		
		codigos = vCBo.retornarCodigosViaje();
		
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
			
				if (txtCodigoViaje.getText().trim().length() > 0){
					
					vC.setCodigoViaje(txtCodigoViaje.getText());						
					
					for (String codigo : codigos) {
						
						if (txtCodigoViaje.getText().equals(codigo)) {
							JOptionPane.showMessageDialog(null, "El vuelo ingresado ya existe. Ingrese otro Codigo de Viaje");
							txtCodigoViaje.setText("");
							vC.setCodigoViaje("");
							break;
						}						
					}
					
				}else{
					vC.setCodigoViaje("");
				}
			}
		});
		txtCodigoViaje.setBounds(145, 20, 190, 30);
		getContentPane().add(txtCodigoViaje);
		
		vC.setCodigoViaje("");
	}
	
	private void agregarCodigoViajeAF(ViajeCabecera viaje) {
		
		vC = new ViajeCabeceraImpl();

		vCBo = new ViajeCabeceraBoImpl();

		JLabel lblCodigoDeViaje = new JLabel("Codigo de Viaje: ");
		lblCodigoDeViaje.setBounds(25, 20, 120, 30);
		getContentPane().add(lblCodigoDeViaje);
		
		txtCodigoViaje = new JTextField(viaje.getCodigoViaje());
		txtCodigoViaje.setEditable(false);
		txtCodigoViaje.setBounds(145, 20, 190, 30);
		getContentPane().add(txtCodigoViaje);
		
		vC.setCodigoViaje(viaje.getCodigoViaje());
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
	
	private void agregarPanelSalidaAF(ViajeCabecera viaje) {
		
		panelSalida = new JPanel();
		panelSalida.setBorder(new TitledBorder(null, "Salida", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panelSalida.setBounds(20, 70, 400, 250);
		panelSalida.setBackground(Color.WHITE);
		getContentPane().add(panelSalida);
		panelSalida.setLayout(null);
		
		agregarLabelsPanelSalida();
		agregarCamposPanelSalidaAF(viaje);
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

		cmbPaisOrigen = new JComboBox<PaisUtil>();
		cmbPaisOrigen.setBounds(180, 30, 190, 30);
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
		panelSalida.add(cmbPaisOrigen);
		
		cmbCiudadOrigen = new JComboBox<CiudadUtil>();
		cmbCiudadOrigen.setBounds(180, 70, 190, 30);
		cmbCiudadOrigen.setEnabled(false);
		cmbCiudadOrigen.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				cargarPlataformasOrigen();
				actualizarComboPaisDestino();
				cargarPaisesDestino();
				actualizarComboPlatOrigen();
				
				if (cmbCiudadOrigen.getSelectedIndex() != 0){
					CiudadUtil ciudad = (CiudadUtil)cmbCiudadOrigen.getSelectedItem();
					vC.setCiudadOrigen(ciudad.getCiudad());
				}else{
					vC.setCiudadOrigen("");
				}
				
			}
		});
		panelSalida.add(cmbCiudadOrigen);
		
		cmbPlatOrigen = new JComboBox<PlataformaUtil>();
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
					
					calcularDuracion();
				}
				
			}
		});
		dateChooserFechaSalida.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				dateChooserFechaLlegada.setDate(dateChooserFechaSalida.getDate());
				dateChooserFechaLlegada.setMinSelectableDate(dateChooserFechaSalida.getDate());
				
				dateChooserFechaLlegada.validate();
				dateChooserFechaLlegada.repaint();
				
				calcularDuracion();
			}
		});
		dateChooserFechaSalida.setBounds(180, 150, 190, 30);
		panelSalida.add(dateChooserFechaSalida);
		
		cmbHoraSalida = new JComboBox<String>();
		cmbHoraSalida.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
			
				if (dateChooserFechaSalida.getDate().equals(dateChooserFechaLlegada.getDate())){
					
					if (cmbHoraSalida.getSelectedIndex() >= cmbHoraLlegada.getSelectedIndex()){
						cmbHoraLlegada.setSelectedIndex(cmbHoraSalida.getSelectedIndex());
						cmbMinutoLlegada.setSelectedIndex(cmbMinutoSalida.getSelectedIndex());
					}
				}
				
				calcularDuracion();
				
			}
		});
		cmbHoraSalida.setBounds(180, 190, 50, 30);
		panelSalida.add(cmbHoraSalida);
		cmbHoraSalida.setModel(new DefaultComboBoxModel<String>(modelHora));
		
		JLabel label1 = new JLabel(":");
		label1.setBounds(240, 190, 15, 30);
		panelSalida.add(label1);
		
		cmbMinutoSalida = new JComboBox<String>();
		cmbMinutoSalida.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
			
				if (dateChooserFechaSalida.getDate().equals(dateChooserFechaLlegada.getDate())){
					if (cmbMinutoSalida.getSelectedIndex() > cmbMinutoLlegada.getSelectedIndex() && cmbHoraSalida.getSelectedIndex() >= cmbHoraLlegada.getSelectedIndex()){
						cmbMinutoLlegada.setSelectedIndex(cmbMinutoSalida.getSelectedIndex());
					}
				}
			
				calcularDuracion();
				
			}
		});
		cmbMinutoSalida.setBounds(255, 190, 50, 30);
		panelSalida.add(cmbMinutoSalida);
		cmbMinutoSalida.setModel(new DefaultComboBoxModel<String>(modelMinuto));
		
		vC.setPaisOrigen("");
		vC.setCiudadOrigen("");
		vC.setPlataformaOrigen("");
		vC.setFechaSalida(null);
		vC.setHoraSalida(Time.valueOf("00:00:00"));
		
	}
	
	private void agregarCamposPanelSalidaAF(ViajeCabecera viaje) {

		String[] modelHora = new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
		String[] modelMinuto = new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};

		PaisUtil p = new PaisUtil(viaje.getPaisOrigen(), viaje.getShortPaisOrigen());
		CiudadUtil c = new CiudadUtil(viaje.getCiudadOrigen(), viaje.getShortPaisOrigen());
		PlataformaUtil pl = new PlataformaUtil(viaje.getPlataformaOrigen(), viaje.getCiudadOrigen());
		
		
		cmbPaisOrigen = new JComboBox<PaisUtil>();
		cargarPaisesOrigen();
		cmbPaisOrigen.getModel().setSelectedItem(p);
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
		
		cmbCiudadOrigen = new JComboBox<CiudadUtil>();
		cargarCiudadesOrigen();
		cmbCiudadOrigen.getModel().setSelectedItem(c);
		cmbCiudadOrigen.setBounds(180, 70, 190, 30);
		cmbCiudadOrigen.setEnabled(false);
		cmbCiudadOrigen.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				cargarPlataformasOrigen();
				actualizarComboPaisDestino();
				cargarPaisesDestino();
				actualizarComboPlatOrigen();
				
				if (cmbCiudadOrigen.getSelectedIndex() != 0){
					CiudadUtil ciudad = (CiudadUtil)cmbCiudadOrigen.getSelectedItem();
					vC.setCiudadOrigen(ciudad.getCiudad());
				}else{
					vC.setCiudadOrigen("");
				}
				
			}
		});
		panelSalida.add(cmbCiudadOrigen);
		
		cmbPlatOrigen = new JComboBox<PlataformaUtil>();
		cargarPlataformasOrigen();
		cmbPlatOrigen.getModel().setSelectedItem(pl);
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
		dateChooserFechaSalida.setDate(viaje.getFechaSalida());
		dateChooserFechaSalida.setMinSelectableDate(now);
		dateChooserFechaSalida.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				
				if (dateChooserFechaSalida.getDate() != null){
					
					dateChooserFechaLlegada.setDate(dateChooserFechaSalida.getDate());
					dateChooserFechaLlegada.setMinSelectableDate(dateChooserFechaSalida.getDate());
					
					dateChooserFechaLlegada.validate();
					dateChooserFechaLlegada.repaint();
					
					calcularDuracion();
				}
				
			}
		});
		dateChooserFechaSalida.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				dateChooserFechaLlegada.setDate(dateChooserFechaSalida.getDate());
				dateChooserFechaLlegada.setMinSelectableDate(dateChooserFechaSalida.getDate());
				
				dateChooserFechaLlegada.validate();
				dateChooserFechaLlegada.repaint();
				
				calcularDuracion();
			}
		});
		dateChooserFechaSalida.setBounds(180, 150, 190, 30);
		panelSalida.add(dateChooserFechaSalida);
		
		cmbHoraSalida = new JComboBox<String>();
		cmbHoraSalida.setModel(new DefaultComboBoxModel<String>(modelHora));
		cmbHoraSalida.getModel().setSelectedItem(viaje.getHoraSalida().toString().substring(0, 2));
		cmbHoraSalida.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
			
				if (dateChooserFechaSalida.getDate().equals(dateChooserFechaLlegada.getDate())){
					
					if (cmbHoraSalida.getSelectedIndex() >= cmbHoraLlegada.getSelectedIndex()){
						cmbHoraLlegada.setSelectedIndex(cmbHoraSalida.getSelectedIndex());
						cmbMinutoLlegada.setSelectedIndex(cmbMinutoSalida.getSelectedIndex());
					}
				}
				
				calcularDuracion();
				
			}
		});
		cmbHoraSalida.setBounds(180, 190, 50, 30);
		panelSalida.add(cmbHoraSalida);
		
		JLabel label1 = new JLabel(":");
		label1.setBounds(240, 190, 15, 30);
		panelSalida.add(label1);
		
		cmbMinutoSalida = new JComboBox<String>();
		cmbMinutoSalida.setModel(new DefaultComboBoxModel<String>(modelMinuto));
		cmbMinutoSalida.getModel().setSelectedItem(viaje.getHoraSalida().toString().substring(3, 5));
		cmbMinutoSalida.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
			
				if (dateChooserFechaSalida.getDate().equals(dateChooserFechaLlegada.getDate())){
					if (cmbMinutoSalida.getSelectedIndex() > cmbMinutoLlegada.getSelectedIndex() && cmbHoraSalida.getSelectedIndex() >= cmbHoraLlegada.getSelectedIndex()){
						cmbMinutoLlegada.setSelectedIndex(cmbMinutoSalida.getSelectedIndex());
					}
				}
			
				calcularDuracion();
				
			}
		});
		cmbMinutoSalida.setBounds(255, 190, 50, 30);
		panelSalida.add(cmbMinutoSalida);
		
		vC.setPaisOrigen(viaje.getPaisOrigen());
		vC.setShortPaisOrigen(viaje.getShortPaisOrigen());
		vC.setCiudadOrigen(viaje.getCiudadOrigen());
		vC.setPlataformaOrigen(viaje.getPlataformaOrigen());
		vC.setFechaSalida(viaje.getFechaSalida());
		vC.setHoraSalida(viaje.getHoraSalida());
		
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
		
		cmbPaisOrigen.setModel(new DefaultComboBoxModel<PaisUtil>(modelPaises));
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
		
		cmbCiudadOrigen.setModel(new DefaultComboBoxModel<CiudadUtil>(modelCiudades));
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
		
		cmbPlatOrigen.setModel(new DefaultComboBoxModel<PlataformaUtil>(modelPlataformas));
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
		
	private void agregarPanelLlegadaAF(ViajeCabecera viaje) {
		
		panelLlegada = new JPanel();
		panelLlegada.setLayout(null);
		panelLlegada.setBackground(Color.WHITE);
		panelLlegada.setBorder(new TitledBorder(null, "Llegada", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panelLlegada.setBounds(440, 70, 400, 250);
		getContentPane().add(panelLlegada);

		agregarLabelsPanelLlegada();
		agregarCamposPanelLlegadaAF(viaje);
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
		
		
		cmbPaisDestino = new JComboBox<PaisUtil>();
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
		
		cmbCiudadDestino = new JComboBox<CiudadUtil>();
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
		
		cmbPlatDestino = new JComboBox<PlataformaUtil>();
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
				
				calcularDuracion();
				
			}
		});
		dateChooserFechaLlegada.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				//calcularDuracion();
			}
		});
		dateChooserFechaLlegada.setBounds(180, 150, 190, 30);
		panelLlegada.add(dateChooserFechaLlegada);
		
		cmbHoraLlegada = new JComboBox<String>();
		cmbHoraLlegada.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				if (dateChooserFechaSalida.getDate().equals(dateChooserFechaLlegada.getDate())){
					
					if (cmbHoraLlegada.getSelectedIndex() < cmbHoraSalida.getSelectedIndex()){
						cmbHoraLlegada.setSelectedIndex(cmbHoraSalida.getSelectedIndex());
					}
				}
				
				calcularDuracion();

			}
		});
		cmbHoraLlegada.setBounds(180, 190, 50, 30);
		cmbHoraLlegada.setModel(new DefaultComboBoxModel<String>(modelHora));
		panelLlegada.add(cmbHoraLlegada);
		
		JLabel label2 = new JLabel(":");
		label2.setFont(new Font("DejaVu Sans", Font.PLAIN, 14));
		label2.setBounds(240, 190, 15, 30);
		panelLlegada.add(label2);
		
		cmbMinutoLlegada = new JComboBox<String>();
		cmbMinutoLlegada.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				if (dateChooserFechaSalida.getDate().equals(dateChooserFechaLlegada.getDate())){
					
					if ( (cmbMinutoLlegada.getSelectedIndex() < cmbMinutoSalida.getSelectedIndex()) && (cmbHoraLlegada.getSelectedIndex() <= cmbHoraSalida.getSelectedIndex()) ){
						cmbMinutoLlegada.setSelectedIndex(cmbMinutoSalida.getSelectedIndex());
					}

				}
				
				calcularDuracion();
				
			}
		});
		cmbMinutoLlegada.setBounds(255, 190, 50, 30);
		cmbMinutoLlegada.setModel(new DefaultComboBoxModel<String>(modelMinuto));
		panelLlegada.add(cmbMinutoLlegada);

		vC.setPaisDestino("");
		vC.setCiudadDestino("");
		vC.setPlataformaDestino("");
		vC.setFechaLlegada(null);
		vC.setHoraLlegada(Time.valueOf("00:00:00"));
	
	}

	private void agregarCamposPanelLlegadaAF(ViajeCabecera viaje) {

		String[] modelHora = new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
		String[] modelMinuto = new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};
		
		PaisUtil p = new PaisUtil(viaje.getPaisDestino(), viaje.getShortPaisDestino());
		CiudadUtil c = new CiudadUtil(viaje.getCiudadDestino(), viaje.getShortPaisDestino());
		PlataformaUtil pl = new PlataformaUtil(viaje.getPlataformaDestino(), viaje.getCiudadDestino());
		
		
		cmbPaisDestino = new JComboBox<PaisUtil>();
		cargarPaisesDestino();
		cmbPaisDestino.getModel().setSelectedItem(p);
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
		cmbPaisDestino.setBounds(180, 30, 190, 30);
		panelLlegada.add(cmbPaisDestino);
		
		cmbCiudadDestino = new JComboBox<CiudadUtil>();
		cargarCiudadesDestino();
		cmbCiudadDestino.getModel().setSelectedItem(c);
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
		
		cmbPlatDestino = new JComboBox<PlataformaUtil>();
		cargarPlataformasDestino();
		cmbPlatDestino.getModel().setSelectedItem(pl);
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
		dateChooserFechaLlegada.setDate(viaje.getFechaLlegada());
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
				
				calcularDuracion();
				
			}
		});
		dateChooserFechaLlegada.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				calcularDuracion();
			}
		});
		dateChooserFechaLlegada.setBounds(180, 150, 190, 30);
		panelLlegada.add(dateChooserFechaLlegada);
		
		cmbHoraLlegada = new JComboBox<String>();
		cmbHoraLlegada.setModel(new DefaultComboBoxModel<String>(modelHora));
		cmbHoraLlegada.getModel().setSelectedItem(viaje.getHoraLlegada().toString().substring(0, 2));
		cmbHoraLlegada.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				if (dateChooserFechaSalida.getDate().equals(dateChooserFechaLlegada.getDate())){
					
					if (cmbHoraLlegada.getSelectedIndex() < cmbHoraSalida.getSelectedIndex()){
						cmbHoraLlegada.setSelectedIndex(cmbHoraSalida.getSelectedIndex());
					}
				}
				
				calcularDuracion();

			}
		});
		cmbHoraLlegada.setBounds(180, 190, 50, 30);
		panelLlegada.add(cmbHoraLlegada);
		
		JLabel label2 = new JLabel(":");
		label2.setFont(new Font("DejaVu Sans", Font.PLAIN, 14));
		label2.setBounds(240, 190, 15, 30);
		panelLlegada.add(label2);
		
		cmbMinutoLlegada = new JComboBox<String>();
		cmbMinutoLlegada.setModel(new DefaultComboBoxModel<String>(modelMinuto));
		cmbMinutoLlegada.getModel().setSelectedItem(viaje.getHoraLlegada().toString().substring(3, 5));
		cmbMinutoLlegada.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				if (dateChooserFechaSalida.getDate().equals(dateChooserFechaLlegada.getDate())){
					
					if ( (cmbMinutoLlegada.getSelectedIndex() < cmbMinutoSalida.getSelectedIndex()) && (cmbHoraLlegada.getSelectedIndex() <= cmbHoraSalida.getSelectedIndex()) ){
						cmbMinutoLlegada.setSelectedIndex(cmbMinutoSalida.getSelectedIndex());
					}

				}
				
				calcularDuracion();
				
			}
		});
		cmbMinutoLlegada.setBounds(255, 190, 50, 30);
		panelLlegada.add(cmbMinutoLlegada);

		vC.setPaisDestino(viaje.getPaisDestino());
		vC.setShortPaisDestino(viaje.getShortPaisDestino());
		vC.setCiudadDestino(viaje.getCiudadDestino());
		vC.setPlataformaDestino(viaje.getPlataformaDestino());
		vC.setFechaLlegada(viaje.getFechaLlegada());
		vC.setHoraLlegada(viaje.getHoraLlegada());
	
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
			
			cmbPaisDestino.setModel(new DefaultComboBoxModel<PaisUtil>(modelPaises));
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
		
		cmbCiudadDestino.setModel(new DefaultComboBoxModel<CiudadUtil>(modelCiudades));
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
		
		cmbPlatDestino.setModel(new DefaultComboBoxModel<PlataformaUtil>(modelPlataformas));
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
	
	private void agregarPanelPreciosAF(ViajeCabecera viaje) {
		panelPrecios = new JPanel();
		panelPrecios.setLayout(null);
		panelPrecios.setBackground(Color.WHITE);
		panelPrecios.setBorder(new TitledBorder(null, "Precios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panelPrecios.setBounds(20, 345, 290, 130);
		getContentPane().add(panelPrecios);
		
		agregarLabelsPanelPrecios();
		agregarCamposPanelPreciosAF(viaje);
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

					Float precioTur = Float.parseFloat(txtPrecioTurista.getText());
					Float precioPrim = 1.5f*precioTur;
					
					txtPrecioPrimera.setText(precioPrim.toString());
					
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
					
					Float precioTur = Float.parseFloat(txtPrecioTurista.getText());
					Float precioPrim = 1.5f*precioTur;
					
					txtPrecioPrimera.setText(precioPrim.toString());
					
				}else{
					vC.setPrecioClaseTur(-1f);
				}

			}

		});
		txtPrecioTurista.setBounds(170, 30, 100, 30);
		panelPrecios.add(txtPrecioTurista);
	
		txtPrecioPrimera = new JTextField();
		txtPrecioPrimera.setEditable(false);
		txtPrecioPrimera.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				
				if (txtPrecioPrimera.getText().length() > 0){
					vC.setPrecioClasePrim(Float.parseFloat(txtPrecioPrimera.getText()));				
				}else{
					vC.setPrecioClasePrim(-1f);
				}
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				
				if (txtPrecioPrimera.getText().length() > 0){
					vC.setPrecioClasePrim(Float.parseFloat(txtPrecioPrimera.getText()));				
				}else{
					vC.setPrecioClasePrim(-1f);
				}
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});
		txtPrecioPrimera.setBounds(170, 70, 100, 30);
		panelPrecios.add(txtPrecioPrimera);
		
		vC.setPrecioClaseTur(-1f);
		vC.setPrecioClasePrim(-1f);
	}

	private void agregarCamposPanelPreciosAF(ViajeCabecera viaje) {

		txtPrecioTurista = new JTextField(viaje.getPrecioClaseTur().toString());
		txtPrecioTurista.setToolTipText("SOLO NUMEROS Y .(PUNTO). POR EJ: 120.04");
		txtPrecioTurista.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if (txtPrecioTurista.getText().trim().length() > 0){
					vC.setPrecioClaseTur(Float.parseFloat(txtPrecioTurista.getText()));	

					Float precioTur = Float.parseFloat(txtPrecioTurista.getText());
					Float precioPrim = 1.5f*precioTur;
					
					txtPrecioPrimera.setText(precioPrim.toString());
					
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
					
					Float precioTur = Float.parseFloat(txtPrecioTurista.getText());
					Float precioPrim = 1.5f*precioTur;
					
					txtPrecioPrimera.setText(precioPrim.toString());
					
				}else{
					vC.setPrecioClaseTur(-1f);
				}

			}

		});
		txtPrecioTurista.setBounds(170, 30, 100, 30);
		panelPrecios.add(txtPrecioTurista);
	
		txtPrecioPrimera = new JTextField(viaje.getPrecioClasePrim().toString());
		txtPrecioPrimera.setEditable(false);
		txtPrecioPrimera.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				
				if (txtPrecioPrimera.getText().length() > 0){
					vC.setPrecioClasePrim(Float.parseFloat(txtPrecioPrimera.getText()));				
				}else{
					vC.setPrecioClasePrim(-1f);
				}
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				
				if (txtPrecioPrimera.getText().length() > 0){
					vC.setPrecioClasePrim(Float.parseFloat(txtPrecioPrimera.getText()));				
				}else{
					vC.setPrecioClasePrim(-1f);
				}
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});
		txtPrecioPrimera.setBounds(170, 70, 100, 30);
		panelPrecios.add(txtPrecioPrimera);
		
		vC.setPrecioClaseTur(viaje.getPrecioClaseTur());
		vC.setPrecioClasePrim(viaje.getPrecioClasePrim());
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
	
	private void agregarPanelImagenesAF(ViajeCabecera viaje) {

		panelImagenes = new JPanel();
		panelImagenes.setLayout(null);
		panelImagenes.setBackground(Color.WHITE);		
		panelImagenes.setBorder(new TitledBorder(null, "Imagenes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panelImagenes.setBounds(330, 345, 510, 130);
		getContentPane().add(panelImagenes);
		
		agregarLabelsPanelImagenes();
		agregarCamposPanelImagenesAF(viaje);
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
	
	private void agregarCamposPanelImagenesAF(ViajeCabecera viaje) {

		txtImagen1 = new JTextField(viaje.getImagen1());
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
		
		txtImagen2 = new JTextField(viaje.getImagen2());
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
		
		vC.setImagen1(viaje.getImagen1());
		vC.setImagen2(viaje.getImagen2());
	}
	
	private void actionBtnImagen1() {

		JFileChooser imagen1 = new JFileChooser("/home/ivang94/workspace/ProyectoFinal/src/imagenes");
		
		imagen1.setFileFilter(filterpng);
		imagen1.setFileFilter(filterjpg);
		
		int opcion = imagen1.showOpenDialog(this);
		
		if (opcion == JFileChooser.APPROVE_OPTION){
			txtImagen1.setText(imagen1.getSelectedFile().getPath().substring(41));
		}
		
	}
	
	private void actionBtnImagen2(){
		
		JFileChooser imagen2 = new JFileChooser("/home/ivang94/workspace/ProyectoFinal/src/imagenes");
		
		imagen2.setFileFilter(filterpng);
		imagen2.setFileFilter(filterjpg);
		
		int opcion = imagen2.showOpenDialog(this);
		
		if (opcion == JFileChooser.APPROVE_OPTION){
			txtImagen2.setText(imagen2.getSelectedFile().getPath().substring(41));
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
	
	private void agregarPanelInfoExtraAF(ViajeCabecera viaje) {
		
		panelInfoExtra = new JPanel();
		panelInfoExtra.setBounds(25, 495, 815, 90);
		panelInfoExtra.setBackground(Color.WHITE);
		getContentPane().add(panelInfoExtra);
		panelInfoExtra.setLayout(null);
		panelInfoExtra.setBorder(new TitledBorder(null, "Informacion extra", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		
		agregarLabelsPanelInfoExtra();
		agregarCamposPanelInfoExtraAF(viaje);
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

		String[] modelHora = new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
		String[] modelMinuto = new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};
		
		txtDistancia = new JTextField();
		txtDistancia.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if (txtDistancia.getText().trim().length() > 0){
					vC.setDistancia(Integer.parseInt(txtDistancia.getText()));						
				}else{
					vC.setDistancia(-1);
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
					vC.setDistancia(Integer.parseInt(txtDistancia.getText()));						
				}else{
					vC.setDistancia(-1);
				}
			}

		});
		txtDistancia.setBounds(120, 30, 125, 30);
		panelInfoExtra.add(txtDistancia);

		cmbHoraDuracion = new JComboBox<String>();
		cmbHoraDuracion.setEnabled(false);
		cmbHoraDuracion.setModel(new DefaultComboBoxModel<>(modelHora));
		cmbHoraDuracion.setBounds(375, 30, 50, 30);
		panelInfoExtra.add(cmbHoraDuracion);
		
		JLabel label3 = new JLabel(":");
		label3.setFont(new Font("DejaVu Sans", Font.PLAIN, 14));
		label3.setBounds(435, 30, 15, 30);
		panelInfoExtra.add(label3);
		
		cmbMinutoDuracion = new JComboBox<String>();
		cmbMinutoDuracion.setEnabled(false);
		cmbMinutoDuracion.setModel(new DefaultComboBoxModel<>(modelMinuto));
		cmbMinutoDuracion.setBounds(450, 30, 50, 30);
		panelInfoExtra.add(cmbMinutoDuracion);
		
		txtCupo = new JTextField();
		txtCupo.setEditable(false);
		txtCupo.setText("66");
		txtCupo.setBounds(620, 30, 165, 30);
		panelInfoExtra.add(txtCupo);
		
		vC.setDistancia(-1);
		vC.setDuracion(Time.valueOf("00:00:00"));
		vC.setCupo(Integer.parseInt(txtCupo.getText()));
	}

	private void agregarCamposPanelInfoExtraAF(ViajeCabecera viaje) {

		String[] modelHora = new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
		String[] modelMinuto = new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};
		
		txtDistancia = new JTextField(viaje.getDistancia().toString());
		txtDistancia.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if (txtDistancia.getText().trim().length() > 0){
					vC.setDistancia(Integer.parseInt(txtDistancia.getText()));						
				}else{
					vC.setDistancia(-1);
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
					vC.setDistancia(Integer.parseInt(txtDistancia.getText()));						
				}else{
					vC.setDistancia(-1);
				}
			}

		});
		txtDistancia.setBounds(120, 30, 125, 30);
		panelInfoExtra.add(txtDistancia);

		cmbHoraDuracion = new JComboBox<String>();
		cmbHoraDuracion.setModel(new DefaultComboBoxModel<String>(modelHora));
		cmbHoraDuracion.getModel().setSelectedItem(viaje.getDuracion().toString().substring(0, 2));
		cmbHoraDuracion.setEnabled(false);
		cmbHoraDuracion.setBounds(375, 30, 50, 30);
		panelInfoExtra.add(cmbHoraDuracion);
		
		JLabel label3 = new JLabel(":");
		label3.setFont(new Font("DejaVu Sans", Font.PLAIN, 14));
		label3.setBounds(435, 30, 15, 30);
		panelInfoExtra.add(label3);
		
		cmbMinutoDuracion = new JComboBox<String>();
		cmbMinutoDuracion.setModel(new DefaultComboBoxModel<String>(modelMinuto));
		cmbMinutoDuracion.getModel().setSelectedItem(viaje.getDuracion().toString().substring(3, 5));
		cmbMinutoDuracion.setEnabled(false);
		cmbMinutoDuracion.setBounds(450, 30, 50, 30);
		panelInfoExtra.add(cmbMinutoDuracion);
		
		txtCupo = new JTextField(viaje.getCupo());
		txtCupo.setEditable(false);
		txtCupo.setText("66");
		txtCupo.setBounds(620, 30, 165, 30);
		panelInfoExtra.add(txtCupo);
		
		vC.setDistancia(viaje.getDistancia());
		vC.setDuracion(viaje.getDuracion());
		vC.setCupo(viaje.getCupo());
	}
	
	private void calcularDuracion(){
		
		Integer horaSalida = Integer.parseInt(cmbHoraSalida.getSelectedItem().toString());
		Integer minutoSalida = Integer.parseInt(cmbMinutoSalida.getSelectedItem().toString());
		
		Integer horaLlegada = Integer.parseInt(cmbHoraLlegada.getSelectedItem().toString());
		Integer minutoLlegada = Integer.parseInt(cmbMinutoLlegada.getSelectedItem().toString());
		
		Integer diferenciaHoras = null;
		Integer diferenciaMinutos = null;
	
		diferenciaHoras = horaLlegada-horaSalida;
		diferenciaMinutos = minutoLlegada-minutoSalida;

		if (dateChooserFechaSalida.getDate().equals( dateChooserFechaLlegada.getDate() )){
			
			if (diferenciaMinutos < 0){
				diferenciaHoras -= 1;
				diferenciaMinutos += 60;
			}
			
		}else{

			diferenciaHoras += 24;
			
			if (diferenciaMinutos < 0){
				diferenciaHoras -= 1;
				diferenciaMinutos += 60;
			}
			
		}

		if (diferenciaHoras<10){
			cmbHoraDuracion.setSelectedItem(new String("0"+diferenciaHoras.toString()));
		}else{
			cmbHoraDuracion.setSelectedItem(new String(diferenciaHoras.toString()));
		}
		
		if (diferenciaMinutos<10){
			cmbMinutoDuracion.setSelectedItem(new String("0"+diferenciaMinutos.toString()));
		}else{
			cmbMinutoDuracion.setSelectedItem(new String(diferenciaMinutos.toString()));	
		}
		
	}
	
	private void agregarBotonCargarVuelo() {
		
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
				
				vC.setOferta("0.0");
				vC.setImagenOferta("");
				
				try {
					
					vCBo.verificarTodos(vC);
					
					vCBo.cargarVuelo(vC);
					
					JOptionPane.showMessageDialog(null, "Se ha cargado el vuelo con exito!"); 

					dispose();
					
					continuarCargando();
					
				} catch (ViajeCabeceraNotValidException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

			}
		});
		btnCargarVuelo.setBounds(25, 605, 170, 35);
		getContentPane().add(btnCargarVuelo);
	}
	
	private void agregarBotonGuardarCambios() {
		
		btnCargarVuelo = new JButton("Guardar Cambios");
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
				
				vC.setOferta("0.0");
				vC.setImagenOferta("");
				
				try {
					
					vCBo.verificarTodos(vC);
					
					vCBo.modificarVuelo(vC);
					
					JOptionPane.showMessageDialog(null, "Se ha modificado el vuelo con exito!"); 

					dispose();
					
				} catch (ViajeCabeceraNotValidException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
		btnCargarVuelo.setBounds(25, 605, 170, 35);
		getContentPane().add(btnCargarVuelo);
	}
	
	private void continuarCargando() {
		
		String ObjButtons[] = {"No","Si"};
	    
		int PromptResult = JOptionPane.showOptionDialog(null, 
	        "¿Desea seguir cargando vuelos?", "Mensaje", 
	        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
	        ObjButtons,ObjButtons[0]);

		if (PromptResult == 1){
			DialogLoadFlight dlf = new DialogLoadFlight();
			dlf.setVisible(true);
		}
	}

}