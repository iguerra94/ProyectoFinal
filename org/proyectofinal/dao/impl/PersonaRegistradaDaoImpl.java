package org.proyectofinal.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.dao.abstracts.AbstractDao;
import org.proyectofinal.dao.interfaces.PersonaRegistradaDao;
import org.proyectofinal.model.interfaces.PersonaRegistrada;
import org.proyectofinal.model.interfaces.Usuario;

/**
 * Implementacion de la clase de persistencia de datos de la entidad de dominio <strong>PersonaRegistrada</strong>: <code>PersonaRegistradaDao</code>.
 *  
 * @author Ivan Guerra
 * @version 1.0.0 
 */

public class PersonaRegistradaDaoImpl extends AbstractDao implements PersonaRegistradaDao {

	/**
	 * Instancia un nuevo objeto de la clase de persistencia de datos <code>PersonaRegistradaDao</code>.
	 */
	
	public PersonaRegistradaDaoImpl(){
		
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.abstracts.AbstractDao#conectar()
	 */

	public void conectar() throws ClassNotFoundException, SQLException{
		super.conectar();
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.abstracts.AbstractDao#desconectar()
	 */
	
	public void desconectar() throws SQLException{
		super.desconectar();
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.PersonaRegistradaDao#consultar()
	 */
	
	public ResultSet consultar() throws SQLException, ClassNotFoundException {
		
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("select * from PersonaRegistrada inner join PersonaGenerica");
		
		ResultSet resultado = sentencia.executeQuery();

		return resultado;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.PersonaRegistradaDao#consultarPorDni(org.proyectofinal.model.interfaces.PersonaRegistrada)
	 */
	
	public ResultSet consultarPorDni(PersonaRegistrada p) throws SQLException, ClassNotFoundException {
		
		PreparedStatement sentencia = getConexion().prepareStatement("select * from PersonaRegistrada preg inner join PersonaGenerica pg on pg.dni = preg.dni where pg.dni = ?");
		
		sentencia.setString(1, p.getDni());
		
		ResultSet resultado = sentencia.executeQuery();
		
		return resultado;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.PersonaRegistradaDao#consultarPersonaPorDni(org.proyectofinal.model.interfaces.PersonaRegistrada)
	 */
	
	public ResultSet consultarPersonaPorDni(PersonaRegistrada p) throws SQLException, ClassNotFoundException {
		
		PreparedStatement sentencia = getConexion().prepareStatement("select * from PersonaGenerica where dni = ?");
		
		sentencia.setString(1, p.getDni());
		
		ResultSet resultado = sentencia.executeQuery();
		
		return resultado;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.PersonaRegistradaDao#consultarPersonaPorDni(java.lang.String)
	 */
	
	public ResultSet consultarPersonaPorDni(String dni) throws SQLException, ClassNotFoundException {
		
		PreparedStatement sentencia = getConexion().prepareStatement("select * from PersonaGenerica where dni = ?");
		
		sentencia.setString(1, dni);
		
		ResultSet resultado = sentencia.executeQuery();
		
		return resultado;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.PersonaRegistradaDao#consultarPorPersonaYUsuario(java.lang.String)
	 */
	
	public ResultSet consultarPorPersonaYUsuario(String dni) throws SQLException, ClassNotFoundException {
		
		conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("select * from PersonaGenerica pg inner join PersonaRegistrada preg on pg.dni = preg.dni inner join Usuario u on u.usuario = preg.usuario where pg.dni = ?");
		
		sentencia.setString(1, dni);
		
		ResultSet resultado = sentencia.executeQuery();
	
		return resultado;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.PersonaRegistradaDao#consultarPorUsuario(org.proyectofinal.model.interfaces.Usuario)
	 */

	public ResultSet consultarPorUsuario(Usuario u) throws SQLException, ClassNotFoundException {
		
		PreparedStatement sentencia = getConexion().prepareStatement("select * from Usuario u where u.usuario = ?");
		
		sentencia.setString(1, u.getNombreUsuario());

		ResultSet resultado = sentencia.executeQuery();
		
		return resultado;
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.PersonaRegistradaDao#consultarPorUsuario(java.lang.String)
	 */
	
	public ResultSet consultarPorUsuario(String user) throws SQLException, ClassNotFoundException {
		
		PreparedStatement sentencia = getConexion().prepareStatement("select * from PersonaRegistrada pr inner join PersonaGenerica pg on pg.dni = pr.dni where usuario = ?");

		sentencia.setString(1, user);
		
		ResultSet resultado = sentencia.executeQuery();
		
		return resultado;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.PersonaRegistradaDao#consultarEmail(java.lang.String)
	 */
	
	public ResultSet consultarEmail(String dni) throws SQLException, ClassNotFoundException {
		
		PreparedStatement sentencia = getConexion().prepareStatement("select email from PersonaRegistrada where dni = ?");
		
		sentencia.setString(1, dni);
		
		ResultSet resultado = sentencia.executeQuery();
		
		return resultado;
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.PersonaRegistradaDao#altaPersonaRegistrada(org.proyectofinal.model.interfaces.PersonaRegistrada)
	 */
	
	public void altaPersonaGenerica(PersonaRegistrada p) throws SQLException{
		
		PreparedStatement sentencia1 = getConexion().prepareStatement("insert into PersonaGenerica (dni, nombre, apellido) VALUES (?,?,?)");
		
		sentencia1.setString(1, p.getDni());
		sentencia1.setString(2, p.getNombre());
		sentencia1.setString(3, p.getApellido());
		
		sentencia1.executeUpdate();
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.PersonaRegistradaDao#altaPersonaRegistradaYUsuarioRelacionado(org.proyectofinal.model.interfaces.PersonaRegistrada)
	 */
	
	public void altaPersonaRegistrada(PersonaRegistrada p) throws SQLException{
	
		PreparedStatement sentencia1 = getConexion().prepareStatement("insert into PersonaRegistrada (dni, email, telefono, fechaNacimiento, pais, ciudad, saldo, usuario) VALUES (?,?,?,?,?,?,?,?)");
		
		sentencia1.setString(1, p.getDni());
		sentencia1.setString(2, p.getEmail());
		sentencia1.setString(3, p.getTelefono());
		sentencia1.setDate(4, p.getFechaNacimiento());
		sentencia1.setString(5, p.getPais());
		sentencia1.setString(6, p.getCiudad());
		sentencia1.setInt(7, p.getSaldo());
		sentencia1.setString(8, p.getUsuario().getNombreUsuario());

		sentencia1.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.PersonaRegistradaDao#bajaPersonaRegistrada(org.proyectofinal.model.interfaces.PersonaRegistrada)
	 */
	
	public void bajaPersonaRegistrada(PersonaRegistrada p) throws SQLException, ClassNotFoundException{
		
		this.conectar();
		
		PreparedStatement sentencia = getConexion().prepareStatement("delete from personaRegistrada where dni = ?");

		sentencia.setString(1, p.getDni());
		
		sentencia.executeUpdate();
		
		this.desconectar();
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.PersonaRegistradaDao#modificacion(org.proyectofinal.model.interfaces.PersonaRegistrada)
	 */
	
	@Override
	public void modificacion(PersonaRegistrada pR) throws SQLException, ClassNotFoundException {

		conectar();

		PreparedStatement sentencia1 = getConexion().prepareStatement("update PersonaGenerica set nombre = ?, apellido = ? where dni = ?");
		
		sentencia1.setString(1, pR.getNombre());
		sentencia1.setString(2, pR.getApellido());
		sentencia1.setString(3, pR.getDni());

		PreparedStatement sentencia2 = getConexion().prepareStatement("update PersonaRegistrada set email = ?, telefono = ? where dni = ?");

		sentencia2.setString(1, pR.getEmail());
		sentencia2.setString(2, pR.getTelefono());
		sentencia2.setString(3, pR.getDni());
		
		sentencia1.executeUpdate();
		sentencia2.executeUpdate();
		
		desconectar();
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.dao.interfaces.PersonaRegistradaDao#modificarSaldo(java.lang.Integer, java.lang.String)
	 */
	
	@Override
	public void modificarSaldo(Integer distancia, String dniPersona) throws SQLException, ClassNotFoundException {
		
		conectar();
		
		PreparedStatement sentencia = null;
		
		sentencia = getConexion().prepareStatement("update PersonaRegistrada set saldo = saldo + ? where dni = ?");
		
		sentencia.setInt(1, distancia);
		sentencia.setString(2, dniPersona);
		
		sentencia.executeUpdate();
	
		desconectar();
	}

}