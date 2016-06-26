package org.proyectofinal.bo.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.proyectofinal.bo.ex.PersonNotValidAgeException;
import org.proyectofinal.bo.interfaces.PersonaRegistradaBo;
import org.proyectofinal.dao.ex.PersonAlreadyExistsException;
import org.proyectofinal.dao.ex.PersonNotValidException;
import org.proyectofinal.dao.impl.PersonaRegistradaDaoImpl;
import org.proyectofinal.dao.impl.ViajeCabeceraDaoImpl;
import org.proyectofinal.dao.interfaces.PersonaRegistradaDao;
import org.proyectofinal.dao.interfaces.ViajeCabeceraDao;
import org.proyectofinal.model.impl.PersonaRegistradaImpl;
import org.proyectofinal.model.impl.ViajeCabeceraImpl;
import org.proyectofinal.model.interfaces.PersonaRegistrada;
import org.proyectofinal.model.interfaces.ViajeCabecera;

public class PersonaRegistradaBoImpl implements PersonaRegistradaBo {
	
	public PersonaRegistradaBoImpl(){
		
	}
	
	public void verificarTodos(PersonaRegistrada p) throws PersonNotValidException{
		
		if (p.getDni() == null || p.getNombre() == null || p.getApellido() == null || 
			p.getEmail() == null || p.getFechaNacimiento() == null || p.getTelefono() == null ||
			p.getPais() == null || p.getCiudad() == null){
			
			throw new PersonNotValidException();
		}
		
	}
	
	public void verificarImportantes(PersonaRegistrada p) throws PersonNotValidException {
	
		if (p.getDni() == null || p.getDni().length() == 0 || p.getNombre() == null || p.getNombre().length() == 0 || p.getApellido() == null || 
			p.getApellido().length() == 0 || p.getEmail() == null || p.getEmail().length() == 0){
			
			throw new PersonNotValidException();
		}
		
	}
	
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
	
	public void registrarPersona(PersonaRegistrada p) throws ClassNotFoundException, SQLException, PersonAlreadyExistsException {
		
		PersonaRegistradaDao pDao = new PersonaRegistradaDaoImpl();
		
		pDao.altaPersonaRegistrada(p);
	}
	
	
	
	public String retornarEmail(String dni){
		
		String email = null;

		PersonaRegistradaDao pRDao = new PersonaRegistradaDaoImpl();

		try {

			ResultSet res = pRDao.consultarEmail(dni);
			
			while (res.next()) {
				email = res.getString("email");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return email;		
	}
	
	public PersonaRegistrada retornarPersona(String usuario) {
		
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

	@Override
	public PersonaRegistrada retornarPersonaPorUsuario(String usuario) {
		
		PersonaRegistrada p = retornarPersona(usuario);
		
		return p;
	}

}