package org.proyectofinal.bo.interfaces;

import org.proyectofinal.bo.ex.DniNotValidException;
import org.proyectofinal.bo.ex.NotValidPassengerException;
import org.proyectofinal.model.interfaces.Pasajero;

/**
 * Interfaz de la Clase de Negocio de la Entidad de Dominio <strong>Pasajero</strong>: <code>PasajeroBo</code>.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public interface PasajeroBo {
	
	/**
	 * Metodo de negocio que verifica que todos los atributos del objeto <code>Pasajero</code> sean validos.
	 *
	 * @param p El objeto <code>Pasajero</code>.
	 * @throws NotValidPassengerException Si algun atributo del objeto <code>Pasajero</code> no es valido.
	 */
	
	public void verificarDatosPasajero(Pasajero p) throws NotValidPassengerException;

	/**
	 * Metodo de negocio que verifica que el atributo <em>dni</em> del objeto <code>Pasajero</code> sea valido.
	 *
	 * @param p El objeto <code>Pasajero</code>.
	 * @throws DniNotValidException Si el atributo <em>dni</em> del objeto <code>Pasajero</code> no es valido.
	 */
	
	public void verificarDniPasajero(Pasajero p) throws DniNotValidException;
	
	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>Pasajero</code> y retorna un objeto <code>Pasajero</code> con todos sus atributos.
	 *
	 * @param dniPasajero El dni del <code>Pasajero</code>.
	 * @return El objeto <code>Pasajero</code> con todos sus atributos.
	 */
	
	public Pasajero retornarPasajero(String dniPasajero);
	
	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>Pasajero</code> para insertar un nuevo objeto <code>Pasajero</code> en la base de datos del sistema.
	 *
	 * @param p El objeto <code>Pasajero</code>.
	 */
	
	public void agregarPasajero(Pasajero p);
	
}