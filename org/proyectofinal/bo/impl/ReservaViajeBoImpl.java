package org.proyectofinal.bo.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.proyectofinal.bo.ex.NotValidPassengerException;
import org.proyectofinal.bo.interfaces.ReservaViajeBo;
import org.proyectofinal.dao.impl.ReservaViajeDaoImpl;
import org.proyectofinal.dao.interfaces.ReservaViajeDao;
import org.proyectofinal.model.interfaces.ReservaViaje;

public class ReservaViajeBoImpl implements ReservaViajeBo {
	
	public void verificarReserva(ReservaViaje rV) throws NotValidPassengerException {
		if (rV.getAsiento() == -1){ throw new NotValidPassengerException(); }
	}

	@Override
	public List<Integer> controlarAsientosOcupados(ReservaViaje rV) {
		
		
		ReservaViajeDao rVDao = new ReservaViajeDaoImpl();
		
		List<Integer> listaOcupados = new ArrayList<Integer>();
				
		try {
			
			rVDao.conectar();
			
			ResultSet res = rVDao.consultarAsientosPorViaje(rV.getViaje().getCodigoViaje());
			
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

}