package practica1.dss.interceptor;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Clase encargada de crear la cadena de filtros y posee métodos
 * para insertar los filtros en la cadena y provocar que cada uno
 * ejecute la ptición del cliente y también del objetivo.
 * 
 * @author jmgn
 *
 */
public class GestorFiltros {
	
	private Interfaz objetivo;
	private Filtro filtro;
	private CadenaFiltros cadena;
	
	/**
	 * Constructor de GestorFiltros que se inicializa con la interfaz.
	 * @param objetivo
	 */
	public GestorFiltros( Interfaz objetivo ){
		this.objetivo = objetivo;
		cadena = new CadenaFiltros(objetivo);
		
	}
	
	/**
	 * Función que modifica el filtro actual.
	 * @param filtro
	 */
	public void setFiltro(Filtro filtro){
		this.filtro = filtro;
	}
	
	/**
	 * Función que devuelve la interfaz actual.
	 * @return
	 */
	public Interfaz getObjetivo() {
		return objetivo;
	}

	/**
	 * Función que ejecuta la petición del cliente.
	 * @param peticion
	 * @throws URISyntaxException 
	 * @throws IOException 
	 */
	public void peticionFiltro(double peticion) throws IOException, URISyntaxException{
		cadena.ejecutar(peticion);
	}

}
