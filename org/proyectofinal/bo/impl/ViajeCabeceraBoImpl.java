package org.proyectofinal.bo.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.bo.interfaces.ViajeCabeceraBo;
import org.proyectofinal.dao.ex.ViajeCabeceraNotValidException;
import org.proyectofinal.dao.interfaces.ViajeCabeceraDao;
import org.proyectofinal.model.impl.ViajeCabeceraImpl;
import org.proyectofinal.model.interfaces.ViajeCabecera;

public class ViajeCabeceraBoImpl implements ViajeCabeceraBo {

	public void verificarTodos(ViajeCabecera vC) throws ViajeCabeceraNotValidException{
		
		if (vC.getCodigoViaje() == -1 || 
			vC.getCiudadOrigen().length() == 0 || 
			vC.getPaisOrigen().length() == 0 || 
			vC.getCiudadDestino().length() == 0 || 
			vC.getPaisDestino().length() == 0 || 
			vC.getFechaSalida() == null ||
			vC.getFechaLlegada() == null ||
			vC.getHoraSalida().toString() == "00:00:00" ||
			vC.getHoraLlegada().toString() == "00:00:00" || 
			vC.getCupo() == -1){

			throw new ViajeCabeceraNotValidException();
		}
		
	}
	
	public ViajeCabecera retornarViaje(ViajeCabeceraDao vCDao, Integer codViaje){
		
		ViajeCabecera vC = new ViajeCabeceraImpl();

		try {

			ResultSet res = vCDao.consultarPorCodigoViaje(codViaje);
			
			while (res.next()) {
				vC.setCodigoViaje(res.getInt("codViaje"));
				vC.setCiudadOrigen(res.getString("ciudadOrigen"));
				vC.setPaisOrigen(res.getString("paisOrigen"));
				vC.setCiudadDestino(res.getString("ciudadDestino"));
				vC.setPaisDestino(res.getString("paisDestino"));
				vC.setFechaSalida(res.getDate("fechaSalida"));
				vC.setHoraSalida(res.getTime("horaSalida"));
				vC.setFechaLlegada(res.getDate("fechaLlegada"));
				vC.setHoraLlegada(res.getTime("horaLlegada"));
				vC.setCupo(res.getInt("cupo"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vC;
		
	}

}
