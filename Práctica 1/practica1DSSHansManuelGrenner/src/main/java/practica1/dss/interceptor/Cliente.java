package practica1.dss.interceptor;

import java.io.IOException;
import java.net.URISyntaxException;

public class Cliente {
	
	private GestorFiltros gestor;

	/**
	 * Función que modifica el gestor de filtros activo.
	 * @param gestor
	 */
	public void setGestorFiltros(GestorFiltros gestor){
		this.gestor = gestor;
	}
	
	/**
	 * Función que envia la petición al gestor.
	 * @param peticion
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public void enviarPeticion(double peticion) throws IOException, URISyntaxException{
		gestor.peticionFiltro(peticion);
	}
	
}
