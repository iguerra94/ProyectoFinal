package org.proyectofinal.bo.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.proyectofinal.bo.ex.NoFlightsFoundException;
import org.proyectofinal.bo.ex.NotOffersFoundException;
import org.proyectofinal.bo.ex.ViajeCabeceraNotValidException;
import org.proyectofinal.bo.ex.ViajeCabeceraOfferNotValidException;
import org.proyectofinal.bo.interfaces.ViajeCabeceraBo;
import org.proyectofinal.dao.impl.ViajeCabeceraDaoImpl;
import org.proyectofinal.dao.interfaces.ViajeCabeceraDao;
import org.proyectofinal.model.impl.ViajeCabeceraImpl;
import org.proyectofinal.model.interfaces.ViajeCabecera;

/**
 * Implementacion de la Clase de Negocio de la entidad de dominio <strong>ViajeCabecera</strong>: <code>ViajeCabeceraBo</code>.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public class ViajeCabeceraBoImpl implements ViajeCabeceraBo {

	/**
	 * Instancia un nuevo objeto de la Clase de Negocio <code>ViajeCabeceraBo</code>.
	 */
	
	public ViajeCabeceraBoImpl(){
		
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.ViajeCabeceraBo#verificarTodos(org.proyectofinal.model.interfaces.ViajeCabecera)
	 */
	
	public void verificarTodos(ViajeCabecera vC) throws ViajeCabeceraNotValidException{
		
		if (vC.getCodigoViaje().length() == 0 || 
			vC.getPaisOrigen().length() == 0 || 
			vC.getCiudadOrigen().length() == 0 || 
			vC.getPlataformaOrigen().length() == 0 || 
			vC.getPaisDestino().length() == 0 || 
			vC.getCiudadDestino().length() == 0 || 
			vC.getPlataformaDestino().length() == 0 || 
			vC.getFechaSalida() == null ||
			vC.getFechaLlegada() == null ||
			vC.getDistancia() == -1 || 
			vC.getDuracion().equals(Time.valueOf("00:00:00")) ||								
			vC.getPrecioClasePrim() == -1f ||
			vC.getPrecioClaseTur() == -1f ||
			vC.getImagen1().length() == 0 ||
			vC.getImagen2().length() == 0){

			throw new ViajeCabeceraNotValidException();
		}
		
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.ViajeCabeceraBo#verificarImportantesConFecha(org.proyectofinal.model.interfaces.ViajeCabecera)
	 */
	
	public void verificarImportantesConFecha(ViajeCabecera vC) throws ViajeCabeceraNotValidException {
		
		if (vC.getCiudadOrigen().length() == 0 || vC.getCiudadDestino().length() == 0 ||
			vC.getFechaSalida().equals(null)) {
			
			throw new ViajeCabeceraNotValidException();
		}
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.ViajeCabeceraBo#verificarImportantesSinFecha(org.proyectofinal.model.interfaces.ViajeCabecera)
	 */
	
	public void verificarImportantesSinFecha(ViajeCabecera vC) throws ViajeCabeceraNotValidException {
		
		if (vC.getCiudadOrigen().length() == 0 || vC.getCiudadDestino().length() == 0) {
			throw new ViajeCabeceraNotValidException();
		}
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.ViajeCabeceraBo#verificarOferta(org.proyectofinal.model.interfaces.ViajeCabecera)
	 */
	
	public void verificarOferta(ViajeCabecera vC) throws ViajeCabeceraOfferNotValidException {

		if (vC.getShortPaisOrigen().length() == 0 || vC.getCiudadOrigen().length() == 0 || 
			vC.getShortPaisDestino().length() == 0 || vC.getCiudadDestino().length() == 0 || 
			Float.parseFloat(vC.getOferta()) <= 0 || Float.parseFloat(vC.getOferta()) > 0.75 || 
			vC.getImagenOferta().length() == 0){
	
			throw new ViajeCabeceraOfferNotValidException();
		}
		
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.ViajeCabeceraBo#retornarViaje(java.lang.String)
	 */
	
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
				vC.setFechaSalida(res.getDate("fechaSalida"));
				vC.setHoraSalida(res.getTime("horaSalida"));
				vC.setFechaLlegada(res.getDate("fechaLlegada"));
				vC.setHoraLlegada(res.getTime("horaLlegada"));
				vC.setDistancia(res.getInt("distancia"));
				vC.setDuracion(res.getTime("duracion"));
				vC.setPrecioClaseTur(res.getFloat("precioClaseTur"));
				vC.setPrecioClasePrim(res.getFloat("precioClasePrim"));
				vC.setOferta(res.getString("oferta"));
				vC.setImagenOferta(res.getString("imagenOferta"));
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
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.ViajeCabeceraBo#retornarCodigosViaje()
	 */
	
	@Override
	public List<String> retornarCodigosViaje() {

		ViajeCabeceraDao vCDao = new ViajeCabeceraDaoImpl();
		
		List<String> listaVuelos = new ArrayList<String>();

		try {

			ResultSet res = vCDao.consultarCodigosViaje();
			
			while (res.next()){
				listaVuelos.add(res.getString("codViaje"));
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return listaVuelos;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.ViajeCabeceraBo#retornarVuelosPorFecha(org.proyectofinal.model.interfaces.ViajeCabecera)
	 */
	
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
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listVuelos;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.ViajeCabeceraBo#retornarVuelosCualquierFecha(org.proyectofinal.model.interfaces.ViajeCabecera)
	 */
	
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
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.ViajeCabeceraBo#retornarOrigenesDestinos()
	 */
	
	@Override
	public List<String> retornarOrigenesDestinos() {
		
		List<String> listOrigenesDestinos = new ArrayList<String>();
		
		ViajeCabeceraDao vCDao = new ViajeCabeceraDaoImpl();
		
		try {

			vCDao.conectar();

			ResultSet res = vCDao.consultarOrigenesDestinos();

			while (res.next()){
				listOrigenesDestinos.add(res.getString("ciudadOrigen")+" ("+res.getString("shortPaisOrigen")+") - " + res.getString("ciudadDestino")+" ("+res.getString("shortPaisDestino")+")");
			}
			
			vCDao.desconectar();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return listOrigenesDestinos;
		
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.ViajeCabeceraBo#retornarOrigenes()
	 */
	
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
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.ViajeCabeceraBo#retornarDestinos()
	 */
	
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
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.ViajeCabeceraBo#retornarListaOfertas()
	 */
	
	public List<ViajeCabecera> retornarListaOfertas(){
		
		List<ViajeCabecera> listOffers = new ArrayList<ViajeCabecera>();
		
		ViajeCabeceraDao vCDao = new ViajeCabeceraDaoImpl();
		
		ViajeCabecera vC = null;
		
		try {

			vCDao.conectar();

			ResultSet res = vCDao.consultarDatosOferta();

			while (res.next()){
				
				if (Float.parseFloat(res.getString("oferta")) > 0f){
					
					vC = new ViajeCabeceraImpl();
					
					vC.setCiudadOrigen(res.getString("ciudadOrigen"));
					vC.setShortPaisOrigen(res.getString("shortPaisOrigen"));
					vC.setCiudadDestino(res.getString("ciudadDestino"));
					vC.setShortPaisDestino(res.getString("shortPaisDestino"));								
					vC.setOferta(res.getString("oferta"));
					vC.setImagenOferta(res.getString("imagenOferta"));
					vC.setPrecioClaseTur(res.getFloat("precioClaseTur"));

					listOffers.add(vC);
				}
			}
			
			vCDao.desconectar();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listOffers;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.ViajeCabeceraBo#retornarOfertas()
	 */
	
	public List<String> retornarOfertas() throws NotOffersFoundException{
		
		List<String> listOffers = new ArrayList<String>();
		
		ViajeCabeceraDao vCDao = new ViajeCabeceraDaoImpl();
		
		try {

			vCDao.conectar();

			ResultSet res = vCDao.consultarOrigenesYDestinos();

			while (res.next()){
				if (Float.parseFloat(res.getString("oferta")) > 0f){
					listOffers.add(res.getString("ciudadOrigen")+" ("+res.getString("shortPaisOrigen")+") - " +res.getString("ciudadDestino")+" ("+res.getString("shortPaisDestino") + ")");
				}
			}
			
			vCDao.desconectar();

			if (listOffers.size() == 0){
				throw new NotOffersFoundException();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listOffers;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.ViajeCabeceraBo#cargarVuelo(org.proyectofinal.model.interfaces.ViajeCabecera)
	 */
	
	@Override
	public void cargarVuelo(ViajeCabecera vC) {

		ViajeCabeceraDao vCDao = new ViajeCabeceraDaoImpl();
		
		try {
			vCDao.alta(vC);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.ViajeCabeceraBo#cargarOferta(org.proyectofinal.model.interfaces.ViajeCabecera)
	 */
	
	@Override
	public void cargarOferta(ViajeCabecera vC) {
		
		ViajeCabeceraDao vCDao = new ViajeCabeceraDaoImpl();
		
		try {
			vCDao.altaOferta(vC);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.ViajeCabeceraBo#eliminarVuelo(java.lang.String)
	 */
	
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

	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.ViajeCabeceraBo#eliminarOferta(org.proyectofinal.model.interfaces.ViajeCabecera)
	 */
	
	@Override
	public void eliminarOferta(ViajeCabecera vC) {
		
		ViajeCabeceraDao vCDao = new ViajeCabeceraDaoImpl();
		
		try {
			vCDao.bajaOferta(vC);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.ViajeCabeceraBo#modificarVuelo(org.proyectofinal.model.interfaces.ViajeCabecera)
	 */
	
	@Override
	public void modificarVuelo(ViajeCabecera vC) {
			
		ViajeCabeceraDao vCDao = new ViajeCabeceraDaoImpl();
		
		try {
			vCDao.modificacion(vC);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.ViajeCabeceraBo#actualizarCupo(org.proyectofinal.model.interfaces.ViajeCabecera)
	 */
	
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

}