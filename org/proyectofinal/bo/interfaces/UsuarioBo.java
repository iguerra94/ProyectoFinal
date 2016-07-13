package org.proyectofinal.bo.interfaces;

import org.proyectofinal.bo.ex.NotEqualPasswordException;
import org.proyectofinal.bo.ex.UserNotExistsException;
import org.proyectofinal.bo.ex.UserNotValidException;
import org.proyectofinal.model.interfaces.Usuario;

/**
 * Interfaz de la Clase de Negocio de la Entidad de Dominio <strong>Usuario</strong>: <code>UsuarioBo</code>.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public interface UsuarioBo {
	
	/**
	 * Metodo de negocio que verifica que todos los atributos del objeto <code>Usuario</code> sean validos.
	 *
	 * @param u El objeto <code>Usuario</code>.
	 * @throws UserNotValidException Si algun atributo del objeto <code>Usuario</code> no es valido.
	 */
	
	public void verificar(Usuario u) throws UserNotValidException;
	
	/**
	 * Metodo de negocio que verifica que el atributo <em>usuario</em> del objeto <code>Usuario</code> es valido.
	 *
	 * @param usuario El atributo <em>usuario</em> del Usuario.
	 * @throws UserNotValidException Si el atributo <em>usuario</em> del objeto <code>Usuario</code> no es valido.
	 */
	
	public void verificarUsuario(String usuario) throws UserNotValidException;
	
	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>Usuario</code> para verificar que todos los atributos del objeto <code>Usuario</code> pasado como parametro sean correctos, es decir, que existan en la base de datos del sistema.
	 *
	 * @param u El objeto <code>Usuario</code>.
	 * @throws UserNotExistsException Si el atributo <em>usuario</em> y/o <em>contrasenia</em> del objeto <code>Usuario</code> no son correctos, es decir, que no existen en la base de datos del sistema. 
	 */
	
	public void verificarDatosCorrectos(Usuario u) throws UserNotExistsException;
	
	/**
	 * Metodo de negocio que verifica que las dos contrasenias pasadas como parametro sean iguales.
	 *
	 * @param nueva La nueva contrasenia.
	 * @param confirmar La contrasenia a la que se quiere comparar con la nueva contrasenia.
	 * @throws NotEqualPasswordException Si las contrasenias pasadas como parametro no coinciden.
	 */
	
	public void controlarNuevaContrasenia(char[] nueva, char[] confirmar) throws NotEqualPasswordException;
	
	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>Usuario</code> y retorna un objeto <code>Usuario</code> con todos sus atributos.
	 *
	 * @param usuario El atributo <em>usuario</em> del objeto <code>Usuario</code>.
	 * @return El objeto <code>Usuario</code> con todos sus atributos.
	 * @throws UserNotExistsException Si el atributo <em>usuario</em> del objeto <code>Usuario</code> no existe en la base de datos del sistema.
	 */
	
	public Usuario retornarUsuario(String usuario) throws UserNotExistsException;
	
	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>Usuario</code> y retorna el atributo <em>dni</em> de la <code>PersonaRegistrada</code> relacionada con el <code>Usuario</code>.
	 *
	 * @param usuario El atributo <em>usuario</em> del objeto <code>Usuario</code>.
	 * @return El atributo <em>dni</em> de la <code>PersonaRegistrada</code> relacionada con el <code>Usuario</code>.
	 */
	
	public String retornarDniPorUsuario(String usuario);
	
	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>Usuario</code> y retorna el atributo <em>contrasenia</em> del <code>Usuario</code>.
	 *
	 * @param usuario El atributo <em>usuario</em> del objeto <code>Usuario</code>.
	 * @return El atributo <em>contrasenia</em> del <code>Usuario</code>.
	 * @throws UserNotExistsException Si el atributo <em>usuario</em> del <code>Usuario</code> no existe en la base de datos del sistema.
	 */
	
	public String recuperarPass(String usuario) throws UserNotExistsException;

	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>Usuario</code> para insertar un nuevo objeto <code>Usuario</code> en la base de datos del sistema.
	 *
	 * @param u El objeto <code>Usuario</code>.
	 */
	
	public void registrarUsuario(Usuario u);

	/**
	 * Metodo de negocio que se conecta con el objeto DAO <code>Usuario</code> para modificar el atributo <em>contrasenia</em> de un objeto <code>Usuario</code>.
	 *
	 * @param contrasenia El atributo <em>contrasenia</em> del <code>Usuario</code>.
	 * @param usuario El atributo <em>usuario</em> del <code>Usuario</code>.
	 */
	
	public void modificarContrasenia(String contrasenia, String usuario);
	
}