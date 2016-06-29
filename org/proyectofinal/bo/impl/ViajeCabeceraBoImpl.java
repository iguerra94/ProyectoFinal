package org.proyectofinal.bo.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
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
		
		if (vC.getCodigoViaje().length() == 0 || 
			vC.getPaisOrigen().length() == 0 || 
			vC.getCiudadOrigen().length() == 0 || 
			vC.getPlataformaOrigen().length() == 0 || 
			vC.getPaisDestino().length() == 0 || 
			vC.getCiudadDestino().length() == 0 || 
			vC.getPlataformaDestino().length() == 0 || 
			vC.getFechaSalida() == null ||
			vC.getHoraSalida().toString() == "00:00:00" ||
			vC.getFechaLlegada() == null ||
			vC.getHoraLlegada().toString() == "00:00:00" || 
			vC.getDistancia() == -1f || 
			vC.getDuracion().toString() == "00:00:00" ||								
			vC.getPrecioClasePrim() == -1f ||
			vC.getPrecioClaseTur() == -1f ||
			vC.getImagen1().length() == 0 ||
			vC.getImagen2().length() == 0){

			throw new ViajeCabeceraNotValidException();
		}
		
	}

	public void verificarImportantesConFecha(ViajeCabecera vC) throws ViajeCabeceraNotValidException {
		
		if (vC.getCiudadOrigen().length() == 0 || vC.getCiudadDestino().length() == 0 ||
			vC.getFechaSalida().equals(null)) {
			
			throw new ViajeCabeceraNotValidException();
		}
	}
	
	public void verificarImportantesSinFecha(ViajeCabecera vC) throws ViajeCabeceraNotValidException {
		
		if (vC.getCiudadOrigen().length() == 0 || vC.getCiudadDestino().length() == 0) {
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
				vC.setOferta(res.getFloat("oferta"));
				vC.setImagen1(res.getString("imagen1"));
				vC.setImagen2(res.getString("imagen2"));
				vC.setCupo(res.getInt("cupo"));
			}

			vCDao.desconectar();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return vC;
		
	}

	public List<ViajeCabecera> retornarVuelosPorFecha(ViajeCabecera vC) throws NoFlightsFoundException {
		
		List<ViajeCabecera> listVuelos = new ArrayList<ViajeCabecera>();
		
		ViajeCabeceraDao vCDao = new ViajeCabeceraDaoImpl();
		
		
		ResultSet res = null;
		
		Calendar c = null;
		
		Date fechaSalida = vC.getFechaSalida();
		
		java.util.Date dateUtil = null; 
		
		Date dateSql = null;
		
		try {
			
			vCDao.conectar();
			
			int k = 7;
			
			for (int i = 1; i <= k; i++){

				res = vCDao.consultarVuelosPorFecha(vC);
	
				while (res.next()){
					ViajeCabecera viaje = retornarViaje(res.getString("codViaje"));
					listVuelos.add(viaje);
				}

				c = Calendar.getInstance();
				
				c.setTime(new java.util.Date(fechaSalida.getTime()));
				
				c.add(Calendar.DATE, i);
				
				dateUtil = c.getTime();
				
				dateSql = new Date(dateUtil.getTime());
				
				vC.setFechaSalida(dateSql);							
				
			}
			
			if (listVuelos.size() == 0){
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
	
	public List<ViajeCabecera> retornarVuelosCualquierFecha(ViajeCabecera vC) throws NoFlightsFoundException {
		
		List<ViajeCabecera> listVuelos = new ArrayList<ViajeCabecera>();
		
		ViajeCabeceraDao vCDao = new ViajeCabeceraDaoImpl();
		
		try {
			
			vCDao.conectar();

			ResultSet res = vCDao.consultarVuelosCualquierFecha(vC);

			while (res.next()){
				ViajeCabecera viaje = retornarViaje(res.getString("codViaje"));
				listVuelos.add(viaje);
			}
			
			if (listVuelos.size() == 0){
				throw new NoFlightsFoundException();
			}
			
			vCDao.desconectar();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listVuelos;
	}

	@Override
	public void actualizarCupo(ViajeCabecera viaje) {

		ViajeCabeceraDao vCDao = new ViajeCabeceraDaoImpl();
		
		try {
			vCDao.actualizarCupo(viaje);
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String[] retornarCodigosViaje() {

		String[] modeloVuelos = null;
		
		ViajeCabeceraDao vCDao = new ViajeCabeceraDaoImpl();
		
		List<String> listaVuelos = new ArrayList<String>();

		try {

			ResultSet res = vCDao.consultarCodigosViaje();
			
			while (res.next()){
				listaVuelos.add(res.getString("codViaje"));
			}
			
			modeloVuelos = new String[listaVuelos.size()];
			
			int i = 0;
			
			for (String codigo : listaVuelos) {
				modeloVuelos[i] = codigo;
				i++;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return modeloVuelos;
	}

	@Override
	public void eliminarVuelo(String codigo) {
		
		ViajeCabeceraDao vCDao = new ViajeCabeceraDaoImpl();
		
		try {
			vCDao.baja(codigo);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}