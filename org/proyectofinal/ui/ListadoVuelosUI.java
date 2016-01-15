package org.proyectofinal.ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.proyectofinal.dao.ex.NoFlightsFoundException;
import org.proyectofinal.dao.impl.ViajeCabeceraDaoImpl;
import org.proyectofinal.dao.interfaces.ViajeCabeceraDao;
import org.proyectofinal.model.impl.ViajeCabeceraImpl;
import org.proyectofinal.model.interfaces.ViajeCabecera;

import com.toedter.calendar.JDateChooser;

public class ListadoVuelosUI extends JFrame {

	private static final long serialVersionUID = -7151479179908930375L;
	private JPanel contentPane;
	private JTable table;
	private JDateChooser dateChooserSalida;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbOrigen;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbDestino;
	private ViajeCabeceraDao vCDao;
//	private AbstractDao aDao;
	private ViajeCabecera vC;
	private JButton btnContinuar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoVuelosUI frame = new ListadoVuelosUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "serial" })
	public ListadoVuelosUI() {
		setResizable(false);
		
		vC = new ViajeCabeceraImpl();

//		aDao = new ViajeCabeceraDaoImpl();

		vCDao = new ViajeCabeceraDaoImpl();
		
		setTitle("Listado de Vuelos");
		setSize(970, 496);
		
		addWindowFocusListener(new WindowFocusListener() {
			
			public void windowGainedFocus(WindowEvent e) {
				
				java.util.Date date = dateChooserSalida.getDate();
				
				Date dateSQL = new Date(date.getTime());
				
				vC.setFechaSalida(dateSQL);
				
//				cmbOrigen.removeAllItems();
//				
//				try {
//					
//					vCDao.conectar();
//					
//					ResultSet res = vCDao.consultarOrigenes();
//					
//					while (res.next()){
//						cmbOrigen.addItem(res.getString("ciudadOrigen") + ", " + res.getString("paisOrigen"));
//					}
//					
//					if (cmbOrigen.getSelectedItem() != null){
//						String[] origen = cmbOrigen.getSelectedItem().toString().split(", ");
//					
//						vC.setCiudadOrigen(origen[0]);
//						vC.setPaisOrigen(origen[1]);
//					}
//					
//					vCDao.desconectar();
//					
//				} catch (ClassNotFoundException e1) {
//					JOptionPane.showMessageDialog(null, e1.getMessage());
//				} catch (SQLException e1) {
//					JOptionPane.showMessageDialog(null, e1.getMessage());
//				}
				
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOrigen = new JLabel("Origen: ");
		lblOrigen.setHorizontalTextPosition(SwingConstants.LEADING);
		lblOrigen.setFont(new Font("Dialog", Font.BOLD, 14));
		lblOrigen.setBounds(30, 15, 70, 25);
		contentPane.add(lblOrigen);

		cmbOrigen = new JComboBox();
		cmbOrigen.addPropertyChangeListener(new PropertyChangeListener() {
			@SuppressWarnings("unchecked")
			public void propertyChange(PropertyChangeEvent arg0) {
			
				cmbOrigen.removeAllItems();
				cmbDestino.removeAllItems();
				
				try {
					
					vCDao.conectar();
					
					ResultSet res = vCDao.consultarOrigenes();

					while (res.next()){
						cmbOrigen.addItem(res.getString("ciudadOrigen") + ", " + res.getString("paisOrigen"));
					}
					
					vCDao.desconectar();
					
//					vCDao.conectar();
//					
//					res = vCDao.consultarDestinos();
//
//					while (res.next()){
//						if (!cmbOrigen.getSelectedItem().equals(res.getString("ciudadDestino") + ", " + res.getString("paisDestino"))){	
//							cmbDestino.addItem(res.getString("ciudadDestino") + ", " + res.getString("paisDestino"));
//						}
//					}
//
//					vCDao.desconectar();
//					
//					cmbDestino.validate();
//					cmbDestino.repaint();
					
				} catch (ClassNotFoundException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
				if (cmbOrigen.getSelectedItem() != null){
					
					String[] origen = cmbOrigen.getSelectedItem().toString().split(", ");
				
					vC.setCiudadOrigen(origen[0]);
					vC.setPaisOrigen(origen[1]);
				}

//				if (cmbDestino.getSelectedItem() != null){
//					
//					String[] destino = cmbDestino.getSelectedItem().toString().split(", ");
//					
//					vC.setCiudadDestino(destino[0]);
//					vC.setPaisDestino(destino[1]);	
//				}
			
			}
		});
		cmbOrigen.addItemListener(new ItemListener() {
			@SuppressWarnings("unchecked")
			public void itemStateChanged(ItemEvent arg0) {
				
//				cmbOrigen.removeAllItems();
				cmbDestino.removeAllItems();
				
				ResultSet res;
				
				try {
					
//					vCDao.conectar();
//					
//					ResultSet res = vCDao.consultarOrigenes();
//
//					while (res.next()){
//						cmbOrigen.addItem(res.getString("ciudadOrigen") + ", " + res.getString("paisOrigen"));
//					}
//					
//					vCDao.desconectar();
//					
					vCDao.conectar();
					
					res = vCDao.consultarDestinos();

					if (cmbOrigen.getSelectedItem() != null){
						while (res.next()){
							if (!cmbOrigen.getSelectedItem().equals(res.getString("ciudadDestino") + ", " + res.getString("paisDestino"))){	
								cmbDestino.addItem(res.getString("ciudadDestino") + ", " + res.getString("paisDestino"));
							}
						}
					}
					vCDao.desconectar();
					
					cmbDestino.validate();
					cmbDestino.repaint();
					
				} catch (ClassNotFoundException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
				if (cmbOrigen.getSelectedItem() != null){
					
					String[] origen = cmbOrigen.getSelectedItem().toString().split(", ");
				
					vC.setCiudadOrigen(origen[0]);
					vC.setPaisOrigen(origen[1]);
				}

				if (cmbDestino.getSelectedItem() != null){
					
					String[] destino = cmbDestino.getSelectedItem().toString().split(", ");
					
					vC.setCiudadDestino(destino[0]);
					vC.setPaisDestino(destino[1]);	
				}
				
			}
		});
		cmbOrigen.setBounds(100, 15, 210, 25);
		contentPane.add(cmbOrigen);
		
		JLabel lblDestino = new JLabel("Destino: ");
		lblDestino.setHorizontalTextPosition(SwingConstants.LEADING);
		lblDestino.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDestino.setBounds(330, 15, 80, 25);
		contentPane.add(lblDestino);

		cmbDestino = new JComboBox();
		cmbDestino.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				if (cmbDestino.getSelectedItem() != null){
					
					String[] destino = cmbDestino.getSelectedItem().toString().split(", ");
				
					vC.setCiudadDestino(destino[0]);
					vC.setPaisDestino(destino[1]);
				}
				
			}
		});
		cmbDestino.setBounds(408, 15, 210, 25);
		contentPane.add(cmbDestino);		
		
		JLabel lblFechaSalida = new JLabel("Fecha de Salida: ");
		lblFechaSalida.setHorizontalTextPosition(SwingConstants.LEADING);
		lblFechaSalida.setFont(new Font("Dialog", Font.BOLD, 14));
		lblFechaSalida.setBounds(30, 55, 150, 25);
		contentPane.add(lblFechaSalida);
		
		// Fecha por defecto del JDateChooser: Fecha Actual
		Calendar date = new GregorianCalendar();
		
		dateChooserSalida = new JDateChooser();
		dateChooserSalida.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				
				java.util.Date date = dateChooserSalida.getDate();
				
				Date dateSQL = new Date(date.getTime());
				
				vC.setFechaSalida(dateSQL);
			}
		});
		dateChooserSalida.setBounds(175, 55, 150, 25);
		dateChooserSalida.setCalendar(date);
		contentPane.add(dateChooserSalida);
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 142, 907, 290);		
		contentPane.add(scrollPane);

		btnContinuar = new JButton("Continuar..");
		btnContinuar.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
			
				if (e.getSource() == btnContinuar){

					Integer filaSelecc = table.getSelectedRow();
					
					ReservaBoletoUI ui = new ReservaBoletoUI();
					
					ui.setVisible(true);
					
					ui.getLblNumeroDeViaje().setText(ui.getLblNumeroDeViaje().getText() + table.getValueAt(filaSelecc, 0));
					ui.getLblOrigen().setText(ui.getLblOrigen().getText() + table.getValueAt(filaSelecc, 1));
					ui.getLblDestino().setText(ui.getLblDestino().getText() + table.getValueAt(filaSelecc, 2));

					ui.getLblSalida().setText(ui.getLblSalida().getText() + table.getValueAt(filaSelecc, 3).toString().substring(0, 10) + " -- Hora: " + table.getValueAt(filaSelecc, 3).toString().substring(11, 16));
					
					ui.getLblLlegada().setText(ui.getLblLlegada().getText() + table.getValueAt(filaSelecc, 4).toString().substring(0, 10) + " -- Hora: " + table.getValueAt(filaSelecc, 4).toString().substring(11, 16));
					
					ui.getLblAsientosDisp().setText(ui.getLblAsientosDisp().getText() + table.getValueAt(filaSelecc, 5));
					
					int cant = (int) table.getValueAt(filaSelecc, 5); 
					
					Object[] cantidad = new Object[cant];
					
					for(int i = 1; i < cantidad.length; i++){
						cantidad[0] = 0;
						cantidad[i] = i;
					}
					
					ui.getComboBox().setModel(new DefaultComboBoxModel(cantidad));
										
				}
			
			}
		});
		btnContinuar.setEnabled(false);
		btnContinuar.setBounds(30, 448, 150, 35);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				if (table.getSelectedRows().length == 1){
					btnContinuar.setEnabled(true);
				}else{
					btnContinuar.setEnabled(false);
				}
				
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo Viaje", "Origen", "Destino", "Fecha de Salida", "Fecha de Llegada", "Cupo"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(103);
		table.getColumnModel().getColumn(1).setPreferredWidth(165);
		table.getColumnModel().getColumn(2).setPreferredWidth(165);
		table.getColumnModel().getColumn(3).setPreferredWidth(135);
		table.getColumnModel().getColumn(4).setPreferredWidth(135);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(51);
		
		final JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				
				if (e1.getSource() == btnConsultar){
		
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					
					try {
						
						int a = model.getRowCount() - 1;
						
						for(int i = a; i >= 0; i--){
							model.removeRow(0);
						}
						
						Object[] fila = new Object[8];
						
						vCDao.conectar();

						ResultSet res = vCDao.consultarVuelos(vC);
						
						String fecha = "";

						while (res.next()){

							fila[0] = res.getInt("codViaje");
							fila[1] = res.getString("ciudadOrigen") + ", " + res.getString("paisOrigen");
							fila[2] = res.getString("ciudadDestino") + ", " + res.getString("paisDestino");							
						
							fecha = res.getDate("fechaSalida").toString().substring(8, 10) + "-" + res.getDate("fechaSalida").toString().substring(5, 7) + "-" + res.getDate("fechaSalida").toString().substring(0, 4);
							
							fila[3] = fecha + " " + res.getTime("horaSalida").toString().substring(0, 5);
							
							fecha = res.getDate("fechaLlegada").toString().substring(8, 10) + "-" + res.getDate("fechaLlegada").toString().substring(5, 7) + "-" + res.getDate("fechaLlegada").toString().substring(0, 4);
							
							fila[4] = fecha + " " + res.getTime("horaLlegada").toString().substring(0, 5);
							
							fila[5] = res.getInt("cupo");
							
							model.addRow(fila);					
						}
						
						vCDao.desconectar();
					
						
					} catch (ClassNotFoundException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					} catch (NoFlightsFoundException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());						
					}

				}
			}
		});
		btnConsultar.setBounds(30, 95, 117, 25);
		contentPane.add(btnConsultar);
		
		JButton btnAgregar = new JButton("Agregar..");
		btnAgregar.setBounds(30, 448, 117, 30);
//		contentPane.add(btnAgregar);
		
		JButton btnEliminar = new JButton("Eliminar..");
		btnEliminar.setBounds(183, 448, 117, 30);
//		contentPane.add(btnEliminar);
		
		JButton btnModificar = new JButton("Modificar..");
		btnModificar.setBounds(333, 448, 117, 30);
//		contentPane.add(btnModificar);
		
	}
	
	public JButton getBtnContinuar() {
		return btnContinuar;
	}

	public void setBtnContinuar(JButton btnContinuar) {
		this.btnContinuar = btnContinuar;
	}

}