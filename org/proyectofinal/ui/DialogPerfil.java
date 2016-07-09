package org.proyectofinal.ui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import org.proyectofinal.bo.impl.PersonaRegistradaBoImpl;
import org.proyectofinal.bo.interfaces.PersonaRegistradaBo;
import org.proyectofinal.model.interfaces.PersonaRegistrada;
import org.proyectofinal.ui.plantillasUI.PlantillaDP;

public class DialogPerfil extends PlantillaDP implements WindowFocusListener {

	private static final long serialVersionUID = 5493693296072780899L;

	public DialogPerfil() {
		inicializarAtributos();
		inicializarComponentes();
		
		addWindowFocusListener(this);
	}

	@Override
	public void windowGainedFocus(WindowEvent e) {
		
		PersonaRegistradaBo pBo = new PersonaRegistradaBoImpl();
		
		PersonaRegistrada pR = pBo.retornarPersonaPorUsuario(getLabelAvatar().getToolTipText());
		
		removerLabelsInfo();
		agregarLabelsInfo(pR);
		
		getContentPane().validate();
		getContentPane().repaint();
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
	}

}