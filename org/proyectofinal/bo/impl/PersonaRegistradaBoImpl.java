package org.proyectofinal.bo.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.bo.ex.PersonAlreadyExistsException;
import org.proyectofinal.bo.ex.PersonNotValidAgeException;
import org.proyectofinal.bo.ex.PersonNotValidException;
import org.proyectofinal.bo.interfaces.PersonaRegistradaBo;
import org.proyectofinal.dao.impl.PersonaRegistradaDaoImpl;
import org.proyectofinal.dao.interfaces.PersonaRegistradaDao;
import org.proyectofinal.model.impl.PersonaRegistradaImpl;
import org.proyectofinal.model.interfaces.PersonaRegistrada;

/**
 * Implementacion de la Clase de Negocio PersonaRegistradaBo.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public class PersonaRegistradaBoImpl implements PersonaRegistradaBo {
	
	/**
	 * Instancia un nuevo Objeto de la Clase de Negocio PersonaRegistradaBo.
	 */
	
	public PersonaRegistradaBoImpl(){
		
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.PersonaRegistradaBo#verificarTodos(org.proyectofinal.model.interfaces.PersonaRegistrada)
	 */
	public void verificarTodos(PersonaRegistrada p) throws PersonNotValidException{
		
		if (p.getDni() == null || p.getNombre() == null || p.getApellido() == null || 
			p.getEmail() == null || p.getFechaNacimiento() == null || p.getTelefono() == null ||
			p.getPais() == null || p.getCiudad() == null){
			
			throw new PersonNotValidException();
		}
		
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.PersonaRegistradaBo#verificarImportantes(org.proyectofinal.model.interfaces.PersonaRegistrada)
	 */
	public void verificarImportantes(PersonaRegistrada p) throws PersonNotValidException {
	
		if (p.getDni() == null || p.getDni().length() == 0 || p.getNombre() == null || p.getNombre().length() == 0 || p.getApellido() == null || 
			p.getApellido().length() == 0 || p.getEmail() == null || p.getEmail().length() == 0){
			
			throw new PersonNotValidException();
		}
		
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.PersonaRegistradaBo#verificarEdad(org.proyectofinal.model.interfaces.PersonaRegistrada)
	 */
	public void verificarEdad(PersonaRegistrada p) throws PersonNotValidAgeException {
		
		Integer edad = null;
		
		Integer anioNacimiento = Integer.parseInt(p.getFechaNacimiento().toString().substring(0, 4));
		Integer mesNacimiento = Integer.parseInt(p.getFechaNacimiento().toString().substring(5, 7));

		java.util.Date now = new java.util.Date();
		
		Date date = new Date(now.getTime());
		
		Integer anioActual = Integer.parseInt(date.toString().substring(0, 4));
		Integer mesActual = Integer.parseInt(date.toString().substring(5, 7));
		
		if (mesActual < mesNacimiento){
			edad = anioActual-anioNacimiento-1;
		}else{
			edad = anioActual-anioNacimiento;
		}
		
		if (edad < 18){
			throw new PersonNotValidAgeException();
		}

	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.PersonaRegistradaBo#retornarPersonaPorUsuario(java.lang.String)
	 */
	public PersonaRegistrada retornarPersonaPorUsuario(String usuario) {
		
		PersonaRegistrada pR = new PersonaRegistradaImpl();

		PersonaRegistradaDao pRDao = new PersonaRegistradaDaoImpl();
		
		try {
			
			pRDao.conectar();
			
			ResultSet res = pRDao.consultarPorUsuario(usuario);
			
			while (res.next()) {
				pR.setDni(res.getString("dni"));
				pR.setNombre(res.getString("nombre"));
				pR.setApellido(res.getString("apellido"));
				pR.setEmail(res.getString("email"));
				pR.setTelefono(res.getString("telefono"));
				pR.setFechaNacimiento(res.getDate("fechaNacimiento"));
				pR.setPais(res.getString("pais"));
				pR.setCiudad(res.getString("ciudad"));
				pR.setSaldo(res.getInt("saldo"));
			}

			pRDao.desconectar();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return pR;
		
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.PersonaRegistradaBo#retornarEmail(java.lang.String)
	 */
	public String retornarEmail(String dni){
		
		String email = null;

		PersonaRegistradaDao pRDao = new PersonaRegistradaDaoImpl();

		try {

			pRDao.conectar();
			
			ResultSet res = pRDao.consultarEmail(dni);
			
			while (res.next()) {
				email = res.getString("email");
			}
			
			pRDao.desconectar();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return email;		
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.PersonaRegistradaBo#registrarPersona(org.proyectofinal.model.interfaces.PersonaRegistrada)
	 */
	public void registrarPersona(PersonaRegistrada p) throws PersonAlreadyExistsException {
		
		PersonaRegistradaDao pDao = new PersonaRegistradaDaoImpl();
		
		try {
			pDao.altaPersonaRegistrada(p);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.PersonaRegistradaBo#modificarPersona(org.proyectofinal.model.interfaces.PersonaRegistrada)
	 */
	public void modificarPersona(PersonaRegistrada pR){
		
		PersonaRegistradaDao pRDao = new PersonaRegistradaDaoImpl();
		
		try {
			pRDao.modificacion(pR);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.PersonaRegistradaBo#actualizarSaldo(java.lang.Integer, java.lang.String)
	 */
	public void actualizarSaldo(Integer distancia, String dniPersona) {
			
		PersonaRegistradaDao pRDao = new PersonaRegistradaDaoImpl();
		
		try {
			pRDao.modificarSaldo(distancia, dniPersona);
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}