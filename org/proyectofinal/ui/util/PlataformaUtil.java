package org.proyectofinal.ui.util;

public class PlataformaUtil {
	
	private String plataforma = null;
	private String ciudad = null;
	
	public PlataformaUtil(String plataforma, String ciudad){
		this.plataforma = plataforma;
		this.ciudad = ciudad;
	}
	
	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String toString(){
		if (getPlataforma().length() > 0){ 
			return getPlataforma();
		} else {
			return "";
		}
	}

}
