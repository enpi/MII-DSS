package practica1.dss.interceptor;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Interfaz {
	
	/**
	 * Función que lanza la URL que dirige al componente.
	 * @param peticion
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public void ejecutar(double peticion) throws IOException, URISyntaxException{
		
		java.awt.Desktop.getDesktop().browse(new URI("http://localhost:8080/practica-1/"));
		
	}

}
