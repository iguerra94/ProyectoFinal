package org.proyectofinal.ui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.proyectofinal.model.interfaces.Usuario;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class panelUsuario extends JPanel {

	private static final long serialVersionUID = 1110184785861940930L;

	private JLabel lblDni;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblUsuario;
	private JLabel lblEmail;
	private JLabel lblCiudad;
	private JLabel lblPais;
	private JPanel panelDatosPersonales;
	private JPanel panelHistorialReservas;
	private JButton btnCambiarDatosPersonales;
	private JButton btnReservarBoleto;
	private JTable table;
	private JLabel lblCantidadDeReservas;
	private JScrollPane sPaneHistorialReservas;
	private JLabel lblBienvenido;
	
	@SuppressWarnings("serial")
	public panelUsuario(Usuario u) {
		
		setSize(978,500);
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
		
		lblNombre = new JLabel("Nombre: ");
		lblNombre.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNombre.setBounds(40, 70, 320, 40);
		panelDatosPersonales.add(lblNombre);
		
		lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setHorizontalTextPosition(SwingConstants.LEADING);
		lblUsuario.setFont(new Font("Dialog", Font.BOLD, 15));
		lblUsuario.setBounds(40, 170, 320, 40);
		panelDatosPersonales.add(lblUsuario);
		
		lblApellido = new JLabel("Apellido: ");
		lblApellido.setHorizontalTextPosition(SwingConstants.LEADING);
		lblApellido.setFont(new Font("Dialog", Font.BOLD, 15));
		lblApellido.setBounds(40, 120, 320, 40);
		panelDatosPersonales.add(lblApellido);
		
		lblEmail = new JLabel("Email: ");
		lblEmail.setHorizontalTextPosition(SwingConstants.LEADING);
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 15));
		lblEmail.setBounds(40, 220, 320, 40);
		panelDatosPersonales.add(lblEmail);
		
		lblDni = new JLabel("DNI: ");
		lblDni.setFont(new Font("Dialog", Font.BOLD, 15));
		lblDni.setBounds(40, 20, 320, 40);
		panelDatosPersonales.add(lblDni);
		
		lblCiudad = new JLabel("Ciudad: ");
		lblCiudad.setHorizontalTextPosition(SwingConstants.LEADING);
		lblCiudad.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCiudad.setBounds(40, 270, 320, 40);
		panelDatosPersonales.add(lblCiudad);
		
		lblPais = new JLabel("Pais: ");
		lblPais.setHorizontalTextPosition(SwingConstants.LEADING);
		lblPais.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPais.setBounds(40, 320, 320, 40);
		panelDatosPersonales.add(lblPais);
		
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
		
		btnCambiarDatosPersonales = new JButton("<html><center>Cambiar<br />datos<br />personales<center></html>");
		btnCambiarDatosPersonales.setBounds(780, 130, 180, 70);
		add(btnCambiarDatosPersonales);
		
		btnReservarBoleto = new JButton("Reservar Boleto");
		btnReservarBoleto.setFont(new Font("Dialog", Font.BOLD, 16));
		btnReservarBoleto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if (e.getSource() == btnReservarBoleto){
					ListadoVuelosUI ui = new ListadoVuelosUI();
					ui.setSize(970, 520);
					ui.getContentPane().add(ui.getBtnContinuar());
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

	public JLabel getLblDni() {
		return lblDni;
	}

	public void setLblDni(JLabel lblDni) {
		this.lblDni = lblDni;
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

	public JLabel getLblUsuario() {
		return lblUsuario;
	}

	public void setLblUsuario(JLabel lblUsuario) {
		this.lblUsuario = lblUsuario;
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
}