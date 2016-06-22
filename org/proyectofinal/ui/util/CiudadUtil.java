package org.proyectofinal.ui.util;

public class CiudadUtil {
	
	private String ciudad = null;
	private String shortPais = null;
	
	public CiudadUtil(String ciudad, String shortPais){
		this.ciudad = ciudad;
		this.shortPais = shortPais;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getShortPais() {
		return this.shortPais;
	}

	public void setShortPais(String shortPais) {
		this.shortPais = shortPais;
	}
	
	public String toString(){
		
		if (getCiudad().length() > 0) {
			return getCiudad();
		} else {
			return "";
		}
	}
}
