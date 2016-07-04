package org.proyectofinal.main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.proyectofinal.ui.MainFrameUI;

public class App {

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		MainFrameUI ui = new MainFrameUI();
	}

}