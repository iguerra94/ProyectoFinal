package org.proyectofinal.bo.interfaces;

import java.util.List;

import org.proyectofinal.bo.ex.NoFlightsFoundException;
import org.proyectofinal.bo.ex.NotOffersFoundException;
import org.proyectofinal.bo.ex.ViajeCabeceraNotValidException;
import org.proyectofinal.bo.ex.ViajeCabeceraOfferNotValidException;
import org.proyectofinal.model.interfaces.ViajeCabecera;

/**
 * Interfaz de la Clase de Negocio <code>ViajeCabeceraBo</code>.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public interface ViajeCabeceraBo {
	
	/**
	 * Metodo de negocio que verifica que todos los atributos del objeto <code>ViajeCabecera</code> sean validos.
	 *
	 * @param vC El objeto <code>ViajeCabecera</code>.
	 * @throws ViajeCabeceraNotValidException Si algun atributo del objeto <code>ViajeCabecera</code> no es valido.
	 */
	
	public void verificarTodos(ViajeCabecera vC) throws ViajeCabeceraNotValidException;
	
	/**
	 * Metodo de negocio que verifica que los atributos <em>ciudadOrigen</em>, <em>fechaSalida</em> y <em>ciudadDestino</em> del objeto <code>ViajeCabecera</code> sean validos.
	 *
	 * @param vC El objeto <code>ViajeCabecera</code>.
	 * @throws ViajeCabeceraNotValidException Si alguno de los atributos especificados del objeto <code>ViajeCabecera</code> no es valido.
	 */
	
	public void verificarImportantesConFecha(ViajeCabecera vC) throws ViajeCabeceraNotValidException;		
	
	/**
	 * Metodo de negocio que verifica que los atributos <em>ciudadOrigen</em> y <em>ciudadDestino</em> del objeto <code>ViajeCabecera</code> sean validos.
	 *
	 * @param vC El objeto <code>ViajeCabecera</code>.
	 * @throws ViajeCabeceraNotValidException Si alguno de los atributos especificados del objeto <code>ViajeCabecera</code> no es valido.
	 */
	
	public void verificarImportantesSinFecha(ViajeCabecera vC) throws ViajeCabeceraNotValidException;		
	
	/**
	 * Metodo de negocio que verifica que los atributos <em>ciudadOrigen</em>, <em>ciudadDestino</em>, <em>oferta</em> e <em>imagenOferta</em> del objeto <code>ViajeCabecera</code> relacionados con la oferta del vijae sean validos.
	 *
	 * @param vC El objeto <code>ViajeCabecera</code>.
	 * @throws ViajeCabeceraOfferNotValidException Si alguno de los atributos especificados del objeto <code>ViajeCabecera</code> relacionados con la oferta del viaje no es valido.
	 */
	
	public void verificarOferta(ViajeCabecera vC) throws ViajeCabeceraOfferNotValidException;
	
	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>ViajeCabecera</code> y retorna un objeto <code>ViajeCabecera</code> con todos sus atributos.
	 *
	 * @param codViaje El atributo <em>codViaje</em> del objeto <code>ViajeCabecera</code>.
	 * @return El objeto <code>ViajeCabecera</code> con todos sus atributos.
	 */
	
	public ViajeCabecera retornarViaje(String codViaje);
	
	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>ViajeCabecera</code> y retorna una lista con los codigos de viaje de cada uno de los objetos <code>ViajeCabecera</code> existentes en la base de datos del sistema.
	 *
	 * @return La lista con los codigos de viaje de cada uno de los objetos <code>ViajeCabecera</code> existentes en la base de datos del sistema.
	 */
	
	public List<String> retornarCodigosViaje();

	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>ViajeCabecera</code> y retorna una lista con los objetos <code>ViajeCabecera</code> encontrados en la base de datos del sistema segun los atributos <em>ciudadOrigen</em>, <em>ciudadDestino</em> y <em>fechaSalida</em> del objeto <code>ViajeCabecera</code>.
	 *
	 * @param vC El objeto <code>ViajeCabecera</code>.
	 * @return La lista con los objetos <code>ViajeCabecera</code> encontrados en la base de datos del sistema segun los atributos <em>ciudadOrigen</em>, <em>ciudadDestino</em> y <em>fechaSalida</em> del objeto <code>ViajeCabecera</code>.
	 * @throws NoFlightsFoundException Si no existe ningun objeto <code>ViajeCabecera</code> en la base de datos del sistema con los atributos especificados.
	 */
	
	public List<ViajeCabecera> retornarVuelosPorFecha(ViajeCabecera vC) throws NoFlightsFoundException;
	
	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>ViajeCabecera</code> y retorna una lista con los objetos <code>ViajeCabecera</code> encontrados en la base de datos del sistema segun los atributos <em>ciudadOrigen</em> y <em>ciudadDestino</em> del objeto <code>ViajeCabecera</code>.
	 *
	 * @param vC El objeto <code>ViajeCabecera</code>.
	 * @return La lista con los objetos <code>ViajeCabecera</code> encontrados en la base de datos del sistema segun los atributos <em>ciudadOrigen</em> y <em>ciudadDestino</em> del objeto <code>ViajeCabecera</code>.
	 * @throws NoFlightsFoundException Si no existe ningun objeto <code>ViajeCabecera</code> en la base de datos del sistema con los atributos especificados.
	 */
	
	public List<ViajeCabecera> retornarVuelosCualquierFecha(ViajeCabecera vC) throws NoFlightsFoundException;
	
	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>ViajeCabecera</code> y retorna una lista con las ciudades de origen, pais de origen, ciudad de destino y pais de destino de cada uno de los objetos <code>ViajeCabecera</code> existentes en la base de datos del sistema.
	 *
	 * @return La lista con las ciudades de origen, pais de origen, ciudad de destino y pais de destino de cada uno de los objetos <code>ViajeCabecera</code> existentes en la base de datos del sistema.
	 */
	
	public List<String> retornarOrigenesDestinos();
	
	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>ViajeCabecera</code> y retorna una lista con las ciudades de origen y pais de origen de cada uno de los objetos <code>ViajeCabecera</code> existentes en la base de datos del sistema.
	 *
	 * @return La lista con las ciudades de origen y pais de origen de cada uno de los objetos <code>ViajeCabecera</code> existentes en la base de datos del sistema.
	 */
	
	public List<String> retornarOrigenes();
	
	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>ViajeCabecera</code> y retorna una lista con las ciudades de destino y pais de destino de cada uno de los objetos <code>ViajeCabecera</code> existentes en la base de datos del sistema.
	 *
	 * @return La lista con las ciudades de destino y pais de destino de cada uno de los objetos <code>ViajeCabecera</code> existentes en la base de datos del sistema.
	 */
	
	public List<String> retornarDestinos();

	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>ViajeCabecera</code> para verificar que objetos <code>ViajeCabecera</code> tienen el atributo <em>oferta</em> mayor a cero, luego para cada uno de ellos setea un objeto <code>ViajeCabecera</code> con todos los atributos relacionados a la oferta de un viaje y retorna una lista con dichos objetos <code>ViajeCabecera</code>.
	 *
	 * @return La lista con los objetos <code>ViajeCabecera</code> que tienen el atributo <em>oferta</em> mayor a cero, con los atributos relacionados a la oferta de un viaje seteados.
	 */
	
	public List<ViajeCabecera> retornarListaOfertas();
	
	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>ViajeCabecera</code> para verificar que objetos <code>ViajeCabecera</code> tienen el atributo <em>oferta</em> mayor a cero y retorna una lista con los atributos <em>ciudadOrigen</em>, <em>paisOrigen</em>, <em>ciudadDestino</em> y <em>paisDestino</em> de dichos objetos <code>ViajeCabecera</code>.
	 *
	 * @return La lista con los atributos <em>ciudadOrigen</em>, <em>paisOrigen</em>, <em>ciudadDestino</em> y <em>paisDestino</em> de los objetos <code>ViajeCabecera</code> que tienen el atributo <em>oferta</em> mayor a cero.
	 * @throws NotOffersFoundException Si no existe ningun objeto <code>ViajeCabecera</code> en la base de datos del sistema con el atributo <em>oferta</em> mayor a cero.
	 */
	
	public List<String> retornarOfertas() throws NotOffersFoundException;
	
	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>ViajeCabecera</code> para insertar un nuevo objeto <code>ViajeCabecera</code> en la base de datos del sistema.
	 *
	 * @param vC El objeto <code>ViajeCabecera</code>.
	 */
	
	public void cargarVuelo(ViajeCabecera vC);

	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>ViajeCabecera</code> para actualizar los atributos <em>oferta</em> e <em>imagenOferta</em> de un objeto <code>ViajeCabecera</code>.
	 *
	 * @param vC El objeto <code>ViajeCabecera</code>.
	 */
	
	public void cargarOferta(ViajeCabecera vC);

	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>ViajeCabecera</code> para eliminar un objeto <code>ViajeCabecera</code> de la base de datos del sistema.
	 *
	 * @param codigo El atributo <em>codigoViaje</em> del objeto <code>ViajeCabecera</code>.
	 */
	
	public void eliminarVuelo(String codigo);
	
	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>ViajeCabecera</code> para actualizar los atributos <em>oferta</em> e <em>imagenOferta</em> de un objeto <code>ViajeCabecera</code>, seteando sus valores en \"0.0\" y \"\"".
	 *
	 * @param vC El objeto <code>ViajeCabecera</code>. 
	 */
	
	public void eliminarOferta(ViajeCabecera vC);
	
	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>ViajeCabecera</code> para modificar los atributos de un objeto <code>ViajeCabecera</code>.
	 *
	 * @param vC El objeto <code>ViajeCabecera</code>.
	 */
	
	public void modificarVuelo(ViajeCabecera vC);

	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>ViajeCabecera</code> para modificar el atributo <em>cupo</em> de un objeto <code>ViajeCabecera</code>.
	 *
	 * @param viaje El objeto <code>ViajeCabecera</code>.
	 */
	
	public void actualizarCupo(ViajeCabecera viaje);
	
}