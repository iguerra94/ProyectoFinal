package org.proyectofinal.bo.ex;

/**
 * Excepcion que se lanza si el atributo <em>usuario</em> y/o <em>contrasenia</em> del objeto <code>Usuario</code> no son correctos, es decir, que no existen en la base de datos del sistema.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public class UserNotExistsException extends Exception {
	
//	private static final long serialVersionUID = -8441762609979567803L;

	/**
	 * Instancia un nuevo objeto de la Excepcion <code>UserNotExistsException</code>
	 */
	
	public UserNotExistsException(){
		
	}
	
	/**
	 * Retorna un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 *
	 * @return Un mensaje descriptivo al usuario del sistema sobre la excepcion ocurrida.
	 */
	
	public String getMessage(){
		return "Los datos ingresados de usuario y/o contraseña no son correctos.";
	}

}