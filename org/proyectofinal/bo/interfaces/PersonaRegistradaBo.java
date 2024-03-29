package org.proyectofinal.bo.interfaces;

import org.proyectofinal.bo.ex.PersonAlreadyExistsException;
import org.proyectofinal.bo.ex.PersonGenericNotValidDniException;
import org.proyectofinal.bo.ex.PersonNotValidAgeException;
import org.proyectofinal.bo.ex.PersonNotValidEmailException;
import org.proyectofinal.bo.ex.PersonNotValidException;
import org.proyectofinal.model.interfaces.PersonaRegistrada;

/**
 * Interfaz de la Clase de Negocio de la Entidad de Dominio <strong>PersonaRegistrada</strong>: <code>PersonaRegistradaBo</code>.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public interface PersonaRegistradaBo {

	/**
	 * Metodo de negocio que verifica que todos los atributos del objeto <code>PersonaRegistrada</code> sean validos.
	 *
	 * @param p El objeto <code>PersonaRegistrada</code>.
	 * @throws PersonNotValidException Si algun atributo del objeto <code>PersonaRegistrada</code> no es valido.
	 */
	
	public void verificarTodos(PersonaRegistrada p) throws PersonNotValidException;
		
	/**
	 * Metodo de negocio que verifica que los atributos obligatorios del objeto <code>PersonaRegistrada</code> sean validos.
	 *
	 * @param p El objeto <code>PersonaRegistrada</code>.
	 * @throws PersonNotValidException Si algun atributo obligatorio del objeto <code>PersonaRegistrada</code> no es valido.
	 */
	
	public void verificarImportantes(PersonaRegistrada p) throws PersonNotValidException;
	
	/**
	 * Metodo de negocio que verifica que el atributo <em>dni</em> del objeto <code>PersonaRegistrada</code> sea valido.
	 *
	 * @param p El objeto <code>PersonaRegistrada</code>.
	 * @throws PersonGenericNotValidDniException Si el atributo <em>dni</em> del objeto <code>PersonaRegistrada</code> no es valido.
	 */
	
	public void verificarDni(PersonaRegistrada p) throws PersonGenericNotValidDniException;

	/**
	 * Metodo de negocio que verifica que el atributo <em>email</em> del objeto <code>PersonaRegistrada</code> sea valido.
	 *
	 * @param p El objeto <code>PersonaRegistrada</code>.
	 * @throws PersonNotValidEmailException Si el atributo <em>email</em> del objeto <code>PersonaRegistrada</code> no es valido.
	 */
	
	public void verificarEmail(PersonaRegistrada p) throws PersonNotValidEmailException;
	
	/**
	 * Metodo de negocio que verifica que el atributo <em>edad</em> del objeto <code>PersonaRegistrada</code> sea mayor o igual a 18.
	 *
	 * @param p El objeto <code>PersonaRegistrada</code>
	 * @throws PersonNotValidAgeException Si el atributo <em>edad</em> del objeto <code>PersonaRegistrada</code> es menor a 18.
	 */
	
	public void verificarEdad(PersonaRegistrada p) throws PersonNotValidAgeException;

	/**
	 * Metodo de negocio que retorna un objeto <code>PersonaRegistrada</code> con todos sus atributos a partir del usuario pasado como parametro.
	 *
	 * @param usuario El atributo <em>usuario</em> de la <code>PersonaRegistrada</code>.
	 * @return El objeto <code>PersonaRegistrada</code> con todos sus atributos.
	 */
	
	public PersonaRegistrada retornarPersonaPorUsuario(String usuario);
	
	/**
	 * Metodo de negocio que retorna el atributo <em>email</em> del objeto <code>PersonaRegistrada</code>.
	 *
	 * @param dni El atributo <em>dni</em> del objeto <code>PersonaRegistrada</code>.
	 * @return El atributo <em>email</em> del objeto <code>PersonaRegistrada</code>.
	 */
	
	public String retornarEmail(String dni);

	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>PersonaRegistrada</code> para verificar la existencia en la base de datos del sistema del objeto <code>PersonaRegistrada</code> pasado como parametro.
	 *
	 * @param p El objeto <code>PersonaRegistrada</code>.
	 * @throws PersonAlreadyExistsException Si el objeto <code>PersonaRegistrada</code> ya existe en la base de datos del sistema.
	 */

	public void controlarExistenciaPersona(PersonaRegistrada p) throws PersonAlreadyExistsException;
	
	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>PersonaRegistrada</code> para insertar un nuevo objeto <code>PersonaRegistrada</code> en la base de datos del sistema.
	 *
	 * @param p El objeto <code>PersonaRegistrada</code>
	 */
		
	public void registrarPersona(PersonaRegistrada p);
		
	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>PersonaRegistrada</code> para modificar los atributos de un objeto <code>PersonaRegistrada</code>.
	 *
	 * @param p El objeto <code>PersonaRegistrada</code>.
	 */
	
	public void modificarPersona(PersonaRegistrada p);
	
	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>PersonaRegistrada</code> para modificar el atributo <em>saldo</em> de un objeto <code>PersonaRegistrada</code>.
	 *
	 * @param distancia El atributo <em>distancia</em> de un <code>ViajeCabecera</code> que sera acumulado al atributo <em>saldo</em> del objeto <code>PersonaRegistrada</code>.
	 * @param dniPersona El atributo <em>dni</em> del objeto <code>PersonaRegistrada</code> al cual se le modificara el atributo <em>saldo</em>.
	 */
	
	public void actualizarSaldo(Integer distancia, String dniPersona);

}