package org.proyectofinal.model.interfaces;

import java.sql.Date;
import java.sql.Time;

/**
 * Interfaz de la clase de dominio ViajeCabecera.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public interface ViajeCabecera extends Cloneable {

	/**
	 * Retorna el codigo del viaje.
	 *
	 * @return El codigo del viaje.
	 */
	
	public String getCodigoViaje();
	
	/**
	 * Establece el codigo del viaje.
	 *
	 * @param codigoViaje El codigo del viaje.
	 */
	
	public void setCodigoViaje(String codigoViaje);

	/**
	 * Retorna la ciudad de origen del viaje.
	 *
	 * @return La ciudad de origen del viaje.
	 */

	public String getCiudadOrigen();
	
	/**
	 * Establece la ciudad de origen del viaje.
	 *
	 * @param ciudadOrigen La ciudad de origen del viaje.
	 */
	
	public void setCiudadOrigen(String ciudadOrigen);

	/**
	 * Retorna el pais de origen del viaje.
	 *
	 * @return El pais de origen del viaje.
	 */
	
	public String getPaisOrigen();
	
	/**
	 * Establece el pais de origen del viaje.
	 *
	 * @param paisOrigen El pais de origen del viaje.
	 */
	
	public void setPaisOrigen(String paisOrigen);

	/**
	 * Retorna el pais de origen del viaje en formato ISO 3166-1 alfa-3.
	 *
	 * @return El pais de origen del viaje en formato ISO 3166-1 alfa-3.
	 */
	
	public String getShortPaisOrigen();
	
	/**
	 * Establece el pais de origen del viaje en formato ISO 3166-1 alfa-3.
	 *
	 * @param paisOrigen El pais de origen del viaje en formato ISO 3166-1 alfa-3.
	 */
	
	public void setShortPaisOrigen(String shortPaisOrigen);

	/**
	 * Retorna la plataforma de origen del viaje.
	 *
	 * @return La plataforma de origen del viaje.
	 */
	
	public String getPlataformaOrigen();
	
	/**
	 * Establece la plataforma de origen del viaje.
	 *
	 * @param plataformaOrigen La plataforma de origen del viaje.
	 */
	
	public void setPlataformaOrigen(String plataformaOrigen);

	/**
	 * Retorna la ciudad de destino del viaje.
	 *
	 * @return La ciudad de destino del viaje.
	 */
	
	public String getCiudadDestino();
	
	/**
	 * Establece la ciudad de destino del viaje.
	 *
	 * @param ciudadDestino La ciudad de destino del viaje.
	 */
	
	public void setCiudadDestino(String ciudadDestino);

	/**
	 * Retorna el pais de destino del viaje.
	 *
	 * @return El pais de destino del viaje.
	 */
	
	public String getPaisDestino();
	
	/**
	 * Establece el pais de destino del viaje.
	 *
	 * @param paisDestino El pais de destino del viaje.
	 */
	
	public void setPaisDestino(String paisDestino);

	/**
	 * Retorna el pais de destino del viaje en formato ISO 3166-1 alfa-3.
	 *
	 * @return El pais de destino del viaje en formato ISO 3166-1 alfa-3.
	 */
	
	public String getShortPaisDestino();
	
	/**
	 * Establece el pais de destino del viaje en formato ISO 3166-1 alfa-3.
	 *
	 * @param shortPaisDestino El pais de destino del viaje en formato ISO 3166-1 alfa-3.
	 */
	
	public void setShortPaisDestino(String shortPaisDestino);
	
	/**
	 * Retorna la plataforma de destino del viaje.
	 *
	 * @return La plataforma de destino del viaje.
	 */
	
	public String getPlataformaDestino();
	
	/**
	 * Establece la plataforma de destino del viaje.
	 *
	 * @param plataformaDestino La plataforma de destino del viaje.
	 */
	
	public void setPlataformaDestino(String plataformaDestino);

	/**
	 * Retorna la fecha de salida del viaje.
	 *
	 * @return La fecha de salida del viaje.
	 */
	
	public Date getFechaSalida();
	
	/**
	 * Establece la fecha de salida del viaje.
	 *
	 * @param fechaSalida La fecha de salida del viaje.
	 */
	
	public void setFechaSalida(Date fechaSalida);
	
	/**
	 * Retorna la hora de salida del viaje.
	 *
	 * @return La hora de salida del viaje.
	 */
	
	public Time getHoraSalida();
	
	/**
	 * Establece la hora de salida del viaje.
	 *
	 * @param horaSalida La hora de salida del viaje.
	 */
	
	public void setHoraSalida(Time horaSalida);

	/**
	 * Retorna la fecha de llegada del viaje.
	 *
	 * @return La fecha de llegada del viaje.
	 */
	
	public Date getFechaLlegada();
	
	/**
	 * Establece la fecha de llegada del viaje.
	 *
	 * @param fechaLlegada La fecha de llegada del viaje.
	 */
	
	public void setFechaLlegada(Date fechaLlegada);

	/**
	 * Retorna la hora de llegada del viaje.
	 *
	 * @return La hora de llegada del viaje.
	 */
	
	public Time getHoraLlegada();
	
	/**
	 * Establece la hora de llegada del viaje.
	 *
	 * @param horaLlegada La hora de llegada del viaje.
	 */
	
	public void setHoraLlegada(Time horaLlegada);

	/**
	 * Retorna la distancia entre la ciudad de origen y destino del viaje.
	 *
	 * @return La distancia entre la ciudad de origen y destino del viaje.
	 */
	
	public Integer getDistancia();
	
	/**
	 * Establece la distancia entre la ciudad de origen y destino del viaje.
	 *
	 * @param distancia La distancia entre la ciudad de origen y destino del viaje.
	 */
	
	public void setDistancia(Integer distancia);
	
	/**
	 * Retorna la duracion del viaje.
	 *
	 * @return La duracion del viaje.
	 */
	
	public Time getDuracion();
	
	/**
	 * Establece la duracion del viaje.
	 *
	 * @param duracion La duracion del viaje.
	 */
	
	public void setDuracion(Time duracion);

	/**
	 * Retorna el precio de la clase turista del viaje.
	 *
	 * @return El precio de la clase turista del viaje.
	 */
	
	public Float getPrecioClaseTur();
	
	/**
	 * Establece el precio de la clase turista del viaje.
	 *
	 * @param precioClaseTur El precio de la clase turista del viaje.
	 */
	
	public void setPrecioClaseTur(Float precioClaseTur);

	/**
	 * Retorna el precio de la primera clase del viaje.
	 *
	 * @return El precio de la primera clase del viaje.
	 */
	
	public Float getPrecioClasePrim();
	
	/**
	 * Establece el precio de la primera clase del viaje.
	 *
	 * @param precioClasePrim El precio de la primera clase del viaje.
	 */
	
	public void setPrecioClasePrim(Float precioClasePrim);
	
	/**
	 * Retorna la oferta de descuento que dispone el viaje.
	 *
	 * @return La oferta de descuento que dispone el viaje.
	 */
	
	public String getOferta();
	
	/**
	 * Establece la oferta de descuento que dispone el viaje.
	 *
	 * @param oferta La oferta de descuento que dispone el viaje.
	 */
	
	public void setOferta(String oferta);
	
	/**
	 * Retorna la ruta de la imagen del destino de la oferta del viaje.
	 *
	 * @return La ruta de la imagen del destino de la oferta del viaje.
	 */
	
	public String getImagenOferta();
	
	/**
	 * Establece la ruta de la imagen del destino de la oferta del viaje.
	 *
	 * @param imagenOferta La ruta de la imagen del destino de la oferta del viaje.
	 */
	
	public void setImagenOferta(String imagenOferta);

	/**
	 * Retorna la ruta de la primera imagen descriptiva del destino del viaje.
	 *
	 * @return La ruta de la primera imagen descriptiva del destino del viaje.
	 */
	
	public String getImagen1();
	
	/**
	 * Establece la ruta de la primera imagen descriptiva del destino del viaje.
	 *
	 * @param imagen1 La ruta de la primera imagen descriptiva del destino del viaje.
	 */
	
	public void setImagen1(String imagen1);

	/**
	 * Retorna la ruta de la segunda imagen descriptiva del destino del viaje.
	 *
	 * @return La ruta de la segunda imagen descriptiva del destino del viaje.
	 */
	
	public String getImagen2();
	
	/**
	 * Establece la ruta de la segunda imagen descriptiva del destino del viaje.
	 *
	 * @param imagen2 La ruta de la segunda imagen descriptiva del destino del viaje.
	 */
	
	public void setImagen2(String imagen2);
	
	/**
	 * Retorna el cupo de pasajeros del viaje.
	 *
	 * @return El cupo de pasajeros del viaje.
	 */
	
	public Integer getCupo();
	
	/**
	 * Establece el cupo de pasajeros del viaje.
	 *
	 * @param cupo El cupo de pasajeros del viaje.
	 */
	
	public void setCupo(Integer cupo);

	/**
	 * Retorna una representacion del objeto ViajeCabecera en un objeto String.
	 * 
	 * @return Una representacion del objeto ViajeCabecera en un objeto String.
	 */
	
	@Override
	public String toString();

	/**
	 * Crea y retorna una copia del objeto ViajeCabecera.
	 *
	 * @return Una copia de esta instancia del objeto ViajeCabecera.
	 * @throws CloneNotSupportedException Si la clase del objeto no soporta la interfaz Cloneable.
	 */
	
	public ViajeCabecera clone() throws CloneNotSupportedException;
	
	/**
	 * Retorna un codigo hash para el objeto ViajeCabecera.
	 *
	 * @return Un entero representando el codigo hash del objeto ViajeCabecera.
	 */
	
	@Override
	public int hashCode();
	
	/**
	 * Retorna true si y solo si el objeto obj pasado como parametro no es nulo y ademas los valores de los atributos del objeto ViajeCabecera y los del objeto ViajeCabecera obj a comparar son iguales.
	 *
	 * @param obj El objeto ViajeCabecera a comparar.
	 * @return true, si la condicion se cumple.
	 */
	
	@Override
	public boolean equals(Object obj);

}