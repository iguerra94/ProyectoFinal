package org.proyectofinal.dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.model.interfaces.ViajeCabecera;

/**
 * Interfaz de la Clase de Persistencia de Datos de la Entidad de Dominio <strong>ViajeCabecera</strong>: <code>ViajeCabeceraDao</code>.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public interface ViajeCabeceraDao {
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.impl.ViajeCabeceraDaoImpl#conectar()
	 */
	
	public void conectar() throws ClassNotFoundException, SQLException;
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.impl.ViajeCabeceraDaoImpl#desconectar()
	 */
	
	public void desconectar() throws SQLException;
	
	/**
	 * Metodo de Persistencia de Datos que retorna un objeto ResultSet con todos los datos de cada uno de los <code>ViajeCabecera</code> existentes en la base de datos del sistema.
	 *
	 * @return Un objeto ResultSet con todos los datos de cada uno de los <code>ViajeCabecera</code> existentes en la base de datos del sistema.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 */

	public ResultSet consultarVuelos() throws SQLException;

	/**
	 * Metodo de Persistencia de Datos que retorna un objeto ResultSet con todos los datos del <code>ViajeCabecera</code> con el atributo <em>codViaje</em> pasado como parametro.
	 *
	 * @param codViaje El atributo <em>codViaje</em> del <code>ViajeCabecera</code>.
	 * @return Un objeto ResultSet con todos los datos del <code>ViajeCabecera</code> con el atributo <em>codViaje</em> pasado como parametro.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 * @throws ClassNotFoundException Si no se encuentra ninguna definicion de la clase buscada.
	 */
	
	public ResultSet consultarPorCodigoViaje(String codViaje) throws SQLException, ClassNotFoundException;
	
	/**
	 * Metodo de Persistencia de Datos que retorna un objeto ResultSet con los <em>codViaje</em> de cada uno de los <code>ViajeCabecera</code> existentes en la base de datos del sistema.
	 *
	 * @return Un objeto ResultSet con los <em>codViaje</em> de cada uno de los <code>ViajeCabecera</code> existentes en la base de datos del sistema.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 * @throws ClassNotFoundException Si no se encuentra ninguna definicion de la clase buscada.
	 */
	
	public ResultSet consultarCodigosViaje() throws SQLException, ClassNotFoundException;
	
	/**
	 * Metodo de Persistencia de Datos que retorna un objeto ResultSet con todos los datos de cada uno de los <code>ViajeCabecera</code> existentes en la base de datos del sistema con los atributos <em>ciudadOrigen</em>, <em>ciudadDestino</em> y <em>fechaSalida</em> del objeto <code>ViajeCabecera</code> pasado como parametro.
	 *
	 * @param vC El objeto <code>ViajeCabecera</code>.
	 * @return Un objeto ResultSet con todos los datos de cada uno de los <code>ViajeCabecera</code> existentes en la base de datos del sistema con los atributos <em>ciudadOrigen</em>, <em>ciudadDestino</em> y <em>fechaSalida</em> del objeto <code>ViajeCabecera</code> pasado como parametro.
	 * @throws ClassNotFoundException Si no se encuentra ninguna definicion de la clase buscada.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 */
	
	public ResultSet consultarVuelosPorFecha(ViajeCabecera vC) throws ClassNotFoundException, SQLException;
	
	/**
	 * Metodo de Persistencia de Datos que retorna un objeto ResultSet con todos los datos de cada uno de los <code>ViajeCabecera</code> existentes en la base de datos del sistema con los atributos <em>ciudadOrigen</em> y <em>ciudadDestino</em> del objeto <code>ViajeCabecera</code> pasado como parametro.
	 *
	 * @param vC El objeto <code>ViajeCabecera</code>.
	 * @return Un objeto ResultSet con todos los datos de cada uno de los <code>ViajeCabecera</code> existentes en la base de datos del sistema con los atributos <em>ciudadOrigen</em> y <em>ciudadDestino</em> del objeto <code>ViajeCabecera</code> pasado como parametro.
	 * @throws ClassNotFoundException Si no se encuentra ninguna definicion de la clase buscada.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 */
	
	public ResultSet consultarVuelosCualquierFecha(ViajeCabecera vC) throws ClassNotFoundException, SQLException;
	
	/**
	 * Metodo de Persistencia de Datos que retorna un objeto ResultSet con los atributos <em>ciudadOrigen</em>, <em>shortPaisOrigen</em>, <em>ciudadDestino</em> y <em>shortPaisDestino</em> de cada uno de los <code>ViajeCabecera</code> existentes en la base de datos del sistema, sin repetir los cuatro atributos a la vez.
	 *
	 * @return Un objeto ResultSet con los atributos <em>ciudadOrigen</em>, <em>shortPaisOrigen</em>, <em>ciudadDestino</em> y <em>shortPaisDestino</em> de cada uno de los <code>ViajeCabecera</code> existentes en la base de datos del sistema, sin repetir los cuatro atributos a la vez.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 * @throws ClassNotFoundException Si no se encuentra ninguna definicion de la clase buscada.
	 */
	
	public ResultSet consultarOrigenesDestinos() throws SQLException, ClassNotFoundException;
	
	/**
	 * Metodo de Persistencia de Datos que retorna un objeto ResultSet con los atributos <em>ciudadOrigen</em> y <em>shortPaisOrigen</em> de cada uno de los <code>ViajeCabecera</code> existentes en la base de datos del sistema, sin repetir los dos atributos a la vez.
	 *
	 * @return Un objeto ResultSet con los atributos <em>ciudadOrigen</em> y <em>shortPaisOrigen</em> de cada uno de los <code>ViajeCabecera</code> existentes en la base de datos del sistema, sin repetir los dos atributos a la vez.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 * @throws ClassNotFoundException Si no se encuentra ninguna definicion de la clase buscada.
	 */
	
	public ResultSet consultarOrigenes() throws ClassNotFoundException, SQLException;
	
	/**
	 * Metodo de Persistencia de Datos que retorna un objeto ResultSet con los atributos <em>ciudadDestino</em> y <em>shortPaisDestino</em> de cada uno de los <code>ViajeCabecera</code> existentes en la base de datos del sistema, segun la <em>ciudadOrigen</em> pasada como parametro, sin repetir los dos atributos a la vez.
	 *
	 * @param ciudadOrigen El atributo <em>ciudadOrigen</em> del objeto <code>ViajeCabecera</code>.
	 * @return Un objeto ResultSet con los atributos <em>ciudadDestino</em> y <em>shortPaisDestino</em> de cada uno de los <code>ViajeCabecera</code> existentes en la base de datos del sistema, segun la <em>ciudadOrigen</em> pasada como parametro, sin repetir los dos atributos a la vez.
	 * @throws ClassNotFoundException Si no se encuentra ninguna definicion de la clase buscada.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 */
	
	public ResultSet consultarDestinos(String ciudadOrigen) throws ClassNotFoundException, SQLException;
	
	/**
	 * Metodo de Persistencia de Datos que retorna un objeto ResultSet con los valores de los atributos relacionados con la oferta de un <code>ViajeCabecera</code> de cada uno de los <code>ViajeCabecera</code> existentes en la base de datos del sistema. Los atributos que se retornan son: <em>ciudadOrigen</em>, <em>shortPaisOrigen</em>, <em>ciudadDestino</em>, <em>shortPaisDestino</em>, <em>oferta</em>, <em>imagenOferta</em> y <em>precioClaseTur</em>.
	 *
	 * @return Un objeto ResultSet con los valores de los atributos relacionados con la oferta de un <code>ViajeCabecera</code> de cada uno de los <code>ViajeCabecera</code> existentes en la base de datos del sistema.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 * @throws ClassNotFoundException Si no se encuentra ninguna definicion de la clase buscada.
	 */
	
	public ResultSet consultarDatosOferta() throws SQLException, ClassNotFoundException;
		
	/**
	 * Metodo de Persistencia de Datos que inserta un nuevo <code>ViajeCabecera</code> en la base de datos del sistema.
	 *
	 * @param vC El objeto <code>ViajeCabecera</code>.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 * @throws ClassNotFoundException Si no se encuentra ninguna definicion de la clase buscada.
	 */
	
	public void alta(ViajeCabecera vC) throws SQLException, ClassNotFoundException;
	
	/**
	 * Metodo de Persistencia de Datos que modifica en la base de datos del sistema los valores de los atributos del <code>ViajeCabecera</code> relacionados con la oferta, es decir, setea los atributos <em>oferta</em> e <em>imagenOferta</em> del <code>ViajeCabecera</code> pasado como parametro.
	 *
	 * @param vC El objeto <code>ViajeCabecera</code> al cual se le modificaran los atributos relacionados con la oferta.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 * @throws ClassNotFoundException Si no se encuentra ninguna definicion de la clase buscada.
	 */
	
	public void altaOferta(ViajeCabecera vC) throws SQLException, ClassNotFoundException;
	
	/**
	 * Metodo de Persistencia de Datos que elimina un <code>ViajeCabecera</code> de la base de datos del sistema con el atributo <em>codViaje</em> pasado como parametro.
	 *
	 * @param codigoViaje El atributo <em>codViaje</em> del ViajeCabecera a eliminar.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 * @throws ClassNotFoundException Si no se encuentra ninguna definicion de la clase buscada.
	 */
	
	public void baja(String codigoViaje) throws SQLException, ClassNotFoundException;
	
	/**
	 * Metodo de Persistencia de Datos que modifica en la base de datos del sistema los valores de los atributos del <code>ViajeCabecera</code> relacionados con la oferta, es decir, resetea los atributos <em>oferta</em> e <em>imagenOferta</em> del <code>ViajeCabecera</code> pasado como parametro a sus valores iniciales.
	 *
	 * @param vC El objeto <code>ViajeCabecera</code> al cual se le resetearan los atributos relacionados con la oferta.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 * @throws ClassNotFoundException Si no se encuentra ninguna definicion de la clase buscada.
	 */
	
	public void bajaOferta(ViajeCabecera vC) throws SQLException, ClassNotFoundException;	
	
	/**
	 * Metodo de Persistencia de Datos que modifica en la base de datos del sistema los valores de los atributos del <code>ViajeCabecera</code> con el atributo <em>codViaje</em> del objeto <code>ViajeCabecera</code> pasado como parametro.
	 *
	 * @param vC El objeto <code>ViajeCabecera</code> con los nuevos valores en los atributos a modificar en la Entidad <code>ViajeCabecera</code> en la base de datos del sistema.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 * @throws ClassNotFoundException Si no se encuentra ninguna definicion de la clase buscada.
	 */
	
	public void modificacion(ViajeCabecera vC) throws SQLException, ClassNotFoundException;
	
	/**
	 * Metodo de Persistencia de Datos que modifica el atributo <em>cupo</em> de un objeto <code>ViajeCabecera</code>, restandole el valor de dicho atributo en 1 (uno).
	 *
	 * @param vC El objeto <code>ViajeCabecera</code> al cual se le modificara el atributo <em>cupo</em>.
	 * @throws SQLException Si existe algun error en el acceso a los datos de la base de datos.
	 * @throws ClassNotFoundException Si no se encuentra ninguna definicion de la clase buscada.
	 */
	
	public void actualizarCupo(ViajeCabecera vC) throws SQLException, ClassNotFoundException;

}