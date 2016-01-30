package org.proyectofinal.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import org.proyectofinal.model.interfaces.Usuario;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class panelUsuario extends JPanel {

	private static final long serialVersionUID = 1110184785861940930L;

	private JLabel lblDni;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblEmail;
	private JLabel lblTelefono;
	private JLabel lblCiudad;
	private JLabel lblPais;
	private JPanel panelDatosPersonales;
	private JPanel panelHistorialReservas;
	private JButton btnReservarBoleto;
	private JTable table;
	private JLabel lblCantidadDeReservas;
	private JScrollPane sPaneHistorialReservas;
	private JLabel lblBienvenido;
	
	@SuppressWarnings("serial")
	public panelUsuario(final Usuario u) {
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
//				getLblDni().validate();
//				getLblDni().repaint();
//				
//				getLblNombre().validate();
//				getLblNombre().repaint();
//				
//				getLblApellido().validate();
//				getLblApellido().repaint();
//				
//				getLblUsuario().validate();
//				getLblUsuario().repaint();
//				
//				getLblEmail().validate();
//				getLblEmail().repaint();
//				
//				getLblCiudad().validate();
//				getLblCiudad().repaint();
//				
//				getLblPais().validate();
//				getLblPais().repaint();
			}
		});
	
		setLayout(null);
		
		lblBienvenido = new JLabel("");
		lblBienvenido.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setForeground(Color.RED);
		lblBienvenido.setBounds(732, 12, 272, 25);
//		
//		lblBienvenido.setText("Bienvenido Administrador!");
//		lblBienvenido.setForeground(Color.RED);
//		lblBienvenido.setText("Bienvenido " + getLblNombre().getText() + "!");
//		lblBienvenido.setForeground(Color.BLACK);
//		add(lblBienvenido);
//		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(30, 30, 700, 399);
		add(tabbedPane);
		
		panelDatosPersonales = new JPanel();
		tabbedPane.addTab("Datos Personales", null, panelDatosPersonales, null);
		panelDatosPersonales.setLayout(null);
		
		lblDni = new JLabel("");
		lblDni.setHorizontalTextPosition(SwingConstants.LEADING);
		lblDni.setFont(new Font("Dialog", Font.BOLD, 15));
		lblDni.setBounds(127, 20, 233, 40);
		panelDatosPersonales.add(lblDni);
		
		lblNombre = new JLabel("");
		lblNombre.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNombre.setBounds(127, 70, 233, 40);
		panelDatosPersonales.add(lblNombre);
		
		
		lblApellido = new JLabel("");
		lblApellido.setHorizontalTextPosition(SwingConstants.LEADING);
		lblApellido.setFont(new Font("Dialog", Font.BOLD, 15));
		lblApellido.setBounds(127, 120, 233, 40);
		panelDatosPersonales.add(lblApellido);
		
		lblEmail = new JLabel("");
		lblEmail.setHorizontalTextPosition(SwingConstants.LEADING);
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 15));
		lblEmail.setBounds(127, 170, 233, 40);
		panelDatosPersonales.add(lblEmail);
		
		lblTelefono = new JLabel("");
		lblTelefono.setHorizontalTextPosition(SwingConstants.LEADING);
		lblTelefono.setFont(new Font("Dialog", Font.BOLD, 15));
		lblTelefono.setBounds(127, 220, 233, 40);
		panelDatosPersonales.add(lblTelefono);
		
		lblCiudad = new JLabel("");
		lblCiudad.setHorizontalTextPosition(SwingConstants.LEADING);
		lblCiudad.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCiudad.setBounds(127, 270, 233, 40);
		panelDatosPersonales.add(lblCiudad);
		
		lblPais = new JLabel("");
		lblPais.setHorizontalTextPosition(SwingConstants.LEADING);
		lblPais.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPais.setBounds(127, 320, 233, 40);
		panelDatosPersonales.add(lblPais);
		
		JLabel label1 = new JLabel("DNI: ");
		label1.setFont(new Font("Dialog", Font.BOLD, 15));
		label1.setBounds(36, 20, 80, 40);
		panelDatosPersonales.add(label1);
		
		JLabel label2 = new JLabel("Nombre: ");
		label2.setFont(new Font("Dialog", Font.BOLD, 15));
		label2.setBounds(36, 70, 80, 40);
		panelDatosPersonales.add(label2);
		
		JLabel label3 = new JLabel("Apellido:");
		label3.setFont(new Font("Dialog", Font.BOLD, 15));
		label3.setBounds(36, 120, 80, 40);
		panelDatosPersonales.add(label3);
		
		JLabel label4 = new JLabel("Email:");
		label4.setFont(new Font("Dialog", Font.BOLD, 15));
		label4.setBounds(36, 170, 80, 40);
		panelDatosPersonales.add(label4);
		
		JLabel label5 = new JLabel("Telefono:");
		label5.setFont(new Font("Dialog", Font.BOLD, 15));
		label5.setBounds(36, 220, 80, 40);
		panelDatosPersonales.add(label5);
		
		JLabel label6 = new JLabel("Ciudad:");
		label6.setFont(new Font("Dialog", Font.BOLD, 15));
		label6.setBounds(36, 270, 80, 40);
		panelDatosPersonales.add(label6);
		
		JLabel label7 = new JLabel("Pais:");
		label7.setFont(new Font("Dialog", Font.BOLD, 15));
		label7.setBounds(36, 320, 80, 40);
		panelDatosPersonales.add(label7);
		
		panelHistorialReservas = new JPanel();
		tabbedPane.addTab("Historial de Reservas", null, panelHistorialReservas, null);
		panelHistorialReservas.setLayout(null);
		
		sPaneHistorialReservas = new JScrollPane();
		sPaneHistorialReservas.setBounds(40, 70, 615, 231);
		panelHistorialReservas.add(sPaneHistorialReservas);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo Viaje", "Dni", "Fecha de Reserva", "Asiento", "Precio"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(114);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(131);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(71);
		sPaneHistorialReservas.setViewportView(table);
		
		lblCantidadDeReservas = new JLabel("Cantidad de Reservas: ");
		lblCantidadDeReservas.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCantidadDeReservas.setBounds(40, 12, 347, 46);
		panelHistorialReservas.add(lblCantidadDeReservas);
		
//		btnCambiarDatosPersonales = new JButton("<html><center>Cambiar<br />datos<br />personales<center></html>");
//		btnCambiarDatosPersonales.setBounds(780, 130, 180, 70);
//		add(btnCambiarDatosPersonales);
		
		btnReservarBoleto = new JButton("Reservar Boleto");
		btnReservarBoleto.setFont(new Font("Dialog", Font.BOLD, 16));
		btnReservarBoleto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if (e.getSource() == btnReservarBoleto){
					final ListadoVuelosUI ui = new ListadoVuelosUI(u);
					
					SwingUtilities.invokeLater(new Runnable() {
					    @Override public void run() {
					    	SwingUtilities.invokeLater(new Runnable() {
							    @Override public void run() {
							        ui.getTable().removeColumn(ui.getTable().getColumnModel().getColumn(6));
							    }
							});
					    }
					});
					ui.remove(ui.getBtnAgregar());
					
					ui.getContentPane().add(ui.getBtnContinuar());
					
					ui.setSize(970, 527);
					
					ui.setLocationRelativeTo(null);
//					ui.setResizable(false);
//					
					ui.validate();
					ui.repaint();

					ui.setVisible(true);
				}
			}
		});
		btnReservarBoleto.setBounds(30, 455, 228, 47);
		add(btnReservarBoleto);
				
		setVisible(true);
	}

	public JLabel getLblBienvenido() {
		return lblBienvenido;
	}

	public void setLblBienvenido(JLabel lblBienvenido) {
		this.lblBienvenido = lblBienvenido;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JLabel getLblApellido() {
		return lblApellido;
	}

	public void setLblApellido(JLabel lblApellido) {
		this.lblApellido = lblApellido;
	}

	public JLabel getLblEmail() {
		return lblEmail;
	}

	public void setLblEmail(JLabel lblEmail) {
		this.lblEmail = lblEmail;
	}

	public JLabel getLblCiudad() {
		return lblCiudad;
	}

	public void setLblCiudad(JLabel lblCiudad) {
		this.lblCiudad = lblCiudad;
	}

	public JLabel getLblPais() {
		return lblPais;
	}

	public void setLblPais(JLabel lblPais) {
		this.lblPais = lblPais;
	}

	public JLabel getLblDni() {
		return lblDni;
	}

	public void setLblDni(JLabel lblDni) {
		this.lblDni = lblDni;
	}

	public JLabel getLblTelefono() {
		return lblTelefono;
	}

	public void setLblTelefono(JLabel lblTelefono) {
		this.lblTelefono = lblTelefono;
	}
}