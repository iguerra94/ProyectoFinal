
package org.proyectofinal.bo.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.bo.ex.NotValidPassengerException;
import org.proyectofinal.bo.interfaces.PasajeroBo;
import org.proyectofinal.dao.impl.PasajeroDaoImpl;
import org.proyectofinal.dao.interfaces.PasajeroDao;
import org.proyectofinal.model.impl.PasajeroImpl;
import org.proyectofinal.model.interfaces.Pasajero;

public class PasajeroBoImpl implements PasajeroBo {

	/*
	 * Constructor de la clase de negocio PasajeroBoImpl.
	 */
	public PasajeroBoImpl(){
		
	}
	
	/**
	 * Metodo de negocio que verifica que todos los datos del Pasajero sean correctos.
	 */
	public void verificarDatosPasajero(Pasajero p) throws NotValidPassengerException {
		
		if (p.getDni().length() == 0 || p.getDni() == null || 
			p.getNombre().trim().length() == 0 ||  
			p.getApellido().trim().length() == 0){ 
			
			throw new NotValidPassengerException();
		}
	}

	/**
	 * Metodo de negocio para insertar un nuevo pasajero.
	 */
	@Override
	public void agregarPasajero(Pasajero pasajero) {
		
		PasajeroDao pDao = new PasajeroDaoImpl();
		
		try {
			
			pDao.conectar();

			ResultSet res = pDao.consultarPorDni(pasajero);
			
			if (!res.next()){
				pDao.altaPasajero(pasajero);
			}

			pDao.desconectar();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Metodo de negocio que retorna un Objeto Pasajero a partir del dni pasado como parametro.
	 */
	@Override
	public Pasajero retornarPasajero(String dniPasajero) {
		
		Pasajero p = new PasajeroImpl();

		PasajeroDao pDao = new PasajeroDaoImpl();
		
		try {
			
			pDao.conectar();
			
			ResultSet res = pDao.consultarPorDni(dniPasajero);
			
			while (res.next()) {
				p.setDni(res.getString("dni"));
				p.setNombre(res.getString("nombre"));
				p.setApellido(res.getString("apellido"));
			}

			pDao.desconectar();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return p;
	}

}