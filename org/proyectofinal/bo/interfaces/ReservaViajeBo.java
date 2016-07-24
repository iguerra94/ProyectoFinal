package org.proyectofinal.bo.interfaces;

import java.util.List;

import org.proyectofinal.bo.ex.BookingNotValidException;
import org.proyectofinal.model.interfaces.ReservaViaje;
import org.proyectofinal.model.interfaces.ViajeCabecera;

/**
 * Interfaz de la Clase de Negocio de la Entidad de Dominio <strong>ReservaViaje</strong>: <code>ReservaViajeBo</code>.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public interface ReservaViajeBo {
	
	/**
	 * Metodo de negocio que verifica que todos los atributos del objeto <code>ReservaViaje</code> sean validos.
	 *
	 * @param rV El objeto <code>ReservaViaje</code>.
	 * @throws BookingNotValidException Si algun atributo del objeto <code>ReservaViaje</code> no es valido.
	 */
	
	public void verificarReserva(ReservaViaje rV) throws BookingNotValidException;
	
	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>ReservaViaje</code> y retorna una lista con con todos los atributos de las <code>ReservaViaje</code> realizadas por la <code>PersonaRegistrada</code> con el atributo <em>dni</em> pasado como parametro.
	 *
	 * @param dni El atributo <em>dni</em> de la <code>PersonaRegistrada</code>.
	 * @return La lista con todos los atributos de las <code>ReservaViaje</code> realizadas por la <code>PersonaRegistrada</code> con el atributo <em>dni</em> pasado como parametro.
	 */
	
	public List<ReservaViaje> retornarReservasSegunDni(String dni);
	
	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>ReservaViaje</code> y retorna una lista con los asientos ocupados del <code>ViajeCabecera</code> asociado a la reserva pasado como parametro.
	 *
	 * @param viaje El objeto <code>ViajeCabecera</code> asociado a la reserva.
	 * @return La lista con los asientos ocupados del <code>ViajeCabecera</code> asociado a la reserva.
	 */
	
	public List<Integer> retornarAsientosOcupados(ViajeCabecera viaje);		
	
	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>ReservaViaje</code> y retorna la cantidad de reservas realizadas por la <code>PersonaRegistrada</code> con el atributo <em>dni</em> pasado como parametro.
	 *
	 * @param dni El atributo <em>dni</em> de la <code>PersonaRegistrada</code>.
	 * @return La cantidad de reservas realizadas por la <code>PersonaRegistrada</code> con el atributo <em>dni</em> pasado como parametro.
	 */
	
	public Integer retornarCantidadDeReservas(String dni);
	
	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>ReservaViaje</code> para insertar un nuevo objeto <code>ReservaViaje</code> en la base de datos del sistema.
	 * 
	 * @param reservaViaje El objeto <code>ReservaViaje</code>.
	 */
	
	public void agregarReserva(ReservaViaje reservaViaje);
	
}