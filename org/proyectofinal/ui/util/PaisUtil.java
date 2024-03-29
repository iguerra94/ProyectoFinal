package org.proyectofinal.ui.util;

public class PaisUtil {
	
	private String pais = null;
	private String shortPais = null;
	
	public PaisUtil(String pais, String shortPais){
		this.pais = pais;
		this.shortPais = shortPais;
	}
	
	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getShortPais() {
		return this.shortPais;
	}

	public void setShortPais(String shortPais) {
		this.shortPais = shortPais;
	}
	
	public String toString(){
		if (getPais().length() > 0){ 
			return getPais().concat(" (").concat(getShortPais()).concat(")");
		} else {
			return "";
		}
	}

}