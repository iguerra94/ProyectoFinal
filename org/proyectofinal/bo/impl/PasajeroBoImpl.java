package org.proyectofinal.bo.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.bo.ex.NotValidPassengerException;
import org.proyectofinal.bo.interfaces.PasajeroBo;
import org.proyectofinal.dao.impl.PasajeroDaoImpl;
import org.proyectofinal.dao.interfaces.PasajeroDao;
import org.proyectofinal.model.interfaces.Pasajero;

public class PasajeroBoImpl implements PasajeroBo {

	public void verificarDatosPasajero(Pasajero p) throws NotValidPassengerException {
		
		if (p.getDni().length() == 0 || p.getDni() == null || 
			p.getNombre().trim().length() == 0 ||  
			p.getApellido().trim().length() == 0){ 
			
			throw new NotValidPassengerException();
		}
	}

	@Override
	public void agregarPasajero(Pasajero pasajero) {
		
		PasajeroDao pDao = new PasajeroDaoImpl();
		
		try {

			ResultSet res = pDao.consultarPorDni(pasajero);
			
			if (!res.next()){
				pDao.altaPasajero(pasajero);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}