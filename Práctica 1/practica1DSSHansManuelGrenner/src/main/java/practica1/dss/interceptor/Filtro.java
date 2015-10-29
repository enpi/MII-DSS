package practica1.dss.interceptor;

/**
 * Interfaz Filtro
 * @author jmgn
 *
 */
public interface Filtro {
	
	/**
	 * Función que ejecuta el filtro.
	 * @param o
	 * @return
	 */
	public double ejecutar(Object o);

}
