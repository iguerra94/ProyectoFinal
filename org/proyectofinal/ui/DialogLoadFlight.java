package org.proyectofinal.ui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogLoadFlight extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2618894532538789035L;
	private JTextField txtCodigoViaje;
	private JTextField txtCiudadOrigen;
	private JTextField txtPaisOrigen;
	private JTextField txtCiudadDestino;
	private JTextField txtCupo;
	private JTextField txtFechaSalida;
	private JTextField txtHoraSalida;
	private JTextField txtFechaLlegada;
	private JTextField txtPaisDestino;
	private JTextField txtHoraLlegada;
	private JButton btnRealizarCambios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogLoadFlight dialog = new DialogLoadFlight();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DialogLoadFlight() {
		setTitle("Cargar Vuelo..");
		setBounds(100, 100, 635, 331);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(null);
		
		JLabel lblCodigoDeViaje = new JLabel("Codigo de Viaje: ");
		lblCodigoDeViaje.setBounds(15, 15, 119, 15);
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
		lblHoraDeSalida.setBounds(330, 165, 130, 15);
		getContentPane().add(lblHoraDeSalida);
		
		JLabel lblFechaDeLlegada = new JLabel("Fecha de Llegada: ");
		lblFechaDeLlegada.setBounds(15, 195, 143, 15);
		getContentPane().add(lblFechaDeLlegada);
		
		JLabel lblHoraDeLlegada = new JLabel("Hora de Llegada: ");
		lblHoraDeLlegada.setBounds(330, 195, 137, 15);
		getContentPane().add(lblHoraDeLlegada);
		
		JLabel lblCupo = new JLabel("Cupo: ");
		lblCupo.setBounds(15, 225, 119, 15);
		getContentPane().add(lblCupo);
		
		txtCodigoViaje = new JTextField();
		txtCodigoViaje.setBounds(160, 15, 151, 19);
		getContentPane().add(txtCodigoViaje);
		txtCodigoViaje.setColumns(10);
		
		txtCiudadOrigen = new JTextField();
		txtCiudadOrigen.setColumns(10);
		txtCiudadOrigen.setBounds(160, 45, 151, 19);
		getContentPane().add(txtCiudadOrigen);
		
		txtPaisOrigen = new JTextField();
		txtPaisOrigen.setColumns(10);
		txtPaisOrigen.setBounds(160, 75, 151, 19);
		getContentPane().add(txtPaisOrigen);
		
		txtCiudadDestino = new JTextField();
		txtCiudadDestino.setColumns(10);
		txtCiudadDestino.setBounds(160, 105, 151, 19);
		getContentPane().add(txtCiudadDestino);
		
		txtPaisDestino = new JTextField();
		txtPaisDestino.setColumns(10);
		txtPaisDestino.setBounds(160, 135, 151, 19);
		getContentPane().add(txtPaisDestino);
		
		txtFechaSalida = new JTextField();
		txtFechaSalida.setToolTipText("Formato: YYYY/MM/DD");
		txtFechaSalida.setColumns(10);
		txtFechaSalida.setBounds(160, 165, 151, 19);
		getContentPane().add(txtFechaSalida);
		
		txtHoraSalida = new JTextField();
		txtHoraSalida.setToolTipText("Formato: HH:MM:SS");
		txtHoraSalida.setColumns(10);
		txtHoraSalida.setBounds(460, 165, 151, 19);
		getContentPane().add(txtHoraSalida);
		
		txtFechaLlegada = new JTextField();
		txtFechaLlegada.setToolTipText("Formato: YYYY/MM/DD");
		txtFechaLlegada.setColumns(10);
		txtFechaLlegada.setBounds(160, 195, 151, 19);
		getContentPane().add(txtFechaLlegada);
		
		txtCupo = new JTextField();
		txtCupo.setToolTipText("Formato: YYYY/MM/DD");
		txtCupo.setColumns(10);
		txtCupo.setBounds(160, 225, 151, 19);
		getContentPane().add(txtCupo);
		
		txtHoraLlegada = new JTextField();
		txtHoraLlegada.setToolTipText("Formato: HH:MM:SS");
		txtHoraLlegada.setColumns(10);
		txtHoraLlegada.setBounds(460, 195, 151, 19);
		getContentPane().add(txtHoraLlegada);
		
		btnRealizarCambios = new JButton("");
		btnRealizarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

	public JTextField getTxtPaisOrigen() {
		return txtPaisOrigen;
	}

	public void setTxtPaisOrigen(JTextField txtPaisOrigen) {
		this.txtPaisOrigen = txtPaisOrigen;
	}

	public JTextField getTxtCiudadDestino() {
		return txtCiudadDestino;
	}

	public void setTxtCiudadDestino(JTextField txtCiudadDestino) {
		this.txtCiudadDestino = txtCiudadDestino;
	}

	public JTextField getTxtCupo() {
		return txtCupo;
	}

	public void setTxtCupo(JTextField txtCupo) {
		this.txtCupo = txtCupo;
	}

	public JTextField getTxtFechaSalida() {
		return txtFechaSalida;
	}

	public void setTxtFechaSalida(JTextField txtFechaSalida) {
		this.txtFechaSalida = txtFechaSalida;
	}

	public JTextField getTxtHoraSalida() {
		return txtHoraSalida;
	}

	public void setTxtHoraSalida(JTextField txtHoraSalida) {
		this.txtHoraSalida = txtHoraSalida;
	}

	public JTextField getTxtFechaLlegada() {
		return txtFechaLlegada;
	}

	public void setTxtFechaLlegada(JTextField txtFechaLlegada) {
		this.txtFechaLlegada = txtFechaLlegada;
	}

	public JTextField getTxtPaisDestino() {
		return txtPaisDestino;
	}

	public void setTxtPaisDestino(JTextField txtPaisDestino) {
		this.txtPaisDestino = txtPaisDestino;
	}

	public JTextField getTxtHoraLlegada() {
		return txtHoraLlegada;
	}

	public void setTxtHoraLlegada(JTextField txtHoraLlegada) {
		this.txtHoraLlegada = txtHoraLlegada;
	}

	public JButton getBtnRealizarCambios() {
		return btnRealizarCambios;
	}

	public void setBtnRealizarCambios(JButton btnRealizarCambios) {
		this.btnRealizarCambios = btnRealizarCambios;
	}
}
