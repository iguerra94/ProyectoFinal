package org.proyectofinal.ui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import org.proyectofinal.bo.impl.PersonaRegistradaBoImpl;
import org.proyectofinal.bo.interfaces.PersonaRegistradaBo;
import org.proyectofinal.model.interfaces.PersonaRegistrada;
import org.proyectofinal.ui.plantillasUI.PlantillaDP;

public class DialogPerfil extends PlantillaDP implements WindowFocusListener {

	public DialogPerfil() {
		inicializarAtributos();
		inicializarComponentes();	
		addWindowFocusListener(this);
	}

	@Override
	public void windowGainedFocus(WindowEvent e) {
		
//		PersonaRegistradaBo pBo = new PersonaRegistradaBoImpl();
//		
//		PersonaRegistrada pR = pBo.retornarPersonaPorUsuario(getLabelAvatar().getToolTipText());
//		
//		agregarPanelPersona(pR);
		
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		
	}

}