package org.proyectofinal.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import org.proyectofinal.model.impl.Boton;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;

public class ReservaBoletoUI extends JFrame implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3014223326291727038L;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservaBoletoUI frame = new ReservaBoletoUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
//	private Object[][] infoAsientos = new Object[3][2];
	
//	private Float precio;
//	private String asiento;
	
	private JLabel lblNumeroDeViaje;
	private JLabel lblOrigen;
	private JLabel lblDestino;
	private JLabel lblSalida;
	private JLabel lblLlegada;
	private JLabel lblAsientosDisp;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private JButton btnNro1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private int a = 1;
	private Object opcion;
	
	/**
	 * Create the frame.
	 */
	@SuppressWarnings("rawtypes")
	public ReservaBoletoUI() {
		
		setTitle("Reserva de Boleto");
		getContentPane().setLayout(null);

		setSize(970,632);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		
		lblAsientosDisp = new JLabel("");
		lblAsientosDisp.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsientosDisp.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAsientosDisp.setForeground(new Color(0, 128, 0));
		lblAsientosDisp.setBounds(137, 10, 33, 38);
		getContentPane().add(lblAsientosDisp);
		
		JLabel lblCantidadDeAsientos = new JLabel("<html><center>Asientos disponibles: </center></html>");
		lblCantidadDeAsientos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCantidadDeAsientos.setBounds(10, 12, 134, 37);
		getContentPane().add(lblCantidadDeAsientos);
		
		JPanel panel1 = new JPanel();
		panel1.setOpaque(false);
		panel1.setBounds(186, 140, 50, 120);
		getContentPane().add(panel1);
		panel1.setLayout(new GridLayout(3, 2, 0, 7));
		
		btnNro1 = new Boton("1", 180f);			
		btnNro1.setBackground(new Color(0, 128, 0));
		btnNro1.setContentAreaFilled(false);
		btnNro1.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro1.setMargin(new Insets(2, 0, 2, 0));
		btnNro1.addMouseListener(this);
		panel1.add(btnNro1);
		
		final JButton btnNro2 = new Boton("2", 180f);
		btnNro2.setBackground(new Color(0, 128, 0));
		btnNro2.setContentAreaFilled(false);
		btnNro2.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro2.setMargin(new Insets(2, 0, 2, 0));
		btnNro2.setHorizontalTextPosition(SwingConstants.CENTER);
		panel1.add(btnNro2);
		
		final JButton btnNro7 = new Boton("7", 180f);
		btnNro7.setBackground(new Color(0, 128, 0));
		btnNro7.setContentAreaFilled(false);
		btnNro7.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro7.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro7.setMargin(new Insets(2, 0, 2, 0));
		panel1.add(btnNro7);
		
		final JButton btnNro8 = new Boton("8", 180f);
		btnNro8.setBackground(new Color(0, 128, 0));
		btnNro8.setContentAreaFilled(false);
		btnNro8.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro8.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro8.setMargin(new Insets(2, 0, 2, 0));
		panel1.add(btnNro8);
		
		final JButton btnNro13 = new Boton("13", 180f);
		btnNro13.setBackground(new Color(0, 128, 0));
		btnNro13.setContentAreaFilled(false);
		btnNro13.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro13.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro13.setMargin(new Insets(2, 0, 2, 0));
		panel1.add(btnNro13);
		
		final JButton btnNro14 = new Boton("14", 180f);
		btnNro14.setBackground(new Color(0, 128, 0));
		btnNro14.setContentAreaFilled(false);
		btnNro14.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro14.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro14.setMargin(new Insets(2, 0, 2, 0));
		panel1.add(btnNro14);
		
		JPanel panel2 = new JPanel();
		panel2.setOpaque(false);
		panel2.setBounds(253, 140, 52, 120);
		getContentPane().add(panel2);
		panel2.setLayout(new GridLayout(3, 2, 0, 7));
		
		final JButton btnNro3 = new Boton("3", 180f);
		btnNro3.setBackground(new Color(0, 128, 0));
		btnNro3.setContentAreaFilled(false);
		btnNro3.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro3.setMargin(new Insets(2, 0, 2, 0));
		panel2.add(btnNro3);
		
		final JButton btnNro4 = new Boton("4", 180f);
		btnNro4.setBackground(new Color(0, 128, 0));
		btnNro4.setContentAreaFilled(false);
		btnNro4.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro4.setMargin(new Insets(2, 0, 2, 0));
		panel2.add(btnNro4);
		
		final JButton btnNro9 = new Boton("9", 180f);
		btnNro9.setBackground(new Color(0, 128, 0));
		btnNro9.setContentAreaFilled(false);
		btnNro9.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro9.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro9.setMargin(new Insets(2, 0, 2, 0));
		panel2.add(btnNro9);
		
		final JButton btnNro10 = new Boton("10", 180f);
		btnNro10.setBackground(new Color(0, 128, 0));
		btnNro10.setContentAreaFilled(false);
		btnNro10.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro10.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro10.setMargin(new Insets(2, 0, 2, 0));
		panel2.add(btnNro10);
		
		final JButton btnNro15 = new Boton("15", 180f);
		btnNro15.setBackground(new Color(0, 128, 0));
		btnNro15.setContentAreaFilled(false);
		btnNro15.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro15.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro15.setMargin(new Insets(2, 0, 2, 0));
		panel2.add(btnNro15);
		
		final JButton btnNro16 = new Boton("16", 180f);
		btnNro16.setBackground(new Color(0, 128, 0));
		btnNro16.setContentAreaFilled(false);
		btnNro16.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro16.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro16.setMargin(new Insets(2, 0, 2, 0));
		panel2.add(btnNro16);
		
		JPanel panel3 = new JPanel();
		panel3.setOpaque(false);
		panel3.setBounds(321, 140, 54, 120);
		getContentPane().add(panel3);
		panel3.setLayout(new GridLayout(3, 2, 0, 7));
		
		final JButton btnNro5 = new Boton("5", 180f);
		btnNro5.setBackground(new Color(0, 128, 0));
		btnNro5.setContentAreaFilled(false);
		btnNro5.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro5.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro5.setMargin(new Insets(2, 0, 2, 0));
		panel3.add(btnNro5);
		
		final JButton btnNro6 = new Boton("6", 180f);
		btnNro6.setBackground(new Color(0, 128, 0));
		btnNro6.setContentAreaFilled(false);
		btnNro6.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro6.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro6.setMargin(new Insets(2, 2, 2, 2));
		panel3.add(btnNro6);
		
		final JButton btnNro11 = new Boton("11", 180f);
		btnNro11.setBackground(new Color(0, 128, 0));
		btnNro11.setContentAreaFilled(false);
		btnNro11.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro11.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro11.setMargin(new Insets(2, 0, 2, 0));
		panel3.add(btnNro11);
		
		final JButton btnNro12 = new Boton("12", 180f);
		btnNro12.setBackground(new Color(0, 128, 0));
		btnNro12.setContentAreaFilled(false);
		btnNro12.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro12.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro12.setMargin(new Insets(2, 0, 2, 0));
		panel3.add(btnNro12);
		
		final JButton btnNro17 = new Boton("17", 180f);
		btnNro17.setBackground(new Color(0, 128, 0));
		btnNro17.setContentAreaFilled(false);
		btnNro17.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro17.setMargin(new Insets(2, 0, 2, 0));
		btnNro17.setHorizontalTextPosition(SwingConstants.CENTER);
		panel3.add(btnNro17);
		
		final JButton btnNro18 = new Boton("18", 180f);
		btnNro18.setBackground(new Color(0, 128, 0));
		btnNro18.setContentAreaFilled(false);
		btnNro18.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro18.setMargin(new Insets(2, 0, 2, 0));
		btnNro18.setHorizontalTextPosition(SwingConstants.CENTER);
		panel3.add(btnNro18);
		
		JPanel panel4 = new JPanel();
		panel4.setOpaque(false);
		panel4.setBounds(186, 280, 50, 283);
		getContentPane().add(panel4);
		panel4.setLayout(new GridLayout(8, 2, 0, 7));
		
		
		final JButton btnNro19 = new Boton("19", 90f);
		btnNro19.setBackground(new Color(0, 128, 0));
		btnNro19.setContentAreaFilled(false);
		btnNro19.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro19.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro19.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro19);
		
		final JButton btnNro20 = new Boton("20", 90f);
		btnNro20.setBackground(new Color(0, 128, 0));
		btnNro20.setContentAreaFilled(false);
		btnNro20.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro20.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro20.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro20);
		
		final JButton btnNro25 = new Boton("25", 90f);
		btnNro25.setBackground(new Color(0, 128, 0));
		btnNro25.setContentAreaFilled(false);
		btnNro25.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro25.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro25.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro25);
		
		final JButton btnNro26 = new Boton("26", 90f);
		btnNro26.setBackground(new Color(0, 128, 0));
		btnNro26.setContentAreaFilled(false);
		btnNro26.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro26.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro26.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro26);
		
		final JButton btnNro31 = new Boton("31", 90f);
		btnNro31.setBackground(new Color(0, 128, 0));
		btnNro31.setContentAreaFilled(false);
		btnNro31.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro31.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro31.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro31);
		
		final JButton btnNro32 = new Boton("32", 90f);
		btnNro32.setBackground(new Color(0, 128, 0));
		btnNro32.setContentAreaFilled(false);
		btnNro32.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro32.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro32.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro32);
		
		final JButton btnNro37 = new Boton("37", 90f);
		btnNro37.setBackground(new Color(0, 128, 0));
		btnNro37.setContentAreaFilled(false);
		btnNro37.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro37.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro37.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro37);
		
		final JButton btnNro38 = new Boton("38", 90f);
		btnNro38.setBackground(new Color(0, 128, 0));
		btnNro38.setContentAreaFilled(false);
		btnNro38.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro38.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro38.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro38);
		
		final JButton btnNro43 = new Boton("43", 90f);
		btnNro43.setBackground(new Color(0, 128, 0));
		btnNro43.setContentAreaFilled(false);
		btnNro43.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro43.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro43.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro43);
		
		final JButton btnNro44 = new Boton("44", 90f);
		btnNro44.setBackground(new Color(0, 128, 0));
		btnNro44.setContentAreaFilled(false);
		btnNro44.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro44.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro44.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro44);
		
		final JButton btnNro49 = new Boton("49", 90f);
		btnNro49.setBackground(new Color(0, 128, 0));
		btnNro49.setContentAreaFilled(false);
		btnNro49.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro49.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro49.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro49);
		
		final JButton btnNro50 = new Boton("50", 90f);
		btnNro50.setBackground(new Color(0, 128, 0));
		btnNro50.setContentAreaFilled(false);
		btnNro50.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro50.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro50.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro50);
		
		final JButton btnNro55 = new Boton("55", 90f);
		btnNro55.setBackground(new Color(0, 128, 0));
		btnNro55.setContentAreaFilled(false);
		btnNro55.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro55.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro55.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro55);
		
		final JButton btnNro56 = new Boton("56", 90f);
		btnNro56.setBackground(new Color(0, 128, 0));
		btnNro56.setContentAreaFilled(false);
		btnNro56.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro56.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro56.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro56);
		
		final JButton btnNro61 = new Boton("61", 90f);
		btnNro61.setBackground(new Color(0, 128, 0));
		btnNro61.setContentAreaFilled(false);
		btnNro61.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro61.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro61.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro61);
		
		final JButton btnNro62 = new Boton("62", 90f);
		btnNro62.setBackground(new Color(0, 128, 0));
		btnNro62.setContentAreaFilled(false);
		btnNro62.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro62.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro62.setMargin(new Insets(2, 0, 2, 0));
		panel4.add(btnNro62);
		
		JPanel panel5 = new JPanel();
		panel5.setOpaque(false);
		panel5.setBounds(253, 280, 52, 283);
		getContentPane().add(panel5);
		panel5.setLayout(new GridLayout(8, 2, 0, 7));
		
		final JButton btnNro21 = new Boton("21", 90f);
		btnNro21.setBackground(new Color(0, 128, 0));
		btnNro21.setContentAreaFilled(false);
		btnNro21.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro21.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro21.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro21);
		
		final JButton btnNro22 = new Boton("22", 90f);
		btnNro22.setBackground(new Color(0, 128, 0));
		btnNro22.setContentAreaFilled(false);
		btnNro22.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro22.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro22.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro22);
		
		final JButton btnNro27 = new Boton("27", 90f);
		btnNro27.setBackground(new Color(0, 128, 0));
		btnNro27.setContentAreaFilled(false);
		btnNro27.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro27.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro27.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro27);
		
		final JButton btnNro28 = new Boton("28", 90f);
		btnNro28.setBackground(new Color(0, 128, 0));
		btnNro28.setContentAreaFilled(false);
		btnNro28.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro28.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro28.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro28);
		
		final JButton btnNro33 = new Boton("33", 90f);
		btnNro33.setBackground(new Color(0, 128, 0));
		btnNro33.setContentAreaFilled(false);
		btnNro33.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro33.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro33.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro33);
		
		final JButton btnNro34 = new Boton("34", 90f);
		btnNro34.setBackground(new Color(0, 128, 0));
		btnNro34.setContentAreaFilled(false);
		btnNro34.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro34.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro34.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro34);
		
		final JButton btnNro39 = new Boton("39", 90f);
		btnNro39.setBackground(new Color(0, 128, 0));
		btnNro39.setContentAreaFilled(false);
		btnNro39.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro39.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro39.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro39);
		
		final JButton btnNro40 = new Boton("40", 90f);
		btnNro40.setBackground(new Color(0, 128, 0));
		btnNro40.setContentAreaFilled(false);
		btnNro40.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro40.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro40.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro40);
		
		final JButton btnNro45 = new Boton("45", 90f);
		btnNro45.setBackground(new Color(0, 128, 0));
		btnNro45.setContentAreaFilled(false);
		btnNro45.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro45.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro45.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro45);
		
		final JButton btnNro46 = new Boton("46", 90f);
		btnNro46.setBackground(new Color(0, 128, 0));
		btnNro46.setContentAreaFilled(false);
		btnNro46.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro46.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro46.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro46);
		
		final JButton btnNro51 = new Boton("51", 90f);
		btnNro51.setBackground(new Color(0, 128, 0));
		btnNro51.setContentAreaFilled(false);
		btnNro51.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro51.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro51.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro51);
		
		final JButton btnNro52 = new Boton("52", 90f);
		btnNro52.setBackground(new Color(0, 128, 0));
		btnNro52.setContentAreaFilled(false);
		btnNro52.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro52.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro52.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro52);
		
		final JButton btnNro57 = new Boton("57", 90f);
		btnNro57.setBackground(new Color(0, 128, 0));
		btnNro57.setContentAreaFilled(false);
		btnNro57.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro57.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro57.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro57);
		
		final JButton btnNro58 = new Boton("58", 90f);
		btnNro58.setBackground(new Color(0, 128, 0));
		btnNro58.setContentAreaFilled(false);
		btnNro58.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro58.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro58.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro58);
		
		final JButton btnNro63 = new Boton("63", 90f);
		btnNro63.setBackground(new Color(0, 128, 0));
		btnNro63.setContentAreaFilled(false);
		btnNro63.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro63.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro63.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro63);
		
		final JButton btnNro64 = new Boton("64", 90f);
		btnNro64.setBackground(new Color(0, 128, 0));
		btnNro64.setContentAreaFilled(false);
		btnNro64.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro64.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro64.setMargin(new Insets(2, 0, 2, 0));
		panel5.add(btnNro64);
		
		JPanel panel6 = new JPanel();
		panel6.setOpaque(false);
		panel6.setBounds(321, 280, 52, 283);
		getContentPane().add(panel6);
		panel6.setLayout(new GridLayout(8, 2, 0, 7));
		
		final JButton btnNro23 = new Boton("23", 90f);
		btnNro23.setBackground(new Color(0, 128, 0));
		btnNro23.setContentAreaFilled(false);
		btnNro23.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro23.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro23.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro23);
		
		final JButton btnNro24 = new Boton("24", 90f);
		btnNro24.setBackground(new Color(0, 128, 0));
		btnNro24.setContentAreaFilled(false);
		btnNro24.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro24.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro24.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro24);
		
		final JButton btnNro29 = new Boton("29", 90f);
		btnNro29.setBackground(new Color(0, 128, 0));
		btnNro29.setContentAreaFilled(false);
		btnNro29.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro29.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro29.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro29);
		
		final JButton btnNro30 = new Boton("30", 90f);
		btnNro30.setBackground(new Color(0, 128, 0));
		btnNro30.setContentAreaFilled(false);
		btnNro30.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro30.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro30.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro30);
		
		final JButton btnNro35 = new Boton("35", 90f);
		btnNro35.setBackground(new Color(0, 128, 0));
		btnNro35.setContentAreaFilled(false);
		btnNro35.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro35.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro35.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro35);
		
		final JButton btnNro36 = new Boton("36", 90f);
		btnNro36.setBackground(new Color(0, 128, 0));
		btnNro36.setContentAreaFilled(false);
		btnNro36.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro36.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro36.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro36);
		
		final JButton btnNro41 = new Boton("41", 90f);
		btnNro41.setBackground(new Color(0, 128, 0));
		btnNro41.setContentAreaFilled(false);
		btnNro41.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro41.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro41.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro41);
		
		final JButton btnNro42 = new Boton("42", 90f);
		btnNro42.setBackground(new Color(0, 128, 0));
		btnNro42.setContentAreaFilled(false);
		btnNro42.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro42.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro42.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro42);
		
		final JButton btnNro47 = new Boton("47", 90f);
		btnNro47.setBackground(new Color(0, 128, 0));
		btnNro47.setContentAreaFilled(false);
		btnNro47.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro47.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro47.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro47);
		
		final JButton btnNro48 = new Boton("48", 90f);
		btnNro48.setBackground(new Color(0, 128, 0));
		btnNro48.setContentAreaFilled(false);
		btnNro48.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro48.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro48.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro48);
		
		final JButton btnNro53 = new Boton("53", 90f);
		btnNro53.setBackground(new Color(0, 128, 0));
		btnNro53.setContentAreaFilled(false);
		btnNro53.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro53.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro53.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro53);
		
		final JButton btnNro54 = new Boton("54", 90f);
		btnNro54.setBackground(new Color(0, 128, 0));
		btnNro54.setContentAreaFilled(false);
		btnNro54.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro54.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro54.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro54);
		
		final JButton btnNro59 = new Boton("59", 90f);
		btnNro59.setBackground(new Color(0, 128, 0));
		btnNro59.setContentAreaFilled(false);
		btnNro59.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro59.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro59.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro59);
		
		final JButton btnNro60 = new Boton("60", 90f);
		btnNro60.setBackground(new Color(0, 128, 0));
		btnNro60.setContentAreaFilled(false);
		btnNro60.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro60.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro60.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro60);
		
		final JButton btnNro65 = new Boton("65", 90f);
		btnNro65.setBackground(new Color(0, 128, 0));
		btnNro65.setContentAreaFilled(false);
		btnNro65.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro65.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro65.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro65);
		
		final JButton btnNro66 = new Boton("66", 90f);
		btnNro66.setBackground(new Color(0, 128, 0));
		btnNro66.setContentAreaFilled(false);
		btnNro66.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		btnNro66.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNro66.setMargin(new Insets(2, 0, 2, 0));
		panel6.add(btnNro66);
		
		JLabel lblAvion = new JLabel("");
		lblAvion.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvion.setIcon(new ImageIcon(ReservaBoletoUI.class.getResource("/imagenes/avion.png")));
		lblAvion.setBounds(12, 12, 537, 553);
		getContentPane().add(lblAvion);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(99, 130, 191), 4));
		panel.setBackground(UIManager.getColor("EditorPane.inactiveForeground"));
		panel.setBounds(580, 346, 374, 250);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNumeroDeViaje = new JLabel("Numero de viaje: ");
		lblNumeroDeViaje.setBounds(20, 80, 337, 30);
		panel.add(lblNumeroDeViaje);
		
		lblOrigen = new JLabel("Origen: ");
		lblOrigen.setBounds(20, 110, 337, 30);
		panel.add(lblOrigen);
		
		lblDestino = new JLabel("Destino: ");
		lblDestino.setBounds(20, 140, 337, 30);
		panel.add(lblDestino);
		
		lblSalida = new JLabel("Salida:");
		lblSalida.setBounds(20, 170, 337, 30);
		panel.add(lblSalida);
		
		lblLlegada = new JLabel("Llegada: ");
		lblLlegada.setBounds(20, 200, 337, 30);
		panel.add(lblLlegada);
		
		JLabel lblInformacionSobreEl = new JLabel("<html><center>Información sobre el vuelo <br />seleccionado: </center></html>");
		lblInformacionSobreEl.setBounds(0, 11, 374, 65);
		panel.add(lblInformacionSobreEl);
		lblInformacionSobreEl.setForeground(SystemColor.controlDkShadow);
		lblInformacionSobreEl.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacionSobreEl.setFont(new Font("Dialog", Font.BOLD, 16));
		
		final JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(99, 130, 191), 4));
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(580, 12, 374, 323);
		getContentPane().add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Cantidad de pasajeros: ");
		lblNewLabel.setBounds(20, 48, 158, 30);
		panel_1.add(lblNewLabel);
		
//		Integer cant = Integer.parseInt(getCantDisp());

		
//		Object[] cantidad = new String[cant];
		
//		for(int i = 0; i < cant; i++){
//			cantidad[i] = i+1;
//		}
		
		final JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(20, 89, 333, 182);
		panel_2.setLayout(null);
		

		final JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (a < (Integer)opcion){
					a++;
					
					panel_1.remove(panel_2);
					panel_1.remove(btnSiguiente);
					
					panel_2.setBorder(new TitledBorder(null, "Pasajero " + a +"/" + opcion, TitledBorder.LEADING, TitledBorder.TOP, null, null));
					
					panel_1.add(panel_2);
					panel_1.add(btnSiguiente);
					
					panel_1.validate();
					panel_1.repaint();
				}
				
			}
		});
		btnSiguiente.setBounds(234, 283, 116, 29);

				
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (comboBox.getSelectedIndex() > 0){
					
					a = 1;
					opcion = comboBox.getSelectedItem();
					
					panel_2.setBorder(new TitledBorder(null, "Pasajero " + a +"/" + opcion, TitledBorder.LEADING, TitledBorder.TOP, null, null));
					
					panel_1.add(panel_2);
					panel_1.add(btnSiguiente);
					
					panel_1.validate();
					panel_1.repaint();
				
				}else{
					panel_1.remove(panel_2);

					panel_1.remove(btnSiguiente);

					panel_1.validate();
					panel_1.repaint();
				}
			}
		});
		comboBox.setBounds(176, 52, 68, 22);
		panel_1.add(comboBox);
		
		JLabel lblinformacinSobrePasajeros = new JLabel("<html><center>Informaci\u00F3n sobre pasajeros: </center></html>");
		lblinformacinSobrePasajeros.setHorizontalAlignment(SwingConstants.CENTER);
		lblinformacinSobrePasajeros.setForeground(Color.DARK_GRAY);
		lblinformacinSobrePasajeros.setFont(new Font("Dialog", Font.BOLD, 16));
		lblinformacinSobrePasajeros.setBounds(0, 0, 374, 50);
		panel_1.add(lblinformacinSobrePasajeros);
		
		
		
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 25, 116, 20);
		panel_2.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(20, 55, 116, 20);
		panel_2.add(lblApellido);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(20, 85, 116, 20);
		panel_2.add(lblDni);
		
		JLabel lblAsiento = new JLabel("Asiento: ");
		lblAsiento.setBounds(20, 115, 116, 20);
		panel_2.add(lblAsiento);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(20, 145, 116, 20);
		panel_2.add(lblPrecio);
		
		textField = new JTextField();
		textField.setBounds(99, 25, 176, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(99, 55, 176, 20);
		panel_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(99, 85, 176, 20);
		panel_2.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(99, 115, 176, 20);
		panel_2.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		textField_4.setBounds(99, 145, 176, 20);
		panel_2.add(textField_4);
		
	}
	
	public JLabel getLblNumeroDeViaje() {
		return lblNumeroDeViaje;
	}

	public void setLblNumeroDeViaje(JLabel lblNumeroDeViaje) {
		this.lblNumeroDeViaje = lblNumeroDeViaje;
	}

	public JLabel getLblOrigen() {
		return lblOrigen;
	}

	public void setLblOrigen(JLabel lblOrigen) {
		this.lblOrigen = lblOrigen;
	}

	public JLabel getLblDestino() {
		return lblDestino;
	}

	public void setLblDestino(JLabel lblDestino) {
		this.lblDestino = lblDestino;
	}

	public JLabel getLblSalida() {
		return lblSalida;
	}

	public void setLblSalida(JLabel lblSalida) {
		this.lblSalida = lblSalida;
	}

	public JLabel getLblLlegada() {
		return lblLlegada;
	}

	public void setLblLlegada(JLabel lblLlegada) {
		this.lblLlegada = lblLlegada;
	}
	
	public JLabel getLblAsientosDisp() {
		return lblAsientosDisp;
	}

	public void setLblAsientosDisp(JLabel lblAsientosDisp) {
		this.lblAsientosDisp = lblAsientosDisp;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	
	
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
//		Boton boton = (Boton) e.getSource();
//		
//		System.out.println(boton);
//		
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getComboBox() {
		return comboBox;
	}

	@SuppressWarnings("rawtypes")
	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}
}