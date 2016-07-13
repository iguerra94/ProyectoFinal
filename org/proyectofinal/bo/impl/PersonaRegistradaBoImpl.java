package org.proyectofinal.bo.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.bo.ex.DniNotValidException;
import org.proyectofinal.bo.ex.EmailNotValidException;
import org.proyectofinal.bo.ex.PersonAlreadyExistsException;
import org.proyectofinal.bo.ex.PersonNotValidAgeException;
import org.proyectofinal.bo.ex.PersonNotValidException;
import org.proyectofinal.bo.ex.UserAlreadyExistsException;
import org.proyectofinal.bo.interfaces.PersonaRegistradaBo;
import org.proyectofinal.dao.impl.PersonaRegistradaDaoImpl;
import org.proyectofinal.dao.interfaces.PersonaRegistradaDao;
import org.proyectofinal.model.impl.PersonaRegistradaImpl;
import org.proyectofinal.model.interfaces.PersonaRegistrada;

/**
 * Implementacion de la Clase de Negocio de la Entidad de Dominio <strong>PersonaRegistrada</strong>: <code>PersonaRegistradaBo</code>.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public class PersonaRegistradaBoImpl implements PersonaRegistradaBo {
	
	/**
	 * Instancia un nuevo objeto de la Clase de Negocio <code>PersonaRegistradaBo</code>.
	 */
	
	public PersonaRegistradaBoImpl(){
		
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.PersonaRegistradaBo#verificarTodos(org.proyectofinal.model.interfaces.PersonaRegistrada)
	 */
	
	public void verificarTodos(PersonaRegistrada p) throws PersonNotValidException {
		
		if (p.getDni() == null || p.getDni().length() == 0 || 
			p.getNombre() == null || p.getNombre().length() == 0 ||
			p.getApellido() == null || p.getApellido().length() == 0 ||
			p.getEmail() == null || p.getEmail().length() == 0 ||
			p.getFechaNacimiento() == null || 
			p.getTelefono() == null || p.getTelefono().length() == 0 ||
			p.getPais() == null || p.getPais().length() == 0 || 
			p.getCiudad() == null || p.getCiudad().length() == 0){
			
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
	 * @see org.proyectofinal.bo.interfaces.PersonaRegistradaBo#verificarDni(org.proyectofinal.model.interfaces.PersonaRegistrada)
	 */
	
	public void verificarDni(PersonaRegistrada p) throws DniNotValidException {
		
		if (p.getDni().length() < 8){
			throw new DniNotValidException();
		}
		
	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.PersonaRegistradaBo#verificarEmail(org.proyectofinal.model.interfaces.PersonaRegistrada)
	 */
	
	public void verificarEmail(PersonaRegistrada p) throws EmailNotValidException {
        
        if (!p.getEmail().matches("^([0-9a-zA-Z_.]+@gmail.com)$")) {
        	throw new EmailNotValidException();
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
			
			ResultSet res = pRDao.consultarDatosPersonaRegistradaPorUsuario(usuario);
			
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
	 * @see org.proyectofinal.bo.interfaces.PersonaRegistradaBo#controlarExistenciaUsuarioYPersona(org.proyectofinal.model.interfaces.PersonaRegistrada)
	 */
	
	public void controlarExistenciaUsuarioYPersona(PersonaRegistrada p) throws UserAlreadyExistsException, PersonAlreadyExistsException{
		
		PersonaRegistradaDao pDao = new PersonaRegistradaDaoImpl();
		
		try {
			
			pDao.conectar();
			
			ResultSet res1 = pDao.consultarPersonaRegistradaPorUsuario(p.getUsuario());
			
			if (res1.next()){
				throw new UserAlreadyExistsException();
			}
			
			ResultSet res2 = pDao.consultarPorDni(p);
			
			if (res2.next()){
				throw new PersonAlreadyExistsException();
			}
			
			pDao.desconectar();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();			
		}

	}
	
	/* (non-Javadoc)
	 * @see org.proyectofinal.bo.interfaces.PersonaRegistradaBo#registrarPersona(org.proyectofinal.model.interfaces.PersonaRegistrada)
	 */
	
	public void registrarPersona(PersonaRegistrada p) {
		
		PersonaRegistradaDao pDao = new PersonaRegistradaDaoImpl();
		
		try {
			
			pDao.conectar();
			
			ResultSet res1 = pDao.consultarPersonaGenericaPorDni(p);
			
			if (!res1.next()){
				pDao.altaPersonaGenerica(p);
			}
			
			pDao.altaPersonaRegistrada(p);
			
			pDao.desconectar();

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