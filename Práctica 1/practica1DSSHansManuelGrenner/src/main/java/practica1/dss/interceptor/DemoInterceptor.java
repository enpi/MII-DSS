package practica1.dss.interceptor;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Clase que contiene el main para lanzar la aplicación.
 * @author jmgn
 *
 */
public class DemoInterceptor {

	public static void main(String[] args) throws IOException, URISyntaxException {
		GestorFiltros gestorFiltros = new GestorFiltros( new Interfaz());
		gestorFiltros.getObjetivo().ejecutar(5.0);
		gestorFiltros.setFiltro(new CalcularVelocidad());
		
		Cliente cliente = new Cliente();
		cliente.setGestorFiltros(gestorFiltros);
		cliente.enviarPeticion(500);

	}

}
