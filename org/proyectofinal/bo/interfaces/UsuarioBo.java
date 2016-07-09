package org.proyectofinal.bo.interfaces;

import org.proyectofinal.bo.ex.NotEqualPasswordException;
import org.proyectofinal.bo.ex.UserAlreadyExistsException;
import org.proyectofinal.bo.ex.UserNotCorrectException;
import org.proyectofinal.bo.ex.UserNotExistsException;
import org.proyectofinal.bo.ex.UserNotValidException;
import org.proyectofinal.model.interfaces.Usuario;

/**
 * Interfaz de la Clase de Negocio UsuarioBo.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public interface UsuarioBo {
	
	/**
	 * Metodo de negocio que verifica que todos los atributos del objeto Usuario sean validos.
	 *
	 * @param u El objeto Usuario.
	 * @throws UserNotValidException Si algun atributo del objeto Usuario no es valido.
	 */
	
	public void verificar(Usuario u) throws UserNotValidException;
	
	/**
	 * Metodo de negocio que verifica que el atributo usuario del objeto Usuario es valido.
	 *
	 * @param usuario El atributo usuario del Usuario.
	 * @throws UserNotValidException Si el atributo usuario del objeto Usuario no es valido.
	 */
	
	public void verificarUsuario(String usuario) throws UserNotValidException;
	
	/**
	 * Metodo de negocio que se conecta con el objeto DAO Usuario para verificar que todos los atributos del objeto Usuario pasado como parametro sean correctos, es decir, que existan en la base de datos del sistema.
	 *
	 * @param u El objeto Usuario.
	 * @throws UserNotCorrectException Si algun atributo del objeto Usuario pasado como parametro no es correcto, es decir, que no existe en la base de datos del sistema.
	 */
	
	public void verificarDatosCorrectos(Usuario u) throws UserNotCorrectException;
	
	/**
	 * Metodo de negocio que verifica que las dos contrasenias pasadas como parametro sean iguales.
	 *
	 * @param nueva La nueva contrasenia.
	 * @param confirmar La contrasenia a la que se quiere comparar con la nueva contrasenia.
	 * @throws NotEqualPasswordException Si las contrasenias pasadas como parametro no coinciden.
	 */
	
	public void controlarNuevaContrasenia(char[] nueva, char[] confirmar) throws NotEqualPasswordException;
	
	/**
	 * Metodo de negocio que se conecta con el objeto DAO Usuario y retorna un objeto Usuario con todos sus atributos.
	 *
	 * @param usuario El atributo usuario del Usuario.
	 * @return El objeto Usuario con todos sus atributos.
	 * @throws UserNotExistsException Si el atributo usuario del Usuario no existe en la base de datos del sistema.
	 */
	
	public Usuario retornarUsuario(String usuario) throws UserNotExistsException;
	
	/**
	 * Metodo de negocio que se conecta con el objeto DAO Usuario y retorna el atributo dni de la PersonaRegistrada relacionado con el Usuario.
	 *
	 * @param usuario El atributo usuario del Usuario
	 * @return El atributo dni de la PersonaRegistrada relacionado con el Usuario.
	 */
	
	public String retornarDniPorUsuario(String usuario);
	
	/**
	 * Metodo de negocio que se conecta con el objeto DAO Usuario y retorna el atributo contrasenia del Usuario.
	 *
	 * @param usuario El atributo usuario del Usuario.
	 * @return El atributo contrasenia del Usuario.
	 * @throws UserNotExistsException Si el atributo usuario del Usuario no existe en la base de datos del sistema.
	 */
	
	public String recuperarPass(String usuario) throws UserNotExistsException;

	/**
	 * Metodo de negocio que se conecta con el objeto DAO Usuario para insertar un nuevo objeto Usuario.
	 *
	 * @param u El objeto Usuario.
	 * @throws UserAlreadyExistsException Si el objeto Usuario ya existe en la base de datos del sistema.
	 */
	
	public void registrarUsuario(Usuario u) throws UserAlreadyExistsException;

	/**
	 * Metodo de negocio que se conecta con el objeto DAO Usuario para modificar el atributo contrasenia del objeto Usuario.
	 *
	 * @param contrasenia El atributo contrasenia del Usuario.
	 * @param usuario El atributo usuario del Usuario.
	 */
	
	public void modificarContrasenia(String contrasenia, String usuario);
	
}