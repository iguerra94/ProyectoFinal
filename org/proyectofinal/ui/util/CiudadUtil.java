package org.proyectofinal.ui.util;

public class CiudadUtil {
	
	private String ciudad = null;
	private String shortPais = null;
	private Boolean enVuelos = null;
	
	public CiudadUtil(String ciudad, String shortPais, Boolean enVuelos){
		this.ciudad = ciudad;
		this.shortPais = shortPais;
		this.enVuelos = enVuelos;
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
	
	public Boolean getEnVuelos() {
		return enVuelos;
	}

	public void setEnVuelos(Boolean enVuelos) {
		this.enVuelos = enVuelos;
	}
	
	public String toString(){
		
		if (getCiudad().length() > 0) {
			return getCiudad();
		} else {
			return "";
		}
	}

}