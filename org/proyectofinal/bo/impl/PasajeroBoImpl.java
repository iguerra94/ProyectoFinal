
package org.proyectofinal.bo.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.bo.ex.PassengerNotValidException;
import org.proyectofinal.bo.ex.PersonGenericNotValidDniException;
import org.proyectofinal.bo.interfaces.PasajeroBo;
import org.proyectofinal.dao.impl.PasajeroDaoImpl;
import org.proyectofinal.dao.interfaces.PasajeroDao;
import org.proyectofinal.model.impl.PasajeroImpl;
import org.proyectofinal.model.interfaces.Pasajero;

/**
 * Implementacion de la Clase de Negocio de la Entidad de Dominio <strong>Pasajero</strong>: <code>PasajeroBo</code>.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public class PasajeroBoImpl implements PasajeroBo {

	/**
	 * Instancia un nuevo objeto de la Clase de Negocio <code>PasajeroBo</code>.
	 */
	
	public PasajeroBoImpl(){
		
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.PasajeroBo#verificarDatosPasajero(org.proyectofinal.model.interfaces.Pasajero)
	 */
	
	public void verificarDatosPasajero(Pasajero p) throws PassengerNotValidException {
		
		if (p.getDni().length() == 0 || p.getDni() == null || 
			p.getNombre().trim().length() == 0 ||  
			p.getApellido().trim().length() == 0){ 
			
			throw new PassengerNotValidException();
		}
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.PasajeroBo#verificarDniPasajero(org.proyectofinal.model.interfaces.Pasajero)
	 */

	@Override
	public void verificarDniPasajero(Pasajero p) throws PersonGenericNotValidDniException {
		
		if (p.getDni().length() < 8){
			throw new PersonGenericNotValidDniException();
		}
		
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.PasajeroBo#retornarPasajero(java.lang.String)
	 */
	
	@Override
	public Pasajero retornarPasajero(String dniPasajero) {
		
		Pasajero p = new PasajeroImpl();

		PasajeroDao pDao = new PasajeroDaoImpl();
		
		try {
			
			pDao.conectar();
			
			ResultSet res = pDao.consultarPasajeroPorDni(dniPasajero);
			
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

	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.PasajeroBo#agregarPasajero(org.proyectofinal.model.interfaces.Pasajero)
	 */
	
	@Override
	public void agregarPasajero(Pasajero pasajero) {
		
		PasajeroDao pDao = new PasajeroDaoImpl();
		
		try {
			
			pDao.conectar();

			ResultSet res1 = pDao.consultarPersonaGenericaPorDni(pasajero);
			ResultSet res2 = pDao.consultarPasajeroPorDni(pasajero.getDni());
			
			if (!res1.next()){
				pDao.altaPersonaGenerica(pasajero);
			}
			
			if (!res2.next()){
				pDao.altaPasajero(pasajero);
			}
			
			pDao.desconectar();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}