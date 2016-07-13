package org.proyectofinal.bo.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.proyectofinal.bo.ex.NotValidBookingException;
import org.proyectofinal.bo.interfaces.PasajeroBo;
import org.proyectofinal.bo.interfaces.ReservaViajeBo;
import org.proyectofinal.bo.interfaces.ViajeCabeceraBo;
import org.proyectofinal.dao.impl.ReservaViajeDaoImpl;
import org.proyectofinal.dao.interfaces.ReservaViajeDao;
import org.proyectofinal.model.impl.ReservaViajeImpl;
import org.proyectofinal.model.interfaces.ReservaViaje;
import org.proyectofinal.model.interfaces.ViajeCabecera;

/**
 * Implementacion de la Clase de Negocio de la Entidad de Dominio <strong>ReservaViaje</strong>: <code>ReservaViajeBo</code>.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public class ReservaViajeBoImpl implements ReservaViajeBo {

	/**
	 * Instancia un nuevo objeto de la Clase de Negocio <code>ReservaViajeBo</code>.
	 */
	
	public ReservaViajeBoImpl(){
		
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.ReservaViajeBo#verificarReserva(org.proyectofinal.model.interfaces.ReservaViaje)
	 */
	
	public void verificarReserva(ReservaViaje rV) throws NotValidBookingException {
		if (rV.getAsiento() == -1){ throw new NotValidBookingException(); }
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.ReservaViajeBo#retornarReservasSegunDni(java.lang.String)
	 */
	
	@Override
	public List<ReservaViaje> retornarReservasSegunDni(String dni) {
		
		List<ReservaViaje> listaReservas = new ArrayList<ReservaViaje>();
		
		ViajeCabeceraBo vCBo = new ViajeCabeceraBoImpl();
		PasajeroBo pBo = new PasajeroBoImpl();
		
		ReservaViajeDao rVDao = new ReservaViajeDaoImpl();

		try {
		
			rVDao.conectar();
			
			ResultSet res = rVDao.consultarPorPersonaQueReserva(dni);
			
			while(res.next()){
				ReservaViaje r = new ReservaViajeImpl();

				r.setViaje(vCBo.retornarViaje(res.getString("codViaje")));
				r.setPasajero(pBo.retornarPasajero(res.getString("dniPasajero")));
				r.setDniPersona(dni);
				r.setFechaReserva(res.getTimestamp("fechaReserva"));
				r.setAsiento(res.getInt("asiento"));
				r.setPrecio(res.getFloat("precio"));
				
				listaReservas.add(r);
			}
			
			rVDao.desconectar();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaReservas;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.ReservaViajeBo#controlarAsientosOcupados(org.proyectofinal.model.interfaces.ViajeCabecera)
	 */
	
	@Override
	public List<Integer> retornarAsientosOcupados(ViajeCabecera viaje) {
		
		ReservaViajeDao rVDao = new ReservaViajeDaoImpl();
		
		List<Integer> listaOcupados = new ArrayList<Integer>();
				
		try {
			
			rVDao.conectar();
			
			ResultSet res = rVDao.consultarAsientosPorViaje(viaje.getCodigoViaje());
			
			while(res.next()){
				listaOcupados.add(res.getInt("asiento"));
			}
			
			rVDao.desconectar();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaOcupados;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.ReservaViajeBo#retornarCantidadDeReservas(java.lang.String)
	 */
	
	@Override
	public Integer retornarCantidadDeReservas(String dni) {
		
		Integer cantReservas = null;
		
		ReservaViajeDao rVDao = new ReservaViajeDaoImpl();
		
		try {
		
			rVDao.conectar();
			
			ResultSet res = rVDao.consultarCantidadDeReservas(dni);
			
			while(res.next()){
				cantReservas = res.getInt("cantReservas");
			}
			
			rVDao.desconectar();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cantReservas;
		
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.ReservaViajeBo#agregarReserva(org.proyectofinal.model.interfaces.ReservaViaje)
	 */
	
	@Override
	public void agregarReserva(ReservaViaje reservaViaje) {
		
		ReservaViajeDao rVDao = new ReservaViajeDaoImpl();
		
		try {
			rVDao.alta(reservaViaje);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}