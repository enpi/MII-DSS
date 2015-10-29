package practica1.dss.interceptor;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;


/**
 * Clase que maneja la cadena de filtros.
 * @author jmgn
 *
 */

public class CadenaFiltros {
	
	private ArrayList<Filtro> filtros;
	private Interfaz objetivo;
	
	
	/**
	 * Constructor de CadenaFiltros que inicializa la interfaz y el arraylist de filtros.
	 * @param objetivo
	 */
	public CadenaFiltros(Interfaz objetivo){
		this.objetivo = objetivo;
		filtros = new ArrayList<Filtro>();
	}
	
	/**
	 * Función para añadir un filtro al arraylist de filtros.
	 * @param filtro
	 */
	public void addFiltro( Filtro filtro){
		filtros.add(filtro);
	}
	
	/**
	 * Función que ejecuta los diferentes filtros en el orden en el que fueron introducidos al arraylist.
	 * @param peticion
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	
	public void ejecutar(double peticion) throws IOException, URISyntaxException{
		for(Filtro filtro: filtros){
			System.out.println("Nueva velocidad (m/s)" + filtro.ejecutar(peticion));
		}
		
		objetivo.ejecutar(peticion);
	}
	
	/**
	 * Función que modifica la interfaz actual.
	 * @param objetivo
	 */
	public void setObjetivo(Interfaz objetivo){
		this.objetivo = objetivo;
	}

}
