package org.proyectofinal.bo.interfaces;

import java.util.List;

import org.proyectofinal.bo.ex.NotValidPassengerException;
import org.proyectofinal.model.interfaces.ReservaViaje;
import org.proyectofinal.model.interfaces.ViajeCabecera;

/**
 * Interfaz de la Clase de Negocio ReservaViajeBo.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public interface ReservaViajeBo {
	
	/**
	 * Metodo de negocio que verifica que todos los atributos del objeto <code>ReservaViaje</code> sean validos.
	 *
	 * @param rV El objeto <code>ReservaViaje</code>.
	 * @throws NotValidPassengerException Si algun atributo del objeto <code>ReservaViaje</code> no es valido.
	 */
	
	public void verificarReserva(ReservaViaje rV) throws NotValidPassengerException;
	
	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>ReservaViaje</code> y retorna una lista con los asientos ocupados del <code>ViajeCabecera</code> pasado como parametro.
	 *
	 * @param viaje El objeto <code>ViajeCabecera</code>.
	 * @return La lista con los asientos ocupados del <code>ViajeCabecera</code>.
	 */
	
	public List<Integer> retornarAsientosOcupados(ViajeCabecera viaje);		
	
	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>ReservaViaje</code> y retorna la cantidad de reservas realizadas por la <code>PersonaRegistrada</code> con el atributo dni pasado como parametro.
	 *
	 * @param dni El atributo dni de la <code>PersonaRegistrada</code>.
	 * @return La cantidad de reservas realizadas por la <code>PersonaRegistrada</code> con el dni pasado como parametro.
	 */
	
	public Integer retornarCantidadDeReservas(String dni);
	
	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>ReservaViaje</code> y retorna una lista con con todos los atributos de las <code>ReservaViaje</code> realizadas por la <code>PersonaRegistrada</code> con el atributo dni pasado como parametro.
	 *
	 * @param dni El atributo dni de la <code>PersonaRegistrada</code>.
	 * @return La lista con todos los atributos de las <code>ReservaViaje</code> realizadas por la <code>PersonaRegistrada</code> con el atributo dni pasado como parametro.
	 */
	
	public List<ReservaViaje> retornarReservasSegunDni(String dni);
	
	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>ReservaViaje</code> para insertar un nuevo objeto <code>ReservaViaje</code>.
	 * 
	 * @param reservaViaje El objeto <code>ReservaViaje</code>.
	 */
	
	public void agregarReserva(ReservaViaje reservaViaje);
	
}