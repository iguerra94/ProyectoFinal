package org.proyectofinal.model.interfaces;

import java.sql.Date;
import java.sql.Time;

/**
 * Interfaz de la clase de dominio <code>ViajeCabecera</code>.
 * 
 * @author Ivan Guerra
 * @version 1.0.0
 */

public interface ViajeCabecera extends Cloneable {

	/**
	 * Retorna el codigo del <code>ViajeCabecera</code>.
	 *
	 * @return El codigo del <code>ViajeCabecera</code>.
	 */
	
	public String getCodigoViaje();
	
	/**
	 * Establece el codigo del <code>ViajeCabecera</code>.
	 *
	 * @param codigoViaje El codigo del <code>ViajeCabecera</code>.
	 */
	
	public void setCodigoViaje(String codigoViaje);

	/**
	 * Retorna la ciudad de origen del <code>ViajeCabecera</code>.
	 *
	 * @return La ciudad de origen del <code>ViajeCabecera</code>.
	 */

	public String getCiudadOrigen();
	
	/**
	 * Establece la ciudad de origen del <code>ViajeCabecera</code>.
	 *
	 * @param ciudadOrigen La ciudad de origen del <code>ViajeCabecera</code>.
	 */
	
	public void setCiudadOrigen(String ciudadOrigen);

	/**
	 * Retorna el pais de origen del <code>ViajeCabecera</code>.
	 *
	 * @return El pais de origen del <code>ViajeCabecera</code>.
	 */
	
	public String getPaisOrigen();
	
	/**
	 * Establece el pais de origen del <code>ViajeCabecera</code>.
	 *
	 * @param paisOrigen El pais de origen del <code>ViajeCabecera</code>.
	 */
	
	public void setPaisOrigen(String paisOrigen);

	/**
	 * Retorna el pais de origen del <code>ViajeCabecera</code> en formato ISO 3166-1 alfa-3.
	 *
	 * @return El pais de origen del <code>ViajeCabecera</code> en formato ISO 3166-1 alfa-3.
	 */
	
	public String getShortPaisOrigen();
	
	/**
	 * Establece el pais de origen del <code>ViajeCabecera</code> en formato ISO 3166-1 alfa-3.
	 *
	 * @param shortPaisOrigen El pais de origen del <code>ViajeCabecera</code> en formato ISO 3166-1 alfa-3.
	 */
	
	public void setShortPaisOrigen(String shortPaisOrigen);

	/**
	 * Retorna la plataforma de origen del <code>ViajeCabecera</code>.
	 *
	 * @return La plataforma de origen del <code>ViajeCabecera</code>.
	 */
	
	public String getPlataformaOrigen();
	
	/**
	 * Establece la plataforma de origen del <code>ViajeCabecera</code>.
	 *
	 * @param plataformaOrigen La plataforma de origen del <code>ViajeCabecera</code>.
	 */
	
	public void setPlataformaOrigen(String plataformaOrigen);

	/**
	 * Retorna la ciudad de destino del <code>ViajeCabecera</code>.
	 *
	 * @return La ciudad de destino del <code>ViajeCabecera</code>.
	 */
	
	public String getCiudadDestino();
	
	/**
	 * Establece la ciudad de destino del <code>ViajeCabecera</code>.
	 *
	 * @param ciudadDestino La ciudad de destino del <code>ViajeCabecera</code>.
	 */
	
	public void setCiudadDestino(String ciudadDestino);

	/**
	 * Retorna el pais de destino del <code>ViajeCabecera</code>.
	 *
	 * @return El pais de destino del <code>ViajeCabecera</code>.
	 */
	
	public String getPaisDestino();
	
	/**
	 * Establece el pais de destino del <code>ViajeCabecera</code>.
	 *
	 * @param paisDestino El pais de destino del <code>ViajeCabecera</code>.
	 */
	
	public void setPaisDestino(String paisDestino);

	/**
	 * Retorna el pais de destino del <code>ViajeCabecera</code> en formato ISO 3166-1 alfa-3.
	 *
	 * @return El pais de destino del <code>ViajeCabecera</code> en formato ISO 3166-1 alfa-3.
	 */
	
	public String getShortPaisDestino();
	
	/**
	 * Establece el pais de destino del <code>ViajeCabecera</code> en formato ISO 3166-1 alfa-3.
	 *
	 * @param shortPaisDestino El pais de destino del <code>ViajeCabecera</code> en formato ISO 3166-1 alfa-3.
	 */
	
	public void setShortPaisDestino(String shortPaisDestino);
	
	/**
	 * Retorna la plataforma de destino del <code>ViajeCabecera</code>.
	 *
	 * @return La plataforma de destino del <code>ViajeCabecera</code>.
	 */
	
	public String getPlataformaDestino();
	
	/**
	 * Establece la plataforma de destino del <code>ViajeCabecera</code>.
	 *
	 * @param plataformaDestino La plataforma de destino del <code>ViajeCabecera</code>.
	 */
	
	public void setPlataformaDestino(String plataformaDestino);

	/**
	 * Retorna la fecha de salida del <code>ViajeCabecera</code>.
	 *
	 * @return La fecha de salida del <code>ViajeCabecera</code>.
	 */
	
	public Date getFechaSalida();
	
	/**
	 * Establece la fecha de salida del <code>ViajeCabecera</code>.
	 *
	 * @param fechaSalida La fecha de salida del <code>ViajeCabecera</code>.
	 */
	
	public void setFechaSalida(Date fechaSalida);
	
	/**
	 * Retorna la hora de salida del <code>ViajeCabecera</code>.
	 *
	 * @return La hora de salida del <code>ViajeCabecera</code>.
	 */
	
	public Time getHoraSalida();
	
	/**
	 * Establece la hora de salida del <code>ViajeCabecera</code>.
	 *
	 * @param horaSalida La hora de salida del <code>ViajeCabecera</code>.
	 */
	
	public void setHoraSalida(Time horaSalida);

	/**
	 * Retorna la fecha de llegada del <code>ViajeCabecera</code>.
	 *
	 * @return La fecha de llegada del <code>ViajeCabecera</code>.
	 */
	
	public Date getFechaLlegada();
	
	/**
	 * Establece la fecha de llegada del <code>ViajeCabecera</code>.
	 *
	 * @param fechaLlegada La fecha de llegada del <code>ViajeCabecera</code>.
	 */
	
	public void setFechaLlegada(Date fechaLlegada);

	/**
	 * Retorna la hora de llegada del <code>ViajeCabecera</code>.
	 *
	 * @return La hora de llegada del <code>ViajeCabecera</code>.
	 */
	
	public Time getHoraLlegada();
	
	/**
	 * Establece la hora de llegada del <code>ViajeCabecera</code>.
	 *
	 * @param horaLlegada La hora de llegada del <code>ViajeCabecera</code>.
	 */
	
	public void setHoraLlegada(Time horaLlegada);

	/**
	 * Retorna la distancia entre la ciudad de origen y destino del <code>ViajeCabecera</code>.
	 *
	 * @return La distancia entre la ciudad de origen y destino del <code>ViajeCabecera</code>.
	 */
	
	public Integer getDistancia();
	
	/**
	 * Establece la distancia entre la ciudad de origen y destino del <code>ViajeCabecera</code>.
	 *
	 * @param distancia La distancia entre la ciudad de origen y destino del <code>ViajeCabecera</code>.
	 */
	
	public void setDistancia(Integer distancia);
	
	/**
	 * Retorna la duracion del <code>ViajeCabecera</code>.
	 *
	 * @return La duracion del <code>ViajeCabecera</code>.
	 */
	
	public Time getDuracion();
	
	/**
	 * Establece la duracion del <code>ViajeCabecera</code>.
	 *
	 * @param duracion La duracion del <code>ViajeCabecera</code>.
	 */
	
	public void setDuracion(Time duracion);

	/**
	 * Retorna el precio de la clase turista del <code>ViajeCabecera</code>.
	 *
	 * @return El precio de la clase turista del <code>ViajeCabecera</code>.
	 */
	
	public Float getPrecioClaseTur();
	
	/**
	 * Establece el precio de la clase turista del <code>ViajeCabecera</code>.
	 *
	 * @param precioClaseTur El precio de la clase turista del <code>ViajeCabecera</code>.
	 */
	
	public void setPrecioClaseTur(Float precioClaseTur);

	/**
	 * Retorna el precio de la primera clase del <code>ViajeCabecera</code>.
	 *
	 * @return El precio de la primera clase del <code>ViajeCabecera</code>.
	 */
	
	public Float getPrecioClasePrim();
	
	/**
	 * Establece el precio de la primera clase del <code>ViajeCabecera</code>.
	 *
	 * @param precioClasePrim El precio de la primera clase del <code>ViajeCabecera</code>.
	 */
	
	public void setPrecioClasePrim(Float precioClasePrim);
	
	/**
	 * Retorna la oferta de descuento que dispone el <code>ViajeCabecera</code>.
	 *
	 * @return La oferta de descuento que dispone el <code>ViajeCabecera</code>.
	 */
	
	public String getOferta();
	
	/**
	 * Establece la oferta de descuento que dispone el <code>ViajeCabecera</code>.
	 *
	 * @param oferta La oferta de descuento que dispone el <code>ViajeCabecera</code>.
	 */
	
	public void setOferta(String oferta);
	
	/**
	 * Retorna la ruta de la imagen del destino de la oferta del <code>ViajeCabecera</code>.
	 *
	 * @return La ruta de la imagen del destino de la oferta del <code>ViajeCabecera</code>.
	 */
	
	public String getImagenOferta();
	
	/**
	 * Establece la ruta de la imagen del destino de la oferta del <code>ViajeCabecera</code>.
	 *
	 * @param imagenOferta La ruta de la imagen del destino de la oferta del <code>ViajeCabecera</code>.
	 */
	
	public void setImagenOferta(String imagenOferta);

	/**
	 * Retorna la ruta de la primera imagen descriptiva del destino del <code>ViajeCabecera</code>.
	 *
	 * @return La ruta de la primera imagen descriptiva del destino del <code>ViajeCabecera</code>.
	 */
	
	public String getImagen1();
	
	/**
	 * Establece la ruta de la primera imagen descriptiva del destino del <code>ViajeCabecera</code>.
	 *
	 * @param imagen1 La ruta de la primera imagen descriptiva del destino del <code>ViajeCabecera</code>.
	 */
	
	public void setImagen1(String imagen1);

	/**
	 * Retorna la ruta de la segunda imagen descriptiva del destino del <code>ViajeCabecera</code>.
	 *
	 * @return La ruta de la segunda imagen descriptiva del destino del <code>ViajeCabecera</code>.
	 */
	
	public String getImagen2();
	
	/**
	 * Establece la ruta de la segunda imagen descriptiva del destino del <code>ViajeCabecera</code>.
	 *
	 * @param imagen2 La ruta de la segunda imagen descriptiva del destino del <code>ViajeCabecera</code>.
	 */
	
	public void setImagen2(String imagen2);
	
	/**
	 * Retorna el cupo de pasajeros del <code>ViajeCabecera</code>.
	 *
	 * @return El cupo de pasajeros del <code>ViajeCabecera</code>.
	 */
	
	public Integer getCupo();
	
	/**
	 * Establece el cupo de pasajeros del <code>ViajeCabecera</code>.
	 *
	 * @param cupo El cupo de pasajeros del <code>ViajeCabecera</code>.
	 */
	
	public void setCupo(Integer cupo);

	/**
	 * Retorna una representacion del objeto <code>ViajeCabecera</code> en un objeto String.
	 * 
	 * @return Una representacion del objeto <code>ViajeCabecera</code> en un objeto String.
	 */
	
	@Override
	public String toString();

	/**
	 * Crea y retorna una copia del objeto <code>ViajeCabecera</code>.
	 *
	 * @return Una copia de esta instancia del objeto <code>ViajeCabecera</code>.
	 * @throws CloneNotSupportedException Si la clase del objeto no soporta la interfaz Cloneable.
	 */
	
	public ViajeCabecera clone() throws CloneNotSupportedException;
	
	/**
	 * Retorna un codigo hash para el objeto <code>ViajeCabecera</code>.
	 *
	 * @return Un entero representando el codigo hash del objeto <code>ViajeCabecera</code>.
	 */
	
	@Override
	public int hashCode();
	
	/**
	 * Retorna true si y solo si el objeto obj pasado como parametro no es nulo y ademas los valores de los atributos del objeto <code>ViajeCabecera</code> y los del objeto <code>ViajeCabecera</code> obj a comparar son iguales.
	 *
	 * @param obj El objeto <code>ViajeCabecera</code> a comparar.
	 * @return true, si la condicion se cumple.
	 */
	
	@Override
	public boolean equals(Object obj);

}