package org.proyectofinal.bo.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.proyectofinal.bo.ex.ViajeCabeceraNotValidException;
import org.proyectofinal.bo.interfaces.ViajeCabeceraBo;
import org.proyectofinal.dao.ex.NoFlightsFoundException;
import org.proyectofinal.dao.impl.ViajeCabeceraDaoImpl;
import org.proyectofinal.dao.interfaces.ViajeCabeceraDao;
import org.proyectofinal.model.impl.ViajeCabeceraImpl;
import org.proyectofinal.model.interfaces.ViajeCabecera;

public class ViajeCabeceraBoImpl implements ViajeCabeceraBo {

	public void verificarTodos(ViajeCabecera vC) throws ViajeCabeceraNotValidException{
		
		if (vC.getCodigoViaje() == "" || 
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

	public void verificarImportantes(ViajeCabecera vC) throws ViajeCabeceraNotValidException {
		
		if (vC.getCiudadOrigen().length() == 0 || vC.getCiudadDestino().length() == 0 ||
			vC.getFechaSalida().equals(null)) {
			
			throw new ViajeCabeceraNotValidException();
		}
	}
	
	public List<String> retornarOrigenes(){
		
		List<String> listOrigenes = new ArrayList<String>();
		
		ViajeCabeceraDao vCDao = new ViajeCabeceraDaoImpl();
		
		try {

			vCDao.conectar();

			ResultSet res = vCDao.consultarOrigenes();

			while (res.next()){
				listOrigenes.add(res.getString("ciudadOrigen")+" ("+res.getString("shortPaisOrigen")+")");
			}
			
			vCDao.desconectar();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listOrigenes;
		
	}
	
	public List<String> retornarDestinos(){
		
		List<String> listDestinos = new ArrayList<String>();
		
		ViajeCabeceraDao vCDao = new ViajeCabeceraDaoImpl();
		
		try {

			vCDao.conectar();

			ResultSet res = vCDao.consultarDestinos();

			while (res.next()){
				listDestinos.add(res.getString("ciudadDestino")+" ("+res.getString("shortPaisDestino")+")");
			}
			
			vCDao.desconectar();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listDestinos;
		
	}
	
	public ViajeCabecera retornarViaje(String codViaje){
		
		ViajeCabecera vC = new ViajeCabeceraImpl();

		ViajeCabeceraDao vCDao = new ViajeCabeceraDaoImpl();
		
		try {

			vCDao.conectar();
			
			ResultSet res = vCDao.consultarPorCodigoViaje(codViaje);
			
			while (res.next()) {
				vC.setCodigoViaje(res.getString("codViaje"));
				vC.setCiudadOrigen(res.getString("ciudadOrigen"));
				vC.setPaisOrigen(res.getString("paisOrigen"));
				vC.setShortPaisOrigen(res.getString("shortPaisOrigen"));
				vC.setPlataformaOrigen(res.getString("plataformaOrigen"));
				vC.setCiudadDestino(res.getString("ciudadDestino"));
				vC.setPaisDestino(res.getString("paisDestino"));
				vC.setShortPaisDestino(res.getString("shortPaisDestino"));
				vC.setPlataformaDestino(res.getString("plataformaDestino"));
				vC.setDistancia(res.getFloat("distancia"));
				vC.setFechaSalida(res.getDate("fechaSalida"));
				vC.setHoraSalida(res.getTime("horaSalida"));
				vC.setFechaLlegada(res.getDate("fechaLlegada"));
				vC.setHoraLlegada(res.getTime("horaLlegada"));
				vC.setDuracion(res.getTime("duracion"));
				vC.setPrecioClaseTur(res.getFloat("precioClaseTur"));
				vC.setPrecioClasePrim(res.getFloat("precioClasePrim"));
				vC.setImagen1(res.getString("imagen1"));
				vC.setImagen2(res.getString("imagen2"));
				vC.setCupo(res.getInt("cupo"));
			}

			vCDao.desconectar();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vC;
		
	}

	@Override
	public List<ViajeCabecera> retornarVuelos(ViajeCabecera vC) throws NoFlightsFoundException {
		
		List<ViajeCabecera> listVuelos = new ArrayList<ViajeCabecera>();
		
		ViajeCabeceraDao vCDao = new ViajeCabeceraDaoImpl();
		
		try {
			vCDao.conectar();

			ResultSet res = vCDao.consultarVuelos(vC);

			if (res.next()){
				while (res.next()){
					ViajeCabecera viaje = retornarViaje(res.getString("codViaje"));
					listVuelos.add(viaje);
				}
			} else {
				throw new NoFlightsFoundException();
			}

			vCDao.desconectar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listVuelos;
	}

}